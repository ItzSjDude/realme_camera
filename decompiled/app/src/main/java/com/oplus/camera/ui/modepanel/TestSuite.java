package com.oplus.camera.ui.modepanel;

/* compiled from: ModeDataInfo.java */
/* loaded from: classes2.dex */
public class i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f6732a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6733b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6734c;
    private java.lang.String d_renamed;
    private int e_renamed;
    private int f_renamed;

    public i_renamed(java.lang.String str, boolean z_renamed, java.lang.String str2, int i_renamed, int i2, boolean z2) {
        this.f6732a = null;
        this.f6733b = true;
        this.f6734c = true;
        this.d_renamed = "position_mode_panel";
        this.e_renamed = -1;
        this.f_renamed = -1;
        this.f6732a = str;
        this.f6733b = z_renamed;
        this.d_renamed = str2;
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
        this.f6734c = z2;
    }

    public java.lang.String a_renamed() {
        return this.f6732a;
    }

    public boolean b_renamed() {
        return this.f6733b;
    }

    public java.lang.String c_renamed() {
        return this.d_renamed;
    }

    public int d_renamed() {
        return this.e_renamed;
    }

    public int e_renamed() {
        return this.f_renamed;
    }

    public boolean f_renamed() {
        return this.f6734c;
    }

    public java.lang.String toString() {
        return "ModeInfo: [mName: " + this.f6732a + ", mbSupportEdit: " + this.f6733b + ", mPosition: " + this.d_renamed + ", mRank: " + this.e_renamed + ", mId: " + this.f_renamed + ", mbSupportFront: " + this.f6734c + "]";
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.oplus.camera.ui.modepanel.i_renamed) && this.f_renamed == ((com.oplus.camera.ui.modepanel.i_renamed) obj).f_renamed;
    }

    public int hashCode() {
        return java.util.Objects.hash(this.f6732a, java.lang.Boolean.valueOf(this.f6733b), java.lang.Boolean.valueOf(this.f6734c), this.d_renamed, java.lang.Integer.valueOf(this.e_renamed), java.lang.Integer.valueOf(this.f_renamed));
    }
}
