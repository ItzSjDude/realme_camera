package okhttp3;

/* loaded from: classes2.dex */
public final class Handshake {
    private final okhttp3.CipherSuite cipherSuite;
    private final java.util.List<java.security.cert.Certificate> localCertificates;
    private final java.util.List<java.security.cert.Certificate> peerCertificates;
    private final okhttp3.TlsVersion tlsVersion;

    private Handshake(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public static okhttp3.Handshake get(javax.net.ssl.SSLSession sSLSession) throws java.io.IOException {
        java.security.cert.Certificate[] peerCertificates;
        java.util.List listEmptyList;
        java.util.List listEmptyList2;
        java.lang.String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new java.lang.IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new java.io.IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        okhttp3.CipherSuite cipherSuiteForJavaName = okhttp3.CipherSuite.forJavaName(cipherSuite);
        java.lang.String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new java.lang.IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new java.io.IOException("tlsVersion == NONE");
        }
        okhttp3.TlsVersion tlsVersionForJavaName = okhttp3.TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = okhttp3.internal.Util.immutableList(peerCertificates);
        } else {
            listEmptyList = java.util.Collections.emptyList();
        }
        java.security.cert.Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = okhttp3.internal.Util.immutableList(localCertificates);
        } else {
            listEmptyList2 = java.util.Collections.emptyList();
        }
        return new okhttp3.Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, listEmptyList, listEmptyList2);
    }

    public static okhttp3.Handshake get(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        if (tlsVersion == null) {
            throw new java.lang.NullPointerException("tlsVersion == null");
        }
        if (cipherSuite == null) {
            throw new java.lang.NullPointerException("cipherSuite == null");
        }
        return new okhttp3.Handshake(tlsVersion, cipherSuite, okhttp3.internal.Util.immutableList(list), okhttp3.internal.Util.immutableList(list2));
    }

    public okhttp3.TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public okhttp3.CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public java.util.List<java.security.cert.Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    @javax.annotation.Nullable
    public java.security.Principal peerPrincipal() {
        if (this.peerCertificates.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.peerCertificates.get(0)).getSubjectX500Principal();
    }

    public java.util.List<java.security.cert.Certificate> localCertificates() {
        return this.localCertificates;
    }

    @javax.annotation.Nullable
    public java.security.Principal localPrincipal() {
        if (this.localCertificates.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.localCertificates.get(0)).getSubjectX500Principal();
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof okhttp3.Handshake)) {
            return false;
        }
        okhttp3.Handshake handshake = (okhttp3.Handshake) obj;
        return this.tlsVersion.equals(handshake.tlsVersion) && this.cipherSuite.equals(handshake.cipherSuite) && this.peerCertificates.equals(handshake.peerCertificates) && this.localCertificates.equals(handshake.localCertificates);
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + this.peerCertificates.hashCode()) * 31) + this.localCertificates.hashCode();
    }
}
