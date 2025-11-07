package com.google.zxing.common;

/* loaded from: classes.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i_renamed) {
        int i2;
        if (i_renamed <= 0 || i_renamed > 32 || i_renamed > available()) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(i_renamed));
        }
        int i3 = this.bitOffset;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int i5 = i_renamed < i4 ? i_renamed : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            i2 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i_renamed -= i5;
            this.bitOffset += i5;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
        } else {
            i2 = 0;
        }
        if (i_renamed <= 0) {
            return i2;
        }
        while (i_renamed >= 8) {
            byte[] bArr2 = this.bytes;
            int i8 = this.byteOffset;
            i2 = (i2 << 8) | (bArr2[i8] & 255);
            this.byteOffset = i8 + 1;
            i_renamed -= 8;
        }
        if (i_renamed <= 0) {
            return i2;
        }
        int i9 = 8 - i_renamed;
        int i10 = (i2 << i_renamed) | ((((255 >> i9) << i9) & this.bytes[this.byteOffset]) >> i9);
        this.bitOffset += i_renamed;
        return i10;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
