package com.google.protobuf;

/* loaded from: classes.dex */
public final class Enum extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.EnumOrBuilder {
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private java.util.List<com.google.protobuf.EnumValue> enumvalue_;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private java.util.List<com.google.protobuf.Option> options_;
    private com.google.protobuf.SourceContext sourceContext_;
    private int syntax_;
    private static final com.google.protobuf.Enum DEFAULT_INSTANCE = new com.google.protobuf.Enum();
    private static final com.google.protobuf.Parser<com.google.protobuf.Enum> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Enum>() { // from class: com.google.protobuf.Enum.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Enum parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Enum(codedInputStream, extensionRegistryLite);
        }
    };

    private Enum(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Enum() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.enumvalue_ = java.util.Collections.emptyList();
        this.options_ = java.util.Collections.emptyList();
        this.syntax_ = 0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Enum();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Enum(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder builderNewBuilder = com.google.protobuf.UnknownFieldSet.newBuilder();
        boolean z_renamed = false;
        int i_renamed = 0;
        while (!z_renamed) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (tag == 18) {
                            if ((i_renamed & 1) == 0) {
                                this.enumvalue_ = new java.util.ArrayList();
                                i_renamed |= 1;
                            }
                            this.enumvalue_.add(codedInputStream.readMessage(com.google.protobuf.EnumValue.parser(), extensionRegistryLite));
                        } else if (tag == 26) {
                            if ((i_renamed & 2) == 0) {
                                this.options_ = new java.util.ArrayList();
                                i_renamed |= 2;
                            }
                            this.options_.add(codedInputStream.readMessage(com.google.protobuf.Option.parser(), extensionRegistryLite));
                        } else if (tag == 34) {
                            com.google.protobuf.SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                            this.sourceContext_ = (com.google.protobuf.SourceContext) codedInputStream.readMessage(com.google.protobuf.SourceContext.parser(), extensionRegistryLite);
                            if (builder != null) {
                                builder.mergeFrom(this.sourceContext_);
                                this.sourceContext_ = builder.buildPartial();
                            }
                        } else if (tag == 40) {
                            this.syntax_ = codedInputStream.readEnum();
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
                if ((i_renamed & 1) != 0) {
                    this.enumvalue_ = java.util.Collections.unmodifiableList(this.enumvalue_);
                }
                if ((i_renamed & 2) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Enum.class, com.google.protobuf.Enum.Builder.class);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public java.util.List<com.google.protobuf.EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public java.util.List<? extends com.google.protobuf.EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.EnumValue getEnumvalue(int i_renamed) {
        return this.enumvalue_.get(i_renamed);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.EnumValueOrBuilder getEnumvalueOrBuilder(int i_renamed) {
        return this.enumvalue_.get(i_renamed);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public java.util.List<com.google.protobuf.Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.Option getOptions(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.SourceContext getSourceContext() {
        com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public com.google.protobuf.Syntax getSyntax() {
        com.google.protobuf.Syntax syntaxValueOf = com.google.protobuf.Syntax.valueOf(this.syntax_);
        return syntaxValueOf == null ? com.google.protobuf.Syntax.UNRECOGNIZED : syntaxValueOf;
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
        for (int i_renamed = 0; i_renamed < this.enumvalue_.size(); i_renamed++) {
            codedOutputStream.writeMessage(2, this.enumvalue_.get(i_renamed));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(4, getSourceContext());
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(5, this.syntax_);
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
        for (int i2 = 0; i2 < this.enumvalue_.size(); i2++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getSourceContext());
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeEnumSize(5, this.syntax_);
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
        if (!(obj instanceof com.google.protobuf.Enum)) {
            return super.equals(obj);
        }
        com.google.protobuf.Enum r5 = (com.google.protobuf.Enum) obj;
        if (getName().equals(r5.getName()) && getEnumvalueList().equals(r5.getEnumvalueList()) && getOptionsList().equals(r5.getOptionsList()) && hasSourceContext() == r5.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(r5.getSourceContext())) && this.syntax_ == r5.syntax_ && this.unknownFields.equals(r5.unknownFields);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getEnumvalueCount() > 0) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getEnumvalueList().hashCode();
        }
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        if (hasSourceContext()) {
            iHashCode = (((iHashCode * 37) + 4) * 53) + getSourceContext().hashCode();
        }
        int iHashCode2 = (((((iHashCode * 37) + 5) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.Enum parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Enum parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Enum parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Enum parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Enum parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Enum parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Enum parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Enum parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Enum parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Enum parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Enum parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Enum parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Enum) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Enum.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Enum.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Enum.Builder newBuilder(com.google.protobuf.Enum r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Enum.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Enum.Builder() : new com.google.protobuf.Enum.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Enum.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Enum.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Enum.Builder> implements com.google.protobuf.EnumOrBuilder {
        private int bitField0_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> enumvalueBuilder_;
        private java.util.List<com.google.protobuf.EnumValue> enumvalue_;
        private java.lang.Object name_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> optionsBuilder_;
        private java.util.List<com.google.protobuf.Option> options_;
        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> sourceContextBuilder_;
        private com.google.protobuf.SourceContext sourceContext_;
        private int syntax_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Enum.class, com.google.protobuf.Enum.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.enumvalue_ = java.util.Collections.emptyList();
            this.options_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.enumvalue_ = java.util.Collections.emptyList();
            this.options_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getEnumvalueFieldBuilder();
                getOptionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder clear() {
            super.clear();
            this.name_ = "";
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.enumvalue_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            this.syntax_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Enum_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Enum getDefaultInstanceForType() {
            return com.google.protobuf.Enum.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum build() {
            com.google.protobuf.Enum enumBuildPartial = buildPartial();
            if (enumBuildPartial.isInitialized()) {
                return enumBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) enumBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum buildPartial() {
            com.google.protobuf.Enum r0 = new com.google.protobuf.Enum(this);
            int i_renamed = this.bitField0_;
            r0.name_ = this.name_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                r0.enumvalue_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.enumvalue_ = java.util.Collections.unmodifiableList(this.enumvalue_);
                    this.bitField0_ &= -2;
                }
                r0.enumvalue_ = this.enumvalue_;
            }
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                r0.options_ = repeatedFieldBuilderV32.build();
            } else {
                if ((this.bitField0_ & 2) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -3;
                }
                r0.options_ = this.options_;
            }
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                r0.sourceContext_ = this.sourceContext_;
            } else {
                r0.sourceContext_ = (com.google.protobuf.SourceContext) singleFieldBuilderV3.build();
            }
            r0.syntax_ = this.syntax_;
            onBuilt();
            return r0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Enum.Builder mo23clone() {
            return (com.google.protobuf.Enum.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Enum.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Enum.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Enum.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Enum.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Enum.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Enum.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Enum) {
                return mergeFrom((com.google.protobuf.Enum) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Enum.Builder mergeFrom(com.google.protobuf.Enum r4) {
            if (r4 == com.google.protobuf.Enum.getDefaultInstance()) {
                return this;
            }
            if (!r4.getName().isEmpty()) {
                this.name_ = r4.name_;
                onChanged();
            }
            if (this.enumvalueBuilder_ == null) {
                if (!r4.enumvalue_.isEmpty()) {
                    if (this.enumvalue_.isEmpty()) {
                        this.enumvalue_ = r4.enumvalue_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureEnumvalueIsMutable();
                        this.enumvalue_.addAll(r4.enumvalue_);
                    }
                    onChanged();
                }
            } else if (!r4.enumvalue_.isEmpty()) {
                if (!this.enumvalueBuilder_.isEmpty()) {
                    this.enumvalueBuilder_.addAllMessages(r4.enumvalue_);
                } else {
                    this.enumvalueBuilder_.dispose();
                    this.enumvalueBuilder_ = null;
                    this.enumvalue_ = r4.enumvalue_;
                    this.bitField0_ &= -2;
                    this.enumvalueBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getEnumvalueFieldBuilder() : null;
                }
            }
            if (this.optionsBuilder_ == null) {
                if (!r4.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = r4.options_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(r4.options_);
                    }
                    onChanged();
                }
            } else if (!r4.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(r4.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = r4.options_;
                    this.bitField0_ &= -3;
                    this.optionsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (r4.hasSourceContext()) {
                mergeSourceContext(r4.getSourceContext());
            }
            if (r4.syntax_ != 0) {
                setSyntaxValue(r4.getSyntaxValue());
            }
            mergeUnknownFields(r4.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Enum.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Enum.access$800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Enum r3 = (com.google.protobuf.Enum) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Enum r4 = (com.google.protobuf.Enum) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Enum.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Enum$Builder");
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Enum.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Enum.Builder clearName() {
            this.name_ = com.google.protobuf.Enum.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Enum.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        private void ensureEnumvalueIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.enumvalue_ = new java.util.ArrayList(this.enumvalue_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public java.util.List<com.google.protobuf.EnumValue> getEnumvalueList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.enumvalue_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enumvalue_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.EnumValue getEnumvalue(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enumvalue_.get(i_renamed);
            }
            return (com.google.protobuf.EnumValue) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Enum.Builder setEnumvalue(int i_renamed, com.google.protobuf.EnumValue enumValue) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, enumValue);
            } else {
                if (enumValue == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureEnumvalueIsMutable();
                this.enumvalue_.set(i_renamed, enumValue);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder setEnumvalue(int i_renamed, com.google.protobuf.EnumValue.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder addEnumvalue(com.google.protobuf.EnumValue enumValue) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(enumValue);
            } else {
                if (enumValue == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(enumValue);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder addEnumvalue(int i_renamed, com.google.protobuf.EnumValue enumValue) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, enumValue);
            } else {
                if (enumValue == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(i_renamed, enumValue);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder addEnumvalue(com.google.protobuf.EnumValue.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder addEnumvalue(int i_renamed, com.google.protobuf.EnumValue.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder addAllEnumvalue(java.lang.Iterable<? extends com.google.protobuf.EnumValue> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumvalueIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.enumvalue_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder clearEnumvalue() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.enumvalue_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder removeEnumvalue(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureEnumvalueIsMutable();
                this.enumvalue_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.EnumValue.Builder getEnumvalueBuilder(int i_renamed) {
            return (com.google.protobuf.EnumValue.Builder) getEnumvalueFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.EnumValueOrBuilder getEnumvalueOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.enumvalue_.get(i_renamed);
            }
            return (com.google.protobuf.EnumValueOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public java.util.List<? extends com.google.protobuf.EnumValueOrBuilder> getEnumvalueOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> repeatedFieldBuilderV3 = this.enumvalueBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.enumvalue_);
        }

        public com.google.protobuf.EnumValue.Builder addEnumvalueBuilder() {
            return (com.google.protobuf.EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(com.google.protobuf.EnumValue.getDefaultInstance());
        }

        public com.google.protobuf.EnumValue.Builder addEnumvalueBuilder(int i_renamed) {
            return (com.google.protobuf.EnumValue.Builder) getEnumvalueFieldBuilder().addBuilder(i_renamed, com.google.protobuf.EnumValue.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.EnumValue.Builder> getEnumvalueBuilderList() {
            return getEnumvalueFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.EnumValue, com.google.protobuf.EnumValue.Builder, com.google.protobuf.EnumValueOrBuilder> getEnumvalueFieldBuilder() {
            if (this.enumvalueBuilder_ == null) {
                this.enumvalueBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.enumvalue_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.enumvalue_ = null;
            }
            return this.enumvalueBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.options_ = new java.util.ArrayList(this.options_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public java.util.List<com.google.protobuf.Option> getOptionsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.Option getOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.Option) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Enum.Builder setOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Enum.Builder setOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Enum.Builder addOptions(com.google.protobuf.Option option) {
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

        public com.google.protobuf.Enum.Builder addOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Enum.Builder addOptions(com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Enum.Builder addOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Enum.Builder addAllOptions(java.lang.Iterable<? extends com.google.protobuf.Option> iterable) {
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

        public com.google.protobuf.Enum.Builder clearOptions() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder removeOptions(int i_renamed) {
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

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.OptionOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.EnumOrBuilder
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
                this.optionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return (this.sourceContextBuilder_ == null && this.sourceContext_ == null) ? false : true;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.SourceContext getSourceContext() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
                return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
            }
            return (com.google.protobuf.SourceContext) singleFieldBuilderV3.getMessage();
        }

        public com.google.protobuf.Enum.Builder setSourceContext(com.google.protobuf.SourceContext sourceContext) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(sourceContext);
            } else {
                if (sourceContext == null) {
                    throw new java.lang.NullPointerException();
                }
                this.sourceContext_ = sourceContext;
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder setSourceContext(com.google.protobuf.SourceContext.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sourceContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder mergeSourceContext(com.google.protobuf.SourceContext sourceContext) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.SourceContext sourceContext2 = this.sourceContext_;
                if (sourceContext2 != null) {
                    this.sourceContext_ = com.google.protobuf.SourceContext.newBuilder(sourceContext2).mergeFrom(sourceContext).buildPartial();
                } else {
                    this.sourceContext_ = sourceContext;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(sourceContext);
            }
            return this;
        }

        public com.google.protobuf.Enum.Builder clearSourceContext() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
                onChanged();
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            return this;
        }

        public com.google.protobuf.SourceContext.Builder getSourceContextBuilder() {
            onChanged();
            return (com.google.protobuf.SourceContext.Builder) getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.SourceContextOrBuilder getSourceContextOrBuilder() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (com.google.protobuf.SourceContextOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
            return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
        }

        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContextBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>(getSourceContext(), getParentForChildren(), isClean());
                this.sourceContext_ = null;
            }
            return this.sourceContextBuilder_;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public com.google.protobuf.Enum.Builder setSyntaxValue(int i_renamed) {
            this.syntax_ = i_renamed;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public com.google.protobuf.Syntax getSyntax() {
            com.google.protobuf.Syntax syntaxValueOf = com.google.protobuf.Syntax.valueOf(this.syntax_);
            return syntaxValueOf == null ? com.google.protobuf.Syntax.UNRECOGNIZED : syntaxValueOf;
        }

        public com.google.protobuf.Enum.Builder setSyntax(com.google.protobuf.Syntax syntax) {
            if (syntax == null) {
                throw new java.lang.NullPointerException();
            }
            this.syntax_ = syntax.getNumber();
            onChanged();
            return this;
        }

        public com.google.protobuf.Enum.Builder clearSyntax() {
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Enum.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Enum.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Enum.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Enum.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Enum> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Enum> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Enum getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
