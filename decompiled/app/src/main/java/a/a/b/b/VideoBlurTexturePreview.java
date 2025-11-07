package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public final class ac_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed> q_renamed = new android.util.LruCache<>(5);
    public float[] r_renamed;
    public float[] s_renamed;
    public float t_renamed;
    public float u_renamed;
    public float v_renamed;
    public float w_renamed;

    public ac_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mask_gradient"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed acVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (acVar == null) {
            acVar = new a_renamed.a_renamed.b_renamed.b_renamed.ac_renamed(resources, context);
            acVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), acVar);
        }
        acVar.a_renamed(context);
        return acVar;
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
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "invert"), this.t_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "reflect"), this.u_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.v_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "alpha"), this.w_renamed);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "endPoint"), 1, this.s_renamed, 0);
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "startPoint"), 1, this.r_renamed, 0);
    }
}
