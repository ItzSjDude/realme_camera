package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraDrawerSettingMenuPanel extends com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel implements com.oplus.camera.ui.menu.setting.down.DrawerLayout.c_renamed {
    private int h_renamed;
    private int i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private com.oplus.camera.ui.inverse.InverseImageView l_renamed;
    private float m_renamed;
    private float n_renamed;
    private int o_renamed;
    private int p_renamed;

    public CameraDrawerSettingMenuPanel(android.content.Context context) {
        this(context, null);
    }

    public CameraDrawerSettingMenuPanel(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = null;
        this.m_renamed = 0.0f;
        this.n_renamed = 0.0f;
        this.o_renamed = 0;
        this.p_renamed = 0;
        p_renamed();
    }

    private void p_renamed() {
        this.h_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.submenu_threshold_level_one);
        this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.submenu_threshold_level_two);
        this.o_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.submenu_layout_offset);
        this.n_renamed = getResources().getDimension(com.oplus.camera.R_renamed.dimen.drawer_layout_space);
        setClipChildren(false);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel
    public void a_renamed(com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.ui.menu.h_renamed hVar, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.e_renamed = comboPreferences;
        n_renamed();
        this.f6574c = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.d_renamed = cameraUIListener;
        this.g_renamed = i_renamed;
        setMotionEventSplittingEnabled(false);
        java.util.List<java.lang.String> menuPanelOptionList = com.oplus.camera.aps.config.CameraConfig.getMenuPanelOptionList();
        if (menuPanelOptionList != null && menuPanelOptionList.size() > 0) {
            for (java.lang.String str : menuPanelOptionList) {
                com.oplus.camera.ui.menu.b_renamed bVarA = hVar.a_renamed(com.oplus.camera.entry.b_renamed.b_renamed(str, this.d_renamed.bc_renamed().J_renamed()));
                if (bVarA != null) {
                    com.oplus.camera.ui.menu.setting.g_renamed gVar = new com.oplus.camera.ui.menu.setting.g_renamed(this.e_renamed, this.f_renamed, bVarA, this, this.d_renamed, this.g_renamed, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(str, getCameraId()));
                    com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.f_renamed, gVar);
                    gVar.b_renamed();
                    gVar.a_renamed(8);
                    this.f6574c.add(gVar);
                    gVar.a_renamed((android.view.ViewGroup) this);
                    gVar.J_renamed().setContentDescription(bVarA.getOptionTitle());
                    if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(bVarA.getOptionKey())) {
                        q_renamed();
                    }
                }
            }
        }
        this.j_renamed = true;
    }

    private void q_renamed() {
        this.l_renamed = new com.oplus.camera.ui.inverse.InverseImageView(getContext());
        this.l_renamed.setId(com.oplus.camera.R_renamed.id_renamed.drawer_setting_divider);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.f_renamed, this.l_renamed);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_line_width), getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_line_height));
        layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_line_margin_top);
        this.l_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.drawer_line_color_selector);
        this.l_renamed.setLayoutParams(layoutParams);
        addView(this.l_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel
    public void a_renamed() {
        if (this.f6574c == null || this.f6574c.size() <= 0) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
            if (next != null && !next.i_renamed()) {
                next.a_renamed(false, false);
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption;
        com.oplus.camera.ui.inverse.InverseImageView inverseImageView;
        if (this.f6574c == null || !this.j_renamed || this.f6574c.size() <= 0 || !this.f6573b) {
            return;
        }
        int i5 = i3 - i_renamed;
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_layout_space_top) + 0.0f;
        for (int i6 = 0; i6 < this.f6574c.size() && (cameraMenuOption = this.f6574c.get(i6)) != null; i6++) {
            if (8 != cameraMenuOption.G_renamed()) {
                int iC = cameraMenuOption.C_renamed();
                if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(cameraMenuOption.a_renamed()) && (inverseImageView = this.l_renamed) != null) {
                    float f_renamed = dimensionPixelSize + ((android.widget.LinearLayout.LayoutParams) inverseImageView.getLayoutParams()).topMargin;
                    com.oplus.camera.ui.inverse.InverseImageView inverseImageView2 = this.l_renamed;
                    int i7 = (int) f_renamed;
                    inverseImageView2.layout((i5 - inverseImageView2.getMeasuredWidth()) / 2, i7, (this.l_renamed.getMeasuredWidth() + i5) / 2, this.l_renamed.getMeasuredHeight() + i7);
                    dimensionPixelSize = f_renamed + this.l_renamed.getMeasuredHeight() + ((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).bottomMargin;
                }
                float f2 = iC;
                cameraMenuOption.a_renamed(0, (int) dimensionPixelSize, i5, (int) (dimensionPixelSize + f2));
                dimensionPixelSize += f2 + this.n_renamed;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i2);
        this.p_renamed = 0;
        if (this.f6574c != null && this.f6574c.size() > 0) {
            size = 0;
            for (int i3 = 0; i3 < this.f6574c.size(); i3++) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.f6574c.get(i3);
                if (cameraMenuOption != null && 8 != cameraMenuOption.G_renamed()) {
                    size = (int) (size + cameraMenuOption.C_renamed() + this.n_renamed);
                    this.p_renamed++;
                }
            }
            com.oplus.camera.ui.inverse.InverseImageView inverseImageView = this.l_renamed;
            if (inverseImageView != null) {
                measureChild(inverseImageView, i_renamed, i2);
                size = size + this.l_renamed.getMeasuredHeight() + ((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).topMargin + ((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).bottomMargin;
            }
            if (size != 0) {
                size = (int) (((int) (size + getResources().getDimension(com.oplus.camera.R_renamed.dimen.drawer_layout_space_top))) - this.n_renamed);
            }
            this.p_renamed--;
        }
        super.onMeasure(i_renamed, android.view.View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel, com.oplus.camera.ui.menu.setting.i_renamed
    public void a_renamed(java.lang.String str, java.lang.String str2) throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = this.f6574c.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(next.a_renamed())) {
                    ((com.oplus.camera.ui.menu.setting.g_renamed) next).n_renamed(str2);
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel
    public void setPendingDrawerGuideAni(final java.lang.Runnable runnable) {
        addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (!com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel.this.j_renamed || i3 - i_renamed <= 0 || i4 - i2 <= 0) {
                    return;
                }
                runnable.run();
                com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel.this.removeOnLayoutChangeListener(this);
            }
        });
    }

    @Override // com.oplus.camera.ui.menu.setting.down.DrawerLayout.c_renamed
    public void setOffset(float f_renamed) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        com.oplus.camera.ui.inverse.InverseImageView inverseImageView;
        this.m_renamed = f_renamed;
        if (this.f6574c == null || !this.j_renamed || this.f6574c.size() <= 0) {
            return;
        }
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_layout_space_top) + 0.0f;
        int i2 = (int) (0 + dimensionPixelSize);
        int i3 = 1;
        float f2 = dimensionPixelSize - this.o_renamed;
        for (int i4 = 0; i4 < this.f6574c.size(); i4++) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = this.f6574c.get(i4);
            if (cameraMenuOption == null) {
                return;
            }
            if (8 != cameraMenuOption.G_renamed()) {
                int iC = cameraMenuOption.C_renamed();
                if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(cameraMenuOption.a_renamed()) && (inverseImageView = this.l_renamed) != null) {
                    int i5 = i2 + ((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).topMargin;
                    this.l_renamed.setAlpha(com.oplus.camera.util.Util.a_renamed(f_renamed, 0.0f, 1.0f));
                    i2 = i5 + ((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).bottomMargin;
                    f2 = f2 + (((android.widget.LinearLayout.LayoutParams) inverseImageView.getLayoutParams()).topMargin * f_renamed) + (((android.widget.LinearLayout.LayoutParams) this.l_renamed.getLayoutParams()).bottomMargin * f_renamed);
                    this.l_renamed.scrollTo(0, (int) ((i2 - f2) - (this.o_renamed * f_renamed)));
                }
                if (i4 == this.f6574c.size() - 1 || !this.k_renamed) {
                    cameraMenuOption.a_renamed(com.oplus.camera.util.Util.a_renamed(f_renamed, 0.0f, 1.0f));
                } else {
                    if (3 == this.p_renamed && 2 == i3) {
                        i_renamed = this.i_renamed;
                    } else {
                        i_renamed = this.h_renamed;
                    }
                    float f3 = ((this.o_renamed + i2) - r0) - i_renamed;
                    cameraMenuOption.a_renamed((f3 - cameraMenuOption.J_renamed().getScrollY()) / f3);
                }
                cameraMenuOption.J_renamed().scrollTo(0, (int) ((i2 - f2) - (this.o_renamed * f_renamed)));
                if (java.lang.Float.compare(1.0f, f_renamed) == 0 && (cameraMenuOption.J_renamed() instanceof android.view.ViewGroup) && ((android.view.ViewGroup) cameraMenuOption.J_renamed()).getChildCount() > 0 && java.lang.Float.compare(((android.view.ViewGroup) cameraMenuOption.J_renamed()).getChildAt(0).getAlpha(), 1.0f) < 0) {
                    com.oplus.camera.e_renamed.b_renamed("CameraDrawerSettingMenuPanel", "setOffset, reSetOffset: " + this.m_renamed);
                    cameraMenuOption.J_renamed().post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraDrawerSettingMenuPanel$CS8_kezgfoN5lpFJV38UVGY2s6A
                        @Override // java.lang.Runnable
                        public final void run() throws android.content.res.Resources.NotFoundException {
                            this.f_renamed$0.r_renamed();
                        }
                    });
                }
                float f4 = this.n_renamed;
                f2 += (iC + f4) * f_renamed;
                i2 = (int) (i2 + iC + f4);
                i3++;
            }
        }
        this.k_renamed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r_renamed() throws android.content.res.Resources.NotFoundException {
        if (java.lang.Float.compare(this.m_renamed, 1.0f) == 0) {
            setOffset(1.0f);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (1.0f != this.m_renamed) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
