package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class af_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.af_renamed> q_renamed = new android.util.LruCache<>(5);

    public af_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("spot_heal_multitexture"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("spot_heal_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.af_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.af_renamed afVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (afVar == null) {
            afVar = new a_renamed.a_renamed.b_renamed.b_renamed.af_renamed(resources, context);
            afVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), afVar);
        }
        afVar.a_renamed(context);
        return afVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.aj_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "smoothTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.dehazeTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "retouchTexture");
        android.opengl.GLES20.glActiveTexture(33986);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.retouchTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        android.opengl.GLES20.glUniform1iv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "textures[0]"), 4, new int[]{3, 4, 5, 6}, 0);
        for (int i_renamed = 1; i_renamed <= 4; i_renamed++) {
            android.opengl.GLES20.glActiveTexture(33984 + i_renamed + 2);
            android.opengl.GLES20.glBindTexture(3553, this.f15a.textures[i_renamed - 1]);
        }
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
        int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation3, dVar.f35b, dVar.f36c);
        o_renamed();
    }
}
