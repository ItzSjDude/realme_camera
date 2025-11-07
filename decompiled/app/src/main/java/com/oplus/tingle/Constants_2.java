package com.oplus.tingle;

import com.oplus.tingle.ipc.p213c.VersionUtils_2;

/* compiled from: Constants.java */
/* renamed from: com.oplus.tingle.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class Constants_2 {
    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Object m25462e() {
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static Object m25463f() {
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static Object m25464g() {
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Object m25465h() {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25458a() {
        return VersionUtils_2.m25516b() ? "com.oplus.epona.binder" : (String) m25462e();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m25459b() {
        return VersionUtils_2.m25516b() ? "com.oplus.epona.ext_binder" : (String) m25463f();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m25460c() {
        return VersionUtils_2.m25516b() ? "com.oplus.appplatform.master.provider" : (String) m25464g();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m25461d() {
        if (VersionUtils_2.m25516b()) {
            return "com.oplus.appplatform";
        }
        String str = (String) m25465h();
        return str == null ? "" : str;
    }
}
