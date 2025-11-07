package com.oplus.camera.professional;

/* compiled from: ProSwitchButtonManager.java */
/* loaded from: classes2.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f5219a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.CameraUIInterface f5220b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.capmode.a_renamed f5221c;
    private android.content.SharedPreferences d_renamed;
    private com.oplus.camera.ui.SwitchButton.a_renamed e_renamed = null;
    private com.oplus.camera.ui.SwitchButton f_renamed = null;
    private java.lang.String g_renamed = null;

    public s_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5219a = activity;
        this.f5220b = cameraUIInterface;
        this.f5221c = aVar;
        this.d_renamed = this.f5221c.t_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "setChecked: " + z_renamed);
        com.oplus.camera.ui.SwitchButton switchButton = this.f_renamed;
        if (switchButton == null) {
            return;
        }
        switchButton.setChecked(z_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "unInit");
        a_renamed(8, false);
        if (this.f_renamed != null) {
            this.f5220b.b_renamed().removeView(this.f_renamed);
        }
    }

    public void a_renamed(final int i_renamed, final boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "setVisibility: " + i_renamed);
        this.f5219a.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.s_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                if (i_renamed == 0) {
                    com.oplus.camera.professional.s_renamed.this.b_renamed(z_renamed);
                } else {
                    com.oplus.camera.professional.s_renamed.this.c_renamed(z_renamed);
                }
            }
        });
    }

    public boolean b_renamed() {
        com.oplus.camera.ui.SwitchButton switchButton = this.f_renamed;
        return switchButton != null && switchButton.getVisibility() == 0;
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "onAfterStartPreview");
        if ((1 == java.lang.Integer.parseInt(this.d_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0)))) || this.f5220b.aw_renamed() || this.f5220b.A_renamed()) {
            return;
        }
        a_renamed(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "showSwitch, needAnimation: " + z_renamed);
        if (this.f5220b.b_renamed() == null || this.f5220b.R_renamed()) {
            return;
        }
        if (this.f_renamed == null) {
            g_renamed();
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.f_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else {
            this.f_renamed.setVisibility(0);
        }
    }

    public void a_renamed(java.lang.String str) {
        this.g_renamed = str;
    }

    private void g_renamed() {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "initSwitchButton");
        this.f_renamed = new com.oplus.camera.ui.SwitchButton(this.f5219a.getApplicationContext());
        this.f_renamed.setVisibility(8);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f5219a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.super_eis_switch_width), this.f5219a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.super_eis_switch_height));
        layoutParams.addRule(20);
        layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        boolean zEquals = "on_renamed".equals(this.d_renamed.getString(this.g_renamed, "off"));
        if (zEquals) {
            layoutParams.bottomMargin = this.f5219a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_pro_switch_on_margin_bottom);
        } else {
            layoutParams.bottomMargin = this.f5219a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_pro_switch_off_margin_bottom);
        }
        layoutParams.setMarginStart(this.f5219a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.super_eis_switch_margin_left));
        this.f_renamed.setChecked(zEquals);
        this.f_renamed.a_renamed(com.oplus.camera.util.Util.a_renamed((android.content.Context) this.f5219a, com.oplus.camera.R_renamed.drawable.switch_button_pro_mode), com.oplus.camera.util.Util.a_renamed((android.content.Context) this.f5219a, com.oplus.camera.R_renamed.drawable.switch_button_pro_mode_bg));
        if (this.f5220b.b_renamed().indexOfChild(this.f_renamed) == -1) {
            this.f5220b.b_renamed().addView(this.f_renamed, layoutParams);
        }
        this.f_renamed.setSwitchClickableListener(new com.oplus.camera.ui.SwitchButton.c_renamed() { // from class: com.oplus.camera.professional.s_renamed.2
            @Override // com.oplus.camera.ui.SwitchButton.c_renamed
            public boolean a_renamed() {
                return (!com.oplus.camera.professional.s_renamed.this.f5221c.Y_renamed() || com.oplus.camera.professional.s_renamed.this.f_renamed.a_renamed() || com.oplus.camera.professional.s_renamed.this.f5221c.S_renamed()) ? false : true;
            }
        });
        this.f_renamed.setOnCheckedChangeListener(new com.oplus.camera.ui.SwitchButton.a_renamed() { // from class: com.oplus.camera.professional.s_renamed.3
            @Override // com.oplus.camera.ui.SwitchButton.a_renamed
            public void a_renamed(com.oplus.camera.ui.SwitchButton switchButton, boolean z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("ProSwitchButtonManager", "initSwitchButton, onCheckedChanged, isChecked: " + z_renamed);
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) com.oplus.camera.professional.s_renamed.this.f_renamed.getLayoutParams();
                if (z_renamed) {
                    layoutParams2.bottomMargin = com.oplus.camera.professional.s_renamed.this.f5219a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_pro_switch_on_margin_bottom);
                } else {
                    layoutParams2.bottomMargin = com.oplus.camera.professional.s_renamed.this.f5219a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_pro_switch_off_margin_bottom);
                }
                com.oplus.camera.professional.s_renamed.this.f_renamed.setLayoutParams(layoutParams2);
                com.oplus.camera.professional.s_renamed.this.d_renamed.edit().putString(com.oplus.camera.professional.s_renamed.this.g_renamed, z_renamed ? "on_renamed" : "off").apply();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "hideSwitch, needAnimation: " + z_renamed);
        if (this.f_renamed == null) {
            com.oplus.camera.e_renamed.b_renamed("ProSwitchButtonManager", "hideSwitch, mProSwitchButton is_renamed null");
            return;
        }
        if (this.f5220b.b_renamed() == null) {
            com.oplus.camera.e_renamed.f_renamed("ProSwitchButtonManager", "hideSwitch, mCameraRootView is_renamed null");
        } else if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.f_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else {
            this.f_renamed.setVisibility(8);
        }
    }

    public void d_renamed() {
        com.oplus.camera.ui.SwitchButton switchButton = this.f_renamed;
        if (switchButton != null) {
            switchButton.setClickable(false);
        }
    }

    public void e_renamed() {
        com.oplus.camera.ui.SwitchButton switchButton = this.f_renamed;
        if (switchButton != null) {
            switchButton.setClickable(true);
        }
    }

    public void f_renamed() {
        com.oplus.camera.ui.SwitchButton switchButton = this.f_renamed;
        if (switchButton != null) {
            switchButton.setClickable(true);
        }
    }
}
