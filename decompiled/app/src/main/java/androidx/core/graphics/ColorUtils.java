package androidx.core.graphics;

import android.graphics.Color;

/* compiled from: ColorUtils.java */
/* renamed from: androidx.core.graphics.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class ColorUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ThreadLocal<double[]> f2943a = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    private static float m2543a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return COUIBaseListPopupWindow_12 < f2 ? f2 : COUIBaseListPopupWindow_12 > f3 ? f3 : COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2545a(int OplusGLSurfaceView_13, int i2, int i3) {
        return OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13 > i3 ? i3 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2544a(int OplusGLSurfaceView_13, int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(OplusGLSurfaceView_13);
        int iM2551c = m2551c(iAlpha2, iAlpha);
        return Color.argb(iM2551c, m2546a(Color.red(OplusGLSurfaceView_13), iAlpha2, Color.red(i2), iAlpha, iM2551c), m2546a(Color.green(OplusGLSurfaceView_13), iAlpha2, Color.green(i2), iAlpha, iM2551c), m2546a(Color.blue(OplusGLSurfaceView_13), iAlpha2, Color.blue(i2), iAlpha, iM2551c));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m2551c(int OplusGLSurfaceView_13, int i2) {
        return 255 - (((255 - i2) * (255 - OplusGLSurfaceView_13)) / 255);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2546a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((OplusGLSurfaceView_13 * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2548a(int OplusGLSurfaceView_13, int i2, int i3, float[] fArr) {
        float COUIBaseListPopupWindow_12;
        float fAbs;
        float f2 = OplusGLSurfaceView_13 / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = Math.max(f2, Math.max(f3, f4));
        float fMin = Math.min(f2, Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            COUIBaseListPopupWindow_12 = 0.0f;
            fAbs = 0.0f;
        } else {
            COUIBaseListPopupWindow_12 = fMax == f2 ? ((f3 - f4) / f5) % 6.0f : fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            fAbs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (COUIBaseListPopupWindow_12 * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = m2543a(f7, 0.0f, 360.0f);
        fArr[1] = m2543a(fAbs, 0.0f, 1.0f);
        fArr[2] = m2543a(f6, 0.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2549a(int OplusGLSurfaceView_13, float[] fArr) {
        m2548a(Color.red(OplusGLSurfaceView_13), Color.green(OplusGLSurfaceView_13), Color.blue(OplusGLSurfaceView_13), fArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2547a(float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float COUIBaseListPopupWindow_12 = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float fAbs = (1.0f - Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((COUIBaseListPopupWindow_12 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) COUIBaseListPopupWindow_12) / 60) {
            case 0:
                iRound = Math.round((fAbs + f4) * 255.0f);
                iRound2 = Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = Math.round(f4 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = Math.round((fAbs + f4) * 255.0f);
                iRound3 = Math.round(f4 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f4 * 255.0f);
                iRound2 = Math.round((fAbs + f4) * 255.0f);
                iRound3 = Math.round((fAbs2 + f4) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f4 * 255.0f);
                iRound2 = Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = Math.round((fAbs + f4) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = Math.round(f4 * 255.0f);
                iRound3 = Math.round((fAbs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f4) * 255.0f);
                iRound2 = Math.round(f4 * 255.0f);
                iRound3 = Math.round((fAbs2 + f4) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(m2545a(iRound, 0, 255), m2545a(iRound2, 0, 255), m2545a(iRound3, 0, 255));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m2550b(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (OplusGLSurfaceView_13 & 16777215) | (i2 << 24);
    }
}
