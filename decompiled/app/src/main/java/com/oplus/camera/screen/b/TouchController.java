package com.oplus.camera.screen.b_renamed;

/* compiled from: RackScreenMode270.java */
/* loaded from: classes2.dex */
public class l_renamed extends com.oplus.camera.screen.b_renamed.k_renamed {
    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int k_renamed() {
        return 270;
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        super.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(270.0f);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect b_renamed(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        android.graphics.Rect rect;
        this.f5361b = com.oplus.camera.util.Util.getScreenHeight();
        this.f5362c = com.oplus.camera.util.Util.getScreenWidth() / 2;
        float f_renamed = i2 / i_renamed;
        if (f_renamed > this.f5361b / this.f5362c) {
            int dimensionPixelOffset = com.oplus.camera.MyApplication.d_renamed().getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_movie_mode_margin_top);
            int iRound = java.lang.Math.round(this.f5361b / f_renamed);
            if (this.d_renamed) {
                dimensionPixelOffset = (com.oplus.camera.util.Util.getScreenWidth() - dimensionPixelOffset) - iRound;
            }
            rect = new android.graphics.Rect(dimensionPixelOffset, 0, iRound + dimensionPixelOffset, this.f5361b);
        } else {
            int i3 = this.f5362c;
            int iRound2 = java.lang.Math.round(i3 * f_renamed);
            int i4 = (this.f5361b - iRound2) / 2;
            int screenWidth = this.d_renamed ? com.oplus.camera.util.Util.getScreenWidth() / 2 : 0;
            rect = new android.graphics.Rect(screenWidth, i4, i3 + screenWidth, iRound2 + i4);
        }
        this.f_renamed = rect;
        return rect;
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_out_screen_preview_switch_button_margin_right), 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_out_screen_preview_switch_button_margin_top)});
        cVar2.d_renamed = 270;
        super.f_renamed(activity, cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, boolean z_renamed, float f_renamed, float f2) {
        return ((float) com.oplus.camera.screen.f_renamed.f5371a) - f_renamed > ((float) activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_confirm_root_layout_height));
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {r3[1] - f2, f_renamed - r3[0]};
        fArr[0] = java.lang.Math.min(java.lang.Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = java.lang.Math.min(java.lang.Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        super.a_renamed(activity, cVar, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_control_panel_button_margin_right), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.d_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start) + com.oplus.camera.util.Util.Z_renamed(), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_arc_seekbar_bg_circle_radius_offset) / 2;
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{((-dimensionPixelSize) / 2) + dimensionPixelSize2 + com.oplus.camera.util.Util.Z_renamed(), 0, 0, ((dimensionPixelSize / 2) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_focus_circle_margin_bottom)) - dimensionPixelSize2}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2, com.oplus.camera.screen.c_renamed cVar3) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int[] iArr = {9, 0, 12, 0};
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start) + com.oplus.camera.util.Util.Z_renamed();
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

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.c_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start) + com.oplus.camera.util.Util.Z_renamed(), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_blur_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = super.c_renamed();
        arrayListC.add("movie");
        return arrayListC;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return this.d_renamed ? "low270" : "rack270";
    }
}
