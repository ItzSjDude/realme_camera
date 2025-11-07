package com.oplus.anim.f_renamed;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.graphics.PathMeasure f3679a = new android.graphics.PathMeasure();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.graphics.Path f3680b = new android.graphics.Path();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.graphics.Path f3681c = new android.graphics.Path();
    private static final float[] d_renamed = new float[4];
    private static final float e_renamed = (float) java.lang.Math.sqrt(2.0d);
    private static float f_renamed = -1.0f;

    public static int a_renamed(float f2, float f3, float f4, float f5) {
        int i_renamed = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i_renamed = (int) (i_renamed * 31 * f3);
        }
        if (f4 != 0.0f) {
            i_renamed = (int) (i_renamed * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i_renamed * 31 * f5) : i_renamed;
    }

    public static boolean a_renamed(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        if (i_renamed < i4) {
            return false;
        }
        if (i_renamed > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static android.graphics.Path a_renamed(android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3, android.graphics.PointF pointF4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(pointF.x_renamed, pointF.y_renamed);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x_renamed + pointF.x_renamed, pointF.y_renamed + pointF3.y_renamed, pointF2.x_renamed + pointF4.x_renamed, pointF2.y_renamed + pointF4.y_renamed, pointF2.x_renamed, pointF2.y_renamed);
        } else {
            path.lineTo(pointF2.x_renamed, pointF2.y_renamed);
        }
        return path;
    }

    public static void a_renamed(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static float a_renamed(android.graphics.Matrix matrix) {
        float[] fArr = d_renamed;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e_renamed;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = d_renamed;
        return ((float) java.lang.Math.hypot(fArr2[2] - fArr2[0], fArr2[3] - fArr2[1])) / 2.0f;
    }

    public static void a_renamed(android.graphics.Path path, com.oplus.anim.a_renamed.a_renamed.s_renamed sVar) {
        if (sVar == null || sVar.g_renamed()) {
            return;
        }
        a_renamed(path, ((com.oplus.anim.a_renamed.b_renamed.c_renamed) sVar.d_renamed()).i_renamed() / 100.0f, ((com.oplus.anim.a_renamed.b_renamed.c_renamed) sVar.e_renamed()).i_renamed() / 100.0f, ((com.oplus.anim.a_renamed.b_renamed.c_renamed) sVar.f_renamed()).i_renamed() / 360.0f);
    }

    public static void a_renamed(android.graphics.Path path, float f2, float f3, float f4) {
        com.oplus.anim.k_renamed.c_renamed("applyTrimPathIfNeeded");
        f3679a.setPath(path, false);
        float length = f3679a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.oplus.anim.k_renamed.d_renamed("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || java.lang.Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.oplus.anim.k_renamed.d_renamed("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float fMin = java.lang.Math.min(f5, f6) + f7;
        float fMax = java.lang.Math.max(f5, f6) + f7;
        if (fMin >= length && fMax >= length) {
            fMin = com.oplus.anim.f_renamed.e_renamed.a_renamed(fMin, length);
            fMax = com.oplus.anim.f_renamed.e_renamed.a_renamed(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = com.oplus.anim.f_renamed.e_renamed.a_renamed(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = com.oplus.anim.f_renamed.e_renamed.a_renamed(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.oplus.anim.k_renamed.d_renamed("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        f3680b.reset();
        f3679a.getSegment(fMin, fMax, f3680b, true);
        if (fMax > length) {
            f3681c.reset();
            f3679a.getSegment(0.0f, fMax % length, f3681c, true);
            f3680b.addPath(f3681c);
        } else if (fMin < 0.0f) {
            f3681c.reset();
            f3679a.getSegment(fMin + length, length, f3681c, true);
            f3680b.addPath(f3681c);
        }
        path.set(f3680b);
        com.oplus.anim.k_renamed.d_renamed("applyTrimPathIfNeeded");
    }

    public static float a_renamed() {
        if (f_renamed == -1.0f) {
            f_renamed = android.content.res.Resources.getSystem().getDisplayMetrics().density;
        }
        return f_renamed;
    }

    public static void b_renamed() {
        f_renamed = android.content.res.Resources.getSystem().getDisplayMetrics().density;
    }

    public static android.graphics.Typeface a_renamed(android.graphics.Typeface typeface, java.lang.String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i_renamed = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i_renamed ? typeface : android.graphics.Typeface.create(typeface, i_renamed);
    }
}
