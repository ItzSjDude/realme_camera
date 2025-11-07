package com.google.protobuf;

/* loaded from: classes.dex */
public final class Struct extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.StructOrBuilder {
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> fields_;
    private byte memoizedIsInitialized;
    private static final com.google.protobuf.Struct DEFAULT_INSTANCE = new com.google.protobuf.Struct();
    private static final com.google.protobuf.Parser<com.google.protobuf.Struct> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Struct>() { // from class: com.google.protobuf.Struct.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Struct parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Struct(codedInputStream, extensionRegistryLite);
        }
    };

    private Struct(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Struct() {
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Struct();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Struct(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
        boolean z_renamed = false;
        boolean z2 = false;
        while (!z_renamed) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            if (!(z2 & true)) {
                                this.fields_ = com.google.protobuf.MapField.newMapField(com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry);
                                z2 |= true;
                            }
                            com.google.protobuf.MapEntry mapEntry = (com.google.protobuf.MapEntry) codedInputStream.readMessage(com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                            this.fields_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                        } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                        }
                    }
                    z_renamed = true;
                } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                    throw e_renamed.setUnfinishedMessage(this);
                } catch (java.io.IOException e2) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.MapField internalGetMapField(int i_renamed) {
        if (i_renamed == 1) {
            return internalGetFields();
        }
        throw new java.lang.RuntimeException("Invalid map field number: " + i_renamed);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Struct.class, com.google.protobuf.Struct.Builder.class);
    }

    private static final class FieldsDefaultEntryHolder {
        static final com.google.protobuf.MapEntry<java.lang.String, com.google.protobuf.Value> defaultEntry = com.google.protobuf.MapEntry.newDefaultInstance(com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, com.google.protobuf.WireFormat.FieldType.STRING, "", com.google.protobuf.WireFormat.FieldType.MESSAGE, com.google.protobuf.Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> internalGetFields() {
        com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> mapField = this.fields_;
        return mapField == null ? com.google.protobuf.MapField.emptyMapField(com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry) : mapField;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().getMap().size();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public boolean containsFields(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException();
        }
        return internalGetFields().getMap().containsKey(str);
    }

    @Override // com.google.protobuf.StructOrBuilder
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.google.protobuf.Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public java.util.Map<java.lang.String, com.google.protobuf.Value> getFieldsMap() {
        return internalGetFields().getMap();
    }

    @Override // com.google.protobuf.StructOrBuilder
    public com.google.protobuf.Value getFieldsOrDefault(java.lang.String str, com.google.protobuf.Value value) {
        if (str == null) {
            throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, com.google.protobuf.Value> map = internalGetFields().getMap();
        return map.containsKey(str) ? map.get(str) : value;
    }

    @Override // com.google.protobuf.StructOrBuilder
    public com.google.protobuf.Value getFieldsOrThrow(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException();
        }
        java.util.Map<java.lang.String, com.google.protobuf.Value> map = internalGetFields().getMap();
        if (!map.containsKey(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return map.get(str);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(com.google.protobuf.CodedOutputStream codedOutputStream) throws java.io.IOException {
        com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetFields(), com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry, 1);
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeMessageSize = 0;
        for (java.util.Map.Entry<java.lang.String, com.google.protobuf.Value> entry : internalGetFields().getMap().entrySet()) {
            iComputeMessageSize += com.google.protobuf.CodedOutputStream.computeMessageSize(1, com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.Struct)) {
            return super.equals(obj);
        }
        com.google.protobuf.Struct struct = (com.google.protobuf.Struct) obj;
        return internalGetFields().equals(struct.internalGetFields()) && this.unknownFields.equals(struct.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        if (!internalGetFields().getMap().isEmpty()) {
            iHashCode = (((iHashCode * 37) + 1) * 53) + internalGetFields().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.Struct parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Struct parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Struct parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Struct parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Struct parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Struct parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Struct parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Struct parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Struct parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Struct parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Struct parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Struct parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Struct) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Struct.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Struct.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Struct.Builder newBuilder(com.google.protobuf.Struct struct) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(struct);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Struct.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Struct.Builder() : new com.google.protobuf.Struct.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Struct.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Struct.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Struct.Builder> implements com.google.protobuf.StructOrBuilder {
        private int bitField0_;
        private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> fields_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.MapField internalGetMapField(int i_renamed) {
            if (i_renamed == 1) {
                return internalGetFields();
            }
            throw new java.lang.RuntimeException("Invalid map field number: " + i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.MapField internalGetMutableMapField(int i_renamed) {
            if (i_renamed == 1) {
                return internalGetMutableFields();
            }
            throw new java.lang.RuntimeException("Invalid map field number: " + i_renamed);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Struct.class, com.google.protobuf.Struct.Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder clear() {
            super.clear();
            internalGetMutableFields().clear();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Struct_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Struct getDefaultInstanceForType() {
            return com.google.protobuf.Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct build() {
            com.google.protobuf.Struct structBuildPartial = buildPartial();
            if (structBuildPartial.isInitialized()) {
                return structBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) structBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct buildPartial() {
            com.google.protobuf.Struct struct = new com.google.protobuf.Struct(this);
            int i_renamed = this.bitField0_;
            struct.fields_ = internalGetFields();
            struct.fields_.makeImmutable();
            onBuilt();
            return struct;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Struct.Builder mo23clone() {
            return (com.google.protobuf.Struct.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Struct.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Struct.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Struct.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Struct.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Struct.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Struct.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Struct) {
                return mergeFrom((com.google.protobuf.Struct) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Struct.Builder mergeFrom(com.google.protobuf.Struct struct) {
            if (struct == com.google.protobuf.Struct.getDefaultInstance()) {
                return this;
            }
            internalGetMutableFields().mergeFrom(struct.internalGetFields());
            mergeUnknownFields(struct.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Struct.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Struct.access$500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Struct r3 = (com.google.protobuf.Struct) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                if (r3 == 0) goto L10
                r2.mergeFrom(r3)
            L10:
                return r2
            L11:
                r3 = move-exception
                goto L21
            L13:
                r3 = move-exception
                com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                com.google.protobuf.Struct r4 = (com.google.protobuf.Struct) r4     // Catch: java.lang.Throwable -> L11
                java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                throw r3     // Catch: java.lang.Throwable -> L1f
            L1f:
                r3 = move-exception
                r0 = r4
            L21:
                if (r0 == 0) goto L26
                r2.mergeFrom(r0)
            L26:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Struct.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Struct$Builder");
        }

        private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> internalGetFields() {
            com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> mapField = this.fields_;
            return mapField == null ? com.google.protobuf.MapField.emptyMapField(com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry) : mapField;
        }

        private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.Value> internalGetMutableFields() {
            onChanged();
            if (this.fields_ == null) {
                this.fields_ = com.google.protobuf.MapField.newMapField(com.google.protobuf.Struct.FieldsDefaultEntryHolder.defaultEntry);
            }
            if (!this.fields_.isMutable()) {
                this.fields_ = this.fields_.copy();
            }
            return this.fields_;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return internalGetFields().getMap().size();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public boolean containsFields(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            return internalGetFields().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.StructOrBuilder
        @java.lang.Deprecated
        public java.util.Map<java.lang.String, com.google.protobuf.Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public java.util.Map<java.lang.String, com.google.protobuf.Value> getFieldsMap() {
            return internalGetFields().getMap();
        }

        @Override // com.google.protobuf.StructOrBuilder
        public com.google.protobuf.Value getFieldsOrDefault(java.lang.String str, com.google.protobuf.Value value) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, com.google.protobuf.Value> map = internalGetFields().getMap();
            return map.containsKey(str) ? map.get(str) : value;
        }

        @Override // com.google.protobuf.StructOrBuilder
        public com.google.protobuf.Value getFieldsOrThrow(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, com.google.protobuf.Value> map = internalGetFields().getMap();
            if (!map.containsKey(str)) {
                throw new java.lang.IllegalArgumentException();
            }
            return map.get(str);
        }

        public com.google.protobuf.Struct.Builder clearFields() {
            internalGetMutableFields().getMutableMap().clear();
            return this;
        }

        public com.google.protobuf.Struct.Builder removeFields(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            internalGetMutableFields().getMutableMap().remove(str);
            return this;
        }

        @java.lang.Deprecated
        public java.util.Map<java.lang.String, com.google.protobuf.Value> getMutableFields() {
            return internalGetMutableFields().getMutableMap();
        }

        public com.google.protobuf.Struct.Builder putFields(java.lang.String str, com.google.protobuf.Value value) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            if (value == null) {
                throw new java.lang.NullPointerException();
            }
            internalGetMutableFields().getMutableMap().put(str, value);
            return this;
        }

        public com.google.protobuf.Struct.Builder putAllFields(java.util.Map<java.lang.String, com.google.protobuf.Value> map) {
            internalGetMutableFields().getMutableMap().putAll(map);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Struct.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Struct.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Struct.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Struct.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Struct> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Struct> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
