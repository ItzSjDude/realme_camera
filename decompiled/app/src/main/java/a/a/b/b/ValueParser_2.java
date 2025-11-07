package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class aj_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed> r_renamed = new android.util.LruCache<>(5);
    public float s_renamed;
    public float[] t_renamed;
    public float[] u_renamed;
    public float[] v_renamed;
    public float w_renamed;
    public float x_renamed;
    public float y_renamed;

    public aj_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("spot_heal"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("spot_heal_vertex");
    }

    public aj_renamed(android.content.res.Resources resources, java.lang.String str, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, str, context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed b_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed ajVar = r_renamed.get(java.lang.Thread.currentThread().getName());
        if (ajVar == null) {
            ajVar = new a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed(resources, context);
            ajVar.a_renamed();
            r_renamed.put(java.lang.Thread.currentThread().getName(), ajVar);
        }
        ajVar.a_renamed(context);
        return ajVar;
    }

    public static void n_renamed() {
        r_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "smoothTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.dehazeTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "originalTexture");
        android.opengl.GLES20.glActiveTexture(33986);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.imageTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "retouchTexture");
        android.opengl.GLES20.glActiveTexture(33987);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.retouchTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation3, 3);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
        int iGlGetUniformLocation4 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation4, dVar.f35b, dVar.f36c);
        o_renamed();
    }

    public void o_renamed() {
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "feather"), this.s_renamed);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE), 1, this.t_renamed, 0);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "position"), 1, this.u_renamed, 0);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "sourcePosition"), 1, this.v_renamed, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.x_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "angle"), this.w_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "mode"), this.y_renamed);
    }
}
