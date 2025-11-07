package com.oplus.camera.professional;

/* compiled from: ProMenuManager.java */
/* loaded from: classes2.dex */
public class r_renamed implements com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener {

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.app.Activity f5208c;
    protected com.oplus.camera.ui.CameraUIInterface d_renamed;
    protected com.oplus.camera.capmode.a_renamed e_renamed;
    protected java.lang.String k_renamed;
    private android.content.res.Resources r_renamed;
    private android.content.SharedPreferences s_renamed;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = false;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f5206a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f5207b = -1;
    protected android.os.Handler f_renamed = null;
    protected com.oplus.camera.professional.p_renamed g_renamed = null;
    protected com.oplus.camera.professional.r_renamed.b_renamed h_renamed = null;
    protected com.oplus.camera.professional.ListProfessionalModeBar i_renamed = null;
    protected com.oplus.camera.professional.r_renamed.a_renamed j_renamed = null;
    private com.oplus.camera.professional.p_renamed.b_renamed t_renamed = new com.oplus.camera.professional.p_renamed.b_renamed() { // from class: com.oplus.camera.professional.r_renamed.3
        @Override // com.oplus.camera.professional.p_renamed.b_renamed
        public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        }
    };

    /* compiled from: ProMenuManager.java */
    public interface b_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(int i_renamed);

        void a_renamed(long j_renamed);

        void a_renamed(boolean z_renamed);

        boolean a_renamed();

        boolean a_renamed(java.lang.String str);

        void b_renamed(int i_renamed);

        void b_renamed(java.lang.String str);

        void b_renamed(boolean z_renamed);

        boolean b_renamed();

        int c_renamed();

        void c_renamed(int i_renamed);

        int d_renamed();

        void d_renamed(int i_renamed);

        void e_renamed();

        void e_renamed(int i_renamed);

        void f_renamed();

        void g_renamed();

        com.oplus.camera.ui.control.b_renamed h_renamed();

        boolean i_renamed();
    }

    public void a_renamed(int i_renamed) {
    }

    public void b_renamed() {
    }

    public r_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, java.lang.String str) {
        this.f5208c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.k_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.f5208c = activity;
        this.d_renamed = cameraUIInterface;
        this.e_renamed = aVar;
        this.r_renamed = this.f5208c.getResources();
        this.s_renamed = this.e_renamed.t_renamed();
        this.k_renamed = str;
        f_renamed();
    }

    public void f_renamed() {
        this.f_renamed = new android.os.Handler();
        com.oplus.camera.professional.LevelPanel.setAutoValueMap(a_renamed());
    }

    public java.util.HashMap<java.lang.String, java.lang.String> a_renamed() {
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
        map.put("pref_professional_iso_key", "100");
        map.put("pref_professional_exposure_time_key", "1/50s");
        map.put("pref_professional_whitebalance_key", "2000");
        map.put("pref_professional_exposure_compensation_key", "0.00");
        map.put("pref_professional_focus_mode_key", "0.00");
        return map;
    }

    public void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        if (this.g_renamed == null) {
            return;
        }
        java.lang.Integer num = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY);
        java.lang.Long l_renamed = (java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME);
        java.lang.Float f_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE);
        if (com.oplus.camera.util.Util.C_renamed()) {
            key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
        } else {
            key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
        }
        int i_renamed = 0;
        if (key != null) {
            try {
                i_renamed = ((int[]) captureResult.get(key))[0];
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        if (num != null && this.g_renamed.g_renamed(1) && (iA4 = a_renamed(num.intValue(), this.g_renamed.c_renamed(1))) > -1 && (!this.g_renamed.c_renamed(1, iA4) || !this.n_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("ProMenuManager", "onPreviewCaptureResult, iso: " + num);
            com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_iso_key", this.g_renamed.d_renamed(1).get(iA4));
            this.g_renamed.scrollTo(1, iA4);
        }
        if (l_renamed != null && this.g_renamed.g_renamed(2) && (iA3 = a_renamed(l_renamed.longValue(), this.g_renamed.c_renamed(2))) > -1 && (!this.g_renamed.c_renamed(2, iA3) || !this.n_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("ProMenuManager", "onPreviewCaptureResult, exposureTime: " + l_renamed);
            com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_exposure_time_key", this.g_renamed.d_renamed(2).get(iA3));
            this.g_renamed.scrollTo(2, iA3);
        }
        if (this.g_renamed.g_renamed(5) && (iA2 = a_renamed(i_renamed, this.g_renamed.c_renamed(5))) > -1 && (!this.g_renamed.c_renamed(5, iA2) || !this.n_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("ProMenuManager", "onPreviewCaptureResult, cct: " + i_renamed);
            com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_whitebalance_key", this.g_renamed.d_renamed(5).get(iA2));
            this.g_renamed.scrollTo(5, iA2);
        }
        if (f_renamed != null && this.g_renamed.g_renamed(4) && (iA = a_renamed(f_renamed.floatValue(), this.g_renamed.c_renamed(4))) > -1 && (!this.g_renamed.c_renamed(4, iA) || !this.n_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("ProMenuManager", "onPreviewCaptureResult, focusDistance: " + f_renamed);
            com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_focus_mode_key", this.g_renamed.d_renamed(4).get(iA));
            this.g_renamed.scrollTo(4, iA);
        }
        this.n_renamed = true;
    }

    private int a_renamed(float f_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = java.lang.Math.abs(java.lang.Float.valueOf(arrayList.get(0)).floatValue() - f_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float fFloatValue = java.lang.Float.valueOf(arrayList.get(i2)).floatValue() - f_renamed;
            if (java.lang.Math.abs(fFloatValue) < fAbs) {
                fAbs = java.lang.Math.abs(fFloatValue);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    private int a_renamed(long j_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = java.lang.Math.abs(java.lang.Long.valueOf(arrayList.get(0)).longValue() - j_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long jLongValue = java.lang.Long.valueOf(arrayList.get(i2)).longValue() - j_renamed;
            if (java.lang.Math.abs(jLongValue) < jAbs) {
                jAbs = java.lang.Math.abs(jLongValue);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    public void g_renamed() throws android.content.res.Resources.NotFoundException {
        n_renamed();
        a_renamed(8, false);
        l_renamed();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setVisibility, visibility: " + i_renamed);
        if (this.j_renamed == null) {
            j_renamed();
        }
        if (i_renamed == 0) {
            com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(i_renamed);
                return;
            }
            return;
        }
        if (i_renamed() && !z_renamed) {
            if (!this.d_renamed.d_renamed() && !this.h_renamed.i_renamed()) {
                this.d_renamed.a_renamed(0, 1);
            }
            if (this.h_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
                this.i_renamed.a_renamed();
                this.d_renamed.d_renamed(0);
                this.d_renamed.b_renamed(true, false);
            }
        }
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar2 = this.i_renamed;
        if (listProfessionalModeBar2 != null) {
            listProfessionalModeBar2.a_renamed();
            this.i_renamed.setItemPressed(false);
            this.i_renamed.setVisibility(i_renamed);
        }
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null) {
            pVar.e_renamed();
        }
    }

    public boolean h_renamed() {
        com.oplus.camera.professional.r_renamed.a_renamed aVar;
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
        return listProfessionalModeBar != null && listProfessionalModeBar.getVisibility() == 0 && (aVar = this.j_renamed) != null && aVar.getVisibility() == 0;
    }

    public boolean i_renamed() {
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        return pVar != null && pVar.c_renamed();
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.professional.r_renamed.a_renamed aVar = this.j_renamed;
        if (aVar == null) {
            return;
        }
        aVar.setTouchState(z_renamed);
    }

    public void j_renamed() throws android.content.res.Resources.NotFoundException {
        this.f5207b = this.e_renamed.as_renamed();
        this.n_renamed = false;
        E_renamed();
        d_renamed();
        F_renamed();
        z_renamed();
        this.g_renamed.setSettleListener(this.i_renamed);
        this.g_renamed.setMotionListener(this.t_renamed);
        k_renamed();
    }

    private com.oplus.camera.professional.p_renamed.a_renamed y_renamed() {
        com.oplus.camera.professional.p_renamed.a_renamed configData = this.g_renamed.getConfigData();
        configData.f5204b = 15625000L;
        return configData;
    }

    private void z_renamed() throws android.content.res.Resources.NotFoundException {
        this.i_renamed = new com.oplus.camera.professional.ListProfessionalModeBar(this.f5208c, q_renamed());
        this.i_renamed.setPanelInterface(this.g_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_height));
        layoutParams.setMargins(0, 0, 0, this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        com.oplus.camera.professional.ListModeBarAdapter listModeBarAdapter = new com.oplus.camera.professional.ListModeBarAdapter(this.f5208c, this.g_renamed.a_renamed(false));
        listModeBarAdapter.a_renamed((com.oplus.camera.professional.q_renamed) this.g_renamed);
        a_renamed(this.i_renamed, com.oplus.camera.R_renamed.id_renamed.main_bar_id, listModeBarAdapter, this);
        this.j_renamed.addView(this.i_renamed, layoutParams);
    }

    public void k_renamed() {
        if (this.i_renamed.isSelected()) {
            int selectedPosition = this.i_renamed.getSelectedPosition();
            this.i_renamed.a_renamed(selectedPosition, true);
            android.view.View childAt = this.i_renamed.getChildAt(selectedPosition);
            int iA = this.i_renamed.a_renamed(childAt);
            if (childAt != null && this.g_renamed.g_renamed(iA)) {
                this.i_renamed.getAdapter().a_renamed(childAt, 0, true);
            }
        }
        this.g_renamed.a_renamed();
    }

    public void l_renamed() throws android.content.res.Resources.NotFoundException {
        a_renamed(8, false);
        o_renamed();
        D_renamed();
    }

    public void a_renamed(com.oplus.camera.professional.r_renamed.b_renamed bVar) {
        this.h_renamed = bVar;
    }

    public void e_renamed() {
        this.p_renamed = false;
        com.oplus.camera.professional.r_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.setVisibility(0);
        }
        this.e_renamed.d_renamed(true);
        k_renamed();
    }

    public void m_renamed() {
        this.p_renamed = true;
        com.oplus.camera.professional.r_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.setTouchState(false);
        }
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null) {
            pVar.h_renamed();
        }
        this.d_renamed.d_renamed(true, false);
        com.oplus.camera.professional.p_renamed pVar2 = this.g_renamed;
        if (pVar2 != null) {
            pVar2.setAuto(4);
        }
        C_renamed();
    }

    public void n_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.professional.r_renamed.b_renamed bVar = this.h_renamed;
        if (bVar == null) {
            return;
        }
        bVar.d_renamed(0);
        a_renamed(this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        b_renamed(this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value));
        this.h_renamed.a_renamed(java.lang.Long.valueOf(this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue());
        B_renamed();
        this.h_renamed.e_renamed();
        this.h_renamed.f_renamed();
        G_renamed();
        A_renamed();
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null) {
            pVar.b_renamed();
        }
    }

    private void A_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.i_renamed == null || (pVar = this.g_renamed) == null) {
            return;
        }
        pVar.setPreference(5);
    }

    private void B_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.i_renamed == null || (pVar = this.g_renamed) == null) {
            return;
        }
        pVar.setPreference(1);
        this.g_renamed.setPreference(2);
    }

    private void C_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "restoreFocusMode");
        com.oplus.camera.professional.r_renamed.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.b_renamed(bVar.c_renamed());
            this.h_renamed.e_renamed(com.oplus.camera.a_renamed.c_renamed());
            this.h_renamed.f_renamed();
        }
    }

    public void a_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        java.lang.String string = this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        if (str == null) {
            str = this.s_renamed.getString("pref_professional_iso_key", string);
        }
        if (!this.s_renamed.getString("pref_professional_iso_key", string).equals(str)) {
            android.content.SharedPreferences.Editor editorEdit = this.s_renamed.edit();
            editorEdit.putString("pref_professional_iso_key", string);
            editorEdit.apply();
        }
        if (string.equals(str)) {
            this.h_renamed.c_renamed(-1);
        } else {
            H_renamed();
            this.h_renamed.b_renamed("off");
            this.h_renamed.c_renamed(java.lang.Integer.valueOf(str).intValue());
        }
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setISOValue, iso: " + str);
    }

    private void D_renamed() {
        com.oplus.camera.professional.r_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.setTouchState(false);
            com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.j_renamed.removeView(this.i_renamed);
                this.i_renamed = null;
            }
        }
        this.j_renamed = null;
    }

    protected void o_renamed() {
        this.g_renamed.scrollTo(1, 0);
        this.g_renamed.scrollTo(2, 0);
        this.g_renamed.scrollTo(5, 0);
        this.g_renamed.scrollTo(4, 0);
    }

    private void E_renamed() {
        this.j_renamed = new com.oplus.camera.professional.r_renamed.a_renamed(this.f5208c);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.getScreenWidth());
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        if (this.e_renamed != null) {
            layoutParams.bottomMargin = this.d_renamed.r_renamed() - this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.j_renamed.setLayoutParams(layoutParams);
        this.j_renamed.setTouchState(true);
        this.j_renamed.getViewTreeObserver().addOnWindowFocusChangeListener(new android.view.ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.r_renamed.1
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z_renamed) {
                if (com.oplus.camera.professional.r_renamed.this.i_renamed != null) {
                    com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onWindowFocusChanged, SelectedPosition: " + com.oplus.camera.professional.r_renamed.this.i_renamed.getSelectedPosition() + ", hasFocus: " + z_renamed);
                    com.oplus.camera.professional.r_renamed.this.i_renamed.a_renamed(com.oplus.camera.professional.r_renamed.this.i_renamed.getSelectedPosition(), true);
                }
            }
        });
        this.d_renamed.a_renamed((android.view.View) this.j_renamed, this.k_renamed, 2, true);
    }

    public void d_renamed() {
        this.g_renamed = new com.oplus.camera.professional.p_renamed(this.f5208c, this.e_renamed);
        this.g_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(this.k_renamed, this.f5207b), this.f_renamed, y_renamed());
    }

    private void F_renamed() {
        this.g_renamed.setGravity(17);
        this.g_renamed.setId(android.view.View.generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height));
        layoutParams.setMargins(0, 0, 0, this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_height) + this.r_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.j_renamed.addView(this.g_renamed, layoutParams);
    }

    private void a_renamed(com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar, int i_renamed, com.oplus.camera.professional.ListModeBarAdapter listModeBarAdapter, com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener onItemClickListener) throws android.content.res.Resources.NotFoundException {
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setId(i_renamed);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    private void G_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.i_renamed == null || (pVar = this.g_renamed) == null) {
            return;
        }
        pVar.setPreference(4);
    }

    public void b_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        java.lang.String string = this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value);
        if (str == null) {
            str = this.s_renamed.getString("pref_professional_exposure_compensation_key", string);
        }
        if (!this.s_renamed.getString("pref_professional_exposure_compensation_key", string).equals(str)) {
            android.content.SharedPreferences.Editor editorEdit = this.s_renamed.edit();
            editorEdit.putString("pref_professional_exposure_compensation_key", string);
            editorEdit.apply();
        }
        try {
            int iIntValue = java.lang.Integer.valueOf(str).intValue();
            this.h_renamed.e_renamed(iIntValue);
            com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setExposureCompensation, evValue: " + iIntValue);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ProMenuManager", "setExposureCompensation, e_renamed: " + e_renamed);
        }
    }

    public void p_renamed() throws java.lang.NumberFormatException {
        android.app.Activity activity;
        if (this.h_renamed == null || (activity = this.f5208c) == null) {
            return;
        }
        java.lang.String string = this.s_renamed.getString("pref_professional_exposure_time_key", activity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        long jLongValue = java.lang.Long.valueOf(this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue();
        long j_renamed = java.lang.Long.parseLong(string);
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setExposureTime, exposureTimeValue: " + j_renamed);
        if (j_renamed != jLongValue) {
            H_renamed();
        }
        a_renamed(j_renamed);
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.control.b_renamed bVarH = com.oplus.camera.professional.r_renamed.this.h_renamed.h_renamed();
                if (com.oplus.camera.professional.r_renamed.this.l_renamed || com.oplus.camera.professional.r_renamed.this.e_renamed.A_renamed()) {
                    return;
                }
                com.oplus.camera.professional.r_renamed.this.d_renamed.a_renamed(bVarH);
            }
        });
    }

    protected void a_renamed(long j_renamed) {
        if (j_renamed < 40000000) {
            com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setExposureTime, back exposureTimeValue: " + j_renamed);
            this.h_renamed.a_renamed(false);
            this.h_renamed.a_renamed(j_renamed);
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setExposureTime, slow shutter");
        this.h_renamed.a_renamed(true);
        this.h_renamed.a_renamed(40000000L);
    }

    private void H_renamed() {
        if ("off".equals(this.s_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.f5208c.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.s_renamed.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.d_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
    }

    /* compiled from: ProMenuManager.java */
    protected class a_renamed extends android.widget.RelativeLayout {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f5218b;

        public a_renamed(android.content.Context context) {
            super(context);
            this.f5218b = true;
        }

        public void setTouchState(boolean z_renamed) {
            this.f5218b = z_renamed;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (!this.f5218b || com.oplus.camera.professional.r_renamed.this.e_renamed == null || com.oplus.camera.professional.r_renamed.this.m_renamed) {
                if (!this.f5218b) {
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                }
                return false;
            }
            if (com.oplus.camera.professional.r_renamed.this.e_renamed.C_renamed()) {
                android.view.MotionEvent motionEventObtain2 = android.view.MotionEvent.obtain(motionEvent);
                motionEventObtain2.setAction(3);
                super.dispatchTouchEvent(motionEventObtain2);
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener
    public void a_renamed(android.view.View view, android.view.View view2, long j_renamed) {
        if (this.e_renamed.A_renamed()) {
            return;
        }
        int iA = this.i_renamed.a_renamed(view2);
        if (com.oplus.camera.professional.ListProfessionalModeBar.ModePressState.NO_PRESSED == this.i_renamed.getModePressState() && this.i_renamed.isSelected()) {
            c_renamed();
            return;
        }
        this.h_renamed.b_renamed(false);
        this.e_renamed.H_renamed();
        I_renamed();
        com.oplus.camera.e_renamed.f_renamed("ProMenuManager", "onItemClick, index: " + iA + ", id_renamed: " + j_renamed);
        this.d_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_pro_fixed_tips_oplus_r);
        this.e_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
        this.d_renamed.e_renamed(4);
        this.g_renamed.setVisibility(0);
        this.g_renamed.f_renamed(iA);
        if (this.g_renamed.g_renamed(iA)) {
            this.i_renamed.getAdapter().a_renamed(view2, 0, true);
            this.g_renamed.b_renamed(iA, true);
        } else {
            this.i_renamed.getAdapter().a_renamed(view2, 8, false);
            this.g_renamed.b_renamed(iA, false);
        }
    }

    private void I_renamed() {
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null) {
            pVar.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J_renamed() {
        G_renamed();
        this.g_renamed.setPanelsBarAuto(4);
    }

    public int q_renamed() {
        return this.e_renamed.u_renamed();
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        if ("pref_professional_whitebalance_key".equals(str)) {
            if (5 == this.i_renamed.getSelectedIndex()) {
                this.g_renamed.h_renamed(5);
            }
            r_renamed();
            return;
        }
        if ("pref_professional_iso_key".equals(str)) {
            if (this.i_renamed.getSelectedIndex() == 1) {
                this.g_renamed.h_renamed(1);
            }
            a_renamed((java.lang.String) null);
            return;
        }
        if ("pref_professional_exposure_compensation_key".equals(str)) {
            if (this.h_renamed.b_renamed() && !this.g_renamed.g_renamed(1)) {
                this.g_renamed.setAuto(1);
            }
            if (this.h_renamed.b_renamed() && !this.g_renamed.g_renamed(2)) {
                this.g_renamed.setAuto(2);
            }
            b_renamed((java.lang.String) null);
            this.h_renamed.f_renamed();
            return;
        }
        if ("pref_professional_exposure_time_key".equals(str)) {
            com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
            if (listProfessionalModeBar != null && 2 == listProfessionalModeBar.getSelectedIndex()) {
                this.g_renamed.h_renamed(2);
            }
            p_renamed();
            return;
        }
        if ("pref_professional_focus_mode_key".equals(str)) {
            this.g_renamed.h_renamed(4);
            if (!this.g_renamed.g_renamed(4)) {
                c_renamed((java.lang.String) null);
                this.q_renamed = true;
                return;
            }
            if (this.h_renamed.d_renamed() == 0) {
                this.q_renamed = false;
            }
            if (4 != this.h_renamed.d_renamed() || this.q_renamed) {
                this.h_renamed.b_renamed(4);
                this.h_renamed.f_renamed();
            }
            if (4 == this.h_renamed.d_renamed() || 1 == this.h_renamed.d_renamed()) {
                J_renamed();
                return;
            }
            return;
        }
        if (!com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) || this.f5208c.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.f5208c.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        K_renamed();
    }

    private void K_renamed() {
        if ("off".equals(this.s_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.f5208c.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        java.lang.String string = this.s_renamed.getString("pref_professional_exposure_time_key", this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.s_renamed.getString("pref_professional_iso_key", this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (java.lang.Long.parseLong(string) != -1) {
            this.g_renamed.setAuto(2);
            if (this.i_renamed.isSelected()) {
                android.view.View viewA = this.i_renamed.a_renamed(2);
                if (2 == this.i_renamed.getSelectedIndex()) {
                    this.i_renamed.getAdapter().a_renamed(viewA, 0, true);
                } else {
                    this.i_renamed.getAdapter().a_renamed(viewA, 0, false);
                }
            }
        }
        if (this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string2)) {
            return;
        }
        this.g_renamed.setAuto(1);
        if (this.i_renamed.isSelected()) {
            android.view.View viewA2 = this.i_renamed.a_renamed(1);
            if (1 == this.i_renamed.getSelectedIndex()) {
                this.i_renamed.getAdapter().a_renamed(viewA2, 0, true);
            } else {
                this.i_renamed.getAdapter().a_renamed(viewA2, 0, false);
            }
        }
    }

    public void c_renamed(java.lang.String str) {
        if (str == null) {
            str = this.s_renamed.getString("pref_professional_focus_mode_key", "0");
        }
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setFocusValue, focusValue: " + str);
        this.e_renamed.ac_renamed();
        if (this.e_renamed.z_renamed()) {
            this.e_renamed.b_renamed(false, false);
        }
        this.h_renamed.a_renamed(java.lang.Float.parseFloat(str));
    }

    public boolean c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onBackPressed");
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
        if (listProfessionalModeBar == null || !listProfessionalModeBar.isSelected()) {
            return false;
        }
        this.i_renamed.a_renamed();
        this.e_renamed.a_renamed(true, true);
        this.e_renamed.d_renamed(true);
        this.d_renamed.d_renamed(0);
        this.d_renamed.d_renamed(true, false);
        this.g_renamed.e_renamed();
        this.h_renamed.g_renamed();
        return true;
    }

    public void r_renamed() {
        java.lang.String string = this.s_renamed.getString("pref_professional_whitebalance_key", this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value));
        if (this.r_renamed.getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value).equals(string)) {
            this.h_renamed.a_renamed(-1);
        }
        if (a_renamed(string, this.g_renamed.c_renamed(5))) {
            try {
                this.h_renamed.a_renamed(java.lang.Integer.parseInt(string));
            } catch (java.lang.NumberFormatException unused) {
                this.h_renamed.e_renamed();
            }
        } else {
            this.h_renamed.e_renamed();
        }
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setWhiteBalance, whiteBalance: " + string);
    }

    public boolean a_renamed(java.lang.String str, java.util.List<java.lang.String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onSingleTapUp");
        if (b_renamed(motionEvent) && this.i_renamed.isSelected() && !this.e_renamed.A_renamed()) {
            c_renamed();
        }
        c_renamed(motionEvent);
        return false;
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.d_renamed.p_renamed().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    private void c_renamed(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.d_renamed.p_renamed().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == this.h_renamed.c_renamed() || 4 == this.h_renamed.c_renamed()) {
                J_renamed();
            }
        }
    }

    public void s_renamed() {
        if (!this.e_renamed.A_renamed() && !this.h_renamed.a_renamed()) {
            this.j_renamed.setEnabled(true);
        } else {
            this.f5206a = true;
        }
    }

    public void t_renamed() {
        this.j_renamed.setEnabled(false);
        c_renamed();
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(com.oplus.camera.util.c_renamed.a_renamed(i_renamed));
        }
    }

    public void c_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onBeforePreview");
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.r_renamed.this.i_renamed == null || !com.oplus.camera.professional.r_renamed.this.i_renamed.isSelected()) {
                    return;
                }
                com.oplus.camera.professional.r_renamed.this.e_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, false, false);
            }
        });
        if (this.o_renamed) {
            com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onBeforePreview, initParamToAuto");
            M_renamed();
        } else if (z_renamed) {
            L_renamed();
        }
    }

    private void L_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "initParam");
        if (this.h_renamed == null || this.g_renamed == null) {
            return;
        }
        java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(this.f5208c, 5);
        if (this.s_renamed.getString("pref_professional_whitebalance_key", strA).equals(strA)) {
            this.h_renamed.e_renamed();
        } else {
            r_renamed();
        }
        a_renamed((java.lang.String) null);
        b_renamed((java.lang.String) null);
        p_renamed();
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.r_renamed.this.p_renamed) {
                    return;
                }
                com.oplus.camera.professional.r_renamed.this.J_renamed();
                com.oplus.camera.professional.r_renamed.this.N_renamed();
            }
        });
    }

    private void M_renamed() {
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.6
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.professional.r_renamed.this.n_renamed();
                com.oplus.camera.professional.r_renamed.this.N_renamed();
            }
        });
        this.o_renamed = false;
    }

    public void d_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null) {
            pVar.b_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N_renamed() {
        this.g_renamed.h_renamed(5);
        this.g_renamed.h_renamed(1);
        this.g_renamed.h_renamed(2);
        this.g_renamed.h_renamed(4);
    }

    public void u_renamed() {
        com.oplus.camera.e_renamed.b_renamed("ProMenuManager", "onAfterStartPreview");
        com.oplus.camera.professional.r_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
    }

    public boolean a_renamed(boolean z_renamed) {
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        if (pVar != null && pVar.g_renamed()) {
            com.oplus.camera.e_renamed.c_renamed("ProMenuManager", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.7
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.professional.r_renamed rVar = com.oplus.camera.professional.r_renamed.this;
                if (rVar.d_renamed(rVar.w_renamed())) {
                    if (com.oplus.camera.professional.r_renamed.this.d_renamed != null) {
                        com.oplus.camera.professional.r_renamed.this.d_renamed.g_renamed(4);
                        com.oplus.camera.professional.r_renamed.this.d_renamed.f_renamed(4);
                        com.oplus.camera.professional.r_renamed.this.d_renamed.a_renamed(4, true);
                        com.oplus.camera.professional.r_renamed.this.d_renamed.a_renamed(4, 1);
                        com.oplus.camera.professional.r_renamed.this.e_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                    }
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.r_renamed.this.j_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                    if (com.oplus.camera.professional.r_renamed.this.d_renamed != null) {
                        com.oplus.camera.professional.r_renamed.this.d_renamed.h_renamed((int) (java.lang.Long.valueOf(com.oplus.camera.professional.r_renamed.this.w_renamed()).longValue() / 1000000));
                    }
                }
                com.oplus.camera.professional.r_renamed.this.j_renamed.setTouchState(false);
            }
        });
        return true;
    }

    public boolean v_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onAfterSnapping");
        if (this.e_renamed.i_renamed() && java.lang.Long.parseLong(w_renamed()) >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            this.e_renamed.c_renamed(4);
        }
        this.f5208c.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.r_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.professional.r_renamed rVar = com.oplus.camera.professional.r_renamed.this;
                if (rVar.d_renamed(rVar.w_renamed())) {
                    com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed();
                    if (com.oplus.camera.professional.r_renamed.this.d_renamed.s_renamed() == 9) {
                        bVar.a_renamed(3);
                        bVar.a_renamed("button_color_inside_none");
                    } else {
                        bVar.a_renamed(7);
                        bVar.a_renamed("button_color_inside_none");
                    }
                    com.oplus.camera.professional.r_renamed.this.d_renamed.a_renamed(bVar);
                }
            }
        });
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onAfterSnapping X_renamed");
        return true;
    }

    public boolean d_renamed(java.lang.String str) {
        return str != null && java.lang.Long.valueOf(str).longValue() >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
    }

    public void a_renamed(byte[] bArr, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "onAfterPictureTaken");
        if (d_renamed(w_renamed())) {
            this.d_renamed.a_renamed(new com.oplus.camera.ui.control.b_renamed(11, "button_color_inside_none"));
            if (this.d_renamed.s_renamed() == 4 || this.d_renamed.s_renamed() == 3 || !i_renamed()) {
                this.d_renamed.a_renamed(0, 1);
            }
            c_renamed(0);
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.e_renamed.a_renamed(true, false);
        }
        this.d_renamed.d_renamed(true, false);
        if (this.f5206a) {
            com.oplus.camera.util.Util.a_renamed(this.j_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.f5206a = false;
        }
        this.j_renamed.setTouchState(true);
    }

    public java.lang.String w_renamed() {
        return this.s_renamed.getString("pref_professional_exposure_time_key", this.f5208c.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
    }

    protected void c_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ProMenuManager", "setCameraMenuControlViewVisibility, visibility: " + i_renamed);
        com.oplus.camera.ui.CameraUIInterface cameraUIInterface = this.d_renamed;
        if (cameraUIInterface != null) {
            cameraUIInterface.g_renamed(i_renamed);
            this.d_renamed.f_renamed(i_renamed);
            this.d_renamed.c_renamed(i_renamed);
        }
    }

    public boolean d_renamed(int i_renamed) {
        com.oplus.camera.professional.p_renamed pVar = this.g_renamed;
        return pVar != null && pVar.g_renamed(i_renamed);
    }

    public void x_renamed() {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.i_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.b_renamed();
        }
    }
}
