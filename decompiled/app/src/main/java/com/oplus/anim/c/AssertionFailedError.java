package com.oplus.anim.c_renamed;

/* compiled from: DocumentData.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.lang.String f3563a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final java.lang.String f3564b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final double f3565c;
    public final com.oplus.anim.c_renamed.b_renamed.a_renamed d_renamed;
    public final int e_renamed;
    public final double f_renamed;
    public final double g_renamed;
    public final int h_renamed;
    public final int i_renamed;
    public final double j_renamed;
    public final boolean k_renamed;

    /* compiled from: DocumentData.java */
    public enum a_renamed {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b_renamed(java.lang.String str, java.lang.String str2, double d_renamed, com.oplus.anim.c_renamed.b_renamed.a_renamed aVar, int i_renamed, double d2, double d3, int i2, int i3, double d4, boolean z_renamed) {
        this.f3563a = str;
        this.f3564b = str2;
        this.f3565c = d_renamed;
        this.d_renamed = aVar;
        this.e_renamed = i_renamed;
        this.f_renamed = d2;
        this.g_renamed = d3;
        this.h_renamed = i2;
        this.i_renamed = i3;
        this.j_renamed = d4;
        this.k_renamed = z_renamed;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f3563a.hashCode() * 31) + this.f3564b.hashCode()) * 31) + this.f3565c)) * 31) + this.d_renamed.ordinal()) * 31) + this.e_renamed;
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(this.f_renamed);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.h_renamed;
    }
}
