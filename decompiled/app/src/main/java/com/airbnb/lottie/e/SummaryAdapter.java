package com.airbnb.lottie.e_renamed;

/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
class z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2219a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "sy", "pt", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "r_renamed", "or", "os", "ir", "is_renamed", "hd");

    static com.airbnb.lottie.c_renamed.b_renamed.i_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        boolean zJ = false;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed aVarForValue = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA3 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA4 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA5 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA6 = null;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2219a)) {
                case 0:
                    strI = cVar.i_renamed();
                    break;
                case 1:
                    aVarForValue = com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.forValue(cVar.l_renamed());
                    break;
                case 2:
                    bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
                    break;
                case 3:
                    mVarB = com.airbnb.lottie.e_renamed.a_renamed.b_renamed(cVar, dVar);
                    break;
                case 4:
                    bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
                    break;
                case 5:
                    bVarA4 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
                    break;
                case 6:
                    bVarA6 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
                    break;
                case 7:
                    bVarA3 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
                    break;
                case 8:
                    bVarA5 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
                    break;
                case 9:
                    zJ = cVar.j_renamed();
                    break;
                default:
                    cVar.h_renamed();
                    cVar.m_renamed();
                    break;
            }
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.i_renamed(strI, aVarForValue, bVarA, mVarB, bVarA2, bVarA3, bVarA4, bVarA5, bVarA6, zJ);
    }
}
