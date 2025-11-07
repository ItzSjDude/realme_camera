package com.p078a.p079a;

/* compiled from: BouncyConversion.java */
/* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class BouncyConversion {

    /* renamed from: PlatformImplementations.kt_3 */
    static final /* synthetic */ boolean f5170a = !BouncyConversion.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final double f5171b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final double f5172c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final double f5173d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final double f5174e;

    /* renamed from: PlatformImplementations.kt_3 */
    private double m5453a(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return (IntrinsicsJvm.kt_5 - d2) / (d3 - d2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private double m5455b(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return d2 + (IntrinsicsJvm.kt_5 * (d3 - d2));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private double m5457c(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return (d3 * IntrinsicsJvm.kt_5) + ((1.0d - IntrinsicsJvm.kt_5) * d2);
    }

    public BouncyConversion(double IntrinsicsJvm.kt_5, double d2) {
        this.f5173d = IntrinsicsJvm.kt_5;
        this.f5174e = d2;
        double dM5455b = m5455b(m5453a(d2 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        this.f5171b = m5455b(m5453a(IntrinsicsJvm.kt_5 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f5172c = m5459d(dM5455b, m5458d(this.f5171b), 0.01d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public double m5460a() {
        return this.f5171b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public double m5461b() {
        return this.f5172c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private double m5459d(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return m5457c((2.0d * IntrinsicsJvm.kt_5) - (IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5), d2, d3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private double m5452a(double IntrinsicsJvm.kt_5) {
        return ((Math.pow(IntrinsicsJvm.kt_5, 3.0d) * 7.0E-4d) - (Math.pow(IntrinsicsJvm.kt_5, 2.0d) * 0.031d)) + (IntrinsicsJvm.kt_5 * 0.64d) + 1.28d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private double m5454b(double IntrinsicsJvm.kt_5) {
        return ((Math.pow(IntrinsicsJvm.kt_5, 3.0d) * 4.4E-5d) - (Math.pow(IntrinsicsJvm.kt_5, 2.0d) * 0.006d)) + (IntrinsicsJvm.kt_5 * 0.36d) + 2.0d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private double m5456c(double IntrinsicsJvm.kt_5) {
        return ((Math.pow(IntrinsicsJvm.kt_5, 3.0d) * 4.5E-7d) - (Math.pow(IntrinsicsJvm.kt_5, 2.0d) * 3.32E-4d)) + (IntrinsicsJvm.kt_5 * 0.1078d) + 5.84d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private double m5458d(double IntrinsicsJvm.kt_5) {
        if (IntrinsicsJvm.kt_5 <= 18.0d) {
            return m5452a(IntrinsicsJvm.kt_5);
        }
        if (IntrinsicsJvm.kt_5 > 18.0d && IntrinsicsJvm.kt_5 <= 44.0d) {
            return m5454b(IntrinsicsJvm.kt_5);
        }
        if (IntrinsicsJvm.kt_5 > 44.0d) {
            return m5456c(IntrinsicsJvm.kt_5);
        }
        if (f5170a) {
            return 0.0d;
        }
        throw new AssertionError();
    }
}
