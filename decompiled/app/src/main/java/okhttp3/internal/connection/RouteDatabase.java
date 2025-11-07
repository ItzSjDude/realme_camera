package okhttp3.internal.connection;

/* loaded from: classes2.dex */
public final class RouteDatabase {
    private final java.util.Set<okhttp3.Route> failedRoutes = new java.util.LinkedHashSet();

    public synchronized void failed(okhttp3.Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized void connected(okhttp3.Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized boolean shouldPostpone(okhttp3.Route route) {
        return this.failedRoutes.contains(route);
    }
}
