package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class h_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.h_renamed> q_renamed = new android.util.LruCache<>(5);
    public float[] r_renamed;
    public float s_renamed;

    public h_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("fill"), context);
        this.r_renamed = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        this.s_renamed = 0.0f;
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.h_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.h_renamed hVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (hVar == null) {
            hVar = new a_renamed.a_renamed.b_renamed.b_renamed.h_renamed(resources, context);
            hVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), hVar);
        }
        hVar.a_renamed(context);
        return hVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "fill_color"), 1, this.r_renamed, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "fill_blend"), this.s_renamed);
    }
}
