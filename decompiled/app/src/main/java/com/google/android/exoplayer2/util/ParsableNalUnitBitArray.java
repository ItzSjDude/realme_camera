package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        reset(bArr, OplusGLSurfaceView_13, i2);
    }

    public void reset(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        this.data = bArr;
        this.byteOffset = OplusGLSurfaceView_13;
        this.byteLimit = i2;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public void skipBit() {
        int OplusGLSurfaceView_13 = this.bitOffset + 1;
        this.bitOffset = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 8) {
            this.bitOffset = 0;
            int i2 = this.byteOffset;
            this.byteOffset = i2 + (shouldSkipByte(i2 + 1) ? 2 : 1);
        }
        assertValidOffset();
    }

    public void skipBits(int OplusGLSurfaceView_13) {
        int i2 = this.byteOffset;
        int i3 = OplusGLSurfaceView_13 / 8;
        this.byteOffset = i2 + i3;
        this.bitOffset += OplusGLSurfaceView_13 - (i3 * 8);
        int i4 = this.bitOffset;
        if (i4 > 7) {
            this.byteOffset++;
            this.bitOffset = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 <= this.byteOffset) {
                if (shouldSkipByte(i2)) {
                    this.byteOffset++;
                    i2 += 2;
                }
            } else {
                assertValidOffset();
                return;
            }
        }
    }

    public boolean canReadBits(int OplusGLSurfaceView_13) {
        int i2 = this.byteOffset;
        int i3 = OplusGLSurfaceView_13 / 8;
        int i4 = i2 + i3;
        int i5 = (this.bitOffset + OplusGLSurfaceView_13) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.byteLimit) {
                break;
            }
            if (shouldSkipByte(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.byteLimit;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int OplusGLSurfaceView_13) {
        int i2;
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
            i3 |= (bArr[i4] & 255) << this.bitOffset;
            if (!shouldSkipByte(i4 + 1)) {
                OplusGLSurfaceView_13 = 1;
            }
            this.byteOffset = i4 + OplusGLSurfaceView_13;
        }
        byte[] bArr2 = this.data;
        int i5 = this.byteOffset;
        int i6 = ((-1) >>> (32 - OplusGLSurfaceView_13)) & (i3 | ((bArr2[i5] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i5 + (shouldSkipByte(i5 + 1) ? 2 : 1);
        }
        assertValidOffset();
        return i6;
    }

    public boolean canReadExpGolombCodedNum() {
        int OplusGLSurfaceView_13 = this.byteOffset;
        int i2 = this.bitOffset;
        int i3 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i3++;
        }
        boolean z = this.byteOffset == this.byteLimit;
        this.byteOffset = OplusGLSurfaceView_13;
        this.bitOffset = i2;
        return !z && canReadBits((i3 * 2) + 1);
    }

    public int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public int readSignedExpGolombCodedInt() {
        int expGolombCodeNum = readExpGolombCodeNum();
        return (expGolombCodeNum % 2 == 0 ? -1 : 1) * ((expGolombCodeNum + 1) / 2);
    }

    private int readExpGolombCodeNum() {
        int OplusGLSurfaceView_13 = 0;
        while (!readBit()) {
            OplusGLSurfaceView_13++;
        }
        return ((1 << OplusGLSurfaceView_13) - 1) + (OplusGLSurfaceView_13 > 0 ? readBits(OplusGLSurfaceView_13) : 0);
    }

    private boolean shouldSkipByte(int OplusGLSurfaceView_13) {
        if (2 <= OplusGLSurfaceView_13 && OplusGLSurfaceView_13 < this.byteLimit) {
            byte[] bArr = this.data;
            if (bArr[OplusGLSurfaceView_13] == 3 && bArr[OplusGLSurfaceView_13 - 2] == 0 && bArr[OplusGLSurfaceView_13 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    private void assertValidOffset() {
        int OplusGLSurfaceView_13;
        int i2 = this.byteOffset;
        Assertions.checkState(i2 >= 0 && (i2 < (OplusGLSurfaceView_13 = this.byteLimit) || (i2 == OplusGLSurfaceView_13 && this.bitOffset == 0)));
    }
}
