package com.oplus.exif;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
class OrderedDataOutputStream extends FilterOutputStream {
    private final ByteBuffer mByteBuffer;

    public OrderedDataOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.mByteBuffer = ByteBuffer.allocate(4);
    }

    public OrderedDataOutputStream setByteOrder(ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
        return this;
    }

    public OrderedDataOutputStream writeShort(short s) throws IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putShort(s);
        this.out.write(this.mByteBuffer.array(), 0, 2);
        return this;
    }

    public OrderedDataOutputStream writeInt(int OplusGLSurfaceView_13) throws IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putInt(OplusGLSurfaceView_13);
        this.out.write(this.mByteBuffer.array());
        return this;
    }

    public OrderedDataOutputStream writeRational(OplusRational oplusRational) throws IOException {
        writeInt((int) oplusRational.getNumerator());
        writeInt((int) oplusRational.getDenominator());
        return this;
    }
}
