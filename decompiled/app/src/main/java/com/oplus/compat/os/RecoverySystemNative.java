package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class RecoverySystemNative {
    public static void setWipeProperty(java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed S_renamed");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("android.os.RecoverySystem").setActionName("setWipeProperty").withString(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, str).build()).execute();
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}
