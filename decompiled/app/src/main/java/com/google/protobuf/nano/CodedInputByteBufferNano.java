package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private final int bufferSize;
    private int bufferSizeAfterLimit;
    private final int bufferStart;
    private com.google.protobuf.CodedInputStream codedInputStream;
    private int lastTag;
    private int maybeLimitedBufferSize;
    private int recursionDepth;
    private int currentLimit = Integer.MAX_VALUE;
    private int recursionLimit = 64;
    private int sizeLimit = DEFAULT_SIZE_LIMIT;

    public static int decodeZigZag32(int i_renamed) {
        return (-(i_renamed & 1)) ^ (i_renamed >>> 1);
    }

    public static long decodeZigZag64(long j_renamed) {
        return (-(j_renamed & 1)) ^ (j_renamed >>> 1);
    }

    public void resetSizeCounter() {
    }

    public static com.google.protobuf.nano.CodedInputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.nano.CodedInputByteBufferNano newInstance(byte[] bArr, int i_renamed, int i2) {
        return new com.google.protobuf.nano.CodedInputByteBufferNano(bArr, i_renamed, i2);
    }

    public int readTag() throws java.io.IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        int i_renamed = this.lastTag;
        if (i_renamed != 0) {
            return i_renamed;
        }
        throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.invalidTag();
    }

    public void checkLastTagWas(int i_renamed) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        if (this.lastTag != i_renamed) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public boolean skipField(int i_renamed) throws java.io.IOException {
        int tagWireType = com.google.protobuf.nano.WireFormatNano.getTagWireType(i_renamed);
        if (tagWireType == 0) {
            readInt32();
            return true;
        }
        if (tagWireType == 1) {
            readRawLittleEndian64();
            return true;
        }
        if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        }
        if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(com.google.protobuf.nano.WireFormatNano.makeTag(com.google.protobuf.nano.WireFormatNano.getTagFieldNumber(i_renamed), 4));
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            readRawLittleEndian32();
            return true;
        }
        throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.invalidWireType();
    }

    public void skipMessage() throws java.io.IOException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag));
    }

    public double readDouble() throws java.io.IOException {
        return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws java.io.IOException {
        return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws java.io.IOException {
        return readRawVarint64();
    }

    public long readInt64() throws java.io.IOException {
        return readRawVarint64();
    }

    public int readInt32() throws java.io.IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws java.io.IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws java.io.IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws java.io.IOException {
        return readRawVarint32() != 0;
    }

    public java.lang.String readString() throws java.io.IOException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 < 0) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.negativeSize();
        }
        int i_renamed = this.maybeLimitedBufferSize;
        int i2 = this.bufferPos;
        if (rawVarint32 > i_renamed - i2) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        java.lang.String str = new java.lang.String(this.buffer, i2, rawVarint32, com.google.protobuf.nano.InternalNano.UTF_8);
        this.bufferPos += rawVarint32;
        return str;
    }

    public void readGroup(com.google.protobuf.nano.MessageNano messageNano, int i_renamed) throws java.io.IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        messageNano.mergeFrom(this);
        checkLastTagWas(com.google.protobuf.nano.WireFormatNano.makeTag(i_renamed, 4));
        this.recursionDepth--;
    }

    public void readMessage(com.google.protobuf.nano.MessageNano messageNano) throws java.io.IOException {
        int rawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.recursionDepth++;
        messageNano.mergeFrom(this);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(iPushLimit);
    }

    public byte[] readBytes() throws java.io.IOException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 < 0) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.negativeSize();
        }
        if (rawVarint32 == 0) {
            return com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
        }
        int i_renamed = this.maybeLimitedBufferSize;
        int i2 = this.bufferPos;
        if (rawVarint32 > i_renamed - i2) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[rawVarint32];
        java.lang.System.arraycopy(this.buffer, i2, bArr, 0, rawVarint32);
        this.bufferPos += rawVarint32;
        return bArr;
    }

    public int readUInt32() throws java.io.IOException {
        return readRawVarint32();
    }

    public int readEnum() throws java.io.IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws java.io.IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws java.io.IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws java.io.IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws java.io.IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public int readRawVarint32() throws java.io.IOException {
        int i_renamed;
        byte rawByte = readRawByte();
        if (rawByte >= 0) {
            return rawByte;
        }
        int i2 = rawByte & 127;
        byte rawByte2 = readRawByte();
        if (rawByte2 >= 0) {
            i_renamed = rawByte2 << 7;
        } else {
            i2 |= (rawByte2 & 127) << 7;
            byte rawByte3 = readRawByte();
            if (rawByte3 >= 0) {
                i_renamed = rawByte3 << 14;
            } else {
                i2 |= (rawByte3 & 127) << 14;
                byte rawByte4 = readRawByte();
                if (rawByte4 < 0) {
                    int i3 = i2 | ((rawByte4 & 127) << 21);
                    byte rawByte5 = readRawByte();
                    int i4 = i3 | (rawByte5 << 28);
                    if (rawByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (readRawByte() >= 0) {
                            return i4;
                        }
                    }
                    throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.malformedVarint();
                }
                i_renamed = rawByte4 << 21;
            }
        }
        return i_renamed | i2;
    }

    public long readRawVarint64() throws java.io.IOException {
        long j_renamed = 0;
        for (int i_renamed = 0; i_renamed < 64; i_renamed += 7) {
            j_renamed |= (r3 & 127) << i_renamed;
            if ((readRawByte() & 128) == 0) {
                return j_renamed;
            }
        }
        throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.malformedVarint();
    }

    public int readRawLittleEndian32() throws java.io.IOException {
        byte rawByte = readRawByte();
        byte rawByte2 = readRawByte();
        byte rawByte3 = readRawByte();
        return ((readRawByte() & 255) << 24) | (rawByte & 255) | ((rawByte2 & 255) << 8) | ((rawByte3 & 255) << 16);
    }

    public long readRawLittleEndian64() throws java.io.IOException {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    private CodedInputByteBufferNano(byte[] bArr, int i_renamed, int i2) {
        this.buffer = bArr;
        this.bufferStart = i_renamed;
        int i3 = i2 + i_renamed;
        this.maybeLimitedBufferSize = i3;
        this.bufferSize = i3;
        this.bufferPos = i_renamed;
    }

    private com.google.protobuf.CodedInputStream getCodedInputStream() throws java.io.IOException {
        if (this.codedInputStream == null) {
            this.codedInputStream = com.google.protobuf.CodedInputStream.newInstance(this.buffer, this.bufferStart, this.bufferSize);
        }
        int totalBytesRead = this.codedInputStream.getTotalBytesRead();
        int i_renamed = this.bufferPos - this.bufferStart;
        if (totalBytesRead > i_renamed) {
            throw new java.io.IOException(java.lang.String.format("CodedInputStream read ahead of_renamed CodedInputByteBufferNano: %s_renamed > %s_renamed", java.lang.Integer.valueOf(totalBytesRead), java.lang.Integer.valueOf(i_renamed)));
        }
        this.codedInputStream.skipRawBytes(i_renamed - totalBytesRead);
        this.codedInputStream.setRecursionLimit(this.recursionLimit - this.recursionDepth);
        return this.codedInputStream;
    }

    public <T_renamed extends com.google.protobuf.GeneratedMessageLite<T_renamed, ?>> T_renamed readMessageLite(com.google.protobuf.Parser<T_renamed> parser) throws java.io.IOException {
        T_renamed t_renamed = (T_renamed) getCodedInputStream().readMessage(parser, com.google.protobuf.ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
        return t_renamed;
    }

    public <T_renamed extends com.google.protobuf.GeneratedMessageLite<T_renamed, ?>> T_renamed readGroupLite(com.google.protobuf.Parser<T_renamed> parser, int i_renamed) throws java.io.IOException {
        T_renamed t_renamed = (T_renamed) getCodedInputStream().readGroup(i_renamed, parser, com.google.protobuf.ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
        checkLastTagWas(com.google.protobuf.nano.WireFormatNano.makeTag(i_renamed, 4));
        return t_renamed;
    }

    public <K_renamed, V_renamed> void readMapEntryInto(com.google.protobuf.MapFieldLite<K_renamed, V_renamed> mapFieldLite, com.google.protobuf.MapEntryLite<K_renamed, V_renamed> mapEntryLite) throws java.io.IOException {
        mapEntryLite.parseInto(mapFieldLite, getCodedInputStream(), com.google.protobuf.ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
    }

    public int setRecursionLimit(int i_renamed) {
        if (i_renamed < 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(47);
            sb.append("Recursion limit cannot be_renamed negative: ");
            sb.append(i_renamed);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i_renamed;
        return i2;
    }

    public int setSizeLimit(int i_renamed) {
        if (i_renamed < 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(42);
            sb.append("Size limit cannot be_renamed negative: ");
            sb.append(i_renamed);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i_renamed;
        return i2;
    }

    public int pushLimit(int i_renamed) throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
        if (i_renamed < 0) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = i_renamed + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.maybeLimitedBufferSize += this.bufferSizeAfterLimit;
        int i_renamed = this.maybeLimitedBufferSize;
        int i2 = this.currentLimit;
        if (i_renamed > i2) {
            this.bufferSizeAfterLimit = i_renamed - i2;
            this.maybeLimitedBufferSize = i_renamed - this.bufferSizeAfterLimit;
        } else {
            this.bufferSizeAfterLimit = 0;
        }
    }

    public void popLimit(int i_renamed) {
        this.currentLimit = i_renamed;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        int i_renamed = this.currentLimit;
        if (i_renamed == Integer.MAX_VALUE) {
            return -1;
        }
        return i_renamed - this.bufferPos;
    }

    public boolean isAtEnd() {
        return this.bufferPos == this.maybeLimitedBufferSize;
    }

    public int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public byte[] getData(int i_renamed, int i2) {
        if (i2 == 0) {
            return com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        java.lang.System.arraycopy(this.buffer, this.bufferStart + i_renamed, bArr, 0, i2);
        return bArr;
    }

    public void rewindToPosition(int i_renamed) {
        rewindToPositionAndTag(i_renamed, this.lastTag);
    }

    void rewindToPositionAndTag(int i_renamed, int i2) {
        int i3 = this.bufferPos;
        int i4 = this.bufferStart;
        if (i_renamed > i3 - i4) {
            int i5 = i3 - i4;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
            sb.append("Position ");
            sb.append(i_renamed);
            sb.append(" is_renamed beyond current ");
            sb.append(i5);
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        if (i_renamed < 0) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i_renamed);
            throw new java.lang.IllegalArgumentException(sb2.toString());
        }
        this.bufferPos = i4 + i_renamed;
        this.lastTag = i2;
    }

    public byte readRawByte() throws java.io.IOException {
        int i_renamed = this.bufferPos;
        if (i_renamed == this.maybeLimitedBufferSize) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i_renamed + 1;
        return bArr[i_renamed];
    }

    public byte[] readRawBytes(int i_renamed) throws java.io.IOException {
        if (i_renamed < 0) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + i_renamed;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (i_renamed > this.maybeLimitedBufferSize - i2) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[i_renamed];
        java.lang.System.arraycopy(this.buffer, i2, bArr, 0, i_renamed);
        this.bufferPos += i_renamed;
        return bArr;
    }

    public void skipRawBytes(int i_renamed) throws java.io.IOException {
        if (i_renamed < 0) {
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + i_renamed;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (i_renamed <= this.maybeLimitedBufferSize - i2) {
            this.bufferPos = i2 + i_renamed;
            return;
        }
        throw com.google.protobuf.nano.InvalidProtocolBufferNanoException.truncatedMessage();
    }
}
