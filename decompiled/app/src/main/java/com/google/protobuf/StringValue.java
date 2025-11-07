package com.google.protobuf;

/* loaded from: classes.dex */
public final class StringValue extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.StringValueOrBuilder {
    private static final com.google.protobuf.StringValue DEFAULT_INSTANCE = new com.google.protobuf.StringValue();
    private static final com.google.protobuf.Parser<com.google.protobuf.StringValue> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.StringValue>() { // from class: com.google.protobuf.StringValue.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.StringValue parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.StringValue(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int VALUE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object value_;

    private StringValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private StringValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.value_ = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.StringValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private StringValue(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                        if (tag == 10) {
                            this.value_ = codedInputStream.readStringRequireUtf8();
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
        return com.google.protobuf.WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.StringValue.class, com.google.protobuf.StringValue.Builder.class);
    }

    @Override // com.google.protobuf.StringValueOrBuilder
    public java.lang.String getValue() {
        java.lang.Object obj = this.value_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.value_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.StringValueOrBuilder
    public com.google.protobuf.ByteString getValueBytes() {
        java.lang.Object obj = this.value_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.value_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
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
        if (!getValueBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.value_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeStringSize = (getValueBytes().isEmpty() ? 0 : 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.value_)) + this.unknownFields.getSerializedSize();
        this.memoizedSize = iComputeStringSize;
        return iComputeStringSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.StringValue)) {
            return super.equals(obj);
        }
        com.google.protobuf.StringValue stringValue = (com.google.protobuf.StringValue) obj;
        return getValue().equals(stringValue.getValue()) && this.unknownFields.equals(stringValue.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public static com.google.protobuf.StringValue parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.StringValue parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.StringValue parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.StringValue parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.StringValue parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.StringValue parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.StringValue parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.StringValue parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.StringValue parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.StringValue parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.StringValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.StringValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.StringValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.StringValue.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.StringValue.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.StringValue.Builder newBuilder(com.google.protobuf.StringValue stringValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(stringValue);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.StringValue.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.StringValue.Builder() : new com.google.protobuf.StringValue.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.StringValue.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.StringValue.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.StringValue.Builder> implements com.google.protobuf.StringValueOrBuilder {
        private java.lang.Object value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.StringValue.class, com.google.protobuf.StringValue.Builder.class);
        }

        private Builder() {
            this.value_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.value_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder clear() {
            super.clear();
            this.value_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.StringValue getDefaultInstanceForType() {
            return com.google.protobuf.StringValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue build() {
            com.google.protobuf.StringValue stringValueBuildPartial = buildPartial();
            if (stringValueBuildPartial.isInitialized()) {
                return stringValueBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) stringValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue buildPartial() {
            com.google.protobuf.StringValue stringValue = new com.google.protobuf.StringValue(this);
            stringValue.value_ = this.value_;
            onBuilt();
            return stringValue;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.StringValue.Builder mo23clone() {
            return (com.google.protobuf.StringValue.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.StringValue.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.StringValue.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.StringValue.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.StringValue.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.StringValue.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.StringValue.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.StringValue) {
                return mergeFrom((com.google.protobuf.StringValue) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.StringValue.Builder mergeFrom(com.google.protobuf.StringValue stringValue) {
            if (stringValue == com.google.protobuf.StringValue.getDefaultInstance()) {
                return this;
            }
            if (!stringValue.getValue().isEmpty()) {
                this.value_ = stringValue.value_;
                onChanged();
            }
            mergeUnknownFields(stringValue.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.StringValue.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.StringValue.access$400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.StringValue r3 = (com.google.protobuf.StringValue) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.StringValue r4 = (com.google.protobuf.StringValue) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.StringValue.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.StringValue$Builder");
        }

        @Override // com.google.protobuf.StringValueOrBuilder
        public java.lang.String getValue() {
            java.lang.Object obj = this.value_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.value_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.StringValueOrBuilder
        public com.google.protobuf.ByteString getValueBytes() {
            java.lang.Object obj = this.value_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.value_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.StringValue.Builder setValue(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.value_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.StringValue.Builder clearValue() {
            this.value_ = com.google.protobuf.StringValue.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        public com.google.protobuf.StringValue.Builder setValueBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.value_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.StringValue.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.StringValue.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.StringValue.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.StringValue.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.StringValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.StringValue of_renamed(java.lang.String str) {
        return newBuilder().setValue(str).build();
    }

    public static com.google.protobuf.Parser<com.google.protobuf.StringValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.StringValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.StringValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
