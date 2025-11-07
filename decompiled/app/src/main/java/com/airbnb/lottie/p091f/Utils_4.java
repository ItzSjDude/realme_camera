package com.airbnb.lottie.p091f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.L_2;
import com.airbnb.lottie.p080a.p081a.TrimPathContent_2;
import com.airbnb.lottie.p080a.p082b.FloatKeyframeAnimation_2;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* compiled from: Utils.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public final class Utils_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ThreadLocal<PathMeasure> f5882a = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ThreadLocal<Path> f5883b = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final ThreadLocal<Path> f5884c = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final ThreadLocal<float[]> f5885d = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_10.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final float f5886e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static float f5887f = -1.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6142a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
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
    public static boolean m6150a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
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
    public static Path m6144a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
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
    public static void m6149a(Closeable closeable) throws IOException {
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
    public static float m6141a(Matrix matrix) {
        float[] fArr = f5885d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float COUIBaseListPopupWindow_12 = f5886e;
        fArr[2] = COUIBaseListPopupWindow_12;
        fArr[3] = COUIBaseListPopupWindow_12;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m6152b(Matrix matrix) {
        float[] fArr = f5885d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6148a(Path path, TrimPathContent_2 c1067s) {
        if (c1067s == null || c1067s.m5569g()) {
            return;
        }
        m6147a(path, ((FloatKeyframeAnimation_2) c1067s.m5566d()).m5597i() / 100.0f, ((FloatKeyframeAnimation_2) c1067s.m5567e()).m5597i() / 100.0f, ((FloatKeyframeAnimation_2) c1067s.m5568f()).m5597i() / 360.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6147a(Path path, float COUIBaseListPopupWindow_12, float f2, float f3) {
        L_2.m5637a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f5882a.get();
        Path path2 = f5883b.get();
        Path path3 = f5884c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (COUIBaseListPopupWindow_12 == 1.0f && f2 == 0.0f) {
            L_2.m5638b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - COUIBaseListPopupWindow_12) - 1.0f) < 0.01d) {
            L_2.m5638b("applyTrimPathIfNeeded");
            return;
        }
        float f4 = COUIBaseListPopupWindow_12 * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = MiscUtils_2.m6128a(fMin, length);
            fMax = MiscUtils_2.m6128a(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = MiscUtils_2.m6128a(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = MiscUtils_2.m6128a(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            L_2.m5638b("applyTrimPathIfNeeded");
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
        L_2.m5638b("applyTrimPathIfNeeded");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m6139a() {
        if (f5887f == -1.0f) {
            f5887f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f5887f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m6140a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m6143a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        if (bitmap.getWidth() == OplusGLSurfaceView_13 && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, OplusGLSurfaceView_13, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m6151a(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6145a(Canvas canvas, RectF rectF, Paint paint) {
        m6146a(canvas, rectF, paint, 31);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6146a(Canvas canvas, RectF rectF, Paint paint, int OplusGLSurfaceView_13) {
        L_2.m5637a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, OplusGLSurfaceView_13);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L_2.m5638b("Utils#saveLayer");
    }
}
