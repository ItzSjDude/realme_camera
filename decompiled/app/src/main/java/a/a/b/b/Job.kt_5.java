package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bj_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed> q_renamed = new android.util.LruCache<>(5);

    public bj_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("distortion"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("fringing_vertex");
        a_renamed(new java.lang.String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed bjVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (bjVar == null) {
            bjVar = new a_renamed.a_renamed.b_renamed.b_renamed.bj_renamed(resources, context);
            bjVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), bjVar);
        }
        bjVar.a_renamed(context);
        return bjVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        return false;
    }
}
