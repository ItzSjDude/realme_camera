package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.p091f.GammaEvaluator_2;
import com.airbnb.lottie.p091f.MiscUtils_2;

/* compiled from: GradientColor.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class GradientColor_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float[] f5512a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int[] f5513b;

    public GradientColor_2(float[] fArr, int[] iArr) {
        this.f5512a = fArr;
        this.f5513b = iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m5668a() {
        return this.f5512a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int[] m5669b() {
        return this.f5513b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m5670c() {
        return this.f5513b.length;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5667a(GradientColor_2 c1106c, GradientColor_2 c1106c2, float COUIBaseListPopupWindow_12) {
        if (c1106c.f5513b.length != c1106c2.f5513b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + c1106c.f5513b.length + " vs " + c1106c2.f5513b.length + ")");
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c1106c.f5513b.length; OplusGLSurfaceView_13++) {
            this.f5512a[OplusGLSurfaceView_13] = MiscUtils_2.m6127a(c1106c.f5512a[OplusGLSurfaceView_13], c1106c2.f5512a[OplusGLSurfaceView_13], COUIBaseListPopupWindow_12);
            this.f5513b[OplusGLSurfaceView_13] = GammaEvaluator_2.m6091a(COUIBaseListPopupWindow_12, c1106c.f5513b[OplusGLSurfaceView_13], c1106c2.f5513b[OplusGLSurfaceView_13]);
        }
    }
}
