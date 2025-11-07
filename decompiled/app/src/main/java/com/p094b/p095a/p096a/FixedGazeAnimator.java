package com.p094b.p095a.p096a;

import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: FixedGazeAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class FixedGazeAnimator extends CameraAnimator {

    /* renamed from: COUIBaseListPopupWindow_8 */
    float f6077e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    float f6078f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final float f6079g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final float f6080h;

    /* renamed from: OplusGLSurfaceView_13 */
    float f6081i;

    /* renamed from: OplusGLSurfaceView_15 */
    final float f6082j;

    /* renamed from: OplusGLSurfaceView_5 */
    float[] f6083k;

    /* renamed from: OplusGLSurfaceView_14 */
    float[] f6084l;

    /* renamed from: OplusGLSurfaceView_6 */
    float[] f6085m;

    /* renamed from: OplusGLSurfaceView_11 */
    float[] f6086n;

    /* renamed from: o */
    float[] f6087o;

    /* renamed from: p */
    float[] f6088p;

    /* renamed from: q */
    float[] f6089q;

    /* renamed from: r */
    float[] f6090r;

    /* renamed from: s */
    float[] f6091s;

    /* renamed from: t */
    private float f6092t;

    /* renamed from: u */
    private float f6093u;

    public FixedGazeAnimator(Camera c4056c, boolean z) {
        super(c4056c, z);
        this.f6092t = -0.0094f;
        this.f6093u = -6.8E-4f;
        this.f6077e = -3.0f;
        this.f6078f = 0.5f;
        this.f6079g = -3.5f;
        this.f6080h = -0.0f;
        this.f6081i = -0.1f;
        this.f6082j = -5.0f;
        this.f6083k = new float[]{0.0f, 0.0f};
        this.f6084l = new float[]{0.0f, 0.0f};
        this.f6085m = new float[]{0.0f, 0.0f};
        this.f6086n = new float[]{0.0f, 0.0f};
        this.f6087o = new float[]{0.0f, 0.0f};
        this.f6088p = new float[]{0.0f, 0.0f};
        this.f6089q = new float[]{0.0f, 0.0f};
        this.f6090r = new float[]{0.0f, 0.0f};
        this.f6091s = new float[]{0.0f, 0.0f};
    }

    public FixedGazeAnimator(Camera c4056c, boolean z, AnimConfig c1220a) {
        super(c4056c, z, c1220a);
        this.f6092t = -0.0094f;
        this.f6093u = -6.8E-4f;
        this.f6077e = -3.0f;
        this.f6078f = 0.5f;
        this.f6079g = -3.5f;
        this.f6080h = -0.0f;
        this.f6081i = -0.1f;
        this.f6082j = -5.0f;
        this.f6083k = new float[]{0.0f, 0.0f};
        this.f6084l = new float[]{0.0f, 0.0f};
        this.f6085m = new float[]{0.0f, 0.0f};
        this.f6086n = new float[]{0.0f, 0.0f};
        this.f6087o = new float[]{0.0f, 0.0f};
        this.f6088p = new float[]{0.0f, 0.0f};
        this.f6089q = new float[]{0.0f, 0.0f};
        this.f6090r = new float[]{0.0f, 0.0f};
        this.f6091s = new float[]{0.0f, 0.0f};
    }

    @Override // com.p094b.p095a.p096a.CameraAnimator, com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        super.mo6248b();
        if (!this.f6044c) {
            this.f6077e = -0.5f;
            this.f6078f = -3.0f;
            this.f6081i = 0.1f;
            if (this.f6045d == AnimDirection.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT) {
                this.f6042a.f24886b = -this.f6042a.f24886b;
                this.f6042a.f24889e = -this.f6042a.f24889e;
                this.f6078f = -this.f6078f;
                this.f6081i = -this.f6081i;
                this.f6042a.m26181a(true);
            }
        } else if (this.f6045d == AnimDirection.ANIM_DIRECTION_FIXEDGAZE_RIGHT2LEFT) {
            this.f6042a.f24885a = -this.f6042a.f24885a;
            this.f6042a.f24888d = -this.f6042a.f24888d;
            this.f6077e = -this.f6077e;
            this.f6081i = -this.f6081i;
            this.f6042a.m26181a(true);
        }
        m6268b(this.f6083k, this.f6042a.f24885a, this.f6077e);
        m6268b(this.f6084l, this.f6042a.f24886b, this.f6078f);
        m6268b(this.f6085m, this.f6042a.f24887c, -3.5f);
        if (this.f6044c) {
            m6268b(this.f6087o, this.f6042a.f24888d, this.f6081i);
        } else {
            m6268b(this.f6087o, this.f6042a.f24889e, this.f6081i);
        }
        m6268b(this.f6086n, this.f6093u, -0.0f);
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6246a(float COUIBaseListPopupWindow_12) {
        if (this.f6044c) {
            this.f6042a.f24885a = m6272a(this.f6083k, COUIBaseListPopupWindow_12, 0.3f);
            this.f6042a.f24886b = m6272a(this.f6084l, COUIBaseListPopupWindow_12, 0.3f);
            this.f6042a.f24888d = m6272a(this.f6087o, COUIBaseListPopupWindow_12, 0.3f);
        } else {
            this.f6042a.f24885a = m6272a(this.f6083k, COUIBaseListPopupWindow_12, 0.3f);
            this.f6042a.f24886b = m6272a(this.f6084l, COUIBaseListPopupWindow_12, 0.3f);
            this.f6042a.f24889e = m6272a(this.f6087o, COUIBaseListPopupWindow_12, 0.3f);
        }
        this.f6042a.f24887c = m6272a(this.f6085m, COUIBaseListPopupWindow_12, 0.2f);
        this.f6042a.m26181a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m6268b(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = COUIBaseListPopupWindow_12 + f2;
    }
}
