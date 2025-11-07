package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float[] f2071a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int[] f2072b;

    public c_renamed(float[] fArr, int[] iArr) {
        this.f2071a = fArr;
        this.f2072b = iArr;
    }

    public float[] a_renamed() {
        return this.f2071a;
    }

    public int[] b_renamed() {
        return this.f2072b;
    }

    public int c_renamed() {
        return this.f2072b.length;
    }

    public void a_renamed(com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVar, com.airbnb.lottie.c_renamed.b_renamed.c_renamed cVar2, float f_renamed) {
        if (cVar.f2072b.length != cVar2.f2072b.length) {
            throw new java.lang.IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f2072b.length + " vs " + cVar2.f2072b.length + ")");
        }
        for (int i_renamed = 0; i_renamed < cVar.f2072b.length; i_renamed++) {
            this.f2071a[i_renamed] = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(cVar.f2071a[i_renamed], cVar2.f2071a[i_renamed], f_renamed);
            this.f2072b[i_renamed] = com.airbnb.lottie.f_renamed.b_renamed.a_renamed(f_renamed, cVar.f2072b[i_renamed], cVar2.f2072b[i_renamed]);
        }
    }
}
