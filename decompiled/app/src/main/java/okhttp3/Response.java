package okhttp3;

/* loaded from: classes2.dex */
public final class Response implements java.io.Closeable {

    @javax.annotation.Nullable
    final okhttp3.ResponseBody body;

    @javax.annotation.Nullable
    private volatile okhttp3.CacheControl cacheControl;

    @javax.annotation.Nullable
    final okhttp3.Response cacheResponse;
    final int code;

    @javax.annotation.Nullable
    final okhttp3.Handshake handshake;
    final okhttp3.Headers headers;
    final java.lang.String message;

    @javax.annotation.Nullable
    final okhttp3.Response networkResponse;

    @javax.annotation.Nullable
    final okhttp3.Response priorResponse;
    final okhttp3.Protocol protocol;
    final long receivedResponseAtMillis;
    final okhttp3.Request request;
    final long sentRequestAtMillis;

    Response(okhttp3.Response.Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
    }

    public okhttp3.Request request() {
        return this.request;
    }

    public okhttp3.Protocol protocol() {
        return this.protocol;
    }

    public int code() {
        return this.code;
    }

    public boolean isSuccessful() {
        int i_renamed = this.code;
        return i_renamed >= 200 && i_renamed < 300;
    }

    public java.lang.String message() {
        return this.message;
    }

    @javax.annotation.Nullable
    public okhttp3.Handshake handshake() {
        return this.handshake;
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.headers.values(str);
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str) {
        return header(str, null);
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
        java.lang.String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public okhttp3.Headers headers() {
        return this.headers;
    }

    public okhttp3.ResponseBody peekBody(long j_renamed) throws java.io.IOException {
        okio.BufferedSource bufferedSourceSource = this.body.source();
        bufferedSourceSource.request(j_renamed);
        okio.Buffer bufferClone = bufferedSourceSource.buffer().clone();
        if (bufferClone.size() > j_renamed) {
            okio.Buffer buffer = new okio.Buffer();
            buffer.write(bufferClone, j_renamed);
            bufferClone.clear();
            bufferClone = buffer;
        }
        return okhttp3.ResponseBody.create(this.body.contentType(), bufferClone.size(), bufferClone);
    }

    @javax.annotation.Nullable
    public okhttp3.ResponseBody body() {
        return this.body;
    }

    public okhttp3.Response.Builder newBuilder() {
        return new okhttp3.Response.Builder(this);
    }

    public boolean isRedirect() {
        int i_renamed = this.code;
        if (i_renamed == 307 || i_renamed == 308) {
            return true;
        }
        switch (i_renamed) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    @javax.annotation.Nullable
    public okhttp3.Response networkResponse() {
        return this.networkResponse;
    }

    @javax.annotation.Nullable
    public okhttp3.Response cacheResponse() {
        return this.cacheResponse;
    }

    @javax.annotation.Nullable
    public okhttp3.Response priorResponse() {
        return this.priorResponse;
    }

    public java.util.List<okhttp3.Challenge> challenges() {
        java.lang.String str;
        int i_renamed = this.code;
        if (i_renamed == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i_renamed != 407) {
                return java.util.Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    public okhttp3.CacheControl cacheControl() {
        okhttp3.CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        okhttp3.CacheControl cacheControl2 = okhttp3.CacheControl.parse(this.headers);
        this.cacheControl = cacheControl2;
        return cacheControl2;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        okhttp3.ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new java.lang.IllegalStateException("response is_renamed not eligible for a_renamed body and must not be_renamed closed");
        }
        responseBody.close();
    }

    public java.lang.String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public static class Builder {

        @javax.annotation.Nullable
        okhttp3.ResponseBody body;

        @javax.annotation.Nullable
        okhttp3.Response cacheResponse;
        int code;

        @javax.annotation.Nullable
        okhttp3.Handshake handshake;
        okhttp3.Headers.Builder headers;
        java.lang.String message;

        @javax.annotation.Nullable
        okhttp3.Response networkResponse;

        @javax.annotation.Nullable
        okhttp3.Response priorResponse;

        @javax.annotation.Nullable
        okhttp3.Protocol protocol;
        long receivedResponseAtMillis;

        @javax.annotation.Nullable
        okhttp3.Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new okhttp3.Headers.Builder();
        }

        Builder(okhttp3.Response response) {
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }

        public okhttp3.Response.Builder request(okhttp3.Request request) {
            this.request = request;
            return this;
        }

        public okhttp3.Response.Builder protocol(okhttp3.Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public okhttp3.Response.Builder code(int i_renamed) {
            this.code = i_renamed;
            return this;
        }

        public okhttp3.Response.Builder message(java.lang.String str) {
            this.message = str;
            return this;
        }

        public okhttp3.Response.Builder handshake(@javax.annotation.Nullable okhttp3.Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public okhttp3.Response.Builder header(java.lang.String str, java.lang.String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public okhttp3.Response.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public okhttp3.Response.Builder removeHeader(java.lang.String str) {
            this.headers.removeAll(str);
            return this;
        }

        public okhttp3.Response.Builder headers(okhttp3.Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public okhttp3.Response.Builder body(@javax.annotation.Nullable okhttp3.ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public okhttp3.Response.Builder networkResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public okhttp3.Response.Builder cacheResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(java.lang.String str, okhttp3.Response response) {
            if (response.body != null) {
                throw new java.lang.IllegalArgumentException(str + ".body != null");
            }
            if (response.networkResponse != null) {
                throw new java.lang.IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.cacheResponse != null) {
                throw new java.lang.IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.priorResponse == null) {
                return;
            }
            throw new java.lang.IllegalArgumentException(str + ".priorResponse != null");
        }

        public okhttp3.Response.Builder priorResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(okhttp3.Response response) {
            if (response.body != null) {
                throw new java.lang.IllegalArgumentException("priorResponse.body != null");
            }
        }

        public okhttp3.Response.Builder sentRequestAtMillis(long j_renamed) {
            this.sentRequestAtMillis = j_renamed;
            return this;
        }

        public okhttp3.Response.Builder receivedResponseAtMillis(long j_renamed) {
            this.receivedResponseAtMillis = j_renamed;
            return this;
        }

        public okhttp3.Response build() {
            if (this.request == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.protocol == null) {
                throw new java.lang.IllegalStateException("protocol == null");
            }
            if (this.code < 0) {
                throw new java.lang.IllegalStateException("code < 0: " + this.code);
            }
            if (this.message == null) {
                throw new java.lang.IllegalStateException("message == null");
            }
            return new okhttp3.Response(this);
        }
    }
}
