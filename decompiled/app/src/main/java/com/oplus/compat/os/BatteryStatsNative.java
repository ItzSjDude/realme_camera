package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class BatteryStatsNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.BatteryStats";
    private static final java.lang.String RESULT = "result";
    public static int STATS_SINCE_CHARGED = 0;
    private static final java.lang.String TAG = "BatteryStatsNative";

    private BatteryStatsNative() {
    }

    static {
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                STATS_SINCE_CHARGED = getStatsSinceCharged();
                return;
            }
            throw new java.lang.UnsupportedOperationException("not support before Q_renamed");
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed(TAG, th.toString());
        }
    }

    private static int getStatsSinceCharged() {
        if (!com.oplus.compat.b_renamed.a_renamed.c_renamed.a_renamed()) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                return 0;
            }
            android.util.Log.e_renamed(TAG, "not supported before Q_renamed");
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("STATS_SINCE_CHARGED").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            android.util.Log.e_renamed(TAG, "STATS_SINCE_CHARGED is_renamed not connected with Epona");
        }
        return 0;
    }
}
