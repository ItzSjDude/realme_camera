package okhttp3.internal.cache;

/* loaded from: classes2.dex */
public final class CacheStrategy {

    @javax.annotation.Nullable
    public final okhttp3.Response cacheResponse;

    @javax.annotation.Nullable
    public final okhttp3.Request networkRequest;

    CacheStrategy(okhttp3.Request request, okhttp3.Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCacheable(okhttp3.Response r3, okhttp3.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L5a
            okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L5a
            okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.isCacheable(okhttp3.Response, okhttp3.Request):boolean");
    }

    public static class Factory {
        private int ageSeconds;
        final okhttp3.Response cacheResponse;
        private java.lang.String etag;
        private java.util.Date expires;
        private java.util.Date lastModified;
        private java.lang.String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final okhttp3.Request request;
        private long sentRequestMillis;
        private java.util.Date servedDate;
        private java.lang.String servedDateString;

        public Factory(long j_renamed, okhttp3.Request request, okhttp3.Response response) {
            this.ageSeconds = -1;
            this.nowMillis = j_renamed;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                okhttp3.Headers headers = response.headers();
                int size = headers.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    java.lang.String strName = headers.name(i_renamed);
                    java.lang.String strValue = headers.value(i_renamed);
                    if ("Date".equalsIgnoreCase(strName)) {
                        this.servedDate = okhttp3.internal.http.HttpDate.parse(strValue);
                        this.servedDateString = strValue;
                    } else if ("Expires".equalsIgnoreCase(strName)) {
                        this.expires = okhttp3.internal.http.HttpDate.parse(strValue);
                    } else if ("Last-Modified".equalsIgnoreCase(strName)) {
                        this.lastModified = okhttp3.internal.http.HttpDate.parse(strValue);
                        this.lastModifiedString = strValue;
                    } else if ("ETag".equalsIgnoreCase(strName)) {
                        this.etag = strValue;
                    } else if ("Age".equalsIgnoreCase(strName)) {
                        this.ageSeconds = okhttp3.internal.http.HttpHeaders.parseSeconds(strValue, -1);
                    }
                }
            }
        }

        public okhttp3.internal.cache.CacheStrategy get() {
            okhttp3.internal.cache.CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) ? candidate : new okhttp3.internal.cache.CacheStrategy(null, null);
        }

        private okhttp3.internal.cache.CacheStrategy getCandidate() {
            if (this.cacheResponse == null) {
                return new okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            if (!okhttp3.internal.cache.CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            okhttp3.CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            okhttp3.CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                jComputeFreshnessLifetime = java.lang.Math.min(jComputeFreshnessLifetime, java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j_renamed = millis2 + jCacheResponseAge;
                if (j_renamed < millis + jComputeFreshnessLifetime) {
                    okhttp3.Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j_renamed >= jComputeFreshnessLifetime) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is_renamed stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new okhttp3.internal.cache.CacheStrategy(null, builderNewBuilder.build());
                }
            }
            java.lang.String str = this.etag;
            java.lang.String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.lastModified != null) {
                str = this.lastModifiedString;
            } else if (this.servedDate != null) {
                str = this.servedDateString;
            } else {
                return new okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            okhttp3.Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            okhttp3.internal.Internal.instance.addLenient(builderNewBuilder2, str2, str);
            return new okhttp3.internal.cache.CacheStrategy(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private long computeFreshnessLifetime() {
            long time;
            long time2;
            if (this.cacheResponse.cacheControl().maxAgeSeconds() != -1) {
                return java.util.concurrent.TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.expires != null) {
                java.util.Date date = this.servedDate;
                if (date != null) {
                    time2 = date.getTime();
                } else {
                    time2 = this.receivedResponseMillis;
                }
                long time3 = this.expires.getTime() - time2;
                if (time3 > 0) {
                    return time3;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            }
            java.util.Date date2 = this.servedDate;
            if (date2 != null) {
                time = date2.getTime();
            } else {
                time = this.sentRequestMillis;
            }
            long time4 = time - this.lastModified.getTime();
            if (time4 > 0) {
                return time4 / 10;
            }
            return 0L;
        }

        private long cacheResponseAge() {
            java.util.Date date = this.servedDate;
            long jMax = date != null ? java.lang.Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            if (this.ageSeconds != -1) {
                jMax = java.lang.Math.max(jMax, java.util.concurrent.TimeUnit.SECONDS.toMillis(this.ageSeconds));
            }
            long j_renamed = this.receivedResponseMillis;
            return jMax + (j_renamed - this.sentRequestMillis) + (this.nowMillis - j_renamed);
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        private static boolean hasConditions(okhttp3.Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }
}
