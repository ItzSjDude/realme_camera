package com.oplus.anim.p122g;

/* compiled from: ScaleXY.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ScaleXY {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f10435a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f10436b;

    public ScaleXY(float COUIBaseListPopupWindow_12, float f2) {
        this.f10435a = COUIBaseListPopupWindow_12;
        this.f10436b = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m9335a() {
        return this.f10435a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m9337b() {
        return this.f10436b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9336a(float COUIBaseListPopupWindow_12, float f2) {
        this.f10435a = COUIBaseListPopupWindow_12;
        this.f10436b = f2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m9338b(float COUIBaseListPopupWindow_12, float f2) {
        return this.f10435a == COUIBaseListPopupWindow_12 && this.f10436b == f2;
    }

    public String toString() {
        return m9335a() + "x" + m9337b();
    }
}
