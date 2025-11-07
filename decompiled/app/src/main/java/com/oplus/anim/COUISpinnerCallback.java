package com.oplus.anim;

/* compiled from: TextDelegate.java */
/* loaded from: classes2.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, java.lang.String> f3719a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f3720b;

    private java.lang.String b_renamed(java.lang.String str) {
        return str;
    }

    public final java.lang.String a_renamed(java.lang.String str) {
        if (this.f3720b && this.f3719a.containsKey(str)) {
            return this.f3719a.get(str);
        }
        java.lang.String strB = b_renamed(str);
        if (this.f3720b) {
            this.f3719a.put(str, strB);
        }
        return strB;
    }
}
