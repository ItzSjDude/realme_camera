package com.airbnb.lottie.e_renamed;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2209a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm", "ind", "refId", "ty_renamed", "parent", "sw", "sh", "sc", "ks", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_TT, "masksProperties", "shapes", "t_renamed", "ef_renamed", "sr", "st", "w_renamed", "h_renamed", "ip", "op", "tm", "cl_renamed", "hd");

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2210b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("d_renamed", "a_renamed");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2211c = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("nm");

    public static com.airbnb.lottie.c_renamed.c_renamed.d_renamed a_renamed(com.airbnb.lottie.d_renamed dVar) {
        android.graphics.Rect rectD = dVar.d_renamed();
        return new com.airbnb.lottie.c_renamed.c_renamed.d_renamed(java.util.Collections.emptyList(), dVar, "__container", -1L, com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.PRE_COMP, -1L, null, java.util.Collections.emptyList(), new com.airbnb.lottie.c_renamed.a_renamed.l_renamed(), 0, 0, 0, 0.0f, 0.0f, rectD.width(), rectD.height(), null, null, java.util.Collections.emptyList(), com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.NONE, null, false);
    }

    public static com.airbnb.lottie.c_renamed.c_renamed.d_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar) throws java.io.IOException {
        float f_renamed;
        java.util.ArrayList arrayList;
        float f2;
        com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed bVar = com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.NONE;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        cVar.c_renamed();
        java.lang.Float fValueOf = java.lang.Float.valueOf(1.0f);
        java.lang.Float fValueOf2 = java.lang.Float.valueOf(0.0f);
        com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed bVar2 = bVar;
        int iL = 0;
        int iL2 = 0;
        int color = 0;
        int iL3 = 0;
        int iL4 = 0;
        boolean zJ = false;
        com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed aVar = null;
        java.lang.String strI = null;
        com.airbnb.lottie.c_renamed.a_renamed.l_renamed lVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.j_renamed jVarF = null;
        com.airbnb.lottie.c_renamed.a_renamed.k_renamed kVarA = null;
        com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVarA = null;
        float fK_renamed = 0.0f;
        float fK2 = 0.0f;
        long jL = -1;
        float fK3 = 1.0f;
        float fK4 = 0.0f;
        long jL2 = 0;
        java.lang.String strI2 = null;
        java.lang.String strI3 = "UNSET";
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2209a)) {
                case 0:
                    strI3 = cVar.i_renamed();
                    break;
                case 1:
                    jL2 = cVar.l_renamed();
                    break;
                case 2:
                    strI = cVar.i_renamed();
                    break;
                case 3:
                    int iL5 = cVar.l_renamed();
                    if (iL5 < com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.UNKNOWN.ordinal()) {
                        aVar = com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.values()[iL5];
                        break;
                    } else {
                        aVar = com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.UNKNOWN;
                        break;
                    }
                case 4:
                    jL = cVar.l_renamed();
                    break;
                case 5:
                    iL = (int) (cVar.l_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
                    break;
                case 6:
                    iL2 = (int) (cVar.l_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
                    break;
                case 7:
                    color = android.graphics.Color.parseColor(cVar.i_renamed());
                    break;
                case 8:
                    lVarA = com.airbnb.lottie.e_renamed.c_renamed.a_renamed(cVar, dVar);
                    break;
                case 9:
                    int iL6 = cVar.l_renamed();
                    if (iL6 >= com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.values().length) {
                        dVar.a_renamed("Unsupported matte type: " + iL6);
                        break;
                    } else {
                        bVar2 = com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.values()[iL6];
                        int i_renamed = com.airbnb.lottie.e_renamed.s_renamed.SceneLoader_2.f2212a[bVar2.ordinal()];
                        if (i_renamed == 1) {
                            dVar.a_renamed("Unsupported matte type: Luma");
                        } else if (i_renamed == 2) {
                            dVar.a_renamed("Unsupported matte type: Luma Inverted");
                        }
                        dVar.a_renamed(1);
                        break;
                    }
                case 10:
                    cVar.a_renamed();
                    while (cVar.e_renamed()) {
                        arrayList2.add(com.airbnb.lottie.e_renamed.u_renamed.a_renamed(cVar, dVar));
                    }
                    dVar.a_renamed(arrayList2.size());
                    cVar.b_renamed();
                    break;
                case 11:
                    cVar.a_renamed();
                    while (cVar.e_renamed()) {
                        com.airbnb.lottie.c_renamed.b_renamed.b_renamed bVarA2 = com.airbnb.lottie.e_renamed.g_renamed.a_renamed(cVar, dVar);
                        if (bVarA2 != null) {
                            arrayList3.add(bVarA2);
                        }
                    }
                    cVar.b_renamed();
                    break;
                case 12:
                    cVar.c_renamed();
                    while (cVar.e_renamed()) {
                        int iA = cVar.a_renamed(f2210b);
                        if (iA == 0) {
                            jVarF = com.airbnb.lottie.e_renamed.d_renamed.f_renamed(cVar, dVar);
                        } else if (iA == 1) {
                            cVar.a_renamed();
                            if (cVar.e_renamed()) {
                                kVarA = com.airbnb.lottie.e_renamed.b_renamed.a_renamed(cVar, dVar);
                            }
                            while (cVar.e_renamed()) {
                                cVar.m_renamed();
                            }
                            cVar.b_renamed();
                        } else {
                            cVar.h_renamed();
                            cVar.m_renamed();
                        }
                    }
                    cVar.d_renamed();
                    break;
                case 13:
                    cVar.a_renamed();
                    java.util.ArrayList arrayList4 = new java.util.ArrayList();
                    while (cVar.e_renamed()) {
                        cVar.c_renamed();
                        while (cVar.e_renamed()) {
                            if (cVar.a_renamed(f2211c) == 0) {
                                arrayList4.add(cVar.i_renamed());
                            } else {
                                cVar.h_renamed();
                                cVar.m_renamed();
                            }
                        }
                        cVar.d_renamed();
                    }
                    cVar.b_renamed();
                    dVar.a_renamed("Lottie doesn't_renamed support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as_renamed contents  in_renamed your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fK3 = (float) cVar.k_renamed();
                    break;
                case 15:
                    fK2 = (float) cVar.k_renamed();
                    break;
                case 16:
                    iL3 = (int) (cVar.l_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
                    break;
                case 17:
                    iL4 = (int) (cVar.l_renamed() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
                    break;
                case 18:
                    fK_renamed = (float) cVar.k_renamed();
                    break;
                case 19:
                    fK4 = (float) cVar.k_renamed();
                    break;
                case 20:
                    bVarA = com.airbnb.lottie.e_renamed.d_renamed.a_renamed(cVar, dVar, false);
                    break;
                case 21:
                    strI2 = cVar.i_renamed();
                    break;
                case 22:
                    zJ = cVar.j_renamed();
                    break;
                default:
                    cVar.h_renamed();
                    cVar.m_renamed();
                    break;
            }
        }
        cVar.d_renamed();
        float f3 = fK_renamed / fK3;
        float fG_renamed = fK4 / fK3;
        java.util.ArrayList arrayList5 = new java.util.ArrayList();
        if (f3 > 0.0f) {
            f_renamed = fK3;
            arrayList = arrayList5;
            arrayList.add(new com.airbnb.lottie.g_renamed.a_renamed(dVar, fValueOf2, fValueOf2, null, 0.0f, java.lang.Float.valueOf(f3)));
            f2 = 0.0f;
        } else {
            f_renamed = fK3;
            arrayList = arrayList5;
            f2 = 0.0f;
        }
        if (fG_renamed <= f2) {
            fG_renamed = dVar.g_renamed();
        }
        arrayList.add(new com.airbnb.lottie.g_renamed.a_renamed(dVar, fValueOf, fValueOf, null, f3, java.lang.Float.valueOf(fG_renamed)));
        arrayList.add(new com.airbnb.lottie.g_renamed.a_renamed(dVar, fValueOf2, fValueOf2, null, fG_renamed, java.lang.Float.valueOf(Float.MAX_VALUE)));
        if (strI3.endsWith(".ai_renamed") || "ai_renamed".equals(strI2)) {
            dVar.a_renamed("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.c_renamed.c_renamed.d_renamed(arrayList3, dVar, strI3, jL2, aVar, jL, strI, arrayList2, lVarA, iL, iL2, color, f_renamed, fK2, iL3, iL4, jVarF, kVarA, arrayList, bVar2, bVarA, zJ);
    }

    /* compiled from: LayerParser.java */
    /* renamed from: com.airbnb.lottie.e_renamed.s_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2212a = new int[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.values().length];

        static {
            try {
                f2212a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.LUMA.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2212a[com.airbnb.lottie.c_renamed.c_renamed.d_renamed.b_renamed.LUMA_INVERTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }
}
