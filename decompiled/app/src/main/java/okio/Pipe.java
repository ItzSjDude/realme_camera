package okio;

/* loaded from: classes2.dex */
public final class Pipe {

    @javax.annotation.Nullable
    private okio.Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final okio.Buffer buffer = new okio.Buffer();
    private final okio.Sink sink = new okio.Pipe.PipeSink();
    private final okio.Source source = new okio.Pipe.PipeSource();

    public Pipe(long j_renamed) {
        if (j_renamed < 1) {
            throw new java.lang.IllegalArgumentException("maxBufferSize < 1: " + j_renamed);
        }
        this.maxBufferSize = j_renamed;
    }

    public final okio.Source source() {
        return this.source;
    }

    public final okio.Sink sink() {
        return this.sink;
    }

    public void fold(okio.Sink sink) throws java.io.IOException {
        boolean z_renamed;
        okio.Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new java.lang.IllegalStateException("sink already folded");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z_renamed = this.sinkClosed;
                    buffer = new okio.Buffer();
                    buffer.write(this.buffer, this.buffer.size);
                    this.buffer.notifyAll();
                }
            }
            try {
                sink.write(buffer, buffer.size);
                if (z_renamed) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    final class PipeSink implements okio.Sink {
        final okio.PushableTimeout timeout = new okio.PushableTimeout();

        PipeSink() {
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                if (!okio.Pipe.this.sinkClosed) {
                    while (true) {
                        if (j_renamed <= 0) {
                            sink = null;
                            break;
                        }
                        if (okio.Pipe.this.foldedSink != null) {
                            sink = okio.Pipe.this.foldedSink;
                            break;
                        }
                        if (okio.Pipe.this.sourceClosed) {
                            throw new java.io.IOException("source is_renamed closed");
                        }
                        long size = okio.Pipe.this.maxBufferSize - okio.Pipe.this.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(okio.Pipe.this.buffer);
                        } else {
                            long jMin = java.lang.Math.min(size, j_renamed);
                            okio.Pipe.this.buffer.write(buffer, jMin);
                            j_renamed -= jMin;
                            okio.Pipe.this.buffer.notifyAll();
                        }
                    }
                } else {
                    throw new java.lang.IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j_renamed);
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                if (!okio.Pipe.this.sinkClosed) {
                    if (okio.Pipe.this.foldedSink != null) {
                        sink = okio.Pipe.this.foldedSink;
                    } else {
                        if (okio.Pipe.this.sourceClosed && okio.Pipe.this.buffer.size() > 0) {
                            throw new java.io.IOException("source is_renamed closed");
                        }
                        sink = null;
                    }
                } else {
                    throw new java.lang.IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                if (okio.Pipe.this.sinkClosed) {
                    return;
                }
                if (okio.Pipe.this.foldedSink != null) {
                    sink = okio.Pipe.this.foldedSink;
                } else {
                    if (okio.Pipe.this.sourceClosed && okio.Pipe.this.buffer.size() > 0) {
                        throw new java.io.IOException("source is_renamed closed");
                    }
                    okio.Pipe.this.sinkClosed = true;
                    okio.Pipe.this.buffer.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.timeout.push(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.timeout.pop();
                    }
                }
            }
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.timeout;
        }
    }

    final class PipeSource implements okio.Source {
        final okio.Timeout timeout = new okio.Timeout();

        PipeSource() {
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            synchronized (okio.Pipe.this.buffer) {
                if (okio.Pipe.this.sourceClosed) {
                    throw new java.lang.IllegalStateException("closed");
                }
                while (okio.Pipe.this.buffer.size() == 0) {
                    if (okio.Pipe.this.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(okio.Pipe.this.buffer);
                }
                long j2 = okio.Pipe.this.buffer.read(buffer, j_renamed);
                okio.Pipe.this.buffer.notifyAll();
                return j2;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (okio.Pipe.this.buffer) {
                okio.Pipe.this.sourceClosed = true;
                okio.Pipe.this.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.timeout;
        }
    }
}
