package okio;

/* loaded from: classes2.dex */
public abstract class ForwardingSink implements okio.Sink {
    private final okio.Sink delegate;

    public ForwardingSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = sink;
    }

    public final okio.Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        this.delegate.write(buffer, j_renamed);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.delegate.close();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
