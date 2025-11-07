package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: MathUtil.java */
/* loaded from: classes2.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static float f6535a = 0.0f;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static float f6536b = 0.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static float f6537c = 0.0f;
    private static float d_renamed = 140.33f;
    private static float e_renamed;
    private static float f_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_elements_height);
    private static float g_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_elements_highlight_height);
    private static float h_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_elements_gap);
    private static float i_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_unit);
    private static float j_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_arc_chord);
    private static float k_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.menu_effect_model_height);

    public static double c_renamed(float f2, double d2) {
        return f2 / d2;
    }

    public static int j_renamed() {
        return 3600;
    }

    static {
        float f2 = f_renamed;
        float f3 = i_renamed;
        f6535a = f2 / f3;
        f6536b = h_renamed / f3;
        f6537c = k_renamed / f3;
    }

    public static float a_renamed(float f2) {
        return f2 / i_renamed;
    }

    public static void b_renamed(float f2) {
        f6535a = a_renamed(f2);
    }

    public static void c_renamed(float f2) {
        f6536b = a_renamed(f2);
    }

    public static void d_renamed(float f2) {
        f6537c = a_renamed(f2);
    }

    public static void e_renamed(float f2) {
        d_renamed = f2;
    }

    public static double a_renamed() {
        return d_renamed;
    }

    public static float b_renamed() {
        return (float) a_renamed(a_renamed(j_renamed), java.lang.Math.toRadians(d_renamed));
    }

    public static float f_renamed(float f2) {
        return (float) java.lang.Math.toDegrees((((int) (r4 / (b_renamed() * 2.0f))) * 3.141592653589793d) + b_renamed(a_renamed(f2) % (b_renamed() * 2.0f), b_renamed()));
    }

    public static float c_renamed() {
        return f6535a;
    }

    public static float d_renamed() {
        return ((float) b_renamed(c_renamed(), b_renamed())) * b_renamed();
    }

    public static float e_renamed() {
        return (float) java.lang.Math.toDegrees(c_renamed(d_renamed(), b_renamed()));
    }

    public static float f_renamed() {
        return (float) java.lang.Math.toDegrees(c_renamed(f6536b, b_renamed()));
    }

    public static float g_renamed() {
        return e_renamed() + f_renamed();
    }

    public static float h_renamed() {
        return e_renamed() / 2.0f;
    }

    public static float a_renamed(int i2) {
        return ((360.0f - h_renamed()) + (g_renamed() * i2)) % 360.0f;
    }

    public static float i_renamed() {
        return f6537c;
    }

    public static float k_renamed() {
        return (-o_renamed()) / 2.0f;
    }

    public static float l_renamed() {
        return o_renamed() / 2.0f;
    }

    public static float m_renamed() {
        return (-p_renamed()) / 2.0f;
    }

    public static float n_renamed() {
        return p_renamed() / 2.0f;
    }

    public static float o_renamed() {
        return a_renamed(j_renamed);
    }

    public static float p_renamed() {
        return f6537c;
    }

    public static double a_renamed(float f2, double d2) {
        return (f2 / 2.0f) / java.lang.Math.sin(d2 / 2.0d);
    }

    public static double b_renamed(float f2, double d2) {
        return java.lang.Math.asin(f2 / (d2 * 2.0d)) * 2.0d;
    }
}
