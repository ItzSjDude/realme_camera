package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FilterGroup.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public java.util.List<java.lang.String> f6902a = new java.util.ArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.util.List<java.lang.String> f6903b = new java.util.ArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    public java.util.List<java.lang.Integer> f6904c = new java.util.ArrayList();
    public java.util.List<java.lang.Integer> d_renamed = new java.util.ArrayList();
    public java.util.List<java.lang.String> e_renamed = this.f6903b;
    public java.util.List<java.lang.Integer> f_renamed = this.d_renamed;

    public java.util.List<java.lang.String> a_renamed(boolean z_renamed) {
        return z_renamed ? this.f6902a : this.f6903b;
    }

    public java.util.List<java.lang.Integer> b_renamed(boolean z_renamed) {
        return z_renamed ? this.f6904c : this.d_renamed;
    }

    public void a_renamed(java.lang.String str, java.lang.Integer num) {
        d_renamed(str, num);
    }

    public void b_renamed(java.lang.String str, java.lang.Integer num) {
        c_renamed(str, num);
        d_renamed(str, num);
    }

    public void a_renamed(int i_renamed, java.lang.String str, java.lang.Integer num) {
        b_renamed(i_renamed, str, num);
        c_renamed(i_renamed, str, num);
    }

    public void c_renamed(java.lang.String str, java.lang.Integer num) {
        this.f6902a.add(str);
        this.f6904c.add(num);
    }

    public void b_renamed(int i_renamed, java.lang.String str, java.lang.Integer num) {
        this.f6902a.add(i_renamed, str);
        this.f6904c.add(i_renamed, num);
    }

    public void d_renamed(java.lang.String str, java.lang.Integer num) {
        this.f6903b.add(str);
        this.d_renamed.add(num);
    }

    public void c_renamed(int i_renamed, java.lang.String str, java.lang.Integer num) {
        this.f6903b.add(i_renamed, str);
        this.d_renamed.add(i_renamed, num);
    }

    public void a_renamed(int i_renamed) {
        this.f6903b.remove(i_renamed);
        this.d_renamed.remove(i_renamed);
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.i_renamed iVar, boolean z_renamed, boolean z2) {
        if (z_renamed) {
            this.f6903b.addAll(iVar.f6903b);
            this.d_renamed.addAll(iVar.d_renamed);
        }
        if (z2) {
            this.f6902a.addAll(iVar.f6902a);
            this.f6904c.addAll(iVar.f6904c);
        }
    }
}
