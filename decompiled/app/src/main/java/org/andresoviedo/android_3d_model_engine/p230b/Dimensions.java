package org.andresoviedo.android_3d_model_engine.p230b;

import java.text.DecimalFormat;
import java.util.Arrays;

/* compiled from: Dimensions.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class Dimensions {

    /* renamed from: OplusGLSurfaceView_5 */
    private static final DecimalFormat f24907k = new DecimalFormat("0.##");

    /* renamed from: PlatformImplementations.kt_3 */
    private float f24908a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f24909b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f24910c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f24911d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f24912e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f24913f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final float[] f24914g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final float[] f24915h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float[] f24916i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f24917j;

    public Dimensions() {
        this.f24908a = Float.MAX_VALUE;
        this.f24909b = -3.4028235E38f;
        this.f24910c = -3.4028235E38f;
        this.f24911d = Float.MAX_VALUE;
        this.f24912e = Float.MAX_VALUE;
        this.f24913f = -3.4028235E38f;
        this.f24914g = new float[]{0.0f, 0.0f, 0.0f};
        this.f24915h = new float[]{0.0f, 0.0f, 0.0f};
        this.f24916i = new float[]{0.0f, 0.0f, 0.0f};
        this.f24917j = false;
    }

    public Dimensions(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        this.f24908a = Float.MAX_VALUE;
        this.f24909b = -3.4028235E38f;
        this.f24910c = -3.4028235E38f;
        this.f24911d = Float.MAX_VALUE;
        this.f24912e = Float.MAX_VALUE;
        this.f24913f = -3.4028235E38f;
        this.f24914g = new float[]{0.0f, 0.0f, 0.0f};
        this.f24915h = new float[]{0.0f, 0.0f, 0.0f};
        this.f24916i = new float[]{0.0f, 0.0f, 0.0f};
        this.f24917j = false;
        this.f24908a = COUIBaseListPopupWindow_12;
        this.f24909b = f2;
        this.f24910c = f3;
        this.f24911d = f4;
        this.f24913f = f5;
        this.f24912e = f6;
        m26185d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26193a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        if (COUIBaseListPopupWindow_12 > this.f24909b) {
            this.f24909b = COUIBaseListPopupWindow_12;
        }
        if (COUIBaseListPopupWindow_12 < this.f24908a) {
            this.f24908a = COUIBaseListPopupWindow_12;
        }
        if (f2 > this.f24910c) {
            this.f24910c = f2;
        }
        if (f2 < this.f24911d) {
            this.f24911d = f2;
        }
        if (f3 > this.f24913f) {
            this.f24913f = f3;
        }
        if (f3 < this.f24912e) {
            this.f24912e = f3;
        }
        m26185d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m26185d() {
        this.f24915h[0] = m26187f();
        this.f24915h[1] = m26189h();
        this.f24915h[2] = m26191j();
        this.f24916i[0] = m26186e();
        this.f24916i[1] = m26188g();
        this.f24916i[2] = m26190i();
        this.f24914g[0] = (m26186e() + m26187f()) / 2.0f;
        this.f24914g[1] = (m26188g() + m26189h()) / 2.0f;
        this.f24914g[2] = (m26190i() + m26191j()) / 2.0f;
        this.f24917j = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m26192a() {
        return Math.abs(m26186e() - m26187f());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m26194b() {
        return Math.abs(m26188g() - m26189h());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m26195c() {
        return Math.abs(m26190i() - m26191j());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float m26186e() {
        if (this.f24917j) {
            return this.f24909b;
        }
        return 0.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float m26187f() {
        if (this.f24917j) {
            return this.f24908a;
        }
        return 0.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float m26188g() {
        if (this.f24917j) {
            return this.f24910c;
        }
        return 0.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float m26189h() {
        if (this.f24917j) {
            return this.f24911d;
        }
        return 0.0f;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private float m26190i() {
        if (this.f24917j) {
            return this.f24913f;
        }
        return 0.0f;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private float m26191j() {
        if (this.f24917j) {
            return this.f24912e;
        }
        return 0.0f;
    }

    public String toString() {
        return "Dimensions{min=" + Arrays.toString(this.f24915h) + ", max=" + Arrays.toString(this.f24916i) + ", center=" + Arrays.toString(this.f24914g) + ", width=" + m26192a() + ", height=" + m26194b() + ", depth=" + m26195c() + '}';
    }
}
