package com.oplus.anim.p115c.p117b;

import com.oplus.anim.p121f.GammaEvaluator;
import com.oplus.anim.p121f.MiscUtils;

/* compiled from: GradientColor.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class GradientColor {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float[] f10134a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int[] f10135b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f10134a = fArr;
        this.f10135b = iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m8979a() {
        return this.f10134a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int[] m8980b() {
        return this.f10135b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m8981c() {
        return this.f10135b.length;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8978a(GradientColor c2331c, GradientColor c2331c2, float COUIBaseListPopupWindow_12) {
        if (c2331c.f10135b.length != c2331c2.f10135b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + c2331c.f10135b.length + " vs " + c2331c2.f10135b.length + ")");
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c2331c.f10135b.length; OplusGLSurfaceView_13++) {
            this.f10134a[OplusGLSurfaceView_13] = MiscUtils.m9274a(c2331c.f10134a[OplusGLSurfaceView_13], c2331c2.f10134a[OplusGLSurfaceView_13], COUIBaseListPopupWindow_12);
            this.f10135b[OplusGLSurfaceView_13] = GammaEvaluator.m9270a(COUIBaseListPopupWindow_12, c2331c.f10135b[OplusGLSurfaceView_13], c2331c2.f10135b[OplusGLSurfaceView_13]);
        }
    }
}
