package com.airbnb.lottie.e_renamed;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2203a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("x_renamed", "y_renamed");

    static int a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar) throws java.io.IOException {
        cVar.a_renamed();
        int iK = (int) (cVar.k_renamed() * 255.0d);
        int iK2 = (int) (cVar.k_renamed() * 255.0d);
        int iK3 = (int) (cVar.k_renamed() * 255.0d);
        while (cVar.e_renamed()) {
            cVar.m_renamed();
        }
        cVar.b_renamed();
        return android.graphics.Color.argb(255, iK, iK2, iK3);
    }

    static java.util.List<android.graphics.PointF> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        cVar.a_renamed();
        while (cVar.f_renamed() == com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY) {
            cVar.a_renamed();
            arrayList.add(b_renamed(cVar, f_renamed));
            cVar.b_renamed();
        }
        cVar.b_renamed();
        return arrayList;
    }

    /* compiled from: JsonUtils.java */
    /* renamed from: com.airbnb.lottie.e_renamed.p_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2204a = new int[com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.values().length];

        static {
            try {
                f2204a[com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2204a[com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_ARRAY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2204a[com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.BEGIN_OBJECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    static android.graphics.PointF b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        int i_renamed = com.airbnb.lottie.e_renamed.p_renamed.SceneLoader_2.f2204a[cVar.f_renamed().ordinal()];
        if (i_renamed == 1) {
            return c_renamed(cVar, f_renamed);
        }
        if (i_renamed == 2) {
            return d_renamed(cVar, f_renamed);
        }
        if (i_renamed == 3) {
            return e_renamed(cVar, f_renamed);
        }
        throw new java.lang.IllegalArgumentException("Unknown point starts with " + cVar.f_renamed());
    }

    private static android.graphics.PointF c_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        float fK_renamed = (float) cVar.k_renamed();
        float fK2 = (float) cVar.k_renamed();
        while (cVar.e_renamed()) {
            cVar.m_renamed();
        }
        return new android.graphics.PointF(fK_renamed * f_renamed, fK2 * f_renamed);
    }

    private static android.graphics.PointF d_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        cVar.a_renamed();
        float fK_renamed = (float) cVar.k_renamed();
        float fK2 = (float) cVar.k_renamed();
        while (cVar.f_renamed() != com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed.END_ARRAY) {
            cVar.m_renamed();
        }
        cVar.b_renamed();
        return new android.graphics.PointF(fK_renamed * f_renamed, fK2 * f_renamed);
    }

    private static android.graphics.PointF e_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed) throws java.io.IOException {
        cVar.c_renamed();
        float fB_renamed = 0.0f;
        float fB2 = 0.0f;
        while (cVar.e_renamed()) {
            int iA = cVar.a_renamed(f2203a);
            if (iA == 0) {
                fB_renamed = b_renamed(cVar);
            } else if (iA == 1) {
                fB2 = b_renamed(cVar);
            } else {
                cVar.h_renamed();
                cVar.m_renamed();
            }
        }
        cVar.d_renamed();
        return new android.graphics.PointF(fB_renamed * f_renamed, fB2 * f_renamed);
    }

    static float b_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar) throws java.io.IOException {
        com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed bVarF = cVar.f_renamed();
        int i_renamed = com.airbnb.lottie.e_renamed.p_renamed.SceneLoader_2.f2204a[bVarF.ordinal()];
        if (i_renamed == 1) {
            return (float) cVar.k_renamed();
        }
        if (i_renamed == 2) {
            cVar.a_renamed();
            float fK_renamed = (float) cVar.k_renamed();
            while (cVar.e_renamed()) {
                cVar.m_renamed();
            }
            cVar.b_renamed();
            return fK_renamed;
        }
        throw new java.lang.IllegalArgumentException("Unknown value for token of_renamed type " + bVarF);
    }
}
