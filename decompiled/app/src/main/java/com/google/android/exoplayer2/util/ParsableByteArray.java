package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableByteArray(int OplusGLSurfaceView_13) {
        this.data = new byte[OplusGLSurfaceView_13];
        this.limit = OplusGLSurfaceView_13;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int OplusGLSurfaceView_13) {
        this.data = bArr;
        this.limit = OplusGLSurfaceView_13;
    }

    public void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public void reset(int OplusGLSurfaceView_13) {
        reset(capacity() < OplusGLSurfaceView_13 ? new byte[OplusGLSurfaceView_13] : this.data, OplusGLSurfaceView_13);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(byte[] bArr, int OplusGLSurfaceView_13) {
        this.data = bArr;
        this.limit = OplusGLSurfaceView_13;
        this.position = 0;
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int limit() {
        return this.limit;
    }

    public void setLimit(int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= this.data.length);
        this.limit = OplusGLSurfaceView_13;
    }

    public int getPosition() {
        return this.position;
    }

    public int capacity() {
        return this.data.length;
    }

    public void setPosition(int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= this.limit);
        this.position = OplusGLSurfaceView_13;
    }

    public void skipBytes(int OplusGLSurfaceView_13) {
        setPosition(this.position + OplusGLSurfaceView_13);
    }

    public void readBytes(ParsableBitArray parsableBitArray, int OplusGLSurfaceView_13) {
        readBytes(parsableBitArray.data, 0, OplusGLSurfaceView_13);
        parsableBitArray.setPosition(0);
    }

    public void readBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        System.arraycopy(this.data, this.position, bArr, OplusGLSurfaceView_13, i2);
        this.position += i2;
    }

    public void readBytes(ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        byteBuffer.put(this.data, this.position, OplusGLSurfaceView_13);
        this.position += OplusGLSurfaceView_13;
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        return (char) ((bArr[OplusGLSurfaceView_13 + 1] & 255) | ((bArr[OplusGLSurfaceView_13] & 255) << 8));
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        return bArr[OplusGLSurfaceView_13] & 255;
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = (bArr[OplusGLSurfaceView_13] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = bArr[OplusGLSurfaceView_13] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i2;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = (bArr[OplusGLSurfaceView_13] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = bArr[OplusGLSurfaceView_13] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) (((bArr[i3] & 255) << 8) | i2);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = (bArr[OplusGLSurfaceView_13] & 255) << 16;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = ((bArr[OplusGLSurfaceView_13] & 255) << 24) >> 8;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return (bArr[i5] & 255) | i4;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = bArr[OplusGLSurfaceView_13] & 255;
        int i3 = this.position;
        this.position = i3 + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return ((bArr[i5] & 255) << 16) | i4;
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = bArr[OplusGLSurfaceView_13] & 255;
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
        long OplusGLSurfaceView_15 = ((bArr[r1] & 255) << 24) | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        long j2 = OplusGLSurfaceView_15 | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        return j2 | (255 & bArr[r5]);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        this.position = this.position + 1;
        this.position = this.position + 1;
        long OplusGLSurfaceView_15 = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        long j2 = OplusGLSurfaceView_15 | ((bArr[r5] & 255) << 16);
        this.position = this.position + 1;
        return j2 | ((255 & bArr[r5]) << 24);
    }

    public int readInt() {
        byte[] bArr = this.data;
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = (bArr[OplusGLSurfaceView_13] & 255) << 24;
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
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = bArr[OplusGLSurfaceView_13] & 255;
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
        long OplusGLSurfaceView_15 = ((bArr[r1] & 255) << 56) | ((bArr[r5] & 255) << 48);
        this.position = this.position + 1;
        long j2 = OplusGLSurfaceView_15 | ((bArr[r5] & 255) << 40);
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
        long OplusGLSurfaceView_15 = (bArr[r1] & 255) | ((bArr[r5] & 255) << 8);
        this.position = this.position + 1;
        long j2 = OplusGLSurfaceView_15 | ((bArr[r5] & 255) << 16);
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
        int OplusGLSurfaceView_13 = this.position;
        this.position = OplusGLSurfaceView_13 + 1;
        int i2 = (bArr[OplusGLSurfaceView_13] & 255) << 8;
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
        int OplusGLSurfaceView_13 = readInt();
        if (OplusGLSurfaceView_13 >= 0) {
            return OplusGLSurfaceView_13;
        }
        throw new IllegalStateException("Top bit not zero: " + OplusGLSurfaceView_13);
    }

    public int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + littleEndianInt);
    }

    public long readUnsignedLongToLong() {
        long OplusGLSurfaceView_15 = readLong();
        if (OplusGLSurfaceView_15 >= 0) {
            return OplusGLSurfaceView_15;
        }
        throw new IllegalStateException("Top bit not zero: " + OplusGLSurfaceView_15);
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public String readString(int OplusGLSurfaceView_13) {
        return readString(OplusGLSurfaceView_13, Charset.forName("UTF-8"));
    }

    public String readString(int OplusGLSurfaceView_13, Charset charset) {
        String str = new String(this.data, this.position, OplusGLSurfaceView_13, charset);
        this.position += OplusGLSurfaceView_13;
        return str;
    }

    public String readNullTerminatedString(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return "";
        }
        int i2 = (this.position + OplusGLSurfaceView_13) - 1;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? OplusGLSurfaceView_13 : OplusGLSurfaceView_13 - 1);
        this.position += OplusGLSurfaceView_13;
        return strFromUtf8Bytes;
    }

    public String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int OplusGLSurfaceView_13 = this.position;
        while (OplusGLSurfaceView_13 < this.limit && this.data[OplusGLSurfaceView_13] != 0) {
            OplusGLSurfaceView_13++;
        }
        byte[] bArr = this.data;
        int i2 = this.position;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(bArr, i2, OplusGLSurfaceView_13 - i2);
        this.position = OplusGLSurfaceView_13;
        int i3 = this.position;
        if (i3 < this.limit) {
            this.position = i3 + 1;
        }
        return strFromUtf8Bytes;
    }

    public String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int OplusGLSurfaceView_13 = this.position;
        while (OplusGLSurfaceView_13 < this.limit && !Util.isLinebreak(this.data[OplusGLSurfaceView_13])) {
            OplusGLSurfaceView_13++;
        }
        int i2 = this.position;
        if (OplusGLSurfaceView_13 - i2 >= 3) {
            byte[] bArr = this.data;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.position = i2 + 3;
            }
        }
        byte[] bArr2 = this.data;
        int i3 = this.position;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(bArr2, i3, OplusGLSurfaceView_13 - i3);
        this.position = OplusGLSurfaceView_13;
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
        int OplusGLSurfaceView_13;
        int i2;
        long OplusGLSurfaceView_15 = this.data[this.position];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & OplusGLSurfaceView_15) != 0) {
                i3--;
            } else if (i3 < 6) {
                OplusGLSurfaceView_15 &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + OplusGLSurfaceView_15);
        }
        for (OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < i2; OplusGLSurfaceView_13++) {
            if ((this.data[this.position + OplusGLSurfaceView_13] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + OplusGLSurfaceView_15);
            }
            OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 << 6) | (r3 & 63);
        }
        this.position += i2;
        return OplusGLSurfaceView_15;
    }
}
