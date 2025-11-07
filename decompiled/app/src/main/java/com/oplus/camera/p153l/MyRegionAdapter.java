package com.oplus.camera.p153l;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.p167c.PrefUtils;

/* compiled from: MyRegionAdapter.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_14.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MyRegionAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f14496a = "PlatformImplementations.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f14497b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f14498c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean f14499d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static String f14500e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static String f14501f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static String f14502g;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m14511a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        f14497b = MyRegionFeatureUtils.m14520a("com.oplus.camera.face_beauty_default_off");
        f14498c = MyRegionFeatureUtils.m14520a("com.oplus.camera.force_play_shutter_sound");
        f14499d = MyRegionFeatureUtils.m14520a("com.oplus.camera.qrc_code_support");
        f14500e = MyRegionFeatureUtils.m14519a("com.oplus.camera.soloop_route_url", null);
        f14501f = MyRegionFeatureUtils.m14519a("com.oplus.camera.sticker_test_url", null);
        f14502g = MyRegionFeatureUtils.m14519a("com.oplus.camera.sticker_base_url", null);
        CameraLog.m12959b(f14496a, "init, duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m14512b() {
        return f14497b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m14513c() {
        return f14498c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m14514d() {
        return f14499d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m14515e() {
        return f14500e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static String m14516f() {
        return f14501f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static String m14517g() {
        return f14502g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m14510a(Context context) {
        if (PrefUtils.m16834d(context)) {
            CameraLog.m12959b(f14496a, "getBaseUrl, url is test env");
            return m14516f();
        }
        CameraLog.m12959b(f14496a, "getBaseUrl, url is release env");
        return m14517g();
    }
}
