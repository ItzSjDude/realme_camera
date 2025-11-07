package com.oplus.camera;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.params.MeteringRectangle;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;

/* compiled from: AEAFHelp.java */
/* renamed from: com.oplus.camera.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AEAFHelp {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final MeteringRectangle[] f12154a = {new MeteringRectangle(0, 0, 0, 0, 0)};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final MeteringRectangle[] f12155b = {new MeteringRectangle(0, 0, 0, 0, 1)};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final RectF f12156c = new RectF(-1.0f, -1.0f, -1.0f, -1.0f);

    /* compiled from: AEAFHelp.java */
    /* renamed from: com.oplus.camera.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        FrameAverage,
        CenterWeighted,
        SpotMetering,
        SmartMetering,
        UserMetering,
        SpotMeteringAdv,
        CenterWeightedAdv,
        End
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m11155c() {
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m11156d() {
        return 1;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static int m11157e() {
        return 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static RectF m11153a() {
        return f12156c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static MeteringRectangle[] m11154b() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DEFAULT_MTK_WEIGHT_3A_REGION)) {
            return f12155b;
        }
        return f12154a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PointF m11150a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return new PointF(COUIBaseListPopupWindow_12, f2);
        }
        if (OplusGLSurfaceView_13 == 90) {
            return new PointF(f2, 1.0f - COUIBaseListPopupWindow_12);
        }
        if (OplusGLSurfaceView_13 == 180) {
            return new PointF(1.0f - COUIBaseListPopupWindow_12, 1.0f - f2);
        }
        if (OplusGLSurfaceView_13 == 270) {
            return new PointF(1.0f - f2, COUIBaseListPopupWindow_12);
        }
        return new PointF(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Rect m11151a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4, int i5, Rect rect, int i6) {
        if (rect == null) {
            CameraLog.m12967f("AEAFHelp", "calculateTapArea, cropRegion is null");
            return null;
        }
        float[] fArr = {COUIBaseListPopupWindow_12 / OplusGLSurfaceView_13, f2 / i2};
        Matrix matrix = new Matrix();
        matrix.setRotate(i5, 0.5f, 0.5f);
        matrix.mapPoints(fArr);
        if (z) {
            fArr[0] = 1.0f - fArr[0];
        }
        Rect rectM11152a = m11152a(OplusGLSurfaceView_13, i2, i3, m11150a(fArr[0], fArr[1], i4), rect);
        CameraLog.m12954a("AEAFHelp", "calculateTapArea, meteringRectangle: " + rectM11152a.toString());
        return rectM11152a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Rect m11152a(int OplusGLSurfaceView_13, int i2, int i3, PointF pointF, Rect rect) {
        double IntrinsicsJvm.kt_5;
        double d2;
        int iMin = (int) ((((i3 * 1.0f) / OplusGLSurfaceView_13) * Math.min(rect.width(), rect.height())) / 2.0f);
        if (OplusGLSurfaceView_13 > i2) {
            IntrinsicsJvm.kt_5 = OplusGLSurfaceView_13;
            d2 = i2;
        } else {
            IntrinsicsJvm.kt_5 = i2;
            d2 = OplusGLSurfaceView_13;
        }
        double d3 = IntrinsicsJvm.kt_5 / d2;
        double dWidth = rect.width() / rect.height();
        int iWidth = rect.width();
        int iHeight = rect.height();
        if (d3 > dWidth) {
            iHeight = (int) (iWidth / d3);
        } else {
            iWidth = (int) (iHeight * d3);
        }
        int iWidth2 = (rect.width() - iWidth) / 2;
        int iHeight2 = (rect.height() - iHeight) / 2;
        int i4 = (int) (rect.left + (pointF.x * iWidth) + iWidth2);
        int i5 = (int) (rect.top + (pointF.y * iHeight) + iHeight2);
        Rect rect2 = new Rect(rect.left + iWidth2, rect.top + iHeight2, rect.right - iWidth2, rect.bottom - iHeight2);
        return new Rect(Util.m24205a(i4 - iMin, rect2.left, rect2.right), Util.m24205a(i5 - iMin, rect2.top, rect2.bottom), Util.m24205a(i4 + iMin, rect2.left, rect2.right), Util.m24205a(i5 + iMin, rect2.top, rect2.bottom));
    }
}
