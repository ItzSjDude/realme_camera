package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c_renamed extends com.airbnb.lottie.a_renamed.b_renamed.f_renamed<java.lang.Float> {
    public c_renamed(java.util.List<com.airbnb.lottie.g_renamed.a_renamed<java.lang.Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Float a_renamed(com.airbnb.lottie.g_renamed.a_renamed<java.lang.Float> aVar, float f_renamed) {
        return java.lang.Float.valueOf(c_renamed(aVar, f_renamed));
    }

    float c_renamed(com.airbnb.lottie.g_renamed.a_renamed<java.lang.Float> aVar, float f_renamed) {
        java.lang.Float f2;
        if (aVar.f2266a == null || aVar.f2267b == null) {
            throw new java.lang.IllegalStateException("Missing values for keyframe.");
        }
        if (this.f2030c != null && (f2 = (java.lang.Float) this.f2030c.a_renamed(aVar.f_renamed, aVar.g_renamed.floatValue(), aVar.f2266a, aVar.f2267b, f_renamed, d_renamed(), h_renamed())) != null) {
            return f2.floatValue();
        }
        return com.airbnb.lottie.f_renamed.g_renamed.a_renamed(aVar.f_renamed(), aVar.g_renamed(), f_renamed);
    }

    public float i_renamed() {
        return c_renamed(c_renamed(), e_renamed());
    }
}
