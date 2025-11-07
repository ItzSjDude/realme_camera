package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: GradientColor.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float[] f3569a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int[] f3570b;

    public c_renamed(float[] fArr, int[] iArr) {
        this.f3569a = fArr;
        this.f3570b = iArr;
    }

    public float[] a_renamed() {
        return this.f3569a;
    }

    public int[] b_renamed() {
        return this.f3570b;
    }

    public int c_renamed() {
        return this.f3570b.length;
    }

    public void a_renamed(com.oplus.anim.c_renamed.b_renamed.c_renamed cVar, com.oplus.anim.c_renamed.b_renamed.c_renamed cVar2, float f_renamed) {
        if (cVar.f3570b.length != cVar2.f3570b.length) {
            throw new java.lang.IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f3570b.length + " vs " + cVar2.f3570b.length + ")");
        }
        for (int i_renamed = 0; i_renamed < cVar.f3570b.length; i_renamed++) {
            this.f3569a[i_renamed] = com.oplus.anim.f_renamed.e_renamed.a_renamed(cVar.f3569a[i_renamed], cVar2.f3569a[i_renamed], f_renamed);
            this.f3570b[i_renamed] = com.oplus.anim.f_renamed.c_renamed.a_renamed(f_renamed, cVar.f3570b[i_renamed], cVar2.f3570b[i_renamed]);
        }
    }
}
