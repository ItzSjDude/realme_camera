package okhttp3;

/* loaded from: classes2.dex */
public final class Route {
    final okhttp3.Address address;
    final java.net.InetSocketAddress inetSocketAddress;
    final java.net.Proxy proxy;

    public Route(okhttp3.Address address, java.net.Proxy proxy, java.net.InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new java.lang.NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new java.lang.NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new java.lang.NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
    }

    public okhttp3.Address address() {
        return this.address;
    }

    public java.net.Proxy proxy() {
        return this.proxy;
    }

    public java.net.InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == java.net.Proxy.Type.HTTP;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof okhttp3.Route) {
            okhttp3.Route route = (okhttp3.Route) obj;
            if (route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public java.lang.String toString() {
        return "Route{" + this.inetSocketAddress + "}";
    }
}
