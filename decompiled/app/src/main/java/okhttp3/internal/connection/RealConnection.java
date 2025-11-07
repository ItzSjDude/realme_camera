package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class RealConnection extends okhttp3.internal.http2.Http2Connection.Listener implements okhttp3.Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final java.lang.String NPE_THROW_WITH_NULL = "throw with null exception";
    private final okhttp3.ConnectionPool connectionPool;
    private okhttp3.Handshake handshake;
    private okhttp3.internal.http2.Http2Connection http2Connection;
    public boolean noNewStreams;
    private okhttp3.Protocol protocol;
    private java.net.Socket rawSocket;
    private final okhttp3.Route route;
    private okio.BufferedSink sink;
    private java.net.Socket socket;
    private okio.BufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation>> allocations = new java.util.ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    public RealConnection(okhttp3.ConnectionPool connectionPool, okhttp3.Route route) {
        this.connectionPool = connectionPool;
        this.route = route;
    }

    public static okhttp3.internal.connection.RealConnection testConnection(okhttp3.ConnectionPool connectionPool, okhttp3.Route route, java.net.Socket socket, long j_renamed) {
        okhttp3.internal.connection.RealConnection realConnection = new okhttp3.internal.connection.RealConnection(connectionPool, route);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j_renamed;
        return realConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:45:0x00f4 A_renamed[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:58:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x0143 A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    private void connectTunnel(int i_renamed, int i2, int i3, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.io.IOException {
        okhttp3.Request requestCreateTunnelRequest = createTunnelRequest();
        okhttp3.HttpUrl httpUrlUrl = requestCreateTunnelRequest.url();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i_renamed, i2, call, eventListener);
            requestCreateTunnelRequest = createTunnel(i2, i3, requestCreateTunnelRequest, httpUrlUrl);
            if (requestCreateTunnelRequest == null) {
                return;
            }
            okhttp3.internal.Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private void connectSocket(int i_renamed, int i2, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.io.IOException {
        java.net.Socket socketCreateSocket;
        java.net.Proxy proxy = this.route.proxy();
        okhttp3.Address address = this.route.address();
        if (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.HTTP) {
            socketCreateSocket = address.socketFactory().createSocket();
        } else {
            socketCreateSocket = new java.net.Socket(proxy);
        }
        this.rawSocket = socketCreateSocket;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            okhttp3.internal.platform.Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i_renamed);
            try {
                this.source = okio.Okio.buffer(okio.Okio.source(this.rawSocket));
                this.sink = okio.Okio.buffer(okio.Okio.sink(this.rawSocket));
            } catch (java.lang.NullPointerException e_renamed) {
                if (NPE_THROW_WITH_NULL.equals(e_renamed.getMessage())) {
                    throw new java.io.IOException(e_renamed);
                }
            }
        } catch (java.net.ConnectException e2) {
            java.net.ConnectException connectException = new java.net.ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void establishProtocol(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector, int i_renamed, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.lang.Throwable {
        if (this.route.address().sslSocketFactory() == null) {
            if (this.route.address().protocols().contains(okhttp3.Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.socket = this.rawSocket;
                this.protocol = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
                startHttp2(i_renamed);
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = okhttp3.Protocol.HTTP_1_1;
                return;
            }
        }
        eventListener.secureConnectStart(call);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == okhttp3.Protocol.HTTP_2) {
            startHttp2(i_renamed);
        }
    }

    private void startHttp2(int i_renamed) throws java.io.IOException {
        this.socket.setSoTimeout(0);
        this.http2Connection = new okhttp3.internal.http2.Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i_renamed).build();
        this.http2Connection.start();
    }

    private void connectTls(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector) throws java.lang.Throwable {
        javax.net.ssl.SSLSocket sSLSocket;
        okhttp3.Protocol protocol;
        okhttp3.Address address = this.route.address();
        try {
            try {
                sSLSocket = (javax.net.ssl.SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            } catch (java.lang.AssertionError e_renamed) {
                e_renamed = e_renamed;
            }
        } catch (java.lang.Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            okhttp3.ConnectionSpec connectionSpecConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket);
            if (connectionSpecConfigureSecureSocket.supportsTlsExtensions()) {
                okhttp3.internal.platform.Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            javax.net.ssl.SSLSession session = sSLSocket.getSession();
            okhttp3.Handshake handshake = okhttp3.Handshake.get(session);
            if (!address.hostnameVerifier().verify(address.url().host(), session)) {
                java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) handshake.peerCertificates().get(0);
                throw new javax.net.ssl.SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n_renamed    certificate: " + okhttp3.CertificatePinner.pin(x509Certificate) + "\n_renamed    DN: " + x509Certificate.getSubjectDN().getName() + "\n_renamed    subjectAltNames: " + okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            }
            address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
            java.lang.String selectedProtocol = connectionSpecConfigureSecureSocket.supportsTlsExtensions() ? okhttp3.internal.platform.Platform.get().getSelectedProtocol(sSLSocket) : null;
            this.socket = sSLSocket;
            this.source = okio.Okio.buffer(okio.Okio.source(this.socket));
            this.sink = okio.Okio.buffer(okio.Okio.sink(this.socket));
            this.handshake = handshake;
            if (selectedProtocol != null) {
                protocol = okhttp3.Protocol.get(selectedProtocol);
            } else {
                protocol = okhttp3.Protocol.HTTP_1_1;
            }
            this.protocol = protocol;
            if (sSLSocket != null) {
                okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket);
            }
        } catch (java.lang.AssertionError e2) {
            e_renamed = e2;
            if (!okhttp3.internal.Util.isAndroidGetsocknameError(e_renamed)) {
                throw e_renamed;
            }
            throw new java.io.IOException(e_renamed);
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket);
            }
            okhttp3.internal.Util.closeQuietly((java.net.Socket) sSLSocket);
            throw th;
        }
    }

    private okhttp3.Request createTunnel(int i_renamed, int i2, okhttp3.Request request, okhttp3.HttpUrl httpUrl) throws java.io.IOException {
        java.lang.String str = "CONNECT " + okhttp3.internal.Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.http1.Http1Codec http1Codec = new okhttp3.internal.http1.Http1Codec(null, null, this.source, this.sink);
            this.source.timeout().timeout(i_renamed, java.util.concurrent.TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout(i2, java.util.concurrent.TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            okhttp3.Response responseBuild = http1Codec.readResponseHeaders(false).request(request).build();
            long jContentLength = okhttp3.internal.http.HttpHeaders.contentLength(responseBuild);
            if (jContentLength == -1) {
                jContentLength = 0;
            }
            okio.Source sourceNewFixedLengthSource = http1Codec.newFixedLengthSource(jContentLength);
            okhttp3.internal.Util.skipAll(sourceNewFixedLengthSource, Integer.MAX_VALUE, java.util.concurrent.TimeUnit.MILLISECONDS);
            sourceNewFixedLengthSource.close();
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                }
                throw new java.io.IOException("TLS tunnel buffered too many bytes!");
            }
            if (iCode == 407) {
                okhttp3.Request requestAuthenticate = this.route.address().proxyAuthenticator().authenticate(this.route, responseBuild);
                if (requestAuthenticate == null) {
                    throw new java.io.IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(responseBuild.header("Connection"))) {
                    return requestAuthenticate;
                }
                request = requestAuthenticate;
            } else {
                throw new java.io.IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
        }
    }

    private okhttp3.Request createTunnelRequest() throws java.io.IOException {
        okhttp3.Request requestBuild = new okhttp3.Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", okhttp3.internal.Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", okhttp3.internal.Version.userAgent()).build();
        okhttp3.Request requestAuthenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new okhttp3.Response.Builder().request(requestBuild).protocol(okhttp3.Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return requestAuthenticate != null ? requestAuthenticate : requestBuild;
    }

    public boolean isEligible(okhttp3.Address address, @javax.annotation.Nullable okhttp3.Route route) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !okhttp3.internal.Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route == null || route.proxy().type() != java.net.Proxy.Type.DIRECT || this.route.proxy().type() != java.net.Proxy.Type.DIRECT || !this.route.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != okhttp3.internal.tls.OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean supportsUrl(okhttp3.HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        return this.handshake != null && okhttp3.internal.tls.OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (java.security.cert.X509Certificate) this.handshake.peerCertificates().get(0));
    }

    public okhttp3.internal.http.HttpCodec newCodec(okhttp3.OkHttpClient okHttpClient, okhttp3.Interceptor.Chain chain, okhttp3.internal.connection.StreamAllocation streamAllocation) throws java.net.SocketException {
        okhttp3.internal.http2.Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new okhttp3.internal.http2.Http2Codec(okHttpClient, chain, streamAllocation, http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout(chain.readTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout(chain.writeTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
        return new okhttp3.internal.http1.Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public okhttp3.internal.ws.RealWebSocket.Streams newWebSocketStreams(final okhttp3.internal.connection.StreamAllocation streamAllocation) {
        return new okhttp3.internal.ws.RealWebSocket.Streams(true, this.source, this.sink) { // from class: okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                okhttp3.internal.connection.StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
            }
        };
    }

    @Override // okhttp3.Connection
    public okhttp3.Route route() {
        return this.route;
    }

    public void cancel() throws java.io.IOException {
        okhttp3.internal.Util.closeQuietly(this.rawSocket);
    }

    @Override // okhttp3.Connection
    public java.net.Socket socket() {
        return this.socket;
    }

    public boolean isHealthy(boolean z_renamed) throws java.net.SocketException {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.http2Connection != null) {
            return !r0.isShutdown();
        }
        if (z_renamed) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.exhausted();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (java.net.SocketTimeoutException unused) {
            } catch (java.io.IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
        http2Stream.close(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(okhttp3.internal.http2.Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.Connection
    public okhttp3.Handshake handshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    @Override // okhttp3.Connection
    public okhttp3.Protocol protocol() {
        return this.protocol;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        okhttp3.Handshake handshake = this.handshake;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
