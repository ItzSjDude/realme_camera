package com.google.android.exoplayer2.extractor.ogg;

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
        boolean z_renamed = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
        skipBits(1);
        return z_renamed;
    }

    public int readBits(int i_renamed) {
        int i2 = this.byteOffset;
        int iMin = java.lang.Math.min(i_renamed, 8 - this.bitOffset);
        int i3 = i2 + 1;
        int i4 = ((this.data[i2] & 255) >> this.bitOffset) & (255 >> (8 - iMin));
        while (iMin < i_renamed) {
            i4 |= (this.data[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i_renamed));
        skipBits(i_renamed);
        return i5;
    }

    public void skipBits(int i_renamed) {
        int i2 = i_renamed / 8;
        this.byteOffset += i2;
        this.bitOffset += i_renamed - (i2 * 8);
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

    public void setPosition(int i_renamed) {
        this.byteOffset = i_renamed / 8;
        this.bitOffset = i_renamed - (this.byteOffset * 8);
        assertValidOffset();
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    private void assertValidOffset() {
        int i_renamed;
        int i2 = this.byteOffset;
        com.google.android.exoplayer2.util.Assertions.checkState(i2 >= 0 && (i2 < (i_renamed = this.byteLimit) || (i2 == i_renamed && this.bitOffset == 0)));
    }
}
