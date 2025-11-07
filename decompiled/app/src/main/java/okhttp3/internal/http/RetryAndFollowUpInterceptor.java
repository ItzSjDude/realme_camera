package okhttp3.internal.http;

/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements okhttp3.Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private java.lang.Object callStackTrace;
    private volatile boolean canceled;
    private final okhttp3.OkHttpClient client;
    private final boolean forWebSocket;
    private volatile okhttp3.internal.connection.StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(okhttp3.OkHttpClient okHttpClient, boolean z_renamed) {
        this.client = okHttpClient;
        this.forWebSocket = z_renamed;
    }

    public void cancel() {
        this.canceled = true;
        okhttp3.internal.connection.StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(java.lang.Object obj) {
        this.callStackTrace = obj;
    }

    public okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Response responseProceed;
        okhttp3.Request requestFollowUpRequest;
        okhttp3.Request request = chain.request();
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (okhttp3.internal.http.RealInterceptorChain) chain;
        okhttp3.Call call = realInterceptorChain.call();
        okhttp3.EventListener eventListener = realInterceptorChain.eventListener();
        okhttp3.internal.connection.StreamAllocation streamAllocation = new okhttp3.internal.connection.StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        int i_renamed = 0;
        okhttp3.Response response = null;
        while (!this.canceled) {
            try {
                try {
                    responseProceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                    if (response != null) {
                        responseProceed = responseProceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                    try {
                        requestFollowUpRequest = followUpRequest(responseProceed, streamAllocation.route());
                    } catch (java.io.IOException e_renamed) {
                        streamAllocation.release();
                        throw e_renamed;
                    }
                } catch (java.io.IOException e2) {
                    if (!recover(e2, streamAllocation, !(e2 instanceof okhttp3.internal.http2.ConnectionShutdownException), request)) {
                        throw e2;
                    }
                } catch (okhttp3.internal.connection.RouteException e3) {
                    if (!recover(e3.getLastConnectException(), streamAllocation, false, request)) {
                        throw e3.getFirstConnectException();
                    }
                }
                if (requestFollowUpRequest == null) {
                    streamAllocation.release();
                    return responseProceed;
                }
                okhttp3.internal.Util.closeQuietly(responseProceed.body());
                int i2 = i_renamed + 1;
                if (i2 > 20) {
                    streamAllocation.release();
                    throw new java.net.ProtocolException("Too many follow-up_renamed requests: " + i2);
                }
                if (requestFollowUpRequest.body() instanceof okhttp3.internal.http.UnrepeatableRequestBody) {
                    streamAllocation.release();
                    throw new java.net.HttpRetryException("Cannot retry streamed HTTP body", responseProceed.code());
                }
                if (!sameConnection(responseProceed, requestFollowUpRequest.url())) {
                    streamAllocation.release();
                    streamAllocation = new okhttp3.internal.connection.StreamAllocation(this.client.connectionPool(), createAddress(requestFollowUpRequest.url()), call, eventListener, this.callStackTrace);
                    this.streamAllocation = streamAllocation;
                } else if (streamAllocation.codec() != null) {
                    throw new java.lang.IllegalStateException("Closing the body of_renamed " + responseProceed + " didn't_renamed close its backing stream. Bad interceptor?");
                }
                response = responseProceed;
                request = requestFollowUpRequest;
                i_renamed = i2;
            } catch (java.lang.Throwable th) {
                streamAllocation.streamFailed(null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new java.io.IOException("Canceled");
    }

    private okhttp3.Address createAddress(okhttp3.HttpUrl httpUrl) {
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        okhttp3.CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            javax.net.ssl.SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new okhttp3.Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(java.io.IOException iOException, okhttp3.internal.connection.StreamAllocation streamAllocation, boolean z_renamed, okhttp3.Request request) throws java.io.IOException {
        streamAllocation.streamFailed(iOException);
        if (this.client.retryOnConnectionFailure()) {
            return !(z_renamed && (request.body() instanceof okhttp3.internal.http.UnrepeatableRequestBody)) && isRecoverable(iOException, z_renamed) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private boolean isRecoverable(java.io.IOException iOException, boolean z_renamed) {
        if (iOException instanceof java.net.ProtocolException) {
            return false;
        }
        return iOException instanceof java.io.InterruptedIOException ? (iOException instanceof java.net.SocketTimeoutException) && !z_renamed : (((iOException instanceof javax.net.ssl.SSLHandshakeException) && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) ? false : true;
    }

    private okhttp3.Request followUpRequest(okhttp3.Response response, okhttp3.Route route) throws java.io.IOException {
        java.lang.String strHeader;
        okhttp3.HttpUrl httpUrlResolve;
        java.net.Proxy proxy;
        if (response == null) {
            throw new java.lang.IllegalStateException();
        }
        int iCode = response.code();
        java.lang.String strMethod = response.request().method();
        if (iCode == 307 || iCode == 308) {
            if (!strMethod.equals("GET") && !strMethod.equals("HEAD")) {
                return null;
            }
        } else {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                if (route != null) {
                    proxy = route.proxy();
                } else {
                    proxy = this.client.proxy();
                }
                if (proxy.type() != java.net.Proxy.Type.HTTP) {
                    throw new java.net.ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, response);
            }
            if (iCode == 408) {
                if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof okhttp3.internal.http.UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.followRedirects() || (strHeader = response.header("Location")) == null || (httpUrlResolve = response.request().url().resolve(strHeader)) == null) {
            return null;
        }
        if (!httpUrlResolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        okhttp3.Request.Builder builderNewBuilder = response.request().newBuilder();
        if (okhttp3.internal.http.HttpMethod.permitsRequestBody(strMethod)) {
            boolean zRedirectsWithBody = okhttp3.internal.http.HttpMethod.redirectsWithBody(strMethod);
            if (okhttp3.internal.http.HttpMethod.redirectsToGet(strMethod)) {
                builderNewBuilder.method("GET", null);
            } else {
                builderNewBuilder.method(strMethod, zRedirectsWithBody ? response.request().body() : null);
            }
            if (!zRedirectsWithBody) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!sameConnection(response, httpUrlResolve)) {
            builderNewBuilder.removeHeader("Authorization");
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private int retryAfter(okhttp3.Response response, int i_renamed) {
        java.lang.String strHeader = response.header("Retry-After");
        if (strHeader == null) {
            return i_renamed;
        }
        if (strHeader.matches("\\d_renamed+")) {
            return java.lang.Integer.valueOf(strHeader).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(okhttp3.Response response, okhttp3.HttpUrl httpUrl) {
        okhttp3.HttpUrl httpUrlUrl = response.request().url();
        return httpUrlUrl.host().equals(httpUrl.host()) && httpUrlUrl.port() == httpUrl.port() && httpUrlUrl.scheme().equals(httpUrl.scheme());
    }
}
