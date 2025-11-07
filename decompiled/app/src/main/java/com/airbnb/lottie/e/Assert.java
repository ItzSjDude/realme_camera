package com.airbnb.lottie.e_renamed;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2166a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("k_renamed", "x_renamed", "y_renamed");

    public static com.airbnb.lottie.c_renamed.a_renamed.e_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY) {
            cVar.a_renamed();
            while (cVar.e_renamed()) {
                arrayList.add(com.airbnb.lottie.e_renamed.w_renamed.a_renamed(cVar, dVar));
            }
            cVar.b_renamed();
            com.airbnb.lottie.e_renamed.r_renamed.a_renamed(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.g_renamed.a_renamed(com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, com.airbnb.lottie.f_renamed.h_renamed.a_renamed())));
        }
        return new com.airbnb.lottie.c_renamed.a_renamed.e_renamed(arrayList);
    }

    static com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        cVar.c_renamed();
        com.airbnb.lottie.c_renamed.a_renamed.e_renamed eVarA = null;
        boolean z_renamed = false;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        while (cVar.f_renamed() != com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_OBJECT) {
            int iA = cVar.a_renamed(f2166a);
            if (iA == 0) {
                eVarA = a_renamed(cVar, dVar);
            } else if (iA != 1) {
                if (iA == 2) {
                    if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.STRING) {
                        cVar.m_renamed();
                        z_renamed = true;
                    } else {
                        bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
                    }
                } else {
                    cVar.h_renamed();
                    cVar.m_renamed();
                }
            } else if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.STRING) {
                cVar.m_renamed();
                z_renamed = true;
            } else {
                bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar);
            }
        }
        cVar.d_renamed();
        if (z_renamed) {
            dVar.a_renamed("Lottie doesn't_renamed support expressions.");
        }
        return eVarA != null ? eVarA : new com.airbnb.lottie.c_renamed.a_renamed.i_renamed(bVarA, bVarA2);
    }
}
