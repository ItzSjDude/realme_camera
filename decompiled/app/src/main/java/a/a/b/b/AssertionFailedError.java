package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class b_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public float q_renamed;
    public float r_renamed;
    public int s_renamed;
    public float[] t_renamed;

    public b_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("paint_overlay"), context);
        this.q_renamed = 1.0f;
        this.r_renamed = 1.0f;
        this.s_renamed = 0;
        this.t_renamed = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        k_renamed();
        j_renamed();
        e_renamed();
        h_renamed();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_OVERLAY);
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "overlayMask"), 1, this.t_renamed, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.q_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "overlayMix"), this.r_renamed);
    }
}
