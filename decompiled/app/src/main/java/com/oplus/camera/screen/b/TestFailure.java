package com.oplus.camera.screen.b_renamed;

/* compiled from: FullScreenMode90.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.screen.b_renamed.g_renamed {
    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int b_renamed(int i_renamed) {
        return 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return "full90";
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int k_renamed() {
        return 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int m_renamed() {
        return 6;
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        super.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(90.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(final android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3, com.oplus.camera.screen.c_renamed cVar4) {
        com.oplus.camera.screen.c_renamed cVar5 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, new int[]{0, 0, 0, 0});
        com.oplus.camera.screen.c_renamed cVar6 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 15, 0}, new int[]{0, 0, (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_bar_margin_right), 0});
        com.oplus.camera.screen.c_renamed cVar7 = new com.oplus.camera.screen.c_renamed(new int[]{10, 0, 11, 0}, new int[]{0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_top), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_panel_margin_right), 0});
        com.oplus.camera.screen.c_renamed cVar8 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), 0});
        cVar8.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$f_renamed$a0kXrENQNrWRrcC2PwWBF_Mqk88
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.f_renamed.a_renamed(activity, view);
            }
        };
        super.a_renamed(activity, cVar5, cVar6, cVar7, cVar8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        android.view.View viewFindViewById = activity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
        if (viewFindViewById != null) {
            viewFindViewById.setRotation(270.0f);
        }
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{(-dimensionPixelSize) / 2, 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90) + (dimensionPixelSize / 2)});
        cVar2.d_renamed = 90;
        super.c_renamed(activity, cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right);
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, null), new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, null));
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.review_control_layout), new com.oplus.camera.screen.c_renamed(new int[]{11, 0}, new int[]{0, 0, dimensionPixelSize, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.g_renamed, com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_margin_right), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_rotate_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {11, 0, 10, 0};
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_screen_mode_switch_button_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_left);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_out_screen_preview_switch_button_margin_top);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, dimensionPixelSize, dimensionPixelSize2, 0});
        cVar3.d_renamed = 90;
        com.oplus.camera.screen.c_renamed cVar4 = new com.oplus.camera.screen.c_renamed(iArr, new int[]{0, dimensionPixelSize3, dimensionPixelSize4, 0});
        cVar4.d_renamed = 90;
        super.c_renamed(activity, cVar3, cVar4);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.d_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void e_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.e_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom_rotate_90)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_start);
        int[] iArr = {9, 0, 12, 0};
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_button_margin_bottom_rotate_90)}), new com.oplus.camera.screen.c_renamed(iArr, new int[]{dimensionPixelOffset, 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_button_margin_bottom_rotate_90)}), new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_top);
        resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_bottom);
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{20, 0}, new int[]{0, 0, 0, 0}), cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.f_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{20, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_left), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_effect_menu_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 10, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_left), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_multi_video_select_view_margin_top), 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar3) {
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        aVar2.call(fValueOf, java.lang.Float.valueOf(this.e_renamed));
        aVar3.call(fValueOf, java.lang.Float.valueOf(this.e_renamed));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void e_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
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

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {f2 - r3[1], r3[0] - f_renamed};
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
        return new android.graphics.Rect(rect.left - rect.height(), rect.top, rect.left, rect.top + rect.width());
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2) {
        return new int[]{i2, com.oplus.camera.screen.f_renamed.f5371a - i_renamed};
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(int i_renamed, int i2, int i3, int i4) {
        return new int[]{(com.oplus.camera.screen.f_renamed.f5371a - i2) - i3, i_renamed};
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

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        android.graphics.Rect rectB = b_renamed(sizeI.getHeight(), sizeI.getWidth());
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_top);
        aVar.d_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_histogram_margin_left);
        aVar.e_renamed = 0;
        if (this.f5362c - rectB.right > i4) {
            aVar.f4923b = (this.f5362c - rectB.right) + i3;
        } else {
            aVar.f4923b = i4;
        }
    }
}
