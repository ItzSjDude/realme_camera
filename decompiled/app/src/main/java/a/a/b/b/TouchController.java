package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class l_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public l_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("grain"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
        a_renamed(new java.lang.String[]{"grain_amount", "grain_size"});
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "scale"), this.f15a.zoom);
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
    }
}
