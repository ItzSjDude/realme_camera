package com.oplus.camera.sticker.p167c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: PrefUtils.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class PrefUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static long m16824a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("local_data_version", 0L);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m16828b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("check_interval_in_minute", 0L);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m16831c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("last_request_time", 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16826a(Context context, long OplusGLSurfaceView_15) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("local_data_version", OplusGLSurfaceView_15);
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16829b(Context context, long OplusGLSurfaceView_15) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("check_interval_in_minute", OplusGLSurfaceView_15);
        editorEdit.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m16832c(Context context, long OplusGLSurfaceView_15) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putLong("last_request_time", OplusGLSurfaceView_15);
        editorEdit.apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16827a(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("test_environment", z);
        editorEdit.apply();
        m16826a(context, 0L);
        m16832c(context, 0L);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m16834d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("test_environment", false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16830b(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("trace_debug", z);
        editorEdit.apply();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m16835e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("trace_debug", false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16825a(Context context, int OplusGLSurfaceView_13) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putInt("auditing_mode", OplusGLSurfaceView_13);
        editorEdit.apply();
        m16826a(context, 0L);
        m16832c(context, 0L);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m16836f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("auditing_mode", 3);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m16833c(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("dump_retention", z);
        editorEdit.apply();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m16837g(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dump_retention", false);
    }
}
