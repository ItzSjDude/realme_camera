package com.oplus.anim.c_renamed;

/* compiled from: KeyPath.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.List<java.lang.String> f3634a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.anim.c_renamed.g_renamed f3635b;

    public f_renamed(java.lang.String... strArr) {
        this.f3634a = java.util.Arrays.asList(strArr);
    }

    private f_renamed(com.oplus.anim.c_renamed.f_renamed fVar) {
        this.f3634a = new java.util.ArrayList(fVar.f3634a);
        this.f3635b = fVar.f3635b;
    }

    public com.oplus.anim.c_renamed.f_renamed a_renamed(java.lang.String str) {
        com.oplus.anim.c_renamed.f_renamed fVar = new com.oplus.anim.c_renamed.f_renamed(this);
        fVar.f3634a.add(str);
        return fVar;
    }

    public com.oplus.anim.c_renamed.f_renamed a_renamed(com.oplus.anim.c_renamed.g_renamed gVar) {
        com.oplus.anim.c_renamed.f_renamed fVar = new com.oplus.anim.c_renamed.f_renamed(this);
        fVar.f3635b = gVar;
        return fVar;
    }

    public com.oplus.anim.c_renamed.g_renamed a_renamed() {
        return this.f3635b;
    }

    public boolean a_renamed(java.lang.String str, int i_renamed) {
        if (b_renamed(str)) {
            return true;
        }
        if (i_renamed >= this.f3634a.size()) {
            return false;
        }
        return this.f3634a.get(i_renamed).equals(str) || this.f3634a.get(i_renamed).equals("**") || this.f3634a.get(i_renamed).equals("*");
    }

    public int b_renamed(java.lang.String str, int i_renamed) {
        if (b_renamed(str)) {
            return 0;
        }
        if (this.f3634a.get(i_renamed).equals("**")) {
            return (i_renamed != this.f3634a.size() - 1 && this.f3634a.get(i_renamed + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean c_renamed(java.lang.String str, int i_renamed) {
        if (i_renamed >= this.f3634a.size()) {
            return false;
        }
        boolean z_renamed = i_renamed == this.f3634a.size() - 1;
        java.lang.String str2 = this.f3634a.get(i_renamed);
        if (!str2.equals("**")) {
            return (z_renamed || (i_renamed == this.f3634a.size() + (-2) && b_renamed())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z_renamed && this.f3634a.get(i_renamed + 1).equals(str)) {
            return i_renamed == this.f3634a.size() + (-2) || (i_renamed == this.f3634a.size() + (-3) && b_renamed());
        }
        if (z_renamed) {
            return true;
        }
        int i2 = i_renamed + 1;
        if (i2 < this.f3634a.size() - 1) {
            return false;
        }
        return this.f3634a.get(i2).equals(str);
    }

    public boolean d_renamed(java.lang.String str, int i_renamed) {
        return "__container".equals(str) || i_renamed < this.f3634a.size() - 1 || this.f3634a.get(i_renamed).equals("**");
    }

    private boolean b_renamed(java.lang.String str) {
        return "__container".equals(str);
    }

    private boolean b_renamed() {
        return this.f3634a.get(r1.size() - 1).equals("**");
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f3634a);
        sb.append(",resolved=");
        sb.append(this.f3635b != null);
        sb.append('}');
        return sb.toString();
    }
}
