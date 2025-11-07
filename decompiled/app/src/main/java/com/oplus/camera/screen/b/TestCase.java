package com.oplus.camera.screen.b_renamed;

/* compiled from: FullScreenMode270.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.screen.b_renamed.g_renamed {
    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int b_renamed(int i_renamed) {
        return 270;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return "full270";
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int k_renamed() {
        return 270;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int m_renamed() {
        return 5;
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        super.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(final android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3, com.oplus.camera.screen.c_renamed cVar4) {
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0}, new int[]{0, 0, 0, 0});
        com.oplus.camera.screen.c_renamed cVar6 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 15, 0}, new int[]{(int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_bar_margin_right), 0, 0, 0});
        com.oplus.camera.screen.c_renamed cVar7 = new com.oplus.camera.screen.c_renamed(new int[]{10, 0, 9, 0}, new int[]{com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_right), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_top), 0, 0});
        com.oplus.camera.screen.c_renamed cVar8 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), 0, 0});
        cVar8.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$e_renamed$zmi065lb-FTXdxWAq552Wn8-gug
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.e_renamed.a_renamed(activity, view);
            }
        };
        super.a_renamed(activity, cVar5, cVar6, cVar7, cVar8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        android.view.View viewFindViewById = activity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
        if (viewFindViewById != null) {
            viewFindViewById.setRotation(90.0f);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, (-dimensionPixelSize) / 2, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90) + (dimensionPixelSize / 2)});
        cVar2.d_renamed = 270;
        super.c_renamed(activity, cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right);
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0}, null), new com.oplus.camera.screen.c_renamed(new int[]{9, 0}, null));
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.review_control_layout), new com.oplus.camera.screen.c_renamed(new int[]{9, 0}, new int[]{dimensionPixelSize, 0, 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_margin_right), 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_rotate_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {20, 0, 12, 0};
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_left);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_top);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelSize2, 0, 0, dimensionPixelSize});
        cVar3.d_renamed = 270;
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelSize4, 0, 0, dimensionPixelSize3});
        cVar4.d_renamed = 270;
        super.c_renamed(activity, cVar3, cVar4);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.d_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_start), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void e_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.e_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start);
        int[] iArr = {11, 0, 12, 0};
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, dimensionPixelOffset, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom_rotate_90)}), new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, 0, dimensionPixelOffset, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom_rotate_90)}), new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_top);
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_bottom);
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{21, 0}, new int[]{0, 0, 0, 0}), cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        super.f_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_top), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_left), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar3) {
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        aVar2.call(fValueOf, java.lang.Float.valueOf(this.e_renamed));
        aVar3.call(fValueOf, java.lang.Float.valueOf(-this.e_renamed));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void e_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void f_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        final android.content.res.Resources resources = com.oplus.camera.util.Util.l_renamed().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_first_level_bar_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_width_270);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_first_level_bar_left_margin_270);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_mode_menu_panel_padding_left_right);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_top_margin_270);
        int dimensionPixelSize7 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_setting_layout_right_margin);
        final int dimensionPixelSize8 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_translation_x_270);
        final int dimensionPixelSize9 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_translation_y_270);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, dimensionPixelSize6, dimensionPixelSize7, 0});
        cVar.d_renamed = 90;
        cVar.e_renamed = new int[]{dimensionPixelSize3, dimensionPixelSize3};
        cVar.f5365c = new int[]{dimensionPixelSize, dimensionPixelSize2};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$e_renamed$sfXUhs7JEwsOecDtR1xJfPaCseg
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.e_renamed.a_renamed(activity, dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize9, dimensionPixelSize8, resources, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, int i4, android.content.res.Resources resources, android.view.View view) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = i_renamed;
        cameraSettingMenuPanel.setRotation(0.0f);
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        float f_renamed = i3;
        cameraSettingMenuPanel.setTranslationY(f_renamed);
        float f2 = i4;
        cameraSettingMenuPanel.setTranslationX(f2);
        cameraSettingMenuPanel.setTag(com.oplus.camera.R_renamed.id_renamed.animating_view_translation, new android.graphics.PointF(f2, f_renamed));
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel2 = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_draw_panel_width);
            cameraSettingMenuPanel2.setPivotX(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_x_270));
            cameraSettingMenuPanel2.setPivotY(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_y_270));
            cameraSettingMenuPanel2.setRotation(270.0f);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_top), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_left), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel) {
        cameraSettingMenuPanel.getLayoutParams().width = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_draw_panel_width);
        cameraSettingMenuPanel.setPivotX(r1.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_x_270));
        cameraSettingMenuPanel.setPivotY(r1.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_sub_pivot_y_270));
        cameraSettingMenuPanel.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.view.View view, com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList, android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.a_renamed(view, basicOptionItemList, context, i_renamed);
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_width_full);
        int dimensionPixelSize2 = (dimensionPixelSize * i_renamed) + (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_space_full) * (i_renamed - 1)) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_item_layout_bottom_offset);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_top_margin) - dimensionPixelSize2;
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_second_level_left_margin_270);
        if (view != null && this.h_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(9);
            layoutParams.topMargin = dimensionPixelSize3;
            layoutParams.leftMargin = dimensionPixelSize4;
            this.h_renamed.addView(basicOptionItemList, layoutParams);
        }
        a_renamed(basicOptionItemList);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        android.content.res.Resources resources = activity.getResources();
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_width), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_height));
        aVar.q_renamed = 0;
        aVar.k_renamed = 0;
        aVar.bottomMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_bottom_margin);
        aVar.leftMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_right_margin);
        viewGroup.setLayoutParams(aVar);
        viewGroup.setVerticalFadingEdgeEnabled(true);
        viewGroup.setFadingEdgeLength(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_fading_edge));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {r3[1] - f2, f_renamed - r3[0]};
        fArr[0] = java.lang.Math.min(java.lang.Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = java.lang.Math.min(java.lang.Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return super.a_renamed(activity, a_renamed(rect));
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean b_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return super.b_renamed(activity, a_renamed(rect));
    }

    private android.graphics.Rect a_renamed(android.graphics.Rect rect) {
        return new android.graphics.Rect(rect.left, rect.top - rect.width(), rect.left + rect.height(), rect.top);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2) {
        return new int[]{com.oplus.camera.screen.f_renamed.f5372b - i2, i_renamed};
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2, int i3, int i4) {
        return new int[]{i2, (com.oplus.camera.screen.f_renamed.f5372b - i_renamed) - i3};
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public com.oplus.camera.ui.preview.w_renamed a_renamed(android.content.Context context) {
        com.oplus.camera.ui.preview.w_renamed wVarA = super.a_renamed(context);
        wVarA.b_renamed(k_renamed());
        return wVarA;
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        return new int[]{this.f5361b, (int) (this.f5361b / (size.getWidth() / size.getHeight())), this.f5361b, (int) (this.f5361b / (size2.getWidth() / size2.getHeight()))};
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect b_renamed(int i_renamed, int i2) {
        this.f5361b = com.oplus.camera.util.Util.getScreenHeight();
        this.f5362c = com.oplus.camera.util.Util.getScreenWidth();
        int screenHeight = com.oplus.camera.util.Util.getScreenHeight();
        int iRound = java.lang.Math.round(screenHeight / (i2 / i_renamed));
        int i3 = (this.f5362c - iRound) / 2;
        return new android.graphics.Rect(i3, 0, iRound + i3, screenHeight);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = super.c_renamed();
        arrayListC.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA);
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams d_renamed() {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_multicamera_type_layout_width), -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_top);
        layoutParams.rightMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_left);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams f_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_width), -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_bar_margin_right);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_width);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_height);
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_top);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_right);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(i_renamed, i2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i4;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        android.graphics.Rect rectB = b_renamed(sizeI.getHeight(), sizeI.getWidth());
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int i5 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_top);
        aVar.d_renamed = (this.f5361b - i3) - com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_left);
        aVar.e_renamed = 0;
        if (rectB.left > i5) {
            aVar.f4923b = rectB.left + i4;
        } else {
            aVar.f4923b = i5;
        }
    }
}
