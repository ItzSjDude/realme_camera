package okio;

/* loaded from: classes2.dex */
public final class InflaterSource implements okio.Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final java.util.zip.Inflater inflater;
    private final okio.BufferedSource source;

    public InflaterSource(okio.Source source, java.util.zip.Inflater inflater) {
        this(okio.Okio.buffer(source), inflater);
    }

    InflaterSource(okio.BufferedSource bufferedSource, java.util.zip.Inflater inflater) {
        if (bufferedSource == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.util.zip.DataFormatException, java.io.IOException {
        boolean zRefill;
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j_renamed == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                okio.Segment segmentWritableSegment = buffer.writableSegment(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j_renamed, 8192 - segmentWritableSegment.limit));
                if (iInflate > 0) {
                    segmentWritableSegment.limit += iInflate;
                    long j2 = iInflate;
                    buffer.size += j2;
                    return j2;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment.pos != segmentWritableSegment.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment.pop();
                okio.SegmentPool.recycle(segmentWritableSegment);
                return -1L;
            } catch (java.util.zip.DataFormatException e_renamed) {
                throw new java.io.IOException(e_renamed);
            }
        } while (!zRefill);
        throw new java.io.EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws java.io.IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new java.lang.IllegalStateException("?");
        }
        if (this.source.exhausted()) {
            return true;
        }
        okio.Segment segment = this.source.buffer().head;
        this.bufferBytesHeldByInflater = segment.limit - segment.pos;
        this.inflater.setInput(segment.data, segment.pos, this.bufferBytesHeldByInflater);
        return false;
    }

    private void releaseInflatedBytes() throws java.io.IOException {
        int i_renamed = this.bufferBytesHeldByInflater;
        if (i_renamed == 0) {
            return;
        }
        int remaining = i_renamed - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }
}
