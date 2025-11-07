package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] bArr) {
        this.data = bArr;
        this.byteLimit = bArr.length;
    }

    public void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public boolean readBit() {
        boolean z = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
        skipBits(1);
        return z;
    }

    public int readBits(int OplusGLSurfaceView_13) {
        int i2 = this.byteOffset;
        int iMin = Math.min(OplusGLSurfaceView_13, 8 - this.bitOffset);
        int i3 = i2 + 1;
        int i4 = ((this.data[i2] & 255) >> this.bitOffset) & (255 >> (8 - iMin));
        while (iMin < OplusGLSurfaceView_13) {
            i4 |= (this.data[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - OplusGLSurfaceView_13));
        skipBits(OplusGLSurfaceView_13);
        return i5;
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

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public void setPosition(int OplusGLSurfaceView_13) {
        this.byteOffset = OplusGLSurfaceView_13 / 8;
        this.bitOffset = OplusGLSurfaceView_13 - (this.byteOffset * 8);
        assertValidOffset();
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    private void assertValidOffset() {
        int OplusGLSurfaceView_13;
        int i2 = this.byteOffset;
        Assertions.checkState(i2 >= 0 && (i2 < (OplusGLSurfaceView_13 = this.byteLimit) || (i2 == OplusGLSurfaceView_13 && this.bitOffset == 0)));
    }
}
