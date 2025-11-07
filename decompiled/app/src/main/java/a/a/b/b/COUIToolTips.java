package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class s_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.s_renamed> q_renamed = new android.util.LruCache<>(5);
    public float r_renamed;
    public float[] s_renamed;
    public float t_renamed;
    public float u_renamed;

    public s_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mask_brush"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.s_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.s_renamed sVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (sVar == null) {
            sVar = new a_renamed.a_renamed.b_renamed.b_renamed.s_renamed(resources, context);
            sVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), sVar);
        }
        sVar.a_renamed(context);
        return sVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "brushTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.paintTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "invert"), this.r_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.t_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "alpha"), this.u_renamed);
        if (this.s_renamed != null) {
            android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "channel"), 1, this.s_renamed, 0);
        }
    }
}
