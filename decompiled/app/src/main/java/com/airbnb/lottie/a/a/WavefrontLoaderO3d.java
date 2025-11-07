package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class o_renamed implements com.airbnb.lottie.a_renamed.a_renamed.k_renamed, com.airbnb.lottie.a_renamed.a_renamed.m_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f2017c;
    private final boolean d_renamed;
    private final com.airbnb.lottie.f_renamed e_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> f_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> g_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> h_renamed;
    private boolean j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f2015a = new android.graphics.Path();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.RectF f2016b = new android.graphics.RectF();
    private com.airbnb.lottie.a_renamed.a_renamed.b_renamed i_renamed = new com.airbnb.lottie.a_renamed.a_renamed.b_renamed();

    public o_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.j_renamed jVar) {
        this.f2017c = jVar.a_renamed();
        this.d_renamed = jVar.e_renamed();
        this.e_renamed = fVar;
        this.f_renamed = jVar.d_renamed().a_renamed();
        this.g_renamed = jVar.c_renamed().a_renamed();
        this.h_renamed = jVar.b_renamed().a_renamed();
        aVar.a_renamed(this.f_renamed);
        aVar.a_renamed(this.g_renamed);
        aVar.a_renamed(this.h_renamed);
        this.f_renamed.a_renamed(this);
        this.g_renamed.a_renamed(this);
        this.h_renamed.a_renamed(this);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2017c;
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.j_renamed = false;
        this.e_renamed.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.s_renamed) {
                com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar = (com.airbnb.lottie.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.i_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.j_renamed) {
            return this.f2015a;
        }
        this.f2015a.reset();
        if (this.d_renamed) {
            this.j_renamed = true;
            return this.f2015a;
        }
        android.graphics.PointF pointFG = this.g_renamed.g_renamed();
        float f_renamed = pointFG.x_renamed / 2.0f;
        float f2 = pointFG.y_renamed / 2.0f;
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar = this.h_renamed;
        float fI_renamed = aVar == null ? 0.0f : ((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) aVar).i_renamed();
        float fMin = java.lang.Math.min(f_renamed, f2);
        if (fI_renamed > fMin) {
            fI_renamed = fMin;
        }
        android.graphics.PointF pointFG2 = this.f_renamed.g_renamed();
        this.f2015a.moveTo(pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed - f2) + fI_renamed);
        this.f2015a.lineTo(pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed + f2) - fI_renamed);
        if (fI_renamed > 0.0f) {
            float f3 = fI_renamed * 2.0f;
            this.f2016b.set((pointFG2.x_renamed + f_renamed) - f3, (pointFG2.y_renamed + f2) - f3, pointFG2.x_renamed + f_renamed, pointFG2.y_renamed + f2);
            this.f2015a.arcTo(this.f2016b, 0.0f, 90.0f, false);
        }
        this.f2015a.lineTo((pointFG2.x_renamed - f_renamed) + fI_renamed, pointFG2.y_renamed + f2);
        if (fI_renamed > 0.0f) {
            float f4 = fI_renamed * 2.0f;
            this.f2016b.set(pointFG2.x_renamed - f_renamed, (pointFG2.y_renamed + f2) - f4, (pointFG2.x_renamed - f_renamed) + f4, pointFG2.y_renamed + f2);
            this.f2015a.arcTo(this.f2016b, 90.0f, 90.0f, false);
        }
        this.f2015a.lineTo(pointFG2.x_renamed - f_renamed, (pointFG2.y_renamed - f2) + fI_renamed);
        if (fI_renamed > 0.0f) {
            float f5 = fI_renamed * 2.0f;
            this.f2016b.set(pointFG2.x_renamed - f_renamed, pointFG2.y_renamed - f2, (pointFG2.x_renamed - f_renamed) + f5, (pointFG2.y_renamed - f2) + f5);
            this.f2015a.arcTo(this.f2016b, 180.0f, 90.0f, false);
        }
        this.f2015a.lineTo((pointFG2.x_renamed + f_renamed) - fI_renamed, pointFG2.y_renamed - f2);
        if (fI_renamed > 0.0f) {
            float f6 = fI_renamed * 2.0f;
            this.f2016b.set((pointFG2.x_renamed + f_renamed) - f6, pointFG2.y_renamed - f2, pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed - f2) + f6);
            this.f2015a.arcTo(this.f2016b, 270.0f, 90.0f, false);
        }
        this.f2015a.close();
        this.i_renamed.a_renamed(this.f2015a);
        this.j_renamed = true;
        return this.f2015a;
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.f_renamed.g_renamed.a_renamed(eVar, i_renamed, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        if (t_renamed == com.airbnb.lottie.k_renamed.j_renamed) {
            this.g_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<android.graphics.PointF>) cVar);
        } else if (t_renamed == com.airbnb.lottie.k_renamed.l_renamed) {
            this.f_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<android.graphics.PointF>) cVar);
        } else if (t_renamed == com.airbnb.lottie.k_renamed.k_renamed) {
            this.h_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
        }
    }
}
