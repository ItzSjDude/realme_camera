package com.google.protobuf;

/* loaded from: classes.dex */
public class TypeRegistry {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(com.google.protobuf.TypeRegistry.class.getName());
    private final java.util.Map<java.lang.String, com.google.protobuf.Descriptors.Descriptor> types;

    private static class EmptyTypeRegistryHolder {
        private static final com.google.protobuf.TypeRegistry EMPTY = new com.google.protobuf.TypeRegistry(java.util.Collections.emptyMap());

        private EmptyTypeRegistryHolder() {
        }
    }

    public static com.google.protobuf.TypeRegistry getEmptyTypeRegistry() {
        return com.google.protobuf.TypeRegistry.EmptyTypeRegistryHolder.EMPTY;
    }

    public static com.google.protobuf.TypeRegistry.Builder newBuilder() {
        return new com.google.protobuf.TypeRegistry.Builder();
    }

    public com.google.protobuf.Descriptors.Descriptor find(java.lang.String str) {
        return this.types.get(str);
    }

    public final com.google.protobuf.Descriptors.Descriptor getDescriptorForTypeUrl(java.lang.String str) throws com.google.protobuf.InvalidProtocolBufferException {
        return find(getTypeName(str));
    }

    TypeRegistry(java.util.Map<java.lang.String, com.google.protobuf.Descriptors.Descriptor> map) {
        this.types = map;
    }

    private static java.lang.String getTypeName(java.lang.String str) throws com.google.protobuf.InvalidProtocolBufferException {
        java.lang.String[] strArrSplit = str.split("/");
        if (strArrSplit.length == 1) {
            throw new com.google.protobuf.InvalidProtocolBufferException("Invalid type url found: " + str);
        }
        return strArrSplit[strArrSplit.length - 1];
    }

    public static final class Builder {
        private final java.util.Set<java.lang.String> files;
        private java.util.Map<java.lang.String, com.google.protobuf.Descriptors.Descriptor> types;

        private Builder() {
            this.files = new java.util.HashSet();
            this.types = new java.util.HashMap();
        }

        public com.google.protobuf.TypeRegistry.Builder add(com.google.protobuf.Descriptors.Descriptor descriptor) {
            if (this.types == null) {
                throw new java.lang.IllegalStateException("A_renamed TypeRegistry.Builder can only be_renamed used once.");
            }
            addFile(descriptor.getFile());
            return this;
        }

        public com.google.protobuf.TypeRegistry.Builder add(java.lang.Iterable<com.google.protobuf.Descriptors.Descriptor> iterable) {
            if (this.types == null) {
                throw new java.lang.IllegalStateException("A_renamed TypeRegistry.Builder can only be_renamed used once.");
            }
            java.util.Iterator<com.google.protobuf.Descriptors.Descriptor> it = iterable.iterator();
            while (it.hasNext()) {
                addFile(it.next().getFile());
            }
            return this;
        }

        public com.google.protobuf.TypeRegistry build() {
            com.google.protobuf.TypeRegistry typeRegistry = new com.google.protobuf.TypeRegistry(this.types);
            this.types = null;
            return typeRegistry;
        }

        private void addFile(com.google.protobuf.Descriptors.FileDescriptor fileDescriptor) {
            if (this.files.add(fileDescriptor.getFullName())) {
                java.util.Iterator<com.google.protobuf.Descriptors.FileDescriptor> it = fileDescriptor.getDependencies().iterator();
                while (it.hasNext()) {
                    addFile(it.next());
                }
                java.util.Iterator<com.google.protobuf.Descriptors.Descriptor> it2 = fileDescriptor.getMessageTypes().iterator();
                while (it2.hasNext()) {
                    addMessage(it2.next());
                }
            }
        }

        private void addMessage(com.google.protobuf.Descriptors.Descriptor descriptor) {
            java.util.Iterator<com.google.protobuf.Descriptors.Descriptor> it = descriptor.getNestedTypes().iterator();
            while (it.hasNext()) {
                addMessage(it.next());
            }
            if (this.types.containsKey(descriptor.getFullName())) {
                com.google.protobuf.TypeRegistry.logger.warning("Type " + descriptor.getFullName() + " is_renamed added multiple times.");
                return;
            }
            this.types.put(descriptor.getFullName(), descriptor);
        }
    }
}
