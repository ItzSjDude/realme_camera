package com.p094b.p095a.p096a;

import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: SwingAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class SwingAnimator extends CameraAnimator {

    /* renamed from: COUIBaseListPopupWindow_8 */
    final float f6094e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final float f6095f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final float f6096g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final float f6097h;

    /* renamed from: OplusGLSurfaceView_13 */
    float f6098i;

    /* renamed from: OplusGLSurfaceView_15 */
    boolean f6099j;

    /* renamed from: OplusGLSurfaceView_5 */
    float[] f6100k;

    /* renamed from: OplusGLSurfaceView_14 */
    float[] f6101l;

    /* renamed from: OplusGLSurfaceView_6 */
    float[] f6102m;

    public SwingAnimator(Camera c4056c, boolean z) {
        super(c4056c, z);
        this.f6094e = 0.0f;
        this.f6095f = 720.0f;
        this.f6096g = 0.32f;
        this.f6097h = 3.0f;
        this.f6098i = 0.0f;
        this.f6099j = false;
        this.f6100k = new float[]{0.0f, 0.0f};
        this.f6101l = new float[]{0.0f, 0.0f};
        this.f6102m = new float[]{0.0f, 0.0f};
    }

    public SwingAnimator(Camera c4056c, boolean z, AnimConfig c1220a) {
        super(c4056c, z, c1220a);
        this.f6094e = 0.0f;
        this.f6095f = 720.0f;
        this.f6096g = 0.32f;
        this.f6097h = 3.0f;
        this.f6098i = 0.0f;
        this.f6099j = false;
        this.f6100k = new float[]{0.0f, 0.0f};
        this.f6101l = new float[]{0.0f, 0.0f};
        this.f6102m = new float[]{0.0f, 0.0f};
    }

    @Override // com.p094b.p095a.p096a.CameraAnimator, com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        super.mo6248b();
        m6273b(this.f6102m, 0.0f, 720.0f);
        m6273b(this.f6100k, 0.0f, 720.0f);
        m6273b(this.f6101l, this.f6042a.f24887c, 3.0f);
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6246a(float COUIBaseListPopupWindow_12) {
        double radians = Math.toRadians(m6271a(this.f6102m, COUIBaseListPopupWindow_12));
        if (this.f6044c) {
            this.f6042a.f24885a = ((float) Math.sin(radians)) * 0.32f;
            this.f6042a.f24888d = this.f6042a.f24885a;
        } else {
            this.f6042a.f24886b = ((float) Math.sin(radians)) * 0.32f;
            this.f6042a.f24889e = this.f6042a.f24886b;
        }
        if (COUIBaseListPopupWindow_12 <= 0.5d) {
            this.f6042a.f24887c = m6271a(this.f6101l, COUIBaseListPopupWindow_12);
        } else {
            this.f6042a.f24887c = m6271a(this.f6101l, 1.0f - COUIBaseListPopupWindow_12);
        }
        this.f6042a.m26181a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m6273b(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = COUIBaseListPopupWindow_12 + f2;
    }
}
