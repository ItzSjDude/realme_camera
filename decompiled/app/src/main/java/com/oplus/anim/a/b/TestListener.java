package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path>> f3502a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer>> f3503b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.c_renamed.b_renamed.g_renamed> f3504c;

    public g_renamed(java.util.List<com.oplus.anim.c_renamed.b_renamed.g_renamed> list) {
        this.f3504c = list;
        this.f3502a = new java.util.ArrayList(list.size());
        this.f3503b = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            this.f3502a.add(list.get(i_renamed).b_renamed().a_renamed());
            this.f3503b.add(list.get(i_renamed).c_renamed().a_renamed());
        }
    }

    public java.util.List<com.oplus.anim.c_renamed.b_renamed.g_renamed> a_renamed() {
        return this.f3504c;
    }

    public java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.c_renamed.b_renamed.l_renamed, android.graphics.Path>> b_renamed() {
        return this.f3502a;
    }

    public java.util.List<com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer>> c_renamed() {
        return this.f3503b;
    }
}
