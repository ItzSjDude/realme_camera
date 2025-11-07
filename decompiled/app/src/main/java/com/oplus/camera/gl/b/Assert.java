package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: BaseDrawer.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected int f4599a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f4600b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f4601c = 0;
    protected int d_renamed = 0;
    protected int e_renamed = 0;
    protected int f_renamed = 0;
    protected float[] g_renamed = {0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    protected float[] h_renamed = {0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    protected int a_renamed(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES32.glCreateShader(i_renamed);
        if (iGlCreateShader == 0) {
            throw new java.lang.RuntimeException("loadShader Failed!" + android.opengl.GLES32.glGetError());
        }
        android.opengl.GLES32.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES32.glCompileShader(iGlCreateShader);
        return iGlCreateShader;
    }

    public static void a_renamed() {
        int iGlGetError = android.opengl.GLES32.glGetError();
        if (iGlGetError != 0) {
            com.oplus.camera.e_renamed.d_renamed("BaseDrawer", "checkGlError, error: " + iGlGetError, new java.lang.Throwable());
        }
    }

    protected int a_renamed(int i_renamed, int i2) {
        int iGlCreateProgram = android.opengl.GLES32.glCreateProgram();
        if (iGlCreateProgram == 0) {
            throw new java.lang.RuntimeException("linkProgram Failed!" + android.opengl.GLES32.glGetError());
        }
        android.opengl.GLES32.glAttachShader(iGlCreateProgram, i_renamed);
        android.opengl.GLES32.glAttachShader(iGlCreateProgram, i2);
        android.opengl.GLES32.glLinkProgram(iGlCreateProgram);
        a_renamed();
        return iGlCreateProgram;
    }

    public static void a_renamed(int[] iArr, int[] iArr2, int i_renamed, int i2) {
        android.opengl.GLES20.glGenFramebuffers(iArr.length, iArr, 0);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            android.opengl.GLES20.glBindTexture(3553, iArr2[i3]);
            android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i_renamed, i2, 0, 6408, 5121, null);
            android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10241, 9728.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLES20.glBindFramebuffer(36160, iArr[i3]);
            android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i3], 0);
            android.opengl.GLES20.glBindTexture(3553, 0);
            android.opengl.GLES20.glBindFramebuffer(36160, 0);
        }
    }

    protected java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return floatBufferAsFloatBuffer;
    }
}
