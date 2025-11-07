package com.oplus.compat.hardware.p186a;

import android.hardware.display.DisplayManager;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;

/* compiled from: DisplayManagerNative.java */
/* renamed from: com.oplus.compat.hardware.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DisplayManagerNative {
    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24913a(DisplayManager displayManager, float COUIBaseListPopupWindow_12) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24912a(float COUIBaseListPopupWindow_12) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Epona.newCall(new Request.Builder().setComponentName("android.hardware.display.DisplayManager").setActionName("setTemporaryAutoBrightnessAdjustment").withFloat("adjustment", COUIBaseListPopupWindow_12).build()).execute();
        } else {
            if (VersionUtils.m24889e()) {
                m24913a((DisplayManager) Epona.getContext().getSystemService("display"), COUIBaseListPopupWindow_12);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before Q");
        }
    }
}
