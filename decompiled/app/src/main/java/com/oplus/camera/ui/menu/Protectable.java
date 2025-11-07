package com.oplus.camera.ui.menu;

/* compiled from: OptionItemConfig.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f6372a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<java.lang.String> f6373b;

    public c_renamed() {
        this.f6373b = null;
        this.f6373b = new java.util.ArrayList();
    }

    public java.lang.String a_renamed() {
        return this.f6372a;
    }

    public void a_renamed(java.lang.String str) {
        this.f6372a = str;
    }

    public void b_renamed(java.lang.String str) {
        if (this.f6373b.contains(str)) {
            return;
        }
        this.f6373b.add(str);
    }

    public java.util.List<java.lang.String> b_renamed() {
        return this.f6373b;
    }
}
