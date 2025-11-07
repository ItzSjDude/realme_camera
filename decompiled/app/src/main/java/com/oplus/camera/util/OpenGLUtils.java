package com.oplus.camera.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.BitmapTexture;
import com.sensetime.utils.OpenGLUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: OpenGLUtils.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class OpenGLUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24588a(Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24593a(int OplusGLSurfaceView_13) {
        GLES20.glDeleteTextures(1, new int[]{OplusGLSurfaceView_13}, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24589a(String str, String str2) {
        int[] iArr = new int[1];
        int iM24587a = m24587a(35633, str);
        if (iM24587a == 0) {
            return 0;
        }
        int iM24587a2 = m24587a(35632, str2);
        if (iM24587a2 == 0) {
            GLES20.glDeleteShader(iM24587a);
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iM24587a);
        GLES20.glAttachShader(iGlCreateProgram, iM24587a2);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            CameraLog.m12967f(OpenGLUtils.TAG, "loadProgram error, " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
            GLES20.glDeleteProgram(iGlCreateProgram);
            return 0;
        }
        GLES20.glDeleteShader(iM24587a);
        GLES20.glDeleteShader(iM24587a2);
        return iGlCreateProgram;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24594a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            CameraLog.m12965d(OpenGLUtils.TAG, "checkGlError, op: " + str + ", glError: 0x" + Integer.toHexString(iGlGetError), new Throwable());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.InputStream] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m24590a(android.content.Context r8, int r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.OpenGLUtils.m24590a(android.content.Context, int):java.lang.String");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static BitmapTexture m24597b(Context context, int OplusGLSurfaceView_13) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), OplusGLSurfaceView_13, options);
        if (bitmapDecodeResource == null) {
            CameraLog.m12967f(OpenGLUtils.TAG, "loadTextureFromDisk: load texture failed from " + OplusGLSurfaceView_13);
            return null;
        }
        return new BitmapTexture(bitmapDecodeResource);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24587a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        CameraLog.m12967f(OpenGLUtils.TAG, "loadShader, Could not compile shader " + OplusGLSurfaceView_13 + ": " + GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m24596b(String str, String str2) {
        int iM24587a = m24587a(35633, str);
        if (iM24587a == 0) {
            m24594a("loadVertexShader");
            return 0;
        }
        int iM24587a2 = m24587a(35632, str2);
        if (iM24587a2 == 0) {
            m24594a("loadFragmentShader");
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            m24594a("glCreateProgram");
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iM24587a);
        m24594a("glAttachVertexShader");
        GLES20.glAttachShader(iGlCreateProgram, iM24587a2);
        m24594a("glAttachFragmentShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (1 == iArr[0]) {
            return iGlCreateProgram;
        }
        CameraLog.m12967f(OpenGLUtils.TAG, "createProgram, Could not link program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m24591a(String str, Resources resources) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamOpen;
        String str2;
        String strReplaceAll = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStreamOpen = resources.getAssets().open(str);
                while (true) {
                    try {
                        int OplusGLSurfaceView_13 = inputStreamOpen.read();
                        if (OplusGLSurfaceView_13 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(OplusGLSurfaceView_13);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            COUIBaseListPopupWindow_8.printStackTrace();
            return strReplaceAll;
        }
        try {
            strReplaceAll = str2.replaceAll("\\r\\OplusGLSurfaceView_11", "\OplusGLSurfaceView_11");
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            strReplaceAll = str2;
            COUIBaseListPopupWindow_8.printStackTrace();
            return strReplaceAll;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            }
            throw th;
        }
        return strReplaceAll;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24595a(int[] iArr, int[] iArr2, int OplusGLSurfaceView_13, int i2) {
        GLES31.glGenFramebuffers(iArr.length, iArr, 0);
        GLES31.glGenTextures(iArr2.length, iArr2, 0);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            GLES31.glBindTexture(3553, iArr2[i3]);
            GLES31.glTexStorage2D(3553, 1, 32856, OplusGLSurfaceView_13, i2);
            GLES31.glTexParameterf(3553, 10240, 9729.0f);
            GLES31.glTexParameterf(3553, 10241, 9729.0f);
            GLES31.glTexParameterf(3553, 10242, 33071.0f);
            GLES31.glTexParameterf(3553, 10243, 33071.0f);
            GLES31.glBindFramebuffer(36160, iArr[i3]);
            GLES31.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i3], 0);
            GLES31.glBindTexture(3553, 0);
            GLES31.glBindFramebuffer(36160, 0);
        }
        m24594a("createStorageFrameBuffer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static FloatBuffer m24592a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
