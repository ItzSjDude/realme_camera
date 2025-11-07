package com.airbnb.lottie.c_renamed;

/* compiled from: DocumentData.java */
/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final java.lang.String f2065a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final java.lang.String f2066b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public final float f2067c;
    public final com.airbnb.lottie.c_renamed.b_renamed.a_renamed d_renamed;
    public final int e_renamed;
    public final float f_renamed;
    public final float g_renamed;
    public final int h_renamed;
    public final int i_renamed;
    public final float j_renamed;
    public final boolean k_renamed;

    /* compiled from: DocumentData.java */
    public enum a_renamed {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b_renamed(java.lang.String str, java.lang.String str2, float f_renamed, com.airbnb.lottie.c_renamed.b_renamed.a_renamed aVar, int i_renamed, float f2, float f3, int i2, int i3, float f4, boolean z_renamed) {
        this.f2065a = str;
        this.f2066b = str2;
        this.f2067c = f_renamed;
        this.d_renamed = aVar;
        this.e_renamed = i_renamed;
        this.f_renamed = f2;
        this.g_renamed = f3;
        this.h_renamed = i2;
        this.i_renamed = i3;
        this.j_renamed = f4;
        this.k_renamed = z_renamed;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f2065a.hashCode() * 31) + this.f2066b.hashCode()) * 31) + this.f2067c)) * 31) + this.d_renamed.ordinal()) * 31) + this.e_renamed;
        long jFloatToRawIntBits = java.lang.Float.floatToRawIntBits(this.f_renamed);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.h_renamed;
    }
}
