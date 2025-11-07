package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class AbstractMessage extends com.google.protobuf.AbstractMessageLite implements com.google.protobuf.Message {
    protected int memoizedSize = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public interface BuilderParent {
        void markDirty();
    }

    @java.lang.Deprecated
    protected static int hashBoolean(boolean z_renamed) {
        return z_renamed ? 1231 : 1237;
    }

    @java.lang.Deprecated
    protected static int hashLong(long j_renamed) {
        return (int) (j_renamed ^ (j_renamed >>> 32));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return com.google.protobuf.MessageReflection.isInitialized(this);
    }

    protected com.google.protobuf.Message.Builder newBuilderForType(com.google.protobuf.AbstractMessage.BuilderParent builderParent) {
        throw new java.lang.UnsupportedOperationException("Nested builder is_renamed not supported for this type.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.util.List<java.lang.String> findInitializationErrors() {
        return com.google.protobuf.MessageReflection.findMissingFields(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public java.lang.String getInitializationErrorString() {
        return com.google.protobuf.MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        throw new java.lang.UnsupportedOperationException("hasOneof() is_renamed not implemented.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
        throw new java.lang.UnsupportedOperationException("getOneofFieldDescriptor() is_renamed not implemented.");
    }

    @Override // com.google.protobuf.Message
    public final java.lang.String toString() {
        return com.google.protobuf.TextFormat.printer().printToString(this);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        com.google.protobuf.MessageReflection.writeMessageTo(this, getAllFields(), codedOutputStream, false);
    }

    @Override // com.google.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int i_renamed) {
        this.memoizedSize = i_renamed;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        this.memoizedSize = com.google.protobuf.MessageReflection.getSerializedSize(this, getAllFields());
        return this.memoizedSize;
    }

    @Override // com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.Message)) {
            return false;
        }
        com.google.protobuf.Message message = (com.google.protobuf.Message) obj;
        if (getDescriptorForType() != message.getDescriptorForType()) {
            return false;
        }
        return compareFields(getAllFields(), message.getAllFields()) && getUnknownFields().equals(message.getUnknownFields());
    }

    @Override // com.google.protobuf.Message
    public int hashCode() {
        int i_renamed = this.memoizedHashCode;
        if (i_renamed != 0) {
            return i_renamed;
        }
        int iHashFields = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashFields;
        return iHashFields;
    }

    private static com.google.protobuf.ByteString toByteString(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return com.google.protobuf.ByteString.copyFrom((byte[]) obj);
        }
        return (com.google.protobuf.ByteString) obj;
    }

    private static boolean compareBytes(java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return java.util.Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return toByteString(obj).equals(toByteString(obj2));
    }

    private static java.util.Map convertMapEntryListToMap(java.util.List list) {
        if (list.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        java.util.HashMap map = new java.util.HashMap();
        java.util.Iterator it = list.iterator();
        com.google.protobuf.Message message = (com.google.protobuf.Message) it.next();
        com.google.protobuf.Descriptors.Descriptor descriptorForType = message.getDescriptorForType();
        com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("key");
        com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE);
        java.lang.Object field = message.getField(fieldDescriptorFindFieldByName2);
        if (field instanceof com.google.protobuf.Descriptors.EnumValueDescriptor) {
            field = java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) field).getNumber());
        }
        map.put(message.getField(fieldDescriptorFindFieldByName), field);
        while (it.hasNext()) {
            com.google.protobuf.Message message2 = (com.google.protobuf.Message) it.next();
            java.lang.Object field2 = message2.getField(fieldDescriptorFindFieldByName2);
            if (field2 instanceof com.google.protobuf.Descriptors.EnumValueDescriptor) {
                field2 = java.lang.Integer.valueOf(((com.google.protobuf.Descriptors.EnumValueDescriptor) field2).getNumber());
            }
            map.put(message2.getField(fieldDescriptorFindFieldByName), field2);
        }
        return map;
    }

    private static boolean compareMapField(java.lang.Object obj, java.lang.Object obj2) {
        return com.google.protobuf.MapFieldLite.equals(convertMapEntryListToMap((java.util.List) obj), convertMapEntryListToMap((java.util.List) obj2));
    }

    static boolean compareFields(java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> map, java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor : map.keySet()) {
            if (!map2.containsKey(fieldDescriptor)) {
                return false;
            }
            java.lang.Object obj = map.get(fieldDescriptor);
            java.lang.Object obj2 = map2.get(fieldDescriptor);
            if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES) {
                if (fieldDescriptor.isRepeated()) {
                    java.util.List list = (java.util.List) obj;
                    java.util.List list2 = (java.util.List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                        if (!compareBytes(list.get(i_renamed), list2.get(i_renamed))) {
                            return false;
                        }
                    }
                } else if (!compareBytes(obj, obj2)) {
                    return false;
                }
            } else if (fieldDescriptor.isMapField()) {
                if (!compareMapField(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static int hashMapField(java.lang.Object obj) {
        return com.google.protobuf.MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((java.util.List) obj));
    }

    protected static int hashFields(int i_renamed, java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> map) {
        int i2;
        int iHashEnum;
        for (java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> entry : map.entrySet()) {
            com.google.protobuf.Descriptors.FieldDescriptor key = entry.getKey();
            java.lang.Object value = entry.getValue();
            int number = (i_renamed * 37) + key.getNumber();
            if (key.isMapField()) {
                i2 = number * 53;
                iHashEnum = hashMapField(value);
            } else if (key.getType() != com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM) {
                i2 = number * 53;
                iHashEnum = value.hashCode();
            } else if (key.isRepeated()) {
                i2 = number * 53;
                iHashEnum = com.google.protobuf.Internal.hashEnumList((java.util.List) value);
            } else {
                i2 = number * 53;
                iHashEnum = com.google.protobuf.Internal.hashEnum((com.google.protobuf.Internal.EnumLite) value);
            }
            i_renamed = i2 + iHashEnum;
        }
        return i_renamed;
    }

    @Override // com.google.protobuf.AbstractMessageLite
    com.google.protobuf.UninitializedMessageException newUninitializedMessageException() {
        return com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException((com.google.protobuf.Message) this);
    }

    public static abstract class Builder<BuilderType extends com.google.protobuf.AbstractMessage.Builder<BuilderType>> extends com.google.protobuf.AbstractMessageLite.Builder implements com.google.protobuf.Message.Builder {
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo23clone() {
            throw new java.lang.UnsupportedOperationException("clone() should be_renamed implemented in_renamed subclasses.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            throw new java.lang.UnsupportedOperationException("hasOneof() is_renamed not implemented.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.FieldDescriptor getOneofFieldDescriptor(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            throw new java.lang.UnsupportedOperationException("getOneofFieldDescriptor() is_renamed not implemented.");
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            throw new java.lang.UnsupportedOperationException("clearOneof() is_renamed not implemented.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            java.util.Iterator<java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object>> it = getAllFields().entrySet().iterator();
            while (it.hasNext()) {
                clearField(it.next().getKey());
            }
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.util.List<java.lang.String> findInitializationErrors() {
            return com.google.protobuf.MessageReflection.findMissingFields(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public java.lang.String getInitializationErrorString() {
            return com.google.protobuf.MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(com.google.protobuf.AbstractMessageLite abstractMessageLite) {
            return (BuilderType) mergeFrom((com.google.protobuf.Message) abstractMessageLite);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.Message message) {
            return (BuilderType) mergeFrom(message, message.getAllFields());
        }

        BuilderType mergeFrom(com.google.protobuf.Message message, java.util.Map<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> map) {
            if (message.getDescriptorForType() != getDescriptorForType()) {
                throw new java.lang.IllegalArgumentException("mergeFrom(Message) can only merge messages of_renamed the same type.");
            }
            for (java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> entry : map.entrySet()) {
                com.google.protobuf.Descriptors.FieldDescriptor key = entry.getKey();
                if (key.isRepeated()) {
                    java.util.Iterator it = ((java.util.List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        addRepeatedField(key, it.next());
                    }
                } else if (key.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    com.google.protobuf.Message message2 = (com.google.protobuf.Message) getField(key);
                    if (message2 == message2.getDefaultInstanceForType()) {
                        setField(key, entry.getValue());
                    } else {
                        setField(key, message2.newBuilderForType().mergeFrom(message2).mergeFrom((com.google.protobuf.Message) entry.getValue()).build());
                    }
                } else {
                    setField(key, entry.getValue());
                }
            }
            mergeUnknownFields(message.getUnknownFields());
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
            return (BuilderType) mergeFrom(codedInputStream, (com.google.protobuf.ExtensionRegistryLite) com.google.protobuf.ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            int tag;
            com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = codedInputStream.shouldDiscardUnknownFields() ? null : com.google.protobuf.UnknownFieldSet.newBuilder(getUnknownFields());
            do {
                tag = codedInputStream.readTag();
                if (tag == 0) {
                    break;
                }
            } while (com.google.protobuf.MessageReflection.mergeFieldFrom(codedInputStream, builderNewBuilder, extensionRegistryLite, getDescriptorForType(), new com.google.protobuf.MessageReflection.BuilderAdapter(this), tag));
            if (builderNewBuilder != null) {
                setUnknownFields(builderNewBuilder.build());
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            setUnknownFields(com.google.protobuf.UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFieldSet).build());
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            throw new java.lang.UnsupportedOperationException("getFieldBuilder() called on_renamed an_renamed unsupported message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public com.google.protobuf.Message.Builder getRepeatedFieldBuilder(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed) {
            throw new java.lang.UnsupportedOperationException("getRepeatedFieldBuilder() called on_renamed an_renamed unsupported message type.");
        }

        public java.lang.String toString() {
            return com.google.protobuf.TextFormat.printer().printToString(this);
        }

        protected static com.google.protobuf.UninitializedMessageException newUninitializedMessageException(com.google.protobuf.Message message) {
            return new com.google.protobuf.UninitializedMessageException(com.google.protobuf.MessageReflection.findMissingFields(message));
        }

        void markClean() {
            throw new java.lang.IllegalStateException("Should be_renamed overridden by_renamed subclasses.");
        }

        void dispose() {
            throw new java.lang.IllegalStateException("Should be_renamed overridden by_renamed subclasses.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] bArr, int i_renamed, int i2, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(bArr, i_renamed, i2, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return (BuilderType) super.mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return (BuilderType) super.mergeFrom(inputStream, extensionRegistryLite);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
            return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
        }
    }

    @java.lang.Deprecated
    protected static int hashEnum(com.google.protobuf.Internal.EnumLite enumLite) {
        return enumLite.getNumber();
    }

    @java.lang.Deprecated
    protected static int hashEnumList(java.util.List<? extends com.google.protobuf.Internal.EnumLite> list) {
        java.util.Iterator<? extends com.google.protobuf.Internal.EnumLite> it = list.iterator();
        int iHashEnum = 1;
        while (it.hasNext()) {
            iHashEnum = (iHashEnum * 31) + hashEnum(it.next());
        }
        return iHashEnum;
    }
}
