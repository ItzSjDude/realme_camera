package com.airbnb.lottie.f_renamed;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.graphics.PointF f2259a = new android.graphics.PointF();

    public static double a_renamed(double d_renamed, double d2, double d3) {
        return d_renamed + (d3 * (d2 - d_renamed));
    }

    public static float a_renamed(float f_renamed, float f2, float f3) {
        return f_renamed + (f3 * (f2 - f_renamed));
    }

    public static int a_renamed(int i_renamed, int i2, float f_renamed) {
        return (int) (i_renamed + (f_renamed * (i2 - i_renamed)));
    }

    public static boolean c_renamed(float f_renamed, float f2, float f3) {
        return f_renamed >= f2 && f_renamed <= f3;
    }

    public static android.graphics.PointF a_renamed(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return new android.graphics.PointF(pointF.x_renamed + pointF2.x_renamed, pointF.y_renamed + pointF2.y_renamed);
    }

    public static void a_renamed(com.airbnb.lottie.c_renamed.b_renamed.l_renamed lVar, android.graphics.Path path) {
        path.reset();
        android.graphics.PointF pointFA = lVar.a_renamed();
        path.moveTo(pointFA.x_renamed, pointFA.y_renamed);
        f2259a.set(pointFA.x_renamed, pointFA.y_renamed);
        for (int i_renamed = 0; i_renamed < lVar.c_renamed().size(); i_renamed++) {
            com.airbnb.lottie.c_renamed.a_renamed aVar = lVar.c_renamed().get(i_renamed);
            android.graphics.PointF pointFA2 = aVar.a_renamed();
            android.graphics.PointF pointFB = aVar.b_renamed();
            android.graphics.PointF pointFC = aVar.c_renamed();
            if (pointFA2.equals(f2259a) && pointFB.equals(pointFC)) {
                path.lineTo(pointFC.x_renamed, pointFC.y_renamed);
            } else {
                path.cubicTo(pointFA2.x_renamed, pointFA2.y_renamed, pointFB.x_renamed, pointFB.y_renamed, pointFC.x_renamed, pointFC.y_renamed);
            }
            f2259a.set(pointFC.x_renamed, pointFC.y_renamed);
        }
        if (lVar.b_renamed()) {
            path.close();
        }
    }

    static int a_renamed(float f_renamed, float f2) {
        return a_renamed((int) f_renamed, (int) f2);
    }

    private static int a_renamed(int i_renamed, int i2) {
        return i_renamed - (i2 * b_renamed(i_renamed, i2));
    }

    private static int b_renamed(int i_renamed, int i2) {
        int i3 = i_renamed / i2;
        return (((i_renamed ^ i2) >= 0) || i_renamed % i2 == 0) ? i3 : i3 - 1;
    }

    public static int a_renamed(int i_renamed, int i2, int i3) {
        return java.lang.Math.max(i2, java.lang.Math.min(i3, i_renamed));
    }

    public static float b_renamed(float f_renamed, float f2, float f3) {
        return java.lang.Math.max(f2, java.lang.Math.min(f3, f_renamed));
    }

    public static double b_renamed(double d_renamed, double d2, double d3) {
        return java.lang.Math.max(d2, java.lang.Math.min(d3, d_renamed));
    }

    public static void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2, com.airbnb.lottie.a_renamed.a_renamed.k_renamed kVar) {
        if (eVar.c_renamed(kVar.b_renamed(), i_renamed)) {
            list.add(eVar2.a_renamed(kVar.b_renamed()).a_renamed(kVar));
        }
    }
}
