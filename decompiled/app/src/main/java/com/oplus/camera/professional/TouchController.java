package com.oplus.camera.professional;

/* compiled from: MainBarItem.java */
/* loaded from: classes2.dex */
public class l_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f5183a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f5184b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f5185c;
    private final int d_renamed;
    private android.app.Activity e_renamed;
    private com.oplus.camera.ui.RotateLottieAnimationView f_renamed;
    private android.widget.RelativeLayout g_renamed;
    private android.widget.ImageView h_renamed;
    private com.oplus.camera.professional.w_renamed i_renamed;
    private com.oplus.camera.professional.w_renamed j_renamed;
    private int k_renamed;
    private android.view.View l_renamed;
    private int m_renamed;
    private int n_renamed;
    private android.content.res.Resources o_renamed;
    private boolean p_renamed;
    private java.lang.String q_renamed;
    private int r_renamed;
    private com.a_renamed.a_renamed.f_renamed s_renamed;
    private boolean t_renamed;
    private int u_renamed;
    private android.animation.Animator v_renamed;
    private android.animation.Animator w_renamed;

    public l_renamed(android.app.Activity activity, com.oplus.camera.screen.b_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        super(activity);
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.p_renamed = true;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = -1;
        this.v_renamed = null;
        this.w_renamed = null;
        this.e_renamed = activity;
        com.oplus.camera.util.Util.q_renamed(this.e_renamed.getApplicationContext());
        this.o_renamed = this.e_renamed.getApplication().getResources();
        if (1 == (aVar == null ? 0 : aVar.j_renamed())) {
            this.k_renamed = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_image_margin_top);
            f5183a = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_image_margin_top);
            f5184b = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_selector_margin_top);
            this.m_renamed = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_value_text_margin_top);
            dimensionPixelSize = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_background_size);
            dimensionPixelSize2 = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_selector_size);
            this.r_renamed = (this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_width) - dimensionPixelSize2) / 2;
        } else {
            this.k_renamed = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin);
            f5183a = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin_top);
            f5184b = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_frame_image_margin_top);
            this.m_renamed = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_margin_top);
            dimensionPixelSize = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_image_width);
            dimensionPixelSize2 = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_frame_width);
            this.r_renamed = 0;
        }
        this.n_renamed = this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_auto_image_padding);
        this.f5185c = androidx.core.a_renamed.a_renamed.c_renamed(this.e_renamed, com.oplus.camera.R_renamed.color.camera_white);
        this.d_renamed = com.oplus.camera.util.Util.A_renamed(this.e_renamed);
        this.f_renamed = new com.oplus.camera.ui.RotateLottieAnimationView(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        this.f_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_bar_button_bg);
        this.f_renamed.setLayoutParams(layoutParams);
        if (com.oplus.camera.util.Util.t_renamed()) {
            if (aVar != null && aVar.r_renamed() && !aVar.q_renamed()) {
                z_renamed = true;
            }
            this.f_renamed.setLightBackground(z_renamed);
        } else {
            this.f_renamed.setLightBackground(com.oplus.camera.util.Util.H_renamed() == 2);
        }
        addView(this.f_renamed);
        this.i_renamed = new com.oplus.camera.professional.w_renamed(this.e_renamed);
        a_renamed(this.i_renamed);
        addView(this.i_renamed);
        this.l_renamed = new android.view.View(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        this.l_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_mode_bar_item_select_highlight);
        this.l_renamed.setVisibility(4);
        addView(this.l_renamed, layoutParams2);
        this.j_renamed = new com.oplus.camera.professional.w_renamed(this.e_renamed);
        a_renamed(this.j_renamed);
        this.j_renamed.setVisibility(8);
        this.j_renamed.setText(com.oplus.camera.R_renamed.string.camera_professional_disable_title);
        this.j_renamed.setTextColor(getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
        addView(this.j_renamed);
        this.g_renamed = new android.widget.RelativeLayout(this.e_renamed);
        this.h_renamed = new com.oplus.camera.ui.u_renamed(this.e_renamed);
        this.h_renamed.setImageDrawable(com.oplus.camera.util.Util.b_renamed(getContext(), com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_bg));
        this.h_renamed.setImageTintList(android.content.res.ColorStateList.valueOf(androidx.core.a_renamed.a_renamed.c_renamed(this.e_renamed, com.oplus.camera.R_renamed.color.camera_white)));
        this.h_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        this.g_renamed.addView(this.h_renamed);
        android.widget.ImageView imageView = new android.widget.ImageView(this.e_renamed);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width), this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_height));
        layoutParams3.addRule(13);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageResource(com.oplus.camera.R_renamed.drawable.pro_ic_tips_auto_img);
        this.g_renamed.addView(imageView);
        this.g_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width), this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_auto_width)));
        this.g_renamed.setVisibility(8);
        addView(this.g_renamed);
        this.s_renamed = com.oplus.camera.professional.u_renamed.a_renamed();
    }

    private void a_renamed(com.oplus.camera.professional.w_renamed wVar) throws android.content.res.Resources.NotFoundException {
        wVar.setHeight(this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_height));
        wVar.setVerticalDraw(true);
        wVar.setIncludeFontPadding(false);
        wVar.setTextSize(0, this.o_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_value_text_size));
        wVar.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        wVar.setGravity(17);
        wVar.setTextColor(this.f5185c);
        wVar.setShadowLayer(this.o_renamed.getDimension(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_text_shadow_radius), 0.0f, 0.0f, com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
        com.oplus.camera.util.Util.a_renamed((android.widget.TextView) wVar);
    }

    public void a_renamed(boolean z_renamed) {
        this.p_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        android.widget.RelativeLayout relativeLayout;
        if (!this.p_renamed || (relativeLayout = this.g_renamed) == null || i_renamed == relativeLayout.getVisibility()) {
            return;
        }
        if (i_renamed == 0) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.g_renamed, 250, com.oplus.camera.professional.t_renamed.f5227a);
                return;
            } else {
                this.g_renamed.setVisibility(0);
                return;
            }
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.g_renamed, 250, 0, com.oplus.camera.professional.t_renamed.f5227a);
        } else {
            this.g_renamed.setVisibility(8);
        }
    }

    public void setItemTitleImage(final int i_renamed) {
        android.app.Activity activity = this.e_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.l_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.professional.l_renamed.this.f_renamed != null) {
                        com.oplus.camera.professional.l_renamed.this.f_renamed.setImageResource(i_renamed);
                        com.oplus.camera.professional.l_renamed.this.f_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                    }
                }
            });
        }
    }

    public void setItemValueText(java.lang.String str) {
        this.q_renamed = str;
        java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(str);
        if (strA != null && strA.length() < com.oplus.camera.professional.w_renamed.f5278a) {
            this.i_renamed.setVerticalDraw(false);
        }
        this.i_renamed.setText(strA);
        this.i_renamed.setContentDescription(strA);
        this.i_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        int i_renamed = z_renamed ? 500 : 250;
        if (!z2) {
            i_renamed = 0;
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.f_renamed, z_renamed, i_renamed);
    }

    public void setItemAnimation(int i_renamed) {
        com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView = this.f_renamed;
        if (rotateLottieAnimationView != null) {
            rotateLottieAnimationView.setAnimation(i_renamed);
        }
        this.u_renamed = i_renamed;
    }

    private boolean b_renamed() {
        return this.u_renamed > 0;
    }

    public java.lang.String getItemValueText() {
        return this.q_renamed;
    }

    @Override // android.view.View
    public java.lang.Object getTag(int i_renamed) {
        if (com.oplus.camera.R_renamed.id_renamed.touch_area_tag == i_renamed) {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.f_renamed.getDrawingRect(rect);
            rect.offset(this.r_renamed, 0);
            return new android.graphics.Rect(rect.left + this.k_renamed, rect.top + this.k_renamed, rect.right + this.k_renamed, rect.bottom + this.k_renamed);
        }
        return super.getTag(i_renamed);
    }

    @Override // android.view.View
    public void setPressed(boolean z_renamed) {
        boolean zIsPressed = isPressed();
        super.setPressed(z_renamed);
        if (zIsPressed == z_renamed || !hasWindowFocus() || b_renamed()) {
            return;
        }
        b_renamed(z_renamed);
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.Animator animator = this.v_renamed;
        java.lang.Float fValueOf = java.lang.Float.valueOf(1.0f);
        if (animator == null) {
            this.v_renamed = android.animation.ObjectAnimator.ofObject(this.l_renamed, "alpha", new android.animation.FloatEvaluator(), 0, fValueOf);
            this.v_renamed.setDuration(250L);
            this.v_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            this.v_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.l_renamed.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator2) {
                    com.oplus.camera.professional.l_renamed.this.l_renamed.setVisibility(0);
                    com.oplus.camera.professional.l_renamed.this.l_renamed.setAlpha(0.0f);
                }
            });
        } else if (animator.isRunning()) {
            this.v_renamed.cancel();
        }
        android.animation.Animator animator2 = this.w_renamed;
        if (animator2 == null) {
            this.w_renamed = android.animation.ObjectAnimator.ofObject(this.l_renamed, "alpha", new android.animation.FloatEvaluator(), fValueOf, 0);
            this.w_renamed.setDuration(250L);
            this.w_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            this.w_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.l_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator3) {
                    com.oplus.camera.professional.l_renamed.this.l_renamed.setVisibility(0);
                    com.oplus.camera.professional.l_renamed.this.l_renamed.setAlpha(1.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator3) {
                    com.oplus.camera.professional.l_renamed.this.l_renamed.setVisibility(4);
                }
            });
        } else if (animator2.isRunning()) {
            this.w_renamed.cancel();
        }
        if (z_renamed) {
            this.v_renamed.start();
        } else {
            this.w_renamed.start();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int measuredHeight;
        int i5 = i3 - i_renamed;
        com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView = this.f_renamed;
        if (rotateLottieAnimationView != null) {
            int measuredWidth = rotateLottieAnimationView.getMeasuredWidth();
            int measuredHeight2 = this.f_renamed.getMeasuredHeight();
            int i6 = (i5 - measuredWidth) / 2;
            com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView2 = this.f_renamed;
            int i7 = this.k_renamed;
            rotateLottieAnimationView2.layout(i6, i7, measuredWidth + i6, measuredHeight2 + i7);
        }
        com.oplus.camera.professional.w_renamed wVar = this.i_renamed;
        int measuredWidth2 = 0;
        if (wVar != null) {
            measuredWidth2 = wVar.getMeasuredWidth();
            measuredHeight = this.i_renamed.getMeasuredHeight();
            int i8 = (i5 - measuredWidth2) / 2;
            com.oplus.camera.professional.w_renamed wVar2 = this.i_renamed;
            int i9 = this.m_renamed;
            wVar2.layout(i8, i9, i8 + measuredWidth2, i9 + measuredHeight);
        } else {
            measuredHeight = 0;
        }
        android.widget.RelativeLayout relativeLayout = this.g_renamed;
        if (relativeLayout != null) {
            int measuredWidth3 = relativeLayout.getMeasuredWidth();
            int measuredHeight3 = this.g_renamed.getMeasuredHeight();
            int i10 = (((i5 - measuredWidth2) / 2) - this.n_renamed) - measuredWidth3;
            int i11 = this.m_renamed + ((measuredHeight - measuredHeight3) / 2);
            this.g_renamed.layout(i10, i11, measuredWidth3 + i10, measuredHeight3 + i11);
        }
        com.oplus.camera.professional.w_renamed wVar3 = this.j_renamed;
        if (wVar3 != null) {
            int measuredWidth4 = wVar3.getMeasuredWidth();
            int measuredHeight4 = this.j_renamed.getMeasuredHeight();
            int i12 = (i5 - measuredWidth4) / 2;
            com.oplus.camera.professional.w_renamed wVar4 = this.j_renamed;
            int i13 = this.m_renamed;
            wVar4.layout(i12, i13, measuredWidth4 + i12, measuredHeight4 + i13);
        }
        android.view.View view = this.l_renamed;
        if (view != null) {
            int measuredWidth5 = view.getMeasuredWidth();
            int measuredHeight5 = this.l_renamed.getMeasuredHeight();
            int i14 = (i5 - measuredWidth5) / 2;
            android.view.View view2 = this.l_renamed;
            int i15 = f5184b;
            view2.layout(i14, i15, measuredWidth5 + i14, measuredHeight5 + i15);
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
            com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView = this.f_renamed;
            if (rotateLottieAnimationView != null && z_renamed) {
                rotateLottieAnimationView.f_renamed();
                this.f_renamed.setProgress(0.0f);
            }
        } else {
            com.oplus.camera.professional.w_renamed wVar = this.i_renamed;
            if (wVar != null) {
                wVar.setVisibility(z_renamed ? 0 : 4);
            }
            if (this.p_renamed && (relativeLayout = this.g_renamed) != null) {
                relativeLayout.setVisibility(z_renamed ? 0 : 4);
            }
            com.oplus.camera.professional.w_renamed wVar2 = this.j_renamed;
            if (wVar2 != null) {
                wVar2.setVisibility(z_renamed ? 4 : 0);
            }
        }
        com.oplus.camera.professional.u_renamed.a_renamed(this.f_renamed, z_renamed ? 0.3f : 1.0f, z_renamed ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z_renamed) {
        if (this.t_renamed == z_renamed) {
            return;
        }
        this.t_renamed = z_renamed;
        com.oplus.camera.professional.u_renamed.a_renamed(this.f_renamed, this.s_renamed, z_renamed);
        com.oplus.camera.professional.u_renamed.a_renamed(this.l_renamed, this.s_renamed, z_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView;
        if (!b_renamed() || (rotateLottieAnimationView = this.f_renamed) == null) {
            return;
        }
        rotateLottieAnimationView.a_renamed();
    }

    public void setLightBackground(boolean z_renamed) {
        com.oplus.camera.ui.RotateLottieAnimationView rotateLottieAnimationView = this.f_renamed;
        if (rotateLottieAnimationView != null) {
            rotateLottieAnimationView.setLightBackground(z_renamed);
        }
    }
}
