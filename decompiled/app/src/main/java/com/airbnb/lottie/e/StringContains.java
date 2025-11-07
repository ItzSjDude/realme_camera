package com.airbnb.lottie.e_renamed;

/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2193a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("ch_renamed", com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE, "w_renamed", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_STYLE, "fFamily", "data");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2194b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("shapes");

    static com.airbnb.lottie.c_renamed.d_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        cVar.c_renamed();
        java.lang.String strI = null;
        java.lang.String strI2 = null;
        double dK_renamed = 0.0d;
        double dK2 = 0.0d;
        char cCharAt = 0;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2193a);
            if (iA == 0) {
                cCharAt = cVar.i_renamed().charAt(0);
            } else if (iA == 1) {
                dK_renamed = cVar.k_renamed();
            } else if (iA == 2) {
                dK2 = cVar.k_renamed();
            } else if (iA == 3) {
                strI = cVar.i_renamed();
            } else if (iA == 4) {
                strI2 = cVar.i_renamed();
            } else if (iA == 5) {
                cVar.c_renamed();
                while (cVar.e_renamed()) {
                    if (cVar.a_renamed(f2194b) == 0) {
                        cVar.a_renamed();
                        while (cVar.e_renamed()) {
                            arrayList.add((com.airbnb.lottie.c_renamed.b_renamed.n_renamed) com.airbnb.lottie.e_renamed.g_renamed.a_renamed(cVar, dVar));
                        }
                        cVar.b_renamed();
                    } else {
                        cVar.h_renamed();
                        cVar.m_renamed();
                    }
                }
                cVar.d_renamed();
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        return new com.airbnb.lottie.c_renamed.d_renamed(arrayList, cCharAt, dK_renamed, dK2, strI, strI2);
    }
}
