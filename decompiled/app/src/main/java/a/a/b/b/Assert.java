package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class a_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public float q_renamed;

    public a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("lookup_export_filter"), context);
        this.q_renamed = 0.0f;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "lut_color_space"), this.q_renamed);
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "img_size");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        return !this.f15a.isLutRender;
    }
}
