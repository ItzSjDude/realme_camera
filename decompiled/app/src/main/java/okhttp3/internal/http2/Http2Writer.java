package okhttp3.internal.http2;

/* loaded from: classes2.dex */
final class Http2Writer implements java.io.Closeable {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(okhttp3.internal.http2.Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final okio.Buffer hpackBuffer = new okio.Buffer();
    final okhttp3.internal.http2.Hpack.Writer hpackWriter = new okhttp3.internal.http2.Hpack.Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final okio.BufferedSink sink;

    Http2Writer(okio.BufferedSink bufferedSink, boolean z_renamed) {
        this.sink = bufferedSink;
        this.client = z_renamed;
    }

    public synchronized void connectionPreface() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (this.client) {
            if (logger.isLoggable(java.util.logging.Level.FINE)) {
                logger.fine(okhttp3.internal.Util.format(">> CONNECTION %s_renamed", okhttp3.internal.http2.Http2.CONNECTION_PREFACE.hex()));
            }
            this.sink.write(okhttp3.internal.http2.Http2.CONNECTION_PREFACE.toByteArray());
            this.sink.flush();
        }
    }

    public synchronized void applyAndAckSettings(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.sink.flush();
    }

    public synchronized void pushPromise(int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) java.lang.Math.min(this.maxFrameSize - 4, size);
        long j_renamed = iMin;
        frameHeader(i_renamed, iMin + 4, (byte) 5, size == j_renamed ? (byte) 4 : (byte) 0);
        this.sink.writeInt(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j_renamed);
        if (size > j_renamed) {
            writeContinuationFrames(i_renamed, size - j_renamed);
        }
    }

    public synchronized void flush() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.sink.flush();
    }

    public synchronized void synStream(boolean z_renamed, int i_renamed, int i2, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(z_renamed, i_renamed, list);
    }

    public synchronized void synReply(boolean z_renamed, int i_renamed, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(z_renamed, i_renamed, list);
    }

    public synchronized void headers(int i_renamed, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(false, i_renamed, list);
    }

    public synchronized void rstStream(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        frameHeader(i_renamed, 4, (byte) 3, (byte) 0);
        this.sink.writeInt(errorCode.httpCode);
        this.sink.flush();
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void data(boolean z_renamed, int i_renamed, okio.Buffer buffer, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        dataFrame(i_renamed, z_renamed ? (byte) 1 : (byte) 0, buffer, i2);
    }

    void dataFrame(int i_renamed, byte b2, okio.Buffer buffer, int i2) throws java.io.IOException {
        frameHeader(i_renamed, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.sink.write(buffer, i2);
        }
    }

    public synchronized void settings(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        int i_renamed = 0;
        frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
        while (i_renamed < 10) {
            if (settings.isSet(i_renamed)) {
                this.sink.writeShort(i_renamed == 4 ? 3 : i_renamed == 7 ? 4 : i_renamed);
                this.sink.writeInt(settings.get(i_renamed));
            }
            i_renamed++;
        }
        this.sink.flush();
    }

    public synchronized void ping(boolean z_renamed, int i_renamed, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z_renamed ? (byte) 1 : (byte) 0);
        this.sink.writeInt(i_renamed);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public synchronized void goAway(int i_renamed, okhttp3.internal.http2.ErrorCode errorCode, byte[] bArr) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw okhttp3.internal.http2.Http2.illegalArgument("errorCode.httpCode == -1", new java.lang.Object[0]);
        }
        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.sink.writeInt(i_renamed);
        this.sink.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public synchronized void windowUpdate(int i_renamed, long j_renamed) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (j_renamed == 0 || j_renamed > 2147483647L) {
            throw okhttp3.internal.http2.Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s_renamed", java.lang.Long.valueOf(j_renamed));
        }
        frameHeader(i_renamed, 4, (byte) 8, (byte) 0);
        this.sink.writeInt((int) j_renamed);
        this.sink.flush();
    }

    public void frameHeader(int i_renamed, int i2, byte b2, byte b3) throws java.io.IOException {
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            logger.fine(okhttp3.internal.http2.Http2.frameLog(false, i_renamed, i2, b2, b3));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            throw okhttp3.internal.http2.Http2.illegalArgument("FRAME_SIZE_ERROR length > %d_renamed: %d_renamed", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i_renamed) != 0) {
            throw okhttp3.internal.http2.Http2.illegalArgument("reserved bit set: %s_renamed", java.lang.Integer.valueOf(i_renamed));
        }
        writeMedium(this.sink, i2);
        this.sink.writeByte(b2 & 255);
        this.sink.writeByte(b3 & 255);
        this.sink.writeInt(i_renamed & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(okio.BufferedSink bufferedSink, int i_renamed) throws java.io.IOException {
        bufferedSink.writeByte((i_renamed >>> 16) & 255);
        bufferedSink.writeByte((i_renamed >>> 8) & 255);
        bufferedSink.writeByte(i_renamed & 255);
    }

    private void writeContinuationFrames(int i_renamed, long j_renamed) throws java.io.IOException {
        while (j_renamed > 0) {
            int iMin = (int) java.lang.Math.min(this.maxFrameSize, j_renamed);
            long j2 = iMin;
            j_renamed -= j2;
            frameHeader(i_renamed, iMin, (byte) 9, j_renamed == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    void headers(boolean z_renamed, int i_renamed, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) java.lang.Math.min(this.maxFrameSize, size);
        long j_renamed = iMin;
        byte b2 = size == j_renamed ? (byte) 4 : (byte) 0;
        if (z_renamed) {
            b2 = (byte) (b2 | 1);
        }
        frameHeader(i_renamed, iMin, (byte) 1, b2);
        this.sink.write(this.hpackBuffer, j_renamed);
        if (size > j_renamed) {
            writeContinuationFrames(i_renamed, size - j_renamed);
        }
    }
}
