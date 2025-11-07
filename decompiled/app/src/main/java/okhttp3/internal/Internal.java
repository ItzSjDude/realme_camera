package okhttp3.internal;

/* loaded from: classes2.dex */
public abstract class Internal {
    public static okhttp3.internal.Internal instance;

    public abstract void addLenient(okhttp3.Headers.Builder builder, java.lang.String str);

    public abstract void addLenient(okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2);

    public abstract void apply(okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z_renamed);

    public abstract int code(okhttp3.Response.Builder builder);

    public abstract boolean connectionBecameIdle(okhttp3.ConnectionPool connectionPool, okhttp3.internal.connection.RealConnection realConnection);

    public abstract java.net.Socket deduplicate(okhttp3.ConnectionPool connectionPool, okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation);

    public abstract boolean equalsNonHost(okhttp3.Address address, okhttp3.Address address2);

    public abstract okhttp3.internal.connection.RealConnection get(okhttp3.ConnectionPool connectionPool, okhttp3.Address address, okhttp3.internal.connection.StreamAllocation streamAllocation, okhttp3.Route route);

    public abstract boolean isInvalidHttpUrlHost(java.lang.IllegalArgumentException illegalArgumentException);

    public abstract okhttp3.Call newWebSocketCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request);

    public abstract void put(okhttp3.ConnectionPool connectionPool, okhttp3.internal.connection.RealConnection realConnection);

    public abstract okhttp3.internal.connection.RouteDatabase routeDatabase(okhttp3.ConnectionPool connectionPool);

    public abstract void setCache(okhttp3.OkHttpClient.Builder builder, okhttp3.internal.cache.InternalCache internalCache);

    public abstract okhttp3.internal.connection.StreamAllocation streamAllocation(okhttp3.Call call);

    @javax.annotation.Nullable
    public abstract java.io.IOException timeoutExit(okhttp3.Call call, @javax.annotation.Nullable java.io.IOException iOException);

    public static void initializeInstanceForTests() {
        new okhttp3.OkHttpClient();
    }
}
