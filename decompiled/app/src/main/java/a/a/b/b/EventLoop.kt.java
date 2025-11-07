package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public final class ap_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed> q_renamed = new android.util.LruCache<>(5);
    public float r_renamed;
    public float s_renamed;
    public float t_renamed;
    public float[] u_renamed;
    public float[] v_renamed;
    public float w_renamed;
    public float x_renamed;

    public ap_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mask_radial"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed apVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (apVar == null) {
            apVar = new a_renamed.a_renamed.b_renamed.b_renamed.ap_renamed(resources, context);
            apVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), apVar);
        }
        apVar.a_renamed(context);
        return apVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "feather"), this.r_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "invert"), this.s_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "angle"), this.t_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.w_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "alpha"), this.x_renamed);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "position");
        if (this.f15a.isSDK) {
            float[] fArr = this.u_renamed;
            android.opengl.GLES20.glUniform2f(iGlGetUniformLocation2, fArr[0], -fArr[1]);
        } else {
            android.opengl.GLES20.glUniform2fv(iGlGetUniformLocation2, 1, this.u_renamed, 0);
        }
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE), 1, this.v_renamed, 0);
    }
}
