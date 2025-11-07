package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class aq_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed> q_renamed = new android.util.LruCache<>(5);
    public int r_renamed;
    public float[] s_renamed;
    public float[] t_renamed;
    public float u_renamed;
    public float[] v_renamed;

    public aq_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("initialize_field"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("patchmatch_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed aqVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (aqVar == null) {
            aqVar = new a_renamed.a_renamed.b_renamed.b_renamed.aq_renamed(resources, context);
            aqVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), aqVar);
        }
        aqVar.a_renamed(context);
        return aqVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "source");
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, this.r_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 0);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "source_size");
        float[] fArr = this.s_renamed;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation2, fArr[0], fArr[1]);
        int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "full_size");
        float[] fArr2 = this.t_renamed;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation3, fArr2[0], fArr2[1]);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "seed"), this.u_renamed);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_REGION), 1, false, this.v_renamed, 0);
    }
}
