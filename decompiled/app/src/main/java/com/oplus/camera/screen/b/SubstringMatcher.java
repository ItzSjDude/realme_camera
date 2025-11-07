package com.oplus.camera.screen.b_renamed;

/* compiled from: RackScreenMode.java */
/* loaded from: classes2.dex */
public abstract class k_renamed extends com.oplus.camera.screen.b_renamed.a_renamed {
    protected android.view.ViewGroup e_renamed;
    protected boolean d_renamed = false;
    protected android.graphics.Rect f_renamed = null;
    private android.app.Activity g_renamed = null;

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int b_renamed(int i_renamed) {
        return 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public boolean i_renamed() {
        return false;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int j_renamed() {
        return 4;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean r_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean q_renamed() {
        return this.d_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        this.f5361b = com.oplus.camera.screen.f_renamed.f5372b;
        this.f5362c = com.oplus.camera.screen.f_renamed.f5371a / 2;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.topMargin = (com.oplus.camera.screen.f_renamed.f5372b - com.oplus.camera.screen.f_renamed.f5371a) / 2;
        layoutParams.bottomMargin = (com.oplus.camera.screen.f_renamed.f5372b - com.oplus.camera.screen.f_renamed.f5371a) / 2;
        layoutParams.leftMargin = (-(com.oplus.camera.screen.f_renamed.f5372b - com.oplus.camera.screen.f_renamed.f5371a)) / 2;
        layoutParams.rightMargin = (-(com.oplus.camera.screen.f_renamed.f5372b - com.oplus.camera.screen.f_renamed.f5371a)) / 2;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void b_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        activity.getResources();
        this.g_renamed = activity;
        super.b_renamed(activity);
        b_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        f_renamed(activity);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        d_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        c_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        j_renamed(activity);
        f_renamed(activity, null);
        i_renamed(activity);
        h_renamed(activity);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        e_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
    }

    private void h_renamed(final android.app.Activity activity) {
        android.widget.RelativeLayout.LayoutParams layoutParamsE = e_renamed();
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsE.bottomMargin});
        cVar.f5365c = new int[]{layoutParamsE.width, layoutParamsE.height};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container), cVar);
        android.widget.RelativeLayout.LayoutParams layoutParamsF = f_renamed();
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, 0});
        cVar2.f5365c = new int[]{layoutParamsF.width, layoutParamsF.height};
        cVar2.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$ByKUFyXFgVr4znLZI7ydEiwDu8M
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.c_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.main_bar_id), cVar2);
        android.widget.RelativeLayout.LayoutParams layoutParamsG = g_renamed();
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, layoutParamsG.bottomMargin});
        cVar3.f5365c = new int[]{layoutParamsG.width, layoutParamsG.height};
        final int iK = k_renamed();
        cVar3.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$hjpjQpabXjMq7YsWil6PnCyhELc
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.screen.b_renamed.k_renamed.a_renamed(activity, iK, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container), cVar3);
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 9, 0}, new int[]{com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_guide_entry_margin_left), 0, 0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_guide_entry_margin_bottom)});
        cVar4.f5365c = new int[]{-2, -2};
        cVar4.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$lniYpPXN-1MCSBkPK-Pzorjwa0s
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.b_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry), cVar4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.app.Activity activity, android.view.View view) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = (com.oplus.camera.professional.ListProfessionalModeBar) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.main_bar_id);
        if (listProfessionalModeBar == null) {
            return;
        }
        listProfessionalModeBar.b_renamed(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, android.view.View view) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.professional.p_renamed pVar = (com.oplus.camera.professional.p_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container);
        if (pVar == null) {
            return;
        }
        pVar.d_renamed(4, i_renamed);
        int childCount = pVar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = pVar.getChildAt(i2);
            if (childAt instanceof com.oplus.camera.professional.LevelPanel) {
                com.oplus.camera.professional.LevelPanel levelPanel = (com.oplus.camera.professional.LevelPanel) childAt;
                levelPanel.a_renamed(4, i_renamed);
                levelPanel.e_renamed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b_renamed(android.app.Activity activity, android.view.View view) {
        android.view.View viewFindViewById = activity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
        if (viewFindViewById != null) {
            viewFindViewById.setRotation(270.0f);
        }
    }

    private void i_renamed(android.app.Activity activity) {
        android.content.res.Resources resources = activity.getResources();
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_title_margin_bottom)});
        cVar.f5365c = new int[]{-2, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_title_height)};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.mode_title_layout), cVar);
    }

    protected void b_renamed(final android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_arc_seekbar_bg_circle_radius_offset);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size);
        cVar.f5365c = new int[]{dimensionPixelSize * 2, dimensionPixelSize + dimensionPixelSize3};
        cVar.d_renamed = 90;
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$--o2Rp9vyncve6UMwl1OmYv0jP4
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.b_renamed(activity, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{3, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, (-dimensionPixelSize4) - dimensionPixelSize3, 0, 0});
        cVar2.f5365c = new int[]{-2, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click), cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, android.view.View view) {
        com.oplus.camera.ui.preview.af_renamed afVar = (com.oplus.camera.ui.preview.af_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
        afVar.getLayoutParams().width = -1;
        afVar.getLayoutParams().height = i_renamed + i2;
        afVar.a_renamed(i_renamed * 2, i_renamed, i3, i_renamed - i2, 0.0f, 1.0f, 0.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect a_renamed(android.content.res.Resources resources, android.graphics.Rect rect) {
        return new android.graphics.Rect(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_focus_circle_margin_bottom), 0, rect.right, rect.bottom);
    }

    protected void f_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_width);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_height);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_menu_panel_padding_left_right);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 10, 0}, new int[]{0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_margin_top), 0, 0});
        cVar.f5365c = new int[]{dimensionPixelSize, -2};
        cVar.d_renamed = 0;
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$FkoIiEL52jp7eWK5LzY564oVMJU
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.a_renamed(activity, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, android.view.View view) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = i_renamed;
        cameraSettingMenuPanel.getLayoutParams().height = i2;
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setTranslationY(0.0f);
        cameraSettingMenuPanel.setTranslationX(0.0f);
        cameraSettingMenuPanel.setTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation, new android.graphics.PointF(0.0f, 0.0f));
        cameraSettingMenuPanel.setPaddingLeftRight(i3);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel2 = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_shutter_button_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_switch_camera_margin_bottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_thumbnail_vertical_margin_top);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.switch_camera_button_width);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0}, null);
        cVar3.f5365c = new int[]{this.f5361b, this.f5362c};
        cVar3.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$ohxZC6pKxK8tAko7x4TocZAwpJg
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.b_renamed(view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_layout), cVar3);
        cVar2.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout), cVar2);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.shutter_button), new com.oplus.camera.screen.c_renamed(new int[]{13, 0}, new int[]{0, 0, 0, 0}));
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 2, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        cVar4.f5365c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.switch_camera_button), cVar4);
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 2, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        cVar5.f5365c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.video_pause_resume), cVar5);
        com.oplus.camera.screen.c_renamed cVar6 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 3, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        cVar6.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$-UzdMbATTC1Ue9A2rec072Hr5-0
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.a_renamed(view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.thumbnail), cVar6);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn), cVar6);
        com.oplus.camera.screen.c_renamed cVar7 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 3, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        cVar7.f5365c = new int[]{dimensionPixelSize5, dimensionPixelSize5};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.recording_cap_button), cVar7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b_renamed(android.view.View view) {
        ((com.oplus.camera.ui.inverse.InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view) {
        if (view instanceof com.oplus.camera.ui.control.ThumbImageView) {
            ((com.oplus.camera.ui.control.ThumbImageView) view).setPaddingPlus(0);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_headline_margin_right), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_headline_margin_bottom)});
        cVar2.f5365c = new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_headline_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.head_line_height)};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.headline_view), cVar2);
    }

    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button), cVar);
    }

    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_width);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button), cVar);
        activity.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    private void j_renamed(final android.app.Activity activity) {
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(null, null);
        cVar.f5365c = new int[]{0, 0};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$k_renamed$Q_renamed-Pg2kzBCkzjF1iXVUyY1E9z2As
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.k_renamed.a_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.gallery_container), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        ((android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container)).setVisibility(8);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.widget.RelativeLayout.LayoutParams a_renamed(android.util.Size size) {
        android.graphics.Rect rectB = b_renamed(size.getHeight(), size.getWidth());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(rectB.width(), rectB.height());
        layoutParams.topMargin = rectB.top;
        layoutParams.rightMargin = com.oplus.camera.util.Util.getScreenWidth() - rectB.right;
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        int[] iArr = new int[4];
        double width = size.getWidth() / size.getHeight();
        double d_renamed = this.f5361b / this.f5362c;
        if (width > d_renamed) {
            iArr[0] = this.f5361b;
            iArr[1] = (int) (this.f5361b / width);
        } else {
            iArr[0] = (int) (this.f5362c * width);
            iArr[1] = this.f5362c;
        }
        double width2 = size2.getWidth() / size2.getHeight();
        if (width2 > d_renamed) {
            iArr[2] = this.f5361b;
            iArr[3] = (int) (this.f5361b / width2);
        } else {
            iArr[2] = (int) (this.f5362c * width2);
            iArr[3] = this.f5362c;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.view.View view, com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList, android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_height);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_first_level_bar_margin_top);
        if (view != null) {
            this.e_renamed = (android.view.ViewGroup) view.getRootView().findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
        basicOptionItemList.setScreenLayoutMode(j_renamed());
        if (view != null && this.e_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.leftMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_tool_second_level_margin_left);
            layoutParams.topMargin = dimensionPixelSize3;
            this.e_renamed.addView(basicOptionItemList, layoutParams);
        }
        a_renamed(basicOptionItemList);
    }

    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_blur_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_bottom);
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset3});
        com.oplus.camera.screen.c_renamed cVar6 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 11, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_button_rack_margin_right), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_button_rack_margin_bottom)});
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        cVar4.f5365c = new int[]{dimensionPixelOffset4, dimensionPixelOffset4};
        cVar5.f5365c = new int[]{dimensionPixelOffset4, dimensionPixelOffset4};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button), cVar4);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button), cVar5);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_guide_button), cVar6);
    }

    protected void e_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        int[] iArr = {12, 0};
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_rack_margin_bottom);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout), new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, 0, dimensionPixelOffset}));
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout), new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, 0, dimensionPixelOffset}));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void c_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void d_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2) {
        return new int[]{i2, com.oplus.camera.screen.f_renamed.f5371a - i_renamed};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2, int i3, int i4) {
        return new int[]{(com.oplus.camera.screen.f_renamed.f5371a - i2) - i3, i_renamed};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, int i_renamed, int i2) {
        android.graphics.Rect rect = this.f_renamed;
        if (rect != null) {
            return rect.contains(i_renamed, i2);
        }
        return false;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = super.c_renamed();
        arrayListC.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
        arrayListC.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA);
        arrayListC.add("superText");
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public com.oplus.camera.ui.preview.w_renamed a_renamed(android.content.Context context) {
        com.oplus.camera.ui.preview.w_renamed wVar = new com.oplus.camera.ui.preview.w_renamed(com.oplus.camera.util.Util.getScreenHeight(), com.oplus.camera.util.Util.getScreenWidth() / 2);
        wVar.b_renamed(90);
        return wVar;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        android.content.res.Resources resources = activity.getResources();
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_head_line_recycle_width), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_head_line_recycle_height));
        aVar.s_renamed = 0;
        aVar.q_renamed = 0;
        aVar.k_renamed = 0;
        aVar.bottomMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_head_line_recycle_margin_bottom);
        aVar.rightMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_head_line_recycle_margin_right);
        viewGroup.setLayoutParams(aVar);
        viewGroup.setVerticalFadingEdgeEnabled(false);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean b_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return rect.centerX() <= activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_confirm_root_layout_height);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return rect.left > activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_confirm_root_layout_height);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        boolean z_renamed = (this.d_renamed && i_renamed == 1) ? false : true;
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, z_renamed);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button, z_renamed);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, z_renamed);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button, z_renamed);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button, z_renamed);
        android.view.View viewFindViewById = activity.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (2 == i_renamed || 6 == i_renamed || i_renamed == 0 || 7 == i_renamed) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, true);
        } else {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, false);
        }
        int i2 = z_renamed ? com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg : com.oplus.camera.R_renamed.drawable.switch_camera_button_bg;
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, i2);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, i2);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, i2);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, i2);
    }

    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button), cVar);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(android.app.Activity activity, com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        com.oplus.camera.screen.f_renamed.f5371a = com.oplus.camera.util.Util.getScreenWidth();
        com.oplus.camera.screen.f_renamed.f5372b = com.oplus.camera.util.Util.getScreenHeight();
        com.oplus.camera.screen.d_renamed.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(0.0f);
        a_renamed(screenRelativeLayout);
        screenRelativeLayout.getLayoutParams().width = com.oplus.camera.screen.f_renamed.f5372b;
        screenRelativeLayout.getLayoutParams().height = com.oplus.camera.screen.f_renamed.f5371a;
        screenRelativeLayout.requestLayout();
        a_renamed(activity);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.setRotation(0.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(int i_renamed) {
        return !this.d_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.f5362c);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_params_bar_container_margin_bottom);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int c_renamed(android.app.Activity activity) {
        return activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top_rack_screen);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams f_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_params_bar_width), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_params_slide_bar_margin_bottom);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_params_slide_bar_width), i_renamed);
        layoutParams.setMargins(0, 0, 0, i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        android.graphics.Rect rectB = b_renamed(sizeI.getHeight(), sizeI.getWidth());
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_histogram_margin_left);
        aVar.f4923b = com.oplus.camera.util.Util.i_renamed(this.d_renamed ? com.oplus.camera.R_renamed.dimen.fold_rack_low_professional_histogram_margin_top : com.oplus.camera.R_renamed.dimen.fold_rack_professional_histogram_margin_top);
        aVar.e_renamed = 0;
        if (rectB.top > i4) {
            aVar.d_renamed = rectB.top + i3;
        } else {
            aVar.d_renamed = i4;
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar) {
        aVar.f4922a = 12;
        aVar.e_renamed = 0;
        aVar.d_renamed = com.oplus.camera.util.Util.i_renamed(this.d_renamed ? com.oplus.camera.R_renamed.dimen.fold_rack_low_movie_histogram_margin_left : com.oplus.camera.R_renamed.dimen.fold_rack_movie_histogram_margin_left) - com.oplus.camera.util.Util.Z_renamed();
        aVar.f4924c = com.oplus.camera.util.Util.i_renamed(this.d_renamed ? com.oplus.camera.R_renamed.dimen.fold_rack_low_movie_histogram_margin_bottom : com.oplus.camera.R_renamed.dimen.fold_rack_movie_histogram_margin_bottom);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a__renamed(android.app.Activity activity) {
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        d_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        c_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        b_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button));
        android.view.View[] viewArr = new android.view.View[arrayList.size()];
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            viewArr[i_renamed] = activity.findViewById(((java.lang.Integer) arrayList.get(i_renamed)).intValue());
        }
        a_renamed(viewArr);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public com.oplus.camera.ui.RotableTextView a_renamed(android.app.Activity activity, android.widget.RelativeLayout relativeLayout, int i_renamed) {
        activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.burst_fold, relativeLayout);
        com.oplus.camera.ui.RotableTextView rotableTextView = (com.oplus.camera.ui.RotableTextView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.burst_num_view_fold);
        rotableTextView.setBackground(activity.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_black, null));
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(this.d_renamed ? com.oplus.camera.R_renamed.dimen.fold_rack_low_first_level_burst_num_view_margin_bottom : com.oplus.camera.R_renamed.dimen.fold_rack_first_level_burst_num_view_margin_bottom);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(boolean z_renamed) {
        return this.d_renamed ? 5 : 4;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar3) {
        aVar.call(1);
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        aVar2.call(fValueOf, fValueOf);
        aVar3.call(new java.lang.Object[0]);
    }
}
