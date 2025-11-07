package com.oplus.anim.e_renamed;

/* compiled from: KeyframeParser.java */
/* loaded from: classes2.dex */
class r_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f3659a = new android.view.animation.LinearInterpolator();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> f3660b;

    r_renamed() {
    }

    private static androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> a_renamed() {
        if (f3660b == null) {
            f3660b = new androidx.collection.SparseArrayCompat<>();
        }
        return f3660b;
    }

    private static java.lang.ref.WeakReference<android.view.animation.Interpolator> a_renamed(int i_renamed) {
        java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference;
        synchronized (com.oplus.anim.e_renamed.r_renamed.class) {
            weakReference = a_renamed().get(i_renamed);
        }
        return weakReference;
    }

    private static void a_renamed(int i_renamed, java.lang.ref.WeakReference<android.view.animation.Interpolator> weakReference) {
        synchronized (com.oplus.anim.e_renamed.r_renamed.class) {
            f3660b.put(i_renamed, weakReference);
        }
    }

    static <T_renamed> com.oplus.anim.g_renamed.c_renamed<T_renamed> a_renamed(android.util.JsonReader jsonReader, com.oplus.anim.a_renamed aVar, float f_renamed, com.oplus.anim.e_renamed.aj_renamed<T_renamed> ajVar, boolean z_renamed) throws java.io.IOException {
        if (z_renamed) {
            return a_renamed(aVar, jsonReader, f_renamed, ajVar);
        }
        return a_renamed(jsonReader, f_renamed, ajVar);
    }

    private static <T_renamed> com.oplus.anim.g_renamed.c_renamed<T_renamed> a_renamed(android.util.JsonReader jsonReader, float f_renamed, com.oplus.anim.e_renamed.aj_renamed<T_renamed> ajVar) throws java.io.IOException {
        return new com.oplus.anim.g_renamed.c_renamed<>(ajVar.b_renamed(jsonReader, f_renamed));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T_renamed> com.oplus.anim.g_renamed.c_renamed<T_renamed> a_renamed(com.oplus.anim.a_renamed r17, android.util.JsonReader r18, float r19, com.oplus.anim.e_renamed.aj_renamed<T_renamed> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.e_renamed.r_renamed.a_renamed(com.oplus.anim.a_renamed, android.util.JsonReader, float, com.oplus.anim.e_renamed.aj_renamed):com.oplus.anim.g_renamed.c_renamed");
    }
}
