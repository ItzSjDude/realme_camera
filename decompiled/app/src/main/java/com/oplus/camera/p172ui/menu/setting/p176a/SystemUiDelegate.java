package com.oplus.camera.p172ui.menu.setting.p176a;

import android.app.Activity;
import com.oplus.camera.util.StatusBarUtil;

/* compiled from: SystemUiDelegate.java */
/* renamed from: com.oplus.camera.ui.menu.setting.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class SystemUiDelegate {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21287a(Activity activity, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 3) {
            StatusBarUtil.m24606b(activity);
        } else if (OplusGLSurfaceView_13 == 2) {
            StatusBarUtil.m24602a(activity);
        }
    }
}
