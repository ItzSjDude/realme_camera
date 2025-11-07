package com.oplus.exif;

/* loaded from: classes2.dex */
class OrderedDataOutputStream extends java.io.FilterOutputStream {
    private final java.nio.ByteBuffer mByteBuffer;

    public OrderedDataOutputStream(java.io.OutputStream outputStream) {
        super(outputStream);
        this.mByteBuffer = java.nio.ByteBuffer.allocate(4);
    }

    public com.oplus.exif.OrderedDataOutputStream setByteOrder(java.nio.ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
        return this;
    }

    public com.oplus.exif.OrderedDataOutputStream writeShort(short s_renamed) throws java.io.IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putShort(s_renamed);
        this.out.write(this.mByteBuffer.array(), 0, 2);
        return this;
    }

    public com.oplus.exif.OrderedDataOutputStream writeInt(int i_renamed) throws java.io.IOException {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putInt(i_renamed);
        this.out.write(this.mByteBuffer.array());
        return this;
    }

    public com.oplus.exif.OrderedDataOutputStream writeRational(com.oplus.exif.OplusRational oplusRational) throws java.io.IOException {
        writeInt((int) oplusRational.getNumerator());
        writeInt((int) oplusRational.getDenominator());
        return this;
    }
}
