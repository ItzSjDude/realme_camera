package com.google.protobuf.nano;

/* loaded from: classes.dex */
public class Extension<M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed> {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    protected final java.lang.Class<T_renamed> clazz;
    protected final com.google.protobuf.GeneratedMessageLite<?, ?> defaultInstance;
    protected final boolean repeated;
    public final int tag;
    protected final int type;

    @java.lang.Deprecated
    public static <M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed extends com.google.protobuf.nano.MessageNano> com.google.protobuf.nano.Extension<M_renamed, T_renamed> createMessageTyped(int i_renamed, java.lang.Class<T_renamed> cls, int i2) {
        return new com.google.protobuf.nano.Extension<>(i_renamed, cls, i2, false);
    }

    public static <M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed extends com.google.protobuf.nano.MessageNano> com.google.protobuf.nano.Extension<M_renamed, T_renamed> createMessageTyped(int i_renamed, java.lang.Class<T_renamed> cls, long j_renamed) {
        return new com.google.protobuf.nano.Extension<>(i_renamed, cls, (int) j_renamed, false);
    }

    /* JADX WARN: Incorrect types in_renamed method signature: <M_renamed:Lcom/google/protobuf/nano/ExtendableMessageNano<TM;>;T_renamed:Lcom/google/protobuf/GeneratedMessageLite<**>;>(ILjava/lang/Class<TT;>;TT;J_renamed)Lcom/google/protobuf/nano/Extension<TM;TT;>; */
    public static com.google.protobuf.nano.Extension createMessageLiteTyped(int i_renamed, java.lang.Class cls, com.google.protobuf.GeneratedMessageLite generatedMessageLite, long j_renamed) {
        return new com.google.protobuf.nano.Extension(i_renamed, cls, (com.google.protobuf.GeneratedMessageLite<?, ?>) generatedMessageLite, (int) j_renamed, false);
    }

    public static <M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed extends com.google.protobuf.nano.MessageNano> com.google.protobuf.nano.Extension<M_renamed, T_renamed[]> createRepeatedMessageTyped(int i_renamed, java.lang.Class<T_renamed[]> cls, long j_renamed) {
        return new com.google.protobuf.nano.Extension<>(i_renamed, cls, (int) j_renamed, true);
    }

    /* JADX WARN: Incorrect types in_renamed method signature: <M_renamed:Lcom/google/protobuf/nano/ExtendableMessageNano<TM;>;T_renamed:Lcom/google/protobuf/GeneratedMessageLite<**>;>(ILjava/lang/Class<[TT;>;TT;J_renamed)Lcom/google/protobuf/nano/Extension<TM;[TT;>; */
    public static com.google.protobuf.nano.Extension createRepeatedMessageLiteTyped(int i_renamed, java.lang.Class cls, com.google.protobuf.GeneratedMessageLite generatedMessageLite, long j_renamed) {
        return new com.google.protobuf.nano.Extension(i_renamed, cls, (com.google.protobuf.GeneratedMessageLite<?, ?>) generatedMessageLite, (int) j_renamed, true);
    }

    public static <M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed> com.google.protobuf.nano.Extension<M_renamed, T_renamed> createPrimitiveTyped(int i_renamed, java.lang.Class<T_renamed> cls, long j_renamed) {
        return new com.google.protobuf.nano.Extension.PrimitiveExtension(i_renamed, cls, (int) j_renamed, false, 0, 0);
    }

    public static <M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed> com.google.protobuf.nano.Extension<M_renamed, T_renamed> createRepeatedPrimitiveTyped(int i_renamed, java.lang.Class<T_renamed> cls, long j_renamed, long j2, long j3) {
        return new com.google.protobuf.nano.Extension.PrimitiveExtension(i_renamed, cls, (int) j_renamed, true, (int) j2, (int) j3);
    }

    private Extension(int i_renamed, java.lang.Class<T_renamed> cls, int i2, boolean z_renamed) {
        this(i_renamed, cls, (com.google.protobuf.GeneratedMessageLite<?, ?>) null, i2, z_renamed);
    }

    private Extension(int i_renamed, java.lang.Class<T_renamed> cls, com.google.protobuf.GeneratedMessageLite<?, ?> generatedMessageLite, int i2, boolean z_renamed) {
        this.type = i_renamed;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z_renamed;
        this.defaultInstance = generatedMessageLite;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.nano.Extension)) {
            return false;
        }
        com.google.protobuf.nano.Extension extension = (com.google.protobuf.nano.Extension) obj;
        return this.type == extension.type && this.clazz == extension.clazz && this.tag == extension.tag && this.repeated == extension.repeated;
    }

    public int hashCode() {
        return ((((((1147 + this.type) * 31) + this.clazz.hashCode()) * 31) + this.tag) * 31) + (this.repeated ? 1 : 0);
    }

    final T_renamed getValueFrom(java.util.List<com.google.protobuf.nano.UnknownFieldData> list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    private T_renamed getRepeatedValueFrom(java.util.List<com.google.protobuf.nano.UnknownFieldData> list) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.protobuf.nano.UnknownFieldData unknownFieldData = list.get(i_renamed);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        java.lang.Class<T_renamed> cls = this.clazz;
        T_renamed tCast = cls.cast(java.lang.reflect.Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            java.lang.reflect.Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    private T_renamed getSingularValueFrom(java.util.List<com.google.protobuf.nano.UnknownFieldData> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(list.get(list.size() - 1).bytes)));
    }

    protected java.lang.Object readData(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) {
        java.lang.Class componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            int i_renamed = this.type;
            if (i_renamed == 10) {
                com.google.protobuf.nano.MessageNano messageNano = (com.google.protobuf.nano.MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readGroup(messageNano, com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag));
                return messageNano;
            }
            if (i_renamed == 11) {
                if (this.defaultInstance != null) {
                    return codedInputByteBufferNano.readMessageLite(this.defaultInstance.getParserForType());
                }
                com.google.protobuf.nano.MessageNano messageNano2 = (com.google.protobuf.nano.MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readMessage(messageNano2);
                return messageNano2;
            }
            int i2 = this.type;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new java.lang.IllegalArgumentException(sb.toString());
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.IllegalArgumentException("Error reading extension field", e_renamed);
        } catch (java.lang.IllegalAccessException e2) {
            java.lang.String strValueOf = java.lang.String.valueOf(componentType);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(strValueOf).length() + 33);
            sb2.append("Error creating instance of_renamed class ");
            sb2.append(strValueOf);
            throw new java.lang.IllegalArgumentException(sb2.toString(), e2);
        } catch (java.lang.InstantiationException e3) {
            java.lang.String strValueOf2 = java.lang.String.valueOf(componentType);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(strValueOf2).length() + 33);
            sb3.append("Error creating instance of_renamed class ");
            sb3.append(strValueOf2);
            throw new java.lang.IllegalArgumentException(sb3.toString(), e3);
        }
    }

    protected void readDataInto(com.google.protobuf.nano.UnknownFieldData unknownFieldData, java.util.List<java.lang.Object> list) {
        list.add(readData(com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    void writeTo(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }

    void writeAsMessageSetTo(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (this.repeated) {
            writeRepeatedDataAsMessageSet(obj, codedOutputByteBufferNano);
        } else {
            writeSingularDataAsMessageSet(obj, codedOutputByteBufferNano);
        }
    }

    protected void writeSingularData(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            int i_renamed = this.type;
            if (i_renamed == 10) {
                int tagFieldNumber = com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag);
                if (this.defaultInstance == null) {
                    codedOutputByteBufferNano.writeGroupNoTag((com.google.protobuf.nano.MessageNano) obj);
                } else {
                    codedOutputByteBufferNano.writeGroupNoTag((com.google.protobuf.MessageLite) obj);
                }
                codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
                return;
            }
            if (i_renamed == 11) {
                if (this.defaultInstance == null) {
                    codedOutputByteBufferNano.writeMessageNoTag((com.google.protobuf.nano.MessageNano) obj);
                    return;
                } else {
                    codedOutputByteBufferNano.writeMessageNoTag((com.google.protobuf.MessageLite) obj);
                    return;
                }
            }
            int i2 = this.type;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new java.lang.IllegalArgumentException(sb.toString());
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        }
    }

    protected void writeSingularDataAsMessageSet(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException {
        codedOutputByteBufferNano.writeMessageSetExtension(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag), (com.google.protobuf.nano.MessageNano) obj);
    }

    protected void writeRepeatedData(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.Object obj2 = java.lang.reflect.Array.get(obj, i_renamed);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    protected void writeRepeatedDataAsMessageSet(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.Object obj2 = java.lang.reflect.Array.get(obj, i_renamed);
            if (obj2 != null) {
                writeSingularDataAsMessageSet(obj2, codedOutputByteBufferNano);
            }
        }
    }

    int computeSerializedSize(java.lang.Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSize(obj);
        }
        return computeSingularSerializedSize(obj);
    }

    int computeSerializedSizeAsMessageSet(java.lang.Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSizeAsMessageSet(obj);
        }
        return computeSingularSerializedSizeAsMessageSet(obj);
    }

    protected int computeRepeatedSerializedSize(java.lang.Object obj) {
        int length = java.lang.reflect.Array.getLength(obj);
        int iComputeSingularSerializedSize = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            if (java.lang.reflect.Array.get(obj, i_renamed) != null) {
                iComputeSingularSerializedSize += computeSingularSerializedSize(java.lang.reflect.Array.get(obj, i_renamed));
            }
        }
        return iComputeSingularSerializedSize;
    }

    protected int computeSingularSerializedSize(java.lang.Object obj) {
        int tagFieldNumber = com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag);
        int i_renamed = this.type;
        if (i_renamed == 10) {
            if (this.defaultInstance == null) {
                return com.google.protobuf.nano.CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (com.google.protobuf.nano.MessageNano) obj);
            }
            return com.google.protobuf.CodedOutputStream.computeGroupSize(tagFieldNumber, (com.google.protobuf.MessageLite) obj);
        }
        if (i_renamed == 11) {
            if (this.defaultInstance == null) {
                return com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (com.google.protobuf.nano.MessageNano) obj);
            }
            return com.google.protobuf.CodedOutputStream.computeMessageSize(tagFieldNumber, (com.google.protobuf.MessageLite) obj);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(i_renamed);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    protected int computeRepeatedSerializedSizeAsMessageSet(java.lang.Object obj) {
        int length = java.lang.reflect.Array.getLength(obj);
        int iComputeSingularSerializedSizeAsMessageSet = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            if (java.lang.reflect.Array.get(obj, i_renamed) != null) {
                iComputeSingularSerializedSizeAsMessageSet += computeSingularSerializedSizeAsMessageSet(java.lang.reflect.Array.get(obj, i_renamed));
            }
        }
        return iComputeSingularSerializedSizeAsMessageSet;
    }

    protected int computeSingularSerializedSizeAsMessageSet(java.lang.Object obj) {
        return com.google.protobuf.nano.CodedOutputByteBufferNano.computeMessageSetExtensionSize(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag), (com.google.protobuf.nano.MessageNano) obj);
    }

    private static class PrimitiveExtension<M_renamed extends com.google.protobuf.nano.ExtendableMessageNano<M_renamed>, T_renamed> extends com.google.protobuf.nano.Extension<M_renamed, T_renamed> {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int i_renamed, java.lang.Class<T_renamed> cls, int i2, boolean z_renamed, int i3, int i4) {
            super(i_renamed, cls, i2, z_renamed);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        @Override // com.google.protobuf.nano.Extension
        protected java.lang.Object readData(com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return java.lang.Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return java.lang.Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return java.lang.Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return java.lang.Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return java.lang.Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return java.lang.Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 10:
                    case 11:
                    default:
                        int i_renamed = this.type;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i_renamed);
                        throw new java.lang.IllegalArgumentException(sb.toString());
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return java.lang.Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return java.lang.Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return java.lang.Long.valueOf(codedInputByteBufferNano.readSInt64());
                }
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalArgumentException("Error reading extension field", e_renamed);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected void readDataInto(com.google.protobuf.nano.UnknownFieldData unknownFieldData, java.util.List<java.lang.Object> list) {
            if (unknownFieldData.tag == this.nonPackedTag) {
                list.add(readData(com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
                return;
            }
            com.google.protobuf.nano.CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = com.google.protobuf.nano.CodedInputByteBufferNano.newInstance(unknownFieldData.bytes);
            try {
                codedInputByteBufferNanoNewInstance.pushLimit(codedInputByteBufferNanoNewInstance.readRawVarint32());
                while (!codedInputByteBufferNanoNewInstance.isAtEnd()) {
                    list.add(readData(codedInputByteBufferNanoNewInstance));
                }
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalArgumentException("Error reading extension field", e_renamed);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected final void writeSingularData(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((java.lang.Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((java.lang.Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((java.lang.Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((java.lang.Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((java.lang.Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((java.lang.Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((java.lang.String) obj);
                        return;
                    case 10:
                    case 11:
                    default:
                        int i_renamed = this.type;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(i_renamed);
                        throw new java.lang.IllegalArgumentException(sb.toString());
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((java.lang.Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((java.lang.Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((java.lang.Long) obj).longValue());
                        return;
                }
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.nano.Extension
        protected void writeRepeatedData(java.lang.Object obj, com.google.protobuf.nano.CodedOutputByteBufferNano codedOutputByteBufferNano) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
            if (this.tag == this.nonPackedTag) {
                super.writeRepeatedData(obj, codedOutputByteBufferNano);
                return;
            }
            if (this.tag == this.packedTag) {
                int length = java.lang.reflect.Array.getLength(obj);
                int iComputePackedDataSize = computePackedDataSize(obj);
                try {
                    codedOutputByteBufferNano.writeRawVarint32(this.tag);
                    codedOutputByteBufferNano.writeRawVarint32(iComputePackedDataSize);
                    int i_renamed = 0;
                    switch (this.type) {
                        case 1:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeDoubleNoTag(java.lang.reflect.Array.getDouble(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 2:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeFloatNoTag(java.lang.reflect.Array.getFloat(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 3:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeInt64NoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 4:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeUInt64NoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 5:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeInt32NoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 6:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeFixed64NoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 7:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeFixed32NoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 8:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeBoolNoTag(java.lang.reflect.Array.getBoolean(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        default:
                            int i2 = this.type;
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(27);
                            sb.append("Unpackable type ");
                            sb.append(i2);
                            throw new java.lang.IllegalArgumentException(sb.toString());
                        case 13:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeUInt32NoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 14:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeEnumNoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 15:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeSFixed32NoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 16:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeSFixed64NoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 17:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeSInt32NoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                        case 18:
                            while (i_renamed < length) {
                                codedOutputByteBufferNano.writeSInt64NoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                                i_renamed++;
                            }
                            return;
                    }
                } catch (java.io.IOException e_renamed) {
                    throw new java.lang.IllegalStateException(e_renamed);
                }
            }
            int i3 = this.tag;
            int i4 = this.nonPackedTag;
            int i5 = this.packedTag;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(124);
            sb2.append("Unexpected repeated extension tag ");
            sb2.append(i3);
            sb2.append(", unequal to both non-packed variant ");
            sb2.append(i4);
            sb2.append(" and packed variant ");
            sb2.append(i5);
            throw new java.lang.IllegalArgumentException(sb2.toString());
        }

        private int computePackedDataSize(java.lang.Object obj) {
            int length = java.lang.reflect.Array.getLength(obj);
            int i_renamed = 0;
            switch (this.type) {
                case 1:
                case 6:
                case 16:
                    length *= 8;
                    break;
                case 2:
                case 7:
                case 15:
                    length *= 4;
                    break;
                case 3:
                    int iComputeInt64SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeInt64SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64SizeNoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeInt64SizeNoTag;
                case 4:
                    int iComputeUInt64SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeUInt64SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeUInt64SizeNoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeUInt64SizeNoTag;
                case 5:
                    int iComputeInt32SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32SizeNoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeInt32SizeNoTag;
                case 8:
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    int i2 = this.type;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
                    sb.append("Unexpected non-packable type ");
                    sb.append(i2);
                    throw new java.lang.IllegalArgumentException(sb.toString());
                case 13:
                    int iComputeUInt32SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeUInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeUInt32SizeNoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeUInt32SizeNoTag;
                case 14:
                    int iComputeEnumSizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeEnumSizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeEnumSizeNoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeEnumSizeNoTag;
                case 17:
                    int iComputeSInt32SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeSInt32SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt32SizeNoTag(java.lang.reflect.Array.getInt(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeSInt32SizeNoTag;
                case 18:
                    int iComputeSInt64SizeNoTag = 0;
                    while (i_renamed < length) {
                        iComputeSInt64SizeNoTag += com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt64SizeNoTag(java.lang.reflect.Array.getLong(obj, i_renamed));
                        i_renamed++;
                    }
                    return iComputeSInt64SizeNoTag;
            }
            return length;
        }

        @Override // com.google.protobuf.nano.Extension
        protected int computeRepeatedSerializedSize(java.lang.Object obj) {
            if (this.tag == this.nonPackedTag) {
                return super.computeRepeatedSerializedSize(obj);
            }
            if (this.tag == this.packedTag) {
                int iComputePackedDataSize = computePackedDataSize(obj);
                return iComputePackedDataSize + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(iComputePackedDataSize) + com.google.protobuf.nano.CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            int i_renamed = this.tag;
            int i2 = this.nonPackedTag;
            int i3 = this.packedTag;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(124);
            sb.append("Unexpected repeated extension tag ");
            sb.append(i_renamed);
            sb.append(", unequal to both non-packed variant ");
            sb.append(i2);
            sb.append(" and packed variant ");
            sb.append(i3);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }

        @Override // com.google.protobuf.nano.Extension
        protected final int computeSingularSerializedSize(java.lang.Object obj) {
            int tagFieldNumber = com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((java.lang.Double) obj).doubleValue());
                case 2:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((java.lang.Float) obj).floatValue());
                case 3:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((java.lang.Long) obj).longValue());
                case 4:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((java.lang.Long) obj).longValue());
                case 5:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 6:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((java.lang.Long) obj).longValue());
                case 7:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 8:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((java.lang.Boolean) obj).booleanValue());
                case 9:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (java.lang.String) obj);
                case 10:
                case 11:
                default:
                    int i_renamed = this.type;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i_renamed);
                    throw new java.lang.IllegalArgumentException(sb.toString());
                case 12:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 14:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 15:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 16:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((java.lang.Long) obj).longValue());
                case 17:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((java.lang.Integer) obj).intValue());
                case 18:
                    return com.google.protobuf.nano.CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((java.lang.Long) obj).longValue());
            }
        }
    }
}
