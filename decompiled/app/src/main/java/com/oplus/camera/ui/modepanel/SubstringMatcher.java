package com.oplus.camera.ui.modepanel;

/* compiled from: ModeInfo.java */
/* loaded from: classes2.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f6735a = "k_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f6736b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6737c;
    private int d_renamed;
    private int e_renamed = -1;
    private int f_renamed = 0;
    private boolean g_renamed = true;
    private boolean h_renamed = true;
    private boolean i_renamed = true;
    private boolean j_renamed = true;
    private boolean k_renamed = false;
    private int l_renamed;

    public k_renamed(android.app.Activity activity, int i_renamed, int i2) {
        this.f6736b = null;
        this.f6737c = -1;
        this.l_renamed = 0;
        this.f6737c = i_renamed;
        this.f6736b = a_renamed(activity, i_renamed);
        this.d_renamed = i2;
        b_renamed(j_renamed());
        a_renamed(i_renamed());
        c_renamed(k_renamed());
        d_renamed(l_renamed());
        this.l_renamed = this.h_renamed ? activity.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency) : activity.getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency);
    }

    private boolean i_renamed() {
        return j_renamed();
    }

    private boolean j_renamed() {
        int i_renamed = this.f6737c;
        return (20 == i_renamed || 21 == i_renamed) ? false : true;
    }

    private boolean k_renamed() {
        int i_renamed = this.f6737c;
        return (20 == i_renamed || 21 == i_renamed) ? false : true;
    }

    private boolean l_renamed() {
        int i_renamed = this.f6737c;
        return (28 == i_renamed || 3 == i_renamed || 9 == i_renamed || 17 == i_renamed || 30 == i_renamed) ? false : true;
    }

    public java.lang.String a_renamed() {
        return this.f6736b;
    }

    public int b_renamed() {
        return this.f6737c;
    }

    public int c_renamed() {
        return this.d_renamed;
    }

    public int d_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public static java.lang.String a_renamed(android.app.Activity activity, int i_renamed) {
        return activity.getString(com.oplus.camera.ui.menu.a_renamed.c_renamed.a_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.d_renamed(i_renamed)));
    }

    public void b_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public int e_renamed() {
        return this.f_renamed;
    }

    public boolean f_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public boolean g_renamed() {
        return this.h_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
    }

    public boolean h_renamed() {
        return this.j_renamed;
    }

    public void d_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    public void e_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.oplus.camera.ui.modepanel.k_renamed) && this.f6737c == ((com.oplus.camera.ui.modepanel.k_renamed) obj).f6737c;
    }

    public int hashCode() {
        return java.util.Objects.hash(this.f6736b, java.lang.Integer.valueOf(this.f6737c), java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed), java.lang.Integer.valueOf(this.f_renamed), java.lang.Boolean.valueOf(this.g_renamed), java.lang.Boolean.valueOf(this.h_renamed), java.lang.Boolean.valueOf(this.i_renamed), java.lang.Boolean.valueOf(this.j_renamed), java.lang.Boolean.valueOf(this.k_renamed), java.lang.Integer.valueOf(this.l_renamed));
    }
}
