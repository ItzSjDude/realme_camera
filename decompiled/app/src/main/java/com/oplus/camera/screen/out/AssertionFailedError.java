package com.oplus.camera.screen.out;

/* compiled from: GLES20Drawer.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected java.nio.FloatBuffer f5384a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.nio.FloatBuffer f5385b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int[] f5386c;
    protected int[] d_renamed;
    private java.lang.String e_renamed;
    private java.lang.String f_renamed;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;

    public b_renamed(android.content.Context context, int i_renamed) {
        this.f5384a = null;
        this.f5385b = null;
        this.f5386c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.f5386c = new int[i_renamed];
        this.d_renamed = new int[i_renamed];
        float[] fArr = new float[com.oplus.camera.screen.out.g_renamed.f5404b.length];
        a_renamed(com.oplus.camera.screen.out.g_renamed.f5404b, fArr);
        this.f5384a = a_renamed(fArr);
        float[] fArr2 = new float[com.oplus.camera.screen.out.g_renamed.f5403a.length];
        a_renamed(com.oplus.camera.screen.out.g_renamed.f5403a, fArr2);
        this.f5385b = a_renamed(fArr2);
        this.e_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.fragment_shader_common));
        this.f_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.vertex_shader_common));
    }

    protected void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        if (this.g_renamed == 0) {
            this.g_renamed = a_renamed(this.f_renamed, this.e_renamed);
            this.h_renamed = android.opengl.GLES20.glGetAttribLocation(this.g_renamed, "aPosition");
            this.i_renamed = android.opengl.GLES20.glGetAttribLocation(this.g_renamed, "aTextureCoord");
        }
    }

    protected void a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUseProgram(this.g_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.h_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.f5385b);
        android.opengl.GLES20.glEnableVertexAttribArray(this.h_renamed);
        int i2 = this.i_renamed;
        if (floatBuffer == null) {
            floatBuffer = this.f5384a;
        }
        android.opengl.GLES20.glVertexAttribPointer(i2, 2, 5126, false, 8, (java.nio.Buffer) floatBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(this.i_renamed);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
    }

    public void b_renamed() {
        int[] iArr = this.f5386c;
        android.opengl.GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    protected void b_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttribPointer(i_renamed, 2, 5126, false, 8, (java.nio.Buffer) floatBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
    }

    protected void c_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttribPointer(i_renamed, 2, 5126, false, 8, (java.nio.Buffer) floatBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
    }

    protected java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    public static int a_renamed(java.lang.String str, java.lang.String str2) {
        int iA = a_renamed(35633, str);
        if (iA == 0) {
            com.oplus.camera.e_renamed.f_renamed("GLES20Drawer", "load vertex shader error");
        }
        int iA2 = a_renamed(35632, str2);
        if (iA2 == 0) {
            com.oplus.camera.e_renamed.f_renamed("GLES20Drawer", "load fragment shader error");
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        a_renamed("glCreateProgram");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA2);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (1 == iArr[0]) {
            return iGlCreateProgram;
        }
        android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    private static int a_renamed(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
        a_renamed("glCreateShader type = " + i_renamed);
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void a_renamed(java.lang.String str) {
        for (int iGlGetError = android.opengl.GLES20.glGetError(); iGlGetError != 0; iGlGetError = android.opengl.GLES20.glGetError()) {
            com.oplus.camera.e_renamed.f_renamed("GLES20Drawer", str + ": glError " + iGlGetError);
        }
    }

    public static java.lang.String a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i_renamed = inputStream.read(bArr);
                        if (-1 == i_renamed) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i_renamed);
                    } catch (java.io.IOException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (java.lang.Throwable th) {
                try {
                    inputStream.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    public static float[] a_renamed(float[] fArr, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = new float[fArr.length];
        }
        java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        return fArr2;
    }
}
