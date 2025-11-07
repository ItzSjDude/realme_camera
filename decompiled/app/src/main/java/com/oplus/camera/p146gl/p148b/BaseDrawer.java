package com.oplus.camera.p146gl.p148b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import com.oplus.camera.CameraLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: BaseDrawer.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BaseDrawer {

    /* renamed from: PlatformImplementations.kt_3 */
    protected int f13919a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f13920b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f13921c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f13922d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f13923e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f13924f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected float[] f13925g = {0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected float[] f13926h = {0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m13871a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES32.glCreateShader(OplusGLSurfaceView_13);
        if (iGlCreateShader == 0) {
            throw new RuntimeException("loadShader Failed!" + GLES32.glGetError());
        }
        GLES32.glShaderSource(iGlCreateShader, str);
        GLES32.glCompileShader(iGlCreateShader);
        return iGlCreateShader;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13868a() {
        int iGlGetError = GLES32.glGetError();
        if (iGlGetError != 0) {
            CameraLog.m12965d("BaseDrawer", "checkGlError, error: " + iGlGetError, new Throwable());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m13870a(int OplusGLSurfaceView_13, int i2) {
        int iGlCreateProgram = GLES32.glCreateProgram();
        if (iGlCreateProgram == 0) {
            throw new RuntimeException("linkProgram Failed!" + GLES32.glGetError());
        }
        GLES32.glAttachShader(iGlCreateProgram, OplusGLSurfaceView_13);
        GLES32.glAttachShader(iGlCreateProgram, i2);
        GLES32.glLinkProgram(iGlCreateProgram);
        m13868a();
        return iGlCreateProgram;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13869a(int[] iArr, int[] iArr2, int OplusGLSurfaceView_13, int i2) {
        GLES20.glGenFramebuffers(iArr.length, iArr, 0);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            GLES20.glBindTexture(3553, iArr2[i3]);
            GLES20.glTexImage2D(3553, 0, 6408, OplusGLSurfaceView_13, i2, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, iArr[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected FloatBuffer m13872a(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return floatBufferAsFloatBuffer;
    }
}
