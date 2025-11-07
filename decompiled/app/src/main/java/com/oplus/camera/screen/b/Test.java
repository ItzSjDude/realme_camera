package com.oplus.camera.screen.b_renamed;

/* compiled from: FullScreenMode0.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.screen.b_renamed.c_renamed {
    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(int i_renamed) {
        return i_renamed == 0 || 1 == i_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int b_renamed(int i_renamed) {
        return i_renamed + 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void d_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return com.oplus.camera.statistics.model.DcsMsgData.FULL;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean n_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        this.f5361b = com.oplus.camera.screen.f_renamed.f5371a;
        this.f5362c = com.oplus.camera.screen.f_renamed.f5372b;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3, com.oplus.camera.screen.c_renamed cVar4) {
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, new int[]{0, 0, 0, 0}), new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 15, 0}, new int[]{0, 0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_bar_margin_right), 0}), new com.oplus.camera.screen.c_renamed(new int[]{10, 0, 11, 0}, new int[]{0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_top), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_right), 0}), new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{(-dimensionPixelSize) / 2, 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom) + (dimensionPixelSize / 2)});
        cVar2.d_renamed = 90;
        super.c_renamed(activity, cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right);
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, null), new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, null));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar3) {
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        aVar2.call(fValueOf, java.lang.Float.valueOf(this.e_renamed));
        aVar3.call(fValueOf, java.lang.Float.valueOf(this.e_renamed));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void e_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.view.View view, com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList, android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.a_renamed(view, basicOptionItemList, context, i_renamed);
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_width_full);
        int dimensionPixelSize2 = (dimensionPixelSize * i_renamed) + (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_space_full) * (i_renamed - 1)) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_layout_bottom_offset);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_top_margin) - dimensionPixelSize2;
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_left_margin);
        if (view != null && this.h_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.topMargin = dimensionPixelSize3;
            layoutParams.leftMargin = dimensionPixelSize4;
            this.h_renamed.addView(basicOptionItemList, layoutParams);
        }
        a_renamed(basicOptionItemList);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_margin_right), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {20, 0, 10, 0};
        super.c_renamed(activity, new com.oplus.camera.screen.c_renamed(iArr, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_left), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_top), 0, 0}), new com.oplus.camera.screen.c_renamed(iArr, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_left), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.d_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void e_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.e_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start);
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom)}), new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom)}), new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {20, 0};
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_margin_top);
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_margin_bottom);
        com.oplus.camera.util.Util.Z_renamed();
        if (com.oplus.camera.util.Util.Z_renamed() > 0) {
            resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_top);
        }
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, 0, 0}), cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.f_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_left), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_left), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public com.oplus.camera.ui.RotableTextView a_renamed(android.app.Activity activity, android.widget.RelativeLayout relativeLayout, int i_renamed) {
        activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.burst_fold, relativeLayout);
        com.oplus.camera.ui.RotableTextView rotableTextView = (com.oplus.camera.ui.RotableTextView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.burst_num_view_fold);
        rotableTextView.setBackground(activity.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_black, null));
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_burst_num_view_margin_bottom);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a__renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        d_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        e_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        c_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null, (com.oplus.camera.screen.c_renamed) null);
        b_renamed(activity, null, null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout));
        android.view.View[] viewArr = new android.view.View[arrayList.size()];
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            viewArr[i_renamed] = activity.findViewById(((java.lang.Integer) arrayList.get(i_renamed)).intValue());
        }
        a_renamed(viewArr);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, int i_renamed, int i2) {
        return i_renamed > this.d_renamed && i_renamed < this.f5361b - this.d_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        if (i_renamed == 0) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            return;
        }
        if (i_renamed == 1) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            return;
        }
        if (i_renamed == 2 || i_renamed == 6) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button, false);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.recording_cap_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        android.graphics.Rect rectB = b_renamed(sizeI.getHeight(), sizeI.getWidth());
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_left);
        aVar.f4923b = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_top);
        aVar.e_renamed = 0;
        if (rectB.left > i4) {
            aVar.d_renamed = rectB.left + i3;
        } else {
            aVar.d_renamed = i4;
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        if (1 == com.oplus.camera.util.Util.H_renamed()) {
            layoutParams.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_16_9_professional_params_container_margin_right);
        }
        return layoutParams;
    }
}
