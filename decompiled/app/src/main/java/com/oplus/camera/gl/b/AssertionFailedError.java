package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: FboDrawer.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.gl_renamed.b_renamed.a_renamed implements com.oplus.camera.gl_renamed.b_renamed.c_renamed {
    private static final float[] i_renamed = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static final float[] j_renamed = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private int k_renamed = 0;
    private int l_renamed = 0;

    @Override // com.oplus.camera.gl_renamed.b_renamed.c_renamed
    public void b_renamed() {
        this.k_renamed = a_renamed(a_renamed(35633, "#version 300 es_renamed                                                      \nlayout(location = 0) in_renamed vec4 a_position;                     \nlayout(location = 1) in_renamed vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n_renamed{                                                            \n_renamed    gl_Position = a_position;                                \n_renamed    v_texture_coord = a_texture_coord.xy;                    \n_renamed}                                                            \n_renamed"), a_renamed(35632, "#version 300 es_renamed                                                      \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler;                           \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n_renamed{                                                            \n_renamed    out_color = texture(uTextureSampler, v_texture_coord);   \n_renamed}\n_renamed"));
        this.l_renamed = android.opengl.GLES32.glGetUniformLocation(this.k_renamed, "uTextureSampler");
    }

    @Override // com.oplus.camera.gl_renamed.b_renamed.c_renamed
    public int a_renamed(int i2, int i3, int i4, android.util.Size size, android.util.Size size2, int i5, boolean z_renamed, com.oplus.camera.gl_renamed.b_renamed.h_renamed hVar) {
        int i6;
        int iB;
        int iC;
        int iA = hVar.a_renamed();
        int iK = hVar.k_renamed();
        int iG = com.oplus.camera.util.Util.g_renamed();
        if (-1 == iG) {
            iB = hVar.b_renamed() - hVar.k_renamed();
            iC = hVar.c_renamed();
        } else if (iG == 0) {
            iB = hVar.b_renamed() - hVar.k_renamed();
            iC = (hVar.c_renamed() / 2) - com.oplus.camera.util.Util.M_renamed();
        } else {
            i6 = 0;
            android.opengl.GLES32.glUseProgram(this.k_renamed);
            android.opengl.GLES32.glActiveTexture(33984);
            android.opengl.GLES32.glViewport(hVar.h_renamed(), i6, iA, iK);
            android.opengl.GLES32.glBindTexture(3553, i2);
            android.opengl.GLES32.glUniform1i(this.l_renamed, 0);
            a_renamed();
            java.nio.FloatBuffer floatBufferA = a_renamed(i_renamed);
            java.nio.FloatBuffer floatBufferA2 = a_renamed(j_renamed);
            floatBufferA.position(0);
            floatBufferA2.position(0);
            android.opengl.GLES32.glVertexAttribPointer(0, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA);
            android.opengl.GLES32.glVertexAttribPointer(1, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA2);
            android.opengl.GLES32.glEnableVertexAttribArray(0);
            android.opengl.GLES32.glEnableVertexAttribArray(1);
            android.opengl.GLES32.glDrawArrays(5, 0, 4);
            a_renamed();
            android.opengl.GLES32.glDisableVertexAttribArray(0);
            android.opengl.GLES32.glDisableVertexAttribArray(1);
            android.opengl.GLES32.glBindTexture(3553, 0);
            android.opengl.GLES32.glUseProgram(0);
            a_renamed();
            return 0;
        }
        i6 = iB - iC;
        android.opengl.GLES32.glUseProgram(this.k_renamed);
        android.opengl.GLES32.glActiveTexture(33984);
        android.opengl.GLES32.glViewport(hVar.h_renamed(), i6, iA, iK);
        android.opengl.GLES32.glBindTexture(3553, i2);
        android.opengl.GLES32.glUniform1i(this.l_renamed, 0);
        a_renamed();
        java.nio.FloatBuffer floatBufferA3 = a_renamed(i_renamed);
        java.nio.FloatBuffer floatBufferA22 = a_renamed(j_renamed);
        floatBufferA3.position(0);
        floatBufferA22.position(0);
        android.opengl.GLES32.glVertexAttribPointer(0, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA3);
        android.opengl.GLES32.glVertexAttribPointer(1, 2, 5126, false, 0, (java.nio.Buffer) floatBufferA22);
        android.opengl.GLES32.glEnableVertexAttribArray(0);
        android.opengl.GLES32.glEnableVertexAttribArray(1);
        android.opengl.GLES32.glDrawArrays(5, 0, 4);
        a_renamed();
        android.opengl.GLES32.glDisableVertexAttribArray(0);
        android.opengl.GLES32.glDisableVertexAttribArray(1);
        android.opengl.GLES32.glBindTexture(3553, 0);
        android.opengl.GLES32.glUseProgram(0);
        a_renamed();
        return 0;
    }

    @Override // com.oplus.camera.gl_renamed.b_renamed.c_renamed
    public void c_renamed() {
        android.opengl.GLES20.glDeleteProgram(this.k_renamed);
        this.k_renamed = 0;
        this.f4601c = 0;
        this.e_renamed = 0;
        this.l_renamed = 0;
    }
}
