package com.oplus.anim.p121f;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.oplus.anim.L;
import com.oplus.anim.p111a.p112a.TrimPathContent;
import com.oplus.anim.p111a.p113b.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: Utils.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public final class Utils_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathMeasure f10389a = new PathMeasure();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Path f10390b = new Path();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Path f10391c = new Path();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final float[] f10392d = new float[4];

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final float f10393e = (float) Math.sqrt(2.0d);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static float f10394f = -1.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m9290a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_12 != 0.0f ? (int) (527 * COUIBaseListPopupWindow_12) : 17;
        if (f2 != 0.0f) {
            OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_13 * 31 * f2);
        }
        if (f3 != 0.0f) {
            OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_13 * 31 * f3);
        }
        return f4 != 0.0f ? (int) (OplusGLSurfaceView_13 * 31 * f4) : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m9296a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        if (OplusGLSurfaceView_13 < i4) {
            return false;
        }
        if (OplusGLSurfaceView_13 > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Path m9291a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9295a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException COUIBaseListPopupWindow_8) {
                throw COUIBaseListPopupWindow_8;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m9289a(Matrix matrix) {
        float[] fArr = f10392d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float COUIBaseListPopupWindow_12 = f10393e;
        fArr[2] = COUIBaseListPopupWindow_12;
        fArr[3] = COUIBaseListPopupWindow_12;
        matrix.mapPoints(fArr);
        float[] fArr2 = f10392d;
        return ((float) Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9294a(Path path, TrimPathContent c2292s) {
        if (c2292s == null || c2292s.m8842g()) {
            return;
        }
        m9293a(path, ((FloatKeyframeAnimation) c2292s.m8839d()).m8861i() / 100.0f, ((FloatKeyframeAnimation) c2292s.m8840e()).m8861i() / 100.0f, ((FloatKeyframeAnimation) c2292s.m8841f()).m8861i() / 360.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9293a(Path path, float COUIBaseListPopupWindow_12, float f2, float f3) {
        L.m9349c("applyTrimPathIfNeeded");
        f10389a.setPath(path, false);
        float length = f10389a.getLength();
        if (COUIBaseListPopupWindow_12 == 1.0f && f2 == 0.0f) {
            L.m9350d("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - COUIBaseListPopupWindow_12) - 1.0f) < 0.01d) {
            L.m9350d("applyTrimPathIfNeeded");
            return;
        }
        float f4 = COUIBaseListPopupWindow_12 * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = MiscUtils.m9275a(fMin, length);
            fMax = MiscUtils.m9275a(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = MiscUtils.m9275a(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = MiscUtils.m9275a(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            L.m9350d("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        f10390b.reset();
        f10389a.getSegment(fMin, fMax, f10390b, true);
        if (fMax > length) {
            f10391c.reset();
            f10389a.getSegment(0.0f, fMax % length, f10391c, true);
            f10390b.addPath(f10391c);
        } else if (fMin < 0.0f) {
            f10391c.reset();
            f10389a.getSegment(fMin + length, length, f10391c, true);
            f10390b.addPath(f10391c);
        }
        path.set(f10390b);
        L.m9350d("applyTrimPathIfNeeded");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m9288a() {
        if (f10394f == -1.0f) {
            f10394f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f10394f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m9297b() {
        f10394f = Resources.getSystem().getDisplayMetrics().density;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m9292a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int OplusGLSurfaceView_13 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == OplusGLSurfaceView_13 ? typeface : Typeface.create(typeface, OplusGLSurfaceView_13);
    }
}
