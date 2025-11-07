package com.google.protobuf;

/* loaded from: classes.dex */
public final class EnumValue extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.EnumValueOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private int number_;
    private java.util.List<com.google.protobuf.Option> options_;
    private static final com.google.protobuf.EnumValue DEFAULT_INSTANCE = new com.google.protobuf.EnumValue();
    private static final com.google.protobuf.Parser<com.google.protobuf.EnumValue> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.EnumValue>() { // from class: com.google.protobuf.EnumValue.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.EnumValue parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.EnumValue(codedInputStream, extensionRegistryLite);
        }
    };

    private EnumValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private EnumValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.options_ = java.util.Collections.emptyList();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.EnumValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private EnumValue(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (tag == 16) {
                                this.number_ = codedInputStream.readInt32();
                            } else if (tag == 26) {
                                if (!(z2 & true)) {
                                    this.options_ = new java.util.ArrayList();
                                    z2 |= true;
                                }
                                this.options_.add(codedInputStream.readMessage(com.google.protobuf.Option.parser(), extensionRegistryLite));
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
                if (z2 & true) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.EnumValue.class, com.google.protobuf.EnumValue.Builder.class);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public java.util.List<com.google.protobuf.Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public com.google.protobuf.Option getOptions(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
        return this.options_.get(i_renamed);
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
        int i_renamed = this.number_;
        if (i_renamed != 0) {
            codedOutputStream.writeInt32(2, i_renamed);
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeStringSize = !getNameBytes().isEmpty() ? com.google.protobuf.GeneratedMessageV3.computeStringSize(1, this.name_) + 0 : 0;
        int i2 = this.number_;
        if (i2 != 0) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeInt32Size(2, i2);
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
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
        if (!(obj instanceof com.google.protobuf.EnumValue)) {
            return super.equals(obj);
        }
        com.google.protobuf.EnumValue enumValue = (com.google.protobuf.EnumValue) obj;
        return getName().equals(enumValue.getName()) && getNumber() == enumValue.getNumber() && getOptionsList().equals(enumValue.getOptionsList()) && this.unknownFields.equals(enumValue.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getNumber();
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.EnumValue parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.EnumValue parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.EnumValue parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.EnumValue parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.EnumValue parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.EnumValue parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.EnumValue parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.EnumValue parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.EnumValue parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.EnumValue parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.EnumValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.EnumValue parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.EnumValue) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.EnumValue.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.EnumValue.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.EnumValue.Builder newBuilder(com.google.protobuf.EnumValue enumValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(enumValue);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.EnumValue.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.EnumValue.Builder() : new com.google.protobuf.EnumValue.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.EnumValue.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.EnumValue.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.EnumValue.Builder> implements com.google.protobuf.EnumValueOrBuilder {
        private int bitField0_;
        private java.lang.Object name_;
        private int number_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> optionsBuilder_;
        private java.util.List<com.google.protobuf.Option> options_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.EnumValue.class, com.google.protobuf.EnumValue.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.options_ = java.util.Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.options_ = java.util.Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getOptionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder clear() {
            super.clear();
            this.name_ = "";
            this.number_ = 0;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.EnumValue getDefaultInstanceForType() {
            return com.google.protobuf.EnumValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue build() {
            com.google.protobuf.EnumValue enumValueBuildPartial = buildPartial();
            if (enumValueBuildPartial.isInitialized()) {
                return enumValueBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) enumValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue buildPartial() {
            com.google.protobuf.EnumValue enumValue = new com.google.protobuf.EnumValue(this);
            int i_renamed = this.bitField0_;
            enumValue.name_ = this.name_;
            enumValue.number_ = this.number_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                enumValue.options_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -2;
                }
                enumValue.options_ = this.options_;
            }
            onBuilt();
            return enumValue;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.EnumValue.Builder mo23clone() {
            return (com.google.protobuf.EnumValue.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.EnumValue.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.EnumValue.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.EnumValue.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.EnumValue.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.EnumValue.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.EnumValue.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.EnumValue) {
                return mergeFrom((com.google.protobuf.EnumValue) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.EnumValue.Builder mergeFrom(com.google.protobuf.EnumValue enumValue) {
            if (enumValue == com.google.protobuf.EnumValue.getDefaultInstance()) {
                return this;
            }
            if (!enumValue.getName().isEmpty()) {
                this.name_ = enumValue.name_;
                onChanged();
            }
            if (enumValue.getNumber() != 0) {
                setNumber(enumValue.getNumber());
            }
            if (this.optionsBuilder_ == null) {
                if (!enumValue.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = enumValue.options_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(enumValue.options_);
                    }
                    onChanged();
                }
            } else if (!enumValue.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(enumValue.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = enumValue.options_;
                    this.bitField0_ &= -2;
                    this.optionsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            mergeUnknownFields(enumValue.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.EnumValue.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.EnumValue.access$600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.EnumValue r3 = (com.google.protobuf.EnumValue) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.EnumValue r4 = (com.google.protobuf.EnumValue) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.EnumValue.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.EnumValue$Builder");
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.EnumValue.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.EnumValue.Builder clearName() {
            this.name_ = com.google.protobuf.EnumValue.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.EnumValue.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return this.number_;
        }

        public com.google.protobuf.EnumValue.Builder setNumber(int i_renamed) {
            this.number_ = i_renamed;
            onChanged();
            return this;
        }

        public com.google.protobuf.EnumValue.Builder clearNumber() {
            this.number_ = 0;
            onChanged();
            return this;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.options_ = new java.util.ArrayList(this.options_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public java.util.List<com.google.protobuf.Option> getOptionsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public com.google.protobuf.Option getOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.Option) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.EnumValue.Builder setOptions(int i_renamed, com.google.protobuf.Option option) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, option);
            } else {
                if (option == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureOptionsIsMutable();
                this.options_.set(i_renamed, option);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder setOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder addOptions(com.google.protobuf.Option option) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(option);
            } else {
                if (option == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureOptionsIsMutable();
                this.options_.add(option);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder addOptions(int i_renamed, com.google.protobuf.Option option) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, option);
            } else {
                if (option == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureOptionsIsMutable();
                this.options_.add(i_renamed, option);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder addOptions(com.google.protobuf.Option.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder addOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder addAllOptions(java.lang.Iterable<? extends com.google.protobuf.Option> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.options_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder clearOptions() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder removeOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureOptionsIsMutable();
                this.options_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.Option.Builder getOptionsBuilder(int i_renamed) {
            return (com.google.protobuf.Option.Builder) getOptionsFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.OptionOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.options_);
        }

        public com.google.protobuf.Option.Builder addOptionsBuilder() {
            return (com.google.protobuf.Option.Builder) getOptionsFieldBuilder().addBuilder(com.google.protobuf.Option.getDefaultInstance());
        }

        public com.google.protobuf.Option.Builder addOptionsBuilder(int i_renamed) {
            return (com.google.protobuf.Option.Builder) getOptionsFieldBuilder().addBuilder(i_renamed, com.google.protobuf.Option.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.EnumValue.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.EnumValue.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.EnumValue.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.EnumValue.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.EnumValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
