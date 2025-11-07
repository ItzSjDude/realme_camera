package com.a_renamed.a_renamed;

/* compiled from: BouncyConversion.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f1964a = !com.a_renamed.a_renamed.c_renamed.class.desiredAssertionStatus();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final double f1965b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final double f1966c;
    private final double d_renamed;
    private final double e_renamed;

    private double a_renamed(double d_renamed, double d2, double d3) {
        return (d_renamed - d2) / (d3 - d2);
    }

    private double b_renamed(double d_renamed, double d2, double d3) {
        return d2 + (d_renamed * (d3 - d2));
    }

    private double c_renamed(double d_renamed, double d2, double d3) {
        return (d3 * d_renamed) + ((1.0d - d_renamed) * d2);
    }

    public c_renamed(double d_renamed, double d2) {
        this.d_renamed = d_renamed;
        this.e_renamed = d2;
        double dB_renamed = b_renamed(a_renamed(d2 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        this.f1965b = b_renamed(a_renamed(d_renamed / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f1966c = d_renamed(dB_renamed, d_renamed(this.f1965b), 0.01d);
    }

    public double a_renamed() {
        return this.f1965b;
    }

    public double b_renamed() {
        return this.f1966c;
    }

    private double d_renamed(double d_renamed, double d2, double d3) {
        return c_renamed((2.0d * d_renamed) - (d_renamed * d_renamed), d2, d3);
    }

    private double a_renamed(double d_renamed) {
        return ((java.lang.Math.pow(d_renamed, 3.0d) * 7.0E-4d) - (java.lang.Math.pow(d_renamed, 2.0d) * 0.031d)) + (d_renamed * 0.64d) + 1.28d;
    }

    private double b_renamed(double d_renamed) {
        return ((java.lang.Math.pow(d_renamed, 3.0d) * 4.4E-5d) - (java.lang.Math.pow(d_renamed, 2.0d) * 0.006d)) + (d_renamed * 0.36d) + 2.0d;
    }

    private double c_renamed(double d_renamed) {
        return ((java.lang.Math.pow(d_renamed, 3.0d) * 4.5E-7d) - (java.lang.Math.pow(d_renamed, 2.0d) * 3.32E-4d)) + (d_renamed * 0.1078d) + 5.84d;
    }

    private double d_renamed(double d_renamed) {
        if (d_renamed <= 18.0d) {
            return a_renamed(d_renamed);
        }
        if (d_renamed > 18.0d && d_renamed <= 44.0d) {
            return b_renamed(d_renamed);
        }
        if (d_renamed > 44.0d) {
            return c_renamed(d_renamed);
        }
        if (f1964a) {
            return 0.0d;
        }
        throw new java.lang.AssertionError();
    }
}
