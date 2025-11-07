package com.oplus.camera.gl_renamed;

/* compiled from: TextureRotateProcessor.java */
/* loaded from: classes2.dex */
public class w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f4678a = {1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f4679b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private int[] f4680c = null;
    private int[] d_renamed = null;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private java.nio.FloatBuffer k_renamed = null;
    private java.nio.FloatBuffer l_renamed = null;

    public int a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        c_renamed();
        a_renamed();
        a_renamed(this.f_renamed, sVar.f4611a, sVar.f4612b);
        android.opengl.GLES20.glViewport(0, 0, sVar.f4611a, sVar.f4612b);
        android.opengl.GLES20.glBindFramebuffer(36160, this.e_renamed);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f_renamed, 0);
        android.opengl.GLES20.glUseProgram(this.g_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, sVar.e_renamed());
        android.opengl.GLES20.glUniform1i(this.h_renamed, 0);
        android.opengl.GLES20.glVertexAttribPointer(this.i_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.l_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.i_renamed);
        android.opengl.GLES20.glVertexAttribPointer(this.j_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.j_renamed);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        return this.f_renamed;
    }

    private java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    private void c_renamed() {
        if (this.g_renamed == 0) {
            this.g_renamed = com.oplus.camera.util.k_renamed.b_renamed("attribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed   gl_Position = aPosition;\n_renamed   vTextureCoord = aTextureCoord.xy;\n_renamed}", "precision mediump float;\nuniform sampler2D aTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n_renamed    gl_FragColor = texture2D(aTexture, vTextureCoord);\n_renamed}");
            this.h_renamed = android.opengl.GLES20.glGetUniformLocation(this.g_renamed, "aTexture");
            this.i_renamed = android.opengl.GLES20.glGetAttribLocation(this.g_renamed, "aPosition");
            this.j_renamed = android.opengl.GLES20.glGetAttribLocation(this.g_renamed, "aTextureCoord");
        }
    }

    public void a_renamed() {
        if (this.f4680c == null) {
            this.f4680c = new int[1];
            int[] iArr = this.f4680c;
            android.opengl.GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            this.e_renamed = this.f4680c[0];
        }
        if (this.d_renamed == null) {
            this.d_renamed = new int[1];
            int[] iArr2 = this.d_renamed;
            android.opengl.GLES20.glGenTextures(iArr2.length, iArr2, 0);
            this.f_renamed = this.d_renamed[0];
        }
        if (this.l_renamed == null) {
            this.l_renamed = a_renamed(f4678a);
        }
        if (this.k_renamed == null) {
            this.k_renamed = a_renamed(f4679b);
        }
    }

    public void b_renamed() {
        int[] iArr = this.f4680c;
        if (iArr != null) {
            android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            this.f4680c = null;
        }
        int[] iArr2 = this.d_renamed;
        if (iArr2 != null) {
            android.opengl.GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            this.d_renamed = null;
        }
    }

    private void a_renamed(int i_renamed, int i2, int i3) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexParameteri(3553, 10240, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10241, 9729);
        android.opengl.GLES20.glTexParameteri(3553, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
    }
}
