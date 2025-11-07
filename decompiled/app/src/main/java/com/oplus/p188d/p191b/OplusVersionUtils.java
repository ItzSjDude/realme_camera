package com.oplus.p188d.p191b;

import android.util.Log;

/* compiled from: OplusVersionUtils.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class OplusVersionUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean f23365a = m24998a();

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m24998a() throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = Class.forName("com.oplus.os.OplusBuild");
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.w("OplusVersionUtils", "isOsVersion_11_3: " + COUIBaseListPopupWindow_8.toString());
        }
        return ((Integer) cls.getMethod("getOplusOSVERSION", new Class[0]).invoke(null, new Object[0])).intValue() >= ((Integer) cls.getField("OplusOS_11_3").get(null)).intValue();
    }
}
