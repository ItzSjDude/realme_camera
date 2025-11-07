package okhttp3.internal.platform;

/* loaded from: classes2.dex */
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final okhttp3.internal.platform.Platform PLATFORM = findPlatform();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(okhttp3.OkHttpClient.class.getName());

    public void afterHandshake(javax.net.ssl.SSLSocket sSLSocket) {
    }

    public void configureSslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, @javax.annotation.Nullable java.lang.String str, java.util.List<okhttp3.Protocol> list) {
    }

    public java.lang.String getPrefix() {
        return "OkHttp";
    }

    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        return null;
    }

    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        return true;
    }

    public static okhttp3.internal.platform.Platform get() {
        return PLATFORM;
    }

    @javax.annotation.Nullable
    protected javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        try {
            java.lang.Object fieldOrNull = readFieldOrNull(sSLSocketFactory, java.lang.Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (javax.net.ssl.X509TrustManager) readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "trustManager");
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i_renamed) throws java.io.IOException {
        socket.connect(inetSocketAddress, i_renamed);
    }

    public void log(int i_renamed, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
        logger.log(i_renamed == 5 ? java.util.logging.Level.WARNING : java.util.logging.Level.INFO, str, th);
    }

    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            return new java.lang.Throwable(str);
        }
        return null;
    }

    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (java.lang.Throwable) obj);
    }

    public static java.util.List<java.lang.String> alpnProtocolNames(java.util.List<okhttp3.Protocol> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            okhttp3.Protocol protocol = list.get(i_renamed);
            if (protocol != okhttp3.Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.SSLSocketFactory sSLSocketFactory) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        javax.net.ssl.X509TrustManager x509TrustManagerTrustManager = trustManager(sSLSocketFactory);
        if (x509TrustManagerTrustManager == null) {
            throw new java.lang.IllegalStateException("Unable to extract the trust manager on_renamed " + get() + ", sslSocketFactory is_renamed " + sSLSocketFactory.getClass());
        }
        return buildCertificateChainCleaner(x509TrustManagerTrustManager);
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(java.lang.System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
    }

    private static okhttp3.internal.platform.Platform findPlatform() {
        okhttp3.internal.platform.ConscryptPlatform conscryptPlatformBuildIfSupported;
        okhttp3.internal.platform.Platform platformBuildIfSupported = okhttp3.internal.platform.AndroidPlatform.buildIfSupported();
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        if (isConscryptPreferred() && (conscryptPlatformBuildIfSupported = okhttp3.internal.platform.ConscryptPlatform.buildIfSupported()) != null) {
            return conscryptPlatformBuildIfSupported;
        }
        okhttp3.internal.platform.Jdk9Platform jdk9PlatformBuildIfSupported = okhttp3.internal.platform.Jdk9Platform.buildIfSupported();
        if (jdk9PlatformBuildIfSupported != null) {
            return jdk9PlatformBuildIfSupported;
        }
        okhttp3.internal.platform.Platform platformBuildIfSupported2 = okhttp3.internal.platform.JdkWithJettyBootPlatform.buildIfSupported();
        return platformBuildIfSupported2 != null ? platformBuildIfSupported2 : new okhttp3.internal.platform.Platform();
    }

    static byte[] concatLengthPrefixed(java.util.List<okhttp3.Protocol> list) {
        okio.Buffer buffer = new okio.Buffer();
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            okhttp3.Protocol protocol = list.get(i_renamed);
            if (protocol != okhttp3.Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    @javax.annotation.Nullable
    static <T_renamed> T_renamed readFieldOrNull(java.lang.Object obj, java.lang.Class<T_renamed> cls, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        java.lang.Object fieldOrNull;
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
            try {
                java.lang.reflect.Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                java.lang.Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (java.lang.IllegalAccessException unused) {
                throw new java.lang.AssertionError();
            } catch (java.lang.NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, java.lang.Object.class, "delegate")) == null) {
            return null;
        }
        return (T_renamed) readFieldOrNull(fieldOrNull, cls, str);
    }

    public javax.net.ssl.SSLContext getSSLContext() {
        if ("1.7".equals(java.lang.System.getProperty("java.specification.version"))) {
            try {
                return javax.net.ssl.SSLContext.getInstance("TLSv1.2");
            } catch (java.security.NoSuchAlgorithmException unused) {
            }
        }
        try {
            return javax.net.ssl.SSLContext.getInstance("TLS");
        } catch (java.security.NoSuchAlgorithmException e_renamed) {
            throw new java.lang.IllegalStateException("No TLS provider", e_renamed);
        }
    }

    public okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public java.lang.String toString() {
        return getClass().getSimpleName();
    }
}
