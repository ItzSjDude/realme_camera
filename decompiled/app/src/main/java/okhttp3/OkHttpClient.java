package okhttp3;

/* loaded from: classes2.dex */
public class OkHttpClient implements java.lang.Cloneable, okhttp3.Call.Factory, okhttp3.WebSocket.Factory {
    final okhttp3.Authenticator authenticator;

    @javax.annotation.Nullable
    final okhttp3.Cache cache;
    final int callTimeout;
    final okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
    final okhttp3.CertificatePinner certificatePinner;
    final int connectTimeout;
    final okhttp3.ConnectionPool connectionPool;
    final java.util.List<okhttp3.ConnectionSpec> connectionSpecs;
    final okhttp3.CookieJar cookieJar;
    final okhttp3.Dispatcher dispatcher;
    final okhttp3.Dns dns;
    final okhttp3.EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final javax.net.ssl.HostnameVerifier hostnameVerifier;
    final java.util.List<okhttp3.Interceptor> interceptors;

    @javax.annotation.Nullable
    final okhttp3.internal.cache.InternalCache internalCache;
    final java.util.List<okhttp3.Interceptor> networkInterceptors;
    final int pingInterval;
    final java.util.List<okhttp3.Protocol> protocols;

    @javax.annotation.Nullable
    final java.net.Proxy proxy;
    final okhttp3.Authenticator proxyAuthenticator;
    final java.net.ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final javax.net.SocketFactory socketFactory;
    final javax.net.ssl.SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    static final java.util.List<okhttp3.Protocol> DEFAULT_PROTOCOLS = okhttp3.internal.Util.immutableList(okhttp3.Protocol.HTTP_2, okhttp3.Protocol.HTTP_1_1);
    static final java.util.List<okhttp3.ConnectionSpec> DEFAULT_CONNECTION_SPECS = okhttp3.internal.Util.immutableList(okhttp3.ConnectionSpec.MODERN_TLS, okhttp3.ConnectionSpec.CLEARTEXT);

    static {
        okhttp3.internal.Internal.instance = new okhttp3.internal.Internal() { // from class: okhttp3.OkHttpClient.1
            @Override // okhttp3.internal.Internal
            public void addLenient(okhttp3.Headers.Builder builder, java.lang.String str) {
                builder.addLenient(str);
            }

            @Override // okhttp3.internal.Internal
            public void addLenient(okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2) {
                builder.addLenient(str, str2);
            }

            @Override // okhttp3.internal.Internal
            public void setCache(okhttp3.OkHttpClient.Builder builder, okhttp3.internal.cache.InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            @Override // okhttp3.internal.Internal
            public boolean connectionBecameIdle(okhttp3.ConnectionPool connectionPool, okhttp3.internal.connection.RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public okhttp3.internal.connection.RealConnection get(okhttp3.ConnectionPool connectionPool, okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.Route route) {
                return connectionPool.get(address, streamAllocation, route);
            }

            @Override // okhttp3.internal.Internal
            public boolean equalsNonHost(okhttp3.Address address, okhttp3.Address address2) {
                return address.equalsNonHost(address2);
            }

            @Override // okhttp3.internal.Internal
            public java.net.Socket deduplicate(okhttp3.ConnectionPool connectionPool, okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation) {
                return connectionPool.deduplicate(address, streamAllocation);
            }

            @Override // okhttp3.internal.Internal
            public void put(okhttp3.ConnectionPool connectionPool, okhttp3.internal.connection.RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public okhttp3.internal.connection.RouteDatabase routeDatabase(okhttp3.ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            @Override // okhttp3.internal.Internal
            public int code(okhttp3.Response.Builder builder) {
                return builder.code;
            }

            @Override // okhttp3.internal.Internal
            public void apply(okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z_renamed) {
                connectionSpec.apply(sSLSocket, z_renamed);
            }

            @Override // okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(java.lang.IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // okhttp3.internal.Internal
            public okhttp3.internal.connection.StreamAllocation streamAllocation(okhttp3.Call call) {
                return ((okhttp3.RealCall) call).streamAllocation();
            }

            @Override // okhttp3.internal.Internal
            @javax.annotation.Nullable
            public java.io.IOException timeoutExit(okhttp3.Call call, @javax.annotation.Nullable java.io.IOException iOException) {
                return ((okhttp3.RealCall) call).timeoutExit(iOException);
            }

            @Override // okhttp3.internal.Internal
            public okhttp3.Call newWebSocketCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request) {
                return okhttp3.RealCall.newRealCall(okHttpClient, request, true);
            }
        };
    }

    public OkHttpClient() {
        this(new okhttp3.OkHttpClient.Builder());
    }

    OkHttpClient(okhttp3.OkHttpClient.Builder builder) throws java.security.NoSuchAlgorithmException, java.security.KeyStoreException {
        boolean z_renamed;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.connectionSpecs = builder.connectionSpecs;
        this.interceptors = okhttp3.internal.Util.immutableList(builder.interceptors);
        this.networkInterceptors = okhttp3.internal.Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        java.util.Iterator<okhttp3.ConnectionSpec> it = this.connectionSpecs.iterator();
        loop0: while (true) {
            z_renamed = false;
            while (it.hasNext()) {
                z_renamed = (z_renamed || it.next().isTls()) ? true : z_renamed;
            }
        }
        if (builder.sslSocketFactory != null || !z_renamed) {
            this.sslSocketFactory = builder.sslSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        } else {
            javax.net.ssl.X509TrustManager x509TrustManagerPlatformTrustManager = okhttp3.internal.Util.platformTrustManager();
            this.sslSocketFactory = newSslSocketFactory(x509TrustManagerPlatformTrustManager);
            this.certificateChainCleaner = okhttp3.internal.tls.CertificateChainCleaner.get(x509TrustManagerPlatformTrustManager);
        }
        if (this.sslSocketFactory != null) {
            okhttp3.internal.platform.Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (this.interceptors.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: " + this.interceptors);
        }
        if (this.networkInterceptors.contains(null)) {
            throw new java.lang.IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    private static javax.net.ssl.SSLSocketFactory newSslSocketFactory(javax.net.ssl.X509TrustManager x509TrustManager) throws java.security.KeyManagementException {
        try {
            javax.net.ssl.SSLContext sSLContext = okhttp3.internal.platform.Platform.get().getSSLContext();
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (java.security.GeneralSecurityException e_renamed) {
            throw okhttp3.internal.Util.assertionError("No System TLS", e_renamed);
        }
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    @javax.annotation.Nullable
    public java.net.Proxy proxy() {
        return this.proxy;
    }

    public java.net.ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public okhttp3.CookieJar cookieJar() {
        return this.cookieJar;
    }

    @javax.annotation.Nullable
    public okhttp3.Cache cache() {
        return this.cache;
    }

    okhttp3.internal.cache.InternalCache internalCache() {
        okhttp3.Cache cache = this.cache;
        return cache != null ? cache.internalCache : this.internalCache;
    }

    public okhttp3.Dns dns() {
        return this.dns;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public okhttp3.Authenticator authenticator() {
        return this.authenticator;
    }

    public okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public okhttp3.ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public okhttp3.Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public java.util.List<okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    public java.util.List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public java.util.List<okhttp3.Interceptor> interceptors() {
        return this.interceptors;
    }

    public java.util.List<okhttp3.Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public okhttp3.EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Override // okhttp3.Call.Factory
    public okhttp3.Call newCall(okhttp3.Request request) {
        return okhttp3.RealCall.newRealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public okhttp3.WebSocket newWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener) {
        okhttp3.internal.ws.RealWebSocket realWebSocket = new okhttp3.internal.ws.RealWebSocket(request, webSocketListener, new java.util.Random(), this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public okhttp3.OkHttpClient.Builder newBuilder() {
        return new okhttp3.OkHttpClient.Builder(this);
    }

    public static final class Builder {
        okhttp3.Authenticator authenticator;

        @javax.annotation.Nullable
        okhttp3.Cache cache;
        int callTimeout;

        @javax.annotation.Nullable
        okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
        okhttp3.CertificatePinner certificatePinner;
        int connectTimeout;
        okhttp3.ConnectionPool connectionPool;
        java.util.List<okhttp3.ConnectionSpec> connectionSpecs;
        okhttp3.CookieJar cookieJar;
        okhttp3.Dispatcher dispatcher;
        okhttp3.Dns dns;
        okhttp3.EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        final java.util.List<okhttp3.Interceptor> interceptors;

        @javax.annotation.Nullable
        okhttp3.internal.cache.InternalCache internalCache;
        final java.util.List<okhttp3.Interceptor> networkInterceptors;
        int pingInterval;
        java.util.List<okhttp3.Protocol> protocols;

        @javax.annotation.Nullable
        java.net.Proxy proxy;
        okhttp3.Authenticator proxyAuthenticator;
        java.net.ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        javax.net.SocketFactory socketFactory;

        @javax.annotation.Nullable
        javax.net.ssl.SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new java.util.ArrayList();
            this.networkInterceptors = new java.util.ArrayList();
            this.dispatcher = new okhttp3.Dispatcher();
            this.protocols = okhttp3.OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = okhttp3.OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = okhttp3.EventListener.factory(okhttp3.EventListener.NONE);
            this.proxySelector = java.net.ProxySelector.getDefault();
            if (this.proxySelector == null) {
                this.proxySelector = new okhttp3.internal.proxy.NullProxySelector();
            }
            this.cookieJar = okhttp3.CookieJar.NO_COOKIES;
            this.socketFactory = javax.net.SocketFactory.getDefault();
            this.hostnameVerifier = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE;
            this.certificatePinner = okhttp3.CertificatePinner.DEFAULT;
            this.proxyAuthenticator = okhttp3.Authenticator.NONE;
            this.authenticator = okhttp3.Authenticator.NONE;
            this.connectionPool = new okhttp3.ConnectionPool();
            this.dns = okhttp3.Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        Builder(okhttp3.OkHttpClient okHttpClient) {
            this.interceptors = new java.util.ArrayList();
            this.networkInterceptors = new java.util.ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.callTimeout = okHttpClient.callTimeout;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }

        public okhttp3.OkHttpClient.Builder callTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.callTimeout = okhttp3.internal.Util.checkDuration("timeout", j_renamed, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder callTimeout(java.time.Duration duration) {
            this.callTimeout = okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.connectTimeout = okhttp3.internal.Util.checkDuration("timeout", j_renamed, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder connectTimeout(java.time.Duration duration) {
            this.connectTimeout = okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder readTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.readTimeout = okhttp3.internal.Util.checkDuration("timeout", j_renamed, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder readTimeout(java.time.Duration duration) {
            this.readTimeout = okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder writeTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.writeTimeout = okhttp3.internal.Util.checkDuration("timeout", j_renamed, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder writeTimeout(java.time.Duration duration) {
            this.writeTimeout = okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder pingInterval(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.pingInterval = okhttp3.internal.Util.checkDuration("interval", j_renamed, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder pingInterval(java.time.Duration duration) {
            this.pingInterval = okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxy(@javax.annotation.Nullable java.net.Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxySelector(java.net.ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new java.lang.NullPointerException("proxySelector == null");
            }
            this.proxySelector = proxySelector;
            return this;
        }

        public okhttp3.OkHttpClient.Builder cookieJar(okhttp3.CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new java.lang.NullPointerException("cookieJar == null");
            }
            this.cookieJar = cookieJar;
            return this;
        }

        void setInternalCache(@javax.annotation.Nullable okhttp3.internal.cache.InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public okhttp3.OkHttpClient.Builder cache(@javax.annotation.Nullable okhttp3.Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public okhttp3.OkHttpClient.Builder dns(okhttp3.Dns dns) {
            if (dns == null) {
                throw new java.lang.NullPointerException("dns == null");
            }
            this.dns = dns;
            return this;
        }

        public okhttp3.OkHttpClient.Builder socketFactory(javax.net.SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new java.lang.NullPointerException("socketFactory == null");
            }
            this.socketFactory = socketFactory;
            return this;
        }

        public okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = okhttp3.internal.platform.Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new java.lang.NullPointerException("trustManager == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = okhttp3.internal.tls.CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public okhttp3.OkHttpClient.Builder hostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new java.lang.NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public okhttp3.OkHttpClient.Builder certificatePinner(okhttp3.CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new java.lang.NullPointerException("certificatePinner == null");
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public okhttp3.OkHttpClient.Builder authenticator(okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("authenticator == null");
            }
            this.authenticator = authenticator;
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxyAuthenticator(okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("proxyAuthenticator == null");
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectionPool(okhttp3.ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new java.lang.NullPointerException("connectionPool == null");
            }
            this.connectionPool = connectionPool;
            return this;
        }

        public okhttp3.OkHttpClient.Builder followSslRedirects(boolean z_renamed) {
            this.followSslRedirects = z_renamed;
            return this;
        }

        public okhttp3.OkHttpClient.Builder followRedirects(boolean z_renamed) {
            this.followRedirects = z_renamed;
            return this;
        }

        public okhttp3.OkHttpClient.Builder retryOnConnectionFailure(boolean z_renamed) {
            this.retryOnConnectionFailure = z_renamed;
            return this;
        }

        public okhttp3.OkHttpClient.Builder dispatcher(okhttp3.Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new java.lang.IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public okhttp3.OkHttpClient.Builder protocols(java.util.List<okhttp3.Protocol> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            if (!arrayList.contains(okhttp3.Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(okhttp3.Protocol.HTTP_1_1)) {
                throw new java.lang.IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(okhttp3.Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new java.lang.IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(okhttp3.Protocol.HTTP_1_0)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(okhttp3.Protocol.SPDY_3);
            this.protocols = java.util.Collections.unmodifiableList(arrayList);
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectionSpecs(java.util.List<okhttp3.ConnectionSpec> list) {
            this.connectionSpecs = okhttp3.internal.Util.immutableList(list);
            return this;
        }

        public java.util.List<okhttp3.Interceptor> interceptors() {
            return this.interceptors;
        }

        public okhttp3.OkHttpClient.Builder addInterceptor(okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            return this;
        }

        public java.util.List<okhttp3.Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public okhttp3.OkHttpClient.Builder addNetworkInterceptor(okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public okhttp3.OkHttpClient.Builder eventListener(okhttp3.EventListener eventListener) {
            if (eventListener == null) {
                throw new java.lang.NullPointerException("eventListener == null");
            }
            this.eventListenerFactory = okhttp3.EventListener.factory(eventListener);
            return this;
        }

        public okhttp3.OkHttpClient.Builder eventListenerFactory(okhttp3.EventListener.Factory factory) {
            if (factory == null) {
                throw new java.lang.NullPointerException("eventListenerFactory == null");
            }
            this.eventListenerFactory = factory;
            return this;
        }

        public okhttp3.OkHttpClient build() {
            return new okhttp3.OkHttpClient(this);
        }
    }
}
