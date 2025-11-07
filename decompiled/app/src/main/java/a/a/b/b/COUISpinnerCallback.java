package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class p_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public java.lang.String q_renamed;

    public p_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("mosaic"), context);
        this.q_renamed = "square";
        this.o_renamed = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("composite_vertex");
        a_renamed(new java.lang.String[]{"mosaic_size"});
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        float fSqrt;
        java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> map;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar;
        java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> map2;
        super.j_renamed();
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "blurTexture");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.f15a.denoiseTexture.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
        if (this.f15a.renderStates.containsKey("mosaic_pattern")) {
            java.lang.Object obj = this.f15a.renderStates.get("mosaic_pattern");
            if ((obj instanceof java.lang.String) && (map2 = this.f15a.patterns) != null && map2.containsKey(obj)) {
                this.q_renamed = (java.lang.String) obj;
            }
        }
        java.lang.String str = this.q_renamed;
        if (str != null && (map = this.f15a.patterns) != null && (dVar = map.get(str)) != null) {
            int iGlGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "patternTexture");
            android.opengl.GLES20.glActiveTexture(33986);
            android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
            android.opengl.GLES20.glUniform1i(iGlGetUniformLocation2, 2);
            android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "patternSize"), dVar.f35b, dVar.f36c);
        }
        if (this.f15a.isSDK) {
            int iGlGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "mosaic_size");
            java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("mosaic_size", this.f15a.renderStates);
            if (objA != null) {
                double d_renamed = java.lang.Float.parseFloat(objA.toString());
                a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2 = this.f15a.imageTexture;
                fSqrt = (float) (d_renamed * java.lang.Math.sqrt((dVar2.f35b * dVar2.f36c) / 2073600.0f));
            } else {
                fSqrt = 0.0f;
            }
            android.opengl.GLES20.glUniform1f(iGlGetUniformLocation3, fSqrt);
        }
        android.opengl.GLES20.glUniformMatrix4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, "viewMatrix"), 1, false, this.f15a.matrix, 0);
        int iGlGetUniformLocation4 = android.opengl.GLES20.glGetUniformLocation(this.f16b, "imgSize");
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar3 = this.f15a.imageTexture;
        android.opengl.GLES20.glUniform2f(iGlGetUniformLocation4, dVar3.f35b, dVar3.f36c);
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_amount"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_amount", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_horizontal"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_horizontal", this.f15a.renderStates)).floatValue());
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "distortion_vertical"), ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed("distortion_vertical", this.f15a.renderStates)).floatValue());
    }
}
