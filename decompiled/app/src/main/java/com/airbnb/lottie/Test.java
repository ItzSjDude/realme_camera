package com.airbnb.lottie;

/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class d_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed>> f2145c;
    private java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> d_renamed;
    private java.util.Map<java.lang.String, com.airbnb.lottie.c_renamed.c_renamed> e_renamed;
    private java.util.List<com.airbnb.lottie.c_renamed.h_renamed> f_renamed;
    private androidx.collection.SparseArrayCompat<com.airbnb.lottie.c_renamed.d_renamed> g_renamed;
    private androidx.collection.LongSparseArray<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> h_renamed;
    private java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> i_renamed;
    private android.graphics.Rect j_renamed;
    private float k_renamed;
    private float l_renamed;
    private float m_renamed;
    private boolean n_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.n_renamed f2143a = new com.airbnb.lottie.n_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.HashSet<java.lang.String> f2144b = new java.util.HashSet<>();
    private int o_renamed = 0;

    public void a_renamed(android.graphics.Rect rect, float f_renamed, float f2, float f3, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> list, androidx.collection.LongSparseArray<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> longSparseArray, java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed>> map, java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> map2, androidx.collection.SparseArrayCompat<com.airbnb.lottie.c_renamed.d_renamed> sparseArrayCompat, java.util.Map<java.lang.String, com.airbnb.lottie.c_renamed.c_renamed> map3, java.util.List<com.airbnb.lottie.c_renamed.h_renamed> list2) {
        this.j_renamed = rect;
        this.k_renamed = f_renamed;
        this.l_renamed = f2;
        this.m_renamed = f3;
        this.i_renamed = list;
        this.h_renamed = longSparseArray;
        this.f2145c = map;
        this.d_renamed = map2;
        this.g_renamed = sparseArrayCompat;
        this.e_renamed = map3;
        this.f_renamed = list2;
    }

    public void a_renamed(java.lang.String str) {
        com.airbnb.lottie.f_renamed.d_renamed.b_renamed(str);
        this.f2144b.add(str);
    }

    public void a_renamed(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.o_renamed += i_renamed;
    }

    public boolean a_renamed() {
        return this.n_renamed;
    }

    public int b_renamed() {
        return this.o_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.f2143a.a_renamed(z_renamed);
    }

    public com.airbnb.lottie.n_renamed c_renamed() {
        return this.f2143a;
    }

    public com.airbnb.lottie.c_renamed.c_renamed.d_renamed a_renamed(long j_renamed) {
        return this.h_renamed.get(j_renamed);
    }

    public android.graphics.Rect d_renamed() {
        return this.j_renamed;
    }

    public float e_renamed() {
        return (long) ((m_renamed() / this.m_renamed) * 1000.0f);
    }

    public float f_renamed() {
        return this.k_renamed;
    }

    public float g_renamed() {
        return this.l_renamed;
    }

    public float h_renamed() {
        return this.m_renamed;
    }

    public java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> i_renamed() {
        return this.i_renamed;
    }

    public java.util.List<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> b_renamed(java.lang.String str) {
        return this.f2145c.get(str);
    }

    public androidx.collection.SparseArrayCompat<com.airbnb.lottie.c_renamed.d_renamed> j_renamed() {
        return this.g_renamed;
    }

    public java.util.Map<java.lang.String, com.airbnb.lottie.c_renamed.c_renamed> k_renamed() {
        return this.e_renamed;
    }

    public com.airbnb.lottie.c_renamed.h_renamed c_renamed(java.lang.String str) {
        int size = this.f_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.airbnb.lottie.c_renamed.h_renamed hVar = this.f_renamed.get(i_renamed);
            if (hVar.a_renamed(str)) {
                return hVar;
            }
        }
        return null;
    }

    public java.util.Map<java.lang.String, com.airbnb.lottie.g_renamed> l_renamed() {
        return this.d_renamed;
    }

    public float m_renamed() {
        return this.l_renamed - this.k_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("LottieComposition:\n_renamed");
        java.util.Iterator<com.airbnb.lottie.c_renamed.c_renamed.d_renamed> it = this.i_renamed.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a_renamed("\t_renamed"));
        }
        return sb.toString();
    }
}
