package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class aa_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public aa_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_SCREEN), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("screen_vertex");
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "cacheTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, b_renamed());
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.cacheTexture.f34a);
        float[] fArr = (float[]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("grid_size", this.f15a.renderStates);
        android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "grid_size"), fArr[0], fArr[1]);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "showTexture"), 1.0f);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "cropMatrix"), 1, false, this.f15a.cropMatrix, 0);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.viewMatrix, 0);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "img_size");
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(this.f15a);
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation2, fArrA[2], fArrA[3]);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_ZOOM), this.f15a.screen.zoom);
    }
}
