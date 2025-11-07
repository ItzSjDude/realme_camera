package com.p094b.p095a.p096a;

import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: CircleAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class CircleAnimator extends CameraAnimator {

    /* renamed from: COUIBaseListPopupWindow_8 */
    final float f6055e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final float f6056f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final float f6057g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    float f6058h;

    /* renamed from: OplusGLSurfaceView_13 */
    boolean f6059i;

    /* renamed from: OplusGLSurfaceView_15 */
    float[] f6060j;

    /* renamed from: OplusGLSurfaceView_5 */
    float[] f6061k;

    public CircleAnimator(Camera c4056c, boolean z) {
        super(c4056c, z);
        this.f6055e = 0.3f;
        this.f6056f = 720.0f;
        this.f6057g = 2.0f;
        this.f6058h = 0.0f;
        this.f6059i = false;
        this.f6060j = new float[]{0.0f, 0.0f};
        this.f6061k = new float[]{0.0f, 0.0f};
    }

    public CircleAnimator(Camera c4056c, boolean z, AnimConfig c1220a) {
        super(c4056c, z, c1220a);
        this.f6055e = 0.3f;
        this.f6056f = 720.0f;
        this.f6057g = 2.0f;
        this.f6058h = 0.0f;
        this.f6059i = false;
        this.f6060j = new float[]{0.0f, 0.0f};
        this.f6061k = new float[]{0.0f, 0.0f};
    }

    @Override // com.p094b.p095a.p096a.CameraAnimator, com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        super.mo6248b();
        m6266b(this.f6060j, 0.0f, 720.0f);
        m6266b(this.f6061k, this.f6042a.f24887c, 2.0f);
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6246a(float COUIBaseListPopupWindow_12) {
        double radians = Math.toRadians(m6271a(this.f6060j, COUIBaseListPopupWindow_12));
        this.f6042a.f24885a = ((float) Math.cos(radians)) * 0.3f;
        this.f6042a.f24886b = ((float) Math.sin(radians)) * 0.3f;
        this.f6042a.f24888d = ((float) Math.cos(radians)) * 0.3f;
        this.f6042a.f24889e = ((float) Math.sin(radians)) * 0.3f;
        if (COUIBaseListPopupWindow_12 <= 0.5d) {
            this.f6042a.f24887c = m6271a(this.f6061k, COUIBaseListPopupWindow_12);
        } else {
            this.f6042a.f24887c = m6271a(this.f6061k, 1.0f - COUIBaseListPopupWindow_12);
        }
        this.f6042a.m26181a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m6266b(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = COUIBaseListPopupWindow_12 + f2;
    }
}
