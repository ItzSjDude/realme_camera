package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusByteBufferInputStream extends java.io.InputStream {
    private java.nio.ByteBuffer mBuf;

    public OplusByteBufferInputStream(java.nio.ByteBuffer byteBuffer) {
        this.mBuf = byteBuffer;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.mBuf.hasRemaining()) {
            return this.mBuf.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i_renamed, int i2) {
        if (!this.mBuf.hasRemaining()) {
            return -1;
        }
        int iMin = java.lang.Math.min(i2, this.mBuf.remaining());
        this.mBuf.get(bArr, i_renamed, iMin);
        return iMin;
    }
}
