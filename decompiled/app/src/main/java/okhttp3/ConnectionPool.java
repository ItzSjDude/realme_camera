package okhttp3;

/* loaded from: classes2.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.concurrent.Executor executor = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp ConnectionPool", true));
    private final java.lang.Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final java.util.Deque<okhttp3.internal.connection.RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final okhttp3.internal.connection.RouteDatabase routeDatabase;

    public ConnectionPool() {
        this(5, 5L, java.util.concurrent.TimeUnit.MINUTES);
    }

    public ConnectionPool(int i_renamed, long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        this.cleanupRunnable = new java.lang.Runnable() { // from class: okhttp3.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() throws java.io.IOException {
                while (true) {
                    long jCleanup = okhttp3.ConnectionPool.this.cleanup(java.lang.System.nanoTime());
                    if (jCleanup == -1) {
                        return;
                    }
                    if (jCleanup > 0) {
                        long j2 = jCleanup / 1000000;
                        long j3 = jCleanup - (1000000 * j2);
                        synchronized (okhttp3.ConnectionPool.this) {
                            try {
                                okhttp3.ConnectionPool.this.wait(j2, (int) j3);
                            } catch (java.lang.InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new java.util.ArrayDeque();
        this.routeDatabase = new okhttp3.internal.connection.RouteDatabase();
        this.maxIdleConnections = i_renamed;
        this.keepAliveDurationNs = timeUnit.toNanos(j_renamed);
        if (j_renamed > 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keepAliveDuration <= 0: " + j_renamed);
    }

    public synchronized int idleConnectionCount() {
        int i_renamed;
        i_renamed = 0;
        java.util.Iterator<okhttp3.internal.connection.RealConnection> it = this.connections.iterator();
        while (it.hasNext()) {
            if (it.next().allocations.isEmpty()) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    @javax.annotation.Nullable
    okhttp3.internal.connection.RealConnection get(okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.Route route) {
        for (okhttp3.internal.connection.RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, route)) {
                streamAllocation.acquire(realConnection, true);
                return realConnection;
            }
        }
        return null;
    }

    @javax.annotation.Nullable
    java.net.Socket deduplicate(okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation) {
        for (okhttp3.internal.connection.RealConnection realConnection : this.connections) {
            if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                return streamAllocation.releaseAndAcquire(realConnection);
            }
        }
        return null;
    }

    void put(okhttp3.internal.connection.RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    boolean connectionBecameIdle(okhttp3.internal.connection.RealConnection realConnection) {
        if (realConnection.noNewStreams || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public void evictAll() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<okhttp3.internal.connection.RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                okhttp3.internal.connection.RealConnection next = it.next();
                if (next.allocations.isEmpty()) {
                    next.noNewStreams = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            okhttp3.internal.Util.closeQuietly(((okhttp3.internal.connection.RealConnection) it2.next()).socket());
        }
    }

    long cleanup(long j_renamed) throws java.io.IOException {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            int i_renamed = 0;
            okhttp3.internal.connection.RealConnection realConnection = null;
            int i2 = 0;
            for (okhttp3.internal.connection.RealConnection realConnection2 : this.connections) {
                if (pruneAndGetAllocationCount(realConnection2, j_renamed) > 0) {
                    i_renamed++;
                } else {
                    i2++;
                    long j3 = j_renamed - realConnection2.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = realConnection2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs && i2 <= this.maxIdleConnections) {
                if (i2 > 0) {
                    return this.keepAliveDurationNs - j2;
                }
                if (i_renamed > 0) {
                    return this.keepAliveDurationNs;
                }
                this.cleanupRunning = false;
                return -1L;
            }
            this.connections.remove(realConnection);
            okhttp3.internal.Util.closeQuietly(realConnection.socket());
            return 0L;
        }
    }

    private int pruneAndGetAllocationCount(okhttp3.internal.connection.RealConnection realConnection, long j_renamed) {
        java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation>> list = realConnection.allocations;
        int i_renamed = 0;
        while (i_renamed < list.size()) {
            java.lang.ref.Reference<okhttp3.internal.connection.StreamAllocation> reference = list.get(i_renamed);
            if (reference.get() != null) {
                i_renamed++;
            } else {
                okhttp3.internal.platform.Platform.get().logCloseableLeak("A_renamed connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a_renamed response body?", ((okhttp3.internal.connection.StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                list.remove(i_renamed);
                realConnection.noNewStreams = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j_renamed - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
