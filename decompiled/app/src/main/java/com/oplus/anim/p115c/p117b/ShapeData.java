package com.oplus.anim.p115c.p117b;

import android.graphics.PointF;
import com.oplus.anim.L;
import com.oplus.anim.p115c.CubicCurveData;
import com.oplus.anim.p121f.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class ShapeData {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<CubicCurveData> f10186a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PointF f10187b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f10188c;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.f10187b = pointF;
        this.f10188c = z;
        this.f10186a = new ArrayList(list);
    }

    public ShapeData() {
        this.f10186a = new ArrayList();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9030a(float COUIBaseListPopupWindow_12, float f2) {
        if (this.f10187b == null) {
            this.f10187b = new PointF();
        }
        this.f10187b.set(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PointF m9031a() {
        return this.f10187b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m9033b() {
        return this.f10188c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<CubicCurveData> m9034c() {
        return this.f10186a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9032a(ShapeData c2340l, ShapeData c2340l2, float COUIBaseListPopupWindow_12) {
        if (this.f10187b == null) {
            this.f10187b = new PointF();
        }
        this.f10188c = c2340l.m9033b() || c2340l2.m9033b();
        if (c2340l.m9034c().size() != c2340l2.m9034c().size()) {
            L.m9348b("Curves must have the same number of control points. Shape 1: " + c2340l.m9034c().size() + "\tShape 2: " + c2340l2.m9034c().size());
        }
        int iMin = Math.min(c2340l.m9034c().size(), c2340l2.m9034c().size());
        if (this.f10186a.size() < iMin) {
            for (int size = this.f10186a.size(); size < iMin; size++) {
                this.f10186a.add(new CubicCurveData());
            }
        } else if (this.f10186a.size() > iMin) {
            for (int size2 = this.f10186a.size() - 1; size2 >= iMin; size2--) {
                List<CubicCurveData> list = this.f10186a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFM9031a = c2340l.m9031a();
        PointF pointFM9031a2 = c2340l2.m9031a();
        m9030a(MiscUtils.m9274a(pointFM9031a.x, pointFM9031a2.x, COUIBaseListPopupWindow_12), MiscUtils.m9274a(pointFM9031a.y, pointFM9031a2.y, COUIBaseListPopupWindow_12));
        for (int size3 = this.f10186a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData c2313a = c2340l.m9034c().get(size3);
            CubicCurveData c2313a2 = c2340l2.m9034c().get(size3);
            PointF pointFM8951a = c2313a.m8951a();
            PointF pointFM8953b = c2313a.m8953b();
            PointF pointFM8955c = c2313a.m8955c();
            PointF pointFM8951a2 = c2313a2.m8951a();
            PointF pointFM8953b2 = c2313a2.m8953b();
            PointF pointFM8955c2 = c2313a2.m8955c();
            this.f10186a.get(size3).m8952a(MiscUtils.m9274a(pointFM8951a.x, pointFM8951a2.x, COUIBaseListPopupWindow_12), MiscUtils.m9274a(pointFM8951a.y, pointFM8951a2.y, COUIBaseListPopupWindow_12));
            this.f10186a.get(size3).m8954b(MiscUtils.m9274a(pointFM8953b.x, pointFM8953b2.x, COUIBaseListPopupWindow_12), MiscUtils.m9274a(pointFM8953b.y, pointFM8953b2.y, COUIBaseListPopupWindow_12));
            this.f10186a.get(size3).m8956c(MiscUtils.m9274a(pointFM8955c.x, pointFM8955c2.x, COUIBaseListPopupWindow_12), MiscUtils.m9274a(pointFM8955c.y, pointFM8955c2.y, COUIBaseListPopupWindow_12));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f10186a.size() + "closed=" + this.f10188c + '}';
    }
}
