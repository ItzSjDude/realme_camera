package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class x_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public boolean q_renamed;
    public float r_renamed;

    public x_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_OVERLAY), context);
        this.r_renamed = 1.0f;
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
        android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "overlayMask"), 1, this.f15a.overlayMask, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.r_renamed);
    }
}
