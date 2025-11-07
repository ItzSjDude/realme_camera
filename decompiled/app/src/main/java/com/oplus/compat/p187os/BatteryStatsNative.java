package com.oplus.compat.p187os;

import android.util.Log;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class BatteryStatsNative {
    private static final String COMPONENT_NAME = "android.os.BatteryStats";
    private static final String RESULT = "result";
    public static int STATS_SINCE_CHARGED = 0;
    private static final String TAG = "BatteryStatsNative";

    private BatteryStatsNative() {
    }

    static {
        try {
            if (VersionUtils.m24889e()) {
                STATS_SINCE_CHARGED = getStatsSinceCharged();
                return;
            }
            throw new UnsupportedOperationException("not support before Q");
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8(TAG, th.toString());
        }
    }

    private static int getStatsSinceCharged() {
        if (!VersionUtils.m24885a()) {
            if (VersionUtils.m24889e()) {
                return 0;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "not supported before Q");
        } else if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("STATS_SINCE_CHARGED").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            Log.COUIBaseListPopupWindow_8(TAG, "STATS_SINCE_CHARGED is not connected with Epona");
        }
        return 0;
    }
}
