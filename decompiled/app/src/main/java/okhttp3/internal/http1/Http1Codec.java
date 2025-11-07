package okhttp3.internal.http1;

/* loaded from: classes2.dex */
public final class Http1Codec implements okhttp3.internal.http.HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final okhttp3.OkHttpClient client;
    final okio.BufferedSink sink;
    final okio.BufferedSource source;
    final okhttp3.internal.connection.StreamAllocation streamAllocation;
    int state = 0;
    private long headerLimit = 262144;

    public Http1Codec(okhttp3.OkHttpClient okHttpClient, okhttp3.internal.connection.StreamAllocation streamAllocation, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okio.Sink createRequestBody(okhttp3.Request request, long j_renamed) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j_renamed != -1) {
            return newFixedLengthSink(j_renamed);
        }
        throw new java.lang.IllegalStateException("Cannot stream a_renamed request body without chunked encoding or a_renamed known content length!");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() throws java.io.IOException {
        okhttp3.internal.connection.RealConnection realConnectionConnection = this.streamAllocation.connection();
        if (realConnectionConnection != null) {
            realConnectionConnection.cancel();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException {
        writeRequest(request.headers(), okhttp3.internal.http.RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okhttp3.ResponseBody openResponseBody(okhttp3.Response response) throws java.io.IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        java.lang.String strHeader = response.header("Content-Type");
        if (!okhttp3.internal.http.HttpHeaders.hasBody(response)) {
            return new okhttp3.internal.http.RealResponseBody(strHeader, 0L, okio.Okio.buffer(newFixedLengthSource(0L)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new okhttp3.internal.http.RealResponseBody(strHeader, -1L, okio.Okio.buffer(newChunkedSource(response.request().url())));
        }
        long jContentLength = okhttp3.internal.http.HttpHeaders.contentLength(response);
        if (jContentLength != -1) {
            return new okhttp3.internal.http.RealResponseBody(strHeader, jContentLength, okio.Okio.buffer(newFixedLengthSource(jContentLength)));
        }
        return new okhttp3.internal.http.RealResponseBody(strHeader, -1L, okio.Okio.buffer(newUnknownLengthSource()));
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws java.io.IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws java.io.IOException {
        this.sink.flush();
    }

    public void writeRequest(okhttp3.Headers headers, java.lang.String str) throws java.io.IOException {
        if (this.state != 0) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(str).writeUtf8("\r_renamed\n_renamed");
        int size = headers.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.sink.writeUtf8(headers.name(i_renamed)).writeUtf8(": ").writeUtf8(headers.value(i_renamed)).writeUtf8("\r_renamed\n_renamed");
        }
        this.sink.writeUtf8("\r_renamed\n_renamed");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okhttp3.Response.Builder readResponseHeaders(boolean z_renamed) throws java.lang.NumberFormatException, java.io.IOException {
        int i_renamed = this.state;
        if (i_renamed != 1 && i_renamed != 3) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        try {
            okhttp3.internal.http.StatusLine statusLine = okhttp3.internal.http.StatusLine.parse(readHeaderLine());
            okhttp3.Response.Builder builderHeaders = new okhttp3.Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(readHeaders());
            if (z_renamed && statusLine.code == 100) {
                return null;
            }
            if (statusLine.code == 100) {
                this.state = 3;
                return builderHeaders;
            }
            this.state = 4;
            return builderHeaders;
        } catch (java.io.EOFException e_renamed) {
            java.io.IOException iOException = new java.io.IOException("unexpected end of_renamed stream on_renamed " + this.streamAllocation);
            iOException.initCause(e_renamed);
            throw iOException;
        }
    }

    private java.lang.String readHeaderLine() throws java.io.IOException {
        java.lang.String utf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= utf8LineStrict.length();
        return utf8LineStrict;
    }

    public okhttp3.Headers readHeaders() throws java.io.IOException {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        while (true) {
            java.lang.String headerLine = readHeaderLine();
            if (headerLine.length() != 0) {
                okhttp3.internal.Internal.instance.addLenient(builder, headerLine);
            } else {
                return builder.build();
            }
        }
    }

    public okio.Sink newChunkedSink() {
        if (this.state != 1) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new okhttp3.internal.http1.Http1Codec.ChunkedSink();
    }

    public okio.Sink newFixedLengthSink(long j_renamed) {
        if (this.state != 1) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new okhttp3.internal.http1.Http1Codec.FixedLengthSink(j_renamed);
    }

    public okio.Source newFixedLengthSource(long j_renamed) throws java.io.IOException {
        if (this.state != 4) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new okhttp3.internal.http1.Http1Codec.FixedLengthSource(j_renamed);
    }

    public okio.Source newChunkedSource(okhttp3.HttpUrl httpUrl) throws java.io.IOException {
        if (this.state != 4) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new okhttp3.internal.http1.Http1Codec.ChunkedSource(httpUrl);
    }

    public okio.Source newUnknownLengthSource() throws java.io.IOException {
        if (this.state != 4) {
            throw new java.lang.IllegalStateException("state: " + this.state);
        }
        okhttp3.internal.connection.StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation == null) {
            throw new java.lang.IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        streamAllocation.noNewStreams();
        return new okhttp3.internal.http1.Http1Codec.UnknownLengthSource();
    }

    void detachTimeout(okio.ForwardingTimeout forwardingTimeout) {
        okio.Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(okio.Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }

    private final class FixedLengthSink implements okio.Sink {
        private long bytesRemaining;
        private boolean closed;
        private final okio.ForwardingTimeout timeout;

        FixedLengthSink(long j_renamed) {
            this.timeout = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1Codec.this.sink.timeout());
            this.bytesRemaining = j_renamed;
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (this.closed) {
                throw new java.lang.IllegalStateException("closed");
            }
            okhttp3.internal.Util.checkOffsetAndCount(buffer.size(), 0L, j_renamed);
            if (j_renamed > this.bytesRemaining) {
                throw new java.net.ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j_renamed);
            }
            okhttp3.internal.http1.Http1Codec.this.sink.write(buffer, j_renamed);
            this.bytesRemaining -= j_renamed;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            okhttp3.internal.http1.Http1Codec.this.sink.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new java.net.ProtocolException("unexpected end of_renamed stream");
            }
            okhttp3.internal.http1.Http1Codec.this.detachTimeout(this.timeout);
            okhttp3.internal.http1.Http1Codec.this.state = 3;
        }
    }

    private final class ChunkedSink implements okio.Sink {
        private boolean closed;
        private final okio.ForwardingTimeout timeout;

        ChunkedSink() {
            this.timeout = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1Codec.this.sink.timeout());
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (this.closed) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (j_renamed == 0) {
                return;
            }
            okhttp3.internal.http1.Http1Codec.this.sink.writeHexadecimalUnsignedLong(j_renamed);
            okhttp3.internal.http1.Http1Codec.this.sink.writeUtf8("\r_renamed\n_renamed");
            okhttp3.internal.http1.Http1Codec.this.sink.write(buffer, j_renamed);
            okhttp3.internal.http1.Http1Codec.this.sink.writeUtf8("\r_renamed\n_renamed");
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            okhttp3.internal.http1.Http1Codec.this.sink.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            okhttp3.internal.http1.Http1Codec.this.sink.writeUtf8("0\r_renamed\n_renamed\r_renamed\n_renamed");
            okhttp3.internal.http1.Http1Codec.this.detachTimeout(this.timeout);
            okhttp3.internal.http1.Http1Codec.this.state = 3;
        }
    }

    private abstract class AbstractSource implements okio.Source {
        protected long bytesRead;
        protected boolean closed;
        protected final okio.ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1Codec.this.source.timeout());
            this.bytesRead = 0L;
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            try {
                long j2 = okhttp3.internal.http1.Http1Codec.this.source.read(buffer, j_renamed);
                if (j2 > 0) {
                    this.bytesRead += j2;
                }
                return j2;
            } catch (java.io.IOException e_renamed) {
                endOfInput(false, e_renamed);
                throw e_renamed;
            }
        }

        protected final void endOfInput(boolean z_renamed, java.io.IOException iOException) throws java.io.IOException {
            if (okhttp3.internal.http1.Http1Codec.this.state == 6) {
                return;
            }
            if (okhttp3.internal.http1.Http1Codec.this.state != 5) {
                throw new java.lang.IllegalStateException("state: " + okhttp3.internal.http1.Http1Codec.this.state);
            }
            okhttp3.internal.http1.Http1Codec.this.detachTimeout(this.timeout);
            okhttp3.internal.http1.Http1Codec http1Codec = okhttp3.internal.http1.Http1Codec.this;
            http1Codec.state = 6;
            if (http1Codec.streamAllocation != null) {
                okhttp3.internal.http1.Http1Codec.this.streamAllocation.streamFinished(!z_renamed, okhttp3.internal.http1.Http1Codec.this, this.bytesRead, iOException);
            }
        }
    }

    private class FixedLengthSource extends okhttp3.internal.http1.Http1Codec.AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j_renamed) throws java.io.IOException {
            super();
            this.bytesRemaining = j_renamed;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
            }
            if (this.closed) {
                throw new java.lang.IllegalStateException("closed");
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(buffer, java.lang.Math.min(j2, j_renamed));
            if (j3 == -1) {
                java.net.ProtocolException protocolException = new java.net.ProtocolException("unexpected end of_renamed stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
            this.bytesRemaining -= j3;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
            return j3;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }

    private class ChunkedSource extends okhttp3.internal.http1.Http1Codec.AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final okhttp3.HttpUrl url;

        ChunkedSource(okhttp3.HttpUrl httpUrl) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
            }
            if (this.closed) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j2 = this.bytesRemainingInChunk;
            if (j2 == 0 || j2 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j3 = super.read(buffer, java.lang.Math.min(j_renamed, this.bytesRemainingInChunk));
            if (j3 == -1) {
                java.net.ProtocolException protocolException = new java.net.ProtocolException("unexpected end of_renamed stream");
                endOfInput(false, protocolException);
                throw protocolException;
            }
            this.bytesRemainingInChunk -= j3;
            return j3;
        }

        private void readChunkSize() throws java.io.IOException {
            if (this.bytesRemainingInChunk != -1) {
                okhttp3.internal.http1.Http1Codec.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = okhttp3.internal.http1.Http1Codec.this.source.readHexadecimalUnsignedLong();
                java.lang.String strTrim = okhttp3.internal.http1.Http1Codec.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new java.net.ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + strTrim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    okhttp3.internal.http.HttpHeaders.receiveHeaders(okhttp3.internal.http1.Http1Codec.this.client.cookieJar(), this.url, okhttp3.internal.http1.Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new java.net.ProtocolException(e_renamed.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }

    private class UnknownLengthSource extends okhttp3.internal.http1.Http1Codec.AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j_renamed);
            }
            if (this.closed) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j2 = super.read(buffer, j_renamed);
            if (j2 != -1) {
                return j2;
            }
            this.inputExhausted = true;
            endOfInput(true, null);
            return -1L;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }
}
