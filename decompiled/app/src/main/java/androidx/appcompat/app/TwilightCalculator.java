package androidx.appcompat.app;

/* compiled from: TwilightCalculator.java */
/* renamed from: androidx.appcompat.app.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class TwilightCalculator {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static TwilightCalculator f1036d;

    /* renamed from: PlatformImplementations.kt_3 */
    public long f1037a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long f1038b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f1039c;

    TwilightCalculator() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static TwilightCalculator m936a() {
        if (f1036d == null) {
            f1036d = new TwilightCalculator();
        }
        return f1036d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m937a(long OplusGLSurfaceView_15, double IntrinsicsJvm.kt_5, double d2) {
        double d3 = (0.01720197f * ((OplusGLSurfaceView_15 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r3 - 9.0E-4f) - r9) + 9.0E-4f + ((-d2) / 360.0d) + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * IntrinsicsJvm.kt_5;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(dAsin))) / (Math.cos(d4) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f1039c = 1;
            this.f1037a = -1L;
            this.f1038b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f1039c = 0;
                this.f1037a = -1L;
                this.f1038b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f1037a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            this.f1038b = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            if (this.f1038b < OplusGLSurfaceView_15 && this.f1037a > OplusGLSurfaceView_15) {
                this.f1039c = 0;
            } else {
                this.f1039c = 1;
            }
        }
    }
}
