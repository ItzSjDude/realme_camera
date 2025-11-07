package com.google.protobuf.nano;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import java.io.IOException;

/* loaded from: classes.dex */
public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private final int bufferSize;
    private int bufferSizeAfterLimit;
    private final int bufferStart;
    private CodedInputStream codedInputStream;
    private int lastTag;
    private int maybeLimitedBufferSize;
    private int recursionDepth;
    private int currentLimit = Integer.MAX_VALUE;
    private int recursionLimit = 64;
    private int sizeLimit = DEFAULT_SIZE_LIMIT;

    public static int decodeZigZag32(int OplusGLSurfaceView_13) {
        return (-(OplusGLSurfaceView_13 & 1)) ^ (OplusGLSurfaceView_13 >>> 1);
    }

    public static long decodeZigZag64(long OplusGLSurfaceView_15) {
        return (-(OplusGLSurfaceView_15 & 1)) ^ (OplusGLSurfaceView_15 >>> 1);
    }

    public void resetSizeCounter() {
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        return new CodedInputByteBufferNano(bArr, OplusGLSurfaceView_13, i2);
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        int OplusGLSurfaceView_13 = this.lastTag;
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13;
        }
        throw InvalidProtocolBufferNanoException.invalidTag();
    }

    public void checkLastTagWas(int OplusGLSurfaceView_13) throws InvalidProtocolBufferNanoException {
        if (this.lastTag != OplusGLSurfaceView_13) {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public boolean skipField(int OplusGLSurfaceView_13) throws IOException {
        int tagWireType = WireFormatNano.getTagWireType(OplusGLSurfaceView_13);
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
            checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(OplusGLSurfaceView_13), 4));
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            readRawLittleEndian32();
            return true;
        }
        throw InvalidProtocolBufferNanoException.invalidWireType();
    }

    public void skipMessage() throws IOException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint32() != 0;
    }

    public String readString() throws IOException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int OplusGLSurfaceView_13 = this.maybeLimitedBufferSize;
        int i2 = this.bufferPos;
        if (rawVarint32 > OplusGLSurfaceView_13 - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        String str = new String(this.buffer, i2, rawVarint32, InternalNano.UTF_8);
        this.bufferPos += rawVarint32;
        return str;
    }

    public void readGroup(MessageNano messageNano, int OplusGLSurfaceView_13) throws IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        messageNano.mergeFrom(this);
        checkLastTagWas(WireFormatNano.makeTag(OplusGLSurfaceView_13, 4));
        this.recursionDepth--;
    }

    public void readMessage(MessageNano messageNano) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.recursionDepth++;
        messageNano.mergeFrom(this);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(iPushLimit);
    }

    public byte[] readBytes() throws IOException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        if (rawVarint32 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        int OplusGLSurfaceView_13 = this.maybeLimitedBufferSize;
        int i2 = this.bufferPos;
        if (rawVarint32 > OplusGLSurfaceView_13 - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[rawVarint32];
        System.arraycopy(this.buffer, i2, bArr, 0, rawVarint32);
        this.bufferPos += rawVarint32;
        return bArr;
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public int readRawVarint32() throws IOException {
        int OplusGLSurfaceView_13;
        byte rawByte = readRawByte();
        if (rawByte >= 0) {
            return rawByte;
        }
        int i2 = rawByte & 127;
        byte rawByte2 = readRawByte();
        if (rawByte2 >= 0) {
            OplusGLSurfaceView_13 = rawByte2 << 7;
        } else {
            i2 |= (rawByte2 & 127) << 7;
            byte rawByte3 = readRawByte();
            if (rawByte3 >= 0) {
                OplusGLSurfaceView_13 = rawByte3 << 14;
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
                    throw InvalidProtocolBufferNanoException.malformedVarint();
                }
                OplusGLSurfaceView_13 = rawByte4 << 21;
            }
        }
        return OplusGLSurfaceView_13 | i2;
    }

    public long readRawVarint64() throws IOException {
        long OplusGLSurfaceView_15 = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 64; OplusGLSurfaceView_13 += 7) {
            OplusGLSurfaceView_15 |= (r3 & 127) << OplusGLSurfaceView_13;
            if ((readRawByte() & 128) == 0) {
                return OplusGLSurfaceView_15;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        byte rawByte = readRawByte();
        byte rawByte2 = readRawByte();
        byte rawByte3 = readRawByte();
        return ((readRawByte() & 255) << 24) | (rawByte & 255) | ((rawByte2 & 255) << 8) | ((rawByte3 & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    private CodedInputByteBufferNano(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        this.buffer = bArr;
        this.bufferStart = OplusGLSurfaceView_13;
        int i3 = i2 + OplusGLSurfaceView_13;
        this.maybeLimitedBufferSize = i3;
        this.bufferSize = i3;
        this.bufferPos = OplusGLSurfaceView_13;
    }

    private CodedInputStream getCodedInputStream() throws IOException {
        if (this.codedInputStream == null) {
            this.codedInputStream = CodedInputStream.newInstance(this.buffer, this.bufferStart, this.bufferSize);
        }
        int totalBytesRead = this.codedInputStream.getTotalBytesRead();
        int OplusGLSurfaceView_13 = this.bufferPos - this.bufferStart;
        if (totalBytesRead > OplusGLSurfaceView_13) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(totalBytesRead), Integer.valueOf(OplusGLSurfaceView_13)));
        }
        this.codedInputStream.skipRawBytes(OplusGLSurfaceView_13 - totalBytesRead);
        this.codedInputStream.setRecursionLimit(this.recursionLimit - this.recursionDepth);
        return this.codedInputStream;
    }

    public <T extends GeneratedMessageLite<T, ?>> T readMessageLite(Parser<T> parser) throws IOException {
        T t = (T) getCodedInputStream().readMessage(parser, ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
        return t;
    }

    public <T extends GeneratedMessageLite<T, ?>> T readGroupLite(Parser<T> parser, int OplusGLSurfaceView_13) throws IOException {
        T t = (T) getCodedInputStream().readGroup(OplusGLSurfaceView_13, parser, ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
        checkLastTagWas(WireFormatNano.makeTag(OplusGLSurfaceView_13, 4));
        return t;
    }

    public <K, V> void readMapEntryInto(MapFieldLite<K, V> mapFieldLite, MapEntryLite<K, V> mapEntryLite) throws IOException {
        mapEntryLite.parseInto(mapFieldLite, getCodedInputStream(), ExtensionRegistryLite.getGeneratedRegistry());
        skipField(this.lastTag);
    }

    public int setRecursionLimit(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("Recursion limit cannot be negative: ");
            sb.append(OplusGLSurfaceView_13);
            throw new IllegalArgumentException(sb.toString());
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = OplusGLSurfaceView_13;
        return i2;
    }

    public int setSizeLimit(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            StringBuilder sb = new StringBuilder(42);
            sb.append("Size limit cannot be negative: ");
            sb.append(OplusGLSurfaceView_13);
            throw new IllegalArgumentException(sb.toString());
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = OplusGLSurfaceView_13;
        return i2;
    }

    public int pushLimit(int OplusGLSurfaceView_13) throws InvalidProtocolBufferNanoException {
        if (OplusGLSurfaceView_13 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = OplusGLSurfaceView_13 + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.maybeLimitedBufferSize += this.bufferSizeAfterLimit;
        int OplusGLSurfaceView_13 = this.maybeLimitedBufferSize;
        int i2 = this.currentLimit;
        if (OplusGLSurfaceView_13 > i2) {
            this.bufferSizeAfterLimit = OplusGLSurfaceView_13 - i2;
            this.maybeLimitedBufferSize = OplusGLSurfaceView_13 - this.bufferSizeAfterLimit;
        } else {
            this.bufferSizeAfterLimit = 0;
        }
    }

    public void popLimit(int OplusGLSurfaceView_13) {
        this.currentLimit = OplusGLSurfaceView_13;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        int OplusGLSurfaceView_13 = this.currentLimit;
        if (OplusGLSurfaceView_13 == Integer.MAX_VALUE) {
            return -1;
        }
        return OplusGLSurfaceView_13 - this.bufferPos;
    }

    public boolean isAtEnd() {
        return this.bufferPos == this.maybeLimitedBufferSize;
    }

    public int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public byte[] getData(int OplusGLSurfaceView_13, int i2) {
        if (i2 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.bufferStart + OplusGLSurfaceView_13, bArr, 0, i2);
        return bArr;
    }

    public void rewindToPosition(int OplusGLSurfaceView_13) {
        rewindToPositionAndTag(OplusGLSurfaceView_13, this.lastTag);
    }

    void rewindToPositionAndTag(int OplusGLSurfaceView_13, int i2) {
        int i3 = this.bufferPos;
        int i4 = this.bufferStart;
        if (OplusGLSurfaceView_13 > i3 - i4) {
            int i5 = i3 - i4;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(OplusGLSurfaceView_13);
            sb.append(" is beyond current ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        }
        if (OplusGLSurfaceView_13 < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(OplusGLSurfaceView_13);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.bufferPos = i4 + OplusGLSurfaceView_13;
        this.lastTag = i2;
    }

    public byte readRawByte() throws IOException {
        int OplusGLSurfaceView_13 = this.bufferPos;
        if (OplusGLSurfaceView_13 == this.maybeLimitedBufferSize) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = this.buffer;
        this.bufferPos = OplusGLSurfaceView_13 + 1;
        return bArr[OplusGLSurfaceView_13];
    }

    public byte[] readRawBytes(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + OplusGLSurfaceView_13;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (OplusGLSurfaceView_13 > this.maybeLimitedBufferSize - i2) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        System.arraycopy(this.buffer, i2, bArr, 0, OplusGLSurfaceView_13);
        this.bufferPos += OplusGLSurfaceView_13;
        return bArr;
    }

    public void skipRawBytes(int OplusGLSurfaceView_13) throws IOException {
        if (OplusGLSurfaceView_13 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bufferPos;
        int i3 = i2 + OplusGLSurfaceView_13;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            skipRawBytes(i4 - i2);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        if (OplusGLSurfaceView_13 <= this.maybeLimitedBufferSize - i2) {
            this.bufferPos = i2 + OplusGLSurfaceView_13;
            return;
        }
        throw InvalidProtocolBufferNanoException.truncatedMessage();
    }
}
