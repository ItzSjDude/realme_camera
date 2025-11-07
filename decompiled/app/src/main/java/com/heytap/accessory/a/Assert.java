package com.heytap.accessory.a_renamed;

/* compiled from: SdkLog.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static void a_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.v_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2);
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.d_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2);
    }

    public static void c_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.i_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2);
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.w_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2);
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2, th);
    }

    public static void a_renamed(java.lang.String str, java.lang.Throwable th) {
        android.util.Log.w_renamed("AF.SDK", str, th);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.e_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2);
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e_renamed(a_renamed("AF.SDK.".concat(java.lang.String.valueOf(str))), str2, th);
    }

    public static void b_renamed(java.lang.String str, java.lang.Throwable th) {
        android.util.Log.e_renamed("AF.SDK", str, th);
    }

    private static java.lang.String a_renamed(java.lang.String str) {
        return (android.os.Build.VERSION.SDK_INT > 23 || str.length() <= 22) ? str : str.substring(0, 22);
    }
}
