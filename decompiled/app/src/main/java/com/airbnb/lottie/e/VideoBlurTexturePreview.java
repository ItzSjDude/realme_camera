package com.airbnb.lottie.e_renamed;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class ac_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<com.airbnb.lottie.g_renamed.d_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.e_renamed.ac_renamed f2174a = new com.airbnb.lottie.e_renamed.ac_renamed();

    private ac_renamed() {
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.g_renamed.d_renamed b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        boolean z_renamed = cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY;
        if (z_renamed) {
            cVar.a_renamed();
        }
        float fK_renamed = (float) cVar.k_renamed();
        float fK2 = (float) cVar.k_renamed();
        while (cVar.e_renamed()) {
            cVar.m_renamed();
        }
        if (z_renamed) {
            cVar.b_renamed();
        }
        return new com.airbnb.lottie.g_renamed.d_renamed((fK_renamed / 100.0f) * f_renamed, (fK2 / 100.0f) * f_renamed);
    }
}
