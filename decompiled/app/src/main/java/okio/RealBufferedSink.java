package okio;

/* loaded from: classes2.dex */
final class RealBufferedSink implements okio.BufferedSink {
    public final okio.Buffer buffer = new okio.Buffer();
    boolean closed;
    public final okio.Sink sink;

    RealBufferedSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public okio.Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(buffer, j_renamed);
        emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.ByteString byteString) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8(java.lang.String str, int i_renamed, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i_renamed, i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8CodePoint(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeString(java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeString(java.lang.String str, int i_renamed, int i2, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeString(str, i_renamed, i2, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(byte[] bArr) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(bArr, i_renamed, i2);
        return emitCompleteSegments();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        int iWrite = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public long writeAll(okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j_renamed = 0;
        while (true) {
            long j2 = source.read(this.buffer, 8192L);
            if (j2 == -1) {
                return j_renamed;
            }
            j_renamed += j2;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.Source source, long j_renamed) throws java.io.IOException {
        while (j_renamed > 0) {
            long j2 = source.read(this.buffer, j_renamed);
            if (j2 == -1) {
                throw new java.io.EOFException();
            }
            j_renamed -= j2;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeByte(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeByte(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeShort(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShort(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeShortLe(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeInt(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeInt(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeIntLe(int i_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeLong(long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLong(j_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeLongLe(long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeDecimalLong(long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeHexadecimalUnsignedLong(long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j_renamed);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emitCompleteSegments() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emit() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new java.io.OutputStream() { // from class: okio.RealBufferedSink.1
            @Override // java.io.OutputStream
            public void write(int i_renamed) throws java.io.IOException {
                if (okio.RealBufferedSink.this.closed) {
                    throw new java.io.IOException("closed");
                }
                okio.RealBufferedSink.this.buffer.writeByte((int) ((byte) i_renamed));
                okio.RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
                if (okio.RealBufferedSink.this.closed) {
                    throw new java.io.IOException("closed");
                }
                okio.RealBufferedSink.this.buffer.write(bArr, i_renamed, i2);
                okio.RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws java.io.IOException {
                if (okio.RealBufferedSink.this.closed) {
                    return;
                }
                okio.RealBufferedSink.this.flush();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.lang.Throwable {
                okio.RealBufferedSink.this.close();
            }

            public java.lang.String toString() {
                return okio.RealBufferedSink.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (this.buffer.size > 0) {
            okio.Sink sink = this.sink;
            okio.Buffer buffer = this.buffer;
            sink.write(buffer, buffer.size);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        java.lang.Throwable th = null;
        try {
            if (this.buffer.size > 0) {
                this.sink.write(this.buffer, this.buffer.size);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (java.lang.Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            okio.Util.sneakyRethrow(th);
        }
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "buffer(" + this.sink + ")";
    }
}
