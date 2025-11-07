package com.oplus.camera.professional;

/* loaded from: classes2.dex */
public class LevelPanel extends android.widget.RelativeLayout implements com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected static java.util.HashMap<java.lang.String, java.lang.String> f5086a = new java.util.HashMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.professional.z_renamed f5087b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.professional.w_renamed f5088c;
    protected android.widget.TextView d_renamed;
    protected com.oplus.camera.professional.a_renamed e_renamed;
    protected com.oplus.camera.ui.CommonComponent.ScaleBar f_renamed;
    private java.lang.String g_renamed;
    private int h_renamed;
    private android.content.Context i_renamed;
    private com.oplus.camera.professional.LevelPanel.ValueChangeListener j_renamed;
    private java.util.ArrayList<com.oplus.camera.ui.menu.OplusTextView> k_renamed;
    private boolean l_renamed;
    private android.content.SharedPreferences m_renamed;
    private java.util.regex.Pattern n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private int r_renamed;
    private int s_renamed;
    private android.animation.ObjectAnimator t_renamed;

    public interface ValueChangeListener {
        void onActionUp();

        void onAutoButtonClick();

        void onAutoValueChange(int i_renamed);

        void onBarScrolling(boolean z_renamed);

        void onManualValueChange(int i_renamed);
    }

    public LevelPanel(android.content.Context context, boolean z_renamed, android.os.Handler handler, boolean z2, boolean z3, com.oplus.camera.professional.z_renamed zVar, android.content.SharedPreferences sharedPreferences) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.f5087b = null;
        this.f5088c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = "[一-龥]";
        this.h_renamed = 0;
        this.j_renamed = null;
        this.k_renamed = new java.util.ArrayList<>();
        this.l_renamed = false;
        this.m_renamed = null;
        this.n_renamed = java.util.regex.Pattern.compile(this.g_renamed);
        this.o_renamed = true;
        this.p_renamed = true;
        this.q_renamed = false;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = null;
        this.i_renamed = context;
        this.m_renamed = sharedPreferences;
        this.f5087b = zVar;
        this.p_renamed = z_renamed;
        this.q_renamed = z3;
        this.l_renamed = z2;
        a_renamed(handler);
    }

    public LevelPanel(android.content.Context context, boolean z_renamed, android.os.Handler handler, boolean z2, boolean z3, int i_renamed, int i2, com.oplus.camera.professional.z_renamed zVar, android.content.SharedPreferences sharedPreferences) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.f5087b = null;
        this.f5088c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = "[一-龥]";
        this.h_renamed = 0;
        this.j_renamed = null;
        this.k_renamed = new java.util.ArrayList<>();
        this.l_renamed = false;
        this.m_renamed = null;
        this.n_renamed = java.util.regex.Pattern.compile(this.g_renamed);
        this.o_renamed = true;
        this.p_renamed = true;
        this.q_renamed = false;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = null;
        this.r_renamed = i_renamed;
        this.s_renamed = i2;
        this.i_renamed = context;
        this.m_renamed = sharedPreferences;
        this.f5087b = zVar;
        this.p_renamed = z_renamed;
        this.q_renamed = z3;
        this.l_renamed = z2;
        a_renamed(handler);
    }

    public com.oplus.camera.professional.z_renamed getSubModeBarData() {
        return this.f5087b;
    }

    public java.lang.String getDefaultValue() {
        return this.f5087b.d_renamed();
    }

    public java.util.ArrayList<java.lang.String> getParameterValueList() {
        return this.f5087b.b_renamed();
    }

    public java.util.ArrayList<java.lang.String> getParameterNamesList() {
        return this.f5087b.c_renamed();
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2) {
        f5086a.put(str, str2);
    }

    public static void c_renamed() {
        f5086a.put("pref_professional_whitebalance_key", "2000");
        f5086a.put("pref_professional_iso_key", "100");
        f5086a.put("pref_professional_exposure_compensation_key", "0.00");
        f5086a.put("pref_professional_exposure_time_key", "1/50s");
        f5086a.put("pref_professional_focus_mode_key", "0.00");
        f5086a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, "2000");
        f5086a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, "100");
        f5086a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE, "0.00");
        f5086a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, "1/50s");
        f5086a.put(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, "0.00");
    }

    public static void setAutoValueMap(java.util.HashMap<java.lang.String, java.lang.String> map) {
        f5086a.clear();
        f5086a = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a_renamed(java.lang.String str) {
        return f5086a.get(str);
    }

    protected java.lang.String a_renamed(com.oplus.camera.professional.z_renamed zVar, java.lang.String str) {
        if (zVar == null) {
            return null;
        }
        return zVar.b_renamed().indexOf(str) < 0 ? "" : zVar.c_renamed().get(zVar.b_renamed().indexOf(str));
    }

    public java.lang.String a_renamed(android.content.SharedPreferences sharedPreferences) {
        java.lang.String strD;
        java.lang.String strA;
        java.lang.String strA2 = this.f5087b.a_renamed();
        java.lang.String string = sharedPreferences.getString(strA2, this.f5087b.d_renamed());
        if (!string.equals(this.f5087b.d_renamed()) || "pref_professional_exposure_compensation_key".equals(strA2)) {
            java.lang.String strA3 = a_renamed(this.f5087b, string);
            if (!"".equals(strA3)) {
                return strA3;
            }
            if ("pref_professional_exposure_compensation_key".equals(strA2)) {
                strD = getDefaultValue();
                strA = a_renamed(this.f5087b, strD);
            } else {
                strD = this.f5087b.d_renamed();
                strA = a_renamed(strA2);
            }
            if (this.f5087b.b_renamed() != null && this.f5087b.b_renamed().size() != 0 && b_renamed(strA2, strD)) {
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strA2, strD);
                editorEdit.apply();
            }
            return strA;
        }
        return a_renamed(strA2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemValueText(java.lang.String str) {
        if (this.f5088c != null) {
            this.f5088c.setText(com.oplus.camera.professional.x_renamed.a_renamed(str));
        }
    }

    private boolean b_renamed(java.lang.String str, java.lang.String str2) {
        if ("pref_professional_exposure_time_key".equals(str)) {
            return (android.text.TextUtils.isEmpty(str2) || this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(str2)) ? false : true;
        }
        return true;
    }

    public int getCurrentIndex() {
        return this.f_renamed.getCurrentIndex();
    }

    public boolean a_renamed(int i_renamed) {
        return this.f_renamed.getCurrentIndex() == i_renamed;
    }

    public void setValueChangeListener(com.oplus.camera.professional.LevelPanel.ValueChangeListener valueChangeListener) {
        this.j_renamed = valueChangeListener;
    }

    public void a_renamed(final int i_renamed, android.app.Activity activity) {
        if (this.f_renamed.getCurrentIndex() != i_renamed || i_renamed == 0) {
            this.f_renamed.setCurrentIndex(i_renamed);
            if (activity != null) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.LevelPanel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.professional.LevelPanel.this.f_renamed.scrollTo(i_renamed);
                        com.oplus.camera.professional.LevelPanel levelPanel = com.oplus.camera.professional.LevelPanel.this;
                        levelPanel.setItemValueText(levelPanel.a_renamed(levelPanel.f5087b.a_renamed()));
                        if (com.oplus.camera.professional.LevelPanel.this.j_renamed != null) {
                            com.oplus.camera.professional.LevelPanel.this.j_renamed.onAutoValueChange(i_renamed);
                        }
                    }
                });
            }
        }
    }

    public void b_renamed(final int i_renamed, android.app.Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.LevelPanel.2
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.LevelPanel levelPanel = com.oplus.camera.professional.LevelPanel.this;
                    levelPanel.setItemValueText(levelPanel.f5087b.c_renamed().get(i_renamed));
                }
            });
        }
    }

    public void a_renamed(final int i_renamed, android.app.Activity activity, final java.lang.String str) {
        this.f_renamed.setCurrentIndex(i_renamed);
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.LevelPanel.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.LevelPanel.this.f_renamed.scrollTo(i_renamed);
                    java.lang.String str2 = str;
                    if (str2 != null) {
                        com.oplus.camera.professional.LevelPanel.this.setItemValueText(str2);
                    } else {
                        com.oplus.camera.professional.LevelPanel levelPanel = com.oplus.camera.professional.LevelPanel.this;
                        levelPanel.setItemValueText(levelPanel.f5087b.c_renamed().get(i_renamed));
                    }
                    if (com.oplus.camera.professional.LevelPanel.this.j_renamed != null) {
                        com.oplus.camera.professional.LevelPanel.this.j_renamed.onManualValueChange(i_renamed);
                    }
                }
            });
        }
    }

    public void setBarAuto(boolean z_renamed) {
        android.widget.TextView textView;
        this.p_renamed = z_renamed;
        if (!z_renamed && (textView = this.d_renamed) != null && textView.getVisibility() == 0) {
            a_renamed(false, true);
        }
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar != null) {
            scaleBar.setAuto(this.p_renamed, true);
        }
        com.oplus.camera.professional.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.setAuto(this.p_renamed);
        }
    }

    public void setAlign(int i_renamed) {
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar != null) {
            scaleBar.setAlign(i_renamed);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.o_renamed) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar != null) {
            scaleBar.invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        boolean z_renamed = i_renamed != getVisibility();
        super.setVisibility(i_renamed);
        if (this.d_renamed != null) {
            if (i_renamed == 0 && z_renamed) {
                a_renamed(true, false);
                return;
            }
            if (4 == i_renamed || 8 == i_renamed) {
                android.animation.ObjectAnimator objectAnimator = this.t_renamed;
                if (objectAnimator != null && objectAnimator.isStarted()) {
                    this.t_renamed.cancel();
                }
                com.oplus.camera.professional.w_renamed wVar = this.f5088c;
                if (wVar != null) {
                    wVar.animate().cancel();
                }
            }
        }
    }

    public void d_renamed() {
        com.oplus.camera.professional.z_renamed zVar;
        if (this.f5088c != null) {
            setItemValueText(a_renamed(this.m_renamed));
        }
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar == null || (zVar = this.f5087b) == null) {
            return;
        }
        scaleBar.setLevelNum(zVar.c_renamed().size());
    }

    public void a_renamed(int i_renamed, int i2) {
        this.r_renamed = i_renamed;
        this.s_renamed = i2;
    }

    public void e_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar == null) {
            return;
        }
        if (1 == this.r_renamed) {
            if (270 == this.s_renamed) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_margin_right_270);
                this.f_renamed.setRotation(90.0f);
                this.f_renamed.setTranslationX(dimensionPixelOffset);
            } else {
                int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_margin_left);
                this.f_renamed.setRotation(270.0f);
                this.f_renamed.setTranslationX(dimensionPixelOffset2);
            }
        } else {
            scaleBar.setTranslationX(0.0f);
            this.f_renamed.setRotation(0.0f);
        }
        this.f_renamed.setLayoutParams(getScaleBarLayoutParams());
        com.oplus.camera.professional.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.setLayoutParams(getAutoTextLayoutParams());
            int i_renamed = this.r_renamed;
            if (1 == i_renamed) {
                this.e_renamed.setTranslationY(-com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_auto_text_margin_bottom));
                this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.profession_mode_auto_button_bg);
            } else if (4 == i_renamed) {
                this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.profession_mode_auto_button_bg_light);
            }
        }
        if (com.oplus.camera.util.Util.t_renamed()) {
            com.oplus.camera.professional.w_renamed wVar = this.f5088c;
            if (wVar != null) {
                wVar.setLayoutParams(getValueTextLayoutParams());
                this.f5088c.setTextAlignment(4);
            }
            android.widget.TextView textView = this.d_renamed;
            if (textView != null) {
                textView.setLayoutParams(getHintTextLayoutParams());
            }
        }
    }

    public android.widget.RelativeLayout.LayoutParams getScaleBarLayoutParams() {
        int i_renamed = this.r_renamed;
        if (1 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_width), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_height));
            layoutParams.addRule(9);
            return layoutParams;
        }
        if (3 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams((com.oplus.camera.util.Util.getScreenWidth() / 2) / (this.l_renamed ? 2 : 1), this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height) + this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_panel_container_margin_bottom));
            layoutParams2.leftMargin = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_outside_margin);
            layoutParams2.rightMargin = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_outside_margin);
            layoutParams2.addRule(12);
            return layoutParams2;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth() / (this.l_renamed ? 2 : 1), this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height) + this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_panel_container_margin_bottom) + ((int) (com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a) * 2.0f)));
        layoutParams3.leftMargin = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_outside_margin);
        layoutParams3.rightMargin = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_outside_margin);
        layoutParams3.addRule(12);
        return layoutParams3;
    }

    public android.widget.RelativeLayout.LayoutParams getAutoTextLayoutParams() throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_width), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_height));
        int i_renamed = this.r_renamed;
        if (1 == i_renamed) {
            layoutParams.addRule(12);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_auto_text_margin_right);
            if (270 == this.s_renamed) {
                layoutParams.addRule(9);
                layoutParams.leftMargin = dimensionPixelOffset;
                return layoutParams;
            }
            layoutParams.addRule(11);
            layoutParams.rightMargin = dimensionPixelOffset;
            return layoutParams;
        }
        if (4 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_width), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_height));
            layoutParams2.addRule(11);
            layoutParams2.addRule(2, this.f_renamed.getId());
            layoutParams2.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_main_mode_bar_item_auto_button_margin_bottom);
            layoutParams2.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_main_mode_bar_item_auto_button_margin_end);
            return layoutParams2;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_width), com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_height));
        layoutParams3.addRule(11);
        layoutParams3.addRule(2, this.f_renamed.getId());
        layoutParams3.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_margin_bottom);
        layoutParams3.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_margin_end);
        return layoutParams3;
    }

    public android.widget.RelativeLayout.LayoutParams getValueTextLayoutParams() throws android.content.res.Resources.NotFoundException {
        int i_renamed = this.r_renamed;
        if (1 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_value_text_margin_top);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_value_text_margin_right);
            if (270 == this.s_renamed) {
                layoutParams.addRule(9);
                layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, 0, 0);
                return layoutParams;
            }
            layoutParams.addRule(11);
            layoutParams.setMargins(0, dimensionPixelOffset, dimensionPixelOffset2, 0);
            return layoutParams;
        }
        if (i_renamed == 0) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            return layoutParams2;
        }
        if (4 == i_renamed) {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_professional_param_slide_bar_value_text_height));
            layoutParams3.addRule(10);
            layoutParams3.addRule(14);
            layoutParams3.topMargin = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_rack_professional_params_slide_bar_value_text_margin_top);
            return layoutParams3;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_professional_param_slide_bar_value_text_height));
        layoutParams4.addRule(14);
        return layoutParams4;
    }

    public android.widget.RelativeLayout.LayoutParams getHintTextLayoutParams() throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (1 == this.r_renamed) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_value_text_margin_top);
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_slide_bar_value_text_margin_right);
            if (270 == this.s_renamed) {
                layoutParams.addRule(9);
                layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, 0, 0);
            } else {
                layoutParams.addRule(11);
                layoutParams.setMargins(0, dimensionPixelOffset, dimensionPixelOffset2, 0);
            }
        } else {
            layoutParams.addRule(14);
        }
        return layoutParams;
    }

    private void a_renamed(android.os.Handler handler) throws android.content.res.Resources.NotFoundException {
        this.f5088c = new com.oplus.camera.professional.w_renamed(this.i_renamed);
        this.f5088c.setVerticalDraw(true);
        setItemValueText(a_renamed(this.m_renamed));
        a_renamed(this.f5088c);
        addView(this.f5088c);
        this.f5088c.setVisibility(4);
        this.d_renamed = new android.widget.TextView(this.i_renamed);
        this.d_renamed.setText(this.f5087b.e_renamed());
        a_renamed(this.d_renamed);
        com.oplus.camera.util.Util.a_renamed(this.d_renamed);
        this.d_renamed.setVisibility(0);
        addView(this.d_renamed);
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a);
        this.f_renamed = new com.oplus.camera.ui.CommonComponent.ScaleBar(this.i_renamed, this.f5087b.c_renamed().size(), handler);
        this.f_renamed.setId(android.view.View.generateViewId());
        this.f_renamed.setScaleBarValueChangeListener(this);
        this.f_renamed.setAuto(this.p_renamed, false);
        this.f_renamed.setShadowLayer();
        int i_renamed = (int) fA_renamed;
        this.f_renamed.setPadding(i_renamed, i_renamed, i_renamed, i_renamed);
        this.f_renamed.setId(generateViewId());
        addView(this.f_renamed);
        android.content.res.Resources resources = this.i_renamed.getApplicationContext().getResources();
        this.e_renamed = new com.oplus.camera.professional.a_renamed(this.i_renamed);
        this.e_renamed.setAuto(this.p_renamed);
        this.e_renamed.setId(generateViewId());
        this.e_renamed.setIncludeFontPadding(false);
        this.e_renamed.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_button_text_size));
        this.e_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.i_renamed));
        this.e_renamed.setGravity(17);
        this.e_renamed.setVisibility(this.q_renamed ? 0 : 8);
        this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.profession_mode_auto_button_bg);
        this.e_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.professional.LevelPanel.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.professional.LevelPanel.this.j_renamed != null) {
                    com.oplus.camera.professional.LevelPanel.this.j_renamed.onAutoButtonClick();
                }
            }
        });
        addView(this.e_renamed);
        e_renamed();
    }

    private void a_renamed(android.widget.TextView textView) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = this.i_renamed.getApplicationContext().getResources();
        textView.setHeight(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_text_height));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_text_size));
        textView.setTypeface(com.oplus.camera.util.Util.c_renamed(false));
        textView.setTextColor(resources.getColor(com.oplus.camera.R_renamed.color.main_item_title_text_color));
        com.oplus.camera.util.Util.a_renamed(textView);
        textView.setId(generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
    }

    private void a_renamed(boolean z_renamed, boolean z2) {
        android.widget.TextView textView = this.d_renamed;
        if (textView != null) {
            if (this.t_renamed == null) {
                this.t_renamed = android.animation.ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0.0f);
                this.t_renamed.setDuration(250L);
                this.t_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
                this.t_renamed.setStartDelay(1L);
                this.t_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.LevelPanel.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                        com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateHintTextView, cancel.");
                        com.oplus.camera.professional.LevelPanel.this.d_renamed.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateHintTextView, end.");
                        com.oplus.camera.professional.LevelPanel.this.d_renamed.setVisibility(8);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateHintTextView, start.");
                        com.oplus.camera.professional.LevelPanel.this.a_renamed();
                    }
                });
            }
            int i_renamed = z_renamed ? 3000 : 0;
            if (z2 && i_renamed == this.t_renamed.getStartDelay()) {
                com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateHintTextView, abort duplicate animation.");
                return;
            }
            this.t_renamed.cancel();
            this.t_renamed.setStartDelay(i_renamed);
            this.t_renamed.start();
            this.d_renamed.setAlpha(1.0f);
            this.d_renamed.setVisibility(0);
            com.oplus.camera.professional.w_renamed wVar = this.f5088c;
            if (wVar != null) {
                wVar.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed() {
        com.oplus.camera.professional.w_renamed wVar = this.f5088c;
        if (wVar != null) {
            wVar.setAlpha(0.0f);
            this.f5088c.animate().alpha(1.0f).setStartDelay(150L).setDuration(250L).setInterpolator(com.oplus.camera.professional.t_renamed.f5227a).setListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.LevelPanel.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateValueTextView, cancel.");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateValueTextView, end.");
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.b_renamed("LevelPanel", "animateValueTextView, start.");
                    com.oplus.camera.professional.LevelPanel.this.f5088c.setVisibility(0);
                }
            }).start();
        }
    }

    public int b_renamed(android.content.SharedPreferences sharedPreferences) {
        java.lang.String strA = this.f5087b.a_renamed();
        java.util.ArrayList<java.lang.String> arrayListB = this.f5087b.b_renamed();
        java.lang.String strD = this.f5087b.d_renamed();
        if (sharedPreferences != null) {
            strD = sharedPreferences.getString(strA, this.f5087b.d_renamed());
        }
        return arrayListB.indexOf(strD);
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar != null) {
            scaleBar.initDataIndex(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onValueChange(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LevelPanel", "onValueChange, value: " + i_renamed);
        com.oplus.camera.professional.LevelPanel.ValueChangeListener valueChangeListener = this.j_renamed;
        if (valueChangeListener != null) {
            valueChangeListener.onManualValueChange(i_renamed);
            setItemValueText(a_renamed(this.m_renamed));
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onBarMoving() {
        if (this.p_renamed) {
            setBarAuto(false);
            return;
        }
        android.widget.TextView textView = this.d_renamed;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        a_renamed(false, true);
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onBarScrolling(boolean z_renamed) {
        com.oplus.camera.professional.LevelPanel.ValueChangeListener valueChangeListener = this.j_renamed;
        if (valueChangeListener != null) {
            valueChangeListener.onBarScrolling(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CommonComponent.ScaleBar.ScaleBarValueChangeListener
    public void onActionUp() {
        com.oplus.camera.professional.LevelPanel.ValueChangeListener valueChangeListener = this.j_renamed;
        if (valueChangeListener != null) {
            valueChangeListener.onActionUp();
        }
    }

    public void setScaleBarTouchable(boolean z_renamed) {
        com.oplus.camera.ui.CommonComponent.ScaleBar scaleBar = this.f_renamed;
        if (scaleBar != null) {
            scaleBar.setTouchable(z_renamed);
        }
    }
}
