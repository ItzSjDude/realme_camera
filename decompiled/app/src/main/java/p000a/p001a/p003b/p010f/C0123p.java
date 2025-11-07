package p000a.p001a.p003b.p010f;

import android.graphics.Bitmap;
import android.opengl.GLU;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.p */
/* loaded from: classes.dex */
public class C0123p {
    /* renamed from: PlatformImplementations.kt_3 */
    public static double m566a(double IntrinsicsJvm.kt_5) {
        double dLog = IntrinsicsJvm.kt_5 * 2.0d;
        if (dLog >= 1.0d) {
            double d2 = dLog - 1.0d;
            dLog = Math.log(0.5d) / Math.log(((1.0d - d2) * 0.5d) + (d2 * 0.9332d));
        }
        return m567a(dLog, 0.0d, 10.0d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m567a(double IntrinsicsJvm.kt_5, double d2, double d3) {
        return Math.max(d2, Math.min(d3, IntrinsicsJvm.kt_5));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m568a(float COUIBaseListPopupWindow_12) {
        double IntrinsicsJvm.kt_5 = COUIBaseListPopupWindow_12;
        return (float) Math.exp((-6.283185307179586d) * IntrinsicsJvm.kt_5 * IntrinsicsJvm.kt_5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m569a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return (f2 * (1.0f - COUIBaseListPopupWindow_12)) + (f3 * COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m570a(float[] fArr, float[] fArr2) {
        float COUIBaseListPopupWindow_12 = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (float) Math.sqrt((COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m571a(float[] fArr, float[] fArr2, float[] fArr3) {
        float fM585b = m585b(fArr2, fArr3);
        if (fM585b == 0.0f) {
            return m585b(fArr, fArr2);
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, (((fArr[0] - fArr2[0]) * (fArr3[0] - fArr2[0])) + ((fArr[1] - fArr2[1]) * (fArr3[1] - fArr2[1]))) / fM585b));
        return m570a(fArr, new float[]{fArr2[0] + ((fArr3[0] - fArr2[0]) * fMax), fArr2[1] + (fMax * (fArr3[1] - fArr2[1]))});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m572a(float[] fArr, float[][] fArr2) {
        if (m586b(fArr, fArr2)) {
            return 0.0f;
        }
        int length = fArr2.length;
        float fMin = 1.0f;
        int OplusGLSurfaceView_13 = length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            m571a(fArr, fArr2[i2], fArr2[OplusGLSurfaceView_13]);
            fMin = Math.min(fMin, m571a(fArr, fArr2[i2], fArr2[OplusGLSurfaceView_13]));
            OplusGLSurfaceView_13 = i2;
        }
        return fMin;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m573a(Bitmap bitmap, float COUIBaseListPopupWindow_12, float f2) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMin = Math.min(1.0f, Math.min(COUIBaseListPopupWindow_12 / width, f2 / height));
        return Bitmap.createScaledBitmap(bitmap, (int) (width * fMin), (int) (height * fMin), true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m574a(Object obj, Class<T> cls) {
        return (T) C0109b.m465a(C0109b.m466a(obj), cls);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m575a(String str) {
        return str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m576a(String str, int OplusGLSurfaceView_13) {
        String str2 = String.format("%s: GLError code:0x%08X %s", str, Integer.valueOf(OplusGLSurfaceView_13), GLU.gluErrorString(OplusGLSurfaceView_13));
        String stackTraceString = Log.getStackTraceString(new Throwable());
        m575a(str2);
        Log.COUIBaseListPopupWindow_8("POLARR_GL_ERROR", str2);
        m575a(stackTraceString);
        Log.COUIBaseListPopupWindow_8("POLARR_GL_TRACE", stackTraceString);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m577a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj == null || obj2 != null) {
            return C0109b.m466a(obj).equals(C0109b.m466a(obj2));
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m578a(Bitmap bitmap) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m579a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr, 0, inputStream.available());
        return bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m580a(float[] fArr) {
        return (fArr == null || fArr.length < 2) ? fArr : new float[]{fArr[0], -fArr[1]};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m581a(float[] fArr, float COUIBaseListPopupWindow_12) {
        double IntrinsicsJvm.kt_5 = (float) (COUIBaseListPopupWindow_12 * 0.017453292519943295d);
        float fCos = (float) Math.cos(IntrinsicsJvm.kt_5);
        float fSin = (float) Math.sin(IntrinsicsJvm.kt_5);
        return new float[]{(fArr[0] * fCos) - (fArr[1] * fSin), (fArr[0] * fSin) + (fArr[1] * fCos)};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m582a(float[] fArr, float[] fArr2, float[] fArr3, float COUIBaseListPopupWindow_12) {
        float f2 = fArr2[0];
        float f3 = fArr2[1];
        fArr[0] = f2 + ((fArr3[0] - f2) * COUIBaseListPopupWindow_12);
        fArr[1] = f3 + (COUIBaseListPopupWindow_12 * (fArr3[1] - f3));
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m583a(float[][] fArr) {
        int length = fArr.length;
        float fMin = 1.0f;
        float fMax = -1.0f;
        float fMax2 = -1.0f;
        float fMin2 = 1.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            float COUIBaseListPopupWindow_12 = fArr[OplusGLSurfaceView_13][0];
            float f2 = fArr[OplusGLSurfaceView_13][1];
            fMin2 = Math.min(fMin2, COUIBaseListPopupWindow_12);
            fMax = Math.max(fMax, COUIBaseListPopupWindow_12);
            fMin = Math.min(fMin, f2);
            fMax2 = Math.max(fMax2, f2);
        }
        return new float[]{(fMin2 * 0.5f) + (fMax * 0.5f), (fMin * 0.5f) + (fMax2 * 0.5f)};
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m584b(float[] fArr) {
        float COUIBaseListPopupWindow_12 = fArr[0];
        float f2 = fArr[1];
        return (float) Math.sqrt((COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m585b(float[] fArr, float[] fArr2) {
        float COUIBaseListPopupWindow_12 = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12) + (f2 * f2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m586b(float[] fArr, float[][] fArr2) {
        float[][] fArr3 = new float[fArr2.length + 1][];
        System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
        fArr3[fArr2.length] = fArr2[0];
        float COUIBaseListPopupWindow_12 = fArr[0];
        float f2 = fArr[1];
        int length = fArr3.length - 1;
        boolean z = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr3.length; OplusGLSurfaceView_13++) {
            float f3 = fArr3[OplusGLSurfaceView_13][0];
            float f4 = fArr3[OplusGLSurfaceView_13][1];
            float f5 = fArr3[length][0];
            float f6 = fArr3[length][1];
            if (((f4 > f2 ? 1 : (f4 == f2 ? 0 : -1)) > 0) != ((f6 > f2 ? 1 : (f6 == f2 ? 0 : -1)) > 0) && COUIBaseListPopupWindow_12 < (((f5 - f3) * (f2 - f4)) / (f6 - f4)) + f3) {
                z = !z;
            }
            length = OplusGLSurfaceView_13;
        }
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float[] m587b(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] + fArr3[0];
        fArr[1] = fArr2[1] + fArr3[1];
        return fArr;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float[] m588c(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] / fArr3[0];
        fArr[1] = fArr2[1] / fArr3[1];
        return fArr;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static float[] m589d(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] * fArr3[0];
        fArr[1] = fArr2[1] * fArr3[1];
        return fArr;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static float[] m590e(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] - fArr3[0];
        fArr[1] = fArr2[1] - fArr3[1];
        return fArr;
    }
}
