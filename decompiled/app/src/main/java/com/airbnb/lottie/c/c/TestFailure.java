package com.airbnb.lottie.c_renamed.c_renamed;

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class f_renamed extends com.airbnb.lottie.c_renamed.c_renamed.a_renamed {
    private final com.airbnb.lottie.a_renamed.a_renamed.d_renamed e_renamed;

    f_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar) {
        super(fVar, dVar);
        this.e_renamed = new com.airbnb.lottie.a_renamed.a_renamed.d_renamed(fVar, this, new com.airbnb.lottie.c_renamed.b_renamed.n_renamed("__container", dVar.n_renamed(), false));
        this.e_renamed.a_renamed(java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        this.e_renamed.a_renamed(canvas, matrix, i_renamed);
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        this.e_renamed.a_renamed(rectF, this.f2117a, z_renamed);
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    protected void b_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        this.e_renamed.a_renamed(eVar, i_renamed, list, eVar2);
    }
}
