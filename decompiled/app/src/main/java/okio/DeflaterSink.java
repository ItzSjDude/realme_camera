package okio;

/* loaded from: classes2.dex */
public final class DeflaterSink implements okio.Sink {
    private boolean closed;
    private final java.util.zip.Deflater deflater;
    private final okio.BufferedSink sink;

    public DeflaterSink(okio.Sink sink, java.util.zip.Deflater deflater) {
        this(okio.Okio.buffer(sink), deflater);
    }

    DeflaterSink(okio.BufferedSink bufferedSink, java.util.zip.Deflater deflater) {
        if (bufferedSink == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j_renamed);
        while (j_renamed > 0) {
            okio.Segment segment = buffer.head;
            int iMin = (int) java.lang.Math.min(j_renamed, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j2 = iMin;
            buffer.size -= j2;
            segment.pos += iMin;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                okio.SegmentPool.recycle(segment);
            }
            j_renamed -= j2;
        }
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    private void deflate(boolean z_renamed) throws java.io.IOException {
        okio.Segment segmentWritableSegment;
        int iDeflate;
        okio.Buffer buffer = this.sink.buffer();
        while (true) {
            segmentWritableSegment = buffer.writableSegment(1);
            if (z_renamed) {
                iDeflate = this.deflater.deflate(segmentWritableSegment.data, segmentWritableSegment.limit, 8192 - segmentWritableSegment.limit, 2);
            } else {
                iDeflate = this.deflater.deflate(segmentWritableSegment.data, segmentWritableSegment.limit, 8192 - segmentWritableSegment.limit);
            }
            if (iDeflate > 0) {
                segmentWritableSegment.limit += iDeflate;
                buffer.size += iDeflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment.pos == segmentWritableSegment.limit) {
            buffer.head = segmentWritableSegment.pop();
            okio.SegmentPool.recycle(segmentWritableSegment);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        deflate(true);
        this.sink.flush();
    }

    void finishDeflate() throws java.io.IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        java.lang.Throwable th = null;
        try {
            finishDeflate();
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

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }
}
