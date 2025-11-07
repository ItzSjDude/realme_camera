package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraSettingUI.java */
/* loaded from: classes2.dex */
public class o_renamed implements com.oplus.camera.d_renamed {
    public android.app.Activity g_renamed;
    public com.oplus.camera.ComboPreferences h_renamed;
    public com.oplus.camera.ui.CameraUIListener i_renamed;
    private boolean q_renamed;
    public com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel j_renamed = null;
    public com.oplus.camera.ui.menu.h_renamed k_renamed = null;
    public int l_renamed = 0;
    protected boolean m_renamed = false;
    protected com.oplus.camera.ui.menu.setting.o_renamed.a_renamed n_renamed = null;
    private com.oplus.camera.ui.menu.setting.o_renamed.b_renamed o_renamed = null;
    private boolean p_renamed = false;
    private int r_renamed = 1;
    private int s_renamed = 0;
    private java.util.ArrayList<java.lang.String> t_renamed = new java.util.ArrayList<>();
    private android.view.animation.PathInterpolator u_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator v_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private int w_renamed = 0;

    /* compiled from: CameraSettingUI.java */
    public interface a_renamed {
        void a_renamed(boolean z_renamed, boolean z2, int i_renamed);

        void ap_renamed(boolean z_renamed);

        java.util.ArrayList<java.lang.String> dg_renamed();

        void m_renamed(java.lang.String str);

        void n_renamed(java.lang.String str);
    }

    public boolean j_renamed() {
        return false;
    }

    public o_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.CameraUIListener cameraUIListener, boolean z_renamed) {
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.q_renamed = false;
        this.g_renamed = activity;
        this.h_renamed = comboPreferences;
        this.i_renamed = cameraUIListener;
        this.q_renamed = z_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.menu.setting.o_renamed.a_renamed aVar) {
        this.n_renamed = aVar;
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || !cameraSettingMenuPanel.isShown() || !a_renamed(this.j_renamed, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "needTouchEvent, mCameraSettingMenu is_renamed show and dispatchTouchEvent");
        return true;
    }

    public void A_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setTranslationY(0.0f);
            this.j_renamed.setRotation(0.0f);
        }
    }

    public com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel B_renamed() {
        return this.j_renamed;
    }

    private boolean a_renamed(android.view.View view, int i_renamed, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i_renamed >= i3 && i_renamed <= view.getMeasuredWidth() + i3;
    }

    public void C_renamed() {
        this.o_renamed = new com.oplus.camera.ui.menu.setting.o_renamed.b_renamed();
        this.o_renamed.setName("ParseXmlThread");
        this.o_renamed.start();
    }

    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "onResumeMessage");
        this.m_renamed = false;
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c_renamed();
        }
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "onPause");
        this.p_renamed = false;
        this.m_renamed = true;
        e_renamed(false);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.e_renamed();
            this.j_renamed.clearAnimation();
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.i_renamed;
            if (cameraUIListener != null && cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING_SUPPORT) && !this.q_renamed) {
                this.j_renamed.setAlpha(1.0f);
            }
            this.j_renamed.setInitState(false);
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.h_renamed;
        if (comboPreferences != null && this.q_renamed) {
            comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
            f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        com.oplus.camera.ui.menu.g_renamed.f_renamed();
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "onDestroy");
        com.oplus.camera.ui.menu.setting.o_renamed.b_renamed bVar = this.o_renamed;
        if (bVar != null) {
            try {
                bVar.a_renamed();
                this.o_renamed = null;
            } catch (java.lang.Exception unused) {
            }
        }
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.o_renamed();
            this.j_renamed = null;
        }
        com.oplus.camera.ui.menu.h_renamed hVar = this.k_renamed;
        if (hVar != null) {
            hVar.a_renamed();
            this.k_renamed = null;
        }
        this.g_renamed = null;
        this.i_renamed = null;
    }

    public boolean D_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.j_renamed();
        }
        return false;
    }

    public void b_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setSizeRatioType(this.l_renamed);
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c_renamed(z_renamed, z2);
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(z_renamed, z2, i_renamed);
        }
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setCameraMenuLayout(z_renamed);
        }
    }

    public void E_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed();
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.ui.menu.setting.o_renamed.b_renamed bVar = this.o_renamed;
        if (bVar != null) {
            try {
                bVar.join();
            } catch (java.lang.InterruptedException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        this.p_renamed = true;
        if (this.j_renamed == null) {
            a_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.i_renamed;
        if (cameraUIListener != null && !cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU_UPDATED)) {
            r_renamed();
        }
        a_renamed(i_renamed, z2, z3);
    }

    public void F_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.k_renamed();
        }
    }

    public void d_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed();
            if (com.oplus.camera.util.Util.R_renamed() == 0) {
                com.oplus.camera.util.Util.a_renamed(this.j_renamed, com.oplus.camera.ui.c_renamed.a_renamed(this.g_renamed, 3), 300, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
            }
        }
    }

    public void G_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.l_renamed();
            this.j_renamed.setOrientation(this.s_renamed);
        }
    }

    public void b_renamed(float f_renamed) {
        a_renamed(f_renamed, false, 0L);
    }

    public void a_renamed(float f_renamed, boolean z_renamed, long j_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            if (z_renamed) {
                android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(f_renamed <= 0.0f ? 1.0f : 0.0f, f_renamed);
                alphaAnimation.setDuration(j_renamed);
                alphaAnimation.setInterpolator(this.u_renamed);
                this.j_renamed.startAnimation(alphaAnimation);
                return;
            }
            cameraSettingMenuPanel.setAlpha(f_renamed);
        }
    }

    public float H_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getAlpha();
        }
        return 1.0f;
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || this.q_renamed) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(i_renamed);
    }

    public void d_renamed(int i_renamed) {
        a_renamed(i_renamed, 0.0f, 0.0f);
    }

    public void a_renamed(int i_renamed, float f_renamed, float f2) {
        boolean z_renamed = (java.lang.Float.compare(f_renamed, 0.0f) == 0 && java.lang.Float.compare(f2, 0.0f) == 0) ? false : true;
        long j_renamed = z_renamed ? 400L : 0L;
        if (i_renamed == 0) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, i_renamed, f_renamed, f2, this.u_renamed, 400L, this.v_renamed, j_renamed, (android.view.animation.Animation.AnimationListener) null, z_renamed ? 150L : 0L);
        } else {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, i_renamed, f_renamed, f2, this.u_renamed, 250L, this.v_renamed, j_renamed, (android.view.animation.Animation.AnimationListener) null, 0L);
        }
    }

    public void a_renamed(boolean z_renamed, float f_renamed, float f2, android.animation.TimeInterpolator timeInterpolator, long j_renamed, android.animation.TimeInterpolator timeInterpolator2, long j2, long j3) {
        com.oplus.camera.util.Util.a_renamed(this.j_renamed, z_renamed, f_renamed, f2, timeInterpolator, j_renamed, timeInterpolator2, j2, (android.animation.Animator.AnimatorListener) null, j3);
    }

    public void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, i_renamed);
        }
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, z_renamed);
        }
    }

    public boolean I_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || cameraSettingMenuPanel.getVisibility() == 0) {
            return true;
        }
        com.oplus.camera.e_renamed.b_renamed("CameraSettingUI", "isCameraSettingMenuVisible, mCameraSettingMenu not visible");
        return false;
    }

    public void e_renamed(int i_renamed) {
        this.r_renamed = i_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.s_renamed = i_renamed;
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setOrientation(i_renamed);
        }
    }

    public void b_renamed(int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        a_renamed(i_renamed, z_renamed, z2, z3);
        f_renamed(true);
    }

    public void f_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.setInitState(z_renamed);
        }
    }

    public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> J_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuList();
        }
        return null;
    }

    public java.util.ArrayList<java.lang.String> K_renamed() {
        return this.t_renamed;
    }

    public void r_renamed() {
        this.t_renamed.clear();
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayListJ = J_renamed();
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "updateSettingMenu, mbCameraOpened: " + this.p_renamed + ", this: " + this);
        if (copyOnWriteArrayListJ == null || !this.p_renamed) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayListJ.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (this.q_renamed) {
                if (a_renamed(next.a_renamed())) {
                    d_renamed(next.a_renamed());
                    if (!this.i_renamed.m_renamed(next.a_renamed())) {
                        a_renamed(next.a_renamed(), next.m_renamed(null));
                    } else {
                        b_renamed(next.a_renamed(), (java.lang.String) null);
                    }
                } else {
                    e_renamed(next.a_renamed());
                }
            } else if (b_renamed(next.a_renamed())) {
                d_renamed(next.a_renamed());
                if (!this.i_renamed.m_renamed(next.a_renamed())) {
                    a_renamed(next.a_renamed(), next.m_renamed(null));
                } else {
                    b_renamed(next.a_renamed(), (java.lang.String) null);
                }
            } else if (!j_renamed(next.a_renamed())) {
                e_renamed(next.a_renamed());
            }
        }
        if (this.q_renamed) {
            if (this.t_renamed.isEmpty()) {
                this.n_renamed.n_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, this.r_renamed));
                com.oplus.camera.ui.CameraUIListener cameraUIListener = this.i_renamed;
                if (cameraUIListener != null && cameraUIListener.f_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING, this.r_renamed))) {
                    this.n_renamed.m_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING, this.r_renamed));
                    return;
                } else {
                    this.n_renamed.n_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING, this.r_renamed));
                    return;
                }
            }
            this.n_renamed.n_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING, this.r_renamed));
            com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.i_renamed;
            if (cameraUIListener2 == null || !cameraUIListener2.f_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, this.r_renamed)) || this.i_renamed.c_renamed()) {
                return;
            }
            this.n_renamed.m_renamed(com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, this.r_renamed));
        }
    }

    public boolean a_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.i_renamed;
        return cameraUIListener != null && cameraUIListener.g_renamed(str) && !this.n_renamed.dg_renamed().contains(str) && !(com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) && this.t_renamed.size() == 0) && (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(str) || com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS));
    }

    public boolean b_renamed(java.lang.String str) {
        return this.i_renamed.f_renamed(str) && this.t_renamed.size() < 4 && this.i_renamed.b_renamed(str) && !j_renamed(str);
    }

    private boolean j_renamed(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        return com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD);
    }

    public boolean L_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.getMenuPanelEnable();
        }
        return false;
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "enableCameraSettingMenu(), enable: " + z_renamed + ", ashed: " + z2);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(z_renamed, z2);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || this.q_renamed) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(4);
        this.j_renamed.setClickable(false);
    }

    public void m_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || this.q_renamed) {
            return;
        }
        cameraSettingMenuPanel.setVisibility(0);
        this.j_renamed.setClickable(true);
    }

    public boolean c_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.g_renamed(str);
        }
        return false;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, str2);
        }
    }

    public void b_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c_renamed(str, str2);
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String... strArr) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, strArr);
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, str2, str3);
        }
    }

    public void b_renamed(java.lang.String str, java.lang.String... strArr) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, strArr);
        }
    }

    public void d_renamed(java.lang.String str) {
        if (!this.t_renamed.contains(str) && this.i_renamed.b_renamed(str)) {
            if (this.q_renamed) {
                com.oplus.camera.ui.menu.setting.o_renamed.a_renamed aVar = this.n_renamed;
                if (aVar != null && !aVar.dg_renamed().contains(str)) {
                    this.t_renamed.add(str);
                }
            } else {
                this.t_renamed.add(str);
            }
        }
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.h_renamed(str);
        }
    }

    public void e_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.i_renamed(str);
        }
    }

    public void f_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.k_renamed(str);
        }
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "resetMenuState, resetVisibility:" + z_renamed + ", resetLayout:" + z2);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(z_renamed, z2);
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "initializeCameraSettingMenu, mPreferenceOptionGroup: " + this.k_renamed);
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI.initializeCameraSettingMenu");
        if (this.k_renamed != null) {
            this.j_renamed = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) this.g_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
            com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.g_renamed, this.j_renamed);
            if (2 == this.r_renamed) {
                this.j_renamed.setInverseColor(false);
            }
            this.j_renamed.a_renamed(this.h_renamed, this.i_renamed, this.k_renamed, this.l_renamed, false);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.i_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.aV_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("CameraSettingUI.initializeCameraSettingMenu");
    }

    public com.oplus.camera.ui.menu.setting.CameraMenuOption g_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = cameraSettingMenuPanel.f6574c.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (str.equals(next.a_renamed())) {
                    return next;
                }
            }
            return null;
        }
        com.oplus.camera.e_renamed.e_renamed("CameraSettingUI", "getSettingMenu, mCameraSettingMenu has not initialize");
        return null;
    }

    public void M_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.d_renamed();
        }
    }

    private void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "updateSupportedOptionItems");
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel == null || this.i_renamed == null || !this.p_renamed) {
            return;
        }
        cameraSettingMenuPanel.m_renamed();
        if (this.r_renamed != 3) {
            java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, i_renamed);
            if (supportedList != null) {
                this.j_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, supportedList);
            }
            this.j_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_PLATFORM_SLOW_VIDEO_FPS, i_renamed));
        }
        this.j_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, i_renamed));
        this.j_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.util.Util.c_renamed(this.g_renamed, i_renamed));
        this.j_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, new java.util.ArrayList(java.util.Arrays.asList(this.g_renamed.getResources().getStringArray(com.oplus.camera.R_renamed.array.video_fps_values))));
        if (z_renamed && !this.q_renamed && !z2) {
            this.j_renamed.setVisibility(0);
            this.j_renamed.setAlpha(1.0f);
        }
        this.j_renamed.setOrientation(this.s_renamed);
        this.i_renamed.y_renamed();
    }

    public void N_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.f_renamed();
        }
    }

    public void O_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.g_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.b_renamed bVarA;
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> optionItems;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.q_renamed) {
            if (com.oplus.camera.entry.b_renamed.b_renamed(this.i_renamed.bc_renamed().J_renamed())) {
                this.k_renamed = new com.oplus.camera.ui.menu.h_renamed(context, com.oplus.camera.R_renamed.xml.camera_submenu_settings_from_other_app, true);
            } else {
                this.k_renamed = new com.oplus.camera.ui.menu.h_renamed(context, com.oplus.camera.R_renamed.xml.camera_submenu_settings, true);
            }
        } else if (com.oplus.camera.entry.b_renamed.b_renamed(this.i_renamed.bc_renamed().J_renamed())) {
            this.k_renamed = new com.oplus.camera.ui.menu.h_renamed(context, com.oplus.camera.R_renamed.xml.camera_preferences_from_other_app, false);
        } else {
            this.k_renamed = new com.oplus.camera.ui.menu.h_renamed(context, com.oplus.camera.R_renamed.xml.camera_preferences, false);
        }
        com.oplus.camera.ui.menu.b_renamed bVarA2 = this.k_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA);
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE);
        if (bVarA2 != null && configIntValue != 0) {
            java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> optionItems2 = bVarA2.getOptionItems();
            java.lang.String[] stringArray = context.getResources().getStringArray(com.oplus.camera.R_renamed.array.switch_camera_values);
            if (optionItems2 != null) {
                java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it = optionItems2.iterator();
                while (it.hasNext()) {
                    java.lang.String strC = it.next().c_renamed();
                    if (strC != null) {
                        if (strC.equals(stringArray[2]) && (configIntValue & 4) == 0) {
                            it.remove();
                        } else if (strC.equals(stringArray[3]) && (configIntValue & 8) == 0) {
                            it.remove();
                        } else if (strC.equals(stringArray[1]) && (configIntValue & 2) == 0) {
                            it.remove();
                        } else if (strC.equals(stringArray[0]) && (configIntValue & 1) == 0) {
                            it.remove();
                        }
                    }
                }
            }
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TORCH_SOFT_LIGHT) && (bVarA = this.k_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE)) != null && (optionItems = bVarA.getOptionItems()) != null) {
            for (com.oplus.camera.ui.menu.e_renamed eVar : optionItems) {
                if ("on_renamed".equals(eVar.c_renamed())) {
                    eVar.c_renamed(context.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_torch));
                }
            }
        }
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "parseCameraMenuConfig, use time: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.b_renamed bVarA;
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> optionItems;
        com.oplus.camera.ui.menu.h_renamed hVar = this.k_renamed;
        if (hVar == null || (bVarA = hVar.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU)) == null || (optionItems = bVarA.getOptionItems()) == null) {
            return;
        }
        for (com.oplus.camera.ui.menu.e_renamed eVar : optionItems) {
            if ("off".equals(eVar.e_renamed())) {
                int i_renamed = com.oplus.camera.R_renamed.drawable.menu_effect_off_selector;
                if (z_renamed) {
                    i_renamed = com.oplus.camera.R_renamed.drawable.fuji_filter_icon;
                } else if (com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed() && !this.h_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) && this.i_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS)) {
                    i_renamed = com.oplus.camera.R_renamed.drawable.menu_effect_grandtour_recommend;
                }
                eVar.a_renamed(this.g_renamed.getDrawable(i_renamed));
            } else if ("on_renamed".equals(eVar.e_renamed())) {
                eVar.a_renamed(this.g_renamed.getDrawable(z_renamed ? com.oplus.camera.R_renamed.drawable.fuji_filter_highlight_icon : com.oplus.camera.R_renamed.drawable.menu_effect_on_selector));
            }
        }
    }

    public void b_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, i_renamed);
        }
    }

    public void d_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.e_renamed.a_renamed("CameraSettingUI", "updateSettingBarBg, halfOpaque: " + z_renamed + ", needAnimation: " + z2);
        if (this.j_renamed == null || !this.p_renamed || (cameraUIListener = this.i_renamed) == null || cameraUIListener.bh_renamed() || !z2) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, com.oplus.camera.ui.c_renamed.a_renamed(this.g_renamed, 1), 200, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        } else {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, this.g_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.background_color), 200, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        }
    }

    public void h_renamed(boolean z_renamed) {
        if (this.j_renamed == null) {
            return;
        }
        int color = this.g_renamed.getColor(com.oplus.camera.R_renamed.color.beauty3d_guide_background);
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, color, 200, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        }
    }

    public int P_renamed() {
        return com.oplus.camera.util.Util.getSettingMenuPanelHeight();
    }

    public void b_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, z_renamed, false);
        }
    }

    public void c_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c_renamed(str, i_renamed);
        }
    }

    public void a_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.b_renamed(str, z_renamed, z2);
        }
    }

    public void a_renamed(java.lang.String str, boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, z_renamed, i_renamed, i2);
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, str2, str3, i_renamed, i2, i3);
        }
    }

    public void h_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.e_renamed(str);
        }
    }

    public boolean i_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            return cameraSettingMenuPanel.f_renamed(str);
        }
        return false;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.a_renamed(str, str2, str3, str4, i_renamed, i2);
        }
    }

    public void c_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.c_renamed(str, z_renamed);
        }
    }

    /* compiled from: CameraSettingUI.java */
    private class b_renamed extends java.lang.Thread {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f6654b;

        public b_renamed() {
            this.f6654b = false;
            this.f6654b = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws android.content.res.Resources.NotFoundException {
            if (this.f6654b) {
                return;
            }
            com.oplus.camera.ui.menu.setting.o_renamed oVar = com.oplus.camera.ui.menu.setting.o_renamed.this;
            oVar.a_renamed(oVar.g_renamed);
        }

        public void a_renamed() {
            this.f6654b = true;
        }
    }

    public void g_renamed(int i_renamed) {
        this.w_renamed = i_renamed;
        Q_renamed();
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.g_renamed.hashCode())) {
            b_renamed();
        }
    }

    private void b_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.i_renamed();
        }
    }

    public void Q_renamed() {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = this.j_renamed;
        if (cameraSettingMenuPanel != null) {
            cameraSettingMenuPanel.h_renamed();
        }
    }
}
