package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class au_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.au_renamed> q_renamed = new android.util.LruCache<>(5);

    public au_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("out"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("distortion_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.au_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.au_renamed auVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (auVar == null) {
            auVar = new a_renamed.a_renamed.b_renamed.b_renamed.au_renamed(resources, context);
            auVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), auVar);
        }
        auVar.a_renamed(context);
        return auVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "original");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.imageTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation2, dVar.f35b, dVar.f36c);
    }
}
