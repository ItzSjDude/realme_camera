package com.google.protobuf;

/* loaded from: classes.dex */
public final class Value extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private java.lang.Object kind_;
    private byte memoizedIsInitialized;
    private static final com.google.protobuf.Value DEFAULT_INSTANCE = new com.google.protobuf.Value();
    private static final com.google.protobuf.Parser<com.google.protobuf.Value> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Value>() { // from class: com.google.protobuf.Value.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Value parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Value(codedInputStream, extensionRegistryLite);
        }
    };

    private Value(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Value();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Value(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                            if (tag == 8) {
                                int i_renamed = codedInputStream.readEnum();
                                this.kindCase_ = 1;
                                this.kind_ = java.lang.Integer.valueOf(i_renamed);
                            } else if (tag == 17) {
                                this.kindCase_ = 2;
                                this.kind_ = java.lang.Double.valueOf(codedInputStream.readDouble());
                            } else if (tag == 26) {
                                java.lang.String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.kindCase_ = 3;
                                this.kind_ = stringRequireUtf8;
                            } else if (tag != 32) {
                                if (tag == 42) {
                                    com.google.protobuf.Struct.Builder builder = this.kindCase_ == 5 ? ((com.google.protobuf.Struct) this.kind_).toBuilder() : null;
                                    this.kind_ = codedInputStream.readMessage(com.google.protobuf.Struct.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((com.google.protobuf.Struct) this.kind_);
                                        this.kind_ = builder.buildPartial();
                                    }
                                    this.kindCase_ = 5;
                                } else if (tag == 50) {
                                    com.google.protobuf.ListValue.Builder builder2 = this.kindCase_ == 6 ? ((com.google.protobuf.ListValue) this.kind_).toBuilder() : null;
                                    this.kind_ = codedInputStream.readMessage(com.google.protobuf.ListValue.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((com.google.protobuf.ListValue) this.kind_);
                                        this.kind_ = builder2.buildPartial();
                                    }
                                    this.kindCase_ = 6;
                                } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.kindCase_ = 4;
                                this.kind_ = java.lang.Boolean.valueOf(codedInputStream.readBool());
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
        return com.google.protobuf.StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Value.class, com.google.protobuf.Value.Builder.class);
    }

    public enum KindCase implements com.google.protobuf.AbstractMessageLite.InternalOneOfEnum, com.google.protobuf.Internal.EnumLite {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);

        private final int value;

        KindCase(int i_renamed) {
            this.value = i_renamed;
        }

        @java.lang.Deprecated
        public static com.google.protobuf.Value.KindCase valueOf(int i_renamed) {
            return forNumber(i_renamed);
        }

        public static com.google.protobuf.Value.KindCase forNumber(int i_renamed) {
            switch (i_renamed) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.AbstractMessageLite.InternalOneOfEnum, com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.Value.KindCase getKindCase() {
        return com.google.protobuf.Value.KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((java.lang.Integer) this.kind_).intValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.NullValue getNullValue() {
        if (this.kindCase_ == 1) {
            com.google.protobuf.NullValue nullValueValueOf = com.google.protobuf.NullValue.valueOf(((java.lang.Integer) this.kind_).intValue());
            return nullValueValueOf == null ? com.google.protobuf.NullValue.UNRECOGNIZED : nullValueValueOf;
        }
        return com.google.protobuf.NullValue.NULL_VALUE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((java.lang.Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public java.lang.String getStringValue() {
        java.lang.String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (str instanceof java.lang.String) {
            return (java.lang.String) str;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) str).toStringUtf8();
        if (this.kindCase_ == 3) {
            this.kind_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.ByteString getStringValueBytes() {
        java.lang.String str = this.kindCase_ == 3 ? this.kind_ : "";
        if (str instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) str);
            if (this.kindCase_ == 3) {
                this.kind_ = byteStringCopyFromUtf8;
            }
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) str;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((java.lang.Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        return this.kindCase_ == 5;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.Struct getStructValue() {
        if (this.kindCase_ == 5) {
            return (com.google.protobuf.Struct) this.kind_;
        }
        return com.google.protobuf.Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ == 5) {
            return (com.google.protobuf.Struct) this.kind_;
        }
        return com.google.protobuf.Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.ListValue getListValue() {
        if (this.kindCase_ == 6) {
            return (com.google.protobuf.ListValue) this.kind_;
        }
        return com.google.protobuf.ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public com.google.protobuf.ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ == 6) {
            return (com.google.protobuf.ListValue) this.kind_;
        }
        return com.google.protobuf.ListValue.getDefaultInstance();
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
        if (this.kindCase_ == 1) {
            codedOutputStream.writeEnum(1, ((java.lang.Integer) this.kind_).intValue());
        }
        if (this.kindCase_ == 2) {
            codedOutputStream.writeDouble(2, ((java.lang.Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            codedOutputStream.writeBool(4, ((java.lang.Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            codedOutputStream.writeMessage(5, (com.google.protobuf.Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            codedOutputStream.writeMessage(6, (com.google.protobuf.ListValue) this.kind_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeEnumSize = this.kindCase_ == 1 ? 0 + com.google.protobuf.CodedOutputStream.computeEnumSize(1, ((java.lang.Integer) this.kind_).intValue()) : 0;
        if (this.kindCase_ == 2) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeDoubleSize(2, ((java.lang.Double) this.kind_).doubleValue());
        }
        if (this.kindCase_ == 3) {
            iComputeEnumSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, this.kind_);
        }
        if (this.kindCase_ == 4) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeBoolSize(4, ((java.lang.Boolean) this.kind_).booleanValue());
        }
        if (this.kindCase_ == 5) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeMessageSize(5, (com.google.protobuf.Struct) this.kind_);
        }
        if (this.kindCase_ == 6) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeMessageSize(6, (com.google.protobuf.ListValue) this.kind_);
        }
        int serializedSize = iComputeEnumSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.Value)) {
            return super.equals(obj);
        }
        com.google.protobuf.Value value = (com.google.protobuf.Value) obj;
        if (!getKindCase().equals(value.getKindCase())) {
            return false;
        }
        switch (this.kindCase_) {
            case 1:
                if (getNullValueValue() != value.getNullValueValue()) {
                    return false;
                }
                break;
            case 2:
                if (java.lang.Double.doubleToLongBits(getNumberValue()) != java.lang.Double.doubleToLongBits(value.getNumberValue())) {
                    return false;
                }
                break;
            case 3:
                if (!getStringValue().equals(value.getStringValue())) {
                    return false;
                }
                break;
            case 4:
                if (getBoolValue() != value.getBoolValue()) {
                    return false;
                }
                break;
            case 5:
                if (!getStructValue().equals(value.getStructValue())) {
                    return false;
                }
                break;
            case 6:
                if (!getListValue().equals(value.getListValue())) {
                    return false;
                }
                break;
        }
        return this.unknownFields.equals(value.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i_renamed;
        int nullValueValue;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        switch (this.kindCase_) {
            case 1:
                i_renamed = ((iHashCode * 37) + 1) * 53;
                nullValueValue = getNullValueValue();
                break;
            case 2:
                i_renamed = ((iHashCode * 37) + 2) * 53;
                nullValueValue = com.google.protobuf.Internal.hashLong(java.lang.Double.doubleToLongBits(getNumberValue()));
                break;
            case 3:
                i_renamed = ((iHashCode * 37) + 3) * 53;
                nullValueValue = getStringValue().hashCode();
                break;
            case 4:
                i_renamed = ((iHashCode * 37) + 4) * 53;
                nullValueValue = com.google.protobuf.Internal.hashBoolean(getBoolValue());
                break;
            case 5:
                i_renamed = ((iHashCode * 37) + 5) * 53;
                nullValueValue = getStructValue().hashCode();
                break;
            case 6:
                i_renamed = ((iHashCode * 37) + 6) * 53;
                nullValueValue = getListValue().hashCode();
                break;
            default:
                int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = iHashCode2;
                return iHashCode2;
        }
        iHashCode = i_renamed + nullValueValue;
        int iHashCode22 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode22;
        return iHashCode22;
    }

    public static com.google.protobuf.Value parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Value parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Value parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Value parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Value parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Value parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Value parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Value parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Value parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Value parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Value parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Value parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Value) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Value.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Value.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Value.Builder newBuilder(com.google.protobuf.Value value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Value.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Value.Builder() : new com.google.protobuf.Value.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Value.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Value.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Value.Builder> implements com.google.protobuf.ValueOrBuilder {
        private int kindCase_;
        private java.lang.Object kind_;
        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> listValueBuilder_;
        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> structValueBuilder_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Value.class, com.google.protobuf.Value.Builder.class);
        }

        private Builder() {
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean z_renamed = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder clear() {
            super.clear();
            this.kindCase_ = 0;
            this.kind_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Value getDefaultInstanceForType() {
            return com.google.protobuf.Value.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value build() {
            com.google.protobuf.Value valueBuildPartial = buildPartial();
            if (valueBuildPartial.isInitialized()) {
                return valueBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) valueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value buildPartial() {
            com.google.protobuf.Value value = new com.google.protobuf.Value(this);
            if (this.kindCase_ == 1) {
                value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 2) {
                value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 3) {
                value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 4) {
                value.kind_ = this.kind_;
            }
            if (this.kindCase_ == 5) {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
                if (singleFieldBuilderV3 == null) {
                    value.kind_ = this.kind_;
                } else {
                    value.kind_ = singleFieldBuilderV3.build();
                }
            }
            if (this.kindCase_ == 6) {
                com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV32 = this.listValueBuilder_;
                if (singleFieldBuilderV32 == null) {
                    value.kind_ = this.kind_;
                } else {
                    value.kind_ = singleFieldBuilderV32.build();
                }
            }
            value.kindCase_ = this.kindCase_;
            onBuilt();
            return value;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Value.Builder mo23clone() {
            return (com.google.protobuf.Value.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Value.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Value.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Value.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Value.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Value.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Value.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Value) {
                return mergeFrom((com.google.protobuf.Value) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Value.Builder mergeFrom(com.google.protobuf.Value value) {
            if (value == com.google.protobuf.Value.getDefaultInstance()) {
                return this;
            }
            switch (value.getKindCase()) {
                case NULL_VALUE:
                    setNullValueValue(value.getNullValueValue());
                    break;
                case NUMBER_VALUE:
                    setNumberValue(value.getNumberValue());
                    break;
                case STRING_VALUE:
                    this.kindCase_ = 3;
                    this.kind_ = value.kind_;
                    onChanged();
                    break;
                case BOOL_VALUE:
                    setBoolValue(value.getBoolValue());
                    break;
                case STRUCT_VALUE:
                    mergeStructValue(value.getStructValue());
                    break;
                case LIST_VALUE:
                    mergeListValue(value.getListValue());
                    break;
            }
            mergeUnknownFields(value.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Value.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Value.access$500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Value r3 = (com.google.protobuf.Value) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Value r4 = (com.google.protobuf.Value) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Value.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Value$Builder");
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.Value.KindCase getKindCase() {
            return com.google.protobuf.Value.KindCase.forNumber(this.kindCase_);
        }

        public com.google.protobuf.Value.Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            if (this.kindCase_ == 1) {
                return ((java.lang.Integer) this.kind_).intValue();
            }
            return 0;
        }

        public com.google.protobuf.Value.Builder setNullValueValue(int i_renamed) {
            this.kindCase_ = 1;
            this.kind_ = java.lang.Integer.valueOf(i_renamed);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.NullValue getNullValue() {
            if (this.kindCase_ == 1) {
                com.google.protobuf.NullValue nullValueValueOf = com.google.protobuf.NullValue.valueOf(((java.lang.Integer) this.kind_).intValue());
                return nullValueValueOf == null ? com.google.protobuf.NullValue.UNRECOGNIZED : nullValueValueOf;
            }
            return com.google.protobuf.NullValue.NULL_VALUE;
        }

        public com.google.protobuf.Value.Builder setNullValue(com.google.protobuf.NullValue nullValue) {
            if (nullValue == null) {
                throw new java.lang.NullPointerException();
            }
            this.kindCase_ = 1;
            this.kind_ = java.lang.Integer.valueOf(nullValue.getNumber());
            onChanged();
            return this;
        }

        public com.google.protobuf.Value.Builder clearNullValue() {
            if (this.kindCase_ == 1) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) {
                return ((java.lang.Double) this.kind_).doubleValue();
            }
            return 0.0d;
        }

        public com.google.protobuf.Value.Builder setNumberValue(double d_renamed) {
            this.kindCase_ = 2;
            this.kind_ = java.lang.Double.valueOf(d_renamed);
            onChanged();
            return this;
        }

        public com.google.protobuf.Value.Builder clearNumberValue() {
            if (this.kindCase_ == 2) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public java.lang.String getStringValue() {
            java.lang.String str = this.kindCase_ == 3 ? this.kind_ : "";
            if (!(str instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) str).toStringUtf8();
                if (this.kindCase_ == 3) {
                    this.kind_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (java.lang.String) str;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.ByteString getStringValueBytes() {
            java.lang.String str = this.kindCase_ == 3 ? this.kind_ : "";
            if (str instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) str);
                if (this.kindCase_ == 3) {
                    this.kind_ = byteStringCopyFromUtf8;
                }
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) str;
        }

        public com.google.protobuf.Value.Builder setStringValue(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.kindCase_ = 3;
            this.kind_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Value.Builder clearStringValue() {
            if (this.kindCase_ == 3) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        public com.google.protobuf.Value.Builder setStringValueBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.kindCase_ = 3;
            this.kind_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) {
                return ((java.lang.Boolean) this.kind_).booleanValue();
            }
            return false;
        }

        public com.google.protobuf.Value.Builder setBoolValue(boolean z_renamed) {
            this.kindCase_ = 4;
            this.kind_ = java.lang.Boolean.valueOf(z_renamed);
            onChanged();
            return this;
        }

        public com.google.protobuf.Value.Builder clearBoolValue() {
            if (this.kindCase_ == 4) {
                this.kindCase_ = 0;
                this.kind_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            return this.kindCase_ == 5;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.Struct getStructValue() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 5) {
                    return (com.google.protobuf.Struct) this.kind_;
                }
                return com.google.protobuf.Struct.getDefaultInstance();
            }
            if (this.kindCase_ == 5) {
                return (com.google.protobuf.Struct) singleFieldBuilderV3.getMessage();
            }
            return com.google.protobuf.Struct.getDefaultInstance();
        }

        public com.google.protobuf.Value.Builder setStructValue(com.google.protobuf.Struct struct) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(struct);
            } else {
                if (struct == null) {
                    throw new java.lang.NullPointerException();
                }
                this.kind_ = struct;
                onChanged();
            }
            this.kindCase_ = 5;
            return this;
        }

        public com.google.protobuf.Value.Builder setStructValue(com.google.protobuf.Struct.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.kind_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.kindCase_ = 5;
            return this;
        }

        public com.google.protobuf.Value.Builder mergeStructValue(com.google.protobuf.Struct struct) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3 = this.structValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 5 && this.kind_ != com.google.protobuf.Struct.getDefaultInstance()) {
                    this.kind_ = com.google.protobuf.Struct.newBuilder((com.google.protobuf.Struct) this.kind_).mergeFrom(struct).buildPartial();
                } else {
                    this.kind_ = struct;
                }
                onChanged();
            } else {
                if (this.kindCase_ == 5) {
                    singleFieldBuilderV3.mergeFrom(struct);
                }
                this.structValueBuilder_.setMessage(struct);
            }
            this.kindCase_ = 5;
            return this;
        }

        public com.google.protobuf.Value.Builder clearStructValue() {
            if (this.structValueBuilder_ == null) {
                if (this.kindCase_ == 5) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                    onChanged();
                }
            } else {
                if (this.kindCase_ == 5) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                }
                this.structValueBuilder_.clear();
            }
            return this;
        }

        public com.google.protobuf.Struct.Builder getStructValueBuilder() {
            return (com.google.protobuf.Struct.Builder) getStructValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.StructOrBuilder getStructValueOrBuilder() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> singleFieldBuilderV3;
            if (this.kindCase_ == 5 && (singleFieldBuilderV3 = this.structValueBuilder_) != null) {
                return (com.google.protobuf.StructOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (this.kindCase_ == 5) {
                return (com.google.protobuf.Struct) this.kind_;
            }
            return com.google.protobuf.Struct.getDefaultInstance();
        }

        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> getStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) {
                if (this.kindCase_ != 5) {
                    this.kind_ = com.google.protobuf.Struct.getDefaultInstance();
                }
                this.structValueBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>((com.google.protobuf.Struct) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            return this.kindCase_ == 6;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.ListValue getListValue() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 6) {
                    return (com.google.protobuf.ListValue) this.kind_;
                }
                return com.google.protobuf.ListValue.getDefaultInstance();
            }
            if (this.kindCase_ == 6) {
                return (com.google.protobuf.ListValue) singleFieldBuilderV3.getMessage();
            }
            return com.google.protobuf.ListValue.getDefaultInstance();
        }

        public com.google.protobuf.Value.Builder setListValue(com.google.protobuf.ListValue listValue) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(listValue);
            } else {
                if (listValue == null) {
                    throw new java.lang.NullPointerException();
                }
                this.kind_ = listValue;
                onChanged();
            }
            this.kindCase_ = 6;
            return this;
        }

        public com.google.protobuf.Value.Builder setListValue(com.google.protobuf.ListValue.Builder builder) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.kind_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.kindCase_ = 6;
            return this;
        }

        public com.google.protobuf.Value.Builder mergeListValue(com.google.protobuf.ListValue listValue) {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV3 = this.listValueBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.kindCase_ == 6 && this.kind_ != com.google.protobuf.ListValue.getDefaultInstance()) {
                    this.kind_ = com.google.protobuf.ListValue.newBuilder((com.google.protobuf.ListValue) this.kind_).mergeFrom(listValue).buildPartial();
                } else {
                    this.kind_ = listValue;
                }
                onChanged();
            } else {
                if (this.kindCase_ == 6) {
                    singleFieldBuilderV3.mergeFrom(listValue);
                }
                this.listValueBuilder_.setMessage(listValue);
            }
            this.kindCase_ = 6;
            return this;
        }

        public com.google.protobuf.Value.Builder clearListValue() {
            if (this.listValueBuilder_ == null) {
                if (this.kindCase_ == 6) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                    onChanged();
                }
            } else {
                if (this.kindCase_ == 6) {
                    this.kindCase_ = 0;
                    this.kind_ = null;
                }
                this.listValueBuilder_.clear();
            }
            return this;
        }

        public com.google.protobuf.ListValue.Builder getListValueBuilder() {
            return (com.google.protobuf.ListValue.Builder) getListValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public com.google.protobuf.ListValueOrBuilder getListValueOrBuilder() {
            com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> singleFieldBuilderV3;
            if (this.kindCase_ == 6 && (singleFieldBuilderV3 = this.listValueBuilder_) != null) {
                return (com.google.protobuf.ListValueOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (this.kindCase_ == 6) {
                return (com.google.protobuf.ListValue) this.kind_;
            }
            return com.google.protobuf.ListValue.getDefaultInstance();
        }

        private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.ListValue, com.google.protobuf.ListValue.Builder, com.google.protobuf.ListValueOrBuilder> getListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) {
                if (this.kindCase_ != 6) {
                    this.kind_ = com.google.protobuf.ListValue.getDefaultInstance();
                }
                this.listValueBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<>((com.google.protobuf.ListValue) this.kind_, getParentForChildren(), isClean());
                this.kind_ = null;
            }
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Value.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Value.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Value.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Value.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Value> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
