package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class aw_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed> q_renamed = new android.util.LruCache<>(5);
    public java.lang.String r_renamed;
    public float s_renamed;
    public float t_renamed;
    public float u_renamed;
    public int v_renamed;

    public aw_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mosaic"), context);
        this.r_renamed = "square";
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed awVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (awVar == null) {
            awVar = new a_renamed.a_renamed.b_renamed.b_renamed.aw_renamed(resources, context);
            awVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), awVar);
        }
        awVar.a_renamed(context);
        return awVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> map;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "blurTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.v_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        java.lang.String str = this.r_renamed;
        if (str != null && (map = this.f15a.patterns) != null && (dVar = map.get(str)) != null) {
            int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "patternTexture");
            android.opengl.GLES20.glActiveTexture(33986);
            android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
            android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
            android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "patternSize"), dVar.f35b, dVar.f36c);
        }
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "mosaic_size"), (float) (this.s_renamed * java.lang.Math.sqrt((this.t_renamed * this.u_renamed) / 2073600.0f)));
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.m_renamed, 0);
        android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize"), this.t_renamed, this.u_renamed);
    }
}
