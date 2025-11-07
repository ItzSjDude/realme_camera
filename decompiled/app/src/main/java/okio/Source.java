package okio;

/* loaded from: classes2.dex */
public interface Source extends java.io.Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws java.io.IOException;

    long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException;

    okio.Timeout timeout();
}
