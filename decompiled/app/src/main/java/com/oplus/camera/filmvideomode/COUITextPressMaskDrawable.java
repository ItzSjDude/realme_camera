package com.oplus.camera.filmvideomode;

/* compiled from: FilmUIControlV2.java */
/* loaded from: classes2.dex */
public class q_renamed extends com.oplus.camera.filmvideomode.a_renamed {
    protected android.widget.RelativeLayout s_renamed;
    protected com.oplus.camera.filmvideomode.o_renamed t_renamed;
    protected com.oplus.camera.filmvideomode.m_renamed u_renamed;
    protected android.view.GestureDetector v_renamed;
    protected com.oplus.camera.ui.preview.PreviewFrameLayout w_renamed;
    protected android.animation.ObjectAnimator x_renamed;
    protected android.animation.ObjectAnimator y_renamed;

    public q_renamed(android.app.Activity activity, com.oplus.camera.e_renamed.d_renamed dVar, com.oplus.camera.capmode.a_renamed aVar, android.view.ViewGroup viewGroup) {
        super(activity);
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
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
        this.w_renamed = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        this.v_renamed = new android.view.GestureDetector(i_renamed(), new com.oplus.camera.filmvideomode.q_renamed.a_renamed());
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR) || this.f4467c.getLayoutParams() == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.f4467c.getLayoutParams();
        layoutParams.topMargin = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_back_top) + i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
        this.f4467c.setLayoutParams(layoutParams);
    }

    protected void f_renamed(boolean z_renamed) {
        if (this.s_renamed == null) {
            this.t_renamed = new com.oplus.camera.filmvideomode.o_renamed(i_renamed());
            this.s_renamed = new android.widget.RelativeLayout(i_renamed());
            this.s_renamed.setBackground(i_renamed().getResources().getDrawable(com.oplus.camera.R_renamed.drawable.film_submenu_panel_bg));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_padding_top);
            layoutParams.bottomMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_padding_bottom);
            this.s_renamed.addView(this.t_renamed, layoutParams);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_width), i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_height));
        layoutParams2.addRule(10);
        layoutParams2.topMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_margin_top);
        layoutParams2.leftMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_submenu_panel_margin_left);
        A_renamed();
        this.s_renamed.setRotation(90.0f);
        this.w_renamed.removeView(this.s_renamed);
        this.s_renamed.setVisibility(8);
        this.w_renamed.addView(this.s_renamed, layoutParams2);
        if (z_renamed) {
            b_renamed(this.s_renamed);
        } else {
            this.s_renamed.setVisibility(0);
        }
        z_renamed();
    }

    protected void z_renamed() {
        this.l_renamed = (com.oplus.camera.ui.control.ThumbImageView) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.thumbnail);
        if (this.l_renamed != null) {
            this.l_renamed.setVisibility(8);
        }
        if (this.j_renamed != null) {
            this.j_renamed.setVisibility(8);
        }
        if (this.f4465a != null) {
            this.f4465a.setVisibility(8);
        }
        if (this.d_renamed != null) {
            this.d_renamed.m_renamed(false);
        }
    }

    protected void g_renamed(boolean z_renamed) {
        android.widget.RelativeLayout relativeLayout = this.s_renamed;
        if (relativeLayout != null) {
            if (z_renamed) {
                c_renamed(relativeLayout);
            } else {
                relativeLayout.setVisibility(8);
                this.w_renamed.removeView(this.s_renamed);
            }
        }
        h_renamed(z_renamed);
    }

    protected void h_renamed(boolean z_renamed) {
        this.l_renamed = (com.oplus.camera.ui.control.ThumbImageView) this.f4466b.findViewById(com.oplus.camera.R_renamed.id_renamed.thumbnail);
        if (this.l_renamed != null) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.l_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 50L, 150L, (android.view.animation.Interpolator) null);
            } else {
                this.l_renamed.setVisibility(0);
            }
        }
        if (this.j_renamed != null) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 50L, 150L, (android.view.animation.Interpolator) null);
        }
        if (this.f4465a != null) {
            com.oplus.camera.util.Util.a_renamed(this.f4465a, 0, (android.view.animation.Animation.AnimationListener) null, 50L, 150L, (android.view.animation.Interpolator) null);
        }
    }

    protected void b_renamed(android.view.View view) {
        com.oplus.camera.e_renamed.a_renamed("FilmUIControlV2", "showSubMenuPanelAnim");
        if (this.x_renamed == null) {
            this.x_renamed = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            this.x_renamed.setDuration(200L);
        }
        view.setVisibility(0);
        this.x_renamed.start();
    }

    protected void c_renamed(final android.view.View view) {
        com.oplus.camera.e_renamed.a_renamed("FilmUIControlV2", "hideSubMenuPanelAnim");
        if (this.y_renamed == null) {
            this.y_renamed = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            this.y_renamed.setDuration(200L);
            this.y_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.q_renamed.1
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(8);
                    com.oplus.camera.filmvideomode.q_renamed.this.w_renamed.removeView(com.oplus.camera.filmvideomode.q_renamed.this.s_renamed);
                }

                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    super.onAnimationCancel(animator);
                    view.setVisibility(8);
                    com.oplus.camera.filmvideomode.q_renamed.this.w_renamed.removeView(com.oplus.camera.filmvideomode.q_renamed.this.s_renamed);
                }
            });
        }
        this.y_renamed.start();
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FilmUIControlV2", "initMenuList");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().b_renamed(false).c_renamed(true).b_renamed(0).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).c_renamed(com.oplus.camera.R_renamed.drawable.icon_show).a_renamed(com.oplus.camera.R_renamed.drawable.icon_hide));
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(C_renamed()).b_renamed(1).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.submenu_open).c_renamed(com.oplus.camera.R_renamed.drawable.submenu_close));
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MOVIE_MODE_HDR_LOG)) {
            arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(g_renamed()).b_renamed(2).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.menu_hdr_mode_on_light).c_renamed(com.oplus.camera.R_renamed.drawable.menu_hdr_mode_off_dark));
            arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(b_renamed()).b_renamed(3).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.menu_log_on).c_renamed(com.oplus.camera.R_renamed.drawable.menu_log_off));
        }
        arrayList.add(new com.oplus.camera.filmvideomode.g_renamed().a_renamed(f_renamed()).b_renamed(4).d_renamed(com.oplus.camera.R_renamed.drawable.movie_mode_menu_bg).a_renamed(com.oplus.camera.R_renamed.drawable.super_eis_light).c_renamed(com.oplus.camera.R_renamed.drawable.super_eis_normal));
        if (this.h_renamed == null) {
            this.h_renamed = new com.oplus.camera.filmvideomode.e_renamed(arrayList, this.i_renamed, true, false);
        }
        this.g_renamed.setAdapter(this.h_renamed);
    }

    protected void A_renamed() {
        java.util.ArrayList<com.oplus.camera.filmvideomode.n_renamed> arrayList = new java.util.ArrayList<>();
        android.content.res.Resources resources = i_renamed().getResources();
        arrayList.add(new com.oplus.camera.filmvideomode.n_renamed().a_renamed(resources.getString(com.oplus.camera.R_renamed.string.camera_film_flash_mode)).a_renamed(c_renamed()).a_renamed(new com.oplus.camera.filmvideomode.n_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.q_renamed.2
            @Override // com.oplus.camera.filmvideomode.n_renamed.a_renamed
            public void a_renamed(boolean z_renamed) {
                com.oplus.camera.filmvideomode.q_renamed.this.j_renamed(z_renamed);
            }
        }));
        arrayList.add(new com.oplus.camera.filmvideomode.n_renamed().a_renamed(resources.getString(com.oplus.camera.R_renamed.string.camera_histogram)).a_renamed(d_renamed()).a_renamed(new com.oplus.camera.filmvideomode.n_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.q_renamed.3
            @Override // com.oplus.camera.filmvideomode.n_renamed.a_renamed
            public void a_renamed(boolean z_renamed) {
                com.oplus.camera.filmvideomode.q_renamed.this.l_renamed(z_renamed);
            }
        }));
        arrayList.add(new com.oplus.camera.filmvideomode.n_renamed().a_renamed(resources.getString(com.oplus.camera.R_renamed.string.camera_setting_reference_line_grid)).a_renamed(e_renamed()).a_renamed(new com.oplus.camera.filmvideomode.n_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.q_renamed.4
            @Override // com.oplus.camera.filmvideomode.n_renamed.a_renamed
            public void a_renamed(boolean z_renamed) {
                com.oplus.camera.filmvideomode.q_renamed.this.k_renamed(z_renamed);
            }
        }));
        com.oplus.camera.filmvideomode.m_renamed mVar = this.u_renamed;
        if (mVar == null) {
            this.u_renamed = new com.oplus.camera.filmvideomode.m_renamed(i_renamed(), arrayList);
        } else {
            mVar.a_renamed(arrayList);
        }
        this.t_renamed.setAdapter((android.widget.ListAdapter) this.u_renamed);
    }

    protected boolean B_renamed() {
        android.animation.ObjectAnimator objectAnimator;
        android.animation.ObjectAnimator objectAnimator2 = this.x_renamed;
        return (objectAnimator2 != null && objectAnimator2.isRunning()) || ((objectAnimator = this.y_renamed) != null && objectAnimator.isRunning());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C_renamed() {
        android.widget.RelativeLayout relativeLayout = this.s_renamed;
        return (relativeLayout == null || relativeLayout.getVisibility() != 0 || -1 == this.w_renamed.indexOfChild(this.s_renamed)) ? false : true;
    }

    protected void i_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.f4465a != null) {
            this.f4465a.b_renamed(z_renamed);
            this.f4465a.d_renamed();
        }
        if (C_renamed()) {
            g_renamed(true);
            this.h_renamed.getItem(1).a_renamed(false);
            this.h_renamed.a_renamed(this.g_renamed, 1);
        }
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void a_renamed(android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        if (this.f4465a != null && viewGroup != null && viewGroup.indexOfChild(this.f4465a) >= 0) {
            i_renamed(false);
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
    public void onClick(android.view.View view) throws android.content.res.Resources.NotFoundException {
        if (view.getId() != com.oplus.camera.R_renamed.id_renamed.movie_mode_back) {
            return;
        }
        if (C_renamed()) {
            g_renamed(false);
            this.h_renamed.getItem(1).a_renamed(false);
            this.h_renamed.a_renamed(this.g_renamed, 1);
        }
        if (this.d_renamed != null) {
            this.d_renamed.aC_renamed();
        }
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE).apply();
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed, com.oplus.camera.filmvideomode.f_renamed.a_renamed
    public void b_renamed(android.view.View view, android.view.View view2, int i_renamed) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = (this.d_renamed == null || this.d_renamed.R_renamed() || this.d_renamed.S_renamed() || (view2.getTag() instanceof java.lang.Boolean ? ((java.lang.Boolean) view2.getTag()).booleanValue() : false)) ? false : true;
        if (i_renamed() == null || this.h_renamed == null || this.f4465a == null || this.f4465a.a_renamed() || B_renamed() || !z_renamed) {
            com.oplus.camera.e_renamed.b_renamed("FilmUIControlV2", "onMenuItemClick is_renamed intercepted, return");
            return;
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
                i_renamed(false);
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
        int iB = item.b_renamed();
        if (iB == 1) {
            c_renamed(item);
        } else if (iB == 2) {
            b_renamed(item);
        } else if (iB == 3) {
            d_renamed(item);
        } else if (iB == 4) {
            a_renamed(item);
        }
        if (this.i_renamed != null && z2) {
            this.i_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT, item.e_renamed()).apply();
        }
        b_renamed(item.b_renamed(), item.e_renamed());
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void p_renamed() throws android.content.res.Resources.NotFoundException {
        super.p_renamed();
        if (C_renamed()) {
            g_renamed(false);
            this.h_renamed.getItem(1).a_renamed(false);
            this.h_renamed.a_renamed(this.g_renamed, 1);
        }
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

    protected void j_renamed(boolean z_renamed) {
        if (this.f_renamed == null || this.i_renamed == null) {
            return;
        }
        b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE);
        if (z_renamed) {
            a_renamed(true, 2);
            a_renamed(true, 1);
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH).apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        }
        D_renamed();
        a_renamed("3");
    }

    protected void a_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.i_renamed == null) {
            return;
        }
        b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU);
        if (gVar.e_renamed()) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on_renamed").apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
        }
        D_renamed();
    }

    protected void b_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.i_renamed == null) {
            return;
        }
        if (gVar.e_renamed()) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR, "on_renamed").apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").apply();
        }
    }

    protected void k_renamed(boolean z_renamed) {
        if (this.i_renamed != null) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, z_renamed ? "grid" : "off").apply();
            a_renamed(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_GRID);
        }
    }

    protected void l_renamed(boolean z_renamed) {
        if (this.i_renamed != null) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, z_renamed ? "on_renamed" : "off").apply();
            a_renamed(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM);
        }
    }

    private void b_renamed(java.lang.String str) {
        com.oplus.camera.ui.a_renamed.a_renamed aVarAT;
        if (this.d_renamed == null || (aVarAT = this.d_renamed.aT_renamed()) == null) {
            return;
        }
        aVarAT.a_renamed(true);
        aVarAT.b_renamed(str);
    }

    private void D_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarAT;
        if (this.d_renamed == null || (aVarAT = this.d_renamed.aT_renamed()) == null) {
            return;
        }
        aVarAT.a_renamed(false);
        aVarAT.b_renamed((java.lang.String) null);
    }

    protected void c_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar != null) {
            if (gVar.e_renamed()) {
                f_renamed(true);
            } else {
                g_renamed(true);
            }
        }
    }

    protected void d_renamed(com.oplus.camera.filmvideomode.g_renamed gVar) {
        if (gVar == null || this.i_renamed == null) {
            return;
        }
        if (gVar.e_renamed()) {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG, "on_renamed").apply();
        } else {
            this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").apply();
        }
    }

    private void E_renamed() {
        this.f4466b.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.q_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.filmvideomode.q_renamed.this.u_renamed != null) {
                    com.oplus.camera.filmvideomode.q_renamed.this.u_renamed.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void k_renamed() {
        com.oplus.camera.filmvideomode.m_renamed mVar = this.u_renamed;
        if (mVar != null) {
            com.oplus.camera.filmvideomode.n_renamed item = mVar.getItem(0);
            if (item.a_renamed()) {
                item.a_renamed(false);
            }
            E_renamed();
        }
        j_renamed(false);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void l_renamed() {
        com.oplus.camera.filmvideomode.m_renamed mVar = this.u_renamed;
        if (mVar != null) {
            com.oplus.camera.filmvideomode.n_renamed item = mVar.getItem(0);
            if (item.a_renamed() != c_renamed()) {
                item.a_renamed(c_renamed());
            }
            E_renamed();
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
        if (this.f4465a != null && this.f4465a.getVisibility() != 0 && this.h_renamed != null && (this.h_renamed.b_renamed() || C_renamed())) {
            com.oplus.camera.util.Util.a_renamed(this.f4465a, 0, (android.view.animation.Animation.AnimationListener) null, 200L);
        }
        if (this.s_renamed == null || this.h_renamed == null) {
            return;
        }
        com.oplus.camera.util.Util.a_renamed(this.s_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 200L);
        this.h_renamed.getItem(1).a_renamed(false);
        this.h_renamed.a_renamed(this.g_renamed, 1);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public com.oplus.camera.statistics.model.DcsMsgData a_renamed(com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData) {
        videoRecordMsgData.mIsHistogramOpen = d_renamed() ? "on_renamed" : "off";
        videoRecordMsgData.mIsLog = b_renamed() ? "on_renamed" : "off";
        videoRecordMsgData.mIsMovieHdr = g_renamed() ? "on_renamed" : "off";
        return videoRecordMsgData;
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

    protected void b_renamed(int i_renamed, boolean z_renamed) {
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
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_SUBMENU;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 2) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_HDR;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 3) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_LOG;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        } else if (i_renamed == 4) {
            filmModeMsgData.mFuncKeyId = com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_EIS;
            filmModeMsgData.mFuncKeyResult = z_renamed ? "1" : "2";
        }
        filmModeMsgData.report();
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void c_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        com.oplus.camera.filmvideomode.g_renamed item = this.h_renamed.getItem(4);
        item.a_renamed(z_renamed);
        item.d_renamed(z2);
        this.h_renamed.a_renamed(this.g_renamed, 4);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void c_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        this.h_renamed.getItem(3).a_renamed(z_renamed);
        this.h_renamed.a_renamed(this.g_renamed, 3);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public void d_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        this.h_renamed.getItem(2).a_renamed(z_renamed);
        this.h_renamed.a_renamed(this.g_renamed, 2);
    }

    @Override // com.oplus.camera.filmvideomode.a_renamed
    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        android.view.GestureDetector gestureDetector = this.v_renamed;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* compiled from: FilmUIControlV2.java */
    protected class a_renamed extends android.view.GestureDetector.SimpleOnGestureListener {
        protected a_renamed() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
            if (com.oplus.camera.filmvideomode.q_renamed.this.C_renamed()) {
                com.oplus.camera.filmvideomode.q_renamed.this.g_renamed(true);
                com.oplus.camera.filmvideomode.q_renamed.this.h_renamed.getItem(1).a_renamed(false);
                com.oplus.camera.filmvideomode.q_renamed.this.h_renamed.a_renamed(com.oplus.camera.filmvideomode.q_renamed.this.g_renamed, 1);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) throws android.content.res.Resources.NotFoundException {
            super.onLongPress(motionEvent);
            if (com.oplus.camera.filmvideomode.q_renamed.this.C_renamed()) {
                com.oplus.camera.filmvideomode.q_renamed.this.g_renamed(true);
                com.oplus.camera.filmvideomode.q_renamed.this.h_renamed.getItem(1).a_renamed(false);
                com.oplus.camera.filmvideomode.q_renamed.this.h_renamed.a_renamed(com.oplus.camera.filmvideomode.q_renamed.this.g_renamed, 1);
            }
        }
    }
}
