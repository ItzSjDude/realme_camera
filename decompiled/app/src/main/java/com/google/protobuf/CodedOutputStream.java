package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends com.google.protobuf.ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @java.lang.Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    com.google.protobuf.CodedOutputStreamWriter wrapper;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(com.google.protobuf.CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = com.google.protobuf.UnsafeUtil.hasUnsafeArrayOperations();

    public static int computeBoolSizeNoTag(boolean z_renamed) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double d_renamed) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int i_renamed) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long j_renamed) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float f_renamed) {
        return 4;
    }

    static int computePreferredBufferSize(int i_renamed) {
        if (i_renamed > 4096) {
            return 4096;
        }
        return i_renamed;
    }

    public static int computeSFixed32SizeNoTag(int i_renamed) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j_renamed) {
        return 8;
    }

    public static int computeUInt32SizeNoTag(int i_renamed) {
        if ((i_renamed & (-128)) == 0) {
            return 1;
        }
        if ((i_renamed & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i_renamed) == 0) {
            return 3;
        }
        return (i_renamed & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64SizeNoTag(long j_renamed) {
        int i_renamed;
        if (((-128) & j_renamed) == 0) {
            return 1;
        }
        if (j_renamed < 0) {
            return 10;
        }
        if (((-34359738368L) & j_renamed) != 0) {
            i_renamed = 6;
            j_renamed >>>= 28;
        } else {
            i_renamed = 2;
        }
        if (((-2097152) & j_renamed) != 0) {
            i_renamed += 2;
            j_renamed >>>= 14;
        }
        return (j_renamed & (-16384)) != 0 ? i_renamed + 1 : i_renamed;
    }

    public static int encodeZigZag32(int i_renamed) {
        return (i_renamed >> 31) ^ (i_renamed << 1);
    }

    public static long encodeZigZag64(long j_renamed) {
        return (j_renamed >> 63) ^ (j_renamed << 1);
    }

    public abstract void flush() throws java.io.IOException;

    public abstract int getTotalBytesWritten();

    public abstract int spaceLeft();

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b2) throws java.io.IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException;

    public abstract void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException;

    public abstract void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException;

    abstract void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    public abstract void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException;

    public abstract void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException;

    public abstract void writeFixed32(int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeFixed32NoTag(int i_renamed) throws java.io.IOException;

    public abstract void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException;

    public abstract void writeFixed64NoTag(long j_renamed) throws java.io.IOException;

    public abstract void writeInt32(int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeInt32NoTag(int i_renamed) throws java.io.IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException;

    abstract void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException;

    public abstract void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException;

    abstract void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException;

    public abstract void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException;

    public abstract void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    public abstract void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException;

    public abstract void writeString(int i_renamed, java.lang.String str) throws java.io.IOException;

    public abstract void writeStringNoTag(java.lang.String str) throws java.io.IOException;

    public abstract void writeTag(int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeUInt32(int i_renamed, int i2) throws java.io.IOException;

    public abstract void writeUInt32NoTag(int i_renamed) throws java.io.IOException;

    public abstract void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException;

    public abstract void writeUInt64NoTag(long j_renamed) throws java.io.IOException;

    public static com.google.protobuf.CodedOutputStream newInstance(java.io.OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(java.io.OutputStream outputStream, int i_renamed) {
        return new com.google.protobuf.CodedOutputStream.OutputStreamEncoder(outputStream, i_renamed);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(byte[] bArr, int i_renamed, int i2) {
        return new com.google.protobuf.CodedOutputStream.ArrayEncoder(bArr, i_renamed, i2);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new com.google.protobuf.CodedOutputStream.HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (com.google.protobuf.CodedOutputStream.UnsafeDirectNioEncoder.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new java.lang.IllegalArgumentException("ByteBuffer is_renamed read-only");
    }

    static com.google.protobuf.CodedOutputStream newUnsafeInstance(java.nio.ByteBuffer byteBuffer) {
        return new com.google.protobuf.CodedOutputStream.UnsafeDirectNioEncoder(byteBuffer);
    }

    static com.google.protobuf.CodedOutputStream newSafeInstance(java.nio.ByteBuffer byteBuffer) {
        return new com.google.protobuf.CodedOutputStream.SafeDirectNioEncoder(byteBuffer);
    }

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    @java.lang.Deprecated
    public static com.google.protobuf.CodedOutputStream newInstance(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        return newInstance(byteBuffer);
    }

    static com.google.protobuf.CodedOutputStream newInstance(com.google.protobuf.ByteOutput byteOutput, int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("bufferSize must be_renamed positive");
        }
        return new com.google.protobuf.CodedOutputStream.ByteOutputEncoder(byteOutput, i_renamed);
    }

    private CodedOutputStream() {
    }

    public final void writeSInt32(int i_renamed, int i2) throws java.io.IOException {
        writeUInt32(i_renamed, encodeZigZag32(i2));
    }

    public final void writeSFixed32(int i_renamed, int i2) throws java.io.IOException {
        writeFixed32(i_renamed, i2);
    }

    public final void writeInt64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeUInt64(i_renamed, j_renamed);
    }

    public final void writeSInt64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeUInt64(i_renamed, encodeZigZag64(j_renamed));
    }

    public final void writeSFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeFixed64(i_renamed, j_renamed);
    }

    public final void writeFloat(int i_renamed, float f_renamed) throws java.io.IOException {
        writeFixed32(i_renamed, java.lang.Float.floatToRawIntBits(f_renamed));
    }

    public final void writeDouble(int i_renamed, double d_renamed) throws java.io.IOException {
        writeFixed64(i_renamed, java.lang.Double.doubleToRawLongBits(d_renamed));
    }

    public final void writeEnum(int i_renamed, int i2) throws java.io.IOException {
        writeInt32(i_renamed, i2);
    }

    public final void writeRawByte(byte b2) throws java.io.IOException {
        write(b2);
    }

    public final void writeRawByte(int i_renamed) throws java.io.IOException {
        write((byte) i_renamed);
    }

    public final void writeRawBytes(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        write(bArr, i_renamed, i2);
    }

    public final void writeRawBytes(com.google.protobuf.ByteString byteString) throws java.io.IOException {
        byteString.writeTo(this);
    }

    public final void writeSInt32NoTag(int i_renamed) throws java.io.IOException {
        writeUInt32NoTag(encodeZigZag32(i_renamed));
    }

    public final void writeSFixed32NoTag(int i_renamed) throws java.io.IOException {
        writeFixed32NoTag(i_renamed);
    }

    public final void writeInt64NoTag(long j_renamed) throws java.io.IOException {
        writeUInt64NoTag(j_renamed);
    }

    public final void writeSInt64NoTag(long j_renamed) throws java.io.IOException {
        writeUInt64NoTag(encodeZigZag64(j_renamed));
    }

    public final void writeSFixed64NoTag(long j_renamed) throws java.io.IOException {
        writeFixed64NoTag(j_renamed);
    }

    public final void writeFloatNoTag(float f_renamed) throws java.io.IOException {
        writeFixed32NoTag(java.lang.Float.floatToRawIntBits(f_renamed));
    }

    public final void writeDoubleNoTag(double d_renamed) throws java.io.IOException {
        writeFixed64NoTag(java.lang.Double.doubleToRawLongBits(d_renamed));
    }

    public final void writeBoolNoTag(boolean z_renamed) throws java.io.IOException {
        write(z_renamed ? (byte) 1 : (byte) 0);
    }

    public final void writeEnumNoTag(int i_renamed) throws java.io.IOException {
        writeInt32NoTag(i_renamed);
    }

    public final void writeByteArrayNoTag(byte[] bArr) throws java.io.IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public static int computeInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeInt32SizeNoTag(i2);
    }

    public static int computeUInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeUInt32SizeNoTag(i2);
    }

    public static int computeSInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeSInt32SizeNoTag(i2);
    }

    public static int computeFixed32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeInt64SizeNoTag(j_renamed);
    }

    public static int computeUInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeUInt64SizeNoTag(j_renamed);
    }

    public static int computeSInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeSInt64SizeNoTag(j_renamed);
    }

    public static int computeFixed64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeFixed64SizeNoTag(j_renamed);
    }

    public static int computeSFixed64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeSFixed64SizeNoTag(j_renamed);
    }

    public static int computeFloatSize(int i_renamed, float f_renamed) {
        return computeTagSize(i_renamed) + computeFloatSizeNoTag(f_renamed);
    }

    public static int computeDoubleSize(int i_renamed, double d_renamed) {
        return computeTagSize(i_renamed) + computeDoubleSizeNoTag(d_renamed);
    }

    public static int computeBoolSize(int i_renamed, boolean z_renamed) {
        return computeTagSize(i_renamed) + computeBoolSizeNoTag(z_renamed);
    }

    public static int computeEnumSize(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeEnumSizeNoTag(i2);
    }

    public static int computeStringSize(int i_renamed, java.lang.String str) {
        return computeTagSize(i_renamed) + computeStringSizeNoTag(str);
    }

    public static int computeBytesSize(int i_renamed, com.google.protobuf.ByteString byteString) {
        return computeTagSize(i_renamed) + computeBytesSizeNoTag(byteString);
    }

    public static int computeByteArraySize(int i_renamed, byte[] bArr) {
        return computeTagSize(i_renamed) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteBufferSize(int i_renamed, java.nio.ByteBuffer byteBuffer) {
        return computeTagSize(i_renamed) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeLazyFieldSize(int i_renamed, com.google.protobuf.LazyFieldLite lazyFieldLite) {
        return computeTagSize(i_renamed) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeMessageSize(int i_renamed, com.google.protobuf.MessageLite messageLite) {
        return computeTagSize(i_renamed) + computeMessageSizeNoTag(messageLite);
    }

    static int computeMessageSize(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) {
        return computeTagSize(i_renamed) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSetExtensionSize(int i_renamed, com.google.protobuf.MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i_renamed) + computeMessageSize(3, messageLite);
    }

    public static int computeRawMessageSetExtensionSize(int i_renamed, com.google.protobuf.ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i_renamed) + computeBytesSize(3, byteString);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i_renamed, com.google.protobuf.LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i_renamed) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeTagSize(int i_renamed) {
        return computeUInt32SizeNoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, 0));
    }

    public static int computeInt32SizeNoTag(int i_renamed) {
        if (i_renamed >= 0) {
            return computeUInt32SizeNoTag(i_renamed);
        }
        return 10;
    }

    public static int computeSInt32SizeNoTag(int i_renamed) {
        return computeUInt32SizeNoTag(encodeZigZag32(i_renamed));
    }

    public static int computeInt64SizeNoTag(long j_renamed) {
        return computeUInt64SizeNoTag(j_renamed);
    }

    public static int computeSInt64SizeNoTag(long j_renamed) {
        return computeUInt64SizeNoTag(encodeZigZag64(j_renamed));
    }

    public static int computeEnumSizeNoTag(int i_renamed) {
        return computeInt32SizeNoTag(i_renamed);
    }

    public static int computeStringSizeNoTag(java.lang.String str) {
        int length;
        try {
            length = com.google.protobuf.Utf8.encodedLength(str);
        } catch (com.google.protobuf.Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(com.google.protobuf.Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeLazyFieldSizeNoTag(com.google.protobuf.LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeBytesSizeNoTag(com.google.protobuf.ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSizeNoTag(java.nio.ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeMessageSizeNoTag(com.google.protobuf.MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    static int computeMessageSizeNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) {
        return computeLengthDelimitedFieldSize(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    static int computeLengthDelimitedFieldSize(int i_renamed) {
        return computeUInt32SizeNoTag(i_renamed) + i_renamed;
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new java.lang.IllegalStateException("Did not write as_renamed much data as_renamed expected.");
        }
    }

    public static class OutOfSpaceException extends java.io.IOException {
        private static final java.lang.String MESSAGE = "CodedOutputStream was writing to a_renamed flat byte array and ran out of_renamed space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(java.lang.String str) {
            super("CodedOutputStream was writing to a_renamed flat byte array and ran out of_renamed space.: " + str);
        }

        OutOfSpaceException(java.lang.Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(java.lang.String str, java.lang.Throwable th) {
            super("CodedOutputStream was writing to a_renamed flat byte array and ran out of_renamed space.: " + str, th);
        }
    }

    final void inefficientWriteStringNoTag(java.lang.String str, com.google.protobuf.Utf8.UnpairedSurrogateException unpairedSurrogateException) throws java.io.IOException {
        logger.log(java.util.logging.Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (java.lang.Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(com.google.protobuf.Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (com.google.protobuf.CodedOutputStream.OutOfSpaceException e_renamed) {
            throw e_renamed;
        } catch (java.lang.IndexOutOfBoundsException e2) {
            throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
        }
    }

    @java.lang.Deprecated
    public final void writeGroup(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeTag(i_renamed, 3);
        writeGroupNoTag(messageLite);
        writeTag(i_renamed, 4);
    }

    @java.lang.Deprecated
    final void writeGroup(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
        writeTag(i_renamed, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i_renamed, 4);
    }

    @java.lang.Deprecated
    public final void writeGroupNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        messageLite.writeTo(this);
    }

    @java.lang.Deprecated
    final void writeGroupNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    @java.lang.Deprecated
    public static int computeGroupSize(int i_renamed, com.google.protobuf.MessageLite messageLite) {
        return (computeTagSize(i_renamed) * 2) + computeGroupSizeNoTag(messageLite);
    }

    @java.lang.Deprecated
    static int computeGroupSize(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) {
        return (computeTagSize(i_renamed) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @java.lang.Deprecated
    public static int computeGroupSizeNoTag(com.google.protobuf.MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @java.lang.Deprecated
    static int computeGroupSizeNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) {
        return ((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    @java.lang.Deprecated
    public final void writeRawVarint32(int i_renamed) throws java.io.IOException {
        writeUInt32NoTag(i_renamed);
    }

    @java.lang.Deprecated
    public final void writeRawVarint64(long j_renamed) throws java.io.IOException {
        writeUInt64NoTag(j_renamed);
    }

    @java.lang.Deprecated
    public static int computeRawVarint32Size(int i_renamed) {
        return computeUInt32SizeNoTag(i_renamed);
    }

    @java.lang.Deprecated
    public static int computeRawVarint64Size(long j_renamed) {
        return computeUInt64SizeNoTag(j_renamed);
    }

    @java.lang.Deprecated
    public final void writeRawLittleEndian32(int i_renamed) throws java.io.IOException {
        writeFixed32NoTag(i_renamed);
    }

    @java.lang.Deprecated
    public final void writeRawLittleEndian64(long j_renamed) throws java.io.IOException {
        writeFixed64NoTag(j_renamed);
    }

    private static class ArrayEncoder extends com.google.protobuf.CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        ArrayEncoder(byte[] bArr, int i_renamed, int i2) {
            super();
            if (bArr == null) {
                throw new java.lang.NullPointerException(com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
            }
            int i3 = i_renamed + i2;
            if ((i_renamed | i2 | (bArr.length - i3)) < 0) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Array range is_renamed invalid. Buffer.length=%d_renamed, offset=%d_renamed, length=%d_renamed", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = i_renamed;
            this.position = i_renamed;
            this.limit = i3;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 1);
            writeFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            write(z_renamed ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException {
            writeByteArray(i_renamed, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(i2);
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b2) throws java.io.IOException {
            try {
                byte[] bArr = this.buffer;
                int i_renamed = this.position;
                this.position = i_renamed + 1;
                bArr[i_renamed] = b2;
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), 1), e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                writeUInt32NoTag(i_renamed);
            } else {
                writeUInt64NoTag(i_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
            if (!com.google.protobuf.CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || com.google.protobuf.Android.isOnAndroidDevice() || spaceLeft() < 5) {
                while ((i_renamed & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i_renamed & 127) | 128);
                        i_renamed >>>= 7;
                    } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                        throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), 1), e_renamed);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i_renamed;
                return;
            }
            if ((i_renamed & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr3, i4, (byte) i_renamed);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            com.google.protobuf.UnsafeUtil.putByte(bArr4, i5, (byte) (i_renamed | 128));
            int i6 = i_renamed >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            com.google.protobuf.UnsafeUtil.putByte(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            com.google.protobuf.UnsafeUtil.putByte(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            com.google.protobuf.UnsafeUtil.putByte(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.buffer;
            int i15 = this.position;
            this.position = i15 + 1;
            com.google.protobuf.UnsafeUtil.putByte(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i_renamed & 255);
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) ((i_renamed >> 8) & 255);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((i_renamed >> 16) & 255);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) ((i_renamed >> 24) & 255);
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), 1), e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
            if (com.google.protobuf.CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j_renamed & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i_renamed = this.position;
                    this.position = i_renamed + 1;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, i_renamed, (byte) ((((int) j_renamed) & 127) | 128));
                    j_renamed >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr2, i2, (byte) j_renamed);
                return;
            }
            while ((j_renamed & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j_renamed) & 127) | 128);
                    j_renamed >>>= 7;
                } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), 1), e_renamed);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j_renamed;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
            try {
                byte[] bArr = this.buffer;
                int i_renamed = this.position;
                this.position = i_renamed + 1;
                bArr[i_renamed] = (byte) (((int) j_renamed) & 255);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) (((int) (j_renamed >> 8)) & 255);
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) (((int) (j_renamed >> 16)) & 255);
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) (((int) (j_renamed >> 24)) & 255);
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) (((int) (j_renamed >> 32)) & 255);
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) (((int) (j_renamed >> 40)) & 255);
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) (((int) (j_renamed >> 48)) & 255);
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (((int) (j_renamed >> 56)) & 255);
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), 1), e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            try {
                java.lang.System.arraycopy(bArr, i_renamed, this.buffer, this.position, i2);
                this.position += i2;
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), java.lang.Integer.valueOf(i2)), e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Integer.valueOf(this.position), java.lang.Integer.valueOf(this.limit), java.lang.Integer.valueOf(iRemaining)), e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(java.lang.String str) throws java.io.IOException {
            int i_renamed = this.position;
            try {
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    this.position = i_renamed + iComputeUInt32SizeNoTag2;
                    int iEncode = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, spaceLeft());
                    this.position = i_renamed;
                    writeUInt32NoTag((iEncode - i_renamed) - iComputeUInt32SizeNoTag2);
                    this.position = iEncode;
                } else {
                    writeUInt32NoTag(com.google.protobuf.Utf8.encodedLength(str));
                    this.position = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
            } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e_renamed) {
                this.position = i_renamed;
                inefficientWriteStringNoTag(str, e_renamed);
            } catch (java.lang.IndexOutOfBoundsException e2) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }
    }

    private static final class HeapNioEncoder extends com.google.protobuf.CodedOutputStream.ArrayEncoder {
        private final java.nio.ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(java.nio.ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    private static final class SafeDirectNioEncoder extends com.google.protobuf.CodedOutputStream {
        private final java.nio.ByteBuffer buffer;
        private final int initialPosition;
        private final java.nio.ByteBuffer originalBuffer;

        SafeDirectNioEncoder(java.nio.ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(java.nio.ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 1);
            writeFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            write(z_renamed ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException {
            writeByteArray(i_renamed, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws java.io.IOException {
            try {
                this.buffer.put(b2);
            } catch (java.nio.BufferOverflowException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(i2);
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                writeUInt32NoTag(i_renamed);
            } else {
                writeUInt64NoTag(i_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
            while ((i_renamed & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((i_renamed & 127) | 128));
                    i_renamed >>>= 7;
                } catch (java.nio.BufferOverflowException e_renamed) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
                }
            }
            this.buffer.put((byte) i_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
            try {
                this.buffer.putInt(i_renamed);
            } catch (java.nio.BufferOverflowException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
            while (((-128) & j_renamed) != 0) {
                try {
                    this.buffer.put((byte) ((((int) j_renamed) & 127) | 128));
                    j_renamed >>>= 7;
                } catch (java.nio.BufferOverflowException e_renamed) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
                }
            }
            this.buffer.put((byte) j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
            try {
                this.buffer.putLong(j_renamed);
            } catch (java.nio.BufferOverflowException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            try {
                this.buffer.put(bArr, i_renamed, i2);
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            } catch (java.nio.BufferOverflowException e2) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (java.nio.BufferOverflowException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
            int iPosition = this.buffer.position();
            try {
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iPosition2 = this.buffer.position() + iComputeUInt32SizeNoTag2;
                    this.buffer.position(iPosition2);
                    encode(str);
                    int iPosition3 = this.buffer.position();
                    this.buffer.position(iPosition);
                    writeUInt32NoTag(iPosition3 - iPosition2);
                    this.buffer.position(iPosition3);
                } else {
                    writeUInt32NoTag(com.google.protobuf.Utf8.encodedLength(str));
                    encode(str);
                }
            } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e_renamed) {
                this.buffer.position(iPosition);
                inefficientWriteStringNoTag(str, e_renamed);
            } catch (java.lang.IllegalArgumentException e2) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        private void encode(java.lang.String str) throws java.io.IOException {
            try {
                com.google.protobuf.Utf8.encodeUtf8(str, this.buffer);
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }
    }

    private static final class UnsafeDirectNioEncoder extends com.google.protobuf.CodedOutputStream {
        private final long address;
        private final java.nio.ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final java.nio.ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(java.nio.ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(java.nio.ByteOrder.LITTLE_ENDIAN);
            this.address = com.google.protobuf.UnsafeUtil.addressOffset(byteBuffer);
            this.initialPosition = this.address + byteBuffer.position();
            this.limit = this.address + byteBuffer.limit();
            this.oneVarintLimit = this.limit - 10;
            this.position = this.initialPosition;
        }

        static boolean isSupported() {
            return com.google.protobuf.UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
            writeTag(i_renamed, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            writeUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
            writeTag(i_renamed, 1);
            writeFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
            writeTag(i_renamed, 0);
            write(z_renamed ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException {
            writeByteArray(i_renamed, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws java.io.IOException {
            long j_renamed = this.position;
            if (j_renamed >= this.limit) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(this.limit), 1));
            }
            this.position = 1 + j_renamed;
            com.google.protobuf.UnsafeUtil.putByte(j_renamed, b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(i2);
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                writeUInt32NoTag(i_renamed);
            } else {
                writeUInt64NoTag(i_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i_renamed & (-128)) != 0) {
                    long j_renamed = this.position;
                    this.position = j_renamed + 1;
                    com.google.protobuf.UnsafeUtil.putByte(j_renamed, (byte) ((i_renamed & 127) | 128));
                    i_renamed >>>= 7;
                }
                long j2 = this.position;
                this.position = 1 + j2;
                com.google.protobuf.UnsafeUtil.putByte(j2, (byte) i_renamed);
                return;
            }
            while (true) {
                long j3 = this.position;
                if (j3 >= this.limit) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(this.limit), 1));
                }
                if ((i_renamed & (-128)) == 0) {
                    this.position = 1 + j3;
                    com.google.protobuf.UnsafeUtil.putByte(j3, (byte) i_renamed);
                    return;
                } else {
                    this.position = j3 + 1;
                    com.google.protobuf.UnsafeUtil.putByte(j3, (byte) ((i_renamed & 127) | 128));
                    i_renamed >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
            this.buffer.putInt(bufferPos(this.position), i_renamed);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j_renamed & (-128)) != 0) {
                    long j2 = this.position;
                    this.position = j2 + 1;
                    com.google.protobuf.UnsafeUtil.putByte(j2, (byte) ((((int) j_renamed) & 127) | 128));
                    j_renamed >>>= 7;
                }
                long j3 = this.position;
                this.position = 1 + j3;
                com.google.protobuf.UnsafeUtil.putByte(j3, (byte) j_renamed);
                return;
            }
            while (true) {
                long j4 = this.position;
                if (j4 >= this.limit) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Long.valueOf(j4), java.lang.Long.valueOf(this.limit), 1));
                }
                if ((j_renamed & (-128)) == 0) {
                    this.position = 1 + j4;
                    com.google.protobuf.UnsafeUtil.putByte(j4, (byte) j_renamed);
                    return;
                } else {
                    this.position = j4 + 1;
                    com.google.protobuf.UnsafeUtil.putByte(j4, (byte) ((((int) j_renamed) & 127) | 128));
                    j_renamed >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
            this.buffer.putLong(bufferPos(this.position), j_renamed);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            if (bArr != null && i_renamed >= 0 && i2 >= 0 && bArr.length - i2 >= i_renamed) {
                long j_renamed = i2;
                long j2 = this.limit - j_renamed;
                long j3 = this.position;
                if (j2 >= j3) {
                    com.google.protobuf.UnsafeUtil.copyMemory(bArr, i_renamed, j3, j_renamed);
                    this.position += j_renamed;
                    return;
                }
            }
            if (bArr == null) {
                throw new java.lang.NullPointerException(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE);
            }
            throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(java.lang.String.format("Pos: %d_renamed, limit: %d_renamed, len: %d_renamed", java.lang.Long.valueOf(this.position), java.lang.Long.valueOf(this.limit), java.lang.Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += iRemaining;
            } catch (java.nio.BufferOverflowException e_renamed) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
            long j_renamed = this.position;
            try {
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                    this.buffer.position(iBufferPos);
                    com.google.protobuf.Utf8.encodeUtf8(str, this.buffer);
                    int iPosition = this.buffer.position() - iBufferPos;
                    writeUInt32NoTag(iPosition);
                    this.position += iPosition;
                } else {
                    int iEncodedLength = com.google.protobuf.Utf8.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    com.google.protobuf.Utf8.encodeUtf8(str, this.buffer);
                    this.position += iEncodedLength;
                }
            } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e_renamed) {
                this.position = j_renamed;
                repositionBuffer(this.position);
                inefficientWriteStringNoTag(str, e_renamed);
            } catch (java.lang.IllegalArgumentException e2) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
            } catch (java.lang.IndexOutOfBoundsException e3) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        private void repositionBuffer(long j_renamed) {
            this.buffer.position(bufferPos(j_renamed));
        }

        private int bufferPos(long j_renamed) {
            return (int) (j_renamed - this.address);
        }
    }

    private static abstract class AbstractBufferedEncoder extends com.google.protobuf.CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i_renamed) {
            super();
            if (i_renamed < 0) {
                throw new java.lang.IllegalArgumentException("bufferSize must be_renamed >= 0");
            }
            this.buffer = new byte[java.lang.Math.max(i_renamed, 20)];
            this.limit = this.buffer.length;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new java.lang.UnsupportedOperationException("spaceLeft() can only be_renamed called on_renamed CodedOutputStreams that are writing to a_renamed flat array or ByteBuffer.");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        final void buffer(byte b2) {
            byte[] bArr = this.buffer;
            int i_renamed = this.position;
            this.position = i_renamed + 1;
            bArr[i_renamed] = b2;
            this.totalBytesWritten++;
        }

        final void bufferTag(int i_renamed, int i2) {
            bufferUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        final void bufferInt32NoTag(int i_renamed) {
            if (i_renamed >= 0) {
                bufferUInt32NoTag(i_renamed);
            } else {
                bufferUInt64NoTag(i_renamed);
            }
        }

        final void bufferUInt32NoTag(int i_renamed) {
            if (com.google.protobuf.CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j_renamed = this.position;
                while ((i_renamed & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, i2, (byte) ((i_renamed & 127) | 128));
                    i_renamed >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr2, i3, (byte) i_renamed);
                this.totalBytesWritten += (int) (this.position - j_renamed);
                return;
            }
            while ((i_renamed & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((i_renamed & 127) | 128);
                this.totalBytesWritten++;
                i_renamed >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) i_renamed;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long j_renamed) {
            if (com.google.protobuf.CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j2 = this.position;
                while ((j_renamed & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i_renamed = this.position;
                    this.position = i_renamed + 1;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, i_renamed, (byte) ((((int) j_renamed) & 127) | 128));
                    j_renamed >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                com.google.protobuf.UnsafeUtil.putByte(bArr2, i2, (byte) j_renamed);
                this.totalBytesWritten += (int) (this.position - j2);
                return;
            }
            while ((j_renamed & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((((int) j_renamed) & 127) | 128);
                this.totalBytesWritten++;
                j_renamed >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j_renamed;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int i_renamed) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (i_renamed & 255);
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) ((i_renamed >> 8) & 255);
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = (byte) ((i_renamed >> 16) & 255);
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = (byte) ((i_renamed >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long j_renamed) {
            byte[] bArr = this.buffer;
            int i_renamed = this.position;
            this.position = i_renamed + 1;
            bArr[i_renamed] = (byte) (j_renamed & 255);
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) ((j_renamed >> 8) & 255);
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) ((j_renamed >> 16) & 255);
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = (byte) (255 & (j_renamed >> 24));
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = (byte) (((int) (j_renamed >> 32)) & 255);
            int i6 = this.position;
            this.position = i6 + 1;
            bArr[i6] = (byte) (((int) (j_renamed >> 40)) & 255);
            int i7 = this.position;
            this.position = i7 + 1;
            bArr[i7] = (byte) (((int) (j_renamed >> 48)) & 255);
            int i8 = this.position;
            this.position = i8 + 1;
            bArr[i8] = (byte) (((int) (j_renamed >> 56)) & 255);
            this.totalBytesWritten += 8;
        }
    }

    private static final class ByteOutputEncoder extends com.google.protobuf.CodedOutputStream.AbstractBufferedEncoder {
        private final com.google.protobuf.ByteOutput out;

        ByteOutputEncoder(com.google.protobuf.ByteOutput byteOutput, int i_renamed) {
            super(i_renamed);
            if (byteOutput == null) {
                throw new java.lang.NullPointerException("out");
            }
            this.out = byteOutput;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(14);
            bufferTag(i_renamed, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(18);
            bufferTag(i_renamed, 1);
            bufferFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
            flushIfNotAvailable(11);
            bufferTag(i_renamed, 0);
            buffer(z_renamed ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException {
            writeByteArray(i_renamed, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(i2);
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws java.io.IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                writeUInt32NoTag(i_renamed);
            } else {
                writeUInt64NoTag(i_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(length);
            int i_renamed = iComputeUInt32SizeNoTag + length;
            if (i_renamed > this.limit) {
                byte[] bArr = new byte[length];
                int iEncode = com.google.protobuf.Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(iEncode);
                writeLazy(bArr, 0, iEncode);
                return;
            }
            if (i_renamed > this.limit - this.position) {
                doFlush();
            }
            int i2 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    this.position = i2 + iComputeUInt32SizeNoTag2;
                    int iEncode2 = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, this.limit - this.position);
                    this.position = i2;
                    int i3 = (iEncode2 - i2) - iComputeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i3);
                    this.position = iEncode2;
                    this.totalBytesWritten += i3;
                } else {
                    int iEncodedLength = com.google.protobuf.Utf8.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                }
            } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e_renamed) {
                this.totalBytesWritten -= this.position - i2;
                this.position = i2;
                inefficientWriteStringNoTag(str, e_renamed);
            } catch (java.lang.IndexOutOfBoundsException e2) {
                throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws java.io.IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            flush();
            this.out.write(bArr, i_renamed, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            flush();
            this.out.writeLazy(bArr, i_renamed, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        private void flushIfNotAvailable(int i_renamed) throws java.io.IOException {
            if (this.limit - this.position < i_renamed) {
                doFlush();
            }
        }

        private void doFlush() throws java.io.IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class OutputStreamEncoder extends com.google.protobuf.CodedOutputStream.AbstractBufferedEncoder {
        private final java.io.OutputStream out;

        OutputStreamEncoder(java.io.OutputStream outputStream, int i_renamed) {
            super(i_renamed);
            if (outputStream == null) {
                throw new java.lang.NullPointerException("out");
            }
            this.out = outputStream;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(com.google.protobuf.WireFormat.makeTag(i_renamed, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
            flushIfNotAvailable(14);
            bufferTag(i_renamed, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(20);
            bufferTag(i_renamed, 0);
            bufferUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(18);
            bufferTag(i_renamed, 1);
            bufferFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
            flushIfNotAvailable(11);
            bufferTag(i_renamed, 0);
            buffer(z_renamed ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr) throws java.io.IOException {
            writeByteArray(i_renamed, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i_renamed, byte[] bArr, int i2, int i3) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i_renamed, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            writeUInt32NoTag(i2);
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int i_renamed, com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeTag(i_renamed, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i_renamed, com.google.protobuf.ByteString byteString) throws java.io.IOException {
            writeTag(1, 3);
            writeUInt32(2, i_renamed);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(com.google.protobuf.MessageLite messageLite, com.google.protobuf.Schema schema) throws java.io.IOException {
            writeUInt32NoTag(((com.google.protobuf.AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws java.io.IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i_renamed) throws java.io.IOException {
            if (i_renamed >= 0) {
                writeUInt32NoTag(i_renamed);
            } else {
                writeUInt64NoTag(i_renamed);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j_renamed);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(length);
                int i_renamed = iComputeUInt32SizeNoTag + length;
                if (i_renamed > this.limit) {
                    byte[] bArr = new byte[length];
                    int iEncode = com.google.protobuf.Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(iEncode);
                    writeLazy(bArr, 0, iEncode);
                    return;
                }
                if (i_renamed > this.limit - this.position) {
                    doFlush();
                }
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                int i2 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        this.position = i2 + iComputeUInt32SizeNoTag2;
                        int iEncode2 = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, this.limit - this.position);
                        this.position = i2;
                        iEncodedLength = (iEncode2 - i2) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iEncode2;
                    } else {
                        iEncodedLength = com.google.protobuf.Utf8.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = com.google.protobuf.Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e_renamed) {
                    this.totalBytesWritten -= this.position - i2;
                    this.position = i2;
                    throw e_renamed;
                } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
                    throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException(e2);
                }
            } catch (com.google.protobuf.Utf8.UnpairedSurrogateException e3) {
                inefficientWriteStringNoTag(str, e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws java.io.IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            if (this.limit - this.position >= i2) {
                java.lang.System.arraycopy(bArr, i_renamed, this.buffer, this.position, i2);
                this.position += i2;
                this.totalBytesWritten += i2;
                return;
            }
            int i3 = this.limit - this.position;
            java.lang.System.arraycopy(bArr, i_renamed, this.buffer, this.position, i3);
            int i4 = i_renamed + i3;
            int i5 = i2 - i3;
            this.position = this.limit;
            this.totalBytesWritten += i3;
            doFlush();
            if (i5 <= this.limit) {
                java.lang.System.arraycopy(bArr, i4, this.buffer, 0, i5);
                this.position = i5;
            } else {
                this.out.write(bArr, i4, i5);
            }
            this.totalBytesWritten += i5;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            write(bArr, i_renamed, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            int iRemaining = byteBuffer.remaining();
            if (this.limit - this.position >= iRemaining) {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int i_renamed = this.limit - this.position;
            byteBuffer.get(this.buffer, this.position, i_renamed);
            int i2 = iRemaining - i_renamed;
            this.position = this.limit;
            this.totalBytesWritten += i_renamed;
            doFlush();
            while (i2 > this.limit) {
                byteBuffer.get(this.buffer, 0, this.limit);
                this.out.write(this.buffer, 0, this.limit);
                i2 -= this.limit;
                this.totalBytesWritten += this.limit;
            }
            byteBuffer.get(this.buffer, 0, i2);
            this.position = i2;
            this.totalBytesWritten += i2;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            write(byteBuffer);
        }

        private void flushIfNotAvailable(int i_renamed) throws java.io.IOException {
            if (this.limit - this.position < i_renamed) {
                doFlush();
            }
        }

        private void doFlush() throws java.io.IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }
}
