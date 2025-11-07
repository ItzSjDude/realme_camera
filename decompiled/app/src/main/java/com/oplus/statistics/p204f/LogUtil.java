package com.oplus.statistics.p204f;

import android.util.Log;

/* compiled from: LogUtil.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class LogUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f23900a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25428a(String str, Supplier<String> interfaceC3752e) {
        Log.COUIBaseListPopupWindow_8("OplusTrack-" + str, interfaceC3752e.get());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25431b(String str, Supplier<String> interfaceC3752e) {
        Log.w("OplusTrack-" + str, interfaceC3752e.get());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m25432c(String str, Supplier<String> interfaceC3752e) {
        if (f23900a) {
            Log.OplusGLSurfaceView_13("OplusTrack-" + str, interfaceC3752e.get());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25433d(String str, Supplier<String> interfaceC3752e) {
        if (f23900a) {
            Log.IntrinsicsJvm.kt_5("OplusTrack-" + str, interfaceC3752e.get());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25434e(String str, Supplier<String> interfaceC3752e) {
        if (f23900a) {
            Log.v("OplusTrack-" + str, interfaceC3752e.get());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25429a(boolean z) {
        f23900a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25430a() {
        return f23900a;
    }
}
