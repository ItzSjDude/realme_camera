package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: FilterMenuCanvas2D.java */
/* loaded from: classes2.dex */
class h_renamed extends com.oplus.camera.ui.menu.levelcontrol.a_renamed {
    private int H_renamed;
    private int I_renamed;
    private int J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private int N_renamed;
    private int O_renamed;
    private int P_renamed;
    private int Q_renamed;
    private int R_renamed;
    private int S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;
    private int X_renamed;
    private int Y_renamed;
    private float Z_renamed;
    private java.lang.String w_renamed = null;
    private java.lang.String x_renamed = null;
    private java.lang.String y_renamed = null;
    private int z_renamed = 0;
    private int A_renamed = 0;
    private int B_renamed = 0;
    private int C_renamed = 0;
    private int D_renamed = 0;
    private int E_renamed = 0;
    private int F_renamed = 0;
    private int G_renamed = 0;

    public h_renamed(android.content.Context context, int i_renamed) {
        this.H_renamed = i_renamed;
        c_renamed(context);
    }

    private void c_renamed(android.content.Context context) {
        b_renamed(context);
        int i_renamed = this.H_renamed;
        this.N_renamed = (1 == i_renamed || 4 == i_renamed) ? 1 : 0;
        this.O_renamed = 1 == this.H_renamed ? 1 : 0;
        this.Z_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.effects_menu_fade_range);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        this.i_renamed.add(6);
        float[] fArr = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        float[] fArr2 = {1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        this.j_renamed.add(floatBufferAsFloatBuffer);
        java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(fArr2.length * 4);
        byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2);
        floatBufferAsFloatBuffer2.position(0);
        this.k_renamed.add(floatBufferAsFloatBuffer2);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    protected void b_renamed(android.content.Context context) {
        this.w_renamed = com.oplus.camera.util.k_renamed.a_renamed("filter_menu.vert", context.getResources());
        this.x_renamed = com.oplus.camera.util.k_renamed.a_renamed("filter_menu.frag", context.getResources());
        this.z_renamed = com.oplus.camera.util.k_renamed.b_renamed(this.w_renamed, this.x_renamed);
        this.B_renamed = android.opengl.GLES20.glGetAttribLocation(this.z_renamed, "aPosition");
        this.C_renamed = android.opengl.GLES20.glGetAttribLocation(this.z_renamed, "aTexCoor");
        this.A_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uMVPMatrix");
        this.I_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "fadeOn");
        this.J_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "isVertical");
        this.K_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "height");
        this.L_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "width");
        this.M_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "fadeRange");
        this.P_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "sTexture");
        this.Q_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "sFilterName");
        this.R_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "hasFilterName");
        this.S_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uSurfaceSize");
        this.T_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uRingRadius");
        this.U_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uRingThickness");
        this.V_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uRingOffsetCenterY");
        this.W_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uRingOffsetCenterX");
        this.X_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uDrawRing");
        this.Y_renamed = android.opengl.GLES20.glGetUniformLocation(this.z_renamed, "uRingTintColor");
        this.y_renamed = com.oplus.camera.util.k_renamed.a_renamed("frag_oes_tex.sh", context.getResources());
        this.D_renamed = com.oplus.camera.util.k_renamed.b_renamed(this.w_renamed, this.y_renamed);
        this.E_renamed = android.opengl.GLES20.glGetAttribLocation(this.D_renamed, "aPosition");
        this.G_renamed = android.opengl.GLES20.glGetAttribLocation(this.D_renamed, "aTexCoor");
        this.F_renamed = android.opengl.GLES20.glGetUniformLocation(this.D_renamed, "uMVPMatrix");
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void e_renamed(int i_renamed, int i2) {
        android.opengl.GLES20.glViewport(0, 0, this.f6472a, this.f6473b);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(1, 0);
        android.opengl.GLES20.glUseProgram(this.z_renamed);
        android.opengl.GLES20.glDisable(2929);
        android.opengl.GLES20.glDisable(2884);
        android.opengl.GLES20.glUniformMatrix4fv(this.A_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        android.opengl.GLES20.glUniform1i(this.I_renamed, this.N_renamed);
        android.opengl.GLES20.glUniform1f(this.L_renamed, this.f6472a);
        android.opengl.GLES20.glUniform1f(this.K_renamed, this.f6473b);
        android.opengl.GLES20.glUniform1i(this.J_renamed, this.O_renamed);
        android.opengl.GLES20.glUniform1f(this.M_renamed, this.Z_renamed);
        android.opengl.GLES20.glUniform1i(this.P_renamed, 0);
        android.opengl.GLES20.glUniform1i(this.Q_renamed, 1);
        android.opengl.GLES20.glUniform1i(this.R_renamed, 1);
        android.opengl.GLES20.glUniform1i(this.X_renamed, 0);
        android.opengl.GLES20.glVertexAttribPointer(this.B_renamed, 3, 5126, false, 12, (java.nio.Buffer) this.j_renamed.get(i2));
        android.opengl.GLES20.glVertexAttribPointer(this.C_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed.get(i2));
        android.opengl.GLES20.glEnableVertexAttribArray(this.B_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.C_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.p_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(i2).intValue());
        f_renamed();
        android.opengl.GLES20.glDisableVertexAttribArray(this.B_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.C_renamed);
    }

    public void f_renamed() {
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(this.g_renamed, this.h_renamed, 1.0f);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed(this.e_renamed, this.f_renamed, 1.0f);
        android.opengl.GLES20.glUniformMatrix4fv(this.A_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        android.opengl.GLES20.glUniform1i(this.I_renamed, 0);
        android.opengl.GLES20.glUniform1i(this.R_renamed, 0);
        android.opengl.GLES20.glUniform1i(this.X_renamed, 1);
        android.opengl.GLES20.glUniform1f(this.T_renamed, this.r_renamed);
        android.opengl.GLES20.glUniform1f(this.U_renamed, this.s_renamed);
        android.opengl.GLES20.glUniform1f(this.W_renamed, this.t_renamed);
        android.opengl.GLES20.glUniform1f(this.V_renamed, this.u_renamed);
        android.opengl.GLES20.glUniform2fv(this.S_renamed, 1, this.q_renamed, 0);
        android.opengl.GLES20.glUniform4fv(this.Y_renamed, 1, this.v_renamed, 0);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(0).intValue());
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void f_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
        android.opengl.GLES20.glUseProgram(this.D_renamed);
        android.opengl.GLES20.glUniformMatrix4fv(this.F_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.d_renamed(), 0);
        android.opengl.GLES20.glVertexAttribPointer(this.E_renamed, 3, 5126, false, 12, (java.nio.Buffer) this.j_renamed.get(0));
        android.opengl.GLES20.glVertexAttribPointer(this.G_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed.get(0));
        android.opengl.GLES20.glEnableVertexAttribArray(this.E_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.G_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, i_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(0).intValue());
        android.opengl.GLES20.glDisableVertexAttribArray(this.E_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.G_renamed);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
    }
}
