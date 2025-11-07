package com.oplus.camera.screen.b_renamed;

/* compiled from: FullScreenMode.java */
/* loaded from: classes2.dex */
public abstract class c_renamed extends com.oplus.camera.screen.b_renamed.a_renamed {
    protected int d_renamed = 0;
    protected float e_renamed = 0.0f;
    protected int f_renamed = 0;
    protected float g_renamed = 20.0f;
    protected android.view.ViewGroup h_renamed;

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(boolean z_renamed) {
        return z_renamed ? 31 : 3;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public com.oplus.camera.ui.RotableTextView a_renamed(android.app.Activity activity, android.widget.RelativeLayout relativeLayout, int i_renamed) {
        return null;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public boolean a_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int j_renamed() {
        return 1;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int k_renamed() {
        return 0;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean l_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int m_renamed() {
        return 7;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void b_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        super.b_renamed(activity);
        android.content.res.Resources resources = activity.getResources();
        this.e_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_linkage_translate);
        this.f_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.full_camera_up_hint_margin_top);
        c_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        f_renamed(activity);
        h_renamed(activity);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        c_renamed(activity, null, null);
        d_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        f_renamed(activity, null);
        e_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        b_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        a_renamed(activity, null, null, null, null);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        b_renamed(activity, null, null);
    }

    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        cVar.f5365c = new int[]{activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_multicamera_type_layout_width), -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.multivideo_type_select_view), cVar);
    }

    protected void a_renamed(final android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3, com.oplus.camera.screen.c_renamed cVar4) {
        cVar.f5365c = new int[]{-2, -1};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$IGePNhGjYtSyAd-1wlDoXGiQf6Y
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                this.f_renamed$0.c_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container), cVar);
        cVar2.f5365c = new int[]{com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_width), -1};
        cVar2.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$VYvn82MIvFRTUFSh36CSed-2Bnw
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.b_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.main_bar_id), cVar2);
        cVar3.f5365c = new int[]{com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_width), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_height)};
        final int iK = k_renamed();
        cVar3.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$zSuyYc5N9XJ28OjDxHWUvPMbD3g
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.screen.b_renamed.c_renamed.a_renamed(activity, iK, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container), cVar3);
        cVar4.f5365c = new int[]{-2, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry), cVar4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.app.Activity activity, android.view.View view) {
        com.oplus.camera.professional.v_renamed.a_renamed aVar = (com.oplus.camera.professional.v_renamed.a_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container);
        if (aVar != null) {
            aVar.setLayoutParams(e_renamed());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.app.Activity activity, android.view.View view) throws android.content.res.Resources.NotFoundException {
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
        pVar.d_renamed(1, i_renamed);
        int childCount = pVar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = pVar.getChildAt(i2);
            if (childAt instanceof com.oplus.camera.professional.LevelPanel) {
                com.oplus.camera.professional.LevelPanel levelPanel = (com.oplus.camera.professional.LevelPanel) childAt;
                levelPanel.a_renamed(1, i_renamed);
                levelPanel.e_renamed();
            }
        }
    }

    protected void c_renamed(final android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius_full);
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_margin_bottom);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_width);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size);
        cVar.f5365c = new int[]{dimensionPixelSize * 2, dimensionPixelSize};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$fs8ZxGTk7h1dR34uAq_8woW7eXo
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                this.f_renamed$0.a_renamed(activity, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize4, dimensionPixelSize3, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{3, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, (-dimensionPixelSize5) - dimensionPixelSize3, 0, 0});
        cVar2.f5365c = new int[]{-2, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click), cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, int i4, android.view.View view) {
        com.oplus.camera.ui.preview.af_renamed afVar = (com.oplus.camera.ui.preview.af_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
        afVar.getLayoutParams().width = -1;
        afVar.getLayoutParams().height = i_renamed;
        afVar.a_renamed(i_renamed * 2, i_renamed, i2, (i_renamed - (i3 / 2)) - i4, 0.0f, 2.0f, this.g_renamed);
    }

    private void h_renamed(final android.app.Activity activity) {
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(null, null);
        cVar.f5365c = new int[]{0, 0};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$AdZtnvmVnJu8jLKSCpuYaaOp92g
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.c_renamed.a_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.gallery_container), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        ((android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container)).setVisibility(8);
    }

    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        android.content.res.Resources resources = activity.getResources();
        resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_width_full);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_width_full);
        resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.switch_camera_margin_bottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_vertical_margin_top);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_cap_margin_top);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_view_padding_plus);
        int dimensionPixelSize7 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.switch_camera_button_width_full);
        cVar.f5365c = new int[]{dimensionPixelSize, -1};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$GHRKJPYD08BlDp1Z0enwXPrbbIU
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.c_renamed.a_renamed(view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_layout), cVar);
        cVar2.f5365c = new int[]{dimensionPixelSize2, -1};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout), cVar2);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.shutter_button), new com.oplus.camera.screen.c_renamed(new int[]{13, 0}, new int[]{0, 0, 0, 0}));
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 2, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        cVar3.f5365c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.switch_camera_button), cVar3);
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 2, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, 0, 0, dimensionPixelSize3});
        cVar4.f5365c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.video_pause_resume), cVar4);
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 3, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize4, 0, 0});
        cVar5.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$OOGEV7H5hZGH4UCl1-IGH_wEOoU
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.c_renamed.a_renamed(dimensionPixelSize6, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.thumbnail), cVar5);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn), cVar5);
        com.oplus.camera.screen.c_renamed cVar6 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 3, com.oplus.camera.R_renamed.id_renamed.shutter_button}, new int[]{0, dimensionPixelSize5, 0, 0});
        cVar6.f5365c = new int[]{dimensionPixelSize7, dimensionPixelSize7};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.recording_cap_button), cVar6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view) {
        if (view instanceof com.oplus.camera.ui.inverse.InverseColorRelativeLayout) {
            ((com.oplus.camera.ui.inverse.InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(int i_renamed, android.view.View view) {
        if (view instanceof com.oplus.camera.ui.control.ThumbImageView) {
            ((com.oplus.camera.ui.control.ThumbImageView) view).setPaddingPlus(i_renamed);
        }
    }

    protected void f_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        final android.content.res.Resources resources = com.oplus.camera.util.Util.l_renamed().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_width);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_top_margin);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_left_margin);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_pivot_y);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_pivot_x);
        final int dimensionPixelSize7 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height);
        final int dimensionPixelSize8 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_mode_menu_panel_padding_left_right);
        final int dimensionPixelSize9 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_translation_x);
        final int dimensionPixelSize10 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_translation_y);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{dimensionPixelSize4, dimensionPixelSize3, 0, 0});
        cVar.d_renamed = 270;
        cVar.e_renamed = new int[]{dimensionPixelSize6, dimensionPixelSize5};
        cVar.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$c_renamed$ZhjdO6cm4r2na2LW7eQl0DZFCwk
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.c_renamed.a_renamed(activity, dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize10, dimensionPixelSize9, resources, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, int i4, android.content.res.Resources resources, android.view.View view) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = i_renamed;
        cameraSettingMenuPanel.setRotation(180.0f);
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        float f_renamed = i3;
        cameraSettingMenuPanel.setTranslationY(f_renamed);
        float f2 = i4;
        cameraSettingMenuPanel.setTranslationX(f2);
        cameraSettingMenuPanel.setTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation, new android.graphics.PointF(f2, f_renamed));
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel2 = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_draw_panel_width);
            cameraSettingMenuPanel2.setPivotX(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_x));
            cameraSettingMenuPanel2.setPivotY(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_y));
            cameraSettingMenuPanel2.setRotation(90.0f);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        cVar.f5365c = new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_width), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_height)};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.headline_view), cVar);
    }

    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_size);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button), cVar);
        activity.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button).setVisibility(0);
    }

    protected void e_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_size);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button), cVar);
    }

    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) {
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_size);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        cVar2.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button), cVar2);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_guide_button), cVar3);
    }

    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0}, new int[]{0, 0, 0, activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_margin_bottom_full_screen)});
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout), cVar3);
    }

    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        cVar.f5365c = new int[]{activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_width), -1};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effects_menu_panel), cVar);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.view.View view, com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList, android.content.Context context, int i_renamed) {
        if (view != null) {
            this.h_renamed = (android.view.ViewGroup) view.getRootView().findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
        basicOptionItemList.setScreenLayoutMode(j_renamed());
    }

    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button), cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_draw_panel_width);
        cameraSettingMenuPanel.setPivotX(activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_x));
        cameraSettingMenuPanel.setPivotY(activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_y));
        cameraSettingMenuPanel.setRotation(90.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.widget.RelativeLayout.LayoutParams a_renamed(android.util.Size size) {
        if (size == null) {
            com.oplus.camera.e_renamed.f_renamed("FullScreenMode", "layoutPreviewFrame, previewSize is_renamed null.");
            return null;
        }
        android.graphics.Rect rectB = b_renamed(size.getHeight(), size.getWidth());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(rectB.width(), rectB.height());
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = rectB.left;
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.d_renamed = rectB.left;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect b_renamed(int i_renamed, int i2) {
        this.f5361b = com.oplus.camera.util.Util.getScreenWidth();
        this.f5362c = com.oplus.camera.util.Util.getScreenHeight();
        android.graphics.Rect rect = new android.graphics.Rect(0, 0, 0, this.f5362c);
        rect.left = (this.f5361b - java.lang.Math.round(this.f5362c / (i2 / i_renamed))) / 2;
        rect.right = this.f5361b - rect.left;
        return rect;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        return new int[]{this.f5362c, (int) (this.f5362c / (size.getWidth() / size.getHeight())), this.f5362c, (int) (this.f5362c / (size2.getWidth() / size2.getHeight()))};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        android.content.res.Resources resources = activity.getResources();
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_width), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_height));
        aVar.s_renamed = 0;
        aVar.k_renamed = 0;
        aVar.bottomMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_bottom_margin);
        aVar.rightMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_right_margin);
        viewGroup.setLayoutParams(aVar);
        viewGroup.setVerticalFadingEdgeEnabled(true);
        viewGroup.setFadingEdgeLength(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_fading_edge));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, boolean z_renamed, float f_renamed, float f2) {
        android.content.res.Resources resources = activity.getResources();
        return f_renamed <= ((float) ((com.oplus.camera.screen.f_renamed.f5371a - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length)));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, android.graphics.Rect rect) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        return ((float) rect.right) <= ((float) ((com.oplus.camera.screen.f_renamed.f5371a - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length)));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean b_renamed(android.app.Activity activity, android.graphics.Rect rect) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        return ((float) rect.centerX()) >= ((float) ((com.oplus.camera.screen.f_renamed.f5371a - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length)));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {f_renamed - r3[0], f2 - r3[1]};
        fArr[0] = java.lang.Math.min(java.lang.Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = java.lang.Math.min(java.lang.Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void c_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        aVar.call(new java.lang.Object[0]);
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
        return new int[]{i_renamed, i2};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2, int i3, int i4) {
        return new int[]{i_renamed, i2};
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = super.c_renamed();
        arrayListC.add("movie");
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] c_renamed(android.app.Activity activity, int i_renamed) {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = new int[3];
        if (i_renamed == 7) {
            iArr[0] = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_ai_enhancement_video_offsetX_full);
            iArr[1] = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_ai_enhancement_video_offsetY_full);
            iArr[2] = 8;
        } else if (i_renamed == 9) {
            iArr[0] = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_zoom_ultra_offsetX_full);
            iArr[1] = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_zoom_ultra_offsetY_full);
            iArr[2] = 8;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams d_renamed() throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_multicamera_type_layout_width), -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.setMargins(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_left), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_top), 0, 0);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(android.app.Activity activity, int i_renamed) {
        return activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_screen_record_time_margin_top);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        if (aVar != null) {
            aVar.call(new java.lang.Object[0]);
        } else {
            com.oplus.camera.e_renamed.f_renamed("FullScreenMode", "updateZoomMargin, callBack is_renamed null");
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams f_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_width), -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_bar_margin_right);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_width);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_height);
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_top);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_right);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(i_renamed, i2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = i3;
        layoutParams.rightMargin = i4;
        return layoutParams;
    }
}
