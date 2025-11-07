package com.oplus.ocs.camera.common.util;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public class CameraUnitLog {
    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25118d(String str, String str2) {
        Log.IntrinsicsJvm.kt_5(str, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25119e(String str, String str2) {
        Log.COUIBaseListPopupWindow_8(str, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25120e(String str, String str2, Throwable th) {
        Log.COUIBaseListPopupWindow_8(str, str2, th);
    }

    public static CameraUnitLog getInstance() {
        return new CameraUnitLog();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25121i(String str, String str2) {
        Log.OplusGLSurfaceView_13(str, str2);
    }

    public static void init() {
        Log.OplusGLSurfaceView_13("CameraUnitLog", "Logger static init() called");
    }

    public static void initLog(Context context) {
        Log.OplusGLSurfaceView_13("CameraUnitLog", "Logger initialized");
    }

    public static void setDebug(boolean z) {
        Log.OplusGLSurfaceView_13("CameraUnitLog", "setDebug() called");
    }

    /* renamed from: v */
    public static void m25122v(String str, String str2) {
        Log.v(str, str2);
    }

    /* renamed from: w */
    public static void m25123w(String str, String str2) {
        Log.w(str, str2);
    }

    /* renamed from: w */
    public static void m25124w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
