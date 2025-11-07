package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: RectangleContent.java */
/* loaded from: classes2.dex */
public class o_renamed implements com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.a_renamed.m_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f3486c;
    private final boolean d_renamed;
    private final com.oplus.anim.b_renamed e_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> f_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> g_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> h_renamed;
    private boolean j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f3484a = new android.graphics.Path();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.RectF f3485b = new android.graphics.RectF();
    private com.oplus.anim.a_renamed.a_renamed.b_renamed i_renamed = new com.oplus.anim.a_renamed.a_renamed.b_renamed();

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
    }

    public o_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.j_renamed jVar) {
        this.f3486c = jVar.a_renamed();
        this.d_renamed = jVar.e_renamed();
        this.e_renamed = bVar;
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

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3486c;
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.j_renamed = false;
        this.e_renamed.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.s_renamed) {
                com.oplus.anim.a_renamed.a_renamed.s_renamed sVar = (com.oplus.anim.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.i_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.j_renamed) {
            return this.f3484a;
        }
        this.f3484a.reset();
        if (this.d_renamed) {
            this.j_renamed = true;
            return this.f3484a;
        }
        android.graphics.PointF pointFG = this.g_renamed.g_renamed();
        float f_renamed = pointFG.x_renamed / 2.0f;
        float f2 = pointFG.y_renamed / 2.0f;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar = this.h_renamed;
        float fI_renamed = aVar == null ? 0.0f : ((com.oplus.anim.a_renamed.b_renamed.c_renamed) aVar).i_renamed();
        float fMin = java.lang.Math.min(f_renamed, f2);
        if (fI_renamed > fMin) {
            fI_renamed = fMin;
        }
        android.graphics.PointF pointFG2 = this.f_renamed.g_renamed();
        this.f3484a.moveTo(pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed - f2) + fI_renamed);
        this.f3484a.lineTo(pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed + f2) - fI_renamed);
        if (fI_renamed > 0.0f) {
            float f3 = fI_renamed * 2.0f;
            this.f3485b.set((pointFG2.x_renamed + f_renamed) - f3, (pointFG2.y_renamed + f2) - f3, pointFG2.x_renamed + f_renamed, pointFG2.y_renamed + f2);
            this.f3484a.arcTo(this.f3485b, 0.0f, 90.0f, false);
        }
        this.f3484a.lineTo((pointFG2.x_renamed - f_renamed) + fI_renamed, pointFG2.y_renamed + f2);
        if (fI_renamed > 0.0f) {
            float f4 = fI_renamed * 2.0f;
            this.f3485b.set(pointFG2.x_renamed - f_renamed, (pointFG2.y_renamed + f2) - f4, (pointFG2.x_renamed - f_renamed) + f4, pointFG2.y_renamed + f2);
            this.f3484a.arcTo(this.f3485b, 90.0f, 90.0f, false);
        }
        this.f3484a.lineTo(pointFG2.x_renamed - f_renamed, (pointFG2.y_renamed - f2) + fI_renamed);
        if (fI_renamed > 0.0f) {
            float f5 = fI_renamed * 2.0f;
            this.f3485b.set(pointFG2.x_renamed - f_renamed, pointFG2.y_renamed - f2, (pointFG2.x_renamed - f_renamed) + f5, (pointFG2.y_renamed - f2) + f5);
            this.f3484a.arcTo(this.f3485b, 180.0f, 90.0f, false);
        }
        this.f3484a.lineTo((pointFG2.x_renamed + f_renamed) - fI_renamed, pointFG2.y_renamed - f2);
        if (fI_renamed > 0.0f) {
            float f6 = fI_renamed * 2.0f;
            this.f3485b.set((pointFG2.x_renamed + f_renamed) - f6, pointFG2.y_renamed - f2, pointFG2.x_renamed + f_renamed, (pointFG2.y_renamed - f2) + f6);
            this.f3484a.arcTo(this.f3485b, 270.0f, 90.0f, false);
        }
        this.f3484a.close();
        this.i_renamed.a_renamed(this.f3484a);
        this.j_renamed = true;
        return this.f3484a;
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }
}
