package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class CodedOutputByteBufferNano {
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private static final int MAX_UTF8_EXPANSION = 3;
    private final java.nio.ByteBuffer buffer;
    private com.google.protobuf.CodedOutputStream codedOutputStream;
    private int codedOutputStreamPosition;

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

    public static int computeRawVarint32Size(int i_renamed) {
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

    public static int computeRawVarint64Size(long j_renamed) {
        if (((-128) & j_renamed) == 0) {
            return 1;
        }
        if (((-16384) & j_renamed) == 0) {
            return 2;
        }
        if (((-2097152) & j_renamed) == 0) {
            return 3;
        }
        if (((-268435456) & j_renamed) == 0) {
            return 4;
        }
        if (((-34359738368L) & j_renamed) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j_renamed) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j_renamed) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j_renamed) == 0) {
            return 8;
        }
        return (j_renamed & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i_renamed) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j_renamed) {
        return 8;
    }

    public static int encodeZigZag32(int i_renamed) {
        return (i_renamed >> 31) ^ (i_renamed << 1);
    }

    public static long encodeZigZag64(long j_renamed) {
        return (j_renamed >> 63) ^ (j_renamed << 1);
    }

    private CodedOutputByteBufferNano(byte[] bArr, int i_renamed, int i2) {
        this(java.nio.ByteBuffer.wrap(bArr, i_renamed, i2));
    }

    private CodedOutputByteBufferNano(java.nio.ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.buffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public static com.google.protobuf.nano.CodedOutputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.nano.CodedOutputByteBufferNano newInstance(byte[] bArr, int i_renamed, int i2) {
        return new com.google.protobuf.nano.CodedOutputByteBufferNano(bArr, i_renamed, i2);
    }

    private com.google.protobuf.CodedOutputStream getCodedOutputStream() throws java.io.IOException {
        if (this.codedOutputStream == null) {
            this.codedOutputStream = com.google.protobuf.CodedOutputStream.newInstance(this.buffer);
            this.codedOutputStreamPosition = this.buffer.position();
        } else if (this.codedOutputStreamPosition != this.buffer.position()) {
            this.codedOutputStream.write(this.buffer.array(), this.codedOutputStreamPosition, this.buffer.position() - this.codedOutputStreamPosition);
            this.codedOutputStreamPosition = this.buffer.position();
        }
        return this.codedOutputStream;
    }

    public void writeDouble(int i_renamed, double d_renamed) throws java.io.IOException {
        writeTag(i_renamed, 1);
        writeDoubleNoTag(d_renamed);
    }

    public void writeFloat(int i_renamed, float f_renamed) throws java.io.IOException {
        writeTag(i_renamed, 5);
        writeFloatNoTag(f_renamed);
    }

    public void writeUInt64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeUInt64NoTag(j_renamed);
    }

    public void writeInt64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeInt64NoTag(j_renamed);
    }

    public void writeInt32(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeInt32NoTag(i2);
    }

    public void writeFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeTag(i_renamed, 1);
        writeFixed64NoTag(j_renamed);
    }

    public void writeFixed32(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 5);
        writeFixed32NoTag(i2);
    }

    public void writeBool(int i_renamed, boolean z_renamed) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeBoolNoTag(z_renamed);
    }

    public void writeString(int i_renamed, java.lang.String str) throws java.io.IOException {
        writeTag(i_renamed, 2);
        writeStringNoTag(str);
    }

    public void writeGroup(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        writeTag(i_renamed, 3);
        writeGroupNoTag(messageNano);
        writeTag(i_renamed, 4);
    }

    public void writeGroupLite(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStream = getCodedOutputStream();
        codedOutputStream.writeGroup(i_renamed, messageLite);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeMessage(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        writeTag(i_renamed, 2);
        writeMessageNoTag(messageNano);
    }

    public void writeMessageLite(int i_renamed, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStream = getCodedOutputStream();
        codedOutputStream.writeMessage(i_renamed, messageLite);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public <K_renamed, V_renamed> void writeMapEntry(int i_renamed, com.google.protobuf.MapEntryLite<K_renamed, V_renamed> mapEntryLite, java.util.Map.Entry<K_renamed, V_renamed> entry) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStream = getCodedOutputStream();
        mapEntryLite.serializeTo(codedOutputStream, i_renamed, entry.getKey(), entry.getValue());
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeBytes(int i_renamed, byte[] bArr) throws java.io.IOException {
        writeTag(i_renamed, 2);
        writeBytesNoTag(bArr);
    }

    public void writeUInt32(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeUInt32NoTag(i2);
    }

    public void writeEnum(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeEnumNoTag(i2);
    }

    public void writeSFixed32(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 5);
        writeSFixed32NoTag(i2);
    }

    public void writeSFixed64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeTag(i_renamed, 1);
        writeSFixed64NoTag(j_renamed);
    }

    public void writeSInt32(int i_renamed, int i2) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeSInt32NoTag(i2);
    }

    public void writeSInt64(int i_renamed, long j_renamed) throws java.io.IOException {
        writeTag(i_renamed, 0);
        writeSInt64NoTag(j_renamed);
    }

    public void writeMessageSetExtension(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        writeTag(1, 3);
        writeUInt32(2, i_renamed);
        writeMessage(3, messageNano);
        writeTag(1, 4);
    }

    public void writeRawMessageSetExtension(int i_renamed, byte[] bArr) throws java.io.IOException {
        writeTag(1, 3);
        writeUInt32(2, i_renamed);
        writeTag(3, 2);
        writeRawBytes(bArr);
        writeTag(1, 4);
    }

    public void writeDoubleNoTag(double d_renamed) throws java.io.IOException {
        writeRawLittleEndian64(java.lang.Double.doubleToLongBits(d_renamed));
    }

    public void writeFloatNoTag(float f_renamed) throws java.io.IOException {
        writeRawLittleEndian32(java.lang.Float.floatToIntBits(f_renamed));
    }

    public void writeUInt64NoTag(long j_renamed) throws java.io.IOException {
        writeRawVarint64(j_renamed);
    }

    public void writeInt64NoTag(long j_renamed) throws java.io.IOException {
        writeRawVarint64(j_renamed);
    }

    public void writeInt32NoTag(int i_renamed) throws java.io.IOException {
        if (i_renamed >= 0) {
            writeRawVarint32(i_renamed);
        } else {
            writeRawVarint64(i_renamed);
        }
    }

    public void writeFixed64NoTag(long j_renamed) throws java.io.IOException {
        writeRawLittleEndian64(j_renamed);
    }

    public void writeFixed32NoTag(int i_renamed) throws java.io.IOException {
        writeRawLittleEndian32(i_renamed);
    }

    public void writeBoolNoTag(boolean z_renamed) throws java.io.IOException {
        writeRawByte(z_renamed ? 1 : 0);
    }

    public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
        try {
            int iComputeRawVarint32Size = computeRawVarint32Size(str.length());
            if (iComputeRawVarint32Size == computeRawVarint32Size(str.length() * 3)) {
                int iPosition = this.buffer.position();
                if (this.buffer.remaining() < iComputeRawVarint32Size) {
                    throw new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(iPosition + iComputeRawVarint32Size, this.buffer.limit());
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
        } catch (java.nio.BufferOverflowException e_renamed) {
            com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException outOfSpaceException = new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
            outOfSpaceException.initCause(e_renamed);
            throw outOfSpaceException;
        }
    }

    private static int encodedLength(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int i_renamed = 0;
        while (i_renamed < length && charSequence.charAt(i_renamed) < 128) {
            i_renamed++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i_renamed < length) {
                char cCharAt = charSequence.charAt(i_renamed);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i_renamed);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i_renamed++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        long j_renamed = iEncodedLengthGeneral + com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(54);
        sb.append("UTF-8 length does not fit in_renamed int: ");
        sb.append(j_renamed);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length();
        int i2 = 0;
        while (i_renamed < length) {
            char cCharAt = charSequence.charAt(i_renamed);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (java.lang.Character.codePointAt(charSequence, i_renamed) < 65536) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
                        sb.append("Unpaired surrogate at_renamed index ");
                        sb.append(i_renamed);
                        throw new java.lang.IllegalArgumentException(sb.toString());
                    }
                    i_renamed++;
                }
            }
            i_renamed++;
        }
        return i2;
    }

    private static void encode(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new java.nio.ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                return;
            } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
                java.nio.BufferOverflowException bufferOverflowException = new java.nio.BufferOverflowException();
                bufferOverflowException.initCause(e_renamed);
                throw bufferOverflowException;
            }
        }
        encodeDirect(charSequence, byteBuffer);
    }

    private static void encodeDirect(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i_renamed = 0;
        while (i_renamed < length) {
            char cCharAt = charSequence.charAt(i_renamed);
            if (cCharAt < 128) {
                byteBuffer.put((byte) cCharAt);
            } else if (cCharAt < 2048) {
                byteBuffer.put((byte) ((cCharAt >>> 6) | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                byteBuffer.put((byte) ((cCharAt >>> '\f_renamed') | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480));
                byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else {
                int i2 = i_renamed + 1;
                if (i2 != charSequence.length()) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (java.lang.Character.isSurrogatePair(cCharAt, cCharAt2)) {
                        int codePoint = java.lang.Character.toCodePoint(cCharAt, cCharAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                        i_renamed = i2;
                    } else {
                        i_renamed = i2;
                    }
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
                sb.append("Unpaired surrogate at_renamed index ");
                sb.append(i_renamed - 1);
                throw new java.lang.IllegalArgumentException(sb.toString());
            }
            i_renamed++;
        }
    }

    private static int encode(java.lang.CharSequence charSequence, byte[] bArr, int i_renamed, int i2) {
        int i3;
        int i4;
        char cCharAt;
        int length = charSequence.length();
        int i5 = i2 + i_renamed;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i_renamed) < i5 && (cCharAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) cCharAt;
            i6++;
        }
        if (i6 == length) {
            return i_renamed + length;
        }
        int i7 = i_renamed + i6;
        while (i6 < length) {
            char cCharAt2 = charSequence.charAt(i6);
            if (cCharAt2 >= 128 || i7 >= i5) {
                if (cCharAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> 6) | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960);
                    i7 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i7 > i5 - 3) {
                        if (i7 <= i5 - 4) {
                            int i9 = i6 + 1;
                            if (i9 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i9);
                                if (java.lang.Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = java.lang.Character.toCodePoint(cCharAt2, cCharAt3);
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
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
                            sb.append("Unpaired surrogate at_renamed index ");
                            sb.append(i6 - 1);
                            throw new java.lang.IllegalArgumentException(sb.toString());
                        }
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(37);
                        sb2.append("Failed writing ");
                        sb2.append(cCharAt2);
                        sb2.append(" at_renamed index ");
                        sb2.append(i7);
                        throw new java.lang.ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    int i13 = i7 + 1;
                    bArr[i7] = (byte) ((cCharAt2 >>> '\f_renamed') | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480);
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

    public void writeGroupNoTag(com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        messageNano.writeTo(this);
    }

    public void writeGroupNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        com.google.protobuf.CodedOutputStream codedOutputStream = getCodedOutputStream();
        messageLite.writeTo(codedOutputStream);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeMessageNoTag(com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        writeRawVarint32(messageNano.getCachedSize());
        messageNano.writeTo(this);
    }

    public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        com.google.protobuf.CodedOutputStream codedOutputStream = getCodedOutputStream();
        messageLite.writeTo(codedOutputStream);
        codedOutputStream.flush();
        this.codedOutputStreamPosition = this.buffer.position();
    }

    public void writeBytesNoTag(byte[] bArr) throws java.io.IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeUInt32NoTag(int i_renamed) throws java.io.IOException {
        writeRawVarint32(i_renamed);
    }

    public void writeEnumNoTag(int i_renamed) throws java.io.IOException {
        writeRawVarint32(i_renamed);
    }

    public void writeSFixed32NoTag(int i_renamed) throws java.io.IOException {
        writeRawLittleEndian32(i_renamed);
    }

    public void writeSFixed64NoTag(long j_renamed) throws java.io.IOException {
        writeRawLittleEndian64(j_renamed);
    }

    public void writeSInt32NoTag(int i_renamed) throws java.io.IOException {
        writeRawVarint32(encodeZigZag32(i_renamed));
    }

    public void writeSInt64NoTag(long j_renamed) throws java.io.IOException {
        writeRawVarint64(encodeZigZag64(j_renamed));
    }

    public static int computeDoubleSize(int i_renamed, double d_renamed) {
        return computeTagSize(i_renamed) + computeDoubleSizeNoTag(d_renamed);
    }

    public static int computeFloatSize(int i_renamed, float f_renamed) {
        return computeTagSize(i_renamed) + computeFloatSizeNoTag(f_renamed);
    }

    public static int computeUInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeUInt64SizeNoTag(j_renamed);
    }

    public static int computeInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeInt64SizeNoTag(j_renamed);
    }

    public static int computeInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeInt32SizeNoTag(i2);
    }

    public static int computeFixed64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeFixed64SizeNoTag(j_renamed);
    }

    public static int computeFixed32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeFixed32SizeNoTag(i2);
    }

    public static int computeBoolSize(int i_renamed, boolean z_renamed) {
        return computeTagSize(i_renamed) + computeBoolSizeNoTag(z_renamed);
    }

    public static int computeStringSize(int i_renamed, java.lang.String str) {
        return computeTagSize(i_renamed) + computeStringSizeNoTag(str);
    }

    public static int computeGroupSize(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) {
        return (computeTagSize(i_renamed) * 2) + computeGroupSizeNoTag(messageNano);
    }

    public static int computeMessageSize(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) {
        return computeTagSize(i_renamed) + computeMessageSizeNoTag(messageNano);
    }

    public static int computeBytesSize(int i_renamed, byte[] bArr) {
        return computeTagSize(i_renamed) + computeBytesSizeNoTag(bArr);
    }

    public static int computeUInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeUInt32SizeNoTag(i2);
    }

    public static int computeEnumSize(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeEnumSizeNoTag(i2);
    }

    public static int computeSFixed32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeSFixed64SizeNoTag(j_renamed);
    }

    public static int computeSInt32Size(int i_renamed, int i2) {
        return computeTagSize(i_renamed) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt64Size(int i_renamed, long j_renamed) {
        return computeTagSize(i_renamed) + computeSInt64SizeNoTag(j_renamed);
    }

    public static int computeMessageSetExtensionSize(int i_renamed, com.google.protobuf.nano.MessageNano messageNano) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i_renamed) + computeMessageSize(3, messageNano);
    }

    public static int computeRawMessageSetExtensionSize(int i_renamed, byte[] bArr) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i_renamed) + computeTagSize(3) + bArr.length;
    }

    public static int computeUInt64SizeNoTag(long j_renamed) {
        return computeRawVarint64Size(j_renamed);
    }

    public static int computeInt64SizeNoTag(long j_renamed) {
        return computeRawVarint64Size(j_renamed);
    }

    public static int computeInt32SizeNoTag(int i_renamed) {
        if (i_renamed >= 0) {
            return computeRawVarint32Size(i_renamed);
        }
        return 10;
    }

    public static int computeStringSizeNoTag(java.lang.String str) {
        int iEncodedLength = encodedLength(str);
        return computeRawVarint32Size(iEncodedLength) + iEncodedLength;
    }

    public static int computeGroupSizeNoTag(com.google.protobuf.nano.MessageNano messageNano) {
        return messageNano.getSerializedSize();
    }

    public static int computeMessageSizeNoTag(com.google.protobuf.nano.MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeBytesSizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeUInt32SizeNoTag(int i_renamed) {
        return computeRawVarint32Size(i_renamed);
    }

    public static int computeEnumSizeNoTag(int i_renamed) {
        return computeRawVarint32Size(i_renamed);
    }

    public static int computeSInt32SizeNoTag(int i_renamed) {
        return computeRawVarint32Size(encodeZigZag32(i_renamed));
    }

    public static int computeSInt64SizeNoTag(long j_renamed) {
        return computeRawVarint64Size(encodeZigZag64(j_renamed));
    }

    public int spaceLeft() {
        return this.buffer.remaining();
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new java.lang.IllegalStateException(java.lang.String.format("Did not write as_renamed much data as_renamed expected, %s_renamed bytes remaining.", java.lang.Integer.valueOf(spaceLeft())));
        }
    }

    public int position() {
        return this.buffer.position();
    }

    public void reset() {
        this.buffer.clear();
    }

    public static class OutOfSpaceException extends java.io.IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(int i_renamed, int i2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(108);
            sb.append("CodedOutputStream was writing to a_renamed flat byte array and ran out of_renamed space (pos ");
            sb.append(i_renamed);
            sb.append(" limit ");
            sb.append(i2);
            sb.append(").");
            super(sb.toString());
        }
    }

    public void writeRawByte(byte b2) throws java.io.IOException {
        if (!this.buffer.hasRemaining()) {
            throw new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.put(b2);
    }

    public void writeRawByte(int i_renamed) throws java.io.IOException {
        writeRawByte((byte) i_renamed);
    }

    public void writeRawBytes(byte[] bArr) throws java.io.IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.buffer.remaining() >= i2) {
            this.buffer.put(bArr, i_renamed, i2);
            return;
        }
        throw new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }

    public void writeTag(int i_renamed, int i2) throws java.io.IOException {
        writeRawVarint32(com.google.protobuf.nano.WireFormatNano.makeTag(i_renamed, i2));
    }

    public static int computeTagSize(int i_renamed) {
        return computeRawVarint32Size(com.google.protobuf.nano.WireFormatNano.makeTag(i_renamed, 0));
    }

    public void writeRawVarint32(int i_renamed) throws java.io.IOException {
        while ((i_renamed & (-128)) != 0) {
            writeRawByte((i_renamed & 127) | 128);
            i_renamed >>>= 7;
        }
        writeRawByte(i_renamed);
    }

    public void writeRawVarint64(long j_renamed) throws java.io.IOException {
        while (((-128) & j_renamed) != 0) {
            writeRawByte((((int) j_renamed) & 127) | 128);
            j_renamed >>>= 7;
        }
        writeRawByte((int) j_renamed);
    }

    public void writeRawLittleEndian32(int i_renamed) throws java.io.IOException {
        if (this.buffer.remaining() < 4) {
            throw new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putInt(i_renamed);
    }

    public void writeRawLittleEndian64(long j_renamed) throws java.io.IOException {
        if (this.buffer.remaining() < 8) {
            throw new com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException(this.buffer.position(), this.buffer.limit());
        }
        this.buffer.putLong(j_renamed);
    }
}
