package com.airbnb.lottie.e_renamed;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q_renamed {
    private static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> d_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2207c = new android.view.animation.LinearInterpolator();

    /* renamed from: a_renamed, reason: collision with root package name */
    static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2205a = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("t_renamed", "s_renamed", "e_renamed", "o_renamed", "i_renamed", "h_renamed", "to", "ti");

    /* renamed from: b_renamed, reason: collision with root package name */
    static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed f2206b = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed.a_renamed("x_renamed", "y_renamed");

    q_renamed() {
    }

    private static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> a_renamed() {
        if (d_renamed == null) {
            d_renamed = new androidx.collection.SparseArrayCompat<>();
        }
        return d_renamed;
    }

    private static java.lang.ref.WeakReference<android.view.animation.Interpolator> a_renamed(int i_renamed) {
        java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference;
        synchronized (com.airbnb.lottie.e_renamed.q_renamed.class) {
            weakReference = a_renamed().get(i_renamed);
        }
        return weakReference;
    }

    private static void a_renamed(int i_renamed, java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference) {
        synchronized (com.airbnb.lottie.e_renamed.q_renamed.class) {
            d_renamed.put(i_renamed, weakReference);
        }
    }

    static <T_renamed> com.airbnb.lottie.g_renamed.a_renamed<T_renamed> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, com.airbnb.lottie.d_renamed dVar, float f_renamed, com.airbnb.lottie.e_renamed.aj_renamed<T_renamed> ajVar, boolean z_renamed, boolean z2) throws java.io.IOException {
        if (z_renamed && z2) {
            return b_renamed(dVar, cVar, f_renamed, ajVar);
        }
        if (z_renamed) {
            return a_renamed(dVar, cVar, f_renamed, ajVar);
        }
        return a_renamed(cVar, f_renamed, ajVar);
    }

    private static <T_renamed> com.airbnb.lottie.g_renamed.a_renamed<T_renamed> a_renamed(com.airbnb.lottie.d_renamed dVar, com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed, com.airbnb.lottie.e_renamed.aj_renamed<T_renamed> ajVar) throws java.io.IOException {
        android.view.animation.Interpolator interpolatorA;
        android.view.animation.Interpolator interpolator;
        T_renamed t_renamed;
        cVar.c_renamed();
        android.graphics.PointF pointFB = null;
        T_renamed tB = null;
        T_renamed tB2 = null;
        android.graphics.PointF pointFB2 = null;
        android.graphics.PointF pointFB3 = null;
        float fK_renamed = 0.0f;
        boolean z_renamed = false;
        android.graphics.PointF pointFB4 = null;
        while (cVar.e_renamed()) {
            switch (cVar.a_renamed(f2205a)) {
                case 0:
                    fK_renamed = (float) cVar.k_renamed();
                    break;
                case 1:
                    tB2 = ajVar.b_renamed(cVar, f_renamed);
                    break;
                case 2:
                    tB = ajVar.b_renamed(cVar, f_renamed);
                    break;
                case 3:
                    pointFB4 = com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, 1.0f);
                    break;
                case 4:
                    pointFB = com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.l_renamed() != 1) {
                        z_renamed = false;
                        break;
                    } else {
                        z_renamed = true;
                        break;
                    }
                case 6:
                    pointFB2 = com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, f_renamed);
                    break;
                case 7:
                    pointFB3 = com.airbnb.lottie.e_renamed.p_renamed.b_renamed(cVar, f_renamed);
                    break;
                default:
                    cVar.m_renamed();
                    break;
            }
        }
        cVar.d_renamed();
        if (z_renamed) {
            interpolator = f2207c;
            t_renamed = tB2;
        } else {
            if (pointFB4 != null && pointFB != null) {
                interpolatorA = a_renamed(pointFB4, pointFB);
            } else {
                interpolatorA = f2207c;
            }
            interpolator = interpolatorA;
            t_renamed = tB;
        }
        com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar = new com.airbnb.lottie.g_renamed.a_renamed<>(dVar, tB2, t_renamed, interpolator, fK_renamed, null);
        aVar.h_renamed = pointFB2;
        aVar.i_renamed = pointFB3;
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T_renamed> com.airbnb.lottie.g_renamed.a_renamed<T_renamed> b_renamed(com.airbnb.lottie.d_renamed r20, com.airbnb.lottie.e_renamed.a_renamed.c_renamed r21, float r22, com.airbnb.lottie.e_renamed.aj_renamed<T_renamed> r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e_renamed.q_renamed.b_renamed(com.airbnb.lottie.d_renamed, com.airbnb.lottie.e_renamed.a_renamed.c_renamed, float, com.airbnb.lottie.e_renamed.aj_renamed):com.airbnb.lottie.g_renamed.a_renamed");
    }

    private static android.view.animation.Interpolator a_renamed(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        android.view.animation.Interpolator linearInterpolator;
        pointF.x_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(pointF.x_renamed, -1.0f, 1.0f);
        pointF.y_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(pointF.y_renamed, -100.0f, 100.0f);
        pointF2.x_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(pointF2.x_renamed, -1.0f, 1.0f);
        pointF2.y_renamed = com.airbnb.lottie.f_renamed.g_renamed.b_renamed(pointF2.y_renamed, -100.0f, 100.0f);
        int iA = com.airbnb.lottie.f_renamed.h_renamed.a_renamed(pointF.x_renamed, pointF.y_renamed, pointF2.x_renamed, pointF2.y_renamed);
        java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReferenceA = a_renamed(iA);
        android.view.animation.Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                linearInterpolator = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(pointF.x_renamed, pointF.y_renamed, pointF2.x_renamed, pointF2.y_renamed);
            } catch (java.lang.IllegalArgumentException e_renamed) {
                if ("The Path cannot loop back on_renamed itself.".equals(e_renamed.getMessage())) {
                    linearInterpolator = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(java.lang.Math.min(pointF.x_renamed, 1.0f), pointF.y_renamed, java.lang.Math.max(pointF2.x_renamed, 0.0f), pointF2.y_renamed);
                } else {
                    linearInterpolator = new android.view.animation.LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                a_renamed(iA, (java.lang.ref.WeakReference<android.view.animation.Interpolator>) new java.lang.ref.WeakReference(interpolator));
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    private static <T_renamed> com.airbnb.lottie.g_renamed.a_renamed<T_renamed> a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed cVar, float f_renamed, com.airbnb.lottie.e_renamed.aj_renamed<T_renamed> ajVar) throws java.io.IOException {
        return new com.airbnb.lottie.g_renamed.a_renamed<>(ajVar.b_renamed(cVar, f_renamed));
    }
}
