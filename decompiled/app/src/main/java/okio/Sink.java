package okio;

/* loaded from: classes2.dex */
public interface Sink extends java.io.Closeable, java.io.Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws java.io.IOException;

    void flush() throws java.io.IOException;

    okio.Timeout timeout();

    void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException;
}
