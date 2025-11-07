package com.google.protobuf;

/* loaded from: classes.dex */
final class NioByteString extends com.google.protobuf.ByteString.LeafByteString {
    private final java.nio.ByteBuffer buffer;

    NioByteString(java.nio.ByteBuffer byteBuffer) {
        com.google.protobuf.Internal.checkNotNull(byteBuffer, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.YUV_BUFFER);
        this.buffer = byteBuffer.slice().order(java.nio.ByteOrder.nativeOrder());
    }

    private java.lang.Object writeReplace() {
        return com.google.protobuf.ByteString.copyFrom(this.buffer.slice());
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException {
        throw new java.io.InvalidObjectException("NioByteString instances are not to be_renamed serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i_renamed) {
        try {
            return this.buffer.get(i_renamed);
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            throw e_renamed;
        } catch (java.lang.IndexOutOfBoundsException e2) {
            throw new java.lang.ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i_renamed) {
        return byteAt(i_renamed);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public com.google.protobuf.ByteString substring(int i_renamed, int i2) {
        try {
            return new com.google.protobuf.NioByteString(slice(i_renamed, i2));
        } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
            throw e_renamed;
        } catch (java.lang.IndexOutOfBoundsException e2) {
            throw new java.lang.ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i_renamed, int i2, int i3) {
        java.nio.ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(i_renamed);
        byteBufferSlice.get(bArr, i2, i3);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    boolean equalsRange(com.google.protobuf.ByteString byteString, int i_renamed, int i2) {
        return substring(0, i2).equals(byteString.substring(i_renamed, i2 + i_renamed));
    }

    @Override // com.google.protobuf.ByteString
    void writeToInternal(java.io.OutputStream outputStream, int i_renamed, int i2) throws java.io.IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i_renamed, i2);
        } else {
            com.google.protobuf.ByteBufferWriter.write(slice(i_renamed, i2 + i_renamed), outputStream);
        }
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(com.google.protobuf.ByteOutput byteOutput) throws java.io.IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public java.nio.ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public java.util.List<java.nio.ByteBuffer> asReadOnlyByteBufferList() {
        return java.util.Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    protected java.lang.String toStringInternal(java.nio.charset.Charset charset) {
        byte[] byteArray;
        int iArrayOffset;
        int length;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            iArrayOffset = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            iArrayOffset = 0;
            length = byteArray.length;
        }
        return new java.lang.String(byteArray, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return com.google.protobuf.Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    protected int partialIsValidUtf8(int i_renamed, int i2, int i3) {
        return com.google.protobuf.Utf8.partialIsValidUtf8(i_renamed, this.buffer, i2, i3 + i2);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.ByteString)) {
            return false;
        }
        com.google.protobuf.ByteString byteString = (com.google.protobuf.ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof com.google.protobuf.NioByteString) {
            return this.buffer.equals(((com.google.protobuf.NioByteString) obj).buffer);
        }
        if (obj instanceof com.google.protobuf.RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    protected int partialHash(int i_renamed, int i2, int i3) {
        int i4 = i_renamed;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + this.buffer.get(i5);
        }
        return i4;
    }

    @Override // com.google.protobuf.ByteString
    public java.io.InputStream newInput() {
        return new java.io.InputStream() { // from class: com.google.protobuf.NioByteString.1
            private final java.nio.ByteBuffer buf;

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            {
                this.buf = com.google.protobuf.NioByteString.this.buffer.slice();
            }

            @Override // java.io.InputStream
            public void mark(int i_renamed) {
                this.buf.mark();
            }

            @Override // java.io.InputStream
            public void reset() throws java.io.IOException {
                try {
                    this.buf.reset();
                } catch (java.nio.InvalidMarkException e_renamed) {
                    throw new java.io.IOException(e_renamed);
                }
            }

            @Override // java.io.InputStream
            public int available() throws java.io.IOException {
                return this.buf.remaining();
            }

            @Override // java.io.InputStream
            public int read() throws java.io.IOException {
                if (this.buf.hasRemaining()) {
                    return this.buf.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int iMin = java.lang.Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, i_renamed, iMin);
                return iMin;
            }
        };
    }

    @Override // com.google.protobuf.ByteString
    public com.google.protobuf.CodedInputStream newCodedInput() {
        return com.google.protobuf.CodedInputStream.newInstance(this.buffer, true);
    }

    private java.nio.ByteBuffer slice(int i_renamed, int i2) {
        if (i_renamed < this.buffer.position() || i2 > this.buffer.limit() || i_renamed > i2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Invalid indices [%d_renamed, %d_renamed]", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
        }
        java.nio.ByteBuffer byteBufferSlice = this.buffer.slice();
        byteBufferSlice.position(i_renamed - this.buffer.position());
        byteBufferSlice.limit(i2 - this.buffer.position());
        return byteBufferSlice;
    }
}
