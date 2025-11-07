package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FilterThumbDrawer.java */
/* loaded from: classes2.dex */
public class m_renamed {
    private int B_renamed;
    private int C_renamed;
    private java.nio.FloatBuffer D_renamed;
    private java.nio.FloatBuffer E_renamed;
    private java.nio.FloatBuffer F_renamed;
    private java.nio.FloatBuffer G_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f6915a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f6916b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f6917c;
    private java.lang.String d_renamed;
    private java.lang.String e_renamed;
    private java.lang.String f_renamed;
    private float[] g_renamed = new float[8];
    private int[] h_renamed = null;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private int[] k_renamed = null;
    private int l_renamed = 0;
    private int m_renamed = 0;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private int t_renamed = 0;
    private int u_renamed = 0;
    private int v_renamed = 0;
    private int w_renamed = 0;
    private int x_renamed = 0;
    private int y_renamed = 0;
    private int z_renamed = 0;
    private int A_renamed = 0;
    private android.graphics.Bitmap H_renamed = null;
    private android.graphics.Bitmap I_renamed = null;

    public m_renamed(android.content.Context context) {
        this.f6915a = null;
        this.f6916b = null;
        this.f6917c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.F_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.f5403a);
        this.D_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.f5404b);
        this.E_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.f5405c);
        this.G_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.f5404b);
        this.f6915a = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.fragment_shader));
        this.f6916b = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.fragment_shader_oes));
        this.f6917c = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.fragment_shader_common));
        this.d_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.vertex_shader));
        this.e_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.vertex_shader_oes));
        this.f_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.vertex_shader_common));
    }

    private void a_renamed(int i_renamed) {
        android.graphics.Canvas canvas = new android.graphics.Canvas();
        this.H_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i_renamed, android.graphics.Bitmap.Config.ARGB_8888);
        canvas.setBitmap(this.H_renamed);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        float f_renamed = i_renamed;
        float f2 = (int) (0.5f * f_renamed);
        canvas.drawRoundRect(0.0f, 0.0f, f_renamed, f_renamed, f2, f2, paint);
    }

    public void a_renamed() {
        int[] iArr = this.h_renamed;
        if (iArr != null) {
            android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
        int[] iArr2 = this.k_renamed;
        if (iArr2 != null) {
            android.opengl.GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
    }

    private java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.b_renamed bVar, java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed, int i2, float f_renamed) {
        int i3;
        b_renamed();
        android.graphics.Rect rect = list.get(0).rect;
        if (this.h_renamed == null) {
            this.h_renamed = new int[2];
            int[] iArr = this.h_renamed;
            android.opengl.GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.h_renamed;
            this.i_renamed = iArr2[0];
            this.j_renamed = iArr2[1];
        }
        if (this.k_renamed == null || this.n_renamed != rect.width() || this.o_renamed != rect.height()) {
            int[] iArr3 = this.k_renamed;
            if (iArr3 != null) {
                android.opengl.GLES20.glDeleteTextures(iArr3.length, iArr3, 0);
            }
            this.k_renamed = new int[4];
            int[] iArr4 = this.k_renamed;
            android.opengl.GLES20.glGenTextures(iArr4.length, iArr4, 0);
            this.l_renamed = this.k_renamed[0];
            a_renamed(this.l_renamed, rect);
            this.m_renamed = this.k_renamed[1];
            a_renamed(this.m_renamed, rect);
            this.q_renamed = this.k_renamed[2];
            a_renamed(rect.height());
            a_renamed(this.p_renamed, this.H_renamed);
            this.q_renamed = this.k_renamed[3];
            this.n_renamed = rect.width();
            this.o_renamed = rect.height();
            float[] fArr = com.oplus.camera.screen.out.g_renamed.f5405c;
            float[] fArr2 = this.g_renamed;
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float fWidth = ((rect.width() - rect.height()) / 2.0f) / rect.width();
            int i4 = 0;
            while (true) {
                float[] fArr3 = this.g_renamed;
                if (i4 >= fArr3.length) {
                    break;
                }
                fArr3[i4] = fArr3[i4] + (fArr3[i4] == 0.0f ? fWidth : -fWidth);
                i4 += 2;
            }
            co_renamed.polarr.renderer.entities.DrawingItem drawingItem = list.get(list.size() - 1);
            this.I_renamed = android.graphics.Bitmap.createBitmap(drawingItem.rect.right, drawingItem.rect.bottom, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Paint paint = new android.graphics.Paint();
            android.graphics.Canvas canvas = new android.graphics.Canvas(this.I_renamed);
            for (co_renamed.polarr.renderer.entities.DrawingItem drawingItem2 : list) {
                if (drawingItem2.overlayBitmap != null) {
                    int i5 = drawingItem2.overlayLeft + drawingItem2.rect.left;
                    int i6 = drawingItem2.overlayTop + drawingItem2.rect.top;
                    int i7 = drawingItem2.rect.bottom - (i6 - drawingItem2.rect.top);
                    canvas.drawBitmap(drawingItem2.overlayBitmap, new android.graphics.Rect(0, 0, drawingItem2.overlayBitmap.getWidth(), drawingItem2.overlayBitmap.getHeight()), new android.graphics.Rect(i5, i6, (((i7 - i6) * drawingItem2.overlayBitmap.getWidth()) / drawingItem2.overlayBitmap.getHeight()) + i5, i7), paint);
                }
            }
            a_renamed(this.q_renamed, this.I_renamed);
        }
        int i8 = 36160;
        android.opengl.GLES20.glBindFramebuffer(36160, this.i_renamed);
        int i9 = 36064;
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.l_renamed, 0);
        android.opengl.GLES20.glViewport(0, 0, rect.width(), rect.height());
        android.opengl.GLES20.glUseProgram(this.x_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, i_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.y_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.F_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.y_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.z_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.E_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.z_renamed);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        int i10 = 0;
        while (i10 < list.size()) {
            co_renamed.polarr.renderer.entities.DrawingItem drawingItem3 = list.get(i10);
            android.graphics.Rect rect2 = drawingItem3.rect;
            if ("default".equals(drawingItem3.filterId)) {
                i3 = this.l_renamed;
            } else {
                android.opengl.GLES20.glViewport(0, 0, rect2.width(), rect2.height());
                bVar.a_renamed(drawingItem3.filterId);
                bVar.b_renamed(this.l_renamed);
                bVar.a_renamed(this.m_renamed);
                bVar.a_renamed(rect2.width(), rect2.height());
                bVar.d_renamed();
                i3 = this.m_renamed;
            }
            android.opengl.GLES20.glBindFramebuffer(i8, this.j_renamed);
            android.opengl.GLES20.glFramebufferTexture2D(i8, i9, 3553, i2, 0);
            android.opengl.GLES20.glViewport(rect2.left + ((rect2.width() - rect2.height()) / 2), rect2.top, rect2.height(), rect2.height());
            android.opengl.GLES20.glEnable(3042);
            android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 0);
            android.opengl.GLES20.glUseProgram(this.r_renamed);
            android.opengl.GLES20.glActiveTexture(33984);
            android.opengl.GLES20.glBindTexture(3553, i3);
            android.opengl.GLES20.glUniform1i(this.v_renamed, 0);
            android.opengl.GLES20.glVertexAttribPointer(this.s_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.F_renamed);
            android.opengl.GLES20.glEnableVertexAttribArray(this.s_renamed);
            this.G_renamed.position(0);
            this.G_renamed.put(this.g_renamed);
            this.G_renamed.position(0);
            android.opengl.GLES20.glVertexAttribPointer(this.t_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.G_renamed);
            android.opengl.GLES20.glEnableVertexAttribArray(this.t_renamed);
            android.opengl.GLES20.glActiveTexture(33985);
            android.opengl.GLES20.glBindTexture(3553, this.p_renamed);
            android.opengl.GLES20.glUniform1i(this.w_renamed, 1);
            android.opengl.GLES20.glVertexAttribPointer(this.u_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.D_renamed);
            android.opengl.GLES20.glEnableVertexAttribArray(this.u_renamed);
            android.opengl.GLES20.glDrawArrays(5, 0, 4);
            android.opengl.GLES20.glDisable(3042);
            i10++;
            i8 = 36160;
            i9 = 36064;
        }
        android.opengl.GLES20.glViewport(0, 0, this.I_renamed.getWidth(), this.I_renamed.getHeight());
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        android.opengl.GLES20.glUseProgram(this.A_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, this.q_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.B_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.F_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.B_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.C_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.E_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.C_renamed);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glDisable(3042);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
    }

    private void a_renamed(int i_renamed, android.graphics.Rect rect) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10241, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, null);
    }

    private void a_renamed(int i_renamed, android.graphics.Bitmap bitmap) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10241, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLUtils.texImage2D(3553, 0, bitmap, 0);
    }

    private void b_renamed() {
        c_renamed();
        d_renamed();
        e_renamed();
    }

    private void c_renamed() {
        if (this.A_renamed == 0) {
            this.A_renamed = a_renamed(this.f_renamed, this.f6917c);
            this.B_renamed = android.opengl.GLES20.glGetAttribLocation(this.A_renamed, "aPosition");
            this.C_renamed = android.opengl.GLES20.glGetAttribLocation(this.A_renamed, "aTextureCoord");
        }
    }

    private void d_renamed() {
        if (this.r_renamed == 0) {
            this.r_renamed = a_renamed(this.d_renamed, this.f6915a);
            this.s_renamed = android.opengl.GLES20.glGetAttribLocation(this.r_renamed, "aPosition");
            this.t_renamed = android.opengl.GLES20.glGetAttribLocation(this.r_renamed, "aTextureCoord");
            this.v_renamed = android.opengl.GLES20.glGetUniformLocation(this.r_renamed, "aTexture");
            this.u_renamed = android.opengl.GLES20.glGetAttribLocation(this.r_renamed, "aTextureCoordMask");
            this.w_renamed = android.opengl.GLES20.glGetUniformLocation(this.r_renamed, "aTextureMask");
        }
    }

    private void e_renamed() {
        if (this.x_renamed == 0) {
            this.x_renamed = a_renamed(this.e_renamed, this.f6916b);
            this.y_renamed = android.opengl.GLES20.glGetAttribLocation(this.x_renamed, "aPosition");
            this.z_renamed = android.opengl.GLES20.glGetAttribLocation(this.x_renamed, "aTextureCoord");
        }
    }

    private java.lang.String a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i_renamed = inputStream.read(bArr);
                        if (i_renamed == -1) {
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

    public static int a_renamed(java.lang.String str, java.lang.String str2) {
        int iA = a_renamed(35633, str);
        if (iA == 0) {
            com.oplus.camera.e_renamed.f_renamed("FilterThumbDrawer", "load vertex shader error");
        }
        int iA2 = a_renamed(35632, str2);
        if (iA2 == 0) {
            com.oplus.camera.e_renamed.f_renamed("FilterThumbDrawer", "load fragment shader error");
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
        if (iArr[0] == 1) {
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
            com.oplus.camera.e_renamed.f_renamed("FilterThumbDrawer", str + ": glError " + iGlGetError);
        }
    }
}
