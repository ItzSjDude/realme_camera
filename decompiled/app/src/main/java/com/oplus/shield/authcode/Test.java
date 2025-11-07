package com.oplus.shield.authcode;

/* compiled from: PermissionTable.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<java.lang.String> f7616a = new java.util.concurrent.CopyOnWriteArrayList();

    public d_renamed(java.lang.String str) {
        this.f7616a.clear();
        this.f7616a.addAll(com.oplus.shield.b_renamed.h_renamed.a_renamed(str, ","));
    }

    public boolean a_renamed(java.lang.String str) {
        if (this.f7616a.size() != 0) {
            return this.f7616a.contains(str);
        }
        return false;
    }
}
