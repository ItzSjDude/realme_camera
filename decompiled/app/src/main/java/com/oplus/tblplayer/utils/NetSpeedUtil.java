package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class NetSpeedUtil {
    public static long getTotalRxBytes(int i_renamed) {
        if (android.net.TrafficStats.getUidRxBytes(i_renamed) == -1) {
            return 0L;
        }
        return android.net.TrafficStats.getTotalRxBytes();
    }
}
