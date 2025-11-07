package com.oplus.camera.filmvideomode;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.professional.SubModeBarData;
import com.oplus.camera.professional.LevelPanel;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.util.Util;

/* compiled from: FilmLevelPanel.java */
/* renamed from: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FilmLevelPanel extends LevelPanel {
    public FilmLevelPanel(Context context, boolean z, Handler handler, boolean z2, boolean z3, SubModeBarData c2908z, SharedPreferences sharedPreferences) throws Resources.NotFoundException {
        super(context, z, handler, z2, z3, c2908z, sharedPreferences);
        if (Util.m24498u()) {
            m13488b();
        } else {
            m13487a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13487a() throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.level_panel_text_margin_landspace);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_slide_bar_margin_bottom);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.movie_mode_params_slide_bar_margin_end);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.movie_mode_params_slide_bar_margin_start);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15340e.getLayoutParams();
        layoutParams.removeRule(10);
        layoutParams.removeRule(21);
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        this.f15340e.setLayoutParams(layoutParams);
        this.f15340e.setRotation(90.0f);
        this.f15340e.setTranslationX((-(layoutParams.width - layoutParams.height)) / 2.0f);
        this.f15340e.setTranslationY((-(layoutParams.width - layoutParams.height)) / 2.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f15341f.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        int marginStart = layoutParams2.getMarginStart();
        if (marginStart < 0) {
            marginStart = 0;
        }
        layoutParams2.setMarginStart(dimensionPixelSize4 + marginStart);
        layoutParams2.setMarginEnd(dimensionPixelSize3);
        this.f15341f.setLayoutParams(layoutParams2);
        this.f15341f.setTranslationY(-dimensionPixelSize2);
        this.f15341f.setHorizontalFadingEdgeEnabled(true);
        int dimensionPixelSize5 = getResources().getDimensionPixelSize(R.dimen.professional_mode_scale_bar_scale_height);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f15338c.getLayoutParams();
        layoutParams3.removeRule(10);
        layoutParams3.addRule(12);
        layoutParams3.width = getResources().getDimensionPixelSize(R.dimen.level_panel_text_width);
        layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.level_panel_text_height);
        this.f15338c.setLayoutParams(layoutParams3);
        this.f15338c.setGravity(8388629);
        this.f15338c.setRotation(90.0f);
        float COUIBaseListPopupWindow_12 = dimensionPixelSize;
        float f2 = dimensionPixelSize5;
        float f3 = dimensionPixelSize2;
        this.f15338c.setTranslationY(-(((layoutParams3.width - layoutParams3.height) / 2.0f) + COUIBaseListPopupWindow_12 + f2 + f3));
        this.f15338c.setTranslationX((layoutParams.height + marginStart) / 2.0f);
        this.f15338c.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.film_level_panel_text_size));
        if (this.f15339d != null) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f15339d.getLayoutParams();
            layoutParams4.removeRule(10);
            layoutParams4.addRule(12);
            layoutParams4.height = getResources().getDimensionPixelSize(R.dimen.level_panel_text_height);
            layoutParams4.width = getResources().getDimensionPixelSize(R.dimen.level_panel_text_width);
            this.f15339d.setLayoutParams(layoutParams4);
            this.f15339d.setGravity(8388629);
            this.f15339d.setRotation(90.0f);
            this.f15339d.setTranslationY(-(((layoutParams4.width - layoutParams4.height) / 2.0f) + COUIBaseListPopupWindow_12 + f2 + f3));
            this.f15339d.setTranslationX((marginStart + layoutParams.height) / 2.0f);
            this.f15339d.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.film_level_panel_text_size));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m13488b() throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_value_text_margin_bottom);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_margin_bottom);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15340e.getLayoutParams();
        LayoutUtil.m16634a(this.f15340e);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_auto_text_margin_bottom);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_auto_text_margin_right);
        this.f15340e.setLayoutParams(layoutParams);
        this.f15340e.setBackgroundResource(R.drawable.auto_button_bg_light);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f15341f.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.setMarginStart(0);
        layoutParams2.setMarginEnd(0);
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.f15341f.setLayoutParams(layoutParams2);
        this.f15341f.setHorizontalFadingEdgeEnabled(true);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f15338c.getLayoutParams();
        LayoutUtil.m16634a(this.f15338c);
        layoutParams3.addRule(12);
        layoutParams3.addRule(14);
        layoutParams3.width = getResources().getDimensionPixelSize(R.dimen.level_panel_text_width);
        layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_value_text_height);
        layoutParams3.bottomMargin = dimensionPixelSize;
        this.f15338c.setLayoutParams(layoutParams3);
        this.f15338c.setGravity(81);
        this.f15338c.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.f15338c.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.film_level_panel_text_size));
        if (this.f15339d != null) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f15339d.getLayoutParams();
            LayoutUtil.m16634a(this.f15339d);
            layoutParams4.addRule(12);
            layoutParams4.addRule(14);
            layoutParams4.width = getResources().getDimensionPixelSize(R.dimen.level_panel_text_width);
            layoutParams4.height = getResources().getDimensionPixelSize(R.dimen.fold_opened_movie_mode_slide_bar_value_text_height);
            layoutParams4.bottomMargin = layoutParams3.bottomMargin;
            this.f15339d.setLayoutParams(layoutParams4);
            this.f15339d.setGravity(81);
            this.f15339d.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.f15339d.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.film_level_panel_text_size));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m13483b(String str) {
        return (TextUtils.isEmpty(str) || getResources().getString(R.string.camera_exposure_time_default_value).equals(str)) ? false : true;
    }

    protected String getPreferencesKey() {
        return getSubModeBarData().m16142a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected String m13486a(String str) {
        return !this.f15337b.m16145b().contains(str) ? "" : this.f15337b.m16147c().get(this.f15337b.m16145b().indexOf(str));
    }

    @Override // com.oplus.camera.professional.LevelPanel
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo13485a(SharedPreferences sharedPreferences) {
        String strM16149d;
        String strM13484c;
        String strM16142a = this.f15337b.m16142a();
        String string = sharedPreferences.getString(strM16142a, this.f15337b.m16149d());
        if (!string.equals(this.f15337b.m16149d()) || CameraUIInterface.KEY_FILM_MODE_EXPOSURE.equals(strM16142a)) {
            String strA = m15354a(this.f15337b, string);
            if (!"".equals(strA)) {
                return strA;
            }
            if (CameraUIInterface.KEY_FILM_MODE_EXPOSURE.equals(strM16142a)) {
                strM16149d = getDefaultValue();
                strM13484c = m15354a(this.f15337b, strM16149d);
            } else {
                strM16149d = this.f15337b.m16149d();
                strM13484c = m13484c(strM16142a);
            }
            if (this.f15337b.m16145b() != null && this.f15337b.m16145b().size() != 0 && m13483b(strM16149d)) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(strM16142a, strM16149d);
                editorEdit.apply();
            }
            return strM13484c;
        }
        return m13484c(strM16142a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String m13484c(String str) {
        return f15336a.get(str);
    }
}
