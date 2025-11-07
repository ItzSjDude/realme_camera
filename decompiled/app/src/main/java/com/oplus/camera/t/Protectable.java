package com.oplus.camera.t_renamed;

/* compiled from: StreetFixFocusHelper.java */
/* loaded from: classes2.dex */
public class c_renamed implements com.oplus.camera.t_renamed.b_renamed.c_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.String f5592b = "StreetFixFocusHelper";
    private android.widget.RelativeLayout A_renamed;
    private android.widget.RelativeLayout C_renamed;
    private boolean d_renamed;
    private boolean g_renamed;
    private android.content.SharedPreferences m_renamed;
    private com.oplus.camera.e_renamed.d_renamed n_renamed;
    private android.app.Activity r_renamed;
    private com.oplus.camera.capmode.a_renamed t_renamed;
    private com.oplus.camera.t_renamed.c_renamed.a_renamed u_renamed;
    private com.oplus.camera.ui.CameraUIInterface v_renamed;
    private java.util.ArrayList<java.lang.String> x_renamed;
    private java.util.ArrayList<java.lang.String> y_renamed;
    private com.oplus.camera.e_renamed.h_renamed z_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5594c = false;
    private boolean e_renamed = true;
    private boolean f_renamed = false;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private boolean j_renamed = false;
    private boolean k_renamed = false;
    private int l_renamed = 50;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.menu.levelcontrol.e_renamed f5593a = null;
    private com.oplus.camera.t_renamed.d_renamed o_renamed = null;
    private com.oplus.camera.t_renamed.c_renamed.b_renamed p_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.menu.OplusTextView> q_renamed = new java.util.ArrayList<>();
    private com.oplus.camera.t_renamed.b_renamed s_renamed = null;
    private android.widget.TextView B_renamed = null;
    private boolean D_renamed = true;
    private android.os.Handler w_renamed = new android.os.Handler(android.os.Looper.getMainLooper());

    /* compiled from: StreetFixFocusHelper.java */
    public interface b_renamed {
        void a_renamed();

        void a_renamed(boolean z_renamed);

        void b_renamed();

        void c_renamed();

        void d_renamed();
    }

    @Override // com.oplus.camera.t_renamed.b_renamed.c_renamed
    public void b_renamed() {
    }

    public c_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.capmode.a_renamed aVar, boolean z_renamed, com.oplus.camera.e_renamed.d_renamed dVar) throws android.content.res.Resources.NotFoundException {
        this.d_renamed = false;
        this.g_renamed = true;
        this.m_renamed = null;
        this.n_renamed = null;
        this.r_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.r_renamed = activity;
        this.v_renamed = cameraUIInterface;
        this.t_renamed = aVar;
        this.d_renamed = false;
        this.u_renamed = new com.oplus.camera.t_renamed.c_renamed.a_renamed(activity);
        this.n_renamed = dVar;
        this.m_renamed = this.t_renamed.t_renamed();
        this.z_renamed = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, this.t_renamed.aw_renamed());
        a_renamed(this.z_renamed.n_renamed(), this.z_renamed.m_renamed());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.r_renamed.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_fixfocus_menu_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        z_renamed();
        layoutParams.bottomMargin = this.v_renamed.r_renamed() - this.r_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_bar_height);
        this.u_renamed.setLayoutParams(layoutParams);
        this.u_renamed.setTouchState(true);
        this.g_renamed = z_renamed;
        this.C_renamed = (android.widget.RelativeLayout) this.r_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
    }

    private void d_renamed(int i_renamed) {
        com.oplus.camera.ae_renamed aeVarAd;
        if (this.e_renamed && (aeVarAd = this.t_renamed.ad_renamed()) != null) {
            if (i_renamed % 10 == 0) {
                aeVarAd.f_renamed();
            } else {
                aeVarAd.d_renamed();
            }
        }
    }

    public void a_renamed(float f_renamed) {
        int iA;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            int iA2 = a_renamed(f_renamed, this.x_renamed);
            android.content.SharedPreferences.Editor editorEdit = this.m_renamed.edit();
            editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, iA2);
            editorEdit.apply();
            return;
        }
        if (f_renamed() || this.s_renamed == null || (iA = a_renamed(f_renamed, this.x_renamed)) <= -1 || this.y_renamed == null || this.x_renamed.size() <= iA) {
            return;
        }
        java.lang.String str = this.y_renamed.get(iA);
        a_renamed(iA, str, this.r_renamed);
        b_renamed(str);
    }

    private void b_renamed(final java.lang.String str) {
        android.app.Activity activity = this.r_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.t_renamed.c_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    java.lang.String str2 = str;
                    if (str2 != null) {
                        com.oplus.camera.t_renamed.c_renamed.this.a_renamed(str2);
                    }
                }
            });
        }
    }

    private int a_renamed(float f_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = java.lang.Math.abs(java.lang.Float.parseFloat(arrayList.get(0)) - f_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float f2 = java.lang.Float.parseFloat(arrayList.get(i2)) - f_renamed;
            if (java.lang.Math.abs(f2) < fAbs) {
                fAbs = java.lang.Math.abs(f2);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    public void c_renamed() {
        v_renamed();
    }

    public boolean d_renamed() {
        return "on_renamed".equals(this.m_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off"));
    }

    public void b_renamed(boolean z_renamed) {
        a_renamed(d_renamed(), z_renamed);
    }

    private void v_renamed() {
        android.content.res.Resources resources = this.r_renamed.getApplicationContext().getResources();
        this.A_renamed = new android.widget.RelativeLayout(this.r_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_fixfocus_menu_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.u_renamed.addView(this.A_renamed, layoutParams);
        this.o_renamed = new com.oplus.camera.t_renamed.d_renamed(this.r_renamed.getApplicationContext());
        this.o_renamed.setVerticalDraw(true);
        this.o_renamed.setIncludeFontPadding(false);
        this.o_renamed.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_main_mode_bar_item_text_size));
        this.o_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.r_renamed.getApplicationContext()));
        this.o_renamed.setGravity(17);
        this.o_renamed.setTextColor(resources.getColor(com.oplus.camera.R_renamed.color.main_item_title_text_color));
        this.o_renamed.setId(android.view.View.generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_text_top_margin);
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_text_bottom_margin);
        this.o_renamed.setLayoutParams(layoutParams2);
        this.A_renamed.addView(this.o_renamed);
        this.s_renamed = new com.oplus.camera.t_renamed.b_renamed(this.r_renamed, this.l_renamed, this.w_renamed);
        this.s_renamed.setForceBigScaleAlphaPosition(45);
        this.s_renamed.setScaleBarValueChangeListener(this);
        this.s_renamed.setId(android.view.View.generateViewId());
        this.s_renamed.setLevelNum(this.y_renamed.size());
        this.s_renamed.setAuto(this.g_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth() / (this.d_renamed ? 2 : 1), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_main_seekbar_height));
        layoutParams3.addRule(3, this.o_renamed.getId());
        this.s_renamed.setScaleBarValueChangeListener(this);
        this.A_renamed.addView(this.s_renamed, layoutParams3);
        this.v_renamed.a_renamed((android.view.View) this.u_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, 2, true);
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "deinitFixFocus");
        com.oplus.camera.t_renamed.c_renamed.a_renamed aVar = this.u_renamed;
        if (aVar != null) {
            aVar.setVisibility(4);
            this.u_renamed.removeAllViewsInLayout();
            this.u_renamed = null;
            this.f_renamed = false;
            this.B_renamed = null;
            com.oplus.camera.ui.menu.levelcontrol.e_renamed eVar = this.f5593a;
            if (eVar != null) {
                eVar.setVisibility(4);
            }
        }
    }

    @Override // com.oplus.camera.t_renamed.b_renamed.c_renamed
    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "onValueChange value: " + i_renamed);
        d_renamed(i_renamed);
        this.o_renamed.setText(f_renamed(i_renamed));
        java.lang.String strE = e_renamed(i_renamed);
        if (this.p_renamed == null || strE == null || !f_renamed()) {
            return;
        }
        b_renamed(i_renamed);
        this.t_renamed.ac_renamed();
        com.oplus.camera.e_renamed.d_renamed dVar = this.n_renamed;
        if (dVar != null) {
            this.k_renamed = true;
            dVar.a_renamed(java.lang.Float.valueOf(strE).floatValue(), true);
        }
    }

    public boolean f_renamed() {
        return this.m_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, false);
    }

    public void g_renamed() {
        com.oplus.camera.t_renamed.c_renamed.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            bVar.d_renamed();
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            c_renamed(true);
        }
        if (!this.h_renamed) {
            l_renamed();
            h_renamed();
            this.h_renamed = true;
        }
        if (d_renamed()) {
            return;
        }
        this.t_renamed.t_renamed().edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "on_renamed").apply();
        this.v_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
    }

    public void h_renamed() {
        w_renamed();
        g_renamed(f_renamed());
    }

    private void g_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.e_renamed eVar = this.f5593a;
        if (eVar != null) {
            if (z_renamed) {
                eVar.a_renamed(false, null, this.r_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.pro_btn_mode_change_a));
                this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_my);
                return;
            }
            eVar.a_renamed(true, null, com.oplus.camera.util.Util.b_renamed(this.r_renamed, com.oplus.camera.R_renamed.drawable.pro_btn_mode_change_light_a));
            if (d_renamed()) {
                this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_ay);
            } else {
                this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_aw);
            }
        }
    }

    private void w_renamed() {
        this.s_renamed.setAuto(!f_renamed());
        this.s_renamed.a_renamed(k_renamed());
        this.s_renamed.b_renamed();
    }

    public void i_renamed() {
        if (this.h_renamed) {
            m_renamed();
            this.h_renamed = false;
        }
        if (!f_renamed()) {
            this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_aw);
        }
        if (d_renamed()) {
            this.t_renamed.t_renamed().edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off").apply();
            this.v_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
        }
        com.oplus.camera.t_renamed.c_renamed.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            bVar.c_renamed();
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            c_renamed(false);
            C_renamed();
        }
    }

    public void j_renamed() {
        if (this.h_renamed) {
            m_renamed();
            this.h_renamed = false;
        }
    }

    public void c_renamed(boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.t_renamed.t_renamed().edit();
        editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, z_renamed);
        editorEdit.apply();
        g_renamed(z_renamed);
        com.oplus.camera.t_renamed.b_renamed bVar = this.s_renamed;
        if (bVar != null) {
            bVar.setAuto(!z_renamed);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "showOrHide isShow:" + z_renamed);
        this.i_renamed = z_renamed;
        if (this.D_renamed) {
            d_renamed(z2);
        }
        if (z_renamed) {
            g_renamed();
            y_renamed();
            x_renamed();
            return;
        }
        i_renamed();
    }

    private void x_renamed() {
        if (this.t_renamed.J_renamed()) {
            this.t_renamed.H_renamed();
        }
    }

    public void d_renamed(boolean z_renamed) {
        boolean zA = this.v_renamed.A_renamed();
        if (z_renamed) {
            if (!zA && !this.i_renamed && !this.j_renamed) {
                this.v_renamed.a_renamed(true);
                this.v_renamed.a_renamed(0, false);
                return;
            } else {
                this.v_renamed.a_renamed(4, false);
                return;
            }
        }
        if (!zA && !this.i_renamed && !this.j_renamed) {
            this.v_renamed.a_renamed(0, 0);
        } else {
            this.v_renamed.a_renamed(8, 0);
        }
    }

    private void y_renamed() {
        if (this.v_renamed.A_renamed()) {
            this.v_renamed.a_renamed(true, true, true, true);
        }
    }

    private java.lang.String e_renamed(int i_renamed) {
        java.util.ArrayList<java.lang.String> arrayList;
        com.oplus.camera.e_renamed.a_renamed(f5592b, "getFocusValue:" + i_renamed);
        if (i_renamed <= -1 || (arrayList = this.x_renamed) == null || arrayList.size() <= i_renamed) {
            return null;
        }
        return this.x_renamed.get(i_renamed);
    }

    private java.lang.String f_renamed(int i_renamed) {
        return this.y_renamed.get(i_renamed);
    }

    public void a_renamed(com.oplus.camera.t_renamed.c_renamed.b_renamed bVar) {
        this.p_renamed = bVar;
    }

    @Override // com.oplus.camera.t_renamed.b_renamed.c_renamed
    public void a_renamed() {
        c_renamed(true);
        this.f5593a.setEnabled(false);
        this.v_renamed.d_renamed(false, false);
        this.p_renamed.a_renamed();
    }

    @Override // com.oplus.camera.t_renamed.b_renamed.c_renamed
    public void a_renamed(boolean z_renamed) {
        this.f5593a.setEnabled(!z_renamed);
        this.v_renamed.d_renamed(!z_renamed, false);
        this.p_renamed.a_renamed(z_renamed);
    }

    public void b_renamed(int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.m_renamed.edit();
        editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, i_renamed);
        editorEdit.apply();
    }

    public int k_renamed() {
        return this.m_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, 10);
    }

    public void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "showLevelPanel");
        if (!this.f_renamed) {
            c_renamed();
        }
        if (this.t_renamed != null) {
            this.v_renamed.f_renamed(20, true);
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            this.f5593a.setVisibility(0);
        }
        this.u_renamed.setVisibility(0);
        this.f_renamed = true;
    }

    public void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "hideLevelPanel");
        this.u_renamed.setVisibility(8);
        this.f5593a.setVisibility(4);
        this.f5593a.setEnabled(true);
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.C_renamed.getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        i_renamed();
        if (!f_renamed()) {
            return false;
        }
        B_renamed();
        return false;
    }

    public void n_renamed() {
        i_renamed();
    }

    public void e_renamed(boolean z_renamed) {
        d_renamed(z_renamed);
    }

    public boolean o_renamed() {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "isShowFixFocusMenu, mbShowFixFocusMenu:" + this.i_renamed);
        return this.i_renamed;
    }

    public boolean p_renamed() {
        return this.k_renamed;
    }

    public void q_renamed() {
        com.oplus.camera.e_renamed.d_renamed dVar;
        if (f_renamed()) {
            java.lang.String strE = e_renamed(k_renamed());
            if (this.p_renamed == null || strE == null || (dVar = this.n_renamed) == null) {
                return;
            }
            this.k_renamed = true;
            dVar.a_renamed(java.lang.Float.valueOf(strE).floatValue(), true);
            this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_my);
        }
    }

    public void r_renamed() {
        this.j_renamed = true;
        i_renamed();
    }

    public void s_renamed() {
        this.j_renamed = false;
    }

    public void t_renamed() {
        this.i_renamed = false;
        this.j_renamed = false;
    }

    /* compiled from: StreetFixFocusHelper.java */
    protected class a_renamed extends android.widget.RelativeLayout {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f5606b;

        @Override // android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            return true;
        }

        public a_renamed(android.app.Activity activity) {
            super(activity.getApplicationContext());
            this.f5606b = true;
        }

        public void setTouchState(boolean z_renamed) {
            this.f5606b = z_renamed;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (this.f5606b && !com.oplus.camera.t_renamed.c_renamed.this.f5594c) {
                if (com.oplus.camera.t_renamed.c_renamed.this.t_renamed.C_renamed()) {
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return false;
                }
                if (1 == motionEvent.getAction()) {
                    com.oplus.camera.t_renamed.c_renamed.this.f5593a.setEnabled(true);
                    com.oplus.camera.t_renamed.c_renamed.this.v_renamed.d_renamed(true, false);
                    if (com.oplus.camera.t_renamed.c_renamed.this.p_renamed != null) {
                        com.oplus.camera.t_renamed.c_renamed.this.p_renamed.b_renamed();
                    }
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!this.f5606b) {
                android.view.MotionEvent motionEventObtain2 = android.view.MotionEvent.obtain(motionEvent);
                motionEventObtain2.setAction(3);
                super.dispatchTouchEvent(motionEventObtain2);
            }
            return false;
        }
    }

    public void a_renamed(final int i_renamed, final java.lang.String str, android.app.Activity activity) {
        com.oplus.camera.t_renamed.b_renamed bVar = this.s_renamed;
        if (bVar == null) {
            return;
        }
        if (bVar.getCurrentIndex() != i_renamed || i_renamed == 0) {
            this.s_renamed.setCurrentIndex(i_renamed);
            if (activity != null) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.t_renamed.c_renamed.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.t_renamed.c_renamed.this.s_renamed.a_renamed(i_renamed);
                        if (str != null) {
                            com.oplus.camera.t_renamed.c_renamed.this.o_renamed.setText((java.lang.CharSequence) com.oplus.camera.t_renamed.c_renamed.this.y_renamed.get(i_renamed));
                        } else {
                            com.oplus.camera.t_renamed.c_renamed.this.o_renamed.setText(str);
                        }
                        if (com.oplus.camera.t_renamed.c_renamed.this.p_renamed != null) {
                            com.oplus.camera.t_renamed.c_renamed cVar = com.oplus.camera.t_renamed.c_renamed.this;
                            cVar.a_renamed((java.lang.String) cVar.y_renamed.get(i_renamed));
                        }
                    }
                });
            }
        }
    }

    private void z_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.f5593a == null) {
            android.content.res.Resources resources = this.r_renamed.getApplicationContext().getResources();
            this.f5593a = new com.oplus.camera.ui.menu.levelcontrol.e_renamed(this.r_renamed);
            this.f5593a.setEnabled(true);
            this.f5593a.setFocusable(false);
            this.f5593a.setClickable(true);
            this.f5593a.setNormalShape(true);
            this.f5593a.setVisibility(4);
            this.f5593a.setContentDescription(resources.getString(com.oplus.camera.R_renamed.string.camera_description_professional_auto));
            android.graphics.drawable.Drawable drawable = resources.getDrawable(com.oplus.camera.R_renamed.drawable.pro_btn_mode_change_light_a);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_button_margin_edge));
            this.f5593a.setLayoutParams(layoutParams);
            ((android.widget.RelativeLayout) this.r_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout)).addView(this.f5593a);
            this.f5593a.a_renamed(this.t_renamed.u_renamed(), false);
            A_renamed();
        }
        this.f5593a.a_renamed(this.t_renamed.u_renamed(), false);
    }

    private void A_renamed() {
        com.a_renamed.a_renamed.f_renamed fVarB = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed();
        fVarB.a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(10.0d, 20.0d));
        final com.a_renamed.a_renamed.f_renamed fVarA = fVarB.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.t_renamed.c_renamed.3
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                float fC_renamed = (float) fVar.c_renamed();
                com.oplus.camera.t_renamed.c_renamed.this.f5593a.setScaleX(fC_renamed);
                com.oplus.camera.t_renamed.c_renamed.this.f5593a.setScaleY(fC_renamed);
            }
        });
        final com.a_renamed.a_renamed.f_renamed fVarA2 = fVarB.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.t_renamed.c_renamed.4
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                com.oplus.camera.t_renamed.c_renamed.this.f5593a.setAlpha((float) fVar.c_renamed());
            }
        });
        fVarA.a_renamed(1.0d);
        fVarA2.a_renamed(1.0d);
        this.f5593a.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.t_renamed.c_renamed.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    fVarA.b_renamed(0.8999999761581421d);
                    fVarA2.b_renamed(0.6000000238418579d);
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                fVarA.b_renamed(1.0d);
                fVarA2.b_renamed(1.0d);
                com.oplus.camera.t_renamed.c_renamed.this.B_renamed();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B_renamed() {
        if (!f_renamed()) {
            if (d_renamed()) {
                this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_ay);
            } else {
                this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_aw);
            }
            c_renamed(true);
            this.s_renamed.b_renamed();
            return;
        }
        if (d_renamed()) {
            this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_my);
        } else {
            this.v_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, com.oplus.camera.R_renamed.drawable.menu_fix_focus_aw);
        }
        c_renamed(false);
        C_renamed();
    }

    private void C_renamed() {
        com.oplus.camera.e_renamed.a_renamed(f5592b, "setContinueAFMode");
        if (4 != this.n_renamed.p_renamed()) {
            this.k_renamed = false;
            this.n_renamed.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
            this.n_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    public void a_renamed(java.lang.String str) {
        com.oplus.camera.t_renamed.d_renamed dVar = this.o_renamed;
        if (dVar == null) {
            return;
        }
        dVar.setText(str);
    }

    private void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.e_renamed.b_renamed(f5592b, "generateFocusValues");
        this.x_renamed = new java.util.ArrayList<>();
        this.y_renamed = new java.util.ArrayList<>();
        if (f_renamed < f2) {
            f2 = f_renamed;
            f_renamed = f2;
        }
        if (java.lang.Float.compare(f_renamed, 0.0f) <= 0.0f || java.lang.Float.compare(f_renamed, f2) == 0) {
            com.oplus.camera.e_renamed.e_renamed(f5592b, "generateFocusValues, return, minFocusDistance: " + f_renamed);
            return;
        }
        float f3 = (f_renamed - f2) / this.l_renamed;
        com.oplus.camera.e_renamed.a_renamed(f5592b, "generateFocusValues, farFocusDistance: " + f2 + ", minFocusDistance: " + f_renamed);
        int i_renamed = 0;
        while (i_renamed <= this.l_renamed) {
            float f4 = i_renamed;
            float f5 = f_renamed - (f3 * f4);
            float f6 = (i_renamed < 0 || f4 > 45.0f) ? 1.0f + ((f4 - 45.0f) * 0.8f) : 0.02f * f4;
            this.x_renamed.add(java.lang.Float.toString(f5));
            java.lang.String str = java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f6));
            if (f4 == 45.0f) {
                this.B_renamed = new androidx.appcompat.widget.AppCompatTextView(this.r_renamed.getApplicationContext());
                this.B_renamed.setText("1.00m");
                this.B_renamed.setTypeface(android.graphics.Typeface.defaultFromStyle(1));
                this.y_renamed.add(this.B_renamed.getText().toString());
            } else {
                this.y_renamed.add(str + "m_renamed");
            }
            i_renamed++;
        }
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.e_renamed eVar = this.f5593a;
        if (eVar != null) {
            eVar.a_renamed(i_renamed, true);
        }
    }

    public void f_renamed(boolean z_renamed) {
        this.D_renamed = z_renamed;
    }

    public void u_renamed() {
        a_renamed(true, false);
    }
}
