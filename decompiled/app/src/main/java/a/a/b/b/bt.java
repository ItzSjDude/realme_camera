package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bt_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public float q_renamed;
    public float r_renamed;

    public bt_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("gausspyd"), context);
    }

    public void d_renamed(int i_renamed, int i2) {
        this.q_renamed = i_renamed;
        this.r_renamed = i2;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE), this.q_renamed, this.r_renamed);
    }
}
