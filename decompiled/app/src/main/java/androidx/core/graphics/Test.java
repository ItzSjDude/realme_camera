package androidx.core.graphics;

/* compiled from: ColorUtils.java */
/* loaded from: classes.dex */
public final class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<double[]> f924a = new java.lang.ThreadLocal<>();

    private static float a_renamed(float f_renamed, float f2, float f3) {
        return f_renamed < f2 ? f2 : f_renamed > f3 ? f3 : f_renamed;
    }

    private static int a_renamed(int i_renamed, int i2, int i3) {
        return i_renamed < i2 ? i2 : i_renamed > i3 ? i3 : i_renamed;
    }

    public static int a_renamed(int i_renamed, int i2) {
        int iAlpha = android.graphics.Color.alpha(i2);
        int iAlpha2 = android.graphics.Color.alpha(i_renamed);
        int iC = c_renamed(iAlpha2, iAlpha);
        return android.graphics.Color.argb(iC, a_renamed(android.graphics.Color.red(i_renamed), iAlpha2, android.graphics.Color.red(i2), iAlpha, iC), a_renamed(android.graphics.Color.green(i_renamed), iAlpha2, android.graphics.Color.green(i2), iAlpha, iC), a_renamed(android.graphics.Color.blue(i_renamed), iAlpha2, android.graphics.Color.blue(i2), iAlpha, iC));
    }

    private static int c_renamed(int i_renamed, int i2) {
        return 255 - (((255 - i2) * (255 - i_renamed)) / 255);
    }

    private static int a_renamed(int i_renamed, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i_renamed * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static void a_renamed(int i_renamed, int i2, int i3, float[] fArr) {
        float f_renamed;
        float fAbs;
        float f2 = i_renamed / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float fMax = java.lang.Math.max(f2, java.lang.Math.max(f3, f4));
        float fMin = java.lang.Math.min(f2, java.lang.Math.min(f3, f4));
        float f5 = fMax - fMin;
        float f6 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f_renamed = 0.0f;
            fAbs = 0.0f;
        } else {
            f_renamed = fMax == f2 ? ((f3 - f4) / f5) % 6.0f : fMax == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            fAbs = f5 / (1.0f - java.lang.Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f_renamed * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = a_renamed(f7, 0.0f, 360.0f);
        fArr[1] = a_renamed(fAbs, 0.0f, 1.0f);
        fArr[2] = a_renamed(f6, 0.0f, 1.0f);
    }

    public static void a_renamed(int i_renamed, float[] fArr) {
        a_renamed(android.graphics.Color.red(i_renamed), android.graphics.Color.green(i_renamed), android.graphics.Color.blue(i_renamed), fArr);
    }

    public static int a_renamed(float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f_renamed = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float fAbs = (1.0f - java.lang.Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * fAbs);
        float fAbs2 = (1.0f - java.lang.Math.abs(((f_renamed / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f_renamed) / 60) {
            case 0:
                iRound = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound2 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 1:
                iRound = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 2:
                iRound = java.lang.Math.round(f4 * 255.0f);
                iRound2 = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound3 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                break;
            case 3:
                iRound = java.lang.Math.round(f4 * 255.0f);
                iRound2 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound3 = java.lang.Math.round((fAbs + f4) * 255.0f);
                break;
            case 4:
                iRound = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                iRound2 = java.lang.Math.round(f4 * 255.0f);
                iRound3 = java.lang.Math.round((fAbs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = java.lang.Math.round((fAbs + f4) * 255.0f);
                iRound2 = java.lang.Math.round(f4 * 255.0f);
                iRound3 = java.lang.Math.round((fAbs2 + f4) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return android.graphics.Color.rgb(a_renamed(iRound, 0, 255), a_renamed(iRound2, 0, 255), a_renamed(iRound3, 0, 255));
    }

    public static int b_renamed(int i_renamed, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new java.lang.IllegalArgumentException("alpha must be_renamed between 0 and 255.");
        }
        return (i_renamed & 16777215) | (i2 << 24);
    }
}
