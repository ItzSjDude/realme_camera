package com.airbnb.lottie.e_renamed;

/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
class r_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2208a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("k_renamed");

    static <T_renamed> java.util.List<com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, float f_renamed, com.airbnb.lottie.e_renamed.aj_renamed<T_renamed> ajVar, boolean z_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.STRING) {
            dVar.a_renamed("Lottie doesn't_renamed support expressions.");
            return arrayList;
        }
        cVar.c_renamed();
        while (cVar.e_renamed()) {
            if (cVar.a_renamed(f2208a) == 0) {
                if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY) {
                    cVar.a_renamed();
                    if (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NUMBER) {
                        arrayList.add(com.airbnb.lottie.e_renamed.q_renamed.a_renamed(cVar, dVar, f_renamed, ajVar, false, z_renamed));
                    } else {
                        while (cVar.e_renamed()) {
                            arrayList.add(com.airbnb.lottie.e_renamed.q_renamed.a_renamed(cVar, dVar, f_renamed, ajVar, true, z_renamed));
                        }
                    }
                    cVar.b_renamed();
                } else {
                    arrayList.add(com.airbnb.lottie.e_renamed.q_renamed.a_renamed(cVar, dVar, f_renamed, ajVar, false, z_renamed));
                }
            } else {
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        a_renamed(arrayList);
        return arrayList;
    }

    public static <T_renamed> void a_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> list) {
        int i_renamed;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i_renamed = size - 1;
            if (i2 >= i_renamed) {
                break;
            }
            com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar = list.get(i2);
            i2++;
            com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar2 = list.get(i2);
            aVar.g_renamed = java.lang.Float.valueOf(aVar2.f_renamed);
            if (aVar.f2267b == null && aVar2.f2266a != null) {
                aVar.f2267b = aVar2.f2266a;
                if (aVar instanceof com.airbnb.lottie.a_renamed.b_renamed.h_renamed) {
                    ((com.airbnb.lottie.a_renamed.b_renamed.h_renamed) aVar).a_renamed();
                }
            }
        }
        com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar3 = list.get(i_renamed);
        if ((aVar3.f2266a == null || aVar3.f2267b == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
