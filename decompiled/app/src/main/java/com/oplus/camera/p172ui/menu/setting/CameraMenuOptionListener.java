package com.oplus.camera.p172ui.menu.setting;

import android.content.SharedPreferences;

/* compiled from: CameraMenuOptionListener.java */
/* renamed from: com.oplus.camera.ui.menu.setting.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public interface CameraMenuOptionListener {
    /* renamed from: PlatformImplementations.kt_3 */
    String mo21218a(String str, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo21219a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo21052a(String str, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo21230a(String str, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    boolean mo21231a(String str, boolean z, boolean z2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean mo21239b(String str);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo21241c(String str);

    /* renamed from: IntrinsicsJvm.kt_5 */
    void mo21247d(String str);

    boolean getMenuPanelAshed();

    boolean getMenuPanelEnable();

    int getOrientation();

    SharedPreferences getSharedPreferences();
}
