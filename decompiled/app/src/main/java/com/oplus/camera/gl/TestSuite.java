package com.oplus.camera.gl_renamed;

/* compiled from: GLES20Canvas.java */
/* loaded from: classes2.dex */
public class i_renamed implements com.oplus.camera.gl_renamed.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4617a = "i_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f4618b = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final float[] f4619c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final com.oplus.camera.gl_renamed.k_renamed i_renamed = new com.oplus.camera.gl_renamed.j_renamed();
    private int G_renamed;
    private int H_renamed;
    private int J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private int N_renamed;
    private int O_renamed;
    private int P_renamed;
    private int Q_renamed;
    private int R_renamed;
    private com.oplus.camera.gl_renamed.d_renamed t_renamed;
    private final int d_renamed = 3;
    private final int e_renamed = 4;
    private final int f_renamed = 5;
    private final int g_renamed = 6;
    private final int h_renamed = 7;
    private final float[] j_renamed = new float[4];
    private final com.oplus.camera.gl_renamed.o_renamed k_renamed = new com.oplus.camera.gl_renamed.o_renamed();
    private final com.oplus.camera.gl_renamed.o_renamed l_renamed = new com.oplus.camera.gl_renamed.o_renamed();
    private final float[] m_renamed = new float[32];
    private final float[] n_renamed = new float[4];
    private final android.graphics.RectF o_renamed = new android.graphics.RectF();
    private final android.graphics.RectF p_renamed = new android.graphics.RectF();
    private final android.graphics.Rect q_renamed = new android.graphics.Rect();
    private final float[] r_renamed = new float[16];
    private final int[] s_renamed = new int[1];
    private boolean u_renamed = false;
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] v_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uColor")};
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] w_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureSampler"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uAlpha")};
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] x_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureSampler"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uAlpha")};
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] y_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureSampler"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uAlpha"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTexLut")};
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] z_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aTextureCoordinate"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureSampler"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uAlpha")};
    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] A_renamed = {new com.oplus.camera.gl_renamed.i_renamed.a_renamed("aPosition"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uTextureMatrix"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uAlpha"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uBlendingAlpha1"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uBlendingAlpha2"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uBlendingTexture1"), new com.oplus.camera.gl_renamed.i_renamed.c_renamed("uBlendingTexture2")};
    private float[] B_renamed = new float[128];
    private float[] C_renamed = new float[8];
    private com.oplus.camera.gl_renamed.o_renamed D_renamed = new com.oplus.camera.gl_renamed.o_renamed();
    private int E_renamed = 0;
    private int F_renamed = 0;
    private float[] I_renamed = new float[16];
    private int S_renamed = 0;
    private int T_renamed = 0;
    private int U_renamed = 0;
    private int V_renamed = 0;
    private int[] W_renamed = new int[1];
    private java.util.ArrayList<com.oplus.camera.gl_renamed.s_renamed> X_renamed = new java.util.ArrayList<>();

    public i_renamed() {
        this.t_renamed = null;
        android.opengl.Matrix.setIdentityM(this.r_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.B_renamed, this.F_renamed);
        this.C_renamed[this.E_renamed] = 1.0f;
        this.X_renamed.add(null);
        this.R_renamed = a_renamed(b_renamed(f4618b));
        int iA = a_renamed(35633, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.draw_vertex_shader));
        int iA2 = a_renamed(35633, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.texture_vertex_shader));
        int iA3 = a_renamed(35633, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.mesh_vertex_shader));
        int iA4 = a_renamed(35632, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.draw_fragment_shader));
        int iA5 = a_renamed(35632, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.texture_fragment_shader));
        int iA6 = a_renamed(35632, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.oes_texture_fragment_shader));
        int iA7 = a_renamed(35632, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.oes_lut_texture_fragment_shader));
        int iA8 = a_renamed(35632, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.texture_blending_fragment_shader));
        this.L_renamed = a_renamed(iA, iA4, this.v_renamed);
        this.M_renamed = a_renamed(iA2, iA5, this.w_renamed);
        this.N_renamed = a_renamed(iA2, iA6, this.x_renamed);
        this.O_renamed = a_renamed(iA2, iA7, this.y_renamed);
        this.P_renamed = a_renamed(iA3, iA5, this.z_renamed);
        this.Q_renamed = a_renamed(iA2, iA8, this.A_renamed);
        android.opengl.GLES20.glBlendFunc(1, 771);
        i_renamed();
        if (this.t_renamed == null) {
            this.t_renamed = com.oplus.camera.util.k_renamed.b_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.R_renamed.raw.hlg_to_srgb_v8_1);
        }
    }

    private static java.nio.FloatBuffer b_renamed(float[] fArr) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return floatBufferAsFloatBuffer;
    }

    private static int a_renamed(int i2, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i2);
        i_renamed();
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        i_renamed();
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        i_renamed();
        return iGlCreateShader;
    }

    private static void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, android.graphics.RectF rectF) {
        int iF = cVar.f_renamed();
        int iG = cVar.g_renamed();
        int i2 = 1;
        int i3 = 0;
        if (cVar.l_renamed()) {
            iF--;
            iG--;
            i3 = 1;
        } else {
            i2 = 0;
        }
        rectF.set(i2, i3, iF, iG);
    }

    private static void a_renamed(android.graphics.RectF rectF, android.graphics.RectF rectF2, com.oplus.camera.gl_renamed.c_renamed cVar) {
        int iF = cVar.f_renamed();
        int iG = cVar.g_renamed();
        int iH = cVar.h_renamed();
        int i2 = cVar.i_renamed();
        float f_renamed = iH;
        rectF.left /= f_renamed;
        rectF.right /= f_renamed;
        float f2 = i2;
        rectF.top /= f2;
        rectF.bottom /= f2;
        float f3 = iF / f_renamed;
        if (rectF.right > f3) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f3 - rectF.left)) / rectF.width());
            rectF.right = f3;
        }
        float f4 = iG / f2;
        if (rectF.bottom > f4) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f4 - rectF.top)) / rectF.height());
            rectF.bottom = f4;
        }
    }

    private static void j_renamed() {
        java.lang.String str;
        int iGlCheckFramebufferStatus = android.opengl.GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus != 36053) {
            switch (iGlCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    str = "";
                    break;
            }
            throw new java.lang.RuntimeException(str + ":" + java.lang.Integer.toHexString(iGlCheckFramebufferStatus));
        }
    }

    public static void i_renamed() {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError != 0) {
            java.lang.Throwable th = new java.lang.Throwable();
            com.oplus.camera.e_renamed.d_renamed(f4617a, "GL error: " + iGlGetError, th);
        }
    }

    private int a_renamed(int i2, int i3, com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr) {
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        i_renamed();
        if (iGlCreateProgram == 0) {
            throw new java.lang.RuntimeException("Cannot create GL program: " + android.opengl.GLES20.glGetError());
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, i2);
        i_renamed();
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, i3);
        i_renamed();
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        i_renamed();
        int[] iArr = this.s_renamed;
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        i_renamed();
        if (iArr[0] != 1) {
            com.oplus.camera.e_renamed.f_renamed(f4617a, "Could not link program: " + android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
            i_renamed();
            android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
            i_renamed();
            iGlCreateProgram = 0;
        }
        for (com.oplus.camera.gl_renamed.i_renamed.b_renamed bVar : bVarArr) {
            bVar.a_renamed(iGlCreateProgram);
        }
        return iGlCreateProgram;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(int i2, int i3) {
        this.G_renamed = i2;
        this.H_renamed = i3;
        android.opengl.GLES20.glViewport(0, 0, this.G_renamed, this.H_renamed);
        i_renamed();
        android.opengl.Matrix.setIdentityM(this.B_renamed, this.F_renamed);
        float f_renamed = i3;
        android.opengl.Matrix.orthoM(this.I_renamed, 0, 0.0f, i2, 0.0f, f_renamed, -1.0f, 1.0f);
        if (l_renamed() == null) {
            this.J_renamed = i2;
            this.K_renamed = i3;
            android.opengl.Matrix.translateM(this.B_renamed, this.F_renamed, 0.0f, f_renamed, 0.0f);
            android.opengl.Matrix.scaleM(this.B_renamed, this.F_renamed, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float[] fArr) {
        android.opengl.GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        i_renamed();
        android.opengl.GLES20.glClear(16384);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public float b_renamed() {
        return this.C_renamed[this.E_renamed];
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed) {
        this.C_renamed[this.E_renamed] = f_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(boolean z_renamed) {
        this.u_renamed = z_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2) {
        int i2 = this.F_renamed;
        float[] fArr = this.B_renamed;
        int i3 = i2 + 12;
        fArr[i3] = fArr[i3] + (fArr[i2 + 0] * f_renamed) + (fArr[i2 + 4] * f2);
        int i4 = i2 + 13;
        fArr[i4] = fArr[i4] + (fArr[i2 + 1] * f_renamed) + (fArr[i2 + 5] * f2);
        int i5 = i2 + 14;
        fArr[i5] = fArr[i5] + (fArr[i2 + 2] * f_renamed) + (fArr[i2 + 6] * f2);
        int i6 = i2 + 15;
        fArr[i6] = fArr[i6] + (fArr[i2 + 3] * f_renamed) + (fArr[i2 + 7] * f2);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2, float f3) {
        android.opengl.Matrix.scaleM(this.B_renamed, this.F_renamed, f_renamed, f2, f3);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4) {
        if (f_renamed == 0.0f) {
            return;
        }
        float[] fArr = this.m_renamed;
        android.opengl.Matrix.setRotateM(fArr, 0, f_renamed, f2, f3, f4);
        float[] fArr2 = this.B_renamed;
        int i2 = this.F_renamed;
        android.opengl.Matrix.multiplyMM(fArr, 16, fArr2, i2, fArr, 0);
        java.lang.System.arraycopy(fArr, 16, fArr2, i2, 16);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void c_renamed() {
        a_renamed(-1);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(int i2) {
        if ((i2 & 1) == 1) {
            float fB_renamed = b_renamed();
            this.E_renamed++;
            float[] fArr = this.C_renamed;
            if (fArr.length <= this.E_renamed) {
                this.C_renamed = java.util.Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.C_renamed[this.E_renamed] = fB_renamed;
        }
        if ((i2 & 2) == 2) {
            int i3 = this.F_renamed;
            this.F_renamed = i3 + 16;
            float[] fArr2 = this.B_renamed;
            if (fArr2.length <= this.F_renamed) {
                this.B_renamed = java.util.Arrays.copyOf(fArr2, fArr2.length * 2);
            }
            float[] fArr3 = this.B_renamed;
            java.lang.System.arraycopy(fArr3, i3, fArr3, this.F_renamed, 16);
        }
        this.D_renamed.a_renamed(i2);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void f_renamed() {
        int iA = this.D_renamed.a_renamed();
        if ((iA & 1) == 1) {
            this.E_renamed--;
        }
        if ((iA & 2) == 2) {
            this.F_renamed -= 16;
        }
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4, com.oplus.camera.gl_renamed.l_renamed lVar) {
        a_renamed(3, 4, 2, f_renamed, f2, f3 - f_renamed, f4 - f2, lVar);
        this.V_renamed++;
    }

    private void a_renamed(int i2, int i3, int i4, float f_renamed, float f2, float f3, float f4, com.oplus.camera.gl_renamed.l_renamed lVar) {
        a_renamed(i2, i3, i4, f_renamed, f2, f3, f4, lVar.a_renamed(), lVar.b_renamed());
    }

    private void a_renamed(int i2, int i3, int i4, float f_renamed, float f2, float f3, float f4, int i5, float f5) {
        a_renamed(i3, i5, f5);
        a_renamed(this.v_renamed, i2, i4, f_renamed, f2, f3, f4);
    }

    private void a_renamed(int i2, int i3, float f_renamed) {
        android.opengl.GLES20.glUseProgram(this.L_renamed);
        i_renamed();
        if (f_renamed > 0.0f) {
            android.opengl.GLES20.glLineWidth(f_renamed);
            i_renamed();
        }
        float[] fArrB = b_renamed(i3);
        boolean z_renamed = fArrB[3] < 1.0f;
        b_renamed(z_renamed);
        if (z_renamed) {
            android.opengl.GLES20.glBlendColor(fArrB[0], fArrB[1], fArrB[2], fArrB[3]);
            i_renamed();
        }
        android.opengl.GLES20.glUniform4fv(this.v_renamed[2].f4620a, 1, fArrB, 0);
        a_renamed(this.v_renamed, i2);
        i_renamed();
    }

    private float[] b_renamed(int i2) {
        float fB_renamed = (((i2 >>> 24) & 255) / 255.0f) * b_renamed();
        float[] fArr = this.n_renamed;
        fArr[0] = (((i2 >>> 16) & 255) / 255.0f) * fB_renamed;
        fArr[1] = (((i2 >>> 8) & 255) / 255.0f) * fB_renamed;
        fArr[2] = ((i2 & 255) / 255.0f) * fB_renamed;
        fArr[3] = fB_renamed;
        return fArr;
    }

    private void b_renamed(boolean z_renamed) {
        if (z_renamed) {
            android.opengl.GLES20.glEnable(3042);
            i_renamed();
        } else {
            android.opengl.GLES20.glDisable(3042);
            i_renamed();
        }
    }

    private void a_renamed(com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr, int i2) {
        android.opengl.GLES20.glBindBuffer(34962, this.R_renamed);
        i_renamed();
        android.opengl.GLES20.glVertexAttribPointer(bVarArr[0].f4620a, 2, 5126, false, 8, i2 * 8);
        i_renamed();
        android.opengl.GLES20.glBindBuffer(34962, 0);
        i_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr, int i2, int i3, float f_renamed, float f2, float f3, float f4) {
        a_renamed(bVarArr, f_renamed, f2, f3, f4);
        int i4 = bVarArr[0].f4620a;
        android.opengl.GLES20.glEnableVertexAttribArray(i4);
        i_renamed();
        android.opengl.GLES20.glDrawArrays(i2, 0, i3);
        i_renamed();
        android.opengl.GLES20.glDisableVertexAttribArray(i4);
        i_renamed();
    }

    private void a_renamed(com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr, float f_renamed, float f2, float f3, float f4) {
        android.opengl.Matrix.translateM(this.m_renamed, 0, this.B_renamed, this.F_renamed, f_renamed, f2, 0.0f);
        android.opengl.Matrix.scaleM(this.m_renamed, 0, f3, f4, 1.0f);
        float[] fArr = this.m_renamed;
        android.opengl.Matrix.multiplyMM(fArr, 16, this.I_renamed, 0, fArr, 0);
        android.opengl.GLES20.glUniformMatrix4fv(bVarArr[1].f4620a, 1, false, this.m_renamed, 16);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4, int i2) {
        a_renamed(5, 0, 4, f_renamed, f2, f3, f4, i2, 0.0f);
        this.U_renamed++;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, int i2, int i3, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        a_renamed(cVar, this.o_renamed);
        this.p_renamed.set(i2, i3, i2 + i4, i3 + i5);
        a_renamed(this.o_renamed, this.p_renamed, cVar);
        b_renamed(cVar, this.o_renamed, this.p_renamed);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.o_renamed.set(rectF);
        this.p_renamed.set(rectF2);
        a_renamed(this.o_renamed, this.p_renamed, cVar);
        b_renamed(cVar, this.o_renamed, this.p_renamed);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, float[] fArr, int i2, int i3, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.p_renamed.set(i2, i3, i2 + i4, i3 + i5);
        a_renamed(cVar, fArr, this.p_renamed);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.c_renamed cVar2, float f_renamed, float f2, float[] fArr, int i2, int i3, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.p_renamed.set(i2, i3, i2 + i4, i3 + i5);
        a_renamed(cVar, cVar2, f_renamed, f2, fArr, this.p_renamed);
    }

    private void b_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        a_renamed(rectF);
        a_renamed(cVar, this.r_renamed, rectF2);
    }

    private void a_renamed(android.graphics.RectF rectF) {
        this.r_renamed[0] = rectF.width();
        this.r_renamed[5] = rectF.height();
        this.r_renamed[12] = rectF.left;
        this.r_renamed[13] = rectF.top;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, float[] fArr, android.graphics.RectF rectF) {
        if (cVar == null) {
            return;
        }
        com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArrC = c_renamed(cVar);
        a_renamed(bVarArrC, 0);
        android.opengl.GLES20.glUniformMatrix4fv(bVarArrC[2].f4620a, 1, false, fArr, 0);
        i_renamed();
        if (cVar.d_renamed()) {
            a_renamed(2);
            a_renamed(0.0f, rectF.centerY());
            a_renamed(1.0f, -1.0f, 1.0f);
            a_renamed(0.0f, -rectF.centerY());
        }
        a_renamed(bVarArrC, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (cVar.d_renamed()) {
            f_renamed();
        }
        this.T_renamed++;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.c_renamed cVar2, float f_renamed, float f2, float[] fArr, android.graphics.RectF rectF) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr = this.A_renamed;
        int i2 = this.Q_renamed;
        android.opengl.GLES20.glViewport(0, 0, this.G_renamed, this.H_renamed);
        i_renamed();
        android.opengl.GLES20.glUseProgram(i2);
        i_renamed();
        b_renamed(!cVar.r_renamed() || b_renamed() < 0.95f);
        android.opengl.GLES20.glActiveTexture(33984);
        i_renamed();
        cVar.b_renamed(this);
        android.opengl.GLES20.glBindTexture(cVar.m_renamed(), cVar.e_renamed());
        i_renamed();
        android.opengl.GLES20.glUniform1i(bVarArr[6].f4620a, 0);
        i_renamed();
        android.opengl.GLES20.glActiveTexture(33985);
        i_renamed();
        cVar2.b_renamed(this);
        android.opengl.GLES20.glBindTexture(cVar2.m_renamed(), cVar2.e_renamed());
        i_renamed();
        android.opengl.GLES20.glUniform1i(bVarArr[7].f4620a, 1);
        i_renamed();
        android.opengl.GLES20.glUniform1f(bVarArr[3].f4620a, b_renamed());
        i_renamed();
        android.opengl.GLES20.glUniform1f(bVarArr[4].f4620a, f_renamed);
        i_renamed();
        android.opengl.GLES20.glUniform1f(bVarArr[5].f4620a, f2);
        i_renamed();
        a_renamed(bVarArr, 0);
        android.opengl.GLES20.glUniformMatrix4fv(bVarArr[2].f4620a, 1, false, fArr, 0);
        i_renamed();
        if (cVar.d_renamed()) {
            a_renamed(2);
            a_renamed(0.0f, rectF.centerY());
            a_renamed(1.0f, -1.0f, 1.0f);
            a_renamed(0.0f, -rectF.centerY());
        }
        a_renamed(bVarArr, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (cVar.d_renamed()) {
            f_renamed();
        }
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, 0);
        i_renamed();
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, 0);
        i_renamed();
        android.opengl.GLES20.glUseProgram(0);
        i_renamed();
        this.T_renamed++;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, float[] fArr, int i2, int i3, int i4, int i5, boolean z_renamed) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        this.q_renamed.set(i2, i3, i4 + i2, i5 + i3);
        a_renamed(cVar, fArr, this.q_renamed, z_renamed);
    }

    private void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, float[] fArr, android.graphics.Rect rect, boolean z_renamed) {
        com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArrC = c_renamed(cVar);
        a_renamed(bVarArrC, 0);
        if (z_renamed) {
            android.opengl.GLES20.glEnable(3089);
        }
        android.opengl.GLES20.glUniformMatrix4fv(bVarArrC[2].f4620a, 1, false, fArr, 0);
        i_renamed();
        if (cVar.d_renamed()) {
            a_renamed(2);
            a_renamed(0.0f, rect.centerY());
            a_renamed(1.0f, -1.0f, 1.0f);
            a_renamed(0.0f, -rect.centerY());
        }
        android.opengl.GLES20.glScissor(rect.left, (this.H_renamed - rect.height()) - rect.top, rect.width(), rect.height());
        a_renamed(bVarArrC, 5, 4, rect.left, rect.top, rect.width(), rect.height());
        if (cVar.d_renamed()) {
            f_renamed();
        }
        this.T_renamed++;
        android.opengl.GLES20.glDisable(3089);
    }

    private com.oplus.camera.gl_renamed.i_renamed.b_renamed[] c_renamed(com.oplus.camera.gl_renamed.c_renamed cVar) {
        com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr;
        int i2;
        if (cVar.m_renamed() == 3553) {
            bVarArr = this.w_renamed;
            i2 = this.M_renamed;
        } else if (k_renamed()) {
            bVarArr = this.y_renamed;
            i2 = this.O_renamed;
        } else {
            bVarArr = this.x_renamed;
            i2 = this.N_renamed;
        }
        a_renamed(cVar, i2, bVarArr);
        return bVarArr;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, int i2, com.oplus.camera.gl_renamed.i_renamed.b_renamed[] bVarArr) {
        android.opengl.GLES20.glViewport(0, 0, this.G_renamed, this.H_renamed);
        i_renamed();
        android.opengl.GLES20.glUseProgram(i2);
        i_renamed();
        b_renamed(!cVar.r_renamed() || b_renamed() < 0.95f);
        android.opengl.GLES20.glActiveTexture(33984);
        i_renamed();
        cVar.b_renamed(this);
        android.opengl.GLES20.glBindTexture(cVar.m_renamed(), cVar.e_renamed());
        i_renamed();
        android.opengl.GLES20.glUniform1i(bVarArr[3].f4620a, 0);
        i_renamed();
        if (k_renamed() && bVarArr.length > 5) {
            android.opengl.GLES20.glActiveTexture(33985);
            i_renamed();
            this.t_renamed.b_renamed(this);
            android.opengl.GLES20.glBindTexture(this.t_renamed.m_renamed(), this.t_renamed.e_renamed());
            i_renamed();
            android.opengl.GLES20.glUniform1i(bVarArr[5].f4620a, 1);
            i_renamed();
        }
        android.opengl.GLES20.glUniform1f(bVarArr[4].f4620a, b_renamed());
        i_renamed();
    }

    private boolean k_renamed() {
        return this.u_renamed && this.t_renamed != null;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar) {
        boolean zN = cVar.n_renamed();
        if (zN) {
            synchronized (this.k_renamed) {
                this.k_renamed.a_renamed(cVar.e_renamed());
            }
        }
        return zN;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void g_renamed() {
        synchronized (this.k_renamed) {
            if (this.k_renamed.b_renamed() > 0) {
                i_renamed.a_renamed(null, this.k_renamed.b_renamed(), this.k_renamed.c_renamed(), 0);
                this.k_renamed.d_renamed();
            }
            if (this.l_renamed.b_renamed() > 0) {
                i_renamed.b_renamed(null, this.l_renamed.b_renamed(), this.l_renamed.c_renamed(), 0);
                this.l_renamed.d_renamed();
            }
        }
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void h_renamed() {
        a_renamed(this.X_renamed.remove(r0.size() - 1), l_renamed());
        f_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        c_renamed();
        com.oplus.camera.gl_renamed.s_renamed sVarL = l_renamed();
        this.X_renamed.add(sVar);
        a_renamed(sVarL, sVar);
    }

    private com.oplus.camera.gl_renamed.s_renamed l_renamed() {
        return this.X_renamed.get(r1.size() - 1);
    }

    private void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, com.oplus.camera.gl_renamed.s_renamed sVar) {
        if (cVar == null && sVar != null) {
            android.opengl.GLES20.glGenFramebuffers(1, this.W_renamed, 0);
            i_renamed();
            android.opengl.GLES20.glBindFramebuffer(36160, this.W_renamed[0]);
            i_renamed();
        } else if (cVar != null && sVar == null) {
            android.opengl.GLES20.glBindFramebuffer(36160, 0);
            i_renamed();
            android.opengl.GLES20.glDeleteFramebuffers(1, this.W_renamed, 0);
            i_renamed();
        }
        if (sVar == null) {
            a_renamed(this.J_renamed, this.K_renamed);
            return;
        }
        a_renamed(sVar.f_renamed(), sVar.g_renamed());
        if (!sVar.n_renamed()) {
            sVar.c_renamed(this);
        }
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, sVar.m_renamed(), sVar.e_renamed(), 0);
        i_renamed();
        j_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void b_renamed(com.oplus.camera.gl_renamed.c_renamed cVar) {
        int iM = cVar.m_renamed();
        android.opengl.GLES20.glBindTexture(iM, cVar.e_renamed());
        i_renamed();
        android.opengl.GLES20.glTexParameteri(iM, 10242, 33071);
        i_renamed();
        android.opengl.GLES20.glTexParameteri(iM, 10243, 33071);
        i_renamed();
        android.opengl.GLES20.glTexParameterf(iM, 10241, 9729.0f);
        i_renamed();
        android.opengl.GLES20.glTexParameterf(iM, 10240, 9729.0f);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, int i2, int i3) {
        int iM = cVar.m_renamed();
        android.opengl.GLES20.glBindTexture(iM, cVar.e_renamed());
        i_renamed();
        android.opengl.GLES20.glTexImage2D(iM, 0, i2, cVar.h_renamed(), cVar.i_renamed(), 0, i2, i3, null);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void b_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, int i2, int i3) {
        int iM = cVar.m_renamed();
        android.opengl.GLES20.glBindTexture(iM, cVar.e_renamed());
        i_renamed();
        android.opengl.GLES20.glTexSubImage2D(iM, 0, 0, 0, cVar.h_renamed(), cVar.i_renamed(), i2, i3, null);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, android.graphics.Bitmap bitmap) {
        int iM = cVar.m_renamed();
        android.opengl.GLES20.glBindTexture(iM, cVar.e_renamed());
        i_renamed();
        android.opengl.GLUtils.texImage2D(iM, 0, bitmap, 0);
        i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.c_renamed cVar, int i2, int i3, android.graphics.Bitmap bitmap, int i4, int i5) {
        int iM = cVar.m_renamed();
        android.opengl.GLES20.glBindTexture(iM, cVar.e_renamed());
        i_renamed();
        android.opengl.GLUtils.texSubImage2D(iM, 0, i2, i3, bitmap, i4, i5);
        i_renamed();
    }

    public int a_renamed(java.nio.FloatBuffer floatBuffer) {
        return a_renamed(floatBuffer, 4);
    }

    private int a_renamed(java.nio.Buffer buffer, int i2) {
        i_renamed.a_renamed(1, this.s_renamed, 0);
        i_renamed();
        int i3 = this.s_renamed[0];
        android.opengl.GLES20.glBindBuffer(34962, i3);
        i_renamed();
        android.opengl.GLES20.glBufferData(34962, buffer.capacity() * i2, buffer, 35044);
        i_renamed();
        return i3;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public com.oplus.camera.gl_renamed.k_renamed a_renamed() {
        return i_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public void a_renamed(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (f_renamed == 0.0f || java.lang.Math.abs(f7) < Float.MIN_VALUE) {
            return;
        }
        float[] fArr = this.m_renamed;
        android.opengl.Matrix.setRotateM(fArr, 0, f_renamed, f2, f3, f4);
        android.opengl.Matrix.multiplyMM(fArr, 16, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, (-f5) / f7, (-f6) / f7, 0.0f, (-1.0f) / f7, 0.0f, 0.0f, 0.0f, 1.0f}, 0, fArr, 0);
        android.opengl.Matrix.multiplyMM(fArr, 0, this.B_renamed, this.F_renamed, fArr, 16);
        java.lang.System.arraycopy(fArr, 0, this.B_renamed, this.F_renamed, 16);
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public int d_renamed() {
        return this.G_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.h_renamed
    public int e_renamed() {
        return this.H_renamed;
    }

    /* compiled from: GLES20Canvas.java */
    private static abstract class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f4620a;

        /* renamed from: b_renamed, reason: collision with root package name */
        protected final java.lang.String f4621b;

        public abstract void a_renamed(int i_renamed);

        public b_renamed(java.lang.String str) {
            this.f4621b = str;
        }
    }

    /* compiled from: GLES20Canvas.java */
    private static class c_renamed extends com.oplus.camera.gl_renamed.i_renamed.b_renamed {
        public c_renamed(java.lang.String str) {
            super(str);
        }

        @Override // com.oplus.camera.gl_renamed.i_renamed.b_renamed
        public void a_renamed(int i_renamed) {
            this.f4620a = android.opengl.GLES20.glGetUniformLocation(i_renamed, this.f4621b);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        }
    }

    /* compiled from: GLES20Canvas.java */
    private static class a_renamed extends com.oplus.camera.gl_renamed.i_renamed.b_renamed {
        public a_renamed(java.lang.String str) {
            super(str);
        }

        @Override // com.oplus.camera.gl_renamed.i_renamed.b_renamed
        public void a_renamed(int i_renamed) {
            this.f4620a = android.opengl.GLES20.glGetAttribLocation(i_renamed, this.f4621b);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        }
    }
}
