package com.oplus.camera;

/* compiled from: AEAFHelp.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.hardware.camera2.params.MeteringRectangle[] f4069a = {new android.hardware.camera2.params.MeteringRectangle(0, 0, 0, 0, 0)};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.hardware.camera2.params.MeteringRectangle[] f4070b = {new android.hardware.camera2.params.MeteringRectangle(0, 0, 0, 0, 1)};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.graphics.RectF f4071c = new android.graphics.RectF(-1.0f, -1.0f, -1.0f, -1.0f);

    /* compiled from: AEAFHelp.java */
    /* renamed from: com.oplus.camera.a_renamed$a_renamed, reason: collision with other inner class name */
    public enum AEAFHelp_2 {
        FrameAverage,
        CenterWeighted,
        SpotMetering,
        SmartMetering,
        UserMetering,
        SpotMeteringAdv,
        CenterWeightedAdv,
        End
    }

    public static int c_renamed() {
        return 0;
    }

    public static int d_renamed() {
        return 1;
    }

    public static int e_renamed() {
        return 1;
    }

    public static android.graphics.RectF a_renamed() {
        return f4071c;
    }

    public static android.hardware.camera2.params.MeteringRectangle[] b_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_DEFAULT_MTK_WEIGHT_3A_REGION)) {
            return f4070b;
        }
        return f4069a;
    }

    private static android.graphics.PointF a_renamed(float f_renamed, float f2, int i_renamed) {
        if (i_renamed == 0) {
            return new android.graphics.PointF(f_renamed, f2);
        }
        if (i_renamed == 90) {
            return new android.graphics.PointF(f2, 1.0f - f_renamed);
        }
        if (i_renamed == 180) {
            return new android.graphics.PointF(1.0f - f_renamed, 1.0f - f2);
        }
        if (i_renamed == 270) {
            return new android.graphics.PointF(1.0f - f2, f_renamed);
        }
        return new android.graphics.PointF(f_renamed, f2);
    }

    public static android.graphics.Rect a_renamed(float f_renamed, float f2, int i_renamed, int i2, int i3, boolean z_renamed, int i4, int i5, android.graphics.Rect rect, int i6) {
        if (rect == null) {
            com.oplus.camera.e_renamed.f_renamed("AEAFHelp", "calculateTapArea, cropRegion is_renamed null");
            return null;
        }
        float[] fArr = {f_renamed / i_renamed, f2 / i2};
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(i5, 0.5f, 0.5f);
        matrix.mapPoints(fArr);
        if (z_renamed) {
            fArr[0] = 1.0f - fArr[0];
        }
        android.graphics.Rect rectA = a_renamed(i_renamed, i2, i3, a_renamed(fArr[0], fArr[1], i4), rect);
        com.oplus.camera.e_renamed.a_renamed("AEAFHelp", "calculateTapArea, meteringRectangle: " + rectA.toString());
        return rectA;
    }

    private static android.graphics.Rect a_renamed(int i_renamed, int i2, int i3, android.graphics.PointF pointF, android.graphics.Rect rect) {
        double d_renamed;
        double d2;
        int iMin = (int) ((((i3 * 1.0f) / i_renamed) * java.lang.Math.min(rect.width(), rect.height())) / 2.0f);
        if (i_renamed > i2) {
            d_renamed = i_renamed;
            d2 = i2;
        } else {
            d_renamed = i2;
            d2 = i_renamed;
        }
        double d3 = d_renamed / d2;
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
        int i4 = (int) (rect.left + (pointF.x_renamed * iWidth) + iWidth2);
        int i5 = (int) (rect.top + (pointF.y_renamed * iHeight) + iHeight2);
        android.graphics.Rect rect2 = new android.graphics.Rect(rect.left + iWidth2, rect.top + iHeight2, rect.right - iWidth2, rect.bottom - iHeight2);
        return new android.graphics.Rect(com.oplus.camera.util.Util.a_renamed(i4 - iMin, rect2.left, rect2.right), com.oplus.camera.util.Util.a_renamed(i5 - iMin, rect2.top, rect2.bottom), com.oplus.camera.util.Util.a_renamed(i4 + iMin, rect2.left, rect2.right), com.oplus.camera.util.Util.a_renamed(i5 + iMin, rect2.top, rect2.bottom));
    }
}
