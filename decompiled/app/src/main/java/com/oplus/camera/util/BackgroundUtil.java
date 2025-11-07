package com.oplus.camera.util;

import android.graphics.Color;

/* compiled from: BackgroundUtil.java */
/* renamed from: com.oplus.camera.util.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class BackgroundUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean f23060a = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f23061b = Color.parseColor("#121212");

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24523a(int OplusGLSurfaceView_13) {
        return f23060a ? Color.argb(Color.alpha(OplusGLSurfaceView_13), Color.red(f23061b), Color.green(f23061b), Color.blue(f23061b)) : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m24522a(float COUIBaseListPopupWindow_12) {
        return f23060a ? Color.red(f23061b) / 255.0f : COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m24524b(float COUIBaseListPopupWindow_12) {
        return f23060a ? Color.green(f23061b) / 255.0f : COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float m24525c(float COUIBaseListPopupWindow_12) {
        return f23060a ? Color.blue(f23061b) / 255.0f : COUIBaseListPopupWindow_12;
    }
}
