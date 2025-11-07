package com.youtu.ocr.docprocess;

/* compiled from: GussianBlur.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private double[] f7775a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7776b;

    public a_renamed(int i_renamed, int i2) {
        this.f7776b = i_renamed;
        this.f7775a = new double[this.f7776b];
        int i3 = 0;
        double d_renamed = 0.0d;
        while (true) {
            int i4 = this.f7776b;
            if (i3 < i4) {
                double d2 = (i4 - 1) - i3;
                double d3 = i2;
                double d4 = d_renamed;
                this.f7775a[i3] = (java.lang.Math.exp(java.lang.Math.pow(d2 / d3, 2.0d) * (-0.5d)) / java.lang.Math.sqrt(6.283185307179586d)) / d3;
                if (d2 > 0.0d) {
                    double[] dArr = this.f7775a;
                    dArr[i3] = dArr[i3] * 2.0d;
                }
                d_renamed = this.f7775a[i3] + d4;
                android.util.Log.e_renamed("xlab", " " + i3 + " " + this.f7775a[i3]);
                i3++;
            } else {
                android.util.Log.e_renamed("xlab", "sum: " + d_renamed);
                return;
            }
        }
    }

    public double[] a_renamed() {
        return this.f7775a;
    }
}
