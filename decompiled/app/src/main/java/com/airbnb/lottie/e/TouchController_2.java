package com.airbnb.lottie.e_renamed;

/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2197a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "g_renamed", "o_renamed", "t_renamed", "s_renamed", "e_renamed", "r_renamed", "hd");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2198b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "k_renamed");

    static com.airbnb.lottie.c_renamed.b_renamed.d_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar2 = null;
        android.graphics.Path.FillType fillType = android.graphics.Path.FillType.WINDING;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.b_renamed.f_renamed fVar = null;
        com.airbnb.lottie.c_renamed.a_renamed.c_renamed cVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC2 = null;
        boolean zJ = false;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2197a)) {
                case 0:
                    strI = cVar.i_renamed();
                    break;
                case 1:
                    int iL = -1;
                    cVar.c_renamed();
                    while (cVar.e_renamed()) {
                        int iA = cVar.a_renamed(f2198b);
                        if (iA == 0) {
                            iL = cVar.l_renamed();
                        } else if (iA == 1) {
                            cVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, iL);
                        } else {
                            cVar.h_renamed();
                            cVar.m_renamed();
                        }
                    }
                    cVar.d_renamed();
                    break;
                case 2:
                    dVar2 = com.airbnb.lottie.e_renamed.d_renamed.b_renamed(cVar, dVar);
                    break;
                case 3:
                    fVar = cVar.l_renamed() == 1 ? com.airbnb.lottie.c_renamed.b_renamed.f_renamed.LINEAR : com.airbnb.lottie.c_renamed.b_renamed.f_renamed.RADIAL;
                    break;
                case 4:
                    fVarC = com.airbnb.lottie.e_renamed.d_renamed.c_renamed(cVar, dVar);
                    break;
                case 5:
                    fVarC2 = com.airbnb.lottie.e_renamed.d_renamed.c_renamed(cVar, dVar);
                    break;
                case 6:
                    fillType = cVar.l_renamed() == 1 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zJ = cVar.j_renamed();
                    break;
                default:
                    cVar.h_renamed();
                    cVar.m_renamed();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar2 = new com.airbnb.lottie.c_renamed.a_renamed.d_renamed(java.util.Collections.singletonList(new com.airbnb.lottie.g_renamed.a_renamed(100)));
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.d_renamed(strI, fVar, fillType, cVarA, dVar2, fVarC, fVarC2, null, null, zJ);
    }
}
