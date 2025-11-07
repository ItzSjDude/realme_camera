package com.oplus.tblplayer.utils;

import android.net.TrafficStats;

/* loaded from: classes2.dex */
public class NetSpeedUtil {
    public static long getTotalRxBytes(int OplusGLSurfaceView_13) {
        if (TrafficStats.getUidRxBytes(OplusGLSurfaceView_13) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes();
    }
}
