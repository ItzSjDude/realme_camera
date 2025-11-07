package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: ShapeData.java */
/* loaded from: classes2.dex */
public class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.c_renamed.a_renamed> f3592a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.PointF f3593b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f3594c;

    public l_renamed(android.graphics.PointF pointF, boolean z_renamed, java.util.List<com.oplus.anim.c_renamed.a_renamed> list) {
        this.f3593b = pointF;
        this.f3594c = z_renamed;
        this.f3592a = new java.util.ArrayList(list);
    }

    public l_renamed() {
        this.f3592a = new java.util.ArrayList();
    }

    private void a_renamed(float f_renamed, float f2) {
        if (this.f3593b == null) {
            this.f3593b = new android.graphics.PointF();
        }
        this.f3593b.set(f_renamed, f2);
    }

    public android.graphics.PointF a_renamed() {
        return this.f3593b;
    }

    public boolean b_renamed() {
        return this.f3594c;
    }

    public java.util.List<com.oplus.anim.c_renamed.a_renamed> c_renamed() {
        return this.f3592a;
    }

    public void a_renamed(com.oplus.anim.c_renamed.b_renamed.l_renamed lVar, com.oplus.anim.c_renamed.b_renamed.l_renamed lVar2, float f_renamed) {
        if (this.f3593b == null) {
            this.f3593b = new android.graphics.PointF();
        }
        this.f3594c = lVar.b_renamed() || lVar2.b_renamed();
        if (lVar.c_renamed().size() != lVar2.c_renamed().size()) {
            com.oplus.anim.k_renamed.b_renamed("Curves must have the same number of_renamed control points. Shape 1: " + lVar.c_renamed().size() + "\tShape 2: " + lVar2.c_renamed().size());
        }
        int iMin = java.lang.Math.min(lVar.c_renamed().size(), lVar2.c_renamed().size());
        if (this.f3592a.size() < iMin) {
            for (int size = this.f3592a.size(); size < iMin; size++) {
                this.f3592a.add(new com.oplus.anim.c_renamed.a_renamed());
            }
        } else if (this.f3592a.size() > iMin) {
            for (int size2 = this.f3592a.size() - 1; size2 >= iMin; size2--) {
                java.util.List<com.oplus.anim.c_renamed.a_renamed> list = this.f3592a;
                list.remove(list.size() - 1);
            }
        }
        android.graphics.PointF pointFA = lVar.a_renamed();
        android.graphics.PointF pointFA2 = lVar2.a_renamed();
        a_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFA.x_renamed, pointFA2.x_renamed, f_renamed), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFA.y_renamed, pointFA2.y_renamed, f_renamed));
        for (int size3 = this.f3592a.size() - 1; size3 >= 0; size3--) {
            com.oplus.anim.c_renamed.a_renamed aVar = lVar.c_renamed().get(size3);
            com.oplus.anim.c_renamed.a_renamed aVar2 = lVar2.c_renamed().get(size3);
            android.graphics.PointF pointFA3 = aVar.a_renamed();
            android.graphics.PointF pointFB = aVar.b_renamed();
            android.graphics.PointF pointFC = aVar.c_renamed();
            android.graphics.PointF pointFA4 = aVar2.a_renamed();
            android.graphics.PointF pointFB2 = aVar2.b_renamed();
            android.graphics.PointF pointFC2 = aVar2.c_renamed();
            this.f3592a.get(size3).a_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFA3.x_renamed, pointFA4.x_renamed, f_renamed), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFA3.y_renamed, pointFA4.y_renamed, f_renamed));
            this.f3592a.get(size3).b_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFB.x_renamed, pointFB2.x_renamed, f_renamed), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFB.y_renamed, pointFB2.y_renamed, f_renamed));
            this.f3592a.get(size3).c_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFC.x_renamed, pointFC2.x_renamed, f_renamed), com.oplus.anim.f_renamed.e_renamed.a_renamed(pointFC.y_renamed, pointFC2.y_renamed, f_renamed));
        }
    }

    public java.lang.String toString() {
        return "ShapeData{numCurves=" + this.f3592a.size() + "closed=" + this.f3594c + '}';
    }
}
