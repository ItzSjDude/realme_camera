package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableByteArray(int i_renamed) {
        this.data = new byte[i_renamed];
        this.limit = i_renamed;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i_renamed) {
        this.data = bArr;
        this.limit = i_renamed;
    }

    public void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public void reset(int i_renamed) {
        reset(capacity() < i_renamed ? new byte[i_renamed] : this.data, i_renamed);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(byte[] bArr, int i_renamed) {
        this.data = bArr;
        this.limit = i_renamed;
        this.position = 0;
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int limit() {
        return this.limit;
    }

    public void setLimit(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed >= 0 && i_renamed <= this.data.length);
        this.limit = i_renamed;
    }

    public int getPosition() {
        return this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void setPosition(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed >= 0 && i_renamed <= this.limit);
        this.position = i_renamed;
    }

    public void skipBytes(int i_renamed) {
        setPosition(this.position + i_renamed);
    }

    public void readBytes(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i_renamed) {
        readBytes(parsableBitArray.data, 0, i_renamed);
        parsableBitArray.setPosition(0);
    }

    public void readBytes(byte[] bArr, int i_renamed, int i2) {
        java.lang.System.arraycopy(this.data, this.position, bArr, i_renamed, i2);
        this.position += i2;
    }

    public void readBytes(java.nio.ByteBuffer byteBuffer, int i_renamed) {
        byteBuffer.put(this.data, this.position, i_renamed);
        this.position += i_renamed;
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        return (char) ((bArr[i_renamed + 1] & 255) | ((bArr[i_renamed] & 255) << 8));
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        return bArr[i_renamed] & 255;
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = (bArr[i_renamed] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = bArr[i_renamed] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i2;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = (bArr[i_renamed] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = bArr[i_renamed] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) (((bArr[i3] & 255) << 8) | i2);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = (bArr[i_renamed] & 255) << 16;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = ((bArr[i_renamed] & 255) << 24) >> 8;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = bArr[i_renamed] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return ((bArr[i5] & 255) << 16) | i4;
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = bArr[i_renamed] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return ((bArr[i5] & 255) << 16) | i4;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j_renamed = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j2 = j_renamed | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        return j2 | (255 & bArr[r5]);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j_renamed = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        long j2 = j_renamed | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        return j2 | ((255 & bArr[r5]) << 24);
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = (bArr[i_renamed] & 255) << 24;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = this.position;
        this.position = i5 + 1;
        int i6 = i4 | ((bArr[i5] & 255) << 8);
        int i7 = this.position;
        this.position = i7 + 1;
        return (bArr[i7] & 255) | i6;
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = bArr[i_renamed] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        int i6 = i4 | ((bArr[i5] & 255) << 16);
        int i7 = this.position;
        this.position = i7 + 1;
        return ((bArr[i7] & 255) << 24) | i6;
    }

    public long readLong() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j_renamed = ((bArr[r1] & 255) << 56) | ((bArr[r5] & 255) << 48);
        this.position = this.position + 1;
        long j2 = j_renamed | ((bArr[r5] & 255) << 40);
        this.position = this.position + 1;
        long j3 = j2 | ((bArr[r5] & 255) << 32);
        this.position = this.position + 1;
        long j4 = j3 | ((bArr[r5] & 255) << 24);
        this.position = this.position + 1;
        long j5 = j4 | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j6 = j5 | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        return j6 | (255 & bArr[r5]);
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long j_renamed = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        long j2 = j_renamed | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j3 = j2 | ((bArr[r5] & 255) << 24);
        this.position = this.position + 1;
        long j4 = j3 | ((bArr[r5] & 255) << 32);
        this.position = this.position + 1;
        long j5 = j4 | ((bArr[r5] & 255) << 40);
        this.position = this.position + 1;
        long j6 = j5 | ((bArr[r5] & 255) << 48);
        this.position = this.position + 1;
        return j6 | ((255 & bArr[r5]) << 56);
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i_renamed = this.position;
        this.position = i_renamed + 1;
        int i2 = (bArr[i_renamed] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = (bArr[i3] & 255) | i2;
        this.position += 2;
        return i4;
    }

    public int readSynchSafeInt() {
        return readUnsignedByte() | (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7);
    }

    public int readUnsignedIntToInt() {
        int i_renamed = readInt();
        if (i_renamed >= 0) {
            return i_renamed;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: " + i_renamed);
    }

    public int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: " + littleEndianInt);
    }

    public long readUnsignedLongToLong() {
        long j_renamed = readLong();
        if (j_renamed >= 0) {
            return j_renamed;
        }
        throw new java.lang.IllegalStateException("Top bit not zero: " + j_renamed);
    }

    public float readFloat() {
        return java.lang.Float.intBitsToFloat(readInt());
    }

    public double readDouble() {
        return java.lang.Double.longBitsToDouble(readLong());
    }

    public java.lang.String readString(int i_renamed) {
        return readString(i_renamed, java.nio.charset.Charset.forName("UTF-8"));
    }

    public java.lang.String readString(int i_renamed, java.nio.charset.Charset charset) {
        java.lang.String str = new java.lang.String(this.data, this.position, i_renamed, charset);
        this.position += i_renamed;
        return str;
    }

    public java.lang.String readNullTerminatedString(int i_renamed) {
        if (i_renamed == 0) {
            return "";
        }
        int i2 = (this.position + i_renamed) - 1;
        java.lang.String strFromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i_renamed : i_renamed - 1);
        this.position += i_renamed;
        return strFromUtf8Bytes;
    }

    public java.lang.String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i_renamed = this.position;
        while (i_renamed < this.limit && this.data[i_renamed] != 0) {
            i_renamed++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        java.lang.String strFromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr, i2, i_renamed - i2);
        this.position = i_renamed;
        int i3 = this.position;
        if (i3 < this.limit) {
            this.position = i3 + 1;
        }
        return strFromUtf8Bytes;
    }

    public java.lang.String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i_renamed = this.position;
        while (i_renamed < this.limit && !com.google.android.exoplayer2.util.Util.isLinebreak(this.data[i_renamed])) {
            i_renamed++;
        }
        int i2 = this.position;
        if (i_renamed - i2 >= 3) {
            byte[] bArr = this.data;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.position = i2 + 3;
            }
        }
        byte[] bArr2 = this.data;
        int i3 = this.position;
        java.lang.String strFromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr2, i3, i_renamed - i3);
        this.position = i_renamed;
        int i4 = this.position;
        int i5 = this.limit;
        if (i4 == i5) {
            return strFromUtf8Bytes;
        }
        if (this.data[i4] == 13) {
            this.position = i4 + 1;
            if (this.position == i5) {
                return strFromUtf8Bytes;
            }
        }
        byte[] bArr3 = this.data;
        int i6 = this.position;
        if (bArr3[i6] == 10) {
            this.position = i6 + 1;
        }
        return strFromUtf8Bytes;
    }

    public long readUtf8EncodedLong() {
        int i_renamed;
        int i2;
        long j_renamed = this.data[this.position];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j_renamed) != 0) {
                i3--;
            } else if (i3 < 6) {
                j_renamed &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw new java.lang.NumberFormatException("Invalid UTF-8 sequence first byte: " + j_renamed);
        }
        for (i_renamed = 1; i_renamed < i2; i_renamed++) {
            if ((this.data[this.position + i_renamed] & 192) != 128) {
                throw new java.lang.NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j_renamed);
            }
            j_renamed = (j_renamed << 6) | (r3 & 63);
        }
        this.position += i2;
        return j_renamed;
    }
}
