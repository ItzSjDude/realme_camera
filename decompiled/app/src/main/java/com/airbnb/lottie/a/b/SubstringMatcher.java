package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k_renamed extends com.airbnb.lottie.a_renamed.b_renamed.f_renamed<com.airbnb.lottie.g_renamed.d_renamed> {
    private final com.airbnb.lottie.g_renamed.d_renamed d_renamed;

    public k_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<com.airbnb.lottie.g_renamed.d_renamed>> list) {
        super(list);
        this.d_renamed = new com.airbnb.lottie.g_renamed.d_renamed();
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.g_renamed.d_renamed a_renamed(com.airbnb.lottie.g_renamed.a_renamed<com.airbnb.lottie.g_renamed.d_renamed> aVar, float f_renamed) {
        com.airbnb.lottie.g_renamed.d_renamed dVar;
        if (aVar.f2266a == null || aVar.f2267b == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.g_renamed.d_renamed dVar2 = aVar.f2266a;
        com.airbnb.lottie.g_renamed.d_renamed dVar3 = aVar.f2267b;
        if (this.f2030c != null && (dVar = (com.airbnb.lottie.g_renamed.d_renamed) this.f2030c.a_renamed(aVar.f_renamed, aVar.g_renamed.floatValue(), dVar2, dVar3, f_renamed, d_renamed(), h_renamed())) != null) {
            return dVar;
        }
        this.d_renamed.a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(dVar2.a_renamed(), dVar3.a_renamed(), f_renamed), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(dVar2.b_renamed(), dVar3.b_renamed(), f_renamed));
        return this.d_renamed;
    }
}
