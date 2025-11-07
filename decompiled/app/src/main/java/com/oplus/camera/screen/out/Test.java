package com.oplus.camera.screen.out;

/* compiled from: OesDrawer.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.screen.out.b_renamed {
    private static final android.view.animation.PathInterpolator e_renamed = new android.view.animation.PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);
    private com.oplus.camera.screen.out.a_renamed A_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int[] l_renamed;
    private int m_renamed;
    private long n_renamed;
    private java.lang.String o_renamed;
    private java.lang.String p_renamed;
    private java.nio.FloatBuffer q_renamed;
    private android.graphics.Matrix r_renamed;
    private android.graphics.Rect s_renamed;
    private android.graphics.Rect t_renamed;
    private android.graphics.Rect u_renamed;
    private long v_renamed;
    private com.oplus.camera.gl_renamed.a_renamed.d_renamed w_renamed;
    private java.nio.FloatBuffer x_renamed;
    private java.nio.FloatBuffer y_renamed;
    private int z_renamed;

    public d_renamed(android.content.Context context) {
        super(context, 2);
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 1;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0L;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = new android.graphics.Matrix();
        this.s_renamed = new android.graphics.Rect();
        this.t_renamed = new android.graphics.Rect();
        this.u_renamed = new android.graphics.Rect();
        this.v_renamed = 0L;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = 0;
        this.A_renamed = null;
        this.x_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.f5405c);
        this.y_renamed = a_renamed(com.oplus.camera.screen.out.g_renamed.d_renamed);
        this.l_renamed = new int[1];
        this.o_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.fragment_shader_oes));
        this.p_renamed = a_renamed(context.getResources().openRawResource(com.oplus.camera.R_renamed.raw.vertex_shader_oes));
    }

    @Override // com.oplus.camera.screen.out.b_renamed
    protected void a_renamed() {
        super.a_renamed();
        e_renamed();
    }

    private void e_renamed() {
        if (this.f_renamed == 0) {
            this.f_renamed = a_renamed(this.p_renamed, this.o_renamed);
            this.g_renamed = android.opengl.GLES20.glGetAttribLocation(this.f_renamed, "aPosition");
            this.h_renamed = android.opengl.GLES20.glGetAttribLocation(this.f_renamed, "aTextureCoord");
        }
    }

    public boolean c_renamed() {
        return 0 != this.n_renamed;
    }

    public void a_renamed(com.oplus.camera.screen.out.a_renamed aVar, android.graphics.Rect rect) {
        if (this.n_renamed == 0) {
            android.opengl.GLES20.glGenTextures(this.f5386c.length, this.f5386c, 0);
            int[] iArr = this.l_renamed;
            android.opengl.GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            this.n_renamed = com.oplus.camera.jni.PreviewShow.init();
        }
        a_renamed();
        a_renamed(aVar, rect, this.s_renamed);
        android.opengl.GLES20.glViewport(this.s_renamed.left, this.s_renamed.top, this.s_renamed.width(), this.s_renamed.height());
        android.opengl.GLES20.glUseProgram(this.f_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        if (!aVar.f5382b.isClosed()) {
            com.oplus.camera.jni.PreviewShow.process(aVar.f5382b, 36197, this.f5386c[this.i_renamed], this.n_renamed);
        }
        b_renamed(this.h_renamed, this.y_renamed);
        c_renamed(this.g_renamed, a_renamed(aVar.e_renamed));
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        this.A_renamed = aVar;
    }

    private void a_renamed(com.oplus.camera.screen.out.a_renamed aVar, android.graphics.Rect rect, android.graphics.Rect rect2) {
        double dHeight;
        double d_renamed;
        double d2 = (aVar.f5383c * 1.0d) / aVar.d_renamed;
        if (java.lang.Math.abs(d2 - 1.3333333333333333d) < 0.01d) {
            dHeight = rect.height();
            d_renamed = 0.21896792189679218d;
        } else if (java.lang.Math.abs(d2 - 1.7777777777777777d) < 0.01d) {
            dHeight = rect.height();
            d_renamed = 0.061366806136680614d;
        } else {
            dHeight = rect.height();
            d_renamed = 0.30264993026499304d;
        }
        double d3 = dHeight * d_renamed;
        rect2.set(0, (int) d3, rect.width(), (int) (d3 + (rect.width() * d2)));
    }

    private java.nio.FloatBuffer a_renamed(int i_renamed) {
        float[] fArrA = a_renamed(com.oplus.camera.screen.out.g_renamed.f5403a, (float[]) null);
        this.r_renamed.reset();
        this.r_renamed.postRotate(i_renamed);
        this.r_renamed.mapPoints(fArrA);
        java.nio.FloatBuffer floatBuffer = this.q_renamed;
        if (floatBuffer == null) {
            this.q_renamed = a_renamed(fArrA);
        } else {
            floatBuffer.position(0);
            this.q_renamed.put(fArrA);
            this.q_renamed.position(0);
        }
        return this.q_renamed;
    }

    @Override // com.oplus.camera.screen.out.b_renamed
    public void b_renamed() {
        super.b_renamed();
        int[] iArr = this.l_renamed;
        android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        com.oplus.camera.jni.PreviewShow.release(this.n_renamed);
        com.oplus.camera.gl_renamed.a_renamed.d_renamed dVar = this.w_renamed;
        if (dVar != null) {
            dVar.b_renamed();
            this.w_renamed = null;
        }
    }

    public int a_renamed(int i_renamed, int i2, int i3, int i4) {
        int i5 = i2 / 10;
        int i6 = i3 / 10;
        this.w_renamed.b_renamed(i5, i6);
        this.w_renamed.a_renamed(i5, i6);
        this.w_renamed.a_renamed(i4);
        return this.w_renamed.a_renamed(i_renamed, com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4580a), com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4581b));
    }

    public void b_renamed(com.oplus.camera.screen.out.a_renamed aVar, android.graphics.Rect rect) {
        this.t_renamed.set(this.s_renamed);
        a_renamed(aVar, rect, this.u_renamed);
        this.v_renamed = java.lang.System.currentTimeMillis();
        a_renamed(this.f5386c[this.j_renamed], this.t_renamed.width(), this.t_renamed.height());
        android.opengl.GLES20.glBindFramebuffer(36160, this.l_renamed[this.m_renamed]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f5386c[this.j_renamed], 0);
        android.opengl.GLES20.glViewport(0, 0, this.t_renamed.width(), this.t_renamed.height());
        android.opengl.GLES20.glUseProgram(this.f_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        b_renamed(this.h_renamed, this.y_renamed);
        c_renamed(this.g_renamed, a_renamed(aVar.e_renamed));
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        if (this.w_renamed == null) {
            this.w_renamed = new com.oplus.camera.gl_renamed.a_renamed.d_renamed();
        }
        this.w_renamed.a_renamed(new android.util.Size(this.t_renamed.height(), this.t_renamed.width()), new android.util.Size(this.u_renamed.height(), this.u_renamed.width()));
        this.z_renamed = 0;
        this.A_renamed = null;
    }

    private void a_renamed(int i_renamed, int i2, int i3) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10241, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
    }

    public boolean c_renamed(com.oplus.camera.screen.out.a_renamed aVar, android.graphics.Rect rect) {
        float fCurrentTimeMillis = (java.lang.System.currentTimeMillis() - this.v_renamed) / 600.0f;
        boolean z_renamed = fCurrentTimeMillis >= 1.0f;
        if (z_renamed) {
            fCurrentTimeMillis = 1.0f;
        }
        float interpolation = e_renamed.getInterpolation(fCurrentTimeMillis);
        if (this.z_renamed < 30) {
            this.k_renamed = a_renamed(this.f5386c[this.j_renamed], this.s_renamed.width(), this.s_renamed.height(), (int) ((20.0f * interpolation) + 5.0f));
        }
        this.s_renamed.set(0, (int) (this.t_renamed.top + ((this.u_renamed.top - this.t_renamed.top) * interpolation)), rect.width(), (int) (this.t_renamed.bottom + ((this.u_renamed.bottom - this.t_renamed.bottom) * interpolation)));
        android.opengl.GLES20.glViewport(this.s_renamed.left, this.s_renamed.top, this.s_renamed.width(), this.s_renamed.height());
        a_renamed(this.k_renamed, (java.nio.FloatBuffer) null);
        this.z_renamed++;
        return z_renamed;
    }

    public void d_renamed() {
        if (this.A_renamed != null) {
            android.opengl.GLES20.glUseProgram(this.f_renamed);
            android.opengl.GLES20.glActiveTexture(33984);
            b_renamed(this.h_renamed, this.y_renamed);
            c_renamed(this.g_renamed, a_renamed(this.A_renamed.e_renamed));
            android.opengl.GLES20.glDrawArrays(5, 0, 4);
        }
    }
}
