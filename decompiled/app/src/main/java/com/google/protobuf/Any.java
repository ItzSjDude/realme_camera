package com.google.protobuf;

/* loaded from: classes.dex */
public final class Any extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.AnyOrBuilder {
    private static final com.google.protobuf.Any DEFAULT_INSTANCE = new com.google.protobuf.Any();
    private static final com.google.protobuf.Parser<com.google.protobuf.Any> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Any>() { // from class: com.google.protobuf.Any.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Any parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Any(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile com.google.protobuf.Message cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object typeUrl_;
    private com.google.protobuf.ByteString value_;

    private Any(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Any() {
        this.memoizedIsInitialized = (byte) -1;
        this.typeUrl_ = "";
        this.value_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Any();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Any(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
        boolean z_renamed = false;
        while (!z_renamed) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.typeUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.value_ = codedInputStream.readBytes();
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z_renamed = true;
                    } catch (java.io.IOException e_renamed) {
                        throw new com.google.protobuf.InvalidProtocolBufferException(e_renamed).setUnfinishedMessage(this);
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Any.class, com.google.protobuf.Any.Builder.class);
    }

    private static java.lang.String getTypeUrl(java.lang.String str, com.google.protobuf.Descriptors.Descriptor descriptor) {
        if (str.endsWith("/")) {
            return str + descriptor.getFullName();
        }
        return str + "/" + descriptor.getFullName();
    }

    private static java.lang.String getTypeNameFromTypeUrl(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1);
    }

    public static <T_renamed extends com.google.protobuf.Message> com.google.protobuf.Any pack(T_renamed t_renamed) {
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", t_renamed.getDescriptorForType())).setValue(t_renamed.toByteString()).build();
    }

    public static <T_renamed extends com.google.protobuf.Message> com.google.protobuf.Any pack(T_renamed t_renamed, java.lang.String str) {
        return newBuilder().setTypeUrl(getTypeUrl(str, t_renamed.getDescriptorForType())).setValue(t_renamed.toByteString()).build();
    }

    public <T_renamed extends com.google.protobuf.Message> boolean is_renamed(java.lang.Class<T_renamed> cls) {
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(((com.google.protobuf.Message) com.google.protobuf.Internal.getDefaultInstance(cls)).getDescriptorForType().getFullName());
    }

    public <T_renamed extends com.google.protobuf.Message> T_renamed unpack(java.lang.Class<T_renamed> cls) throws com.google.protobuf.InvalidProtocolBufferException {
        boolean z_renamed;
        if (this.cachedUnpackValue == null) {
            z_renamed = false;
        } else {
            if (this.cachedUnpackValue.getClass() == cls) {
                return (T_renamed) this.cachedUnpackValue;
            }
            z_renamed = true;
        }
        if (z_renamed || !is_renamed(cls)) {
            throw new com.google.protobuf.InvalidProtocolBufferException("Type of_renamed the Any message does not match the given class.");
        }
        T_renamed t_renamed = (T_renamed) ((com.google.protobuf.Message) com.google.protobuf.Internal.getDefaultInstance(cls)).getParserForType().parseFrom(getValue());
        this.cachedUnpackValue = t_renamed;
        return t_renamed;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public java.lang.String getTypeUrl() {
        java.lang.Object obj = this.typeUrl_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.typeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public com.google.protobuf.ByteString getTypeUrlBytes() {
        java.lang.Object obj = this.typeUrl_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.typeUrl_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public com.google.protobuf.ByteString getValue() {
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
        if (!getTypeUrlBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            codedOutputStream.writeBytes(2, this.value_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeStringSize = getTypeUrlBytes().isEmpty() ? 0 : 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
        if (!this.value_.isEmpty()) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeBytesSize(2, this.value_);
        }
        int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.Any)) {
            return super.equals(obj);
        }
        com.google.protobuf.Any any = (com.google.protobuf.Any) obj;
        return getTypeUrl().equals(any.getTypeUrl()) && getValue().equals(any.getValue()) && this.unknownFields.equals(any.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public static com.google.protobuf.Any parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Any parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Any parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Any parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Any parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Any parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Any parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Any parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Any parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Any parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Any parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Any parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Any) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Any.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Any.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Any.Builder newBuilder(com.google.protobuf.Any any) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(any);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Any.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Any.Builder() : new com.google.protobuf.Any.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Any.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Any.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Any.Builder> implements com.google.protobuf.AnyOrBuilder {
        private java.lang.Object typeUrl_;
        private com.google.protobuf.ByteString value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Any.class, com.google.protobuf.Any.Builder.class);
        }

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = com.google.protobuf.ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.typeUrl_ = "";
            this.value_ = com.google.protobuf.ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder clear() {
            super.clear();
            this.typeUrl_ = "";
            this.value_ = com.google.protobuf.ByteString.EMPTY;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Any getDefaultInstanceForType() {
            return com.google.protobuf.Any.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any build() {
            com.google.protobuf.Any anyBuildPartial = buildPartial();
            if (anyBuildPartial.isInitialized()) {
                return anyBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) anyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any buildPartial() {
            com.google.protobuf.Any any = new com.google.protobuf.Any(this);
            any.typeUrl_ = this.typeUrl_;
            any.value_ = this.value_;
            onBuilt();
            return any;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Any.Builder mo23clone() {
            return (com.google.protobuf.Any.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Any.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Any.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Any.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Any.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Any.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Any.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Any) {
                return mergeFrom((com.google.protobuf.Any) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Any.Builder mergeFrom(com.google.protobuf.Any any) {
            if (any == com.google.protobuf.Any.getDefaultInstance()) {
                return this;
            }
            if (!any.getTypeUrl().isEmpty()) {
                this.typeUrl_ = any.typeUrl_;
                onChanged();
            }
            if (any.getValue() != com.google.protobuf.ByteString.EMPTY) {
                setValue(any.getValue());
            }
            mergeUnknownFields(any.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Any.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Any.access$500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Any r3 = (com.google.protobuf.Any) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Any r4 = (com.google.protobuf.Any) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Any.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Any$Builder");
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public java.lang.String getTypeUrl() {
            java.lang.Object obj = this.typeUrl_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.typeUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public com.google.protobuf.ByteString getTypeUrlBytes() {
            java.lang.Object obj = this.typeUrl_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.typeUrl_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Any.Builder setTypeUrl(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.typeUrl_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Any.Builder clearTypeUrl() {
            this.typeUrl_ = com.google.protobuf.Any.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public com.google.protobuf.Any.Builder setTypeUrlBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.typeUrl_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public com.google.protobuf.ByteString getValue() {
            return this.value_;
        }

        public com.google.protobuf.Any.Builder setValue(com.google.protobuf.ByteString byteString) {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            this.value_ = byteString;
            onChanged();
            return this;
        }

        public com.google.protobuf.Any.Builder clearValue() {
            this.value_ = com.google.protobuf.Any.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Any.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Any.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Any.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Any.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
