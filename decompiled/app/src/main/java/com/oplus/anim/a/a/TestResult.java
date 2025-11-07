package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: GradientFillContent.java */
/* loaded from: classes2.dex */
public class h_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3471a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final boolean f3472b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.c_renamed.a_renamed f3473c;
    private final android.util.LongSparseArray<android.graphics.LinearGradient> d_renamed = new android.util.LongSparseArray<>();
    private final android.util.LongSparseArray<android.graphics.RadialGradient> e_renamed = new android.util.LongSparseArray<>();
    private final android.graphics.Matrix f_renamed = new android.graphics.Matrix();
    private final android.graphics.Path g_renamed = new android.graphics.Path();
    private final android.graphics.Paint h_renamed = new com.oplus.anim.a_renamed.a_renamed(1);
    private final android.graphics.RectF i_renamed = new android.graphics.RectF();
    private final java.util.List<com.oplus.anim.a_renamed.a_renamed.m_renamed> j_renamed = new java.util.ArrayList();
    private final com.oplus.anim.c_renamed.b_renamed.f_renamed k_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed, com.oplus.anim.c_renamed.b_renamed.c_renamed> l_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> m_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> n_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> o_renamed;
    private final com.oplus.anim.b_renamed p_renamed;
    private final int q_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> r_renamed;

    public h_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.d_renamed dVar) {
        this.f3473c = aVar;
        this.f3471a = dVar.a_renamed();
        this.f3472b = dVar.h_renamed();
        this.p_renamed = bVar;
        this.k_renamed = dVar.b_renamed();
        this.g_renamed.setFillType(dVar.c_renamed());
        this.q_renamed = (int) (bVar.r_renamed().e_renamed() / 32.0f);
        this.l_renamed = dVar.d_renamed().a_renamed();
        this.l_renamed.a_renamed(this);
        aVar.a_renamed(this.l_renamed);
        this.m_renamed = dVar.e_renamed().a_renamed();
        this.m_renamed.a_renamed(this);
        aVar.a_renamed(this.m_renamed);
        this.n_renamed = dVar.f_renamed().a_renamed();
        this.n_renamed.a_renamed(this);
        aVar.a_renamed(this.n_renamed);
        this.o_renamed = dVar.g_renamed().a_renamed();
        this.o_renamed.a_renamed(this);
        aVar.a_renamed(this.o_renamed);
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        this.p_renamed.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list2.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list2.get(i_renamed);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.m_renamed) {
                this.j_renamed.add((com.oplus.anim.a_renamed.a_renamed.m_renamed) cVar);
            }
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        android.graphics.Shader shaderD;
        if (this.f3472b) {
            return;
        }
        com.oplus.anim.k_renamed.c_renamed("GradientFillContent#draw");
        this.g_renamed.reset();
        for (int i2 = 0; i2 < this.j_renamed.size(); i2++) {
            this.g_renamed.addPath(this.j_renamed.get(i2).e_renamed(), matrix);
        }
        this.g_renamed.computeBounds(this.i_renamed, false);
        if (this.k_renamed == com.oplus.anim.c_renamed.b_renamed.f_renamed.LINEAR) {
            shaderD = c_renamed();
        } else {
            shaderD = d_renamed();
        }
        this.f_renamed.set(matrix);
        shaderD.setLocalMatrix(this.f_renamed);
        this.h_renamed.setShader(shaderD);
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.r_renamed;
        if (aVar != null) {
            this.h_renamed.setColorFilter(aVar.g_renamed());
        }
        this.h_renamed.setAlpha(com.oplus.anim.f_renamed.e_renamed.a_renamed((int) ((((i_renamed / 255.0f) * this.m_renamed.g_renamed().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.g_renamed, this.h_renamed);
        com.oplus.anim.k_renamed.d_renamed("GradientFillContent#draw");
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.g_renamed.reset();
        for (int i_renamed = 0; i_renamed < this.j_renamed.size(); i_renamed++) {
            this.g_renamed.addPath(this.j_renamed.get(i_renamed).e_renamed(), matrix);
        }
        this.g_renamed.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3471a;
    }

    private android.graphics.LinearGradient c_renamed() {
        long jE = e_renamed();
        android.graphics.LinearGradient linearGradient = this.d_renamed.get(jE);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF pointFG = this.n_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.o_renamed.g_renamed();
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVarG = this.l_renamed.g_renamed();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(pointFG.x_renamed, pointFG.y_renamed, pointFG2.x_renamed, pointFG2.y_renamed, cVarG.b_renamed(), cVarG.a_renamed(), android.graphics.Shader.TileMode.CLAMP);
        this.d_renamed.put(jE, linearGradient2);
        return linearGradient2;
    }

    private android.graphics.RadialGradient d_renamed() {
        long jE = e_renamed();
        android.graphics.RadialGradient radialGradient = this.e_renamed.get(jE);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF pointFG = this.n_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.o_renamed.g_renamed();
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVarG = this.l_renamed.g_renamed();
        int[] iArrB = cVarG.b_renamed();
        float[] fArrA = cVarG.a_renamed();
        float f_renamed = pointFG.x_renamed;
        float f2 = pointFG.y_renamed;
        float fHypot = (float) java.lang.Math.hypot(pointFG2.x_renamed - f_renamed, pointFG2.y_renamed - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient(f_renamed, f2, fHypot, iArrB, fArrA, android.graphics.Shader.TileMode.CLAMP);
        this.e_renamed.put(jE, radialGradient2);
        return radialGradient2;
    }

    private int e_renamed() {
        int iRound = java.lang.Math.round(this.n_renamed.h_renamed() * this.q_renamed);
        int iRound2 = java.lang.Math.round(this.o_renamed.h_renamed() * this.q_renamed);
        int iRound3 = java.lang.Math.round(this.l_renamed.h_renamed() * this.q_renamed);
        int i_renamed = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i_renamed = i_renamed * 31 * iRound2;
        }
        return iRound3 != 0 ? i_renamed * 31 * iRound3 : i_renamed;
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (t_renamed == com.oplus.anim.d_renamed.z_renamed) {
            if (bVar == null) {
                this.r_renamed = null;
                return;
            }
            this.r_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
            this.r_renamed.a_renamed(this);
            this.f3473c.a_renamed(this.r_renamed);
        }
    }
}
