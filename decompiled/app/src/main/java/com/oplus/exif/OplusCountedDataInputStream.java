package com.oplus.exif;

/* loaded from: classes2.dex */
class OplusCountedDataInputStream extends java.io.FilterInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] mByteArray;
    private final java.nio.ByteBuffer mByteBuffer;
    private int mCount;

    protected OplusCountedDataInputStream(java.io.InputStream inputStream) {
        super(inputStream);
        this.mCount = 0;
        this.mByteArray = new byte[8];
        this.mByteBuffer = java.nio.ByteBuffer.wrap(this.mByteArray);
    }

    public int getReadByteCount() {
        return this.mCount;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        int i_renamed = this.in_renamed.read(bArr);
        this.mCount += i_renamed >= 0 ? i_renamed : 0;
        return i_renamed;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        int i3 = this.in_renamed.read(bArr, i_renamed, i2);
        this.mCount += i3 >= 0 ? i3 : 0;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int i_renamed = this.in_renamed.read();
        this.mCount += i_renamed >= 0 ? 1 : 0;
        return i_renamed;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j_renamed) throws java.io.IOException {
        long jSkip = this.in_renamed.skip(j_renamed);
        this.mCount = (int) (this.mCount + jSkip);
        return jSkip;
    }

    public void skipOrThrow(long j_renamed) throws java.io.IOException {
        if (skip(j_renamed) != j_renamed) {
            throw new java.io.EOFException();
        }
    }

    public void skipTo(long j_renamed) throws java.io.IOException {
        skipOrThrow(j_renamed - this.mCount);
    }

    public void readOrThrow(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (read(bArr, i_renamed, i2) != i2) {
            throw new java.io.EOFException();
        }
    }

    public void readOrThrow(byte[] bArr) throws java.io.IOException {
        readOrThrow(bArr, 0, bArr.length);
    }

    public void setByteOrder(java.nio.ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
    }

    public java.nio.ByteOrder getByteOrder() {
        return this.mByteBuffer.order();
    }

    public short readShort() throws java.io.IOException {
        readOrThrow(this.mByteArray, 0, 2);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getShort();
    }

    public int readUnsignedShort() throws java.io.IOException {
        return readShort() & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    public int readInt() throws java.io.IOException {
        readOrThrow(this.mByteArray, 0, 4);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getInt();
    }

    public long readUnsignedInt() throws java.io.IOException {
        return readInt() & 4294967295L;
    }

    public long readLong() throws java.io.IOException {
        readOrThrow(this.mByteArray, 0, 8);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getLong();
    }

    public java.lang.String readString(int i_renamed) throws java.io.IOException {
        byte[] bArr = new byte[i_renamed];
        readOrThrow(bArr);
        return new java.lang.String(bArr, "UTF8");
    }

    public java.lang.String readString(int i_renamed, java.nio.charset.Charset charset) throws java.io.IOException {
        byte[] bArr = new byte[i_renamed];
        readOrThrow(bArr);
        return new java.lang.String(bArr, charset);
    }
}
