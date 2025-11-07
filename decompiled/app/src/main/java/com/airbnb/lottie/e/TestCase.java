package com.airbnb.lottie.e_renamed;

/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2187a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "s_renamed", "hd", "d_renamed");

    static com.airbnb.lottie.c_renamed.b_renamed.a_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, int i_renamed) throws java.io.IOException {
        boolean z_renamed = i_renamed == 3;
        boolean zJ = false;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2187a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                mVarB = com.airbnb.lottie.e_renamed.a_renamed.b_renamed(cVar, dVar);
            } else if (iA == 2) {
                fVarC = com.airbnb.lottie.e_renamed.d_renamed.c_renamed(cVar, dVar);
            } else if (iA == 3) {
                zJ = cVar.j_renamed();
            } else if (iA == 4) {
                z_renamed = cVar.l_renamed() == 3;
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.a_renamed(strI, mVarB, fVarC, z_renamed, zJ);
    }
}
