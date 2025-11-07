package org.andresoviedo.android_3d_model_engine.p230b;

import java.nio.FloatBuffer;
import org.andresoviedo.p225a.p228c.Math3DUtils;

/* compiled from: AnimatedModel.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AnimatedModel extends Object3DData {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float[] f24875h;

    /* renamed from: OplusGLSurfaceView_13 */
    private FloatBuffer f24876i;

    /* renamed from: OplusGLSurfaceView_15 */
    private FloatBuffer f24877j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float[][] f24878k;

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m26163a() {
        float[] fArr = this.f24875h;
        return fArr == null ? Math3DUtils.f24819a : fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimatedModel m26162a(FloatBuffer floatBuffer) {
        this.f24876i = floatBuffer;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public FloatBuffer m26164b() {
        return this.f24876i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatedModel m26165b(FloatBuffer floatBuffer) {
        this.f24877j = floatBuffer;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public FloatBuffer m26166c() {
        return this.f24877j;
    }

    @Override // org.andresoviedo.android_3d_model_engine.p230b.Object3DData
    /* renamed from: IntrinsicsJvm.kt_5 */
    public Dimensions mo26167d() {
        return super.mo26167d();
    }

    @Override // org.andresoviedo.android_3d_model_engine.p230b.Object3DData
    /* renamed from: COUIBaseListPopupWindow_8, reason: merged with bridge method [inline-methods] */
    public AnimatedModel clone() {
        AnimatedModel c4054a = new AnimatedModel();
        super.m26228a(c4054a);
        c4054a.m26162a(m26164b());
        c4054a.m26165b(m26166c());
        c4054a.f24878k = this.f24878k;
        c4054a.f24875h = this.f24875h;
        return c4054a;
    }
}
