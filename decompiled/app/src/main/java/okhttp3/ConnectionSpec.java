package okhttp3;

/* loaded from: classes2.dex */
public final class ConnectionSpec {

    @javax.annotation.Nullable
    final java.lang.String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;

    @javax.annotation.Nullable
    final java.lang.String[] tlsVersions;
    private static final okhttp3.CipherSuite[] RESTRICTED_CIPHER_SUITES = {okhttp3.CipherSuite.TLS_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_CHACHA20_POLY1305_SHA256, okhttp3.CipherSuite.TLS_AES_128_CCM_SHA256, okhttp3.CipherSuite.TLS_AES_256_CCM_8_SHA256, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
    private static final okhttp3.CipherSuite[] APPROVED_CIPHER_SUITES = {okhttp3.CipherSuite.TLS_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_CHACHA20_POLY1305_SHA256, okhttp3.CipherSuite.TLS_AES_128_CCM_SHA256, okhttp3.CipherSuite.TLS_AES_256_CCM_8_SHA256, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, okhttp3.CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final okhttp3.ConnectionSpec RESTRICTED_TLS = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(RESTRICTED_CIPHER_SUITES).tlsVersions(okhttp3.TlsVersion.TLS_1_3, okhttp3.TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    public static final okhttp3.ConnectionSpec MODERN_TLS = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(okhttp3.TlsVersion.TLS_1_3, okhttp3.TlsVersion.TLS_1_2, okhttp3.TlsVersion.TLS_1_1, okhttp3.TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final okhttp3.ConnectionSpec COMPATIBLE_TLS = new okhttp3.ConnectionSpec.Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(okhttp3.TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final okhttp3.ConnectionSpec CLEARTEXT = new okhttp3.ConnectionSpec.Builder(false).build();

    ConnectionSpec(okhttp3.ConnectionSpec.Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.tls;
    }

    @javax.annotation.Nullable
    public java.util.List<okhttp3.CipherSuite> cipherSuites() {
        java.lang.String[] strArr = this.cipherSuites;
        if (strArr != null) {
            return okhttp3.CipherSuite.forJavaNames(strArr);
        }
        return null;
    }

    @javax.annotation.Nullable
    public java.util.List<okhttp3.TlsVersion> tlsVersions() {
        java.lang.String[] strArr = this.tlsVersions;
        if (strArr != null) {
            return okhttp3.TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    void apply(javax.net.ssl.SSLSocket sSLSocket, boolean z_renamed) {
        okhttp3.ConnectionSpec connectionSpecSupportedSpec = supportedSpec(sSLSocket, z_renamed);
        java.lang.String[] strArr = connectionSpecSupportedSpec.tlsVersions;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        java.lang.String[] strArr2 = connectionSpecSupportedSpec.cipherSuites;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private okhttp3.ConnectionSpec supportedSpec(javax.net.ssl.SSLSocket sSLSocket, boolean z_renamed) {
        java.lang.String[] enabledCipherSuites;
        java.lang.String[] enabledProtocols;
        if (this.cipherSuites != null) {
            enabledCipherSuites = okhttp3.internal.Util.intersect(okhttp3.CipherSuite.ORDER_BY_NAME, sSLSocket.getEnabledCipherSuites(), this.cipherSuites);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersions != null) {
            enabledProtocols = okhttp3.internal.Util.intersect(okhttp3.internal.Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.tlsVersions);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        java.lang.String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iIndexOf = okhttp3.internal.Util.indexOf(okhttp3.CipherSuite.ORDER_BY_NAME, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z_renamed && iIndexOf != -1) {
            enabledCipherSuites = okhttp3.internal.Util.concat(enabledCipherSuites, supportedCipherSuites[iIndexOf]);
        }
        return new okhttp3.ConnectionSpec.Builder(this).cipherSuites(enabledCipherSuites).tlsVersions(enabledProtocols).build();
    }

    public boolean isCompatible(javax.net.ssl.SSLSocket sSLSocket) {
        if (!this.tls) {
            return false;
        }
        if (this.tlsVersions == null || okhttp3.internal.Util.nonEmptyIntersection(okhttp3.internal.Util.NATURAL_ORDER, this.tlsVersions, sSLSocket.getEnabledProtocols())) {
            return this.cipherSuites == null || okhttp3.internal.Util.nonEmptyIntersection(okhttp3.CipherSuite.ORDER_BY_NAME, this.cipherSuites, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        okhttp3.ConnectionSpec connectionSpec = (okhttp3.ConnectionSpec) obj;
        boolean z_renamed = this.tls;
        if (z_renamed != connectionSpec.tls) {
            return false;
        }
        return !z_renamed || (java.util.Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && java.util.Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public int hashCode() {
        if (this.tls) {
            return ((((527 + java.util.Arrays.hashCode(this.cipherSuites)) * 31) + java.util.Arrays.hashCode(this.tlsVersions)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public java.lang.String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.cipherSuites != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.tlsVersions != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public static final class Builder {

        @javax.annotation.Nullable
        java.lang.String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;

        @javax.annotation.Nullable
        java.lang.String[] tlsVersions;

        Builder(boolean z_renamed) {
            this.tls = z_renamed;
        }

        public Builder(okhttp3.ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public okhttp3.ConnectionSpec.Builder allEnabledCipherSuites() {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            this.cipherSuites = null;
            return this;
        }

        public okhttp3.ConnectionSpec.Builder cipherSuites(okhttp3.CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[cipherSuiteArr.length];
            for (int i_renamed = 0; i_renamed < cipherSuiteArr.length; i_renamed++) {
                strArr[i_renamed] = cipherSuiteArr[i_renamed].javaName;
            }
            return cipherSuites(strArr);
        }

        public okhttp3.ConnectionSpec.Builder cipherSuites(java.lang.String... strArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new java.lang.IllegalArgumentException("At least one cipher suite is_renamed required");
            }
            this.cipherSuites = (java.lang.String[]) strArr.clone();
            return this;
        }

        public okhttp3.ConnectionSpec.Builder allEnabledTlsVersions() {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            this.tlsVersions = null;
            return this;
        }

        public okhttp3.ConnectionSpec.Builder tlsVersions(okhttp3.TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[tlsVersionArr.length];
            for (int i_renamed = 0; i_renamed < tlsVersionArr.length; i_renamed++) {
                strArr[i_renamed] = tlsVersionArr[i_renamed].javaName;
            }
            return tlsVersions(strArr);
        }

        public okhttp3.ConnectionSpec.Builder tlsVersions(java.lang.String... strArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new java.lang.IllegalArgumentException("At least one TLS version is_renamed required");
            }
            this.tlsVersions = (java.lang.String[]) strArr.clone();
            return this;
        }

        public okhttp3.ConnectionSpec.Builder supportsTlsExtensions(boolean z_renamed) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = z_renamed;
            return this;
        }

        public okhttp3.ConnectionSpec build() {
            return new okhttp3.ConnectionSpec(this);
        }
    }
}
