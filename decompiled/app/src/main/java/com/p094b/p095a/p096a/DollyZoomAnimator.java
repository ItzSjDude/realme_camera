package com.p094b.p095a.p096a;

import com.p094b.p095a.Log;
import org.andresoviedo.android_3d_model_engine.p230b.Camera;

/* compiled from: DollyZoomAnimator.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class DollyZoomAnimator extends CameraAnimator {

    /* renamed from: COUIBaseListPopupWindow_8 */
    final float f6062e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final float f6063f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final float f6064g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final float f6065h;

    /* renamed from: OplusGLSurfaceView_13 */
    final float f6066i;

    /* renamed from: OplusGLSurfaceView_15 */
    float[] f6067j;

    /* renamed from: OplusGLSurfaceView_5 */
    float[] f6068k;

    /* renamed from: OplusGLSurfaceView_14 */
    float[] f6069l;

    /* renamed from: OplusGLSurfaceView_6 */
    float[] f6070m;

    /* renamed from: OplusGLSurfaceView_11 */
    float[] f6071n;

    /* renamed from: o */
    float[] f6072o;

    /* renamed from: p */
    float[] f6073p;

    /* renamed from: q */
    float[] f6074q;

    /* renamed from: r */
    private float f6075r;

    /* renamed from: s */
    private float f6076s;

    public DollyZoomAnimator(Camera c4056c, boolean z) {
        super(c4056c, z);
        this.f6075r = -0.0094f;
        this.f6076s = -6.8E-4f;
        this.f6062e = -0.0f;
        this.f6063f = -0.0f;
        this.f6064g = -30.0f;
        this.f6065h = -0.1f;
        this.f6066i = 1.0f;
        this.f6067j = new float[]{0.0f, 0.0f};
        this.f6068k = new float[]{0.0f, 0.0f};
        this.f6069l = new float[]{0.0f, 0.0f};
        this.f6070m = new float[]{0.0f, 0.0f};
        this.f6071n = new float[]{0.0f, 0.0f};
        this.f6072o = new float[]{0.0f, 0.0f};
        this.f6073p = new float[]{0.0f, 0.0f};
        this.f6074q = new float[]{0.0f, 0.0f};
    }

    public DollyZoomAnimator(Camera c4056c, boolean z, AnimConfig c1220a) {
        super(c4056c, z, c1220a);
        this.f6075r = -0.0094f;
        this.f6076s = -6.8E-4f;
        this.f6062e = -0.0f;
        this.f6063f = -0.0f;
        this.f6064g = -30.0f;
        this.f6065h = -0.1f;
        this.f6066i = 1.0f;
        this.f6067j = new float[]{0.0f, 0.0f};
        this.f6068k = new float[]{0.0f, 0.0f};
        this.f6069l = new float[]{0.0f, 0.0f};
        this.f6070m = new float[]{0.0f, 0.0f};
        this.f6071n = new float[]{0.0f, 0.0f};
        this.f6072o = new float[]{0.0f, 0.0f};
        this.f6073p = new float[]{0.0f, 0.0f};
        this.f6074q = new float[]{0.0f, 0.0f};
    }

    @Override // com.p094b.p095a.p096a.CameraAnimator, com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        super.mo6248b();
        m6267b(this.f6067j, this.f6042a.f24885a, -0.0f);
        m6267b(this.f6068k, this.f6042a.f24886b, -0.0f);
        m6267b(this.f6069l, this.f6042a.f24887c, -30.0f);
        m6267b(this.f6070m, this.f6076s, -0.1f);
        m6267b(this.f6071n, this.f6042a.f24897m, this.f6042a.f24897m);
        m6267b(this.f6072o, this.f6042a.f24896l, this.f6042a.f24896l);
        m6267b(this.f6073p, this.f6042a.f24894j, this.f6042a.f24894j);
        m6267b(this.f6074q, this.f6042a.f24895k, this.f6042a.f24895k);
        Log.m6278d("dolly zoom", "dolly start:" + this.f6071n + "," + this.f6069l + "," + this.f6073p);
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6246a(float COUIBaseListPopupWindow_12) {
        this.f6042a.f24887c = m6272a(this.f6069l, this.f6045d == AnimDirection.ANIM_DIRECTION_DOLLYZOOM_FORWARD ? COUIBaseListPopupWindow_12 : 1.0f - COUIBaseListPopupWindow_12, 3.0f);
        this.f6042a.f24885a = m6271a(this.f6067j, COUIBaseListPopupWindow_12);
        this.f6042a.f24886b = -m6271a(this.f6067j, COUIBaseListPopupWindow_12);
        this.f6042a.f24889e = this.f6042a.f24885a;
        this.f6042a.f24897m = (this.f6071n[0] * (this.f6069l[0] + 1.0f)) / (this.f6042a.f24887c + 1.0f);
        this.f6042a.f24896l = (this.f6072o[0] * (this.f6069l[0] + 1.0f)) / (this.f6042a.f24887c + 1.0f);
        this.f6042a.f24894j = (this.f6073p[0] * (this.f6069l[0] + 1.0f)) / (this.f6042a.f24887c + 1.0f);
        this.f6042a.f24895k = (this.f6074q[0] * (this.f6069l[0] + 1.0f)) / (this.f6042a.f24887c + 1.0f);
        this.f6042a.m26181a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m6267b(float[] fArr, float COUIBaseListPopupWindow_12, float f2) {
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = COUIBaseListPopupWindow_12 + f2;
    }
}
