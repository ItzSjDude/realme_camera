package okhttp3;

/* loaded from: classes2.dex */
public final class Request {

    @javax.annotation.Nullable
    final okhttp3.RequestBody body;

    @javax.annotation.Nullable
    private volatile okhttp3.CacheControl cacheControl;
    final okhttp3.Headers headers;
    final java.lang.String method;
    final java.util.Map<java.lang.Class<?>, java.lang.Object> tags;
    final okhttp3.HttpUrl url;

    Request(okhttp3.Request.Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = okhttp3.internal.Util.immutableMap(builder.tags);
    }

    public okhttp3.HttpUrl url() {
        return this.url;
    }

    public java.lang.String method() {
        return this.method;
    }

    public okhttp3.Headers headers() {
        return this.headers;
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str) {
        return this.headers.get(str);
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.headers.values(str);
    }

    @javax.annotation.Nullable
    public okhttp3.RequestBody body() {
        return this.body;
    }

    @javax.annotation.Nullable
    public java.lang.Object tag() {
        return tag(java.lang.Object.class);
    }

    @javax.annotation.Nullable
    public <T_renamed> T_renamed tag(java.lang.Class<? extends T_renamed> cls) {
        return cls.cast(this.tags.get(cls));
    }

    public okhttp3.Request.Builder newBuilder() {
        return new okhttp3.Request.Builder(this);
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

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public java.lang.String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public static class Builder {

        @javax.annotation.Nullable
        okhttp3.RequestBody body;
        okhttp3.Headers.Builder headers;
        java.lang.String method;
        java.util.Map<java.lang.Class<?>, java.lang.Object> tags;

        @javax.annotation.Nullable
        okhttp3.HttpUrl url;

        public Builder() {
            this.tags = java.util.Collections.emptyMap();
            this.method = "GET";
            this.headers = new okhttp3.Headers.Builder();
        }

        Builder(okhttp3.Request request) {
            java.util.Map<java.lang.Class<?>, java.lang.Object> linkedHashMap;
            this.tags = java.util.Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                linkedHashMap = java.util.Collections.emptyMap();
            } else {
                linkedHashMap = new java.util.LinkedHashMap<>(request.tags);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers.newBuilder();
        }

        public okhttp3.Request.Builder url(okhttp3.HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        public okhttp3.Request.Builder url(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return url(okhttp3.HttpUrl.get(str));
        }

        public okhttp3.Request.Builder url(java.net.URL url) {
            if (url == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            return url(okhttp3.HttpUrl.get(url.toString()));
        }

        public okhttp3.Request.Builder header(java.lang.String str, java.lang.String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public okhttp3.Request.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public okhttp3.Request.Builder removeHeader(java.lang.String str) {
            this.headers.removeAll(str);
            return this;
        }

        public okhttp3.Request.Builder headers(okhttp3.Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public okhttp3.Request.Builder cacheControl(okhttp3.CacheControl cacheControl) {
            java.lang.String string = cacheControl.toString();
            return string.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public okhttp3.Request.Builder get() {
            return method("GET", null);
        }

        public okhttp3.Request.Builder head() {
            return method("HEAD", null);
        }

        public okhttp3.Request.Builder post(okhttp3.RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public okhttp3.Request.Builder delete(@javax.annotation.Nullable okhttp3.RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public okhttp3.Request.Builder delete() {
            return delete(okhttp3.internal.Util.EMPTY_REQUEST);
        }

        public okhttp3.Request.Builder put(okhttp3.RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public okhttp3.Request.Builder patch(okhttp3.RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public okhttp3.Request.Builder method(java.lang.String str, @javax.annotation.Nullable okhttp3.RequestBody requestBody) {
            if (str == null) {
                throw new java.lang.NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new java.lang.IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !okhttp3.internal.http.HttpMethod.permitsRequestBody(str)) {
                throw new java.lang.IllegalArgumentException("method " + str + " must not have a_renamed request body.");
            }
            if (requestBody == null && okhttp3.internal.http.HttpMethod.requiresRequestBody(str)) {
                throw new java.lang.IllegalArgumentException("method " + str + " must have a_renamed request body.");
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public okhttp3.Request.Builder tag(@javax.annotation.Nullable java.lang.Object obj) {
            return tag(java.lang.Object.class, obj);
        }

        public <T_renamed> okhttp3.Request.Builder tag(java.lang.Class<? super T_renamed> cls, @javax.annotation.Nullable T_renamed t_renamed) {
            if (cls == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (t_renamed == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new java.util.LinkedHashMap();
                }
                this.tags.put(cls, cls.cast(t_renamed));
            }
            return this;
        }

        public okhttp3.Request build() {
            if (this.url == null) {
                throw new java.lang.IllegalStateException("url == null");
            }
            return new okhttp3.Request(this);
        }
    }
}
