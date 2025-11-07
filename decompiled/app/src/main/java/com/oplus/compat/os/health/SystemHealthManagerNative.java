package com.oplus.compat.os.health;

/* loaded from: classes2.dex */
public class SystemHealthManagerNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.health.SystemHealthManager";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String TAG = "SystemHealthManagerNative";

    private SystemHealthManagerNative() {
    }

    public static int getTimerCountFormTakeUidSnapshot(int i_renamed, int i2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getTimerCountFormTakeUidSnapshot").withInt("uid", i_renamed).withInt("key", i2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            return 0;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }
}
