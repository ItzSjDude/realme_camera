package com.airbnb.lottie.c_renamed;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.String f2138c = "\r_renamed";

    /* renamed from: a_renamed, reason: collision with root package name */
    public final float f2139a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final float f2140b;
    private final java.lang.String d_renamed;

    public h_renamed(java.lang.String str, float f_renamed, float f2) {
        this.d_renamed = str;
        this.f2140b = f2;
        this.f2139a = f_renamed;
    }

    public boolean a_renamed(java.lang.String str) {
        if (this.d_renamed.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.d_renamed.endsWith(f2138c)) {
            java.lang.String str2 = this.d_renamed;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
