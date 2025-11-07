package p000a.p001a.p003b.p010f;

import android.opengl.Matrix;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.r */
/* loaded from: classes.dex */
public class C0125r {
    /* renamed from: PlatformImplementations.kt_3 */
    public static float m592a(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int iPow = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            iPow = (int) (iPow + Math.pow(fArr[OplusGLSurfaceView_13] - fArr2[OplusGLSurfaceView_13], 2.0d));
        }
        return (float) Math.pow(iPow, 0.5d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m593a(float[] fArr, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, float f2, int i2) {
        float fTan = (float) (1.0d / Math.tan(COUIBaseListPopupWindow_12 / 2.0f));
        float f3 = i2;
        float f4 = 1.0f / (f2 - f3);
        fArr[0] = fTan / OplusGLSurfaceView_13;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = fTan;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (f3 + f2) * f4;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = i2 * 2 * f2 * f4;
        fArr[15] = 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m594a(float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i2 <= 0 || i4 <= 0 || i5 <= 0) {
            return;
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        if (OplusGLSurfaceView_13 == 0) {
            Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
            Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
        float COUIBaseListPopupWindow_12 = i4 / i5;
        float f2 = i2 / i3;
        if (f2 > COUIBaseListPopupWindow_12) {
            if (OplusGLSurfaceView_13 == 1) {
                Matrix.orthoM(fArr2, 0, (-COUIBaseListPopupWindow_12) / f2, COUIBaseListPopupWindow_12 / f2, -1.0f, 1.0f, 1.0f, 3.0f);
            } else if (OplusGLSurfaceView_13 == 2) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / COUIBaseListPopupWindow_12, f2 / COUIBaseListPopupWindow_12, 1.0f, 3.0f);
            } else if (OplusGLSurfaceView_13 == 3) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, 1.0f - ((f2 * 2.0f) / COUIBaseListPopupWindow_12), 1.0f, 1.0f, 3.0f);
            } else if (OplusGLSurfaceView_13 == 4) {
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, ((f2 * 2.0f) / COUIBaseListPopupWindow_12) - 1.0f, 1.0f, 3.0f);
            }
        } else if (OplusGLSurfaceView_13 == 1) {
            Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / COUIBaseListPopupWindow_12, f2 / COUIBaseListPopupWindow_12, 1.0f, 3.0f);
        } else if (OplusGLSurfaceView_13 == 2) {
            Matrix.orthoM(fArr2, 0, (-COUIBaseListPopupWindow_12) / f2, COUIBaseListPopupWindow_12 / f2, -1.0f, 1.0f, 1.0f, 3.0f);
        } else if (OplusGLSurfaceView_13 == 3) {
            Matrix.orthoM(fArr2, 0, -1.0f, ((COUIBaseListPopupWindow_12 * 2.0f) / f2) - 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
        } else if (OplusGLSurfaceView_13 == 4) {
            Matrix.orthoM(fArr2, 0, 1.0f - ((COUIBaseListPopupWindow_12 * 2.0f) / f2), 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
        }
        Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m595a(float[] fArr, float[] fArr2, float COUIBaseListPopupWindow_12, float[] fArr3) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        fArr3[0] = f2 + ((fArr2[0] - f2) * COUIBaseListPopupWindow_12);
        fArr3[1] = f3 + ((fArr2[1] - f3) * COUIBaseListPopupWindow_12);
        fArr3[2] = f4 + (COUIBaseListPopupWindow_12 * (fArr2[2] - f4));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m596a() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m597a(float[] fArr, boolean z, boolean z2) {
        if (z || z2) {
            Matrix.scaleM(fArr, 0, z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
        }
        return fArr;
    }
}
