package com.airbnb.lottie.e_renamed;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class v_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2216a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "mm", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.h_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar) throws java.io.IOException {
        java.lang.String strI = null;
        boolean zJ = false;
        com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed aVarForId = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2216a);
            if (iA == 0) {
                strI = cVar.i_renamed();
            } else if (iA == 1) {
                aVarForId = com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed.forId(cVar.l_renamed());
            } else if (iA == 2) {
                zJ = cVar.j_renamed();
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.h_renamed(strI, aVarForId, zJ);
    }
}
