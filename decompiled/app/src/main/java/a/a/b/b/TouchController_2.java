package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class m_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.m_renamed> q_renamed = new android.util.LruCache<>(5);

    public m_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("watermark"), context);
        a_renamed(new java.lang.String[]{"opacity"});
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.m_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.m_renamed mVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (mVar == null) {
            mVar = new a_renamed.a_renamed.b_renamed.b_renamed.m_renamed(resources, context);
            mVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), mVar);
        }
        mVar.a_renamed(context);
        return mVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void e_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        co_renamed.polarr.renderer.entities.Context context = this.f15a;
        if (context.watermarkTexture != null) {
            co_renamed.polarr.renderer.entities.Context.WatermarkOptions watermarkOptions = context.watermarkOptions;
            if (watermarkOptions.enabled || watermarkOptions.preview) {
                n_renamed();
                super.j_renamed();
                int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "texture");
                android.opengl.GLES20.glActiveTexture(33984);
                android.opengl.GLES20.glBindTexture(3553, this.f15a.watermarkTexture.f34a);
                android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 0);
                android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, "opacity"), this.f15a.watermarkOptions.opacity);
            }
        }
    }

    public final void n_renamed() {
        float[] fArrA = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.a_renamed(this.f15a);
        co_renamed.polarr.renderer.entities.Context context = this.f15a;
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = context.watermarkTexture;
        float f_renamed = dVar.f35b;
        float f2 = dVar.f36c;
        float f3 = fArrA[2];
        float f4 = fArrA[3];
        float[] fArrB = a_renamed.a_renamed.b_renamed.f_renamed.h_renamed.b_renamed(context);
        if (this.f15a.cropMode) {
            f3 = fArrB[0];
            f4 = fArrB[1];
        }
        float f5 = f_renamed / f3;
        float f6 = f2 / f4;
        co_renamed.polarr.renderer.entities.Context.WatermarkOptions watermarkOptions = this.f15a.watermarkOptions;
        float[] fArr = watermarkOptions.position;
        float f7 = watermarkOptions.scale;
        float f8 = watermarkOptions.rotation;
        float fMax = java.lang.Math.max(f5, f6);
        float f9 = (f5 / fMax) * f7;
        float f10 = (f6 / fMax) * f7;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArrB[0] / 2.0f;
        float f14 = fArrB[1] / 2.0f;
        float f15 = fArrA[0];
        float f16 = this.f15a.cropScale;
        float[] fArr2 = {((f15 - f13) * f16) + f13, ((fArrA[1] - f14) * f16) + f14, fArrA[2] * f16, fArrA[3] * f16};
        float f17 = (fArrB[0] - fArr2[2]) / 2.0f;
        float f18 = fArr2[0];
        float f19 = (fArrB[1] - fArr2[3]) / 2.0f;
        float f20 = fArr2[1];
        float f21 = (-(f17 - f18)) / fArr2[2];
        float f22 = (-(f19 - f20)) / fArr2[3];
        float f23 = fArr2[2] / fArrB[0];
        float f24 = fArr2[3] / fArrB[1];
        float[] fArrA2 = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        android.opengl.Matrix.multiplyMM(fArrA2, 0, fArrA2, 0, this.f15a.viewMatrix, 0);
        android.opengl.Matrix.scaleM(fArrA2, 0, this.f15a.viewMatrix, 0, f23, f24, 1.0f);
        android.opengl.Matrix.translateM(fArrA2, 0, f21 * 2.0f, f22 * 2.0f, 0.0f);
        android.opengl.Matrix.translateM(fArrA2, 0, f11 - (f9 * f11), f12 - (f10 * f12), 0.0f);
        android.opengl.Matrix.scaleM(fArrA2, 0, 1.0f / f3, 1.0f / f4, 1.0f);
        android.opengl.Matrix.rotateM(fArrA2, 0, f8, 0.0f, 0.0f, 1.0f);
        android.opengl.Matrix.scaleM(fArrA2, 0, f3, f4, 1.0f);
        android.opengl.Matrix.scaleM(fArrA2, 0, f9, f10, 1.0f);
        a_renamed(fArrA2);
    }
}
