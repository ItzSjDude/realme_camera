package com.oplus.camera.screen.b_renamed;

/* compiled from: CommonScreenMode.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.screen.b_renamed.a_renamed {
    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public int a_renamed(boolean z_renamed) {
        return 0;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void a_renamed(android.view.View view, com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList, android.content.Context context, int i_renamed) {
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public boolean a_renamed() {
        return true;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(int i_renamed) {
        return i_renamed == 0 || 2 == i_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public boolean i_renamed() {
        return false;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int j_renamed() {
        return 0;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        this.f5361b = com.oplus.camera.screen.f_renamed.f5371a;
        this.f5362c = com.oplus.camera.screen.f_renamed.f5372b;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    protected void b_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        super.b_renamed(activity);
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = (-resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size)) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
        final int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_height);
        final int dimensionPixelSize5 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_circle_center_y);
        final int dimensionPixelSize6 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        final int dimensionPixelSize7 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout}, new int[]{0, 0, 0, dimensionPixelSize});
        cVar.f5365c = new int[]{-1, -2};
        cVar.d_renamed = 0;
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$b_renamed$9A--AMwStlUnPFsbFFG16r6tn8M
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                this.f_renamed$0.a_renamed(activity, dimensionPixelSize4, dimensionPixelSize6, dimensionPixelSize7, dimensionPixelSize5, dimensionPixelSize2, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container), cVar);
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{3, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar}, new int[]{0, dimensionPixelSize3, 0, 0});
        cVar2.f5365c = new int[]{-1, -2};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click), cVar2);
        com.oplus.camera.screen.c_renamed cVar3 = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar, 14, 0}, new int[]{0, 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_value_padding_bottom)});
        cVar3.f5365c = new int[]{-2, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_value_height)};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_display_text), cVar3);
        i_renamed(activity);
        f_renamed(activity);
        g_renamed(activity);
        h_renamed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, int i3, int i4, int i5, android.view.View view) {
        com.oplus.camera.ui.preview.af_renamed afVar = (com.oplus.camera.ui.preview.af_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
        afVar.getLayoutParams().width = -1;
        afVar.getLayoutParams().height = i_renamed;
        afVar.a_renamed(this.f5361b, i2, i3, i4, (com.oplus.camera.util.Util.P_renamed() + i5) / 2.0f, 1.0f, 0.0f);
    }

    private void h_renamed(final android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = com.oplus.camera.util.Util.l_renamed().getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_padding_left_right);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{10, 0}, new int[]{0, 0, 0, 0});
        cVar.f5365c = new int[]{-1, -2};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$b_renamed$psDyPbhOpNS9vM2hrLp5KWtNY5A
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.b_renamed.a_renamed(activity, dimensionPixelSize, dimensionPixelSize2, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, int i_renamed, int i2, android.view.View view) {
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
        cameraSettingMenuPanel.getLayoutParams().width = -1;
        cameraSettingMenuPanel.getLayoutParams().height = i_renamed;
        cameraSettingMenuPanel.setPaddingLeftRight(i2);
        com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel2 = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        if (cameraSettingMenuPanel2 != null) {
            cameraSettingMenuPanel2.getLayoutParams().width = -1;
            cameraSettingMenuPanel2.setRotation(0.0f);
        }
    }

    protected void f_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.horizontal_common_effect_button_margin_end);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout, 21, 0}, new int[]{0, 0, dimensionPixelOffset2, dimensionPixelOffset});
        cVar.f5365c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button), cVar);
        activity.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button).setVisibility(8);
    }

    protected void g_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_right);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout, 20, 0}, new int[]{dimensionPixelOffset, 0, 0, dimensionPixelOffset2});
        cVar.f5365c = new int[]{dimensionPixelOffset3, dimensionPixelOffset3};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button), cVar);
    }

    private void i_renamed(final android.app.Activity activity) {
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(null, null);
        cVar.f5365c = new int[]{0, 0};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$b_renamed$A5r_DQHHKX-F6pH9j0WMJ6sPPOw
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.b_renamed.a_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.gallery_container), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        ((android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container)).setVisibility(8);
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
    public boolean a_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, int i_renamed, int i2) {
        return i2 >= cameraUIInterface.am_renamed() && i2 <= cameraUIInterface.an_renamed();
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
        return new java.util.ArrayList<>();
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        if (i_renamed == 2) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, true);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, true);
            return;
        }
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button, false);
        com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.video_pause_resume, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
    }
}
