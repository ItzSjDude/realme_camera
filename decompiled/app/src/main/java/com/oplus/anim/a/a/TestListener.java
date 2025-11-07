package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: FillContent.java */
/* loaded from: classes2.dex */
public class g_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.c_renamed.a_renamed f3470c;
    private final java.lang.String d_renamed;
    private final boolean e_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> g_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> h_renamed;
    private final com.oplus.anim.b_renamed i_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f3468a = new android.graphics.Path();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Paint f3469b = new com.oplus.anim.a_renamed.a_renamed(1);
    private final java.util.List<com.oplus.anim.a_renamed.a_renamed.m_renamed> f_renamed = new java.util.ArrayList();

    public g_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.m_renamed mVar) {
        this.f3470c = aVar;
        this.d_renamed = mVar.a_renamed();
        this.e_renamed = mVar.e_renamed();
        this.i_renamed = bVar;
        if (mVar.b_renamed() == null || mVar.c_renamed() == null) {
            this.g_renamed = null;
            this.h_renamed = null;
            return;
        }
        this.f3468a.setFillType(mVar.d_renamed());
        this.g_renamed = mVar.b_renamed().a_renamed();
        this.g_renamed.a_renamed(this);
        aVar.a_renamed(this.g_renamed);
        this.h_renamed = mVar.c_renamed().a_renamed();
        this.h_renamed.a_renamed(this);
        aVar.a_renamed(this.h_renamed);
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        this.i_renamed.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list2.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list2.get(i_renamed);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.m_renamed) {
                this.f_renamed.add((com.oplus.anim.a_renamed.a_renamed.m_renamed) cVar);
            }
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.e_renamed) {
            return;
        }
        com.oplus.anim.k_renamed.c_renamed("FillContent#draw");
        this.f3469b.setColor(((com.oplus.anim.a_renamed.b_renamed.b_renamed) this.g_renamed).i_renamed());
        this.f3469b.setAlpha(com.oplus.anim.f_renamed.e_renamed.a_renamed((int) ((((i_renamed / 255.0f) * this.h_renamed.g_renamed().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.j_renamed;
        if (aVar != null) {
            this.f3469b.setColorFilter(aVar.g_renamed());
        }
        this.f3468a.reset();
        for (int i2 = 0; i2 < this.f_renamed.size(); i2++) {
            this.f3468a.addPath(this.f_renamed.get(i2).e_renamed(), matrix);
        }
        canvas.drawPath(this.f3468a, this.f3469b);
        com.oplus.anim.k_renamed.d_renamed("FillContent#draw");
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.f3468a.reset();
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            this.f3468a.addPath(this.f_renamed.get(i_renamed).e_renamed(), matrix);
        }
        this.f3468a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (t_renamed == com.oplus.anim.d_renamed.f3641a) {
            this.g_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.d_renamed) {
            this.h_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.z_renamed) {
            if (bVar == null) {
                this.j_renamed = null;
                return;
            }
            this.j_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
            this.j_renamed.a_renamed(this);
            this.f3470c.a_renamed(this.j_renamed);
        }
    }
}
