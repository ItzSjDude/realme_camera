package com.airbnb.lottie.p091f;

/* compiled from: MeanCalculator.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class MeanCalculator_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f5879a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f5880b;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6125a(float COUIBaseListPopupWindow_12) {
        this.f5879a += COUIBaseListPopupWindow_12;
        this.f5880b++;
        int OplusGLSurfaceView_13 = this.f5880b;
        if (OplusGLSurfaceView_13 == Integer.MAX_VALUE) {
            this.f5879a /= 2.0f;
            this.f5880b = OplusGLSurfaceView_13 / 2;
        }
    }
}
