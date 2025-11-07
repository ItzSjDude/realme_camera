package okhttp3.internal.http2;

/* loaded from: classes2.dex */
public final class Http2Codec implements okhttp3.internal.http.HttpCodec {
    private final okhttp3.Interceptor.Chain chain;
    private final okhttp3.internal.http2.Http2Connection connection;
    private final okhttp3.Protocol protocol;
    private okhttp3.internal.http2.Http2Stream stream;
    final okhttp3.internal.connection.StreamAllocation streamAllocation;
    private static final java.lang.String CONNECTION = "connection";
    private static final java.lang.String HOST = "host";
    private static final java.lang.String KEEP_ALIVE = "keep-alive";
    private static final java.lang.String PROXY_CONNECTION = "proxy-connection";
    private static final java.lang.String TE_renamed = "te";
    private static final java.lang.String TRANSFER_ENCODING = "transfer-encoding";
    private static final java.lang.String ENCODING = "encoding";
    private static final java.lang.String UPGRADE = "upgrade";
    private static final java.util.List<java.lang.String> HTTP_2_SKIPPED_REQUEST_HEADERS = okhttp3.internal.Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE_renamed, TRANSFER_ENCODING, ENCODING, UPGRADE, okhttp3.internal.http2.Header.TARGET_METHOD_UTF8, okhttp3.internal.http2.Header.TARGET_PATH_UTF8, okhttp3.internal.http2.Header.TARGET_SCHEME_UTF8, okhttp3.internal.http2.Header.TARGET_AUTHORITY_UTF8);
    private static final java.util.List<java.lang.String> HTTP_2_SKIPPED_RESPONSE_HEADERS = okhttp3.internal.Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE_renamed, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public Http2Codec(okhttp3.OkHttpClient okHttpClient, okhttp3.Interceptor.Chain chain, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.internal.http2.Http2Connection http2Connection) {
        okhttp3.Protocol protocol;
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
        if (okHttpClient.protocols().contains(okhttp3.Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = okhttp3.Protocol.HTTP_2;
        }
        this.protocol = protocol;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okio.Sink createRequestBody(okhttp3.Request request, long j_renamed) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException {
        if (this.stream != null) {
            return;
        }
        this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
        this.stream.readTimeout().timeout(this.chain.readTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws java.io.IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws java.io.IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okhttp3.Response.Builder readResponseHeaders(boolean z_renamed) throws java.lang.NumberFormatException, java.io.IOException {
        okhttp3.Response.Builder http2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (z_renamed && okhttp3.internal.Internal.instance.code(http2HeadersList) == 100) {
            return null;
        }
        return http2HeadersList;
    }

    public static java.util.List<okhttp3.internal.http2.Header> http2HeadersList(okhttp3.Request request) {
        okhttp3.Headers headers = request.headers();
        java.util.ArrayList arrayList = new java.util.ArrayList(headers.size() + 4);
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_METHOD, request.method()));
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_PATH, okhttp3.internal.http.RequestLine.requestPath(request.url())));
        java.lang.String strHeader = request.header("Host");
        if (strHeader != null) {
            arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_AUTHORITY, strHeader));
        }
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            okio.ByteString byteStringEncodeUtf8 = okio.ByteString.encodeUtf8(headers.name(i_renamed).toLowerCase(java.util.Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(byteStringEncodeUtf8.utf8())) {
                arrayList.add(new okhttp3.internal.http2.Header(byteStringEncodeUtf8, headers.value(i_renamed)));
            }
        }
        return arrayList;
    }

    public static okhttp3.Response.Builder readHttp2HeadersList(okhttp3.Headers headers, okhttp3.Protocol protocol) throws java.lang.NumberFormatException, java.io.IOException {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        okhttp3.internal.http.StatusLine statusLine = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String strName = headers.name(i_renamed);
            java.lang.String strValue = headers.value(i_renamed);
            if (strName.equals(okhttp3.internal.http2.Header.RESPONSE_STATUS_UTF8)) {
                statusLine = okhttp3.internal.http.StatusLine.parse("HTTP/1.1 " + strValue);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strName)) {
                okhttp3.internal.Internal.instance.addLenient(builder, strName, strValue);
            }
        }
        if (statusLine == null) {
            throw new java.net.ProtocolException("Expected ':status' header not present");
        }
        return new okhttp3.Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
    }

    @Override // okhttp3.internal.http.HttpCodec
    public okhttp3.ResponseBody openResponseBody(okhttp3.Response response) throws java.io.IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        return new okhttp3.internal.http.RealResponseBody(response.header("Content-Type"), okhttp3.internal.http.HttpHeaders.contentLength(response), okio.Okio.buffer(new okhttp3.internal.http2.Http2Codec.StreamFinishingSource(this.stream.getSource())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        okhttp3.internal.http2.Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(okhttp3.internal.http2.ErrorCode.CANCEL);
        }
    }

    class StreamFinishingSource extends okio.ForwardingSource {
        long bytesRead;
        boolean completed;

        StreamFinishingSource(okio.Source source) {
            super(source);
            this.completed = false;
            this.bytesRead = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            try {
                long j2 = delegate().read(buffer, j_renamed);
                if (j2 > 0) {
                    this.bytesRead += j2;
                }
                return j2;
            } catch (java.io.IOException e_renamed) {
                endOfInput(e_renamed);
                throw e_renamed;
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            endOfInput(null);
        }

        private void endOfInput(java.io.IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            okhttp3.internal.http2.Http2Codec.this.streamAllocation.streamFinished(false, okhttp3.internal.http2.Http2Codec.this, this.bytesRead, iOException);
        }
    }
}
