package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bx_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public bx_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("sharpen"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("sharpen_vertex");
        a_renamed(new java.lang.String[]{"sharpen"});
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "step");
        co_renamed.polarr.renderer.entities.Context context = this.f15a;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.imageTexture;
        float f_renamed = context.zoom;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, (1.0f / dVar.f35b) * f_renamed, (1.0f / dVar.f36c) * f_renamed);
    }
}
