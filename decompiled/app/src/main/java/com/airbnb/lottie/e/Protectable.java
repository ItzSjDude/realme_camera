package com.airbnb.lottie.e_renamed;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2185a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("a_renamed", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "s_renamed", "rz", "r_renamed", "o_renamed", "so", "eo_renamed", "sk", "sa");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2186b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("k_renamed");

    public static com.airbnb.lottie.c_renamed.a_renamed.l_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        boolean z_renamed;
        boolean z2 = false;
        boolean z3 = cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_OBJECT;
        if (z3) {
            cVar.c_renamed();
        }
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar = null;
        com.airbnb.lottie.c_renamed.a_renamed.e_renamed eVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVarB = null;
        com.airbnb.lottie.c_renamed.a_renamed.g_renamed gVarD = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA2 = null;
        com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVarB = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA3 = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA4 = null;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2185a)) {
                case 0:
                    boolean z4 = z2;
                    cVar.c_renamed();
                    while (cVar.e_renamed()) {
                        if (cVar.a_renamed(f2186b) == 0) {
                            eVarA = com.airbnb.lottie.e_renamed.a_renamed.a_renamed(cVar, dVar);
                        } else {
                            cVar.h_renamed();
                            cVar.m_renamed();
                        }
                    }
                    cVar.d_renamed();
                    z2 = z4;
                    continue;
                case 1:
                    mVarB = com.airbnb.lottie.e_renamed.a_renamed.b_renamed(cVar, dVar);
                    continue;
                case 2:
                    gVarD = com.airbnb.lottie.e_renamed.d_renamed.d_renamed(cVar, dVar);
                    continue;
                case 3:
                    dVar.a_renamed("Lottie doesn't_renamed support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarB = com.airbnb.lottie.e_renamed.d_renamed.b_renamed(cVar, dVar);
                    continue;
                case 6:
                    bVarA3 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, z2);
                    continue;
                case 7:
                    bVarA4 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, z2);
                    continue;
                case 8:
                    bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, z2);
                    continue;
                case 9:
                    bVarA2 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, z2);
                    continue;
                default:
                    cVar.h_renamed();
                    cVar.m_renamed();
                    continue;
            }
            com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA5 = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, z2);
            if (bVarA5.c_renamed().isEmpty()) {
                bVarA5.c_renamed().add(new com.airbnb.lottie.g_renamed.a_renamed(dVar, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(dVar.g_renamed())));
            } else {
                if (((com.airbnb.lottie.g_renamed.a_renamed) bVarA5.c_renamed().get(0)).f2266a == 0) {
                    z_renamed = false;
                    bVarA5.c_renamed().set(0, new com.airbnb.lottie.g_renamed.a_renamed(dVar, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f), null, 0.0f, java.lang.Float.valueOf(dVar.g_renamed())));
                }
                z2 = z_renamed;
                bVar = bVarA5;
            }
            z_renamed = false;
            z2 = z_renamed;
            bVar = bVarA5;
        }
        if (z3) {
            cVar.d_renamed();
        }
        com.airbnb.lottie.c_renamed.a_renamed.e_renamed eVar = a_renamed(eVarA) ? null : eVarA;
        com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar = a_renamed(mVarB) ? null : mVarB;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2 = a_renamed(bVar) ? null : bVar;
        if (a_renamed(gVarD)) {
            gVarD = null;
        }
        return new com.airbnb.lottie.c_renamed.a_renamed.l_renamed(eVar, mVar, gVarD, bVar2, dVarB, bVarA3, bVarA4, b_renamed(bVarA) ? null : bVarA, c_renamed(bVarA2) ? null : bVarA2);
    }

    private static boolean a_renamed(com.airbnb.lottie.c_renamed.a_renamed.e_renamed eVar) {
        return eVar == null || (eVar.b_renamed() && eVar.c_renamed().get(0).f2266a.equals(0.0f, 0.0f));
    }

    private static boolean a_renamed(com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.airbnb.lottie.c_renamed.a_renamed.i_renamed) && mVar.b_renamed() && mVar.c_renamed().get(0).f2266a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a_renamed(com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar) {
        return bVar == null || (bVar.b_renamed() && ((java.lang.Float) ((com.airbnb.lottie.g_renamed.a_renamed) bVar.c_renamed().get(0)).f2266a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a_renamed(com.airbnb.lottie.c_renamed.a_renamed.g_renamed gVar) {
        return gVar == null || (gVar.b_renamed() && ((com.airbnb.lottie.g_renamed.d_renamed) ((com.airbnb.lottie.g_renamed.a_renamed) gVar.c_renamed().get(0)).f2266a).b_renamed(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b_renamed(com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar) {
        return bVar == null || (bVar.b_renamed() && ((java.lang.Float) ((com.airbnb.lottie.g_renamed.a_renamed) bVar.c_renamed().get(0)).f2266a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c_renamed(com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar) {
        return bVar == null || (bVar.b_renamed() && ((java.lang.Float) ((com.airbnb.lottie.g_renamed.a_renamed) bVar.c_renamed().get(0)).f2266a).floatValue() == 0.0f);
    }
}
