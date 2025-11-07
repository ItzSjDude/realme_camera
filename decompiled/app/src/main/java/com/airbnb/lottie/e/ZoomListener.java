package com.airbnb.lottie.e_renamed;

/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
class ag_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2179a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "ind", "ks", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.o_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        int iL = 0;
        java.lang.String strI = null;
        boolean zJ = false;
        com.airbnb.lottie.c_renamed.a_renamed.h_renamed hVarE = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2179a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                iL = cVar.l_renamed();
            } else if (iA == 2) {
                hVarE = com.airbnb.lottie.e_renamed.d_renamed.e_renamed(cVar, dVar);
            } else if (iA == 3) {
                zJ = cVar.j_renamed();
            } else {
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.o_renamed(strI, iL, hVarE, zJ);
    }
}
