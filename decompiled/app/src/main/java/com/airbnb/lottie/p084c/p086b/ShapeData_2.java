package com.airbnb.lottie.p084c.p086b;

import android.graphics.PointF;
import com.airbnb.lottie.p084c.CubicCurveData_2;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class ShapeData_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<CubicCurveData_2> f5564a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PointF f5565b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f5566c;

    public ShapeData_2(PointF pointF, boolean z, List<CubicCurveData_2> list) {
        this.f5565b = pointF;
        this.f5566c = z;
        this.f5564a = new ArrayList(list);
    }

    public ShapeData_2() {
        this.f5564a = new ArrayList();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5719a(float COUIBaseListPopupWindow_12, float f2) {
        if (this.f5565b == null) {
            this.f5565b = new PointF();
        }
        this.f5565b.set(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PointF m5720a() {
        return this.f5565b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m5722b() {
        return this.f5566c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<CubicCurveData_2> m5723c() {
        return this.f5564a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5721a(ShapeData_2 c1115l, ShapeData_2 c1115l2, float COUIBaseListPopupWindow_12) {
        if (this.f5565b == null) {
            this.f5565b = new PointF();
        }
        this.f5566c = c1115l.m5722b() || c1115l2.m5722b();
        if (c1115l.m5723c().size() != c1115l2.m5723c().size()) {
            Logger_3.m6100b("Curves must have the same number of control points. Shape 1: " + c1115l.m5723c().size() + "\tShape 2: " + c1115l2.m5723c().size());
        }
        int iMin = Math.min(c1115l.m5723c().size(), c1115l2.m5723c().size());
        if (this.f5564a.size() < iMin) {
            for (int size = this.f5564a.size(); size < iMin; size++) {
                this.f5564a.add(new CubicCurveData_2());
            }
        } else if (this.f5564a.size() > iMin) {
            for (int size2 = this.f5564a.size() - 1; size2 >= iMin; size2--) {
                List<CubicCurveData_2> list = this.f5564a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFM5720a = c1115l.m5720a();
        PointF pointFM5720a2 = c1115l2.m5720a();
        m5719a(MiscUtils_2.m6127a(pointFM5720a.x, pointFM5720a2.x, COUIBaseListPopupWindow_12), MiscUtils_2.m6127a(pointFM5720a.y, pointFM5720a2.y, COUIBaseListPopupWindow_12));
        for (int size3 = this.f5564a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData_2 c1088a = c1115l.m5723c().get(size3);
            CubicCurveData_2 c1088a2 = c1115l2.m5723c().get(size3);
            PointF pointFM5641a = c1088a.m5641a();
            PointF pointFM5643b = c1088a.m5643b();
            PointF pointFM5645c = c1088a.m5645c();
            PointF pointFM5641a2 = c1088a2.m5641a();
            PointF pointFM5643b2 = c1088a2.m5643b();
            PointF pointFM5645c2 = c1088a2.m5645c();
            this.f5564a.get(size3).m5642a(MiscUtils_2.m6127a(pointFM5641a.x, pointFM5641a2.x, COUIBaseListPopupWindow_12), MiscUtils_2.m6127a(pointFM5641a.y, pointFM5641a2.y, COUIBaseListPopupWindow_12));
            this.f5564a.get(size3).m5644b(MiscUtils_2.m6127a(pointFM5643b.x, pointFM5643b2.x, COUIBaseListPopupWindow_12), MiscUtils_2.m6127a(pointFM5643b.y, pointFM5643b2.y, COUIBaseListPopupWindow_12));
            this.f5564a.get(size3).m5646c(MiscUtils_2.m6127a(pointFM5645c.x, pointFM5645c2.x, COUIBaseListPopupWindow_12), MiscUtils_2.m6127a(pointFM5645c.y, pointFM5645c2.y, COUIBaseListPopupWindow_12));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f5564a.size() + "closed=" + this.f5566c + '}';
    }
}
