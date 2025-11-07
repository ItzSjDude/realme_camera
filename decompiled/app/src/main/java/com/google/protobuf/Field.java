package com.google.protobuf;

/* loaded from: classes.dex */
public final class Field extends com.google.protobuf.GeneratedMessageV3 implements com.google.protobuf.FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int cardinality_;
    private volatile java.lang.Object defaultValue_;
    private volatile java.lang.Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile java.lang.Object name_;
    private int number_;
    private int oneofIndex_;
    private java.util.List<com.google.protobuf.Option> options_;
    private boolean packed_;
    private volatile java.lang.Object typeUrl_;
    private static final com.google.protobuf.Field DEFAULT_INSTANCE = new com.google.protobuf.Field();
    private static final com.google.protobuf.Parser<com.google.protobuf.Field> PARSER = new com.google.protobuf.AbstractParser<com.google.protobuf.Field>() { // from class: com.google.protobuf.Field.1
        @Override // com.google.protobuf.Parser
        public com.google.protobuf.Field parsePartialFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
            return new com.google.protobuf.Field(codedInputStream, extensionRegistryLite);
        }
    };

    private Field(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Field() {
        this.memoizedIsInitialized = (byte) -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = java.util.Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected java.lang.Object newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new com.google.protobuf.Field();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Field(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
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
                    switch (tag) {
                        case 0:
                            z_renamed = true;
                        case 8:
                            this.kind_ = codedInputStream.readEnum();
                        case 16:
                            this.cardinality_ = codedInputStream.readEnum();
                        case 24:
                            this.number_ = codedInputStream.readInt32();
                        case 34:
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        case 50:
                            this.typeUrl_ = codedInputStream.readStringRequireUtf8();
                        case 56:
                            this.oneofIndex_ = codedInputStream.readInt32();
                        case 64:
                            this.packed_ = codedInputStream.readBool();
                        case 74:
                            if (!(z2 & true)) {
                                this.options_ = new java.util.ArrayList();
                                z2 |= true;
                            }
                            this.options_.add(codedInputStream.readMessage(com.google.protobuf.Option.parser(), extensionRegistryLite));
                        case 82:
                            this.jsonName_ = codedInputStream.readStringRequireUtf8();
                        case 90:
                            this.defaultValue_ = codedInputStream.readStringRequireUtf8();
                        default:
                            if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                                z_renamed = true;
                            }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e_renamed) {
                    throw e_renamed.setUnfinishedMessage(this);
                } catch (java.io.IOException e2) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
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
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return com.google.protobuf.TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Field.class, com.google.protobuf.Field.Builder.class);
    }

    public enum Kind implements com.google.protobuf.ProtocolMessageEnum {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);

        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private final int value;
        private static final com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Kind> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Kind>() { // from class: com.google.protobuf.Field.Kind.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public com.google.protobuf.Field.Kind findValueByNumber(int i_renamed) {
                return com.google.protobuf.Field.Kind.forNumber(i_renamed);
            }
        };
        private static final com.google.protobuf.Field.Kind[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new java.lang.IllegalArgumentException("Can't_renamed get the number of_renamed an_renamed unknown enum value.");
            }
            return this.value;
        }

        @java.lang.Deprecated
        public static com.google.protobuf.Field.Kind valueOf(int i_renamed) {
            return forNumber(i_renamed);
        }

        public static com.google.protobuf.Field.Kind forNumber(int i_renamed) {
            switch (i_renamed) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
            return com.google.protobuf.Field.getDescriptor().getEnumTypes().get(0);
        }

        public static com.google.protobuf.Field.Kind valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new java.lang.IllegalArgumentException("EnumValueDescriptor is_renamed not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        Kind(int i_renamed) {
            this.value = i_renamed;
        }
    }

    public enum Cardinality implements com.google.protobuf.ProtocolMessageEnum {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);

        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private final int value;
        private static final com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Cardinality> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Cardinality>() { // from class: com.google.protobuf.Field.Cardinality.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public com.google.protobuf.Field.Cardinality findValueByNumber(int i_renamed) {
                return com.google.protobuf.Field.Cardinality.forNumber(i_renamed);
            }
        };
        private static final com.google.protobuf.Field.Cardinality[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new java.lang.IllegalArgumentException("Can't_renamed get the number of_renamed an_renamed unknown enum value.");
            }
            return this.value;
        }

        @java.lang.Deprecated
        public static com.google.protobuf.Field.Cardinality valueOf(int i_renamed) {
            return forNumber(i_renamed);
        }

        public static com.google.protobuf.Field.Cardinality forNumber(int i_renamed) {
            if (i_renamed == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i_renamed == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i_renamed == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i_renamed != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static com.google.protobuf.Internal.EnumLiteMap<com.google.protobuf.Field.Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
            return com.google.protobuf.Field.getDescriptor().getEnumTypes().get(1);
        }

        public static com.google.protobuf.Field.Cardinality valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new java.lang.IllegalArgumentException("EnumValueDescriptor is_renamed not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        Cardinality(int i_renamed) {
            this.value = i_renamed;
        }
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.Field.Kind getKind() {
        com.google.protobuf.Field.Kind kindValueOf = com.google.protobuf.Field.Kind.valueOf(this.kind_);
        return kindValueOf == null ? com.google.protobuf.Field.Kind.UNRECOGNIZED : kindValueOf;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.Field.Cardinality getCardinality() {
        com.google.protobuf.Field.Cardinality cardinalityValueOf = com.google.protobuf.Field.Cardinality.valueOf(this.cardinality_);
        return cardinalityValueOf == null ? com.google.protobuf.Field.Cardinality.UNRECOGNIZED : cardinalityValueOf;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.lang.String getName() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object obj = this.name_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.lang.String getTypeUrl() {
        java.lang.Object obj = this.typeUrl_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.typeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.ByteString getTypeUrlBytes() {
        java.lang.Object obj = this.typeUrl_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.typeUrl_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.util.List<com.google.protobuf.Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.Option getOptions(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
        return this.options_.get(i_renamed);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.lang.String getJsonName() {
        java.lang.Object obj = this.jsonName_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.jsonName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.ByteString getJsonNameBytes() {
        java.lang.Object obj = this.jsonName_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.jsonName_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (com.google.protobuf.ByteString) obj;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public java.lang.String getDefaultValue() {
        java.lang.Object obj = this.defaultValue_;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
        this.defaultValue_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public com.google.protobuf.ByteString getDefaultValueBytes() {
        java.lang.Object obj = this.defaultValue_;
        if (obj instanceof java.lang.String) {
            com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
            this.defaultValue_ = byteStringCopyFromUtf8;
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
        if (this.kind_ != com.google.protobuf.Field.Kind.TYPE_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(1, this.kind_);
        }
        if (this.cardinality_ != com.google.protobuf.Field.Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(2, this.cardinality_);
        }
        int i_renamed = this.number_;
        if (i_renamed != 0) {
            codedOutputStream.writeInt32(3, i_renamed);
        }
        if (!getNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
        }
        if (!getTypeUrlBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 6, this.typeUrl_);
        }
        int i2 = this.oneofIndex_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(7, i2);
        }
        boolean z_renamed = this.packed_;
        if (z_renamed) {
            codedOutputStream.writeBool(8, z_renamed);
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            codedOutputStream.writeMessage(9, this.options_.get(i3));
        }
        if (!getJsonNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 10, this.jsonName_);
        }
        if (!getDefaultValueBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(codedOutputStream, 11, this.defaultValue_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i_renamed = this.memoizedSize;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int iComputeEnumSize = this.kind_ != com.google.protobuf.Field.Kind.TYPE_UNKNOWN.getNumber() ? com.google.protobuf.CodedOutputStream.computeEnumSize(1, this.kind_) + 0 : 0;
        if (this.cardinality_ != com.google.protobuf.Field.Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        int i2 = this.number_;
        if (i2 != 0) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeInt32Size(3, i2);
        }
        if (!getNameBytes().isEmpty()) {
            iComputeEnumSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, this.name_);
        }
        if (!getTypeUrlBytes().isEmpty()) {
            iComputeEnumSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
        }
        int i3 = this.oneofIndex_;
        if (i3 != 0) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeInt32Size(7, i3);
        }
        boolean z_renamed = this.packed_;
        if (z_renamed) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeBoolSize(8, z_renamed);
        }
        for (int i4 = 0; i4 < this.options_.size(); i4++) {
            iComputeEnumSize += com.google.protobuf.CodedOutputStream.computeMessageSize(9, this.options_.get(i4));
        }
        if (!getJsonNameBytes().isEmpty()) {
            iComputeEnumSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, this.jsonName_);
        }
        if (!getDefaultValueBytes().isEmpty()) {
            iComputeEnumSize += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
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
        if (!(obj instanceof com.google.protobuf.Field)) {
            return super.equals(obj);
        }
        com.google.protobuf.Field field = (com.google.protobuf.Field) obj;
        return this.kind_ == field.kind_ && this.cardinality_ == field.cardinality_ && getNumber() == field.getNumber() && getName().equals(field.getName()) && getTypeUrl().equals(field.getTypeUrl()) && getOneofIndex() == field.getOneofIndex() && getPacked() == field.getPacked() && getOptionsList().equals(field.getOptionsList()) && getJsonName().equals(field.getJsonName()) && getDefaultValue().equals(field.getDefaultValue()) && this.unknownFields.equals(field.unknownFields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + com.google.protobuf.Internal.hashBoolean(getPacked());
        if (getOptionsCount() > 0) {
            iHashCode = (((iHashCode * 37) + 9) * 53) + getOptionsList().hashCode();
        }
        int iHashCode2 = (((((((((iHashCode * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static com.google.protobuf.Field parseFrom(java.nio.ByteBuffer byteBuffer) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static com.google.protobuf.Field parseFrom(java.nio.ByteBuffer byteBuffer, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static com.google.protobuf.Field parseFrom(com.google.protobuf.ByteString byteString) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static com.google.protobuf.Field parseFrom(com.google.protobuf.ByteString byteString, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static com.google.protobuf.Field parseFrom(byte[] bArr) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static com.google.protobuf.Field parseFrom(byte[] bArr, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static com.google.protobuf.Field parseFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Field parseFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Field parseDelimitedFrom(java.io.InputStream inputStream) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static com.google.protobuf.Field parseDelimitedFrom(java.io.InputStream inputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static com.google.protobuf.Field parseFrom(com.google.protobuf.CodedInputStream codedInputStream) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static com.google.protobuf.Field parseFrom(com.google.protobuf.CodedInputStream codedInputStream, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        return (com.google.protobuf.Field) com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Field.Builder newBuilderForType() {
        return newBuilder();
    }

    public static com.google.protobuf.Field.Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static com.google.protobuf.Field.Builder newBuilder(com.google.protobuf.Field field) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(field);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Field.Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new com.google.protobuf.Field.Builder() : new com.google.protobuf.Field.Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public com.google.protobuf.Field.Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
        return new com.google.protobuf.Field.Builder(builderParent);
    }

    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<com.google.protobuf.Field.Builder> implements com.google.protobuf.FieldOrBuilder {
        private int bitField0_;
        private int cardinality_;
        private java.lang.Object defaultValue_;
        private java.lang.Object jsonName_;
        private int kind_;
        private java.lang.Object name_;
        private int number_;
        private int oneofIndex_;
        private com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> optionsBuilder_;
        private java.util.List<com.google.protobuf.Option> options_;
        private boolean packed_;
        private java.lang.Object typeUrl_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(com.google.protobuf.Field.class, com.google.protobuf.Field.Builder.class);
        }

        private Builder() {
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = java.util.Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = java.util.Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                getOptionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder clear() {
            super.clear();
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.options_ = java.util.Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.jsonName_ = "";
            this.defaultValue_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.google.protobuf.TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public com.google.protobuf.Field getDefaultInstanceForType() {
            return com.google.protobuf.Field.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field build() {
            com.google.protobuf.Field fieldBuildPartial = buildPartial();
            if (fieldBuildPartial.isInitialized()) {
                return fieldBuildPartial;
            }
            throw newUninitializedMessageException((com.google.protobuf.Message) fieldBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field buildPartial() {
            com.google.protobuf.Field field = new com.google.protobuf.Field(this);
            int i_renamed = this.bitField0_;
            field.kind_ = this.kind_;
            field.cardinality_ = this.cardinality_;
            field.number_ = this.number_;
            field.name_ = this.name_;
            field.typeUrl_ = this.typeUrl_;
            field.oneofIndex_ = this.oneofIndex_;
            field.packed_ = this.packed_;
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                field.options_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.options_ = java.util.Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -2;
                }
                field.options_ = this.options_;
            }
            field.jsonName_ = this.jsonName_;
            field.defaultValue_ = this.defaultValue_;
            onBuilt();
            return field;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public com.google.protobuf.Field.Builder mo23clone() {
            return (com.google.protobuf.Field.Builder) super.mo23clone();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder setField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Field.Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor) {
            return (com.google.protobuf.Field.Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneofDescriptor) {
            return (com.google.protobuf.Field.Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, int i_renamed, java.lang.Object obj) {
            return (com.google.protobuf.Field.Builder) super.setRepeatedField(fieldDescriptor, i_renamed, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            return (com.google.protobuf.Field.Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public com.google.protobuf.Field.Builder mergeFrom(com.google.protobuf.Message message) {
            if (message instanceof com.google.protobuf.Field) {
                return mergeFrom((com.google.protobuf.Field) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public com.google.protobuf.Field.Builder mergeFrom(com.google.protobuf.Field field) {
            if (field == com.google.protobuf.Field.getDefaultInstance()) {
                return this;
            }
            if (field.kind_ != 0) {
                setKindValue(field.getKindValue());
            }
            if (field.cardinality_ != 0) {
                setCardinalityValue(field.getCardinalityValue());
            }
            if (field.getNumber() != 0) {
                setNumber(field.getNumber());
            }
            if (!field.getName().isEmpty()) {
                this.name_ = field.name_;
                onChanged();
            }
            if (!field.getTypeUrl().isEmpty()) {
                this.typeUrl_ = field.typeUrl_;
                onChanged();
            }
            if (field.getOneofIndex() != 0) {
                setOneofIndex(field.getOneofIndex());
            }
            if (field.getPacked()) {
                setPacked(field.getPacked());
            }
            if (this.optionsBuilder_ == null) {
                if (!field.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = field.options_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(field.options_);
                    }
                    onChanged();
                }
            } else if (!field.options_.isEmpty()) {
                if (!this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.addAllMessages(field.options_);
                } else {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = field.options_;
                    this.bitField0_ &= -2;
                    this.optionsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                }
            }
            if (!field.getJsonName().isEmpty()) {
                this.jsonName_ = field.jsonName_;
                onChanged();
            }
            if (!field.getDefaultValue().isEmpty()) {
                this.defaultValue_ = field.defaultValue_;
                onChanged();
            }
            mergeUnknownFields(field.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.Field.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.protobuf.Field.access$1300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.protobuf.Field r3 = (com.google.protobuf.Field) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.protobuf.Field r4 = (com.google.protobuf.Field) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Field.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.Field$Builder");
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        public com.google.protobuf.Field.Builder setKindValue(int i_renamed) {
            this.kind_ = i_renamed;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.Field.Kind getKind() {
            com.google.protobuf.Field.Kind kindValueOf = com.google.protobuf.Field.Kind.valueOf(this.kind_);
            return kindValueOf == null ? com.google.protobuf.Field.Kind.UNRECOGNIZED : kindValueOf;
        }

        public com.google.protobuf.Field.Builder setKind(com.google.protobuf.Field.Kind kind) {
            if (kind == null) {
                throw new java.lang.NullPointerException();
            }
            this.kind_ = kind.getNumber();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearKind() {
            this.kind_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        public com.google.protobuf.Field.Builder setCardinalityValue(int i_renamed) {
            this.cardinality_ = i_renamed;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.Field.Cardinality getCardinality() {
            com.google.protobuf.Field.Cardinality cardinalityValueOf = com.google.protobuf.Field.Cardinality.valueOf(this.cardinality_);
            return cardinalityValueOf == null ? com.google.protobuf.Field.Cardinality.UNRECOGNIZED : cardinalityValueOf;
        }

        public com.google.protobuf.Field.Builder setCardinality(com.google.protobuf.Field.Cardinality cardinality) {
            if (cardinality == null) {
                throw new java.lang.NullPointerException();
            }
            this.cardinality_ = cardinality.getNumber();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearCardinality() {
            this.cardinality_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return this.number_;
        }

        public com.google.protobuf.Field.Builder setNumber(int i_renamed) {
            this.number_ = i_renamed;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearNumber() {
            this.number_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public java.lang.String getName() {
            java.lang.Object obj = this.name_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object obj = this.name_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Field.Builder setName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.name_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearName() {
            this.name_ = com.google.protobuf.Field.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder setNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public java.lang.String getTypeUrl() {
            java.lang.Object obj = this.typeUrl_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.typeUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.ByteString getTypeUrlBytes() {
            java.lang.Object obj = this.typeUrl_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.typeUrl_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Field.Builder setTypeUrl(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.typeUrl_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearTypeUrl() {
            this.typeUrl_ = com.google.protobuf.Field.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder setTypeUrlBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.typeUrl_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        public com.google.protobuf.Field.Builder setOneofIndex(int i_renamed) {
            this.oneofIndex_ = i_renamed;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearOneofIndex() {
            this.oneofIndex_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        public com.google.protobuf.Field.Builder setPacked(boolean z_renamed) {
            this.packed_ = z_renamed;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearPacked() {
            this.packed_ = false;
            onChanged();
            return this;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.options_ = new java.util.ArrayList(this.options_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public java.util.List<com.google.protobuf.Option> getOptionsList() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return java.util.Collections.unmodifiableList(this.options_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.Option getOptions(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.Option) repeatedFieldBuilderV3.getMessage(i_renamed);
        }

        public com.google.protobuf.Field.Builder setOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Field.Builder setOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Field.Builder addOptions(com.google.protobuf.Option option) {
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

        public com.google.protobuf.Field.Builder addOptions(int i_renamed, com.google.protobuf.Option option) {
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

        public com.google.protobuf.Field.Builder addOptions(com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Field.Builder addOptions(int i_renamed, com.google.protobuf.Option.Builder builder) {
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

        public com.google.protobuf.Field.Builder addAllOptions(java.lang.Iterable<? extends com.google.protobuf.Option> iterable) {
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

        public com.google.protobuf.Field.Builder clearOptions() {
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

        public com.google.protobuf.Field.Builder removeOptions(int i_renamed) {
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

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed) {
            com.google.protobuf.RepeatedFieldBuilderV3<com.google.protobuf.Option, com.google.protobuf.Option.Builder, com.google.protobuf.OptionOrBuilder> repeatedFieldBuilderV3 = this.optionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.options_.get(i_renamed);
            }
            return (com.google.protobuf.OptionOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i_renamed);
        }

        @Override // com.google.protobuf.FieldOrBuilder
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

        @Override // com.google.protobuf.FieldOrBuilder
        public java.lang.String getJsonName() {
            java.lang.Object obj = this.jsonName_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.jsonName_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.ByteString getJsonNameBytes() {
            java.lang.Object obj = this.jsonName_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.jsonName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Field.Builder setJsonName(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.jsonName_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearJsonName() {
            this.jsonName_ = com.google.protobuf.Field.getDefaultInstance().getJsonName();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder setJsonNameBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.jsonName_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public java.lang.String getDefaultValue() {
            java.lang.Object obj = this.defaultValue_;
            if (!(obj instanceof java.lang.String)) {
                java.lang.String stringUtf8 = ((com.google.protobuf.ByteString) obj).toStringUtf8();
                this.defaultValue_ = stringUtf8;
                return stringUtf8;
            }
            return (java.lang.String) obj;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public com.google.protobuf.ByteString getDefaultValueBytes() {
            java.lang.Object obj = this.defaultValue_;
            if (obj instanceof java.lang.String) {
                com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) obj);
                this.defaultValue_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (com.google.protobuf.ByteString) obj;
        }

        public com.google.protobuf.Field.Builder setDefaultValue(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException();
            }
            this.defaultValue_ = str;
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder clearDefaultValue() {
            this.defaultValue_ = com.google.protobuf.Field.getDefaultInstance().getDefaultValue();
            onChanged();
            return this;
        }

        public com.google.protobuf.Field.Builder setDefaultValueBytes(com.google.protobuf.ByteString byteString) throws java.lang.IllegalArgumentException {
            if (byteString == null) {
                throw new java.lang.NullPointerException();
            }
            com.google.protobuf.AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.defaultValue_ = byteString;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Field.Builder setUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Field.Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final com.google.protobuf.Field.Builder mergeUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            return (com.google.protobuf.Field.Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static com.google.protobuf.Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<com.google.protobuf.Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public com.google.protobuf.Parser<com.google.protobuf.Field> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public com.google.protobuf.Field getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
