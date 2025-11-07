package com.google.protobuf;

/* loaded from: classes.dex */
public final class Mixin extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.MixinOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ROOT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private volatile java.lang.Object root_;
    private static final com.google.protobuf.Mixin DEFAULT_INSTANCE = new com.google.protobuf.Mixin();
    private static final com.google.protobuf.Parser<com.google.protobuf.Mixin> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Mixin>() { // from class: com.google.protobuf.Mixin.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Mixin parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Mixin(codedInputStream, extensionRegistryLite);
        }
    };

    private Mixin(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Mixin() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.root_ = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Mixin();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Mixin(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 18) {
                                this.root_ = codedInputStream.readStringRequireUtf8();
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
        return com.google.protobuf.ApiProto.internal_static_google_protobuf_Mixin_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Mixin.class, com.google.protobuf.Mixin.Builder.class);
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public java.lang.String getRoot() {
        java.lang.Object obj = this.root_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.root_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.MixinOrBuilder
    public com.google.protobuf.ByteString getRootBytes() {
        java.lang.Object obj = this.root_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.root_ = byteStringCopyFromUtf8;
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
        if (!getNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (!getRootBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 2, this.root_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeStringSize = getNameBytes().isEmpty() ? 0 : 0 + com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.name_);
        if (!getRootBytes().isEmpty()) {
            iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, this.root_);
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
        if (!(obj instanceof com.google.protobuf.Mixin)) {
            return super.equals(obj);
        }
        com.google.protobuf.Mixin mixin = (com.google.protobuf.Mixin) obj;
        return getName().equals(mixin.getName()) && getRoot().equals(mixin.getRoot()) && this.unknownFields.equals(mixin.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getRoot().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public static com.google.protobuf.Mixin parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Mixin parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Mixin parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Mixin parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Mixin parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Mixin parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Mixin parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Mixin parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Mixin parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Mixin parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Mixin parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Mixin parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Mixin) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Mixin.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Mixin.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Mixin.Builder newBuilder(com.google.protobuf.Mixin mixin) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(mixin);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Mixin.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Mixin.Builder() : new com.google.protobuf.Mixin.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Mixin.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Mixin.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Mixin.Builder> implements com.google.protobuf.MixinOrBuilder {
        private java.lang.Object name_;
        private java.lang.Object root_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Mixin_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Mixin_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Mixin.class, com.google.protobuf.Mixin.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.root_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.root_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder clear() {
            super.clear();
            this.name_ = "";
            this.root_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Mixin_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Mixin getDefaultInstanceForType() {
            return com.google.protobuf.Mixin.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin build() {
            com.google.protobuf.Mixin mixinBuildPartial = buildPartial();
            if (mixinBuildPartial.isInitialized()) {
                return mixinBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) mixinBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin buildPartial() {
            com.google.protobuf.Mixin mixin = new com.google.protobuf.Mixin(this);
            mixin.name_ = this.name_;
            mixin.root_ = this.root_;
            onBuilt();
            return mixin;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Mixin.Builder mo23clone() {
            return (com.google.protobuf.Mixin.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Mixin.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Mixin.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Mixin.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Mixin.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Mixin.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Mixin.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Mixin) {
                return mergeFrom((com.google.protobuf.Mixin) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Mixin.Builder mergeFrom(com.google.protobuf.Mixin mixin) {
            if (mixin == com.google.protobuf.Mixin.getDefaultInstance()) {
                return this;
            }
            if (!mixin.getName().isEmpty()) {
                this.name_ = mixin.name_;
                onChanged();
            }
            if (!mixin.getRoot().isEmpty()) {
                this.root_ = mixin.root_;
                onChanged();
            }
            mergeUnknownFields(mixin.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Mixin.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Mixin.access$500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Mixin r3 = (com.google.protobuf.Mixin) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Mixin r4 = (com.google.protobuf.Mixin) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Mixin.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Mixin$Builder");
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Mixin.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Mixin.Builder clearName() {
            this.name_ = com.google.protobuf.Mixin.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Mixin.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public java.lang.String getRoot() {
            java.lang.Object obj = this.root_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.root_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.MixinOrBuilder
        public com.google.protobuf.ByteString getRootBytes() {
            java.lang.Object obj = this.root_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.root_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Mixin.Builder setRoot(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.root_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Mixin.Builder clearRoot() {
            this.root_ = com.google.protobuf.Mixin.getDefaultInstance().getRoot();
            onChanged();
            return this;
        }

        public com.google.protobuf.Mixin.Builder setRootBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.root_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Mixin.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Mixin.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Mixin.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Mixin.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Mixin> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Mixin> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Mixin getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
