package com.oplus.camera.filmvideomode;

/* compiled from: FilmAnimatorUtil.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f4471a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static android.animation.ValueAnimator.AnimatorUpdateListener f4472b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.List<android.animation.AnimatorSet> f4473c = new java.util.concurrent.CopyOnWriteArrayList();

    public static void a_renamed() {
        for (android.animation.AnimatorSet animatorSet : f4473c) {
            if (animatorSet.isStarted() || animatorSet.isRunning()) {
                com.oplus.camera.e_renamed.b_renamed("FilmAnimatorUtil", "cancel alphaAndTranslation animation");
                animatorSet.cancel();
            }
        }
        f4473c.clear();
    }

    private static void b_renamed(android.animation.AnimatorSet animatorSet) {
        if (animatorSet == null || f4473c.contains(animatorSet)) {
            return;
        }
        f4473c.add(animatorSet);
    }

    public static boolean b_renamed() {
        return f4471a;
    }

    public static void a_renamed(boolean z_renamed) {
        f4471a = z_renamed;
    }

    public static void a_renamed(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        f4472b = animatorUpdateListener;
    }

    public static void a_renamed(final android.view.View view, int i_renamed, boolean z_renamed, int i2, boolean z2) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.Drawable background;
        if (view != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.R_renamed.dimen.fold_opened_movie_mode_menu_item_distance : com.oplus.camera.R_renamed.dimen.movie_mode_menu_item_move_x);
            if (i2 < 5) {
                dimensionPixelSize = view.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_item_move_20x);
            }
            final boolean z3 = view.getVisibility() == 0;
            int i3 = z3 ? dimensionPixelSize * i_renamed : 0;
            boolean z4 = 3 == i_renamed || 4 == i_renamed;
            if (com.oplus.camera.util.Util.g_renamed() == 0 && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) && z4) {
                i3 -= dimensionPixelSize;
            }
            final android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            if (z2) {
                animatorSet.setDuration(0L);
            } else {
                animatorSet.setDuration(200L);
            }
            animatorSet.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(view.getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator));
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(view, "translationX", i3));
            if (i_renamed != 0 && !z2) {
                float f_renamed = view.isEnabled() ? 1.0f : 0.5f;
                float[] fArr = new float[2];
                fArr[0] = z3 ? 0.0f : f_renamed;
                if (!z3) {
                    f_renamed = 0.0f;
                }
                fArr[1] = f_renamed;
                animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(view, "alpha", fArr));
            }
            if (i_renamed == 0 && !z2 && (background = view.getBackground()) != null) {
                background.setAlpha(255);
            }
            animatorSet.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.b_renamed.1
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (!z3) {
                        view.setVisibility(0);
                    }
                    view.setTag(true);
                }

                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (!z3) {
                        view.setVisibility(8);
                    } else if (com.oplus.camera.util.Util.u_renamed()) {
                        view.setVisibility(0);
                    }
                    view.setTag(false);
                    com.oplus.camera.filmvideomode.b_renamed.c_renamed(animatorSet);
                }

                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if (!z3) {
                        view.setVisibility(8);
                    } else if (com.oplus.camera.util.Util.u_renamed()) {
                        view.setVisibility(0);
                    }
                    view.setTag(false);
                    com.oplus.camera.filmvideomode.b_renamed.c_renamed(animatorSet);
                }
            });
            b_renamed(animatorSet);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c_renamed(android.animation.AnimatorSet animatorSet) {
        if (animatorSet == null) {
            return;
        }
        f4473c.remove(animatorSet);
    }

    public static void a_renamed(com.oplus.camera.filmvideomode.k_renamed kVar, android.view.View view) {
        if (kVar != null) {
            int dimensionPixelSize = kVar.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_item_move_x);
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(kVar, "alpha", 0.0f, 1.0f), android.animation.ObjectAnimator.ofFloat(view, "translationX", dimensionPixelSize, 0.0f), android.animation.ObjectAnimator.ofFloat(kVar, "scaleX", 0.9f, 1.0f));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(kVar.getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator));
            animatorSet.start();
        }
    }

    public static void b_renamed(final com.oplus.camera.filmvideomode.k_renamed kVar, android.view.View view) {
        if (kVar != null) {
            int dimensionPixelSize = kVar.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_item_move_x);
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(kVar, "alpha", 1.0f, 0.0f), android.animation.ObjectAnimator.ofFloat(view, "translationX", 0.0f, dimensionPixelSize), android.animation.ObjectAnimator.ofFloat(kVar, "scaleX", 1.0f, 0.9f));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(kVar.getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator));
            animatorSet.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.filmvideomode.b_renamed.2
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    kVar.setVisibility(8);
                }

                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    kVar.setVisibility(8);
                }
            });
            animatorSet.start();
        }
    }

    public static void a_renamed(final android.view.ViewGroup viewGroup, com.oplus.camera.ui.control.ShutterButton shutterButton, final com.oplus.camera.ui.control.ThumbImageView thumbImageView, final android.widget.RelativeLayout relativeLayout, final com.oplus.camera.ui.modepanel.p_renamed pVar, final com.oplus.camera.ui.control.ShutterButton shutterButton2, final android.view.View view, final android.view.View view2, final android.view.View view3) throws android.content.res.Resources.NotFoundException {
        float f_renamed;
        android.view.animation.Interpolator interpolatorLoadInterpolator = android.view.animation.AnimationUtils.loadInterpolator(viewGroup.getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator);
        android.view.animation.Interpolator interpolatorLoadInterpolator2 = android.view.animation.AnimationUtils.loadInterpolator(viewGroup.getContext(), com.oplus.camera.R_renamed.anim.movie_enter_exit_path_interpolator);
        if (shutterButton != null) {
            float fA_renamed = 0.0f;
            if (com.oplus.camera.util.Util.u_renamed()) {
                f_renamed = 0.0f;
            } else {
                fA_renamed = a_renamed(shutterButton.getResources());
                f_renamed = -shutterButton.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_shutter_move_x);
            }
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.setDuration(440L);
            animatorSet.setInterpolator(interpolatorLoadInterpolator);
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(shutterButton, "translationX", f_renamed), android.animation.ObjectAnimator.ofFloat(shutterButton, "translationY", fA_renamed));
            animatorSet.start();
            if (pVar != null) {
                android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(255, 0).setDuration(80L);
                duration.setInterpolator(interpolatorLoadInterpolator);
                duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$-eYkpBtvA5jPYsG_6g7JERDDMoY
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        com.oplus.camera.filmvideomode.b_renamed.a_renamed(pVar, valueAnimator);
                    }
                });
                android.animation.ValueAnimator duration2 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
                duration2.setInterpolator(interpolatorLoadInterpolator2);
                final android.animation.ValueAnimator duration3 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(180L);
                duration3.setInterpolator(interpolatorLoadInterpolator2);
                duration2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$aUquX6hr7AXzK_wkNrzj_4WngF4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        com.oplus.camera.filmvideomode.b_renamed.a_renamed(pVar, thumbImageView, shutterButton2, duration3, view, view2, view3, viewGroup, relativeLayout, valueAnimator);
                    }
                });
                duration3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$6Tp2IIjwyT71_XpOZCr9IXf0dd0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        com.oplus.camera.filmvideomode.b_renamed.a_renamed(view, view2, view3, thumbImageView, valueAnimator);
                    }
                });
                duration2.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.modepanel.p_renamed pVar, android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        pVar.e_renamed(iIntValue);
        if (iIntValue == 0) {
            pVar.e_renamed(255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.modepanel.p_renamed pVar, com.oplus.camera.ui.control.ThumbImageView thumbImageView, com.oplus.camera.ui.control.ShutterButton shutterButton, android.animation.ValueAnimator valueAnimator, android.view.View view, android.view.View view2, android.view.View view3, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.animation.ValueAnimator valueAnimator2) {
        a_renamed(((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue(), pVar, thumbImageView, shutterButton, valueAnimator, view, view2, view3, viewGroup, relativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view, android.view.View view2, android.view.View view3, com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        a_renamed(view, fFloatValue);
        a_renamed(view2, fFloatValue);
        a_renamed(view3, fFloatValue);
        if (com.oplus.camera.util.Util.u_renamed()) {
            return;
        }
        a_renamed(thumbImageView, fFloatValue);
    }

    public static int a_renamed(android.content.res.Resources resources) throws android.content.res.Resources.NotFoundException {
        int iO = com.oplus.camera.util.Util.O_renamed();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_top) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_shutter_button_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_bottom) + com.oplus.camera.util.Util.aG_renamed();
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height);
        int screenHeight = (com.oplus.camera.util.Util.getScreenHeight() - iO) + dimensionPixelSize + (dimensionPixelSize2 / 2);
        int screenHeight2 = (com.oplus.camera.util.Util.getScreenHeight() - dimensionPixelSize3) - (dimensionPixelSize4 / 2);
        com.oplus.camera.e_renamed.b_renamed("FilmAnimatorUtil", "getMovieShutterMoveDistance, navbar height: " + com.oplus.camera.util.Util.aG_renamed() + ", screeny: " + com.oplus.camera.util.Util.getScreenHeight() + ", without nav: " + com.oplus.camera.util.Util.U_renamed() + ", shutterCenterY: " + screenHeight + ", movieParamsCenterY: " + screenHeight2 + ", movieParamsMarginBottom: " + dimensionPixelSize3 + ", panelHeight: " + iO);
        return screenHeight2 - screenHeight;
    }

    private static void a_renamed(float f_renamed, com.oplus.camera.ui.modepanel.p_renamed pVar, com.oplus.camera.ui.control.ThumbImageView thumbImageView, com.oplus.camera.ui.control.ShutterButton shutterButton, android.animation.ValueAnimator valueAnimator, android.view.View view, android.view.View view2, android.view.View view3, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout) {
        pVar.a_renamed(f_renamed);
        shutterButton.setAlpha(f_renamed);
        if (!com.oplus.camera.util.Util.u_renamed()) {
            thumbImageView.setAlpha(f_renamed);
        }
        if (0.0f == f_renamed) {
            viewGroup.setLayoutDirection(0);
            pVar.b_renamed(false);
            pVar.a_renamed(1.0f);
            valueAnimator.start();
            a_renamed(view, com.oplus.camera.util.Util.u_renamed() ? 4 : 0);
            a_renamed(view2, 0);
            a_renamed(view3, 0);
            a_renamed((android.view.View) shutterButton, 8);
            a_renamed((android.view.View) shutterButton, 1.0f);
            if (com.oplus.camera.util.Util.u_renamed()) {
                return;
            }
            a_renamed(viewGroup, thumbImageView, relativeLayout);
        }
    }

    private static void a_renamed(android.view.ViewGroup viewGroup, com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.widget.RelativeLayout relativeLayout) {
        if (viewGroup.indexOfChild(thumbImageView) < 0) {
            relativeLayout.removeView(thumbImageView);
            viewGroup.addView(thumbImageView);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = thumbImageView.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_width);
            layoutParams.height = thumbImageView.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_height);
            layoutParams.topMargin = viewGroup.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_top);
            layoutParams.leftMargin = viewGroup.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_thumbnail_left);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR)) {
                layoutParams.topMargin += thumbImageView.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
            }
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            thumbImageView.setLayoutParams(layoutParams);
            thumbImageView.setPadding(0, 0, 0, 0);
            thumbImageView.a_renamed(thumbImageView.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_thumbnail_round_corner_radius), true, 0);
            thumbImageView.setRotation(90.0f);
        }
    }

    public static void a_renamed(final android.view.ViewGroup viewGroup, com.oplus.camera.ui.control.ShutterButton shutterButton, final com.oplus.camera.ui.control.ThumbImageView thumbImageView, final android.widget.RelativeLayout relativeLayout, final android.view.View view, final android.view.View view2, final android.view.View view3, final int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.view.animation.Interpolator interpolatorLoadInterpolator = android.view.animation.AnimationUtils.loadInterpolator(viewGroup.getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator);
        android.view.animation.Interpolator interpolatorLoadInterpolator2 = android.view.animation.AnimationUtils.loadInterpolator(viewGroup.getContext(), com.oplus.camera.R_renamed.anim.movie_enter_exit_path_interpolator);
        if (shutterButton != null) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.setDuration(440L);
            animatorSet.setInterpolator(interpolatorLoadInterpolator);
            float f_renamed = 0;
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(shutterButton, "translationX", f_renamed), android.animation.ObjectAnimator.ofFloat(shutterButton, "translationY", f_renamed));
            animatorSet.start();
        }
        if (relativeLayout.indexOfChild(thumbImageView) < 0 && thumbImageView != null) {
            final android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(180L);
            duration.setInterpolator(interpolatorLoadInterpolator2);
            android.animation.ValueAnimator duration2 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
            duration.setInterpolator(interpolatorLoadInterpolator2);
            duration2.setInterpolator(interpolatorLoadInterpolator2);
            duration2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$tc_a1G7pNG4JfHn9RlerYqzLmSg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.filmvideomode.b_renamed.a_renamed(thumbImageView, view, view2, view3, viewGroup, relativeLayout, duration, i_renamed, valueAnimator);
                }
            });
            duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$GtA1ce9wBKD-SQ-CBQvK6lI0cPI
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.filmvideomode.b_renamed.a_renamed(thumbImageView, valueAnimator);
                }
            });
            duration2.start();
        }
        if (!com.oplus.camera.util.Util.u_renamed() || view2 == null) {
            return;
        }
        android.animation.ValueAnimator duration3 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(180L);
        duration3.setInterpolator(interpolatorLoadInterpolator2);
        duration3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$b_renamed$cnGIe0j8CsVt1WwzEF31IYaLBeg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.filmvideomode.b_renamed.a_renamed(thumbImageView, view, view2, view3, viewGroup, relativeLayout, i_renamed, valueAnimator);
            }
        });
        duration3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.view.View view, android.view.View view2, android.view.View view3, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.animation.ValueAnimator valueAnimator, int i_renamed, android.animation.ValueAnimator valueAnimator2) throws android.content.res.Resources.NotFoundException {
        a_renamed(((java.lang.Float) valueAnimator2.getAnimatedValue()).floatValue(), thumbImageView, view, view2, view3, viewGroup, relativeLayout, valueAnimator, i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        a_renamed(thumbImageView, fFloatValue);
        if (1.0f == fFloatValue) {
            a_renamed((android.view.View) thumbImageView, 0);
            if (f4471a) {
                a_renamed(false);
                android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener = f4472b;
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.view.View view, android.view.View view2, android.view.View view3, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, int i_renamed, android.animation.ValueAnimator valueAnimator) throws android.content.res.Resources.NotFoundException {
        a_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue(), thumbImageView, view, view2, view3, viewGroup, relativeLayout, (android.animation.ValueAnimator) null, i_renamed);
    }

    private static void a_renamed(float f_renamed, com.oplus.camera.ui.control.ThumbImageView thumbImageView, android.view.View view, android.view.View view2, android.view.View view3, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.animation.ValueAnimator valueAnimator, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (!com.oplus.camera.util.Util.u_renamed()) {
            a_renamed(thumbImageView, f_renamed);
            a_renamed(view, f_renamed);
        }
        a_renamed(view2, f_renamed);
        a_renamed(view3, f_renamed);
        if (0.0f == f_renamed) {
            if (!com.oplus.camera.util.Util.u_renamed() && valueAnimator != null) {
                if (relativeLayout.indexOfChild(thumbImageView) < 0) {
                    viewGroup.removeView(thumbImageView);
                    relativeLayout.addView(thumbImageView);
                }
                viewGroup.setLayoutDirection(3);
                android.content.res.Resources resources = thumbImageView.getResources();
                int dimensionPixelSize = thumbImageView.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_view_padding);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_view_width);
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = dimensionPixelSize2;
                layoutParams.height = dimensionPixelSize2;
                layoutParams.leftMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.thumbnail_margin_start);
                layoutParams.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_out_thumbnail_margin_top);
                thumbImageView.setLayoutParams(layoutParams);
                thumbImageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                thumbImageView.a_renamed(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_round_corner_radius), false, i_renamed);
                thumbImageView.setRotation(0.0f);
                valueAnimator.start();
                a_renamed(view, 8);
            }
            a_renamed(view2, 8);
            a_renamed(view3, 8);
            a_renamed(view, 1.0f);
            a_renamed(view2, 1.0f);
            a_renamed(view3, 1.0f);
            viewGroup.removeView(view2);
        }
    }

    private static void a_renamed(android.view.View view, float f_renamed) {
        if (view != null) {
            view.setAlpha(f_renamed);
        }
    }

    private static void a_renamed(android.view.View view, int i_renamed) {
        if (view != null) {
            view.setVisibility(i_renamed);
        }
    }
}
