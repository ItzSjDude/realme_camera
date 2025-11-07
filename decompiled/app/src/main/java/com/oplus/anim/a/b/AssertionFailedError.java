package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.anim.a_renamed.b_renamed.f_renamed<java.lang.Integer> {
    public b_renamed(java.util.List<com.oplus.anim.g_renamed.c_renamed<java.lang.Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer a_renamed(com.oplus.anim.g_renamed.c_renamed<java.lang.Integer> cVar, float f_renamed) {
        return java.lang.Integer.valueOf(c_renamed(cVar, f_renamed));
    }

    public int c_renamed(com.oplus.anim.g_renamed.c_renamed<java.lang.Integer> cVar, float f_renamed) {
        java.lang.Integer num;
        if (cVar.f3704a == null || cVar.d_renamed == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = cVar.f3704a.intValue();
        int iIntValue2 = cVar.d_renamed.intValue();
        if (this.f3499b != null && (num = (java.lang.Integer) this.f3499b.a_renamed(cVar.f3706c, cVar.e_renamed.floatValue(), java.lang.Integer.valueOf(iIntValue), java.lang.Integer.valueOf(iIntValue2), f_renamed, d_renamed(), h_renamed())) != null) {
            return num.intValue();
        }
        return com.oplus.anim.f_renamed.c_renamed.a_renamed(com.oplus.anim.f_renamed.e_renamed.b_renamed(f_renamed, 0.0f, 1.0f), iIntValue, iIntValue2);
    }

    public int i_renamed() {
        return c_renamed(c_renamed(), e_renamed());
    }
}
