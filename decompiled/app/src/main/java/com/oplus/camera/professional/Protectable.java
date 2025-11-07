package com.oplus.camera.professional;

/* compiled from: HSLevelPanel.java */
/* loaded from: classes2.dex */
public class c_renamed extends android.widget.RelativeLayout implements com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static java.util.HashMap<java.lang.String, java.lang.String> f5111a = new java.util.HashMap<>();
    private static java.util.HashMap<java.lang.String, java.lang.Boolean> g_renamed = new java.util.HashMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.professional.i_renamed f5112b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.professional.b_renamed f5113c;
    protected com.oplus.camera.ui.CommonComponent.HSScaleBar d_renamed;
    protected com.oplus.camera.professional.w_renamed e_renamed;
    protected android.widget.TextView f_renamed;
    private java.lang.String h_renamed;
    private int i_renamed;
    private android.content.Context j_renamed;
    private com.oplus.camera.professional.c_renamed.a_renamed k_renamed;
    private java.util.ArrayList<com.oplus.camera.ui.menu.OplusTextView> l_renamed;
    private boolean m_renamed;
    private android.content.SharedPreferences n_renamed;
    private java.util.regex.Pattern o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private java.lang.String[] s_renamed;
    private java.lang.String[] t_renamed;
    private java.lang.String[] u_renamed;
    private java.lang.String[] v_renamed;

    /* compiled from: HSLevelPanel.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(boolean z_renamed);

        void b_renamed();

        void b_renamed(int i_renamed);
    }

    public c_renamed(android.content.Context context, boolean z_renamed, android.os.Handler handler, boolean z2, boolean z3, com.oplus.camera.professional.i_renamed iVar, android.content.SharedPreferences sharedPreferences) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.f5112b = null;
        this.f5113c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.h_renamed = "[一-龥]";
        this.i_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = new java.util.ArrayList<>();
        this.m_renamed = false;
        this.n_renamed = null;
        this.o_renamed = java.util.regex.Pattern.compile(this.h_renamed);
        this.p_renamed = true;
        this.q_renamed = true;
        this.r_renamed = false;
        this.s_renamed = new java.lang.String[]{"100", "400", "800", "1600", "3200", "6400"};
        this.t_renamed = new java.lang.String[]{"1/8000", "1/1000", "1/125", "1/15", "1/2", "4", com.oplus.camera.capmode.w_renamed.VIDEO_DEFAULT_FPS, "32"};
        this.u_renamed = new java.lang.String[]{"2300", "3600", "4900", "6200", "7500"};
        this.v_renamed = new java.lang.String[]{"-2.00", "-1.00", "0.00", "+1.00", "+2.00"};
        this.j_renamed = context;
        this.n_renamed = sharedPreferences;
        this.f5112b = iVar;
        this.q_renamed = z_renamed;
        this.r_renamed = z3;
        this.m_renamed = z2;
        a_renamed(handler);
    }

    public com.oplus.camera.professional.i_renamed getHSSubModeBarData() {
        return this.f5112b;
    }

    public java.lang.String getDefaultValue() {
        return this.f5112b.d_renamed();
    }

    public java.util.ArrayList<java.lang.String> getParameterValueList() {
        return this.f5112b.b_renamed();
    }

    public java.util.ArrayList<java.lang.String> getParameterNamesList() {
        return this.f5112b.c_renamed();
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2) {
        f5111a.put(str, str2);
    }

    public static void a_renamed() {
        f5111a.put("pref_professional_whitebalance_key", "2000");
        f5111a.put("pref_professional_iso_key", "100");
        f5111a.put("pref_professional_exposure_compensation_key", "0.00");
        f5111a.put("pref_professional_exposure_time_key", "1/50s");
        f5111a.put("pref_professional_focus_mode_key", "0.00");
        f5111a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "2000");
        f5111a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, "100");
        f5111a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "0.00");
        f5111a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, "1/50s");
        f5111a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "0.00");
    }

    public static void setAutoValueMap(java.util.HashMap<java.lang.String, java.lang.String> map) {
        f5111a.clear();
        f5111a = map;
    }

    private java.lang.String a_renamed(java.lang.String str) {
        return f5111a.get(str);
    }

    protected java.lang.String a_renamed(com.oplus.camera.professional.i_renamed iVar, java.lang.String str) {
        if (iVar == null) {
            return null;
        }
        return iVar.b_renamed().indexOf(str) < 0 ? "" : iVar.c_renamed().get(iVar.b_renamed().indexOf(str));
    }

    public java.lang.String a_renamed(android.content.SharedPreferences sharedPreferences) {
        java.lang.String strD;
        java.lang.String strA;
        java.lang.String strA2 = this.f5112b.a_renamed();
        java.lang.String string = sharedPreferences.getString(strA2, this.f5112b.d_renamed());
        if (!string.equals(this.f5112b.d_renamed()) || "pref_professional_exposure_compensation_key".equals(strA2)) {
            java.lang.String strA3 = a_renamed(this.f5112b, string);
            if (!"".equals(strA3)) {
                return strA3;
            }
            if ("pref_professional_exposure_compensation_key".equals(strA2)) {
                strD = getDefaultValue();
                strA = a_renamed(this.f5112b, strD);
            } else {
                strD = this.f5112b.d_renamed();
                strA = a_renamed(strA2);
            }
            if (this.f5112b.b_renamed() != null && this.f5112b.b_renamed().size() != 0 && b_renamed(strA2, strD)) {
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strA2, strD);
                editorEdit.apply();
            }
            return strA;
        }
        return a_renamed(strA2);
    }

    private boolean b_renamed(java.lang.String str, java.lang.String str2) {
        if ("pref_professional_exposure_time_key".equals(str)) {
            return (android.text.TextUtils.isEmpty(str2) || this.j_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(str2)) ? false : true;
        }
        return true;
    }

    public int getCurrentIndex() {
        return this.d_renamed.getCurrentIndex();
    }

    public boolean a_renamed(int i_renamed) {
        return this.d_renamed.getCurrentIndex() == i_renamed;
    }

    public void setValueChangeListener(com.oplus.camera.professional.c_renamed.a_renamed aVar) {
        this.k_renamed = aVar;
    }

    public void a_renamed(final int i_renamed, android.app.Activity activity) {
        if (this.d_renamed.getCurrentIndex() != i_renamed || i_renamed == 0) {
            this.d_renamed.setCurrentIndex(i_renamed);
            if (activity != null) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.c_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.professional.c_renamed.this.d_renamed.scrollTo(i_renamed);
                        if (com.oplus.camera.professional.c_renamed.this.k_renamed != null) {
                            com.oplus.camera.professional.c_renamed.this.k_renamed.b_renamed(i_renamed);
                        }
                    }
                });
            }
        }
    }

    public void a_renamed(final int i_renamed, android.app.Activity activity, java.lang.String str) {
        this.d_renamed.setCurrentIndex(i_renamed);
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.c_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.c_renamed.this.d_renamed.scrollTo(i_renamed);
                    if (com.oplus.camera.professional.c_renamed.this.k_renamed != null) {
                        com.oplus.camera.professional.c_renamed.this.k_renamed.a_renamed(i_renamed);
                    }
                }
            });
        }
    }

    public void setBarAuto(boolean z_renamed) {
        this.q_renamed = z_renamed;
        com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = this.d_renamed;
        if (hSScaleBar != null) {
            hSScaleBar.setAuto(this.q_renamed, true);
        }
        com.oplus.camera.professional.b_renamed bVar = this.f5113c;
        if (bVar != null) {
            bVar.setAuto(this.q_renamed);
        }
    }

    public void setAlign(int i_renamed) {
        com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = this.d_renamed;
        if (hSScaleBar != null) {
            hSScaleBar.setAlign(i_renamed);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.p_renamed) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = this.d_renamed;
        if (hSScaleBar != null) {
            hSScaleBar.invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
    }

    public void b_renamed() {
        com.oplus.camera.professional.i_renamed iVar;
        com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = this.d_renamed;
        if (hSScaleBar == null || (iVar = this.f5112b) == null) {
            return;
        }
        hSScaleBar.setLevelNum(iVar.c_renamed().size());
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(android.os.Handler r14) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.c_renamed.a_renamed(android.os.Handler):void");
    }

    public int b_renamed(android.content.SharedPreferences sharedPreferences) {
        java.lang.String strA = this.f5112b.a_renamed();
        java.util.ArrayList<java.lang.String> arrayListB = this.f5112b.b_renamed();
        java.lang.String strD = this.f5112b.d_renamed();
        if (sharedPreferences != null) {
            strD = sharedPreferences.getString(strA, this.f5112b.d_renamed());
        }
        return arrayListB.indexOf(strD);
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.CommonComponent.HSScaleBar hSScaleBar = this.d_renamed;
        if (hSScaleBar != null) {
            hSScaleBar.initDataIndex(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onValueChange(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("HSLevelPanel", "onValueChange, value: " + i_renamed);
        com.oplus.camera.professional.c_renamed.a_renamed aVar = this.k_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onBarMoving() {
        if (this.q_renamed) {
            setBarAuto(false);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onBarScrolling(boolean z_renamed) {
        com.oplus.camera.professional.c_renamed.a_renamed aVar = this.k_renamed;
        if (aVar != null) {
            aVar.a_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.HSScaleBar.ScaleBarValueChangeListener
    public void onActionUp() {
        com.oplus.camera.professional.c_renamed.a_renamed aVar = this.k_renamed;
        if (aVar != null) {
            aVar.b_renamed();
        }
    }
}
