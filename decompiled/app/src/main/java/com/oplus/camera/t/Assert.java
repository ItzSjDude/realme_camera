package com.oplus.camera.t_renamed;

/* compiled from: FixFocusControl.java */
/* loaded from: classes2.dex */
public class a_renamed {
    private com.oplus.camera.e_renamed.d_renamed g_renamed;
    private android.content.SharedPreferences h_renamed;
    private android.app.Activity l_renamed;
    private com.oplus.camera.ui.CameraUIInterface m_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5582a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5583b = "1";

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f5584c = "28";
    private java.lang.String d_renamed = "169";
    private java.lang.String[] e_renamed = null;
    private boolean f_renamed = false;
    private java.util.ArrayList<java.lang.String> i_renamed = null;
    private java.util.ArrayList<java.lang.String> j_renamed = null;
    private com.oplus.camera.t_renamed.d_renamed k_renamed = null;

    public a_renamed(com.oplus.camera.e_renamed.d_renamed dVar, com.oplus.camera.capmode.a_renamed aVar, android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.g_renamed = null;
        this.h_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.g_renamed = dVar;
        this.h_renamed = aVar.t_renamed();
        this.m_renamed = cameraUIInterface;
        this.l_renamed = activity;
        com.oplus.camera.e_renamed.h_renamed hVarA = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, aVar.aw_renamed());
        a_renamed(hVarA.n_renamed(), hVarA.m_renamed());
        h_renamed();
        d_renamed();
    }

    private void a_renamed(float f_renamed, float f2) {
        this.i_renamed = new java.util.ArrayList<>();
        this.j_renamed = new java.util.ArrayList<>();
        if (f_renamed < f2) {
            f2 = f_renamed;
            f_renamed = f2;
        }
        if (java.lang.Float.compare(f_renamed, 0.0f) <= 0 || java.lang.Float.compare(f_renamed, f2) == 0) {
            com.oplus.camera.e_renamed.e_renamed("FixFocusCtrol", "generateFocusValues, return, minFocusDistance: " + f_renamed);
            return;
        }
        float f3 = (f_renamed - f2) / 50.0f;
        int i_renamed = 0;
        while (i_renamed <= 50) {
            float f4 = i_renamed;
            this.i_renamed.add(java.lang.Float.toString(f_renamed - (f3 * f4)));
            java.lang.String str = java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf((i_renamed < 0 || f4 > 45.0f) ? 1.0f + ((f4 - 45.0f) * 0.8f) : 0.02f * f4));
            if (f4 == 45.0f) {
                this.j_renamed.add("1.00m");
            } else {
                this.j_renamed.add(str + "m_renamed");
            }
            i_renamed++;
        }
        this.f5582a = a_renamed();
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FixFocusCtrol", "onValueChange value: " + i_renamed);
        java.lang.String strD = d_renamed(i_renamed);
        this.k_renamed.setText(c_renamed(i_renamed));
        if (strD != null) {
            b_renamed(i_renamed);
            com.oplus.camera.e_renamed.d_renamed dVar = this.g_renamed;
            if (dVar != null) {
                dVar.a_renamed(java.lang.Float.valueOf(strD).floatValue(), true);
            }
        }
    }

    private java.lang.String c_renamed(int i_renamed) {
        return this.j_renamed.get(i_renamed);
    }

    public void b_renamed(int i_renamed) {
        android.content.SharedPreferences.Editor editorEdit = this.h_renamed.edit();
        editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, i_renamed);
        editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, true);
        editorEdit.apply();
    }

    public int a_renamed() {
        return this.h_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_VALUE, 10);
    }

    private java.lang.String d_renamed(int i_renamed) {
        java.util.ArrayList<java.lang.String> arrayList;
        if (i_renamed <= -1 || (arrayList = this.i_renamed) == null || arrayList.size() <= i_renamed) {
            return null;
        }
        return this.i_renamed.get(i_renamed);
    }

    public boolean b_renamed() {
        f_renamed();
        int i_renamed = this.f5582a;
        if (i_renamed <= 0) {
            return false;
        }
        this.f5582a = i_renamed - 1;
        a_renamed(true);
        a_renamed(this.f5582a);
        return true;
    }

    public boolean c_renamed() {
        f_renamed();
        int i_renamed = this.f5582a;
        if (i_renamed >= 50) {
            return false;
        }
        this.f5582a = i_renamed + 1;
        a_renamed(true);
        a_renamed(this.f5582a);
        return true;
    }

    public void a_renamed(boolean z_renamed) {
        this.f_renamed = z_renamed;
        this.g_renamed.E_renamed(this.f_renamed);
        this.g_renamed.a_renamed(this.e_renamed);
        this.g_renamed.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    private void h_renamed() {
        java.lang.String[] strArrB;
        this.f5583b = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EDGE_FILTER_LINE_SIZE);
        int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EDGE_FILTER_COLOR);
        if (configIntArrayValue != null && 3 == configIntArrayValue.length && (strArrB = com.oplus.camera.util.Util.b_renamed(configIntArrayValue[0], configIntArrayValue[1], configIntArrayValue[2])) != null && 2 == strArrB.length) {
            this.f5584c = strArrB[0];
            this.d_renamed = strArrB[1];
        }
        this.e_renamed = new java.lang.String[]{this.f5583b, this.f5584c, this.d_renamed};
    }

    public void d_renamed() {
        this.k_renamed = new com.oplus.camera.t_renamed.d_renamed(this.l_renamed.getApplicationContext());
        android.content.res.Resources resources = this.l_renamed.getApplicationContext().getResources();
        this.k_renamed.setVerticalDraw(true);
        this.k_renamed.setIncludeFontPadding(false);
        this.k_renamed.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_main_mode_bar_item_text_size));
        this.k_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.l_renamed.getApplicationContext()));
        this.k_renamed.setGravity(80);
        this.k_renamed.setTextColor(resources.getColor(com.oplus.camera.R_renamed.color.main_item_title_text_color));
        this.k_renamed.setId(android.view.View.generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height) + (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_button_size) / 2);
        this.k_renamed.setLayoutParams(layoutParams);
        this.m_renamed.a_renamed((android.view.View) this.k_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, 4, true);
    }

    public void e_renamed() {
        com.oplus.camera.t_renamed.d_renamed dVar = this.k_renamed;
        if (dVar != null) {
            dVar.setVisibility(8);
        }
    }

    public void f_renamed() {
        com.oplus.camera.t_renamed.d_renamed dVar = this.k_renamed;
        if (dVar == null || dVar.getVisibility() == 0) {
            return;
        }
        this.f5582a = a_renamed();
        this.k_renamed.setText(c_renamed(this.f5582a));
        this.k_renamed.setVisibility(0);
    }

    public boolean g_renamed() {
        return this.h_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_MANUAL_STATE, false);
    }
}
