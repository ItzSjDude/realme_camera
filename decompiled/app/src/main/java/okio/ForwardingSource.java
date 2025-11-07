package okio;

/* loaded from: classes2.dex */
public abstract class ForwardingSource implements okio.Source {
    private final okio.Source delegate;

    public ForwardingSource(okio.Source source) {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = source;
    }

    public final okio.Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        return this.delegate.read(buffer, j_renamed);
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.delegate.close();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
