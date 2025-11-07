package com.google.protobuf;

/* loaded from: classes.dex */
class IterableByteBufferInputStream extends java.io.InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private java.nio.ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize = 0;
    private boolean hasArray;
    private java.util.Iterator<java.nio.ByteBuffer> iterator;

    IterableByteBufferInputStream(java.lang.Iterable<java.nio.ByteBuffer> iterable) {
        this.iterator = iterable.iterator();
        for (java.nio.ByteBuffer byteBuffer : iterable) {
            this.dataSize++;
        }
        this.currentIndex = -1;
        if (getNextByteBuffer()) {
            return;
        }
        this.currentByteBuffer = com.google.protobuf.Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0L;
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (!this.iterator.hasNext()) {
            return false;
        }
        this.currentByteBuffer = this.iterator.next();
        this.currentByteBufferPos = this.currentByteBuffer.position();
        if (this.currentByteBuffer.hasArray()) {
            this.hasArray = true;
            this.currentArray = this.currentByteBuffer.array();
            this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
        } else {
            this.hasArray = false;
            this.currentAddress = com.google.protobuf.UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentArray = null;
        }
        return true;
    }

    private void updateCurrentByteBufferPos(int i_renamed) {
        this.currentByteBufferPos += i_renamed;
        if (this.currentByteBufferPos == this.currentByteBuffer.limit()) {
            getNextByteBuffer();
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        if (this.hasArray) {
            int i_renamed = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
            updateCurrentByteBufferPos(1);
            return i_renamed;
        }
        int i2 = com.google.protobuf.UnsafeUtil.getByte(this.currentByteBufferPos + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int iLimit = this.currentByteBuffer.limit() - this.currentByteBufferPos;
        if (i2 > iLimit) {
            i2 = iLimit;
        }
        if (this.hasArray) {
            java.lang.System.arraycopy(this.currentArray, this.currentByteBufferPos + this.currentArrayOffset, bArr, i_renamed, i2);
            updateCurrentByteBufferPos(i2);
        } else {
            int iPosition = this.currentByteBuffer.position();
            this.currentByteBuffer.position(this.currentByteBufferPos);
            this.currentByteBuffer.get(bArr, i_renamed, i2);
            this.currentByteBuffer.position(iPosition);
            updateCurrentByteBufferPos(i2);
        }
        return i2;
    }
}
