package org.junit.rules;

/* loaded from: classes2.dex */
public class TemporaryFolder extends org.junit.rules.ExternalResource {
    private java.io.File folder;
    private final java.io.File parentFolder;

    public TemporaryFolder() {
        this(null);
    }

    public TemporaryFolder(java.io.File file) {
        this.parentFolder = file;
    }

    @Override // org.junit.rules.ExternalResource
    protected void before() throws java.lang.Throwable {
        create();
    }

    @Override // org.junit.rules.ExternalResource
    protected void after() {
        delete();
    }

    public void create() throws java.io.IOException {
        this.folder = createTemporaryFolderIn(this.parentFolder);
    }

    public java.io.File newFile(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(getRoot(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new java.io.IOException("a_renamed file with the name '" + str + "' already exists in_renamed the test folder");
    }

    public java.io.File newFile() throws java.io.IOException {
        return java.io.File.createTempFile("junit", null, getRoot());
    }

    public java.io.File newFolder(java.lang.String str) throws java.io.IOException {
        return newFolder(str);
    }

    public java.io.File newFolder(java.lang.String... strArr) throws java.io.IOException {
        java.io.File root = getRoot();
        int i_renamed = 0;
        while (i_renamed < strArr.length) {
            java.lang.String str = strArr[i_renamed];
            validateFolderName(str);
            java.io.File file = new java.io.File(root, str);
            if (!file.mkdir() && isLastElementInArray(i_renamed, strArr)) {
                throw new java.io.IOException("a_renamed folder with the name '" + str + "' already exists");
            }
            i_renamed++;
            root = file;
        }
        return root;
    }

    private void validateFolderName(java.lang.String str) throws java.io.IOException {
        if (new java.io.File(str).getParent() != null) {
            throw new java.io.IOException("Folder name cannot consist of_renamed multiple path components separated by_renamed a_renamed file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of_renamed folders");
        }
    }

    private boolean isLastElementInArray(int i_renamed, java.lang.String[] strArr) {
        return i_renamed == strArr.length - 1;
    }

    public java.io.File newFolder() throws java.io.IOException {
        return createTemporaryFolderIn(getRoot());
    }

    private java.io.File createTemporaryFolderIn(java.io.File file) throws java.io.IOException {
        java.io.File fileCreateTempFile = java.io.File.createTempFile("junit", "", file);
        fileCreateTempFile.delete();
        fileCreateTempFile.mkdir();
        return fileCreateTempFile;
    }

    public java.io.File getRoot() {
        java.io.File file = this.folder;
        if (file != null) {
            return file;
        }
        throw new java.lang.IllegalStateException("the temporary folder has not yet been created");
    }

    public void delete() {
        java.io.File file = this.folder;
        if (file != null) {
            recursiveDelete(file);
        }
    }

    private void recursiveDelete(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }
}
