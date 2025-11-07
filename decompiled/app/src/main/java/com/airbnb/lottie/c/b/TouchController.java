package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.c_renamed.a_renamed> f2094a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.PointF f2095b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2096c;

    public l_renamed(android.graphics.PointF pointF, boolean z_renamed, java.util.List<com.airbnb.lottie.c_renamed.a_renamed> list) {
        this.f2095b = pointF;
        this.f2096c = z_renamed;
        this.f2094a = new java.util.ArrayList(list);
    }

    public l_renamed() {
        this.f2094a = new java.util.ArrayList();
    }

    private void a_renamed(float f_renamed, float f2) {
        if (this.f2095b == null) {
            this.f2095b = new android.graphics.PointF();
        }
        this.f2095b.set(f_renamed, f2);
    }

    public android.graphics.PointF a_renamed() {
        return this.f2095b;
    }

    public boolean b_renamed() {
        return this.f2096c;
    }

    public java.util.List<com.airbnb.lottie.c_renamed.a_renamed> c_renamed() {
        return this.f2094a;
    }

    public void a_renamed(com.airbnb.lottie.c_renamed.b_renamed.l_renamed lVar, com.airbnb.lottie.c_renamed.b_renamed.l_renamed lVar2, float f_renamed) {
        if (this.f2095b == null) {
            this.f2095b = new android.graphics.PointF();
        }
        this.f2096c = lVar.b_renamed() || lVar2.b_renamed();
        if (lVar.c_renamed().size() != lVar2.c_renamed().size()) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Curves must have the same number of_renamed control points. Shape 1: " + lVar.c_renamed().size() + "\tShape 2: " + lVar2.c_renamed().size());
        }
        int iMin = java.lang.Math.min(lVar.c_renamed().size(), lVar2.c_renamed().size());
        if (this.f2094a.size() < iMin) {
            for (int size = this.f2094a.size(); size < iMin; size++) {
                this.f2094a.add(new com.airbnb.lottie.c_renamed.a_renamed());
            }
        } else if (this.f2094a.size() > iMin) {
            for (int size2 = this.f2094a.size() - 1; size2 >= iMin; size2--) {
                java.util.List<com.airbnb.lottie.c_renamed.a_renamed> list = this.f2094a;
                list.remove(list.size() - 1);
            }
        }
        android.graphics.PointF pointFA = lVar.a_renamed();
        android.graphics.PointF pointFA2 = lVar2.a_renamed();
        a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFA.x_renamed, pointFA2.x_renamed, f_renamed), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFA.y_renamed, pointFA2.y_renamed, f_renamed));
        for (int size3 = this.f2094a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.c_renamed.a_renamed aVar = lVar.c_renamed().get(size3);
            com.airbnb.lottie.c_renamed.a_renamed aVar2 = lVar2.c_renamed().get(size3);
            android.graphics.PointF pointFA3 = aVar.a_renamed();
            android.graphics.PointF pointFB = aVar.b_renamed();
            android.graphics.PointF pointFC = aVar.c_renamed();
            android.graphics.PointF pointFA4 = aVar2.a_renamed();
            android.graphics.PointF pointFB2 = aVar2.b_renamed();
            android.graphics.PointF pointFC2 = aVar2.c_renamed();
            this.f2094a.get(size3).a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFA3.x_renamed, pointFA4.x_renamed, f_renamed), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFA3.y_renamed, pointFA4.y_renamed, f_renamed));
            this.f2094a.get(size3).b_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFB.x_renamed, pointFB2.x_renamed, f_renamed), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFB.y_renamed, pointFB2.y_renamed, f_renamed));
            this.f2094a.get(size3).c_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFC.x_renamed, pointFC2.x_renamed, f_renamed), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointFC.y_renamed, pointFC2.y_renamed, f_renamed));
        }
    }

    public java.lang.String toString() {
        return "ShapeData{numCurves=" + this.f2094a.size() + "closed=" + this.f2096c + '}';
    }
}
