package com.oplus.camera.screen.b_renamed;

/* compiled from: RackScreenMode90.java */
/* loaded from: classes2.dex */
public class m_renamed extends com.oplus.camera.screen.b_renamed.k_renamed {
    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int k_renamed() {
        return 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        super.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(90.0f);
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
            if (!this.d_renamed) {
                dimensionPixelOffset = (com.oplus.camera.util.Util.getScreenWidth() - dimensionPixelOffset) - iRound;
            }
            rect = new android.graphics.Rect(dimensionPixelOffset, 0, iRound + dimensionPixelOffset, this.f5361b);
        } else {
            int i3 = this.f5362c;
            int iRound2 = java.lang.Math.round(i3 * f_renamed);
            int i4 = (this.f5361b - iRound2) / 2;
            int screenWidth = this.d_renamed ? 0 : com.oplus.camera.util.Util.getScreenWidth() / 2;
            rect = new android.graphics.Rect(screenWidth, i4, i3 + screenWidth, iRound2 + i4);
        }
        this.f_renamed = rect;
        return rect;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, boolean z_renamed, float f_renamed, float f2) {
        return f_renamed > ((float) activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_confirm_root_layout_height));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return super.a_renamed(activity, rect);
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean b_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        return super.b_renamed(activity, rect);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public float[] a_renamed(android.view.View view, float f_renamed, float f2) {
        view.getLocationOnScreen(new int[2]);
        float[] fArr = {f2 - r3[1], r3[0] - f_renamed};
        fArr[0] = java.lang.Math.min(java.lang.Math.max(fArr[0], view.getPaddingLeft()), view.getWidth() - view.getPaddingRight());
        fArr[1] = java.lang.Math.min(java.lang.Math.max(fArr[1], view.getPaddingTop()), view.getHeight() - view.getPaddingBottom());
        return fArr;
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void f_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        com.oplus.camera.screen.c_renamed cVar2 = new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 10, 0}, new int[]{0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_out_screen_preview_switch_button_margin_top), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_out_screen_preview_switch_button_margin_right), 0});
        cVar2.d_renamed = 90;
        super.f_renamed(activity, cVar2);
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar, com.oplus.camera.screen.c_renamed cVar2) {
        super.a_renamed(activity, cVar, new com.oplus.camera.screen.c_renamed(new int[]{11, 0, 12, 0}, new int[]{0, 0, activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_control_panel_button_margin_right) + java.lang.Math.round(com.oplus.camera.util.Util.Z_renamed() / 5.0f), 0}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void d_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.d_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void b_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_arc_seekbar_bg_circle_radius_offset) / 2;
        super.b_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{((-dimensionPixelSize) / 2) + dimensionPixelSize2, 0, 0, ((dimensionPixelSize / 2) - resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_zoom_focus_circle_margin_bottom)) - dimensionPixelSize2}));
    }

    @Override // com.oplus.camera.screen.b_renamed.k_renamed
    protected void c_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        android.content.res.Resources resources = activity.getResources();
        super.c_renamed(activity, new com.oplus.camera.screen.c_renamed(new int[]{9, 0, 12, 0}, new int[]{resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_effect_button_margin_start), 0, 0, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_blur_button_margin_bottom)}));
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return this.d_renamed ? "low90" : "rack90";
    }
}
