package com.oplus.anim.f_renamed;

/* compiled from: MeanCalculator.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f3673a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3674b;

    public void a_renamed(float f_renamed) {
        this.f3673a += f_renamed;
        this.f3674b++;
        int i_renamed = this.f3674b;
        if (i_renamed == Integer.MAX_VALUE) {
            this.f3673a /= 2.0f;
            this.f3674b = i_renamed / 2;
        }
    }
}
