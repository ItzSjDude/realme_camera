package com.oplus.anim.c_renamed;

/* compiled from: FontCharacter.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.c_renamed.b_renamed.n_renamed> f3631a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final char f3632b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final double f3633c;
    private final double d_renamed;
    private final java.lang.String e_renamed;
    private final java.lang.String f_renamed;

    public e_renamed(java.util.List<com.oplus.anim.c_renamed.b_renamed.n_renamed> list, char c2, double d_renamed, double d2, java.lang.String str, java.lang.String str2) {
        this.f3631a = list;
        this.f3632b = c2;
        this.f3633c = d_renamed;
        this.d_renamed = d2;
        this.e_renamed = str;
        this.f_renamed = str2;
    }

    public static int a_renamed(char c2, java.lang.String str, java.lang.String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public java.util.List<com.oplus.anim.c_renamed.b_renamed.n_renamed> a_renamed() {
        return this.f3631a;
    }

    public double b_renamed() {
        return this.d_renamed;
    }

    public int hashCode() {
        return a_renamed(this.f3632b, this.f_renamed, this.e_renamed);
    }
}
