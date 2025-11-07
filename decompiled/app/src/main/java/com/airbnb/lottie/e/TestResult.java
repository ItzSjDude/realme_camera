package com.airbnb.lottie.e_renamed;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<com.airbnb.lottie.c_renamed.b_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.e_renamed.h_renamed f2190a = new com.airbnb.lottie.e_renamed.h_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2191b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("t_renamed", "f_renamed", "s_renamed", "j_renamed", "tr", "lh", "ls", "fc_renamed", "sc", "sw", "of_renamed");

    private h_renamed() {
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.c_renamed.b_renamed b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        com.airbnb.lottie.c_renamed.b_renamed.a_renamed aVar = com.airbnb.lottie.c_renamed.b_renamed.a_renamed.CENTER;
        cVar.c_renamed();
        com.airbnb.lottie.c_renamed.b_renamed.a_renamed aVar2 = aVar;
        java.lang.String strI = null;
        java.lang.String strI2 = null;
        int iL = 0;
        int iA = 0;
        int iA2 = 0;
        float fK_renamed = 0.0f;
        float fK2 = 0.0f;
        float fK3 = 0.0f;
        float fK4 = 0.0f;
        boolean zJ = true;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2191b)) {
                case 0:
                    strI = cVar.i_renamed();
                    break;
                case 1:
                    strI2 = cVar.i_renamed();
                    break;
                case 2:
                    fK_renamed = (float) cVar.k_renamed();
                    break;
                case 3:
                    int iL2 = cVar.l_renamed();
                    if (iL2 > com.airbnb.lottie.c_renamed.b_renamed.a_renamed.CENTER.ordinal() || iL2 < 0) {
                        aVar2 = com.airbnb.lottie.c_renamed.b_renamed.a_renamed.CENTER;
                        break;
                    } else {
                        aVar2 = com.airbnb.lottie.c_renamed.b_renamed.a_renamed.values()[iL2];
                        break;
                    }
                    break;
                case 4:
                    iL = cVar.l_renamed();
                    break;
                case 5:
                    fK2 = (float) cVar.k_renamed();
                    break;
                case 6:
                    fK3 = (float) cVar.k_renamed();
                    break;
                case 7:
                    iA = com.airbnb.lottie.e_renamed.p_renamed.a_renamed(cVar);
                    break;
                case 8:
                    iA2 = com.airbnb.lottie.e_renamed.p_renamed.a_renamed(cVar);
                    break;
                case 9:
                    fK4 = (float) cVar.k_renamed();
                    break;
                case 10:
                    zJ = cVar.j_renamed();
                    break;
                default:
                    cVar.h_renamed();
                    cVar.m_renamed();
                    break;
            }
        }
        cVar.d_renamed();
        return new com.airbnb.lottie.c_renamed.b_renamed(strI, strI2, fK_renamed, aVar2, iL, fK2, fK3, iA, iA2, fK4, zJ);
    }
}
