package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class CallServerInterceptor implements okhttp3.Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z_renamed) {
        this.forWebSocket = z_renamed;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Response responseBuild;
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (okhttp3.internal.http.RealInterceptorChain) chain;
        okhttp3.internal.http.HttpCodec httpCodecHttpStream = realInterceptorChain.httpStream();
        okhttp3.internal.connection.StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        okhttp3.internal.connection.RealConnection realConnection = (okhttp3.internal.connection.RealConnection) realInterceptorChain.connection();
        okhttp3.Request request = realInterceptorChain.request();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        realInterceptorChain.eventListener().requestHeadersStart(realInterceptorChain.call());
        httpCodecHttpStream.writeRequestHeaders(request);
        realInterceptorChain.eventListener().requestHeadersEnd(realInterceptorChain.call(), request);
        okhttp3.Response.Builder responseHeaders = null;
        if (okhttp3.internal.http.HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                httpCodecHttpStream.flushRequest();
                realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
                responseHeaders = httpCodecHttpStream.readResponseHeaders(true);
            }
            if (responseHeaders == null) {
                realInterceptorChain.eventListener().requestBodyStart(realInterceptorChain.call());
                okhttp3.internal.http.CallServerInterceptor.CountingSink countingSink = new okhttp3.internal.http.CallServerInterceptor.CountingSink(httpCodecHttpStream.createRequestBody(request, request.body().contentLength()));
                okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(countingSink);
                request.body().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                realInterceptorChain.eventListener().requestBodyEnd(realInterceptorChain.call(), countingSink.successfulCount);
            } else if (!realConnection.isMultiplexed()) {
                streamAllocation.noNewStreams();
            }
        }
        httpCodecHttpStream.finishRequest();
        if (responseHeaders == null) {
            realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
            responseHeaders = httpCodecHttpStream.readResponseHeaders(false);
        }
        okhttp3.Response responseBuild2 = responseHeaders.request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        int iCode = responseBuild2.code();
        if (iCode == 100) {
            responseBuild2 = httpCodecHttpStream.readResponseHeaders(false).request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
            iCode = responseBuild2.code();
        }
        realInterceptorChain.eventListener().responseHeadersEnd(realInterceptorChain.call(), responseBuild2);
        if (this.forWebSocket && iCode == 101) {
            responseBuild = responseBuild2.newBuilder().body(okhttp3.internal.Util.EMPTY_RESPONSE).build();
        } else {
            responseBuild = responseBuild2.newBuilder().body(httpCodecHttpStream.openResponseBody(responseBuild2)).build();
        }
        if ("close".equalsIgnoreCase(responseBuild.request().header("Connection")) || "close".equalsIgnoreCase(responseBuild.header("Connection"))) {
            streamAllocation.noNewStreams();
        }
        if ((iCode != 204 && iCode != 205) || responseBuild.body().contentLength() <= 0) {
            return responseBuild;
        }
        throw new java.net.ProtocolException("HTTP " + iCode + " had non-zero Content-Length: " + responseBuild.body().contentLength());
    }

    static final class CountingSink extends okio.ForwardingSink {
        long successfulCount;

        CountingSink(okio.Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
            super.write(buffer, j_renamed);
            this.successfulCount += j_renamed;
        }
    }
}
