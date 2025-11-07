package com.oplus.camera.screen.b_renamed;

/* compiled from: OutScreenMode.java */
/* loaded from: classes2.dex */
public class j_renamed extends com.oplus.camera.screen.b_renamed.b_renamed {
    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(boolean z_renamed) {
        return 1;
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(int i_renamed) {
        return 2 == i_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return "out";
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int j_renamed() {
        return 2;
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar2) {
        aVar2.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {f_renamed - r3[0], f2 - r3[1]};
        fArr[0] = java.lang.Math.min(java.lang.Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = java.lang.Math.min(java.lang.Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.widget.RelativeLayout.LayoutParams a_renamed(android.util.Size size) {
        if (size == null) {
            return null;
        }
        android.graphics.Rect rectB = b_renamed(size.getHeight(), size.getWidth());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(rectB.width(), rectB.height());
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        layoutParams.leftMargin = rectB.left;
        layoutParams.topMargin = rectB.top;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect b_renamed(int i_renamed, int i2) {
        this.f5361b = com.oplus.camera.util.Util.getScreenWidth();
        this.f5362c = com.oplus.camera.util.Util.getScreenHeight();
        int iD = com.oplus.camera.util.Util.d_renamed(i2, i_renamed);
        float f_renamed = i2 / i_renamed;
        if (7 == iD) {
            int iRound = java.lang.Math.round(this.f5362c / f_renamed);
            int i3 = (this.f5361b - iRound) / 2;
            return new android.graphics.Rect(i3, 0, iRound + i3, this.f5362c);
        }
        int iRound2 = java.lang.Math.round(f_renamed * this.f5361b);
        int iC = ((this.f5362c - iRound2) / 2) + c_renamed(iD);
        return new android.graphics.Rect(0, iC, this.f5361b, iRound2 + iC);
    }

    public static int c_renamed(int i_renamed) {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        if (i_renamed == 0) {
            return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_screen_center_offset_y_4_3);
        }
        if (i_renamed == 1) {
            return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_screen_center_offset_y_16_9);
        }
        if (i_renamed != 2) {
            return 0;
        }
        return resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_screen_center_offset_y_1_1);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        int[] iArr = new int[4];
        float width = size.getWidth() / size.getHeight();
        if (7 == com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight())) {
            iArr[0] = this.f5362c;
            iArr[1] = java.lang.Math.round(this.f5362c / width);
        } else {
            iArr[0] = (int) (this.f5361b * width);
            iArr[1] = this.f5361b;
        }
        float width2 = size2.getWidth() / size2.getHeight();
        if (7 == com.oplus.camera.util.Util.d_renamed(size2.getWidth(), size2.getHeight())) {
            iArr[2] = this.f5362c;
            iArr[3] = java.lang.Math.round(this.f5362c / width2);
        } else {
            iArr[2] = (int) (this.f5361b * width2);
            iArr[3] = this.f5361b;
        }
        return iArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        arrayList.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO);
        arrayList.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER);
        return arrayList;
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button, false);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), i_renamed);
        layoutParams.setMargins(0, 0, 0, i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.b_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    protected void b_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        super.b_renamed(activity);
        i_renamed(activity);
        a_renamed(activity, (com.oplus.camera.screen.c_renamed) null);
        j_renamed(activity);
        h_renamed(activity);
    }

    private void h_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout}, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom)});
        cVar.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout}, new int[]{0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom)});
        cVar2.f5365c = new int[]{dimensionPixelOffset, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button), cVar2);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_panel_margin_bottom_vertical)});
        cVar3.f5365c = new int[]{-1, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout), cVar3);
    }

    private void i_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_main_shutter_button_margin_top);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_button_margin_edge);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_switch_camera_button_margin_top);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_thumbnail_margin_top);
        int dimensionPixelOffset7 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.thumbnail_view_padding);
        int dimensionPixelOffset8 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.thumbnail_margin_start);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{12, 0}, new int[]{0, 0, 0, 0});
        cVar.f5365c = new int[]{-1, com.oplus.camera.util.Util.O_renamed()};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_layout), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{10, 0}, new int[]{0, dimensionPixelOffset2, 0, 0});
        cVar2.f5365c = new int[]{-1, dimensionPixelOffset};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout), cVar2);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.shutter_button), new com.oplus.camera.screen.c_renamed(new int[]{14, 0}, new int[]{0, dimensionPixelOffset3, 0, 0}));
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.switch_camera_button), new com.oplus.camera.screen.c_renamed(new int[]{21, 0}, new int[]{0, dimensionPixelOffset5, dimensionPixelOffset4, 0}));
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.video_pause_resume), new com.oplus.camera.screen.c_renamed(new int[]{21, 0}, new int[]{0, dimensionPixelOffset5, dimensionPixelOffset4, 0}));
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{20, 0}, new int[]{dimensionPixelOffset8, dimensionPixelOffset6, 0, 0});
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.thumbnail), cVar3);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn), cVar3);
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.recording_cap_button), new com.oplus.camera.screen.c_renamed(new int[]{20, 0}, new int[]{dimensionPixelOffset8 + dimensionPixelOffset7, dimensionPixelOffset5, 0, 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        super.a_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{14, 0, 10, 0}, new int[]{0, 0, 0, 0}));
    }

    private void j_renamed(final android.app.Activity activity) {
        android.widget.RelativeLayout.LayoutParams layoutParamsE = e_renamed();
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, layoutParamsE.bottomMargin});
        cVar.f5365c = new int[]{layoutParamsE.width, layoutParamsE.height};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{12, 0, 14, 0}, new int[]{0, 0, 0, 0});
        cVar2.f5365c = new int[]{-1, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height)};
        cVar2.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$j_renamed$p_renamed-74yuUwNzNumCHd4oe_NutrJsY
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
        cVar3.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$j_renamed$P1JFmQ8nHG5Qc63VPLwcK9u2FxM
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.screen.b_renamed.j_renamed.a_renamed(activity, iK, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container), cVar3);
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
        pVar.d_renamed(2, i_renamed);
        int childCount = pVar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = pVar.getChildAt(i2);
            if (childAt instanceof com.oplus.camera.professional.LevelPanel) {
                com.oplus.camera.professional.LevelPanel levelPanel = (com.oplus.camera.professional.LevelPanel) childAt;
                levelPanel.a_renamed(2, i_renamed);
                levelPanel.e_renamed();
            }
        }
    }
}
