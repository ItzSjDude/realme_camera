package com.google.protobuf.nano;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MessageLite;
import com.oplus.ocs.camera.CameraParameter;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.util.Map;

/* loaded from: classes.dex */
public final class CodedOutputByteBufferNano {
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private static final int MAX_UTF8_EXPANSION = 3;
    private final ByteBuffer buffer;
    private CodedOutputStream codedOutputStream;
    private int codedOutputStreamPosition;

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

    public static int computeRawVarint32Size(int OplusGLSurfaceView_13) {
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

    public static int computeRawVarint64Size(long OplusGLSurfaceView_15) {
        if (((-128) & OplusGLSurfaceView_15) == 0) {
            return 1;
        }
        if (((-16384) & OplusGLSurfaceView_15) == 0) {
            return 2;
        }
        if (((-2097152) & OplusGLSurfaceView_15) == 0) {
            return 3;
        }
        if (((-268435456) & OplusGLSurfaceView_15) == 0) {
            return 4;
        }
        if (((-34359738368L) & OplusGLSurfaceView_15) == 0) {
            return 5;
        }
        if (((-4398046511104L) & OplusGLSurfaceView_15) == 0) {
            return 6;
        }
        if (((-562949953421312L) & OplusGLSurfaceView_15) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & OplusGLSurfaceView_15) == 0) {
            return 8;
        }
        return (OplusGLSurfaceView_15 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int OplusGLSurfaceView_13) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long OplusGLSurfaceView_15) {
        return 8;
    }

    public static int encodeZigZag32(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 >> 31) ^ (OplusGLSurfaceView_13 << 1);
    }

    public static long encodeZigZag64(long OplusGLSurfaceView_15) {
        return (OplusGLSurfaceView_15 >> 63) ^ (OplusGLSurfaceView_15 << 1);
    }

    private CodedOutputByteBufferNano(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        this(ByteBuffer.wrap(bArr, OplusGLSurfaceView_13, i2));
    }

    private CodedOutputByteBufferNano(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return new CodedOutputByteBufferNano(bArr, OplusGLSurfaceView_13, i2);
    }

    private CodedOutputStream getCodedOutputStream() throws IOException {
        if (this.codedOutputStream == null) {
            this.codedOutputStream = CodedOutputStream.newInstance(this.buffer);
            this.codedOutputStreamPosition = this.buffer.position();
        } else if (this.codedOutputStreamPosition != this.buffer.position()) {
            this.codedOutputStream.write(this.buffer.array(), this.codedOutputStreamPosition, this.buffer.position() - this.codedOutputStreamPosition);
            this.codedOutputStreamPosition = this.buffer.position();
        }
        return this.codedOutputStream;
    }

    public void writeDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws IOException {
        writeTag(OplusGLSurfaceView_13, 1);
        writeDoubleNoTag(IntrinsicsJvm.kt_5);
    }

    public void writeFloat(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IOException {
        writeTag(OplusGLSurfaceView_13, 5);
        writeFloatNoTag(COUIBaseListPopupWindow_12);
    }

    public void writeUInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeUInt64NoTag(OplusGLSurfaceView_15);
    }

    public void writeInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeInt64NoTag(OplusGLSurfaceView_15);
    }

    public void writeInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeInt32NoTag(i2);
    }

    public void writeFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeTag(OplusGLSurfaceView_13, 1);
        writeFixed64NoTag(OplusGLSurfaceView_15);
    }

    public void writeFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 5);
        writeFixed32NoTag(i2);
    }

    public void writeBool(int OplusGLSurfaceView_13, boolean z) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeBoolNoTag(z);
    }

    public void writeString(int OplusGLSurfaceView_13, String str) throws IOException {
        writeTag(OplusGLSurfaceView_13, 2);
        writeStringNoTag(str);
    }

    public void writeGroup(int OplusGLSurfaceView_13, MessageNano messageNano) throws IOException {
        writeTag(OplusGLSurfaceView_13, 3);
        writeGroupNoTag(messageNano);
        writeTag(OplusGLSurfaceView_13, 4);
    }

    public void writeGroupLite(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
        CodedOutputStream codedOutputStream = getCodedOutputStream();
        codedOutputStream.writeGroup(OplusGLSurfaceView_13, messageLite);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeMessage(int OplusGLSurfaceView_13, MessageNano messageNano) throws IOException {
        writeTag(OplusGLSurfaceView_13, 2);
        writeMessageNoTag(messageNano);
    }

    public void writeMessageLite(int OplusGLSurfaceView_13, MessageLite messageLite) throws IOException {
        CodedOutputStream codedOutputStream = getCodedOutputStream();
        codedOutputStream.writeMessage(OplusGLSurfaceView_13, messageLite);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public <K, V> void writeMapEntry(int OplusGLSurfaceView_13, MapEntryLite<K, V> mapEntryLite, Map.Entry<K, V> entry) throws IOException {
        CodedOutputStream codedOutputStream = getCodedOutputStream();
        mapEntryLite.serializeTo(codedOutputStream, OplusGLSurfaceView_13, entry.getKey(), entry.getValue());
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeBytes(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        writeTag(OplusGLSurfaceView_13, 2);
        writeBytesNoTag(bArr);
    }

    public void writeUInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeUInt32NoTag(i2);
    }

    public void writeEnum(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeEnumNoTag(i2);
    }

    public void writeSFixed32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 5);
        writeSFixed32NoTag(i2);
    }

    public void writeSFixed64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeTag(OplusGLSurfaceView_13, 1);
        writeSFixed64NoTag(OplusGLSurfaceView_15);
    }

    public void writeSInt32(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeSInt32NoTag(i2);
    }

    public void writeSInt64(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        writeTag(OplusGLSurfaceView_13, 0);
        writeSInt64NoTag(OplusGLSurfaceView_15);
    }

    public void writeMessageSetExtension(int OplusGLSurfaceView_13, MessageNano messageNano) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, OplusGLSurfaceView_13);
        writeMessage(3, messageNano);
        writeTag(1, 4);
    }

    public void writeRawMessageSetExtension(int OplusGLSurfaceView_13, byte[] bArr) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, OplusGLSurfaceView_13);
        writeTag(3, 2);
        writeRawBytes(bArr);
        writeTag(1, 4);
    }

    public void writeDoubleNoTag(double IntrinsicsJvm.kt_5) throws IOException {
        writeRawLittleEndian64(Double.doubleToLongBits(IntrinsicsJvm.kt_5));
    }

    public void writeFloatNoTag(float COUIBaseListPopupWindow_12) throws IOException {
        writeRawLittleEndian32(Float.floatToIntBits(COUIBaseListPopupWindow_12));
    }

    public void writeUInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeRawVarint64(OplusGLSurfaceView_15);
    }

    public void writeInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeRawVarint64(OplusGLSurfaceView_15);
    }

    public void writeInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 >= 0) {
            writeRawVarint32(OplusGLSurfaceView_13);
        } else {
            writeRawVarint64(OplusGLSurfaceView_13);
        }
    }

    public void writeFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeRawLittleEndian64(OplusGLSurfaceView_15);
    }

    public void writeFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeRawLittleEndian32(OplusGLSurfaceView_13);
    }

    public void writeBoolNoTag(boolean z) throws IOException {
        writeRawByte(z ? 1 : 0);
    }

    public void writeStringNoTag(String str) throws IOException {
        try {
            int iComputeRawVarint32Size = computeRawVarint32Size(str.length());
            if (iComputeRawVarint32Size == computeRawVarint32Size(str.length() * 3)) {
                int iPosition = this.buffer.position();
                if (this.buffer.remaining() < iComputeRawVarint32Size) {
                    throw new OutOfSpaceException(iPosition + iComputeRawVarint32Size, this.buffer.limit());
                }
                this.buffer.position(iPosition + iComputeRawVarint32Size);
                encode(str, this.buffer);
                int iPosition2 = this.buffer.position();
                this.buffer.position(iPosition);
                writeRawVarint32((iPosition2 - iPosition) - iComputeRawVarint32Size);
                this.buffer.position(iPosition2);
                return;
            }
            writeRawVarint32(encodedLength(str));
            encode(str, this.buffer);
        } catch (BufferOverflowException COUIBaseListPopupWindow_8) {
            OutOfSpaceException outOfSpaceException = new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
            outOfSpaceException.initCause(COUIBaseListPopupWindow_8);
            throw outOfSpaceException;
        }
    }

    private static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < length && charSequence.charAt(OplusGLSurfaceView_13) < 128) {
            OplusGLSurfaceView_13++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (OplusGLSurfaceView_13 < length) {
                char cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, OplusGLSurfaceView_13);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                OplusGLSurfaceView_13++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        long OplusGLSurfaceView_15 = iEncodedLengthGeneral + STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(OplusGLSurfaceView_15);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int OplusGLSurfaceView_13) {
        int length = charSequence.length();
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            char cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, OplusGLSurfaceView_13) < 65536) {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(OplusGLSurfaceView_13);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    OplusGLSurfaceView_13++;
                }
            }
            OplusGLSurfaceView_13++;
        }
        return i2;
    }

    private static void encode(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                return;
            } catch (ArrayIndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(COUIBaseListPopupWindow_8);
                throw bufferOverflowException;
            }
        }
        encodeDirect(charSequence, byteBuffer);
    }

    private static void encodeDirect(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < length) {
            char cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
            if (cCharAt < 128) {
                byteBuffer.put((byte) cCharAt);
            } else if (cCharAt < 2048) {
                byteBuffer.put((byte) ((cCharAt >>> 6) | CameraParameter.VideoFps.FPS_960));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                byteBuffer.put((byte) ((cCharAt >>> '\COUIBaseListPopupWindow_12') | CameraParameter.VideoFps.FPS_480));
                byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else {
                int i2 = OplusGLSurfaceView_13 + 1;
                if (i2 != charSequence.length()) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                        OplusGLSurfaceView_13 = i2;
                    } else {
                        OplusGLSurfaceView_13 = i2;
                    }
                }
                StringBuilder sb = new StringBuilder(39);
                sb.append("Unpaired surrogate at index ");
                sb.append(OplusGLSurfaceView_13 - 1);
                throw new IllegalArgumentException(sb.toString());
            }
            OplusGLSurfaceView_13++;
        }
    }

    private static int encode(CharSequence charSequence, byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        char cCharAt;
        int length = charSequence.length();
        int i5 = i2 + OplusGLSurfaceView_13;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + OplusGLSurfaceView_13) < i5 && (cCharAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) cCharAt;
            i6++;
        }
        if (i6 == length) {
            return OplusGLSurfaceView_13 + length;
        }
        int i7 = OplusGLSurfaceView_13 + i6;
        while (i6 < length) {
            char cCharAt2 = charSequence.charAt(i6);
            if (cCharAt2 >= 128 || i7 >= i5) {
                if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> 6) | CameraParameter.VideoFps.FPS_960);
                    i7 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                        if (i7 <= i5 - 4) {
                            int i9 = i6 + 1;
                            if (i9 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i9);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i10 = i7 + 1;
                                    bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                    int i11 = i10 + 1;
                                    bArr[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i12 = i11 + 1;
                                    bArr[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i7 = i12 + 1;
                                    bArr[i12] = (byte) ((codePoint & 63) | 128);
                                    i6 = i9;
                                } else {
                                    i6 = i9;
                                }
                            }
                            StringBuilder sb = new StringBuilder(39);
                            sb.append("Unpaired surrogate at index ");
                            sb.append(i6 - 1);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        StringBuilder sb2 = new StringBuilder(37);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt2);
                        sb2.append(" at index ");
                        sb2.append(i7);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    int i13 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> '\COUIBaseListPopupWindow_12') | CameraParameter.VideoFps.FPS_480);
                    int i14 = i13 + 1;
                    bArr[i13] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i3 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 & '?') | 128);
                }
                i6++;
            } else {
                i3 = i7 + 1;
                bArr[i7] = (byte) cCharAt2;
            }
            i7 = i3;
            i6++;
        }
        return i7;
    }

    public void writeGroupNoTag(MessageNano messageNano) throws IOException {
        messageNano.writeTo(this);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        CodedOutputStream codedOutputStream = getCodedOutputStream();
        messageLite.writeTo(codedOutputStream);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeMessageNoTag(MessageNano messageNano) throws IOException {
        writeRawVarint32(messageNano.getCachedSize());
        messageNano.writeTo(this);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        CodedOutputStream codedOutputStream = getCodedOutputStream();
        messageLite.writeTo(codedOutputStream);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeBytesNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeUInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeRawVarint32(OplusGLSurfaceView_13);
    }

    public void writeEnumNoTag(int OplusGLSurfaceView_13) throws IOException {
        writeRawVarint32(OplusGLSurfaceView_13);
    }

    public void writeSFixed32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeRawLittleEndian32(OplusGLSurfaceView_13);
    }

    public void writeSFixed64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeRawLittleEndian64(OplusGLSurfaceView_15);
    }

    public void writeSInt32NoTag(int OplusGLSurfaceView_13) throws IOException {
        writeRawVarint32(encodeZigZag32(OplusGLSurfaceView_13));
    }

    public void writeSInt64NoTag(long OplusGLSurfaceView_15) throws IOException {
        writeRawVarint64(encodeZigZag64(OplusGLSurfaceView_15));
    }

    public static int computeDoubleSize(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        return computeTagSize(OplusGLSurfaceView_13) + computeDoubleSizeNoTag(IntrinsicsJvm.kt_5);
    }

    public static int computeFloatSize(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFloatSizeNoTag(COUIBaseListPopupWindow_12);
    }

    public static int computeUInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeUInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeInt32SizeNoTag(i2);
    }

    public static int computeFixed64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFixed64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeFixed32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeFixed32SizeNoTag(i2);
    }

    public static int computeBoolSize(int OplusGLSurfaceView_13, boolean z) {
        return computeTagSize(OplusGLSurfaceView_13) + computeBoolSizeNoTag(z);
    }

    public static int computeStringSize(int OplusGLSurfaceView_13, String str) {
        return computeTagSize(OplusGLSurfaceView_13) + computeStringSizeNoTag(str);
    }

    public static int computeGroupSize(int OplusGLSurfaceView_13, MessageNano messageNano) {
        return (computeTagSize(OplusGLSurfaceView_13) * 2) + computeGroupSizeNoTag(messageNano);
    }

    public static int computeMessageSize(int OplusGLSurfaceView_13, MessageNano messageNano) {
        return computeTagSize(OplusGLSurfaceView_13) + computeMessageSizeNoTag(messageNano);
    }

    public static int computeBytesSize(int OplusGLSurfaceView_13, byte[] bArr) {
        return computeTagSize(OplusGLSurfaceView_13) + computeBytesSizeNoTag(bArr);
    }

    public static int computeUInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeUInt32SizeNoTag(i2);
    }

    public static int computeEnumSize(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeEnumSizeNoTag(i2);
    }

    public static int computeSFixed32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSFixed64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeSInt32Size(int OplusGLSurfaceView_13, int i2) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt64Size(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return computeTagSize(OplusGLSurfaceView_13) + computeSInt64SizeNoTag(OplusGLSurfaceView_15);
    }

    public static int computeMessageSetExtensionSize(int OplusGLSurfaceView_13, MessageNano messageNano) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, OplusGLSurfaceView_13) + computeMessageSize(3, messageNano);
    }

    public static int computeRawMessageSetExtensionSize(int OplusGLSurfaceView_13, byte[] bArr) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, OplusGLSurfaceView_13) + computeTagSize(3) + bArr.length;
    }

    public static int computeUInt64SizeNoTag(long OplusGLSurfaceView_15) {
        return computeRawVarint64Size(OplusGLSurfaceView_15);
    }

    public static int computeInt64SizeNoTag(long OplusGLSurfaceView_15) {
        return computeRawVarint64Size(OplusGLSurfaceView_15);
    }

    public static int computeInt32SizeNoTag(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0) {
            return computeRawVarint32Size(OplusGLSurfaceView_13);
        }
        return 10;
    }

    public static int computeStringSizeNoTag(String str) {
        int iEncodedLength = encodedLength(str);
        return computeRawVarint32Size(iEncodedLength) + iEncodedLength;
    }

    public static int computeGroupSizeNoTag(MessageNano messageNano) {
        return messageNano.getSerializedSize();
    }

    public static int computeMessageSizeNoTag(MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeBytesSizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeUInt32SizeNoTag(int OplusGLSurfaceView_13) {
        return computeRawVarint32Size(OplusGLSurfaceView_13);
    }

    public static int computeEnumSizeNoTag(int OplusGLSurfaceView_13) {
        return computeRawVarint32Size(OplusGLSurfaceView_13);
    }

    public static int computeSInt32SizeNoTag(int OplusGLSurfaceView_13) {
        return computeRawVarint32Size(encodeZigZag32(OplusGLSurfaceView_13));
    }

    public static int computeSInt64SizeNoTag(long OplusGLSurfaceView_15) {
        return computeRawVarint64Size(encodeZigZag64(OplusGLSurfaceView_15));
    }

    public int spaceLeft() {
        return this.buffer.remaining();
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(spaceLeft())));
        }
    }

    public int position() {
        return this.buffer.position();
    }

    public void reset() {
        this.buffer.clear();
    }

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(int OplusGLSurfaceView_13, int i2) {
            StringBuilder sb = new StringBuilder(108);
            sb.append("CodedOutputStream was writing to PlatformImplementations.kt_3 flat byte array and ran out of space (pos ");
            sb.append(OplusGLSurfaceView_13);
            sb.append(" limit ");
            sb.append(i2);
            sb.append(").");
            super(sb.toString());
        }
    }

    public void writeRawByte(byte b2) throws IOException {
        if (!this.buffer.hasRemaining()) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(b2);
    }

    public void writeRawByte(int OplusGLSurfaceView_13) throws IOException {
        writeRawByte((byte) OplusGLSurfaceView_13);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (this.buffer.remaining() >= i2) {
            this.buffer.put(bArr, OplusGLSurfaceView_13, i2);
            return;
        }
        throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }

    public void writeTag(int OplusGLSurfaceView_13, int i2) throws IOException {
        writeRawVarint32(WireFormatNano.makeTag(OplusGLSurfaceView_13, i2));
    }

    public static int computeTagSize(int OplusGLSurfaceView_13) {
        return computeRawVarint32Size(WireFormatNano.makeTag(OplusGLSurfaceView_13, 0));
    }

    public void writeRawVarint32(int OplusGLSurfaceView_13) throws IOException {
        while ((OplusGLSurfaceView_13 & (-128)) != 0) {
            writeRawByte((OplusGLSurfaceView_13 & 127) | 128);
            OplusGLSurfaceView_13 >>>= 7;
        }
        writeRawByte(OplusGLSurfaceView_13);
    }

    public void writeRawVarint64(long OplusGLSurfaceView_15) throws IOException {
        while (((-128) & OplusGLSurfaceView_15) != 0) {
            writeRawByte((((int) OplusGLSurfaceView_15) & 127) | 128);
            OplusGLSurfaceView_15 >>>= 7;
        }
        writeRawByte((int) OplusGLSurfaceView_15);
    }

    public void writeRawLittleEndian32(int OplusGLSurfaceView_13) throws IOException {
        if (this.buffer.remaining() < 4) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putInt(OplusGLSurfaceView_13);
    }

    public void writeRawLittleEndian64(long OplusGLSurfaceView_15) throws IOException {
        if (this.buffer.remaining() < 8) {
            throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putLong(OplusGLSurfaceView_15);
    }
}
