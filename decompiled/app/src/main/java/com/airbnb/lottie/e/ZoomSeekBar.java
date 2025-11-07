package com.airbnb.lottie.e_renamed;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class ai_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2182a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("s_renamed", "e_renamed", "o_renamed", "nm", "m_renamed", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.q_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        boolean zJ = false;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed aVarForId = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA3 = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2182a);
            if (iA == 0) {
                bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
            } else if (iA == 1) {
                bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
            } else if (iA == 2) {
                bVarA3 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
            } else if (iA == 3) {
                strI = cVar.i_renamed();
            } else if (iA == 4) {
                aVarForId = com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.forId(cVar.l_renamed());
            } else if (iA == 5) {
                zJ = cVar.j_renamed();
            } else {
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.q_renamed(strI, aVarForId, bVarA, bVarA2, bVarA3, zJ);
    }
}
