package okhttp3;

/* loaded from: classes2.dex */
public final class Address {

    @javax.annotation.Nullable
    final okhttp3.CertificatePinner certificatePinner;
    final java.util.List<okhttp3.ConnectionSpec> connectionSpecs;
    final okhttp3.Dns dns;

    @javax.annotation.Nullable
    final javax.net.ssl.HostnameVerifier hostnameVerifier;
    final java.util.List<okhttp3.Protocol> protocols;

    @javax.annotation.Nullable
    final java.net.Proxy proxy;
    final okhttp3.Authenticator proxyAuthenticator;
    final java.net.ProxySelector proxySelector;
    final javax.net.SocketFactory socketFactory;

    @javax.annotation.Nullable
    final javax.net.ssl.SSLSocketFactory sslSocketFactory;
    final okhttp3.HttpUrl url;

    public Address(java.lang.String str, int i_renamed, okhttp3.Dns dns, javax.net.SocketFactory socketFactory, @javax.annotation.Nullable javax.net.ssl.SSLSocketFactory sSLSocketFactory, @javax.annotation.Nullable javax.net.ssl.HostnameVerifier hostnameVerifier, @javax.annotation.Nullable okhttp3.CertificatePinner certificatePinner, okhttp3.Authenticator authenticator, @javax.annotation.Nullable java.net.Proxy proxy, java.util.List<okhttp3.Protocol> list, java.util.List<okhttp3.ConnectionSpec> list2, java.net.ProxySelector proxySelector) {
        this.url = new okhttp3.HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i_renamed).build();
        if (dns == null) {
            throw new java.lang.NullPointerException("dns == null");
        }
        this.dns = dns;
        if (socketFactory == null) {
            throw new java.lang.NullPointerException("socketFactory == null");
        }
        this.socketFactory = socketFactory;
        if (authenticator == null) {
            throw new java.lang.NullPointerException("proxyAuthenticator == null");
        }
        this.proxyAuthenticator = authenticator;
        if (list == null) {
            throw new java.lang.NullPointerException("protocols == null");
        }
        this.protocols = okhttp3.internal.Util.immutableList(list);
        if (list2 == null) {
            throw new java.lang.NullPointerException("connectionSpecs == null");
        }
        this.connectionSpecs = okhttp3.internal.Util.immutableList(list2);
        if (proxySelector == null) {
            throw new java.lang.NullPointerException("proxySelector == null");
        }
        this.proxySelector = proxySelector;
        this.proxy = proxy;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
    }

    public okhttp3.HttpUrl url() {
        return this.url;
    }

    public okhttp3.Dns dns() {
        return this.dns;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public java.util.List<okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    public java.util.List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public java.net.ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @javax.annotation.Nullable
    public java.net.Proxy proxy() {
        return this.proxy;
    }

    @javax.annotation.Nullable
    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @javax.annotation.Nullable
    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @javax.annotation.Nullable
    public okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof okhttp3.Address) {
            okhttp3.Address address = (okhttp3.Address) obj;
            if (this.url.equals(address.url) && equalsNonHost(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31;
        java.net.Proxy proxy = this.proxy;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        javax.net.ssl.HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        okhttp3.CertificatePinner certificatePinner = this.certificatePinner;
        return iHashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    boolean equalsNonHost(okhttp3.Address address) {
        return this.dns.equals(address.dns) && this.proxyAuthenticator.equals(address.proxyAuthenticator) && this.protocols.equals(address.protocols) && this.connectionSpecs.equals(address.connectionSpecs) && this.proxySelector.equals(address.proxySelector) && okhttp3.internal.Util.equal(this.proxy, address.proxy) && okhttp3.internal.Util.equal(this.sslSocketFactory, address.sslSocketFactory) && okhttp3.internal.Util.equal(this.hostnameVerifier, address.hostnameVerifier) && okhttp3.internal.Util.equal(this.certificatePinner, address.certificatePinner) && url().port() == address.url().port();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Address{");
        sb.append(this.url.host());
        sb.append(":");
        sb.append(this.url.port());
        if (this.proxy != null) {
            sb.append(", proxy=");
            sb.append(this.proxy);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.proxySelector);
        }
        sb.append("}");
        return sb.toString();
    }
}
