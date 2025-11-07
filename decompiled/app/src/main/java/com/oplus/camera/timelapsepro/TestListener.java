package com.oplus.camera.timelapsepro;

/* compiled from: TimeLapseProMenuLayout.java */
/* loaded from: classes2.dex */
public class g_renamed extends android.widget.RelativeLayout {
    private android.widget.RelativeLayout A_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar B_renamed;
    private int C_renamed;
    private int D_renamed;
    private int E_renamed;
    private boolean F_renamed;
    private boolean G_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView H_renamed;
    private com.oplus.camera.timelapsepro.a_renamed I_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView J_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView K_renamed;
    private android.widget.LinearLayout L_renamed;
    private android.widget.RelativeLayout.LayoutParams M_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.i_renamed> N_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.a_renamed> O_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.i_renamed P_renamed;
    private com.oplus.camera.timelapsepro.a_renamed.a_renamed Q_renamed;
    private boolean R_renamed;
    private com.oplus.camera.timelapsepro.b_renamed S_renamed;
    private int T_renamed;
    private android.widget.RelativeLayout.LayoutParams U_renamed;
    private android.widget.RelativeLayout.LayoutParams V_renamed;
    private android.widget.RelativeLayout.LayoutParams W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f5694a;
    private android.widget.RelativeLayout.LayoutParams aa_renamed;
    private android.widget.RelativeLayout.LayoutParams ab_renamed;
    private boolean ac_renamed;
    private int ad_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> ae_renamed;
    private com.oplus.camera.screen.b_renamed.a_renamed af_renamed;
    private androidx.recyclerview.widget.LinearLayoutManager ag_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.b_renamed ah_renamed;
    private androidx.recyclerview.widget.LinearLayoutManager ai_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.b_renamed aj_renamed;
    private boolean ak_renamed;
    private int al_renamed;
    private int am_renamed;
    private int an_renamed;
    private boolean ao_renamed;
    private java.lang.String ap_renamed;
    private android.view.View aq_renamed;
    private boolean ar_renamed;
    private boolean as_renamed;
    private java.lang.String at_renamed;
    private java.lang.String au_renamed;
    private com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed av_renamed;
    private com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed aw_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5695b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f5696c;
    private final com.oplus.camera.ComboPreferences d_renamed;
    private final java.util.List<com.oplus.camera.timelapsepro.g_renamed.e_renamed> e_renamed;
    private final java.util.List<com.oplus.camera.timelapsepro.g_renamed.d_renamed> f_renamed;
    private final android.os.Handler g_renamed;
    private final android.os.Handler h_renamed;
    private android.content.Context i_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.e_renamed j_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.f_renamed k_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.c_renamed l_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.a_renamed m_renamed;
    private androidx.recyclerview.widget.RecyclerView n_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.k_renamed> o_renamed;
    private com.oplus.camera.timelapsepro.adapter.b_renamed p_renamed;
    private androidx.recyclerview.widget.RecyclerView q_renamed;
    private android.widget.RelativeLayout r_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.j_renamed> s_renamed;
    private com.oplus.camera.timelapsepro.adapter.SubSettingAdapter t_renamed;
    private volatile com.oplus.camera.timelapsepro.a_renamed.j_renamed u_renamed;
    private volatile int v_renamed;
    private boolean w_renamed;
    private android.widget.RelativeLayout x_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar y_renamed;
    private int z_renamed;

    /* compiled from: TimeLapseProMenuLayout.java */
    public interface a_renamed {
        void a_renamed(int i_renamed, boolean z_renamed, java.lang.Object... objArr);
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    public interface c_renamed {
        void onChanged();
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    public interface d_renamed {
        void a_renamed();

        void b_renamed();
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    public interface e_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(long j_renamed);

        void a_renamed(java.lang.String str);

        void a_renamed(java.lang.String str, java.lang.String str2);
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    public interface f_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(java.lang.String str);

        void a_renamed(java.lang.String str, java.lang.String str2);

        void a_renamed(boolean z_renamed);
    }

    private java.lang.String g_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_INTERVAL;
        }
        if (i_renamed == 1) {
            return com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_TIMER;
        }
        if (i_renamed != 2) {
            return null;
        }
        return com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_PARAMETER;
    }

    public g_renamed(android.content.Context context, com.oplus.camera.ComboPreferences comboPreferences) {
        super(context);
        this.e_renamed = new java.util.ArrayList();
        this.f_renamed = new java.util.ArrayList();
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.v_renamed = 0;
        this.w_renamed = true;
        this.z_renamed = -1;
        this.C_renamed = 0;
        this.D_renamed = 0;
        this.E_renamed = 0;
        this.R_renamed = false;
        this.T_renamed = 0;
        this.ac_renamed = false;
        this.ad_renamed = 60;
        this.ae_renamed = null;
        this.af_renamed = null;
        this.ag_renamed = null;
        this.ah_renamed = null;
        this.ai_renamed = null;
        this.aj_renamed = null;
        this.ak_renamed = false;
        this.al_renamed = 3;
        this.am_renamed = 3;
        this.an_renamed = -1;
        this.ao_renamed = true;
        this.ap_renamed = "";
        this.aq_renamed = null;
        this.ar_renamed = false;
        this.as_renamed = false;
        this.at_renamed = null;
        this.au_renamed = null;
        this.av_renamed = new com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed() { // from class: com.oplus.camera.timelapsepro.g_renamed.1
            @Override // com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed
            public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.j_renamed jVar) {
                if (i_renamed != com.oplus.camera.timelapsepro.g_renamed.this.an_renamed) {
                    int i2 = 0;
                    while (i2 < com.oplus.camera.timelapsepro.g_renamed.this.t_renamed.c_renamed().size()) {
                        com.oplus.camera.timelapsepro.g_renamed.this.t_renamed.c_renamed().get(i2).f5651b = i2 == i_renamed;
                        i2++;
                    }
                    com.oplus.camera.timelapsepro.g_renamed.this.t_renamed.notifyDataSetChanged();
                    com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(i_renamed, jVar);
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "clickItem, current setting is_renamed " + i_renamed + ", so return.");
            }
        };
        this.aw_renamed = new com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed() { // from class: com.oplus.camera.timelapsepro.g_renamed.4
            @Override // com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed
            public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.k_renamed kVar) {
                int i2 = 0;
                while (true) {
                    boolean z_renamed = true;
                    if (i2 >= com.oplus.camera.timelapsepro.g_renamed.this.p_renamed.c_renamed().size()) {
                        break;
                    }
                    com.oplus.camera.timelapsepro.a_renamed.k_renamed kVar2 = com.oplus.camera.timelapsepro.g_renamed.this.p_renamed.c_renamed().get(i2);
                    if (i2 != i_renamed) {
                        z_renamed = false;
                    }
                    kVar2.a_renamed(z_renamed);
                    i2++;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.p_renamed.notifyDataSetChanged();
                com.oplus.camera.timelapsepro.g_renamed.this.T_renamed = i_renamed;
                com.oplus.camera.timelapsepro.g_renamed gVar = com.oplus.camera.timelapsepro.g_renamed.this;
                gVar.a_renamed("pref_time_lapse_pro_template_key", gVar.T_renamed);
                com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(com.oplus.camera.R_renamed.string.time_lapse_pro_hint_template_format, i_renamed == 0, com.oplus.camera.timelapsepro.g_renamed.this.p_renamed.c_renamed().get(i_renamed).b_renamed());
                com.oplus.camera.timelapsepro.g_renamed.this.ak_renamed = i_renamed != 0;
                if (i_renamed != 0) {
                    com.oplus.camera.timelapsepro.g_renamed.this.t_renamed();
                }
                com.oplus.camera.timelapsepro.g_renamed.this.d_renamed(i_renamed);
                com.oplus.camera.timelapsepro.g_renamed.this.e_renamed(i_renamed);
            }
        };
        this.i_renamed = context;
        this.d_renamed = comboPreferences;
        this.f5696c = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_radius_size);
        this.f5694a = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dx);
        this.f5695b = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dy);
        this.N_renamed = F_renamed();
        this.O_renamed = G_renamed();
        a_renamed();
        r_renamed();
        v_renamed();
        this.g_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.timelapsepro.g_renamed.5
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
                super.handleMessage(message);
                int i_renamed = message.what;
                if (i_renamed == 0) {
                    com.oplus.camera.timelapsepro.g_renamed.this.x_renamed();
                    return;
                }
                if (i_renamed == 1) {
                    com.oplus.camera.timelapsepro.g_renamed.this.b_renamed(-1);
                    return;
                }
                if (i_renamed != 2) {
                    return;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(false, true);
                if (com.oplus.camera.timelapsepro.g_renamed.this.y_renamed != null && com.oplus.camera.timelapsepro.g_renamed.this.y_renamed.isShown()) {
                    com.oplus.camera.timelapsepro.g_renamed.this.y_renamed.b_renamed(true);
                }
                if (com.oplus.camera.timelapsepro.g_renamed.this.B_renamed == null || !com.oplus.camera.timelapsepro.g_renamed.this.B_renamed.isShown()) {
                    return;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.B_renamed.b_renamed(true);
            }
        };
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Report TimelapsePro Thread");
        handlerThread.start();
        this.h_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.timelapsepro.g_renamed.6
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 10:
                        com.oplus.camera.timelapsepro.g_renamed gVar = com.oplus.camera.timelapsepro.g_renamed.this;
                        gVar.d_renamed(gVar.P_renamed.f__renamed());
                        break;
                    case 11:
                        com.oplus.camera.timelapsepro.g_renamed gVar2 = com.oplus.camera.timelapsepro.g_renamed.this;
                        gVar2.f_renamed(gVar2.Q_renamed.b_renamed());
                        break;
                    case 12:
                        com.oplus.camera.timelapsepro.g_renamed gVar3 = com.oplus.camera.timelapsepro.g_renamed.this;
                        gVar3.b_renamed(gVar3.at_renamed, com.oplus.camera.timelapsepro.g_renamed.this.au_renamed);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "putPreferenceInt, key: " + str + ", value: " + i_renamed);
        this.d_renamed.edit().putInt(str, i_renamed).apply();
    }

    private int b_renamed(java.lang.String str, int i_renamed) {
        int i2 = this.d_renamed.getInt(str, i_renamed);
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "getPreferenceInt, key: " + str + ", value: " + i2);
        return i2;
    }

    public void a_renamed() {
        this.ao_renamed = true;
        this.T_renamed = b_renamed("pref_time_lapse_pro_template_key", 0);
        this.v_renamed = b_renamed("pref_time_lapse_pro_sub_setting_key", 0);
        this.z_renamed = b_renamed("pref_time_lapse_pro_speed_key", -1);
        this.C_renamed = b_renamed("pref_time_lapse_pro_duration_key", 0);
        this.D_renamed = this.z_renamed;
        this.E_renamed = this.C_renamed;
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "restoreFromPreference, mSelectTemplate: " + this.T_renamed + ", mIndexOfCurrentSetting: " + this.v_renamed + ", mSpeedIndex: " + this.z_renamed + ", mDurationIndex: " + this.C_renamed);
    }

    public void b_renamed() {
        if (this.p_renamed != null) {
            int i_renamed = 0;
            while (i_renamed < this.o_renamed.size()) {
                this.o_renamed.get(i_renamed).a_renamed(i_renamed == this.T_renamed);
                i_renamed++;
            }
            this.p_renamed.notifyDataSetChanged();
        }
        if (this.t_renamed != null) {
            int i2 = 0;
            while (i2 < this.s_renamed.size()) {
                this.s_renamed.get(i2).f5651b = i2 == this.v_renamed;
                i2++;
            }
            this.u_renamed = this.s_renamed.get(this.v_renamed);
            this.t_renamed.notifyDataSetChanged();
        }
    }

    public void setShowTemplate(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (!this.F_renamed) {
            this.F_renamed = true;
        }
        this.G_renamed = z_renamed;
        d_renamed();
        if (this.G_renamed) {
            I_renamed();
            return;
        }
        J_renamed();
        if (this.ak_renamed) {
            return;
        }
        b_renamed(-1);
    }

    public boolean c_renamed() {
        return this.G_renamed;
    }

    public void d_renamed() throws android.content.res.Resources.NotFoundException {
        this.n_renamed.setVisibility(this.G_renamed ? 0 : 8);
        this.aq_renamed.setVisibility(this.G_renamed ? 8 : 0);
        this.r_renamed.setVisibility(this.G_renamed ? 8 : 0);
        if (this.G_renamed) {
            this.am_renamed = 3;
            c_renamed(3);
        } else {
            x_renamed();
        }
    }

    private void r_renamed() {
        this.n_renamed = new androidx.recyclerview.widget.RecyclerView(this.i_renamed);
        if (this.aa_renamed == null) {
            this.aa_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            this.aa_renamed.addRule(14);
            this.aa_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_margin_bottom);
        }
        addView(this.n_renamed, this.aa_renamed);
        this.ag_renamed = new androidx.recyclerview.widget.LinearLayoutManager(this.i_renamed, 0, false);
        this.n_renamed.setLayoutManager(this.ag_renamed);
        this.p_renamed = new com.oplus.camera.timelapsepro.adapter.b_renamed(this.i_renamed);
        if (this.o_renamed == null) {
            this.o_renamed = getTemplateInfoList();
        }
        this.p_renamed.a_renamed(this.aw_renamed);
        this.p_renamed.a_renamed(this.o_renamed);
        this.n_renamed.setAdapter(this.p_renamed);
        this.ah_renamed = new com.oplus.camera.timelapsepro.g_renamed.b_renamed(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_interval) / 2);
        this.n_renamed.addItemDecoration(this.ah_renamed);
        this.n_renamed.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s_renamed() {
        if (this.T_renamed == 0) {
            return;
        }
        com.oplus.camera.timelapsepro.adapter.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            bVar.a_renamed(0);
        }
        b_renamed(com.oplus.camera.R_renamed.string.time_lapse_pro_close_template);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t_renamed() {
        this.d_renamed.edit().remove("pref_time_lapse_pro_speed_key").remove("pref_time_lapse_pro_duration_key").remove("pref_time_lapse_pro_duration_key").apply();
        i_renamed();
        j_renamed();
        h_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        a_renamed(i_renamed, true, new java.lang.Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, java.lang.Object... objArr) {
        com.oplus.camera.timelapsepro.g_renamed.a_renamed aVar = this.m_renamed;
        if (aVar == null || !this.ao_renamed) {
            return;
        }
        aVar.a_renamed(i_renamed, z_renamed, objArr);
    }

    public void e_renamed() throws android.content.res.Resources.NotFoundException {
        java.lang.String string;
        int iB;
        if (this.T_renamed <= 0 && this.F_renamed && !this.G_renamed) {
            java.lang.String str = java.lang.String.format(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_format), this.P_renamed.d_renamed());
            com.oplus.camera.timelapsepro.a_renamed.a_renamed aVar = this.Q_renamed;
            if (aVar == null || (iB = aVar.b_renamed()) <= 0) {
                string = getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_unlimited_time);
            } else {
                string = java.lang.String.format(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_video_time_format_min), java.lang.Integer.valueOf(iB));
            }
            a_renamed(com.oplus.camera.R_renamed.string.time_lapse_pro_hint_text_format, f_renamed(), str, string);
        }
    }

    public boolean f_renamed() {
        int i_renamed = this.D_renamed;
        boolean z_renamed = (i_renamed == 0 || -1 == i_renamed) && this.E_renamed == 0;
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        return bVar != null ? z_renamed && !bVar.d_renamed() : z_renamed;
    }

    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.k_renamed> u_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : com.oplus.camera.ui.CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES) {
            arrayList.add(b_renamed(str));
        }
        return arrayList;
    }

    public java.util.List<com.oplus.camera.timelapsepro.a_renamed.k_renamed> getTemplateInfoList() {
        java.util.List<com.oplus.camera.timelapsepro.a_renamed.k_renamed> list = this.o_renamed;
        if (list == null || list.isEmpty()) {
            this.o_renamed = u_renamed();
        }
        return this.o_renamed;
    }

    private com.oplus.camera.timelapsepro.a_renamed.k_renamed b_renamed(java.lang.String str) {
        if (str.equals(com.oplus.camera.ui.CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[0])) {
            return new com.oplus.camera.timelapsepro.a_renamed.k_renamed(com.oplus.camera.R_renamed.drawable.time_lapse_pro_item_bg, this.T_renamed == 0, getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_no_template));
        }
        if (str.equals(com.oplus.camera.ui.CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[1])) {
            return new com.oplus.camera.timelapsepro.a_renamed.k_renamed(com.oplus.camera.R_renamed.drawable.time_lapse_pro_template_car, 1 == this.T_renamed, getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_template_car));
        }
        if (str.equals(com.oplus.camera.ui.CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[2])) {
            return new com.oplus.camera.timelapsepro.a_renamed.k_renamed(com.oplus.camera.R_renamed.drawable.time_lapse_pro_template_star, 2 == this.T_renamed, getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_template_star));
        }
        if (str.equals(com.oplus.camera.ui.CameraUIInterface.KEY_TIMELAPSE_PRO_TEMPLATES[3])) {
            return new com.oplus.camera.timelapsepro.a_renamed.k_renamed(com.oplus.camera.R_renamed.drawable.time_lapse_pro_template_cloud, 3 == this.T_renamed, getResources().getString(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_template_cloud));
        }
        return null;
    }

    private void v_renamed() {
        this.aq_renamed = new android.view.View(this.i_renamed);
        this.aq_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout_bottom_view);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(12);
        addView(this.aq_renamed, layoutParams);
        this.q_renamed = new androidx.recyclerview.widget.RecyclerView(this.i_renamed);
        this.ai_renamed = new androidx.recyclerview.widget.LinearLayoutManager(this.i_renamed, 0, false);
        this.q_renamed.setLayoutManager(this.ai_renamed);
        this.t_renamed = new com.oplus.camera.timelapsepro.adapter.SubSettingAdapter(this.i_renamed);
        if (this.s_renamed == null) {
            this.s_renamed = w_renamed();
        }
        this.t_renamed.a_renamed(this.av_renamed);
        this.t_renamed.a_renamed(this.s_renamed);
        this.q_renamed.setAdapter(this.t_renamed);
        this.q_renamed.setItemViewCacheSize(-1);
        this.aj_renamed = new com.oplus.camera.timelapsepro.g_renamed.b_renamed(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_item_divider_horizontal) / 2, getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_item_divider_vertical) / 2);
        this.q_renamed.addItemDecoration(this.aj_renamed);
        if (this.ab_renamed == null) {
            this.ab_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        this.r_renamed = new android.widget.RelativeLayout(this.i_renamed);
        this.r_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_title);
        this.r_renamed.addView(this.q_renamed);
        this.r_renamed.setGravity(17);
        addView(this.r_renamed, this.ab_renamed);
        this.r_renamed.setVisibility(8);
    }

    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.j_renamed> w_renamed() throws android.content.res.Resources.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String[] stringArray = getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_settings);
        int i_renamed = 0;
        while (i_renamed < stringArray.length) {
            arrayList.add(new com.oplus.camera.timelapsepro.a_renamed.j_renamed(stringArray[i_renamed], this.v_renamed == i_renamed));
            i_renamed++;
        }
        this.u_renamed = (com.oplus.camera.timelapsepro.a_renamed.j_renamed) arrayList.get(this.v_renamed);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.j_renamed jVar) {
        this.v_renamed = i_renamed;
        a_renamed("pref_time_lapse_pro_sub_setting_key", this.v_renamed);
        this.u_renamed = jVar;
        this.g_renamed.sendEmptyMessage(0);
        a_renamed(false, true);
        y_renamed();
        e_renamed(g_renamed(i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x_renamed() throws android.content.res.Resources.NotFoundException {
        androidx.recyclerview.widget.RecyclerView recyclerView;
        com.oplus.camera.screen.b_renamed.a_renamed aVar = this.af_renamed;
        if (aVar != null) {
            a_renamed(aVar.j_renamed(), this.af_renamed.k_renamed());
        }
        if (this.x_renamed == null) {
            z_renamed();
        }
        if (this.A_renamed == null) {
            B_renamed();
        }
        if (this.S_renamed == null) {
            D_renamed();
        }
        a_renamed(false, true);
        if (this.u_renamed.f5650a.equals(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_speed))) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.y_renamed;
            if (timeLapseProParamScaleBar != null) {
                timeLapseProParamScaleBar.setShowText(true);
            }
            c_renamed(0);
        } else if (this.u_renamed.f5650a.equals(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_duration))) {
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.B_renamed;
            if (timeLapseProParamScaleBar2 != null) {
                timeLapseProParamScaleBar2.setShowText(true);
            }
            c_renamed(1);
        } else if (this.u_renamed.f5650a.equals(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_pro_params))) {
            c_renamed(2);
        }
        if (1 != this.af_renamed.j_renamed() || this.ar_renamed || (recyclerView = this.q_renamed) == null || this.t_renamed == null) {
            return;
        }
        this.ar_renamed = true;
        recyclerView.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.timelapsepro.g_renamed.7
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "onPreDraw, width: " + com.oplus.camera.timelapsepro.g_renamed.this.q_renamed.getWidth());
                if (com.oplus.camera.timelapsepro.g_renamed.this.q_renamed.getWidth() <= 0) {
                    return false;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.t_renamed.a_renamed(com.oplus.camera.timelapsepro.g_renamed.this.q_renamed.getWidth());
                com.oplus.camera.timelapsepro.g_renamed.this.t_renamed.notifyDataSetChanged();
                com.oplus.camera.timelapsepro.g_renamed.this.q_renamed.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
    }

    private void c_renamed(int i_renamed) {
        this.al_renamed = i_renamed;
        this.an_renamed = i_renamed;
        if (i_renamed == 0) {
            b_renamed(true, true);
            c_renamed(false, true);
            d_renamed(false, true);
        } else if (i_renamed == 1) {
            b_renamed(false, true);
            c_renamed(true, true);
            d_renamed(false, true);
        } else if (i_renamed == 2) {
            b_renamed(false, true);
            c_renamed(false, true);
            d_renamed(true, true);
        } else if (i_renamed == 3) {
            b_renamed(false, false);
            c_renamed(false, false);
            d_renamed(false, false);
            a_renamed(false, false);
        }
        this.am_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        a_renamed(str, str2, str3, true, false);
    }

    private void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed) {
        a_renamed(str, str2, str3, z_renamed, true);
    }

    private void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, boolean z2) {
        a_renamed(str, str2, str3, z_renamed, z2, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, boolean z2, long j_renamed) {
        if (this.M_renamed == null) {
            y_renamed();
        }
        if (!this.R_renamed) {
            this.K_renamed = new com.oplus.camera.ui.inverse.InverseTextView(this.i_renamed);
            this.K_renamed.setTextSize(1, 12.0f);
            this.K_renamed.setGravity(17);
            this.K_renamed.setIncludeFontPadding(false);
            this.K_renamed.setSingleLine(true);
            this.K_renamed.setTextColor(this.i_renamed.getColor(com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color));
            this.K_renamed.setShadowLayer(this.f5696c, this.f5694a, this.f5695b, androidx.core.a_renamed.a_renamed.c_renamed(this.i_renamed, com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
            this.K_renamed.setMaxWidth(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_seek_text_desc_max_width));
            this.I_renamed = new com.oplus.camera.timelapsepro.a_renamed(this.i_renamed);
            this.I_renamed.setTextColor(this.i_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.I_renamed.a_renamed(com.oplus.camera.util.Util.z_renamed(), 2, 56.0f);
            this.J_renamed = new com.oplus.camera.ui.inverse.InverseTextView(this.i_renamed);
            this.J_renamed.setTextSize(2, 46.0f);
            this.J_renamed.setGravity(17);
            this.J_renamed.setTextColor(this.i_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.J_renamed.setShadowLayer(this.f5696c, this.f5694a, this.f5695b, androidx.core.a_renamed.a_renamed.c_renamed(this.i_renamed, com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.i_renamed);
            linearLayout.setLayoutDirection(0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(1);
            linearLayout.addView(this.I_renamed);
            linearLayout.addView(this.J_renamed);
            ((android.widget.LinearLayout.LayoutParams) this.J_renamed.getLayoutParams()).leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_center_tips_divider);
            this.L_renamed = new android.widget.LinearLayout(this.i_renamed);
            this.L_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout_tips_layout);
            this.L_renamed.setOrientation(1);
            this.L_renamed.setGravity(17);
            this.L_renamed.addView(linearLayout, new android.widget.LinearLayout.LayoutParams(-2, -2));
            this.L_renamed.addView(this.K_renamed, new android.widget.LinearLayout.LayoutParams(-2, -2));
            addView(this.L_renamed, this.M_renamed);
            this.L_renamed.setVisibility(8);
            this.R_renamed = true;
            this.K_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.timelapsepro.g_renamed.8
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (com.oplus.camera.timelapsepro.g_renamed.this.I_renamed.getHeight() > 0) {
                        com.oplus.camera.timelapsepro.g_renamed.this.K_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    com.oplus.camera.timelapsepro.g_renamed.this.L_renamed.setPadding(0, com.oplus.camera.timelapsepro.g_renamed.this.K_renamed.getHeight(), 0, 0);
                }
            });
        }
        this.K_renamed.setSingleLine(4 == this.af_renamed.j_renamed());
        this.K_renamed.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.K_renamed.setLines(4 == this.af_renamed.j_renamed() ? 1 : 2);
        this.I_renamed.setTextToDraw(str == null ? "" : str);
        this.J_renamed.setText(str2 == null ? "" : str2);
        this.K_renamed.setText(str3 != null ? str3 : "");
        this.K_renamed.setVisibility(str3 != null ? 0 : 4);
        if (str2 != null && !str2.isEmpty() && this.L_renamed.getChildCount() > 0) {
            ((android.widget.LinearLayout) this.L_renamed.getChildAt(0)).setGravity(str2.matches("^[a_renamed-zA-Z_renamed]*") ? 80 : 17);
        }
        if (z2) {
            a_renamed(true, true);
        }
        if (this.g_renamed.hasMessages(2)) {
            this.g_renamed.removeMessages(2);
        }
        if (z_renamed) {
            this.g_renamed.sendEmptyMessageDelayed(2, j_renamed);
        }
    }

    private void y_renamed() {
        if (this.M_renamed == null) {
            this.M_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        this.M_renamed.removeRule(13);
        this.M_renamed.addRule(14);
        this.M_renamed.addRule(2, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_title);
        if (1 == this.af_renamed.j_renamed()) {
            this.M_renamed.removeRule(2);
            this.M_renamed.addRule(13);
        } else if (3 == this.af_renamed.j_renamed()) {
            this.M_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_seek_text_margin_bottom_split);
        } else if (4 == this.af_renamed.j_renamed()) {
            this.M_renamed.bottomMargin = getResources().getDimensionPixelOffset(this.u_renamed.f5650a.equals(getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_setting_of_pro_params)) ? com.oplus.camera.R_renamed.dimen.setting_seek_text_margin_bottom_rack_params : com.oplus.camera.R_renamed.dimen.setting_seek_text_margin_bottom_rack);
        } else {
            this.M_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_seek_text_margin_bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2) {
        this.ac_renamed = z_renamed;
        if (z2) {
            a_renamed(z_renamed);
            return;
        }
        android.widget.LinearLayout linearLayout = this.L_renamed;
        if (linearLayout != null) {
            linearLayout.setVisibility(z_renamed ? 0 : 8);
        }
        if (z_renamed || !this.g_renamed.hasMessages(2)) {
            return;
        }
        this.g_renamed.removeMessages(2);
    }

    private void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
            if (bVar != null) {
                bVar.setEnabled(false);
            }
            com.oplus.camera.util.Util.a_renamed(this.L_renamed, 0.0f, 1.0f, 400L, 150L, new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.timelapsepro.g_renamed.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    if (com.oplus.camera.timelapsepro.g_renamed.this.S_renamed != null) {
                        com.oplus.camera.timelapsepro.g_renamed.this.S_renamed.setEnabled(true);
                    }
                }
            }, com.oplus.camera.professional.t_renamed.f5227a);
            return;
        }
        com.oplus.camera.util.Util.a_renamed(this.L_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
    }

    private int getScaleLayoutId() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "getScaleLayoutId");
        return 1 == this.af_renamed.j_renamed() ? 270 == this.af_renamed.k_renamed() ? com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_vertical_270 : com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_vertical : com.oplus.camera.R_renamed.layout.time_lapse_pro_scale_bar_default;
    }

    private void z_renamed() {
        this.w_renamed = this.z_renamed == -1;
        this.x_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.i_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.y_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.x_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.H_renamed = (com.oplus.camera.ui.inverse.InverseTextView) this.x_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn);
        this.H_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.H_renamed.setTextSize(1, 12.0f);
        final android.widget.TextView textView = (android.widget.TextView) this.x_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_text);
        final com.a_renamed.a_renamed.f_renamed fVarA = com.oplus.camera.professional.u_renamed.a_renamed();
        this.H_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.g_renamed.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    com.oplus.camera.professional.u_renamed.a_renamed(view, fVarA, true);
                } else if (action == 1 || action == 3) {
                    com.oplus.camera.professional.u_renamed.a_renamed(view, fVarA, false);
                }
                return false;
            }
        });
        if (this.N_renamed == null) {
            this.N_renamed = F_renamed();
        }
        if (this.D_renamed == -1) {
            this.D_renamed = 0;
        }
        this.P_renamed = this.N_renamed.get(this.D_renamed);
        this.y_renamed.setTextUpdateListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.c_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$g_renamed$MLKeWOscLWQ8s98wFOyRI1tGQ1M
            public final void onUpdate(java.lang.String str) {
                textView.setText(str);
            }
        });
        this.H_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$g_renamed$tCrKp-4pvj04dPdkBupmpcP2Dr8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.a_renamed(view);
            }
        });
        this.H_renamed.setInverseColor(this.w_renamed);
        com.oplus.camera.timelapsepro.d_renamed.a_renamed(this.H_renamed, this.w_renamed, false);
        this.y_renamed.setValueList(this.N_renamed);
        this.y_renamed.setLineSpace(this.ad_renamed);
        int i_renamed = this.D_renamed;
        if (i_renamed != 0) {
            this.y_renamed.setCurrentIndex(i_renamed);
        }
        this.y_renamed.setMoveListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed() { // from class: com.oplus.camera.timelapsepro.g_renamed.11
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
            public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
                if (com.oplus.camera.timelapsepro.g_renamed.this.w_renamed) {
                    com.oplus.camera.timelapsepro.g_renamed.this.w_renamed = false;
                    com.oplus.camera.timelapsepro.g_renamed.this.y_renamed.setAutoState(false);
                    if (com.oplus.camera.timelapsepro.g_renamed.this.H_renamed != null) {
                        com.oplus.camera.timelapsepro.g_renamed.this.H_renamed.setInverseColor(false);
                        com.oplus.camera.timelapsepro.d_renamed.a_renamed(com.oplus.camera.timelapsepro.g_renamed.this.H_renamed, false, true);
                    }
                }
                com.oplus.camera.timelapsepro.g_renamed.this.s_renamed();
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.timelapsepro.g_renamed.this.g_renamed.hasMessages(2)) {
                    com.oplus.camera.timelapsepro.g_renamed.this.g_renamed.removeMessages(2);
                }
                com.oplus.camera.timelapsepro.g_renamed.this.g_renamed.sendEmptyMessageDelayed(2, 1000L);
                com.oplus.camera.timelapsepro.g_renamed.this.K_renamed();
            }
        });
        this.y_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$g_renamed$QD3VFN4PF0R__xhGX1K3W-xTRKE
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
            public final void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i2) {
                this.f_renamed$0.b_renamed(timeLapseProParamScaleBar, i2);
            }
        });
        A_renamed();
        addView(this.x_renamed, this.U_renamed);
        this.y_renamed.c_renamed(!this.w_renamed);
        int i2 = this.z_renamed;
        if (i2 <= 0) {
            this.y_renamed.b_renamed(0);
        } else {
            this.y_renamed.b_renamed(i2);
        }
        this.x_renamed.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        this.H_renamed.setInverseColor(!r0.a_renamed());
        this.w_renamed = this.H_renamed.a_renamed();
        this.y_renamed.setAutoState(this.w_renamed);
        com.oplus.camera.timelapsepro.d_renamed.a_renamed((com.oplus.camera.ui.inverse.InverseTextView) view, this.w_renamed);
        if (this.w_renamed) {
            this.ap_renamed = "";
            a_renamed("pref_time_lapse_pro_speed_key", -1);
            d_renamed("auto");
        } else {
            d_renamed(this.P_renamed.d_renamed());
        }
        if (this.g_renamed.hasMessages(2)) {
            this.g_renamed.removeMessages(2);
        }
        this.g_renamed.sendEmptyMessageDelayed(2, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
        com.oplus.camera.timelapsepro.b_renamed bVar;
        this.D_renamed = i_renamed;
        this.P_renamed = this.N_renamed.get(i_renamed);
        if (this.y_renamed.isShown()) {
            this.y_renamed.b_renamed(false);
            if (this.v_renamed == 0) {
                a_renamed(this.P_renamed.f__renamed(), this.P_renamed.g__renamed(), this.P_renamed.c_renamed(), false);
            }
        }
        c_renamed(this.P_renamed.d_renamed(), i_renamed);
        if (!this.y_renamed.isShown() || (bVar = this.S_renamed) == null) {
            return;
        }
        bVar.a_renamed((java.lang.Long.parseLong(this.P_renamed.d_renamed()) * 1000) / 30);
    }

    private void A_renamed() {
        if (this.U_renamed == null) {
            this.U_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        this.U_renamed.addRule(2, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_title);
        this.U_renamed.removeRule(14);
        this.U_renamed.removeRule(9);
        this.U_renamed.removeRule(11);
        if (2 == this.af_renamed.j_renamed() || 3 == this.af_renamed.j_renamed()) {
            this.U_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        if (4 == this.af_renamed.j_renamed()) {
            this.U_renamed.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_width_rack_screen);
            this.U_renamed.addRule(14);
            this.U_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
            com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.H_renamed;
            if (inverseTextView != null) {
                inverseTextView.setBackgroundResource(this.af_renamed.q_renamed() ? com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_default : com.oplus.camera.R_renamed.drawable.time_lapse_pro_auto_btn_bg_full_screen);
                return;
            }
            return;
        }
        this.U_renamed.addRule(270 == this.af_renamed.k_renamed() ? 11 : 9);
        this.U_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_margin_bottom_full_screen);
        com.oplus.camera.ui.inverse.InverseTextView inverseTextView2 = this.H_renamed;
        if (inverseTextView2 != null) {
            ((android.widget.RelativeLayout.LayoutParams) inverseTextView2.getLayoutParams()).topMargin = com.oplus.camera.util.Util.Z_renamed() == 0 ? getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_auto_button_margin_vertical_top) : getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_auto_button_margin_vertical_top_with_nav);
        }
    }

    public void setSettingValues(java.lang.String str) {
        if (this.N_renamed == null) {
            this.N_renamed = F_renamed();
        }
        for (int i_renamed = 0; i_renamed < this.N_renamed.size(); i_renamed++) {
            if (this.N_renamed.get(i_renamed).d_renamed().equals(str)) {
                this.D_renamed = i_renamed;
            }
        }
    }

    private void b_renamed(boolean z_renamed, boolean z2) {
        android.widget.RelativeLayout relativeLayout = this.x_renamed;
        if (relativeLayout != null) {
            if (z2) {
                if (z_renamed || this.am_renamed == 0) {
                    if (z_renamed) {
                        com.oplus.camera.util.Util.a_renamed(this.x_renamed, 0.0f, 1.0f, 400L, 150L, (android.view.animation.Animation.AnimationListener) null, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    } else {
                        com.oplus.camera.util.Util.a_renamed(this.x_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    }
                }
                return;
            }
            relativeLayout.setVisibility(z_renamed ? 0 : 8);
        }
    }

    private void B_renamed() {
        this.A_renamed = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.i_renamed).inflate(getScaleLayoutId(), (android.view.ViewGroup) this, false);
        this.B_renamed = (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar) this.A_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_bar);
        this.A_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn).setVisibility(4);
        final android.widget.TextView textView = (android.widget.TextView) this.A_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scale_text);
        if (this.O_renamed == null) {
            this.O_renamed = G_renamed();
        }
        this.Q_renamed = this.O_renamed.get(0);
        this.B_renamed.setTextUpdateListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.c_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$g_renamed$zpzuJGx3CnKqsqlHAWGZXdhO0nI
            public final void onUpdate(java.lang.String str) {
                textView.setText(str);
            }
        });
        this.B_renamed.setValueList(this.O_renamed);
        this.B_renamed.setScaleSpace(12);
        this.B_renamed.c_renamed(true);
        int i_renamed = this.E_renamed;
        if (i_renamed != 0) {
            this.B_renamed.setCurrentIndex(i_renamed);
        }
        this.B_renamed.setMoveListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed() { // from class: com.oplus.camera.timelapsepro.g_renamed.2
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
            public void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar) {
                com.oplus.camera.timelapsepro.g_renamed.this.s_renamed();
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed
            public void a_renamed() {
                com.oplus.camera.timelapsepro.g_renamed.this.g_renamed.sendEmptyMessageDelayed(2, 1000L);
                com.oplus.camera.timelapsepro.g_renamed.this.L_renamed();
            }
        });
        this.B_renamed.setScaleListener(new com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$g_renamed$EY_RPrT8h8MD8wujwGJ8hP4BXj0
            @Override // com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed
            public final void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i2) {
                this.f_renamed$0.a_renamed(timeLapseProParamScaleBar, i2);
            }
        });
        C_renamed();
        addView(this.A_renamed, this.V_renamed);
        this.B_renamed.b_renamed(this.C_renamed);
        this.A_renamed.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed) {
        if (this.E_renamed != i_renamed) {
            this.C_renamed = i_renamed;
            a_renamed("pref_time_lapse_pro_duration_key", i_renamed);
        }
        this.E_renamed = i_renamed;
        this.Q_renamed = this.O_renamed.get(i_renamed);
        this.B_renamed.setShowText(false);
        if (1 == this.al_renamed) {
            a_renamed(this.Q_renamed.f__renamed(), this.Q_renamed.g__renamed(), this.Q_renamed.a_renamed(this.P_renamed).c_renamed(), false);
        }
        a_renamed(this.Q_renamed.a_renamed());
    }

    private void C_renamed() {
        if (this.V_renamed == null) {
            this.V_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        this.V_renamed.addRule(2, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_title);
        this.V_renamed.removeRule(14);
        this.V_renamed.removeRule(9);
        this.V_renamed.removeRule(11);
        if (2 == this.af_renamed.j_renamed() || 3 == this.af_renamed.j_renamed()) {
            this.V_renamed.bottomMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        if (4 == this.af_renamed.j_renamed()) {
            this.V_renamed.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_width_rack_screen);
            this.V_renamed.addRule(14);
            this.V_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_margin_bottom_rack_screen) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom);
            return;
        }
        this.V_renamed.addRule(270 == this.af_renamed.k_renamed() ? 11 : 9);
        this.V_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_margin_bottom_full_screen);
        android.widget.RelativeLayout relativeLayout = this.A_renamed;
        if (relativeLayout != null) {
            ((android.widget.RelativeLayout.LayoutParams) relativeLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.auto_btn).getLayoutParams()).topMargin = com.oplus.camera.util.Util.Z_renamed() == 0 ? getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_auto_button_margin_vertical_top) : getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_auto_button_margin_vertical_top_with_nav);
        }
    }

    private void c_renamed(boolean z_renamed, boolean z2) {
        android.widget.RelativeLayout relativeLayout = this.A_renamed;
        if (relativeLayout != null) {
            if (z2) {
                if (z_renamed || 1 == this.am_renamed) {
                    if (z_renamed) {
                        com.oplus.camera.util.Util.a_renamed(this.A_renamed, 0.0f, 1.0f, 400L, 150L, (android.view.animation.Animation.AnimationListener) null, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    } else {
                        com.oplus.camera.util.Util.a_renamed(this.A_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    }
                }
                return;
            }
            relativeLayout.setVisibility(z_renamed ? 0 : 8);
        }
    }

    private void D_renamed() {
        this.S_renamed = new com.oplus.camera.timelapsepro.b_renamed(this.i_renamed, this.d_renamed);
        E_renamed();
        this.S_renamed.setLayoutParams(this.W_renamed);
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        com.oplus.camera.screen.b_renamed.a_renamed aVar = this.af_renamed;
        bVar.a_renamed(aVar, aVar.j_renamed(), this.af_renamed.k_renamed());
        java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> list = this.ae_renamed;
        if (list != null) {
            this.S_renamed.setParamList(list);
        }
        this.S_renamed.setParameterCallback(new com.oplus.camera.timelapsepro.b_renamed.a_renamed() { // from class: com.oplus.camera.timelapsepro.g_renamed.3
            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.timelapsepro.g_renamed.this.s_renamed();
            }

            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void a_renamed(java.lang.String str, java.lang.String str2) {
                com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(str, str2);
            }

            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void a_renamed(java.lang.String str, boolean z_renamed, java.lang.String str2) {
                if (z_renamed) {
                    com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(str, (java.lang.String) null, (java.lang.String) null);
                    com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(true, true);
                } else {
                    com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(false, true);
                }
                if (str2 == null) {
                    com.oplus.camera.timelapsepro.g_renamed.this.b_renamed((java.lang.String) null, com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_VALUE_CLEAR);
                } else {
                    com.oplus.camera.timelapsepro.g_renamed.this.e_renamed(str2);
                }
            }

            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void b_renamed(java.lang.String str, java.lang.String str2) {
                if (str != null) {
                    if (2 == com.oplus.camera.timelapsepro.g_renamed.this.al_renamed) {
                        com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(str, str2, null, true, true, 1500L);
                        return;
                    }
                    return;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.a_renamed(false, true);
            }

            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void c_renamed(java.lang.String str, java.lang.String str2) {
                com.oplus.camera.timelapsepro.g_renamed.this.at_renamed = str;
                com.oplus.camera.timelapsepro.g_renamed.this.au_renamed = str2;
                com.oplus.camera.timelapsepro.g_renamed.this.h_renamed.sendEmptyMessage(12);
            }

            @Override // com.oplus.camera.timelapsepro.b_renamed.a_renamed
            public void d_renamed(java.lang.String str, java.lang.String str2) {
                com.oplus.camera.timelapsepro.g_renamed.this.at_renamed = str;
                com.oplus.camera.timelapsepro.g_renamed.this.au_renamed = str2;
                if (com.oplus.camera.timelapsepro.g_renamed.this.at_renamed != null && com.oplus.camera.timelapsepro.g_renamed.this.at_renamed.equals(str) && com.oplus.camera.timelapsepro.g_renamed.this.h_renamed.hasMessages(12)) {
                    return;
                }
                com.oplus.camera.timelapsepro.g_renamed.this.h_renamed.sendEmptyMessageDelayed(12, 1000L);
            }
        });
        if (this.S_renamed.b_renamed()) {
            addView(this.S_renamed);
        }
        this.S_renamed.setVisibility(8);
    }

    private void E_renamed() {
        if (this.W_renamed == null) {
            this.W_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        this.W_renamed.addRule(2, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_title);
        this.W_renamed.removeRule(14);
        this.W_renamed.removeRule(9);
        this.W_renamed.removeRule(11);
        if (2 == this.af_renamed.j_renamed() || 3 == this.af_renamed.j_renamed() || 4 == this.af_renamed.j_renamed()) {
            android.widget.RelativeLayout.LayoutParams layoutParams = this.W_renamed;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.addRule(14);
            this.W_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_param_bottom_margin);
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = this.W_renamed;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.addRule(270 == this.af_renamed.k_renamed() ? 11 : 9);
        this.W_renamed.bottomMargin = 0;
    }

    private void d_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        if (bVar != null) {
            if (!z_renamed) {
                bVar.e_renamed();
            }
            if (z2) {
                if (z_renamed || 2 == this.am_renamed) {
                    if (z_renamed) {
                        com.oplus.camera.util.Util.a_renamed(this.S_renamed, 0.0f, 1.0f, 400L, 150L, (android.view.animation.Animation.AnimationListener) null, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    } else {
                        com.oplus.camera.util.Util.a_renamed(this.S_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
                        return;
                    }
                }
                return;
            }
            this.S_renamed.setVisibility(z_renamed ? 0 : 8);
        }
    }

    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.i_renamed> F_renamed() throws android.content.res.Resources.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_speeds)) {
            arrayList.add(new com.oplus.camera.timelapsepro.a_renamed.i_renamed(str));
        }
        return arrayList;
    }

    public java.lang.String g_renamed() {
        if (this.z_renamed != -1) {
            return getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_speeds)[this.z_renamed];
        }
        return getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_speeds)[0];
    }

    public void a_renamed(java.lang.String str) {
        c_renamed(str);
    }

    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.a_renamed> G_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed <= 240; i_renamed += 5) {
            arrayList.add(new com.oplus.camera.timelapsepro.a_renamed.a_renamed(i_renamed));
        }
        return arrayList;
    }

    public void a_renamed(com.oplus.camera.timelapsepro.g_renamed.e_renamed eVar) {
        if (this.e_renamed.contains(eVar)) {
            return;
        }
        this.e_renamed.add(eVar);
    }

    public void setTimeLapseProMenuListener(com.oplus.camera.timelapsepro.g_renamed.e_renamed eVar) {
        if (eVar == null) {
            com.oplus.camera.timelapsepro.g_renamed.e_renamed eVar2 = this.j_renamed;
            if (eVar2 == null || !this.e_renamed.contains(eVar2)) {
                return;
            }
            this.e_renamed.remove(this.j_renamed);
            this.j_renamed = null;
            return;
        }
        this.j_renamed = eVar;
        if (this.e_renamed.contains(eVar)) {
            this.e_renamed.remove(eVar);
        }
        this.e_renamed.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.g_renamed.removeCallbacksAndMessages(null);
        this.h_renamed.removeCallbacksAndMessages(null);
        this.h_renamed.getLooper().quitSafely();
        this.e_renamed.clear();
        this.f_renamed.clear();
        this.i_renamed = null;
        this.m_renamed = null;
        this.l_renamed = null;
        this.k_renamed = null;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i_renamed) {
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.e_renamed> it = this.e_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(i_renamed);
        }
    }

    private void c_renamed(java.lang.String str, int i_renamed) {
        if (str.equals(this.ap_renamed)) {
            return;
        }
        a_renamed("pref_time_lapse_pro_speed_key", i_renamed);
        this.ap_renamed = str;
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.e_renamed> it = this.e_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(str);
        }
        c_renamed(str);
    }

    private void c_renamed(java.lang.String str) {
        com.oplus.camera.timelapsepro.g_renamed.e_renamed eVar;
        java.util.List<com.oplus.camera.timelapsepro.a_renamed.a_renamed> list;
        if (this.C_renamed != 0 && this.j_renamed != null && (list = this.O_renamed) != null && !list.isEmpty()) {
            com.oplus.camera.timelapsepro.a_renamed.a_renamed aVar = this.O_renamed.get(this.C_renamed);
            aVar.a_renamed(str);
            this.j_renamed.a_renamed(aVar.a_renamed());
        } else {
            if (this.C_renamed != 0 || (eVar = this.j_renamed) == null) {
                return;
            }
            eVar.a_renamed(0L);
        }
    }

    private void a_renamed(long j_renamed) {
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.e_renamed> it = this.e_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(j_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.e_renamed> it = this.e_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed(str, str2);
        }
    }

    public void h_renamed() {
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        if (bVar != null) {
            bVar.f_renamed();
        }
    }

    public void i_renamed() {
        this.z_renamed = -1;
        this.w_renamed = true;
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.y_renamed;
        if (timeLapseProParamScaleBar != null) {
            timeLapseProParamScaleBar.c_renamed(false);
            this.y_renamed.b_renamed(0);
        }
        com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.H_renamed;
        if (inverseTextView != null) {
            inverseTextView.setInverseColor(this.w_renamed);
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "resetSpeed, speedIndex: " + i_renamed);
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.y_renamed;
        if (timeLapseProParamScaleBar != null) {
            if (timeLapseProParamScaleBar.getCurrentIndex() < i_renamed || this.H_renamed.a_renamed()) {
                com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar2 = this.y_renamed;
                if (timeLapseProParamScaleBar2 != null) {
                    timeLapseProParamScaleBar2.setCurrentIndex(i_renamed);
                }
                com.oplus.camera.ui.inverse.InverseTextView inverseTextView = this.H_renamed;
                if (inverseTextView == null || inverseTextView.a_renamed()) {
                    return;
                }
                this.H_renamed.setInverseColor(true);
                this.w_renamed = this.H_renamed.a_renamed();
                this.y_renamed.setAutoState(this.w_renamed);
            }
        }
    }

    public void j_renamed() {
        this.C_renamed = 0;
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar = this.B_renamed;
        if (timeLapseProParamScaleBar != null) {
            timeLapseProParamScaleBar.b_renamed(0);
        }
    }

    public void k_renamed() {
        android.os.Handler handler = this.g_renamed;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void setProParameterList(java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> list) {
        this.ae_renamed = list;
    }

    public void setCurrentScreenMode(com.oplus.camera.screen.b_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        M_renamed();
        this.af_renamed = aVar;
        b_renamed(aVar.j_renamed(), aVar.k_renamed());
        H_renamed();
    }

    private void H_renamed() throws android.content.res.Resources.NotFoundException {
        int iJ = this.af_renamed.j_renamed();
        int iK = this.af_renamed.k_renamed();
        this.t_renamed.a_renamed(this.af_renamed, iJ, iK);
        this.ai_renamed.setOrientation(1 == iJ ? 1 : 0);
        a_renamed(iJ, iK);
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        if (bVar != null) {
            bVar.a_renamed(this.af_renamed, iJ, iK);
        }
        com.oplus.camera.timelapsepro.g_renamed.b_renamed bVar2 = this.aj_renamed;
        if (bVar2 != null) {
            bVar2.a_renamed(1 != iJ ? 2 : 1);
        }
        android.widget.RelativeLayout relativeLayout = this.x_renamed;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.y_renamed = null;
            this.H_renamed = null;
            removeView(this.x_renamed);
            this.x_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout2 = this.A_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
            this.B_renamed = null;
            removeView(this.A_renamed);
            this.A_renamed = null;
        }
    }

    private void a_renamed(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelOffset;
        com.oplus.camera.screen.d_renamed.a_renamed(this.r_renamed);
        if (i_renamed == 1) {
            this.ab_renamed.addRule(2, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout_bottom_view);
            this.ab_renamed.addRule(270 == i2 ? 11 : 9);
            this.ab_renamed.width = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.setting_item_w_full_max);
            if (270 == this.af_renamed.k_renamed() || 90 == this.af_renamed.k_renamed()) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_rotate_margin_bottom);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_margin_bottom);
            }
            this.ab_renamed.bottomMargin = dimensionPixelOffset;
        } else if (i_renamed == 2 || i_renamed == 3 || i_renamed == 4) {
            this.ab_renamed.addRule(12);
            this.ab_renamed.addRule(14);
            this.ab_renamed.width = -1;
        }
        A_renamed();
        C_renamed();
        E_renamed();
        y_renamed();
        this.r_renamed.requestLayout();
    }

    private void b_renamed(int i_renamed, int i2) {
        this.p_renamed.a_renamed(this.af_renamed, i_renamed, i2);
        this.ag_renamed.setOrientation(1 == i_renamed ? 1 : 0);
        c_renamed(i_renamed, i2);
        com.oplus.camera.timelapsepro.g_renamed.b_renamed bVar = this.ah_renamed;
        if (bVar != null) {
            if (3 == i_renamed) {
                bVar.b_renamed(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_interval_split) / 2);
            } else {
                bVar.b_renamed(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_interval) / 2);
            }
            if (1 == i_renamed) {
                this.n_renamed.removeItemDecoration(this.ah_renamed);
            } else if (this.n_renamed.getItemDecorationCount() == 0) {
                this.n_renamed.addItemDecoration(this.ah_renamed);
            }
        }
    }

    private void c_renamed(int i_renamed, int i2) {
        com.oplus.camera.screen.d_renamed.a_renamed(this.n_renamed);
        if (i_renamed == 1) {
            this.aa_renamed.addRule(10);
            this.aa_renamed.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_margin_top_full);
            if (270 == i2) {
                this.aa_renamed.addRule(11);
                this.aa_renamed.rightMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_template_margin_start);
            } else {
                this.aa_renamed.leftMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_full_template_margin_start);
                this.aa_renamed.addRule(9);
            }
        } else if (i_renamed == 2 || i_renamed == 3) {
            this.aa_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_margin_bottom);
            this.aa_renamed.addRule(14);
        } else if (i_renamed == 4) {
            this.aa_renamed.bottomMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_template_rack_margin_bottom);
            this.aa_renamed.addRule(14);
        }
        this.n_renamed.requestLayout();
    }

    public void l_renamed() {
        this.ak_renamed = this.T_renamed != 0;
        a_renamed(com.oplus.camera.R_renamed.string.time_lapse_pro_hint_template_format, this.T_renamed == 0, this.o_renamed.get(this.T_renamed).b_renamed());
    }

    public void m_renamed() {
        if (2 == this.v_renamed) {
            d_renamed(false, true);
        }
    }

    public void setAnimationState(boolean z_renamed) {
        this.as_renamed = z_renamed;
    }

    public boolean n_renamed() {
        return this.as_renamed;
    }

    public void o_renamed() {
        b_renamed(c_renamed());
    }

    public void p_renamed() {
        com.oplus.camera.timelapsepro.b_renamed bVar = this.S_renamed;
        if (bVar != null) {
            bVar.g_renamed();
        }
    }

    public void q_renamed() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.n_renamed;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
            com.oplus.camera.timelapsepro.adapter.b_renamed bVar = this.p_renamed;
            if (bVar != null) {
                this.aw_renamed = null;
                bVar.a_renamed();
                this.p_renamed = null;
            }
        }
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.q_renamed;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(null);
            com.oplus.camera.timelapsepro.adapter.SubSettingAdapter subSettingAdapter = this.t_renamed;
            if (subSettingAdapter != null) {
                this.av_renamed = null;
                subSettingAdapter.a_renamed();
                this.t_renamed = null;
            }
        }
        com.oplus.camera.timelapsepro.b_renamed bVar2 = this.S_renamed;
        if (bVar2 != null) {
            bVar2.c_renamed();
        }
        removeAllViews();
        this.i_renamed = null;
        this.g_renamed.removeCallbacksAndMessages(null);
        this.h_renamed.removeCallbacksAndMessages(null);
        this.h_renamed.getLooper().quitSafely();
        this.e_renamed.clear();
        this.f_renamed.clear();
        this.m_renamed = null;
        this.l_renamed = null;
        this.k_renamed = null;
    }

    public void a_renamed(com.oplus.camera.timelapsepro.g_renamed.d_renamed dVar) {
        if (this.f_renamed.contains(dVar)) {
            return;
        }
        this.f_renamed.add(dVar);
    }

    public void b_renamed(com.oplus.camera.timelapsepro.g_renamed.d_renamed dVar) {
        if (this.f_renamed.contains(dVar)) {
            this.f_renamed.remove(dVar);
        }
    }

    private void I_renamed() {
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.d_renamed> it = this.f_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed();
        }
    }

    private void J_renamed() {
        java.util.Iterator<com.oplus.camera.timelapsepro.g_renamed.d_renamed> it = this.f_renamed.iterator();
        while (it.hasNext()) {
            it.next().b_renamed();
        }
    }

    public void setReportCallback(com.oplus.camera.timelapsepro.g_renamed.f_renamed fVar) {
        this.k_renamed = fVar;
    }

    private void b_renamed(boolean z_renamed) {
        com.oplus.camera.timelapsepro.g_renamed.f_renamed fVar = this.k_renamed;
        if (fVar != null) {
            fVar.a_renamed(z_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed(int i_renamed) {
        com.oplus.camera.timelapsepro.g_renamed.f_renamed fVar = this.k_renamed;
        if (fVar != null) {
            fVar.a_renamed(i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K_renamed() {
        if (this.h_renamed.hasMessages(10)) {
            return;
        }
        this.h_renamed.sendEmptyMessageDelayed(10, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(java.lang.String str) {
        b_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_INTERVAL, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L_renamed() {
        if (this.h_renamed.hasMessages(11)) {
            return;
        }
        this.h_renamed.sendEmptyMessageDelayed(11, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed(int i_renamed) {
        b_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_TIMELAPSEPRO_TIMER, i_renamed == 0 ? "auto" : java.lang.String.valueOf(i_renamed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.timelapsepro.g_renamed.f_renamed fVar = this.k_renamed;
        if (fVar != null) {
            fVar.a_renamed(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed(java.lang.String str) {
        com.oplus.camera.timelapsepro.g_renamed.f_renamed fVar = this.k_renamed;
        if (fVar != null) {
            fVar.a_renamed(str);
        }
    }

    private void M_renamed() {
        com.oplus.camera.timelapsepro.g_renamed.c_renamed cVar = this.l_renamed;
        if (cVar != null) {
            cVar.onChanged();
        }
    }

    public void setChangeScreenModeListener(com.oplus.camera.timelapsepro.g_renamed.c_renamed cVar) {
        this.l_renamed = cVar;
    }

    public void setHintCallback(com.oplus.camera.timelapsepro.g_renamed.a_renamed aVar) {
        this.m_renamed = aVar;
    }

    /* compiled from: TimeLapseProMenuLayout.java */
    private static class b_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f5709a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5710b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f5711c;

        public b_renamed(int i_renamed) {
            this.f5709a = 2;
            this.f5710b = 0;
            this.f5711c = 0;
            this.f5711c = i_renamed;
        }

        public b_renamed(int i_renamed, int i2) {
            this.f5709a = 2;
            this.f5710b = 0;
            this.f5711c = 0;
            this.f5710b = i_renamed;
            this.f5711c = i2;
        }

        public void a_renamed(int i_renamed) {
            this.f5709a = i_renamed;
        }

        public void b_renamed(int i_renamed) {
            this.f5711c = i_renamed;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            int i_renamed;
            int i2 = this.f5711c;
            int i3 = this.f5710b;
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                i_renamed = i3;
                i3 = 0;
            } else {
                i_renamed = (recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() - 1 != recyclerView.getChildAdapterPosition(view)) ? i3 : 0;
            }
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMenuLayout", "getItemOffsets, width: " + recyclerView.getChildViewHolder(view).itemView.getWidth() + ", index: " + recyclerView.getChildAdapterPosition(view));
            if (this.f5709a == 1) {
                rect.set(0, i3, 0, i_renamed);
            } else {
                rect.set(i2, 0, i2, 0);
            }
        }
    }
}
