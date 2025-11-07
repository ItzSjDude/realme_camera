package com.oplus.camera.p146gl.p148b;

import android.graphics.Rect;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.capmode.MultiVideoMode;
import com.oplus.camera.util.Util;

/* compiled from: SubSurfacePositionContainer.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class SubSurfacePositionContainer {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f13950a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f13951b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f13952c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f13953d = -1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13954e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13955f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13956g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f13957h = -1;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13958i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13959j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13960k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f13961l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13962m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13963n = 0;

    /* renamed from: o */
    private boolean f13964o = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13898a() {
        if (Util.m24498u()) {
            return (int) (this.f13951b / 1.7777777777777777d);
        }
        return this.f13950a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13903b() {
        return this.f13951b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13905c() {
        return this.f13952c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m13907d() {
        return this.f13953d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m13909e() {
        return this.f13954e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m13911f() {
        return this.f13958i;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m13913g() {
        return this.f13959j;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m13914h() {
        if (Util.m24498u()) {
            return (this.f13950a - m13898a()) / 2;
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m13915i() {
        return this.f13960k;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public int m13916j() {
        return this.f13961l;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m13917k() {
        return this.f13962m;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public int m13918l() {
        return this.f13963n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13899a(int OplusGLSurfaceView_13) {
        this.f13950a = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13904b(int OplusGLSurfaceView_13) {
        this.f13951b = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13906c(int OplusGLSurfaceView_13) {
        this.f13952c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13908d(int OplusGLSurfaceView_13) {
        this.f13953d = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13910e(int OplusGLSurfaceView_13) {
        this.f13954e = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m13919m() {
        return this.f13957h;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m13912f(int OplusGLSurfaceView_13) {
        CameraLog.m12967f("SubSurfacePositionContainer", "setMultiVideoType, multiVideoType: " + OplusGLSurfaceView_13);
        this.f13957h = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m13920n() {
        return this.f13964o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13902a(boolean z) {
        this.f13964o = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13900a(int OplusGLSurfaceView_13, int i2) {
        this.f13955f = OplusGLSurfaceView_13;
        this.f13956g = i2;
    }

    /* renamed from: o */
    public Rect m13921o() {
        int OplusGLSurfaceView_13 = this.f13953d;
        int i2 = this.f13954e;
        return new Rect(OplusGLSurfaceView_13, i2, this.f13955f + OplusGLSurfaceView_13, this.f13956g + i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13901a(Size size, Size size2, int OplusGLSurfaceView_13, boolean z) {
        float fM12560a = MultiVideoMode.m12560a(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0) {
            this.f13958i = m13898a();
            this.f13959j = (size2.getWidth() * m13898a()) / size2.getHeight();
            int i2 = this.f13958i;
            this.f13960k = i2;
            int i3 = this.f13959j;
            this.f13961l = i3;
            this.f13963n = i2;
            this.f13962m = i3 * 2;
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (z) {
                this.f13958i = m13898a();
                this.f13959j = (size2.getWidth() * m13898a()) / size2.getHeight();
                int iM13898a = (int) (m13898a() / fM12560a);
                this.f13960k = iM13898a;
                this.f13961l = iM13898a;
                this.f13963n = this.f13958i;
                this.f13962m = this.f13959j;
                return;
            }
            this.f13960k = m13898a();
            this.f13961l = (size.getWidth() * m13898a()) / size.getHeight();
            int iM13898a2 = (int) (m13898a() / fM12560a);
            this.f13958i = iM13898a2;
            this.f13959j = iM13898a2;
            this.f13963n = this.f13960k;
            this.f13962m = this.f13961l;
            return;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return;
        }
        if (z) {
            this.f13958i = m13898a();
            this.f13959j = (size2.getWidth() * m13898a()) / size2.getHeight();
            this.f13960k = (int) (m13898a() / fM12560a);
            int i4 = this.f13959j;
            this.f13961l = (int) (i4 / fM12560a);
            this.f13963n = this.f13958i;
            this.f13962m = i4;
            return;
        }
        this.f13960k = m13898a();
        this.f13961l = (size.getWidth() * m13898a()) / size.getHeight();
        this.f13958i = (int) (m13898a() / fM12560a);
        int i5 = this.f13961l;
        this.f13959j = (int) (i5 / fM12560a);
        this.f13963n = this.f13960k;
        this.f13962m = i5;
    }

    public String toString() {
        return "SubSurfacePositionContainer{mScreenWidth=" + this.f13950a + ", mScreenHeight=" + this.f13951b + ", mSettingMenuPanelHeight=" + this.f13952c + ", mSmallSurfaceXOnScreen=" + this.f13953d + ", mSmallSurfaceYOnScreen=" + this.f13954e + ", mSmallSurfaceWidth=" + this.f13955f + ", mSmallSurfaceHeight=" + this.f13956g + ", mMultiVideoType=" + this.f13957h + ", mDrawMainImageWidth=" + this.f13958i + ", mDrawMainImageHeight=" + this.f13959j + ", mDrawSubImageWidth=" + this.f13960k + ", mDrawSubImageHeight=" + this.f13961l + ", mFboHeight=" + this.f13962m + ", mFboWidth=" + this.f13963n + ", mbMainOneCameraFirstDraw=" + this.f13964o + '}';
    }
}
