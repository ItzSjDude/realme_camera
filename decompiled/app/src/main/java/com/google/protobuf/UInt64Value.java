package com.google.protobuf;

/* loaded from: classes.dex */
public final class UInt64Value extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.UInt64ValueOrBuilder {
    private static final com.google.protobuf.UInt64Value DEFAULT_INSTANCE = new com.google.protobuf.UInt64Value();
    private static final com.google.protobuf.Parser<com.google.protobuf.UInt64Value> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.UInt64Value>() { // from class: com.google.protobuf.UInt64Value.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.UInt64Value parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.UInt64Value(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private long value_;

    private UInt64Value(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private UInt64Value() {
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.UInt64Value();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private UInt64Value(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
        boolean z_renamed = false;
        while (!z_renamed) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.value_ = codedInputStream.readUInt64();
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
        return com.google.protobuf.WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.UInt64Value.class, com.google.protobuf.UInt64Value.Builder.class);
    }

    @Override // com.google.protobuf.UInt64ValueOrBuilder
    public long getValue() {
        return this.value_;
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
        long j_renamed = this.value_;
        if (j_renamed != 0) {
            codedOutputStream.writeUInt64(1, j_renamed);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        long j_renamed = this.value_;
        int iComputeUInt64Size = (j_renamed != 0 ? 0 + com.google.protobuf.CodedOutputStream.computeUInt64Size(1, j_renamed) : 0) + this.unknownFields.getSerializedSize();
        this.memoizedSize = iComputeUInt64Size;
        return iComputeUInt64Size;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.UInt64Value)) {
            return super.equals(obj);
        }
        com.google.protobuf.UInt64Value uInt64Value = (com.google.protobuf.UInt64Value) obj;
        return getValue() == uInt64Value.getValue() && this.unknownFields.equals(uInt64Value.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + com.google.protobuf.Internal.hashLong(getValue())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public static com.google.protobuf.UInt64Value parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.UInt64Value parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.UInt64Value parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.UInt64Value parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.UInt64Value parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.UInt64Value parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.UInt64Value parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.UInt64Value parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.UInt64Value parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.UInt64Value parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.UInt64Value parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.UInt64Value parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.UInt64Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.UInt64Value.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.UInt64Value.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.UInt64Value.Builder newBuilder(com.google.protobuf.UInt64Value uInt64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt64Value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.UInt64Value.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.UInt64Value.Builder() : new com.google.protobuf.UInt64Value.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.UInt64Value.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.UInt64Value.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.UInt64Value.Builder> implements com.google.protobuf.UInt64ValueOrBuilder {
        private long value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.UInt64Value.class, com.google.protobuf.UInt64Value.Builder.class);
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
        public com.google.protobuf.UInt64Value.Builder clear() {
            super.clear();
            this.value_ = 0L;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.UInt64Value getDefaultInstanceForType() {
            return com.google.protobuf.UInt64Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value build() {
            com.google.protobuf.UInt64Value uInt64ValueBuildPartial = buildPartial();
            if (uInt64ValueBuildPartial.isInitialized()) {
                return uInt64ValueBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) uInt64ValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value buildPartial() {
            com.google.protobuf.UInt64Value uInt64Value = new com.google.protobuf.UInt64Value(this);
            uInt64Value.value_ = this.value_;
            onBuilt();
            return uInt64Value;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.UInt64Value.Builder mo23clone() {
            return (com.google.protobuf.UInt64Value.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.UInt64Value.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.UInt64Value.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.UInt64Value.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.UInt64Value.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.UInt64Value.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.UInt64Value.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.UInt64Value) {
                return mergeFrom((com.google.protobuf.UInt64Value) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.UInt64Value.Builder mergeFrom(com.google.protobuf.UInt64Value uInt64Value) {
            if (uInt64Value == com.google.protobuf.UInt64Value.getDefaultInstance()) {
                return this;
            }
            if (uInt64Value.getValue() != 0) {
                setValue(uInt64Value.getValue());
            }
            mergeUnknownFields(uInt64Value.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.UInt64Value.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.UInt64Value.access$400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.UInt64Value r3 = (com.google.protobuf.UInt64Value) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.UInt64Value r4 = (com.google.protobuf.UInt64Value) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UInt64Value.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.UInt64Value$Builder");
        }

        @Override // com.google.protobuf.UInt64ValueOrBuilder
        public long getValue() {
            return this.value_;
        }

        public com.google.protobuf.UInt64Value.Builder setValue(long j_renamed) {
            this.value_ = j_renamed;
            onChanged();
            return this;
        }

        public com.google.protobuf.UInt64Value.Builder clearValue() {
            this.value_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.UInt64Value.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.UInt64Value.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.UInt64Value.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.UInt64Value.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.UInt64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.UInt64Value of_renamed(long j_renamed) {
        return newBuilder().setValue(j_renamed).build();
    }

    public static com.google.protobuf.Parser<com.google.protobuf.UInt64Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.UInt64Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.UInt64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
