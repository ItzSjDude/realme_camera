package com.oplus.camera.p172ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: OrientationAnimation.java */
/* renamed from: com.oplus.camera.ui.r */
/* loaded from: classes2.dex */
public class OrientationAnimation extends Animation implements Animation.AnimationListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f22481a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f22482b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f22483c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f22484d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22485e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f22486f = null;

    /* compiled from: OrientationAnimation.java */
    /* renamed from: com.oplus.camera.ui.r$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo18006a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo18007a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo18008a();
    }

    public OrientationAnimation(float COUIBaseListPopupWindow_12, float f2) {
        this.f22481a = 0.0f;
        this.f22482b = 0.0f;
        this.f22483c = false;
        this.f22484d = false;
        this.f22481a = COUIBaseListPopupWindow_12;
        this.f22482b = f2;
        this.f22483c = false;
        this.f22484d = false;
        setRepeatCount(1);
        setAnimationListener(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23902a(int OplusGLSurfaceView_13, boolean z) {
        this.f22485e = OplusGLSurfaceView_13;
        PlatformImplementations.kt_3 aVar = this.f22486f;
        if ((aVar == null || aVar.mo18008a()) && z) {
            return;
        }
        m23900a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23903a(PlatformImplementations.kt_3 aVar) {
        this.f22486f = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m23901a() {
        return this.f22485e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23904b() {
        return this.f22483c;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
        float f2;
        float f3;
        if (this.f22484d) {
            f2 = this.f22482b;
            f3 = this.f22481a;
        } else {
            f2 = this.f22481a;
            f3 = this.f22482b;
        }
        float f4 = f2 + ((f3 - f2) * COUIBaseListPopupWindow_12);
        float f5 = f4 <= 1.0f ? f4 : 1.0f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (!this.f22483c) {
            f5 = this.f22481a;
        }
        m23899a(f5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23899a(float COUIBaseListPopupWindow_12) {
        PlatformImplementations.kt_3 aVar = this.f22486f;
        if (aVar != null) {
            aVar.mo18006a(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23900a(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = this.f22486f;
        if (aVar != null) {
            aVar.mo18007a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        m23900a(this.f22485e);
        m23899a(this.f22481a);
        this.f22483c = false;
        this.f22484d = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        this.f22484d = true;
        m23899a(this.f22482b);
        m23900a(this.f22485e);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f22483c = true;
        this.f22484d = false;
    }
}
