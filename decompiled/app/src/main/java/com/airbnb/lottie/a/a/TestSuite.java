package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i_renamed extends com.airbnb.lottie.a_renamed.a_renamed.a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f2006c;
    private final boolean d_renamed;
    private final androidx.collection.LongSparseArray<android.graphics.LinearGradient> e_renamed;
    private final androidx.collection.LongSparseArray<android.graphics.RadialGradient> f_renamed;
    private final android.graphics.RectF g_renamed;
    private final com.airbnb.lottie.c_renamed.b_renamed.f_renamed h_renamed;
    private final int i_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.c_renamed, com.airbnb.lottie.c_renamed.b_renamed.c_renamed> j_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> k_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> l_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.p_renamed m_renamed;

    public i_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.e_renamed eVar) {
        super(fVar, aVar, eVar.h_renamed().toPaintCap(), eVar.i_renamed().toPaintJoin(), eVar.l_renamed(), eVar.d_renamed(), eVar.g_renamed(), eVar.j_renamed(), eVar.k_renamed());
        this.e_renamed = new androidx.collection.LongSparseArray<>();
        this.f_renamed = new androidx.collection.LongSparseArray<>();
        this.g_renamed = new android.graphics.RectF();
        this.f2006c = eVar.a_renamed();
        this.h_renamed = eVar.b_renamed();
        this.d_renamed = eVar.m_renamed();
        this.i_renamed = (int) (fVar.t_renamed().e_renamed() / 32.0f);
        this.j_renamed = eVar.c_renamed().a_renamed();
        this.j_renamed.a_renamed(this);
        aVar.a_renamed(this.j_renamed);
        this.k_renamed = eVar.e_renamed().a_renamed();
        this.k_renamed.a_renamed(this);
        aVar.a_renamed(this.k_renamed);
        this.l_renamed = eVar.f_renamed().a_renamed();
        this.l_renamed.a_renamed(this);
        aVar.a_renamed(this.l_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        android.graphics.Shader shaderD;
        if (this.d_renamed) {
            return;
        }
        a_renamed(this.g_renamed, matrix, false);
        if (this.h_renamed == com.airbnb.lottie.c_renamed.b_renamed.f_renamed.LINEAR) {
            shaderD = c_renamed();
        } else {
            shaderD = d_renamed();
        }
        shaderD.setLocalMatrix(matrix);
        this.f1989b.setShader(shaderD);
        super.a_renamed(canvas, matrix, i_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2006c;
    }

    private android.graphics.LinearGradient c_renamed() {
        long jE = e_renamed();
        android.graphics.LinearGradient linearGradient = this.e_renamed.get(jE);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF pointFG = this.k_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.l_renamed.g_renamed();
        com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVarG = this.j_renamed.g_renamed();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(pointFG.x_renamed, pointFG.y_renamed, pointFG2.x_renamed, pointFG2.y_renamed, a_renamed(cVarG.b_renamed()), cVarG.a_renamed(), android.graphics.Shader.TileMode.CLAMP);
        this.e_renamed.put(jE, linearGradient2);
        return linearGradient2;
    }

    private android.graphics.RadialGradient d_renamed() {
        long jE = e_renamed();
        android.graphics.RadialGradient radialGradient = this.f_renamed.get(jE);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF pointFG = this.k_renamed.g_renamed();
        android.graphics.PointF pointFG2 = this.l_renamed.g_renamed();
        com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVarG = this.j_renamed.g_renamed();
        int[] iArrA = a_renamed(cVarG.b_renamed());
        float[] fArrA = cVarG.a_renamed();
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient(pointFG.x_renamed, pointFG.y_renamed, (float) java.lang.Math.hypot(pointFG2.x_renamed - r7, pointFG2.y_renamed - r8), iArrA, fArrA, android.graphics.Shader.TileMode.CLAMP);
        this.f_renamed.put(jE, radialGradient2);
        return radialGradient2;
    }

    private int e_renamed() {
        int iRound = java.lang.Math.round(this.k_renamed.h_renamed() * this.i_renamed);
        int iRound2 = java.lang.Math.round(this.l_renamed.h_renamed() * this.i_renamed);
        int iRound3 = java.lang.Math.round(this.j_renamed.h_renamed() * this.i_renamed);
        int i_renamed = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i_renamed = i_renamed * 31 * iRound2;
        }
        return iRound3 != 0 ? i_renamed * 31 * iRound3 : i_renamed;
    }

    private int[] a_renamed(int[] iArr) {
        com.airbnb.lottie.a_renamed.b_renamed.p_renamed pVar = this.m_renamed;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.a_renamed.a_renamed.a_renamed, com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        super.a_renamed((com.airbnb.lottie.a_renamed.a_renamed.i_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.a_renamed.a_renamed.i_renamed>) cVar);
        if (t_renamed == com.airbnb.lottie.k_renamed.F_renamed) {
            if (this.m_renamed != null) {
                this.f1988a.b_renamed(this.m_renamed);
            }
            if (cVar == null) {
                this.m_renamed = null;
                return;
            }
            this.m_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.m_renamed.a_renamed(this);
            this.f1988a.a_renamed(this.m_renamed);
        }
    }
}
