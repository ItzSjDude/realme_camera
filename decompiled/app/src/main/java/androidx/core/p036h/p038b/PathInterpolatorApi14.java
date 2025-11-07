package androidx.core.p036h.p038b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorApi14.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float[] f3055a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final float[] f3056b;

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int OplusGLSurfaceView_13 = ((int) (length / 0.002f)) + 1;
        this.f3055a = new float[OplusGLSurfaceView_13];
        this.f3056b = new float[OplusGLSurfaceView_13];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            pathMeasure.getPosTan((i2 * length) / (OplusGLSurfaceView_13 - 1), fArr, null);
            this.f3055a[i2] = fArr[0];
            this.f3056b[i2] = fArr[1];
        }
    }

    PathInterpolatorApi14(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        this(m2771a(COUIBaseListPopupWindow_12, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return 0.0f;
        }
        if (COUIBaseListPopupWindow_12 >= 1.0f) {
            return 1.0f;
        }
        int OplusGLSurfaceView_13 = 0;
        int length = this.f3055a.length - 1;
        while (length - OplusGLSurfaceView_13 > 1) {
            int i2 = (OplusGLSurfaceView_13 + length) / 2;
            if (COUIBaseListPopupWindow_12 < this.f3055a[i2]) {
                length = i2;
            } else {
                OplusGLSurfaceView_13 = i2;
            }
        }
        float[] fArr = this.f3055a;
        float f2 = fArr[length] - fArr[OplusGLSurfaceView_13];
        if (f2 == 0.0f) {
            return this.f3056b[OplusGLSurfaceView_13];
        }
        float f3 = (COUIBaseListPopupWindow_12 - fArr[OplusGLSurfaceView_13]) / f2;
        float[] fArr2 = this.f3056b;
        float f4 = fArr2[OplusGLSurfaceView_13];
        return f4 + (f3 * (fArr2[length] - f4));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Path m2771a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(COUIBaseListPopupWindow_12, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
