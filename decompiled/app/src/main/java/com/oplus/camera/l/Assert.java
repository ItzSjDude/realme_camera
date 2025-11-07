package com.oplus.camera.l_renamed;

/* compiled from: MyRegionAdapter.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4785a = "a_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f4786b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f4787c;
    private static boolean d_renamed;
    private static java.lang.String e_renamed;
    private static java.lang.String f_renamed;
    private static java.lang.String g_renamed;

    public static void a_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        f4786b = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.face_beauty_default_off");
        f4787c = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.force_play_shutter_sound");
        d_renamed = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.qrc_code_support");
        e_renamed = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.soloop_route_url", null);
        f_renamed = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.sticker_test_url", null);
        g_renamed = com.oplus.camera.l_renamed.b_renamed.a_renamed("com.oplus.camera.sticker_base_url", null);
        com.oplus.camera.e_renamed.b_renamed(f4785a, "init, duration: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static boolean b_renamed() {
        return f4786b;
    }

    public static boolean c_renamed() {
        return f4787c;
    }

    public static boolean d_renamed() {
        return d_renamed;
    }

    public static java.lang.String e_renamed() {
        return e_renamed;
    }

    public static java.lang.String f_renamed() {
        return f_renamed;
    }

    public static java.lang.String g_renamed() {
        return g_renamed;
    }

    public static java.lang.String a_renamed(android.content.Context context) {
        if (com.oplus.camera.sticker.c_renamed.d_renamed.d_renamed(context)) {
            com.oplus.camera.e_renamed.b_renamed(f4785a, "getBaseUrl, url is_renamed test env");
            return f_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed(f4785a, "getBaseUrl, url is_renamed release env");
        return g_renamed();
    }
}
