package com.oplus.anim.p121f;

/* compiled from: MeanCalculator.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class MeanCalculator {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f10382a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f10383b;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9272a(float COUIBaseListPopupWindow_12) {
        this.f10382a += COUIBaseListPopupWindow_12;
        this.f10383b++;
        int OplusGLSurfaceView_13 = this.f10383b;
        if (OplusGLSurfaceView_13 == Integer.MAX_VALUE) {
            this.f10382a /= 2.0f;
            this.f10383b = OplusGLSurfaceView_13 / 2;
        }
    }
}
