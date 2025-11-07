package com.oplus.camera.filmvideomode;

/* compiled from: FilmMainBarItem.java */
/* loaded from: classes2.dex */
public class d_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4478a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4479b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.RelativeLayout f4480c;
    private int d_renamed;
    private android.app.Activity e_renamed;
    private com.oplus.camera.ui.RotateLottieAnimationView f_renamed;
    private com.airbnb.lottie.LottieAnimationView g_renamed;
    private android.widget.ImageView h_renamed;
    private com.oplus.camera.professional.w_renamed i_renamed;
    private com.oplus.camera.professional.w_renamed j_renamed;
    private android.widget.ImageView k_renamed;
    private int l_renamed;
    private int m_renamed;
    private android.content.res.Resources n_renamed;
    private boolean o_renamed;
    private java.lang.String p_renamed;
    private com.a_renamed.a_renamed.f_renamed q_renamed;
    private boolean r_renamed;
    private int s_renamed;
    private int t_renamed;
    private boolean u_renamed;

    public d_renamed(android.app.Activity activity) {
        super(activity);
        this.f4478a = 0;
        this.f4479b = 0;
        this.f4480c = null;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = null;
        this.o_renamed = true;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = false;
        this.s_renamed = -1;
        this.t_renamed = -1;
        this.u_renamed = false;
        this.e_renamed = activity;
        com.oplus.camera.util.Util.q_renamed(this.e_renamed.getApplicationContext());
        this.n_renamed = this.e_renamed.getApplication().getResources();
        this.d_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin_top);
        this.l_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_margin_top);
        this.m_renamed = this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_auto_image_padding);
        this.f4478a = androidx.core.a_renamed.a_renamed.c_renamed(this.e_renamed, com.oplus.camera.R_renamed.color.camera_white);
        this.f4479b = com.oplus.camera.util.Util.A_renamed(this.e_renamed);
        this.f_renamed = new com.oplus.camera.ui.RotateLottieAnimationView(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_params_item_bg_width), this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.film_params_item_bg_height));
        this.f_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.film_params_item_bg_selected);
        this.f_renamed.setLayoutParams(layoutParams);
        this.f_renamed.setAlpha(0.0f);
        addView(this.f_renamed);
        this.g_renamed = new com.oplus.camera.ui.RotateLottieAnimationView(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_image_width), this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_image_height));
        this.g_renamed.setBackgroundResource(com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.R_renamed.drawable.common_button_bg_light : com.oplus.camera.R_renamed.drawable.common_button_bg);
        this.g_renamed.setLayoutParams(layoutParams2);
        addView(this.g_renamed);
        this.i_renamed = new com.oplus.camera.professional.w_renamed(this.e_renamed);
        a_renamed(this.i_renamed);
        addView(this.i_renamed);
        this.j_renamed = new com.oplus.camera.professional.w_renamed(this.e_renamed);
        a_renamed(this.j_renamed);
        this.j_renamed.setVisibility(8);
        this.j_renamed.setText(com.oplus.camera.R_renamed.string.camera_professional_disable_title);
        this.j_renamed.setAlpha(0.3f);
        addView(this.j_renamed);
        this.f4480c = new android.widget.RelativeLayout(this.e_renamed);
        this.h_renamed = new android.widget.ImageView(this.e_renamed);
        this.h_renamed.setImageDrawable(com.oplus.camera.util.Util.b_renamed(getContext(), com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_bg));
        this.h_renamed.setImageTintList(android.content.res.ColorStateList.valueOf(androidx.core.a_renamed.a_renamed.c_renamed(this.e_renamed, com.oplus.camera.R_renamed.color.camera_white)));
        this.h_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        this.f4480c.addView(this.h_renamed);
        this.k_renamed = new android.widget.ImageView(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width), this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_height));
        layoutParams3.addRule(13);
        this.k_renamed.setLayoutParams(layoutParams3);
        this.k_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_img);
        this.f4480c.addView(this.k_renamed);
        this.f4480c.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width), this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width)));
        this.f4480c.setVisibility(0);
        addView(this.f4480c);
        this.q_renamed = com.oplus.camera.professional.u_renamed.a_renamed();
        this.d_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin_top_rotated);
        this.l_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_margin_top_rotated);
        if (com.oplus.camera.util.Util.u_renamed()) {
            this.l_renamed += this.d_renamed;
        }
    }

    private void a_renamed(com.oplus.camera.professional.w_renamed wVar) {
        wVar.setHeight(this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_height));
        wVar.setVerticalDraw(true);
        wVar.setIncludeFontPadding(false);
        wVar.setTextSize(0, this.n_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_size));
        wVar.setGravity(17);
        wVar.setTextColor(this.f4478a);
        wVar.setShadowLayer(this.n_renamed.getDimension(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_text_shadow_radius), 0.0f, 0.0f, com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
    }

    public void a_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (this.o_renamed) {
            com.oplus.camera.e_renamed.b_renamed("FilmMainBarItem", "setItemAutoVisibility, visibility: " + i_renamed + ", item: " + ((java.lang.Object) this.i_renamed.getText()));
            android.widget.ImageView imageView = this.h_renamed;
            if (imageView == null || this.k_renamed == null || i_renamed == imageView.getVisibility()) {
                return;
            }
            if (i_renamed == 0) {
                if (z_renamed) {
                    com.oplus.camera.util.Util.a_renamed(this.h_renamed, 250, com.oplus.camera.professional.t_renamed.f5227a);
                    com.oplus.camera.util.Util.a_renamed(this.k_renamed, 250, com.oplus.camera.professional.t_renamed.f5227a);
                    return;
                } else {
                    this.h_renamed.setVisibility(0);
                    this.k_renamed.setVisibility(0);
                    return;
                }
            }
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.h_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
                com.oplus.camera.util.Util.a_renamed(this.k_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
            } else {
                this.h_renamed.setVisibility(8);
                this.k_renamed.setVisibility(8);
            }
        }
    }

    public void setItemIndex(int i_renamed) {
        this.u_renamed = this.t_renamed != i_renamed;
        this.t_renamed = i_renamed;
    }

    public void setItemTitleImage(final int i_renamed) {
        android.app.Activity activity = this.e_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.d_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.filmvideomode.d_renamed.this.g_renamed != null) {
                        com.oplus.camera.filmvideomode.d_renamed.this.g_renamed.setImageResource(i_renamed);
                        com.oplus.camera.filmvideomode.d_renamed.this.g_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                    }
                }
            });
        }
    }

    public void setItemValueText(java.lang.String str) {
        if (!isEnabled() && 4 == this.t_renamed) {
            str = this.e_renamed.getString(com.oplus.camera.R_renamed.string.camera_professional_disable_title);
        }
        this.p_renamed = str;
        java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(str);
        if (strA != null && strA.length() < com.oplus.camera.professional.w_renamed.f5278a) {
            this.i_renamed.setVerticalDraw(false);
        }
        this.i_renamed.setText(strA);
        this.i_renamed.setContentDescription(strA);
        this.i_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    public void setItemAnimation(int i_renamed) {
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.g_renamed;
        if (lottieAnimationView != null && -1 != i_renamed) {
            lottieAnimationView.setAnimation(i_renamed);
        }
        this.s_renamed = i_renamed;
    }

    private boolean a_renamed() {
        return this.s_renamed > 0;
    }

    public java.lang.String getItemValueText() {
        return this.p_renamed;
    }

    @Override // android.view.View
    public void setSelected(boolean z_renamed) {
        a_renamed(z_renamed, false);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (a_renamed()) {
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.g_renamed;
            if (lottieAnimationView != null && z_renamed) {
                lottieAnimationView.a_renamed();
            }
            this.f_renamed.setAlpha(0.0f);
            return;
        }
        boolean zIsSelected = isSelected();
        super.setSelected(z_renamed);
        com.oplus.camera.e_renamed.b_renamed("FilmMainBarItem", "setSelected, selected: " + z_renamed + ", bPressed: " + zIsSelected + ", animation: " + z2);
        if (zIsSelected == z_renamed) {
            return;
        }
        this.f_renamed.animate().cancel();
        if (z2) {
            this.f_renamed.animate().alpha(z_renamed ? 1.0f : 0.0f).setInterpolator(com.oplus.camera.professional.t_renamed.f5227a).setDuration(250L).start();
        } else {
            this.f_renamed.setAlpha(z_renamed ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int measuredHeight;
        int i5 = i3 - i_renamed;
        com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView = this.f_renamed;
        int measuredWidth = 0;
        if (rotateLottieAnimationView != null) {
            int measuredWidth2 = rotateLottieAnimationView.getMeasuredWidth();
            int i6 = (i5 - measuredWidth2) / 2;
            this.f_renamed.layout(i6, 0, measuredWidth2 + i6, this.f_renamed.getMeasuredHeight());
        }
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.g_renamed;
        if (lottieAnimationView != null) {
            int measuredWidth3 = lottieAnimationView.getMeasuredWidth();
            int measuredHeight2 = this.g_renamed.getMeasuredHeight();
            int i7 = (i5 - measuredWidth3) / 2;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView2 = this.g_renamed;
            int i8 = this.d_renamed;
            lottieAnimationView2.layout(i7, i8, measuredWidth3 + i7, measuredHeight2 + i8);
        }
        com.oplus.camera.professional.w_renamed wVar = this.i_renamed;
        if (wVar != null) {
            measuredWidth = wVar.getMeasuredWidth();
            measuredHeight = this.i_renamed.getMeasuredHeight();
            int i9 = (i5 - measuredWidth) / 2;
            com.oplus.camera.professional.w_renamed wVar2 = this.i_renamed;
            int i10 = this.l_renamed;
            wVar2.layout(i9, i10, i9 + measuredWidth, i10 + measuredHeight);
        } else {
            measuredHeight = 0;
        }
        android.widget.RelativeLayout relativeLayout = this.f4480c;
        if (relativeLayout != null) {
            int measuredWidth4 = relativeLayout.getMeasuredWidth();
            int measuredHeight3 = this.f4480c.getMeasuredHeight();
            int i11 = (((i5 - measuredWidth) / 2) - this.m_renamed) - measuredWidth4;
            int i12 = this.l_renamed + ((measuredHeight - measuredHeight3) / 2);
            this.f4480c.layout(i11, i12, measuredWidth4 + i11, measuredHeight3 + i12);
        }
        com.oplus.camera.professional.w_renamed wVar3 = this.j_renamed;
        if (wVar3 != null) {
            int measuredWidth5 = wVar3.getMeasuredWidth();
            int measuredHeight4 = this.j_renamed.getMeasuredHeight();
            int i13 = (i5 - measuredWidth5) / 2;
            com.oplus.camera.professional.w_renamed wVar4 = this.j_renamed;
            int i14 = this.l_renamed;
            wVar4.layout(i13, i14, measuredWidth5 + i13, measuredHeight4 + i14);
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        android.widget.RelativeLayout relativeLayout;
        int i_renamed;
        com.oplus.camera.e_renamed.b_renamed("FilmMainBarItem", "setEnabled, enabled: " + z_renamed + ", isEnable: " + isEnabled() + ", mDataChanged: " + this.u_renamed);
        boolean zIsEnabled = isEnabled();
        super.setEnabled(z_renamed);
        if (zIsEnabled == z_renamed) {
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.g_renamed;
            if (lottieAnimationView == null || lottieAnimationView.d_renamed()) {
                return;
            }
            this.g_renamed.f_renamed();
            this.g_renamed.setProgress(0.0f);
            this.g_renamed.refreshDrawableState();
            this.g_renamed.invalidate();
            return;
        }
        if (!z_renamed && (4 == (i_renamed = this.t_renamed) || 3 == i_renamed)) {
            this.i_renamed.setText(this.e_renamed.getString(com.oplus.camera.R_renamed.string.camera_professional_disable_title));
        } else {
            this.i_renamed.setText(this.p_renamed);
        }
        if (a_renamed()) {
            com.airbnb.lottie.LottieAnimationView lottieAnimationView2 = this.g_renamed;
            if (lottieAnimationView2 != null && z_renamed) {
                lottieAnimationView2.f_renamed();
                this.g_renamed.setProgress(0.0f);
            }
        } else {
            if (this.o_renamed && (relativeLayout = this.f4480c) != null) {
                relativeLayout.setVisibility(z_renamed ? 0 : 4);
            }
            this.i_renamed.setAlpha(z_renamed ? 1.0f : 0.3f);
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.g_renamed, z_renamed ? 0.3f : 1.0f, z_renamed ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z_renamed) {
        if (this.r_renamed == z_renamed) {
            return;
        }
        this.r_renamed = z_renamed;
        if (a_renamed()) {
            return;
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.g_renamed, this.q_renamed, z_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.oplus.camera.e_renamed.b_renamed("FilmMainBarItem", "onAttachedToWindow, view: " + this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.oplus.camera.e_renamed.b_renamed("FilmMainBarItem", "onDetachedFromWindow, view: " + this);
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.g_renamed;
        if (lottieAnimationView != null) {
            lottieAnimationView.clearAnimation();
        }
    }
}
