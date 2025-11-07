package com.oplus.camera.ui.preview;

/* compiled from: SwitchAnimManager.java */
/* loaded from: classes2.dex */
public class aa_renamed implements com.oplus.camera.ui.preview.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f6978a = {70.0f, 110.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f6979b = {0.2f, 0.25f};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static float f6980c = 600.0f;
    private long d_renamed = 0;
    private int e_renamed = 0;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private com.oplus.camera.ui.preview.aa_renamed.a_renamed h_renamed = new com.oplus.camera.ui.preview.aa_renamed.a_renamed(0.27f, 0.5f, 0.25f, 1.0f);
    private float i_renamed = 0.0f;
    private android.content.Context j_renamed = null;
    private float k_renamed = 0.0f;
    private float l_renamed = 0.0f;
    private float m_renamed = 0.0f;
    private float n_renamed = 1.0f;
    private com.oplus.camera.ui.preview.h_renamed.d_renamed o_renamed;

    @Override // com.oplus.camera.ui.preview.c_renamed
    public void a_renamed(int i_renamed) {
        f6980c = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public void a_renamed(int i_renamed, int i2) {
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public void b_renamed(int i_renamed, int i2) {
        this.g_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public void a_renamed(android.content.Context context, com.oplus.camera.ui.preview.h_renamed.d_renamed dVar) {
        this.d_renamed = android.os.SystemClock.uptimeMillis();
        this.i_renamed = context.getResources().getDisplayMetrics().density;
        this.j_renamed = context;
        float[] fArr = f6978a;
        this.k_renamed = (fArr[1] - fArr[0]) / 2.0f;
        float[] fArr2 = f6979b;
        this.l_renamed = (fArr2[1] - fArr2[0]) / this.k_renamed;
        this.o_renamed = dVar;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public boolean b_renamed() {
        return ((float) (android.os.SystemClock.uptimeMillis() - this.d_renamed)) > f6980c;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public boolean a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, com.oplus.camera.gl_renamed.c_renamed cVar) {
        android.content.Context context;
        float fUptimeMillis = android.os.SystemClock.uptimeMillis() - this.d_renamed;
        float f_renamed = f6980c;
        if (fUptimeMillis > f_renamed) {
            return false;
        }
        float interpolation = this.h_renamed.getInterpolation(fUptimeMillis / f_renamed);
        if (this.m_renamed <= 0.5f && interpolation > 0.5f && (context = this.j_renamed) != null) {
            ((android.app.Activity) context).runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.aa_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.aa_renamed.this.o_renamed != null) {
                        com.oplus.camera.ui.preview.aa_renamed.this.o_renamed.b_renamed();
                    }
                }
            });
        }
        this.m_renamed = interpolation;
        a_renamed(hVar, interpolation, 180.0f * interpolation);
        float f2 = i3;
        float f3 = i_renamed + (f2 / 2.0f);
        float f4 = i4;
        float f5 = i2 + (f4 / 2.0f);
        if (interpolation < 0.1f) {
            float f6 = 1.0f - ((interpolation / 0.1f) * 0.1f);
            float f7 = f2 * f6;
            float f8 = f6 * f4;
            cVar.a_renamed(hVar, java.lang.Math.round(f3 - (f7 / 2.0f)), java.lang.Math.round(f5 - (f8 / 2.0f)), java.lang.Math.round(f7), java.lang.Math.round(f8));
            return true;
        }
        float f9 = interpolation - 0.1f;
        if (f9 < 0.8f) {
            float f10 = f2 * 0.9f;
            float f11 = f4 * 0.9f;
            int iRound = java.lang.Math.round(f3 - (f10 / 2.0f));
            int iRound2 = java.lang.Math.round(f5 - (f11 / 2.0f));
            if (f9 < 0.4f) {
                hVar.a_renamed(f3, 0.0f);
                hVar.a_renamed((f9 / 0.4f) * 90.0f, 0.0f, 1.0f, 0.0f, 0.0f, i4 / 2, f4 * this.i_renamed);
                hVar.a_renamed(-f3, 0.0f);
                cVar.a_renamed(hVar, iRound, iRound2, java.lang.Math.round(f10), java.lang.Math.round(f11));
                return true;
            }
            hVar.a_renamed(f3, 0.0f);
            hVar.a_renamed(270.0f + (((f9 - 0.4f) / 0.4f) * 90.0f), 0.0f, 1.0f, 0.0f, 0.0f, i4 / 2, f4 * this.i_renamed);
            hVar.a_renamed(-f3, 0.0f);
            cVar.a_renamed(hVar, iRound, iRound2, java.lang.Math.round(f10), java.lang.Math.round(f11));
            return true;
        }
        float f12 = 1.0f - (((1.0f - interpolation) / 0.1f) * 0.1f);
        float f13 = f2 * f12;
        float f14 = f12 * f4;
        cVar.a_renamed(hVar, java.lang.Math.round(f3 - (f13 / 2.0f)), java.lang.Math.round(f5 - (f14 / 2.0f)), java.lang.Math.round(f13), java.lang.Math.round(f14));
        return true;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public boolean b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4, com.oplus.camera.gl_renamed.c_renamed cVar) {
        float f_renamed;
        float f2 = i3;
        float f3 = i_renamed + (f2 / 2.0f);
        float f4 = i2 + (i4 / 2.0f);
        int i5 = this.g_renamed;
        if (i5 != 0) {
            f_renamed = f2 / i5;
        } else {
            com.oplus.camera.e_renamed.f_renamed("SwitchAnimManager", "mPreviewFrameLayoutWidth is_renamed 0.");
            f_renamed = 1.0f;
        }
        float f5 = this.e_renamed * f_renamed;
        float f6 = this.f_renamed * f_renamed;
        int iRound = java.lang.Math.round(f3 - (f5 / 2.0f));
        int iRound2 = java.lang.Math.round(f4 - (f6 / 2.0f));
        float fB_renamed = hVar.b_renamed();
        hVar.a_renamed(0.8f);
        cVar.a_renamed(hVar, iRound, iRound2, java.lang.Math.round(f5), java.lang.Math.round(f6));
        hVar.a_renamed(fB_renamed);
        return true;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, float f_renamed, float f2) {
        float f3 = (1.0f - (f_renamed * f_renamed)) + 0.4f;
        if (f_renamed >= 0.7f) {
            hVar.a_renamed(f3);
            this.n_renamed = f3;
        }
        float[] fArr = f6978a;
        if (fArr[0] > f2 || f2 > fArr[1]) {
            return;
        }
        float fAbs = (java.lang.Math.abs(90.0f - f2) * this.l_renamed) + f6979b[0];
        hVar.a_renamed(fAbs);
        this.n_renamed = fAbs;
    }

    @Override // com.oplus.camera.ui.preview.c_renamed
    public float a_renamed() {
        return this.n_renamed;
    }

    /* compiled from: SwitchAnimManager.java */
    private class a_renamed extends android.view.animation.PathInterpolator {
        a_renamed(float f_renamed, float f2, float f3, float f4) {
            super(f_renamed, f2, f3, f4);
        }
    }
}
