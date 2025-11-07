package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class r_renamed {
    public static float a_renamed(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int iPow = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            iPow = (int) (iPow + java.lang.Math.pow(fArr[i_renamed] - fArr2[i_renamed], 2.0d));
        }
        return (float) java.lang.Math.pow(iPow, 0.5d);
    }

    public static void a_renamed(float[] fArr, float f_renamed, int i_renamed, float f2, int i2) {
        float fTan = (float) (1.0d / java.lang.Math.tan(f_renamed / 2.0f));
        float f3 = i2;
        float f4 = 1.0f / (f2 - f3);
        fArr[0] = fTan / i_renamed;
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

    public static void a_renamed(float[] fArr, int i_renamed, int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i2 <= 0 || i4 <= 0 || i5 <= 0) {
            return;
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        if (i_renamed == 0) {
            android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
            android.opengl.Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
        }
        float f_renamed = i4 / i5;
        float f2 = i2 / i3;
        if (f2 > f_renamed) {
            if (i_renamed == 1) {
                android.opengl.Matrix.orthoM(fArr2, 0, (-f_renamed) / f2, f_renamed / f2, -1.0f, 1.0f, 1.0f, 3.0f);
            } else if (i_renamed == 2) {
                android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f_renamed, f2 / f_renamed, 1.0f, 3.0f);
            } else if (i_renamed == 3) {
                android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, 1.0f - ((f2 * 2.0f) / f_renamed), 1.0f, 1.0f, 3.0f);
            } else if (i_renamed == 4) {
                android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -1.0f, ((f2 * 2.0f) / f_renamed) - 1.0f, 1.0f, 3.0f);
            }
        } else if (i_renamed == 1) {
            android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, (-f2) / f_renamed, f2 / f_renamed, 1.0f, 3.0f);
        } else if (i_renamed == 2) {
            android.opengl.Matrix.orthoM(fArr2, 0, (-f_renamed) / f2, f_renamed / f2, -1.0f, 1.0f, 1.0f, 3.0f);
        } else if (i_renamed == 3) {
            android.opengl.Matrix.orthoM(fArr2, 0, -1.0f, ((f_renamed * 2.0f) / f2) - 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
        } else if (i_renamed == 4) {
            android.opengl.Matrix.orthoM(fArr2, 0, 1.0f - ((f_renamed * 2.0f) / f2), 1.0f, -1.0f, 1.0f, 1.0f, 3.0f);
        }
        android.opengl.Matrix.setLookAtM(fArr3, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
    }

    public static void a_renamed(float[] fArr, float[] fArr2, float f_renamed, float[] fArr3) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        fArr3[0] = f2 + ((fArr2[0] - f2) * f_renamed);
        fArr3[1] = f3 + ((fArr2[1] - f3) * f_renamed);
        fArr3[2] = f4 + (f_renamed * (fArr2[2] - f4));
    }

    public static float[] a_renamed() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static float[] a_renamed(float[] fArr, boolean z_renamed, boolean z2) {
        if (z_renamed || z2) {
            android.opengl.Matrix.scaleM(fArr, 0, z_renamed ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
        }
        return fArr;
    }
}
