package okhttp3.internal.cache;

/* loaded from: classes2.dex */
class FaultHidingSink extends okio.ForwardingSink {
    private boolean hasErrors;

    protected void onException(java.io.IOException iOException) {
    }

    FaultHidingSink(okio.Sink sink) {
        super(sink);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        if (this.hasErrors) {
            buffer.skip(j_renamed);
            return;
        }
        try {
            super.write(buffer, j_renamed);
        } catch (java.io.IOException e_renamed) {
            this.hasErrors = true;
            onException(e_renamed);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (java.io.IOException e_renamed) {
            this.hasErrors = true;
            onException(e_renamed);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (java.io.IOException e_renamed) {
            this.hasErrors = true;
            onException(e_renamed);
        }
    }
}
