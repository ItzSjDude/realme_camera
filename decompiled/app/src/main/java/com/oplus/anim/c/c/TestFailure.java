package com.oplus.anim.c_renamed.c_renamed;

/* compiled from: ShapeLayer.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.anim.c_renamed.c_renamed.a_renamed {
    private final com.oplus.anim.a_renamed.a_renamed.d_renamed e_renamed;

    f_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.d_renamed dVar) {
        super(bVar, dVar);
        com.oplus.anim.c_renamed.b_renamed.n_renamed nVar = new com.oplus.anim.c_renamed.b_renamed.n_renamed("__container", dVar.n_renamed(), false);
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ShapeLayer::shapeGroup = " + nVar.toString());
        }
        this.e_renamed = new com.oplus.anim.a_renamed.a_renamed.d_renamed(bVar, this, nVar);
        this.e_renamed.a_renamed(java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        com.oplus.anim.k_renamed.c_renamed("ShapeLayer#draw");
        this.e_renamed.a_renamed(canvas, matrix, i_renamed);
        com.oplus.anim.k_renamed.d_renamed("ShapeLayer#draw");
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        this.e_renamed.a_renamed(rectF, this.f3614a, z_renamed);
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    protected void b_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        this.e_renamed.a_renamed(fVar, i_renamed, list, fVar2);
    }
}
