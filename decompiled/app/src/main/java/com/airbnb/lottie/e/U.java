package com.airbnb.lottie.e_renamed;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2199a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "g_renamed", "o_renamed", "t_renamed", "s_renamed", "e_renamed", "w_renamed", "lc", "lj", "ml", "hd", "d_renamed");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2200b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "k_renamed");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2201c = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("n_renamed", "v_renamed");

    static com.airbnb.lottie.c_renamed.b_renamed.e_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        com.airbnb.lottie.c_renamed.a_renamed.c_renamed cVar2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float fK_renamed = 0.0f;
        com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar2 = null;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.b_renamed.f_renamed fVar = null;
        com.airbnb.lottie.c_renamed.a_renamed.c_renamed cVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC = null;
        com.airbnb.lottie.c_renamed.a_renamed.f_renamed fVarC2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed aVar = null;
        com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed bVar = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2 = null;
        boolean zJ = false;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2199a)) {
                case 0:
                    strI = cVar.i_renamed();
                    break;
                case 1:
                    int iL = -1;
                    cVar.c_renamed();
                    while (cVar.e_renamed()) {
                        int iA = cVar.a_renamed(f2200b);
                        if (iA != 0) {
                            cVar2 = cVarA;
                            if (iA == 1) {
                                cVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, iL);
                            } else {
                                cVar.h_renamed();
                                cVar.m_renamed();
                            }
                        } else {
                            cVar2 = cVarA;
                            iL = cVar.l_renamed();
                        }
                        cVarA = cVar2;
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
                    bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
                    break;
                case 7:
                    aVar = com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed.values()[cVar.l_renamed() - 1];
                    break;
                case 8:
                    bVar = com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed.values()[cVar.l_renamed() - 1];
                    break;
                case 9:
                    fK_renamed = (float) cVar.k_renamed();
                    break;
                case 10:
                    zJ = cVar.j_renamed();
                    break;
                case 11:
                    cVar.a_renamed();
                    while (cVar.e_renamed()) {
                        cVar.c_renamed();
                        java.lang.String strI2 = null;
                        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
                        while (cVar.e_renamed()) {
                            int iA2 = cVar.a_renamed(f2201c);
                            if (iA2 != 0) {
                                com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar3 = bVar2;
                                if (iA2 == 1) {
                                    bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
                                } else {
                                    cVar.h_renamed();
                                    cVar.m_renamed();
                                }
                                bVar2 = bVar3;
                            } else {
                                strI2 = cVar.i_renamed();
                            }
                        }
                        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar4 = bVar2;
                        cVar.d_renamed();
                        if (strI2.equals("o_renamed")) {
                            bVar2 = bVarA2;
                        } else {
                            if (strI2.equals("d_renamed") || strI2.equals("g_renamed")) {
                                dVar.a_renamed(true);
                                arrayList.add(bVarA2);
                            }
                            bVar2 = bVar4;
                        }
                    }
                    com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar5 = bVar2;
                    cVar.b_renamed();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar5;
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
        return new com.airbnb.lottie.c_renamed.b_renamed.e_renamed(strI, fVar, cVarA, dVar2, fVarC, fVarC2, bVarA, aVar, bVar, fK_renamed, arrayList, bVar2, zJ);
    }
}
