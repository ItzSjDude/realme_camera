package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ay_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed> q_renamed = new android.util.LruCache<>(5);
    public int r_renamed;

    public ay_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("paint_blend"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed ayVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (ayVar == null) {
            ayVar = new a_renamed.a_renamed.b_renamed.b_renamed.ay_renamed(resources, context);
            ayVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), ayVar);
        }
        ayVar.a_renamed(context);
        return ayVar;
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
    }
}
