package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class ConnectInterceptor implements okhttp3.Interceptor {
    public final okhttp3.OkHttpClient client;

    public ConnectInterceptor(okhttp3.OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (okhttp3.internal.http.RealInterceptorChain) chain;
        okhttp3.Request request = realInterceptorChain.request();
        okhttp3.internal.connection.StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals("GET")), streamAllocation.connection());
    }
}
