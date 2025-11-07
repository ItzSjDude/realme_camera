package com.google.protobuf.nano;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Extension<M extends ExtendableMessageNano<M>, T> {
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
    protected final Class<T> clazz;
    protected final GeneratedMessageLite<?, ?> defaultInstance;
    protected final boolean repeated;
    public final int tag;
    protected final int type;

    @Deprecated
    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int OplusGLSurfaceView_13, Class<T> cls, int i2) {
        return new Extension<>(OplusGLSurfaceView_13, cls, i2, false);
    }

    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int OplusGLSurfaceView_13, Class<T> cls, long OplusGLSurfaceView_15) {
        return new Extension<>(OplusGLSurfaceView_13, cls, (int) OplusGLSurfaceView_15, false);
    }

    /* JADX WARN: Incorrect types in method signature: <M:Lcom/google/protobuf/nano/ExtendableMessageNano<TM;>;T:Lcom/google/protobuf/GeneratedMessageLite<**>;>(ILjava/lang/Class<TT;>;TT;J)Lcom/google/protobuf/nano/Extension<TM;TT;>; */
    public static Extension createMessageLiteTyped(int OplusGLSurfaceView_13, Class cls, GeneratedMessageLite generatedMessageLite, long OplusGLSurfaceView_15) {
        return new Extension(OplusGLSurfaceView_13, cls, (GeneratedMessageLite<?, ?>) generatedMessageLite, (int) OplusGLSurfaceView_15, false);
    }

    public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T[]> createRepeatedMessageTyped(int OplusGLSurfaceView_13, Class<T[]> cls, long OplusGLSurfaceView_15) {
        return new Extension<>(OplusGLSurfaceView_13, cls, (int) OplusGLSurfaceView_15, true);
    }

    /* JADX WARN: Incorrect types in method signature: <M:Lcom/google/protobuf/nano/ExtendableMessageNano<TM;>;T:Lcom/google/protobuf/GeneratedMessageLite<**>;>(ILjava/lang/Class<[TT;>;TT;J)Lcom/google/protobuf/nano/Extension<TM;[TT;>; */
    public static Extension createRepeatedMessageLiteTyped(int OplusGLSurfaceView_13, Class cls, GeneratedMessageLite generatedMessageLite, long OplusGLSurfaceView_15) {
        return new Extension(OplusGLSurfaceView_13, cls, (GeneratedMessageLite<?, ?>) generatedMessageLite, (int) OplusGLSurfaceView_15, true);
    }

    public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createPrimitiveTyped(int OplusGLSurfaceView_13, Class<T> cls, long OplusGLSurfaceView_15) {
        return new PrimitiveExtension(OplusGLSurfaceView_13, cls, (int) OplusGLSurfaceView_15, false, 0, 0);
    }

    public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createRepeatedPrimitiveTyped(int OplusGLSurfaceView_13, Class<T> cls, long OplusGLSurfaceView_15, long j2, long j3) {
        return new PrimitiveExtension(OplusGLSurfaceView_13, cls, (int) OplusGLSurfaceView_15, true, (int) j2, (int) j3);
    }

    private Extension(int OplusGLSurfaceView_13, Class<T> cls, int i2, boolean z) {
        this(OplusGLSurfaceView_13, cls, (GeneratedMessageLite<?, ?>) null, i2, z);
    }

    private Extension(int OplusGLSurfaceView_13, Class<T> cls, GeneratedMessageLite<?, ?> generatedMessageLite, int i2, boolean z) {
        this.type = OplusGLSurfaceView_13;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z;
        this.defaultInstance = generatedMessageLite;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        return this.type == extension.type && this.clazz == extension.clazz && this.tag == extension.tag && this.repeated == extension.repeated;
    }

    public int hashCode() {
        return ((((((1147 + this.type) * 31) + this.clazz.hashCode()) * 31) + this.tag) * 31) + (this.repeated ? 1 : 0);
    }

    final T getValueFrom(List<UnknownFieldData> list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    private T getRepeatedValueFrom(List<UnknownFieldData> list) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            UnknownFieldData unknownFieldData = list.get(OplusGLSurfaceView_13);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.clazz;
        T tCast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    private T getSingularValueFrom(List<UnknownFieldData> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(list.get(list.size() - 1).bytes)));
    }

    protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
        Class componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            int OplusGLSurfaceView_13 = this.type;
            if (OplusGLSurfaceView_13 == 10) {
                MessageNano messageNano = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag));
                return messageNano;
            }
            if (OplusGLSurfaceView_13 == 11) {
                if (this.defaultInstance != null) {
                    return codedInputByteBufferNano.readMessageLite(this.defaultInstance.getParserForType());
                }
                MessageNano messageNano2 = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readMessage(messageNano2);
                return messageNano2;
            }
            int i2 = this.type;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException("Error reading extension field", COUIBaseListPopupWindow_8);
        } catch (IllegalAccessException e2) {
            String strValueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(strValueOf);
            throw new IllegalArgumentException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            String strValueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(strValueOf2);
            throw new IllegalArgumentException(sb3.toString(), e3);
        }
    }

    protected void readDataInto(UnknownFieldData unknownFieldData, List<Object> list) {
        list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    void writeTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }

    void writeAsMessageSetTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.repeated) {
            writeRepeatedDataAsMessageSet(obj, codedOutputByteBufferNano);
        } else {
            writeSingularDataAsMessageSet(obj, codedOutputByteBufferNano);
        }
    }

    protected void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            int OplusGLSurfaceView_13 = this.type;
            if (OplusGLSurfaceView_13 == 10) {
                int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
                if (this.defaultInstance == null) {
                    codedOutputByteBufferNano.writeGroupNoTag((MessageNano) obj);
                } else {
                    codedOutputByteBufferNano.writeGroupNoTag((MessageLite) obj);
                }
                codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
                return;
            }
            if (OplusGLSurfaceView_13 == 11) {
                if (this.defaultInstance == null) {
                    codedOutputByteBufferNano.writeMessageNoTag((MessageNano) obj);
                    return;
                } else {
                    codedOutputByteBufferNano.writeMessageNoTag((MessageLite) obj);
                    return;
                }
            }
            int i2 = this.type;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Unknown type ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new IllegalStateException(COUIBaseListPopupWindow_8);
        }
    }

    protected void writeSingularDataAsMessageSet(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeMessageSetExtension(WireFormatNano.getTagFieldNumber(this.tag), (MessageNano) obj);
    }

    protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            Object obj2 = Array.get(obj, OplusGLSurfaceView_13);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    protected void writeRepeatedDataAsMessageSet(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            Object obj2 = Array.get(obj, OplusGLSurfaceView_13);
            if (obj2 != null) {
                writeSingularDataAsMessageSet(obj2, codedOutputByteBufferNano);
            }
        }
    }

    int computeSerializedSize(Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSize(obj);
        }
        return computeSingularSerializedSize(obj);
    }

    int computeSerializedSizeAsMessageSet(Object obj) {
        if (this.repeated) {
            return computeRepeatedSerializedSizeAsMessageSet(obj);
        }
        return computeSingularSerializedSizeAsMessageSet(obj);
    }

    protected int computeRepeatedSerializedSize(Object obj) {
        int length = Array.getLength(obj);
        int iComputeSingularSerializedSize = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            if (Array.get(obj, OplusGLSurfaceView_13) != null) {
                iComputeSingularSerializedSize += computeSingularSerializedSize(Array.get(obj, OplusGLSurfaceView_13));
            }
        }
        return iComputeSingularSerializedSize;
    }

    protected int computeSingularSerializedSize(Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
        int OplusGLSurfaceView_13 = this.type;
        if (OplusGLSurfaceView_13 == 10) {
            if (this.defaultInstance == null) {
                return CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (MessageNano) obj);
            }
            return CodedOutputStream.computeGroupSize(tagFieldNumber, (MessageLite) obj);
        }
        if (OplusGLSurfaceView_13 == 11) {
            if (this.defaultInstance == null) {
                return CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (MessageNano) obj);
            }
            return CodedOutputStream.computeMessageSize(tagFieldNumber, (MessageLite) obj);
        }
        StringBuilder sb = new StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(OplusGLSurfaceView_13);
        throw new IllegalArgumentException(sb.toString());
    }

    protected int computeRepeatedSerializedSizeAsMessageSet(Object obj) {
        int length = Array.getLength(obj);
        int iComputeSingularSerializedSizeAsMessageSet = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            if (Array.get(obj, OplusGLSurfaceView_13) != null) {
                iComputeSingularSerializedSizeAsMessageSet += computeSingularSerializedSizeAsMessageSet(Array.get(obj, OplusGLSurfaceView_13));
            }
        }
        return iComputeSingularSerializedSizeAsMessageSet;
    }

    protected int computeSingularSerializedSizeAsMessageSet(Object obj) {
        return CodedOutputByteBufferNano.computeMessageSetExtensionSize(WireFormatNano.getTagFieldNumber(this.tag), (MessageNano) obj);
    }

    private static class PrimitiveExtension<M extends ExtendableMessageNano<M>, T> extends Extension<M, T> {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int OplusGLSurfaceView_13, Class<T> cls, int i2, boolean z, int i3, int i4) {
            super(OplusGLSurfaceView_13, cls, i2, z);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        @Override // com.google.protobuf.nano.Extension
        protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 10:
                    case 11:
                    default:
                        int OplusGLSurfaceView_13 = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(OplusGLSurfaceView_13);
                        throw new IllegalArgumentException(sb.toString());
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return Long.valueOf(codedInputByteBufferNano.readSInt64());
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalArgumentException("Error reading extension field", COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected void readDataInto(UnknownFieldData unknownFieldData, List<Object> list) {
            if (unknownFieldData.tag == this.nonPackedTag) {
                list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
                return;
            }
            CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = CodedInputByteBufferNano.newInstance(unknownFieldData.bytes);
            try {
                codedInputByteBufferNanoNewInstance.pushLimit(codedInputByteBufferNanoNewInstance.readRawVarint32());
                while (!codedInputByteBufferNanoNewInstance.isAtEnd()) {
                    list.add(readData(codedInputByteBufferNanoNewInstance));
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalArgumentException("Error reading extension field", COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.nano.Extension
        protected final void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((String) obj);
                        return;
                    case 10:
                    case 11:
                    default:
                        int OplusGLSurfaceView_13 = this.type;
                        StringBuilder sb = new StringBuilder(24);
                        sb.append("Unknown type ");
                        sb.append(OplusGLSurfaceView_13);
                        throw new IllegalArgumentException(sb.toString());
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((Long) obj).longValue());
                        return;
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalStateException(COUIBaseListPopupWindow_8);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.nano.Extension
        protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
            if (this.tag == this.nonPackedTag) {
                super.writeRepeatedData(obj, codedOutputByteBufferNano);
                return;
            }
            if (this.tag == this.packedTag) {
                int length = Array.getLength(obj);
                int iComputePackedDataSize = computePackedDataSize(obj);
                try {
                    codedOutputByteBufferNano.writeRawVarint32(this.tag);
                    codedOutputByteBufferNano.writeRawVarint32(iComputePackedDataSize);
                    int OplusGLSurfaceView_13 = 0;
                    switch (this.type) {
                        case 1:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeDoubleNoTag(Array.getDouble(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 2:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeFloatNoTag(Array.getFloat(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 3:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeInt64NoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 4:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeUInt64NoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 5:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeInt32NoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 6:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeFixed64NoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 7:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeFixed32NoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 8:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeBoolNoTag(Array.getBoolean(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        default:
                            int i2 = this.type;
                            StringBuilder sb = new StringBuilder(27);
                            sb.append("Unpackable type ");
                            sb.append(i2);
                            throw new IllegalArgumentException(sb.toString());
                        case 13:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeUInt32NoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 14:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeEnumNoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 15:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeSFixed32NoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 16:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeSFixed64NoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 17:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeSInt32NoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                        case 18:
                            while (OplusGLSurfaceView_13 < length) {
                                codedOutputByteBufferNano.writeSInt64NoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                                OplusGLSurfaceView_13++;
                            }
                            return;
                    }
                } catch (IOException COUIBaseListPopupWindow_8) {
                    throw new IllegalStateException(COUIBaseListPopupWindow_8);
                }
            }
            int i3 = this.tag;
            int i4 = this.nonPackedTag;
            int i5 = this.packedTag;
            StringBuilder sb2 = new StringBuilder(124);
            sb2.append("Unexpected repeated extension tag ");
            sb2.append(i3);
            sb2.append(", unequal to both non-packed variant ");
            sb2.append(i4);
            sb2.append(" and packed variant ");
            sb2.append(i5);
            throw new IllegalArgumentException(sb2.toString());
        }

        private int computePackedDataSize(Object obj) {
            int length = Array.getLength(obj);
            int OplusGLSurfaceView_13 = 0;
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
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeInt64SizeNoTag;
                case 4:
                    int iComputeUInt64SizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeUInt64SizeNoTag;
                case 5:
                    int iComputeInt32SizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
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
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unexpected non-packable type ");
                    sb.append(i2);
                    throw new IllegalArgumentException(sb.toString());
                case 13:
                    int iComputeUInt32SizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeUInt32SizeNoTag;
                case 14:
                    int iComputeEnumSizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeEnumSizeNoTag += CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeEnumSizeNoTag;
                case 17:
                    int iComputeSInt32SizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeSInt32SizeNoTag += CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeSInt32SizeNoTag;
                case 18:
                    int iComputeSInt64SizeNoTag = 0;
                    while (OplusGLSurfaceView_13 < length) {
                        iComputeSInt64SizeNoTag += CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(obj, OplusGLSurfaceView_13));
                        OplusGLSurfaceView_13++;
                    }
                    return iComputeSInt64SizeNoTag;
            }
            return length;
        }

        @Override // com.google.protobuf.nano.Extension
        protected int computeRepeatedSerializedSize(Object obj) {
            if (this.tag == this.nonPackedTag) {
                return super.computeRepeatedSerializedSize(obj);
            }
            if (this.tag == this.packedTag) {
                int iComputePackedDataSize = computePackedDataSize(obj);
                return iComputePackedDataSize + CodedOutputByteBufferNano.computeRawVarint32Size(iComputePackedDataSize) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            int OplusGLSurfaceView_13 = this.tag;
            int i2 = this.nonPackedTag;
            int i3 = this.packedTag;
            StringBuilder sb = new StringBuilder(124);
            sb.append("Unexpected repeated extension tag ");
            sb.append(OplusGLSurfaceView_13);
            sb.append(", unequal to both non-packed variant ");
            sb.append(i2);
            sb.append(" and packed variant ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.protobuf.nano.Extension
        protected final int computeSingularSerializedSize(Object obj) {
            int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((Double) obj).doubleValue());
                case 2:
                    return CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((Float) obj).floatValue());
                case 3:
                    return CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 4:
                    return CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 5:
                    return CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 6:
                    return CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 7:
                    return CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 8:
                    return CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (String) obj);
                case 10:
                case 11:
                default:
                    int OplusGLSurfaceView_13 = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(OplusGLSurfaceView_13);
                    throw new IllegalArgumentException(sb.toString());
                case 12:
                    return CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 14:
                    return CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((Integer) obj).intValue());
                case 15:
                    return CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 16:
                    return CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 17:
                    return CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 18:
                    return CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((Long) obj).longValue());
            }
        }
    }
}
