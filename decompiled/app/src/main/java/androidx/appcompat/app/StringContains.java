package androidx.appcompat.app;

/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
class j_renamed {
    private static androidx.appcompat.app.j_renamed d_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public long f282a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public long f283b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f284c;

    j_renamed() {
    }

    static androidx.appcompat.app.j_renamed a_renamed() {
        if (d_renamed == null) {
            d_renamed = new androidx.appcompat.app.j_renamed();
        }
        return d_renamed;
    }

    public void a_renamed(long j_renamed, double d2, double d3) {
        double d4 = (0.01720197f * ((j_renamed - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (java.lang.Math.sin(d4) * 0.03341960161924362d) + d4 + (java.lang.Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (java.lang.Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = java.lang.Math.round((r3 - 9.0E-4f) - r9) + 9.0E-4f + ((-d3) / 360.0d) + (java.lang.Math.sin(d4) * 0.0053d) + (java.lang.Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = java.lang.Math.asin(java.lang.Math.sin(dSin) * java.lang.Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double dSin2 = (java.lang.Math.sin(-0.10471975803375244d) - (java.lang.Math.sin(d5) * java.lang.Math.sin(dAsin))) / (java.lang.Math.cos(d5) * java.lang.Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f284c = 1;
            this.f282a = -1L;
            this.f283b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f284c = 0;
                this.f282a = -1L;
                this.f283b = -1L;
                return;
            }
            double dAcos = (float) (java.lang.Math.acos(dSin2) / 6.283185307179586d);
            this.f282a = java.lang.Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            this.f283b = java.lang.Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            if (this.f283b < j_renamed && this.f282a > j_renamed) {
                this.f284c = 0;
            } else {
                this.f284c = 1;
            }
        }
    }
}
