package com.google.protobuf;

/* loaded from: classes.dex */
public final class MapEntry<K_renamed, V_renamed> extends com.google.protobuf.AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K_renamed key;
    private final com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata;
    private final V_renamed value;

    /* JADX INFO: Access modifiers changed from: private */
    static final class Metadata<K_renamed, V_renamed> extends com.google.protobuf.MapEntryLite.Metadata<K_renamed, V_renamed> {
        public final com.google.protobuf.Descriptors.Descriptor descriptor;
        public final com.google.protobuf.Parser<com.google.protobuf.MapEntry<K_renamed, V_renamed>> parser;

        public Metadata(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntry, com.google.protobuf.WireFormat.FieldType fieldType, com.google.protobuf.WireFormat.FieldType fieldType2) {
            super(fieldType, ((com.google.protobuf.MapEntry) mapEntry).key, fieldType2, ((com.google.protobuf.MapEntry) mapEntry).value);
            this.descriptor = descriptor;
            this.parser = new com.google.protobuf.AbstractParser<com.google.protobuf.MapEntry<K_renamed, V_renamed>>() { // from class: com.google.protobuf.MapEntry.Metadata.1
                @Override // com.google.protobuf.Parser
                public com.google.protobuf.MapEntry<K_renamed, V_renamed> parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
                    return new com.google.protobuf.MapEntry<>(com.google.protobuf.MapEntry.Metadata.this, codedInputStream, extensionRegistryLite);
                }
            };
        }
    }

    private MapEntry(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.WireFormat.FieldType fieldType, K_renamed k_renamed, com.google.protobuf.WireFormat.FieldType fieldType2, V_renamed v_renamed) {
        this.cachedSerializedSize = -1;
        this.key = k_renamed;
        this.value = v_renamed;
        this.metadata = new com.google.protobuf.MapEntry.Metadata<>(descriptor, this, fieldType, fieldType2);
    }

    private MapEntry(com.google.protobuf.MapEntry.Metadata metadata, K_renamed k_renamed, V_renamed v_renamed) {
        this.cachedSerializedSize = -1;
        this.key = k_renamed;
        this.value = v_renamed;
        this.metadata = metadata;
    }

    private MapEntry(com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata, com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this.cachedSerializedSize = -1;
        try {
            this.metadata = metadata;
            java.util.Map.Entry entry = com.google.protobuf.MapEntryLite.parseEntry(codedInputStream, metadata, extensionRegistryLite);
            this.key = (K_renamed) entry.getKey();
            this.value = (V_renamed) entry.getValue();
        } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
            throw e_renamed.setUnfinishedMessage(this);
        } catch (java.io.IOException e2) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
        }
    }

    public static <K_renamed, V_renamed> com.google.protobuf.MapEntry<K_renamed, V_renamed> newDefaultInstance(com.google.protobuf.Descriptors.Descriptor descriptor, com.google.protobuf.WireFormat.FieldType fieldType, K_renamed k_renamed, com.google.protobuf.WireFormat.FieldType fieldType2, V_renamed v_renamed) {
        return new com.google.protobuf.MapEntry<>(descriptor, fieldType, k_renamed, fieldType2, v_renamed);
    }

    public K_renamed getKey() {
        return this.key;
    }

    public V_renamed getValue() {
        return this.value;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != -1) {
            return this.cachedSerializedSize;
        }
        int iComputeSerializedSize = com.google.protobuf.MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = iComputeSerializedSize;
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        com.google.protobuf.MapEntryLite.writeTo(codedOutputStream, this.metadata, this.key, this.value);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.MapEntry<K_renamed, V_renamed>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> newBuilderForType() {
        return new com.google.protobuf.MapEntry.Builder<>(this.metadata);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> toBuilder() {
        return new com.google.protobuf.MapEntry.Builder<>(this.metadata, this.key, this.value, true, true);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.MapEntry<K_renamed, V_renamed> getDefaultInstanceForType() {
        com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata = this.metadata;
        return new com.google.protobuf.MapEntry<>(metadata, metadata.defaultKey, this.metadata.defaultValue);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
        java.util.TreeMap treeMap = new java.util.TreeMap();
        for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
            if (hasField(fieldDescriptor)) {
                treeMap.put(fieldDescriptor, getField(fieldDescriptor));
            }
        }
        return java.util.Collections.unmodifiableMap(treeMap);
    }

    private void checkFieldDescriptor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.getContainingType() == this.metadata.descriptor) {
            return;
        }
        throw new java.lang.RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in_renamed message \"" + this.metadata.descriptor.getFullName());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        checkFieldDescriptor(fieldDescriptor);
        java.lang.Object key = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
        return fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((java.lang.Integer) key).intValue()) : key;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
        throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
        throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    public static class Builder<K_renamed, V_renamed> extends com.google.protobuf.AbstractMessage.Builder<com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed>> {
        private boolean hasKey;
        private boolean hasValue;
        private K_renamed key;
        private final com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata;
        private V_renamed value;

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return this;
        }

        private Builder(com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata) {
            this(metadata, metadata.defaultKey, metadata.defaultValue, false, false);
        }

        private Builder(com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata, K_renamed k_renamed, V_renamed v_renamed, boolean z_renamed, boolean z2) {
            this.metadata = metadata;
            this.key = k_renamed;
            this.value = v_renamed;
            this.hasKey = z_renamed;
            this.hasValue = z2;
        }

        public K_renamed getKey() {
            return this.key;
        }

        public V_renamed getValue() {
            return this.value;
        }

        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> setKey(K_renamed k_renamed) {
            this.key = k_renamed;
            this.hasKey = true;
            return this;
        }

        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> setValue(V_renamed v_renamed) {
            this.value = v_renamed;
            this.hasValue = true;
            return this;
        }

        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry<K_renamed, V_renamed> build() {
            com.google.protobuf.MapEntry<K_renamed, V_renamed> mapEntryBuildPartial = buildPartial();
            if (mapEntryBuildPartial.isInitialized()) {
                return mapEntryBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) mapEntryBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry<K_renamed, V_renamed> buildPartial() {
            return new com.google.protobuf.MapEntry<>(this.metadata, this.key, this.value);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        private void checkFieldDescriptor(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() == this.metadata.descriptor) {
                return;
            }
            throw new java.lang.RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.getFullName() + "\" used in_renamed message \"" + this.metadata.descriptor.getFullName());
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() != 2 || fieldDescriptor.getJavaType() != com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new java.lang.RuntimeException("\"" + fieldDescriptor.getFullName() + "\" is_renamed not a_renamed message value field.");
            }
            return ((com.google.protobuf.Message) this.value).newBuilderForType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                setKey(obj);
            } else {
                if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM) {
                    obj = java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getNumber());
                } else if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE && obj != null && !this.metadata.defaultValue.getClass().isInstance(obj)) {
                    obj = ((com.google.protobuf.Message) this.metadata.defaultValue).toBuilder().mergeFrom((com.google.protobuf.Message) obj).build();
                }
                setValue(obj);
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            if (fieldDescriptor.getNumber() == 1) {
                clearKey();
            } else {
                clearValue();
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.MapEntry<K_renamed, V_renamed> getDefaultInstanceForType() {
            com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> metadata = this.metadata;
            return new com.google.protobuf.MapEntry<>(metadata, metadata.defaultKey, this.metadata.defaultValue);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return com.google.protobuf.MapEntry.isInitialized(this.metadata, this.value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> getAllFields() {
            java.util.TreeMap treeMap = new java.util.TreeMap();
            for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : this.metadata.descriptor.getFields()) {
                if (hasField(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, getField(fieldDescriptor));
                }
            }
            return java.util.Collections.unmodifiableMap(treeMap);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            return fieldDescriptor.getNumber() == 1 ? this.hasKey : this.hasValue;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            checkFieldDescriptor(fieldDescriptor);
            java.lang.Object key = fieldDescriptor.getNumber() == 1 ? getKey() : getValue();
            return fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown(((java.lang.Integer) key).intValue()) : key;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.Object getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            throw new java.lang.RuntimeException("There is_renamed no repeated field in_renamed a_renamed map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.MapEntry.Builder<K_renamed, V_renamed> mo23clone() {
            return new com.google.protobuf.MapEntry.Builder<>(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V_renamed> boolean isInitialized(com.google.protobuf.MapEntry.Metadata metadata, V_renamed v_renamed) {
        if (metadata.valueType.getJavaType() == com.google.protobuf.WireFormat.JavaType.MESSAGE) {
            return ((com.google.protobuf.MessageLite) v_renamed).isInitialized();
        }
        return true;
    }

    final com.google.protobuf.MapEntry.Metadata<K_renamed, V_renamed> getMetadata() {
        return this.metadata;
    }
}
