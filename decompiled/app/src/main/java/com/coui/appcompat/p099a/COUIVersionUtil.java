package com.coui.appcompat.p099a;

import android.util.Log;

/* compiled from: COUIVersionUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.x */
/* loaded from: classes.dex */
public class COUIVersionUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static String f6369a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f6370b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6500a() throws ClassNotFoundException {
        f6369a = m6501b() ? "com.oplus.os.OplusBuild" : COUICompatUtil.m6393a().m6395c();
        f6370b = m6501b() ? "getOplusOSVERSION" : COUICompatUtil.m6393a().m6396d();
        try {
            Class<?> cls = Class.forName(f6369a);
            if (cls == null) {
                return 0;
            }
            return ((Integer) cls.getDeclaredMethod(f6370b, new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("COUIVersionUtil", "getOSVersionCode failed. error = " + COUIBaseListPopupWindow_8.getMessage());
            return 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m6501b() throws ClassNotFoundException {
        try {
            Class.forName("com.oplus.os.OplusBuild");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
