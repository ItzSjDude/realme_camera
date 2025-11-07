package com.google.protobuf;

/* loaded from: classes.dex */
public final class FieldMask extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.FieldMaskOrBuilder {
    private static final com.google.protobuf.FieldMask DEFAULT_INSTANCE = new com.google.protobuf.FieldMask();
    private static final com.google.protobuf.Parser<com.google.protobuf.FieldMask> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.FieldMask>() { // from class: com.google.protobuf.FieldMask.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.FieldMask parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.FieldMask(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PATHS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private com.google.protobuf.LazyStringList paths_;

    private FieldMask(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private FieldMask() {
        this.memoizedIsInitialized = (byte) -1;
        this.paths_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.FieldMask();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private FieldMask(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                            java.lang.String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if (!(z2 & true)) {
                                this.paths_ = new com.google.protobuf.LazyStringArrayList();
                                z2 |= true;
                            }
                            this.paths_.add(stringRequireUtf8);
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
                if (z2 & true) {
                    this.paths_ = this.paths_.getUnmodifiableView();
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.FieldMask.class, com.google.protobuf.FieldMask.Builder.class);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public com.google.protobuf.ProtocolStringList getPathsList() {
        return this.paths_;
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public java.lang.String getPaths(int i_renamed) {
        return (java.lang.String) this.paths_.get(i_renamed);
    }

    @Override // com.google.protobuf.FieldMaskOrBuilder
    public com.google.protobuf.ByteString getPathsBytes(int i_renamed) {
        return this.paths_.getByteString(i_renamed);
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
        for (int i_renamed = 0; i_renamed < this.paths_.size(); i_renamed++) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 1, this.paths_.getRaw(i_renamed));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeStringSizeNoTag = 0;
        for (int i2 = 0; i2 < this.paths_.size(); i2++) {
            iComputeStringSizeNoTag += computeStringSizeNoTag(this.paths_.getRaw(i2));
        }
        int size = 0 + iComputeStringSizeNoTag + (getPathsList().size() * 1) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size;
        return size;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.FieldMask)) {
            return super.equals(obj);
        }
        com.google.protobuf.FieldMask fieldMask = (com.google.protobuf.FieldMask) obj;
        return getPathsList().equals(fieldMask.getPathsList()) && this.unknownFields.equals(fieldMask.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        if (getPathsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 1) * 53) + getPathsList().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.FieldMask parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.FieldMask parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.FieldMask parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.FieldMask parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.FieldMask parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.FieldMask parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.FieldMask parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.FieldMask parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.FieldMask parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.FieldMask parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.FieldMask parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.FieldMask parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.FieldMask) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.FieldMask.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.FieldMask.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.FieldMask.Builder newBuilder(com.google.protobuf.FieldMask fieldMask) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(fieldMask);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.FieldMask.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.FieldMask.Builder() : new com.google.protobuf.FieldMask.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.FieldMask.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.FieldMask.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.FieldMask.Builder> implements com.google.protobuf.FieldMaskOrBuilder {
        private int bitField0_;
        private com.google.protobuf.LazyStringList paths_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.FieldMask.class, com.google.protobuf.FieldMask.Builder.class);
        }

        private Builder() {
            this.paths_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.paths_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder clear() {
            super.clear();
            this.paths_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.FieldMask getDefaultInstanceForType() {
            return com.google.protobuf.FieldMask.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask build() {
            com.google.protobuf.FieldMask fieldMaskBuildPartial = buildPartial();
            if (fieldMaskBuildPartial.isInitialized()) {
                return fieldMaskBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) fieldMaskBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask buildPartial() {
            com.google.protobuf.FieldMask fieldMask = new com.google.protobuf.FieldMask(this);
            if ((this.bitField0_ & 1) != 0) {
                this.paths_ = this.paths_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            fieldMask.paths_ = this.paths_;
            onBuilt();
            return fieldMask;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.FieldMask.Builder mo23clone() {
            return (com.google.protobuf.FieldMask.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.FieldMask.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.FieldMask.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.FieldMask.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.FieldMask.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.FieldMask.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.FieldMask.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.FieldMask) {
                return mergeFrom((com.google.protobuf.FieldMask) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.FieldMask.Builder mergeFrom(com.google.protobuf.FieldMask fieldMask) {
            if (fieldMask == com.google.protobuf.FieldMask.getDefaultInstance()) {
                return this;
            }
            if (!fieldMask.paths_.isEmpty()) {
                if (this.paths_.isEmpty()) {
                    this.paths_ = fieldMask.paths_;
                    this.bitField0_ &= -2;
                } else {
                    ensurePathsIsMutable();
                    this.paths_.addAll(fieldMask.paths_);
                }
                onChanged();
            }
            mergeUnknownFields(fieldMask.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.FieldMask.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.FieldMask.access$400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.FieldMask r3 = (com.google.protobuf.FieldMask) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.FieldMask r4 = (com.google.protobuf.FieldMask) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldMask.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.FieldMask$Builder");
        }

        private void ensurePathsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.paths_ = new com.google.protobuf.LazyStringArrayList(this.paths_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public com.google.protobuf.ProtocolStringList getPathsList() {
            return this.paths_.getUnmodifiableView();
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public int getPathsCount() {
            return this.paths_.size();
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public java.lang.String getPaths(int i_renamed) {
            return (java.lang.String) this.paths_.get(i_renamed);
        }

        @Override // com.google.protobuf.FieldMaskOrBuilder
        public com.google.protobuf.ByteString getPathsBytes(int i_renamed) {
            return this.paths_.getByteString(i_renamed);
        }

        public com.google.protobuf.FieldMask.Builder setPaths(int i_renamed, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            ensurePathsIsMutable();
            this.paths_.set(i_renamed, str);
            onChanged();
            return this;
        }

        public com.google.protobuf.FieldMask.Builder addPaths(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            ensurePathsIsMutable();
            this.paths_.add(str);
            onChanged();
            return this;
        }

        public com.google.protobuf.FieldMask.Builder addAllPaths(java.lang.Iterable<java.lang.String> iterable) {
            ensurePathsIsMutable();
            com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.paths_);
            onChanged();
            return this;
        }

        public com.google.protobuf.FieldMask.Builder clearPaths() {
            this.paths_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public com.google.protobuf.FieldMask.Builder addPathsBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensurePathsIsMutable();
            this.paths_.add(byteString);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.FieldMask.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.FieldMask.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.FieldMask.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.FieldMask.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.FieldMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.FieldMask> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.FieldMask> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.FieldMask getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
