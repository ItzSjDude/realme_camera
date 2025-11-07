package com.oplus.camera.professional;

/* compiled from: HighPictureProMenuManager.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.camera.professional.r_renamed {

    /* compiled from: HighPictureProMenuManager.java */
    public interface a_renamed extends com.oplus.camera.professional.r_renamed.b_renamed {
        void b_renamed(long j_renamed);
    }

    public j_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, java.lang.String str) {
        super(activity, aVar, cameraUIInterface, str);
    }

    @Override // com.oplus.camera.professional.r_renamed
    public java.util.HashMap<java.lang.String, java.lang.String> a_renamed() {
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("pref_professional_iso_key", "100");
        map.put("pref_professional_exposure_time_key", "1/50s");
        map.put("pref_professional_whitebalance_key", "2000");
        map.put("pref_professional_focus_mode_key", "0.00");
        map.put("pref_professional_exposure_compensation_key", "0.00");
        return map;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void b_renamed() {
        if (this.g_renamed != null) {
            this.g_renamed.scrollTo(3, this.g_renamed.c_renamed(3).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.f5208c, 3)));
        }
    }

    @Override // com.oplus.camera.professional.r_renamed
    public boolean c_renamed() {
        if (this.i_renamed == null || !this.i_renamed.isSelected()) {
            return false;
        }
        if (!this.h_renamed.i_renamed()) {
            this.d_renamed.a_renamed(0, 1);
        }
        this.g_renamed.e_renamed();
        this.i_renamed.a_renamed();
        this.h_renamed.g_renamed();
        this.h_renamed.b_renamed(true);
        return true;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void a_renamed(long j_renamed) {
        ((com.oplus.camera.professional.j_renamed.a_renamed) this.h_renamed).b_renamed(j_renamed);
        super.a_renamed(j_renamed);
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void a_renamed(byte[] bArr, boolean z_renamed, boolean z2) {
        if (d_renamed(w_renamed()) && !i_renamed()) {
            this.d_renamed.a_renamed(0, 1);
        }
        super.a_renamed(bArr, z_renamed, z2);
    }
}
