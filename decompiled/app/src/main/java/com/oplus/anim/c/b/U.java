package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: ShapeGroup.java */
/* loaded from: classes2.dex */
public class n_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3598a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.c_renamed.b_renamed.b_renamed> f3599b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f3600c;

    public n_renamed(java.lang.String str, java.util.List<com.oplus.anim.c_renamed.b_renamed.b_renamed> list, boolean z_renamed) {
        this.f3598a = str;
        this.f3599b = list;
        this.f3600c = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3598a;
    }

    public java.util.List<com.oplus.anim.c_renamed.b_renamed.b_renamed> b_renamed() {
        return this.f3599b;
    }

    public boolean c_renamed() {
        return this.f3600c;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ShapeGroup to ContentGroup, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.d_renamed(bVar, aVar, this);
    }

    public java.lang.String toString() {
        return "ShapeGroup{name='" + this.f3598a + "' Shapes: " + java.util.Arrays.toString(this.f3599b.toArray()) + '}';
    }
}
