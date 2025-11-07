package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class g_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.g_renamed> q_renamed = new android.util.LruCache<>(5);
    public float[] r_renamed;

    public g_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("blur_mask"), context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.g_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.g_renamed gVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (gVar == null) {
            gVar = new a_renamed.a_renamed.b_renamed.b_renamed.g_renamed(resources, context);
            gVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), gVar);
        }
        gVar.a_renamed(context);
        return gVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "delta"), 1, this.r_renamed, 0);
    }
}
