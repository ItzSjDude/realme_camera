package okhttp3.internal.cache;

/* loaded from: classes2.dex */
public final class CacheInterceptor implements okhttp3.Interceptor {
    final okhttp3.internal.cache.InternalCache cache;

    public CacheInterceptor(okhttp3.internal.cache.InternalCache internalCache) {
        this.cache = internalCache;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.internal.cache.InternalCache internalCache = this.cache;
        okhttp3.Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        okhttp3.internal.cache.CacheStrategy cacheStrategy = new okhttp3.internal.cache.CacheStrategy.Factory(java.lang.System.currentTimeMillis(), chain.request(), response).get();
        okhttp3.Request request = cacheStrategy.networkRequest;
        okhttp3.Response response2 = cacheStrategy.cacheResponse;
        okhttp3.internal.cache.InternalCache internalCache2 = this.cache;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            okhttp3.internal.Util.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new okhttp3.Response.Builder().request(chain.request()).protocol(okhttp3.Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(stripBody(response2)).build();
        }
        try {
            okhttp3.Response responseProceed = chain.proceed(request);
            if (responseProceed == null && response != null) {
            }
            if (response2 != null) {
                if (responseProceed.code() == 304) {
                    okhttp3.Response responseBuild = response2.newBuilder().headers(combine(response2.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(stripBody(response2)).networkResponse(stripBody(responseProceed)).build();
                    responseProceed.body().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(response2, responseBuild);
                    return responseBuild;
                }
                okhttp3.internal.Util.closeQuietly(response2.body());
            }
            okhttp3.Response responseBuild2 = responseProceed.newBuilder().cacheResponse(stripBody(response2)).networkResponse(stripBody(responseProceed)).build();
            if (this.cache != null) {
                if (okhttp3.internal.http.HttpHeaders.hasBody(responseBuild2) && okhttp3.internal.cache.CacheStrategy.isCacheable(responseBuild2, request)) {
                    return cacheWritingResponse(this.cache.put(responseBuild2), responseBuild2);
                }
                if (okhttp3.internal.http.HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.cache.remove(request);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
            return responseBuild2;
        } finally {
            if (response != null) {
                okhttp3.internal.Util.closeQuietly(response.body());
            }
        }
    }

    private static okhttp3.Response stripBody(okhttp3.Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private okhttp3.Response cacheWritingResponse(final okhttp3.internal.cache.CacheRequest cacheRequest, okhttp3.Response response) throws java.io.IOException {
        okio.Sink sinkBody;
        if (cacheRequest == null || (sinkBody = cacheRequest.body()) == null) {
            return response;
        }
        final okio.BufferedSource bufferedSourceSource = response.body().source();
        final okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(sinkBody);
        return response.newBuilder().body(new okhttp3.internal.http.RealResponseBody(response.header("Content-Type"), response.body().contentLength(), okio.Okio.buffer(new okio.Source() { // from class: okhttp3.internal.cache.CacheInterceptor.1
            boolean cacheRequestClosed;

            @Override // okio.Source
            public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                try {
                    long j2 = bufferedSourceSource.read(buffer, j_renamed);
                    if (j2 == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            bufferedSinkBuffer.close();
                        }
                        return -1L;
                    }
                    buffer.copyTo(bufferedSinkBuffer.buffer(), buffer.size() - j2, j2);
                    bufferedSinkBuffer.emitCompleteSegments();
                    return j2;
                } catch (java.io.IOException e_renamed) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e_renamed;
                }
            }

            @Override // okio.Source
            public okio.Timeout timeout() {
                return bufferedSourceSource.timeout();
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                if (!this.cacheRequestClosed && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                bufferedSourceSource.close();
            }
        }))).build();
    }

    private static okhttp3.Headers combine(okhttp3.Headers headers, okhttp3.Headers headers2) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String strName = headers.name(i_renamed);
            java.lang.String strValue = headers.value(i_renamed);
            if ((!"Warning".equalsIgnoreCase(strName) || !strValue.startsWith("1")) && (isContentSpecificHeader(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                okhttp3.internal.Internal.instance.addLenient(builder, strName, strValue);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            java.lang.String strName2 = headers2.name(i2);
            if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                okhttp3.internal.Internal.instance.addLenient(builder, strName2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    static boolean isEndToEnd(java.lang.String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE_renamed".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    static boolean isContentSpecificHeader(java.lang.String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
