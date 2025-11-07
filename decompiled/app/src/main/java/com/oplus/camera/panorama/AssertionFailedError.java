package com.oplus.camera.panorama;

/* compiled from: ClockwiseDirection.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.panorama.c_renamed {
    @Override // com.oplus.camera.panorama.c_renamed
    public float b_renamed(float f_renamed) {
        return f_renamed;
    }

    @Override // com.oplus.camera.panorama.c_renamed
    public float c_renamed(float f_renamed) {
        return f_renamed;
    }

    public b_renamed(android.content.Context context) {
        super(context);
    }

    @Override // com.oplus.camera.panorama.c_renamed
    protected float[] a_renamed(int i_renamed, int i2) {
        c_renamed();
        this.g_renamed[0] = this.k_renamed;
        this.g_renamed[1] = this.j_renamed;
        float f_renamed = i_renamed;
        this.g_renamed[2] = f_renamed - this.k_renamed;
        this.g_renamed[3] = 0.0f;
        this.g_renamed[4] = f_renamed - this.k_renamed;
        float f2 = i2;
        this.g_renamed[5] = f2;
        this.g_renamed[6] = this.k_renamed;
        this.g_renamed[7] = f2 - this.j_renamed;
        return this.g_renamed;
    }

    @Override // com.oplus.camera.panorama.c_renamed
    public java.lang.String a_renamed(android.content.Context context) {
        return context.getResources().getString(com.oplus.camera.R_renamed.string.camera_panorama_front_left_rotato);
    }

    @Override // com.oplus.camera.panorama.c_renamed
    public void a_renamed(float f_renamed) {
        if (java.lang.Float.compare(1.0f, f_renamed) == 0) {
            this.f4939b = this.f4940c;
            this.l_renamed = true;
            this.j_renamed = this.h_renamed;
            this.k_renamed = this.i_renamed;
            return;
        }
        this.f4939b = this.f4940c * f_renamed;
        this.k_renamed = this.i_renamed * f_renamed;
        this.j_renamed = this.h_renamed * f_renamed;
    }
}
