package com.airbnb.lottie.e_renamed;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2214b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("w_renamed", "h_renamed", "ip", "op", "fr_renamed", "v_renamed", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: a_renamed, reason: collision with root package name */
    static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2213a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, "layers", "w_renamed", "h_renamed", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "u_renamed");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2215c = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("list");
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed d_renamed = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("cm_renamed", "tm", "dr_renamed");

    public static com.airbnb.lottie.d_renamed a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar) throws java.io.IOException {
        java.util.HashMap map;
        java.util.ArrayList arrayList;
        com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar2 = cVar;
        float fA_renamed = com.airbnb.lottie.f_renamed.h_renamed.a_renamed();
        androidx.collection.LongSparseArray<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> longSparseArray = new androidx.collection.LongSparseArray<>();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.HashMap map2 = new java.util.HashMap();
        java.util.HashMap map3 = new java.util.HashMap();
        java.util.HashMap map4 = new java.util.HashMap();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        androidx.collection.SparseArrayCompat<com.airbnb.lottie.c_renamed.d_renamed> sparseArrayCompat = new androidx.collection.SparseArrayCompat<>();
        com.airbnb.lottie.d_renamed dVar = new com.airbnb.lottie.d_renamed();
        cVar.c_renamed();
        float fK_renamed = 0.0f;
        float fK2 = 0.0f;
        float fK3 = 0.0f;
        int iL = 0;
        int iL2 = 0;
        while (cVar.e_renamed()) {
            switch (cVar2.a_renamed(f2214b)) {
                case 0:
                    iL = cVar.l_renamed();
                    break;
                case 1:
                    iL2 = cVar.l_renamed();
                    break;
                case 2:
                    map = map4;
                    arrayList = arrayList3;
                    fK_renamed = (float) cVar.k_renamed();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fK2 = ((float) cVar.k_renamed()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fK3 = (float) cVar.k_renamed();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    java.lang.String[] strArrSplit = cVar.i_renamed().split("\\.");
                    if (!com.airbnb.lottie.f_renamed.h_renamed.a_renamed(java.lang.Integer.parseInt(strArrSplit[0]), java.lang.Integer.parseInt(strArrSplit[1]), java.lang.Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        dVar.a_renamed("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    a_renamed(cVar2, dVar, arrayList2, longSparseArray);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    a_renamed(cVar2, dVar, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    a_renamed(cVar2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    a_renamed(cVar2, dVar, sparseArrayCompat);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    a_renamed(cVar2, dVar, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    cVar.h_renamed();
                    cVar.m_renamed();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            cVar2 = cVar;
        }
        dVar.a_renamed(new android.graphics.Rect(0, 0, (int) (iL * fA_renamed), (int) (iL2 * fA_renamed)), fK_renamed, fK2, fK3, arrayList2, longSparseArray, map2, map3, sparseArrayCompat, map4, arrayList3);
        return dVar;
    }

    private static void a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> list, androidx.collection.LongSparseArray<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> longSparseArray) throws java.io.IOException {
        cVar.a_renamed();
        int i_renamed = 0;
        while (cVar.e_renamed()) {
            com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVarA = com.airbnb.lottie.e_renamed.s_renamed.a_renamed(cVar, dVar);
            if (dVarA.k_renamed() == com.airbnb.lottie.c_renamed.c_renamed.d_renamed.a_renamed.IMAGE) {
                i_renamed++;
            }
            list.add(dVarA);
            longSparseArray.put(dVarA.e_renamed(), dVarA);
            if (i_renamed > 4) {
                com.airbnb.lottie.f_renamed.d_renamed.b_renamed("You have " + i_renamed + " images. Lottie should primarily be_renamed used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.b_renamed();
    }

    private static void a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed>> map, java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> map2) throws java.io.IOException {
        cVar.a_renamed();
        while (cVar.e_renamed()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray();
            cVar.c_renamed();
            int iL = 0;
            int iL2 = 0;
            java.lang.String strI = null;
            java.lang.String strI2 = null;
            java.lang.String strI3 = null;
            while (cVar.e_renamed()) {
                int iA = cVar.a_renamed(f2213a);
                if (iA == 0) {
                    strI = cVar.i_renamed();
                } else if (iA == 1) {
                    cVar.a_renamed();
                    while (cVar.e_renamed()) {
                        com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVarA = com.airbnb.lottie.e_renamed.s_renamed.a_renamed(cVar, dVar);
                        longSparseArray.put(dVarA.e_renamed(), dVarA);
                        arrayList.add(dVarA);
                    }
                    cVar.b_renamed();
                } else if (iA == 2) {
                    iL = cVar.l_renamed();
                } else if (iA == 3) {
                    iL2 = cVar.l_renamed();
                } else if (iA == 4) {
                    strI2 = cVar.i_renamed();
                } else if (iA == 5) {
                    strI3 = cVar.i_renamed();
                } else {
                    cVar.h_renamed();
                    cVar.m_renamed();
                }
            }
            cVar.d_renamed();
            if (strI2 != null) {
                com.airbnb.lottie.g_renamed gVar = new com.airbnb.lottie.g_renamed(iL, iL2, strI, strI2, strI3);
                map2.put(gVar.c_renamed(), gVar);
            } else {
                map.put(strI, arrayList);
            }
        }
        cVar.b_renamed();
    }

    private static void a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, java.util.Map<java.lang.String, com.airbnb.lottie.c_renamed.c_renamed> map) throws java.io.IOException {
        cVar.c_renamed();
        while (cVar.e_renamed()) {
            if (cVar.a_renamed(f2215c) == 0) {
                cVar.a_renamed();
                while (cVar.e_renamed()) {
                    com.airbnb.lottie.c_renamed.c_renamed cVarA = com.airbnb.lottie.e_renamed.k_renamed.a_renamed(cVar);
                    map.put(cVarA.b_renamed(), cVarA);
                }
                cVar.b_renamed();
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
    }

    private static void a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, androidx.collection.SparseArrayCompat<com.airbnb.lottie.c_renamed.d_renamed> sparseArrayCompat) throws java.io.IOException {
        cVar.a_renamed();
        while (cVar.e_renamed()) {
            com.airbnb.lottie.c_renamed.d_renamed dVarA = com.airbnb.lottie.e_renamed.j_renamed.a_renamed(cVar, dVar);
            sparseArrayCompat.put(dVarA.hashCode(), dVarA);
        }
        cVar.b_renamed();
    }

    private static void a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, java.util.List<com.airbnb.lottie.c_renamed.h_renamed> list) throws java.io.IOException {
        cVar.a_renamed();
        while (cVar.e_renamed()) {
            java.lang.String strI = null;
            cVar.c_renamed();
            float fK_renamed = 0.0f;
            float fK2 = 0.0f;
            while (cVar.e_renamed()) {
                int iA = cVar.a_renamed(d_renamed);
                if (iA == 0) {
                    strI = cVar.i_renamed();
                } else if (iA == 1) {
                    fK_renamed = (float) cVar.k_renamed();
                } else if (iA == 2) {
                    fK2 = (float) cVar.k_renamed();
                } else {
                    cVar.h_renamed();
                    cVar.m_renamed();
                }
            }
            cVar.d_renamed();
            list.add(new com.airbnb.lottie.c_renamed.h_renamed(strI, fK_renamed, fK2));
        }
        cVar.b_renamed();
    }
}
