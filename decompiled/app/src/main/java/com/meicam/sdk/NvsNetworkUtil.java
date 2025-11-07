package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsNetworkUtil {
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_WIFI = 1;

    public static final int getNetWorkStates(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? -1 : 1;
        }
        return 0;
    }
}
