package com.oplus.camera.p172ui.menu.levelcontrol;

import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: MathUtil.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.o */
/* loaded from: classes2.dex */
public class MathUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static float f19839a = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static float f19840b = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static float f19841c = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static float f19842d = 140.33f;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static float f19843e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static float f19844f = Util.m24456h(R.dimen.menu_effect_elements_height);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static float f19845g = Util.m24456h(R.dimen.menu_effect_elements_highlight_height);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static float f19846h = Util.m24456h(R.dimen.menu_effect_elements_gap);

    /* renamed from: OplusGLSurfaceView_13 */
    private static float f19847i = Util.m24456h(R.dimen.menu_effect_unit);

    /* renamed from: OplusGLSurfaceView_15 */
    private static float f19848j = Util.m24456h(R.dimen.menu_effect_arc_chord);

    /* renamed from: OplusGLSurfaceView_5 */
    private static float f19849k = Util.m24456h(R.dimen.menu_effect_model_height);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static double m20989c(float COUIBaseListPopupWindow_12, double IntrinsicsJvm.kt_5) {
        return COUIBaseListPopupWindow_12 / IntrinsicsJvm.kt_5;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m21001j() {
        return 3600;
    }

    static {
        float COUIBaseListPopupWindow_12 = f19844f;
        float f2 = f19847i;
        f19839a = COUIBaseListPopupWindow_12 / f2;
        f19840b = f19846h / f2;
        f19841c = f19849k / f2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m20984a(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12 / f19847i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m20988b(float COUIBaseListPopupWindow_12) {
        f19839a = m20984a(COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m20991c(float COUIBaseListPopupWindow_12) {
        f19840b = m20984a(COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m20993d(float COUIBaseListPopupWindow_12) {
        f19841c = m20984a(COUIBaseListPopupWindow_12);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m20995e(float COUIBaseListPopupWindow_12) {
        f19842d = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m20982a() {
        return f19842d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m20987b() {
        return (float) m20983a(m20984a(f19848j), Math.toRadians(f19842d));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static float m20997f(float COUIBaseListPopupWindow_12) {
        return (float) Math.toDegrees((((int) (r4 / (m20987b() * 2.0f))) * 3.141592653589793d) + m20986b(m20984a(COUIBaseListPopupWindow_12) % (m20987b() * 2.0f), m20987b()));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float m20990c() {
        return f19839a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static float m20992d() {
        return ((float) m20986b(m20990c(), m20987b())) * m20987b();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static float m20994e() {
        return (float) Math.toDegrees(m20989c(m20992d(), m20987b()));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static float m20996f() {
        return (float) Math.toDegrees(m20989c(f19840b, m20987b()));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static float m20998g() {
        return m20994e() + m20996f();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static float m20999h() {
        return m20994e() / 2.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m20985a(int OplusGLSurfaceView_13) {
        return ((360.0f - m20999h()) + (m20998g() * OplusGLSurfaceView_13)) % 360.0f;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static float m21000i() {
        return f19841c;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static float m21002k() {
        return (-m21006o()) / 2.0f;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static float m21003l() {
        return m21006o() / 2.0f;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static float m21004m() {
        return (-m21007p()) / 2.0f;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static float m21005n() {
        return m21007p() / 2.0f;
    }

    /* renamed from: o */
    public static float m21006o() {
        return m20984a(f19848j);
    }

    /* renamed from: p */
    public static float m21007p() {
        return f19841c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m20983a(float COUIBaseListPopupWindow_12, double IntrinsicsJvm.kt_5) {
        return (COUIBaseListPopupWindow_12 / 2.0f) / Math.sin(IntrinsicsJvm.kt_5 / 2.0d);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static double m20986b(float COUIBaseListPopupWindow_12, double IntrinsicsJvm.kt_5) {
        return Math.asin(COUIBaseListPopupWindow_12 / (IntrinsicsJvm.kt_5 * 2.0d)) * 2.0d;
    }
}
