package okio;

/* loaded from: classes2.dex */
final class PeekSource implements okio.Source {
    private final okio.Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private okio.Segment expectedSegment;
    private long pos;
    private final okio.BufferedSource upstream;

    PeekSource(okio.BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        this.buffer = bufferedSource.buffer();
        this.expectedSegment = this.buffer.head;
        okio.Segment segment = this.expectedSegment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        okio.Segment segment = this.expectedSegment;
        if (segment != null && (segment != this.buffer.head || this.expectedPos != this.buffer.head.pos)) {
            throw new java.lang.IllegalStateException("Peek source is_renamed invalid because upstream source was used");
        }
        if (j_renamed == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && this.buffer.head != null) {
            this.expectedSegment = this.buffer.head;
            this.expectedPos = this.buffer.head.pos;
        }
        long jMin = java.lang.Math.min(j_renamed, this.buffer.size - this.pos);
        this.buffer.copyTo(buffer, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.upstream.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.closed = true;
    }
}
