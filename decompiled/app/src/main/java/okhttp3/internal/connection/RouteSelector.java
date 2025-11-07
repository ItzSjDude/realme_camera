package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class RouteSelector {
    private final okhttp3.Address address;
    private final okhttp3.Call call;
    private final okhttp3.EventListener eventListener;
    private int nextProxyIndex;
    private final okhttp3.internal.connection.RouteDatabase routeDatabase;
    private java.util.List<java.net.Proxy> proxies = java.util.Collections.emptyList();
    private java.util.List<java.net.InetSocketAddress> inetSocketAddresses = java.util.Collections.emptyList();
    private final java.util.List<okhttp3.Route> postponedRoutes = new java.util.ArrayList();

    public RouteSelector(okhttp3.Address address, okhttp3.internal.connection.RouteDatabase routeDatabase, okhttp3.Call call, okhttp3.EventListener eventListener) {
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        resetNextProxy(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public okhttp3.internal.connection.RouteSelector.Selection next() throws java.io.IOException {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (hasNextProxy()) {
            java.net.Proxy proxyNextProxy = nextProxy();
            int size = this.inetSocketAddresses.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                okhttp3.Route route = new okhttp3.Route(this.address, proxyNextProxy, this.inetSocketAddresses.get(i_renamed));
                if (this.routeDatabase.shouldPostpone(route)) {
                    this.postponedRoutes.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new okhttp3.internal.connection.RouteSelector.Selection(arrayList);
    }

    public void connectFailed(okhttp3.Route route, java.io.IOException iOException) {
        if (route.proxy().type() != java.net.Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    private void resetNextProxy(okhttp3.HttpUrl httpUrl, java.net.Proxy proxy) {
        java.util.List<java.net.Proxy> listImmutableList;
        if (proxy != null) {
            this.proxies = java.util.Collections.singletonList(proxy);
        } else {
            java.util.List<java.net.Proxy> listSelect = this.address.proxySelector().select(httpUrl.uri());
            if (listSelect != null && !listSelect.isEmpty()) {
                listImmutableList = okhttp3.internal.Util.immutableList(listSelect);
            } else {
                listImmutableList = okhttp3.internal.Util.immutableList(java.net.Proxy.NO_PROXY);
            }
            this.proxies = listImmutableList;
        }
        this.nextProxyIndex = 0;
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private java.net.Proxy nextProxy() throws java.io.IOException {
        if (!hasNextProxy()) {
            throw new java.net.SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        java.util.List<java.net.Proxy> list = this.proxies;
        int i_renamed = this.nextProxyIndex;
        this.nextProxyIndex = i_renamed + 1;
        java.net.Proxy proxy = list.get(i_renamed);
        resetNextInetSocketAddress(proxy);
        return proxy;
    }

    private void resetNextInetSocketAddress(java.net.Proxy proxy) throws java.io.IOException {
        java.lang.String strHost;
        int iPort;
        this.inetSocketAddresses = new java.util.ArrayList();
        if (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.SOCKS) {
            strHost = this.address.url().host();
            iPort = this.address.url().port();
        } else {
            java.net.SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof java.net.InetSocketAddress)) {
                throw new java.lang.IllegalArgumentException("Proxy.address() is_renamed not an_renamed InetSocketAddress: " + socketAddressAddress.getClass());
            }
            java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) socketAddressAddress;
            strHost = getHostString(inetSocketAddress);
            iPort = inetSocketAddress.getPort();
        }
        if (iPort < 1 || iPort > 65535) {
            throw new java.net.SocketException("No route to " + strHost + ":" + iPort + "; port is_renamed out of_renamed range");
        }
        if (proxy.type() == java.net.Proxy.Type.SOCKS) {
            this.inetSocketAddresses.add(java.net.InetSocketAddress.createUnresolved(strHost, iPort));
            return;
        }
        this.eventListener.dnsStart(this.call, strHost);
        java.util.List<java.net.InetAddress> listLookup = this.address.dns().lookup(strHost);
        if (listLookup.isEmpty()) {
            throw new java.net.UnknownHostException(this.address.dns() + " returned no addresses for " + strHost);
        }
        this.eventListener.dnsEnd(this.call, strHost, listLookup);
        int size = listLookup.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.inetSocketAddresses.add(new java.net.InetSocketAddress(listLookup.get(i_renamed), iPort));
        }
    }

    static java.lang.String getHostString(java.net.InetSocketAddress inetSocketAddress) {
        java.net.InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class Selection {
        private int nextRouteIndex = 0;
        private final java.util.List<okhttp3.Route> routes;

        Selection(java.util.List<okhttp3.Route> list) {
            this.routes = list;
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public okhttp3.Route next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.util.List<okhttp3.Route> list = this.routes;
            int i_renamed = this.nextRouteIndex;
            this.nextRouteIndex = i_renamed + 1;
            return list.get(i_renamed);
        }

        public java.util.List<okhttp3.Route> getAll() {
            return new java.util.ArrayList(this.routes);
        }
    }
}
