package com.airbnb.lottie.p091f;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.p080a.p081a.KeyPathElementContent_2;
import com.airbnb.lottie.p084c.CubicCurveData_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import java.util.List;

/* compiled from: MiscUtils.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class MiscUtils_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static PointF f5881a = new PointF();

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m6126a(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return IntrinsicsJvm.kt_5 + (d3 * (d2 - IntrinsicsJvm.kt_5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m6127a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + (f3 * (f2 - COUIBaseListPopupWindow_12));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6130a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return (int) (OplusGLSurfaceView_13 + (COUIBaseListPopupWindow_12 * (i2 - OplusGLSurfaceView_13)));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m6138c(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 >= f2 && COUIBaseListPopupWindow_12 <= f3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PointF m6132a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6133a(ShapeData_2 c1115l, Path path) {
        path.reset();
        PointF pointFM5720a = c1115l.m5720a();
        path.moveTo(pointFM5720a.x, pointFM5720a.y);
        f5881a.set(pointFM5720a.x, pointFM5720a.y);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c1115l.m5723c().size(); OplusGLSurfaceView_13++) {
            CubicCurveData_2 c1088a = c1115l.m5723c().get(OplusGLSurfaceView_13);
            PointF pointFM5641a = c1088a.m5641a();
            PointF pointFM5643b = c1088a.m5643b();
            PointF pointFM5645c = c1088a.m5645c();
            if (pointFM5641a.equals(f5881a) && pointFM5643b.equals(pointFM5645c)) {
                path.lineTo(pointFM5645c.x, pointFM5645c.y);
            } else {
                path.cubicTo(pointFM5641a.x, pointFM5641a.y, pointFM5643b.x, pointFM5643b.y, pointFM5645c.x, pointFM5645c.y);
            }
            f5881a.set(pointFM5645c.x, pointFM5645c.y);
        }
        if (c1115l.m5722b()) {
            path.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m6128a(float COUIBaseListPopupWindow_12, float f2) {
        return m6129a((int) COUIBaseListPopupWindow_12, (int) f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m6129a(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 - (i2 * m6137b(OplusGLSurfaceView_13, i2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m6137b(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 / i2;
        return (((OplusGLSurfaceView_13 ^ i2) >= 0) || OplusGLSurfaceView_13 % i2 == 0) ? i3 : i3 - 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6131a(int OplusGLSurfaceView_13, int i2, int i3) {
        return Math.max(i2, Math.min(i3, OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m6136b(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return Math.max(f2, Math.min(f3, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static double m6135b(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return Math.max(d2, Math.min(d3, IntrinsicsJvm.kt_5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6134a(KeyPath_2 c1131e, int OplusGLSurfaceView_13, List<KeyPath_2> list, KeyPath_2 c1131e2, KeyPathElementContent_2 interfaceC1059k) {
        if (c1131e.m5832c(interfaceC1059k.mo5540b(), OplusGLSurfaceView_13)) {
            list.add(c1131e2.m5828a(interfaceC1059k.mo5540b()).m5827a(interfaceC1059k));
        }
    }
}
