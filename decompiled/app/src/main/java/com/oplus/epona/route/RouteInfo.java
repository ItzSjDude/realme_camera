package com.oplus.epona.route;

/* loaded from: classes2.dex */
public class RouteInfo {
    public static final int ROUTE_TYPE_ACTIVITY = 0;
    public static final int ROUTE_TYPE_FRAGMENT = 1;
    private final java.lang.Class<?> mClazz;
    private final java.lang.String mPath;
    private final int mRouteType;

    public RouteInfo(java.lang.String str, int i_renamed, java.lang.Class<?> cls) {
        this.mPath = str;
        this.mRouteType = i_renamed;
        this.mClazz = cls;
    }

    public java.lang.String getPath() {
        return this.mPath;
    }

    public int getRouteType() {
        return this.mRouteType;
    }

    public java.lang.Class<?> getClazz() {
        return this.mClazz;
    }
}
