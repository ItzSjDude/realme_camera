package com.oplus.camera.ui.menu.shareedit;

/* compiled from: ShareEditThumbMenu.java */
/* loaded from: classes2.dex */
public class a_renamed implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, android.view.View.OnClickListener, android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.PathInterpolator f6682a = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.view.animation.PathInterpolator f6683b = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private android.widget.RelativeLayout Q_renamed;
    private com.oplus.camera.ui.control.ThumbImageView W_renamed;
    private com.oplus.camera.ui.control.a_renamed Y_renamed;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.b_renamed aD_renamed;
    private com.oplus.camera.ui.CameraUIListener aE_renamed;
    private boolean aI_renamed;
    private android.animation.ValueAnimator aM_renamed;
    private android.animation.ValueAnimator aN_renamed;
    private boolean ab_renamed;
    private boolean ac_renamed;
    private com.oplus.camera.Camera ar_renamed;
    private com.oplus.camera.ui.menu.shareedit.b_renamed at_renamed;
    private android.os.Handler au_renamed;
    private com.oplus.camera.ui.control.e_renamed av_renamed;
    private android.view.animation.Interpolator aw_renamed;
    private com.oplus.camera.ComboPreferences ax_renamed;
    private android.content.SharedPreferences ay_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6684c = 1;
    private int d_renamed = 1;
    private float e_renamed = 0.0f;
    private float f_renamed = 0.0f;
    private float g_renamed = 0.0f;
    private float h_renamed = 0.0f;
    private float i_renamed = 0.0f;
    private float j_renamed = 0.0f;
    private float k_renamed = 0.0f;
    private float l_renamed = 0.0f;
    private float m_renamed = 0.0f;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private int t_renamed = 0;
    private int u_renamed = 0;
    private int v_renamed = 0;
    private int w_renamed = 0;
    private int x_renamed = 0;
    private int y_renamed = 0;
    private int z_renamed = 0;
    private int A_renamed = 0;
    private int B_renamed = 0;
    private float C_renamed = 0.0f;
    private float D_renamed = 0.0f;
    private float E_renamed = 0.0f;
    private float F_renamed = 0.0f;
    private float G_renamed = 0.0f;
    private android.widget.RelativeLayout.LayoutParams H_renamed = null;
    private android.widget.RelativeLayout.LayoutParams I_renamed = null;
    private android.widget.RelativeLayout.LayoutParams J_renamed = null;
    private android.widget.RelativeLayout.LayoutParams K_renamed = null;
    private android.widget.RelativeLayout.LayoutParams L_renamed = null;
    private float M_renamed = 0.0f;
    private float N_renamed = 0.0f;
    private float O_renamed = 0.0f;
    private float P_renamed = 0.0f;
    private android.widget.PopupWindow R_renamed = null;
    private com.oplus.camera.ui.menu.shareedit.ShareArrowImageView S_renamed = null;
    private com.oplus.camera.ui.RotateImageView T_renamed = null;
    private com.oplus.camera.ui.RotateImageView U_renamed = null;
    private com.oplus.camera.ui.RotateImageView V_renamed = null;
    private com.oplus.camera.ui.control.ThumbImageView X_renamed = null;
    private boolean Z_renamed = false;
    private boolean aa_renamed = false;
    private boolean ad_renamed = false;
    private boolean ae_renamed = false;
    private boolean af_renamed = false;
    private boolean ag_renamed = false;
    private boolean ah_renamed = false;
    private boolean ai_renamed = false;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 aj_renamed = null;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 ak_renamed = null;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 al_renamed = null;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 am_renamed = null;
    private com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 an_renamed = null;
    private android.graphics.drawable.GradientDrawable ao_renamed = null;
    private float ap_renamed = p_renamed();
    private float aq_renamed = this.i_renamed;
    private long as_renamed = 0;
    private boolean az_renamed = false;
    private boolean[] aA_renamed = {false, false, false, false};
    private int[] aB_renamed = {com.oplus.camera.R_renamed.id_renamed.thumbnail, com.oplus.camera.R_renamed.id_renamed.share, com.oplus.camera.R_renamed.id_renamed.edit, com.oplus.camera.R_renamed.id_renamed.soloop};
    private android.view.View[] aC_renamed = null;
    private boolean aF_renamed = false;
    private boolean aG_renamed = true;
    private boolean aH_renamed = false;
    private boolean aJ_renamed = false;
    private boolean aK_renamed = false;
    private float aL_renamed = 0.0f;

    /* compiled from: ShareEditThumbMenu.java */
    public interface b_renamed {
        void a_renamed();
    }

    private int a_renamed(int i_renamed) {
        return com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(i_renamed);
    }

    private void n_renamed() {
        this.v_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.thumbnail_width_nomal);
        this.x_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.share_icon_margin_bottom);
        this.w_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.thumb_margin_bottom);
        this.y_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.share_button_width);
        this.z_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.arrow_total_size);
        int i_renamed = this.w_renamed;
        int i2 = this.v_renamed;
        int i3 = this.y_renamed;
        int i4 = this.x_renamed;
        this.f_renamed = (i_renamed * 2) + i2 + i3 + i4;
        this.g_renamed = (i_renamed * 2) + i2 + (i3 * 2) + (i4 * 3);
        this.h_renamed = (i_renamed * 2) + i2 + (i3 * 3) + (i4 * 5);
        this.e_renamed = this.h_renamed + i3 + i4;
        this.i_renamed = i2 + i_renamed + this.z_renamed;
        this.j_renamed = i_renamed + i2;
        this.k_renamed = 0.0f;
        this.l_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.arrow_anim_height);
        this.m_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.arrow_anim_offset);
        int i5 = this.w_renamed;
        this.n_renamed = i5;
        int i6 = this.x_renamed;
        int i7 = this.v_renamed;
        int i8 = this.y_renamed;
        this.o_renamed = (i6 * 3) + i7 + i5 + (i8 * 2);
        this.p_renamed = i5;
        this.q_renamed = (i6 * 2) + i7 + i5 + i8;
        this.r_renamed = i5;
        this.s_renamed = i6 + i7 + i5;
        this.t_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.share_button_width);
        this.A_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.share_anim_up_region);
        this.B_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.share_anim_down_region);
        this.u_renamed = this.v_renamed + (this.w_renamed * 2);
    }

    private void o_renamed() {
        this.R_renamed = new android.widget.PopupWindow(this.Q_renamed, this.u_renamed, (int) this.e_renamed);
        this.R_renamed.setSplitTouchEnabled(false);
        this.Q_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.share_and_edit_layout_background_drawable);
        android.widget.RelativeLayout relativeLayout = this.Q_renamed;
        relativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.u_renamed, relativeLayout.getMeasuredHeight()));
        this.H_renamed = (android.widget.RelativeLayout.LayoutParams) this.Q_renamed.getLayoutParams();
        this.ao_renamed = (android.graphics.drawable.GradientDrawable) this.Q_renamed.getBackground();
        this.ao_renamed.setCornerRadius(this.u_renamed / 2);
        this.F_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.thumbnail_margin_start) - ((((this.u_renamed - this.v_renamed) - this.W_renamed.getPaddingLeft()) - this.W_renamed.getPaddingRight()) / 2);
        this.G_renamed = (((a_renamed(com.oplus.camera.R_renamed.dimen.control_panel_button_height) - this.v_renamed) / 2) - this.w_renamed) + ((com.oplus.camera.util.Util.O_renamed() - com.oplus.camera.util.Util.P_renamed()) - a_renamed(com.oplus.camera.R_renamed.dimen.control_panel_margin_top)) + a_renamed(com.oplus.camera.R_renamed.dimen.thumbnail_margin_top_offset);
        if (com.oplus.camera.util.Util.t_renamed()) {
            this.G_renamed = ((a_renamed(com.oplus.camera.R_renamed.dimen.control_panel_button_height) - this.v_renamed) / 2) + this.w_renamed + ((com.oplus.camera.util.Util.O_renamed() - com.oplus.camera.util.Util.P_renamed()) - a_renamed(com.oplus.camera.R_renamed.dimen.control_panel_margin_top));
        }
        this.R_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.aE_renamed != null) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.aE_renamed.i_renamed(true);
                    }
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.aF_renamed = (aVar.Y_renamed == null || com.oplus.camera.ui.menu.shareedit.a_renamed.this.Y_renamed.ap_renamed() || (com.oplus.camera.ui.menu.shareedit.a_renamed.this.e_renamed - motionEvent.getY() >= ((float) com.oplus.camera.ui.menu.shareedit.a_renamed.this.v_renamed) && (!com.oplus.camera.ui.menu.shareedit.a_renamed.this.D_renamed() || com.oplus.camera.ui.menu.shareedit.a_renamed.this.e_renamed - motionEvent.getY() >= ((float) com.oplus.camera.ui.menu.shareedit.a_renamed.this.H_renamed.height)))) ? false : true;
                }
                if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.aF_renamed && com.oplus.camera.ui.menu.shareedit.a_renamed.this.aG_renamed) {
                    return false;
                }
                motionEvent.setLocation(com.oplus.camera.ui.menu.shareedit.a_renamed.this.aI_renamed ? motionEvent.getRawX() : motionEvent.getX() + com.oplus.camera.ui.menu.shareedit.a_renamed.this.F_renamed, ((motionEvent.getY() + com.oplus.camera.util.Util.getScreenHeight()) - com.oplus.camera.ui.menu.shareedit.a_renamed.this.G_renamed) - com.oplus.camera.ui.menu.shareedit.a_renamed.this.e_renamed);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.ar_renamed.dispatchTouchEvent(motionEvent);
                return true;
            }
        });
        this.S_renamed = (com.oplus.camera.ui.menu.shareedit.ShareArrowImageView) this.Y_renamed.aq_renamed().findViewById(com.oplus.camera.R_renamed.id_renamed.up_arrow);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.ar_renamed, this.S_renamed);
        this.T_renamed = (com.oplus.camera.ui.RotateImageView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.share);
        this.U_renamed = (com.oplus.camera.ui.RotateImageView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.edit);
        this.V_renamed = (com.oplus.camera.ui.RotateImageView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.soloop);
        this.X_renamed = (com.oplus.camera.ui.control.ThumbImageView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.popup_thumbnail);
        this.aC_renamed = new android.view.View[4];
        android.view.View[] viewArr = this.aC_renamed;
        viewArr[0] = this.W_renamed;
        viewArr[1] = this.T_renamed;
        viewArr[2] = this.U_renamed;
        viewArr[3] = this.V_renamed;
        this.Q_renamed.setOnTouchListener(this);
        this.S_renamed.setOnTouchListener(this);
        this.U_renamed.setOnTouchListener(this);
        this.T_renamed.setOnTouchListener(this);
        this.V_renamed.setOnTouchListener(this);
        this.T_renamed.setOnClickListener(this);
        this.U_renamed.setOnClickListener(this);
        this.V_renamed.setOnClickListener(this);
        this.X_renamed.setOnClickListener(this);
        this.I_renamed = (android.widget.RelativeLayout.LayoutParams) this.S_renamed.getLayoutParams();
        this.J_renamed = (android.widget.RelativeLayout.LayoutParams) this.U_renamed.getLayoutParams();
        this.K_renamed = (android.widget.RelativeLayout.LayoutParams) this.T_renamed.getLayoutParams();
        this.L_renamed = (android.widget.RelativeLayout.LayoutParams) this.V_renamed.getLayoutParams();
        this.W_renamed.setOnTouchListener(this);
        this.X_renamed.setOnTouchListener(this);
    }

    public a_renamed(android.widget.RelativeLayout relativeLayout, com.oplus.camera.ui.control.a_renamed aVar, android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.menu.shareedit.a_renamed.b_renamed bVar, com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.ui.control.ThumbImageView thumbImageView) {
        this.Q_renamed = null;
        this.W_renamed = null;
        this.Y_renamed = null;
        this.ab_renamed = false;
        this.ac_renamed = false;
        this.ar_renamed = null;
        this.at_renamed = null;
        this.au_renamed = null;
        this.av_renamed = null;
        this.aw_renamed = null;
        this.ax_renamed = null;
        this.ay_renamed = null;
        this.aD_renamed = null;
        this.aE_renamed = null;
        this.aI_renamed = false;
        this.Q_renamed = relativeLayout;
        this.aD_renamed = bVar;
        this.aE_renamed = cameraUIListener;
        this.W_renamed = thumbImageView;
        this.ax_renamed = comboPreferences;
        this.ay_renamed = com.oplus.camera.util.Util.l_renamed().getSharedPreferences("soloop_info", 0);
        this.ay_renamed.registerOnSharedPreferenceChangeListener(this);
        this.Y_renamed = aVar;
        this.ar_renamed = (com.oplus.camera.Camera) activity;
        this.av_renamed = this.Y_renamed.t_renamed();
        com.oplus.camera.ui.control.e_renamed eVar = this.av_renamed;
        this.ab_renamed = eVar != null && com.oplus.camera.util.Util.a_renamed(eVar.e_renamed());
        this.ac_renamed = this.av_renamed != null && l_renamed();
        this.aI_renamed = 1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault());
        n_renamed();
        o_renamed();
        this.at_renamed = new com.oplus.camera.ui.menu.shareedit.b_renamed(6.0f, 2.0f);
        this.aw_renamed = new android.view.animation.PathInterpolator(0.66f, 0.0f, 0.34f, 1.0f);
        this.au_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.8
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 2) {
                    return;
                }
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.az_renamed = true;
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.a_renamed(true, true);
            }
        };
        a_renamed(true, true);
    }

    public void a_renamed() {
        android.os.Handler handler = this.au_renamed;
        if (handler != null) {
            handler.removeMessages(2);
        }
        android.widget.PopupWindow popupWindow = this.R_renamed;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.R_renamed.dismiss();
        }
        C_renamed();
    }

    public void b_renamed() {
        com.oplus.camera.Camera camera = this.ar_renamed;
        if (camera == null || camera.isFinishing()) {
            return;
        }
        this.R_renamed.showAtLocation((android.widget.RelativeLayout) this.ar_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera), (this.aI_renamed ? 8388613 : 8388611) | 80, (int) this.F_renamed, (int) this.G_renamed);
    }

    private float p_renamed() {
        if (this.ab_renamed && this.ac_renamed) {
            return this.h_renamed;
        }
        if (this.ab_renamed || this.ac_renamed) {
            return this.g_renamed;
        }
        return this.f_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.T_renamed.a_renamed(i_renamed, z_renamed);
        this.U_renamed.a_renamed(i_renamed, z_renamed);
        this.V_renamed.a_renamed(i_renamed, z_renamed);
        this.X_renamed.a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        this.av_renamed = eVar;
        k_renamed();
    }

    public void b_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        this.ad_renamed = true;
        c_renamed(eVar);
        d_renamed(eVar);
        if (t_renamed() && this.W_renamed.getVisibility() == 0) {
            c_renamed(this.i_renamed);
            c_renamed(1);
            com.oplus.camera.ComboPreferences comboPreferences = this.ax_renamed;
            if (comboPreferences != null && eVar != null && comboPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, true) && M_renamed()) {
                this.ax_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                if (!com.oplus.camera.util.Util.a_renamed(eVar.e_renamed())) {
                    A_renamed();
                    this.ae_renamed = true;
                    return;
                } else {
                    B_renamed();
                    this.af_renamed = true;
                    return;
                }
            }
            if (this.aG_renamed) {
                q_renamed();
            } else {
                this.aH_renamed = true;
            }
            this.T_renamed.setVisibility(4);
            this.U_renamed.setVisibility(4);
            this.V_renamed.setVisibility(4);
            a_renamed(this.J_renamed, this.U_renamed, this.p_renamed);
            a_renamed(this.K_renamed, this.T_renamed, this.r_renamed);
            a_renamed(this.L_renamed, this.V_renamed, this.n_renamed);
            E_renamed();
            this.U_renamed.clearAnimation();
            this.T_renamed.clearAnimation();
            this.V_renamed.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ShareEditThumbMenu", "setBgAlpha: " + this.ao_renamed.getAlpha() + " to -> :" + i_renamed);
        this.ao_renamed.setAlpha(i_renamed);
    }

    public void c_renamed() {
        if (this.aH_renamed) {
            this.aH_renamed = false;
            q_renamed();
        }
    }

    private void q_renamed() {
        b_renamed(255);
        c_renamed(this.i_renamed);
        z_renamed();
    }

    private void c_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        this.av_renamed = eVar;
        com.oplus.camera.ui.control.e_renamed eVar2 = this.av_renamed;
        if (eVar2 == null) {
            return;
        }
        this.ab_renamed = com.oplus.camera.util.Util.a_renamed(eVar2.e_renamed());
        this.ap_renamed = p_renamed();
    }

    private void d_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        this.av_renamed = eVar;
        if (this.av_renamed == null) {
            return;
        }
        this.ac_renamed = l_renamed();
        this.ap_renamed = p_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ShareEditThumbMenu", "setState: " + this.f6684c + " to -> :" + i_renamed);
        this.f6684c = i_renamed;
    }

    public void d_renamed() {
        c_renamed(this.i_renamed);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        this.ad_renamed = true;
        k_renamed();
        this.Q_renamed.clearAnimation();
        this.V_renamed.clearAnimation();
        this.U_renamed.clearAnimation();
        this.T_renamed.clearAnimation();
        android.os.Handler handler = this.au_renamed;
        if (handler != null) {
            handler.removeMessages(2);
        }
        if (z_renamed && this.ao_renamed.getAlpha() != 0) {
            C_renamed();
            r_renamed();
        } else {
            d_renamed(z2);
            a_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(boolean z_renamed) {
        c_renamed(0);
        C_renamed();
        b_renamed(0);
        this.V_renamed.setVisibility(4);
        this.T_renamed.setVisibility(4);
        this.U_renamed.setVisibility(4);
        a_renamed(this.L_renamed, this.V_renamed, this.n_renamed);
        a_renamed(this.J_renamed, this.U_renamed, this.p_renamed);
        a_renamed(this.K_renamed, this.T_renamed, this.r_renamed);
        if (z_renamed) {
            d_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a_renamed(float f_renamed) {
        float f2 = this.C_renamed;
        return f2 + ((this.D_renamed - f2) * f_renamed);
    }

    private void r_renamed() {
        this.C_renamed = this.H_renamed.height;
        this.D_renamed = this.i_renamed;
        c_renamed(5);
        this.aC_renamed[0] = this.W_renamed;
        android.widget.PopupWindow popupWindow = this.R_renamed;
        if (popupWindow == null || !popupWindow.isShowing()) {
            if (5 == this.f6684c) {
                d_renamed(true);
            }
        } else {
            this.E_renamed = this.T_renamed.getAlpha();
            this.an_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.9

                /* renamed from: a_renamed, reason: collision with root package name */
                float f6700a = 0.0f;

                /* renamed from: b_renamed, reason: collision with root package name */
                float f6701b = 0.0f;

                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.c_renamed(aVar.a_renamed(f_renamed));
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.b_renamed((int) ((1.0f - f_renamed) * 255.0f));
                    this.f6700a = com.oplus.camera.ui.menu.shareedit.a_renamed.this.E_renamed + ((this.f6701b - com.oplus.camera.ui.menu.shareedit.a_renamed.this.E_renamed) * f_renamed);
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.U_renamed.setImageAlpha((int) (this.f6700a * 255.0f));
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.T_renamed.setImageAlpha((int) (this.f6700a * 255.0f));
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.V_renamed.setImageAlpha((int) (this.f6700a * 255.0f));
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar2 = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar2.a_renamed(aVar2.J_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.U_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.q_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.p_renamed, f_renamed, false);
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar3 = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar3.a_renamed(aVar3.K_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.T_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.s_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.r_renamed, f_renamed, false);
                    if (!com.oplus.camera.ui.menu.shareedit.a_renamed.this.ab_renamed) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed aVar4 = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                        aVar4.a_renamed(aVar4.L_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.V_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.q_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.p_renamed, f_renamed, false);
                    } else {
                        com.oplus.camera.ui.menu.shareedit.a_renamed aVar5 = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                        aVar5.a_renamed(aVar5.L_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.V_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.o_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.n_renamed, f_renamed, false);
                    }
                }

                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                protected void a_renamed(android.view.animation.Animation animation) {
                    super.a_renamed(animation);
                }

                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                protected void b_renamed(android.view.animation.Animation animation) {
                    if (5 == com.oplus.camera.ui.menu.shareedit.a_renamed.this.f6684c) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.d_renamed(true);
                    }
                    if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.ae_renamed || com.oplus.camera.ui.menu.shareedit.a_renamed.this.af_renamed) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.z_renamed();
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.E_renamed();
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.ae_renamed = false;
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.af_renamed = false;
                    }
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.a_renamed();
                }
            };
            this.an_renamed.setDuration(300L);
            this.an_renamed.setInterpolator(this.aw_renamed);
            this.Q_renamed.clearAnimation();
            this.Q_renamed.startAnimation(this.an_renamed);
        }
    }

    private boolean s_renamed() {
        com.oplus.camera.ui.control.e_renamed eVar = this.av_renamed;
        this.ab_renamed = eVar != null && com.oplus.camera.util.Util.a_renamed(eVar.e_renamed());
        this.ac_renamed = this.av_renamed != null && l_renamed();
        this.ap_renamed = p_renamed();
        com.oplus.camera.ui.control.e_renamed eVar2 = this.av_renamed;
        return (eVar2 == null || eVar2.e_renamed() == null || this.av_renamed.f6060a || !t_renamed()) ? false : true;
    }

    private boolean t_renamed() {
        return this.Y_renamed.aj_renamed() && this.Y_renamed.at_renamed();
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.control.ThumbImageView thumbImageView = this.X_renamed;
        if (thumbImageView != null) {
            thumbImageView.a_renamed(bitmap, i_renamed, z_renamed, false);
        }
    }

    private void u_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.aE_renamed;
        if (cameraUIListener != null && !cameraUIListener.bT_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ShareEditThumbMenu", "animToFullExpand, mCameraUIListener: " + this.aE_renamed);
            return;
        }
        if (2 != this.f6684c) {
            return;
        }
        this.aC_renamed[0] = this.X_renamed;
        b_renamed();
        b_renamed(255);
        c_renamed(4);
        if (this.aj_renamed == null) {
            this.aj_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.10
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    float fY_renamed = com.oplus.camera.ui.menu.shareedit.a_renamed.this.y_renamed() * f_renamed;
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.c_renamed(aVar.aq_renamed + fY_renamed);
                }
            };
            this.aj_renamed.setInterpolator(this.aw_renamed);
        }
        this.aq_renamed = this.H_renamed.height;
        this.aj_renamed.setDuration(300L);
        v_renamed();
        this.Q_renamed.clearAnimation();
        this.Q_renamed.startAnimation(this.aj_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, android.view.View view, int i_renamed, int i2, float f_renamed, boolean z_renamed) {
        float f2 = i_renamed + ((int) (this.v_renamed * 0.100000024f)) + 1;
        layoutParams.bottomMargin = (int) (f2 + ((i2 - f2) * f_renamed));
        view.requestLayout();
        if (0.5f >= f_renamed || !z_renamed) {
            return;
        }
        view.setVisibility(0);
    }

    private void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, android.view.View view, int i_renamed) {
        layoutParams.bottomMargin = i_renamed + ((int) (this.v_renamed * 0.100000024f)) + 1;
        view.requestLayout();
    }

    private void v_renamed() {
        int i_renamed = this.f6684c;
        if (6 == i_renamed || 7 == i_renamed || 1 == i_renamed) {
            return;
        }
        c_renamed(6);
        if (this.al_renamed == null) {
            this.al_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.11
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                protected void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.a_renamed(aVar.J_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.U_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.p_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.q_renamed, f_renamed, true);
                }
            };
            this.al_renamed.setDuration(300L);
            this.al_renamed.setStartOffset(80L);
            this.al_renamed.setInterpolator(this.at_renamed);
        }
        if (this.ak_renamed == null) {
            this.ak_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.12
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    if (1 == com.oplus.camera.ui.menu.shareedit.a_renamed.this.f6684c) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.T_renamed.clearAnimation();
                    }
                    if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.S_renamed.getVisibility() == 0) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.C_renamed();
                    }
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.a_renamed(aVar.K_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.T_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.r_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.s_renamed, f_renamed, true);
                }

                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                protected void b_renamed(android.view.animation.Animation animation) {
                    if (1 == com.oplus.camera.ui.menu.shareedit.a_renamed.this.f6684c) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.T_renamed.setVisibility(4);
                        return;
                    }
                    if (6 == com.oplus.camera.ui.menu.shareedit.a_renamed.this.f6684c) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.c_renamed(7);
                        if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.S_renamed.getVisibility() == 0) {
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.C_renamed();
                        }
                        if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.aD_renamed != null) {
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.aD_renamed.a_renamed();
                        }
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.w_renamed();
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.Y_renamed.q_renamed(45);
                    }
                }
            };
            this.ak_renamed.setDuration(300L);
            this.ak_renamed.setInterpolator(this.at_renamed);
        }
        if (this.am_renamed == null) {
            this.am_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.13
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                protected void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    if (!com.oplus.camera.ui.menu.shareedit.a_renamed.this.ab_renamed) {
                        com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                        aVar.a_renamed(aVar.L_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.V_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.p_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.q_renamed, f_renamed, true);
                    } else {
                        com.oplus.camera.ui.menu.shareedit.a_renamed aVar2 = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                        aVar2.a_renamed(aVar2.L_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.V_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.n_renamed, com.oplus.camera.ui.menu.shareedit.a_renamed.this.o_renamed, f_renamed, true);
                    }
                }
            };
            this.am_renamed.setDuration(300L);
            this.am_renamed.setStartOffset(80L);
            this.am_renamed.setInterpolator(this.at_renamed);
        }
        if (this.ac_renamed) {
            this.V_renamed.startAnimation(this.am_renamed);
            this.al_renamed.setStartOffset(110L);
        }
        if (this.ab_renamed) {
            this.U_renamed.startAnimation(this.al_renamed);
            this.ak_renamed.setStartOffset(140L);
        } else {
            this.ak_renamed.setStartOffset(110L);
        }
        x_renamed();
        w_renamed();
    }

    public void e_renamed() {
        int i_renamed = this.f6684c;
        if (7 == i_renamed || 2 == i_renamed || 6 == i_renamed || 4 == i_renamed || 1 == i_renamed) {
            this.au_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.14
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.aK_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.w_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w_renamed() {
        float f_renamed = J_renamed() ? 0.3f : 1.0f;
        com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "updateIconAlpha, mbEnable: " + this.az_renamed);
        if (this.ac_renamed) {
            this.V_renamed.setImageAlpha((int) (f_renamed * 255.0f));
            this.V_renamed.setDrawableAlpha(f_renamed);
            this.V_renamed.invalidate();
        }
        if (this.ab_renamed) {
            this.U_renamed.setImageAlpha((int) (f_renamed * 255.0f));
            this.U_renamed.setDrawableAlpha(f_renamed);
            this.U_renamed.invalidate();
        }
        this.T_renamed.setImageAlpha((int) (255.0f * f_renamed));
        this.T_renamed.setDrawableAlpha(f_renamed);
        this.T_renamed.invalidate();
        if (this.az_renamed) {
            E_renamed();
        }
    }

    private void x_renamed() {
        int i_renamed = this.f6684c;
        if (i_renamed == 0 || 1 == i_renamed) {
            return;
        }
        this.Q_renamed.clearAnimation();
        this.T_renamed.startAnimation(this.ak_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float y_renamed() {
        return this.ap_renamed - this.aq_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z_renamed() {
        if (!m_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("ShareEditThumbMenu", "showArrow, should not show arrow now");
            return;
        }
        if (0.0f == this.O_renamed || 0.0f == this.P_renamed) {
            this.O_renamed = (((this.Y_renamed.aq_renamed().getHeight() - this.v_renamed) / 2.0f) - a_renamed(com.oplus.camera.R_renamed.dimen.arrow_height)) - this.m_renamed;
            this.P_renamed = a_renamed(com.oplus.camera.R_renamed.dimen.arrow_margin_start) + ((this.v_renamed - a_renamed(com.oplus.camera.R_renamed.dimen.arrow_width)) / 2.0f);
            android.widget.RelativeLayout.LayoutParams layoutParams = this.I_renamed;
            layoutParams.topMargin = (int) this.O_renamed;
            layoutParams.setMarginStart((int) this.P_renamed);
            this.S_renamed.requestLayout();
        }
        if (this.aG_renamed) {
            this.S_renamed.setVisibility(0);
        }
    }

    private void A_renamed() {
        this.aC_renamed[0] = this.X_renamed;
        b_renamed();
        b_renamed(255);
        c_renamed(4);
        if (this.aj_renamed == null) {
            this.aj_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.15
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    float fY_renamed = com.oplus.camera.ui.menu.shareedit.a_renamed.this.y_renamed() * f_renamed;
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.c_renamed(aVar.aq_renamed + fY_renamed);
                }
            };
            this.aj_renamed.setInterpolator(this.aw_renamed);
        }
        this.aq_renamed = this.H_renamed.height;
        this.aj_renamed.setDuration(300L);
        v_renamed();
        this.Q_renamed.clearAnimation();
        this.Q_renamed.startAnimation(this.aj_renamed);
    }

    private void B_renamed() {
        this.aC_renamed[0] = this.X_renamed;
        b_renamed();
        b_renamed(255);
        c_renamed(4);
        if (this.aj_renamed == null) {
            this.aj_renamed = new com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.2
                @Override // com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3
                void a_renamed(float f_renamed, android.view.animation.Transformation transformation) {
                    float fY_renamed = com.oplus.camera.ui.menu.shareedit.a_renamed.this.y_renamed() * f_renamed;
                    com.oplus.camera.ui.menu.shareedit.a_renamed aVar = com.oplus.camera.ui.menu.shareedit.a_renamed.this;
                    aVar.c_renamed(aVar.aq_renamed + fY_renamed);
                }
            };
            this.aj_renamed.setInterpolator(this.aw_renamed);
        }
        this.aq_renamed = this.H_renamed.height;
        this.aj_renamed.setDuration(300L);
        v_renamed();
        this.Q_renamed.clearAnimation();
        this.Q_renamed.startAnimation(this.aj_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C_renamed() {
        this.S_renamed.clearAnimation();
        this.S_renamed.setVisibility(8);
    }

    private void b_renamed(float f_renamed) {
        float fExp = this.H_renamed.height + f_renamed;
        if (this.i_renamed > fExp) {
            return;
        }
        if (this.k_renamed + p_renamed() < fExp) {
            fExp = p_renamed() + this.k_renamed;
            c_renamed(fExp);
        } else if (p_renamed() < fExp) {
            fExp = (((float) java.lang.Math.exp((-0.02f) * f_renamed)) * f_renamed) + this.H_renamed.height;
            c_renamed(fExp);
        } else {
            c_renamed(fExp);
        }
        if (fExp >= p_renamed() - this.A_renamed && 2 == this.f6684c) {
            C_renamed();
            u_renamed();
        }
        if (3 != this.f6684c || fExp > p_renamed() - this.B_renamed) {
            return;
        }
        this.ah_renamed = false;
        r_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(float f_renamed) {
        android.widget.RelativeLayout.LayoutParams layoutParams = this.H_renamed;
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = (int) f_renamed;
        this.Q_renamed.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D_renamed() {
        return 255 == this.ao_renamed.getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E_renamed() {
        android.os.Handler handler = this.au_renamed;
        if (handler != null) {
            handler.removeMessages(2);
            this.au_renamed.sendEmptyMessageDelayed(2, 2851L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int i_renamed = 0;
        if (!this.Z_renamed || !this.aa_renamed || !this.az_renamed || this.Y_renamed.ap_renamed() || this.W_renamed.getVisibility() != 0 || this.aE_renamed.p_renamed()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onTouch, !mbShareAndMarkEnable: ");
            sb.append(!this.Z_renamed);
            sb.append(", !mbEnableTouch: ");
            sb.append(!this.aa_renamed);
            sb.append(", !mbEnable: ");
            sb.append(!this.az_renamed);
            sb.append(", isMoreModeTab: ");
            sb.append(this.Y_renamed.ap_renamed());
            sb.append(", mThumbImageViewVisibility: ");
            sb.append(this.W_renamed.getVisibility());
            sb.append(", isDoubleFinger: ");
            sb.append(this.aE_renamed.p_renamed());
            com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", sb.toString());
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            N_renamed();
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.aA_renamed;
                if (i2 >= zArr.length) {
                    break;
                }
                zArr[i2] = this.aB_renamed[i2] == view.getId();
                i2++;
            }
            if (view.getId() == com.oplus.camera.R_renamed.id_renamed.popup_thumbnail) {
                this.aA_renamed[0] = true;
            }
            if (K_renamed()) {
                com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "onTouch, ACTION_DOWN isAnimating return");
                return true;
            }
            this.ad_renamed = false;
            android.os.Handler handler = this.au_renamed;
            if (handler != null) {
                handler.removeMessages(2);
            }
            this.N_renamed = motionEvent.getY();
            this.M_renamed = motionEvent.getY();
            if (this.H_renamed.height < 0) {
                this.H_renamed.height = this.Q_renamed.getMeasuredHeight();
            }
            int i3 = this.f6684c;
            this.d_renamed = i3;
            if (1 == i3 || 7 == i3 || i3 == 0) {
                this.ah_renamed = true;
                c_renamed(7 != this.f6684c ? 2 : 3);
                this.Q_renamed.clearAnimation();
                this.ai_renamed = 2 == this.f6684c;
            } else {
                this.ah_renamed = false;
            }
            this.ag_renamed = true;
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (K_renamed()) {
                    com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "onTouch, ACTION_MOVE isAnimating return");
                    return true;
                }
                if (this.ad_renamed) {
                    com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "onTouch, ACTION_MOVE mbIntercept return");
                    return true;
                }
                if (this.N_renamed != 0.0f && this.ah_renamed) {
                    this.aL_renamed = motionEvent.getY() - this.N_renamed;
                    if (java.lang.Math.abs(this.aL_renamed) < this.t_renamed) {
                        return true;
                    }
                    int i4 = 0;
                    while (true) {
                        boolean[] zArr2 = this.aA_renamed;
                        if (i4 >= zArr2.length) {
                            break;
                        }
                        if (zArr2[i4] && java.lang.Math.abs(motionEvent.getY() - this.M_renamed) > this.t_renamed) {
                            this.aA_renamed[i4] = false;
                        }
                        i4++;
                    }
                    if (this.ag_renamed) {
                        this.ag_renamed = false;
                        if (this.ai_renamed) {
                            if (this.S_renamed.getVisibility() == 0) {
                                C_renamed();
                            }
                            if (!D_renamed()) {
                                b_renamed(255);
                            }
                        }
                    }
                }
                return true;
            }
            if (action == 3) {
                int i5 = 0;
                while (true) {
                    boolean[] zArr3 = this.aA_renamed;
                    if (i5 >= zArr3.length) {
                        break;
                    }
                    zArr3[i5] = false;
                    i5++;
                }
            } else {
                return false;
            }
        }
        if (0.0f == this.N_renamed || !this.ah_renamed || !this.ai_renamed) {
            if (0.0f > this.aL_renamed) {
                r_renamed();
                this.ah_renamed = false;
            } else {
                b_renamed((float) ((-r0) * 0.5d));
            }
        } else if (java.lang.Math.abs(this.aL_renamed) > this.t_renamed) {
            if (this.aL_renamed > 0.0f) {
                u_renamed();
                this.ah_renamed = false;
            } else {
                b_renamed((float) ((-r0) * 0.5d));
            }
        }
        O_renamed();
        if (this.ad_renamed) {
            while (true) {
                boolean[] zArr4 = this.aA_renamed;
                if (i_renamed >= zArr4.length) {
                    break;
                }
                if (zArr4[i_renamed]) {
                    this.aC_renamed[i_renamed].performClick();
                    break;
                }
                i_renamed++;
            }
            return true;
        }
        E_renamed();
        java.lang.Object[] objArr = java.lang.Math.abs(motionEvent.getY() - this.M_renamed) < ((float) this.t_renamed);
        int i6 = 0;
        while (true) {
            boolean[] zArr5 = this.aA_renamed;
            if (i6 >= zArr5.length) {
                if (objArr != false) {
                    int i7 = this.d_renamed;
                    if (1 == i7 || i7 == 0) {
                        C_renamed();
                        u_renamed();
                    } else {
                        c_renamed(D_renamed() ? 7 : 0);
                    }
                    return true;
                }
                if (this.ai_renamed) {
                    C_renamed();
                    u_renamed();
                } else if (3 == this.f6684c) {
                    r_renamed();
                }
                return true;
            }
            if (zArr5[i6] && objArr == true) {
                this.aC_renamed[i6].performClick();
                return true;
            }
            i6++;
        }
    }

    private java.lang.String a_renamed(java.lang.String str) {
        java.lang.String[] strArrSplit;
        if (android.text.TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || 1 > strArrSplit.length) {
            return null;
        }
        java.lang.String str2 = strArrSplit[strArrSplit.length - 1];
        if (com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(str2) || "jpg".equalsIgnoreCase(str2)) {
            return "image/jpeg";
        }
        if ("raw".equalsIgnoreCase(str2) || "dng".equalsIgnoreCase(str2)) {
            return "image/x_renamed-adobe-dng";
        }
        if ("heic_8bits".equalsIgnoreCase(str2) || "heic_10bits".equalsIgnoreCase(str2) || "heic".equalsIgnoreCase(str2)) {
            return "image/heic";
        }
        if ("mp4".equalsIgnoreCase(str2)) {
            return com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4;
        }
        if ("3gp".equalsIgnoreCase(str2)) {
            return "video/3gp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F_renamed() {
        com.oplus.camera.ui.control.e_renamed eVarT = this.Y_renamed.t_renamed();
        if (eVarT == null) {
            return;
        }
        android.net.Uri uriE = eVarT.e_renamed();
        if (a_renamed(uriE, com.oplus.camera.util.Util.a_renamed(uriE))) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
            java.lang.String strL = eVarT.l_renamed();
            if (strL == null) {
                strL = a_renamed(eVarT.f_renamed());
            }
            if (strL == null) {
                strL = com.oplus.camera.util.Util.a_renamed(uriE) ? "image/*" : "video/*";
            }
            intent.setType(strL);
            intent.putExtra("android.intent.extra.STREAM", uriE);
            if (this.Y_renamed.ak_renamed()) {
                intent.setFlags(268468224);
            }
            I_renamed();
            try {
                this.ar_renamed.startActivity(android.content.Intent.createChooser(intent, null));
                this.ar_renamed.overridePendingTransition(0, 0);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "jumpSystemShare: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G_renamed() {
        com.oplus.camera.ui.control.e_renamed eVarT = this.Y_renamed.t_renamed();
        if (eVarT == null) {
            return;
        }
        android.net.Uri uriE = eVarT.e_renamed();
        if (a_renamed(uriE, com.oplus.camera.util.Util.a_renamed(uriE))) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.EDIT");
            intent.setData(uriE);
            intent.setPackage(com.oplus.camera.util.Util.aP_renamed());
            if (com.oplus.camera.util.Util.ak_renamed()) {
                intent.putExtra("edit_skill", "doodle");
                intent.putExtra("finish_operate", "save,share");
                intent.putExtra("from", this.ar_renamed.getPackageName());
                intent.putExtra("isInternalSdcard", true);
                intent.putExtra("editor_state_item", "graffiti");
                intent.setFlags(1);
            }
            if (this.Y_renamed.ak_renamed()) {
                intent.addFlags(268468224);
            }
            I_renamed();
            try {
                this.ar_renamed.startActivity(intent);
                this.ar_renamed.overridePendingTransition(com.oplus.camera.R_renamed.anim.gallery_push_up_enter, com.oplus.camera.R_renamed.anim.camera_fade_out_for_edit);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "jumpMark: " + th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H_renamed() {
        com.oplus.camera.ui.control.e_renamed eVarT = this.Y_renamed.t_renamed();
        if (eVarT == null) {
            return;
        }
        android.net.Uri uriE = eVarT.e_renamed();
        if (a_renamed(uriE, com.oplus.camera.util.Util.a_renamed(uriE))) {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("oplusos.intent.action.SOLOOP_VIDEO_EDITOR");
            long id_renamed = android.content.ContentUris.parseId(uriE);
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
            arrayList.add(java.lang.String.valueOf(id_renamed));
            intent.putStringArrayListExtra("id_list", arrayList);
            intent.putExtra("tab_name", "template");
            intent.putExtra("use_template", true);
            if (this.Y_renamed.ak_renamed()) {
                intent.setFlags(268468224);
            }
            I_renamed();
            try {
                this.ar_renamed.startActivity(intent);
                this.ar_renamed.overridePendingTransition(1 == this.ar_renamed.getResources().getConfiguration().getLayoutDirection() ? com.oplus.camera.R_renamed.anim.gallery_in_rtl : com.oplus.camera.R_renamed.anim.gallery_in, 0);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "jumpSoloop: " + th);
            }
        }
    }

    private void I_renamed() {
        if (this.Y_renamed.ak_renamed()) {
            try {
                new android.view.OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "OplusWindowManager exception:" + e_renamed.toString());
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.d_renamed("ShareEditThumbMenu", "OplusWindowManager error:", e2);
            }
        }
    }

    private boolean a_renamed(android.net.Uri uri, boolean z_renamed) throws java.lang.Throwable {
        if (uri == null) {
            return false;
        }
        boolean zA = com.oplus.camera.util.Util.a_renamed(uri, this.ar_renamed.getContentResolver());
        if (!J_renamed() && zA) {
            return !z_renamed || a_renamed(uri);
        }
        com.oplus.camera.e_renamed.e_renamed("ShareEditThumbMenu", "onThumbNailClick, imageCaptureListIsEmpty: " + com.oplus.camera.m_renamed.b_renamed.a_renamed().j_renamed() + ", imageSaveListIsEmpty: " + com.oplus.camera.m_renamed.b_renamed.a_renamed().g_renamed() + ", isUriValid: " + zA);
        return false;
    }

    private boolean J_renamed() {
        return (com.oplus.camera.m_renamed.b_renamed.a_renamed().j_renamed() && com.oplus.camera.m_renamed.b_renamed.a_renamed().g_renamed()) ? false : true;
    }

    private boolean a_renamed(android.net.Uri uri) {
        try {
            return this.ar_renamed.getContentResolver().loadThumbnail(uri, new android.util.Size(1, 1), null) != null;
        } catch (java.lang.Exception unused) {
            com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "checkFileOk: " + uri.toString());
            return false;
        }
    }

    public void f_renamed() {
        this.ad_renamed = true;
        d_renamed(true);
        this.Q_renamed.setVisibility(8);
        this.aG_renamed = false;
    }

    public void g_renamed() {
        this.Q_renamed.setVisibility(0);
        this.aG_renamed = true;
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.Q_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.aG_renamed = true;
        } else {
            g_renamed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) throws android.content.pm.PackageManager.NameNotFoundException {
        if (0 != this.as_renamed && 500 > java.lang.System.currentTimeMillis() - this.as_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "onClick, mLastClickTime return");
        }
        if (!this.az_renamed || this.aK_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "onClick, return mbEnable " + this.az_renamed + ", mbPaused: " + this.aK_renamed);
            return;
        }
        if (this.aJ_renamed) {
            return;
        }
        this.aJ_renamed = true;
        this.as_renamed = java.lang.System.currentTimeMillis();
        switch (view.getId()) {
            case com.oplus.camera.R_renamed.id_renamed.edit /* 2131296576 */:
                java.lang.String strAP = com.oplus.camera.util.Util.aP_renamed();
                if (com.oplus.camera.util.f_renamed.a_renamed(this.ar_renamed, strAP)) {
                    com.oplus.camera.util.f_renamed.a_renamed(this.ar_renamed, com.oplus.camera.R_renamed.string.camera_disable_album, strAP, "");
                    this.aJ_renamed = false;
                    break;
                } else {
                    com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.G_renamed();
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.aJ_renamed = false;
                        }
                    }, "share");
                    this.ax_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                    this.Y_renamed.q_renamed(47);
                    break;
                }
            case com.oplus.camera.R_renamed.id_renamed.popup_thumbnail /* 2131296975 */:
                this.Y_renamed.onClick(view);
                this.aJ_renamed = false;
                break;
            case com.oplus.camera.R_renamed.id_renamed.share /* 2131297075 */:
                com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.F_renamed();
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.aJ_renamed = false;
                    }
                }, "share");
                this.ax_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                this.Y_renamed.q_renamed(46);
                break;
            case com.oplus.camera.R_renamed.id_renamed.soloop /* 2131297100 */:
                com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.util.Util.d_renamed(com.oplus.camera.ui.menu.shareedit.a_renamed.this.ar_renamed, "com.oplus.videoeditor") || !com.oplus.camera.util.Util.B_renamed(com.oplus.camera.ui.menu.shareedit.a_renamed.this.ar_renamed) || !com.oplus.camera.ui.menu.shareedit.a_renamed.this.M_renamed()) {
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.H_renamed();
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.Y_renamed.q_renamed(55);
                            com.oplus.camera.ui.menu.shareedit.a_renamed.this.aJ_renamed = false;
                            return;
                        }
                        com.oplus.camera.ui.menu.shareedit.a_renamed.this.ar_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.oplus.camera.ui.menu.shareedit.a_renamed.this.aE_renamed != null) {
                                    com.oplus.camera.ui.menu.shareedit.a_renamed.this.aE_renamed.br_renamed();
                                }
                                com.oplus.camera.ui.menu.shareedit.a_renamed.this.aJ_renamed = false;
                            }
                        });
                    }
                }, "share");
                this.ax_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, false).apply();
                break;
            default:
                this.aJ_renamed = false;
                break;
        }
    }

    private boolean K_renamed() {
        return a_renamed(this.aj_renamed) || a_renamed(this.an_renamed) || a_renamed(this.ak_renamed) || a_renamed(this.al_renamed) || a_renamed(this.am_renamed);
    }

    private boolean a_renamed(com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3 abstractC0132a) {
        return abstractC0132a != null && abstractC0132a.a_renamed();
    }

    public boolean h_renamed() {
        int i_renamed = this.f6684c;
        return 7 == i_renamed || 4 == i_renamed;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if ("key_is_soloop_in_market".equals(str)) {
            k_renamed();
        }
    }

    public void i_renamed() {
        this.aK_renamed = false;
        this.Z_renamed = "on_renamed".equals(this.ax_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SHARE_AND_MARK, this.ar_renamed.getString(com.oplus.camera.R_renamed.string.camera_share_default_value)));
    }

    public void j_renamed() {
        this.aK_renamed = true;
        this.as_renamed = 0L;
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.f_renamed("ShareEditThumbMenu", "setEnableMenu, enable: " + z_renamed + ", mbEnable: " + this.az_renamed);
        this.az_renamed = z_renamed;
        if (this.az_renamed) {
            return;
        }
        int i_renamed = this.f6684c;
        if (7 == i_renamed || 4 == i_renamed || 2 == i_renamed) {
            a_renamed(false, true);
        }
    }

    public void k_renamed() {
        this.aa_renamed = s_renamed();
    }

    public void c_renamed(boolean z_renamed) {
        android.widget.PopupWindow popupWindow = this.R_renamed;
        if (popupWindow != null && popupWindow.isShowing() && this.aI_renamed) {
            this.R_renamed.setTouchable(z_renamed);
            this.R_renamed.update();
        }
    }

    public boolean l_renamed() {
        com.oplus.camera.ui.control.e_renamed eVarT = this.Y_renamed.t_renamed();
        return eVarT != null && (eVarT.l_renamed() == null || !"image/x_renamed-adobe-dng".equals(eVarT.l_renamed())) && !eVarT.f_renamed().contains("raw") && M_renamed() && ((com.oplus.camera.util.Util.d_renamed(this.ar_renamed, "com.oplus.videoeditor") || (com.oplus.camera.util.Util.B_renamed(this.ar_renamed) && L_renamed())) && this.Y_renamed.aj_renamed());
    }

    public boolean m_renamed() {
        return !this.Y_renamed.au_renamed();
    }

    private boolean L_renamed() {
        android.content.SharedPreferences sharedPreferences = this.ay_renamed;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("key_is_soloop_in_market", false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP);
    }

    /* compiled from: ShareEditThumbMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.shareedit.a_renamed$a_renamed, reason: collision with other inner class name */
    private static abstract class ShareEditThumbMenu_3 extends android.view.animation.Animation {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f6703a = false;

        /* renamed from: b_renamed, reason: collision with root package name */
        private volatile boolean f6704b = false;

        abstract void a_renamed(float f_renamed, android.view.animation.Transformation transformation);

        protected void a_renamed(android.view.animation.Animation animation) {
        }

        protected void b_renamed(android.view.animation.Animation animation) {
        }

        protected void c_renamed(android.view.animation.Animation animation) {
        }

        public ShareEditThumbMenu_3() {
            setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.a_renamed.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.f6703a = false;
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.f6704b = true;
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.a_renamed(animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.f6703a = true;
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.f6704b = false;
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.b_renamed(animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                    com.oplus.camera.ui.menu.shareedit.a_renamed.ShareEditThumbMenu_3.this.c_renamed(animation);
                }
            });
        }

        public boolean a_renamed() {
            return this.f6704b;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f_renamed, android.view.animation.Transformation transformation) {
            if (this.f6703a) {
                return;
            }
            a_renamed(f_renamed, transformation);
        }
    }

    private void N_renamed() {
        if (this.aM_renamed == null) {
            P_renamed();
        }
        this.aM_renamed.start();
    }

    private void O_renamed() {
        if (this.aN_renamed == null) {
            Q_renamed();
        }
        this.aN_renamed.start();
    }

    private void P_renamed() {
        this.aM_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.9f);
        this.aM_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.W_renamed.setScaleX(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.W_renamed.setScaleY(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.X_renamed.setScaleX(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.X_renamed.setScaleY(fFloatValue);
            }
        });
        this.aM_renamed.setDuration(200L);
        this.aM_renamed.setInterpolator(f6682a);
    }

    private void Q_renamed() {
        this.aN_renamed = android.animation.ValueAnimator.ofFloat(0.9f, 1.0f);
        this.aN_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.shareedit.a_renamed.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.W_renamed.setScaleX(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.W_renamed.setScaleY(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.X_renamed.setScaleX(fFloatValue);
                com.oplus.camera.ui.menu.shareedit.a_renamed.this.X_renamed.setScaleY(fFloatValue);
            }
        });
        this.aN_renamed.setDuration(295L);
        this.aN_renamed.setInterpolator(f6683b);
    }
}
