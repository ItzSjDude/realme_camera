package com.airbnb.lottie.p092g;

/* compiled from: ScaleXY.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class ScaleXY_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f5920a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f5921b;

    public ScaleXY_2(float COUIBaseListPopupWindow_12, float f2) {
        this.f5920a = COUIBaseListPopupWindow_12;
        this.f5921b = f2;
    }

    public ScaleXY_2() {
        this(1.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m6175a() {
        return this.f5920a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m6177b() {
        return this.f5921b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6176a(float COUIBaseListPopupWindow_12, float f2) {
        this.f5920a = COUIBaseListPopupWindow_12;
        this.f5921b = f2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6178b(float COUIBaseListPopupWindow_12, float f2) {
        return this.f5920a == COUIBaseListPopupWindow_12 && this.f5921b == f2;
    }

    public String toString() {
        return m6175a() + "x" + m6177b();
    }
}
