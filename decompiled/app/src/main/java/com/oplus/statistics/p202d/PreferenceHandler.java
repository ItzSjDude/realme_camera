package com.oplus.statistics.p202d;

import android.content.Context;

/* compiled from: PreferenceHandler.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class PreferenceHandler {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final MemoryPreference f23878a = new MemoryPreference();

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25367a(Context context, String str, long OplusGLSurfaceView_15) {
        f23878a.m25360b(str, OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m25372b(Context context, String str, long OplusGLSurfaceView_15) {
        return f23878a.m25358a(str, OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25368a(Context context, String str, String str2) {
        f23878a.m25361b(str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m25373b(Context context, String str, String str2) {
        return f23878a.m25359a(str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25363a(Context context) {
        return f23878a.m25359a("pagevisit.routes", "");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25366a(Context context, String str) {
        f23878a.m25361b("pagevisit.routes", "");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m25371b(Context context) {
        return f23878a.m25358a("activity.start.time", -1L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25365a(Context context, long OplusGLSurfaceView_15) {
        f23878a.m25360b("activity.start.time", OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m25377c(Context context) {
        return f23878a.m25358a("activity.end.time", -1L);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25375b(Context context, long OplusGLSurfaceView_15) {
        f23878a.m25360b("activity.end.time", OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m25380d(Context context) {
        return f23878a.m25359a("current.activity", "");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25376b(Context context, String str) {
        f23878a.m25361b("current.activity", str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m25378c(Context context, String str, String str2) {
        return f23878a.m25358a("event.start" + str + "_" + str2, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25369a(Context context, String str, String str2, long OplusGLSurfaceView_15) {
        f23878a.m25360b("event.start" + str + "_" + str2, OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m25381d(Context context, String str, String str2) {
        return f23878a.m25359a("kv.start" + str + "_" + str2, "");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25370a(String str, String str2, String str3) {
        f23878a.m25361b("kv.start" + str + "_" + str3, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static int m25382e(Context context) {
        return f23878a.m25357a("pagevisit.duration", 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25364a(Context context, int OplusGLSurfaceView_13) {
        f23878a.m25362c("pagevisit.duration", OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static String m25383f(Context context) {
        return f23878a.m25359a("ssoid", "0");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m25379c(Context context, String str) {
        f23878a.m25361b("ssoid", str);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static void m25384g(Context context) {
        f23878a.m25361b("ssoid", "0");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m25374b(Context context, int OplusGLSurfaceView_13) {
        f23878a.m25362c("session.timeout", OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int m25385h(Context context) {
        return f23878a.m25357a("session.timeout", 30);
    }
}
