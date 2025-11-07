package com.oplus.anim.p115c;

import android.graphics.PointF;

/* compiled from: CubicCurveData.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class CubicCurveData {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PointF f10098a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PointF f10099b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PointF f10100c;

    public CubicCurveData() {
        this.f10098a = new PointF();
        this.f10099b = new PointF();
        this.f10100c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f10098a = pointF;
        this.f10099b = pointF2;
        this.f10100c = pointF3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8952a(float COUIBaseListPopupWindow_12, float f2) {
        this.f10098a.set(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PointF m8951a() {
        return this.f10098a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8954b(float COUIBaseListPopupWindow_12, float f2) {
        this.f10099b.set(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PointF m8953b() {
        return this.f10099b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8956c(float COUIBaseListPopupWindow_12, float f2) {
        this.f10100c.set(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PointF m8955c() {
        return this.f10100c;
    }
}
