package com.oplus.camera;

/* compiled from: ZoomManager.java */
/* loaded from: classes2.dex */
public class ag_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final float f4106a = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTAR_WIDE_ZOOM_POINT_VALUE);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float f4107b = f4106a;
    private com.oplus.camera.ui.preview.ai_renamed B_renamed;
    private android.app.Activity L_renamed;
    private android.content.res.Resources M_renamed;
    private com.oplus.camera.ComboPreferences N_renamed;
    private com.oplus.camera.capmode.a_renamed O_renamed;
    private android.view.ViewGroup Y_renamed;
    private java.text.DecimalFormat aa_renamed;
    private com.oplus.camera.screen.g_renamed ab_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.ArrayList<java.lang.Float> f4108c = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.Float> d_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.Float> e_renamed = new java.util.ArrayList<>();
    private float f_renamed = 1.0f;
    private float g_renamed = 1.0f;
    private float h_renamed = 0.0f;
    private float i_renamed = 0.0f;
    private float j_renamed = 0.0f;
    private float k_renamed = 0.0f;
    private int q_renamed = 0;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private boolean v_renamed = false;
    private boolean w_renamed = false;
    private boolean x_renamed = false;
    private boolean y_renamed = false;
    private boolean z_renamed = false;
    private com.oplus.camera.ag_renamed.a_renamed A_renamed = null;
    private android.widget.RelativeLayout C_renamed = null;
    private android.widget.LinearLayout D_renamed = null;
    private com.oplus.camera.ui.widget.InertiaZoomBar E_renamed = null;
    private com.oplus.camera.ui.widget.InertialZoomButton F_renamed = null;
    private com.oplus.camera.ui.widget.InertialZoomButton G_renamed = null;
    private com.oplus.camera.ui.RotableTextView H_renamed = null;
    private com.oplus.camera.ui.x_renamed I_renamed = null;
    private com.oplus.camera.ui.RotableTextView J_renamed = null;
    private com.oplus.camera.ab_renamed K_renamed = null;
    private com.oplus.camera.af_renamed P_renamed = null;
    private android.graphics.Rect Q_renamed = null;
    private android.animation.ValueAnimator R_renamed = null;
    private android.animation.ValueAnimator S_renamed = null;
    private android.animation.AnimatorSet T_renamed = null;
    private android.animation.AnimatorSet U_renamed = null;
    private android.animation.AnimatorSet V_renamed = null;
    private android.animation.AnimatorSet W_renamed = null;
    private android.animation.ValueAnimator X_renamed = null;
    private android.os.Handler Z_renamed = null;
    private int ac_renamed = 0;
    private int ad_renamed = 0;
    private java.lang.String ae_renamed = "";
    private boolean af_renamed = false;
    private boolean ag_renamed = false;
    private boolean ah_renamed = false;
    private boolean ai_renamed = false;
    private boolean aj_renamed = false;
    private boolean ak_renamed = false;
    private boolean al_renamed = false;
    private android.view.animation.PathInterpolator am_renamed = new android.view.animation.PathInterpolator(0.42f, 0.42f, 0.52f, 0.92f);
    private android.view.animation.PathInterpolator an_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator ao_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* compiled from: ZoomManager.java */
    public interface a_renamed {
        boolean A_renamed();

        boolean B_renamed();

        boolean C_renamed();

        int D_renamed();

        void a_renamed(float f_renamed, boolean z_renamed);

        void a_renamed(float f_renamed, boolean z_renamed, float f2);

        void a_renamed(int i_renamed);

        void a_renamed(boolean z_renamed);

        boolean a_renamed();

        boolean a_renamed(java.lang.String str);

        void b_renamed(float f_renamed);

        void b_renamed(int i_renamed);

        void b_renamed(boolean z_renamed);

        boolean b_renamed();

        void c_renamed();

        void c_renamed(float f_renamed);

        void c_renamed(boolean z_renamed);

        void d_renamed();

        void d_renamed(boolean z_renamed);

        boolean e_renamed();

        void f_renamed();

        void g_renamed();

        void h_renamed();

        void i_renamed();

        void j_renamed();

        void k_renamed();

        boolean l_renamed();

        boolean m_renamed();

        java.lang.String n_renamed();

        boolean o_renamed();

        void p_renamed();

        void q_renamed();

        void r_renamed();

        boolean s_renamed();

        boolean t_renamed();

        boolean u_renamed();

        boolean v_renamed();

        boolean w_renamed();

        boolean x_renamed();

        boolean y_renamed();

        boolean z_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d_renamed(float f_renamed) {
        return ((f_renamed / 100.0f) * 10.0f) - 5.0f;
    }

    public ag_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.capmode.a_renamed aVar, android.view.ViewGroup viewGroup, com.oplus.camera.screen.g_renamed gVar) {
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.B_renamed = null;
        this.L_renamed = null;
        this.M_renamed = null;
        this.N_renamed = null;
        this.O_renamed = null;
        this.Y_renamed = null;
        this.aa_renamed = null;
        this.ab_renamed = null;
        this.ab_renamed = gVar;
        this.L_renamed = activity;
        this.M_renamed = this.L_renamed.getResources();
        this.N_renamed = comboPreferences;
        this.O_renamed = aVar;
        this.Y_renamed = viewGroup;
        this.B_renamed = new com.oplus.camera.ui.preview.af_renamed(this.L_renamed);
        this.B_renamed.setScreenModeManager(gVar);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.L_renamed, this.B_renamed);
        this.B_renamed.setId(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
        this.l_renamed = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_gesture_scale_step);
        this.o_renamed = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_current_indicator_move_distance_max);
        this.m_renamed = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_current_text_move_distance_max);
        this.n_renamed = this.L_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_animation_y);
        this.p_renamed = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoombar_anim_transx);
        this.aa_renamed = new java.text.DecimalFormat("0.0", java.text.DecimalFormatSymbols.getInstance(java.util.Locale.US));
        this.f4108c.add(java.lang.Float.valueOf(1.0f));
        this.f4108c.add(java.lang.Float.valueOf(5.0f));
        this.f4108c.add(java.lang.Float.valueOf(10.0f));
        this.f4108c.add(java.lang.Float.valueOf(10.1f));
        this.B_renamed.setOnSeekBarChangeListener(new com.oplus.camera.ui.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.1
            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void a_renamed(float f_renamed) {
                if (com.oplus.camera.ag_renamed.this.I_renamed != null) {
                    com.oplus.camera.ag_renamed.this.I_renamed.setFromClickView(false);
                }
                if (com.oplus.camera.ag_renamed.this.O_renamed != null && com.oplus.camera.ag_renamed.this.O_renamed.a_renamed(f_renamed, com.oplus.camera.ag_renamed.this.f_renamed) && com.oplus.camera.ag_renamed.this.O_renamed.aB_renamed()) {
                    com.oplus.camera.ag_renamed.this.u_renamed = true;
                }
                if (com.oplus.camera.ag_renamed.this.A_renamed != null && com.oplus.camera.ag_renamed.this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                    com.oplus.camera.ag_renamed.this.A_renamed.c_renamed(f_renamed == 1.0f);
                    if (com.oplus.camera.ag_renamed.this.A_renamed == null || !com.oplus.camera.ag_renamed.this.A_renamed.o_renamed()) {
                        return;
                    }
                    com.oplus.camera.ag_renamed.this.A_renamed.q_renamed();
                    return;
                }
                if (java.lang.Float.compare(com.oplus.camera.ag_renamed.f4106a, f_renamed) == 0) {
                    com.oplus.camera.j_renamed.a_renamed().g_renamed();
                }
                com.oplus.camera.ag_renamed.this.b_renamed(f_renamed, true);
                if (com.oplus.camera.ag_renamed.this.A_renamed == null || !com.oplus.camera.ag_renamed.this.A_renamed.o_renamed()) {
                    return;
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                    com.oplus.camera.ag_renamed.this.A_renamed.p_renamed();
                } else {
                    com.oplus.camera.ag_renamed.this.A_renamed.q_renamed();
                }
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void a_renamed(float f_renamed, boolean z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onChanged, zoomValue: " + f_renamed);
                if (com.oplus.camera.ag_renamed.this.P_renamed.h_renamed()) {
                    if (!com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() || java.lang.Float.compare(f_renamed, 2.0f) >= 0) {
                        if (!com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() && java.lang.Float.compare(f_renamed, 2.0f) >= 0 && !com.oplus.camera.ag_renamed.this.A_renamed.v_renamed()) {
                            com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on_renamed").apply();
                        }
                    } else {
                        com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    }
                }
                if (!com.oplus.camera.ag_renamed.this.P_renamed.g_renamed() || !com.oplus.camera.ag_renamed.this.A_renamed.s_renamed()) {
                    com.oplus.camera.ag_renamed.this.f_renamed(f_renamed);
                    com.oplus.camera.ag_renamed.this.g_renamed(f_renamed);
                    com.oplus.camera.ag_renamed.this.a_renamed(f_renamed, f_renamed, true, false);
                } else {
                    if (java.lang.Float.compare(f_renamed, 1.0f) < 0 || !z_renamed) {
                        return;
                    }
                    com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                    com.oplus.camera.ag_renamed.this.f_renamed(f_renamed);
                    com.oplus.camera.ag_renamed.this.g_renamed(f_renamed);
                }
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public boolean a_renamed() {
                return com.oplus.camera.ag_renamed.this.Y_renamed();
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                    com.oplus.camera.ag_renamed.this.A_renamed.f_renamed();
                    com.oplus.camera.ag_renamed.this.A_renamed.c_renamed();
                }
                com.oplus.camera.ag_renamed.this.V_renamed();
                com.oplus.camera.ag_renamed.this.a_renamed(0);
                com.oplus.camera.ag_renamed agVar = com.oplus.camera.ag_renamed.this;
                agVar.e_renamed(agVar.f_renamed);
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void c_renamed() {
                if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                    com.oplus.camera.ag_renamed.this.A_renamed.g_renamed();
                    com.oplus.camera.ag_renamed.this.A_renamed.d_renamed();
                }
                if (!com.oplus.camera.ag_renamed.this.P_renamed.g_renamed() || java.lang.Float.compare(com.oplus.camera.ag_renamed.this.B_renamed.getCurrentZoom(), 1.0f) >= 0) {
                    return;
                }
                if (com.oplus.camera.ag_renamed.this.P_renamed.f_renamed() || (com.oplus.camera.ag_renamed.this.A_renamed != null && com.oplus.camera.ag_renamed.this.A_renamed.u_renamed())) {
                    com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(com.oplus.camera.ag_renamed.f4106a, false);
                } else {
                    com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(1.0f, false);
                }
                com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void d_renamed() {
                if (com.oplus.camera.ag_renamed.this.P_renamed.g_renamed() && com.oplus.camera.ag_renamed.this.P_renamed.f_renamed() && com.oplus.camera.ag_renamed.this.A_renamed != null && !com.oplus.camera.ag_renamed.this.A_renamed.u_renamed()) {
                    com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(com.oplus.camera.ag_renamed.f4106a, false);
                }
                if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                    com.oplus.camera.ag_renamed.this.A_renamed.h_renamed();
                }
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void b_renamed(float f_renamed) throws android.content.res.Resources.NotFoundException {
                float fA_renamed = com.oplus.camera.util.Util.a_renamed(f_renamed, 0.0f, 1.0f);
                int color = com.oplus.camera.ag_renamed.this.L_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_30_percent_transparency_color);
                com.oplus.camera.ag_renamed.this.A_renamed.b_renamed(android.graphics.Color.argb((int) (fA_renamed * android.graphics.Color.alpha(color)), android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color)));
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void c_renamed(float f_renamed) throws android.content.res.Resources.NotFoundException {
                if (com.oplus.camera.ag_renamed.this.t_renamed && com.oplus.camera.ag_renamed.this.J_renamed.getVisibility() == 0) {
                    com.oplus.camera.ag_renamed.this.N_renamed();
                }
                float fA_renamed = com.oplus.camera.util.Util.a_renamed(f_renamed, 0.0f, 1.0f);
                int color = com.oplus.camera.ag_renamed.this.L_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.plugin_background_30_percent_transparency_color);
                com.oplus.camera.ag_renamed.this.A_renamed.b_renamed(android.graphics.Color.argb((int) (fA_renamed * android.graphics.Color.alpha(color)), android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color)));
                com.oplus.camera.ag_renamed.this.a_renamed(4);
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void e_renamed() {
                float f_renamed;
                float currentZoom = com.oplus.camera.ag_renamed.this.B_renamed.getCurrentZoom();
                com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onActionUpOnExpandState, zoomValue: " + currentZoom);
                if (com.oplus.camera.ag_renamed.this.P_renamed.g_renamed()) {
                    if (!com.oplus.camera.ag_renamed.this.A_renamed.u_renamed()) {
                        if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() || java.lang.Float.compare(currentZoom, com.oplus.camera.ag_renamed.f4106a) <= 0) {
                            if (com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() || java.lang.Float.compare(currentZoom, 1.0f) >= 0) {
                                com.oplus.camera.ag_renamed.this.e_renamed(currentZoom);
                            } else {
                                if (java.lang.Float.compare(currentZoom, 0.8f) > 0) {
                                    com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(1.0f, false);
                                } else {
                                    com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
                                    com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(com.oplus.camera.ag_renamed.f4106a, false);
                                }
                                com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                                com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
                            }
                        } else {
                            if (java.lang.Float.compare(currentZoom, 0.8f) <= 0) {
                                com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(com.oplus.camera.ag_renamed.f4106a, false);
                            } else {
                                com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                                com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(1.0f, false);
                            }
                            com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                            com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
                        }
                    } else if (java.lang.Float.compare(currentZoom, 1.0f) < 0) {
                        com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(1.0f, false);
                        com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                        com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
                    } else {
                        com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(currentZoom, false);
                        com.oplus.camera.ag_renamed.this.e_renamed(currentZoom);
                        com.oplus.camera.ag_renamed.this.b_renamed(currentZoom, currentZoom);
                    }
                }
                if (com.oplus.camera.ag_renamed.this.A_renamed.s_renamed()) {
                    com.oplus.camera.j_renamed.a_renamed().g_renamed();
                }
                com.oplus.camera.ui.x_renamed xVar = com.oplus.camera.ag_renamed.this.I_renamed;
                if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed()) {
                    f_renamed = com.oplus.camera.ag_renamed.this.f_renamed;
                } else {
                    f_renamed = com.oplus.camera.ag_renamed.f4106a;
                }
                xVar.a_renamed(f_renamed, true, true);
                com.oplus.camera.ag_renamed.this.h_renamed(2);
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void f_renamed() {
                com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onActionDownOnExpandState");
                if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                    com.oplus.camera.ag_renamed.this.A_renamed.c_renamed();
                }
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void d_renamed(float f_renamed) {
                com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onArcSeekBarClick, clicked zoomValue: " + f_renamed + ", mCurrentZoomValue: " + com.oplus.camera.ag_renamed.this.f_renamed);
                com.oplus.camera.ag_renamed.this.e_renamed(f_renamed);
                com.oplus.camera.ag_renamed.this.I_renamed.a_renamed(f_renamed, false);
                com.oplus.camera.ag_renamed.this.f_renamed = f_renamed;
                com.oplus.camera.ag_renamed.this.h_renamed(9);
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void g_renamed() {
                com.oplus.camera.ag_renamed.this.E_renamed();
            }

            @Override // com.oplus.camera.ui.b_renamed.a_renamed
            public void h_renamed() {
                float currentZoom = com.oplus.camera.ag_renamed.this.B_renamed.getCurrentZoom();
                com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onReboundAnimEnd, zoomValue: " + currentZoom);
                if (!com.oplus.camera.ag_renamed.this.P_renamed.g_renamed() || com.oplus.camera.ag_renamed.this.A_renamed == null || com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() || java.lang.Float.compare(currentZoom, com.oplus.camera.ag_renamed.f4106a) != 0) {
                    return;
                }
                com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(1.0f, false);
                com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
            }
        });
        D_renamed();
    }

    private void D_renamed() {
        this.Z_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ag_renamed.12
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                double dFloor;
                int i_renamed = message.what;
                if (i_renamed != 1) {
                    if (i_renamed == 2) {
                        sendEmptyMessageDelayed(2, 25L);
                        com.oplus.camera.ag_renamed.this.a_renamed(-2.0f);
                        return;
                    } else {
                        if (i_renamed != 3) {
                            return;
                        }
                        sendEmptyMessageDelayed(3, 25L);
                        com.oplus.camera.ag_renamed.this.a_renamed(2.0f);
                        return;
                    }
                }
                if (message.arg1 != 1) {
                    sendEmptyMessageDelayed(1, 25L);
                }
                com.oplus.camera.ag_renamed agVar = com.oplus.camera.ag_renamed.this;
                float fC_renamed = agVar.c_renamed(agVar.j_renamed);
                if (message.arg1 == 1 && com.oplus.camera.ag_renamed.this.H_renamed() && !com.oplus.camera.ag_renamed.this.E_renamed.b_renamed()) {
                    if (fC_renamed > com.oplus.camera.ag_renamed.this.f_renamed) {
                        dFloor = java.lang.Math.ceil(fC_renamed * 10.0f);
                    } else if (fC_renamed < com.oplus.camera.ag_renamed.this.f_renamed) {
                        dFloor = java.lang.Math.floor(fC_renamed * 10.0f);
                    }
                    fC_renamed = (float) (dFloor / 10.0d);
                }
                com.oplus.camera.ag_renamed.this.a_renamed(fC_renamed, fC_renamed, false, true);
                com.oplus.camera.ag_renamed.this.B_renamed.b_renamed(fC_renamed, false);
                if (com.oplus.camera.ag_renamed.this.H_renamed()) {
                    if (com.oplus.camera.ag_renamed.this.E_renamed.b_renamed()) {
                        com.oplus.camera.ag_renamed.this.E_renamed.setThumbText("");
                        if (com.oplus.camera.ag_renamed.this.H_renamed != null) {
                            com.oplus.camera.ag_renamed.this.H_renamed.setText(com.oplus.camera.ag_renamed.this.W_renamed());
                        }
                    } else if (message.arg1 != 1 || com.oplus.camera.ag_renamed.this.H_renamed == null) {
                        com.oplus.camera.ag_renamed.this.E_renamed.setThumbText(com.oplus.camera.ag_renamed.this.B_renamed.getCurrentDisplayText());
                    } else {
                        com.oplus.camera.ag_renamed.this.H_renamed.setText(com.oplus.camera.ag_renamed.this.W_renamed());
                        com.oplus.camera.ag_renamed.this.E_renamed.setThumbText(com.oplus.camera.ag_renamed.this.B_renamed.j_renamed(fC_renamed));
                    }
                }
                com.oplus.camera.ag_renamed.this.x_renamed = false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E_renamed() {
        com.oplus.camera.ag_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.r_renamed();
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
        if (xVar == null || i_renamed == xVar.getVisibility()) {
            return;
        }
        this.I_renamed.b_renamed(i_renamed, true);
        this.B_renamed.setZoomClickVisibility(i_renamed);
    }

    private void c_renamed(android.view.ViewGroup viewGroup) {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "initFocusChooseView");
        if (this.I_renamed == null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar);
            layoutParams.topMargin = this.L_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
            this.I_renamed = new com.oplus.camera.ui.x_renamed(this.L_renamed);
            this.I_renamed.setId(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click);
            this.I_renamed.setZoomUnit(this.B_renamed.getZoomValueUnit());
            this.I_renamed.setLayoutParams(layoutParams);
            this.C_renamed.addView(this.I_renamed);
            this.I_renamed.setVisibility(4);
            this.I_renamed.setListener(new com.oplus.camera.ui.x_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.16
                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public void a_renamed(float f_renamed) {
                    com.oplus.camera.ag_renamed.this.a_renamed(f_renamed, true);
                    if (com.oplus.camera.ag_renamed.this.B_renamed.A_renamed()) {
                        com.oplus.camera.ag_renamed.this.e_renamed(f_renamed);
                    }
                    if (a_renamed()) {
                        return;
                    }
                    if (f_renamed == com.oplus.camera.ag_renamed.this.k_renamed || f_renamed <= com.oplus.camera.ag_renamed.this.h_renamed) {
                        com.oplus.camera.ag_renamed.this.I_renamed.setFromClickView(false);
                    } else {
                        com.oplus.camera.ag_renamed.this.I_renamed.setFromClickView(true);
                    }
                    com.oplus.camera.ag_renamed.this.b_renamed(f_renamed, f_renamed);
                }

                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public void a_renamed(float f_renamed, boolean z_renamed) {
                    if (java.lang.Float.compare(com.oplus.camera.ag_renamed.f4106a, f_renamed) == 0) {
                        com.oplus.camera.j_renamed.a_renamed().g_renamed();
                    }
                    com.oplus.camera.ag_renamed.this.k_renamed = f_renamed;
                    if (com.oplus.camera.ag_renamed.this.P_renamed.g_renamed()) {
                        if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() || java.lang.Float.compare(f_renamed, com.oplus.camera.ag_renamed.f4106a) <= 0) {
                            if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() && java.lang.Float.compare(f_renamed, com.oplus.camera.ag_renamed.f4106a) <= 0) {
                                com.oplus.camera.ag_renamed.this.b_renamed(com.oplus.camera.ag_renamed.f4106a, z_renamed);
                            }
                        } else {
                            com.oplus.camera.ag_renamed.this.b_renamed(f_renamed, z_renamed);
                        }
                    }
                    if (com.oplus.camera.ag_renamed.this.P_renamed.h_renamed() && ((com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() && java.lang.Float.compare(f_renamed, 2.0f) < 0) || (!com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() && java.lang.Float.compare(f_renamed, 2.0f) >= 0 && !com.oplus.camera.ag_renamed.this.A_renamed.v_renamed()))) {
                        com.oplus.camera.ag_renamed.this.b_renamed(f_renamed, z_renamed);
                    }
                    if (com.oplus.camera.ag_renamed.this.A_renamed == null || !com.oplus.camera.ag_renamed.this.A_renamed.o_renamed()) {
                        return;
                    }
                    com.oplus.camera.ag_renamed.this.A_renamed.q_renamed();
                }

                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public boolean a_renamed() {
                    return com.oplus.camera.ag_renamed.this.O_renamed.R_renamed() || com.oplus.camera.ag_renamed.this.O_renamed.S_renamed();
                }

                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public void b_renamed() {
                    com.oplus.camera.ag_renamed.this.h_renamed(7);
                }

                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public void b_renamed(float f_renamed) {
                    com.oplus.camera.ag_renamed.this.A_renamed.b_renamed(f_renamed);
                }

                @Override // com.oplus.camera.ui.x_renamed.a_renamed
                public boolean c_renamed() {
                    return com.oplus.camera.ag_renamed.this.B_renamed.A_renamed();
                }
            });
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "initFocusChooseView X_renamed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float c_renamed(float f_renamed) {
        float f2 = this.f_renamed;
        float f3 = f4107b;
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(f2 + (((((f2 - f3) / (20.0f - f3)) * 0.47950003f) + 0.0152f) * (f_renamed / 5.0f)), this.h_renamed, this.i_renamed);
        if (java.lang.Float.compare(fA_renamed, this.h_renamed) == 0 && this.E_renamed.g_renamed() && java.lang.Float.compare(this.f_renamed, this.h_renamed) > 0) {
            G_renamed();
        }
        if (java.lang.Float.compare(fA_renamed, this.i_renamed) == 0 && this.E_renamed.f_renamed() && java.lang.Float.compare(this.f_renamed, this.i_renamed) < 0) {
            F_renamed();
        }
        return fA_renamed;
    }

    private void F_renamed() {
        com.oplus.camera.capmode.a_renamed aVar;
        com.oplus.camera.e_renamed.c_renamed("ZoomManager", "onMaxZoomValueResponsed");
        if (this.A_renamed != null && ((aVar = this.O_renamed) == null || !aVar.ao_renamed() || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
            this.A_renamed.p_renamed();
        }
        this.E_renamed.d_renamed();
    }

    private void G_renamed() {
        com.oplus.camera.capmode.a_renamed aVar;
        com.oplus.camera.e_renamed.c_renamed("ZoomManager", "onMinZoomValueResponsed");
        if (this.A_renamed != null && ((aVar = this.O_renamed) == null || !aVar.ao_renamed() || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
            this.A_renamed.p_renamed();
        }
        this.E_renamed.d_renamed();
    }

    private boolean a_renamed(android.view.View view, int i_renamed, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i_renamed >= i3 && i_renamed <= view.getMeasuredWidth() + i3;
    }

    public void a_renamed(com.oplus.camera.ag_renamed.a_renamed aVar) {
        this.A_renamed = aVar;
        this.B_renamed.setZoomListener(new com.oplus.camera.ag_renamed.c_renamed());
        if (this.K_renamed == null) {
            this.K_renamed = new com.oplus.camera.ab_renamed(this.L_renamed, new com.oplus.camera.ag_renamed.b_renamed());
        }
    }

    public float a_renamed() {
        return this.f_renamed;
    }

    public float b_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            if (u_renamed()) {
                this.B_renamed.setEnabled(true);
                this.I_renamed.setEnabled(true);
                return;
            }
            return;
        }
        this.B_renamed.setEnabled(false);
        this.I_renamed.setEnabled(false);
    }

    public void a_renamed(float f_renamed, boolean z_renamed) {
        if (this.y_renamed) {
            this.B_renamed.b_renamed(f_renamed, z_renamed);
            if (H_renamed()) {
                this.E_renamed.setThumbText(this.B_renamed.j_renamed(f_renamed));
            }
            com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
            if (rotableTextView != null) {
                rotableTextView.setText(this.B_renamed.j_renamed(f_renamed));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H_renamed() {
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        return inertiaZoomBar != null && inertiaZoomBar.getVisibility() == 0;
    }

    private void g_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (-1 == i_renamed && this.L_renamed != null) {
            i_renamed = this.q_renamed;
        }
        if (this.J_renamed != null) {
            int dimensionPixelSize = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_value_padding_bottom);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.J_renamed.getLayoutParams();
            if (i_renamed % 180 == 0) {
                this.J_renamed.setBottomMargin(dimensionPixelSize);
                return;
            }
            this.J_renamed.setBottomMargin(0);
            layoutParams.bottomMargin = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_land_display_text_bottom_margin);
            this.J_renamed.setLayoutParams(layoutParams);
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        int i3;
        int i4;
        int i5;
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "setOrientation, orientation: " + i_renamed + ", anim: " + z_renamed);
        this.B_renamed.c_renamed(i_renamed, z_renamed);
        g_renamed(i_renamed);
        if (this.J_renamed != null && this.B_renamed.A_renamed()) {
            this.J_renamed.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
        if (xVar != null) {
            xVar.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        if (rotableTextView != null && 1 != (i5 = this.r_renamed) && 4 != i5) {
            rotableTextView.a_renamed(i_renamed, z_renamed);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton = this.F_renamed;
        if (inertialZoomButton != null && inertialZoomButton.getVisibility() == 0 && 1 != (i4 = this.r_renamed) && 4 != i4) {
            this.F_renamed.a_renamed(i_renamed, z_renamed);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton2 = this.G_renamed;
        if (inertialZoomButton2 != null && inertialZoomButton2.getVisibility() == 0 && 1 != (i3 = this.r_renamed) && 4 != i3) {
            this.G_renamed.a_renamed(i_renamed, z_renamed);
        }
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        if (inertiaZoomBar != null && inertiaZoomBar.getVisibility() == 0 && 1 != (i2 = this.r_renamed) && 4 != i2) {
            this.E_renamed.a_renamed(i_renamed, z_renamed);
        }
        this.q_renamed = i_renamed;
    }

    public void a_renamed(float f_renamed) {
        this.j_renamed = f_renamed;
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "performShow, isSupportZoomMenu is_renamed false, so return");
        } else {
            this.B_renamed.a_renamed(!this.A_renamed.u_renamed(), z_renamed, z2);
        }
    }

    public void a_renamed(android.animation.AnimatorListenerAdapter animatorListenerAdapter, boolean z_renamed, boolean z2) {
        this.B_renamed.a_renamed(animatorListenerAdapter, z_renamed, z2);
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed != 0) {
            this.I_renamed.setVisibility(i_renamed);
            this.B_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        } else {
            this.B_renamed.a_renamed(false, true, false);
        }
    }

    public void c_renamed() {
        this.B_renamed.l_renamed();
        com.oplus.camera.ui.RotableTextView rotableTextView = this.J_renamed;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.J_renamed.setVisibility(4);
        }
        com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
        if (xVar != null) {
            xVar.clearAnimation();
            this.I_renamed.setVisibility(4);
        }
    }

    public void d_renamed() {
        this.B_renamed.m_renamed();
    }

    public void e_renamed() {
        com.oplus.camera.ui.preview.ai_renamed aiVar = this.B_renamed;
        if (aiVar != null) {
            aiVar.q_renamed();
        }
    }

    public void c_renamed(int i_renamed) {
        this.B_renamed.setLayoutDirection(i_renamed);
    }

    public boolean b_renamed(boolean z_renamed) {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "performCollapse, isSupportZoomMenu is_renamed false, so return");
            return false;
        }
        if (this.y_renamed && this.P_renamed.g_renamed() && (this.A_renamed.s_renamed() || java.lang.Float.compare(this.f_renamed, 1.0f) < 0)) {
            b_renamed(1.0f, 1.0f);
        }
        return this.B_renamed.b_renamed(z_renamed);
    }

    private void I_renamed() {
        this.D_renamed = (android.widget.LinearLayout) this.L_renamed.getLayoutInflater().inflate(ac_renamed(), (android.view.ViewGroup) null);
        this.D_renamed.setVisibility(8);
        this.E_renamed = (com.oplus.camera.ui.widget.InertiaZoomBar) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.inertial_zoom_bar);
        this.F_renamed = (com.oplus.camera.ui.widget.InertialZoomButton) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.inertial_zoom_minus_button);
        this.G_renamed = (com.oplus.camera.ui.widget.InertialZoomButton) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.inertial_zoom_plus_button);
        this.H_renamed = (com.oplus.camera.ui.RotableTextView) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.inertial_zoom_value_text);
        this.H_renamed.setShadowLayer(com.oplus.camera.util.Util.a_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a), 0.0f, 0.0f, this.M_renamed.getColor(com.oplus.camera.R_renamed.color.inertia_zoom_text_shadow_color, null));
        if (com.oplus.camera.util.Util.t_renamed()) {
            this.H_renamed.setAlpha(0.8f);
            this.H_renamed.setTextColor(-1);
        }
        this.E_renamed.setOnSeekBarListener(new com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed() { // from class: com.oplus.camera.ag_renamed.17
            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void a_renamed(float f_renamed) {
                float fD_renamed = com.oplus.camera.ag_renamed.this.d_renamed(f_renamed);
                if (java.lang.Float.compare(com.oplus.camera.ag_renamed.this.j_renamed, fD_renamed) == 0) {
                    return;
                }
                com.oplus.camera.ag_renamed.this.a_renamed(fD_renamed);
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void a_renamed() {
                if (java.lang.Float.compare(com.oplus.camera.ag_renamed.this.f_renamed, com.oplus.camera.ag_renamed.this.h_renamed) == 0) {
                    if (com.oplus.camera.ag_renamed.this.A_renamed != null && (com.oplus.camera.ag_renamed.this.O_renamed == null || !com.oplus.camera.ag_renamed.this.O_renamed.ao_renamed() || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
                        com.oplus.camera.ag_renamed.this.A_renamed.p_renamed();
                    }
                    com.oplus.camera.ag_renamed.this.E_renamed.d_renamed();
                }
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void b_renamed() {
                if (java.lang.Float.compare(com.oplus.camera.ag_renamed.this.f_renamed, com.oplus.camera.ag_renamed.this.i_renamed) == 0) {
                    if (com.oplus.camera.ag_renamed.this.A_renamed != null && com.oplus.camera.ag_renamed.this.A_renamed != null && (com.oplus.camera.ag_renamed.this.O_renamed == null || !com.oplus.camera.ag_renamed.this.O_renamed.ao_renamed() || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
                        com.oplus.camera.ag_renamed.this.A_renamed.p_renamed();
                    }
                    com.oplus.camera.ag_renamed.this.E_renamed.d_renamed();
                }
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void c_renamed() {
                com.oplus.camera.ag_renamed.this.E_renamed.e_renamed();
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void d_renamed() {
                com.oplus.camera.ag_renamed.this.E_renamed.e_renamed();
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void e_renamed() {
                if (!com.oplus.camera.ag_renamed.this.J_renamed()) {
                    com.oplus.camera.ag_renamed.this.m_renamed(true);
                }
                com.oplus.camera.ag_renamed.this.o_renamed(true);
            }

            @Override // com.oplus.camera.ui.widget.InertiaZoomBar.a_renamed
            public void f_renamed() {
                com.oplus.camera.ag_renamed.this.n_renamed(true);
                com.oplus.camera.ag_renamed.this.E_renamed.setThumbText(com.oplus.camera.ag_renamed.this.B_renamed.getCurrentDisplayText());
                com.oplus.camera.ag_renamed.this.E_renamed.a_renamed(true);
                com.oplus.camera.ag_renamed.this.E_renamed.c_renamed();
                if (!com.oplus.camera.ag_renamed.this.x_renamed) {
                    com.oplus.camera.ag_renamed.this.h_renamed(10);
                }
                com.oplus.camera.ag_renamed.this.L_renamed();
            }
        });
        this.E_renamed.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.oplus.camera.ag_renamed.18
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view) {
                com.oplus.camera.ag_renamed.this.E_renamed.c_renamed(true);
                com.oplus.camera.ag_renamed.this.E_renamed.e_renamed(true);
                com.oplus.camera.ag_renamed.this.E_renamed.b_renamed(true);
                com.oplus.camera.ag_renamed.this.E_renamed.setIsHighlight(true);
                com.oplus.camera.ag_renamed.this.H_renamed.setText(com.oplus.camera.ag_renamed.this.W_renamed());
                if (com.oplus.camera.ag_renamed.this.J_renamed()) {
                    return false;
                }
                com.oplus.camera.ag_renamed.this.m_renamed(true);
                return false;
            }
        });
        this.F_renamed.setOnInertialZoomButtonListener(new com.oplus.camera.ui.widget.InertialZoomButton.a_renamed() { // from class: com.oplus.camera.ag_renamed.19
            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.ag_renamed.this.X_renamed == null) {
                    com.oplus.camera.ag_renamed.this.K_renamed();
                }
                if (com.oplus.camera.ag_renamed.this.X_renamed.isRunning()) {
                    com.oplus.camera.ag_renamed.this.X_renamed.cancel();
                }
                float fA_renamed = com.oplus.camera.util.Util.a_renamed(new java.math.BigDecimal(java.lang.String.valueOf(com.oplus.camera.ag_renamed.this.f_renamed)).add(new java.math.BigDecimal(java.lang.String.valueOf(-0.1f))).floatValue(), com.oplus.camera.ag_renamed.this.h_renamed, com.oplus.camera.ag_renamed.this.i_renamed);
                com.oplus.camera.ag_renamed.this.X_renamed.setFloatValues(com.oplus.camera.ag_renamed.this.f_renamed, fA_renamed);
                com.oplus.camera.ag_renamed.this.X_renamed.start();
                com.oplus.camera.ag_renamed.this.a_renamed(fA_renamed, false);
            }

            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.ag_renamed.this.Z_renamed != null) {
                    com.oplus.camera.ag_renamed.this.Z_renamed.removeMessages(2);
                    com.oplus.camera.ag_renamed.this.Z_renamed.removeMessages(3);
                    com.oplus.camera.ag_renamed.this.Z_renamed.sendEmptyMessage(2);
                }
                com.oplus.camera.ag_renamed.this.o_renamed(false);
            }

            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void c_renamed() {
                com.oplus.camera.ag_renamed.this.L_renamed();
                com.oplus.camera.ag_renamed.this.h_renamed(11);
            }
        });
        this.G_renamed.setOnInertialZoomButtonListener(new com.oplus.camera.ui.widget.InertialZoomButton.a_renamed() { // from class: com.oplus.camera.ag_renamed.20
            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.ag_renamed.this.X_renamed == null) {
                    com.oplus.camera.ag_renamed.this.K_renamed();
                }
                if (com.oplus.camera.ag_renamed.this.X_renamed.isRunning()) {
                    com.oplus.camera.ag_renamed.this.X_renamed.cancel();
                }
                float fA_renamed = com.oplus.camera.util.Util.a_renamed(new java.math.BigDecimal(java.lang.String.valueOf(com.oplus.camera.ag_renamed.this.f_renamed)).add(new java.math.BigDecimal(java.lang.String.valueOf(0.1f))).floatValue(), com.oplus.camera.ag_renamed.this.h_renamed, com.oplus.camera.ag_renamed.this.i_renamed);
                com.oplus.camera.ag_renamed.this.X_renamed.setFloatValues(com.oplus.camera.ag_renamed.this.f_renamed, fA_renamed);
                com.oplus.camera.ag_renamed.this.X_renamed.start();
                com.oplus.camera.ag_renamed.this.a_renamed(fA_renamed, false);
            }

            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.ag_renamed.this.Z_renamed != null) {
                    com.oplus.camera.ag_renamed.this.Z_renamed.removeMessages(2);
                    com.oplus.camera.ag_renamed.this.Z_renamed.removeMessages(3);
                    com.oplus.camera.ag_renamed.this.Z_renamed.sendEmptyMessage(3);
                }
                com.oplus.camera.ag_renamed.this.o_renamed(false);
            }

            @Override // com.oplus.camera.ui.widget.InertialZoomButton.a_renamed
            public void c_renamed() {
                com.oplus.camera.ag_renamed.this.L_renamed();
                com.oplus.camera.ag_renamed.this.h_renamed(11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J_renamed() {
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        return rotableTextView != null && rotableTextView.getVisibility() == 0 && java.lang.Float.compare(this.H_renamed.getAlpha(), 1.0f) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed(boolean z_renamed) {
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        if (rotableTextView == null) {
            return;
        }
        rotableTextView.setText(W_renamed());
        this.H_renamed.setVisibility(0);
        if (z_renamed) {
            android.view.animation.Animation animation = this.H_renamed.getAnimation();
            if (animation == null || animation.hasEnded()) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.H_renamed, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.an_renamed);
                objectAnimatorOfFloat.setDuration(183L);
                objectAnimatorOfFloat.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ag_renamed.21
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.ag_renamed.this.H_renamed.setVisibility(0);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            return;
        }
        this.H_renamed.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed(boolean z_renamed) {
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        if (rotableTextView == null) {
            return;
        }
        if (z_renamed) {
            android.view.animation.Animation animation = rotableTextView.getAnimation();
            if (animation == null || animation.hasEnded()) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.H_renamed, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.an_renamed);
                objectAnimatorOfFloat.setDuration(183L);
                objectAnimatorOfFloat.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ag_renamed.22
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.ag_renamed.this.H_renamed.setVisibility(8);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            return;
        }
        rotableTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K_renamed() {
        this.X_renamed = new android.animation.ValueAnimator();
        this.X_renamed.setDuration(100L);
        this.X_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.L_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_in));
        this.X_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.-$$Lambda$ag_renamed$VfCu1CbVzuM9fM0MPTBNn2CQhtE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        this.X_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.2
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.h_renamed(12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        float f_renamed = f4106a;
        if (f_renamed > fFloatValue) {
            fFloatValue = f_renamed;
        }
        a_renamed(fFloatValue, fFloatValue, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed(boolean z_renamed) {
        if (this.A_renamed != null) {
            com.oplus.camera.capmode.a_renamed aVar = this.O_renamed;
            if (aVar == null || !aVar.ao_renamed() || (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE))) {
                this.A_renamed.p_renamed();
            }
            this.A_renamed.i_renamed();
            this.A_renamed.a_renamed(true);
        }
        this.E_renamed.a_renamed(z_renamed);
        android.os.Handler handler = this.Z_renamed;
        if (handler != null) {
            this.x_renamed = true;
            handler.removeMessages(1);
            this.Z_renamed.sendEmptyMessageDelayed(1, 25L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L_renamed() {
        android.os.Handler handler = this.Z_renamed;
        if (handler != null) {
            this.x_renamed = false;
            handler.removeCallbacksAndMessages(null);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 1;
            messageObtain.arg1 = 1;
            this.Z_renamed.sendMessageDelayed(messageObtain, 25L);
        }
        com.oplus.camera.ag_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.j_renamed();
            this.A_renamed.a_renamed(false);
        }
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_value_height));
        layoutParams.addRule(2, this.B_renamed.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_value_padding_bottom);
        this.J_renamed = new com.oplus.camera.ui.RotableTextView(this.L_renamed);
        this.J_renamed.setId(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_display_text);
        this.J_renamed.setTextColor(-1);
        this.J_renamed.setTypeface(com.oplus.camera.util.Util.y_renamed());
        this.J_renamed.setShadowLayer(com.oplus.camera.util.Util.a_renamed(com.oplus.camera.MyApplication.d_renamed(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a), 0.0f, 0.0f, this.M_renamed.getColor(com.oplus.camera.R_renamed.color.inertia_zoom_text_shadow_color));
        this.J_renamed.setTextSize(0, this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_display_text_size));
        this.J_renamed.setVisibility(8);
        this.J_renamed.setAlpha(0.8f);
        this.J_renamed.a_renamed(this.q_renamed, false);
        this.J_renamed.setGravity(17);
        this.C_renamed.addView(this.J_renamed, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed(float f_renamed) {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar != null && afVar.g_renamed() && (java.lang.Float.compare(this.B_renamed.getCurrentZoom(), 1.0f) < 0 || java.lang.Float.compare(f_renamed, 1.0f) < 0)) {
            this.J_renamed.setText(this.B_renamed.k_renamed(f4106a));
        } else {
            this.J_renamed.setText(this.B_renamed.k_renamed(f_renamed));
        }
        if (this.t_renamed || !this.B_renamed.A_renamed()) {
            return;
        }
        M_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed(float f_renamed) {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar != null && afVar.g_renamed() && (java.lang.Float.compare(this.B_renamed.getCurrentZoom(), 1.0f) < 0 || java.lang.Float.compare(f_renamed, 1.0f) < 0)) {
            this.J_renamed.setText(this.B_renamed.k_renamed(f4106a));
        } else {
            this.J_renamed.setText(this.B_renamed.k_renamed(f_renamed));
        }
    }

    private void M_renamed() {
        com.oplus.camera.ag_renamed.a_renamed aVar = this.A_renamed;
        if (aVar == null || !aVar.A_renamed()) {
            this.t_renamed = true;
            this.J_renamed.clearAnimation();
            android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, this.m_renamed, 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.L_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_in));
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.L_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_point_alpha));
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ag_renamed.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    if (com.oplus.camera.ag_renamed.this.J_renamed != null) {
                        com.oplus.camera.ag_renamed.this.J_renamed.a_renamed(com.oplus.camera.ag_renamed.this.q_renamed, false);
                        com.oplus.camera.ag_renamed.this.J_renamed.setVisibility(0);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    if (com.oplus.camera.ag_renamed.this.J_renamed == null || !com.oplus.camera.ag_renamed.this.t_renamed) {
                        return;
                    }
                    com.oplus.camera.ag_renamed.this.J_renamed.clearAnimation();
                }
            });
            this.J_renamed.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N_renamed() {
        this.t_renamed = false;
        this.J_renamed.clearAnimation();
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, this.o_renamed);
        translateAnimation.setDuration(500L);
        translateAnimation.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.L_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_out));
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.8f, 0.0f);
        alphaAnimation.setDuration(250L);
        alphaAnimation.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.L_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_point_alpha));
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ag_renamed.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (com.oplus.camera.ag_renamed.this.J_renamed == null || !com.oplus.camera.ag_renamed.this.t_renamed) {
                    return;
                }
                com.oplus.camera.ag_renamed.this.J_renamed.clearAnimation();
                com.oplus.camera.ag_renamed.this.J_renamed.setVisibility(4);
            }
        });
        this.J_renamed.startAnimation(animationSet);
    }

    public void b_renamed(final android.view.ViewGroup viewGroup) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        android.widget.RelativeLayout.LayoutParams layoutParams2;
        if (viewGroup == null) {
            return;
        }
        final android.view.View viewFindViewById = this.L_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button);
        this.C_renamed = new android.widget.RelativeLayout(this.L_renamed);
        this.C_renamed.setId(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container);
        this.C_renamed.setClipChildren(false);
        if (com.oplus.camera.util.Util.t_renamed() && 1 == this.r_renamed) {
            int dimensionPixelSize = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
            int dimensionPixelSize2 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
            int dimensionPixelSize3 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_margin_bottom);
            int dimensionPixelSize4 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_width);
            this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size);
            int i_renamed = this.s_renamed;
            if (i_renamed == 90) {
                int dimensionPixelSize5 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90);
                layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins((-dimensionPixelSize) / 2, 0, 0, dimensionPixelSize5 + (dimensionPixelSize / 2));
                this.C_renamed.setRotation(90.0f);
            } else if (i_renamed == 270) {
                int dimensionPixelSize6 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90);
                layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, (-dimensionPixelSize) / 2, dimensionPixelSize6 + (dimensionPixelSize / 2));
                this.C_renamed.setRotation(270.0f);
            } else {
                int dimensionPixelSize7 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_full_margin_bottom);
                int dimensionPixelSize8 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_margin_bottom);
                dimensionPixelSize4 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_focus_circle_width);
                layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins((-dimensionPixelSize) / 2, 0, 0, dimensionPixelSize7 + (dimensionPixelSize / 2) + com.oplus.camera.util.Util.Z_renamed());
                this.C_renamed.setRotation(90.0f);
                dimensionPixelSize3 = dimensionPixelSize8;
            }
            layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, dimensionPixelSize);
            ((com.oplus.camera.ui.preview.af_renamed) this.B_renamed).a_renamed(dimensionPixelSize * 2, dimensionPixelSize, dimensionPixelSize2, (dimensionPixelSize - (dimensionPixelSize4 / 2)) - dimensionPixelSize3, 0.0f, 2.0f, 0.0f);
        } else {
            int dimensionPixelSize9 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_bg_circle_radius);
            int dimensionPixelSize10 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_seekbar_switch_bar_radius);
            int dimensionPixelSize11 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_arc_seekbar_focus_circle_center_y);
            int dimensionPixelSize12 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            layoutParams.bottomMargin = (-this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_mark_button_size)) - this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_margin_top);
            layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, this.B_renamed.getLayoutHeight());
            ((com.oplus.camera.ui.preview.af_renamed) this.B_renamed).a_renamed(this.O_renamed.aU_renamed().b_renamed(), dimensionPixelSize9, dimensionPixelSize10, dimensionPixelSize11, (com.oplus.camera.util.Util.P_renamed() + dimensionPixelSize12) / 2.0f, 1.0f, 0.0f);
        }
        this.C_renamed.addView(this.B_renamed, 0, layoutParams2);
        this.B_renamed.setVisibility(4);
        android.view.View view = new android.view.View(this.L_renamed);
        view.setId(com.oplus.camera.R_renamed.id_renamed.zoom_seek_anchor_view);
        view.setWillNotDraw(true);
        view.setVisibility(4);
        this.C_renamed.addView(view, 1);
        viewGroup.addView(this.C_renamed, viewGroup.indexOfChild(viewFindViewById), layoutParams);
        a_renamed(viewGroup);
        c_renamed(viewGroup);
        if (viewFindViewById.isShown()) {
            final int dimensionPixelSize13 = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_extra_touch_offset);
            viewGroup.post(new java.lang.Runnable() { // from class: com.oplus.camera.ag_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    android.graphics.Rect rect = new android.graphics.Rect();
                    viewFindViewById.getHitRect(rect);
                    if (dimensionPixelSize13 > 0) {
                        rect.top -= dimensionPixelSize13;
                        rect.bottom += dimensionPixelSize13;
                        rect.left -= dimensionPixelSize13;
                        rect.right += dimensionPixelSize13;
                        viewGroup.setTouchDelegate(new android.view.TouchDelegate(rect, viewFindViewById));
                    }
                }
            });
        }
    }

    public void c_renamed(boolean z_renamed) {
        android.widget.RelativeLayout relativeLayout = this.C_renamed;
        if (relativeLayout != null) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(relativeLayout, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
            } else {
                relativeLayout.setVisibility(4);
            }
        }
    }

    public void d_renamed(boolean z_renamed) {
        android.widget.RelativeLayout relativeLayout = this.C_renamed;
        if (relativeLayout != null) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(relativeLayout, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            } else {
                relativeLayout.setVisibility(0);
            }
        }
    }

    public android.view.View f_renamed() {
        return this.C_renamed;
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "showZoomSeekBarAfterInertialZoom");
        if (X_renamed()) {
            this.T_renamed.cancel();
        }
        if (this.U_renamed == null) {
            O_renamed();
        }
        android.os.Handler handler = this.Z_renamed;
        if (handler != null) {
            handler.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ag_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ag_renamed.this.B_renamed != null) {
                        if (!com.oplus.camera.util.Util.t_renamed()) {
                            com.oplus.camera.ag_renamed.this.B_renamed.setAlpha(0.0f);
                        }
                        com.oplus.camera.ag_renamed.this.B_renamed.setVisibility(0);
                    }
                }
            }, 150L);
        }
        this.U_renamed.start();
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "hideZoomSeekBarBeforeInertialZoom");
        if (m_renamed()) {
            a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            return;
        }
        android.animation.AnimatorSet animatorSet = this.U_renamed;
        if (animatorSet != null && animatorSet.isStarted() && this.U_renamed.isRunning()) {
            this.U_renamed.cancel();
        }
        if (this.T_renamed == null) {
            P_renamed();
        }
        this.T_renamed.start();
    }

    public void i_renamed() {
        android.widget.LinearLayout linearLayout = this.D_renamed;
        if (linearLayout != null) {
            this.Y_renamed.removeView(linearLayout);
            this.D_renamed = null;
        }
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "showInertialZoomView, animation: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.V_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.V_renamed.cancel();
        }
        if (this.Y_renamed == null) {
            return;
        }
        if (this.D_renamed == null) {
            I_renamed();
        }
        e_renamed(this.r_renamed);
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.a_renamed();
            if (this.B_renamed.C_renamed()) {
                this.E_renamed.setThumbText(this.B_renamed.getSlideToDisplayText());
            } else {
                this.E_renamed.setThumbText(this.B_renamed.getCurrentDisplayText());
            }
        }
        int i_renamed = this.r_renamed;
        if (1 == i_renamed || 4 == i_renamed) {
            ae_renamed();
        } else {
            ad_renamed();
        }
        if (z_renamed) {
            if (this.W_renamed == null) {
                int i2 = this.r_renamed;
                if (1 == i2 || 4 == i2) {
                    R_renamed();
                } else {
                    Q_renamed();
                }
            }
            this.D_renamed.setAlpha(0.0f);
            this.D_renamed.setVisibility(0);
            this.W_renamed.start();
        } else {
            this.D_renamed.setVisibility(0);
        }
        this.w_renamed = true;
    }

    public void f_renamed(boolean z_renamed) {
        android.widget.LinearLayout linearLayout;
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "hideInertialZoomView, anim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.W_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.W_renamed.cancel();
        }
        if (this.Y_renamed == null || (linearLayout = this.D_renamed) == null) {
            return;
        }
        if (z_renamed) {
            if (this.V_renamed == null) {
                int i_renamed = this.r_renamed;
                if (1 == i_renamed || 4 == i_renamed) {
                    T_renamed();
                } else {
                    S_renamed();
                }
            }
            this.V_renamed.start();
        } else {
            linearLayout.setVisibility(8);
        }
        this.w_renamed = false;
    }

    private void O_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.B_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(400L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.B_renamed, "translationY", -this.n_renamed, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(400L);
        this.U_renamed = new android.animation.AnimatorSet();
        this.U_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.U_renamed.setStartDelay(150L);
        this.U_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.7
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.B_renamed != null) {
                    com.oplus.camera.ag_renamed.this.B_renamed.setVisibility(0);
                    com.oplus.camera.ag_renamed.this.B_renamed.setAlpha(1.0f);
                }
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.B_renamed != null) {
                    com.oplus.camera.ag_renamed.this.B_renamed.setVisibility(0);
                    com.oplus.camera.ag_renamed.this.B_renamed.setAlpha(1.0f);
                }
            }
        });
        this.U_renamed.setStartDelay(150L);
    }

    private void P_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.B_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.B_renamed, "translationY", 0.0f, -this.n_renamed);
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(400L);
        this.T_renamed = new android.animation.AnimatorSet();
        this.T_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.T_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.8
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.B_renamed.setVisibility(4);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.B_renamed.setVisibility(4);
            }
        });
    }

    private void Q_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(300L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationY", this.n_renamed, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(300L);
        this.W_renamed = new android.animation.AnimatorSet();
        this.W_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.W_renamed.setStartDelay(150L);
        this.W_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.9
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(0.0f);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(1.0f);
                com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(0);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(0);
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(1.0f);
            }
        });
        this.W_renamed.setStartDelay(150L);
    }

    private void R_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(300L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationX", -this.n_renamed, 0.0f);
        if (270 == this.s_renamed && 4 != this.r_renamed) {
            objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationX", this.n_renamed, 0.0f);
        }
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(300L);
        this.W_renamed = new android.animation.AnimatorSet();
        this.W_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.W_renamed.setStartDelay(150L);
        this.W_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.10
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(0.0f);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(1.0f);
                com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(0);
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(0);
                com.oplus.camera.ag_renamed.this.D_renamed.setAlpha(1.0f);
            }
        });
        this.W_renamed.setStartDelay(150L);
    }

    private void S_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationY", 0.0f, this.n_renamed);
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(300L);
        this.V_renamed = new android.animation.AnimatorSet();
        this.V_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.V_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.11
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.D_renamed != null) {
                    com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(4);
                    com.oplus.camera.ag_renamed.this.Y_renamed.removeView(com.oplus.camera.ag_renamed.this.D_renamed);
                }
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.D_renamed != null) {
                    com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(4);
                    com.oplus.camera.ag_renamed.this.Y_renamed.removeView(com.oplus.camera.ag_renamed.this.D_renamed);
                }
            }
        });
    }

    private void T_renamed() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.an_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationX", 0.0f, -this.n_renamed);
        if (270 == this.s_renamed && 4 != this.r_renamed) {
            objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.D_renamed, "translationX", 0.0f, this.n_renamed);
        }
        objectAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        objectAnimatorOfFloat2.setDuration(300L);
        this.V_renamed = new android.animation.AnimatorSet();
        this.V_renamed.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.V_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ag_renamed.13
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.D_renamed != null) {
                    com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(4);
                    com.oplus.camera.ag_renamed.this.Y_renamed.removeView(com.oplus.camera.ag_renamed.this.D_renamed);
                }
            }

            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (com.oplus.camera.ag_renamed.this.D_renamed != null) {
                    com.oplus.camera.ag_renamed.this.D_renamed.setVisibility(4);
                    com.oplus.camera.ag_renamed.this.Y_renamed.removeView(com.oplus.camera.ag_renamed.this.D_renamed);
                }
            }
        });
    }

    public float a_renamed(float f_renamed, float f2) {
        com.oplus.camera.af_renamed afVar;
        if (this.i_renamed < 1.0f) {
            return 0.0f;
        }
        float f3 = f_renamed + ((f2 / this.l_renamed) * 0.1f);
        float f4 = this.h_renamed;
        if (this.v_renamed && (afVar = this.P_renamed) != null && afVar.g_renamed() && !this.P_renamed.p_renamed()) {
            f4 = f4106a;
        }
        return com.oplus.camera.util.Util.a_renamed(f3, f4, this.i_renamed);
    }

    public boolean j_renamed() {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "isZoomMenuExpand, isSupportZoomMenu is_renamed false, so return");
            return false;
        }
        return this.B_renamed.A_renamed();
    }

    public boolean k_renamed() {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "isZoomMenuExpand, isSupportZoomMenu is_renamed false, so return");
            return false;
        }
        return this.B_renamed.B_renamed();
    }

    public float l_renamed() {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "getZoomVelocityRate, isSupportZoomMenu is_renamed false, so return");
            return 0.0f;
        }
        return this.B_renamed.getVelocityRate();
    }

    public boolean m_renamed() {
        if (!u_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ZoomManager", "isZoomMenuCollapsing, isSupportZoomMenu is_renamed false, so return");
            return false;
        }
        return this.B_renamed.z_renamed();
    }

    public void n_renamed() {
        if (this.y_renamed) {
            com.oplus.camera.ui.RotableTextView rotableTextView = this.J_renamed;
            if (rotableTextView != null) {
                rotableTextView.clearAnimation();
                this.J_renamed.setVisibility(8);
            }
            com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
            if (xVar != null) {
                xVar.setVisibility(8);
            }
            android.animation.ValueAnimator valueAnimator = this.R_renamed;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            android.animation.ValueAnimator valueAnimator2 = this.S_renamed;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            android.os.Handler handler = this.Z_renamed;
            if (handler != null) {
                this.x_renamed = false;
                handler.removeCallbacksAndMessages(null);
            }
            this.B_renamed.m_renamed();
            this.t_renamed = false;
            this.B_renamed.r_renamed();
            this.u_renamed = false;
            if (!this.A_renamed.a_renamed()) {
                this.B_renamed.setVisibility(8);
            }
            e_renamed();
        }
    }

    public void a_renamed(float f_renamed, float f2, float f3, android.graphics.Rect rect, com.oplus.camera.af_renamed afVar, boolean z_renamed) {
        com.oplus.camera.af_renamed afVar2;
        this.y_renamed = true;
        this.Q_renamed = rect;
        this.P_renamed = afVar;
        this.g_renamed = this.f_renamed;
        this.f_renamed = f3;
        this.h_renamed = f_renamed;
        this.i_renamed = f2;
        com.oplus.camera.af_renamed afVar3 = this.P_renamed;
        boolean zO = afVar3 != null ? afVar3.o_renamed() : false;
        this.d_renamed = new java.util.ArrayList<>();
        this.e_renamed.clear();
        float fN_renamed = 2.0f;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM) && zO) {
            this.d_renamed.add(java.lang.Float.valueOf(1.0f));
            this.d_renamed.add(java.lang.Float.valueOf(2.0f));
        } else {
            com.oplus.camera.af_renamed afVar4 = this.P_renamed;
            if (afVar4 != null && ((afVar4.m_renamed() && this.P_renamed.n_renamed()) || this.P_renamed.w_renamed() || ((this.P_renamed.u_renamed() && this.P_renamed.g_renamed()) || this.P_renamed.M_renamed() || this.P_renamed.G_renamed()))) {
                this.d_renamed.add(java.lang.Float.valueOf(f4106a));
                this.d_renamed.add(java.lang.Float.valueOf(1.0f));
                this.e_renamed.add(java.lang.Float.valueOf(1.0f));
            } else {
                if (java.lang.Float.compare(this.h_renamed, 1.0f) < 0) {
                    this.d_renamed.add(java.lang.Float.valueOf(new java.math.BigDecimal(this.h_renamed).setScale(1, 1).floatValue()));
                    this.e_renamed.add(java.lang.Float.valueOf(new java.math.BigDecimal(this.h_renamed).setScale(1, 1).floatValue()));
                } else if (z_renamed && (afVar2 = this.P_renamed) != null && afVar2.g_renamed() && !this.P_renamed.p_renamed()) {
                    this.d_renamed.add(java.lang.Float.valueOf(f4106a));
                }
                if (java.lang.Float.compare(this.h_renamed, 1.0f) <= 0) {
                    this.d_renamed.add(java.lang.Float.valueOf(1.0f));
                }
                com.oplus.camera.af_renamed afVar5 = this.P_renamed;
                if (afVar5 != null) {
                    if (afVar5.y_renamed()) {
                        fN_renamed = 3.0f;
                    } else if (java.lang.Float.compare(this.P_renamed.N_renamed(), 0.0f) != 0) {
                        fN_renamed = this.P_renamed.N_renamed();
                    }
                }
                if (!zO && java.lang.Float.compare(this.i_renamed, fN_renamed) >= 0) {
                    com.oplus.camera.af_renamed afVar6 = this.P_renamed;
                    if (afVar6 != null && afVar6.z_renamed() && fN_renamed != 5.0f && fN_renamed != 10.0f) {
                        this.d_renamed.add(java.lang.Float.valueOf(fN_renamed));
                    }
                    if (java.lang.Float.compare(this.i_renamed, 5.0f) >= 0) {
                        this.d_renamed.add(java.lang.Float.valueOf(5.0f));
                        if (java.lang.Float.compare(this.i_renamed, 20.0f) >= 0) {
                            this.d_renamed.add(java.lang.Float.valueOf(10.0f));
                        }
                    }
                }
                if (java.lang.Float.compare(this.h_renamed, 1.0f) <= 0) {
                    this.e_renamed.add(java.lang.Float.valueOf(1.0f));
                }
                com.oplus.camera.af_renamed afVar7 = this.P_renamed;
                if (afVar7 != null && afVar7.z_renamed()) {
                    this.e_renamed.add(java.lang.Float.valueOf(fN_renamed));
                }
                if (java.lang.Float.compare(this.i_renamed, 8.0f) >= 0) {
                    this.e_renamed.add(java.lang.Float.valueOf(5.0f));
                    if (java.lang.Float.compare(this.i_renamed, 10.0f) > 0) {
                        this.e_renamed.add(java.lang.Float.valueOf(10.0f));
                    }
                }
            }
        }
        com.oplus.camera.af_renamed afVar8 = this.P_renamed;
        if (afVar8 != null) {
            this.B_renamed.setCustomUltraWideIcon(afVar8.q_renamed());
            this.B_renamed.setCustomWideIcon(this.P_renamed.r_renamed());
            this.B_renamed.setCustomTeleIcon(this.P_renamed.s_renamed());
            this.B_renamed.setDisplayMode(this.P_renamed.t_renamed() ? com.oplus.camera.ui.preview.ai_renamed.a_renamed.ICON_ONLY : com.oplus.camera.ui.preview.ai_renamed.a_renamed.NORMAL);
        }
        com.oplus.camera.af_renamed afVar9 = this.P_renamed;
        int iF = (afVar9 == null || !afVar9.E_renamed()) ? 1 : this.P_renamed.F_renamed();
        com.oplus.camera.af_renamed afVar10 = this.P_renamed;
        boolean zI = afVar10 != null ? afVar10.I_renamed() : false;
        com.oplus.camera.af_renamed afVar11 = this.P_renamed;
        boolean zJ = afVar11 != null ? afVar11.J_renamed() : false;
        boolean zA = this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH);
        boolean zB = this.A_renamed.B_renamed();
        com.oplus.camera.capmode.a_renamed aVar = this.O_renamed;
        int iAw = aVar != null ? aVar.aw_renamed() : 0;
        java.lang.String strN = this.A_renamed.n_renamed();
        com.oplus.camera.af_renamed afVar12 = this.P_renamed;
        boolean zM = afVar12 != null ? afVar12.m_renamed() : false;
        com.oplus.camera.af_renamed afVar13 = this.P_renamed;
        boolean zQ = afVar13 != null ? afVar13.Q_renamed() : false;
        boolean zU = u_renamed();
        com.oplus.camera.af_renamed afVar14 = this.P_renamed;
        boolean zP = afVar14 != null ? afVar14.p_renamed() : false;
        com.oplus.camera.af_renamed afVar15 = this.P_renamed;
        boolean zG = afVar15 != null ? afVar15.g_renamed() : false;
        boolean z2 = (zI == this.af_renamed && zJ == this.ag_renamed && iAw == this.ad_renamed && strN.equals(this.ae_renamed) && zM == this.ah_renamed && zG == this.v_renamed && zQ == this.ai_renamed && (zU == this.ak_renamed || strN.equals(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO)) && zP == this.aj_renamed) ? false : true;
        this.ad_renamed = iAw;
        this.ae_renamed = strN;
        this.af_renamed = zI;
        this.ag_renamed = zJ;
        this.ah_renamed = zM;
        this.v_renamed = zG;
        this.ai_renamed = zQ;
        this.ak_renamed = zU;
        this.aj_renamed = zP;
        this.B_renamed.a_renamed(U_renamed() ? f4106a : this.f_renamed, this.h_renamed, this.i_renamed, this.e_renamed, this.d_renamed, iF, zA, zB, z2);
        if (!this.I_renamed.isShown() || !zO) {
            this.I_renamed.a_renamed(U_renamed() ? f4106a : this.f_renamed, this.d_renamed, this.q_renamed, iF);
        }
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "initialize, mMinZoomValue: " + this.h_renamed + ", mMaxZoomValue: " + this.i_renamed + ", mCurrentZoomValue: " + this.f_renamed + ", mClickPoints: " + this.d_renamed.toString());
    }

    private boolean U_renamed() {
        return this.A_renamed.s_renamed() || this.A_renamed.w_renamed() || B_renamed() || ab_renamed();
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        if (this.K_renamed == null || !w_renamed()) {
            return false;
        }
        if (this.A_renamed.a_renamed() || aa_renamed()) {
            if (motionEvent.getPointerCount() >= 2) {
                this.K_renamed.a_renamed(motionEvent);
            }
            return !aa_renamed() && this.K_renamed.a_renamed();
        }
        if ((!this.K_renamed.a_renamed() || 2 > motionEvent.getPointerCount() || 6 != motionEvent.getAction()) && 262 != motionEvent.getAction()) {
            return false;
        }
        this.K_renamed.a_renamed(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(float f_renamed, boolean z_renamed) {
        java.lang.String str;
        if (!this.A_renamed.e_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ZoomManager", "handleMessage, cancel click");
            return;
        }
        float f2 = this.f_renamed;
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        str = "on_renamed";
        if (afVar != null && afVar.h_renamed()) {
            if (!this.A_renamed.t_renamed() && java.lang.Float.compare(2.0f, f_renamed) <= 0) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on_renamed").apply();
            } else if (this.A_renamed.t_renamed() && java.lang.Float.compare(2.0f, f_renamed) > 0) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
            }
        }
        com.oplus.camera.af_renamed afVar2 = this.P_renamed;
        if (afVar2 != null && (afVar2.k_renamed() || this.P_renamed.l_renamed())) {
            b_renamed(f_renamed, f_renamed);
            str = java.lang.Float.compare(2.0f, f_renamed) != 0 ? "off" : "on_renamed";
            if (this.P_renamed.k_renamed()) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY, str).apply();
            } else if (this.P_renamed.l_renamed()) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, str).apply();
            }
        } else {
            com.oplus.camera.af_renamed afVar3 = this.P_renamed;
            if (afVar3 != null && afVar3.m_renamed()) {
                if (java.lang.Float.compare(f4106a, f_renamed) == 0) {
                    f_renamed = 1.0f;
                } else {
                    str = "off";
                }
                b_renamed(f_renamed, f_renamed);
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, str).apply();
            } else {
                com.oplus.camera.af_renamed afVar4 = this.P_renamed;
                if (afVar4 != null && afVar4.u_renamed() && this.P_renamed.g_renamed()) {
                    this.N_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, !this.N_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true)).apply();
                } else if (java.lang.Float.compare(f4106a, f_renamed) == 0) {
                    com.oplus.camera.af_renamed afVar5 = this.P_renamed;
                    if (afVar5 != null) {
                        if (afVar5.d_renamed()) {
                            b_renamed(f_renamed, f_renamed);
                        } else if (this.P_renamed.g_renamed()) {
                            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
                            V_renamed();
                            b_renamed(1.0f, f_renamed);
                        } else if (this.P_renamed.M_renamed()) {
                            this.A_renamed.b_renamed(true);
                            b_renamed(1.0f, f_renamed);
                        } else if (this.P_renamed.G_renamed()) {
                            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_MODE, "off").apply();
                            s_renamed();
                        }
                    }
                } else {
                    com.oplus.camera.af_renamed afVar6 = this.P_renamed;
                    if (afVar6 != null) {
                        if (afVar6.g_renamed() && this.N_renamed.contains(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && this.A_renamed.s_renamed()) {
                            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                            V_renamed();
                        } else if (this.P_renamed.M_renamed()) {
                            this.A_renamed.b_renamed(false);
                        } else if (this.P_renamed.G_renamed()) {
                            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_MODE, "on_renamed").apply();
                            s_renamed();
                        }
                    }
                    for (int i_renamed = 1; i_renamed <= 1; i_renamed++) {
                        b_renamed(((f_renamed - f2) * this.am_renamed.getInterpolation(i_renamed / 1)) + f2, f_renamed);
                    }
                }
            }
        }
        if (z_renamed) {
            h_renamed(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V_renamed() {
        if ("on_renamed".equals(this.N_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
        }
    }

    public void o_renamed() {
        if (!this.A_renamed.e_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ZoomManager", "handleMessage, cancel click");
            return;
        }
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar != null && afVar.m_renamed()) {
            this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "on_renamed").apply();
        } else {
            com.oplus.camera.af_renamed afVar2 = this.P_renamed;
            if (afVar2 != null && afVar2.g_renamed()) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
            }
        }
        a_renamed(f4106a, false);
        float f_renamed = f4106a;
        b_renamed(f_renamed, f_renamed);
        h_renamed(8);
    }

    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.af_renamed afVar;
        if (Y_renamed()) {
            if (H_renamed() && this.E_renamed.b_renamed()) {
                return;
            }
            com.oplus.camera.af_renamed afVar2 = this.P_renamed;
            if (afVar2 == null || !afVar2.f_renamed() || (!this.O_renamed.ao_renamed() && z_renamed)) {
                com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
                if (xVar != null) {
                    xVar.setFromClickView(false);
                }
                float fFloatValue = new java.math.BigDecimal(java.lang.String.valueOf(java.lang.Math.round((this.f_renamed + (z_renamed ? 0.1f : -0.1f)) * 100.0f) / 100.0f)).setScale(1, 1).floatValue();
                float f_renamed = this.h_renamed;
                float f2 = fFloatValue + 1.0E-5f;
                if (this.v_renamed && (afVar = this.P_renamed) != null && afVar.g_renamed() && !this.P_renamed.p_renamed() && (this.P_renamed.d_renamed() || !this.O_renamed.ao_renamed())) {
                    f_renamed = f4106a;
                }
                float fA_renamed = com.oplus.camera.util.Util.a_renamed(f2, f_renamed, this.i_renamed);
                if (this.f_renamed == fA_renamed) {
                    return;
                }
                h_renamed(3);
                com.oplus.camera.af_renamed afVar3 = this.P_renamed;
                if (afVar3 != null && afVar3.h_renamed()) {
                    if (this.A_renamed.t_renamed() && java.lang.Float.compare(fA_renamed, 2.0f) < 0) {
                        this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    } else if (!this.A_renamed.t_renamed() && java.lang.Float.compare(fA_renamed, 2.0f) >= 0 && !this.A_renamed.v_renamed()) {
                        this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on_renamed").apply();
                    }
                }
                com.oplus.camera.af_renamed afVar4 = this.P_renamed;
                if (afVar4 != null && afVar4.g_renamed()) {
                    if (this.A_renamed.s_renamed() && java.lang.Float.compare(fA_renamed, f4106a) > 0) {
                        this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                        a_renamed(1.0f, true);
                        if (this.B_renamed.A_renamed()) {
                            e_renamed(1.0f);
                            return;
                        }
                        return;
                    }
                    if (!this.A_renamed.s_renamed() && java.lang.Float.compare(fA_renamed, 1.0f) < 0) {
                        this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
                        a_renamed(f4106a, true);
                        if (this.B_renamed.A_renamed()) {
                            e_renamed(f4106a);
                            return;
                        }
                        return;
                    }
                }
                a_renamed(fA_renamed, true);
                b_renamed(fA_renamed, fA_renamed);
                if (this.P_renamed != null && this.t_renamed && this.B_renamed.A_renamed()) {
                    e_renamed(fA_renamed);
                }
            }
        }
    }

    public boolean a_renamed(boolean z_renamed, float f_renamed, float f2) {
        if (!Y_renamed()) {
            return false;
        }
        if (H_renamed() && this.E_renamed.b_renamed()) {
            return false;
        }
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar != null && afVar.f_renamed() && (this.O_renamed.ao_renamed() || !z_renamed)) {
            return false;
        }
        com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
        if (xVar != null) {
            xVar.setFromClickView(false);
        }
        float f3 = this.f_renamed;
        if (!z_renamed) {
            f_renamed = -f_renamed;
        }
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(new java.math.BigDecimal(java.lang.String.valueOf(java.lang.Math.round((f3 + f_renamed) * 100.0f) / 100.0f)).setScale(2, 1).floatValue() + 1.0E-5f, f2, this.i_renamed);
        if (this.f_renamed == fA_renamed) {
            return false;
        }
        h_renamed(3);
        com.oplus.camera.af_renamed afVar2 = this.P_renamed;
        if (afVar2 != null && afVar2.h_renamed()) {
            if (this.A_renamed.t_renamed() && java.lang.Float.compare(fA_renamed, 2.0f) < 0) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
            } else if (!this.A_renamed.t_renamed() && java.lang.Float.compare(fA_renamed, 2.0f) >= 0 && !this.A_renamed.v_renamed()) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on_renamed").apply();
            }
        }
        com.oplus.camera.af_renamed afVar3 = this.P_renamed;
        if (afVar3 != null && afVar3.g_renamed()) {
            if (this.A_renamed.s_renamed() && java.lang.Float.compare(fA_renamed, f4106a) > 0) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                a_renamed(1.0f, true);
                if (this.B_renamed.A_renamed()) {
                    e_renamed(1.0f);
                }
                return false;
            }
            if (!this.A_renamed.s_renamed() && java.lang.Float.compare(fA_renamed, 1.0f) < 0) {
                this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
                a_renamed(f4106a, true);
                if (this.B_renamed.A_renamed()) {
                    e_renamed(f4106a);
                }
                return false;
            }
        }
        a_renamed(fA_renamed, true);
        b_renamed(fA_renamed, fA_renamed);
        if (this.P_renamed != null && this.t_renamed && this.B_renamed.A_renamed()) {
            e_renamed(fA_renamed);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed(float f_renamed) {
        if (this.A_renamed.o_renamed()) {
            java.util.Collections.sort(this.e_renamed);
            java.util.Iterator<java.lang.Float> it = this.e_renamed.iterator();
            while (it.hasNext()) {
                float fFloatValue = it.next().floatValue();
                if ((java.lang.Float.compare(fFloatValue, this.f_renamed) > 0 && java.lang.Float.compare(fFloatValue, f_renamed) <= 0) || (java.lang.Float.compare(fFloatValue, this.f_renamed) < 0 && java.lang.Float.compare(fFloatValue, f_renamed) >= 0)) {
                    if (this.e_renamed.get(0).floatValue() != fFloatValue) {
                        if (this.e_renamed.get(r2.size() - 1).floatValue() != fFloatValue) {
                            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                                this.A_renamed.r_renamed();
                                return;
                            } else {
                                this.A_renamed.q_renamed();
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(float f_renamed, float f2) {
        a_renamed(f_renamed, f2, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed, float f2, boolean z_renamed, boolean z2) {
        if (java.lang.Float.compare(this.f_renamed, f_renamed) == 0) {
            return;
        }
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar != null && afVar.d_renamed() && z_renamed) {
            java.util.Iterator<java.lang.Float> it = this.f4108c.iterator();
            while (it.hasNext()) {
                float fFloatValue = it.next().floatValue();
                if (f_renamed < fFloatValue && f_renamed >= fFloatValue - 0.1f) {
                    float fWidth = (this.Q_renamed.width() / 2.0f) / ((int) ((r1 / fFloatValue) + 1.0f));
                    if (f_renamed >= fWidth) {
                        f_renamed = fWidth;
                    }
                }
            }
        }
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(f_renamed, this.h_renamed, this.i_renamed);
        if (this.A_renamed != null && java.lang.Float.compare(fA_renamed, this.f_renamed) != 0) {
            this.g_renamed = this.f_renamed;
            this.f_renamed = fA_renamed;
            this.A_renamed.a_renamed(fA_renamed, true, f2);
            if (this.h_renamed == fA_renamed) {
                this.I_renamed.a_renamed(U_renamed() ? f4106a : new java.math.BigDecimal(this.h_renamed).setScale(1, 1).floatValue(), z2, false);
            } else {
                this.I_renamed.a_renamed(U_renamed() ? f4106a : fA_renamed, z2, false);
            }
        }
        if (java.lang.Float.compare(f4106a, this.f_renamed) == 0) {
            com.oplus.camera.j_renamed.a_renamed().g_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "changeZoom, mZoomValue: " + this.f_renamed + ", value: " + fA_renamed);
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ag_renamed.a_renamed aVar;
        android.animation.ValueAnimator valueAnimator = this.S_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (!com.oplus.camera.util.Util.t_renamed()) {
                return;
            }
            this.S_renamed.cancel();
            this.C_renamed.setAlpha(1.0f);
            this.A_renamed.c_renamed(1.0f);
        }
        android.animation.ValueAnimator valueAnimator2 = this.R_renamed;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.R_renamed.cancel();
        }
        final android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.B_renamed.getLayoutParams();
        int i2 = layoutParams.bottomMargin;
        android.app.Activity activity = this.L_renamed;
        int dimensionPixelOffset = activity != null ? activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.zoom_view_translate_anim_threshold) : 0;
        boolean z2 = i_renamed > i2 && (aVar = this.A_renamed) != null && aVar.m_renamed() && !this.A_renamed.C_renamed();
        int i3 = z2 ? 150 : 0;
        if (java.lang.Math.abs(i_renamed - i2) > dimensionPixelOffset && z_renamed) {
            android.animation.ValueAnimator valueAnimator3 = this.R_renamed;
            if (valueAnimator3 == null) {
                this.R_renamed = android.animation.ValueAnimator.ofInt(i2, i_renamed);
                this.R_renamed.setStartDelay(i3);
                this.R_renamed.setDuration(400);
                this.R_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.B_renamed.getContext(), com.oplus.camera.R_renamed.anim.zoom_interpolator_in));
                this.R_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ag_renamed.14
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator4) {
                        int iIntValue = ((java.lang.Integer) valueAnimator4.getAnimatedValue()).intValue();
                        layoutParams.bottomMargin = iIntValue;
                        com.oplus.camera.ag_renamed.this.B_renamed.setLayoutParams(layoutParams);
                        com.oplus.camera.ag_renamed.this.p_renamed();
                        if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                            com.oplus.camera.ag_renamed.this.A_renamed.a_renamed(iIntValue);
                        }
                    }
                });
            } else if (!valueAnimator3.isRunning()) {
                this.R_renamed.setIntValues(i2, i_renamed);
                this.R_renamed.setStartDelay(i3);
                this.R_renamed.setDuration(400);
            }
            if (this.S_renamed == null) {
                this.S_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
                this.S_renamed.setStartDelay(i3);
                this.S_renamed.setDuration(400);
                this.S_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(this.C_renamed.getContext(), com.oplus.camera.R_renamed.anim.alpha_path_interpolator));
                this.S_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ag_renamed.15
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator4) {
                        float fFloatValue = ((java.lang.Float) valueAnimator4.getAnimatedValue()).floatValue();
                        com.oplus.camera.ag_renamed.this.C_renamed.setAlpha(fFloatValue);
                        if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                            com.oplus.camera.ag_renamed.this.A_renamed.c_renamed(fFloatValue);
                        }
                    }
                });
            }
            if (z2) {
                this.C_renamed.setAlpha(0.0f);
                android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                animatorSet.play(this.S_renamed).with(this.R_renamed);
                animatorSet.start();
                return;
            }
            if (!this.R_renamed.isRunning()) {
                this.R_renamed.start();
            }
            com.oplus.camera.ag_renamed.a_renamed aVar2 = this.A_renamed;
            if (aVar2 != null) {
                aVar2.c_renamed(1.0f);
                return;
            }
            return;
        }
        layoutParams.bottomMargin = i_renamed;
        this.B_renamed.setLayoutParams(layoutParams);
        p_renamed();
        com.oplus.camera.ag_renamed.a_renamed aVar3 = this.A_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(i_renamed);
            this.A_renamed.c_renamed(1.0f);
        }
    }

    public void p_renamed() {
        android.view.ViewParent parent = this.B_renamed.getParent();
        if (!(parent instanceof android.widget.RelativeLayout) || this.L_renamed == null) {
            return;
        }
        android.view.View viewFindViewById = ((android.widget.RelativeLayout) parent).findViewById(com.oplus.camera.R_renamed.id_renamed.zoom_seek_anchor_view);
        float[] ultraWideZoomDotViewLocation = this.B_renamed.getUltraWideZoomDotViewLocation();
        float dimensionPixelSize = this.L_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_click_point_radius);
        float dimensionPixelSize2 = this.L_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_zoom_ultra_margin_top);
        if (viewFindViewById != null) {
            if (ultraWideZoomDotViewLocation != null && 2 == ultraWideZoomDotViewLocation.length) {
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                int i_renamed = (int) (2.0f * dimensionPixelSize);
                layoutParams.width = i_renamed;
                layoutParams.height = i_renamed;
                if (1 == this.B_renamed.getLayoutDirection()) {
                    layoutParams.setMarginStart((int) ((com.oplus.camera.util.Util.getScreenWidth() - ultraWideZoomDotViewLocation[0]) - dimensionPixelSize));
                } else {
                    layoutParams.setMarginStart((int) (ultraWideZoomDotViewLocation[0] - dimensionPixelSize));
                }
                layoutParams.topMargin = (int) (((ultraWideZoomDotViewLocation[1] - dimensionPixelSize2) - dimensionPixelSize) + (this.B_renamed.getFocusCircleRadius() / 2));
                viewFindViewById.setLayoutParams(layoutParams);
                viewFindViewById.setVisibility(4);
                return;
            }
            viewFindViewById.setVisibility(8);
        }
    }

    public boolean q_renamed() {
        return this.w_renamed && this.B_renamed.z_renamed();
    }

    public void r_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "onDestroy");
        this.L_renamed = null;
        this.N_renamed = null;
        this.O_renamed = null;
        this.A_renamed = null;
        this.K_renamed = null;
        this.y_renamed = false;
        android.animation.AnimatorSet animatorSet = this.U_renamed;
        if (animatorSet != null && animatorSet.isStarted() && this.U_renamed.isRunning()) {
            this.U_renamed.cancel();
        }
    }

    public void h_renamed(boolean z_renamed) {
        this.z_renamed = z_renamed;
        s_renamed();
    }

    public void d_renamed(int i_renamed) {
        this.ac_renamed = i_renamed;
        s_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s_renamed() {
        /*
            r5 = this;
            com.oplus.camera.ui.preview.ai_renamed r0 = r5.B_renamed
            if (r0 != 0) goto L5
            return
        L5:
            boolean r1 = r5.z_renamed
            r2 = 1
            if (r1 == 0) goto Le
            r0.setLightBackground(r2)
            return
        Le:
            r0 = 2
            int r1 = r5.ac_renamed
            r3 = 0
            if (r0 != r1) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            com.oplus.camera.ag_renamed$a_renamed r1 = r5.A_renamed
            if (r1 == 0) goto L30
            java.lang.String r1 = r1.n_renamed()
            java.lang.String r4 = "professional"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L2f
            com.oplus.camera.ag_renamed$a_renamed r1 = r5.A_renamed
            boolean r1 = r1.C_renamed()
            if (r1 == 0) goto L30
        L2f:
            r0 = r3
        L30:
            com.oplus.camera.screen.g_renamed r1 = r5.ab_renamed
            com.oplus.camera.screen.b_renamed.a_renamed r1 = r1.a_renamed()
            int r1 = r1.j_renamed()
            if (r2 != r1) goto L4f
            com.oplus.camera.screen.g_renamed r0 = r5.ab_renamed
            com.oplus.camera.screen.b_renamed.a_renamed r0 = r0.a_renamed()
            int r0 = r0.k_renamed()
            if (r0 != 0) goto L73
            int r0 = r5.ac_renamed
            if (r0 == 0) goto L76
            if (r2 != r0) goto L73
            goto L76
        L4f:
            r1 = 4
            com.oplus.camera.screen.g_renamed r4 = r5.ab_renamed
            com.oplus.camera.screen.b_renamed.a_renamed r4 = r4.a_renamed()
            int r4 = r4.j_renamed()
            if (r1 != r4) goto L6d
            com.oplus.camera.screen.g_renamed r0 = r5.ab_renamed
            com.oplus.camera.screen.b_renamed.a_renamed r0 = r0.a_renamed()
            boolean r0 = r0.q_renamed()
            if (r0 == 0) goto L76
            int r0 = r5.ac_renamed
            if (r2 == r0) goto L73
            goto L76
        L6d:
            boolean r1 = com.oplus.camera.util.Util.t_renamed()
            if (r1 == 0) goto L75
        L73:
            r2 = r3
            goto L76
        L75:
            r2 = r0
        L76:
            com.oplus.camera.ui.preview.ai_renamed r5 = r5.B_renamed
            r5.setLightBackground(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ag_renamed.s_renamed():void");
    }

    public void i_renamed(final boolean z_renamed) {
        this.B_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.-$$Lambda$ag_renamed$gNyyeuKfOzOzBYQBNCB0phiLmaQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.p_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p_renamed(boolean z_renamed) {
        if (this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
            this.B_renamed.d_renamed(!z_renamed ? 1 : 0, false);
        }
    }

    public void j_renamed(boolean z_renamed) {
        this.al_renamed = z_renamed;
    }

    public boolean t_renamed() {
        return this.al_renamed;
    }

    /* compiled from: ZoomManager.java */
    private class b_renamed implements com.oplus.camera.ab_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f4135b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f4136c;

        private b_renamed() {
            this.f4135b = 0.0f;
            this.f4136c = 0.0f;
        }

        @Override // com.oplus.camera.ab_renamed.a_renamed
        public boolean a_renamed(com.oplus.camera.ab_renamed abVar) {
            if (com.oplus.camera.ag_renamed.this.A_renamed != null && com.oplus.camera.ag_renamed.this.A_renamed.x_renamed()) {
                return true;
            }
            float fD_renamed = abVar.d_renamed();
            if (java.lang.Float.isInfinite(fD_renamed) || java.lang.Float.isNaN(fD_renamed) || 0.0f == this.f4135b) {
                return true;
            }
            float fA_renamed = com.oplus.camera.ag_renamed.this.a_renamed(this.f4136c, abVar.b_renamed() - this.f4135b);
            if (com.oplus.camera.ag_renamed.this.P_renamed != null && com.oplus.camera.ag_renamed.this.P_renamed.h_renamed() && !com.oplus.camera.ag_renamed.this.O_renamed.ao_renamed()) {
                if (com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() || java.lang.Float.compare(2.0f, fA_renamed) > 0 || com.oplus.camera.ag_renamed.this.A_renamed.v_renamed()) {
                    if (com.oplus.camera.ag_renamed.this.A_renamed.t_renamed() && java.lang.Float.compare(2.0f, fA_renamed) > 0) {
                        com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    }
                } else {
                    com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on_renamed").apply();
                }
            }
            if (com.oplus.camera.ag_renamed.this.P_renamed.g_renamed()) {
                if (com.oplus.camera.ag_renamed.this.P_renamed.f_renamed() && java.lang.Float.compare(fA_renamed, com.oplus.camera.ag_renamed.f4106a) <= 0) {
                    return true;
                }
                if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() || java.lang.Float.compare(fA_renamed, com.oplus.camera.ag_renamed.f4106a) <= 0) {
                    if (!com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() && java.lang.Float.compare(fA_renamed, 1.0f) < 0) {
                        if (java.lang.Float.compare(fA_renamed, 0.8f) < 0 && !com.oplus.camera.ag_renamed.this.O_renamed.ao_renamed()) {
                            com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed").apply();
                            com.oplus.camera.ag_renamed.this.a_renamed(com.oplus.camera.ag_renamed.f4106a, false);
                            com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
                            if (com.oplus.camera.ag_renamed.this.B_renamed.A_renamed()) {
                                com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                            }
                        }
                        return true;
                    }
                } else {
                    if (java.lang.Float.compare(fA_renamed, 0.8f) > 0 && !com.oplus.camera.ag_renamed.this.O_renamed.ao_renamed()) {
                        com.oplus.camera.ag_renamed.this.N_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                        com.oplus.camera.ag_renamed.this.a_renamed(1.0f, false);
                        com.oplus.camera.ag_renamed.this.b_renamed(1.0f, 1.0f);
                        if (com.oplus.camera.ag_renamed.this.B_renamed.A_renamed()) {
                            com.oplus.camera.ag_renamed.this.e_renamed(1.0f);
                        }
                    }
                    return true;
                }
            }
            com.oplus.camera.ag_renamed.this.a_renamed(fA_renamed, false);
            com.oplus.camera.ag_renamed.this.b_renamed(fA_renamed, fA_renamed);
            if (!com.oplus.camera.ag_renamed.this.B_renamed.s_renamed()) {
                com.oplus.camera.ag_renamed.this.B_renamed.p_renamed();
            }
            return true;
        }

        @Override // com.oplus.camera.ab_renamed.a_renamed
        public boolean b_renamed(com.oplus.camera.ab_renamed abVar) {
            if (!com.oplus.camera.ag_renamed.this.Y_renamed()) {
                if (com.oplus.camera.ag_renamed.this.aa_renamed()) {
                    com.oplus.camera.ag_renamed.this.A_renamed.k_renamed();
                }
                return false;
            }
            if (!com.oplus.camera.ag_renamed.this.Z_renamed() || com.oplus.camera.ag_renamed.this.A_renamed.u_renamed() || !com.oplus.camera.ag_renamed.this.A_renamed.e_renamed() || com.oplus.camera.gl_renamed.b_renamed.e_renamed.a_renamed().c_renamed()) {
                return false;
            }
            this.f4135b = abVar.c_renamed();
            this.f4136c = com.oplus.camera.ag_renamed.this.A_renamed.s_renamed() ? com.oplus.camera.ag_renamed.f4106a : com.oplus.camera.ag_renamed.this.f_renamed;
            com.oplus.camera.ag_renamed.this.A_renamed.c_renamed();
            com.oplus.camera.ag_renamed.this.b_renamed(false);
            com.oplus.camera.ag_renamed.this.A_renamed.a_renamed(true);
            com.oplus.camera.ag_renamed.this.B_renamed.p_renamed();
            return true;
        }

        @Override // com.oplus.camera.ab_renamed.a_renamed
        public void c_renamed(com.oplus.camera.ab_renamed abVar) {
            if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                com.oplus.camera.ag_renamed.this.A_renamed.d_renamed();
                com.oplus.camera.ag_renamed.this.A_renamed.a_renamed(false);
            }
            com.oplus.camera.ag_renamed.this.B_renamed.q_renamed();
            com.oplus.camera.ag_renamed.this.h_renamed(4);
        }
    }

    public boolean u_renamed() {
        return this.A_renamed.a_renamed();
    }

    public void k_renamed(boolean z_renamed) {
        this.I_renamed.setZoomUnit(z_renamed);
        this.B_renamed.setZoomValueUnit(z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed(int i_renamed) {
        if (this.A_renamed != null) {
            com.oplus.camera.statistics.model.ZoomAdjustMsgData zoomAdjustMsgData = new com.oplus.camera.statistics.model.ZoomAdjustMsgData(this.L_renamed);
            zoomAdjustMsgData.mCaptureType = !this.A_renamed.l_renamed() ? 1 : 0;
            zoomAdjustMsgData.mCaptureMode = this.A_renamed.n_renamed();
            if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO.equals(zoomAdjustMsgData.mCaptureMode)) {
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.mOrientation = this.q_renamed;
            zoomAdjustMsgData.mZoomType = i_renamed;
            zoomAdjustMsgData.mZoomValue = java.lang.String.valueOf(U_renamed() ? f4106a : a_renamed());
            zoomAdjustMsgData.mbVideoRecording = this.O_renamed.ao_renamed();
            if (10 == i_renamed || 11 == i_renamed) {
                zoomAdjustMsgData.mRateValue = java.lang.String.valueOf(this.j_renamed);
            }
            if (this.O_renamed.i_renamed()) {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(1);
            } else if (this.O_renamed.m_renamed()) {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(3);
            } else {
                zoomAdjustMsgData.mCameraEnterType = java.lang.String.valueOf(2);
            }
            zoomAdjustMsgData.mCameraId = this.O_renamed.ax_renamed();
            zoomAdjustMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.O_renamed.aw_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
            if (!android.text.TextUtils.isEmpty(zoomAdjustMsgData.mCaptureMode) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(zoomAdjustMsgData.mCaptureMode) && this.O_renamed.ay_renamed()) {
                zoomAdjustMsgData.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_QUICK_VIDEO;
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String W_renamed() {
        if (this.B_renamed != null) {
            return this.aa_renamed.format(this.B_renamed.f_renamed(this.f_renamed)) + "X_renamed";
        }
        return this.aa_renamed.format(this.f_renamed) + "X_renamed";
    }

    public boolean v_renamed() {
        return this.B_renamed.C_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X_renamed() {
        android.animation.AnimatorSet animatorSet = this.T_renamed;
        return animatorSet != null && animatorSet.isStarted() && this.T_renamed.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        if (afVar == null) {
            return true;
        }
        if (afVar.k_renamed() || this.P_renamed.l_renamed() || this.P_renamed.m_renamed() || this.P_renamed.w_renamed() || this.P_renamed.o_renamed() || this.P_renamed.E_renamed() || this.P_renamed.u_renamed() || this.P_renamed.M_renamed() || this.P_renamed.G_renamed() || this.P_renamed.O_renamed()) {
            return false;
        }
        com.oplus.camera.ag_renamed.a_renamed aVar = this.A_renamed;
        if ((aVar != null && aVar.y_renamed()) || !this.P_renamed.P_renamed()) {
            return false;
        }
        com.oplus.camera.ag_renamed.a_renamed aVar2 = this.A_renamed;
        return aVar2 == null || 32 != aVar2.D_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        return afVar == null || !afVar.L_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aa_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        return (afVar == null || !afVar.m_renamed() || this.P_renamed.n_renamed()) ? false : true;
    }

    public boolean w_renamed() {
        return "off".equals(this.N_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"));
    }

    public void l_renamed(boolean z_renamed) {
        this.u_renamed = z_renamed;
    }

    public boolean x_renamed() {
        return this.u_renamed;
    }

    public void y_renamed() {
        com.oplus.camera.ui.preview.ai_renamed aiVar = this.B_renamed;
        if (aiVar != null) {
            aiVar.v_renamed();
        }
    }

    public float[] z_renamed() {
        com.oplus.camera.af_renamed afVar;
        if (this.B_renamed == null || (afVar = this.P_renamed) == null) {
            return null;
        }
        if (afVar.d_renamed() || this.P_renamed.g_renamed()) {
            return this.B_renamed.getUltraWideZoomDotViewLocation();
        }
        return null;
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        if (j_renamed()) {
            return a_renamed(this.B_renamed, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
        return false;
    }

    public boolean c_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.preview.ai_renamed aiVar = this.B_renamed;
        return aiVar != null && aiVar.b_renamed(motionEvent);
    }

    public void b_renamed(float f_renamed) {
        this.f_renamed = f_renamed;
    }

    public void A_renamed() {
        com.oplus.camera.ab_renamed abVar = this.K_renamed;
        if (abVar != null) {
            abVar.e_renamed();
        }
    }

    public boolean B_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        return afVar != null && afVar.m_renamed() && this.P_renamed.n_renamed() && "on_renamed".equals(this.N_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
    }

    private boolean ab_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        return afVar != null && afVar.G_renamed() && "off".equals(this.N_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_MODE, "off"));
    }

    /* compiled from: ZoomManager.java */
    private class c_renamed implements com.oplus.camera.ui.preview.ag_renamed {
        private c_renamed() {
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean a_renamed() {
            return com.oplus.camera.ag_renamed.this.A_renamed.e_renamed() && !com.oplus.camera.ag_renamed.this.X_renamed();
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean b_renamed() {
            return com.oplus.camera.ag_renamed.this.w_renamed();
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean c_renamed() {
            return com.oplus.camera.ag_renamed.this.A_renamed.s_renamed();
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean d_renamed() {
            return com.oplus.camera.ag_renamed.this.A_renamed.u_renamed();
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean e_renamed() {
            return com.oplus.camera.ag_renamed.this.E_renamed != null && com.oplus.camera.ag_renamed.this.E_renamed.b_renamed();
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean f_renamed() {
            if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                return com.oplus.camera.ag_renamed.this.A_renamed.b_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean g_renamed() {
            if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                return com.oplus.camera.ag_renamed.this.A_renamed.y_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean h_renamed() {
            if (com.oplus.camera.ag_renamed.this.A_renamed != null) {
                return com.oplus.camera.ag_renamed.this.A_renamed.z_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public float i_renamed() {
            if (com.oplus.camera.ag_renamed.this.P_renamed != null) {
                return com.oplus.camera.ag_renamed.this.P_renamed.N_renamed();
            }
            return 0.0f;
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean j_renamed() {
            return (com.oplus.camera.ag_renamed.this.F_renamed != null && com.oplus.camera.ag_renamed.this.F_renamed.a_renamed()) || (com.oplus.camera.ag_renamed.this.G_renamed != null && com.oplus.camera.ag_renamed.this.G_renamed.a_renamed());
        }

        @Override // com.oplus.camera.ui.preview.ag_renamed
        public boolean k_renamed() {
            return com.oplus.camera.ag_renamed.this.t_renamed();
        }
    }

    public void C_renamed() {
        com.oplus.camera.af_renamed afVar = this.P_renamed;
        int iF = (afVar == null || !afVar.E_renamed()) ? 1 : this.P_renamed.F_renamed();
        com.oplus.camera.af_renamed afVar2 = this.P_renamed;
        boolean zI = afVar2 != null ? afVar2.I_renamed() : false;
        com.oplus.camera.af_renamed afVar3 = this.P_renamed;
        boolean zJ = afVar3 != null ? afVar3.J_renamed() : false;
        boolean zA = this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FRONT_ZOOM_SWITCH);
        boolean zB = this.A_renamed.B_renamed();
        com.oplus.camera.capmode.a_renamed aVar = this.O_renamed;
        int iAw = aVar != null ? aVar.aw_renamed() : 0;
        java.lang.String strN = this.A_renamed.n_renamed();
        com.oplus.camera.af_renamed afVar4 = this.P_renamed;
        boolean zM = afVar4 != null ? afVar4.m_renamed() : false;
        boolean zU = u_renamed();
        boolean z_renamed = (zI == this.af_renamed && zJ == this.ag_renamed && iAw == this.ad_renamed && strN.equals(this.ae_renamed) && zM == this.ah_renamed && zU == this.ak_renamed) ? false : true;
        this.ad_renamed = iAw;
        this.ae_renamed = strN;
        this.af_renamed = zI;
        this.ag_renamed = zJ;
        this.ah_renamed = zM;
        this.ak_renamed = zU;
        com.oplus.camera.ui.preview.ai_renamed aiVar = this.B_renamed;
        if (aiVar != null) {
            aiVar.a_renamed(U_renamed() ? f4106a : this.f_renamed, this.h_renamed, this.i_renamed, this.e_renamed, this.d_renamed, iF, zA, zB, z_renamed);
        }
        com.oplus.camera.ui.x_renamed xVar = this.I_renamed;
        if (xVar != null) {
            xVar.a_renamed(U_renamed() ? f4106a : this.f_renamed, this.d_renamed, this.q_renamed, iF);
        }
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "updateZoomViewWithScreenMode, mClickPoints: " + this.d_renamed.toString());
    }

    public static float a_renamed(float f_renamed, int i_renamed) {
        return java.lang.Math.round(((((int) ((f_renamed + 1.0E-5f) / 0.1f)) * 0.1f) * i_renamed) * 10000.0f) / 10000.0f;
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("ZoomManager", "setScreenMode, layoutMode: " + i_renamed + ", screenRotation: " + i2);
        android.animation.AnimatorSet animatorSet = this.V_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.V_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.W_renamed;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.W_renamed.cancel();
        }
        this.V_renamed = null;
        this.W_renamed = null;
        this.r_renamed = i_renamed;
        this.s_renamed = i2;
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.setScreenMode(i_renamed);
        }
    }

    private int ac_renamed() {
        int i_renamed = this.r_renamed;
        return 1 == i_renamed ? com.oplus.camera.R_renamed.layout.camera_inertial_zoom_layout_vertical : 4 == i_renamed ? com.oplus.camera.R_renamed.layout.camera_inertial_zoom_layout_rackl : com.oplus.camera.R_renamed.layout.camera_inertial_zoom_layout;
    }

    public void e_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParamsI = i_renamed(i_renamed);
        if (layoutParamsI != null) {
            this.H_renamed.setLayoutParams(layoutParamsI);
        }
        android.widget.RelativeLayout.LayoutParams layoutParamsJ = j_renamed(i_renamed);
        this.Y_renamed.removeView(this.D_renamed);
        this.Y_renamed.addView(this.D_renamed, layoutParamsJ);
    }

    public void f_renamed(int i_renamed) {
        i_renamed();
        if (this.w_renamed) {
            e_renamed(false);
            android.widget.RelativeLayout.LayoutParams layoutParamsI = i_renamed(i_renamed);
            if (layoutParamsI != null) {
                this.H_renamed.setLayoutParams(layoutParamsI);
            }
            this.D_renamed.setLayoutParams(j_renamed(i_renamed));
        }
    }

    private void ad_renamed() {
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.a_renamed(this.q_renamed, false);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton = this.F_renamed;
        if (inertialZoomButton != null) {
            inertialZoomButton.a_renamed(this.q_renamed, false);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton2 = this.G_renamed;
        if (inertialZoomButton2 != null) {
            inertialZoomButton2.a_renamed(this.q_renamed, false);
        }
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        if (rotableTextView != null) {
            rotableTextView.a_renamed(this.q_renamed, false);
        }
    }

    private void ae_renamed() {
        com.oplus.camera.ui.widget.InertiaZoomBar inertiaZoomBar = this.E_renamed;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.a_renamed(-90, false);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton = this.F_renamed;
        if (inertialZoomButton != null) {
            inertialZoomButton.a_renamed(0, false);
        }
        com.oplus.camera.ui.widget.InertialZoomButton inertialZoomButton2 = this.G_renamed;
        if (inertialZoomButton2 != null) {
            inertialZoomButton2.a_renamed(-90, false);
        }
        com.oplus.camera.ui.RotableTextView rotableTextView = this.H_renamed;
        if (rotableTextView != null) {
            rotableTextView.a_renamed(0, false);
        }
    }

    private android.widget.RelativeLayout.LayoutParams i_renamed(int i_renamed) {
        if (1 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.H_renamed.getLayoutParams();
            layoutParams.addRule(20);
            if (270 == this.s_renamed) {
                layoutParams.setMarginStart(0);
                return layoutParams;
            }
            layoutParams.setMarginStart(this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.page_guide_double_exposure_video_height));
            return layoutParams;
        }
        if (4 != this.r_renamed) {
            return null;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.H_renamed.getLayoutParams();
        layoutParams2.addRule(20);
        layoutParams2.setMarginStart(this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoom_text_view_margin_left_rack));
        return layoutParams2;
    }

    private android.widget.RelativeLayout.LayoutParams j_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (1 == i_renamed) {
            if (270 == this.s_renamed) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoom_view_height_vertical));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                int dimensionPixelOffset = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.top_margin_1_1);
                int dimensionPixelOffset2 = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_height);
                layoutParams.rightMargin = -dimensionPixelOffset;
                layoutParams.topMargin = dimensionPixelOffset2;
                return layoutParams;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoom_view_height_vertical));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            int dimensionPixelOffset3 = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.top_margin_1_1);
            int dimensionPixelOffset4 = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_height);
            layoutParams2.leftMargin = -dimensionPixelOffset3;
            layoutParams2.topMargin = dimensionPixelOffset4;
            return layoutParams2;
        }
        if (4 == this.r_renamed) {
            int dimensionPixelSize = this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoom_view_height_rack);
            int dimensionPixelOffset5 = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.inertial_zoom_view_margin_left_rack) + com.oplus.camera.util.Util.Z_renamed();
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, dimensionPixelSize);
            layoutParams3.addRule(9);
            layoutParams3.addRule(12);
            if ("low270" == this.O_renamed.aU_renamed().h_renamed() || "rack270" == this.O_renamed.aU_renamed().h_renamed()) {
                layoutParams3.leftMargin = dimensionPixelOffset5;
            } else {
                layoutParams3.leftMargin = this.M_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.inertial_zoom_view_margin_left_rack);
            }
            layoutParams3.bottomMargin = 0;
            return layoutParams3;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        layoutParams4.setMargins(0, 0, 0, this.M_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inertial_zoombar_margin_bottom));
        return layoutParams4;
    }
}
