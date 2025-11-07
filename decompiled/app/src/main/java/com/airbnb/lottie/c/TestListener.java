package com.airbnb.lottie.c_renamed;

/* compiled from: LottieCompositionCache.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.c_renamed.g_renamed f2136a = new com.airbnb.lottie.c_renamed.g_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.collection.LruCache<java.lang.String, com.airbnb.lottie.d_renamed> f2137b = new androidx.collection.LruCache<>(20);

    public static com.airbnb.lottie.c_renamed.g_renamed a_renamed() {
        return f2136a;
    }

    g_renamed() {
    }

    public com.airbnb.lottie.d_renamed a_renamed(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.f2137b.get(str);
    }

    public void a_renamed(java.lang.String str, com.airbnb.lottie.d_renamed dVar) {
        if (str == null) {
            return;
        }
        this.f2137b.put(str, dVar);
    }
}
