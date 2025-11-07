package androidx.dynamicanimation.a_renamed;

/* compiled from: SpringForce.java */
/* loaded from: classes.dex */
public final class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    double f1081a;

    /* renamed from: b_renamed, reason: collision with root package name */
    double f1082b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f1083c;
    private double d_renamed;
    private double e_renamed;
    private double f_renamed;
    private double g_renamed;
    private double h_renamed;
    private double i_renamed;
    private final androidx.dynamicanimation.a_renamed.c_renamed.a_renamed j_renamed;

    public g_renamed() {
        this.f1081a = java.lang.Math.sqrt(1500.0d);
        this.f1082b = 0.5d;
        this.f1083c = false;
        this.i_renamed = Double.MAX_VALUE;
        this.j_renamed = new androidx.dynamicanimation.a_renamed.c_renamed.a_renamed();
    }

    public g_renamed(float f_renamed) {
        this.f1081a = java.lang.Math.sqrt(1500.0d);
        this.f1082b = 0.5d;
        this.f1083c = false;
        this.i_renamed = Double.MAX_VALUE;
        this.j_renamed = new androidx.dynamicanimation.a_renamed.c_renamed.a_renamed();
        this.i_renamed = f_renamed;
    }

    public androidx.dynamicanimation.a_renamed.g_renamed a_renamed(float f_renamed) {
        if (f_renamed <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Spring stiffness constant must be_renamed positive.");
        }
        this.f1081a = java.lang.Math.sqrt(f_renamed);
        this.f1083c = false;
        return this;
    }

    public androidx.dynamicanimation.a_renamed.g_renamed b_renamed(float f_renamed) {
        if (f_renamed < 0.0f) {
            throw new java.lang.IllegalArgumentException("Damping ratio must be_renamed non-negative");
        }
        this.f1082b = f_renamed;
        this.f1083c = false;
        return this;
    }

    public androidx.dynamicanimation.a_renamed.g_renamed c_renamed(float f_renamed) {
        this.i_renamed = f_renamed;
        return this;
    }

    public float a_renamed() {
        return (float) this.i_renamed;
    }

    public boolean a_renamed(float f_renamed, float f2) {
        return ((double) java.lang.Math.abs(f2)) < this.e_renamed && ((double) java.lang.Math.abs(f_renamed - a_renamed())) < this.d_renamed;
    }

    private void b_renamed() {
        if (this.f1083c) {
            return;
        }
        if (this.i_renamed == Double.MAX_VALUE) {
            throw new java.lang.IllegalStateException("Error: Final position of_renamed the spring must be_renamed set before the animation starts");
        }
        double d_renamed = this.f1082b;
        if (d_renamed > 1.0d) {
            double d2 = this.f1081a;
            this.f_renamed = ((-d_renamed) * d2) + (d2 * java.lang.Math.sqrt((d_renamed * d_renamed) - 1.0d));
            double d3 = this.f1082b;
            double d4 = this.f1081a;
            this.g_renamed = ((-d3) * d4) - (d4 * java.lang.Math.sqrt((d3 * d3) - 1.0d));
        } else if (d_renamed >= 0.0d && d_renamed < 1.0d) {
            this.h_renamed = this.f1081a * java.lang.Math.sqrt(1.0d - (d_renamed * d_renamed));
        }
        this.f1083c = true;
    }

    androidx.dynamicanimation.a_renamed.c_renamed.a_renamed a_renamed(double d_renamed, double d2, long j_renamed) {
        double dCos;
        double dPow;
        b_renamed();
        double d3 = j_renamed / 1000.0d;
        double d4 = d_renamed - this.i_renamed;
        double d5 = this.f1082b;
        if (d5 > 1.0d) {
            double d6 = this.g_renamed;
            double d7 = this.f_renamed;
            double d8 = d4 - (((d6 * d4) - d2) / (d6 - d7));
            double d9 = ((d4 * d6) - d2) / (d6 - d7);
            dPow = (java.lang.Math.pow(2.718281828459045d, d6 * d3) * d8) + (java.lang.Math.pow(2.718281828459045d, this.f_renamed * d3) * d9);
            double d10 = this.g_renamed;
            double dPow2 = d8 * d10 * java.lang.Math.pow(2.718281828459045d, d10 * d3);
            double d11 = this.f_renamed;
            dCos = dPow2 + (d9 * d11 * java.lang.Math.pow(2.718281828459045d, d11 * d3));
        } else if (d5 == 1.0d) {
            double d12 = this.f1081a;
            double d13 = d2 + (d12 * d4);
            double d14 = d4 + (d13 * d3);
            dPow = java.lang.Math.pow(2.718281828459045d, (-d12) * d3) * d14;
            double dPow3 = d14 * java.lang.Math.pow(2.718281828459045d, (-this.f1081a) * d3);
            double d15 = this.f1081a;
            dCos = (d13 * java.lang.Math.pow(2.718281828459045d, (-d15) * d3)) + (dPow3 * (-d15));
        } else {
            double d16 = 1.0d / this.h_renamed;
            double d17 = this.f1081a;
            double d18 = d16 * ((d5 * d17 * d4) + d2);
            double dPow4 = java.lang.Math.pow(2.718281828459045d, (-d5) * d17 * d3) * ((java.lang.Math.cos(this.h_renamed * d3) * d4) + (java.lang.Math.sin(this.h_renamed * d3) * d18));
            double d19 = this.f1081a;
            double d20 = this.f1082b;
            double d21 = (-d19) * dPow4 * d20;
            double dPow5 = java.lang.Math.pow(2.718281828459045d, (-d20) * d19 * d3);
            double d22 = this.h_renamed;
            double dSin = (-d22) * d4 * java.lang.Math.sin(d22 * d3);
            double d23 = this.h_renamed;
            dCos = d21 + (dPow5 * (dSin + (d18 * d23 * java.lang.Math.cos(d23 * d3))));
            dPow = dPow4;
        }
        androidx.dynamicanimation.a_renamed.c_renamed.a_renamed aVar = this.j_renamed;
        aVar.f1077a = (float) (dPow + this.i_renamed);
        aVar.f1078b = (float) dCos;
        return aVar;
    }

    void a_renamed(double d_renamed) {
        this.d_renamed = java.lang.Math.abs(d_renamed);
        this.e_renamed = this.d_renamed * 62.5d;
    }
}
