package com.p094b.p095a;

import android.util.Log;

/* compiled from: Log.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class Log {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6274a(String str, String str2) {
        Log.COUIBaseListPopupWindow_8(str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6275a(String str, String str2, Throwable th) {
        Log.IntrinsicsJvm.kt_5(str, str2, th);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m6276b(String str, String str2) {
        if (Config.f6014a >= 2) {
            Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m6277c(String str, String str2) {
        if (Config.f6014a >= 4) {
            Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m6278d(String str, String str2) {
        if (Config.f6014a >= 8) {
            Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m6279e(String str, String str2) {
        if (Config.f6014a >= 10) {
            Log.IntrinsicsJvm.kt_5(str, str2);
        }
    }
}
