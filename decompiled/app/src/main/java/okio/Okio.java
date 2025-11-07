package okio;

/* loaded from: classes2.dex */
public final class Okio {
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(okio.Okio.class.getName());

    private Okio() {
    }

    public static okio.BufferedSource buffer(okio.Source source) {
        return new okio.RealBufferedSource(source);
    }

    public static okio.BufferedSink buffer(okio.Sink sink) {
        return new okio.RealBufferedSink(sink);
    }

    public static okio.Sink sink(java.io.OutputStream outputStream) {
        return sink(outputStream, new okio.Timeout());
    }

    private static okio.Sink sink(final java.io.OutputStream outputStream, final okio.Timeout timeout) {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("timeout == null");
        }
        return new okio.Sink() { // from class: okio.Okio.1
            @Override // okio.Sink
            public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                okio.Util.checkOffsetAndCount(buffer.size, 0L, j_renamed);
                while (j_renamed > 0) {
                    timeout.throwIfReached();
                    okio.Segment segment = buffer.head;
                    int iMin = (int) java.lang.Math.min(j_renamed, segment.limit - segment.pos);
                    outputStream.write(segment.data, segment.pos, iMin);
                    segment.pos += iMin;
                    long j2 = iMin;
                    j_renamed -= j2;
                    buffer.size -= j2;
                    if (segment.pos == segment.limit) {
                        buffer.head = segment.pop();
                        okio.SegmentPool.recycle(segment);
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws java.io.IOException {
                outputStream.flush();
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                outputStream.close();
            }

            @Override // okio.Sink
            public okio.Timeout timeout() {
                return timeout;
            }

            public java.lang.String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static okio.Sink sink(java.net.Socket socket) throws java.io.IOException {
        if (socket == null) {
            throw new java.lang.IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new java.io.IOException("socket's_renamed output stream == null");
        }
        okio.AsyncTimeout asyncTimeoutTimeout = timeout(socket);
        return asyncTimeoutTimeout.sink(sink(socket.getOutputStream(), asyncTimeoutTimeout));
    }

    public static okio.Source source(java.io.InputStream inputStream) {
        return source(inputStream, new okio.Timeout());
    }

    private static okio.Source source(final java.io.InputStream inputStream, final okio.Timeout timeout) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in_renamed == null");
        }
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("timeout == null");
        }
        return new okio.Source() { // from class: okio.Okio.2
            @Override // okio.Source
            public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                if (j_renamed < 0) {
                    throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
                }
                if (j_renamed == 0) {
                    return 0L;
                }
                try {
                    timeout.throwIfReached();
                    okio.Segment segmentWritableSegment = buffer.writableSegment(1);
                    int i_renamed = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j_renamed, 8192 - segmentWritableSegment.limit));
                    if (i_renamed == -1) {
                        return -1L;
                    }
                    segmentWritableSegment.limit += i_renamed;
                    long j2 = i_renamed;
                    buffer.size += j2;
                    return j2;
                } catch (java.lang.AssertionError e_renamed) {
                    if (okio.Okio.isAndroidGetsocknameError(e_renamed)) {
                        throw new java.io.IOException(e_renamed);
                    }
                    throw e_renamed;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                inputStream.close();
            }

            @Override // okio.Source
            public okio.Timeout timeout() {
                return timeout;
            }

            public java.lang.String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static okio.Source source(java.io.File file) throws java.io.FileNotFoundException {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("file == null");
        }
        return source(new java.io.FileInputStream(file));
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public static okio.Source source(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        if (path == null) {
            throw new java.lang.IllegalArgumentException("path == null");
        }
        return source(java.nio.file.Files.newInputStream(path, openOptionArr));
    }

    public static okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("file == null");
        }
        return sink(new java.io.FileOutputStream(file));
    }

    public static okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("file == null");
        }
        return sink(new java.io.FileOutputStream(file, true));
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public static okio.Sink sink(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        if (path == null) {
            throw new java.lang.IllegalArgumentException("path == null");
        }
        return sink(java.nio.file.Files.newOutputStream(path, openOptionArr));
    }

    public static okio.Sink blackhole() {
        return new okio.Sink() { // from class: okio.Okio.3
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws java.io.IOException {
            }

            @Override // okio.Sink
            public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                buffer.skip(j_renamed);
            }

            @Override // okio.Sink
            public okio.Timeout timeout() {
                return okio.Timeout.NONE;
            }
        };
    }

    public static okio.Source source(java.net.Socket socket) throws java.io.IOException {
        if (socket == null) {
            throw new java.lang.IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new java.io.IOException("socket's_renamed input stream == null");
        }
        okio.AsyncTimeout asyncTimeoutTimeout = timeout(socket);
        return asyncTimeoutTimeout.source(source(socket.getInputStream(), asyncTimeoutTimeout));
    }

    private static okio.AsyncTimeout timeout(final java.net.Socket socket) {
        return new okio.AsyncTimeout() { // from class: okio.Okio.4
            @Override // okio.AsyncTimeout
            protected java.io.IOException newTimeoutException(@javax.annotation.Nullable java.io.IOException iOException) {
                java.net.SocketTimeoutException socketTimeoutException = new java.net.SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // okio.AsyncTimeout
            protected void timedOut() throws java.io.IOException {
                try {
                    socket.close();
                } catch (java.lang.AssertionError e_renamed) {
                    if (okio.Okio.isAndroidGetsocknameError(e_renamed)) {
                        okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + socket, (java.lang.Throwable) e_renamed);
                        return;
                    }
                    throw e_renamed;
                } catch (java.lang.Exception e2) {
                    okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + socket, (java.lang.Throwable) e2);
                }
            }
        };
    }

    static boolean isAndroidGetsocknameError(java.lang.AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
