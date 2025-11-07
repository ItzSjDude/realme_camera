package com.oplus.ocs.camera.common.util;

/* loaded from: classes2.dex */
public class CameraUnitLog {
    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.d_renamed(str, str2);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.e_renamed(str, str2);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e_renamed(str, str2, th);
    }

    public static com.oplus.ocs.camera.common.util.CameraUnitLog getInstance() {
        return new com.oplus.ocs.camera.common.util.CameraUnitLog();
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.i_renamed(str, str2);
    }

    public static void init() {
        android.util.Log.i_renamed("CameraUnitLog", "Logger static init() called");
    }

    public static void initLog(android.content.Context context) {
        android.util.Log.i_renamed("CameraUnitLog", "Logger initialized");
    }

    public static void setDebug(boolean z_renamed) {
        android.util.Log.i_renamed("CameraUnitLog", "setDebug() called");
    }

    public static void v_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.v_renamed(str, str2);
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.w_renamed(str, str2);
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w_renamed(str, str2, th);
    }
}
