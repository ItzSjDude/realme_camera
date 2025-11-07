package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class BuildNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.Build";

    private BuildNative() {
    }

    public static java.lang.String getSerial() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getSerial").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getString("result");
            }
            return null;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
