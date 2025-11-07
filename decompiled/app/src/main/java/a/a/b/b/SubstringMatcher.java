package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class k_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public k_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("vignette"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
        a_renamed(new java.lang.String[]{"vignette_amount", "vignette_feather", "vignette_highlights", "vignette_roundness", "vignette_size"});
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "crop");
        float[] fArr = (float[]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("crop", this.f15a.renderStates);
        float[] fArrCopyOf = java.util.Arrays.copyOf(fArr, fArr.length);
        fArrCopyOf[1] = (1.0f - fArrCopyOf[3]) - fArrCopyOf[1];
        android.opengl.GLES20.glUniform4fv(iGlGetUniformLocation, 1, fArrCopyOf, 0);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "rotationMatrix"), 1, false, this.f15a.rotation90MatrixInv, 0);
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(this.f15a);
        android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize"), fArrB[0], fArrB[1]);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
    }
}
