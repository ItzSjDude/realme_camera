package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class RealInterceptorChain implements okhttp3.Interceptor.Chain {
    private final okhttp3.Call call;
    private int calls;
    private final int connectTimeout;
    private final okhttp3.internal.connection.RealConnection connection;
    private final okhttp3.EventListener eventListener;
    private final okhttp3.internal.http.HttpCodec httpCodec;
    private final int index;
    private final java.util.List<okhttp3.Interceptor> interceptors;
    private final int readTimeout;
    private final okhttp3.Request request;
    private final okhttp3.internal.connection.StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(java.util.List<okhttp3.Interceptor> list, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.internal.http.HttpCodec httpCodec, okhttp3.internal.connection.RealConnection realConnection, int i_renamed, okhttp3.Request request, okhttp3.Call call, okhttp3.EventListener eventListener, int i2, int i3, int i4) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = i_renamed;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Connection connection() {
        return this.connection;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withConnectTimeout(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, okhttp3.internal.Util.checkDuration("timeout", i_renamed, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withReadTimeout(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, okhttp3.internal.Util.checkDuration("timeout", i_renamed, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withWriteTimeout(int i_renamed, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, okhttp3.internal.Util.checkDuration("timeout", i_renamed, timeUnit));
    }

    public okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public okhttp3.internal.http.HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Call call() {
        return this.call;
    }

    public okhttp3.EventListener eventListener() {
        return this.eventListener;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Response proceed(okhttp3.Request request) throws java.io.IOException {
        return proceed(request, this.streamAllocation, this.httpCodec, this.connection);
    }

    public okhttp3.Response proceed(okhttp3.Request request, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.internal.http.HttpCodec httpCodec, okhttp3.internal.connection.RealConnection realConnection) throws java.io.IOException {
        if (this.index >= this.interceptors.size()) {
            throw new java.lang.AssertionError();
        }
        this.calls++;
        if (this.httpCodec != null && !this.connection.supportsUrl(request.url())) {
            throw new java.lang.IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.httpCodec != null && this.calls > 1) {
            throw new java.lang.IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = new okhttp3.internal.http.RealInterceptorChain(this.interceptors, streamAllocation, httpCodec, realConnection, this.index + 1, request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
        okhttp3.Interceptor interceptor = this.interceptors.get(this.index);
        okhttp3.Response responseIntercept = interceptor.intercept(realInterceptorChain);
        if (httpCodec != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
            throw new java.lang.IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (responseIntercept == null) {
            throw new java.lang.NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new java.lang.IllegalStateException("interceptor " + interceptor + " returned a_renamed response with no body");
    }
}
