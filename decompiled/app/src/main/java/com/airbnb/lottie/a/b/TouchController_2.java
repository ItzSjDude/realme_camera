package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m_renamed extends com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> {
    protected com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> d_renamed;
    protected com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> e_renamed;
    private final android.graphics.PointF f_renamed;
    private final android.graphics.PointF g_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> h_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> i_renamed;

    public m_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar, com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2) {
        super(java.util.Collections.emptyList());
        this.f_renamed = new android.graphics.PointF();
        this.g_renamed = new android.graphics.PointF();
        this.h_renamed = aVar;
        this.i_renamed = aVar2;
        a_renamed(h_renamed());
    }

    public void b_renamed(com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> cVar) {
        com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> cVar2 = this.d_renamed;
        if (cVar2 != null) {
            cVar2.a_renamed((com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?>) null);
        }
        this.d_renamed = cVar;
        if (cVar != null) {
            cVar.a_renamed(this);
        }
    }

    public void c_renamed(com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> cVar) {
        com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float> cVar2 = this.e_renamed;
        if (cVar2 != null) {
            cVar2.a_renamed((com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?>) null);
        }
        this.e_renamed = cVar;
        if (cVar != null) {
            cVar.a_renamed(this);
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    public void a_renamed(float f_renamed) {
        this.h_renamed.a_renamed(f_renamed);
        this.i_renamed.a_renamed(f_renamed);
        this.f_renamed.set(this.h_renamed.g_renamed().floatValue(), this.i_renamed.g_renamed().floatValue());
        for (int i_renamed = 0; i_renamed < this.f2028a.size(); i_renamed++) {
            this.f2028a.get(i_renamed).a_renamed();
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: i_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF g_renamed() {
        return a_renamed(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.PointF a_renamed(com.airbnb.lottie.g_renamed.a_renamed<android.graphics.PointF> aVar, float f_renamed) {
        java.lang.Float fA_renamed;
        com.airbnb.lottie.g_renamed.a_renamed<java.lang.Float> aVarC;
        com.airbnb.lottie.g_renamed.a_renamed<java.lang.Float> aVarC2;
        java.lang.Float fA2 = null;
        if (this.d_renamed == null || (aVarC2 = this.h_renamed.c_renamed()) == null) {
            fA_renamed = null;
        } else {
            float fE_renamed = this.h_renamed.e_renamed();
            java.lang.Float f2 = aVarC2.g_renamed;
            fA_renamed = this.d_renamed.a_renamed(aVarC2.f_renamed, f2 == null ? aVarC2.f_renamed : f2.floatValue(), aVarC2.f2266a, aVarC2.f2267b, f_renamed, f_renamed, fE_renamed);
        }
        if (this.e_renamed != null && (aVarC = this.i_renamed.c_renamed()) != null) {
            float fE2 = this.i_renamed.e_renamed();
            java.lang.Float f3 = aVarC.g_renamed;
            fA2 = this.e_renamed.a_renamed(aVarC.f_renamed, f3 == null ? aVarC.f_renamed : f3.floatValue(), aVarC.f2266a, aVarC.f2267b, f_renamed, f_renamed, fE2);
        }
        if (fA_renamed == null) {
            this.g_renamed.set(this.f_renamed.x_renamed, 0.0f);
        } else {
            this.g_renamed.set(fA_renamed.floatValue(), 0.0f);
        }
        if (fA2 == null) {
            android.graphics.PointF pointF = this.g_renamed;
            pointF.set(pointF.x_renamed, this.f_renamed.y_renamed);
        } else {
            android.graphics.PointF pointF2 = this.g_renamed;
            pointF2.set(pointF2.x_renamed, fA2.floatValue());
        }
        return this.g_renamed;
    }
}
