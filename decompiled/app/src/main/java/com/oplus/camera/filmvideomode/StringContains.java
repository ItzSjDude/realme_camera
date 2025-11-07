package com.oplus.camera.filmvideomode;

/* compiled from: FilmModeItemBarData.java */
/* loaded from: classes2.dex */
public class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4495a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f4496b = "";

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4497c = false;
    private boolean d_renamed = false;
    private int e_renamed = -1;
    private int f_renamed = -1;
    private boolean g_renamed = true;

    public com.oplus.camera.filmvideomode.j_renamed a_renamed(int i_renamed) {
        this.f4495a = i_renamed;
        return this;
    }

    public com.oplus.camera.filmvideomode.j_renamed b_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
        return this;
    }

    public com.oplus.camera.filmvideomode.j_renamed c_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
        return this;
    }

    public int a_renamed() {
        return this.e_renamed;
    }

    public int b_renamed() {
        return this.f4495a;
    }

    public com.oplus.camera.filmvideomode.j_renamed a_renamed(boolean z_renamed) {
        this.f4497c = z_renamed;
        return this;
    }

    public boolean c_renamed() {
        return this.d_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public java.lang.String d_renamed() {
        return this.f4496b;
    }

    public com.oplus.camera.filmvideomode.j_renamed a_renamed(java.lang.String str) {
        this.f4496b = str;
        return this;
    }

    public int e_renamed() {
        return this.f_renamed;
    }

    public boolean f_renamed() {
        return this.g_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public java.lang.String toString() {
        return "FilmModeItemBarData{mPreferenceTitleImage=" + this.f4495a + ", mName='" + this.f4496b + "', mbIsAuto=" + this.f4497c + ", mbIsSelect=" + this.d_renamed + ", mAnimationRes=" + this.e_renamed + ", mItemIndex=" + this.f_renamed + ", mItemEnabled=" + this.g_renamed + '}';
    }
}
