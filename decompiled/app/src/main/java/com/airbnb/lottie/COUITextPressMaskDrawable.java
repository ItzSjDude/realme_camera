package com.airbnb.lottie;

/* compiled from: TextDelegate.java */
/* loaded from: classes.dex */
public class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, java.lang.String> f2291a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2292b;

    private java.lang.String b_renamed(java.lang.String str) {
        return str;
    }

    public final java.lang.String a_renamed(java.lang.String str) {
        if (this.f2292b && this.f2291a.containsKey(str)) {
            return this.f2291a.get(str);
        }
        java.lang.String strB = b_renamed(str);
        if (this.f2292b) {
            this.f2291a.put(str, strB);
        }
        return strB;
    }
}
