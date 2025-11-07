package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraMenuOptionDrawerItem.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.ui.menu.setting.CameraMenuOption implements android.view.View.OnClickListener, android.view.View.OnTouchListener, com.oplus.camera.ui.inverse.a_renamed {
    private java.util.List<com.oplus.camera.ui.menu.e_renamed> A_renamed;
    private java.lang.String r_renamed;
    private android.widget.PopupWindow s_renamed;
    private java.lang.String t_renamed;
    private int u_renamed;
    private android.view.View v_renamed;
    private com.oplus.camera.ui.menu.OplusTextView w_renamed;
    private android.content.Context x_renamed;
    private java.util.List<android.view.View> y_renamed;
    private boolean z_renamed;

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void d_renamed(boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int z_renamed() {
        return 0;
    }

    public g_renamed(com.oplus.camera.ComboPreferences comboPreferences, android.content.Context context, com.oplus.camera.ui.menu.b_renamed bVar, com.oplus.camera.ui.menu.setting.i_renamed iVar, com.oplus.camera.ui.CameraUIListener cameraUIListener, int i_renamed, java.lang.String str) {
        super(comboPreferences, context, bVar, iVar, cameraUIListener, i_renamed, str);
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = -1;
        this.v_renamed = null;
        this.y_renamed = new java.util.ArrayList();
        this.z_renamed = false;
        this.A_renamed = new java.util.ArrayList();
        this.x_renamed = context;
        aj_renamed();
        this.d_renamed = true;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void b_renamed() throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "initCameraMenuOptionView");
        this.y_renamed.clear();
        this.v_renamed = android.view.View.inflate(this.x_renamed, com.oplus.camera.R_renamed.layout.menu_option_image, null);
        this.v_renamed.setOnClickListener(this);
        this.w_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.v_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tv_title);
        this.w_renamed.setMatchParent(true);
        this.w_renamed.setText(this.r_renamed);
        this.w_renamed.setOnClickListener(this);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.v_renamed.getContext(), this.w_renamed);
        if (O_renamed() == 0) {
            int iA = 0;
            for (int i2 = 0; i2 < X_renamed(); i2++) {
                iA = a_renamed(h_renamed((X_renamed() - i2) - 1), i2, false);
            }
            i_renamed = iA;
        } else if (1 == O_renamed()) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < X_renamed()) {
                com.oplus.camera.ui.menu.OplusTextView oplusTextView = new com.oplus.camera.ui.menu.OplusTextView(this.x_renamed);
                oplusTextView.setTextSize(0, this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_text_size));
                int dimensionPixelSize = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_text_width);
                int dimensionPixelSize2 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_text_height);
                int dimensionPixelSize3 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_text_space);
                int dimensionPixelSize4 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_menu_text_last_space);
                int dimensionPixelSize5 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_text_padding);
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                int i5 = (i3 * dimensionPixelSize) + (dimensionPixelSize3 * i3) + dimensionPixelSize4;
                layoutParams.setMarginEnd(i5);
                oplusTextView.setGravity(17);
                oplusTextView.setMaxWidth(this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_text_max_width));
                oplusTextView.setSingleLine(true);
                oplusTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                oplusTextView.setMarqueeRepeatLimit(6);
                oplusTextView.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                oplusTextView.setText(i3 == 0 ? com.oplus.camera.R_renamed.string.camera_slogan_assignment_on : com.oplus.camera.R_renamed.string.camera_slogan_assignment_off);
                oplusTextView.setTextColor(this.x_renamed.getColorStateList(com.oplus.camera.R_renamed.color.drawer_item_text_color_selector));
                com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.x_renamed, oplusTextView);
                com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed((X_renamed() - i3) - 1);
                if (eVarH != null) {
                    oplusTextView.setText(eVarH.e_renamed());
                }
                ((android.widget.FrameLayout) this.v_renamed).addView(oplusTextView, layoutParams);
                this.y_renamed.add(oplusTextView);
                oplusTextView.setOnClickListener(this);
                i3++;
                i4 = dimensionPixelSize + i5;
            }
            i_renamed = i4;
        } else if (2 == O_renamed()) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.v_renamed;
            com.oplus.camera.ui.inverse.InverseImageView inverseImageView = new com.oplus.camera.ui.inverse.InverseImageView(this.x_renamed);
            frameLayout.setBackgroundResource(com.oplus.camera.R_renamed.drawable.bg_camera_setting_item);
            int dimensionPixelSize6 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_item_icon_w_h);
            int dimensionPixelSize7 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.more_item_icon_w_h);
            int dimensionPixelSize8 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_set_icon_last_space);
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize6, dimensionPixelSize7);
            layoutParams2.gravity = 8388629;
            layoutParams2.setMarginEnd(dimensionPixelSize8);
            inverseImageView.setImageResource(com.oplus.camera.R_renamed.drawable.enter_camera_setting_selector);
            inverseImageView.setContentDescription(this.r_renamed);
            if (1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault())) {
                inverseImageView.setRotation(180.0f);
            }
            if (frameLayout instanceof com.oplus.camera.ui.menu.RippleLayout) {
                ((com.oplus.camera.ui.menu.RippleLayout) frameLayout).setNeedForbidEvent(true);
            }
            i_renamed = dimensionPixelSize8 + dimensionPixelSize6;
            frameLayout.addView(inverseImageView, layoutParams2);
            android.widget.FrameLayout.LayoutParams layoutParams3 = (android.widget.FrameLayout.LayoutParams) this.w_renamed.getLayoutParams();
            layoutParams3.topMargin = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_line_margin_bottom) + this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_key_layout_margin_top);
            this.w_renamed.setLayoutParams(layoutParams3);
            com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.x_renamed, inverseImageView);
            inverseImageView.setOnClickListener(this);
        } else {
            i_renamed = 0;
        }
        android.widget.FrameLayout.LayoutParams layoutParams4 = (android.widget.FrameLayout.LayoutParams) this.w_renamed.getLayoutParams();
        layoutParams4.width = ((com.oplus.camera.util.Util.getScreenWidth() - i_renamed) - layoutParams4.leftMargin) - layoutParams4.rightMargin;
        this.w_renamed.setLayoutParams(layoutParams4);
        super.b_renamed();
    }

    private int a_renamed(com.oplus.camera.ui.menu.e_renamed eVar, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.RotateImageView rotateImageView = new com.oplus.camera.ui.RotateImageView(this.x_renamed);
        int dimensionPixelSize = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width);
        int dimensionPixelSize2 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_height);
        int dimensionPixelSize3 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_menu_icon_space);
        int dimensionPixelSize4 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_last_space);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.gravity = 8388629;
        int i2 = (i_renamed * dimensionPixelSize) + (dimensionPixelSize3 * i_renamed) + dimensionPixelSize4;
        layoutParams.setMarginEnd(i2);
        int dimensionPixelSize5 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_padding_left_right);
        int dimensionPixelSize6 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_padding_top_bottom);
        rotateImageView.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
        rotateImageView.setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.x_renamed, com.oplus.camera.R_renamed.drawable.drawer_item_iv_background).mutate());
        if (eVar != null) {
            rotateImageView.setImageDrawable(eVar.a_renamed());
            rotateImageView.setContentDescription(eVar.d_renamed());
            rotateImageView.setTag(eVar.c_renamed());
        }
        ((android.widget.FrameLayout) this.v_renamed).addView(rotateImageView, layoutParams);
        if (z_renamed) {
            this.y_renamed.add(i_renamed, rotateImageView);
        } else {
            this.y_renamed.add(rotateImageView);
        }
        rotateImageView.setOnClickListener(this);
        rotateImageView.setOnTouchListener(this);
        return i2 + dimensionPixelSize;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(java.lang.String str, com.oplus.camera.ui.menu.e_renamed eVar) {
        int size = this.y_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (this.y_renamed.get(i_renamed).getTag().equals(eVar.c_renamed())) {
                if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(eVar.c_renamed()) && com.oplus.camera.util.Util.u_renamed()) {
                    ((com.oplus.camera.ui.RotateImageView) this.y_renamed.get(i_renamed)).setImageDrawable(this.x_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.photo_ratio_14_15_selector));
                } else {
                    ((com.oplus.camera.ui.RotateImageView) this.y_renamed.get(i_renamed)).setImageDrawable(eVar.a_renamed());
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void u_renamed() {
        super.u_renamed();
        if (this.l_renamed != null) {
            this.l_renamed.c_renamed(a_renamed());
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (!this.n_renamed.aY_renamed()) {
            super.a_renamed(z_renamed, z2);
        }
        if (!this.e_renamed && s_renamed()) {
            if (J_renamed() != null) {
                J_renamed().setClickable(z_renamed);
                if (J_renamed() instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) J_renamed();
                    for (int i_renamed = 0; i_renamed < viewGroup.getChildCount(); i_renamed++) {
                        viewGroup.getChildAt(i_renamed).setClickable(z_renamed);
                    }
                    if (z_renamed && com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(a_renamed())) {
                        n_renamed(null);
                    }
                }
            }
            this.q_renamed = z_renamed;
            if (this.f6560b != null) {
                this.f6560b.a_renamed(z_renamed, z2);
                return;
            }
            return;
        }
        if (J_renamed() != null) {
            J_renamed().setClickable(false);
            if (J_renamed() instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) J_renamed();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    viewGroup2.getChildAt(i2).setClickable(false);
                }
            }
        }
        this.q_renamed = false;
        if (this.f6560b != null) {
            this.f6560b.a_renamed(false, true);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, int i2, int i3) {
        if (str2 == null || str2.isEmpty() || this.s_renamed == null) {
            return;
        }
        w_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void w_renamed() {
        android.widget.PopupWindow popupWindow = this.s_renamed;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                this.s_renamed.dismiss();
            }
            this.s_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.View view) {
        this.v_renamed = view;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public android.view.View J_renamed() {
        return this.v_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(float f_renamed) {
        for (int i_renamed = 0; i_renamed < ((android.view.ViewGroup) this.v_renamed).getChildCount(); i_renamed++) {
            ((android.view.ViewGroup) this.v_renamed).getChildAt(i_renamed).setAlpha(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void q_renamed() {
        int color;
        int color2;
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "updateMenuOptionView, index: " + ad_renamed() + ", title: " + N_renamed());
        if (X_renamed() > 0) {
            if (R_renamed() != null && aa_renamed() && !android.text.TextUtils.isEmpty(V_renamed()) && com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(a_renamed())) {
                if (android.text.TextUtils.isEmpty(com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                    int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.n_renamed.G_renamed()) / 100;
                    double dA_renamed = configIntValue > 0 ? configIntValue : com.oplus.camera.util.Util.a_renamed(this.x_renamed, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n_renamed.G_renamed()));
                    if (java.lang.Float.compare((float) dA_renamed, 0.0f) != 0) {
                        this.t_renamed = this.x_renamed.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard_high_hint, java.lang.Double.valueOf(dA_renamed));
                        this.u_renamed = (int) dA_renamed;
                    }
                } else {
                    this.t_renamed = this.x_renamed.getString(com.oplus.camera.R_renamed.string.camera_setting_menu_high_resolution_item);
                }
                this.w_renamed.setText(this.t_renamed);
            }
            if (O_renamed() == 0) {
                for (int i_renamed = 0; i_renamed < X_renamed(); i_renamed++) {
                    int iX = (X_renamed() - i_renamed) - 1;
                    if (iX >= this.y_renamed.size()) {
                        return;
                    }
                    com.oplus.camera.ui.RotateImageView rotateImageView = (com.oplus.camera.ui.RotateImageView) this.y_renamed.get(iX);
                    if (rotateImageView.getDrawable() == null) {
                        return;
                    }
                    int i2 = this.u_renamed;
                    if (-1 != i2) {
                        rotateImageView.setHighResolutionType(i2);
                    }
                    if (i_renamed == ad_renamed()) {
                        if (this.z_renamed) {
                            color = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
                            color2 = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_85_percent_transparency);
                        } else {
                            color = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_85_percent_transparency);
                            color2 = com.oplus.camera.util.Util.A_renamed(this.x_renamed);
                        }
                    } else if (this.z_renamed) {
                        color = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
                        color2 = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_15_percent_transparency);
                    } else {
                        color = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
                        color2 = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency);
                    }
                    com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed(i_renamed);
                    if (eVarH != null) {
                        if (eVarH.f_renamed()) {
                            rotateImageView.setEnabled(true);
                        } else {
                            rotateImageView.a_renamed(false, false);
                            color = this.x_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_30_percent_transparency);
                        }
                    }
                    rotateImageView.a_renamed(color, color2);
                }
            } else if (1 == O_renamed()) {
                for (int i3 = 0; i3 < this.y_renamed.size(); i3++) {
                    int iX2 = (X_renamed() - i3) - 1;
                    com.oplus.camera.ui.menu.e_renamed eVarH2 = h_renamed(iX2);
                    if (eVarH2 == null) {
                        return;
                    }
                    android.widget.TextView textView = (android.widget.TextView) this.y_renamed.get(i3);
                    textView.setEnabled(eVarH2.f_renamed());
                    if (iX2 == ad_renamed() && !ah_renamed()) {
                        textView.setSelected(true);
                        textView.setBackground(this.x_renamed.getDrawable(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(a_renamed()) ? com.oplus.camera.R_renamed.drawable.drawer_item_round_bg_selected : com.oplus.camera.R_renamed.drawable.drawer_item_tv_background));
                    } else {
                        boolean zF = eVarH2.f_renamed();
                        int i4 = com.oplus.camera.R_renamed.drawable.drawer_item_round_bg_unselected;
                        if (!zF) {
                            com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "updateMenuOptionView, key: " + a_renamed() + ", disabled.");
                            textView.setSelected(false);
                            android.content.Context context = this.x_renamed;
                            if (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(a_renamed())) {
                                i4 = com.oplus.camera.R_renamed.drawable.drawer_item_tv_background_grey;
                            }
                            textView.setBackground(context.getDrawable(i4));
                        } else {
                            textView.setSelected(false);
                            android.content.Context context2 = this.x_renamed;
                            if (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(a_renamed())) {
                                i4 = com.oplus.camera.R_renamed.drawable.drawer_item_tv_background_grey;
                            }
                            textView.setBackground(context2.getDrawable(i4));
                        }
                    }
                }
            }
        }
        android.view.View view = this.v_renamed;
        if (view != null) {
            view.invalidate();
            android.view.View view2 = this.v_renamed;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(a_renamed().equals(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION) ? this.t_renamed : this.r_renamed);
            sb.append(U_renamed());
            view2.setContentDescription(sb.toString());
        }
        if (ab_renamed()) {
            d_renamed(ad_renamed() != 0);
        }
    }

    private boolean ah_renamed() {
        if (this.f6559a == null || !com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(a_renamed())) {
            return false;
        }
        return "on_renamed".equals(this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS_SETTING_SUPPORT);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public boolean a_renamed(java.util.List<java.lang.String> list, java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.e_renamed eVar = null;
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(a_renamed())) {
            boolean zB = com.oplus.camera.util.Util.b_renamed("video_size_4kuhd", this.n_renamed.G_renamed());
            java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it = this.p_renamed.getOptionItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.oplus.camera.ui.menu.e_renamed next = it.next();
                if ("video_size_4kuhd".equals(next.c_renamed())) {
                    com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "updateSupportedItems, key: " + a_renamed() + ", enable 4k: " + zB);
                    next.a_renamed(zB);
                    eVar = next;
                    break;
                }
            }
            if (!zB) {
                j_renamed("video_size_4kuhd");
            } else if (eVar != null && !Y_renamed().contains(eVar)) {
                a_renamed(eVar);
            }
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(a_renamed())) {
            n_renamed(null);
            return true;
        }
        return super.a_renamed(list, str);
    }

    public void a_renamed(com.oplus.camera.ui.menu.e_renamed eVar) throws android.content.res.Resources.NotFoundException {
        int iK = super.k_renamed(eVar.c_renamed());
        if (z_renamed() == 0) {
            a_renamed(eVar, (X_renamed() - iK) - 1, true);
            ai_renamed();
        }
    }

    private com.oplus.camera.ui.menu.e_renamed o_renamed(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < this.A_renamed.size(); i_renamed++) {
            com.oplus.camera.ui.menu.e_renamed eVar = this.A_renamed.get(i_renamed);
            if (eVar != null && android.text.TextUtils.equals(eVar.c_renamed(), str)) {
                return eVar;
            }
        }
        return null;
    }

    private com.oplus.camera.ui.menu.e_renamed p_renamed(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < X_renamed(); i_renamed++) {
            com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed(i_renamed);
            if (eVarH != null && android.text.TextUtils.equals(eVarH.c_renamed(), str)) {
                return eVarH;
            }
        }
        return null;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int j_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        java.lang.String strD;
        com.oplus.camera.ui.RotateImageView rotateImageView;
        if (!this.n_renamed.g_renamed(a_renamed())) {
            return -1;
        }
        int iJ = super.j_renamed(str);
        if (iJ < 0) {
            com.oplus.camera.e_renamed.e_renamed("CameraMenuOptionDrawerItem", "removeOptionItem, itemValue: " + str + ", not found in_renamed current option items.");
            return iJ;
        }
        if (z_renamed() == 0) {
            java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it = this.p_renamed.getOptionItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    strD = null;
                    break;
                }
                com.oplus.camera.ui.menu.e_renamed next = it.next();
                if (str.equals(next.c_renamed())) {
                    strD = next.d_renamed();
                    break;
                }
            }
            if (strD != null) {
                java.util.Iterator<android.view.View> it2 = this.y_renamed.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        rotateImageView = null;
                        break;
                    }
                    rotateImageView = (com.oplus.camera.ui.RotateImageView) it2.next();
                    if (strD.equals(rotateImageView.getContentDescription().toString())) {
                        ((android.widget.FrameLayout) this.v_renamed).removeView(rotateImageView);
                        break;
                    }
                }
                if (rotateImageView != null) {
                    this.y_renamed.remove(rotateImageView);
                }
            }
            ai_renamed();
        }
        return iJ;
    }

    private void ai_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_width);
        int dimensionPixelSize2 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_height);
        int dimensionPixelSize3 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_menu_icon_space);
        int dimensionPixelSize4 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_last_space);
        for (android.view.View view : this.y_renamed) {
            int iIndexOf = this.y_renamed.indexOf(view);
            if (-1 != iIndexOf) {
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                layoutParams.setMarginEnd((iIndexOf * dimensionPixelSize) + (iIndexOf * dimensionPixelSize3) + dimensionPixelSize4);
                int dimensionPixelSize5 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_padding_left_right);
                int dimensionPixelSize6 = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_item_icon_padding_top_bottom);
                view.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public void n_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, this.n_renamed.G_renamed()));
        }
        com.oplus.camera.ui.menu.e_renamed eVarP = p_renamed(java.lang.String.valueOf(120));
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(this.n_renamed.G_renamed())) {
            if (eVarP != null) {
                this.A_renamed.add(eVarP);
                j_renamed(java.lang.String.valueOf(120));
            }
        } else if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS)) {
            j_renamed(java.lang.String.valueOf(120));
        } else {
            boolean z_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) && "video_size_4kuhd".equals(str);
            if (eVarP != null) {
                eVarP.a_renamed(z_renamed);
            } else {
                com.oplus.camera.ui.menu.e_renamed eVarO = o_renamed(java.lang.String.valueOf(120));
                if (eVarO != null) {
                    a_renamed(eVarO);
                    this.A_renamed.remove(eVarO);
                    eVarO.a_renamed(z_renamed);
                }
            }
        }
        com.oplus.camera.ui.menu.e_renamed eVarP2 = p_renamed(java.lang.String.valueOf(24));
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_8K_24_FPS)) {
            com.oplus.camera.ui.menu.e_renamed eVarP3 = p_renamed(java.lang.String.valueOf(30));
            if ("video_size_8k".equals(str)) {
                if (eVarP2 != null) {
                    eVarP2.a_renamed(true);
                } else {
                    com.oplus.camera.ui.menu.e_renamed eVarO2 = o_renamed(java.lang.String.valueOf(24));
                    if (eVarO2 != null) {
                        a_renamed(eVarO2);
                        this.A_renamed.remove(eVarO2);
                        eVarO2.a_renamed(true);
                    }
                }
                if (eVarP3 != null) {
                    if (!this.A_renamed.contains(eVarP3)) {
                        this.A_renamed.add(eVarP3);
                    }
                    j_renamed(java.lang.String.valueOf(30));
                }
            } else {
                com.oplus.camera.ui.menu.e_renamed eVarO3 = o_renamed(java.lang.String.valueOf(30));
                if (eVarO3 != null) {
                    a_renamed(eVarO3);
                    this.A_renamed.remove(eVarO3);
                    eVarO3.a_renamed(true);
                }
                if (eVarP2 != null) {
                    if (!this.A_renamed.contains(eVarP2)) {
                        this.A_renamed.add(eVarP2);
                    }
                    j_renamed(java.lang.String.valueOf(24));
                }
            }
        } else if (eVarP2 != null) {
            j_renamed(java.lang.String.valueOf(24));
        }
        boolean z2 = com.oplus.camera.util.Util.a_renamed(this.n_renamed.G_renamed(), str) && !ah_renamed();
        for (int i_renamed = 0; i_renamed < X_renamed(); i_renamed++) {
            com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed(i_renamed);
            if (eVarH != null && 60 == java.lang.Integer.parseInt(eVarH.c_renamed())) {
                com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "updateVideoFpsItemsAvailability, video resolution value: " + str + ", enable 60fps: " + z2);
                eVarH.a_renamed(z2);
                q_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public boolean a_renamed(java.lang.String str, java.lang.String... strArr) {
        if (!a_renamed().equals(str)) {
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (java.lang.String str2 : strArr) {
            k_renamed(str2);
        }
        if (this.f6560b == null) {
            return true;
        }
        m_renamed();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.l_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "onClick, Key: " + a_renamed());
            if (J_renamed() == null || J_renamed().isClickable()) {
                if (this.f6560b == null) {
                    k_renamed();
                }
                if (2 == ac_renamed()) {
                    return;
                }
                if (Z_renamed()) {
                    int iX = X_renamed();
                    if (com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
                        com.oplus.camera.ui.menu.g_renamed.d_renamed();
                    }
                    int iX2 = (X_renamed() - this.y_renamed.indexOf(view)) - 1;
                    if (2 == O_renamed()) {
                        iX2 = this.o_renamed;
                        if (2 <= iX) {
                            iX2 = iX2 < iX + (-1) ? iX2 + 1 : 0;
                        }
                    }
                    if (ad_renamed() != iX2) {
                        i_renamed(iX2);
                        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "onClick, length: " + iX + ", index: " + iX2);
                        if (!com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(a_renamed())) {
                            q_renamed();
                        }
                    } else {
                        com.oplus.camera.e_renamed.e_renamed("CameraMenuOptionDrawerItem", "onClick, cancel, index unchanged");
                        return;
                    }
                } else if (h_renamed()) {
                    p_renamed();
                } else {
                    o_renamed();
                }
                boolean zA = this.l_renamed.a_renamed(a_renamed(), false, true);
                android.view.View view2 = this.v_renamed;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(a_renamed()) ? this.t_renamed : this.r_renamed);
                sb.append(U_renamed());
                view2.setContentDescription(sb.toString());
                com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "onClick, Key: " + a_renamed() + ", menuOptionClickResult: " + zA);
                a_renamed(1.0f);
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.ViewGroup viewGroup) {
        super.a_renamed(viewGroup);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int B_renamed() {
        android.view.View view = this.v_renamed;
        if (view != null) {
            return view.getWidth();
        }
        return super.B_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int C_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.v_renamed != null) {
            int dimensionPixelSize = this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_height);
            return 2 == O_renamed() ? dimensionPixelSize + this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_layout_arrow_height) + this.x_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.drawer_line_margin_bottom) : dimensionPixelSize;
        }
        return super.C_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void h_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "setOptionItemText, text: " + str);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionDrawerItem", "setImageIcon, icon: " + drawable);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(int i_renamed, boolean z_renamed) {
        super.a_renamed(i_renamed, z_renamed);
        for (int i2 = 0; i2 < this.y_renamed.size(); i2++) {
            android.view.View view = this.y_renamed.get(i2);
            if (view instanceof com.oplus.camera.ui.RotateImageView) {
                ((com.oplus.camera.ui.RotateImageView) view).a_renamed(i_renamed, z_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void A_renamed() {
        if (this.v_renamed != null) {
            super.A_renamed();
            a_renamed((android.view.View) null);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void f_renamed(int i_renamed) {
        super.f_renamed(i_renamed);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:98:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void aj_renamed() {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.g_renamed.aj_renamed():void");
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption, com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    public void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption, int i_renamed) {
        super.a_renamed(cameraMenuOption, i_renamed);
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.z_renamed = z_renamed;
        if (this.y_renamed.size() > 0) {
            q_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void d_renamed(java.lang.String str, boolean z_renamed) {
        java.lang.String strA = a_renamed();
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS.equals(strA)) {
            int iG = this.n_renamed != null ? this.n_renamed.G_renamed() : 0;
            f_renamed(z_renamed);
            a_renamed(iG, str);
            P_renamed();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(strA)) {
            if (this.f6559a != null) {
                this.f6559a.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_MACRO_SWITCH).apply();
            }
            super.d_renamed(str, z_renamed);
            return;
        }
        super.d_renamed(str, z_renamed);
    }

    private void a_renamed(int i_renamed, java.lang.String str) {
        java.lang.String string = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, this.x_renamed.getString(com.oplus.camera.R_renamed.string.camera_video_default_fps));
        if (android.text.TextUtils.isEmpty(str) || str.equals(string)) {
            return;
        }
        boolean zG = g_renamed(i_renamed);
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionDrawerItem", "processVideoFpsChange, fpsType: " + str);
        android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, str);
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
        boolean zEquals = java.lang.String.valueOf(60).equals(str);
        if (30 != java.lang.Integer.parseInt(str)) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off");
        }
        if (zEquals) {
            java.lang.String string2 = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            if (!android.text.TextUtils.isEmpty(string2) && !com.oplus.camera.util.Util.a_renamed(i_renamed, string2)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
                editorEdit.apply();
            }
            if (a_renamed(i_renamed, str, (java.lang.String) null) && java.lang.Float.compare(this.n_renamed.s_renamed(), com.oplus.camera.ag_renamed.f4106a) == 0 && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed");
            } else {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            }
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        } else if (zG) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            this.n_renamed.r_renamed();
        }
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed) && !java.lang.String.valueOf(30).equals(str)) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS)) {
            boolean z_renamed = this.f6559a.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_EIS_FPS);
            if ((z_renamed && zEquals) || (!z_renamed && java.lang.Integer.parseInt(str) != configIntValue)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            }
        } else if (!zEquals) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
        }
        editorEdit.apply();
        a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, str, 0);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
        if (this.n_renamed != null) {
            com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.x_renamed);
            menuClickMsgData.mCaptureType = !this.n_renamed.B_renamed() ? 1 : 0;
            menuClickMsgData.mCaptureMode = this.n_renamed.ao_renamed();
            menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.n_renamed.bc_renamed().J_renamed());
            menuClickMsgData.mCameraId = this.n_renamed.H_renamed();
            menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.n_renamed.H_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
            menuClickMsgData.buildTopMenuEvent(str, str2, i_renamed);
            menuClickMsgData.report();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        super.a_renamed(view, motionEvent);
        return false;
    }
}
