package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int OplusGLSurfaceView_13) {
        this.data = bArr;
        this.byteLimit = OplusGLSurfaceView_13;
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public void reset(byte[] bArr, int OplusGLSurfaceView_13) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = OplusGLSurfaceView_13;
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public int getBytePosition() {
        Assertions.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public void setPosition(int OplusGLSurfaceView_13) {
        this.byteOffset = OplusGLSurfaceView_13 / 8;
        this.bitOffset = OplusGLSurfaceView_13 - (this.byteOffset * 8);
        assertValidOffset();
    }

    public void skipBit() {
        int OplusGLSurfaceView_13 = this.bitOffset + 1;
        this.bitOffset = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public void skipBits(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 / 8;
        this.byteOffset += i2;
        this.bitOffset += OplusGLSurfaceView_13 - (i2 * 8);
        int i3 = this.bitOffset;
        if (i3 > 7) {
            this.byteOffset++;
            this.bitOffset = i3 - 8;
        }
        assertValidOffset();
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int OplusGLSurfaceView_13) {
        int i2;
        if (OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        this.bitOffset += OplusGLSurfaceView_13;
        int i3 = 0;
        while (true) {
            i2 = this.bitOffset;
            if (i2 <= 8) {
                break;
            }
            this.bitOffset = i2 - 8;
            byte[] bArr = this.data;
            int i4 = this.byteOffset;
            this.byteOffset = i4 + 1;
            i3 |= (bArr[i4] & 255) << this.bitOffset;
        }
        byte[] bArr2 = this.data;
        int i5 = this.byteOffset;
        int i6 = ((-1) >>> (32 - OplusGLSurfaceView_13)) & (i3 | ((bArr2[i5] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i5 + 1;
        }
        assertValidOffset();
        return i6;
    }

    public void readBits(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = (i2 >> 3) + OplusGLSurfaceView_13;
        while (OplusGLSurfaceView_13 < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.byteOffset;
            this.byteOffset = i4 + 1;
            byte b2 = bArr2[i4];
            int i5 = this.bitOffset;
            bArr[OplusGLSurfaceView_13] = (byte) (b2 << i5);
            bArr[OplusGLSurfaceView_13] = (byte) (((255 & bArr2[this.byteOffset]) >> (8 - i5)) | bArr[OplusGLSurfaceView_13]);
            OplusGLSurfaceView_13++;
        }
        int i6 = i2 & 7;
        if (i6 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i6));
        int i7 = this.bitOffset;
        if (i7 + i6 > 8) {
            int i8 = bArr[i3];
            byte[] bArr3 = this.data;
            int i9 = this.byteOffset;
            this.byteOffset = i9 + 1;
            bArr[i3] = (byte) (i8 | ((bArr3[i9] & 255) << i7));
            this.bitOffset = i7 - 8;
        }
        this.bitOffset += i6;
        byte[] bArr4 = this.data;
        int i10 = this.byteOffset;
        int i11 = bArr4[i10] & 255;
        int i12 = this.bitOffset;
        bArr[i3] = (byte) (((byte) ((i11 >> (8 - i12)) << (8 - i6))) | bArr[i3]);
        if (i12 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i10 + 1;
        }
        assertValidOffset();
    }

    public void byteAlign() {
        if (this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public void readBytes(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        Assertions.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, bArr, OplusGLSurfaceView_13, i2);
        this.byteOffset += i2;
        assertValidOffset();
    }

    public void skipBytes(int OplusGLSurfaceView_13) {
        Assertions.checkState(this.bitOffset == 0);
        this.byteOffset += OplusGLSurfaceView_13;
        assertValidOffset();
    }

    public void putInt(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 32) {
            OplusGLSurfaceView_13 &= (1 << i2) - 1;
        }
        int iMin = Math.min(8 - this.bitOffset, i2);
        int i3 = this.bitOffset;
        int i4 = (8 - i3) - iMin;
        byte[] bArr = this.data;
        int i5 = this.byteOffset;
        bArr[i5] = (byte) (((65280 >> i3) | ((1 << i4) - 1)) & bArr[i5]);
        int i6 = i2 - iMin;
        bArr[i5] = (byte) (((OplusGLSurfaceView_13 >>> i6) << i4) | bArr[i5]);
        int i7 = i5 + 1;
        while (i6 > 8) {
            this.data[i7] = (byte) (OplusGLSurfaceView_13 >>> (i6 - 8));
            i6 -= 8;
            i7++;
        }
        int i8 = 8 - i6;
        byte[] bArr2 = this.data;
        bArr2[i7] = (byte) (bArr2[i7] & ((1 << i8) - 1));
        bArr2[i7] = (byte) (((OplusGLSurfaceView_13 & ((1 << i6) - 1)) << i8) | bArr2[i7]);
        skipBits(i2);
        assertValidOffset();
    }

    private void assertValidOffset() {
        int OplusGLSurfaceView_13;
        int i2 = this.byteOffset;
        Assertions.checkState(i2 >= 0 && (i2 < (OplusGLSurfaceView_13 = this.byteLimit) || (i2 == OplusGLSurfaceView_13 && this.bitOffset == 0)));
    }
}
