package com.oplus.anim.p121f;

import android.graphics.Path;
import android.graphics.PointF;
import com.oplus.anim.p111a.p112a.KeyPathElementContent;
import com.oplus.anim.p115c.CubicCurveData;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.p117b.ShapeData;
import java.util.List;

/* compiled from: MiscUtils.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class MiscUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static PointF f10384a = new PointF();

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m9273a(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return IntrinsicsJvm.kt_5 + (d3 * (d2 - IntrinsicsJvm.kt_5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m9274a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 + (f3 * (f2 - COUIBaseListPopupWindow_12));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m9277a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        return (int) (OplusGLSurfaceView_13 + (COUIBaseListPopupWindow_12 * (i2 - OplusGLSurfaceView_13)));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m9284c(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 >= f2 && COUIBaseListPopupWindow_12 <= f3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PointF m9279a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9280a(ShapeData c2340l, Path path) {
        path.reset();
        PointF pointFM9031a = c2340l.m9031a();
        path.moveTo(pointFM9031a.x, pointFM9031a.y);
        f10384a.set(pointFM9031a.x, pointFM9031a.y);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c2340l.m9034c().size(); OplusGLSurfaceView_13++) {
            CubicCurveData c2313a = c2340l.m9034c().get(OplusGLSurfaceView_13);
            PointF pointFM8951a = c2313a.m8951a();
            PointF pointFM8953b = c2313a.m8953b();
            PointF pointFM8955c = c2313a.m8955c();
            if (pointFM8951a.equals(f10384a) && pointFM8953b.equals(pointFM8955c)) {
                path.lineTo(pointFM8955c.x, pointFM8955c.y);
            } else {
                path.cubicTo(pointFM8951a.x, pointFM8951a.y, pointFM8953b.x, pointFM8953b.y, pointFM8955c.x, pointFM8955c.y);
            }
            f10384a.set(pointFM8955c.x, pointFM8955c.y);
        }
        if (c2340l.m9033b()) {
            path.close();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m9275a(float COUIBaseListPopupWindow_12, float f2) {
        return m9276a((int) COUIBaseListPopupWindow_12, (int) f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m9276a(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 - (i2 * m9283b(OplusGLSurfaceView_13, i2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m9283b(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 / i2;
        return (((OplusGLSurfaceView_13 ^ i2) >= 0) || OplusGLSurfaceView_13 % i2 == 0) ? i3 : i3 - 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m9278a(int OplusGLSurfaceView_13, int i2, int i3) {
        return Math.max(i2, Math.min(i3, OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m9282b(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return Math.max(f2, Math.min(f3, COUIBaseListPopupWindow_12));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9281a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2, KeyPathElementContent interfaceC2284k) {
        if (c2357f.m9140c(interfaceC2284k.mo8816b(), OplusGLSurfaceView_13)) {
            KeyPath c2357fM9136a = c2357f2.m9136a(interfaceC2284k.mo8816b());
            if (OplusLog.f10387c) {
                OplusLog.m9286b("MiscUtils::resolveKeyPath():currentPartialKeyPath = " + c2357fM9136a.toString() + "; content:" + interfaceC2284k.mo8816b());
            }
            list.add(c2357fM9136a.m9135a(interfaceC2284k));
        }
    }
}
