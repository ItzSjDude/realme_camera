package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bk_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed> q_renamed = new android.util.LruCache<>(5);
    public int r_renamed;
    public int s_renamed;
    public int t_renamed;

    public bk_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("paint_split"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed bkVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (bkVar == null) {
            bkVar = new a_renamed.a_renamed.b_renamed.b_renamed.bk_renamed(resources, context);
            bkVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), bkVar);
        }
        bkVar.a_renamed(context);
        return bkVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "source");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.r_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "prePainting");
        android.opengl.GLES20.glActiveTexture(33986);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "curBrush");
        android.opengl.GLES20.glActiveTexture(33987);
        android.opengl.GLES20.glBindTexture(3553, this.t_renamed);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation3, 3);
    }
}
