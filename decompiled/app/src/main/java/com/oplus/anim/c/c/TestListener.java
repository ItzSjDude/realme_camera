package com.oplus.anim.c_renamed.c_renamed;

/* compiled from: SolidLayer.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.anim.c_renamed.c_renamed.a_renamed {
    private final android.graphics.RectF e_renamed;
    private final android.graphics.Paint f_renamed;
    private final float[] g_renamed;
    private final android.graphics.Path h_renamed;
    private final com.oplus.anim.c_renamed.c_renamed.d_renamed i_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> j_renamed;

    g_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.d_renamed dVar) {
        super(bVar, dVar);
        this.e_renamed = new android.graphics.RectF();
        this.f_renamed = new com.oplus.anim.a_renamed.a_renamed();
        this.g_renamed = new float[8];
        this.h_renamed = new android.graphics.Path();
        this.i_renamed = dVar;
        this.f_renamed.setAlpha(0);
        this.f_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.f_renamed.setColor(dVar.p_renamed());
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed
    public void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        int iAlpha = android.graphics.Color.alpha(this.i_renamed.p_renamed());
        if (iAlpha == 0) {
            return;
        }
        com.oplus.anim.k_renamed.c_renamed("SolidLayer#draw");
        int iIntValue = (int) ((i_renamed / 255.0f) * (((iAlpha / 255.0f) * (this.d_renamed.a_renamed() == null ? 100 : this.d_renamed.a_renamed().g_renamed().intValue())) / 100.0f) * 255.0f);
        this.f_renamed.setAlpha(iIntValue);
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.j_renamed;
        if (aVar != null) {
            this.f_renamed.setColorFilter(aVar.g_renamed());
        }
        if (iIntValue > 0) {
            float[] fArr = this.g_renamed;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.i_renamed.r_renamed();
            float[] fArr2 = this.g_renamed;
            fArr2[3] = 0.0f;
            fArr2[4] = this.i_renamed.r_renamed();
            this.g_renamed[5] = this.i_renamed.q_renamed();
            float[] fArr3 = this.g_renamed;
            fArr3[6] = 0.0f;
            fArr3[7] = this.i_renamed.q_renamed();
            matrix.mapPoints(this.g_renamed);
            this.h_renamed.reset();
            android.graphics.Path path = this.h_renamed;
            float[] fArr4 = this.g_renamed;
            path.moveTo(fArr4[0], fArr4[1]);
            android.graphics.Path path2 = this.h_renamed;
            float[] fArr5 = this.g_renamed;
            path2.lineTo(fArr5[2], fArr5[3]);
            android.graphics.Path path3 = this.h_renamed;
            float[] fArr6 = this.g_renamed;
            path3.lineTo(fArr6[4], fArr6[5]);
            android.graphics.Path path4 = this.h_renamed;
            float[] fArr7 = this.g_renamed;
            path4.lineTo(fArr7[6], fArr7[7]);
            android.graphics.Path path5 = this.h_renamed;
            float[] fArr8 = this.g_renamed;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.h_renamed.close();
            canvas.drawPath(this.h_renamed, this.f_renamed);
        }
        com.oplus.anim.k_renamed.d_renamed("SolidLayer#draw");
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        this.e_renamed.set(0.0f, 0.0f, this.i_renamed.r_renamed(), this.i_renamed.q_renamed());
        this.f3614a.mapRect(this.e_renamed);
        rectF.set(this.e_renamed);
    }

    @Override // com.oplus.anim.c_renamed.c_renamed.a_renamed, com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        super.a_renamed((com.oplus.anim.c_renamed.c_renamed.g_renamed) t_renamed, (com.oplus.anim.g_renamed.b_renamed<com.oplus.anim.c_renamed.c_renamed.g_renamed>) bVar);
        if (t_renamed == com.oplus.anim.d_renamed.z_renamed) {
            if (bVar == null) {
                this.j_renamed = null;
            } else {
                this.j_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
            }
        }
    }
}
