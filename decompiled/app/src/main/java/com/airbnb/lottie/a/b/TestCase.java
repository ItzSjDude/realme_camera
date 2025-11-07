package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e_renamed extends com.airbnb.lottie.a_renamed.b_renamed.f_renamed<java.lang.Integer> {
    public e_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<java.lang.Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer a_renamed(com.airbnb.lottie.g_renamed.a_renamed<java.lang.Integer> aVar, float f_renamed) {
        return java.lang.Integer.valueOf(c_renamed(aVar, f_renamed));
    }

    int c_renamed(com.airbnb.lottie.g_renamed.a_renamed<java.lang.Integer> aVar, float f_renamed) {
        java.lang.Integer num;
        if (aVar.f2266a == null || aVar.f2267b == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        if (this.f2030c != null && (num = (java.lang.Integer) this.f2030c.a_renamed(aVar.f_renamed, aVar.g_renamed.floatValue(), aVar.f2266a, aVar.f2267b, f_renamed, d_renamed(), h_renamed())) != null) {
            return num.intValue();
        }
        return com.airbnb.lottie.f_renamed.g_renamed.a_renamed(aVar.h_renamed(), aVar.i_renamed(), f_renamed);
    }

    public int i_renamed() {
        return c_renamed(c_renamed(), e_renamed());
    }
}
