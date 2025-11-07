package androidx.c_renamed;

/* compiled from: Texture2dProgram.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final float[] f688a = new float[16];

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final float[] f689b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f690c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;

    static {
        android.opengl.Matrix.setIdentityM(f688a, 0);
        f689b = new float[16];
        android.opengl.Matrix.setIdentityM(f689b, 0);
        android.opengl.Matrix.translateM(f689b, 0, 0.0f, 1.0f, 0.0f);
        android.opengl.Matrix.scaleM(f689b, 0, 1.0f, -1.0f, 1.0f);
    }

    public e_renamed(int i_renamed) {
        this.f690c = i_renamed;
        if (i_renamed == 0) {
            this.i_renamed = 3553;
            this.d_renamed = a_renamed("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed    gl_Position = uMVPMatrix * aPosition;\n_renamed    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n_renamed}\n_renamed", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n_renamed    gl_FragColor = texture2D(sTexture, vTextureCoord);\n_renamed}\n_renamed");
        } else if (i_renamed == 1) {
            this.i_renamed = 36197;
            this.d_renamed = a_renamed("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed    gl_Position = uMVPMatrix * aPosition;\n_renamed    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n_renamed}\n_renamed", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n_renamed    gl_FragColor = texture2D(sTexture, vTextureCoord);\n_renamed}\n_renamed");
        } else {
            throw new java.lang.RuntimeException("Unhandled type " + i_renamed);
        }
        int i2 = this.d_renamed;
        if (i2 == 0) {
            throw new java.lang.RuntimeException("Unable to create program");
        }
        this.g_renamed = android.opengl.GLES20.glGetAttribLocation(i2, "aPosition");
        b_renamed(this.g_renamed, "aPosition");
        this.h_renamed = android.opengl.GLES20.glGetAttribLocation(this.d_renamed, "aTextureCoord");
        b_renamed(this.h_renamed, "aTextureCoord");
        this.e_renamed = android.opengl.GLES20.glGetUniformLocation(this.d_renamed, "uMVPMatrix");
        b_renamed(this.e_renamed, "uMVPMatrix");
        this.f_renamed = android.opengl.GLES20.glGetUniformLocation(this.d_renamed, "uTexMatrix");
        b_renamed(this.f_renamed, "uTexMatrix");
    }

    public void a_renamed() {
        android.util.Log.d_renamed("Texture2dProgram", "deleting program " + this.d_renamed);
        android.opengl.GLES20.glDeleteProgram(this.d_renamed);
        this.d_renamed = -1;
    }

    public int b_renamed() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        a_renamed("glGenTextures");
        int i_renamed = iArr[0];
        android.opengl.GLES20.glBindTexture(this.i_renamed, i_renamed);
        a_renamed("glBindTexture " + i_renamed);
        android.opengl.GLES20.glTexParameterf(this.i_renamed, 10241, 9728.0f);
        int i2 = this.i_renamed;
        android.opengl.GLES20.glTexParameterf(i2, 10240, i2 != 3553 ? 9729.0f : 9728.0f);
        android.opengl.GLES20.glTexParameteri(this.i_renamed, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(this.i_renamed, 10243, 33071);
        a_renamed("glTexParameter");
        return i_renamed;
    }

    public void a_renamed(int i_renamed, android.graphics.Bitmap bitmap) {
        android.opengl.GLES20.glBindTexture(this.i_renamed, i_renamed);
        android.opengl.GLUtils.texImage2D(this.i_renamed, 0, bitmap, 0);
    }

    public void a_renamed(float[] fArr, java.nio.FloatBuffer floatBuffer, int i_renamed, int i2, int i3, int i4, float[] fArr2, java.nio.FloatBuffer floatBuffer2, int i5, int i6) {
        a_renamed("draw start");
        android.opengl.GLES20.glUseProgram(this.d_renamed);
        a_renamed("glUseProgram");
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(this.i_renamed, i5);
        android.opengl.GLES20.glUniformMatrix4fv(this.e_renamed, 1, false, fArr, 0);
        a_renamed("glUniformMatrix4fv");
        android.opengl.GLES20.glUniformMatrix4fv(this.f_renamed, 1, false, fArr2, 0);
        a_renamed("glUniformMatrix4fv");
        android.opengl.GLES20.glEnableVertexAttribArray(this.g_renamed);
        a_renamed("glEnableVertexAttribArray");
        android.opengl.GLES20.glVertexAttribPointer(this.g_renamed, i3, 5126, false, i4, (java.nio.Buffer) floatBuffer);
        a_renamed("glVertexAttribPointer");
        android.opengl.GLES20.glEnableVertexAttribArray(this.h_renamed);
        a_renamed("glEnableVertexAttribArray");
        android.opengl.GLES20.glVertexAttribPointer(this.h_renamed, 2, 5126, false, i6, (java.nio.Buffer) floatBuffer2);
        a_renamed("glVertexAttribPointer");
        android.opengl.GLES20.glDrawArrays(5, i_renamed, i2);
        a_renamed("glDrawArrays");
        android.opengl.GLES20.glDisableVertexAttribArray(this.g_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.h_renamed);
        android.opengl.GLES20.glBindTexture(this.i_renamed, 0);
        android.opengl.GLES20.glUseProgram(0);
    }

    public static int a_renamed(java.lang.String str, java.lang.String str2) {
        int iA;
        int iA2 = a_renamed(35633, str);
        if (iA2 == 0 || (iA = a_renamed(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        a_renamed("glCreateProgram");
        if (iGlCreateProgram == 0) {
            android.util.Log.e_renamed("Texture2dProgram", "Could not create program");
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA2);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        android.util.Log.e_renamed("Texture2dProgram", "Could not link program: ");
        android.util.Log.e_renamed("Texture2dProgram", android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
        android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static int a_renamed(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
        a_renamed("glCreateShader type=" + i_renamed);
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        android.util.Log.e_renamed("Texture2dProgram", "Could not compile shader " + i_renamed + ":");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" ");
        sb.append(android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader));
        android.util.Log.e_renamed("Texture2dProgram", sb.toString());
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void b_renamed(int i_renamed, java.lang.String str) {
        if (i_renamed >= 0) {
            return;
        }
        throw new java.lang.RuntimeException("Unable to locate '" + str + "' in_renamed program");
    }

    public static void a_renamed(java.lang.String str) {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError == 1285) {
            android.util.Log.i_renamed("Texture2dProgram", str + " GL_OUT_OF_MEMORY");
        }
        if (iGlGetError == 0 || iGlGetError == 1285) {
            return;
        }
        java.lang.String str2 = str + ": glError 0x" + java.lang.Integer.toHexString(iGlGetError);
        android.util.Log.e_renamed("Texture2dProgram", str2);
        throw new java.lang.RuntimeException(str2);
    }
}
