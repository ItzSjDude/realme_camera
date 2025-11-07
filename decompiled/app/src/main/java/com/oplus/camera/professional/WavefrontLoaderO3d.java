package com.oplus.camera.professional;

/* compiled from: NightProMenuManager.java */
/* loaded from: classes2.dex */
public class o_renamed extends com.oplus.camera.professional.r_renamed {
    public o_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, java.lang.String str) {
        super(activity, aVar, cameraUIInterface, str);
    }

    @Override // com.oplus.camera.professional.r_renamed
    public java.util.HashMap<java.lang.String, java.lang.String> a_renamed() {
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("pref_professional_iso_key", "100");
        map.put("pref_professional_exposure_time_key", "1/50s");
        map.put("pref_professional_whitebalance_key", "2000");
        map.put("pref_professional_focus_mode_key", "0.00");
        return map;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void d_renamed() {
        this.g_renamed = new com.oplus.camera.professional.m_renamed(this.f5208c, this.e_renamed);
        this.g_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(this.k_renamed, this.f5207b), this.f_renamed, y_renamed());
    }

    private com.oplus.camera.professional.p_renamed.a_renamed y_renamed() {
        com.oplus.camera.professional.p_renamed.a_renamed configData = this.g_renamed.getConfigData();
        configData.f5204b = 15625000L;
        return configData;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void e_renamed() {
        if (this.j_renamed != null) {
            this.j_renamed.setVisibility(0);
        }
        b_renamed(0);
        this.e_renamed.d_renamed(true);
        k_renamed();
    }

    @Override // com.oplus.camera.professional.r_renamed
    public boolean c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("NightProMenuManager", "onBackPressed");
        if (this.i_renamed == null || !this.i_renamed.isSelected()) {
            return false;
        }
        this.i_renamed.a_renamed();
        this.g_renamed.e_renamed();
        this.e_renamed.a_renamed(true, true);
        this.e_renamed.d_renamed(true);
        if (!this.h_renamed.i_renamed()) {
            this.d_renamed.a_renamed(0, 1);
        }
        this.d_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r, -1, false, false, true);
        this.d_renamed.d_renamed(0);
        this.d_renamed.d_renamed(true, false);
        this.h_renamed.g_renamed();
        this.h_renamed.b_renamed(true);
        return true;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public boolean a_renamed(final boolean z_renamed) {
        if (this.g_renamed != null && this.g_renamed.g_renamed()) {
            com.oplus.camera.e_renamed.c_renamed("NightProMenuManager", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        if (!z_renamed && this.g_renamed != null && (!this.g_renamed.g_renamed(1) || !this.g_renamed.g_renamed(2))) {
            return false;
        }
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.o_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("NightProMenuManager", "onBeforeSnapping isInNightProProcess: " + z_renamed);
                if (z_renamed && com.oplus.camera.professional.o_renamed.this.h_renamed.b_renamed()) {
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.o_renamed.this.j_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                }
                com.oplus.camera.professional.o_renamed.this.j_renamed.setTouchState(false);
            }
        });
        return true;
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void a_renamed(long j_renamed) {
        this.h_renamed.a_renamed(j_renamed);
    }

    @Override // com.oplus.camera.professional.r_renamed
    public void a_renamed(byte[] bArr, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("NightProMenuManager", "onAfterPictureTaken isInNightProProcess: " + z2 + ", mbNeedShowMenuAfterTakePicture: " + this.f5206a);
        if (z2) {
            c_renamed(0);
            this.d_renamed.as_renamed();
            if (this.h_renamed.b_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
                a_renamed(0, false);
            }
            this.d_renamed.g_renamed(true);
            this.d_renamed.a_renamed(this.h_renamed.h_renamed(), false);
            if (!i_renamed()) {
                if (!this.d_renamed.d_renamed() && !this.h_renamed.i_renamed()) {
                    this.d_renamed.a_renamed(0, 1);
                }
                this.d_renamed.d_renamed(0);
                this.e_renamed.a_renamed(true, false);
            }
        }
        this.d_renamed.d_renamed(true, false);
        if (this.f5206a) {
            if (this.h_renamed.b_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
            this.f5206a = false;
        }
        this.j_renamed.setTouchState(true);
    }
}
