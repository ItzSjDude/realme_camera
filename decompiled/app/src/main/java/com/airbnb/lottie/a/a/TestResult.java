package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h_renamed implements com.airbnb.lottie.a_renamed.a_renamed.e_renamed, com.airbnb.lottie.a_renamed.a_renamed.k_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2003a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final boolean f2004b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.c_renamed.a_renamed f2005c;
    private final androidx.collection.LongSparseArray<android.graphics.LinearGradient> d_renamed = new androidx.collection.LongSparseArray<>();
    private final androidx.collection.LongSparseArray<android.graphics.RadialGradient> e_renamed = new androidx.collection.LongSparseArray<>();
    private final android.graphics.Path f_renamed = new android.graphics.Path();
    private final android.graphics.Paint g_renamed = new com.airbnb.lottie.a_renamed.a_renamed(1);
    private final android.graphics.RectF h_renamed = new android.graphics.RectF();
    private final java.util.List<com.airbnb.lottie.a_renamed.a_renamed.m_renamed> i_renamed = new java.util.ArrayList();
    private final com.airbnb.lottie.c_renamed.b_renamed.f_renamed j_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.c_renamed, com.airbnb.lottie.c_renamed.b_renamed.c_renamed> k_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> l_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> m_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> n_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> o_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.p_renamed p_renamed;
    private final com.airbnb.lottie.f_renamed q_renamed;
    private final int r_renamed;

    public h_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.d_renamed dVar) {
        this.f2005c = aVar;
        this.f2003a = dVar.a_renamed();
        this.f2004b = dVar.h_renamed();
        this.q_renamed = fVar;
        this.j_renamed = dVar.b_renamed();
        this.f_renamed.setFillType(dVar.c_renamed());
        this.r_renamed = (int) (fVar.t_renamed().e_renamed() / 32.0f);
        this.k_renamed = dVar.d_renamed().a_renamed();
        this.k_renamed.a_renamed(this);
        aVar.a_renamed(this.k_renamed);
        this.l_renamed = dVar.e_renamed().a_renamed();
        this.l_renamed.a_renamed(this);
        aVar.a_renamed(this.l_renamed);
        this.m_renamed = dVar.f_renamed().a_renamed();
        this.m_renamed.a_renamed(this);
        aVar.a_renamed(this.m_renamed);
        this.n_renamed = dVar.g_renamed().a_renamed();
        this.n_renamed.a_renamed(this);
        aVar.a_renamed(this.n_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        this.q_renamed.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list2.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list2.get(i_renamed);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.m_renamed) {
                this.i_renamed.add((com.airbnb.lottie.a_renamed.a_renamed.m_renamed) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        android.graphics.Shader shaderD;
        if (this.f2004b) {
            return;
        }
        com.airbnb.lottie.c_renamed.a_renamed("GradientFillContent#draw");
        this.f_renamed.reset();
        for (int i2 = 0; i2 < this.i_renamed.size(); i2++) {
            this.f_renamed.addPath(this.i_renamed.get(i2).e_renamed(), matrix);
        }
        this.f_renamed.computeBounds(this.h_renamed, false);
        if (this.j_renamed == com.airbnb.lottie.c_renamed.b_renamed.f_renamed.LINEAR) {
            shaderD = c_renamed();
        } else {
            shaderD = d_renamed();
        }
        shaderD.setLocalMatrix(matrix);
        this.g_renamed.setShader(shaderD);
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.o_renamed;
        if (aVar != null) {
            this.g_renamed.setColorFilter(aVar.g_renamed());
        }
        this.g_renamed.setAlpha(com.airbnb.lottie.f_renamed.g_renamed.a_renamed((int) ((((i_renamed / 255.0f) * this.l_renamed.g_renamed().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f_renamed, this.g_renamed);
        com.airbnb.lottie.c_renamed.b_renamed("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.f_renamed.reset();
        for (int i_renamed = 0; i_renamed < this.i_renamed.size(); i_renamed++) {
            this.f_renamed.addPath(this.i_renamed.get(i_renamed).e_renamed(), matrix);
        }
        this.f_renamed.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2003a;
    }

    private android.graphics.LinearGradient c_renamed() {
        long jE = e_renamed();
        android.graphics.LinearGradient linearGradient = this.d_renamed.get(jE);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF pointFG = this.m_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.n_renamed.g_renamed();
        com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVarG = this.k_renamed.g_renamed();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(pointFG.x_renamed, pointFG.y_renamed, pointFG2.x_renamed, pointFG2.y_renamed, a_renamed(cVarG.b_renamed()), cVarG.a_renamed(), android.graphics.Shader.TileMode.CLAMP);
        this.d_renamed.put(jE, linearGradient2);
        return linearGradient2;
    }

    private android.graphics.RadialGradient d_renamed() {
        long jE = e_renamed();
        android.graphics.RadialGradient radialGradient = this.e_renamed.get(jE);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF pointFG = this.m_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.n_renamed.g_renamed();
        com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVarG = this.k_renamed.g_renamed();
        int[] iArrA = a_renamed(cVarG.b_renamed());
        float[] fArrA = cVarG.a_renamed();
        float f_renamed = pointFG.x_renamed;
        float f2 = pointFG.y_renamed;
        float fHypot = (float) java.lang.Math.hypot(pointFG2.x_renamed - f_renamed, pointFG2.y_renamed - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient(f_renamed, f2, fHypot, iArrA, fArrA, android.graphics.Shader.TileMode.CLAMP);
        this.e_renamed.put(jE, radialGradient2);
        return radialGradient2;
    }

    private int e_renamed() {
        int iRound = java.lang.Math.round(this.m_renamed.h_renamed() * this.r_renamed);
        int iRound2 = java.lang.Math.round(this.n_renamed.h_renamed() * this.r_renamed);
        int iRound3 = java.lang.Math.round(this.k_renamed.h_renamed() * this.r_renamed);
        int i_renamed = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i_renamed = i_renamed * 31 * iRound2;
        }
        return iRound3 != 0 ? i_renamed * 31 * iRound3 : i_renamed;
    }

    private int[] a_renamed(int[] iArr) {
        com.airbnb.lottie.a_renamed.b_renamed.p_renamed pVar = this.p_renamed;
        if (pVar != null) {
            java.lang.Integer[] numArr = (java.lang.Integer[]) pVar.g_renamed();
            int i_renamed = 0;
            if (iArr.length == numArr.length) {
                while (i_renamed < iArr.length) {
                    iArr[i_renamed] = numArr[i_renamed].intValue();
                    i_renamed++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i_renamed < numArr.length) {
                    iArr[i_renamed] = numArr[i_renamed].intValue();
                    i_renamed++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.f_renamed.g_renamed.a_renamed(eVar, i_renamed, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        if (t_renamed == com.airbnb.lottie.k_renamed.d_renamed) {
            this.l_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Integer>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.E_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.o_renamed;
            if (aVar != null) {
                this.f2005c.b_renamed(aVar);
            }
            if (cVar == null) {
                this.o_renamed = null;
                return;
            }
            this.o_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.o_renamed.a_renamed(this);
            this.f2005c.a_renamed(this.o_renamed);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.F_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.p_renamed pVar = this.p_renamed;
            if (pVar != null) {
                this.f2005c.b_renamed(pVar);
            }
            if (cVar == null) {
                this.p_renamed = null;
                return;
            }
            this.d_renamed.clear();
            this.e_renamed.clear();
            this.p_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.p_renamed.a_renamed(this);
            this.f2005c.a_renamed(this.p_renamed);
        }
    }
}
