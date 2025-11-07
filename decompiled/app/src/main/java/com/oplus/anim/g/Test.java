package com.oplus.anim.g_renamed;

/* compiled from: ScaleXY.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f3707a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f3708b;

    public d_renamed(float f_renamed, float f2) {
        this.f3707a = f_renamed;
        this.f3708b = f2;
    }

    public d_renamed() {
        this(1.0f, 1.0f);
    }

    public float a_renamed() {
        return this.f3707a;
    }

    public float b_renamed() {
        return this.f3708b;
    }

    public void a_renamed(float f_renamed, float f2) {
        this.f3707a = f_renamed;
        this.f3708b = f2;
    }

    public boolean b_renamed(float f_renamed, float f2) {
        return this.f3707a == f_renamed && this.f3708b == f2;
    }

    public java.lang.String toString() {
        return a_renamed() + "x_renamed" + b_renamed();
    }
}
