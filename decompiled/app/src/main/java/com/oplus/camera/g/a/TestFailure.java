package com.oplus.camera.g_renamed.a_renamed;

/* compiled from: ExifTag.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f4557a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.lang.String f4558b;

    public f_renamed(int i_renamed) {
        this.f4557a = 0;
        this.f4558b = null;
        this.f4557a = i_renamed;
        com.oplus.camera.g_renamed.a_renamed.g_renamed gVar = com.oplus.camera.g_renamed.a_renamed.a_renamed.f4541a.get(java.lang.Integer.valueOf(this.f4557a));
        java.lang.String str = gVar != null ? gVar.f4560b : null;
        this.f4558b = str == null ? "unknown" : str;
    }

    public java.lang.String toString() {
        return java.lang.String.format("[0x%04X ; %d_renamed]", java.lang.Integer.valueOf(this.f4557a), java.lang.Integer.valueOf(this.f4557a)) + " ; TagName : " + this.f4558b;
    }
}
