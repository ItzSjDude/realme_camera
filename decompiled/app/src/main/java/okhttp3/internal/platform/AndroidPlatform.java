package okhttp3.internal.platform;

/* loaded from: classes2.dex */
class AndroidPlatform extends okhttp3.internal.platform.Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final okhttp3.internal.platform.AndroidPlatform.CloseGuard closeGuard = okhttp3.internal.platform.AndroidPlatform.CloseGuard.get();
    private final okhttp3.internal.platform.OptionalMethod<java.net.Socket> getAlpnSelectedProtocol;
    private final okhttp3.internal.platform.OptionalMethod<java.net.Socket> setAlpnProtocols;
    private final okhttp3.internal.platform.OptionalMethod<java.net.Socket> setHostname;
    private final okhttp3.internal.platform.OptionalMethod<java.net.Socket> setUseSessionTickets;
    private final java.lang.Class<?> sslParametersClass;

    AndroidPlatform(java.lang.Class<?> cls, okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod, okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod2, okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod3, okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod4) {
        this.sslParametersClass = cls;
        this.setUseSessionTickets = optionalMethod;
        this.setHostname = optionalMethod2;
        this.getAlpnSelectedProtocol = optionalMethod3;
        this.setAlpnProtocols = optionalMethod4;
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i_renamed) throws java.io.IOException {
        try {
            socket.connect(inetSocketAddress, i_renamed);
        } catch (java.lang.AssertionError e_renamed) {
            if (!okhttp3.internal.Util.isAndroidGetsocknameError(e_renamed)) {
                throw e_renamed;
            }
            throw new java.io.IOException(e_renamed);
        } catch (java.lang.ClassCastException e2) {
            if (android.os.Build.VERSION.SDK_INT == 26) {
                java.io.IOException iOException = new java.io.IOException("Exception in_renamed connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (java.lang.SecurityException e3) {
            java.io.IOException iOException2 = new java.io.IOException("Exception in_renamed connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    protected javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        java.lang.Object fieldOrNull = readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
        if (fieldOrNull == null) {
            try {
                fieldOrNull = readFieldOrNull(sSLSocketFactory, java.lang.Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (java.lang.ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        javax.net.ssl.X509TrustManager x509TrustManager = (javax.net.ssl.X509TrustManager) readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (javax.net.ssl.X509TrustManager) readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "trustManager");
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) {
        if (str != null) {
            this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, true);
            this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod = this.setAlpnProtocols;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
            return;
        }
        this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, concatLengthPrefixed(list));
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        byte[] bArr;
        okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod = this.getAlpnSelectedProtocol;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new java.lang.Object[0])) == null) {
            return null;
        }
        return new java.lang.String(bArr, okhttp3.internal.Util.UTF_8);
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int i_renamed, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
        int iMin;
        int i2 = i_renamed != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n_renamed' + android.util.Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = java.lang.Math.min(iIndexOf, i3 + 4000);
                android.util.Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        return this.closeGuard.createAndOpen(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (this.closeGuard.warnIfOpen(obj)) {
            return;
        }
        log(5, str, null);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(java.lang.String str) throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.security.NetworkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(str, cls, cls.getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to determine cleartext support", e_renamed);
        }
    }

    private boolean api24IsCleartextTrafficPermitted(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", java.lang.String.class).invoke(obj, str)).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return this.api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    private boolean api23IsCleartextTrafficPermitted(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private static boolean supportsAlpn() throws java.lang.ClassNotFoundException {
        if (java.security.Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            java.lang.Class.forName("android.net.Network");
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) throws java.lang.ClassNotFoundException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.net.http.X509TrustManagerExtensions");
            return new okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner(cls.getConstructor(javax.net.ssl.X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", java.security.cert.X509Certificate[].class, java.lang.String.class, java.lang.String.class));
        } catch (java.lang.Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    public static okhttp3.internal.platform.Platform buildIfSupported() {
        java.lang.Class<?> cls;
        okhttp3.internal.platform.OptionalMethod optionalMethod;
        okhttp3.internal.platform.OptionalMethod optionalMethod2;
        try {
            try {
                cls = java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (java.lang.ClassNotFoundException unused) {
                cls = java.lang.Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            java.lang.Class<?> cls2 = cls;
            okhttp3.internal.platform.OptionalMethod optionalMethod3 = new okhttp3.internal.platform.OptionalMethod(null, "setUseSessionTickets", java.lang.Boolean.TYPE);
            okhttp3.internal.platform.OptionalMethod optionalMethod4 = new okhttp3.internal.platform.OptionalMethod(null, "setHostname", java.lang.String.class);
            if (supportsAlpn()) {
                okhttp3.internal.platform.OptionalMethod optionalMethod5 = new okhttp3.internal.platform.OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new java.lang.Class[0]);
                optionalMethod2 = new okhttp3.internal.platform.OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod = optionalMethod5;
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new okhttp3.internal.platform.AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (java.lang.ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            java.lang.reflect.Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", java.security.cert.X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (java.lang.NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    static final class AndroidCertificateChainCleaner extends okhttp3.internal.tls.CertificateChainCleaner {
        private final java.lang.reflect.Method checkServerTrusted;
        private final java.lang.Object x509TrustManagerExtensions;

        public int hashCode() {
            return 0;
        }

        AndroidCertificateChainCleaner(java.lang.Object obj, java.lang.reflect.Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
            try {
                return (java.util.List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (java.security.cert.X509Certificate[]) list.toArray(new java.security.cert.X509Certificate[list.size()]), "RSA", str);
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                javax.net.ssl.SSLPeerUnverifiedException sSLPeerUnverifiedException = new javax.net.ssl.SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(java.lang.Object obj) {
            return obj instanceof okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner;
        }
    }

    static final class CloseGuard {
        private final java.lang.reflect.Method getMethod;
        private final java.lang.reflect.Method openMethod;
        private final java.lang.reflect.Method warnIfOpenMethod;

        CloseGuard(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        java.lang.Object createAndOpen(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            java.lang.reflect.Method method = this.getMethod;
            if (method != null) {
                try {
                    java.lang.Object objInvoke = method.invoke(null, new java.lang.Object[0]);
                    this.openMethod.invoke(objInvoke, str);
                    return objInvoke;
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }

        boolean warnIfOpen(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.warnIfOpenMethod.invoke(obj, new java.lang.Object[0]);
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }

        static okhttp3.internal.platform.AndroidPlatform.CloseGuard get() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
            java.lang.reflect.Method method;
            java.lang.reflect.Method method2;
            java.lang.reflect.Method method3 = null;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("dalvik.system.CloseGuard");
                java.lang.reflect.Method method4 = cls.getMethod("get", new java.lang.Class[0]);
                method2 = cls.getMethod("open", java.lang.String.class);
                method = cls.getMethod("warnIfOpen", new java.lang.Class[0]);
                method3 = method4;
            } catch (java.lang.Exception unused) {
                method = null;
                method2 = null;
            }
            return new okhttp3.internal.platform.AndroidPlatform.CloseGuard(method3, method2, method);
        }
    }

    static final class AndroidTrustRootIndex implements okhttp3.internal.tls.TrustRootIndex {
        private final java.lang.reflect.Method findByIssuerAndSignatureMethod;
        private final javax.net.ssl.X509TrustManager trustManager;

        AndroidTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager, java.lang.reflect.Method method) {
            this.findByIssuerAndSignatureMethod = method;
            this.trustManager = x509TrustManager;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
            try {
                java.security.cert.TrustAnchor trustAnchor = (java.security.cert.TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw okhttp3.internal.Util.assertionError("unable to get issues and signature", e_renamed);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex)) {
                return false;
            }
            okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex androidTrustRootIndex = (okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex) obj;
            return this.trustManager.equals(androidTrustRootIndex.trustManager) && this.findByIssuerAndSignatureMethod.equals(androidTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x000e  */
    @Override // okhttp3.internal.platform.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.net.ssl.SSLContext getSSLContext() {
        /*
            r2 = this;
            r2 = 1
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r1 = 16
            if (r0 < r1) goto Le
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r1 = 22
            if (r0 >= r1) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L18
            java.lang.String r2 = "TLSv1.2"
            javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch: java.security.NoSuchAlgorithmException -> L18
            return r2
        L18:
            java.lang.String r2 = "TLS"
            javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch: java.security.NoSuchAlgorithmException -> L1f
            return r2
        L1f:
            r2 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No TLS provider"
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.getSSLContext():javax.net.ssl.SSLContext");
    }
}
