package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class e_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.e_renamed> q_renamed = new android.util.LruCache<>(5);
    public float[] r_renamed;

    public e_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("denoise_nlm1"), context);
        this.r_renamed = new float[15];
        a_renamed(new java.lang.String[]{"delta"});
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.e_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.e_renamed eVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (eVar == null) {
            eVar = new a_renamed.a_renamed.b_renamed.b_renamed.e_renamed(resources, context);
            eVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), eVar);
        }
        eVar.a_renamed(context);
        return eVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "textureResolution");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation, dVar.f35b, dVar.f36c);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "kernel[0]");
        float[] fArr = this.r_renamed;
        android.opengl.GLES20.glUniform1fv(iGlGetUniformLocation2, fArr.length, fArr, 0);
    }
}
