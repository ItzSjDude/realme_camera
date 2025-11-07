package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class WaveformEffectNative {
    public static int EFFECT_ALARM_NOTIFICATION = 0;
    private static final java.lang.String TAG = "WaveformEffectNative";

    private static java.lang.Object initForQ() {
        return null;
    }

    static {
        if (android.os.Build.VERSION.SDK_INT == 29) {
            EFFECT_ALARM_NOTIFICATION = ((java.lang.Integer) initForQ()).intValue();
        } else {
            android.util.Log.e_renamed(TAG, "only support before Q_renamed");
        }
    }
}
