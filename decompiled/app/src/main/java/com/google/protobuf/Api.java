package com.google.protobuf;

/* loaded from: classes.dex */
public final class Api extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.ApiOrBuilder {
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private java.util.List<com.google.protobuf.Method> methods_;
    private java.util.List<com.google.protobuf.Mixin> mixins_;
    private volatile java.lang.Object name_;
    private java.util.List<com.google.protobuf.Option> options_;
    private com.google.protobuf.SourceContext sourceContext_;
    private int syntax_;
    private volatile java.lang.Object version_;
    private static final com.google.protobuf.Api DEFAULT_INSTANCE = new com.google.protobuf.Api();
    private static final com.google.protobuf.Parser<com.google.protobuf.Api> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Api>() { // from class: com.google.protobuf.Api.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Api parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Api(codedInputStream, extensionRegistryLite);
        }
    };

    private Api(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Api() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.methods_ = java.util.Collections.emptyList();
        this.options_ = java.util.Collections.emptyList();
        this.version_ = "";
        this.mixins_ = java.util.Collections.emptyList();
        this.syntax_ = 0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Api();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Api(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                this.methods_ = new java.util.ArrayList();
                                i_renamed |= 1;
                            }
                            this.methods_.add(codedInputStream.readMessage(com.google.protobuf.Method.parser(), extensionRegistryLite));
                        } else if (tag == 26) {
                            if ((i_renamed & 2) == 0) {
                                this.options_ = new java.util.ArrayList();
                                i_renamed |= 2;
                            }
                            this.options_.add(codedInputStream.readMessage(com.google.protobuf.Option.parser(), extensionRegistryLite));
                        } else if (tag == 34) {
                            this.version_ = codedInputStream.readStringRequireUtf8();
                        } else if (tag == 42) {
                            com.google.protobuf.SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                            this.sourceContext_ = (com.google.protobuf.SourceContext) codedInputStream.readMessage(com.google.protobuf.SourceContext.parser(), extensionRegistryLite);
                            if (builder != null) {
                                builder.mergeFrom(this.sourceContext_);
                                this.sourceContext_ = builder.buildPartial();
                            }
                        } else if (tag == 50) {
                            if ((i_renamed & 4) == 0) {
                                this.mixins_ = new java.util.ArrayList();
                                i_renamed |= 4;
                            }
                            this.mixins_.add(codedInputStream.readMessage(com.google.protobuf.Mixin.parser(), extensionRegistryLite));
                        } else if (tag == 56) {
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
                    this.methods_ = java.util.Collections.unmodifiableList(this.methods_);
                }
                if ((i_renamed & 2) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                }
                if ((i_renamed & 4) != 0) {
                    this.mixins_ = java.util.Collections.unmodifiableList(this.mixins_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Api.class, com.google.protobuf.Api.Builder.class);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<com.google.protobuf.Method> getMethodsList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<? extends com.google.protobuf.MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.Method getMethods(int i_renamed) {
        return this.methods_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.MethodOrBuilder getMethodsOrBuilder(int i_renamed) {
        return this.methods_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<com.google.protobuf.Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.Option getOptions(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.lang.String getVersion() {
        java.lang.Object obj = this.version_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.version_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.ByteString getVersionBytes() {
        java.lang.Object obj = this.version_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.version_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.SourceContext getSourceContext() {
        com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<com.google.protobuf.Mixin> getMixinsList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public java.util.List<? extends com.google.protobuf.MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.Mixin getMixins(int i_renamed) {
        return this.mixins_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public com.google.protobuf.MixinOrBuilder getMixinsOrBuilder(int i_renamed) {
        return this.mixins_.get(i_renamed);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
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
        for (int i_renamed = 0; i_renamed < this.methods_.size(); i_renamed++) {
            codedOutputStream.writeMessage(2, this.methods_.get(i_renamed));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        if (!getVersionBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 4, this.version_);
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(7, this.syntax_);
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
        for (int i2 = 0; i2 < this.methods_.size(); i2++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(2, this.methods_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (!getVersionBytes().isEmpty()) {
            iComputeStringSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, this.version_);
        }
        if (this.sourceContext_ != null) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i4 = 0; i4 < this.mixins_.size(); i4++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(6, this.mixins_.get(i4));
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeEnumSize(7, this.syntax_);
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
        if (!(obj instanceof com.google.protobuf.Api)) {
            return super.equals(obj);
        }
        com.google.protobuf.Api api = (com.google.protobuf.Api) obj;
        if (getName().equals(api.getName()) && getMethodsList().equals(api.getMethodsList()) && getOptionsList().equals(api.getOptionsList()) && getVersion().equals(api.getVersion()) && hasSourceContext() == api.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(api.getSourceContext())) && getMixinsList().equals(api.getMixinsList()) && this.syntax_ == api.syntax_ && this.unknownFields.equals(api.unknownFields);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getMethodsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOptionsList().hashCode();
        }
        int iHashCode2 = (((iHashCode * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext()) {
            iHashCode2 = (((iHashCode2 * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        if (getMixinsCount() > 0) {
            iHashCode2 = (((iHashCode2 * 37) + 6) * 53) + getMixinsList().hashCode();
        }
        int iHashCode3 = (((((iHashCode2 * 37) + 7) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode3;
        return iHashCode3;
    }

    public static com.google.protobuf.Api parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Api parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Api parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Api parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Api parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Api parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Api parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Api parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Api parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Api parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Api parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Api parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Api) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Api.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Api.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Api.Builder newBuilder(com.google.protobuf.Api api) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Api.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Api.Builder() : new com.google.protobuf.Api.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Api.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Api.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Api.Builder> implements com.google.protobuf.ApiOrBuilder {
        private int bitField0_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> methodsBuilder_;
        private java.util.List<com.google.protobuf.Method> methods_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> mixinsBuilder_;
        private java.util.List<com.google.protobuf.Mixin> mixins_;
        private java.lang.Object name_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> optionsBuilder_;
        private java.util.List<com.google.protobuf.Option> options_;
        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> sourceContextBuilder_;
        private com.google.protobuf.SourceContext sourceContext_;
        private int syntax_;
        private java.lang.Object version_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Api.class, com.google.protobuf.Api.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.methods_ = java.util.Collections.emptyList();
            this.options_ = java.util.Collections.emptyList();
            this.version_ = "";
            this.mixins_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.methods_ = java.util.Collections.emptyList();
            this.options_ = java.util.Collections.emptyList();
            this.version_ = "";
            this.mixins_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getMethodsFieldBuilder();
                getOptionsFieldBuilder();
                getMixinsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder clear() {
            super.clear();
            this.name_ = "";
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.methods_ = java.util.Collections.emptyList();
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
            this.version_ = "";
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV33 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV33 == null) {
                this.mixins_ = java.util.Collections.emptyList();
                this.bitField0_ &= -5;
            } else {
                repeatedFieldBuilderV33.clear();
            }
            this.syntax_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Api getDefaultInstanceForType() {
            return com.google.protobuf.Api.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api build() {
            com.google.protobuf.Api apiBuildPartial = buildPartial();
            if (apiBuildPartial.isInitialized()) {
                return apiBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) apiBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api buildPartial() {
            com.google.protobuf.Api api = new com.google.protobuf.Api(this);
            int i_renamed = this.bitField0_;
            api.name_ = this.name_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                api.methods_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.methods_ = java.util.Collections.unmodifiableList(this.methods_);
                    this.bitField0_ &= -2;
                }
                api.methods_ = this.methods_;
            }
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                api.options_ = repeatedFieldBuilderV32.build();
            } else {
                if ((this.bitField0_ & 2) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -3;
                }
                api.options_ = this.options_;
            }
            api.version_ = this.version_;
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                api.sourceContext_ = this.sourceContext_;
            } else {
                api.sourceContext_ = (com.google.protobuf.SourceContext) singleFieldBuilderV3.build();
            }
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV33 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV33 != null) {
                api.mixins_ = repeatedFieldBuilderV33.build();
            } else {
                if ((this.bitField0_ & 4) != 0) {
                    this.mixins_ = java.util.Collections.unmodifiableList(this.mixins_);
                    this.bitField0_ &= -5;
                }
                api.mixins_ = this.mixins_;
            }
            api.syntax_ = this.syntax_;
            onBuilt();
            return api;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Api.Builder mo23clone() {
            return (com.google.protobuf.Api.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Api.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Api.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Api.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Api.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Api.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Api.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Api) {
                return mergeFrom((com.google.protobuf.Api) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Api.Builder mergeFrom(com.google.protobuf.Api api) {
            if (api == com.google.protobuf.Api.getDefaultInstance()) {
                return this;
            }
            if (!api.getName().isEmpty()) {
                this.name_ = api.name_;
                onChanged();
            }
            if (this.methodsBuilder_ == null) {
                if (!api.methods_.isEmpty()) {
                    if (this.methods_.isEmpty()) {
                        this.methods_ = api.methods_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMethodsIsMutable();
                        this.methods_.addAll(api.methods_);
                    }
                    onChanged();
                }
            } else if (!api.methods_.isEmpty()) {
                if (!this.methodsBuilder_.isEmpty()) {
                    this.methodsBuilder_.addAllMessages(api.methods_);
                } else {
                    this.methodsBuilder_.dispose();
                    this.methodsBuilder_ = null;
                    this.methods_ = api.methods_;
                    this.bitField0_ &= -2;
                    this.methodsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getMethodsFieldBuilder() : null;
                }
            }
            if (this.optionsBuilder_ == null) {
                if (!api.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = api.options_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(api.options_);
                    }
                    onChanged();
                }
            } else if (!api.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(api.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = api.options_;
                    this.bitField0_ &= -3;
                    this.optionsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (!api.getVersion().isEmpty()) {
                this.version_ = api.version_;
                onChanged();
            }
            if (api.hasSourceContext()) {
                mergeSourceContext(api.getSourceContext());
            }
            if (this.mixinsBuilder_ == null) {
                if (!api.mixins_.isEmpty()) {
                    if (this.mixins_.isEmpty()) {
                        this.mixins_ = api.mixins_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureMixinsIsMutable();
                        this.mixins_.addAll(api.mixins_);
                    }
                    onChanged();
                }
            } else if (!api.mixins_.isEmpty()) {
                if (!this.mixinsBuilder_.isEmpty()) {
                    this.mixinsBuilder_.addAllMessages(api.mixins_);
                } else {
                    this.mixinsBuilder_.dispose();
                    this.mixinsBuilder_ = null;
                    this.mixins_ = api.mixins_;
                    this.bitField0_ &= -5;
                    this.mixinsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getMixinsFieldBuilder() : null;
                }
            }
            if (api.syntax_ != 0) {
                setSyntaxValue(api.getSyntaxValue());
            }
            mergeUnknownFields(api.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Api.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Api.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Api r3 = (com.google.protobuf.Api) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Api r4 = (com.google.protobuf.Api) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Api.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Api$Builder");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Api.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Api.Builder clearName() {
            this.name_ = com.google.protobuf.Api.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Api.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.methods_ = new java.util.ArrayList(this.methods_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.util.List<com.google.protobuf.Method> getMethodsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.methods_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.Method getMethods(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.get(i_renamed);
            }
            return (com.google.protobuf.Method) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Api.Builder setMethods(int i_renamed, com.google.protobuf.Method method) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, method);
            } else {
                if (method == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMethodsIsMutable();
                this.methods_.set(i_renamed, method);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder setMethods(int i_renamed, com.google.protobuf.Method.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMethods(com.google.protobuf.Method method) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(method);
            } else {
                if (method == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMethodsIsMutable();
                this.methods_.add(method);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMethods(int i_renamed, com.google.protobuf.Method method) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, method);
            } else {
                if (method == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMethodsIsMutable();
                this.methods_.add(i_renamed, method);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMethods(com.google.protobuf.Method.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMethods(int i_renamed, com.google.protobuf.Method.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addAllMethods(java.lang.Iterable<? extends com.google.protobuf.Method> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.methods_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.Api.Builder clearMethods() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.methods_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder removeMethods(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMethodsIsMutable();
                this.methods_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.Method.Builder getMethodsBuilder(int i_renamed) {
            return (com.google.protobuf.Method.Builder) getMethodsFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.MethodOrBuilder getMethodsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.methods_.get(i_renamed);
            }
            return (com.google.protobuf.MethodOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.util.List<? extends com.google.protobuf.MethodOrBuilder> getMethodsOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> repeatedFieldBuilderV3 = this.methodsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.methods_);
        }

        public com.google.protobuf.Method.Builder addMethodsBuilder() {
            return (com.google.protobuf.Method.Builder) getMethodsFieldBuilder().addBuilder(com.google.protobuf.Method.getDefaultInstance());
        }

        public com.google.protobuf.Method.Builder addMethodsBuilder(int i_renamed) {
            return (com.google.protobuf.Method.Builder) getMethodsFieldBuilder().addBuilder(i_renamed, com.google.protobuf.Method.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.Method.Builder> getMethodsBuilderList() {
            return getMethodsFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Method, com.google.protobuf.Method.Builder, com.google.protobuf.MethodOrBuilder> getMethodsFieldBuilder() {
            if (this.methodsBuilder_ == null) {
                this.methodsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.methods_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.methods_ = null;
            }
            return this.methodsBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.options_ = new java.util.ArrayList(this.options_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.util.List<com.google.protobuf.Option> getOptionsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.Option getOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.Option) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Api.Builder setOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Api.Builder setOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Api.Builder addOptions(com.google.protobuf.Option option) {
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

        public com.google.protobuf.Api.Builder addOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Api.Builder addOptions(com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Api.Builder addOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Api.Builder addAllOptions(java.lang.Iterable<? extends com.google.protobuf.Option> iterable) {
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

        public com.google.protobuf.Api.Builder clearOptions() {
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

        public com.google.protobuf.Api.Builder removeOptions(int i_renamed) {
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

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.OptionOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ApiOrBuilder
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

        @Override // com.google.protobuf.ApiOrBuilder
        public java.lang.String getVersion() {
            java.lang.Object obj = this.version_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.version_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.ByteString getVersionBytes() {
            java.lang.Object obj = this.version_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.version_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Api.Builder setVersion(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.version_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Api.Builder clearVersion() {
            this.version_ = com.google.protobuf.Api.getDefaultInstance().getVersion();
            onChanged();
            return this;
        }

        public com.google.protobuf.Api.Builder setVersionBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.version_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return (this.sourceContextBuilder_ == null && this.sourceContext_ == null) ? false : true;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.SourceContext getSourceContext() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
                return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
            }
            return (com.google.protobuf.SourceContext) singleFieldBuilderV3.getMessage();
        }

        public com.google.protobuf.Api.Builder setSourceContext(com.google.protobuf.SourceContext sourceContext) {
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

        public com.google.protobuf.Api.Builder setSourceContext(com.google.protobuf.SourceContext.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sourceContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder mergeSourceContext(com.google.protobuf.SourceContext sourceContext) {
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

        public com.google.protobuf.Api.Builder clearSourceContext() {
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

        @Override // com.google.protobuf.ApiOrBuilder
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

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.mixins_ = new java.util.ArrayList(this.mixins_);
                this.bitField0_ |= 4;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.util.List<com.google.protobuf.Mixin> getMixinsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.mixins_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.Mixin getMixins(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.get(i_renamed);
            }
            return (com.google.protobuf.Mixin) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Api.Builder setMixins(int i_renamed, com.google.protobuf.Mixin mixin) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, mixin);
            } else {
                if (mixin == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMixinsIsMutable();
                this.mixins_.set(i_renamed, mixin);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder setMixins(int i_renamed, com.google.protobuf.Mixin.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMixins(com.google.protobuf.Mixin mixin) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(mixin);
            } else {
                if (mixin == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMixinsIsMutable();
                this.mixins_.add(mixin);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMixins(int i_renamed, com.google.protobuf.Mixin mixin) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, mixin);
            } else {
                if (mixin == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureMixinsIsMutable();
                this.mixins_.add(i_renamed, mixin);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMixins(com.google.protobuf.Mixin.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addMixins(int i_renamed, com.google.protobuf.Mixin.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Api.Builder addAllMixins(java.lang.Iterable<? extends com.google.protobuf.Mixin> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.mixins_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.Api.Builder clearMixins() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.mixins_ = java.util.Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Api.Builder removeMixins(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMixinsIsMutable();
                this.mixins_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.Mixin.Builder getMixinsBuilder(int i_renamed) {
            return (com.google.protobuf.Mixin.Builder) getMixinsFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.MixinOrBuilder getMixinsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.mixins_.get(i_renamed);
            }
            return (com.google.protobuf.MixinOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public java.util.List<? extends com.google.protobuf.MixinOrBuilder> getMixinsOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> repeatedFieldBuilderV3 = this.mixinsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.mixins_);
        }

        public com.google.protobuf.Mixin.Builder addMixinsBuilder() {
            return (com.google.protobuf.Mixin.Builder) getMixinsFieldBuilder().addBuilder(com.google.protobuf.Mixin.getDefaultInstance());
        }

        public com.google.protobuf.Mixin.Builder addMixinsBuilder(int i_renamed) {
            return (com.google.protobuf.Mixin.Builder) getMixinsFieldBuilder().addBuilder(i_renamed, com.google.protobuf.Mixin.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.Mixin.Builder> getMixinsBuilderList() {
            return getMixinsFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Mixin, com.google.protobuf.Mixin.Builder, com.google.protobuf.MixinOrBuilder> getMixinsFieldBuilder() {
            if (this.mixinsBuilder_ == null) {
                this.mixinsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.mixins_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.mixins_ = null;
            }
            return this.mixinsBuilder_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public com.google.protobuf.Api.Builder setSyntaxValue(int i_renamed) {
            this.syntax_ = i_renamed;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public com.google.protobuf.Syntax getSyntax() {
            com.google.protobuf.Syntax syntaxValueOf = com.google.protobuf.Syntax.valueOf(this.syntax_);
            return syntaxValueOf == null ? com.google.protobuf.Syntax.UNRECOGNIZED : syntaxValueOf;
        }

        public com.google.protobuf.Api.Builder setSyntax(com.google.protobuf.Syntax syntax) {
            if (syntax == null) {
                throw new java.lang.NullPointerException();
            }
            this.syntax_ = syntax.getNumber();
            onChanged();
            return this;
        }

        public com.google.protobuf.Api.Builder clearSyntax() {
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Api.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Api.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Api.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Api.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Api> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
