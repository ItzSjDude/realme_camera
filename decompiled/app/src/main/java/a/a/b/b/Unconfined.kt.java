package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bq_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed> q_renamed = new android.util.LruCache<>(5);
    public a_renamed.a_renamed.b_renamed.c_renamed.f_renamed r_renamed;
    public co_renamed.polarr.renderer.entities.Context.FaceState s_renamed;

    public bq_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("face"), context);
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("distortion_vertex");
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed bqVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (bqVar == null) {
            bqVar = new a_renamed.a_renamed.b_renamed.b_renamed.bq_renamed(resources, context);
            bqVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), bqVar);
        }
        bqVar.a_renamed(context);
        return bqVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "smoothMap");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.dehazeTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "faceMask");
        android.opengl.GLES20.glActiveTexture(33986);
        android.opengl.GLES20.glBindTexture(3553, this.r_renamed.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        if (this.s_renamed != null) {
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_smoothness"), this.s_renamed.skin_smoothness);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_tone"), this.s_renamed.skin_tone);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_hue"), this.s_renamed.skin_hue);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_saturation"), this.s_renamed.skin_saturation);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_shadows"), this.s_renamed.skin_shadows);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "skin_highlights"), this.s_renamed.skin_highlights);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "teeth_whitening"), this.s_renamed.teeth_whitening);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "teeth_brightness"), this.s_renamed.teeth_brightness);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "eyes_brightness"), this.s_renamed.eyes_brightness);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "eyes_contrast"), this.s_renamed.eyes_contrast);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "eyes_clarity"), this.s_renamed.eyes_clarity);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "lips_brightness"), this.s_renamed.lips_brightness);
            android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "lips_saturation"), this.s_renamed.lips_saturation);
        }
    }
}
