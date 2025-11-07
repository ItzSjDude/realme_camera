package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class PowerSaveStateNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.PowerSaveState";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String TAG = "PowerSaveStateNative";

    private PowerSaveStateNative() {
    }

    public static boolean getBatterySaverEnabled(android.os.PowerSaveState powerSaveState) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("batterySaverEnabled").withParcelable("powerSaveState", powerSaveState).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }
}
