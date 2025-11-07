package androidx.dynamicanimation.p043a;

import androidx.dynamicanimation.p043a.DynamicAnimation;

/* compiled from: SpringForce.java */
/* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public final class SpringForce {

    /* renamed from: PlatformImplementations.kt_3 */
    double f3330a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    double f3331b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f3332c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private double f3333d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private double f3334e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private double f3335f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private double f3336g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private double f3337h;

    /* renamed from: OplusGLSurfaceView_13 */
    private double f3338i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final DynamicAnimation.PlatformImplementations.kt_3 f3339j;

    public SpringForce() {
        this.f3330a = Math.sqrt(1500.0d);
        this.f3331b = 0.5d;
        this.f3332c = false;
        this.f3338i = Double.MAX_VALUE;
        this.f3339j = new DynamicAnimation.PlatformImplementations.kt_3();
    }

    public SpringForce(float COUIBaseListPopupWindow_12) {
        this.f3330a = Math.sqrt(1500.0d);
        this.f3331b = 0.5d;
        this.f3332c = false;
        this.f3338i = Double.MAX_VALUE;
        this.f3339j = new DynamicAnimation.PlatformImplementations.kt_3();
        this.f3338i = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SpringForce m3236a(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f3330a = Math.sqrt(COUIBaseListPopupWindow_12);
        this.f3332c = false;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SpringForce m3239b(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f3331b = COUIBaseListPopupWindow_12;
        this.f3332c = false;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SpringForce m3240c(float COUIBaseListPopupWindow_12) {
        this.f3338i = COUIBaseListPopupWindow_12;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m3234a() {
        return (float) this.f3338i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3238a(float COUIBaseListPopupWindow_12, float f2) {
        return ((double) Math.abs(f2)) < this.f3334e && ((double) Math.abs(COUIBaseListPopupWindow_12 - m3234a())) < this.f3333d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3233b() {
        if (this.f3332c) {
            return;
        }
        if (this.f3338i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double IntrinsicsJvm.kt_5 = this.f3331b;
        if (IntrinsicsJvm.kt_5 > 1.0d) {
            double d2 = this.f3330a;
            this.f3335f = ((-IntrinsicsJvm.kt_5) * d2) + (d2 * Math.sqrt((IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5) - 1.0d));
            double d3 = this.f3331b;
            double d4 = this.f3330a;
            this.f3336g = ((-d3) * d4) - (d4 * Math.sqrt((d3 * d3) - 1.0d));
        } else if (IntrinsicsJvm.kt_5 >= 0.0d && IntrinsicsJvm.kt_5 < 1.0d) {
            this.f3337h = this.f3330a * Math.sqrt(1.0d - (IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5));
        }
        this.f3332c = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    DynamicAnimation.PlatformImplementations.kt_3 m3235a(double IntrinsicsJvm.kt_5, double d2, long OplusGLSurfaceView_15) {
        double dCos;
        double dPow;
        m3233b();
        double d3 = OplusGLSurfaceView_15 / 1000.0d;
        double d4 = IntrinsicsJvm.kt_5 - this.f3338i;
        double d5 = this.f3331b;
        if (d5 > 1.0d) {
            double d6 = this.f3336g;
            double d7 = this.f3335f;
            double d8 = d4 - (((d6 * d4) - d2) / (d6 - d7));
            double d9 = ((d4 * d6) - d2) / (d6 - d7);
            dPow = (Math.pow(2.718281828459045d, d6 * d3) * d8) + (Math.pow(2.718281828459045d, this.f3335f * d3) * d9);
            double d10 = this.f3336g;
            double dPow2 = d8 * d10 * Math.pow(2.718281828459045d, d10 * d3);
            double d11 = this.f3335f;
            dCos = dPow2 + (d9 * d11 * Math.pow(2.718281828459045d, d11 * d3));
        } else if (d5 == 1.0d) {
            double d12 = this.f3330a;
            double d13 = d2 + (d12 * d4);
            double d14 = d4 + (d13 * d3);
            dPow = Math.pow(2.718281828459045d, (-d12) * d3) * d14;
            double dPow3 = d14 * Math.pow(2.718281828459045d, (-this.f3330a) * d3);
            double d15 = this.f3330a;
            dCos = (d13 * Math.pow(2.718281828459045d, (-d15) * d3)) + (dPow3 * (-d15));
        } else {
            double d16 = 1.0d / this.f3337h;
            double d17 = this.f3330a;
            double d18 = d16 * ((d5 * d17 * d4) + d2);
            double dPow4 = Math.pow(2.718281828459045d, (-d5) * d17 * d3) * ((Math.cos(this.f3337h * d3) * d4) + (Math.sin(this.f3337h * d3) * d18));
            double d19 = this.f3330a;
            double d20 = this.f3331b;
            double d21 = (-d19) * dPow4 * d20;
            double dPow5 = Math.pow(2.718281828459045d, (-d20) * d19 * d3);
            double d22 = this.f3337h;
            double dSin = (-d22) * d4 * Math.sin(d22 * d3);
            double d23 = this.f3337h;
            dCos = d21 + (dPow5 * (dSin + (d18 * d23 * Math.cos(d23 * d3))));
            dPow = dPow4;
        }
        DynamicAnimation.PlatformImplementations.kt_3 aVar = this.f3339j;
        aVar.f3323a = (float) (dPow + this.f3338i);
        aVar.f3324b = (float) dCos;
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3237a(double IntrinsicsJvm.kt_5) {
        this.f3333d = Math.abs(IntrinsicsJvm.kt_5);
        this.f3334e = this.f3333d * 62.5d;
    }
}
