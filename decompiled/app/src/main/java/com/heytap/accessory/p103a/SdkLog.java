package com.heytap.accessory.p103a;

import android.os.Build;
import android.util.Log;

/* compiled from: SdkLog.java */
/* renamed from: com.heytap.accessory.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class SdkLog {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8375a(String str, String str2) {
        Log.v(m8374a("AF.SDK.".concat(String.valueOf(str))), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m8378b(String str, String str2) {
        Log.IntrinsicsJvm.kt_5(m8374a("AF.SDK.".concat(String.valueOf(str))), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m8381c(String str, String str2) {
        Log.OplusGLSurfaceView_13(m8374a("AF.SDK.".concat(String.valueOf(str))), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m8382d(String str, String str2) {
        Log.w(m8374a("AF.SDK.".concat(String.valueOf(str))), str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8376a(String str, String str2, Throwable th) {
        Log.w(m8374a("AF.SDK.".concat(String.valueOf(str))), str2, th);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8377a(String str, Throwable th) {
        Log.w("AF.SDK", str, th);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m8383e(String str, String str2) {
        Log.COUIBaseListPopupWindow_8(m8374a("AF.SDK.".concat(String.valueOf(str))), str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m8379b(String str, String str2, Throwable th) {
        Log.COUIBaseListPopupWindow_8(m8374a("AF.SDK.".concat(String.valueOf(str))), str2, th);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m8380b(String str, Throwable th) {
        Log.COUIBaseListPopupWindow_8("AF.SDK", str, th);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m8374a(String str) {
        return (Build.VERSION.SDK_INT > 23 || str.length() <= 22) ? str : str.substring(0, 22);
    }
}
