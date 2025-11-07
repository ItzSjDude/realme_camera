package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class n_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.n_renamed> q_renamed = new android.util.LruCache<>(5);
    public int r_renamed;

    public n_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("unmask"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.n_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.n_renamed nVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (nVar == null) {
            nVar = new a_renamed.a_renamed.b_renamed.b_renamed.n_renamed(resources, context);
            nVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), nVar);
        }
        nVar.a_renamed(context);
        return nVar;
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
    }
}
