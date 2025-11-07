package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraSettingMenuPanel extends android.widget.LinearLayout implements com.oplus.camera.ui.inverse.a_renamed, com.oplus.camera.ui.menu.setting.i_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public boolean f6572a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public boolean f6573b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> f6574c;
    public com.oplus.camera.ui.CameraUIListener d_renamed;
    public com.oplus.camera.ComboPreferences e_renamed;
    public android.content.Context f_renamed;
    public int g_renamed;
    private final java.lang.Object h_renamed;
    private int i_renamed;
    private int j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private int o_renamed;
    private java.util.List<com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed> p_renamed;
    private java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> q_renamed;
    private java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> r_renamed;
    private com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed s_renamed;
    private com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed t_renamed;

    public void setPendingDrawerGuideAni(java.lang.Runnable runnable) {
    }

    public CameraSettingMenuPanel(android.content.Context context) {
        super(context);
        this.h_renamed = new java.lang.Object();
        this.f6572a = false;
        this.f6573b = true;
        this.f6574c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = true;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0;
        this.p_renamed = null;
        this.q_renamed = new java.util.ArrayList();
        this.r_renamed = new java.util.ArrayList();
        this.s_renamed = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed();
        this.t_renamed = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed();
        this.f_renamed = context;
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_padding_left_right);
    }

    public CameraSettingMenuPanel(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h_renamed = new java.lang.Object();
        this.f6572a = false;
        this.f6573b = true;
        this.f6574c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = true;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = 0;
        this.p_renamed = null;
        this.q_renamed = new java.util.ArrayList();
        this.r_renamed = new java.util.ArrayList();
        this.s_renamed = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed();
        this.t_renamed = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed();
        this.f_renamed = context;
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_padding_left_right);
    }

    public void setCameraMenuLayout(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "setCameraMenuLayout(), " + this.f6573b + " => " + z_renamed);
        if (z_renamed && this.f6573b) {
            return;
        }
        this.f6573b = z_renamed;
        if (this.f6573b) {
            p_renamed();
            requestLayout();
        }
    }

    public void b_renamed() {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed> list = this.p_renamed;
        if (list != null) {
            list.clear();
        }
    }

    public void setInitState(boolean z_renamed) {
        this.f6572a = z_renamed;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionN = n_renamed(str);
        if (cameraMenuOptionN != null) {
            cameraMenuOptionN.a_renamed(str2, str3, i_renamed, i2, i3);
        }
    }

    public void e_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionN = n_renamed(str);
        if (cameraMenuOptionN != null) {
            cameraMenuOptionN.w_renamed();
        }
    }

    public boolean f_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionN = n_renamed(str);
        if (cameraMenuOptionN != null) {
            return cameraMenuOptionN.e_renamed(str);
        }
        return false;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionC;
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = null;
        int iN = -1;
        try {
            com.oplus.camera.ui.menu.setting.h_renamed hVar = (com.oplus.camera.ui.menu.setting.h_renamed) n_renamed(str);
            if (hVar != null) {
                iN = hVar.n_renamed(str3);
                basicOptionItemList = hVar.f6560b;
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        if (basicOptionItemList == null || basicOptionItemList.isShown() || (cameraMenuOptionC = basicOptionItemList.c_renamed(iN)) == null) {
            return;
        }
        cameraMenuOptionC.a_renamed(str2, str4, str3, i_renamed, i2);
    }

    public void a_renamed(java.lang.String str, boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionN = n_renamed(str);
        if (cameraMenuOptionN != null) {
            cameraMenuOptionN.a_renamed(z_renamed, i_renamed, i2);
        }
    }

    private com.oplus.camera.ui.menu.setting.CameraMenuOption n_renamed(java.lang.String str) {
        if (str != null && !str.isEmpty()) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (str.equals(next.a_renamed())) {
                    return next;
                }
            }
        }
        return null;
    }

    private void p_renamed() {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed> list = this.p_renamed;
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (this.h_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "executeOptions(), length: " + this.p_renamed.size());
            for (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar : this.p_renamed) {
                if (aVar != null && 1 == aVar.f6577a) {
                    o_renamed(aVar.f6578b);
                }
            }
            for (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar2 : this.p_renamed) {
                if (aVar2 != null && aVar2.f6577a == 0) {
                    j_renamed(aVar2.f6578b);
                }
            }
            for (int i_renamed = 0; i_renamed < this.p_renamed.size(); i_renamed++) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar3 = this.p_renamed.get(i_renamed);
                if (aVar3 != null) {
                    int i2 = aVar3.f6577a;
                    if (i2 == 2) {
                        a_renamed(aVar3.f6578b, aVar3.d_renamed);
                    } else if (i2 == 5) {
                        b_renamed(aVar3.f6578b, aVar3.e_renamed);
                    } else if (i2 == 6) {
                        a_renamed(aVar3.f6578b, aVar3.e_renamed);
                    }
                }
            }
            for (int i3 = 0; i3 < this.p_renamed.size(); i3++) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar4 = this.p_renamed.get(i3);
                if (aVar4 != null) {
                    int i4 = aVar4.f6577a;
                    if (i4 == 3) {
                        c_renamed(aVar4.f6578b, aVar4.f6579c);
                    } else if (i4 == 4) {
                        b_renamed(aVar4.f6578b, aVar4.f6579c);
                    }
                }
            }
            this.p_renamed.clear();
        }
    }

    public void a_renamed(com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.ui.menu.h_renamed hVar, int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "initialize, sizeRatioType: " + i_renamed);
        this.m_renamed = z_renamed;
        this.e_renamed = comboPreferences;
        n_renamed();
        this.f6574c = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.d_renamed = cameraUIListener;
        this.g_renamed = i_renamed;
        java.util.List<java.lang.String> menuPanelOptionList = com.oplus.camera.aps.config.CameraConfig.getMenuPanelOptionList();
        if (this.m_renamed) {
            this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.submenu_panel_padding_left_right);
        }
        if (menuPanelOptionList == null || menuPanelOptionList.size() <= 0) {
            return;
        }
        for (java.lang.String str : menuPanelOptionList) {
            com.oplus.camera.ui.menu.b_renamed bVarA = hVar.a_renamed(com.oplus.camera.entry.b_renamed.b_renamed(str, this.d_renamed.bc_renamed().J_renamed()));
            if (bVarA != null) {
                com.oplus.camera.ui.menu.setting.h_renamed hVar2 = new com.oplus.camera.ui.menu.setting.h_renamed(this.e_renamed, this.f_renamed, bVarA, this, this.d_renamed, this.g_renamed, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(str, getCameraId()), z_renamed);
                hVar2.b_renamed();
                this.f6574c.add(hVar2);
                hVar2.a_renamed((android.view.ViewGroup) this);
                hVar2.J_renamed().setContentDescription(bVarA.getOptionTitle());
            }
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "updateAfterCameraResume(), mMenuList: " + this.f6574c);
        setCameraMenuLayout(true);
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.c_renamed();
                }
            }
        }
        q_renamed();
    }

    private void q_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.e_renamed;
        if (comboPreferences == null || this.d_renamed == null) {
            return;
        }
        boolean zEquals = "on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS_SETTING_SUPPORT);
        if (1 == this.d_renamed.bc_renamed().J_renamed() && !this.d_renamed.B_renamed() && !android.text.TextUtils.isEmpty(this.d_renamed.ao_renamed()) && zEquals && !com.oplus.camera.e_renamed.a_renamed.a_renamed(this.d_renamed.G_renamed()) && !configBooleanValue) {
            i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE);
            return;
        }
        if (this.d_renamed.c_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, this.d_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE))) {
            h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE);
        }
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "updateImageIconShadow");
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.b_renamed(next.L_renamed());
                }
            }
        }
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "updateAfterCameraPause");
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.d_renamed();
                }
            }
        }
    }

    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "saveLastMenuPanelState");
        setCameraMenuLayout(false);
        this.r_renamed.clear();
        this.s_renamed.e_renamed();
        this.s_renamed.f6580a = this.t_renamed.f6580a;
        if (this.t_renamed.c_renamed() != null) {
            this.s_renamed.c_renamed().addAll(this.t_renamed.c_renamed());
            this.q_renamed.clear();
            this.q_renamed.addAll(this.t_renamed.c_renamed());
        }
        if (this.t_renamed.b_renamed() != null) {
            this.s_renamed.b_renamed().addAll(this.t_renamed.b_renamed());
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            next.E_renamed();
            next.J_renamed().clearAnimation();
        }
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "resetLastMenuPanelState");
        for (int i_renamed = 0; i_renamed < this.f6574c.size(); i_renamed++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.f6574c.get(i_renamed);
            if (cameraMenuOption.G_renamed() == 0) {
                cameraMenuOption.b_renamed(cameraMenuOption.a_renamed(), false);
            }
        }
        this.r_renamed.clear();
        this.s_renamed.e_renamed();
        this.s_renamed.f6580a = 0.0f;
        this.q_renamed.clear();
        this.t_renamed.e_renamed();
        this.t_renamed.f6580a = 0.0f;
    }

    private void a_renamed(float f_renamed, boolean z_renamed) {
        int width;
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "initMenuViewLeftVisibility, itemSpace: " + f_renamed + ", isRightToLeft: " + z_renamed);
        float fB_renamed = (float) this.i_renamed;
        for (int i_renamed = 0; i_renamed < this.t_renamed.c_renamed().size(); i_renamed++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.t_renamed.c_renamed().get(i_renamed);
            if (1 == this.t_renamed.c_renamed().size()) {
                if (d_renamed(cameraMenuOption.a_renamed(), z_renamed)) {
                    width = this.i_renamed;
                } else if (e_renamed(cameraMenuOption.a_renamed(), z_renamed)) {
                    width = (getWidth() + this.i_renamed) - cameraMenuOption.B_renamed();
                }
                fB_renamed = width;
            }
            this.t_renamed.b_renamed().add(java.lang.Integer.valueOf((int) fB_renamed));
            fB_renamed += cameraMenuOption.B_renamed() + f_renamed;
        }
    }

    private void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "initMenuLayoutLeftForFull, itemSpace: " + f_renamed + " firstLeft: " + f2);
        for (int i_renamed = 0; i_renamed < this.t_renamed.c_renamed().size(); i_renamed++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.t_renamed.c_renamed().get(i_renamed);
            this.t_renamed.b_renamed().add(java.lang.Integer.valueOf((int) f2));
            f2 += cameraMenuOption.B_renamed() + f_renamed;
        }
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "removeSecondMenuAfterChangeScreenMode");
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.e_renamed();
                }
            }
        }
    }

    public void i_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.f_renamed();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (this.f6572a && (copyOnWriteArrayList = this.f6574c) != null && copyOnWriteArrayList.size() > 0 && this.f6573b) {
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
            if (1 == (cameraUIListener != null ? cameraUIListener.ca_renamed() : 0)) {
                a_renamed(z_renamed, i_renamed, i2, i3, i4);
            } else {
                b_renamed(z_renamed, i_renamed, i2, i3, i4);
            }
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.d_renamed;
        if (cameraUIListener2 != null) {
            cameraUIListener2.l_renamed(false);
        }
    }

    private void a_renamed(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        boolean z2;
        int i5 = i4 - i2;
        float dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_item_space);
        this.t_renamed.e_renamed();
        int i6 = 0;
        for (int i7 = 0; i7 < this.f6574c.size(); i7++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.f6574c.get(i7);
            cameraMenuOption.M_renamed();
            if (!cameraMenuOption.i_renamed()) {
                i6++;
                this.t_renamed.c_renamed().add(cameraMenuOption);
            }
        }
        float fB_renamed = (5 - i6) * (this.f6574c.get(0).B_renamed() + dimensionPixelSize);
        if (this.t_renamed.f6580a != dimensionPixelSize) {
            this.t_renamed.f6580a = dimensionPixelSize;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.t_renamed.b_renamed().size() == 0) {
            a_renamed(dimensionPixelSize, fB_renamed);
        }
        int i8 = 0;
        float f_renamed = fB_renamed;
        for (int i9 = 0; i9 < this.f6574c.size(); i9++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption2 = this.f6574c.get(i9);
            if (cameraMenuOption2 != null && 8 != cameraMenuOption2.G_renamed()) {
                int iB = cameraMenuOption2.B_renamed();
                int measuredHeight = getMeasuredHeight();
                int i10 = (i5 - measuredHeight) / 2;
                if (1 == cameraMenuOption2.F_renamed()) {
                    return;
                }
                if (!this.r_renamed.contains(cameraMenuOption2) && this.t_renamed.c_renamed().contains(cameraMenuOption2)) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionA = this.s_renamed.a_renamed(f_renamed);
                    if (cameraMenuOptionA != null) {
                        if (!a_renamed(cameraMenuOptionA, cameraMenuOption2)) {
                            cameraMenuOption2.b_renamed(0, true);
                        }
                    } else if (!z2) {
                        cameraMenuOption2.b_renamed(0, false);
                    }
                    this.r_renamed.add(cameraMenuOption2);
                }
                if (i8 < 5 && this.t_renamed.c_renamed().contains(cameraMenuOption2)) {
                    int i11 = (int) f_renamed;
                    cameraMenuOption2.a_renamed(i11, i10, i11 + iB, measuredHeight + i10);
                    f_renamed = f_renamed + iB + dimensionPixelSize;
                    i8++;
                }
            } else if (cameraMenuOption2 != null && 8 == cameraMenuOption2.G_renamed()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOptionA2 = this.t_renamed.a_renamed(this.s_renamed.a_renamed(cameraMenuOption2));
                if (cameraMenuOptionA2 != null && this.q_renamed.contains(cameraMenuOption2) && !a_renamed(cameraMenuOptionA2, cameraMenuOption2)) {
                    cameraMenuOption2.b_renamed(8, true);
                }
                this.q_renamed.remove(cameraMenuOption2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:150:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:151:0x02f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(boolean r27, int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.b_renamed(boolean, int, int, int, int):void");
    }

    private void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed, int i2, int i3, float f_renamed, float f2) {
        float fAbs;
        float fAbs2;
        float fA_renamed = this.s_renamed.a_renamed() - f_renamed;
        float f3 = i_renamed + (f2 * 2.0f);
        if (getMeasuredWidth() <= f3) {
            if (getMeasuredWidth() == f3) {
                if (0.0f > fA_renamed) {
                    fAbs2 = java.lang.Math.abs(fA_renamed);
                    fAbs = f2 - fAbs2;
                }
            } else if (getMeasuredWidth() < f3) {
                if (0.0f < fA_renamed) {
                    fAbs = f2 - java.lang.Math.abs(fA_renamed);
                } else {
                    fAbs = java.lang.Math.abs(fA_renamed) + f2;
                }
                if ((getMeasuredWidth() - i_renamed) / 2.0f >= fAbs) {
                }
            }
            fAbs = f2;
        } else if (0.0f < fA_renamed) {
            fAbs = java.lang.Math.abs(fA_renamed) + f2;
        } else {
            fAbs2 = java.lang.Math.abs(fA_renamed);
            fAbs = f2 - fAbs2;
        }
        int i4 = (int) fAbs;
        int i5 = (int) f2;
        if (i4 != i5) {
            double d_renamed = fAbs;
            if ((this.s_renamed.b_renamed((int) java.lang.Math.ceil(d_renamed)) || this.s_renamed.b_renamed((int) java.lang.Math.floor(d_renamed))) && 0.0f == this.t_renamed.a_renamed(this.s_renamed.a_renamed(fAbs))) {
                cameraMenuOption.a_renamed(i4, i5, 0);
                return;
            }
        }
        cameraMenuOption.a_renamed(i5, i3, i_renamed + i5, i2 + i3);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x009a A_renamed[PHI: r2
      0x009a: PHI (r2v27 float) = (r2v24 float), (r2v24 float), (r2v30 float) binds: [B_renamed:33:0x00c1, B_renamed:35:0x00c4, B_renamed:22:0x0097] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption r12, float r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption, float):void");
    }

    public boolean j_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.g_renamed()) {
                return true;
            }
        }
        return false;
    }

    public void k_renamed() {
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && !next.i_renamed() && ((this.d_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(next.a_renamed())) || (this.d_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(next.a_renamed())))) {
                next.e_renamed(0);
                next.a_renamed(true, true);
            }
        }
    }

    public void a_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && !next.i_renamed()) {
                if (this.d_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE) && com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(next.a_renamed())) {
                    next.e_renamed(0);
                } else if (this.d_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE) && com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(next.a_renamed()) && !this.d_renamed.aU_renamed()) {
                    next.e_renamed(0);
                } else {
                    if (1 == next.F_renamed()) {
                        next.a_renamed(4);
                    } else {
                        if (next.D_renamed()) {
                            next.E_renamed();
                        }
                        if (next.J_renamed() != null && next.J_renamed().getAnimation() != null && next.J_renamed().getAnimation().hasStarted()) {
                            a_renamed(next);
                            next.a_renamed(4);
                        } else {
                            a_renamed(next);
                            next.e_renamed(4);
                        }
                    }
                    next.a_renamed(false, false);
                    if (3 == next.F_renamed()) {
                        next.d_renamed(0);
                    }
                }
            }
        }
    }

    private void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(0L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(true);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 0.0f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setFillBefore(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        cameraMenuOption.J_renamed().clearAnimation();
        cameraMenuOption.J_renamed().startAnimation(animationSet);
    }

    public void l_renamed() {
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null) {
                if (next.i_renamed()) {
                    next.a_renamed(8);
                } else {
                    next.e_renamed(0);
                }
            }
        }
    }

    @Override // android.view.View
    public void setAlpha(float f_renamed) {
        super.setAlpha(f_renamed);
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "setAlpha, alpha : " + f_renamed);
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        super.setVisibility(i_renamed);
        com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "setVisibility, visibility : " + i_renamed);
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null && cameraUIListener.c_renamed() && (1 == this.d_renamed.ca_renamed() || 4 == this.d_renamed.ca_renamed())) {
            com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "setVisibility, set cameraSettingMenu flash item visible while isVideoRecording");
            a_renamed();
            return;
        }
        if (i_renamed == 0 && (copyOnWriteArrayList = this.f6574c) != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.i_renamed()) {
                        next.a_renamed(8);
                    } else {
                        next.e_renamed(0);
                    }
                }
            }
        }
        if (i_renamed == 0 || this.f6574c == null || !com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it2 = this.f6574c.iterator();
        while (it2.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next2 = it2.next();
            if (next2 != null) {
                next2.p_renamed();
            }
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        this.k_renamed = z_renamed;
        this.l_renamed = z2;
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null && (!z_renamed || !next.i_renamed())) {
                    next.a_renamed(z_renamed, z2);
                }
            }
        }
    }

    public boolean g_renamed(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener == null) {
            return false;
        }
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, cameraUIListener.bc_renamed().J_renamed());
        if (android.text.TextUtils.isEmpty(strB) || (copyOnWriteArrayList = this.f6574c) == null) {
            return false;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.a_renamed().equals(strB)) {
                return next.t_renamed();
            }
        }
        return false;
    }

    public void b_renamed(java.lang.String str, java.lang.String str2) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        if (this.f6573b) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null && next.a_renamed(str, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(next.a_renamed()), getCameraId()), str2)) {
                    return;
                }
            }
            return;
        }
        if (this.p_renamed == null) {
            this.p_renamed = new java.util.ArrayList();
        }
        synchronized (this.h_renamed) {
            com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVarD = d_renamed(str, 4);
            if (aVarD == null) {
                aVarD = d_renamed(str, 3);
            }
            if (aVarD == null) {
                aVarD = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
            } else {
                this.p_renamed.remove(aVarD);
            }
            aVarD.f6578b = str;
            aVarD.f6577a = 4;
            aVarD.f6579c = str2;
            this.p_renamed.add(aVarD);
        }
    }

    public void c_renamed(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null && !cameraUIListener.a_renamed(str)) {
            com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "enableCameraSettingMenuOption(), this cap mod can not enable key : " + str);
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            if (this.f6573b) {
                java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                    if (next != null && !next.i_renamed() && next.b_renamed(str, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(next.a_renamed()), getCameraId()), str2)) {
                        return;
                    }
                }
                return;
            }
            if (this.p_renamed == null) {
                this.p_renamed = new java.util.ArrayList();
            }
            synchronized (this.h_renamed) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVarD = d_renamed(str, 3);
                if (aVarD == null) {
                    aVarD = d_renamed(str, 4);
                }
                if (aVarD == null) {
                    aVarD = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                } else {
                    this.p_renamed.remove(aVarD);
                }
                aVarD.f6578b = str;
                aVarD.f6577a = 3;
                aVarD.f6579c = str2;
                this.p_renamed.add(aVarD);
            }
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String... strArr) {
        if (str == null || str.equals("") || strArr == null || strArr.length <= 0 || this.f6574c == null) {
            return;
        }
        if (!this.f6573b && this.p_renamed != null) {
            synchronized (this.h_renamed) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                aVar.f6578b = str;
                aVar.e_renamed = strArr;
                aVar.f6577a = 6;
                this.p_renamed.add(aVar);
            }
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.a_renamed(str, strArr)) {
                return;
            }
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (str == null || str.equals("") || str2 == null || str2.equals("") || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if ((next instanceof com.oplus.camera.ui.menu.setting.h_renamed) && str.equals(next.a_renamed())) {
                java.util.List<com.oplus.camera.ui.menu.e_renamed> listAh = ((com.oplus.camera.ui.menu.setting.h_renamed) next).ah_renamed();
                if (listAh != null) {
                    for (int i_renamed = 0; i_renamed < listAh.size(); i_renamed++) {
                        if (str2.equals(listAh.get(i_renamed).c_renamed())) {
                            listAh.get(i_renamed).c_renamed(str3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    public void b_renamed(java.lang.String str, java.lang.String... strArr) {
        if (str == null || str.equals("") || strArr == null || strArr.length <= 0 || this.f6574c == null) {
            return;
        }
        if (!this.f6573b && this.p_renamed != null) {
            synchronized (this.h_renamed) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                aVar.f6578b = str;
                aVar.e_renamed = strArr;
                aVar.f6577a = 5;
                this.p_renamed.add(aVar);
            }
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.b_renamed(str, strArr)) {
                return;
            }
        }
    }

    public boolean a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed) {
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.ac_renamed() == i_renamed && next.G_renamed() == 0 && !cameraMenuOption.a_renamed().equals(next.a_renamed())) {
                return true;
            }
        }
        return false;
    }

    public void h_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null && !cameraUIListener.b_renamed(str)) {
            com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "addContainMenuOption, the current mode can not add option: " + str);
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            if (this.f6573b) {
                java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (a_renamed(str, it.next())) {
                        requestLayout();
                    }
                }
                return;
            }
            if (this.p_renamed == null) {
                this.p_renamed = new java.util.ArrayList();
            }
            synchronized (this.h_renamed) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVarD = d_renamed(str, 1);
                if (aVarD == null) {
                    aVarD = d_renamed(str, 0);
                }
                if (aVarD == null) {
                    com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                    aVar.f6578b = str;
                    aVar.f6577a = 1;
                    this.p_renamed.add(aVar);
                } else if (aVarD.f6577a != 1) {
                    this.p_renamed.remove(aVarD);
                    aVarD.f6578b = str;
                    aVarD.f6577a = 1;
                    this.p_renamed.add(aVarD);
                }
            }
        }
    }

    private void o_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null && !cameraUIListener.b_renamed(str)) {
            com.oplus.camera.e_renamed.a_renamed("CameraSettingMenuPanel", "executeAddContainMenuOption, the current mode can not add option: " + str);
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList == null || !this.f6573b) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            a_renamed(str, it.next());
        }
    }

    private boolean a_renamed(java.lang.String str, com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption != null) {
            return cameraMenuOption.a_renamed(str, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(cameraMenuOption.a_renamed()), getCameraId()), getVisibility(), !str.equals(cameraMenuOption.a_renamed()) || 1 != cameraMenuOption.ac_renamed() || !a_renamed(cameraMenuOption, 1));
        }
        return false;
    }

    public void i_renamed(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        if (this.f6573b) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.b_renamed(str, this.f6572a && !this.m_renamed)) {
                        requestLayout();
                        return;
                    }
                }
            }
            return;
        }
        if (this.p_renamed == null) {
            this.p_renamed = new java.util.ArrayList();
        }
        synchronized (this.h_renamed) {
            com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVarD = d_renamed(str, 0);
            if (aVarD == null) {
                aVarD = d_renamed(str, 1);
            }
            if (aVarD == null) {
                com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                aVar.f6578b = str;
                aVar.f6577a = 0;
                this.p_renamed.add(aVar);
            } else if (aVarD.f6577a != 0) {
                this.p_renamed.remove(aVarD);
                aVarD.f6578b = str;
                aVarD.f6577a = 0;
                this.p_renamed.add(aVarD);
            }
        }
    }

    public void j_renamed(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null || !this.f6573b) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null) {
                if (next.b_renamed(str, this.f6572a && !this.m_renamed)) {
                    return;
                }
            }
        }
    }

    private com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed d_renamed(java.lang.String str, int i_renamed) {
        java.util.List<com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed> list;
        if (str == null || str.equals("") || (list = this.p_renamed) == null || list.isEmpty()) {
            return null;
        }
        for (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVar : this.p_renamed) {
            if (str.equals(aVar.f6578b) && aVar.f6577a == i_renamed) {
                return aVar;
            }
        }
        return null;
    }

    public void a_renamed(java.lang.String str, int i_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && next.a_renamed(str, i_renamed)) {
                return;
            }
        }
    }

    public void a_renamed(java.lang.String str, java.util.List<java.lang.String> list) {
        if (android.text.TextUtils.isEmpty(str) || list == null) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener == null || cameraUIListener.f_renamed(str) || this.d_renamed.g_renamed(str)) {
            com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.d_renamed;
            if (cameraUIListener2 != null) {
                str = com.oplus.camera.entry.b_renamed.b_renamed(str, cameraUIListener2.bc_renamed().J_renamed());
            }
            java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
            if (copyOnWriteArrayList != null) {
                if (this.f6573b) {
                    java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                        if (next != null && next.a_renamed(str, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(next.a_renamed()), getCameraId()), list)) {
                            return;
                        }
                    }
                    return;
                }
                if (this.p_renamed == null) {
                    this.p_renamed = new java.util.ArrayList();
                }
                synchronized (this.h_renamed) {
                    com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed aVarD = d_renamed(str, 2);
                    if (aVarD == null) {
                        aVarD = new com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.a_renamed(this, null);
                    } else {
                        this.p_renamed.remove(aVarD);
                    }
                    aVarD.f6578b = str;
                    aVarD.f6577a = 2;
                    aVarD.d_renamed = list;
                    this.p_renamed.add(aVarD);
                }
            }
        }
    }

    public void k_renamed(java.lang.String str) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && str.equals(next.a_renamed())) {
                next.f_renamed(com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(next.a_renamed()), getCameraId()));
                return;
            }
        }
    }

    public void b_renamed(java.lang.String str, int i_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && str.equals(next.a_renamed()) && b_renamed(next, i_renamed)) {
                b_renamed(next);
                return;
            }
        }
    }

    private boolean b_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed) {
        if (cameraMenuOption.ad_renamed() == 0 && i_renamed == 0) {
            return true;
        }
        return cameraMenuOption.ad_renamed() != 0 && 8 == i_renamed;
    }

    private void b_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
        java.lang.Object objQ = cameraMenuOption.Q_renamed();
        android.view.View viewJ = cameraMenuOption.J_renamed();
        if (objQ == null || viewJ == null) {
            com.oplus.camera.e_renamed.b_renamed("CameraSettingMenuPanel", "showCameraSubSettingMenuWithAnimation view: " + viewJ + "drawable: " + objQ);
            return;
        }
        if (objQ instanceof android.graphics.drawable.StateListDrawable) {
            android.graphics.drawable.StateListDrawable stateListDrawable = (android.graphics.drawable.StateListDrawable) objQ;
            java.lang.Object stateDrawable = stateListDrawable.getStateDrawable(stateListDrawable.findStateDrawableIndex(viewJ.getDrawableState()));
            if (stateDrawable instanceof android.graphics.drawable.Animatable) {
                ((android.graphics.drawable.Animatable) stateDrawable).start();
                return;
            }
            return;
        }
        if (objQ instanceof android.graphics.drawable.Animatable) {
            ((android.graphics.drawable.Animatable) objQ).start();
        }
    }

    public void b_renamed(java.lang.String str, boolean z_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (android.text.TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.f6574c) == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && str.equals(next.a_renamed())) {
                next.d_renamed(z_renamed);
                return;
            }
        }
    }

    public void m_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList;
        if (this.f6573b && (copyOnWriteArrayList = this.f6574c) != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.f_renamed(com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.entry.b_renamed.d_renamed(next.a_renamed()), getCameraId()));
                }
            }
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.b_renamed(z_renamed, z2);
                }
            }
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel$1, reason: invalid class name */
    class SceneLoader_2 implements android.view.animation.Animation.AnimationListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ boolean f6575a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.camera.ui.menu.setting.CameraMenuOption f6576b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption;
            if (!this.f6575a || (cameraMenuOption = this.f6576b) == null) {
                return;
            }
            cameraMenuOption.b_renamed(cameraMenuOption.x_renamed());
        }
    }

    public void n_renamed() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().n_renamed();
            }
            this.f6574c.clear();
            this.f6574c = null;
        }
    }

    public void o_renamed() {
        clearAnimation();
        n_renamed();
        removeAllViews();
        if (this.p_renamed != null) {
            synchronized (this.h_renamed) {
                this.p_renamed.clear();
            }
            this.p_renamed = null;
        }
        this.f_renamed = null;
        this.d_renamed = null;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public android.content.SharedPreferences getSharedPreferences() {
        return this.e_renamed;
    }

    public int getCameraId() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.G_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public boolean getMenuPanelEnable() {
        return this.k_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public boolean getMenuPanelAshed() {
        return this.l_renamed;
    }

    @Override // android.widget.LinearLayout, com.oplus.camera.ui.menu.setting.i_renamed
    public int getOrientation() {
        return this.j_renamed;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i_renamed) {
        this.j_renamed = i_renamed;
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(i_renamed, true);
        }
    }

    public int getUnremovedMenuNum() {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        int i_renamed = 0;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null && !next.i_renamed()) {
                    i_renamed++;
                }
            }
        }
        return i_renamed;
    }

    public java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> getMenuList() {
        return this.f6574c;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public boolean a_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.a_renamed(str, z_renamed, z2);
        }
        return true;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public boolean a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.a_renamed(str, z_renamed);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public java.lang.String a_renamed(java.lang.String str, int i_renamed, int i2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.a_renamed(str, i_renamed, i2);
        }
        return null;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.a_renamed(str, str2);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public void a_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.e_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public boolean b_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.b_renamed(str);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public void c_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.n_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.i_renamed
    public void d_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.o_renamed(str);
        }
    }

    private boolean d_renamed(java.lang.String str, boolean z_renamed) {
        if (z_renamed) {
            return m_renamed(str);
        }
        return l_renamed(str);
    }

    private boolean e_renamed(java.lang.String str, boolean z_renamed) {
        if (z_renamed) {
            return l_renamed(str);
        }
        return m_renamed(str);
    }

    public boolean l_renamed(java.lang.String str) {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(str);
    }

    public boolean m_renamed(java.lang.String str) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        return com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(strD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p_renamed(java.lang.String str) {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.d_renamed.bc_renamed().J_renamed()).equals(str) || com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.d_renamed.bc_renamed().J_renamed()).equals(str) || com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, this.d_renamed.bc_renamed().J_renamed()).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q_renamed(java.lang.String str) {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU, this.d_renamed.bc_renamed().J_renamed()).equals(str) || com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU, this.d_renamed.bc_renamed().J_renamed()).equals(str) || com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU, this.d_renamed.bc_renamed().J_renamed()).equals(str) || com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.d_renamed.bc_renamed().J_renamed()).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r_renamed(java.lang.String str) {
        return com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(str);
    }

    public void setSizeRatioType(int i_renamed) {
        this.g_renamed = i_renamed;
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.f_renamed(this.g_renamed);
                }
            }
        }
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.c_renamed(z_renamed, z2);
                }
            }
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null) {
                    next.a_renamed(z_renamed, z2, i_renamed);
                }
            }
        }
    }

    public void b_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.d_renamed.bc_renamed().J_renamed());
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null && strB.equals(next.a_renamed()) && (z2 || z_renamed != next.ad_renamed())) {
                    next.i_renamed(z_renamed ? 1 : 0);
                    next.a_renamed(next.g_renamed(z_renamed), next.S_renamed());
                }
            }
        }
    }

    public void c_renamed(java.lang.String str, int i_renamed) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.d_renamed.bc_renamed().J_renamed());
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (next != null && strB.equals(next.a_renamed()) && i_renamed != next.ad_renamed()) {
                    next.i_renamed(i_renamed);
                }
            }
        }
    }

    public void setShadowOn(boolean z_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().e_renamed(z_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.n_renamed = z_renamed;
        setBackgroundColor(this.o_renamed);
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        this.o_renamed = i_renamed;
        super.setBackgroundColor(this.n_renamed ? 0 : com.oplus.camera.util.c_renamed.a_renamed(i_renamed));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.d_renamed;
        if (cameraUIListener != null && cameraUIListener.p_renamed() && 3 != (actionMasked = motionEvent.getActionMasked()) && 2 != actionMasked) {
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void c_renamed(java.lang.String str, boolean z_renamed) {
        java.util.concurrent.CopyOnWriteArrayList<com.oplus.camera.ui.menu.setting.CameraMenuOption> copyOnWriteArrayList = this.f6574c;
        if (copyOnWriteArrayList == null || str == null) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (str.equals(next.a_renamed())) {
                ((com.oplus.camera.ui.menu.i_renamed) next.J_renamed()).setStateSecond(z_renamed);
            }
        }
    }

    private class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f6577a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.lang.String f6578b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.lang.String f6579c;
        public java.util.List<java.lang.String> d_renamed;
        public java.lang.String[] e_renamed;

        private a_renamed() {
            this.f6577a = -1;
            this.f6579c = null;
            this.d_renamed = null;
            this.e_renamed = null;
        }

        /* synthetic */ a_renamed(com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel, com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.SceneLoader_2 anonymousClass1) {
            this();
        }

        public java.lang.String toString() {
            return new com.google.gson.Gson().toJson(this);
        }
    }

    private class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f6580a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.util.List<java.lang.Integer> f6581b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> f6582c;

        public float a_renamed() {
            return this.f6580a;
        }

        public java.util.List<java.lang.Integer> b_renamed() {
            return this.f6581b;
        }

        public java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> c_renamed() {
            return this.f6582c;
        }

        public b_renamed() {
            if (this.f6581b == null) {
                this.f6581b = new java.util.ArrayList();
            }
            if (this.f6582c == null) {
                this.f6582c = new java.util.ArrayList();
            }
        }

        public int d_renamed() {
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.f6582c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void e_renamed() {
            java.util.List<java.lang.Integer> list = this.f6581b;
            if (list == null) {
                this.f6581b = new java.util.ArrayList();
            } else {
                list.clear();
            }
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list2 = this.f6582c;
            if (list2 == null) {
                this.f6582c = new java.util.ArrayList();
            } else {
                list2.clear();
            }
        }

        public com.oplus.camera.ui.menu.setting.CameraMenuOption a_renamed(int i_renamed) {
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list;
            int iIndexOf;
            if (this.f6581b == null || (list = this.f6582c) == null || list.size() != this.f6581b.size() || (iIndexOf = this.f6581b.indexOf(java.lang.Integer.valueOf(i_renamed))) < 0) {
                return null;
            }
            return this.f6582c.get(iIndexOf);
        }

        public com.oplus.camera.ui.menu.setting.CameraMenuOption a_renamed(float f_renamed) {
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list;
            if (this.f6581b == null || (list = this.f6582c) == null || list.size() != this.f6581b.size()) {
                return null;
            }
            double d_renamed = f_renamed;
            int iIndexOf = this.f6581b.indexOf(java.lang.Integer.valueOf((int) java.lang.Math.ceil(d_renamed)));
            if (iIndexOf < 0) {
                iIndexOf = this.f6581b.indexOf(java.lang.Integer.valueOf((int) java.lang.Math.floor(d_renamed)));
            }
            if (iIndexOf >= 0) {
                return this.f6582c.get(iIndexOf);
            }
            return null;
        }

        public boolean b_renamed(int i_renamed) {
            java.util.List<java.lang.Integer> list = this.f6581b;
            if (list != null) {
                return list.contains(java.lang.Integer.valueOf(i_renamed));
            }
            return false;
        }

        public boolean b_renamed(float f_renamed) {
            java.util.List<java.lang.Integer> list = this.f6581b;
            if (list == null) {
                return false;
            }
            double d_renamed = f_renamed;
            return list.contains(java.lang.Integer.valueOf((int) java.lang.Math.ceil(d_renamed))) || this.f6581b.contains(java.lang.Integer.valueOf((int) java.lang.Math.floor(d_renamed)));
        }

        public float a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
            int iIntValue;
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption2;
            if (this.f6581b != null && this.f6582c != null && cameraMenuOption != null) {
                boolean z_renamed = 1 == com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.getLayoutDirection();
                if (this.f6582c.contains(cameraMenuOption)) {
                    iIntValue = cameraMenuOption.J_renamed().getLeft();
                } else {
                    java.lang.String strA = cameraMenuOption.a_renamed();
                    if (android.text.TextUtils.isEmpty(strA)) {
                        return 0.0f;
                    }
                    if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.p_renamed(strA)) {
                        for (int i_renamed = 0; i_renamed < this.f6582c.size(); i_renamed++) {
                            if (z_renamed) {
                                int size = (this.f6582c.size() - i_renamed) - 1;
                                cameraMenuOption2 = size >= 0 ? this.f6582c.get(size) : this.f6582c.get(0);
                            } else {
                                cameraMenuOption2 = this.f6582c.get(i_renamed);
                            }
                            if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.p_renamed(cameraMenuOption2.a_renamed())) {
                                iIntValue = this.f6581b.get(i_renamed).intValue();
                                break;
                            }
                        }
                    }
                    if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.r_renamed(strA)) {
                        for (int i2 = 0; i2 < this.f6582c.size(); i2++) {
                            if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.r_renamed(this.f6582c.get(i2).a_renamed())) {
                                iIntValue = this.f6581b.get(i2).intValue();
                                break;
                            }
                        }
                    }
                    if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.q_renamed(strA)) {
                        for (int i3 = 0; i3 < this.f6582c.size(); i3++) {
                            if (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel.this.q_renamed(this.f6582c.get(i3).a_renamed())) {
                                iIntValue = this.f6581b.get(i3).intValue();
                            }
                        }
                    }
                }
                return iIntValue;
            }
            return 0.0f;
        }

        public boolean b_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption) {
            java.util.List<com.oplus.camera.ui.menu.setting.CameraMenuOption> list = this.f6582c;
            return (list == null || cameraMenuOption == null || !list.contains(cameraMenuOption)) ? false : true;
        }
    }

    public void setPaddingLeftRight(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    private boolean a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption2) {
        java.lang.String strA = cameraMenuOption.a_renamed();
        java.lang.String strA2 = cameraMenuOption2.a_renamed();
        if (!android.text.TextUtils.isEmpty(strA) && !android.text.TextUtils.isEmpty(strA2)) {
            if (strA.equals(strA2)) {
                return true;
            }
            if ((p_renamed(strA) && p_renamed(strA2)) || ((r_renamed(strA) && r_renamed(strA2)) || (q_renamed(strA) && q_renamed(strA2)))) {
                return true;
            }
        }
        return false;
    }
}
