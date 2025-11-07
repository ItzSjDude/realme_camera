package com.airbnb.lottie.f_renamed;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.graphics.PathMeasure> f2260a = new java.lang.ThreadLocal<android.graphics.PathMeasure>() { // from class: com.airbnb.lottie.f_renamed.h_renamed.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.PathMeasure initialValue() {
            return new android.graphics.PathMeasure();
        }
    };

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.graphics.Path> f2261b = new java.lang.ThreadLocal<android.graphics.Path>() { // from class: com.airbnb.lottie.f_renamed.h_renamed.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.graphics.Path> f2262c = new java.lang.ThreadLocal<android.graphics.Path>() { // from class: com.airbnb.lottie.f_renamed.h_renamed.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public android.graphics.Path initialValue() {
            return new android.graphics.Path();
        }
    };
    private static final java.lang.ThreadLocal<float[]> d_renamed = new java.lang.ThreadLocal<float[]>() { // from class: com.airbnb.lottie.f_renamed.h_renamed.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float e_renamed = (float) (java.lang.Math.sqrt(2.0d) / 2.0d);
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
        float[] fArr = d_renamed.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e_renamed;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) java.lang.Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean b_renamed(android.graphics.Matrix matrix) {
        float[] fArr = d_renamed.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void a_renamed(android.graphics.Path path, com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar) {
        if (sVar == null || sVar.g_renamed()) {
            return;
        }
        a_renamed(path, ((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) sVar.d_renamed()).i_renamed() / 100.0f, ((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) sVar.e_renamed()).i_renamed() / 100.0f, ((com.airbnb.lottie.a_renamed.b_renamed.c_renamed) sVar.f_renamed()).i_renamed() / 360.0f);
    }

    public static void a_renamed(android.graphics.Path path, float f2, float f3, float f4) {
        com.airbnb.lottie.c_renamed.a_renamed("applyTrimPathIfNeeded");
        android.graphics.PathMeasure pathMeasure = f2260a.get();
        android.graphics.Path path2 = f2261b.get();
        android.graphics.Path path3 = f2262c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.airbnb.lottie.c_renamed.b_renamed("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || java.lang.Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.airbnb.lottie.c_renamed.b_renamed("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float fMin = java.lang.Math.min(f5, f6) + f7;
        float fMax = java.lang.Math.max(f5, f6) + f7;
        if (fMin >= length && fMax >= length) {
            fMin = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(fMin, length);
            fMax = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = com.airbnb.lottie.f_renamed.g_renamed.a_renamed(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.airbnb.lottie.c_renamed.b_renamed("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        com.airbnb.lottie.c_renamed.b_renamed("applyTrimPathIfNeeded");
    }

    public static float a_renamed() {
        if (f_renamed == -1.0f) {
            f_renamed = android.content.res.Resources.getSystem().getDisplayMetrics().density;
        }
        return f_renamed;
    }

    public static float a_renamed(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return android.provider.Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return android.provider.Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2) {
        if (bitmap.getWidth() == i_renamed && bitmap.getHeight() == i2) {
            return bitmap;
        }
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i_renamed, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean a_renamed(java.lang.Throwable th) {
        return (th instanceof java.net.SocketException) || (th instanceof java.nio.channels.ClosedChannelException) || (th instanceof java.io.InterruptedIOException) || (th instanceof java.net.ProtocolException) || (th instanceof javax.net.ssl.SSLException) || (th instanceof java.net.UnknownHostException) || (th instanceof java.net.UnknownServiceException);
    }

    public static void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint) {
        a_renamed(canvas, rectF, paint, 31);
    }

    public static void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF, android.graphics.Paint paint, int i_renamed) {
        com.airbnb.lottie.c_renamed.a_renamed("Utils#saveLayer");
        if (android.os.Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i_renamed);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.c_renamed.b_renamed("Utils#saveLayer");
    }
}
