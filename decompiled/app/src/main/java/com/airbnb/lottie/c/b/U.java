package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class n_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2100a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.c_renamed.b_renamed.b_renamed> f2101b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f2102c;

    public n_renamed(java.lang.String str, java.util.List<com.airbnb.lottie.c_renamed.b_renamed.b_renamed> list, boolean z_renamed) {
        this.f2100a = str;
        this.f2101b = list;
        this.f2102c = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2100a;
    }

    public java.util.List<com.airbnb.lottie.c_renamed.b_renamed.b_renamed> b_renamed() {
        return this.f2101b;
    }

    public boolean c_renamed() {
        return this.f2102c;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.d_renamed(fVar, aVar, this);
    }

    public java.lang.String toString() {
        return "ShapeGroup{name='" + this.f2100a + "' Shapes: " + java.util.Arrays.toString(this.f2101b.toArray()) + '}';
    }
}
