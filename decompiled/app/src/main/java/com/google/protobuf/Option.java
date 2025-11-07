package com.google.protobuf;

/* loaded from: classes.dex */
public final class Option extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.OptionOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private com.google.protobuf.Any value_;
    private static final com.google.protobuf.Option DEFAULT_INSTANCE = new com.google.protobuf.Option();
    private static final com.google.protobuf.Parser<com.google.protobuf.Option> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Option>() { // from class: com.google.protobuf.Option.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Option parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Option(codedInputStream, extensionRegistryLite);
        }
    };

    private Option(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Option() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Option();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Option(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                com.google.protobuf.Any.Builder builder = this.value_ != null ? this.value_.toBuilder() : null;
                                this.value_ = (com.google.protobuf.Any) codedInputStream.readMessage(com.google.protobuf.Any.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom(this.value_);
                                    this.value_ = builder.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z_renamed = true;
                    } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                        throw e_renamed.setUnfinishedMessage(this);
                    }
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
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Option.class, com.google.protobuf.Option.Builder.class);
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return this.value_ != null;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public com.google.protobuf.Any getValue() {
        com.google.protobuf.Any any = this.value_;
        return any == null ? com.google.protobuf.Any.getDefaultInstance() : any;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public com.google.protobuf.AnyOrBuilder getValueOrBuilder() {
        return getValue();
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
        if (this.value_ != null) {
            codedOutputStream.writeMessage(2, getValue());
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
        if (this.value_ != null) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getValue());
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
        if (!(obj instanceof com.google.protobuf.Option)) {
            return super.equals(obj);
        }
        com.google.protobuf.Option option = (com.google.protobuf.Option) obj;
        if (getName().equals(option.getName()) && hasValue() == option.hasValue()) {
            return (!hasValue() || getValue().equals(option.getValue())) && this.unknownFields.equals(option.unknownFields);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue()) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getValue().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.Option parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Option parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Option parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Option parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Option parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Option parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Option parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Option parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Option parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Option parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Option parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Option parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Option) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Option.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Option.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Option.Builder newBuilder(com.google.protobuf.Option option) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(option);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Option.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Option.Builder() : new com.google.protobuf.Option.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Option.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Option.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Option.Builder> implements com.google.protobuf.OptionOrBuilder {
        private java.lang.Object name_;
        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> valueBuilder_;
        private com.google.protobuf.Any value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Option.class, com.google.protobuf.Option.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder clear() {
            super.clear();
            this.name_ = "";
            if (this.valueBuilder_ == null) {
                this.value_ = null;
            } else {
                this.value_ = null;
                this.valueBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Option getDefaultInstanceForType() {
            return com.google.protobuf.Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option build() {
            com.google.protobuf.Option optionBuildPartial = buildPartial();
            if (optionBuildPartial.isInitialized()) {
                return optionBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) optionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option buildPartial() {
            com.google.protobuf.Option option = new com.google.protobuf.Option(this);
            option.name_ = this.name_;
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                option.value_ = this.value_;
            } else {
                option.value_ = (com.google.protobuf.Any) singleFieldBuilderV3.build();
            }
            onBuilt();
            return option;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Option.Builder mo23clone() {
            return (com.google.protobuf.Option.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Option.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Option.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Option.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Option.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Option.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Option.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Option) {
                return mergeFrom((com.google.protobuf.Option) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Option.Builder mergeFrom(com.google.protobuf.Option option) {
            if (option == com.google.protobuf.Option.getDefaultInstance()) {
                return this;
            }
            if (!option.getName().isEmpty()) {
                this.name_ = option.name_;
                onChanged();
            }
            if (option.hasValue()) {
                mergeValue(option.getValue());
            }
            mergeUnknownFields(option.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Option.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Option.access$500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Option r3 = (com.google.protobuf.Option) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Option r4 = (com.google.protobuf.Option) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Option.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Option$Builder");
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Option.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Option.Builder clearName() {
            this.name_ = com.google.protobuf.Option.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Option.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public boolean hasValue() {
            return (this.valueBuilder_ == null && this.value_ == null) ? false : true;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public com.google.protobuf.Any getValue() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.Any any = this.value_;
                return any == null ? com.google.protobuf.Any.getDefaultInstance() : any;
            }
            return (com.google.protobuf.Any) singleFieldBuilderV3.getMessage();
        }

        public com.google.protobuf.Option.Builder setValue(com.google.protobuf.Any any) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(any);
            } else {
                if (any == null) {
                    throw new java.lang.NullPointerException();
                }
                this.value_ = any;
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Option.Builder setValue(com.google.protobuf.Any.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.value_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Option.Builder mergeValue(com.google.protobuf.Any any) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.Any any2 = this.value_;
                if (any2 != null) {
                    this.value_ = com.google.protobuf.Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.value_ = any;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(any);
            }
            return this;
        }

        public com.google.protobuf.Option.Builder clearValue() {
            if (this.valueBuilder_ == null) {
                this.value_ = null;
                onChanged();
            } else {
                this.value_ = null;
                this.valueBuilder_ = null;
            }
            return this;
        }

        public com.google.protobuf.Any.Builder getValueBuilder() {
            onChanged();
            return (com.google.protobuf.Any.Builder) getValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public com.google.protobuf.AnyOrBuilder getValueOrBuilder() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> singleFieldBuilderV3 = this.valueBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (com.google.protobuf.AnyOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            com.google.protobuf.Any any = this.value_;
            return any == null ? com.google.protobuf.Any.getDefaultInstance() : any;
        }

        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> getValueFieldBuilder() {
            if (this.valueBuilder_ == null) {
                this.valueBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>(getValue(), getParentForChildren(), isClean());
                this.value_ = null;
            }
            return this.valueBuilder_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Option.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Option.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Option.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Option.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Option> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
