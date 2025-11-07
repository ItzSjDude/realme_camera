package com.oplus.camera.ui.menu.facebeauty;

/* compiled from: FaceBeautyCommonMenu.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.ui.menu.facebeauty.d_renamed implements com.oplus.camera.ui.menu.facebeauty.a_renamed {
    private int A_renamed;
    private com.oplus.camera.ui.OplusNumAISeekBar B_renamed;
    private android.widget.RelativeLayout.LayoutParams C_renamed = null;
    private android.view.View z_renamed;

    private int c_renamed(int i_renamed, int i2) {
        return 1 == i_renamed ? 270 == i2 ? com.oplus.camera.R_renamed.layout.face_beauty_common_vertical_270 : com.oplus.camera.R_renamed.layout.face_beauty_common_vertical : com.oplus.camera.R_renamed.layout.face_beauty_common;
    }

    public e_renamed(android.app.Activity activity, com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar, com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed aVar2, int i_renamed, int i2) {
        this.z_renamed = null;
        this.A_renamed = 0;
        this.B_renamed = null;
        com.oplus.camera.util.Util.q_renamed(activity.getApplicationContext());
        this.w_renamed = i_renamed;
        this.y_renamed = activity;
        this.x_renamed = i2;
        this.o_renamed = aVar2;
        this.z_renamed = activity.getLayoutInflater().inflate(c_renamed(i_renamed, i2), (android.view.ViewGroup) null);
        this.f6417a = (android.widget.LinearLayout) this.z_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tab_container);
        this.A_renamed = a_renamed(activity);
        this.B_renamed = (com.oplus.camera.ui.OplusNumAISeekBar) this.z_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_seekbar);
        this.B_renamed.setOnProgressChangedListener(aVar);
        this.B_renamed.setFrontStyle(true);
        this.B_renamed.setmThumbTextShadowBlur(activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius));
        this.B_renamed.setmThumbTextShadowColor(activity.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
        this.v_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
    }

    public int a_renamed(android.app.Activity activity) {
        if (3 == this.w_renamed) {
            return activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_face_beauty_tab_margin_bottom);
        }
        return com.oplus.camera.util.Util.O_renamed() - activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_container_height);
    }

    public void a_renamed(int i_renamed, int i2) {
        if (i_renamed == -100000) {
            i_renamed = 0;
        }
        this.B_renamed.b_renamed(0).a_renamed(100).d_renamed(i2).c_renamed(i_renamed).postInvalidate();
    }

    public android.view.ViewGroup.LayoutParams b_renamed(int i_renamed, int i2) {
        if (1 == i_renamed) {
            this.C_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else if (4 == i_renamed) {
            this.C_renamed = new android.widget.RelativeLayout.LayoutParams(this.y_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_face_beauty_common_layout_width), -2);
            this.C_renamed.addRule(12);
            this.C_renamed.addRule(14);
            this.C_renamed.setMargins(0, 0, 0, this.y_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_face_beauty_layout_margin_bottom));
            this.C_renamed.setLayoutDirection(15);
        } else {
            this.C_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            this.C_renamed.addRule(12);
            this.C_renamed.setMargins(0, 0, 0, this.A_renamed);
        }
        return this.C_renamed;
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        this.h_renamed = z_renamed;
        this.j_renamed = z2;
        c_renamed();
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyCommonMenu", "showFaceBeauty, needAnimation: " + z_renamed);
        l_renamed(z_renamed);
        if (this.B_renamed.c_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("FaceBeautyCommonMenu", "showFaceBeauty, isThumbOnDragging");
            this.B_renamed.b_renamed();
        }
        this.e_renamed = 1;
        this.q_renamed = a_renamed(this.B_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void f_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyCommonMenu", "hideFaceBeauty, needAni: " + z_renamed);
        this.q_renamed = b_renamed(this.B_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void g_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FaceBeautyCommonMenu", "hideFaceBeauty, needAni: " + z_renamed);
        c_renamed(this.B_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.a_renamed
    public void a_renamed() {
        this.e_renamed = 0;
        m_renamed(false);
        if (this.n_renamed != null) {
            this.n_renamed.a_renamed();
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.z_renamed.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.z_renamed);
        }
    }

    public android.view.View s_renamed() {
        return this.z_renamed;
    }

    public com.oplus.camera.ui.OplusNumAISeekBar t_renamed() {
        return this.B_renamed;
    }
}
