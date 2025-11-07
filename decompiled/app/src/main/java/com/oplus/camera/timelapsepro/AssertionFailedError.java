package com.oplus.camera.timelapsepro;

/* compiled from: ParameterContainer.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.widget.RelativeLayout {
    private com.oplus.camera.timelapsepro.b_renamed.a_renamed A_renamed;
    private int B_renamed;
    private int C_renamed;
    private int D_renamed;
    private int E_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> F_renamed;
    private android.os.Handler G_renamed;
    private boolean H_renamed;
    private boolean I_renamed;
    private boolean J_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed K_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed L_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed M_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed N_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed O_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.e_renamed P_renamed;
    private java.util.Map<java.lang.String, java.lang.String> Q_renamed;
    private boolean R_renamed;
    private android.view.View.OnTouchListener S_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final com.oplus.camera.ComboPreferences f5658a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5659b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.a_renamed.a_renamed.f_renamed f5660c;
    private com.oplus.camera.timelapsepro.adapter.ParamsAdapter d_renamed;
    private android.content.Context e_renamed;
    private androidx.recyclerview.widget.COUIRecyclerView f_renamed;
    private androidx.recyclerview.widget.LinearLayoutManager g_renamed;
    private android.widget.RelativeLayout h_renamed;
    private android.widget.RelativeLayout i_renamed;
    private android.widget.RelativeLayout j_renamed;
    private android.widget.RelativeLayout k_renamed;
    private android.widget.RelativeLayout l_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar m_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar n_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar o_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar p_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView w_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView x_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView y_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView z_renamed;

    /* compiled from: ParameterContainer.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(java.lang.String str, java.lang.String str2);

        void a_renamed(java.lang.String str, boolean z_renamed, java.lang.String str2);

        void b_renamed(java.lang.String str, java.lang.String str2);

        void c_renamed(java.lang.String str, java.lang.String str2);

        void d_renamed(java.lang.String str, java.lang.String str2);
    }

    public b_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences) {
        super(context);
        this.f5660c = com.oplus.camera.professional.u_renamed.a_renamed();
        this.r_renamed = -1;
        this.s_renamed = -1;
        this.t_renamed = 0;
        this.u_renamed = -1;
        this.v_renamed = -1;
        this.B_renamed = 0;
        this.D_renamed = 2;
        this.E_renamed = 0;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = false;
        this.I_renamed = false;
        this.J_renamed = false;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = null;
        this.N_renamed = null;
        this.O_renamed = null;
        this.P_renamed = null;
        this.Q_renamed = new java.util.HashMap();
        this.R_renamed = false;
        this.S_renamed = new android.view.View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.b_renamed.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    com.oplus.camera.professional.u_renamed.a_renamed(view, com.oplus.camera.timelapsepro.b_renamed.this.f5660c, true);
                } else if (action == 1 || action == 3) {
                    com.oplus.camera.professional.u_renamed.a_renamed(view, com.oplus.camera.timelapsepro.b_renamed.this.f5660c, false);
                }
                return false;
            }
        };
        this.e_renamed = context;
        this.f5658a = comboPreferences;
        this.I_renamed = false;
        android.view.View viewInflate = android.view.LayoutInflater.from(this.e_renamed).inflate(com.oplus.camera.R_renamed.layout.time_lapse_pro_param_container, this);
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        h_renamed();
        this.f5659b = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.blur_menu_animation_translation_y);
        this.f_renamed = (androidx.recyclerview.widget.COUIRecyclerView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.param_rv);
        this.f_renamed.setItemViewCacheSize(-1);
        this.g_renamed = new androidx.recyclerview.widget.LinearLayoutManager(this.e_renamed) { // from class: com.oplus.camera.timelapsepro.b_renamed.7
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
            public boolean canScrollVertically() {
                return super.canScrollVertically();
            }
        };
        this.d_renamed = new com.oplus.camera.timelapsepro.adapter.ParamsAdapter(this.e_renamed);
        this.g_renamed.setOrientation(0);
        this.f_renamed.setLayoutManager(this.g_renamed);
        this.d_renamed.a_renamed(new com.oplus.camera.timelapsepro.adapter.ParamsAdapter.a_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$8Eg7xdIZuFH1gRwibIbSBSXdYWc
            @Override // com.oplus.camera.timelapsepro.adapter.ParamsAdapter.a_renamed
            public final void clickItem(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar) throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.a_renamed(i_renamed, eVar);
            }
        });
        this.d_renamed.a_renamed(new com.oplus.camera.timelapsepro.adapter.ParamsAdapter.b_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$9uAEfNDaxvrGpPkuCMWZtKuwjkM
            @Override // com.oplus.camera.timelapsepro.adapter.ParamsAdapter.b_renamed
            public final void onValueChanged(int i_renamed, int i2) {
                this.f_renamed$0.b_renamed(i_renamed, i2);
            }
        });
        this.f_renamed.setAdapter(this.d_renamed);
        this.f_renamed.setClipChildren(false);
        this.f_renamed.setClipToPadding(false);
        this.G_renamed = new android.os.Handler(android.os.Looper.myLooper()) { // from class: com.oplus.camera.timelapsepro.b_renamed.8
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 1) {
                    com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(true, message.arg1, message.arg2);
                } else {
                    if (i_renamed != 2) {
                        return;
                    }
                    com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(false, message.arg1, message.arg2);
                }
            }
        };
    }

    private void h_renamed() {
        this.r_renamed = b_renamed("pref_time_lapse_pro_index_of_iso_key", -1);
        this.s_renamed = b_renamed("pref_time_lapse_pro_index_of_exposure_time_key", -1);
        this.t_renamed = b_renamed("pref_time_lapse_pro_index_of_exposure_compensation_key", com.oplus.camera.timelapsepro.e_renamed.f5680a);
        this.u_renamed = b_renamed("pref_time_lapse_pro_index_of_focus_mode_key", -1);
        this.v_renamed = b_renamed("pref_time_lapse_pro_index_of_whitebalance_key", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "putPreferenceInt, key: " + str + ", value: " + i_renamed);
        this.f5658a.edit().putInt(str, i_renamed).apply();
    }

    private int b_renamed(java.lang.String str, int i_renamed) {
        int i2 = this.f5658a.getInt(str, i_renamed);
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "getPreferenceInt, value: " + i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed) {
        a_renamed(i_renamed, 1);
    }

    private void a_renamed(int i_renamed, int i2) {
        a_renamed(i_renamed, i2, 1000L);
    }

    private void a_renamed(int i_renamed, int i2, long j_renamed) {
        if (this.G_renamed.hasMessages(1)) {
            this.G_renamed.removeMessages(1);
        }
        android.os.Handler handler = this.G_renamed;
        handler.sendMessageDelayed(android.os.Message.obtain(handler, 1, i_renamed, i2), j_renamed);
    }

    private void b_renamed(int i_renamed) {
        if (this.G_renamed.hasMessages(2)) {
            this.G_renamed.removeMessages(2);
        }
        android.os.Handler handler = this.G_renamed;
        handler.sendMessage(android.os.Message.obtain(handler, 2, i_renamed, 0));
        a_renamed(i_renamed, 1, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar;
        if (i_renamed == 1) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.m_renamed;
            if (timeLapseProParamScaleBar2 != null && timeLapseProParamScaleBar2.isShown()) {
                this.m_renamed.a_renamed(z_renamed, true);
            }
        } else if (i_renamed == 2) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar3 = this.n_renamed;
            if (timeLapseProParamScaleBar3 != null && timeLapseProParamScaleBar3.isShown()) {
                this.n_renamed.a_renamed(z_renamed, true);
            }
        } else if (i_renamed == 3) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar4 = this.o_renamed;
            if (timeLapseProParamScaleBar4 != null && timeLapseProParamScaleBar4.isShown()) {
                this.o_renamed.a_renamed(z_renamed, true);
            }
        } else if (i_renamed == 4) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar5 = this.p_renamed;
            if (timeLapseProParamScaleBar5 != null && timeLapseProParamScaleBar5.isShown()) {
                this.p_renamed.a_renamed(z_renamed, true);
            }
        } else if (i_renamed == 5 && (timeLapseProParamScaleBar = this.q_renamed) != null && timeLapseProParamScaleBar.isShown()) {
            this.q_renamed.a_renamed(z_renamed, true);
        }
        if (1 == i2) {
            a_renamed((java.lang.String) null);
        }
    }

    private android.widget.RelativeLayout.LayoutParams getScaleLayoutParams() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        int i_renamed = this.D_renamed;
        if (1 == i_renamed) {
            layoutParams.addRule(15);
        } else if (4 == i_renamed) {
            layoutParams.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_width_rack_screen);
            layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.param_rv);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
        } else {
            layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.param_rv);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
        }
        return layoutParams;
    }

    private void a_renamed(com.oplus.camera.ui.inverse.InverseTextView inverseTextView, boolean z_renamed) {
        a_renamed(inverseTextView, z_renamed, true);
    }

    private void a_renamed(com.oplus.camera.ui.inverse.InverseTextView inverseTextView, boolean z_renamed, boolean z2) {
        com.oplus.camera.timelapsepro.d_renamed.a_renamed(inverseTextView, z_renamed, z2);
    }

    private void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "initIsoContainer.");
        this.h_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.e_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.h_renamed.setVisibility(8);
        this.m_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.h_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.w_renamed = (com.oplus.camera.ui.inverse.InverseTextView) this.h_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn);
        this.w_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.w_renamed.setTextSize(1, 12.0f);
        this.w_renamed.setOnTouchListener(this.S_renamed);
        if (4 == this.D_renamed) {
            this.w_renamed.setBackgroundResource(this.R_renamed ? com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_default : com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        a_renamed(this.m_renamed);
        this.w_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$CYQbdzb8AX5XQ0dKf15eQxut9x4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.d_renamed(view);
            }
        });
        if (this.F_renamed != null) {
            this.w_renamed.setInverseColor(this.L_renamed.g_renamed());
            com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.w_renamed;
            a_renamed(inverseTextView, inverseTextView.a_renamed(), false);
            this.m_renamed.b_renamed(this.L_renamed.n_renamed());
            this.m_renamed.setScaleSpace(10);
            this.m_renamed.setValueList(this.L_renamed.o_renamed());
            this.m_renamed.setCurrentIndex(this.L_renamed.n_renamed());
            this.m_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.b_renamed.9
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
                public void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
                    com.oplus.camera.timelapsepro.b_renamed.this.L_renamed.a_renamed(i_renamed);
                    if (!com.oplus.camera.timelapsepro.b_renamed.this.L_renamed.g_renamed()) {
                        com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar.a_renamed(bVar.L_renamed.f_renamed(), com.oplus.camera.timelapsepro.b_renamed.this.L_renamed.d_renamed());
                        com.oplus.camera.timelapsepro.b_renamed bVar2 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar2.a_renamed("pref_time_lapse_pro_index_of_iso_key", bVar2.L_renamed.n_renamed());
                    }
                    com.oplus.camera.timelapsepro.b_renamed.this.p_renamed();
                    com.oplus.camera.timelapsepro.b_renamed.this.o_renamed();
                    if (com.oplus.camera.timelapsepro.b_renamed.this.m_renamed.isShown()) {
                        com.oplus.camera.timelapsepro.b_renamed.this.m_renamed.b_renamed(false);
                        com.oplus.camera.timelapsepro.b_renamed bVar3 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar3.a_renamed(bVar3.L_renamed.e_renamed());
                    }
                }
            });
            this.m_renamed.setMoveListener(new com.oplus.camera.timelapsepro.b_renamed.ParameterContainer_3());
            if (!this.L_renamed.g_renamed()) {
                this.m_renamed.c_renamed(true);
                this.m_renamed.b_renamed(this.r_renamed);
            }
        }
        addView(this.h_renamed, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.view.View view) {
        this.w_renamed.setInverseColor(!r0.a_renamed());
        this.L_renamed.a_renamed(this.w_renamed.a_renamed());
        this.m_renamed.setAutoState(this.w_renamed.a_renamed());
        a_renamed((com.oplus.camera.ui.inverse.InverseTextView) view, this.w_renamed.a_renamed());
        p_renamed();
        o_renamed();
        if (this.w_renamed.a_renamed()) {
            a_renamed(this.L_renamed.f_renamed(), getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
            a_renamed("pref_time_lapse_pro_index_of_iso_key", -1);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, "auto");
        } else {
            a_renamed("pref_time_lapse_pro_index_of_iso_key", this.L_renamed.n_renamed());
            b_renamed(1);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, this.L_renamed.e_renamed());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.b_renamed$10, reason: invalid class name */
    class ParameterContainer_3 implements com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed {
        ParameterContainer_3() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (com.oplus.camera.timelapsepro.b_renamed.this.L_renamed.g_renamed()) {
                com.oplus.camera.timelapsepro.b_renamed.this.w_renamed.performClick();
            }
            com.oplus.camera.timelapsepro.b_renamed.this.q_renamed();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(1);
            com.oplus.camera.timelapsepro.b_renamed.this.G_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$10$k_fg28HmsJnR3pX1UP7OIlpdnQA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed();
                }
            }, 50L);
            com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
            bVar.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_ISO_VALUE, bVar.L_renamed.e_renamed());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.L_renamed.d_renamed(false);
        }
    }

    private void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "initShutterContainer.");
        this.i_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.e_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.i_renamed.setVisibility(8);
        this.n_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.x_renamed = (com.oplus.camera.ui.inverse.InverseTextView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn);
        this.x_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.x_renamed.setTextSize(1, 12.0f);
        this.x_renamed.setOnTouchListener(this.S_renamed);
        if (4 == this.D_renamed) {
            this.x_renamed.setBackgroundResource(this.R_renamed ? com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_default : com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        a_renamed(this.n_renamed);
        this.x_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$Ap44TBEX-Tddfp0NygY42bbbYn4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.c_renamed(view);
            }
        });
        if (this.F_renamed != null) {
            this.x_renamed.setInverseColor(this.M_renamed.g_renamed());
            com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.x_renamed;
            a_renamed(inverseTextView, inverseTextView.a_renamed(), false);
            this.n_renamed.b_renamed(this.M_renamed.n_renamed());
            this.n_renamed.setScaleSpace(10);
            this.n_renamed.setValueList(this.M_renamed.o_renamed());
            this.n_renamed.setCurrentIndex(this.M_renamed.n_renamed());
            this.n_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.b_renamed.11
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
                public void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
                    com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.a_renamed(i_renamed);
                    if (!com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.g_renamed()) {
                        com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar.a_renamed(bVar.M_renamed.f_renamed(), com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.d_renamed());
                        com.oplus.camera.timelapsepro.b_renamed bVar2 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar2.a_renamed("pref_time_lapse_pro_index_of_exposure_time_key", bVar2.M_renamed.n_renamed());
                    }
                    com.oplus.camera.timelapsepro.b_renamed.this.p_renamed();
                    com.oplus.camera.timelapsepro.b_renamed.this.o_renamed();
                    if (com.oplus.camera.timelapsepro.b_renamed.this.n_renamed.isShown()) {
                        com.oplus.camera.timelapsepro.b_renamed.this.n_renamed.b_renamed(false);
                        java.lang.String strE = com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.e_renamed();
                        com.oplus.camera.timelapsepro.b_renamed.this.b_renamed(strE.substring(0, strE.length() - 1), strE.substring(strE.length() - 1));
                    }
                }
            });
            this.n_renamed.setMoveListener(new com.oplus.camera.timelapsepro.b_renamed.ParameterContainer_4());
            if (!this.M_renamed.g_renamed()) {
                this.n_renamed.c_renamed(true);
                this.n_renamed.b_renamed(this.s_renamed);
            }
        }
        addView(this.i_renamed, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.view.View view) {
        this.x_renamed.setInverseColor(!r0.a_renamed());
        this.M_renamed.a_renamed(this.x_renamed.a_renamed());
        this.n_renamed.setAutoState(this.x_renamed.a_renamed());
        a_renamed((com.oplus.camera.ui.inverse.InverseTextView) view, this.x_renamed.a_renamed());
        p_renamed();
        o_renamed();
        if (this.x_renamed.a_renamed()) {
            a_renamed(this.M_renamed.f_renamed(), getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
            a_renamed("pref_time_lapse_pro_index_of_exposure_time_key", -1);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, "auto");
        } else {
            a_renamed("pref_time_lapse_pro_index_of_exposure_time_key", this.M_renamed.n_renamed());
            b_renamed(2);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, this.M_renamed.e_renamed());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.b_renamed$12, reason: invalid class name */
    class ParameterContainer_4 implements com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed {
        ParameterContainer_4() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.g_renamed()) {
                com.oplus.camera.timelapsepro.b_renamed.this.x_renamed.performClick();
            }
            com.oplus.camera.timelapsepro.b_renamed.this.q_renamed();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(2);
            com.oplus.camera.timelapsepro.b_renamed.this.G_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$12$WNHMVRniA9Lw-laBYlHnDSjfqCs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed();
                }
            }, 50L);
            com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
            bVar.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_TIME, bVar.M_renamed.e_renamed());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.M_renamed.d_renamed(false);
        }
    }

    private void k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "initEvContainer.");
        this.j_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.e_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.j_renamed.setVisibility(8);
        this.o_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.j_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.j_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn).setVisibility(8);
        a_renamed(this.o_renamed);
        if (this.F_renamed != null) {
            this.o_renamed.b_renamed(this.N_renamed.n_renamed());
            this.o_renamed.a_renamed(10, 2);
            this.o_renamed.setValueList(this.N_renamed.o_renamed());
            this.o_renamed.c_renamed(true);
            this.o_renamed.setCurrentIndex(this.N_renamed.n_renamed());
            this.o_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.b_renamed.13
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
                public void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
                    com.oplus.camera.timelapsepro.b_renamed.this.N_renamed.a_renamed(i_renamed);
                    if (!com.oplus.camera.timelapsepro.b_renamed.this.N_renamed.g_renamed()) {
                        com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar.a_renamed(bVar.N_renamed.f_renamed(), com.oplus.camera.timelapsepro.b_renamed.this.N_renamed.d_renamed());
                        com.oplus.camera.timelapsepro.b_renamed bVar2 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar2.a_renamed("pref_time_lapse_pro_index_of_exposure_compensation_key", bVar2.N_renamed.n_renamed());
                    }
                    com.oplus.camera.timelapsepro.b_renamed bVar3 = com.oplus.camera.timelapsepro.b_renamed.this;
                    bVar3.C_renamed = bVar3.N_renamed.n_renamed();
                    com.oplus.camera.timelapsepro.b_renamed.this.p_renamed();
                    com.oplus.camera.timelapsepro.b_renamed.this.o_renamed();
                    if (com.oplus.camera.timelapsepro.b_renamed.this.o_renamed.isShown()) {
                        com.oplus.camera.timelapsepro.b_renamed.this.o_renamed.b_renamed(false);
                        com.oplus.camera.timelapsepro.b_renamed bVar4 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar4.a_renamed(bVar4.N_renamed.e_renamed());
                    }
                }
            });
            this.o_renamed.setMoveListener(new com.oplus.camera.timelapsepro.b_renamed.ParameterContainer_5());
        }
        addView(this.j_renamed, getScaleLayoutParams());
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.b_renamed$14, reason: invalid class name */
    class ParameterContainer_5 implements com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed {
        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        }

        ParameterContainer_5() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(3);
            com.oplus.camera.timelapsepro.b_renamed.this.G_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$14$_BBpe9w6y_keVJuKbA9m1R2QXaU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed();
                }
            }, 50L);
            if (com.oplus.camera.timelapsepro.b_renamed.this.N_renamed.d_renamed().equals(com.oplus.camera.timelapsepro.b_renamed.this.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value))) {
                com.oplus.camera.timelapsepro.b_renamed.this.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION, "auto");
            } else {
                com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                bVar.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_EXPOSURE_COMPENSATION, bVar.N_renamed.e_renamed());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.N_renamed.d_renamed(false);
        }
    }

    private void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "initFocusContainer.");
        this.k_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.e_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.k_renamed.setVisibility(8);
        this.p_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.k_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.y_renamed = (com.oplus.camera.ui.inverse.InverseTextView) this.k_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn);
        this.y_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.y_renamed.setTextSize(1, 12.0f);
        this.y_renamed.setOnTouchListener(this.S_renamed);
        if (4 == this.D_renamed) {
            this.y_renamed.setBackgroundResource(this.R_renamed ? com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_default : com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        a_renamed(this.p_renamed);
        this.y_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$ovlCsbMe7pXmOu3t-Y_renamed-eH_renamed-eZzTA
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.b_renamed(view);
            }
        });
        if (this.F_renamed != null) {
            this.y_renamed.setInverseColor(this.O_renamed.g_renamed());
            com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.y_renamed;
            a_renamed(inverseTextView, inverseTextView.a_renamed(), false);
            this.p_renamed.b_renamed(this.O_renamed.n_renamed());
            this.p_renamed.setScaleSpace(10);
            this.p_renamed.setValueList(this.O_renamed.o_renamed());
            this.p_renamed.setCurrentIndex(this.O_renamed.n_renamed());
            this.p_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.b_renamed.2
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
                public void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
                    com.oplus.camera.timelapsepro.b_renamed.this.O_renamed.a_renamed(i_renamed);
                    if (!com.oplus.camera.timelapsepro.b_renamed.this.O_renamed.g_renamed()) {
                        com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar.a_renamed(bVar.O_renamed.f_renamed(), com.oplus.camera.timelapsepro.b_renamed.this.O_renamed.d_renamed());
                        com.oplus.camera.timelapsepro.b_renamed bVar2 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar2.a_renamed("pref_time_lapse_pro_index_of_focus_mode_key", bVar2.O_renamed.n_renamed());
                    }
                    com.oplus.camera.timelapsepro.b_renamed.this.o_renamed();
                    if (com.oplus.camera.timelapsepro.b_renamed.this.p_renamed.isShown()) {
                        com.oplus.camera.timelapsepro.b_renamed.this.p_renamed.b_renamed(false);
                        com.oplus.camera.timelapsepro.b_renamed bVar3 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar3.a_renamed(bVar3.O_renamed.e_renamed());
                    }
                }
            });
            this.p_renamed.setMoveListener(new com.oplus.camera.timelapsepro.b_renamed.ParameterContainer_6());
            if (!this.O_renamed.g_renamed()) {
                this.p_renamed.c_renamed(true);
                this.p_renamed.b_renamed(this.u_renamed);
            }
        }
        addView(this.k_renamed, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        this.y_renamed.setInverseColor(!r0.a_renamed());
        this.O_renamed.a_renamed(this.y_renamed.a_renamed());
        this.p_renamed.setAutoState(this.y_renamed.a_renamed());
        a_renamed((com.oplus.camera.ui.inverse.InverseTextView) view, this.y_renamed.a_renamed());
        p_renamed();
        o_renamed();
        if (this.y_renamed.a_renamed()) {
            a_renamed(this.O_renamed.f_renamed(), getResources().getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
            a_renamed("pref_time_lapse_pro_index_of_focus_mode_key", -1);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, "auto");
        } else {
            a_renamed("pref_time_lapse_pro_index_of_focus_mode_key", this.O_renamed.n_renamed());
            b_renamed(4);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, this.M_renamed.e_renamed());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.b_renamed$3, reason: invalid class name */
    class ParameterContainer_6 implements com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed {
        ParameterContainer_6() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (com.oplus.camera.timelapsepro.b_renamed.this.O_renamed.g_renamed()) {
                com.oplus.camera.timelapsepro.b_renamed.this.y_renamed.performClick();
            }
            com.oplus.camera.timelapsepro.b_renamed.this.q_renamed();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(4);
            com.oplus.camera.timelapsepro.b_renamed.this.G_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$3$qIOm-k1f2VabT7LfoB-qwgpJ614
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed();
                }
            }, 50L);
            com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
            bVar.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_FOCUS_VALUE, bVar.O_renamed.e_renamed());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.O_renamed.d_renamed(false);
        }
    }

    private void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "initWbContainer.");
        this.l_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.e_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.l_renamed.setVisibility(8);
        this.q_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.l_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.z_renamed = (com.oplus.camera.ui.inverse.InverseTextView) this.l_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn);
        this.z_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.z_renamed.setTextSize(1, 12.0f);
        this.z_renamed.setOnTouchListener(this.S_renamed);
        if (4 == this.D_renamed) {
            this.z_renamed.setBackgroundResource(this.R_renamed ? com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_default : com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_full_screen);
        }
        a_renamed(this.q_renamed);
        this.z_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$YPZHG20aPbfopjBzaNxik_rM3gk
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.a_renamed(view);
            }
        });
        if (this.F_renamed != null) {
            this.z_renamed.setInverseColor(this.P_renamed.g_renamed());
            com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.z_renamed;
            a_renamed(inverseTextView, inverseTextView.a_renamed(), false);
            this.q_renamed.b_renamed(this.P_renamed.n_renamed());
            this.q_renamed.setScaleSpace(10);
            this.q_renamed.setValueList(this.P_renamed.o_renamed());
            this.q_renamed.setCurrentIndex(this.P_renamed.n_renamed());
            this.q_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.b_renamed.4
                @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
                public void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
                    com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.a_renamed(i_renamed);
                    if (!com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.g_renamed()) {
                        com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar.a_renamed(bVar.P_renamed.f_renamed(), com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.d_renamed());
                        com.oplus.camera.timelapsepro.b_renamed bVar2 = com.oplus.camera.timelapsepro.b_renamed.this;
                        bVar2.a_renamed("pref_time_lapse_pro_index_of_whitebalance_key", bVar2.P_renamed.n_renamed());
                    }
                    com.oplus.camera.timelapsepro.b_renamed.this.o_renamed();
                    if (com.oplus.camera.timelapsepro.b_renamed.this.q_renamed.isShown()) {
                        com.oplus.camera.timelapsepro.b_renamed.this.q_renamed.b_renamed(false);
                        java.lang.String strE = com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.e_renamed();
                        com.oplus.camera.timelapsepro.b_renamed.this.b_renamed(strE.substring(0, strE.length() - 1), strE.substring(strE.length() - 1));
                    }
                }
            });
            this.q_renamed.setMoveListener(new com.oplus.camera.timelapsepro.b_renamed.ParameterContainer_7());
            if (!this.P_renamed.g_renamed()) {
                this.q_renamed.c_renamed(true);
                this.q_renamed.b_renamed(this.v_renamed);
            }
        }
        addView(this.l_renamed, getScaleLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        this.z_renamed.setInverseColor(!r0.a_renamed());
        this.P_renamed.a_renamed(this.z_renamed.a_renamed());
        this.q_renamed.setAutoState(this.z_renamed.a_renamed());
        a_renamed((com.oplus.camera.ui.inverse.InverseTextView) view, this.z_renamed.a_renamed());
        p_renamed();
        o_renamed();
        if (this.z_renamed.a_renamed()) {
            a_renamed(this.P_renamed.f_renamed(), getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value));
            a_renamed("pref_time_lapse_pro_index_of_whitebalance_key", -1);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, "auto");
        } else {
            a_renamed("pref_time_lapse_pro_index_of_whitebalance_key", this.P_renamed.n_renamed());
            b_renamed(5);
            d_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, this.P_renamed.e_renamed());
        }
    }

    /* compiled from: ParameterContainer.java */
    /* renamed from: com.oplus.camera.timelapsepro.b_renamed$5, reason: invalid class name */
    class ParameterContainer_7 implements com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed {
        ParameterContainer_7() {
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
            if (com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.g_renamed()) {
                com.oplus.camera.timelapsepro.b_renamed.this.z_renamed.performClick();
            }
            com.oplus.camera.timelapsepro.b_renamed.this.q_renamed();
        }

        @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
        public void a_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.a_renamed(5);
            com.oplus.camera.timelapsepro.b_renamed.this.G_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$b_renamed$5$4ukiWCupQF0fVqJGYj2m3cNxiIg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed();
                }
            }, 50L);
            com.oplus.camera.timelapsepro.b_renamed bVar = com.oplus.camera.timelapsepro.b_renamed.this;
            bVar.c_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_WHITE_BALANCE, bVar.P_renamed.e_renamed());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.b_renamed.this.P_renamed.d_renamed(false);
        }
    }

    private void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        if (1 == this.D_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) timeLapseProParamScaleBar.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_container_margin_top_full_screen);
            if (this.E_renamed == 270) {
                layoutParams.rightMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_scale_margin_vertical);
            } else {
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_scale_margin_vertical);
            }
        }
    }

    private int getScaleLayoutId() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "getScaleLayoutId, mScreenLayoutMode : " + this.D_renamed + ", mModeOrientation : " + this.E_renamed);
        return 1 == this.D_renamed ? 270 == this.E_renamed ? com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_vertical_270 : com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_vertical : com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_default;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "clearScales.");
        android.widget.RelativeLayout relativeLayout = this.h_renamed;
        if (relativeLayout != null) {
            removeView(relativeLayout);
            this.h_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout2 = this.i_renamed;
        if (relativeLayout2 != null) {
            removeView(relativeLayout2);
            this.i_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout3 = this.j_renamed;
        if (relativeLayout3 != null) {
            removeView(relativeLayout3);
            this.j_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout4 = this.k_renamed;
        if (relativeLayout4 != null) {
            removeView(relativeLayout4);
            this.k_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout5 = this.l_renamed;
        if (relativeLayout5 != null) {
            removeView(relativeLayout5);
            this.l_renamed = null;
        }
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, int i_renamed, int i2) {
        com.oplus.camera.timelapsepro.adapter.ParamsAdapter paramsAdapter = this.d_renamed;
        if (paramsAdapter != null) {
            paramsAdapter.a_renamed(aVar, i_renamed, i2);
        }
        this.D_renamed = i_renamed;
        this.E_renamed = i2;
        this.R_renamed = aVar.q_renamed();
        a_renamed();
        if (i_renamed == 1) {
            c_renamed(i2);
            this.f_renamed.setVerticalFadingEdgeEnabled(true);
            this.f_renamed.setFadingEdgeLength(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_fading_length));
        } else if (i_renamed == 2 || i_renamed == 3 || i_renamed == 4) {
            this.f_renamed.setVerticalFadingEdgeEnabled(false);
            n_renamed();
        }
    }

    private void c_renamed(int i_renamed) {
        this.g_renamed.setOrientation(1);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_container_options_margin_top_full_screen);
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_container_options_margin_bottom_full_screen);
        if (270 == i_renamed) {
            layoutParams.addRule(11);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_container_margin_start_full_screen);
        } else {
            layoutParams.addRule(9);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_params_container_margin_start_full_screen);
        }
    }

    private void n_renamed() {
        this.g_renamed.setOrientation(0);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.removeRule(10);
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        layoutParams.setMargins(0, 0, 0, 0);
    }

    public void setParamList(java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.F_renamed = list;
        this.K_renamed = this.F_renamed.get(0);
        this.L_renamed = this.F_renamed.get(1);
        this.M_renamed = this.F_renamed.get(2);
        this.N_renamed = this.F_renamed.get(3);
        this.O_renamed = this.F_renamed.get(4);
        this.P_renamed = this.F_renamed.get(5);
        this.C_renamed = this.N_renamed.n_renamed();
        this.d_renamed.a_renamed(this.F_renamed);
        this.I_renamed = true;
    }

    public boolean b_renamed() {
        return this.I_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed() {
        if (this.F_renamed == null || this.K_renamed == null) {
            return;
        }
        boolean zG = true;
        for (int i_renamed = 1; i_renamed < this.F_renamed.size(); i_renamed++) {
            if (3 == i_renamed) {
                zG = this.F_renamed.get(i_renamed).d_renamed().equals(getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value));
            } else {
                zG = this.F_renamed.get(i_renamed).g_renamed();
            }
            if (!zG) {
                break;
            }
        }
        this.K_renamed.b_renamed(zG ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar;
        if (this.F_renamed == null || this.N_renamed == null || (eVar = this.L_renamed) == null || this.M_renamed == null) {
            return;
        }
        if (!eVar.g_renamed() && !this.M_renamed.g_renamed()) {
            this.N_renamed.b_renamed();
            this.N_renamed.a_renamed("-");
            this.N_renamed.b_renamed(false);
            a_renamed(this.N_renamed.f_renamed(), getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value));
            return;
        }
        this.N_renamed.a_renamed(this.C_renamed);
        this.N_renamed.b_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "onParamValueChanged, scale scroll position: " + i_renamed + ", index: " + i2);
        if (i_renamed == 1) {
            if (b_renamed(this.m_renamed)) {
                this.m_renamed.b_renamed(i2);
            }
        } else if (i_renamed == 2) {
            if (b_renamed(this.n_renamed)) {
                this.n_renamed.b_renamed(i2);
            }
        } else if (i_renamed == 4) {
            if (b_renamed(this.p_renamed)) {
                this.p_renamed.b_renamed(i2);
            }
        } else if (i_renamed == 5 && b_renamed(this.q_renamed)) {
            this.q_renamed.b_renamed(i2);
        }
    }

    private boolean b_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
        return timeLapseProParamScaleBar != null && timeLapseProParamScaleBar.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(int r10, com.oplus.camera.timelapsepro.a_renamed.e_renamed r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.b_renamed.a_renamed(int, com.oplus.camera.timelapsepro.a_renamed.e_renamed):void");
    }

    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar d_renamed(int i_renamed) {
        if (i_renamed == 1) {
            return this.m_renamed;
        }
        if (i_renamed == 2) {
            return this.n_renamed;
        }
        if (i_renamed == 3) {
            return this.o_renamed;
        }
        if (i_renamed == 4) {
            return this.p_renamed;
        }
        if (i_renamed != 5) {
            return null;
        }
        return this.q_renamed;
    }

    private com.oplus.camera.ui.inverse.InverseTextView e_renamed(int i_renamed) {
        if (i_renamed == 1) {
            return this.w_renamed;
        }
        if (i_renamed == 2) {
            return this.x_renamed;
        }
        if (i_renamed == 4) {
            return this.y_renamed;
        }
        if (i_renamed != 5) {
            return null;
        }
        return this.z_renamed;
    }

    private java.lang.String f_renamed(int i_renamed) {
        if (i_renamed == 1) {
            return getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        }
        if (i_renamed == 2) {
            return getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value);
        }
        if (i_renamed == 3) {
            return getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value);
        }
        if (i_renamed == 4) {
            return getResources().getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value);
        }
        if (i_renamed != 5) {
            return null;
        }
        return getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
    }

    private void g_renamed(int i_renamed) {
        if (this.F_renamed == null) {
            return;
        }
        if (this.h_renamed != null && this.L_renamed != null) {
            this.m_renamed.b_renamed(false);
            this.w_renamed.setInverseColor(this.L_renamed.g_renamed());
            a_renamed(this.h_renamed, i_renamed == 1, i_renamed == 1);
        }
        if (this.i_renamed != null && this.M_renamed != null) {
            this.n_renamed.b_renamed(false);
            this.x_renamed.setInverseColor(this.M_renamed.g_renamed());
            a_renamed(this.i_renamed, i_renamed == 2, i_renamed == 2);
        }
        if (this.j_renamed != null) {
            this.o_renamed.b_renamed(false);
            a_renamed(this.j_renamed, i_renamed == 3, i_renamed == 3);
        }
        if (this.k_renamed != null && this.O_renamed != null) {
            this.p_renamed.b_renamed(false);
            this.y_renamed.setInverseColor(this.O_renamed.g_renamed());
            a_renamed(this.k_renamed, i_renamed == 4, i_renamed == 4);
        }
        if (this.l_renamed != null && this.P_renamed != null) {
            this.q_renamed.b_renamed(false);
            this.z_renamed.setInverseColor(this.P_renamed.g_renamed());
            a_renamed(this.l_renamed, i_renamed == 5, i_renamed == 5);
        }
        a_renamed(i_renamed);
    }

    private void a_renamed(android.widget.RelativeLayout relativeLayout, boolean z_renamed, boolean z2) {
        if (!z2) {
            int i_renamed = 8;
            if (z_renamed && !relativeLayout.isShown()) {
                i_renamed = 0;
            }
            relativeLayout.setVisibility(i_renamed);
            if (i_renamed == 0) {
                this.J_renamed = true;
                return;
            }
            return;
        }
        if (z_renamed) {
            if (!relativeLayout.isShown()) {
                a_renamed(relativeLayout, !this.J_renamed);
                return;
            } else {
                b_renamed(relativeLayout, true);
                this.J_renamed = false;
                return;
            }
        }
        if (relativeLayout.isShown()) {
            b_renamed(relativeLayout, !this.J_renamed);
        }
    }

    private void a_renamed(android.widget.RelativeLayout relativeLayout, boolean z_renamed) {
        this.J_renamed = true;
        a_renamed((android.view.View) relativeLayout, true, z_renamed);
    }

    private void b_renamed(android.widget.RelativeLayout relativeLayout, boolean z_renamed) {
        a_renamed((android.view.View) relativeLayout, false, z_renamed);
    }

    private void a_renamed(final android.view.View view, final boolean z_renamed, final boolean z2) {
        android.animation.ObjectAnimator objectAnimatorOfFloat;
        android.animation.ObjectAnimator objectAnimatorOfFloat2;
        if (view == null) {
            return;
        }
        if (z_renamed) {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        objectAnimatorOfFloat.setDuration(z_renamed ? 400L : 250L);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.AnimatorSet.Builder builderPlay = animatorSet.play(objectAnimatorOfFloat);
        float f_renamed = this.f5659b;
        if (z2) {
            java.lang.String str = "translationX";
            if (1 != this.D_renamed) {
                str = "translationY";
            } else if (270 != this.E_renamed) {
                f_renamed = -f_renamed;
            }
            if (z_renamed) {
                objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, str, f_renamed, 0.0f);
            } else {
                objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, str, 0.0f, f_renamed);
            }
            objectAnimatorOfFloat2.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
            if (z_renamed) {
                animatorSet.setStartDelay(150L);
            }
        }
        final float f2 = f_renamed;
        final boolean zIsEnabled = view.isEnabled();
        this.f_renamed.setEnabled(false);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.b_renamed.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.timelapsepro.b_renamed.this.H_renamed = true;
                view.setAlpha(z_renamed ? 0.0f : 1.0f);
                if (z2) {
                    if (1 == com.oplus.camera.timelapsepro.b_renamed.this.D_renamed) {
                        view.setTranslationX(z_renamed ? f2 : 0.0f);
                    } else {
                        view.setTranslationY(z_renamed ? f2 : 0.0f);
                    }
                }
                view.setVisibility(0);
                view.setEnabled(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (z_renamed) {
                    view.setAlpha(0.0f);
                    view.setVisibility(8);
                } else {
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
                if (z2) {
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                }
                view.setEnabled(zIsEnabled);
                com.oplus.camera.timelapsepro.b_renamed.this.H_renamed = false;
                com.oplus.camera.timelapsepro.b_renamed.this.f_renamed.setEnabled(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (!z_renamed) {
                    view.setVisibility(8);
                }
                view.setEnabled(zIsEnabled);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                com.oplus.camera.timelapsepro.b_renamed.this.H_renamed = false;
                com.oplus.camera.timelapsepro.b_renamed.this.f_renamed.setEnabled(true);
            }
        });
        animatorSet.start();
    }

    protected void c_renamed() {
        removeAllViews();
        this.e_renamed = null;
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = this.f_renamed;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setAdapter(null);
            com.oplus.camera.timelapsepro.adapter.ParamsAdapter paramsAdapter = this.d_renamed;
            if (paramsAdapter != null) {
                paramsAdapter.a_renamed();
                this.d_renamed = null;
            }
        }
    }

    public boolean d_renamed() {
        com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar = this.K_renamed;
        if (eVar != null) {
            return eVar.h_renamed();
        }
        return false;
    }

    public void e_renamed() {
        java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> list;
        int i_renamed = this.B_renamed;
        if (i_renamed == 0 || (list = this.F_renamed) == null) {
            return;
        }
        a_renamed(i_renamed, list.get(i_renamed));
    }

    public void f_renamed() {
        a_renamed(0, this.F_renamed.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.Q_renamed.get(str);
        if (str3 == null || !str3.equals(str2)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                com.oplus.camera.e_renamed.a_renamed("ParameterContainer", "parameterChange empty value, key: " + str + ", value: " + str2);
                return;
            }
            this.Q_renamed.put(str, str2);
            com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
            if (aVar != null) {
                aVar.a_renamed(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str) {
        b_renamed(str, (java.lang.String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.b_renamed(str, str2);
        }
    }

    private void a_renamed(java.lang.String str, boolean z_renamed, java.lang.String str2) {
        com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.a_renamed(str, z_renamed, str2);
        }
    }

    public void setParameterCallback(com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar) {
        this.A_renamed = aVar;
    }

    public void a_renamed(long j_renamed) {
        com.oplus.camera.timelapsepro.a_renamed.e_renamed eVar = this.M_renamed;
        if (eVar == null || eVar.g_renamed()) {
            return;
        }
        try {
            if (j_renamed > java.lang.Long.parseLong(this.M_renamed.d_renamed()) / 1000000 || this.i_renamed == null) {
                return;
            }
            this.x_renamed.performClick();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.d_renamed(str, str2);
        }
    }

    private void d_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.timelapsepro.b_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.c_renamed(str, str2);
        }
    }

    public void g_renamed() {
        com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.y_renamed;
        if (inverseTextView != null) {
            inverseTextView.performClick();
        }
    }
}
