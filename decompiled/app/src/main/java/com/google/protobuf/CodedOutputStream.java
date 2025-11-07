package com.google.protobuf;

import com.android.providers.downloads.Downloads;
import com.google.protobuf.Utf8;
import com.oplus.ocs.camera.CameraParameter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double IntrinsicsJvm.kt_5) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int OplusGLSurfaceView_13) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long OplusGLSurfaceView_15) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float COUIBaseListPopupWindow_12) {
        return 4;
    }

    static int computePreferredBufferSize(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > 4096) {
            return 4096;
        }
        return OplusGLSurfaceView_13;
    }

    public static int computeSFixed32SizeNoTag(int OplusGLSurfaceView_13) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long OplusGLSurfaceView_15) {
        return 8;
    }

    public static int computeUInt32SizeNoTag(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & (-128)) == 0) {
            return 1;
        }
        if ((OplusGLSurfaceView_13 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & OplusGLSurfaceView_13) == 0) {
            return 3;
        }
        return (OplusGLSurfaceView_13 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64SizeNoTag(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13;
        if (((-128) & OplusGLSurfaceView_15) == 0) {
            return 1;
        }
        if (OplusGLSurfaceView_15 < 0) {
            return 10;
        }
        if (((-34359738368L) & OplusGLSurfaceView_15) != 0) {
            OplusGLSurfaceView_13 = 6;
            OplusGLSurfaceView_15 >>>= 28;
        } else {
            OplusGLSurfaceView_13 = 2;
        }
        if (((-2097152) & OplusGLSurfaceView_15) != 0) {
            OplusGLSurfaceView_13 += 2;
            OplusGLSurfaceView_15 >>>= 14;
        }
        return (OplusGLSurfaceView_15 & (-16384)) != 0 ? OplusGLSurfaceView_13 + 1 : OplusGLSurfaceView_13;
    }

    public static int encodeZigZag32(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 >> 31) ^ (OplusGLSurfaceView_13 << 1);
    }

    public static long encodeZigZag64(long OplusGLSurfaceView_15) {
        return (OplusGLSurfaceView_15 >> 63) ^ (OplusGLSurfaceView_15 << 1);
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public abstract int spaceLeft();

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b2) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException;

    public abstract void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException;

    abstract void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public abstract void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException;

    public abstract void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    public abstract void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException;

    public abstract void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException;

    abstract void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException;

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public abstract void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException;

    public abstract void writeString(int OplusGLSurfaceView_13, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException;

    public abstract void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException;

    public abstract void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException;

    public abstract void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException;

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int OplusGLSurfaceView_13) {
        return new OutputStreamEncoder(outputStream, OplusGLSurfaceView_13);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return new ArrayEncoder(bArr, OplusGLSurfaceView_13, i2);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        return newInstance(byteBuffer);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("bufferSize must be positive");
        }
        return new ByteOutputEncoder(byteOutput, OplusGLSurfaceView_13);
    }

    private CodedOutputStream() {
    }

    public final void writeSInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeUInt32(OplusGLSurfaceView_13, encodeZigZag32(i2));
    }

    public final void writeSFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeFixed32(OplusGLSurfaceView_13, i2);
    }

    public final void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeUInt64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    public final void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeUInt64(OplusGLSurfaceView_13, encodeZigZag64(OplusGLSurfaceView_15));
    }

    public final void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeFixed64(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    public final void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IOException {
        writeFixed32(OplusGLSurfaceView_13, Float.floatToRawIntBits(COUIBaseListPopupWindow_12));
    }

    public final void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws IOException {
        writeFixed64(OplusGLSurfaceView_13, Double.doubleToRawLongBits(IntrinsicsJvm.kt_5));
    }

    public final void writeEnum(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeInt32(OplusGLSurfaceView_13, i2);
    }

    public final void writeRawByte(byte b2) throws IOException {
        write(b2);
    }

    public final void writeRawByte(int OplusGLSurfaceView_13) throws IOException {
        write((byte) OplusGLSurfaceView_13);
    }

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        write(bArr, OplusGLSurfaceView_13, i2);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo(this);
    }

    public final void writeSInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeUInt32NoTag(encodeZigZag32(OplusGLSurfaceView_13));
    }

    public final void writeSFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeFixed32NoTag(OplusGLSurfaceView_13);
    }

    public final void writeInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeUInt64NoTag(OplusGLSurfaceView_15);
    }

    public final void writeSInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeUInt64NoTag(encodeZigZag64(OplusGLSurfaceView_15));
    }

    public final void writeSFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeFixed64NoTag(OplusGLSurfaceView_15);
    }

    public final void writeFloatNoTag(float COUIBaseListPopupWindow_12) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(COUIBaseListPopupWindow_12));
    }

    public final void writeDoubleNoTag(double IntrinsicsJvm.kt_5) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(IntrinsicsJvm.kt_5));
    }

    public final void writeBoolNoTag(boolean z) throws IOException {
        write(z ? (byte) 1 : (byte) 0);
    }

    public final void writeEnumNoTag(int OplusGLSurfaceView_13) throws IOException {
        writeInt32NoTag(OplusGLSurfaceView_13);
    }

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public static int computeInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeInt32SizeNoTag(i2);
    }

    public static int computeUInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeUInt32SizeNoTag(i2);
    }

    public static int computeSInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSInt32SizeNoTag(i2);
    }

    public static int computeFixed32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeUInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeUInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeSInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeFixed64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFixed64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeSFixed64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSFixed64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeFloatSize(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFloatSizeNoTag(COUIBaseListPopupWindow_12);
    }

    public static int computeDoubleSize(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        return computeTagSize(OplusGLSurfaceView_13) + computeDoubleSizeNoTag(IntrinsicsJvm.kt_5);
    }

    public static int computeBoolSize(int OplusGLSurfaceView_13, boolean z) {
        return computeTagSize(OplusGLSurfaceView_13) + computeBoolSizeNoTag(z);
    }

    public static int computeEnumSize(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeEnumSizeNoTag(i2);
    }

    public static int computeStringSize(int OplusGLSurfaceView_13, String str) {
        return computeTagSize(OplusGLSurfaceView_13) + computeStringSizeNoTag(str);
    }

    public static int computeBytesSize(int OplusGLSurfaceView_13, ByteString byteString) {
        return computeTagSize(OplusGLSurfaceView_13) + computeBytesSizeNoTag(byteString);
    }

    public static int computeByteArraySize(int OplusGLSurfaceView_13, byte[] bArr) {
        return computeTagSize(OplusGLSurfaceView_13) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteBufferSize(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) {
        return computeTagSize(OplusGLSurfaceView_13) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeLazyFieldSize(int OplusGLSurfaceView_13, LazyFieldLite lazyFieldLite) {
        return computeTagSize(OplusGLSurfaceView_13) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeMessageSize(int OplusGLSurfaceView_13, MessageLite messageLite) {
        return computeTagSize(OplusGLSurfaceView_13) + computeMessageSizeNoTag(messageLite);
    }

    static int computeMessageSize(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) {
        return computeTagSize(OplusGLSurfaceView_13) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSetExtensionSize(int OplusGLSurfaceView_13, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, OplusGLSurfaceView_13) + computeMessageSize(3, messageLite);
    }

    public static int computeRawMessageSetExtensionSize(int OplusGLSurfaceView_13, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, OplusGLSurfaceView_13) + computeBytesSize(3, byteString);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int OplusGLSurfaceView_13, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, OplusGLSurfaceView_13) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeTagSize(int OplusGLSurfaceView_13) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(OplusGLSurfaceView_13, 0));
    }

    public static int computeInt32SizeNoTag(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0) {
            return computeUInt32SizeNoTag(OplusGLSurfaceView_13);
        }
        return 10;
    }

    public static int computeSInt32SizeNoTag(int OplusGLSurfaceView_13) {
        return computeUInt32SizeNoTag(encodeZigZag32(OplusGLSurfaceView_13));
    }

    public static int computeInt64SizeNoTag(long OplusGLSurfaceView_15) {
        return computeUInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeSInt64SizeNoTag(long OplusGLSurfaceView_15) {
        return computeUInt64SizeNoTag(encodeZigZag64(OplusGLSurfaceView_15));
    }

    public static int computeEnumSizeNoTag(int OplusGLSurfaceView_13) {
        return computeInt32SizeNoTag(OplusGLSurfaceView_13);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    static int computeLengthDelimitedFieldSize(int OplusGLSurfaceView_13) {
        return computeUInt32SizeNoTag(OplusGLSurfaceView_13) + OplusGLSurfaceView_13;
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to PlatformImplementations.kt_3 flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to PlatformImplementations.kt_3 flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to PlatformImplementations.kt_3 flat byte array and ran out of space.: " + str, th);
        }
    }

    final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (OutOfSpaceException COUIBaseListPopupWindow_8) {
            throw COUIBaseListPopupWindow_8;
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException(e2);
        }
    }

    @Deprecated
    public final void writeGroup(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
        writeTag(OplusGLSurfaceView_13, 3);
        writeGroupNoTag(messageLite);
        writeTag(OplusGLSurfaceView_13, 4);
    }

    @Deprecated
    final void writeGroup(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(OplusGLSurfaceView_13, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(OplusGLSurfaceView_13, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    @Deprecated
    final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    @Deprecated
    public static int computeGroupSize(int OplusGLSurfaceView_13, MessageLite messageLite) {
        return (computeTagSize(OplusGLSurfaceView_13) * 2) + computeGroupSizeNoTag(messageLite);
    }

    @Deprecated
    static int computeGroupSize(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) {
        return (computeTagSize(OplusGLSurfaceView_13) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    @Deprecated
    public final void writeRawVarint32(int OplusGLSurfaceView_13) throws IOException {
        writeUInt32NoTag(OplusGLSurfaceView_13);
    }

    @Deprecated
    public final void writeRawVarint64(long OplusGLSurfaceView_15) throws IOException {
        writeUInt64NoTag(OplusGLSurfaceView_15);
    }

    @Deprecated
    public static int computeRawVarint32Size(int OplusGLSurfaceView_13) {
        return computeUInt32SizeNoTag(OplusGLSurfaceView_13);
    }

    @Deprecated
    public static int computeRawVarint64Size(long OplusGLSurfaceView_15) {
        return computeUInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int OplusGLSurfaceView_13) throws IOException {
        writeFixed32NoTag(OplusGLSurfaceView_13);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long OplusGLSurfaceView_15) throws IOException {
        writeFixed64NoTag(OplusGLSurfaceView_15);
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }

        ArrayEncoder(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException(CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
            }
            int i3 = OplusGLSurfaceView_13 + i2;
            if ((OplusGLSurfaceView_13 | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%IntrinsicsJvm.kt_5, offset=%IntrinsicsJvm.kt_5, length=%IntrinsicsJvm.kt_5", Integer.valueOf(bArr.length), Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = OplusGLSurfaceView_13;
            this.position = OplusGLSurfaceView_13;
            this.limit = i3;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 1);
            writeFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
            writeByteArray(OplusGLSurfaceView_13, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int OplusGLSurfaceView_13 = this.position;
                this.position = OplusGLSurfaceView_13 + 1;
                bArr[OplusGLSurfaceView_13] = b2;
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (OplusGLSurfaceView_13 >= 0) {
                writeUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                writeUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || Android.isOnAndroidDevice() || spaceLeft() < 5) {
                while ((OplusGLSurfaceView_13 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
                        OplusGLSurfaceView_13 >>>= 7;
                    } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                        throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), COUIBaseListPopupWindow_8);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) OplusGLSurfaceView_13;
                return;
            }
            if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                UnsafeUtil.putByte(bArr3, i4, (byte) OplusGLSurfaceView_13);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            UnsafeUtil.putByte(bArr4, i5, (byte) (OplusGLSurfaceView_13 | 128));
            int i6 = OplusGLSurfaceView_13 >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                UnsafeUtil.putByte(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            UnsafeUtil.putByte(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                UnsafeUtil.putByte(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            UnsafeUtil.putByte(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                UnsafeUtil.putByte(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            UnsafeUtil.putByte(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.buffer;
            int i15 = this.position;
            this.position = i15 + 1;
            UnsafeUtil.putByte(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (OplusGLSurfaceView_13 & 255);
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) ((OplusGLSurfaceView_13 >> 8) & 255);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((OplusGLSurfaceView_13 >> 16) & 255);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) ((OplusGLSurfaceView_13 >> 24) & 255);
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((OplusGLSurfaceView_15 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int OplusGLSurfaceView_13 = this.position;
                    this.position = OplusGLSurfaceView_13 + 1;
                    UnsafeUtil.putByte(bArr, OplusGLSurfaceView_13, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
                    OplusGLSurfaceView_15 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                UnsafeUtil.putByte(bArr2, i2, (byte) OplusGLSurfaceView_15);
                return;
            }
            while ((OplusGLSurfaceView_15 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128);
                    OplusGLSurfaceView_15 >>>= 7;
                } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                    throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), COUIBaseListPopupWindow_8);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) OplusGLSurfaceView_15;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int OplusGLSurfaceView_13 = this.position;
                this.position = OplusGLSurfaceView_13 + 1;
                bArr[OplusGLSurfaceView_13] = (byte) (((int) OplusGLSurfaceView_15) & 255);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) (((int) (OplusGLSurfaceView_15 >> 8)) & 255);
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) (((int) (OplusGLSurfaceView_15 >> 16)) & 255);
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) (((int) (OplusGLSurfaceView_15 >> 24)) & 255);
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) (((int) (OplusGLSurfaceView_15 >> 32)) & 255);
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) (((int) (OplusGLSurfaceView_15 >> 40)) & 255);
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) (((int) (OplusGLSurfaceView_15 >> 48)) & 255);
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (((int) (OplusGLSurfaceView_15 >> 56)) & 255);
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            try {
                System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(iRemaining)), COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int OplusGLSurfaceView_13 = this.position;
            try {
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    this.position = OplusGLSurfaceView_13 + iComputeUInt32SizeNoTag2;
                    int iEncode = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                    this.position = OplusGLSurfaceView_13;
                    writeUInt32NoTag((iEncode - OplusGLSurfaceView_13) - iComputeUInt32SizeNoTag2);
                    this.position = iEncode;
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException COUIBaseListPopupWindow_8) {
                this.position = OplusGLSurfaceView_13;
                inefficientWriteStringNoTag(str, COUIBaseListPopupWindow_8);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
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

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 1);
            writeFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
            writeByteArray(OplusGLSurfaceView_13, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            try {
                this.buffer.put(b2);
            } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (OplusGLSurfaceView_13 >= 0) {
                writeUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                writeUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            while ((OplusGLSurfaceView_13 & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((OplusGLSurfaceView_13 & 127) | 128));
                    OplusGLSurfaceView_13 >>>= 7;
                } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                    throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
                }
            }
            this.buffer.put((byte) OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
            try {
                this.buffer.putInt(OplusGLSurfaceView_13);
            } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
            while (((-128) & OplusGLSurfaceView_15) != 0) {
                try {
                    this.buffer.put((byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
                    OplusGLSurfaceView_15 >>>= 7;
                } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                    throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
                }
            }
            this.buffer.put((byte) OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
            try {
                this.buffer.putLong(OplusGLSurfaceView_15);
            } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            try {
                this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
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
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                }
            } catch (Utf8.UnpairedSurrogateException COUIBaseListPopupWindow_8) {
                this.buffer.position(iPosition);
                inefficientWriteStringNoTag(str, COUIBaseListPopupWindow_8);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException(e2);
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

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.address = UnsafeUtil.addressOffset(byteBuffer);
            this.initialPosition = this.address + byteBuffer.position();
            this.limit = this.address + byteBuffer.limit();
            this.oneVarintLimit = this.limit - 10;
            this.position = this.initialPosition;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeTag(OplusGLSurfaceView_13, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            writeUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            writeTag(OplusGLSurfaceView_13, 1);
            writeFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            writeTag(OplusGLSurfaceView_13, 0);
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
            writeByteArray(OplusGLSurfaceView_13, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            long OplusGLSurfaceView_15 = this.position;
            if (OplusGLSurfaceView_15 >= this.limit) {
                throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(this.limit), 1));
            }
            this.position = 1 + OplusGLSurfaceView_15;
            UnsafeUtil.putByte(OplusGLSurfaceView_15, b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (OplusGLSurfaceView_13 >= 0) {
                writeUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                writeUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((OplusGLSurfaceView_13 & (-128)) != 0) {
                    long OplusGLSurfaceView_15 = this.position;
                    this.position = OplusGLSurfaceView_15 + 1;
                    UnsafeUtil.putByte(OplusGLSurfaceView_15, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
                    OplusGLSurfaceView_13 >>>= 7;
                }
                long j2 = this.position;
                this.position = 1 + j2;
                UnsafeUtil.putByte(j2, (byte) OplusGLSurfaceView_13);
                return;
            }
            while (true) {
                long j3 = this.position;
                if (j3 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Long.valueOf(j3), Long.valueOf(this.limit), 1));
                }
                if ((OplusGLSurfaceView_13 & (-128)) == 0) {
                    this.position = 1 + j3;
                    UnsafeUtil.putByte(j3, (byte) OplusGLSurfaceView_13);
                    return;
                } else {
                    this.position = j3 + 1;
                    UnsafeUtil.putByte(j3, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
                    OplusGLSurfaceView_13 >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
            this.buffer.putInt(bufferPos(this.position), OplusGLSurfaceView_13);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((OplusGLSurfaceView_15 & (-128)) != 0) {
                    long j2 = this.position;
                    this.position = j2 + 1;
                    UnsafeUtil.putByte(j2, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
                    OplusGLSurfaceView_15 >>>= 7;
                }
                long j3 = this.position;
                this.position = 1 + j3;
                UnsafeUtil.putByte(j3, (byte) OplusGLSurfaceView_15);
                return;
            }
            while (true) {
                long j4 = this.position;
                if (j4 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Long.valueOf(j4), Long.valueOf(this.limit), 1));
                }
                if ((OplusGLSurfaceView_15 & (-128)) == 0) {
                    this.position = 1 + j4;
                    UnsafeUtil.putByte(j4, (byte) OplusGLSurfaceView_15);
                    return;
                } else {
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
                    OplusGLSurfaceView_15 >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
            this.buffer.putLong(bufferPos(this.position), OplusGLSurfaceView_15);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            if (bArr != null && OplusGLSurfaceView_13 >= 0 && i2 >= 0 && bArr.length - i2 >= OplusGLSurfaceView_13) {
                long OplusGLSurfaceView_15 = i2;
                long j2 = this.limit - OplusGLSurfaceView_15;
                long j3 = this.position;
                if (j2 >= j3) {
                    UnsafeUtil.copyMemory(bArr, OplusGLSurfaceView_13, j3, OplusGLSurfaceView_15);
                    this.position += OplusGLSurfaceView_15;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException(Downloads.Impl.RequestHeaders.COLUMN_VALUE);
            }
            throw new OutOfSpaceException(String.format("Pos: %IntrinsicsJvm.kt_5, limit: %IntrinsicsJvm.kt_5, len: %IntrinsicsJvm.kt_5", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i2)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += iRemaining;
            } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
                throw new OutOfSpaceException(COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long OplusGLSurfaceView_15 = this.position;
            try {
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                    this.buffer.position(iBufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int iPosition = this.buffer.position() - iBufferPos;
                    writeUInt32NoTag(iPosition);
                    this.position += iPosition;
                } else {
                    int iEncodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += iEncodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException COUIBaseListPopupWindow_8) {
                this.position = OplusGLSurfaceView_15;
                repositionBuffer(this.position);
                inefficientWriteStringNoTag(str, COUIBaseListPopupWindow_8);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
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

        private void repositionBuffer(long OplusGLSurfaceView_15) {
            this.buffer.position(bufferPos(OplusGLSurfaceView_15));
        }

        private int bufferPos(long OplusGLSurfaceView_15) {
            return (int) (OplusGLSurfaceView_15 - this.address);
        }
    }

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int OplusGLSurfaceView_13) {
            super();
            if (OplusGLSurfaceView_13 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.buffer = new byte[Math.max(OplusGLSurfaceView_13, 20)];
            this.limit = this.buffer.length;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to PlatformImplementations.kt_3 flat array or ByteBuffer.");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        final void buffer(byte b2) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.position;
            this.position = OplusGLSurfaceView_13 + 1;
            bArr[OplusGLSurfaceView_13] = b2;
            this.totalBytesWritten++;
        }

        final void bufferTag(int OplusGLSurfaceView_13, int i2) {
            bufferUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        final void bufferInt32NoTag(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 >= 0) {
                bufferUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                bufferUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        final void bufferUInt32NoTag(int OplusGLSurfaceView_13) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long OplusGLSurfaceView_15 = this.position;
                while ((OplusGLSurfaceView_13 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    UnsafeUtil.putByte(bArr, i2, (byte) ((OplusGLSurfaceView_13 & 127) | 128));
                    OplusGLSurfaceView_13 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                UnsafeUtil.putByte(bArr2, i3, (byte) OplusGLSurfaceView_13);
                this.totalBytesWritten += (int) (this.position - OplusGLSurfaceView_15);
                return;
            }
            while ((OplusGLSurfaceView_13 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((OplusGLSurfaceView_13 & 127) | 128);
                this.totalBytesWritten++;
                OplusGLSurfaceView_13 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) OplusGLSurfaceView_13;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long OplusGLSurfaceView_15) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j2 = this.position;
                while ((OplusGLSurfaceView_15 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int OplusGLSurfaceView_13 = this.position;
                    this.position = OplusGLSurfaceView_13 + 1;
                    UnsafeUtil.putByte(bArr, OplusGLSurfaceView_13, (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128));
                    OplusGLSurfaceView_15 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                UnsafeUtil.putByte(bArr2, i2, (byte) OplusGLSurfaceView_15);
                this.totalBytesWritten += (int) (this.position - j2);
                return;
            }
            while ((OplusGLSurfaceView_15 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((((int) OplusGLSurfaceView_15) & 127) | 128);
                this.totalBytesWritten++;
                OplusGLSurfaceView_15 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) OplusGLSurfaceView_15;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int OplusGLSurfaceView_13) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (OplusGLSurfaceView_13 & 255);
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) ((OplusGLSurfaceView_13 >> 8) & 255);
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = (byte) ((OplusGLSurfaceView_13 >> 16) & 255);
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = (byte) ((OplusGLSurfaceView_13 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long OplusGLSurfaceView_15) {
            byte[] bArr = this.buffer;
            int OplusGLSurfaceView_13 = this.position;
            this.position = OplusGLSurfaceView_13 + 1;
            bArr[OplusGLSurfaceView_13] = (byte) (OplusGLSurfaceView_15 & 255);
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) ((OplusGLSurfaceView_15 >> 8) & 255);
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) ((OplusGLSurfaceView_15 >> 16) & 255);
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = (byte) (255 & (OplusGLSurfaceView_15 >> 24));
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = (byte) (((int) (OplusGLSurfaceView_15 >> 32)) & 255);
            int i6 = this.position;
            this.position = i6 + 1;
            bArr[i6] = (byte) (((int) (OplusGLSurfaceView_15 >> 40)) & 255);
            int i7 = this.position;
            this.position = i7 + 1;
            bArr[i7] = (byte) (((int) (OplusGLSurfaceView_15 >> 48)) & 255);
            int i8 = this.position;
            this.position = i8 + 1;
            bArr[i8] = (byte) (((int) (OplusGLSurfaceView_15 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput byteOutput, int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
            if (byteOutput == null) {
                throw new NullPointerException("out");
            }
            this.out = byteOutput;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(OplusGLSurfaceView_13, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(OplusGLSurfaceView_13, 1);
            bufferFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(OplusGLSurfaceView_13, 0);
            buffer(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
            writeByteArray(OplusGLSurfaceView_13, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (OplusGLSurfaceView_13 >= 0) {
                writeUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                writeUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(length);
            int OplusGLSurfaceView_13 = iComputeUInt32SizeNoTag + length;
            if (OplusGLSurfaceView_13 > this.limit) {
                byte[] bArr = new byte[length];
                int iEncode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(iEncode);
                writeLazy(bArr, 0, iEncode);
                return;
            }
            if (OplusGLSurfaceView_13 > this.limit - this.position) {
                doFlush();
            }
            int i2 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    this.position = i2 + iComputeUInt32SizeNoTag2;
                    int iEncode2 = Utf8.encode(str, this.buffer, this.position, this.limit - this.position);
                    this.position = i2;
                    int i3 = (iEncode2 - i2) - iComputeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i3);
                    this.position = iEncode2;
                    this.totalBytesWritten += i3;
                } else {
                    int iEncodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException COUIBaseListPopupWindow_8) {
                this.totalBytesWritten -= this.position - i2;
                this.position = i2;
                inefficientWriteStringNoTag(str, COUIBaseListPopupWindow_8);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            flush();
            this.out.write(bArr, OplusGLSurfaceView_13, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            flush();
            this.out.writeLazy(bArr, OplusGLSurfaceView_13, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        private void flushIfNotAvailable(int OplusGLSurfaceView_13) throws IOException {
            if (this.limit - this.position < OplusGLSurfaceView_13) {
                doFlush();
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream outputStream, int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(OplusGLSurfaceView_13, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(OplusGLSurfaceView_13, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(OplusGLSurfaceView_13, 0);
            bufferUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(OplusGLSurfaceView_13, 1);
            bufferFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(OplusGLSurfaceView_13, 0);
            buffer(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
            writeByteArray(OplusGLSurfaceView_13, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int OplusGLSurfaceView_13, ByteBuffer byteBuffer) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            writeUInt32NoTag(i2);
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessage(int OplusGLSurfaceView_13, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(OplusGLSurfaceView_13, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int OplusGLSurfaceView_13, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, OplusGLSurfaceView_13);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b2) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            if (OplusGLSurfaceView_13 >= 0) {
                writeUInt32NoTag(OplusGLSurfaceView_13);
            } else {
                writeUInt64NoTag(OplusGLSurfaceView_13);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(OplusGLSurfaceView_13);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(OplusGLSurfaceView_15);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = computeUInt32SizeNoTag(length);
                int OplusGLSurfaceView_13 = iComputeUInt32SizeNoTag + length;
                if (OplusGLSurfaceView_13 > this.limit) {
                    byte[] bArr = new byte[length];
                    int iEncode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(iEncode);
                    writeLazy(bArr, 0, iEncode);
                    return;
                }
                if (OplusGLSurfaceView_13 > this.limit - this.position) {
                    doFlush();
                }
                int iComputeUInt32SizeNoTag2 = computeUInt32SizeNoTag(str.length());
                int i2 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        this.position = i2 + iComputeUInt32SizeNoTag2;
                        int iEncode2 = Utf8.encode(str, this.buffer, this.position, this.limit - this.position);
                        this.position = i2;
                        iEncodedLength = (iEncode2 - i2) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iEncode2;
                    } else {
                        iEncodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (Utf8.UnpairedSurrogateException COUIBaseListPopupWindow_8) {
                    this.totalBytesWritten -= this.position - i2;
                    this.position = i2;
                    throw COUIBaseListPopupWindow_8;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(e2);
                }
            } catch (Utf8.UnpairedSurrogateException e3) {
                inefficientWriteStringNoTag(str, e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            if (this.limit - this.position >= i2) {
                System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.position, i2);
                this.position += i2;
                this.totalBytesWritten += i2;
                return;
            }
            int i3 = this.limit - this.position;
            System.arraycopy(bArr, OplusGLSurfaceView_13, this.buffer, this.position, i3);
            int i4 = OplusGLSurfaceView_13 + i3;
            int i5 = i2 - i3;
            this.position = this.limit;
            this.totalBytesWritten += i3;
            doFlush();
            if (i5 <= this.limit) {
                System.arraycopy(bArr, i4, this.buffer, 0, i5);
                this.position = i5;
            } else {
                this.out.write(bArr, i4, i5);
            }
            this.totalBytesWritten += i5;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
            write(bArr, OplusGLSurfaceView_13, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            if (this.limit - this.position >= iRemaining) {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int OplusGLSurfaceView_13 = this.limit - this.position;
            byteBuffer.get(this.buffer, this.position, OplusGLSurfaceView_13);
            int i2 = iRemaining - OplusGLSurfaceView_13;
            this.position = this.limit;
            this.totalBytesWritten += OplusGLSurfaceView_13;
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
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        private void flushIfNotAvailable(int OplusGLSurfaceView_13) throws IOException {
            if (this.limit - this.position < OplusGLSurfaceView_13) {
                doFlush();
            }
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }
}
