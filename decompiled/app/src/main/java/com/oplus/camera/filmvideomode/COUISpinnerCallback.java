package com.oplus.camera.filmvideomode;

/* compiled from: FilmUIControlV1.java */
/* loaded from: classes2.dex */
public class p_renamed extends com.oplus.camera.filmvideomode.a_renamed {
    public p_renamed(android.app.Activity activity, com.oplus.camera.e_renamed.d_renamed dVar, com.oplus.camera.capmode.a_renamed aVar, android.view.ViewGroup viewGroup) {
        super(activity);
        this.f4466b = activity;
        this.f4467c.setRotation(90.0f);
        this.f4467c.setOnClickListener(this);
        this.f_renamed = dVar;
        this.d_renamed = aVar;
        this.i_renamed = aVar.t_renamed();
        this.k_renamed = com.oplus.camera.util.Util.b_renamed(activity, com.oplus.camera.R_renamed.drawable.exposure_control_bar_bottom);
        this.l_renamed = (com.oplus.camera.ui.control.ThumbImageView) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.thumbnail);
        this.m_renamed = (com.oplus.camera.ui.control.MainShutterButton) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.shutter_button);
        this.n_renamed = viewGroup;
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) || this.f4467c.getLayoutParams() == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.f4467c.getLayoutParams();
        layoutParams.topMargin = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_back_top) + i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
        this.f4467c.setLayoutParams(layoutParams);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().b_renamed(false).c_renamed(true).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).c_renamed(com.oplus.camera.R_renamed.drawable.icon_show).a_renamed(com.oplus.camera.R_renamed.drawable.icon_hide));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(e_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.icon_tool_grid_light).c_renamed(com.oplus.camera.R_renamed.drawable.icon_tool_grid));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(f_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.super_eis_light).c_renamed(com.oplus.camera.R_renamed.drawable.super_eis_normal));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(c_renamed()).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.menu_flash_torch_light).c_renamed(com.oplus.camera.R_renamed.drawable.camera_menu_flash_off));
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.filmvideomode.e_renamed(arrayList, this.i_renamed, false, false);
        }
        this.g_renamed.setAdapter(this.h_renamed);
    }

    private void f_renamed(boolean z_renamed) {
        if (this.f4465a != null) {
            this.f4465a.b_renamed(z_renamed);
            this.f4465a.d_renamed();
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed(android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        if (this.f4465a != null && viewGroup != null && viewGroup.indexOfChild(this.f4465a) >= 0) {
            f_renamed(false);
            viewGroup.removeView(this.f4465a);
        }
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        this.h_renamed.getItem(0).a_renamed(false);
        this.h_renamed.getItem(0).f_renamed(false);
        this.h_renamed.getItem(0).e_renamed(true);
        this.h_renamed.a_renamed(this.g_renamed, 0, false);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed, android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.movie_mode_back) {
            return;
        }
        if (this.d_renamed != null) {
            this.d_renamed.aC_renamed();
        }
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE).apply();
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed, com.oplus.camera.filmvideomode.f_renamed.a_renamed
    public void b_renamed(android.view.View view, android.view.View view2, int i_renamed) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = (this.d_renamed == null || this.d_renamed.R_renamed() || this.d_renamed.S_renamed() || (view2.getTag() instanceof java.lang.Boolean ? ((java.lang.Boolean) view2.getTag()).booleanValue() : false)) ? false : true;
        if (i_renamed() == null || this.h_renamed == null || this.f4465a == null || this.f4465a.a_renamed() || !z_renamed) {
            return;
        }
        if (this.d_renamed != null && this.d_renamed.aT_renamed() != null) {
            this.d_renamed.aT_renamed().a_renamed(true);
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(i_renamed);
        item.a_renamed(!item.e_renamed());
        boolean z2 = i_renamed == 0;
        if (z2) {
            boolean zC = this.f4465a.c_renamed();
            item.e_renamed(true);
            if (item.e_renamed() && !zC) {
                this.f4465a.b_renamed();
            } else {
                f_renamed(false);
            }
            if (this.d_renamed != null && !this.d_renamed.ao_renamed() && !zC) {
                item.f_renamed(false);
                this.h_renamed.a_renamed(this.g_renamed, i_renamed, true);
            } else {
                item.f_renamed(true);
                this.h_renamed.b_renamed(this.g_renamed, i_renamed, this.h_renamed.b_renamed(), !item.e_renamed());
            }
        } else {
            this.h_renamed.a_renamed(this.g_renamed, i_renamed);
        }
        if (3 == i_renamed) {
            a_renamed(item);
        }
        if (2 == i_renamed) {
            b_renamed(item);
        }
        if (1 == i_renamed) {
            c_renamed(item);
        }
        if (this.i_renamed != null && z2) {
            this.i_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.e_renamed()).apply();
        }
        z_renamed();
        b_renamed(i_renamed, item.e_renamed());
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void j_renamed() throws android.content.res.Resources.NotFoundException {
        if (i_renamed() == null || this.h_renamed == null || this.g_renamed == null || this.i_renamed == null || this.f4465a == null || this.h_renamed.getCount() == 0 || this.h_renamed.b_renamed() || !this.i_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, true)) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(0);
        item.a_renamed(true);
        item.f_renamed(false);
        item.e_renamed(true);
        this.f4465a.b_renamed();
        this.h_renamed.a_renamed(this.g_renamed, 0, true);
    }

    private void a_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.f_renamed == null || this.i_renamed == null) {
            return;
        }
        this.d_renamed.aT_renamed().a_renamed(true);
        this.d_renamed.aT_renamed().b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE);
        if (gVar.e_renamed()) {
            a_renamed(true, 2);
            a_renamed(true, 1);
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH).apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        }
        z_renamed();
    }

    private void b_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.i_renamed == null) {
            return;
        }
        if (gVar.e_renamed()) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on_renamed").apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
        }
    }

    private void c_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.i_renamed == null) {
            return;
        }
        this.d_renamed.aT_renamed().b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE);
        if (gVar.e_renamed()) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "grid").apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").apply();
        }
        z_renamed();
    }

    private void z_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarAT;
        if (this.d_renamed == null || (aVarAT = this.d_renamed.aT_renamed()) == null) {
            return;
        }
        aVarAT.b_renamed((java.lang.String) null);
        aVarAT.a_renamed(false);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void k_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || !c_renamed()) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(3);
        item.a_renamed(false);
        a_renamed(item);
        this.h_renamed.a_renamed(this.g_renamed, 3);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void l_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(3);
        if (item.e_renamed() != c_renamed()) {
            item.a_renamed(c_renamed());
            this.h_renamed.a_renamed(this.g_renamed, 3);
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void m_renamed() throws android.content.res.Resources.NotFoundException {
        super.m_renamed();
        if (this.d_renamed != null && this.h_renamed != null && this.h_renamed.b_renamed() && this.h_renamed.getCount() > 0) {
            com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(0);
            item.a_renamed(true);
            item.e_renamed(false);
            item.f_renamed(false);
            this.h_renamed.b_renamed(this.g_renamed, 0, true, false);
        }
        if (this.j_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
        if (this.f4467c != null) {
            com.oplus.camera.util.Util.a_renamed(this.f4467c, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void n_renamed() throws android.content.res.Resources.NotFoundException {
        super.n_renamed();
        boolean z_renamed = this.f4465a != null && this.f4465a.c_renamed();
        if (this.d_renamed != null && this.h_renamed != null && !this.h_renamed.b_renamed() && z_renamed && this.h_renamed.getCount() > 0) {
            com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(0);
            item.a_renamed(true);
            item.e_renamed(false);
            item.f_renamed(false);
            this.h_renamed.a_renamed(this.g_renamed, 0, true);
        }
        if (this.j_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
        if (this.f4467c != null) {
            com.oplus.camera.util.Util.a_renamed(this.f4467c, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
    }

    private void b_renamed(int i_renamed, boolean z_renamed) {
        if (this.f4466b == null) {
            return;
        }
        com.oplus.camera.statistics.model.FilmModeMsgData filmModeMsgData = new com.oplus.camera.statistics.model.FilmModeMsgData(i_renamed());
        filmModeMsgData.buildEventId("funcKey_click");
        if (this.d_renamed != null) {
            filmModeMsgData.mCameraId = this.d_renamed.aw_renamed();
        }
        if (this.i_renamed != null) {
            filmModeMsgData.mCaptureMode = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "");
        }
        if (i_renamed == 0) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_MENU_SWITCH;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 1) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_GRID;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 2) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_EIS;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 3) {
            filmModeMsgData.mFuncKeyId = "3";
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        }
        filmModeMsgData.report();
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void b_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(3);
        item.a_renamed(z_renamed);
        item.d_renamed(z2);
        this.h_renamed.a_renamed(this.g_renamed, 3);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void c_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(2);
        item.a_renamed(z_renamed);
        item.d_renamed(z2);
        this.h_renamed.a_renamed(this.g_renamed, 2);
    }
}
