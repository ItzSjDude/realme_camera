package com.airbnb.lottie.f_renamed;

/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f2257a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2258b;

    public void a_renamed(float f_renamed) {
        this.f2257a += f_renamed;
        this.f2258b++;
        int i_renamed = this.f2258b;
        if (i_renamed == Integer.MAX_VALUE) {
            this.f2257a /= 2.0f;
            this.f2258b = i_renamed / 2;
        }
    }
}
