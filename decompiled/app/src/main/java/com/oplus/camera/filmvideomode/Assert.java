package com.oplus.camera.filmvideomode;

/* compiled from: BaseFilmUIControl.java */
/* loaded from: classes2.dex */
public class a_renamed implements android.view.View.OnClickListener, com.oplus.camera.filmvideomode.f_renamed.a_renamed, com.oplus.camera.filmvideomode.k_renamed.a_renamed, com.oplus.camera.filmvideomode.k_renamed.b_renamed, com.oplus.camera.filmvideomode.k_renamed.c_renamed, com.oplus.camera.filmvideomode.k_renamed.d_renamed {
    private static final int[] s_renamed = {com.oplus.camera.R_renamed.drawable.zoom_seek_bar_ultra_angle, com.oplus.camera.R_renamed.drawable.zoom_seek_bar_normal_len, com.oplus.camera.R_renamed.drawable.zoom_seek_bar_tele};

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.RotateImageView f4467c;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected com.oplus.camera.filmvideomode.k_renamed f4465a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected android.app.Activity f4466b = null;
    protected com.oplus.camera.capmode.a_renamed d_renamed = null;
    protected int e_renamed = -1;
    protected com.oplus.camera.e_renamed.d_renamed f_renamed = null;
    protected com.oplus.camera.filmvideomode.f_renamed g_renamed = null;
    protected com.oplus.camera.filmvideomode.e_renamed h_renamed = null;
    protected android.content.SharedPreferences i_renamed = null;
    protected com.oplus.camera.ui.SwitchCameraBar j_renamed = null;
    protected android.graphics.drawable.Drawable k_renamed = null;
    protected com.oplus.camera.ui.control.ThumbImageView l_renamed = null;
    protected com.oplus.camera.ui.control.MainShutterButton m_renamed = null;
    protected android.view.ViewGroup n_renamed = null;
    protected boolean o_renamed = false;
    protected boolean p_renamed = false;
    protected android.graphics.Rect q_renamed = new android.graphics.Rect();
    protected com.oplus.camera.filmvideomode.a_renamed.BaseFilmUIControl_2 r_renamed = null;
    private boolean t_renamed = false;
    private java.lang.String u_renamed = "";
    private java.lang.String v_renamed = "";
    private java.lang.String w_renamed = "";
    private java.lang.String x_renamed = "";
    private int y_renamed = -1;
    private android.os.Handler z_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.filmvideomode.a_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 0) {
                if (message.obj == null || com.oplus.camera.filmvideomode.a_renamed.this.p_renamed) {
                    return;
                }
                com.oplus.camera.filmvideomode.a_renamed.this.a_renamed((com.oplus.camera.filmvideomode.FilmParam) message.obj);
                return;
            }
            if (i_renamed == 1) {
                if (com.oplus.camera.filmvideomode.a_renamed.this.p_renamed) {
                    return;
                }
                com.oplus.camera.filmvideomode.a_renamed.this.j_renamed();
            } else if (i_renamed == 2) {
                if (com.oplus.camera.filmvideomode.a_renamed.this.p_renamed) {
                    return;
                }
                com.oplus.camera.filmvideomode.a_renamed.this.h_renamed();
            } else {
                if (i_renamed != 3 || com.oplus.camera.filmvideomode.a_renamed.this.p_renamed || com.oplus.camera.filmvideomode.a_renamed.this.f4465a == null) {
                    return;
                }
                com.oplus.camera.filmvideomode.a_renamed.this.f4465a.c_renamed(message.arg1);
            }
        }
    };

    /* compiled from: BaseFilmUIControl.java */
    /* renamed from: com.oplus.camera.filmvideomode.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface BaseFilmUIControl_2 {
        android.graphics.Rect a_renamed();

        com.oplus.camera.e_renamed.h_renamed a_renamed(int i_renamed);
    }

    private java.lang.String b_renamed(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? i_renamed != 5 ? "" : com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_WB : com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_FOCUS : com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_EV : com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_SHUTTER : com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_ISO;
    }

    public void a_renamed() {
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        return false;
    }

    @Override // com.oplus.camera.filmvideomode.f_renamed.a_renamed
    public void b_renamed(android.view.View view, android.view.View view2, int i_renamed) {
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
    }

    public void c_renamed(boolean z_renamed) {
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
    }

    public void d_renamed(boolean z_renamed) {
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.a_renamed
    public void e_renamed(boolean z_renamed) {
    }

    public void j_renamed() {
    }

    public void k_renamed() {
    }

    public void l_renamed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
    }

    public void y_renamed() {
    }

    public a_renamed(android.app.Activity activity) {
        this.f4467c = null;
        this.f4467c = (com.oplus.camera.ui.RotateImageView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_mode_back);
        if (this.f4467c == null) {
            this.f4467c = (com.oplus.camera.ui.RotateImageView) activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.view_movie_mode_back, (android.view.ViewGroup) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera)).findViewById(com.oplus.camera.R_renamed.id_renamed.movie_mode_back);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (i_renamed() == null) {
            return;
        }
        boolean z3 = com.oplus.camera.util.Util.g_renamed() != this.y_renamed;
        this.y_renamed = com.oplus.camera.util.Util.g_renamed();
        if (this.f4465a == null || z3) {
            android.app.Activity activity = this.f4466b;
            com.oplus.camera.capmode.a_renamed aVar = this.d_renamed;
            this.f4465a = new com.oplus.camera.filmvideomode.k_renamed(activity, aVar, this, this.r_renamed.a_renamed(aVar.aw_renamed()));
            this.f4465a.setFilmParamsStateChangeListener(this);
            this.f4465a.setId(com.oplus.camera.R_renamed.id_renamed.movie_params_container_id);
            this.f4465a.setOnItemClickListener(this);
            this.f4465a.setStatisticDataWriter(this);
        }
        android.view.View viewFindViewById = this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_params_container_id);
        if (viewFindViewById == null) {
            this.n_renamed.addView(this.f4465a);
        } else if (z3) {
            this.n_renamed.removeView(viewFindViewById);
            this.n_renamed.addView(this.f4465a);
        }
        this.f4465a.setLayoutParams(z_renamed());
        this.f4465a.setVisibility(8);
        b_renamed(true);
        a_renamed(this.n_renamed, z3);
        this.z_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$a_renamed$DWeponS_FIz_4hJQLp9kz94h8Rc
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.F_renamed();
            }
        });
        if (this.j_renamed == null || z3) {
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.layout_film_switch_camera);
            if (relativeLayout != null) {
                this.n_renamed.removeView(relativeLayout);
            }
            a_renamed(this.n_renamed, z_renamed, z2);
        } else if (!A_renamed().equals(this.j_renamed.getSelectValue())) {
            this.j_renamed.setSelectValue(A_renamed());
            this.j_renamed.setSelectBg(A_renamed());
            b_renamed(A_renamed());
        }
        this.z_renamed.removeMessages(1);
        this.z_renamed.sendEmptyMessageDelayed(1, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F_renamed() throws android.content.res.Resources.NotFoundException {
        C_renamed();
        this.h_renamed.a_renamed(this.g_renamed, false, false);
    }

    private android.widget.RelativeLayout.LayoutParams z_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_slide_bar_container_height));
        if (com.oplus.camera.util.Util.u_renamed()) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = i_renamed().getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_params_left);
        } else {
            layoutParams.addRule(12);
            layoutParams.leftMargin = i_renamed().getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.movie_mode_params_left);
            layoutParams.rightMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_margin_right);
            layoutParams.bottomMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_bottom) + com.oplus.camera.util.Util.aG_renamed();
        }
        return layoutParams;
    }

    private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (i_renamed() == null) {
            return;
        }
        android.view.View view = this.g_renamed;
        if (view == null || z_renamed) {
            android.view.View view2 = (com.oplus.camera.filmvideomode.f_renamed) viewGroup.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_menu_id);
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
            this.g_renamed = new com.oplus.camera.filmvideomode.f_renamed(i_renamed());
            this.g_renamed.setId(com.oplus.camera.R_renamed.id_renamed.movie_menu_id);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if (com.oplus.camera.util.Util.u_renamed()) {
                layoutParams.addRule(14);
                layoutParams.topMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_margin_top) + (com.oplus.camera.util.Util.getScreenWidth() / 2);
            } else {
                layoutParams.addRule(10);
                layoutParams.topMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_margin_top);
                layoutParams.leftMargin = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_margin_left);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
            }
            int dimensionPixelSize = i_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_width);
            this.g_renamed.setMenuItemClickListener(this);
            a_renamed();
            int count = this.h_renamed.getCount();
            int dimensionPixelSize2 = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_item_move_x);
            if (count < 5) {
                dimensionPixelSize2 = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_item_move_20x);
            }
            if (com.oplus.camera.util.Util.u_renamed()) {
                dimensionPixelSize2 = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_menu_item_distance);
            }
            layoutParams.width = (dimensionPixelSize * count) + ((this.h_renamed.getCount() - 1) * dimensionPixelSize2);
            viewGroup.addView(this.g_renamed, layoutParams);
        } else if (viewGroup.indexOfChild(view) < 0) {
            viewGroup.addView(this.g_renamed);
        }
        this.g_renamed.setVisibility(8);
    }

    private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed, boolean z2) {
        if (this.f4466b == null || this.i_renamed == null) {
            return;
        }
        if (!z_renamed && !z2) {
            com.oplus.camera.e_renamed.f_renamed("BaseFilmUIControl", "No need to display the selection SwitchCameraBar");
            return;
        }
        if (com.oplus.camera.util.Util.u_renamed()) {
            this.j_renamed = (com.oplus.camera.ui.SwitchCameraBar) this.f4466b.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.switch_camera_layout_rack, viewGroup).findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
            this.j_renamed.setItemRotation(270);
        } else {
            this.j_renamed = (com.oplus.camera.ui.SwitchCameraBar) this.f4466b.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.switch_camera_layout, viewGroup).findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
        }
        this.j_renamed.a_renamed(A_renamed(), z_renamed, z2, s_renamed);
        this.j_renamed.setRotation(90.0f);
        this.j_renamed.setClickListener(new com.oplus.camera.ui.SwitchCameraBar.a_renamed() { // from class: com.oplus.camera.filmvideomode.a_renamed.2
            @Override // com.oplus.camera.ui.SwitchCameraBar.a_renamed
            public void a_renamed(java.lang.String str) {
                if (str.equals(com.oplus.camera.filmvideomode.a_renamed.this.A_renamed())) {
                    return;
                }
                com.oplus.camera.filmvideomode.a_renamed.this.b_renamed(false);
                com.oplus.camera.filmvideomode.a_renamed.this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, str).apply();
                com.oplus.camera.filmvideomode.a_renamed.this.a_renamed(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA);
                com.oplus.camera.filmvideomode.a_renamed.this.b_renamed(str);
                com.oplus.camera.filmvideomode.a_renamed.this.C_renamed();
                com.oplus.camera.filmvideomode.a_renamed.this.v_renamed();
            }

            @Override // com.oplus.camera.ui.SwitchCameraBar.a_renamed
            public boolean a_renamed() {
                return (com.oplus.camera.filmvideomode.a_renamed.this.d_renamed == null || com.oplus.camera.filmvideomode.a_renamed.this.d_renamed.R_renamed() || !com.oplus.camera.filmvideomode.a_renamed.this.d_renamed.ap_renamed() || com.oplus.camera.filmvideomode.a_renamed.this.d_renamed.g_renamed() != 1 || com.oplus.camera.filmvideomode.a_renamed.this.d_renamed.S_renamed() || com.oplus.camera.filmvideomode.a_renamed.this.f4465a == null || com.oplus.camera.filmvideomode.a_renamed.this.o_renamed || com.oplus.camera.filmvideomode.a_renamed.this.f4465a.a_renamed()) ? false : true;
            }
        });
        this.j_renamed.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String A_renamed() {
        if (this.i_renamed == null) {
            return "camera_main";
        }
        return this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) ? "camera_ultra_wide" : "camera_main");
    }

    protected boolean b_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_LOG, "off").equals("on_renamed");
    }

    protected boolean c_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").equals(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH);
    }

    protected boolean d_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HISTOGRAM, "off").equals("on_renamed");
    }

    protected boolean e_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid");
    }

    protected boolean f_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on_renamed").equals("on_renamed");
    }

    protected boolean g_renamed() {
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        return sharedPreferences != null && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_HDR, "off").equals("on_renamed");
    }

    public void h_renamed() {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.a_renamed(true);
            this.f4465a.d_renamed();
        }
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.d_renamed
    public void a_renamed(android.view.View view, android.view.View view2, int i_renamed, long j_renamed) throws java.lang.NumberFormatException {
        if (a_renamed(view2)) {
            com.oplus.camera.e_renamed.b_renamed("BaseFilmUIControl", "onItemClick, position: " + i_renamed + ", id_renamed: " + j_renamed);
            if (0 == j_renamed) {
                f_renamed(true);
            } else {
                this.f4465a.a_renamed(view, view2, i_renamed, j_renamed);
                a_renamed(b_renamed((int) j_renamed));
            }
        }
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.d_renamed
    public boolean a_renamed(android.view.View view) {
        com.oplus.camera.capmode.a_renamed aVar;
        return (this.f4465a == null || view == null || !view.isEnabled() || (aVar = this.d_renamed) == null || !aVar.aX_renamed()) ? false : true;
    }

    private void f_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar == null) {
            return;
        }
        dVar.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
        c_renamed(java.lang.Integer.valueOf("100").intValue(), true, z_renamed);
        long j_renamed = java.lang.Long.parseLong(this.f4466b.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        this.f_renamed.a_renamed(j_renamed);
        this.f_renamed.a_renamed(j_renamed, false);
        this.f_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
        this.f_renamed.i_renamed(false);
        if (z_renamed) {
            this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        a_renamed(true, 1);
        a_renamed(true, 2);
        a_renamed(true, 5);
        a_renamed(true, 4);
        this.f4466b.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.a_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.filmvideomode.a_renamed.this.f4465a.g_renamed();
            }
        });
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.setAFEnable(z_renamed);
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.a_renamed(i_renamed, z_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.setParamsBarEnable(z_renamed);
        }
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.d_renamed
    public void a_renamed(android.view.View view, android.view.View view2, int i_renamed) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar == null) {
            return;
        }
        kVar.a_renamed(true);
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.b_renamed
    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        a_renamed(z_renamed, str, i_renamed);
    }

    public void a_renamed(boolean z_renamed, java.lang.String str, int i_renamed) throws android.content.res.Resources.NotFoundException {
        a_renamed(z_renamed, str, i_renamed, true);
    }

    public void a_renamed(boolean z_renamed, java.lang.String str, int i_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (i_renamed == 1) {
            c_renamed(java.lang.Integer.parseInt(str), z_renamed, z2);
            c_renamed(3);
        } else if (i_renamed == 2) {
            a_renamed(java.lang.Long.parseLong(str), z_renamed, z2);
            c_renamed(3);
        } else if (i_renamed == 3) {
            b_renamed(java.lang.Integer.parseInt(str), z_renamed, z2);
        } else if (i_renamed == 4) {
            a_renamed(java.lang.Float.parseFloat(str), z_renamed, z2);
        } else if (i_renamed == 5) {
            a_renamed(java.lang.Integer.parseInt(str), z_renamed, z2);
        }
        c_renamed(0);
    }

    private void c_renamed(int i_renamed) {
        android.os.Message messageObtainMessage = this.z_renamed.obtainMessage(3);
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }

    private void B_renamed() {
        if (!com.oplus.camera.Camera.l_renamed) {
            this.f_renamed.b_renamed(c_renamed() ? com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH : "off");
        } else {
            this.f_renamed.b_renamed("off");
        }
    }

    private void c_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        if (this.f_renamed != null) {
            if (z_renamed) {
                B_renamed();
                this.f_renamed.b_renamed(-1, z2);
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "setISOValue, back ISOValue: " + i_renamed);
            k_renamed();
            this.f_renamed.b_renamed(i_renamed, z2);
        }
    }

    public void a_renamed(long j_renamed, boolean z_renamed, boolean z2) {
        if (this.f_renamed == null || i_renamed() == null) {
            return;
        }
        if (z_renamed) {
            B_renamed();
            this.f_renamed.a_renamed(java.lang.Long.valueOf(i_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue(), z2);
        } else {
            com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "setExposureTime, slow shutter");
            k_renamed();
            this.f_renamed.a_renamed(j_renamed, z2);
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar == null) {
            return;
        }
        if (z_renamed) {
            dVar.a_renamed(-1, false);
            this.f_renamed.i_renamed(z2);
        } else {
            try {
                dVar.a_renamed(i_renamed, z2);
            } catch (java.lang.NumberFormatException unused) {
                this.f_renamed.i_renamed(z2);
            }
        }
        com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "setWhiteBalance, whiteBalance: " + i_renamed);
    }

    public void a_renamed(float f_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.capmode.a_renamed aVar;
        com.oplus.camera.e_renamed.d_renamed dVar = this.f_renamed;
        if (dVar == null || (aVar = this.d_renamed) == null) {
            return;
        }
        if (z_renamed) {
            int iP = dVar.p_renamed();
            if (iP == 0) {
                this.t_renamed = false;
            }
            if (3 != iP || this.t_renamed) {
                this.f_renamed.a_renamed(3, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                if (z2) {
                    this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                    return;
                }
                return;
            }
            return;
        }
        aVar.ac_renamed();
        if (this.f_renamed != null) {
            if (this.d_renamed.z_renamed()) {
                this.d_renamed.b_renamed(false, false);
            }
            this.f_renamed.a_renamed(f_renamed, z2);
            this.t_renamed = true;
        }
    }

    public void b_renamed(int i_renamed, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.f_renamed == null || i_renamed() == null) {
            return;
        }
        if (z_renamed) {
            try {
                this.f_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed().getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)));
                if (z2) {
                    this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
                com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "setExposureCompensation, defaultValue: " + i_renamed);
                return;
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("BaseFilmUIControl", "setExposureCompensation, e_renamed: " + e_renamed);
                return;
            }
        }
        try {
            this.f_renamed.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed));
            if (z2) {
                this.f_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "setExposureCompensation, evValue: " + i_renamed);
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.f_renamed("BaseFilmUIControl", "setExposureCompensation, e_renamed: " + e2);
        }
    }

    public void a_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.c_renamed(i_renamed, z_renamed);
        }
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        com.oplus.camera.filmvideomode.k_renamed kVar;
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null || (kVar = this.f4465a) == null || kVar.getModeBarCount() == 0) {
            com.oplus.camera.e_renamed.f_renamed("BaseFilmUIControl", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (com.oplus.camera.util.Util.C_renamed()) {
            key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
        } else {
            key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
        }
        java.lang.Integer num = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY);
        java.lang.Long l_renamed = (java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME);
        int iValueOf = 0;
        java.lang.Float f_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE);
        if (key != null) {
            try {
                iValueOf = java.lang.Integer.valueOf(((int[]) captureResult.get(key))[0]);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        com.oplus.camera.filmvideomode.FilmParam filmParam = new com.oplus.camera.filmvideomode.FilmParam(iValueOf, num, l_renamed, f_renamed);
        android.os.Handler handler = this.z_renamed;
        if (handler != null) {
            handler.removeMessages(0);
            this.z_renamed.obtainMessage(0, filmParam).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.filmvideomode.FilmParam filmParam) {
        this.u_renamed = java.lang.String.valueOf(filmParam.getCct());
        this.v_renamed = java.lang.String.valueOf(filmParam.getIso());
        this.w_renamed = java.lang.String.valueOf(filmParam.getExp());
        this.x_renamed = java.lang.String.valueOf(filmParam.getEv());
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar == null) {
            return;
        }
        kVar.a_renamed(filmParam.getIso());
        this.f4465a.a_renamed(filmParam.getExp());
        this.f4465a.b_renamed(filmParam.getCct());
        this.f4465a.a_renamed(filmParam.getEv());
    }

    public android.content.Context i_renamed() {
        android.app.Activity activity = this.f4466b;
        if (activity == null) {
            return null;
        }
        return activity;
    }

    public void m_renamed() {
        this.o_renamed = true;
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.h_renamed();
        }
    }

    public void n_renamed() {
        this.o_renamed = false;
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.i_renamed();
        }
    }

    public void o_renamed() {
        com.oplus.camera.ui.control.ThumbImageView thumbImageView;
        if (i_renamed() == null) {
            return;
        }
        this.p_renamed = false;
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.setLayoutParams(z_renamed());
        }
        if (this.m_renamed != null) {
            android.animation.ObjectAnimator.ofFloat(this.m_renamed, "translationY", com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.filmvideomode.b_renamed.a_renamed(i_renamed().getResources())).setDuration(0L).start();
        }
        b_renamed(true);
        if (com.oplus.camera.util.Util.u_renamed() || (thumbImageView = this.l_renamed) == null) {
            return;
        }
        a_renamed(thumbImageView);
    }

    private void a_renamed(com.oplus.camera.ui.control.ThumbImageView thumbImageView) {
        com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "resumeThumb, thumbImageView: " + thumbImageView + ", mActivity: " + this.f4466b);
        android.app.Activity activity = this.f4466b;
        if (activity != null) {
            android.content.res.Resources resources = activity.getResources();
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_width);
            layoutParams.height = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_height);
            layoutParams.topMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_top);
            layoutParams.leftMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_left);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
            }
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            thumbImageView.setLayoutParams(layoutParams);
            thumbImageView.setPadding(0, 0, 0, 0);
            thumbImageView.setRotation(90.0f);
        }
    }

    public void p_renamed() {
        this.p_renamed = true;
        if (this.f4465a != null) {
            a_renamed((android.view.View) null, (android.view.View) null, this.e_renamed);
            this.f4465a.d_renamed();
        }
        android.os.Handler handler = this.z_renamed;
        if (handler == null || !handler.hasMessages(1)) {
            return;
        }
        j_renamed();
    }

    public void q_renamed() {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar == null || kVar.a_renamed()) {
            return;
        }
        h_renamed();
    }

    public void r_renamed() {
        this.f4465a.c_renamed(4, true);
    }

    public void s_renamed() {
        android.os.Handler handler = this.z_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.z_renamed = null;
        }
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.setOnItemClickListener(null);
            this.f4465a.setStatisticDataWriter(null);
        }
        this.f4466b = null;
        this.i_renamed = null;
        this.d_renamed = null;
        this.f_renamed = null;
    }

    public void t_renamed() {
        if (this.i_renamed == null || this.f4466b == null) {
            return;
        }
        b_renamed(true);
        java.lang.String string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, "auto");
        java.lang.String string2 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto");
        java.lang.String string3 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto");
        java.lang.String string4 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
        java.lang.String string5 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE, null);
        com.oplus.camera.e_renamed.b_renamed("BaseFilmUIControl", "onBeforeStartPreview, iso: " + string + ", shutter: " + string2 + ", wb: " + string3 + ", af_renamed: " + string4 + ", ev_renamed: " + string5);
        if (!"auto".equals(string)) {
            a_renamed(false, string, 1, false);
        } else {
            a_renamed(true, "0", 1, false);
        }
        if (!"auto".equals(string2)) {
            a_renamed(false, string2, 2, false);
        } else {
            a_renamed(true, "0", 2, false);
        }
        if (!"auto".equals(string3)) {
            a_renamed(false, string3, 5, false);
        } else {
            a_renamed(true, "0", 5, false);
        }
        if (!"auto".equals(string4)) {
            a_renamed(false, string4, 4, false);
        } else {
            a_renamed(true, "0", 4, false);
        }
        if (string5 != null) {
            a_renamed(false, string5, 3, false);
        } else {
            a_renamed(true, "0", 3, false);
        }
    }

    public void u_renamed() {
        java.lang.String string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
        if (!"auto".equals(string)) {
            a_renamed(false, string, 4);
        } else {
            a_renamed(true, "0", 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C_renamed() {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.a_renamed(this.r_renamed.a_renamed(this.d_renamed.aw_renamed()));
        }
    }

    public void v_renamed() {
        a_renamed(true, 4);
        a_renamed(true, 2);
        a_renamed(true, 1);
        a_renamed(true, 5);
    }

    public void w_renamed() {
        if (this.i_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "resetFilmModeParams");
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_SHOW_UI_DEFAULT).apply();
        this.i_renamed.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA_BAR).apply();
        a_renamed(true, "0", 1);
        a_renamed(true, "0", 2);
        a_renamed(true, "0", 5);
        a_renamed(true, "0", 4);
        a_renamed(true, "0", 3);
    }

    public com.oplus.camera.statistics.model.DcsMsgData a_renamed(com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData) {
        com.oplus.camera.capmode.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            videoRecordMsgData.mCameraId = aVar.aw_renamed();
            videoRecordMsgData.mTouchXYValue = android.text.TextUtils.isEmpty(this.d_renamed.af_renamed()) ? "0x0" : this.d_renamed.af_renamed();
        }
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        if (sharedPreferences != null) {
            java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
            videoRecordMsgData.mFlashTrigger = com.oplus.camera.a_renamed.a_renamed.a_renamed(string);
            videoRecordMsgData.mFlashMode = string;
            videoRecordMsgData.mMovieCameraId = A_renamed();
            videoRecordMsgData.mVideoMode = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "");
            videoRecordMsgData.mMovieSteady = f_renamed() ? "on_renamed" : "off";
            java.lang.String string2 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, "auto");
            java.lang.String string3 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto");
            java.lang.String string4 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto");
            java.lang.String string5 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto");
            java.lang.String string6 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "auto");
            videoRecordMsgData.mMovieExpTime = a_renamed(2, string3, "auto");
            videoRecordMsgData.mMovieIsoValue = a_renamed(1, string2, "auto");
            videoRecordMsgData.mMovieFocusValue = b_renamed(4, string5, "auto");
            videoRecordMsgData.mMovieEvValue = b_renamed(3, string6, "0");
            videoRecordMsgData.mMovieWbValue = a_renamed(5, string4, "auto");
            videoRecordMsgData.mCct = a_renamed(5, string4, this.u_renamed);
            videoRecordMsgData.mIso = a_renamed(1, string2, this.v_renamed);
            videoRecordMsgData.mExp = a_renamed(2, string3, this.w_renamed);
            videoRecordMsgData.mTouchEVValue = a_renamed(3, string6, this.x_renamed);
        }
        videoRecordMsgData.mIsAssistantLine = java.lang.Boolean.toString(e_renamed());
        return videoRecordMsgData;
    }

    private java.lang.String a_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        return kVar == null ? str2 : kVar.a_renamed(i_renamed, str, str2);
    }

    private java.lang.String b_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        return kVar == null ? str2 : kVar.b_renamed(i_renamed, str, str2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    protected void a_renamed(java.lang.String str) {
        if (this.f4466b == null) {
            return;
        }
        com.oplus.camera.statistics.model.FilmModeMsgData filmModeMsgData = new com.oplus.camera.statistics.model.FilmModeMsgData(i_renamed());
        filmModeMsgData.buildEventId("funcValue_select");
        filmModeMsgData.mFuncKeyId = str;
        com.oplus.camera.capmode.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            filmModeMsgData.mCameraId = aVar.aw_renamed();
        }
        android.content.SharedPreferences sharedPreferences = this.i_renamed;
        if (sharedPreferences != null) {
            filmModeMsgData.mCaptureMode = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "");
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != 51) {
                if (iHashCode != 1636) {
                    if (iHashCode != 1638) {
                        if (iHashCode != 1699) {
                            switch (iHashCode) {
                                case 1660:
                                    if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_SHUTTER)) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 1661:
                                    if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_WB)) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case 1662:
                                    if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_FOCUS)) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case 1663:
                                    if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_EV)) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case 1664:
                                    if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_ISO)) {
                                        c2 = '\b_renamed';
                                        break;
                                    }
                                    break;
                            }
                        } else if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_HISTOGRAM)) {
                            c2 = 2;
                        }
                    } else if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_SWITCH_CAMERA)) {
                        c2 = 0;
                    }
                } else if (str.equals(com.oplus.camera.statistics.model.FilmModeMsgData.FUNC_KEY_ID_GRID)) {
                    c2 = 3;
                }
            } else if (str.equals("3")) {
                c2 = 1;
            }
            switch (c2) {
                case 0:
                    filmModeMsgData.mFuncKeyValue = A_renamed();
                    break;
                case 1:
                    filmModeMsgData.mFuncKeyValue = c_renamed() ? com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH : "off";
                    break;
                case 2:
                    filmModeMsgData.mFuncKeyValue = d_renamed() ? "on_renamed" : "off";
                    break;
                case 3:
                    filmModeMsgData.mFuncKeyValue = e_renamed() ? "on_renamed" : "off";
                    break;
                case 4:
                    filmModeMsgData.mFuncKeyValue = a_renamed(2, this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, "auto"), "0");
                    break;
                case 5:
                    filmModeMsgData.mFuncKeyValue = a_renamed(5, this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "auto"), "auto");
                    break;
                case 6:
                    filmModeMsgData.mFuncKeyValue = b_renamed(4, this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "auto"), "auto");
                    break;
                case 7:
                    filmModeMsgData.mFuncKeyValue = b_renamed(3, this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "auto"), "0");
                    break;
                case '\b_renamed':
                    filmModeMsgData.mFuncKeyValue = a_renamed(1, this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, "auto"), "auto");
                    break;
            }
        }
        filmModeMsgData.report();
    }

    public boolean a_renamed(int i_renamed, int i2, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        android.app.Activity activity = this.f4466b;
        if (activity == null || this.p_renamed) {
            return false;
        }
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_width) / 2;
        int bottom = this.g_renamed.getBottom() + dimensionPixelSize;
        int iU = com.oplus.camera.util.Util.U_renamed();
        int dimensionPixelSize2 = this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.switch_camera_bar_margin_left);
        int screenWidth = com.oplus.camera.util.Util.getScreenWidth() - this.f4466b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_margin_top);
        android.graphics.Rect rect = new android.graphics.Rect();
        com.oplus.camera.ui.control.MainShutterButton mainShutterButton = this.m_renamed;
        if (mainShutterButton != null) {
            mainShutterButton.getGlobalVisibleRect(rect);
            iU = rect.top;
            rect.top -= dimensionPixelSize;
        }
        this.q_renamed.set(dimensionPixelSize2, bottom, screenWidth, iU);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        com.oplus.camera.filmvideomode.k_renamed kVar = this.f4465a;
        if (kVar != null) {
            kVar.a_renamed(rect2);
            rect2.top -= dimensionPixelSize;
        }
        android.graphics.Rect rect3 = new android.graphics.Rect();
        com.oplus.camera.ui.SwitchCameraBar switchCameraBar = this.j_renamed;
        if (switchCameraBar != null) {
            float width = (switchCameraBar.getWidth() / 2) - (this.j_renamed.getHeight() / 2);
            rect3.left = (int) (this.j_renamed.getX() + width);
            rect3.top = ((int) (this.j_renamed.getY() - width)) - dimensionPixelSize;
            rect3.right = rect3.left + this.j_renamed.getHeight() + dimensionPixelSize;
            rect3.bottom = ((int) (this.j_renamed.getY() - width)) + this.j_renamed.getWidth() + dimensionPixelSize;
        }
        if (z_renamed) {
            rect3.top -= this.k_renamed.getIntrinsicHeight();
        }
        android.graphics.Rect rect4 = new android.graphics.Rect();
        com.oplus.camera.ui.control.ThumbImageView thumbImageView = this.l_renamed;
        if (thumbImageView != null) {
            rect4.left = (int) thumbImageView.getX();
            rect4.top = ((int) this.l_renamed.getY()) - dimensionPixelSize;
            rect4.right = (this.l_renamed.getRight() + dimensionPixelSize) - this.l_renamed.getPaddingRight();
            rect4.bottom = this.l_renamed.getBottom() + dimensionPixelSize;
        }
        return (!this.q_renamed.contains(i_renamed, i2) || rect.contains(i_renamed, i2) || rect3.contains(i_renamed, i2) || rect4.contains(i_renamed, i2) || rect2.contains(i_renamed, i2)) ? false : true;
    }

    public void x_renamed() {
        com.oplus.camera.e_renamed.a_renamed("BaseFilmUIControl", "restoreDefaultMode, Restore UI");
        if (this.f4466b == null || this.f4465a == null || this.h_renamed == null) {
            return;
        }
        C_renamed();
        if (this instanceof com.oplus.camera.filmvideomode.p_renamed) {
            this.h_renamed.getItem(2).a_renamed(true);
        } else if (this instanceof com.oplus.camera.filmvideomode.q_renamed) {
            for (com.oplus.camera.filmvideomode.g_renamed gVar : this.h_renamed.a_renamed()) {
                if (4 == gVar.b_renamed()) {
                    gVar.a_renamed(true);
                }
            }
        }
        this.h_renamed.a_renamed(this.g_renamed, false, false);
        this.f4465a.e_renamed();
        if (this.j_renamed != null && !A_renamed().equals(this.j_renamed.getSelectValue())) {
            this.j_renamed.setSelectValue(A_renamed());
            this.j_renamed.setSelectBg(A_renamed());
        }
        b_renamed(A_renamed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(java.lang.String str) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOVIE_ULTRA_WIDE_FLASH_EIS_SUPPORT)) {
            return;
        }
        if ("camera_ultra_wide".equals(str)) {
            D_renamed();
        } else {
            E_renamed();
        }
    }

    private void D_renamed() {
        java.lang.String string = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off");
        java.lang.String string2 = this.i_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "on_renamed");
        this.i_renamed.edit().putString("pref_film_flash_mode_key", string).apply();
        this.i_renamed.edit().putString("pref_film_eis_mode_key", string2).apply();
        this.i_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, false).apply();
        b_renamed(false, false);
        c_renamed(false, false);
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, "off").apply();
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, "off").apply();
    }

    private void E_renamed() {
        java.lang.String string = this.i_renamed.getString("pref_film_flash_mode_key", "off");
        java.lang.String string2 = this.i_renamed.getString("pref_film_eis_mode_key", "on_renamed");
        this.i_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, true).apply();
        b_renamed(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH.equals(string), true);
        c_renamed("on_renamed".equals(string2), true);
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_MOVIE_FLASH_MODE, string).apply();
        this.i_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_MENU, string2).apply();
    }

    public void a_renamed(com.oplus.camera.filmvideomode.a_renamed.BaseFilmUIControl_2 interfaceC0099a) {
        this.r_renamed = interfaceC0099a;
    }

    @Override // com.oplus.camera.filmvideomode.k_renamed.c_renamed
    public void a_renamed(int i_renamed) {
        a_renamed(b_renamed(i_renamed));
    }
}
