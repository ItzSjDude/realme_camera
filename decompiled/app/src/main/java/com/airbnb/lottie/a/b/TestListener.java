package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path>> f2036a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer>> f2037b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.c_renamed.b_renamed.g_renamed> f2038c;

    public g_renamed(java.util.List<com.airbnb.lottie.c_renamed.b_renamed.g_renamed> list) {
        this.f2038c = list;
        this.f2036a = new java.util.ArrayList(list.size());
        this.f2037b = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            this.f2036a.add(list.get(i_renamed).b_renamed().a_renamed());
            this.f2037b.add(list.get(i_renamed).c_renamed().a_renamed());
        }
    }

    public java.util.List<com.airbnb.lottie.c_renamed.b_renamed.g_renamed> a_renamed() {
        return this.f2038c;
    }

    public java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<com.airbnb.lottie.c_renamed.b_renamed.l_renamed, android.graphics.Path>> b_renamed() {
        return this.f2036a;
    }

    public java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer>> c_renamed() {
        return this.f2037b;
    }
}
