package com.oplus.camera.filmvideomode;

/* compiled from: FilmLevelPanel.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.camera.professional.LevelPanel {
    public c_renamed(android.content.Context context, boolean z_renamed, android.os.Handler handler, boolean z2, boolean z3, com.oplus.camera.professional.z_renamed zVar, android.content.SharedPreferences sharedPreferences) throws android.content.res.Resources.NotFoundException {
        super(context, z_renamed, handler, z2, z3, zVar, sharedPreferences);
        if (com.oplus.camera.util.Util.u_renamed()) {
            b_renamed();
        } else {
            a_renamed();
        }
    }

    protected void a_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_margin_landspace);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_slide_bar_margin_bottom);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_slide_bar_margin_end);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_slide_bar_margin_start);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.e_renamed.getLayoutParams();
        layoutParams.removeRule(10);
        layoutParams.removeRule(21);
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        this.e_renamed.setLayoutParams(layoutParams);
        this.e_renamed.setRotation(90.0f);
        this.e_renamed.setTranslationX((-(layoutParams.width - layoutParams.height)) / 2.0f);
        this.e_renamed.setTranslationY((-(layoutParams.width - layoutParams.height)) / 2.0f);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height);
        int marginStart = layoutParams2.getMarginStart();
        if (marginStart < 0) {
            marginStart = 0;
        }
        layoutParams2.setMarginStart(dimensionPixelSize4 + marginStart);
        layoutParams2.setMarginEnd(dimensionPixelSize3);
        this.f_renamed.setLayoutParams(layoutParams2);
        this.f_renamed.setTranslationY(-dimensionPixelSize2);
        this.f_renamed.setHorizontalFadingEdgeEnabled(true);
        int dimensionPixelSize5 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.f5088c.getLayoutParams();
        layoutParams3.removeRule(10);
        layoutParams3.addRule(12);
        layoutParams3.width = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_width);
        layoutParams3.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_height);
        this.f5088c.setLayoutParams(layoutParams3);
        this.f5088c.setGravity(8388629);
        this.f5088c.setRotation(90.0f);
        float f_renamed = dimensionPixelSize;
        float f2 = dimensionPixelSize5;
        float f3 = dimensionPixelSize2;
        this.f5088c.setTranslationY(-(((layoutParams3.width - layoutParams3.height) / 2.0f) + f_renamed + f2 + f3));
        this.f5088c.setTranslationX((layoutParams.height + marginStart) / 2.0f);
        this.f5088c.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_level_panel_text_size));
        if (this.d_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.d_renamed.getLayoutParams();
            layoutParams4.removeRule(10);
            layoutParams4.addRule(12);
            layoutParams4.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_height);
            layoutParams4.width = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_width);
            this.d_renamed.setLayoutParams(layoutParams4);
            this.d_renamed.setGravity(8388629);
            this.d_renamed.setRotation(90.0f);
            this.d_renamed.setTranslationY(-(((layoutParams4.width - layoutParams4.height) / 2.0f) + f_renamed + f2 + f3));
            this.d_renamed.setTranslationX((marginStart + layoutParams.height) / 2.0f);
            this.d_renamed.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_level_panel_text_size));
        }
    }

    protected void b_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_value_text_margin_bottom);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_margin_bottom);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.e_renamed.getLayoutParams();
        com.oplus.camera.screen.d_renamed.a_renamed(this.e_renamed);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_auto_text_margin_bottom);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_auto_text_margin_right);
        this.e_renamed.setLayoutParams(layoutParams);
        this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.auto_button_bg_light);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.f_renamed.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.setMarginStart(0);
        layoutParams2.setMarginEnd(0);
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.f_renamed.setLayoutParams(layoutParams2);
        this.f_renamed.setHorizontalFadingEdgeEnabled(true);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.f5088c.getLayoutParams();
        com.oplus.camera.screen.d_renamed.a_renamed(this.f5088c);
        layoutParams3.addRule(12);
        layoutParams3.addRule(14);
        layoutParams3.width = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_width);
        layoutParams3.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_value_text_height);
        layoutParams3.bottomMargin = dimensionPixelSize;
        this.f5088c.setLayoutParams(layoutParams3);
        this.f5088c.setGravity(81);
        this.f5088c.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.f5088c.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_level_panel_text_size));
        if (this.d_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.d_renamed.getLayoutParams();
            com.oplus.camera.screen.d_renamed.a_renamed(this.d_renamed);
            layoutParams4.addRule(12);
            layoutParams4.addRule(14);
            layoutParams4.width = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.level_panel_text_width);
            layoutParams4.height = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_slide_bar_value_text_height);
            layoutParams4.bottomMargin = layoutParams3.bottomMargin;
            this.d_renamed.setLayoutParams(layoutParams4);
            this.d_renamed.setGravity(81);
            this.d_renamed.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.d_renamed.setTextSize(0, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_level_panel_text_size));
        }
    }

    private boolean b_renamed(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(str)) ? false : true;
    }

    protected java.lang.String getPreferencesKey() {
        return getSubModeBarData().a_renamed();
    }

    protected java.lang.String a_renamed(java.lang.String str) {
        return !this.f5087b.b_renamed().contains(str) ? "" : this.f5087b.c_renamed().get(this.f5087b.b_renamed().indexOf(str));
    }

    @Override // com.oplus.camera.professional.LevelPanel
    public java.lang.String a_renamed(android.content.SharedPreferences sharedPreferences) {
        java.lang.String strD;
        java.lang.String strC;
        java.lang.String strA = this.f5087b.a_renamed();
        java.lang.String string = sharedPreferences.getString(strA, this.f5087b.d_renamed());
        if (!string.equals(this.f5087b.d_renamed()) || com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE.equals(strA)) {
            java.lang.String strA2 = a_renamed(this.f5087b, string);
            if (!"".equals(strA2)) {
                return strA2;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_EXPOSURE.equals(strA)) {
                strD = getDefaultValue();
                strC = a_renamed(this.f5087b, strD);
            } else {
                strD = this.f5087b.d_renamed();
                strC = c_renamed(strA);
            }
            if (this.f5087b.b_renamed() != null && this.f5087b.b_renamed().size() != 0 && b_renamed(strD)) {
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strA, strD);
                editorEdit.apply();
            }
            return strC;
        }
        return c_renamed(strA);
    }

    private java.lang.String c_renamed(java.lang.String str) {
        return f5086a.get(str);
    }
}
