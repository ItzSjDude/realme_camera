package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class by_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static final float[] q_renamed = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] r_renamed = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.5f, -0.5f, 1.0f};
    public static final float[] s_renamed = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 0.5f, 1.0f};
    public static final float[] t_renamed = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] u_renamed = {-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] v_renamed = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed w_renamed;
    public float[] x_renamed;
    public float[] y_renamed;
    public float z_renamed;

    public by_renamed(android.content.res.Resources resources, java.lang.String str, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, str, context);
        this.x_renamed = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        this.y_renamed = new float[9];
        this.z_renamed = 1.0f;
        m_renamed();
    }

    public void a_renamed(float f_renamed) {
        this.z_renamed = f_renamed;
    }

    public void a_renamed(float f_renamed, float f2, float f3, float f4) {
        float[] fArr = this.x_renamed;
        fArr[0] = f_renamed;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
    }

    public final void a_renamed(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[3] * fArr3[1]) + (fArr2[6] * fArr3[2]);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[7] * fArr3[2]);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[8] * fArr3[2]);
        fArr[3] = (fArr2[0] * fArr3[3]) + (fArr2[3] * fArr3[4]) + (fArr2[6] * fArr3[5]);
        fArr[4] = (fArr2[1] * fArr3[3]) + (fArr2[4] * fArr3[4]) + (fArr2[7] * fArr3[5]);
        fArr[5] = (fArr2[2] * fArr3[3]) + (fArr2[5] * fArr3[4]) + (fArr2[8] * fArr3[5]);
        fArr[6] = (fArr2[0] * fArr3[6]) + (fArr2[3] * fArr3[7]) + (fArr2[6] * fArr3[8]);
        fArr[7] = (fArr2[1] * fArr3[6]) + (fArr2[4] * fArr3[7]) + (fArr2[7] * fArr3[8]);
        fArr[8] = (fArr2[2] * fArr3[6]) + (fArr2[5] * fArr3[7]) + (fArr2[8] * fArr3[8]);
    }

    public void b_renamed(int i_renamed) {
        int i2 = i_renamed % 360;
        if (i2 == 0) {
            m_renamed();
            return;
        }
        if (90 == i2 || -270 == i2) {
            float[] fArr = t_renamed;
            float[] fArr2 = this.y_renamed;
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return;
        }
        if (180 == i2 || -180 == i2) {
            float[] fArr3 = u_renamed;
            float[] fArr4 = this.y_renamed;
            java.lang.System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        } else {
            if (270 == i2 || -90 == i2) {
                float[] fArr5 = v_renamed;
                float[] fArr6 = this.y_renamed;
                java.lang.System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
                return;
            }
            double radians = java.lang.Math.toRadians(i2);
            float fSin = (float) java.lang.Math.sin(radians);
            float fCos = (float) java.lang.Math.cos(radians);
            float[] fArr7 = new float[9];
            a_renamed(fArr7, new float[]{fCos, fSin, 0.0f, -fSin, fCos, 0.0f, 0.0f, 0.0f, 1.0f}, r_renamed);
            a_renamed(this.y_renamed, s_renamed, fArr7);
        }
    }

    public void b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        this.w_renamed = dVar;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        a_renamed(b_renamed(), 0);
        a_renamed(this.w_renamed, 1);
        a_renamed("texture", 0);
        a_renamed("sprite", 1);
        a_renamed("spriteMatrix", this.y_renamed);
        float[] fArr = this.x_renamed;
        a_renamed("bkgndCrop", fArr[0], fArr[1], fArr[2], fArr[3]);
        a_renamed("opacity", this.z_renamed);
    }

    public final void m_renamed() {
        float[] fArr = q_renamed;
        float[] fArr2 = this.y_renamed;
        java.lang.System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }
}
