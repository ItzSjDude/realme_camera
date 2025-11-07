package com.oplus.camera.professional;

/* compiled from: HSMainBarItem.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f5128a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5129b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f5130c;
    private android.app.Activity d_renamed;
    private com.airbnb.lottie.LottieAnimationView e_renamed;
    private android.widget.TextView f_renamed;
    private android.widget.ImageView g_renamed;
    private android.widget.RelativeLayout h_renamed;
    private android.widget.LinearLayout i_renamed;
    private android.widget.ImageView j_renamed;
    private com.oplus.camera.professional.w_renamed k_renamed;
    private com.oplus.camera.professional.w_renamed l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private android.content.res.Resources p_renamed;
    private boolean q_renamed;
    private java.lang.String r_renamed;
    private com.a_renamed.a_renamed.f_renamed s_renamed;
    private boolean t_renamed;
    private int u_renamed;

    public f_renamed(android.app.Activity activity, java.lang.Boolean bool) {
        super(activity);
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.q_renamed = true;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = -1;
        this.d_renamed = activity;
        com.oplus.camera.util.Util.q_renamed(this.d_renamed.getApplicationContext());
        this.p_renamed = this.d_renamed.getApplication().getResources();
        f5128a = this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_image_margin_top);
        this.m_renamed = this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_value_text_margin_top);
        this.o_renamed = this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_value_text_interval);
        this.n_renamed = this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_value_auto_image_padding);
        this.f5129b = androidx.core.a_renamed.a_renamed.c_renamed(this.d_renamed, com.oplus.camera.R_renamed.color.camera_white);
        this.f5130c = androidx.core.a_renamed.a_renamed.c_renamed(this.d_renamed, com.oplus.camera.R_renamed.color.camera_Hasu);
        if (bool.booleanValue()) {
            this.e_renamed = new com.oplus.camera.ui.RotateLottieAnimationView(this.d_renamed);
            this.e_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_reset_image_width), this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_reset_image_height)));
            this.e_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_bar_reset_bg);
            this.e_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_mode_ic_reset);
            this.e_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
            addView(this.e_renamed);
            this.k_renamed = new com.oplus.camera.professional.w_renamed(this.d_renamed);
            this.k_renamed.setVisibility(8);
            this.l_renamed = new com.oplus.camera.professional.w_renamed(this.d_renamed);
            this.l_renamed.setVisibility(8);
            this.h_renamed = new android.widget.RelativeLayout(this.d_renamed);
            this.j_renamed = new android.widget.ImageView(this.d_renamed);
            this.h_renamed.addView(this.j_renamed);
            this.h_renamed.setVisibility(8);
            this.h_renamed.addView(new android.widget.ImageView(this.d_renamed));
            this.h_renamed.setVisibility(8);
            this.i_renamed = new android.widget.LinearLayout(this.d_renamed);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.i_renamed.setGravity(17);
            this.i_renamed.setLayoutParams(layoutParams);
        } else {
            this.g_renamed = new android.widget.ImageView(this.d_renamed);
            this.g_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_separate_width), this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_separate_height)));
            this.g_renamed.setBackgroundColor(getResources().getColor(com.oplus.camera.R_renamed.color.pro_separate_line));
            addView(this.g_renamed);
            this.f_renamed = new android.widget.TextView(this.d_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_image_height));
            layoutParams2.addRule(14);
            this.f_renamed.setLayoutParams(layoutParams2);
            this.f_renamed.setTextColor(getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.f_renamed.setTextSize(0, this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_title_text_size));
            addView(this.f_renamed);
            this.k_renamed = new com.oplus.camera.professional.w_renamed(this.d_renamed);
            a_renamed(this.k_renamed);
            this.l_renamed = new com.oplus.camera.professional.w_renamed(this.d_renamed);
            a_renamed(this.l_renamed);
            this.l_renamed.setVisibility(8);
            this.l_renamed.setText(com.oplus.camera.R_renamed.string.camera_professional_disable_title);
            this.l_renamed.setTextColor(getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.h_renamed = new android.widget.RelativeLayout(this.d_renamed);
            this.j_renamed = new android.widget.ImageView(this.d_renamed);
            this.j_renamed.setImageDrawable(com.oplus.camera.util.Util.b_renamed(getContext(), com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_bg));
            this.j_renamed.setImageTintList(android.content.res.ColorStateList.valueOf(androidx.core.a_renamed.a_renamed.c_renamed(this.d_renamed, com.oplus.camera.R_renamed.color.camera_white)));
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(17);
            this.j_renamed.setLayoutParams(layoutParams3);
            this.h_renamed.addView(this.j_renamed);
            android.widget.ImageView imageView = new android.widget.ImageView(this.d_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_auto_width), this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_auto_height));
            layoutParams4.addRule(17);
            imageView.setLayoutParams(layoutParams4);
            imageView.setImageResource(com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_img);
            this.h_renamed.addView(imageView);
            this.h_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_auto_width), this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_auto_width)));
            this.h_renamed.setVisibility(8);
            this.i_renamed = new android.widget.LinearLayout(this.d_renamed);
            android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams5.weight = 1.0f;
            this.i_renamed.setGravity(1);
            this.i_renamed.setLayoutParams(layoutParams5);
        }
        addView(this.l_renamed);
        this.i_renamed.setClipChildren(false);
        this.i_renamed.addView(this.h_renamed);
        this.i_renamed.addView(this.k_renamed);
        addView(this.i_renamed);
        this.s_renamed = com.oplus.camera.professional.u_renamed.a_renamed();
    }

    private void a_renamed(com.oplus.camera.professional.w_renamed wVar) {
        wVar.setHeight(this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_value_text_height));
        wVar.setVerticalDraw(true);
        wVar.setIncludeFontPadding(false);
        wVar.setTextSize(0, this.p_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_value_text_size));
        wVar.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        wVar.setGravity(17);
        wVar.setTextColor(this.f5129b);
    }

    public void a_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        android.widget.RelativeLayout relativeLayout;
        if (!this.q_renamed || (relativeLayout = this.h_renamed) == null || i_renamed == relativeLayout.getVisibility()) {
            return;
        }
        if (i_renamed == 0) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.h_renamed, 250, com.oplus.camera.professional.t_renamed.f5227a);
                return;
            } else {
                this.h_renamed.setVisibility(0);
                return;
            }
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.h_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
        } else {
            this.h_renamed.setVisibility(8);
        }
    }

    public void setItemTitleImage(final java.lang.String str) {
        android.app.Activity activity = this.d_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.f_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.professional.f_renamed.this.f_renamed != null) {
                        com.oplus.camera.professional.f_renamed.this.f_renamed.setText(str);
                        com.oplus.camera.professional.f_renamed.this.f_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                    }
                }
            });
        }
    }

    public void setItemValueText(java.lang.String str) {
        this.r_renamed = str;
        java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(str);
        if (strA != null && strA.length() < com.oplus.camera.professional.w_renamed.f5278a) {
            this.k_renamed.setVerticalDraw(false);
        }
        this.k_renamed.setText(strA);
        this.k_renamed.setContentDescription(strA);
        this.k_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        int i_renamed = z_renamed ? 500 : 250;
        if (!z2) {
            i_renamed = 0;
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.e_renamed, z_renamed, i_renamed);
    }

    public void setItemAnimation(int i_renamed) {
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.e_renamed;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(i_renamed);
        }
        this.u_renamed = i_renamed;
    }

    private boolean b_renamed() {
        return this.u_renamed > 0;
    }

    public java.lang.String getItemValueText() {
        return this.r_renamed;
    }

    @Override // android.view.View
    public void setPressed(boolean z_renamed) {
        boolean zIsPressed = isPressed();
        super.setPressed(z_renamed);
        if (zIsPressed == z_renamed || !hasWindowFocus() || b_renamed()) {
            return;
        }
        int i_renamed = z_renamed ? this.f5129b : this.f5130c;
        int i2 = z_renamed ? this.f5130c : this.f5129b;
        com.oplus.camera.professional.u_renamed.a_renamed(this.e_renamed, i_renamed, i2, 250, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        com.oplus.camera.professional.u_renamed.a_renamed(this.f_renamed, i_renamed, i2, 250, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        com.oplus.camera.professional.u_renamed.a_renamed(this.k_renamed, i_renamed, i2, 250, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        com.oplus.camera.professional.u_renamed.a_renamed(this.j_renamed, i_renamed, i2, 250, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int i5 = i3 - i_renamed;
        int i6 = i4 - i2;
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.e_renamed;
        if (lottieAnimationView != null) {
            int measuredWidth = lottieAnimationView.getMeasuredWidth();
            int measuredHeight = this.e_renamed.getMeasuredHeight();
            int i7 = (i5 - measuredWidth) / 2;
            int i8 = (i6 - measuredHeight) / 2;
            this.e_renamed.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
        }
        android.widget.TextView textView = this.f_renamed;
        if (textView != null) {
            int measuredWidth2 = textView.getMeasuredWidth();
            int measuredHeight2 = this.f_renamed.getMeasuredHeight();
            int i9 = (i5 - measuredWidth2) / 2;
            android.widget.TextView textView2 = this.f_renamed;
            int i10 = f5128a;
            textView2.layout(i9, i10, measuredWidth2 + i9, measuredHeight2 + i10);
        }
        android.widget.LinearLayout linearLayout = this.i_renamed;
        if (linearLayout != null) {
            int measuredWidth3 = linearLayout.getMeasuredWidth();
            com.oplus.camera.professional.w_renamed wVar = this.k_renamed;
            if (wVar != null && this.h_renamed != null) {
                measuredWidth3 = wVar.getMeasuredWidth() + this.h_renamed.getMeasuredWidth() + this.n_renamed;
            }
            int measuredHeight3 = this.i_renamed.getMeasuredHeight();
            int i11 = (i5 - measuredWidth3) / 2;
            android.widget.LinearLayout linearLayout2 = this.i_renamed;
            int i12 = this.m_renamed;
            linearLayout2.layout(i11, i12, measuredWidth3 + i11, measuredHeight3 + i12);
        }
        com.oplus.camera.professional.w_renamed wVar2 = this.l_renamed;
        if (wVar2 != null) {
            int measuredWidth4 = wVar2.getMeasuredWidth();
            int measuredHeight4 = this.l_renamed.getMeasuredHeight();
            int i13 = (i5 - measuredWidth4) / 2;
            com.oplus.camera.professional.w_renamed wVar3 = this.l_renamed;
            int i14 = this.m_renamed;
            wVar3.layout(i13, i14, measuredWidth4 + i13, measuredHeight4 + i14);
        }
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            int measuredWidth5 = imageView.getMeasuredWidth();
            int measuredHeight5 = this.g_renamed.getMeasuredHeight();
            int i15 = (i6 - measuredHeight5) / 2;
            this.g_renamed.layout(0, i15, measuredWidth5, measuredHeight5 + i15);
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        android.widget.RelativeLayout relativeLayout;
        boolean zIsEnabled = isEnabled();
        super.setEnabled(z_renamed);
        if (zIsEnabled == z_renamed) {
            return;
        }
        if (b_renamed()) {
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.e_renamed;
            if (lottieAnimationView != null && z_renamed) {
                lottieAnimationView.f_renamed();
                this.e_renamed.setProgress(0.0f);
            }
        } else {
            com.oplus.camera.professional.w_renamed wVar = this.k_renamed;
            if (wVar != null) {
                wVar.setVisibility(z_renamed ? 0 : 4);
            }
            if (this.q_renamed && (relativeLayout = this.h_renamed) != null) {
                relativeLayout.setVisibility(z_renamed ? 0 : 4);
            }
            com.oplus.camera.professional.w_renamed wVar2 = this.l_renamed;
            if (wVar2 != null) {
                wVar2.setVisibility(z_renamed ? 4 : 0);
            }
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.e_renamed, z_renamed ? 0.3f : 1.0f, z_renamed ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z_renamed) {
        if (this.t_renamed == z_renamed) {
            return;
        }
        this.t_renamed = z_renamed;
        com.oplus.camera.professional.u_renamed.a_renamed(this.e_renamed, this.s_renamed, z_renamed);
        com.oplus.camera.professional.u_renamed.a_renamed(this.f_renamed, this.s_renamed, z_renamed);
    }

    public void a_renamed() {
        com.airbnb.lottie.LottieAnimationView lottieAnimationView;
        if (!b_renamed() || (lottieAnimationView = this.e_renamed) == null) {
            return;
        }
        lottieAnimationView.a_renamed();
    }
}
