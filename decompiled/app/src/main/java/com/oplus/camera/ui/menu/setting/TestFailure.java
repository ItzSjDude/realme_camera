package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraDrawerSettingUI.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.ui.menu.setting.o_renamed implements com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed {
    private com.oplus.camera.ui.menu.setting.down.DrawerLayout o_renamed;
    private android.animation.AnimatorSet p_renamed;
    private boolean q_renamed;
    private float r_renamed;
    private com.oplus.camera.ui.menu.setting.f_renamed.a_renamed s_renamed;
    private int t_renamed;
    private boolean u_renamed;

    /* compiled from: CameraDrawerSettingUI.java */
    public interface a_renamed {
        void a_renamed(boolean z_renamed);
    }

    public f_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.CameraUIListener cameraUIListener, boolean z_renamed) {
        super(activity, comboPreferences, cameraUIListener, z_renamed);
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = false;
        this.r_renamed = 1.0f;
        this.s_renamed = null;
        this.t_renamed = 0;
        this.u_renamed = false;
        this.o_renamed = (com.oplus.camera.ui.menu.setting.down.DrawerLayout) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward);
        this.o_renamed.setOnDrawerListener(this);
        this.o_renamed.setPreferences(comboPreferences);
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        if (3 == this.t_renamed) {
            b_renamed(1 == i_renamed);
        }
        super.a_renamed(i_renamed, z_renamed, z2, z3);
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraDrawerSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.k_renamed);
        com.oplus.camera.e_renamed.a_renamed("CameraDrawerSettingUI.initializeCameraSettingMenu");
        if (this.k_renamed != null) {
            android.view.ViewStub viewStub = (android.view.ViewStub) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.viewstub_drawer_menu);
            if (viewStub != null) {
                this.j_renamed = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) viewStub.inflate().findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
                this.i_renamed.bL_renamed().a_renamed(this.g_renamed, this.j_renamed);
            } else {
                this.j_renamed = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
            }
            com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
            if (drawerLayout != null) {
                drawerLayout.a_renamed();
            }
            this.j_renamed.a_renamed(this.h_renamed, this.i_renamed, this.k_renamed, this.l_renamed, true);
        }
        if (this.i_renamed != null) {
            this.i_renamed.aV_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI.initializeCameraSettingMenu");
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "setCameraDrawerSettingOpenAndClose, isOpen: " + i_renamed);
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.setOpenAndClose(i_renamed == 0);
        }
    }

    public void b_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.d_renamed();
        }
    }

    public boolean c_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.e_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void d_renamed() {
        if (this.j_renamed != null) {
            this.j_renamed.a_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void e_renamed() {
        if (this.i_renamed != null) {
            this.i_renamed.p_renamed("3");
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void f_renamed() {
        n_renamed();
        if (!k_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "onArrowClick, can't_renamed response arrow click, so return");
            return;
        }
        if (this.h_renamed != null) {
            this.h_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, j_renamed() ? "off" : "on_renamed").apply();
        }
        if (this.i_renamed != null) {
            this.i_renamed.p_renamed("1");
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void g_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.f_renamed();
            n_renamed();
        }
        android.animation.AnimatorSet animatorSet = this.p_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.p_renamed.removeAllListeners();
        }
        this.q_renamed = false;
        com.oplus.camera.ui.menu.setting.f_renamed.a_renamed aVar = this.s_renamed;
        if (aVar != null) {
            aVar.a_renamed(false);
        }
        super.g_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void h_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.b_renamed();
        }
        super.h_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void i_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.g_renamed();
        }
        super.i_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void a_renamed(boolean z_renamed) {
        if (this.h_renamed != null) {
            java.lang.String string = this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off");
            com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "onShowAndHide, value: " + string + ", isOpen: " + z_renamed);
            if ("on_renamed".equals(string) != z_renamed) {
                if (this.n_renamed != null) {
                    this.n_renamed.ap_renamed(z_renamed);
                }
                this.h_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, z_renamed ? "on_renamed" : "off").apply();
            }
            if (z_renamed) {
                this.h_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, false).apply();
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public boolean j_renamed() {
        return this.h_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").equals("on_renamed");
    }

    public boolean a_renamed(long j_renamed) {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        return drawerLayout != null && drawerLayout.a_renamed(j_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void a_renamed(float f_renamed) {
        if (this.g_renamed == null) {
            return;
        }
        com.oplus.camera.ui.inverse.e_renamed.INS.setMaskAlpha(this.g_renamed, f_renamed);
        if (1.0f > f_renamed) {
            n_renamed();
        }
        if (0.85f < f_renamed && this.q_renamed && f_renamed > this.r_renamed) {
            this.q_renamed = false;
            com.oplus.camera.ui.menu.setting.f_renamed.a_renamed aVar = this.s_renamed;
            if (aVar != null) {
                aVar.a_renamed(false);
            }
        } else if (0.95f > f_renamed && !this.q_renamed && f_renamed < this.r_renamed) {
            this.q_renamed = true;
            com.oplus.camera.ui.menu.setting.f_renamed.a_renamed aVar2 = this.s_renamed;
            if (aVar2 != null) {
                aVar2.a_renamed(true);
            }
        }
        this.r_renamed = f_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public boolean k_renamed() {
        if (this.i_renamed != null) {
            return (2 == this.i_renamed.n_renamed() || t_renamed() || this.i_renamed.aY_renamed() || !this.i_renamed.w_renamed() || !this.i_renamed.bJ_renamed()) ? false : true;
        }
        return true;
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        if (this.n_renamed != null) {
            this.n_renamed.a_renamed(z_renamed, z2, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void l_renamed() {
        super.r_renamed();
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        this.t_renamed = i_renamed;
        this.u_renamed = z_renamed;
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.a_renamed(i_renamed, i2, z_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.o_renamed.getLayoutParams();
        if (z_renamed) {
            marginLayoutParams.topMargin = this.g_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_split_screen_front_setting_topMargin_offset);
        } else {
            marginLayoutParams.topMargin = 0;
        }
    }

    public void a_renamed(com.oplus.camera.ui.menu.setting.f_renamed.a_renamed aVar) {
        this.s_renamed = aVar;
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        if (this.o_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "enableCameraSettingMenu, enable: " + z_renamed);
            this.o_renamed.setEnabled(z_renamed);
        }
        if (this.j_renamed != null) {
            this.j_renamed.a_renamed(z_renamed, true);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void c_renamed(boolean z_renamed) {
        if (this.o_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "hideCameraSettingMenu, isEnabled: " + z_renamed);
            this.o_renamed.setRollVisibility(4);
            this.o_renamed.setEnabled(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void m_renamed() {
        if (this.o_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "showCameraSettingMenu");
            this.o_renamed.setRollVisibility(0);
            this.o_renamed.setEnabled(true);
        }
    }

    public void n_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.c_renamed();
        }
    }

    public boolean o_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.h_renamed();
        }
        return false;
    }

    public boolean p_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.i_renamed();
        }
        return false;
    }

    public boolean q_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.getEnableTouch();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed
    public void r_renamed() {
        if (t_renamed() || this.o_renamed.j_renamed()) {
            return;
        }
        super.r_renamed();
    }

    public boolean s_renamed() {
        boolean z_renamed;
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayListJ = J_renamed();
        if (copyOnWriteArrayListJ != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayListJ.iterator();
            while (it.hasNext()) {
                if (a_renamed(it.next().a_renamed())) {
                    z_renamed = true;
                    break;
                }
            }
            z_renamed = false;
        } else {
            z_renamed = false;
        }
        com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingUI", "willSubMenuShow: " + z_renamed);
        return z_renamed;
    }

    public boolean t_renamed() {
        android.animation.AnimatorSet animatorSet = this.p_renamed;
        return animatorSet != null && animatorSet.isRunning();
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public boolean u_renamed() {
        return this.i_renamed != null && this.i_renamed.bq_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void v_renamed() {
        if (this.i_renamed != null) {
            this.i_renamed.aA_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed
    public void w_renamed() {
        if (this.i_renamed != null) {
            this.i_renamed.aB_renamed();
        }
    }

    public void x_renamed() {
        android.animation.AnimatorSet animatorSet = this.p_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.setEnableTouch(z_renamed);
        }
    }

    public boolean y_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.k_renamed();
        }
        return false;
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            return drawerLayout.a_renamed(motionEvent);
        }
        return false;
    }

    public void z_renamed() {
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = this.o_renamed;
        if (drawerLayout != null) {
            drawerLayout.l_renamed();
        }
    }
}
