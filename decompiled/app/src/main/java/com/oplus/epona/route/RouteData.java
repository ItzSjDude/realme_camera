package com.oplus.epona.route;

import android.content.Context;

/* loaded from: classes2.dex */
public class RouteData {
    private final Context mContext;
    private final int mRequestCode;

    public RouteData(Context context, int OplusGLSurfaceView_13) {
        this.mContext = context;
        this.mRequestCode = OplusGLSurfaceView_13;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }
}
