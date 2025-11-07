package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<java.lang.Float> {
    public c_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<java.lang.Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Float a_renamed(com.oplus.anim.g_renamed.c_renamed<java.lang.Float> cVar, float f_renamed) {
        return java.lang.Float.valueOf(c_renamed(cVar, f_renamed));
    }

    float c_renamed(com.oplus.anim.g_renamed.c_renamed<java.lang.Float> cVar, float f_renamed) {
        java.lang.Float f2;
        if (cVar.f3704a == null || cVar.d_renamed == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        if (this.f3499b != null && (f2 = (java.lang.Float) this.f3499b.a_renamed(cVar.f3706c, cVar.e_renamed.floatValue(), cVar.f3704a, cVar.d_renamed, f_renamed, d_renamed(), h_renamed())) != null) {
            return f2.floatValue();
        }
        return com.oplus.anim.f_renamed.e_renamed.a_renamed(cVar.f_renamed(), cVar.g_renamed(), f_renamed);
    }

    public float i_renamed() {
        return c_renamed(c_renamed(), e_renamed());
    }
}
