package com.airbnb.lottie.e_renamed;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
class af_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2178a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "hd", "it");

    static com.airbnb.lottie.c_renamed.b_renamed.n_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String strI = null;
        boolean zJ = false;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2178a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                zJ = cVar.j_renamed();
            } else if (iA == 2) {
                cVar.a_renamed();
                while (cVar.e_renamed()) {
                    com.airbnb.lottie.c_renamed.b_renamed.b_renamed bVarA = com.airbnb.lottie.e_renamed.g_renamed.a_renamed(cVar, dVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                cVar.b_renamed();
            } else {
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.n_renamed(strI, arrayList, zJ);
    }
}
