package com.airbnb.lottie.e_renamed;

/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
class ab_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2173a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "c_renamed", "o_renamed", "tr", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.k_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        boolean zJ = false;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.l_renamed lVarA = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2173a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
            } else if (iA == 2) {
                bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
            } else if (iA == 3) {
                lVarA = com.airbnb.lottie.e_renamed.c_renamed.a_renamed(cVar, dVar);
            } else if (iA == 4) {
                zJ = cVar.j_renamed();
            } else {
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.k_renamed(strI, bVarA, bVarA2, lVarA, zJ);
    }
}
