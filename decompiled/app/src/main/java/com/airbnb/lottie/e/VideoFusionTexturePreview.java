package com.airbnb.lottie.e_renamed;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class ad_renamed implements com.airbnb.lottie.e_renamed.aj_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.e_renamed.ad_renamed f2175a = new com.airbnb.lottie.e_renamed.ad_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2176b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("c_renamed", "v_renamed", "i_renamed", "o_renamed");

    private ad_renamed() {
    }

    @Override // com.airbnb.lottie.e_renamed.aj_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.c_renamed.b_renamed.l_renamed b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY) {
            cVar.a_renamed();
        }
        cVar.c_renamed();
        java.util.List<android.graphics.PointF> listA = null;
        java.util.List<android.graphics.PointF> listA2 = null;
        java.util.List<android.graphics.PointF> listA3 = null;
        boolean zJ = false;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2176b);
            if (iA == 0) {
                zJ = cVar.j_renamed();
            } else if (iA == 1) {
                listA = com.airbnb.lottie.e_renamed.p_renamed.a_renamed(cVar, f_renamed);
            } else if (iA == 2) {
                listA2 = com.airbnb.lottie.e_renamed.p_renamed.a_renamed(cVar, f_renamed);
            } else if (iA == 3) {
                listA3 = com.airbnb.lottie.e_renamed.p_renamed.a_renamed(cVar, f_renamed);
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_ARRAY) {
            cVar.b_renamed();
        }
        if (listA == null || listA2 == null || listA3 == null) {
            throw new java.lang.IllegalArgumentException("Shape data was missing information.");
        }
        if (listA.isEmpty()) {
            return new com.airbnb.lottie.c_renamed.b_renamed.l_renamed(new android.graphics.PointF(), false, java.util.Collections.emptyList());
        }
        int size = listA.size();
        android.graphics.PointF pointF = listA.get(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i_renamed = 1; i_renamed < size; i_renamed++) {
            android.graphics.PointF pointF2 = listA.get(i_renamed);
            int i2 = i_renamed - 1;
            arrayList.add(new com.airbnb.lottie.c_renamed.a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(listA.get(i2), listA3.get(i2)), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointF2, listA2.get(i_renamed)), pointF2));
        }
        if (zJ) {
            android.graphics.PointF pointF3 = listA.get(0);
            int i3 = size - 1;
            arrayList.add(new com.airbnb.lottie.c_renamed.a_renamed(com.airbnb.lottie.f_renamed.g_renamed.a_renamed(listA.get(i3), listA3.get(i3)), com.airbnb.lottie.f_renamed.g_renamed.a_renamed(pointF3, listA2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.c_renamed.b_renamed.l_renamed(pointF, zJ, arrayList);
    }
}
