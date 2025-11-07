package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class p_renamed {
    public static double a_renamed(double d_renamed) {
        double dLog = d_renamed * 2.0d;
        if (dLog >= 1.0d) {
            double d2 = dLog - 1.0d;
            dLog = java.lang.Math.log(0.5d) / java.lang.Math.log(((1.0d - d2) * 0.5d) + (d2 * 0.9332d));
        }
        return a_renamed(dLog, 0.0d, 10.0d);
    }

    public static double a_renamed(double d_renamed, double d2, double d3) {
        return java.lang.Math.max(d2, java.lang.Math.min(d3, d_renamed));
    }

    public static float a_renamed(float f_renamed) {
        double d_renamed = f_renamed;
        return (float) java.lang.Math.exp((-6.283185307179586d) * d_renamed * d_renamed);
    }

    public static float a_renamed(float f_renamed, float f2, float f3) {
        return (f2 * (1.0f - f_renamed)) + (f3 * f_renamed);
    }

    public static float a_renamed(float[] fArr, float[] fArr2) {
        float f_renamed = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (float) java.lang.Math.sqrt((f_renamed * f_renamed) + (f2 * f2));
    }

    public static float a_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        float fB_renamed = b_renamed(fArr2, fArr3);
        if (fB_renamed == 0.0f) {
            return b_renamed(fArr, fArr2);
        }
        float fMax = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, (((fArr[0] - fArr2[0]) * (fArr3[0] - fArr2[0])) + ((fArr[1] - fArr2[1]) * (fArr3[1] - fArr2[1]))) / fB_renamed));
        return a_renamed(fArr, new float[]{fArr2[0] + ((fArr3[0] - fArr2[0]) * fMax), fArr2[1] + (fMax * (fArr3[1] - fArr2[1]))});
    }

    public static float a_renamed(float[] fArr, float[][] fArr2) {
        if (b_renamed(fArr, fArr2)) {
            return 0.0f;
        }
        int length = fArr2.length;
        float fMin = 1.0f;
        int i_renamed = length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            a_renamed(fArr, fArr2[i2], fArr2[i_renamed]);
            fMin = java.lang.Math.min(fMin, a_renamed(fArr, fArr2[i2], fArr2[i_renamed]));
            i_renamed = i2;
        }
        return fMin;
    }

    public static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, float f_renamed, float f2) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMin = java.lang.Math.min(1.0f, java.lang.Math.min(f_renamed / width, f2 / height));
        return android.graphics.Bitmap.createScaledBitmap(bitmap, (int) (width * fMin), (int) (height * fMin), true);
    }

    public static <T_renamed> T_renamed a_renamed(java.lang.Object obj, java.lang.Class<T_renamed> cls) {
        return (T_renamed) a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(obj), cls);
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        return str;
    }

    public static void a_renamed(java.lang.String str, int i_renamed) {
        java.lang.String str2 = java.lang.String.format("%s_renamed: GLError code:0x%08X %s_renamed", str, java.lang.Integer.valueOf(i_renamed), android.opengl.GLU.gluErrorString(i_renamed));
        java.lang.String stackTraceString = android.util.Log.getStackTraceString(new java.lang.Throwable());
        a_renamed(str2);
        android.util.Log.e_renamed("POLARR_GL_ERROR", str2);
        a_renamed(stackTraceString);
        android.util.Log.e_renamed("POLARR_GL_TRACE", stackTraceString);
    }

    public static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj == null || obj2 != null) {
            return a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(obj).equals(a_renamed.a_renamed.b_renamed.f_renamed.b_renamed.a_renamed(obj2));
        }
        return false;
    }

    public static byte[] a_renamed(android.graphics.Bitmap bitmap) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public static byte[] a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr, 0, inputStream.available());
        return bArr;
    }

    public static float[] a_renamed(float[] fArr) {
        return (fArr == null || fArr.length < 2) ? fArr : new float[]{fArr[0], -fArr[1]};
    }

    public static float[] a_renamed(float[] fArr, float f_renamed) {
        double d_renamed = (float) (f_renamed * 0.017453292519943295d);
        float fCos = (float) java.lang.Math.cos(d_renamed);
        float fSin = (float) java.lang.Math.sin(d_renamed);
        return new float[]{(fArr[0] * fCos) - (fArr[1] * fSin), (fArr[0] * fSin) + (fArr[1] * fCos)};
    }

    public static float[] a_renamed(float[] fArr, float[] fArr2, float[] fArr3, float f_renamed) {
        float f2 = fArr2[0];
        float f3 = fArr2[1];
        fArr[0] = f2 + ((fArr3[0] - f2) * f_renamed);
        fArr[1] = f3 + (f_renamed * (fArr3[1] - f3));
        return fArr;
    }

    public static float[] a_renamed(float[][] fArr) {
        int length = fArr.length;
        float fMin = 1.0f;
        float fMax = -1.0f;
        float fMax2 = -1.0f;
        float fMin2 = 1.0f;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            float f_renamed = fArr[i_renamed][0];
            float f2 = fArr[i_renamed][1];
            fMin2 = java.lang.Math.min(fMin2, f_renamed);
            fMax = java.lang.Math.max(fMax, f_renamed);
            fMin = java.lang.Math.min(fMin, f2);
            fMax2 = java.lang.Math.max(fMax2, f2);
        }
        return new float[]{(fMin2 * 0.5f) + (fMax * 0.5f), (fMin * 0.5f) + (fMax2 * 0.5f)};
    }

    public static float b_renamed(float[] fArr) {
        float f_renamed = fArr[0];
        float f2 = fArr[1];
        return (float) java.lang.Math.sqrt((f_renamed * f_renamed) + (f2 * f2));
    }

    public static float b_renamed(float[] fArr, float[] fArr2) {
        float f_renamed = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (f_renamed * f_renamed) + (f2 * f2);
    }

    public static boolean b_renamed(float[] fArr, float[][] fArr2) {
        float[][] fArr3 = new float[fArr2.length + 1][];
        java.lang.System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
        fArr3[fArr2.length] = fArr2[0];
        float f_renamed = fArr[0];
        float f2 = fArr[1];
        int length = fArr3.length - 1;
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < fArr3.length; i_renamed++) {
            float f3 = fArr3[i_renamed][0];
            float f4 = fArr3[i_renamed][1];
            float f5 = fArr3[length][0];
            float f6 = fArr3[length][1];
            if (((f4 > f2 ? 1 : (f4 == f2 ? 0 : -1)) > 0) != ((f6 > f2 ? 1 : (f6 == f2 ? 0 : -1)) > 0) && f_renamed < (((f5 - f3) * (f2 - f4)) / (f6 - f4)) + f3) {
                z_renamed = !z_renamed;
            }
            length = i_renamed;
        }
        return z_renamed;
    }

    public static float[] b_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] + fArr3[0];
        fArr[1] = fArr2[1] + fArr3[1];
        return fArr;
    }

    public static float[] c_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] / fArr3[0];
        fArr[1] = fArr2[1] / fArr3[1];
        return fArr;
    }

    public static float[] d_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] * fArr3[0];
        fArr[1] = fArr2[1] * fArr3[1];
        return fArr;
    }

    public static float[] e_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] - fArr3[0];
        fArr[1] = fArr2[1] - fArr3[1];
        return fArr;
    }
}
