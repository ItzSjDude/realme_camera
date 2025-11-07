package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final okhttp3.Address address;
    public final okhttp3.Call call;
    private final java.lang.Object callStackTrace;
    private boolean canceled;
    private okhttp3.internal.http.HttpCodec codec;
    private okhttp3.internal.connection.RealConnection connection;
    private final okhttp3.ConnectionPool connectionPool;
    public final okhttp3.EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private okhttp3.Route route;
    private okhttp3.internal.connection.RouteSelector.Selection routeSelection;
    private final okhttp3.internal.connection.RouteSelector routeSelector;

    public StreamAllocation(okhttp3.ConnectionPool connectionPool, okhttp3.Address address, okhttp3.Call call, okhttp3.EventListener eventListener, java.lang.Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new okhttp3.internal.connection.RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    public okhttp3.internal.http.HttpCodec newStream(okhttp3.OkHttpClient okHttpClient, okhttp3.Interceptor.Chain chain, boolean z_renamed) {
        try {
            okhttp3.internal.http.HttpCodec httpCodecNewCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z_renamed).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = httpCodecNewCodec;
            }
            return httpCodecNewCodec;
        } catch (java.io.IOException e_renamed) {
            throw new okhttp3.internal.connection.RouteException(e_renamed);
        }
    }

    private okhttp3.internal.connection.RealConnection findHealthyConnection(int i_renamed, int i2, int i3, int i4, boolean z_renamed, boolean z2) throws java.lang.Throwable {
        while (true) {
            okhttp3.internal.connection.RealConnection realConnectionFindConnection = findConnection(i_renamed, i2, i3, i4, z_renamed);
            synchronized (this.connectionPool) {
                if (realConnectionFindConnection.successCount == 0) {
                    return realConnectionFindConnection;
                }
                if (realConnectionFindConnection.isHealthy(z2)) {
                    return realConnectionFindConnection;
                }
                noNewStreams();
            }
        }
    }

    private okhttp3.internal.connection.RealConnection findConnection(int i_renamed, int i2, int i3, int i4, boolean z_renamed) throws java.lang.Throwable {
        java.net.Socket socketReleaseIfNoNewStreams;
        java.net.Socket socketDeduplicate;
        okhttp3.internal.connection.RealConnection realConnection;
        okhttp3.internal.connection.RealConnection realConnection2;
        okhttp3.internal.connection.RealConnection realConnection3;
        okhttp3.Route next;
        boolean z2;
        boolean z3;
        okhttp3.internal.connection.RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new java.lang.IllegalStateException("released");
            }
            if (this.codec != null) {
                throw new java.lang.IllegalStateException("codec != null");
            }
            if (this.canceled) {
                throw new java.io.IOException("Canceled");
            }
            okhttp3.internal.connection.RealConnection realConnection4 = this.connection;
            socketReleaseIfNoNewStreams = releaseIfNoNewStreams();
            socketDeduplicate = null;
            if (this.connection != null) {
                realConnection2 = this.connection;
                realConnection = null;
            } else {
                realConnection = realConnection4;
                realConnection2 = null;
            }
            if (!this.reportedAcquired) {
                realConnection = null;
            }
            if (realConnection2 == null) {
                okhttp3.internal.Internal.instance.get(this.connectionPool, this.address, this, null);
                if (this.connection != null) {
                    realConnection3 = this.connection;
                    next = null;
                    z2 = true;
                } else {
                    next = this.route;
                    realConnection3 = realConnection2;
                }
            } else {
                realConnection3 = realConnection2;
                next = null;
            }
            z2 = false;
        }
        okhttp3.internal.Util.closeQuietly(socketReleaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
        }
        if (realConnection3 != null) {
            return realConnection3;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (this.canceled) {
                throw new java.io.IOException("Canceled");
            }
            if (z3) {
                java.util.List<okhttp3.Route> all = this.routeSelection.getAll();
                int size = all.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    okhttp3.Route route = all.get(i5);
                    okhttp3.internal.Internal.instance.get(this.connectionPool, this.address, this, route);
                    if (this.connection != null) {
                        realConnection3 = this.connection;
                        this.route = route;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (next == null) {
                    next = this.routeSelection.next();
                }
                this.route = next;
                this.refusedStreamCount = 0;
                realConnection3 = new okhttp3.internal.connection.RealConnection(this.connectionPool, next);
                acquire(realConnection3, false);
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i_renamed, i2, i3, i4, z_renamed, this.call, this.eventListener);
        routeDatabase().connected(realConnection3.route());
        synchronized (this.connectionPool) {
            this.reportedAcquired = true;
            okhttp3.internal.Internal.instance.put(this.connectionPool, realConnection3);
            if (realConnection3.isMultiplexed()) {
                socketDeduplicate = okhttp3.internal.Internal.instance.deduplicate(this.connectionPool, this.address, this);
                realConnection3 = this.connection;
            }
        }
        okhttp3.internal.Util.closeQuietly(socketDeduplicate);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    private java.net.Socket releaseIfNoNewStreams() {
        okhttp3.internal.connection.RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    public void streamFinished(boolean z_renamed, okhttp3.internal.http.HttpCodec httpCodec, long j_renamed, java.io.IOException iOException) {
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j_renamed);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z_renamed) {
                        this.connection.successCount++;
                    }
                    realConnection = this.connection;
                    socketDeallocate = deallocate(z_renamed, false, true);
                    if (this.connection != null) {
                        realConnection = null;
                    }
                    z2 = this.released;
                }
            }
            throw new java.lang.IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, okhttp3.internal.Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            okhttp3.internal.Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public okhttp3.internal.http.HttpCodec codec() {
        okhttp3.internal.http.HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private okhttp3.internal.connection.RouteDatabase routeDatabase() {
        return okhttp3.internal.Internal.instance.routeDatabase(this.connectionPool);
    }

    public okhttp3.Route route() {
        return this.route;
    }

    public synchronized okhttp3.internal.connection.RealConnection connection() {
        return this.connection;
    }

    public void release() throws java.io.IOException {
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            okhttp3.internal.Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public void noNewStreams() throws java.io.IOException {
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.Socket deallocate(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            r0 = 0
            if (r4 == 0) goto L5
            r1.codec = r0
        L5:
            r4 = 1
            if (r3 == 0) goto La
            r1.released = r4
        La:
            okhttp3.internal.connection.RealConnection r3 = r1.connection
            if (r3 == 0) goto L4e
            if (r2 == 0) goto L12
            r3.noNewStreams = r4
        L12:
            okhttp3.internal.http.HttpCodec r2 = r1.codec
            if (r2 != 0) goto L4e
            boolean r2 = r1.released
            if (r2 != 0) goto L20
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            boolean r2 = r2.noNewStreams
            if (r2 == 0) goto L4e
        L20:
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            r1.release(r2)
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation>> r2 = r2.allocations
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            long r3 = java.lang.System.nanoTime()
            r2.idleAtNanos = r3
            okhttp3.internal.Internal r2 = okhttp3.internal.Internal.instance
            okhttp3.ConnectionPool r3 = r1.connectionPool
            okhttp3.internal.connection.RealConnection r4 = r1.connection
            boolean r2 = r2.connectionBecameIdle(r3, r4)
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            java.net.Socket r2 = r2.socket()
            goto L4b
        L4a:
            r2 = r0
        L4b:
            r1.connection = r0
            goto L4f
        L4e:
            r2 = r0
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.deallocate(boolean, boolean, boolean):java.net.Socket");
    }

    public void cancel() throws java.io.IOException {
        okhttp3.internal.http.HttpCodec httpCodec;
        okhttp3.internal.connection.RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void streamFailed(java.io.IOException iOException) throws java.io.IOException {
        boolean z_renamed;
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socketDeallocate;
        synchronized (this.connectionPool) {
            if (iOException instanceof okhttp3.internal.http2.StreamResetException) {
                okhttp3.internal.http2.ErrorCode errorCode = ((okhttp3.internal.http2.StreamResetException) iOException).errorCode;
                if (errorCode == okhttp3.internal.http2.ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                    if (this.refusedStreamCount > 1) {
                        this.route = null;
                        z_renamed = true;
                    }
                    z_renamed = false;
                } else {
                    if (errorCode != okhttp3.internal.http2.ErrorCode.CANCEL) {
                        this.route = null;
                        z_renamed = true;
                    }
                    z_renamed = false;
                }
            } else {
                if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof okhttp3.internal.http2.ConnectionShutdownException))) {
                    if (this.connection.successCount == 0) {
                        if (this.route != null && iOException != null) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                    z_renamed = true;
                }
                z_renamed = false;
            }
            realConnection = this.connection;
            socketDeallocate = deallocate(z_renamed, false, true);
            if (this.connection != null || !this.reportedAcquired) {
                realConnection = null;
            }
        }
        okhttp3.internal.Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void acquire(okhttp3.internal.connection.RealConnection realConnection, boolean z_renamed) {
        if (this.connection != null) {
            throw new java.lang.IllegalStateException();
        }
        this.connection = realConnection;
        this.reportedAcquired = z_renamed;
        realConnection.allocations.add(new okhttp3.internal.connection.StreamAllocation.StreamAllocationReference(this, this.callStackTrace));
    }

    private void release(okhttp3.internal.connection.RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (realConnection.allocations.get(i_renamed).get() == this) {
                realConnection.allocations.remove(i_renamed);
                return;
            }
        }
        throw new java.lang.IllegalStateException();
    }

    public java.net.Socket releaseAndAcquire(okhttp3.internal.connection.RealConnection realConnection) {
        if (this.codec != null || this.connection.allocations.size() != 1) {
            throw new java.lang.IllegalStateException();
        }
        java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation> reference = this.connection.allocations.get(0);
        java.net.Socket socketDeallocate = deallocate(true, false, false);
        this.connection = realConnection;
        realConnection.allocations.add(reference);
        return socketDeallocate;
    }

    public boolean hasMoreRoutes() {
        okhttp3.internal.connection.RouteSelector.Selection selection;
        return this.route != null || ((selection = this.routeSelection) != null && selection.hasNext()) || this.routeSelector.hasNext();
    }

    public java.lang.String toString() {
        okhttp3.internal.connection.RealConnection realConnectionConnection = connection();
        return realConnectionConnection != null ? realConnectionConnection.toString() : this.address.toString();
    }

    public static final class StreamAllocationReference extends java.lang.ref.WeakReference<okhttp3.internal.connection.StreamAllocation> {
        public final java.lang.Object callStackTrace;

        StreamAllocationReference(okhttp3.internal.connection.StreamAllocation streamAllocation, java.lang.Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }
}
