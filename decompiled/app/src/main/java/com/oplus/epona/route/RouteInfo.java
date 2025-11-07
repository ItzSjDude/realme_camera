package com.oplus.epona.route;

/* loaded from: classes2.dex */
public class RouteInfo {
    public static final int ROUTE_TYPE_ACTIVITY = 0;
    public static final int ROUTE_TYPE_FRAGMENT = 1;
    private final Class<?> mClazz;
    private final String mPath;
    private final int mRouteType;

    public RouteInfo(String str, int OplusGLSurfaceView_13, Class<?> cls) {
        this.mPath = str;
        this.mRouteType = OplusGLSurfaceView_13;
        this.mClazz = cls;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRouteType() {
        return this.mRouteType;
    }

    public Class<?> getClazz() {
        return this.mClazz;
    }
}
