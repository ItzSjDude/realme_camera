package com.airbnb.lottie.e_renamed;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class ae_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2177a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "c_renamed", "o_renamed", "fillEnabled", "r_renamed", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.m_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar2 = null;
        boolean zJ = false;
        boolean zJ2 = false;
        int iL = 1;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.a_renamed.a_renamed aVarG = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2177a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                aVarG = com.airbnb.lottie.e_renamed.d_renamed.g_renamed(cVar, dVar);
            } else if (iA == 2) {
                dVar2 = com.airbnb.lottie.e_renamed.d_renamed.b_renamed(cVar, dVar);
            } else if (iA == 3) {
                zJ = cVar.j_renamed();
            } else if (iA == 4) {
                iL = cVar.l_renamed();
            } else if (iA == 5) {
                zJ2 = cVar.j_renamed();
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        if (dVar2 == null) {
            dVar2 = new com.airbnb.lottie.c_renamed.a_renamed.d_renamed(java.util.Collections.singletonList(new com.airbnb.lottie.g_renamed.a_renamed(100)));
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.m_renamed(strI, zJ, iL == 1 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD, aVarG, dVar2, zJ2);
    }
}
