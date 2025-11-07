package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ak_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed> q_renamed = new android.util.LruCache<>(5);
    public float A_renamed;
    public float r_renamed;
    public float s_renamed;
    public float t_renamed;
    public float u_renamed;
    public float[] v_renamed;
    public float[] w_renamed;
    public float x_renamed;
    public float y_renamed;
    public float[] z_renamed;

    public ak_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mask_color"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("distortion_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed akVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (akVar == null) {
            akVar = new a_renamed.a_renamed.b_renamed.b_renamed.ak_renamed(resources, context);
            akVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), akVar);
        }
        akVar.a_renamed(context);
        return akVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "colorMap");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.dehazeTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation2, dVar.f35b, dVar.f36c);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "feather"), this.r_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "invert"), this.s_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "useRadius"), this.t_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "threshold"), this.u_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.x_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "alpha"), this.y_renamed);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "position"), 1, this.v_renamed, 0);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE), 1, this.w_renamed, 0);
        float[] fArr = this.z_renamed;
        if (fArr != null && fArr.length == 3) {
            android.opengl.GLES20.glUniform3fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "selectedColor"), 1, this.z_renamed, 0);
        }
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "useSelectedColor"), this.A_renamed);
    }
}
