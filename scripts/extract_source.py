import os
import shutil
from pathlib import Path
import javalang
from collections import defaultdict
import re

class JavaDeobfuscator:
    def __init__(self, base_dir):
        self.base_dir = Path(base_dir)
        self.all_java_files = list(self.base_dir.rglob("*.java"))
        self.rename_map_classes = {}   # old_class_name -> new_class_name
        self.rename_map_methods = {}   # old_method_name -> new_method_name
        self.rename_map_fields = {}    # old_field_name -> new_field_name
        self.usage_map = defaultdict(list)
        self.file_rename_map = {}      # old_path -> new_path (track actual file renames)

    ### --- STEP 1: CLASS LEVEL --- ###
    def extract_original_class_name(self, content):
        """Extract class name from compiled from comment"""
        match = re.search(r'/\*\s*compiled from:\s*([^\s*]+)\s*\*/', content)
        if match:
            return match.group(1).replace('.java', '')
        return None

    def parse_classes(self, content):
        """Return list of class/interface/enum names defined in this file"""
        try:
            tree = javalang.parse.parse(content)
            names = []
            for path, node in tree:
                if isinstance(node, (javalang.tree.ClassDeclaration,
                                     javalang.tree.InterfaceDeclaration,
                                     javalang.tree.EnumDeclaration)):
                    names.append(node.name)
            return names
        except:
            return []

    def build_class_rename_map_only(self):
        """Build class rename map based on compiled-from comment"""
        print("🔍 Building class rename map...")
        temp_class_map = defaultdict(list)

        for file_path in self.all_java_files:
            if not file_path.exists():
                continue
            content = file_path.read_text(encoding='utf-8')
            original_class = self.extract_original_class_name(content)
            classes_in_file = self.parse_classes(content)
            for cls in classes_in_file:
                if original_class and original_class != cls:
                    temp_class_map[original_class].append(cls)

        # Resolve duplicates
        for original, duplicates in temp_class_map.items():
            for idx, old in enumerate(duplicates):
                if idx == 0:
                    self.rename_map_classes[old] = original
                else:
                    self.rename_map_classes[old] = f"{original}_{idx+1}"

        print(f"✅ Class rename map: {self.rename_map_classes}")

    def rename_files(self):
        """Rename Java files based on class rename map"""
        print("📂 Renaming Java files based on compiled-from comment...")
        
        # Build a plan first (to avoid conflicts)
        rename_plan = []
        for file_path in self.all_java_files:
            if not file_path.exists():
                continue
                
            content = file_path.read_text(encoding='utf-8')
            classes_in_file = self.parse_classes(content)
            
            for cls in classes_in_file:
                if cls in self.rename_map_classes:
                    new_name = self.rename_map_classes[cls]
                    new_file_path = file_path.parent / f"{new_name}.java"
                    
                    # Handle naming conflicts
                    counter = 1
                    while new_file_path.exists() and new_file_path != file_path:
                        new_file_path = file_path.parent / f"{new_name}_{counter}.java"
                        counter += 1
                    
                    if new_file_path != file_path:
                        rename_plan.append((file_path, new_file_path))
                    break  # Only rename once per file
        
        # Execute the rename plan
        for old_path, new_path in rename_plan:
            if not old_path.exists():
                print(f"⚠️ Skipping {old_path.name} - file no longer exists")
                continue
                
            try:
                shutil.move(str(old_path), str(new_path))
                self.file_rename_map[old_path] = new_path
                print(f"📝 {old_path.name} -> {new_path.name}")
            except Exception as e:
                print(f"❌ Failed to rename {old_path.name}: {e}")

        # Update all_java_files list with new paths
        self.all_java_files = list(self.base_dir.rglob("*.java"))

    ### --- STEP 2: METHODS & FIELDS --- ###
    def parse_methods_and_fields(self, content):
        """Return methods and fields defined in this file"""
        try:
            tree = javalang.parse.parse(content)
            methods = []
            fields = []
            for path, node in tree:
                if isinstance(node, javalang.tree.MethodDeclaration):
                    methods.append(node.name)
                if isinstance(node, javalang.tree.FieldDeclaration):
                    for decl in node.declarators:
                        fields.append(decl.name)
            return methods, fields
        except:
            return [], []

    def build_method_field_maps(self):
        """Build maps for obfuscated methods and fields"""
        print("🔍 Building method and field rename maps...")
        for file_path in self.all_java_files:
            if not file_path.exists():
                continue
            content = file_path.read_text(encoding='utf-8')
            methods, fields = self.parse_methods_and_fields(content)

            for m in methods:
                if len(m) <= 2:  # likely obfuscated
                    new_name = f"{m}_renamed"
                    self.rename_map_methods[m] = new_name
            for f in fields:
                if len(f) <= 2:
                    new_name = f"{f}_renamed"
                    self.rename_map_fields[f] = new_name

        print(f"✅ Method rename map: {self.rename_map_methods}")
        print(f"✅ Field rename map: {self.rename_map_fields}")

    ### --- STEP 3: USAGES & REPLACEMENTS --- ###
    def find_usages(self):
        """Find all files where class/method/field is used"""
        print("🔍 Mapping references in all files...")
        for file_path in self.all_java_files:
            if not file_path.exists():
                continue
            content = file_path.read_text(encoding='utf-8')
            for old_name in list(self.rename_map_classes.keys()) + \
                            list(self.rename_map_methods.keys()) + \
                            list(self.rename_map_fields.keys()):
                if old_name in content:
                    self.usage_map[old_name].append(file_path)
        print("✅ Usage map created.")

    def replace_references(self):
        """Replace all references based on rename maps"""
        print("🔄 Replacing references across files...")
        combined_map = {**self.rename_map_classes,
                        **self.rename_map_methods,
                        **self.rename_map_fields}
        for old_name, new_name in combined_map.items():
            for file_path in self.usage_map.get(old_name, []):
                if not file_path.exists():
                    continue
                content = file_path.read_text(encoding='utf-8')
                content_new = re.sub(rf'\b{re.escape(old_name)}\b', new_name, content)
                if content != content_new:
                    file_path.write_text(content_new, encoding='utf-8')
                    print(f"✏️ Updated references in {file_path.relative_to(self.base_dir)}")

    ### --- FULL PROCESS --- ###
    def process(self):
        print("🚀 Starting full deobfuscation sequence...")
        self.build_class_rename_map_only()
        self.rename_files()
        self.build_method_field_maps()
        self.find_usages()
        self.replace_references()
        print("✅ Deobfuscation complete!")

if __name__ == "__main__":
    import sys
    target_dir = sys.argv[1] if len(sys.argv) > 1 else "decompiled/sources"
    deobfuscator = JavaDeobfuscator(target_dir)
    deobfuscator.process()