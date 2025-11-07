package com.google.protobuf;

/* loaded from: classes.dex */
public class TextFormatParseInfoTree {
    private java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseLocation>> locationsFromField;
    java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseInfoTree>> subtreesFromField;

    private TextFormatParseInfoTree(java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseLocation>> map, java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseInfoTree.Builder>> map2) {
        java.util.HashMap map3 = new java.util.HashMap();
        for (java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseLocation>> entry : map.entrySet()) {
            map3.put(entry.getKey(), java.util.Collections.unmodifiableList(entry.getValue()));
        }
        this.locationsFromField = java.util.Collections.unmodifiableMap(map3);
        java.util.HashMap map4 = new java.util.HashMap();
        for (java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseInfoTree.Builder>> entry2 : map2.entrySet()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<com.google.protobuf.TextFormatParseInfoTree.Builder> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().build());
            }
            map4.put(entry2.getKey(), java.util.Collections.unmodifiableList(arrayList));
        }
        this.subtreesFromField = java.util.Collections.unmodifiableMap(map4);
    }

    public java.util.List<com.google.protobuf.TextFormatParseLocation> getLocations(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        java.util.List<com.google.protobuf.TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public com.google.protobuf.TextFormatParseLocation getLocation(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
        return (com.google.protobuf.TextFormatParseLocation) getFromList(getLocations(fieldDescriptor), i_renamed, fieldDescriptor);
    }

    public java.util.List<com.google.protobuf.TextFormatParseInfoTree> getNestedTrees(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        java.util.List<com.google.protobuf.TextFormatParseInfoTree> list = this.subtreesFromField.get(fieldDescriptor);
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public com.google.protobuf.TextFormatParseInfoTree getNestedTree(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
        return (com.google.protobuf.TextFormatParseInfoTree) getFromList(getNestedTrees(fieldDescriptor), i_renamed, fieldDescriptor);
    }

    public static com.google.protobuf.TextFormatParseInfoTree.Builder builder() {
        return new com.google.protobuf.TextFormatParseInfoTree.Builder();
    }

    private static <T_renamed> T_renamed getFromList(java.util.List<T_renamed> list, int i_renamed, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        if (i_renamed >= list.size() || i_renamed < 0) {
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = fieldDescriptor == null ? "<null>" : fieldDescriptor.getName();
            objArr[1] = java.lang.Integer.valueOf(i_renamed);
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Illegal index field: %s_renamed, index %d_renamed", objArr));
        }
        return list.get(i_renamed);
    }

    public static class Builder {
        private java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseLocation>> locationsFromField;
        private java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.util.List<com.google.protobuf.TextFormatParseInfoTree.Builder>> subtreeBuildersFromField;

        private Builder() {
            this.locationsFromField = new java.util.HashMap();
            this.subtreeBuildersFromField = new java.util.HashMap();
        }

        public com.google.protobuf.TextFormatParseInfoTree.Builder setLocation(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.TextFormatParseLocation textFormatParseLocation) {
            java.util.List<com.google.protobuf.TextFormatParseLocation> arrayList = this.locationsFromField.get(fieldDescriptor);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                this.locationsFromField.put(fieldDescriptor, arrayList);
            }
            arrayList.add(textFormatParseLocation);
            return this;
        }

        public com.google.protobuf.TextFormatParseInfoTree.Builder getBuilderForSubMessageField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            java.util.List<com.google.protobuf.TextFormatParseInfoTree.Builder> arrayList = this.subtreeBuildersFromField.get(fieldDescriptor);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                this.subtreeBuildersFromField.put(fieldDescriptor, arrayList);
            }
            com.google.protobuf.TextFormatParseInfoTree.Builder builder = new com.google.protobuf.TextFormatParseInfoTree.Builder();
            arrayList.add(builder);
            return builder;
        }

        public com.google.protobuf.TextFormatParseInfoTree build() {
            return new com.google.protobuf.TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
        }
    }
}
