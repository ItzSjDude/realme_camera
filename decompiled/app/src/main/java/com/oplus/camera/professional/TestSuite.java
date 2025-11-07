package com.oplus.camera.professional;

/* compiled from: HSSubModeBarData.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f5177a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f5179c;
    private java.lang.String d_renamed;
    private java.lang.String e_renamed;
    private java.lang.String f_renamed;
    private java.lang.String i_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5178b = -1;
    private java.util.ArrayList<java.lang.String> g_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.String> h_renamed = new java.util.ArrayList<>();

    public i_renamed(android.content.Context context) {
        this.f5177a = context;
    }

    public com.oplus.camera.professional.i_renamed a_renamed(int i_renamed) {
        this.e_renamed = this.f5177a.getResources().getString(i_renamed);
        return this;
    }

    public com.oplus.camera.professional.i_renamed a_renamed(java.lang.String str) {
        this.f_renamed = str;
        return this;
    }

    public com.oplus.camera.professional.i_renamed b_renamed(int i_renamed) {
        this.f5178b = i_renamed;
        return this;
    }

    public com.oplus.camera.professional.i_renamed b_renamed(java.lang.String str) {
        this.f5179c = str;
        return this;
    }

    public com.oplus.camera.professional.i_renamed c_renamed(java.lang.String str) {
        this.d_renamed = str;
        return this;
    }

    public com.oplus.camera.professional.i_renamed c_renamed(int i_renamed) {
        this.i_renamed = this.f5177a.getResources().getString(i_renamed);
        return this;
    }

    public com.oplus.camera.professional.i_renamed d_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        for (java.lang.String str : this.f5177a.getResources().getStringArray(i_renamed)) {
            this.g_renamed.add(str);
        }
        return this;
    }

    public com.oplus.camera.professional.i_renamed e_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        for (java.lang.String str : this.f5177a.getResources().getStringArray(i_renamed)) {
            this.h_renamed.add(str);
        }
        return this;
    }

    public java.lang.String a_renamed() {
        return this.d_renamed;
    }

    public java.util.ArrayList<java.lang.String> b_renamed() {
        return this.g_renamed;
    }

    public java.util.ArrayList<java.lang.String> c_renamed() {
        return this.h_renamed;
    }

    public java.lang.String d_renamed() {
        return this.i_renamed;
    }

    public java.lang.String e_renamed() {
        return this.f_renamed;
    }
}
