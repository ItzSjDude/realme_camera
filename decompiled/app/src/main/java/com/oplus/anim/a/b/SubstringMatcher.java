package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class k_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<com.oplus.anim.g_renamed.d_renamed> {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.g_renamed.d_renamed f3507c;

    public k_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<com.oplus.anim.g_renamed.d_renamed>> list) {
        super(list);
        this.f3507c = new com.oplus.anim.g_renamed.d_renamed();
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.anim.g_renamed.d_renamed a_renamed(com.oplus.anim.g_renamed.c_renamed<com.oplus.anim.g_renamed.d_renamed> cVar, float f_renamed) {
        com.oplus.anim.g_renamed.d_renamed dVar;
        if (cVar.f3704a == null || cVar.d_renamed == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.oplus.anim.g_renamed.d_renamed dVar2 = cVar.f3704a;
        com.oplus.anim.g_renamed.d_renamed dVar3 = cVar.d_renamed;
        if (this.f3499b != null && (dVar = (com.oplus.anim.g_renamed.d_renamed) this.f3499b.a_renamed(cVar.f3706c, cVar.e_renamed.floatValue(), dVar2, dVar3, f_renamed, d_renamed(), h_renamed())) != null) {
            return dVar;
        }
        this.f3507c.a_renamed(com.oplus.anim.f_renamed.e_renamed.a_renamed(dVar2.a_renamed(), dVar3.a_renamed(), f_renamed), com.oplus.anim.f_renamed.e_renamed.a_renamed(dVar2.b_renamed(), dVar3.b_renamed(), f_renamed));
        return this.f3507c;
    }
}
