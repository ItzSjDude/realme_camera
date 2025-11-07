package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class as_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.as_renamed> q_renamed = new android.util.LruCache<>(5);

    public as_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("distortion_multitexture"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("fringing_vertex");
        a_renamed(new java.lang.String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.as_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.as_renamed asVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (asVar == null) {
            asVar = new a_renamed.a_renamed.b_renamed.b_renamed.as_renamed(resources, context);
            asVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), asVar);
        }
        asVar.a_renamed(context);
        return asVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            android.opengl.GLES20.glActiveTexture(33984 + i_renamed);
            android.opengl.GLES20.glBindTexture(3553, this.f15a.textures[i_renamed]);
        }
        android.opengl.GLES20.glUniform1iv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "textures[0]"), 4, new int[]{0, 1, 2, 3}, 0);
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
    }
}
