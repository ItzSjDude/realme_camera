package com.airbnb.lottie.e_renamed;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class aa_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2172a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "s_renamed", "r_renamed", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.j_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        boolean zJ = false;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2172a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                mVarB = com.airbnb.lottie.e_renamed.a_renamed.b_renamed(cVar, dVar);
            } else if (iA == 2) {
                fVarC = com.airbnb.lottie.e_renamed.d_renamed.c_renamed(cVar, dVar);
            } else if (iA == 3) {
                bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
            } else if (iA == 4) {
                zJ = cVar.j_renamed();
            } else {
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.j_renamed(strI, mVarB, fVarC, bVarA, zJ);
    }
}
