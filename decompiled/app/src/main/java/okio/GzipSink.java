package okio;

/* loaded from: classes2.dex */
public final class GzipSink implements okio.Sink {
    private boolean closed;
    private final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
    private final java.util.zip.Deflater deflater;
    private final okio.DeflaterSink deflaterSink;
    private final okio.BufferedSink sink;

    public GzipSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        this.deflater = new java.util.zip.Deflater(-1, true);
        this.sink = okio.Okio.buffer(sink);
        this.deflaterSink = new okio.DeflaterSink(this.sink, this.deflater);
        writeHeader();
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (j_renamed == 0) {
            return;
        }
        updateCrc(buffer, j_renamed);
        this.deflaterSink.write(buffer, j_renamed);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        java.lang.Throwable th = null;
        try {
            this.deflaterSink.finishDeflate();
            writeFooter();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (java.lang.Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (java.lang.Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            okio.Util.sneakyRethrow(th);
        }
    }

    public final java.util.zip.Deflater deflater() {
        return this.deflater;
    }

    private void writeHeader() {
        okio.Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private void writeFooter() throws java.io.IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void updateCrc(okio.Buffer buffer, long j_renamed) {
        okio.Segment segment = buffer.head;
        while (j_renamed > 0) {
            int iMin = (int) java.lang.Math.min(j_renamed, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, iMin);
            j_renamed -= iMin;
            segment = segment.next;
        }
    }
}
