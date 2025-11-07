package okio;

/* loaded from: classes2.dex */
public final class GzipSource implements okio.Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final java.util.zip.Inflater inflater;
    private final okio.InflaterSource inflaterSource;
    private final okio.BufferedSource source;
    private int section = 0;
    private final java.util.zip.CRC32 crc = new java.util.zip.CRC32();

    public GzipSource(okio.Source source) {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        this.inflater = new java.util.zip.Inflater(true);
        this.source = okio.Okio.buffer(source);
        this.inflaterSource = new okio.InflaterSource(this.source, this.inflater);
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j_renamed) throws java.util.zip.DataFormatException, java.io.IOException {
        if (j_renamed < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
        }
        if (j_renamed == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long j2 = buffer.size;
            long j3 = this.inflaterSource.read(buffer, j_renamed);
            if (j3 != -1) {
                updateCrc(buffer, j2, j3);
                return j3;
            }
            this.section = 2;
        }
        if (this.section == 2) {
            consumeTrailer();
            this.section = 3;
            if (!this.source.exhausted()) {
                throw new java.io.IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void consumeHeader() throws java.io.IOException {
        this.source.require(10L);
        byte b2 = this.source.buffer().getByte(3L);
        boolean z_renamed = ((b2 >> 1) & 1) == 1;
        if (z_renamed) {
            updateCrc(this.source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z_renamed) {
                updateCrc(this.source.buffer(), 0L, 2L);
            }
            long shortLe = this.source.buffer().readShortLe();
            this.source.require(shortLe);
            if (z_renamed) {
                updateCrc(this.source.buffer(), 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new java.io.EOFException();
            }
            if (z_renamed) {
                updateCrc(this.source.buffer(), 0L, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((b2 >> FCOMMENT) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new java.io.EOFException();
            }
            if (z_renamed) {
                updateCrc(this.source.buffer(), 0L, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z_renamed) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private void consumeTrailer() throws java.io.IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.inflaterSource.close();
    }

    private void updateCrc(okio.Buffer buffer, long j_renamed, long j2) {
        okio.Segment segment = buffer.head;
        while (j_renamed >= segment.limit - segment.pos) {
            j_renamed -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (j2 > 0) {
            int iMin = (int) java.lang.Math.min(segment.limit - r6, j2);
            this.crc.update(segment.data, (int) (segment.pos + j_renamed), iMin);
            j2 -= iMin;
            segment = segment.next;
            j_renamed = 0;
        }
    }

    private void checkEqual(java.lang.String str, int i_renamed, int i2) throws java.io.IOException {
        if (i2 != i_renamed) {
            throw new java.io.IOException(java.lang.String.format("%s_renamed: actual 0x%08x != expected 0x%08x", str, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i_renamed)));
        }
    }
}
