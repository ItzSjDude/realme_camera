package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bp_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed {
    public float n_renamed;
    public float o_renamed;
    public int p_renamed;

    public bp_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        super(context, resources);
        this.n_renamed = 0.5f;
        this.o_renamed = 0.5f;
        a_renamed();
    }

    public void a_renamed(java.util.List<java.lang.Float> list) {
        java.nio.FloatBuffer floatBufferAsFloatBuffer;
        if (list == null) {
            return;
        }
        synchronized (list) {
            int size = list.size() * 4;
            java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(size);
            byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
            floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
            for (int i_renamed = 0; i_renamed < size && list.size() > i_renamed; i_renamed++) {
                java.lang.Float fValueOf = list.get(i_renamed);
                if (!this.f15a.isSDK && i_renamed % 4 == 1) {
                    fValueOf = java.lang.Float.valueOf(1.0f - fValueOf.floatValue());
                }
                floatBufferAsFloatBuffer.put(fValueOf.floatValue());
            }
        }
        floatBufferAsFloatBuffer.position(0);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendEquation(32774);
        android.opengl.GLES20.glBlendFuncSeparate(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
        android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 4, 5126, false, 0, (java.nio.Buffer) floatBufferAsFloatBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(this.d_renamed);
        android.opengl.GLES20.glUseProgram(this.f16b);
        l_renamed();
        android.opengl.GLES20.glDrawArrays(0, 0, list.size() / 4);
        android.opengl.GLES20.glDisableVertexAttribArray(this.d_renamed);
        android.opengl.GLES20.glDisable(3042);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void b_renamed(int i_renamed, int i2) {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void d_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        this.f16b = a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.c_renamed(a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.vertexHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("paint_vertex")), a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.fragmentHeader + this.f15a.shaderUtil.a_renamed(this.i_renamed, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("paint")));
        this.d_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "coordinates");
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
    }

    public final void l_renamed() {
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "brushMap");
        android.opengl.GLES20.glActiveTexture(33988);
        android.opengl.GLES20.glBindTexture(3553, this.p_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 4);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_IMAGE);
        android.opengl.GLES20.glActiveTexture(33989);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.denoiseTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 5);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "brushSize"), this.n_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "flow"), this.o_renamed);
    }
}
