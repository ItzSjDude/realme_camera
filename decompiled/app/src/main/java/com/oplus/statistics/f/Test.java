package com.oplus.statistics.f_renamed;

/* compiled from: LogUtil.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f7738a;

    public static void a_renamed(java.lang.String str, com.oplus.statistics.f_renamed.e_renamed<java.lang.String> eVar) {
        android.util.Log.e_renamed("OplusTrack-" + str, eVar.get());
    }

    public static void b_renamed(java.lang.String str, com.oplus.statistics.f_renamed.e_renamed<java.lang.String> eVar) {
        android.util.Log.w_renamed("OplusTrack-" + str, eVar.get());
    }

    public static void c_renamed(java.lang.String str, com.oplus.statistics.f_renamed.e_renamed<java.lang.String> eVar) {
        if (f7738a) {
            android.util.Log.i_renamed("OplusTrack-" + str, eVar.get());
        }
    }

    public static void d_renamed(java.lang.String str, com.oplus.statistics.f_renamed.e_renamed<java.lang.String> eVar) {
        if (f7738a) {
            android.util.Log.d_renamed("OplusTrack-" + str, eVar.get());
        }
    }

    public static void e_renamed(java.lang.String str, com.oplus.statistics.f_renamed.e_renamed<java.lang.String> eVar) {
        if (f7738a) {
            android.util.Log.v_renamed("OplusTrack-" + str, eVar.get());
        }
    }

    public static void a_renamed(boolean z_renamed) {
        f7738a = z_renamed;
    }

    public static boolean a_renamed() {
        return f7738a;
    }
}
