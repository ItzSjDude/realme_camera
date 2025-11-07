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

    public int readBits(int OplusGLSurfaceView_13) {
        int i2;
        if (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > 32 || OplusGLSurfaceView_13 > available()) {
            throw new IllegalArgumentException(String.valueOf(OplusGLSurfaceView_13));
        }
        int i3 = this.bitOffset;
        if (i3 > 0) {
            int i4 = 8 - i3;
            int i5 = OplusGLSurfaceView_13 < i4 ? OplusGLSurfaceView_13 : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.bytes;
            int i7 = this.byteOffset;
            i2 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            OplusGLSurfaceView_13 -= i5;
            this.bitOffset += i5;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset = i7 + 1;
            }
        } else {
            i2 = 0;
        }
        if (OplusGLSurfaceView_13 <= 0) {
            return i2;
        }
        while (OplusGLSurfaceView_13 >= 8) {
            byte[] bArr2 = this.bytes;
            int i8 = this.byteOffset;
            i2 = (i2 << 8) | (bArr2[i8] & 255);
            this.byteOffset = i8 + 1;
            OplusGLSurfaceView_13 -= 8;
        }
        if (OplusGLSurfaceView_13 <= 0) {
            return i2;
        }
        int i9 = 8 - OplusGLSurfaceView_13;
        int i10 = (i2 << OplusGLSurfaceView_13) | ((((255 >> i9) << i9) & this.bytes[this.byteOffset]) >> i9);
        this.bitOffset += OplusGLSurfaceView_13;
        return i10;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
