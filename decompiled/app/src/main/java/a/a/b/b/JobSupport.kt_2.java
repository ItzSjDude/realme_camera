package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bg_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed> q_renamed = new android.util.LruCache<>(5);
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed r_renamed;
    public float[] s_renamed;
    public float t_renamed;
    public float u_renamed;
    public float v_renamed;
    public float[] w_renamed;

    public bg_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("layer"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("layer_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed bgVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (bgVar == null) {
            bgVar = new a_renamed.a_renamed.b_renamed.b_renamed.bg_renamed(resources, context);
            bgVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), bgVar);
        }
        bgVar.a_renamed(context);
        return bgVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "layerTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.r_renamed.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        if (this.s_renamed != null) {
            android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "colorOverlay"), 1, this.s_renamed, 0);
        }
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "backgroundMatrix"), 1, false, this.w_renamed, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.t_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "blendMode"), this.u_renamed);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "blendMix"), this.v_renamed);
    }
}
