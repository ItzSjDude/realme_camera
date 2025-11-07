package okhttp3.internal.cache2;

/* loaded from: classes2.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final okio.ByteString PREFIX_CLEAN = okio.ByteString.encodeUtf8("OkHttp cache v1\n_renamed");
    static final okio.ByteString PREFIX_DIRTY = okio.ByteString.encodeUtf8("OkHttp DIRTY :(\n_renamed");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    java.io.RandomAccessFile file;
    private final okio.ByteString metadata;
    int sourceCount;
    okio.Source upstream;
    long upstreamPos;
    java.lang.Thread upstreamReader;
    final okio.Buffer upstreamBuffer = new okio.Buffer();
    final okio.Buffer buffer = new okio.Buffer();

    private Relay(java.io.RandomAccessFile randomAccessFile, okio.Source source, long j_renamed, okio.ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j_renamed;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static okhttp3.internal.cache2.Relay edit(java.io.File file, okio.Source source, okio.ByteString byteString, long j_renamed) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        okhttp3.internal.cache2.Relay relay = new okhttp3.internal.cache2.Relay(randomAccessFile, source, 0L, byteString, j_renamed);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static okhttp3.internal.cache2.Relay read(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        okhttp3.internal.cache2.FileOperator fileOperator = new okhttp3.internal.cache2.FileOperator(randomAccessFile.getChannel());
        okio.Buffer buffer = new okio.Buffer();
        fileOperator.read(0L, buffer, 32L);
        if (!buffer.readByteString(PREFIX_CLEAN.size()).equals(PREFIX_CLEAN)) {
            throw new java.io.IOException("unreadable cache file");
        }
        long j_renamed = buffer.readLong();
        long j2 = buffer.readLong();
        okio.Buffer buffer2 = new okio.Buffer();
        fileOperator.read(j_renamed + 32, buffer2, j2);
        return new okhttp3.internal.cache2.Relay(randomAccessFile, null, j_renamed, buffer2.readByteString(), 0L);
    }

    private void writeHeader(okio.ByteString byteString, long j_renamed, long j2) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        buffer.write(byteString);
        buffer.writeLong(j_renamed);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new java.lang.IllegalArgumentException();
        }
        new okhttp3.internal.cache2.FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
    }

    private void writeMetadata(long j_renamed) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        buffer.write(this.metadata);
        new okhttp3.internal.cache2.FileOperator(this.file.getChannel()).write(32 + j_renamed, buffer, this.metadata.size());
    }

    void commit(long j_renamed) throws java.io.IOException {
        writeMetadata(j_renamed);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j_renamed, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        okhttp3.internal.Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public okio.ByteString metadata() {
        return this.metadata;
    }

    public okio.Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new okhttp3.internal.cache2.Relay.RelaySource();
        }
    }

    class RelaySource implements okio.Source {
        private okhttp3.internal.cache2.FileOperator fileOperator;
        private long sourcePos;
        private final okio.Timeout timeout = new okio.Timeout();

        RelaySource() {
            this.fileOperator = new okhttp3.internal.cache2.FileOperator(okhttp3.internal.cache2.Relay.this.file.getChannel());
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            long j2;
            char c2;
            if (this.fileOperator == null) {
                throw new java.lang.IllegalStateException("closed");
            }
            synchronized (okhttp3.internal.cache2.Relay.this) {
                while (true) {
                    long j3 = this.sourcePos;
                    j2 = okhttp3.internal.cache2.Relay.this.upstreamPos;
                    if (j3 == j2) {
                        if (!okhttp3.internal.cache2.Relay.this.complete) {
                            if (okhttp3.internal.cache2.Relay.this.upstreamReader != null) {
                                this.timeout.waitUntilNotified(okhttp3.internal.cache2.Relay.this);
                            } else {
                                okhttp3.internal.cache2.Relay.this.upstreamReader = java.lang.Thread.currentThread();
                                c2 = 1;
                                break;
                            }
                        } else {
                            return -1L;
                        }
                    } else {
                        long size = j2 - okhttp3.internal.cache2.Relay.this.buffer.size();
                        if (this.sourcePos >= size) {
                            long jMin = java.lang.Math.min(j_renamed, j2 - this.sourcePos);
                            okhttp3.internal.cache2.Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin);
                            this.sourcePos += jMin;
                            return jMin;
                        }
                        c2 = 2;
                    }
                }
                if (c2 == 2) {
                    long jMin2 = java.lang.Math.min(j_renamed, j2 - this.sourcePos);
                    this.fileOperator.read(this.sourcePos + 32, buffer, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    long j4 = okhttp3.internal.cache2.Relay.this.upstream.read(okhttp3.internal.cache2.Relay.this.upstreamBuffer, okhttp3.internal.cache2.Relay.this.bufferMaxSize);
                    if (j4 == -1) {
                        okhttp3.internal.cache2.Relay.this.commit(j2);
                        synchronized (okhttp3.internal.cache2.Relay.this) {
                            okhttp3.internal.cache2.Relay.this.upstreamReader = null;
                            okhttp3.internal.cache2.Relay.this.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = java.lang.Math.min(j4, j_renamed);
                    okhttp3.internal.cache2.Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                    this.sourcePos += jMin3;
                    this.fileOperator.write(j2 + 32, okhttp3.internal.cache2.Relay.this.upstreamBuffer.clone(), j4);
                    synchronized (okhttp3.internal.cache2.Relay.this) {
                        okhttp3.internal.cache2.Relay.this.buffer.write(okhttp3.internal.cache2.Relay.this.upstreamBuffer, j4);
                        if (okhttp3.internal.cache2.Relay.this.buffer.size() > okhttp3.internal.cache2.Relay.this.bufferMaxSize) {
                            okhttp3.internal.cache2.Relay.this.buffer.skip(okhttp3.internal.cache2.Relay.this.buffer.size() - okhttp3.internal.cache2.Relay.this.bufferMaxSize);
                        }
                        okhttp3.internal.cache2.Relay.this.upstreamPos += j4;
                    }
                    synchronized (okhttp3.internal.cache2.Relay.this) {
                        okhttp3.internal.cache2.Relay.this.upstreamReader = null;
                        okhttp3.internal.cache2.Relay.this.notifyAll();
                    }
                    return jMin3;
                } catch (java.lang.Throwable th) {
                    synchronized (okhttp3.internal.cache2.Relay.this) {
                        okhttp3.internal.cache2.Relay.this.upstreamReader = null;
                        okhttp3.internal.cache2.Relay.this.notifyAll();
                        throw th;
                    }
                }
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.fileOperator == null) {
                return;
            }
            java.io.RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (okhttp3.internal.cache2.Relay.this) {
                okhttp3.internal.cache2.Relay relay = okhttp3.internal.cache2.Relay.this;
                relay.sourceCount--;
                if (okhttp3.internal.cache2.Relay.this.sourceCount == 0) {
                    java.io.RandomAccessFile randomAccessFile2 = okhttp3.internal.cache2.Relay.this.file;
                    okhttp3.internal.cache2.Relay.this.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                okhttp3.internal.Util.closeQuietly(randomAccessFile);
            }
        }
    }
}
