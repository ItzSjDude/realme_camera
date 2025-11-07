package com.oplus.camera.p172ui.modepanel;

import android.graphics.Rect;
import android.view.View;
import com.oplus.camera.screen.ScreenModeConst;

/* compiled from: DragHelperUtils.java */
/* renamed from: com.oplus.camera.ui.modepanel.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class DragHelperUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    protected static int f20506a = 15;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected static int f20507b = 10;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected static float f20508c = 100.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected static float f20509d = 200.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m21788a() {
        return 1.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m21789a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        return (int) (COUIBaseListPopupWindow_12 * OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m21792a(ModeInfo c3353k) {
        if (c3353k != null) {
            return c3353k.m21934h();
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m21796b(ModeInfo c3353k) {
        if (c3353k != null) {
            return c3353k.m21932f();
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m21791a(View view, int OplusGLSurfaceView_13, int i2) {
        int iM21790a = m21790a(i2, view.getHeight());
        if (iM21790a < 0) {
            return -m21789a((m21797c() - i2) / m21797c(), m21799d());
        }
        if (iM21790a > 0) {
            return m21789a(((i2 - view.getHeight()) + m21797c()) / m21797c(), m21799d());
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m21790a(int OplusGLSurfaceView_13, int i2) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        if (COUIBaseListPopupWindow_12 < m21797c()) {
            return -1;
        }
        return COUIBaseListPopupWindow_12 > ((float) i2) - m21797c() ? 1 : 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m21793b() {
        return f20508c / m21788a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float m21797c() {
        return f20509d / m21788a();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m21799d() {
        return (int) (f20507b / m21788a());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static int m21800e() {
        return (int) (f20506a / m21788a());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m21795b(View view, int OplusGLSurfaceView_13, int i2) {
        int iM21794b = m21794b(OplusGLSurfaceView_13, view.getWidth());
        if (iM21794b < 0) {
            return -m21789a((m21793b() - OplusGLSurfaceView_13) / m21793b(), m21800e());
        }
        if (iM21794b > 0) {
            return m21789a(((OplusGLSurfaceView_13 - view.getWidth()) + m21793b()) / m21793b(), m21800e());
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected static int m21794b(int OplusGLSurfaceView_13, int i2) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        if (COUIBaseListPopupWindow_12 < m21793b()) {
            return -1;
        }
        return COUIBaseListPopupWindow_12 > ((float) i2) - m21793b() ? 1 : 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Rect m21798c(View view, int OplusGLSurfaceView_13, int i2) {
        int height;
        int height2;
        int i3;
        int i4;
        int[] iArr = new int[2];
        if (view == null) {
            return new Rect(0, 0, 0, 0);
        }
        view.getLocationOnScreen(iArr);
        if (4 != OplusGLSurfaceView_13) {
            height = iArr[0];
            int i5 = iArr[1];
            int width = (int) (iArr[0] + (view.getWidth() * view.getScaleX()));
            height2 = (int) (iArr[1] + (view.getHeight() * view.getScaleY()));
            i3 = i5;
            i4 = width;
        } else if (i2 == 90) {
            i4 = iArr[0];
            height = iArr[0] - ((int) (view.getHeight() * view.getScaleY()));
            i3 = iArr[1];
            height2 = (int) (i3 + (view.getWidth() * view.getScaleX()));
        } else {
            i4 = ScreenModeConst.f16034a - iArr[0];
            height = i4 - ((int) (view.getHeight() * view.getScaleY()));
            i3 = ScreenModeConst.f16035b - iArr[1];
            height2 = ((int) (view.getWidth() * view.getScaleX())) + i3;
        }
        return new Rect(height, i3, i4, height2);
    }
}
