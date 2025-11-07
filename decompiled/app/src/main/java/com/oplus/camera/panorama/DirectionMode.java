package com.oplus.camera.panorama;

import android.content.Context;
import android.graphics.Matrix;
import com.oplus.camera.R;

/* compiled from: DirectionMode.java */
/* renamed from: com.oplus.camera.panorama.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class DirectionMode {

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected float f14936h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected float f14937i;

    /* renamed from: PlatformImplementations.kt_3 */
    protected Matrix f14929a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected float f14930b = 10.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected float f14931c = 260.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected float f14932d = -40.0f;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float f14933e = 220.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected float[] f14934f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected float[] f14935g = null;

    /* renamed from: OplusGLSurfaceView_15 */
    protected float f14938j = 0.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    protected float f14939k = 0.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    protected boolean f14940l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    protected int f14941m = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract String mo14914a(Context context);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo14916a(float COUIBaseListPopupWindow_12);

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract float[] mo14917a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract float mo14918b(float COUIBaseListPopupWindow_12);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract float mo14919c(float COUIBaseListPopupWindow_12);

    public DirectionMode(Context context) {
        this.f14936h = 0.0f;
        this.f14937i = 0.0f;
        this.f14937i = context.getResources().getDimension(R.dimen.front_panorama_guide_camera_width_narrow);
        this.f14936h = context.getResources().getDimension(R.dimen.front_panorama_guide_camera_height_narrow);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m14921b() {
        return this.f14941m;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14922b(int OplusGLSurfaceView_13, int i2) {
        this.f14929a = new Matrix();
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        this.f14934f = new float[]{0.0f, 0.0f, COUIBaseListPopupWindow_12, 0.0f, COUIBaseListPopupWindow_12, f2, 0.0f, f2};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Matrix m14920a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.f14929a == null) {
            m14922b(OplusGLSurfaceView_13, i2);
        }
        this.f14935g = mo14917a(OplusGLSurfaceView_13, i2);
        this.f14929a.reset();
        this.f14929a.setPolyToPoly(this.f14934f, 0, this.f14935g, 0, 4);
        this.f14929a.postTranslate((i3 - OplusGLSurfaceView_13) / 2, (i4 - i2) / 2);
        return this.f14929a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m14923c() {
        if (this.f14935g == null) {
            this.f14935g = new float[8];
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m14924d() {
        return this.f14932d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m14925e() {
        return this.f14930b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14915a() {
        this.f14930b = 0.0f;
        this.f14939k = 0.0f;
        this.f14938j = 0.0f;
        this.f14940l = false;
    }
}
