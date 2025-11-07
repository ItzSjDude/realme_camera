package com.oplus.exif;

import com.oplus.exif.OplusExifInterface;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
class OplusCountedDataInputStream extends FilterInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] mByteArray;
    private final ByteBuffer mByteBuffer;
    private int mCount;

    protected OplusCountedDataInputStream(InputStream inputStream) {
        super(inputStream);
        this.mCount = 0;
        this.mByteArray = new byte[8];
        this.mByteBuffer = ByteBuffer.wrap(this.mByteArray);
    }

    public int getReadByteCount() {
        return this.mCount;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int OplusGLSurfaceView_13 = this.in.read(bArr);
        this.mCount += OplusGLSurfaceView_13 >= 0 ? OplusGLSurfaceView_13 : 0;
        return OplusGLSurfaceView_13;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        int i3 = this.in.read(bArr, OplusGLSurfaceView_13, i2);
        this.mCount += i3 >= 0 ? i3 : 0;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int OplusGLSurfaceView_13 = this.in.read();
        this.mCount += OplusGLSurfaceView_13 >= 0 ? 1 : 0;
        return OplusGLSurfaceView_13;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long OplusGLSurfaceView_15) throws IOException {
        long jSkip = this.in.skip(OplusGLSurfaceView_15);
        this.mCount = (int) (this.mCount + jSkip);
        return jSkip;
    }

    public void skipOrThrow(long OplusGLSurfaceView_15) throws IOException {
        if (skip(OplusGLSurfaceView_15) != OplusGLSurfaceView_15) {
            throw new EOFException();
        }
    }

    public void skipTo(long OplusGLSurfaceView_15) throws IOException {
        skipOrThrow(OplusGLSurfaceView_15 - this.mCount);
    }

    public void readOrThrow(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (read(bArr, OplusGLSurfaceView_13, i2) != i2) {
            throw new EOFException();
        }
    }

    public void readOrThrow(byte[] bArr) throws IOException {
        readOrThrow(bArr, 0, bArr.length);
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
    }

    public ByteOrder getByteOrder() {
        return this.mByteBuffer.order();
    }

    public short readShort() throws IOException {
        readOrThrow(this.mByteArray, 0, 2);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getShort();
    }

    public int readUnsignedShort() throws IOException {
        return readShort() & OplusExifInterface.ColorSpace.UNCALIBRATED;
    }

    public int readInt() throws IOException {
        readOrThrow(this.mByteArray, 0, 4);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getInt();
    }

    public long readUnsignedInt() throws IOException {
        return readInt() & 4294967295L;
    }

    public long readLong() throws IOException {
        readOrThrow(this.mByteArray, 0, 8);
        this.mByteBuffer.rewind();
        return this.mByteBuffer.getLong();
    }

    public String readString(int OplusGLSurfaceView_13) throws IOException {
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        readOrThrow(bArr);
        return new String(bArr, "UTF8");
    }

    public String readString(int OplusGLSurfaceView_13, Charset charset) throws IOException {
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        readOrThrow(bArr);
        return new String(bArr, charset);
    }
}
