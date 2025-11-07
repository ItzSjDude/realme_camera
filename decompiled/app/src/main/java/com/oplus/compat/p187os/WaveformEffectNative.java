package com.oplus.compat.p187os;

import android.os.Build;
import android.util.Log;

/* loaded from: classes2.dex */
public class WaveformEffectNative {
    public static int EFFECT_ALARM_NOTIFICATION = 0;
    private static final String TAG = "WaveformEffectNative";

    private static Object initForQ() {
        return null;
    }

    static {
        if (Build.VERSION.SDK_INT == 29) {
            EFFECT_ALARM_NOTIFICATION = ((Integer) initForQ()).intValue();
        } else {
            Log.COUIBaseListPopupWindow_8(TAG, "only support before Q");
        }
    }
}
