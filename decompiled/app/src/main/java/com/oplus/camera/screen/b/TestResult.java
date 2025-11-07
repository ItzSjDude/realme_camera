package com.oplus.camera.screen.b_renamed;

/* compiled from: LeftRightScreenMode.java */
/* loaded from: classes2.dex */
public abstract class h_renamed extends com.oplus.camera.screen.b_renamed.a_renamed {
    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(boolean z_renamed) {
        return z_renamed ? 21 : 2;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public boolean a_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(int i_renamed) {
        return 6 == i_renamed || 2 == i_renamed;
    }

    protected abstract void i_renamed(android.app.Activity activity);

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int j_renamed() {
        return 3;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean o_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        this.f5361b = com.oplus.camera.screen.f_renamed.f5371a / 2;
        this.f5362c = com.oplus.camera.screen.f_renamed.f5372b;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void b_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        super.b_renamed(activity);
        o_renamed(activity);
        h_renamed(activity);
        m_renamed(activity);
        n_renamed(activity);
        f_renamed(activity);
        i_renamed(activity);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        p_renamed(activity);
        l_renamed(activity);
        j_renamed(activity);
        k_renamed(activity);
    }

    private void l_renamed(final android.app.Activity activity) {
        android.widget.RelativeLayout.LayoutParams layoutParamsE = e_renamed();
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsE.bottomMargin});
        cVar.f5365c = new int[]{layoutParamsE.width, layoutParamsE.height};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, 0});
        cVar2.f5365c = new int[]{-1, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height)};
        cVar2.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$h_renamed$3bjrjhuMhcCf96jYvgIYYqKxHKE
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.a_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.main_bar_id), cVar2);
        android.widget.RelativeLayout.LayoutParams layoutParamsG = g_renamed();
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 12, 0}, new int[]{0, 0, 0, layoutParamsG.bottomMargin});
        cVar3.f5365c = new int[]{layoutParamsG.width, layoutParamsG.height};
        final int iK = k_renamed();
        cVar3.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$h_renamed$pAjpg81eNS7jrgoNC1s_SQDrk58
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.screen.b_renamed.h_renamed.a_renamed(activity, iK, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container), cVar3);
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_top), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_right), 0});
        cVar4.f5365c = new int[]{-2, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry), cVar4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) throws android.content.res.Resources.NotFoundException {
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
        pVar.d_renamed(3, i_renamed);
        int childCount = pVar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = pVar.getChildAt(i2);
            if (childAt instanceof com.oplus.camera.professional.LevelPanel) {
                com.oplus.camera.professional.LevelPanel levelPanel = (com.oplus.camera.professional.LevelPanel) childAt;
                levelPanel.a_renamed(3, i_renamed);
                levelPanel.e_renamed();
            }
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 10, 0}, new int[]{0, 0, 0, 0}));
    }

    protected void f_renamed(android.app.Activity activity) {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_left_right_preview_shutter_button_margin_top);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_switch_camera_button_margin_top);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_thumbnail_margin_top);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_button_margin_edge);
        int dimensionPixelOffset7 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.thumbnail_view_padding);
        int dimensionPixelOffset8 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.thumbnail_margin_start);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.switch_camera_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{10, 0}, new int[]{0, dimensionPixelOffset2, 0, 0});
        cVar.f5365c = new int[]{-1, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.shutter_button), new com.oplus.camera.screen.c_renamed(new int[]{14, 0}, new int[]{0, dimensionPixelOffset3, 0, 0}));
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{21, 0}, new int[]{0, dimensionPixelOffset4, dimensionPixelOffset6, 0});
        cVar2.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.switch_camera_button), cVar2);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{21, 0}, new int[]{0, dimensionPixelOffset4, dimensionPixelOffset6, 0});
        cVar3.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.video_pause_resume), cVar3);
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(new int[]{20, 0}, new int[]{dimensionPixelOffset8, dimensionPixelOffset5, 0, 0});
        cVar4.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$h_renamed$tH4ChxzoJva0B9-qZfmLmMgUa5U
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.h_renamed.a_renamed(view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.thumbnail), cVar4);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn), cVar4);
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(new int[]{20, 0}, new int[]{dimensionPixelOffset8 + dimensionPixelOffset7, dimensionPixelOffset4, 0, 0});
        cVar5.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.recording_cap_button), cVar5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view) {
        if (view instanceof com.oplus.camera.ui.control.ThumbImageView) {
            ((com.oplus.camera.ui.control.ThumbImageView) view).setPaddingPlus(0);
        }
    }

    private void m_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_effect_button_margin_bottom);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_effect_button_margin_end);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout, 21, 0}, new int[]{0, 0, dimensionPixelOffset2, dimensionPixelOffset});
        cVar.f5365c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button), cVar);
        activity.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    protected void h_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {20, 0, 10, 0};
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_left);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_top);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelSize, dimensionPixelSize2, 0, 0});
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelSize3, dimensionPixelSize4, 0, 0});
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button), cVar2);
    }

    private void n_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_blur_button_margin_start);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_effect_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout, 20, 0}, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        cVar.f5365c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button), cVar);
    }

    private void o_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = (-resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_circle_center_y);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
        final int dimensionPixelSize7 = dimensionPixelSize4 != 0 ? resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius) : 0;
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout}, new int[]{0, 0, 0, dimensionPixelSize});
        cVar.f5365c = new int[]{-1, -2};
        cVar.d_renamed = 0;
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$h_renamed$LxtM6OUd9RX9OMS2YZG9XP9J_B4
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                this.f_renamed$0.a_renamed(activity, dimensionPixelSize4, dimensionPixelSize7, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize2, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{3, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar}, new int[]{0, dimensionPixelSize3, 0, 0});
        cVar2.f5365c = new int[]{-1, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click), cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, int i4, int i5, android.view.View view) {
        com.oplus.camera.ui.preview.af_renamed afVar = (com.oplus.camera.ui.preview.af_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
        afVar.getLayoutParams().width = -1;
        afVar.getLayoutParams().height = i_renamed;
        afVar.a_renamed(this.f5361b, i2, i3, i4, (com.oplus.camera.util.Util.P_renamed() + i5) / 2.0f, 1.0f, 0.0f);
    }

    private void p_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = com.oplus.camera.util.Util.l_renamed().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_padding_left_right);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{10, 0}, new int[]{0, 0, 0, 0});
        cVar.f5365c = new int[]{-1, -2};
        cVar.d_renamed = 0;
        final com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = dimensionPixelSize;
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$h_renamed$5ZXwuuFfvx8V3j5t_DTfLx6OGqg
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.h_renamed.a_renamed(cameraSettingMenuPanel, dimensionPixelSize2, activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel, int i_renamed, android.app.Activity activity, android.view.View view) {
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setTranslationY(0.0f);
        cameraSettingMenuPanel.setTranslationX(0.0f);
        cameraSettingMenuPanel.setTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation, new android.graphics.PointF(0.0f, 0.0f));
        cameraSettingMenuPanel.setPaddingLeftRight(i_renamed);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel2 = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.setRotation(0.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar3) {
        aVar.call(2);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void c_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
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
    public void d_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2) {
        return new int[]{i_renamed, i2};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2, int i3, int i4) {
        return new int[]{i_renamed, i2};
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        return new int[]{(int) (this.f5361b * (size.getWidth() / size.getHeight())), this.f5361b, (int) (this.f5361b * (size2.getWidth() / size2.getHeight())), this.f5361b};
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(android.app.Activity activity, int i_renamed) {
        return activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_split_screen_record_time_margin_top);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int c_renamed(android.app.Activity activity) {
        return activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top_split_screen);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        android.content.res.Resources resources = activity.getResources();
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(-1, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_height));
        aVar.s_renamed = 0;
        aVar.q_renamed = 0;
        aVar.h_renamed = 0;
        aVar.topMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_view_margin_top);
        viewGroup.setLayoutParams(aVar);
        viewGroup.setVerticalFadingEdgeEnabled(false);
    }

    public static int a_renamed(float f_renamed) {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        double d_renamed = f_renamed;
        if (java.lang.Math.abs(d_renamed - 1.0d) < 0.01d) {
            return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_center_offset_y_1_1);
        }
        if (java.lang.Math.abs(d_renamed - 1.3333333333333333d) < 0.01d) {
            return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_center_offset_y_4_3);
        }
        if (java.lang.Math.abs(d_renamed - 0.9333333333333333d) < 0.01d) {
            return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_center_offset_y_14_15);
        }
        return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_center_offset_y_16_9);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = super.c_renamed();
        arrayListC.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
        arrayListC.add("movie");
        arrayListC.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA);
        arrayListC.add("superText");
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button, true);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, true);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button, false);
        if (i_renamed == 1) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            return;
        }
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
    }

    protected void j_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {9, 0, 2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout};
        int[] iArr2 = {11, 0, 2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout};
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(iArr, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom)});
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(iArr2, new int[]{0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom)});
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{10, 0, 11, 0}, new int[]{0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_top), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_right), 0});
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        cVar2.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button), cVar2);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_guide_button), cVar3);
    }

    protected void k_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        int[] iArr = {12, 0};
        int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, 0, dimensionPixelOffset});
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, 0, dimensionPixelOffset});
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout), cVar);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout), cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.f5361b);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_split_professional_params_bar_container_margin_bottom);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams f_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.f5361b, i_renamed);
        layoutParams.setMargins(0, 0, 0, i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        android.graphics.Rect rectB = b_renamed(sizeI.getHeight(), sizeI.getWidth());
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int i5 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_split_professional_histogram_margin_top);
        aVar.d_renamed = i4;
        aVar.e_renamed = 0;
        if (rectB.top + i3 > i5) {
            aVar.f4923b = rectB.top + i3;
        } else {
            aVar.f4923b = i5;
        }
    }
}
