package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g_renamed implements com.airbnb.lottie.a_renamed.a_renamed.e_renamed, com.airbnb.lottie.a_renamed.a_renamed.k_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.c_renamed.a_renamed f2002c;
    private final java.lang.String d_renamed;
    private final boolean e_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> g_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> h_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> i_renamed;
    private final com.airbnb.lottie.f_renamed j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f2000a = new android.graphics.Path();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Paint f2001b = new com.airbnb.lottie.a_renamed.a_renamed(1);
    private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> f_renamed = new java.util.ArrayList();

    public g_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.m_renamed mVar) {
        this.f2002c = aVar;
        this.d_renamed = mVar.a_renamed();
        this.e_renamed = mVar.e_renamed();
        this.j_renamed = fVar;
        if (mVar.b_renamed() == null || mVar.c_renamed() == null) {
            this.g_renamed = null;
            this.h_renamed = null;
            return;
        }
        this.f2000a.setFillType(mVar.d_renamed());
        this.g_renamed = mVar.b_renamed().a_renamed();
        this.g_renamed.a_renamed(this);
        aVar.a_renamed(this.g_renamed);
        this.h_renamed = mVar.c_renamed().a_renamed();
        this.h_renamed.a_renamed(this);
        aVar.a_renamed(this.h_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        this.j_renamed.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list2.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list2.get(i_renamed);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed) {
                this.f_renamed.add((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.e_renamed) {
            return;
        }
        com.airbnb.lottie.c_renamed.a_renamed("FillContent#draw");
        this.f2001b.setColor(((com.airbnb.lottie.a_renamed.b_renamed.b_renamed) this.g_renamed).i_renamed());
        this.f2001b.setAlpha(com.airbnb.lottie.f_renamed.g_renamed.a_renamed((int) ((((i_renamed / 255.0f) * this.h_renamed.g_renamed().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.i_renamed;
        if (aVar != null) {
            this.f2001b.setColorFilter(aVar.g_renamed());
        }
        this.f2000a.reset();
        for (int i2 = 0; i2 < this.f_renamed.size(); i2++) {
            this.f2000a.addPath(this.f_renamed.get(i2).e_renamed(), matrix);
        }
        canvas.drawPath(this.f2000a, this.f2001b);
        com.airbnb.lottie.c_renamed.b_renamed("FillContent#draw");
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.f2000a.reset();
        for (int i_renamed = 0; i_renamed < this.f_renamed.size(); i_renamed++) {
            this.f2000a.addPath(this.f_renamed.get(i_renamed).e_renamed(), matrix);
        }
        this.f2000a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.f_renamed.g_renamed.a_renamed(eVar, i_renamed, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        if (t_renamed == com.airbnb.lottie.k_renamed.f2277a) {
            this.g_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Integer>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.d_renamed) {
            this.h_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Integer>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.E_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.i_renamed;
            if (aVar != null) {
                this.f2002c.b_renamed(aVar);
            }
            if (cVar == null) {
                this.i_renamed = null;
                return;
            }
            this.i_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.i_renamed.a_renamed(this);
            this.f2002c.a_renamed(this.i_renamed);
        }
    }
}
