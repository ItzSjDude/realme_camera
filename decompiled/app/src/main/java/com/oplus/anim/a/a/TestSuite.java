package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.oplus.anim.a_renamed.a_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f3474b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f3475c;
    private final android.util.LongSparseArray<android.graphics.LinearGradient> d_renamed;
    private final android.util.LongSparseArray<android.graphics.RadialGradient> e_renamed;
    private final android.graphics.RectF f_renamed;
    private final com.oplus.anim.c_renamed.b_renamed.f_renamed g_renamed;
    private final int h_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.c_renamed, com.oplus.anim.c_renamed.b_renamed.c_renamed> i_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> j_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> k_renamed;

    public i_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.e_renamed eVar) {
        super(bVar, aVar, eVar.h_renamed().toPaintCap(), eVar.i_renamed().toPaintJoin(), eVar.l_renamed(), eVar.d_renamed(), eVar.g_renamed(), eVar.j_renamed(), eVar.k_renamed());
        this.d_renamed = new android.util.LongSparseArray<>();
        this.e_renamed = new android.util.LongSparseArray<>();
        this.f_renamed = new android.graphics.RectF();
        this.f3474b = eVar.a_renamed();
        this.g_renamed = eVar.b_renamed();
        this.f3475c = eVar.m_renamed();
        this.h_renamed = (int) (bVar.r_renamed().e_renamed() / 32.0f);
        this.i_renamed = eVar.c_renamed().a_renamed();
        this.i_renamed.a_renamed(this);
        aVar.a_renamed(this.i_renamed);
        this.j_renamed = eVar.e_renamed().a_renamed();
        this.j_renamed.a_renamed(this);
        aVar.a_renamed(this.j_renamed);
        this.k_renamed = eVar.f_renamed().a_renamed();
        this.k_renamed.a_renamed(this);
        aVar.a_renamed(this.k_renamed);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.f3475c) {
            return;
        }
        a_renamed(this.f_renamed, matrix, false);
        if (this.g_renamed == com.oplus.anim.c_renamed.b_renamed.f_renamed.LINEAR) {
            this.f3456a.setShader(c_renamed());
        } else {
            this.f3456a.setShader(d_renamed());
        }
        super.a_renamed(canvas, matrix, i_renamed);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3474b;
    }

    private android.graphics.LinearGradient c_renamed() {
        long jE = e_renamed();
        android.graphics.LinearGradient linearGradient = this.d_renamed.get(jE);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF pointFG = this.j_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.k_renamed.g_renamed();
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVarG = this.i_renamed.g_renamed();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient((int) (this.f_renamed.left + (this.f_renamed.width() / 2.0f) + pointFG.x_renamed), (int) (this.f_renamed.top + (this.f_renamed.height() / 2.0f) + pointFG.y_renamed), (int) (this.f_renamed.left + (this.f_renamed.width() / 2.0f) + pointFG2.x_renamed), (int) (this.f_renamed.top + (this.f_renamed.height() / 2.0f) + pointFG2.y_renamed), cVarG.b_renamed(), cVarG.a_renamed(), android.graphics.Shader.TileMode.CLAMP);
        this.d_renamed.put(jE, linearGradient2);
        return linearGradient2;
    }

    private android.graphics.RadialGradient d_renamed() {
        long jE = e_renamed();
        android.graphics.RadialGradient radialGradient = this.e_renamed.get(jE);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF pointFG = this.j_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.k_renamed.g_renamed();
        com.oplus.anim.c_renamed.b_renamed.c_renamed cVarG = this.i_renamed.g_renamed();
        int[] iArrB = cVarG.b_renamed();
        float[] fArrA = cVarG.a_renamed();
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient((int) (this.f_renamed.left + (this.f_renamed.width() / 2.0f) + pointFG.x_renamed), (int) (this.f_renamed.top + (this.f_renamed.height() / 2.0f) + pointFG.y_renamed), (float) java.lang.Math.hypot(((int) ((this.f_renamed.left + (this.f_renamed.width() / 2.0f)) + pointFG2.x_renamed)) - r4, ((int) ((this.f_renamed.top + (this.f_renamed.height() / 2.0f)) + pointFG2.y_renamed)) - r0), iArrB, fArrA, android.graphics.Shader.TileMode.CLAMP);
        this.e_renamed.put(jE, radialGradient2);
        return radialGradient2;
    }

    private int e_renamed() {
        int iRound = java.lang.Math.round(this.j_renamed.h_renamed() * this.h_renamed);
        int iRound2 = java.lang.Math.round(this.k_renamed.h_renamed() * this.h_renamed);
        int iRound3 = java.lang.Math.round(this.i_renamed.h_renamed() * this.h_renamed);
        int i_renamed = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i_renamed = i_renamed * 31 * iRound2;
        }
        return iRound3 != 0 ? i_renamed * 31 * iRound3 : i_renamed;
    }
}
