package com.oplus.camera.ui.preview.a_renamed.b_renamed;

/* compiled from: VideoWatermarkRenderer.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f6872a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f6873b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final float[] f6874c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] d_renamed = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static final float[] e_renamed = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] f_renamed = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private java.nio.FloatBuffer g_renamed;
    private java.nio.FloatBuffer i_renamed;
    private java.nio.FloatBuffer j_renamed;
    private java.nio.FloatBuffer k_renamed;
    private java.nio.FloatBuffer l_renamed;
    private java.nio.FloatBuffer m_renamed;
    private int n_renamed;
    private java.nio.FloatBuffer h_renamed = null;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private boolean t_renamed = false;
    private float[] u_renamed = new float[16];
    private float[] v_renamed = new float[16];
    private float[] w_renamed = new float[16];
    private float[] x_renamed = new float[16];

    public a_renamed() {
        this.g_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = 0;
        this.g_renamed = a_renamed(f6872a);
        this.i_renamed = a_renamed(f6873b);
        this.j_renamed = a_renamed(f6874c);
        this.k_renamed = a_renamed(d_renamed);
        this.l_renamed = a_renamed(e_renamed);
        this.m_renamed = a_renamed(f_renamed);
        this.n_renamed = f6872a.length / 2;
        android.opengl.Matrix.setIdentityM(this.u_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.v_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.w_renamed, 0);
        android.opengl.Matrix.setIdentityM(this.x_renamed, 0);
    }

    public void a_renamed() {
        if (this.t_renamed) {
            return;
        }
        this.o_renamed = com.oplus.camera.util.k_renamed.b_renamed("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed    gl_Position = uMVPMatrix * aPosition;\n_renamed    vTextureCoord = aTextureCoord.xy;\n_renamed}\n_renamed", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uSampleTexture;\nvoid main() {\n_renamed    gl_FragColor = texture2D(uSampleTexture, vTextureCoord);\n_renamed}\n_renamed");
        this.p_renamed = android.opengl.GLES20.glGetUniformLocation(this.o_renamed, "uMVPMatrix");
        a_renamed(this.p_renamed, "uMVPMatrix");
        this.q_renamed = android.opengl.GLES20.glGetAttribLocation(this.o_renamed, "aPosition");
        a_renamed(this.q_renamed, "aPosition");
        this.r_renamed = android.opengl.GLES20.glGetAttribLocation(this.o_renamed, "aTextureCoord");
        a_renamed(this.r_renamed, "aTextureCoord");
        this.s_renamed = android.opengl.GLES20.glGetUniformLocation(this.o_renamed, "uSampleTexture");
        a_renamed(this.s_renamed, "uSampleTexture");
        this.t_renamed = true;
        com.oplus.camera.e_renamed.b_renamed("VideoWatermarkRenderer", "onAttached, mShaderProgram: " + this.o_renamed);
    }

    public void b_renamed() {
        android.opengl.GLES20.glDeleteProgram(this.o_renamed);
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = false;
        com.oplus.camera.e_renamed.b_renamed("VideoWatermarkRenderer", "onDetached");
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        android.opengl.GLES20.glUseProgram(this.o_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glUniform1i(this.s_renamed, 0);
        com.oplus.camera.util.k_renamed.a_renamed("glUniform1i mSampleTextureLoc");
        android.opengl.GLES20.glUniformMatrix4fv(this.p_renamed, 1, false, c_renamed(), 0);
        com.oplus.camera.util.k_renamed.a_renamed("glUniformMatrix4fv mMVPMatrixLoc");
        android.opengl.GLES20.glEnableVertexAttribArray(this.q_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.q_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.g_renamed);
        com.oplus.camera.util.k_renamed.a_renamed("glVertexAttribPointer mPositionLoc");
        android.opengl.GLES20.glEnableVertexAttribArray(this.r_renamed);
        if (i2 == 90) {
            this.h_renamed = this.j_renamed;
        } else if (i2 == 180) {
            this.h_renamed = this.k_renamed;
        } else if (i2 == 270) {
            this.h_renamed = this.l_renamed;
        } else {
            this.h_renamed = this.i_renamed;
        }
        android.opengl.GLES20.glVertexAttribPointer(this.r_renamed, 2, 5126, false, 8, (java.nio.Buffer) (z_renamed ? this.m_renamed : this.h_renamed));
        com.oplus.camera.util.k_renamed.a_renamed("glVertexAttribPointer mTextureCoordLoc");
        android.opengl.GLES20.glDrawArrays(5, 0, this.n_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.q_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.r_renamed);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glUseProgram(0);
    }

    private void a_renamed(int i_renamed, java.lang.String str) {
        if (i_renamed >= 0) {
            return;
        }
        throw new java.lang.RuntimeException("Unable to locate '" + str + "' in_renamed program");
    }

    private float[] c_renamed() {
        android.opengl.Matrix.multiplyMM(this.x_renamed, 0, this.v_renamed, 0, this.w_renamed, 0);
        float[] fArr = this.x_renamed;
        android.opengl.Matrix.multiplyMM(fArr, 0, this.u_renamed, 0, fArr, 0);
        return this.x_renamed;
    }

    private java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
