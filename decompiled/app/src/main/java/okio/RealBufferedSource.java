package okio;

/* loaded from: classes2.dex */
final class RealBufferedSource implements okio.BufferedSource {
    public final okio.Buffer buffer = new okio.Buffer();
    boolean closed;
    public final okio.Source source;

    RealBufferedSource(okio.Source source) {
        if (source == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // okio.BufferedSource
    public okio.Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.BufferedSource
    public okio.Buffer getBuffer() {
        return this.buffer;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, java.lang.Math.min(j_renamed, this.buffer.size));
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    public void require(long j_renamed) throws java.io.IOException {
        if (!request(j_renamed)) {
            throw new java.io.EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long j_renamed) throws java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (this.buffer.size < j_renamed) {
            if (this.source.read(this.buffer, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws java.io.IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // okio.BufferedSource
    public okio.ByteString readByteString(long j_renamed) throws java.io.IOException {
        require(j_renamed);
        return this.buffer.readByteString(j_renamed);
    }

    @Override // okio.BufferedSource
    public int select(okio.Options options) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = this.buffer.selectPrefix(options, true);
            if (iSelectPrefix == -1) {
                return -1;
            }
            if (iSelectPrefix != -2) {
                this.buffer.skip(options.byteStrings[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.buffer, 8192L) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j_renamed) throws java.io.IOException {
        require(j_renamed);
        return this.buffer.readByteArray(j_renamed);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws java.io.IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (java.io.EOFException e_renamed) {
            int i_renamed = 0;
            while (this.buffer.size > 0) {
                okio.Buffer buffer = this.buffer;
                int i2 = buffer.read(bArr, i_renamed, (int) buffer.size);
                if (i2 == -1) {
                    throw new java.lang.AssertionError();
                }
                i_renamed += i2;
            }
            throw e_renamed;
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        long j_renamed = i2;
        okio.Util.checkOffsetAndCount(bArr.length, i_renamed, j_renamed);
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i_renamed, (int) java.lang.Math.min(j_renamed, this.buffer.size));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public void readFully(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        try {
            require(j_renamed);
            this.buffer.readFully(buffer, j_renamed);
        } catch (java.io.EOFException e_renamed) {
            buffer.writeAll(this.buffer);
            throw e_renamed;
        }
    }

    @Override // okio.BufferedSource
    public long readAll(okio.Sink sink) throws java.io.IOException {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        long j_renamed = 0;
        while (this.source.read(this.buffer, 8192L) != -1) {
            long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j_renamed += jCompleteSegmentByteCount;
                sink.write(this.buffer, jCompleteSegmentByteCount);
            }
        }
        if (this.buffer.size() <= 0) {
            return j_renamed;
        }
        long size = j_renamed + this.buffer.size();
        okio.Buffer buffer = this.buffer;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8(long j_renamed) throws java.io.IOException {
        require(j_renamed);
        return this.buffer.readUtf8(j_renamed);
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(java.nio.charset.Charset charset) throws java.io.IOException {
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // okio.BufferedSource
    public java.lang.String readString(long j_renamed, java.nio.charset.Charset charset) throws java.io.IOException {
        require(j_renamed);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        return this.buffer.readString(j_renamed, charset);
    }

    @Override // okio.BufferedSource
    @javax.annotation.Nullable
    public java.lang.String readUtf8Line() throws java.io.IOException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (this.buffer.size != 0) {
            return readUtf8(this.buffer.size);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict() throws java.io.IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public java.lang.String readUtf8LineStrict(long j_renamed) throws java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("limit < 0: " + j_renamed);
        }
        long j2 = j_renamed == Long.MAX_VALUE ? Long.MAX_VALUE : j_renamed + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
            return this.buffer.readUtf8Line(j2);
        }
        okio.Buffer buffer = new okio.Buffer();
        okio.Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, java.lang.Math.min(32L, buffer2.size()));
        throw new java.io.EOFException("\\n_renamed not found: limit=" + java.lang.Math.min(this.buffer.size(), j_renamed) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws java.io.IOException {
        require(1L);
        byte b2 = this.buffer.getByte(0L);
        if ((b2 & 224) == 192) {
            require(2L);
        } else if ((b2 & 240) == 224) {
            require(3L);
        } else if ((b2 & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    public short readShort() throws java.io.IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws java.io.IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // okio.BufferedSource
    public int readInt() throws java.io.IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws java.io.IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws java.io.IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws java.io.IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws java.io.IOException {
        byte b2;
        require(1L);
        int i_renamed = 0;
        while (true) {
            int i2 = i_renamed + 1;
            if (!request(i2)) {
                break;
            }
            b2 = this.buffer.getByte(i_renamed);
            if ((b2 < 48 || b2 > 57) && !(i_renamed == 0 && b2 == 45)) {
                break;
            }
            i_renamed = i2;
        }
        if (i_renamed == 0) {
            throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9] or '-' character but was %#x_renamed", java.lang.Byte.valueOf(b2)));
        }
        return this.buffer.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        byte b2;
        require(1L);
        int i_renamed = 0;
        while (true) {
            int i2 = i_renamed + 1;
            if (!request(i2)) {
                break;
            }
            b2 = this.buffer.getByte(i_renamed);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            i_renamed = i2;
        }
        if (i_renamed == 0) {
            throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA_renamed-F_renamed] character but was %#x_renamed", java.lang.Byte.valueOf(b2)));
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public void skip(long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (j_renamed > 0) {
            if (this.buffer.size == 0 && this.source.read(this.buffer, 8192L) == -1) {
                throw new java.io.EOFException();
            }
            long jMin = java.lang.Math.min(j_renamed, this.buffer.size());
            this.buffer.skip(jMin);
            j_renamed -= jMin;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) throws java.io.IOException {
        return indexOf(b2, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j_renamed) throws java.io.IOException {
        return indexOf(b2, j_renamed, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j_renamed, long j2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j_renamed < 0 || j2 < j_renamed) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("fromIndex=%s_renamed toIndex=%s_renamed", java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(j2)));
        }
        while (j_renamed < j2) {
            long jIndexOf = this.buffer.indexOf(b2, j_renamed, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j3 = this.buffer.size;
            if (j3 >= j2 || this.source.read(this.buffer, 8192L) == -1) {
                break;
            }
            j_renamed = java.lang.Math.max(j_renamed, j3);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString) throws java.io.IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(okio.ByteString byteString, long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.buffer.indexOf(byteString, j_renamed);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            j_renamed = java.lang.Math.max(j_renamed, (j2 - byteString.size()) + 1);
        }
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString) throws java.io.IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(okio.ByteString byteString, long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.buffer.indexOfElement(byteString, j_renamed);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long j2 = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == -1) {
                return -1L;
            }
            j_renamed = java.lang.Math.max(j_renamed, j2);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j_renamed, okio.ByteString byteString) throws java.io.IOException {
        return rangeEquals(j_renamed, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j_renamed, okio.ByteString byteString, int i_renamed, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j_renamed < 0 || i_renamed < 0 || i2 < 0 || byteString.size() - i_renamed < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j_renamed;
            if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(i_renamed + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public okio.BufferedSource peek() {
        return okio.Okio.buffer(new okio.PeekSource(this));
    }

    @Override // okio.BufferedSource
    public java.io.InputStream inputStream() {
        return new java.io.InputStream() { // from class: okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int read() throws java.io.IOException {
                if (okio.RealBufferedSource.this.closed) {
                    throw new java.io.IOException("closed");
                }
                if (okio.RealBufferedSource.this.buffer.size == 0 && okio.RealBufferedSource.this.source.read(okio.RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return okio.RealBufferedSource.this.buffer.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
                if (okio.RealBufferedSource.this.closed) {
                    throw new java.io.IOException("closed");
                }
                okio.Util.checkOffsetAndCount(bArr.length, i_renamed, i2);
                if (okio.RealBufferedSource.this.buffer.size == 0 && okio.RealBufferedSource.this.source.read(okio.RealBufferedSource.this.buffer, 8192L) == -1) {
                    return -1;
                }
                return okio.RealBufferedSource.this.buffer.read(bArr, i_renamed, i2);
            }

            @Override // java.io.InputStream
            public int available() throws java.io.IOException {
                if (okio.RealBufferedSource.this.closed) {
                    throw new java.io.IOException("closed");
                }
                return (int) java.lang.Math.min(okio.RealBufferedSource.this.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                okio.RealBufferedSource.this.close();
            }

            public java.lang.String toString() {
                return okio.RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Source
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.source.timeout();
    }

    public java.lang.String toString() {
        return "buffer(" + this.source + ")";
    }
}
