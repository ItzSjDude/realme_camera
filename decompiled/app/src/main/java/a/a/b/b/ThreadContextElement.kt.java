package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bl_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed> q_renamed = new android.util.LruCache<>(5);
    public float[] r_renamed;

    public bl_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR), context);
        a_renamed(new java.lang.String[]{com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR});
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed blVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (blVar == null) {
            blVar = new a_renamed.a_renamed.b_renamed.b_renamed.bl_renamed(resources, context);
            blVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), blVar);
        }
        blVar.a_renamed(context);
        return blVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "delta");
        float[] fArr = this.r_renamed;
        android.opengl.GLES20.glUniform2fv(iGlGetUniformLocation, fArr.length / 2, fArr, 0);
    }
}
