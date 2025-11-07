package com.airbnb.lottie.e_renamed;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2183a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("a_renamed");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2184b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("fc_renamed", "sc", "sw", "t_renamed");

    public static com.airbnb.lottie.c_renamed.a_renamed.k_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        cVar.c_renamed();
        com.airbnb.lottie.c_renamed.a_renamed.k_renamed kVarB = null;
        while (cVar.e_renamed()) {
            if (cVar.a_renamed(f2183a) == 0) {
                kVarB = b_renamed(cVar, dVar);
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        return kVarB == null ? new com.airbnb.lottie.c_renamed.a_renamed.k_renamed(null, null, null, null) : kVarB;
    }

    private static com.airbnb.lottie.c_renamed.a_renamed.k_renamed b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        cVar.c_renamed();
        com.airbnb.lottie.c_renamed.a_renamed.a_renamed aVarG = null;
        com.airbnb.lottie.c_renamed.a_renamed.a_renamed aVarG2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2184b);
            if (iA == 0) {
                aVarG = com.airbnb.lottie.e_renamed.d_renamed.g_renamed(cVar, dVar);
            } else if (iA == 1) {
                aVarG2 = com.airbnb.lottie.e_renamed.d_renamed.g_renamed(cVar, dVar);
            } else if (iA == 2) {
                bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
            } else if (iA == 3) {
                bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        return new com.airbnb.lottie.c_renamed.a_renamed.k_renamed(aVarG, aVarG2, bVarA, bVarA2);
    }
}
