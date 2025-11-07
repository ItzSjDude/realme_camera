package com.google.protobuf;

/* loaded from: classes.dex */
public final class Type extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.TypeOrBuilder {
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private java.util.List<com.google.protobuf.Field> fields_;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private com.google.protobuf.LazyStringList oneofs_;
    private java.util.List<com.google.protobuf.Option> options_;
    private com.google.protobuf.SourceContext sourceContext_;
    private int syntax_;
    private static final com.google.protobuf.Type DEFAULT_INSTANCE = new com.google.protobuf.Type();
    private static final com.google.protobuf.Parser<com.google.protobuf.Type> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Type>() { // from class: com.google.protobuf.Type.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Type parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Type(codedInputStream, extensionRegistryLite);
        }
    };

    private Type(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Type() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.fields_ = java.util.Collections.emptyList();
        this.oneofs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        this.options_ = java.util.Collections.emptyList();
        this.syntax_ = 0;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Type();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Type(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                                this.fields_ = new java.util.ArrayList();
                                i_renamed |= 1;
                            }
                            this.fields_.add(codedInputStream.readMessage(com.google.protobuf.Field.parser(), extensionRegistryLite));
                        } else if (tag == 26) {
                            java.lang.String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if ((i_renamed & 2) == 0) {
                                this.oneofs_ = new com.google.protobuf.LazyStringArrayList();
                                i_renamed |= 2;
                            }
                            this.oneofs_.add(stringRequireUtf8);
                        } else if (tag == 34) {
                            if ((i_renamed & 4) == 0) {
                                this.options_ = new java.util.ArrayList();
                                i_renamed |= 4;
                            }
                            this.options_.add(codedInputStream.readMessage(com.google.protobuf.Option.parser(), extensionRegistryLite));
                        } else if (tag == 42) {
                            com.google.protobuf.SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                            this.sourceContext_ = (com.google.protobuf.SourceContext) codedInputStream.readMessage(com.google.protobuf.SourceContext.parser(), extensionRegistryLite);
                            if (builder != null) {
                                builder.mergeFrom(this.sourceContext_);
                                this.sourceContext_ = builder.buildPartial();
                            }
                        } else if (tag == 48) {
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
                    this.fields_ = java.util.Collections.unmodifiableList(this.fields_);
                }
                if ((i_renamed & 2) != 0) {
                    this.oneofs_ = this.oneofs_.getUnmodifiableView();
                }
                if ((i_renamed & 4) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Type_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Type.class, com.google.protobuf.Type.Builder.class);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.util.List<com.google.protobuf.Field> getFieldsList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.util.List<? extends com.google.protobuf.FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.Field getFields(int i_renamed) {
        return this.fields_.get(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.FieldOrBuilder getFieldsOrBuilder(int i_renamed) {
        return this.fields_.get(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.ProtocolStringList getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.lang.String getOneofs(int i_renamed) {
        return (java.lang.String) this.oneofs_.get(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.ByteString getOneofsBytes(int i_renamed) {
        return this.oneofs_.getByteString(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.util.List<com.google.protobuf.Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.Option getOptions(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.SourceContext getSourceContext() {
        com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public com.google.protobuf.SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
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
        for (int i_renamed = 0; i_renamed < this.fields_.size(); i_renamed++) {
            codedOutputStream.writeMessage(2, this.fields_.get(i_renamed));
        }
        for (int i2 = 0; i2 < this.oneofs_.size(); i2++) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 3, this.oneofs_.getRaw(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            codedOutputStream.writeMessage(4, this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(6, this.syntax_);
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
        for (int i2 = 0; i2 < this.fields_.size(); i2++) {
            iComputeStringSize += com.google.protobuf.CodedOutputStream.computeMessageSize(2, this.fields_.get(i2));
        }
        int iComputeStringSizeNoTag = 0;
        for (int i3 = 0; i3 < this.oneofs_.size(); i3++) {
            iComputeStringSizeNoTag += computeStringSizeNoTag(this.oneofs_.getRaw(i3));
        }
        int size = iComputeStringSize + iComputeStringSizeNoTag + (getOneofsList().size() * 1);
        for (int i4 = 0; i4 < this.options_.size(); i4++) {
            size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, this.options_.get(i4));
        }
        if (this.sourceContext_ != null) {
            size += com.google.protobuf.CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        if (this.syntax_ != com.google.protobuf.Syntax.SYNTAX_PROTO2.getNumber()) {
            size += com.google.protobuf.CodedOutputStream.computeEnumSize(6, this.syntax_);
        }
        int serializedSize = size + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.Type)) {
            return super.equals(obj);
        }
        com.google.protobuf.Type type = (com.google.protobuf.Type) obj;
        if (getName().equals(type.getName()) && getFieldsList().equals(type.getFieldsList()) && getOneofsList().equals(type.getOneofsList()) && getOptionsList().equals(type.getOptionsList()) && hasSourceContext() == type.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(type.getSourceContext())) && this.syntax_ == type.syntax_ && this.unknownFields.equals(type.unknownFields);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getFieldsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getFieldsList().hashCode();
        }
        if (getOneofsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getOneofsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 4) * 53) + getOptionsList().hashCode();
        }
        if (hasSourceContext()) {
            iHashCode = (((iHashCode * 37) + 5) * 53) + getSourceContext().hashCode();
        }
        int iHashCode2 = (((((iHashCode * 37) + 6) * 53) + this.syntax_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.Type parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Type parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Type parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Type parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Type parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Type parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Type parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Type parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Type parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Type parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Type parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Type parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Type) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Type.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Type.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Type.Builder newBuilder(com.google.protobuf.Type type) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(type);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Type.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Type.Builder() : new com.google.protobuf.Type.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Type.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Type.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Type.Builder> implements com.google.protobuf.TypeOrBuilder {
        private int bitField0_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> fieldsBuilder_;
        private java.util.List<com.google.protobuf.Field> fields_;
        private java.lang.Object name_;
        private com.google.protobuf.LazyStringList oneofs_;
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
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Type.class, com.google.protobuf.Type.Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.fields_ = java.util.Collections.emptyList();
            this.oneofs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.options_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.fields_ = java.util.Collections.emptyList();
            this.oneofs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.options_ = java.util.Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getFieldsFieldBuilder();
                getOptionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder clear() {
            super.clear();
            this.name_ = "";
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.fields_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.oneofs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -5;
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
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Type_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Type getDefaultInstanceForType() {
            return com.google.protobuf.Type.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type build() {
            com.google.protobuf.Type typeBuildPartial = buildPartial();
            if (typeBuildPartial.isInitialized()) {
                return typeBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) typeBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type buildPartial() {
            com.google.protobuf.Type type = new com.google.protobuf.Type(this);
            int i_renamed = this.bitField0_;
            type.name_ = this.name_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                type.fields_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.fields_ = java.util.Collections.unmodifiableList(this.fields_);
                    this.bitField0_ &= -2;
                }
                type.fields_ = this.fields_;
            }
            if ((this.bitField0_ & 2) != 0) {
                this.oneofs_ = this.oneofs_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            type.oneofs_ = this.oneofs_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV32 = this.optionsBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                type.options_ = repeatedFieldBuilderV32.build();
            } else {
                if ((this.bitField0_ & 4) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -5;
                }
                type.options_ = this.options_;
            }
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                type.sourceContext_ = this.sourceContext_;
            } else {
                type.sourceContext_ = (com.google.protobuf.SourceContext) singleFieldBuilderV3.build();
            }
            type.syntax_ = this.syntax_;
            onBuilt();
            return type;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Type.Builder mo23clone() {
            return (com.google.protobuf.Type.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Type.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Type.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Type.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Type.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Type.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Type.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Type) {
                return mergeFrom((com.google.protobuf.Type) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Type.Builder mergeFrom(com.google.protobuf.Type type) {
            if (type == com.google.protobuf.Type.getDefaultInstance()) {
                return this;
            }
            if (!type.getName().isEmpty()) {
                this.name_ = type.name_;
                onChanged();
            }
            if (this.fieldsBuilder_ == null) {
                if (!type.fields_.isEmpty()) {
                    if (this.fields_.isEmpty()) {
                        this.fields_ = type.fields_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFieldsIsMutable();
                        this.fields_.addAll(type.fields_);
                    }
                    onChanged();
                }
            } else if (!type.fields_.isEmpty()) {
                if (!this.fieldsBuilder_.isEmpty()) {
                    this.fieldsBuilder_.addAllMessages(type.fields_);
                } else {
                    this.fieldsBuilder_.dispose();
                    this.fieldsBuilder_ = null;
                    this.fields_ = type.fields_;
                    this.bitField0_ &= -2;
                    this.fieldsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getFieldsFieldBuilder() : null;
                }
            }
            if (!type.oneofs_.isEmpty()) {
                if (this.oneofs_.isEmpty()) {
                    this.oneofs_ = type.oneofs_;
                    this.bitField0_ &= -3;
                } else {
                    ensureOneofsIsMutable();
                    this.oneofs_.addAll(type.oneofs_);
                }
                onChanged();
            }
            if (this.optionsBuilder_ == null) {
                if (!type.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = type.options_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(type.options_);
                    }
                    onChanged();
                }
            } else if (!type.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(type.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = type.options_;
                    this.bitField0_ &= -5;
                    this.optionsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (type.hasSourceContext()) {
                mergeSourceContext(type.getSourceContext());
            }
            if (type.syntax_ != 0) {
                setSyntaxValue(type.getSyntaxValue());
            }
            mergeUnknownFields(type.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Type.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Type.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Type r3 = (com.google.protobuf.Type) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Type r4 = (com.google.protobuf.Type) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Type.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Type$Builder");
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Type.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder clearName() {
            this.name_ = com.google.protobuf.Type.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        private void ensureFieldsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.fields_ = new java.util.ArrayList(this.fields_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public java.util.List<com.google.protobuf.Field> getFieldsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.fields_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.fields_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.Field getFields(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.fields_.get(i_renamed);
            }
            return (com.google.protobuf.Field) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Type.Builder setFields(int i_renamed, com.google.protobuf.Field field) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i_renamed, field);
            } else {
                if (field == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFieldsIsMutable();
                this.fields_.set(i_renamed, field);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Type.Builder setFields(int i_renamed, com.google.protobuf.Field.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureFieldsIsMutable();
                this.fields_.set(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Type.Builder addFields(com.google.protobuf.Field field) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(field);
            } else {
                if (field == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFieldsIsMutable();
                this.fields_.add(field);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Type.Builder addFields(int i_renamed, com.google.protobuf.Field field) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i_renamed, field);
            } else {
                if (field == null) {
                    throw new java.lang.NullPointerException();
                }
                ensureFieldsIsMutable();
                this.fields_.add(i_renamed, field);
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Type.Builder addFields(com.google.protobuf.Field.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureFieldsIsMutable();
                this.fields_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Type.Builder addFields(int i_renamed, com.google.protobuf.Field.Builder builder) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureFieldsIsMutable();
                this.fields_.add(i_renamed, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i_renamed, builder.build());
            }
            return this;
        }

        public com.google.protobuf.Type.Builder addAllFields(java.lang.Iterable<? extends com.google.protobuf.Field> iterable) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureFieldsIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.fields_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public com.google.protobuf.Type.Builder clearFields() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.fields_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Type.Builder removeFields(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureFieldsIsMutable();
                this.fields_.remove(i_renamed);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i_renamed);
            }
            return this;
        }

        public com.google.protobuf.Field.Builder getFieldsBuilder(int i_renamed) {
            return (com.google.protobuf.Field.Builder) getFieldsFieldBuilder().getBuilder(i_renamed);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.FieldOrBuilder getFieldsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.fields_.get(i_renamed);
            }
            return (com.google.protobuf.FieldOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public java.util.List<? extends com.google.protobuf.FieldOrBuilder> getFieldsOrBuilderList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> repeatedFieldBuilderV3 = this.fieldsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return java.util.Collections.unmodifiableList(this.fields_);
        }

        public com.google.protobuf.Field.Builder addFieldsBuilder() {
            return (com.google.protobuf.Field.Builder) getFieldsFieldBuilder().addBuilder(com.google.protobuf.Field.getDefaultInstance());
        }

        public com.google.protobuf.Field.Builder addFieldsBuilder(int i_renamed) {
            return (com.google.protobuf.Field.Builder) getFieldsFieldBuilder().addBuilder(i_renamed, com.google.protobuf.Field.getDefaultInstance());
        }

        public java.util.List<com.google.protobuf.Field.Builder> getFieldsBuilderList() {
            return getFieldsFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Field, com.google.protobuf.Field.Builder, com.google.protobuf.FieldOrBuilder> getFieldsFieldBuilder() {
            if (this.fieldsBuilder_ == null) {
                this.fieldsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.fields_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.fields_ = null;
            }
            return this.fieldsBuilder_;
        }

        private void ensureOneofsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.oneofs_ = new com.google.protobuf.LazyStringArrayList(this.oneofs_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.ProtocolStringList getOneofsList() {
            return this.oneofs_.getUnmodifiableView();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return this.oneofs_.size();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public java.lang.String getOneofs(int i_renamed) {
            return (java.lang.String) this.oneofs_.get(i_renamed);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.ByteString getOneofsBytes(int i_renamed) {
            return this.oneofs_.getByteString(i_renamed);
        }

        public com.google.protobuf.Type.Builder setOneofs(int i_renamed, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            ensureOneofsIsMutable();
            this.oneofs_.set(i_renamed, str);
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder addOneofs(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            ensureOneofsIsMutable();
            this.oneofs_.add(str);
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder addAllOneofs(java.lang.Iterable<java.lang.String> iterable) {
            ensureOneofsIsMutable();
            com.google.protobuf.AbstractMessageLite.Builder.addAll((java.lang.Iterable) iterable, (java.util.List) this.oneofs_);
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder clearOneofs() {
            this.oneofs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder addOneofsBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureOneofsIsMutable();
            this.oneofs_.add(byteString);
            onChanged();
            return this;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.options_ = new java.util.ArrayList(this.options_);
                this.bitField0_ |= 4;
            }
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public java.util.List<com.google.protobuf.Option> getOptionsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.Option getOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.Option) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Type.Builder setOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Type.Builder setOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Type.Builder addOptions(com.google.protobuf.Option option) {
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

        public com.google.protobuf.Type.Builder addOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Type.Builder addOptions(com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Type.Builder addOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Type.Builder addAllOptions(java.lang.Iterable<? extends com.google.protobuf.Option> iterable) {
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

        public com.google.protobuf.Type.Builder clearOptions() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public com.google.protobuf.Type.Builder removeOptions(int i_renamed) {
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

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.OptionOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.TypeOrBuilder
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
                this.optionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return (this.sourceContextBuilder_ == null && this.sourceContext_ == null) ? false : true;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.SourceContext getSourceContext() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                com.google.protobuf.SourceContext sourceContext = this.sourceContext_;
                return sourceContext == null ? com.google.protobuf.SourceContext.getDefaultInstance() : sourceContext;
            }
            return (com.google.protobuf.SourceContext) singleFieldBuilderV3.getMessage();
        }

        public com.google.protobuf.Type.Builder setSourceContext(com.google.protobuf.SourceContext sourceContext) {
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

        public com.google.protobuf.Type.Builder setSourceContext(com.google.protobuf.SourceContext.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.SourceContext, com.google.protobuf.SourceContext.Builder, com.google.protobuf.SourceContextOrBuilder> singleFieldBuilderV3 = this.sourceContextBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sourceContext_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public com.google.protobuf.Type.Builder mergeSourceContext(com.google.protobuf.SourceContext sourceContext) {
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

        public com.google.protobuf.Type.Builder clearSourceContext() {
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

        @Override // com.google.protobuf.TypeOrBuilder
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

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public com.google.protobuf.Type.Builder setSyntaxValue(int i_renamed) {
            this.syntax_ = i_renamed;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public com.google.protobuf.Syntax getSyntax() {
            com.google.protobuf.Syntax syntaxValueOf = com.google.protobuf.Syntax.valueOf(this.syntax_);
            return syntaxValueOf == null ? com.google.protobuf.Syntax.UNRECOGNIZED : syntaxValueOf;
        }

        public com.google.protobuf.Type.Builder setSyntax(com.google.protobuf.Syntax syntax) {
            if (syntax == null) {
                throw new java.lang.NullPointerException();
            }
            this.syntax_ = syntax.getNumber();
            onChanged();
            return this;
        }

        public com.google.protobuf.Type.Builder clearSyntax() {
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Type.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Type.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Type.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Type.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Type> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Type> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Type getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
