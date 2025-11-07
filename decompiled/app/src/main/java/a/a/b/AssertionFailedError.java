package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class b_renamed {
    public int e_renamed;
    public int g_renamed;
    public int h_renamed;
    public int i_renamed;
    public int j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public final float[] f12a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: c_renamed, reason: collision with root package name */
    public float[] f14c = new float[16];
    public float[] d_renamed = new float[16];
    public int f_renamed = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.nio.FloatBuffer f13b = java.nio.ByteBuffer.allocateDirect(this.f12a.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();

    public b_renamed() {
        this.f13b.put(this.f12a).position(0);
        android.opengl.Matrix.setIdentityM(this.d_renamed, 0);
    }

    public final int a_renamed(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
        a_renamed("glCreateShader type=" + i_renamed);
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        android.util.Log.e_renamed("TextureRender", "Could not compile shader " + i_renamed + ":");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" ");
        sb.append(android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader));
        android.util.Log.e_renamed("TextureRender", sb.toString());
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public final int a_renamed(java.lang.String str, java.lang.String str2) {
        int iA;
        int iA2 = a_renamed(35633, str);
        int i_renamed = 0;
        if (iA2 == 0 || (iA = a_renamed(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        a_renamed("glCreateProgram");
        if (iGlCreateProgram == 0) {
            android.util.Log.e_renamed("TextureRender", "Could not create program");
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA2);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA);
        a_renamed("glAttachShader");
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            android.util.Log.e_renamed("TextureRender", "Could not link program: ");
            android.util.Log.e_renamed("TextureRender", android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
            android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
        } else {
            i_renamed = iGlCreateProgram;
        }
        if (i_renamed != 0) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed(i_renamed);
        }
        return i_renamed;
    }

    public void a_renamed() {
        this.e_renamed = a_renamed("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed  gl_Position = uMVPMatrix * aPosition;\n_renamed  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n_renamed}\n_renamed", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n_renamed  gl_FragColor = texture2D(sTexture, vTextureCoord);\n_renamed}\n_renamed");
        int i_renamed = this.e_renamed;
        if (i_renamed == 0) {
            throw new java.lang.RuntimeException("failed creating program");
        }
        this.i_renamed = android.opengl.GLES20.glGetAttribLocation(i_renamed, "aPosition");
        a_renamed("glGetAttribLocation aPosition");
        if (this.i_renamed == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for aPosition");
        }
        this.j_renamed = android.opengl.GLES20.glGetAttribLocation(this.e_renamed, "aTextureCoord");
        a_renamed("glGetAttribLocation aTextureCoord");
        if (this.j_renamed == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.g_renamed = android.opengl.GLES20.glGetUniformLocation(this.e_renamed, "uMVPMatrix");
        a_renamed("glGetUniformLocation uMVPMatrix");
        if (this.g_renamed == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.h_renamed = android.opengl.GLES20.glGetUniformLocation(this.e_renamed, "uSTMatrix");
        a_renamed("glGetUniformLocation uSTMatrix");
        if (this.h_renamed == -1) {
            throw new java.lang.RuntimeException("Could not get attrib location for uSTMatrix");
        }
        android.opengl.Matrix.setIdentityM(this.f14c, 0);
        android.opengl.Matrix.scaleM(this.f14c, 0, -1.0f, -1.0f, 1.0f);
    }

    public void a_renamed(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public void a_renamed(android.graphics.SurfaceTexture surfaceTexture, float[] fArr) {
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(this.d_renamed);
        }
        android.opengl.GLES20.glUseProgram(this.e_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, this.f_renamed);
        this.f13b.position(0);
        android.opengl.GLES20.glVertexAttribPointer(this.i_renamed, 3, 5126, false, 20, (java.nio.Buffer) this.f13b);
        android.opengl.GLES20.glEnableVertexAttribArray(this.i_renamed);
        this.f13b.position(3);
        android.opengl.GLES20.glVertexAttribPointer(this.j_renamed, 2, 5126, false, 20, (java.nio.Buffer) this.f13b);
        android.opengl.GLES20.glEnableVertexAttribArray(this.j_renamed);
        if (fArr != null) {
            android.opengl.Matrix.setIdentityM(this.f14c, 0);
            android.opengl.Matrix.scaleM(this.f14c, 0, -1.0f, -1.0f, 1.0f);
            float[] fArr2 = this.f14c;
            android.opengl.Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        }
        android.opengl.GLES20.glUniformMatrix4fv(this.g_renamed, 1, false, this.f14c, 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.h_renamed, 1, false, this.d_renamed, 0);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
    }

    public void a_renamed(java.lang.String str) {
        while (true) {
            int iGlGetError = android.opengl.GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            android.util.Log.e_renamed("TextureRender", str + ": glError " + iGlGetError);
        }
    }
}
