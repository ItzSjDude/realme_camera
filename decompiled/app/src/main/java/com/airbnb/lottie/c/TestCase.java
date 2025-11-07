package com.airbnb.lottie.c_renamed;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.airbnb.lottie.c_renamed.e_renamed f2133a = new com.airbnb.lottie.c_renamed.e_renamed("COMPOSITION");

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<java.lang.String> f2134b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.airbnb.lottie.c_renamed.f_renamed f2135c;

    public e_renamed(java.lang.String... strArr) {
        this.f2134b = java.util.Arrays.asList(strArr);
    }

    private e_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar) {
        this.f2134b = new java.util.ArrayList(eVar.f2134b);
        this.f2135c = eVar.f2135c;
    }

    public com.airbnb.lottie.c_renamed.e_renamed a_renamed(java.lang.String str) {
        com.airbnb.lottie.c_renamed.e_renamed eVar = new com.airbnb.lottie.c_renamed.e_renamed(this);
        eVar.f2134b.add(str);
        return eVar;
    }

    public com.airbnb.lottie.c_renamed.e_renamed a_renamed(com.airbnb.lottie.c_renamed.f_renamed fVar) {
        com.airbnb.lottie.c_renamed.e_renamed eVar = new com.airbnb.lottie.c_renamed.e_renamed(this);
        eVar.f2135c = fVar;
        return eVar;
    }

    public com.airbnb.lottie.c_renamed.f_renamed a_renamed() {
        return this.f2135c;
    }

    public boolean a_renamed(java.lang.String str, int i_renamed) {
        if (b_renamed(str)) {
            return true;
        }
        if (i_renamed >= this.f2134b.size()) {
            return false;
        }
        return this.f2134b.get(i_renamed).equals(str) || this.f2134b.get(i_renamed).equals("**") || this.f2134b.get(i_renamed).equals("*");
    }

    public int b_renamed(java.lang.String str, int i_renamed) {
        if (b_renamed(str)) {
            return 0;
        }
        if (this.f2134b.get(i_renamed).equals("**")) {
            return (i_renamed != this.f2134b.size() - 1 && this.f2134b.get(i_renamed + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean c_renamed(java.lang.String str, int i_renamed) {
        if (i_renamed >= this.f2134b.size()) {
            return false;
        }
        boolean z_renamed = i_renamed == this.f2134b.size() - 1;
        java.lang.String str2 = this.f2134b.get(i_renamed);
        if (!str2.equals("**")) {
            return (z_renamed || (i_renamed == this.f2134b.size() + (-2) && b_renamed())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z_renamed && this.f2134b.get(i_renamed + 1).equals(str)) {
            return i_renamed == this.f2134b.size() + (-2) || (i_renamed == this.f2134b.size() + (-3) && b_renamed());
        }
        if (z_renamed) {
            return true;
        }
        int i2 = i_renamed + 1;
        if (i2 < this.f2134b.size() - 1) {
            return false;
        }
        return this.f2134b.get(i2).equals(str);
    }

    public boolean d_renamed(java.lang.String str, int i_renamed) {
        return "__container".equals(str) || i_renamed < this.f2134b.size() - 1 || this.f2134b.get(i_renamed).equals("**");
    }

    private boolean b_renamed(java.lang.String str) {
        return "__container".equals(str);
    }

    private boolean b_renamed() {
        return this.f2134b.get(r1.size() - 1).equals("**");
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f2134b);
        sb.append(",resolved=");
        sb.append(this.f2135c != null);
        sb.append('}');
        return sb.toString();
    }
}
