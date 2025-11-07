package com.airbnb.lottie.e_renamed;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2195a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("fFamily", "fName", "fStyle", "ascent");

    static com.airbnb.lottie.c_renamed.c_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar) throws java.io.IOException {
        cVar.c_renamed();
        java.lang.String strI = null;
        java.lang.String strI2 = null;
        float fK_renamed = 0.0f;
        java.lang.String strI3 = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2195a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                strI3 = cVar.i_renamed();
            } else if (iA == 2) {
                strI2 = cVar.i_renamed();
            } else if (iA == 3) {
                fK_renamed = (float) cVar.k_renamed();
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        return new com.airbnb.lottie.c_renamed.c_renamed(strI, strI3, strI2, fK_renamed);
    }
}
