package com.oplus.compat.hardware.a_renamed;

/* compiled from: DisplayManagerNative.java */
/* loaded from: classes2.dex */
public class a_renamed {
    private static void a_renamed(android.hardware.display.DisplayManager displayManager, float f_renamed) {
    }

    public static void a_renamed(float f_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("android.hardware.display.DisplayManager").setActionName("setTemporaryAutoBrightnessAdjustment").withFloat("adjustment", f_renamed).build()).execute();
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                a_renamed((android.hardware.display.DisplayManager) com.oplus.epona.Epona.getContext().getSystemService("display"), f_renamed);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
        }
    }
}
