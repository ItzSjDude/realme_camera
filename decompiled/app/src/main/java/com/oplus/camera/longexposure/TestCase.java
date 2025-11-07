package com.oplus.camera.longexposure;

/* compiled from: LongExposureLevelPanel.java */
/* loaded from: classes2.dex */
public class e_renamed implements com.oplus.camera.longexposure.i_renamed.c_renamed {
    private android.content.Context e_renamed;
    private android.app.Activity f_renamed;
    private android.content.SharedPreferences g_renamed;
    private android.os.Handler h_renamed;
    private com.oplus.camera.capmode.a_renamed i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4824a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4825b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.professional.z_renamed f4826c = null;
    private com.oplus.camera.longexposure.i_renamed d_renamed = null;
    private android.content.res.Resources j_renamed = null;
    private android.widget.RelativeLayout k_renamed = null;
    private com.oplus.camera.longexposure.h_renamed l_renamed = null;
    private com.oplus.camera.longexposure.h_renamed m_renamed = null;
    private android.animation.AnimatorSet n_renamed = null;
    private android.animation.AnimatorSet o_renamed = null;
    private int p_renamed = 0;
    private android.view.animation.PathInterpolator q_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator r_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    public e_renamed(android.content.Context context, android.app.Activity activity, android.content.SharedPreferences sharedPreferences, android.os.Handler handler, com.oplus.camera.capmode.a_renamed aVar) {
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.e_renamed = context;
        this.f_renamed = activity;
        this.g_renamed = sharedPreferences;
        this.h_renamed = handler;
        this.i_renamed = aVar;
    }

    public void a_renamed(int i_renamed) {
        if (this.j_renamed == null) {
            this.j_renamed = this.f_renamed.getResources();
        }
        if (this.k_renamed == null) {
            this.k_renamed = (android.widget.RelativeLayout) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
        this.f4824a = i_renamed;
        this.p_renamed = this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_translate_y);
        a_renamed(25, 1);
        c_renamed();
        d_renamed();
        b_renamed(false);
    }

    private void c_renamed() {
        if (this.l_renamed == null) {
            this.l_renamed = new com.oplus.camera.longexposure.h_renamed(this.e_renamed);
            this.l_renamed.setGravity(17);
            this.l_renamed.setId(android.view.View.generateViewId());
            this.l_renamed.setShadowLayer(this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_text_radius_shadow), 0.0f, 0.0f, this.j_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
            this.l_renamed.setTextSize(0, this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_size));
            this.l_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.e_renamed));
            this.l_renamed.setTextColor(-1);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_width), this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_height));
            layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
            layoutParams.setMarginStart((int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_left));
            layoutParams.setMargins(0, (int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_exposure_time_text_margin_top), 0, 0);
            this.k_renamed.addView(this.l_renamed, layoutParams);
        }
        if (this.m_renamed == null) {
            this.m_renamed = new com.oplus.camera.longexposure.h_renamed(this.f_renamed);
            this.m_renamed.setGravity(17);
            this.m_renamed.setId(android.view.View.generateViewId());
            this.m_renamed.setTextSize(0, this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_size));
            this.m_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.e_renamed));
            this.m_renamed.setTextColor(com.oplus.camera.util.Util.A_renamed(this.f_renamed));
            this.m_renamed.setText(com.oplus.camera.R_renamed.string.long_exposure_capture_time_text);
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_width), this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_height));
            layoutParams2.gravity = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
            layoutParams2.setMarginStart((int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_left));
            layoutParams2.setMargins(0, (int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_capture_time_text_margin_top), 0, 0);
            this.k_renamed.addView(this.m_renamed, layoutParams2);
        }
    }

    public void b_renamed(int i_renamed) {
        if (this.f4824a != i_renamed) {
            this.f4825b = true;
        } else {
            this.f4825b = false;
        }
        this.f4824a = i_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "changeScene, currentType: " + i_renamed);
        if (1 == i_renamed) {
            if (this.g_renamed.getBoolean("pref_long_exposure_streamer_portrait_auto_key", true)) {
                this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i2 = this.g_renamed.getInt("pref_long_exposure_streamer_portrait_key", 6);
                this.d_renamed.setCurrentIndex(i2);
                this.d_renamed.a_renamed(i2);
                a_renamed(true, z_renamed);
                return;
            }
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.d_renamed.setCurrentIndex(0);
            this.d_renamed.a_renamed(0);
            a_renamed(false, z_renamed);
            return;
        }
        if (2 == i_renamed) {
            if (this.g_renamed.getBoolean("pref_long_exposure_busy_traffic_auto_key", true)) {
                this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i3 = this.g_renamed.getInt("pref_long_exposure_busy_traffic_key", 10);
                this.d_renamed.setCurrentIndex(i3);
                this.d_renamed.a_renamed(i3);
                a_renamed(true, z_renamed);
                return;
            }
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.d_renamed.setCurrentIndex(0);
            this.d_renamed.a_renamed(0);
            a_renamed(false, z_renamed);
            return;
        }
        if (3 == i_renamed) {
            if (this.g_renamed.getBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", true)) {
                this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i4 = this.g_renamed.getInt("pref_long_exposure_flowing_clouds_and_water_key", 8);
                this.d_renamed.setCurrentIndex(i4);
                this.d_renamed.a_renamed(i4);
                a_renamed(true, z_renamed);
                return;
            }
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.d_renamed.setCurrentIndex(0);
            this.d_renamed.a_renamed(0);
            a_renamed(false, z_renamed);
            return;
        }
        if (4 == i_renamed) {
            if (this.g_renamed.getBoolean("pref_long_exposure_light_painting_auto_key", false)) {
                this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i5 = this.g_renamed.getInt("pref_long_exposure_light_painting_key", 0);
                this.d_renamed.setCurrentIndex(i5);
                this.d_renamed.a_renamed(i5);
                a_renamed(true, z_renamed);
                return;
            }
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.d_renamed.setCurrentIndex(0);
            this.d_renamed.a_renamed(0);
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            a_renamed(false, z_renamed);
            return;
        }
        if (5 == i_renamed) {
            if (this.g_renamed.getBoolean("pref_long_exposure_moving_crowd_auto_key", true)) {
                this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
                int i6 = this.g_renamed.getInt("pref_long_exposure_moving_crowd_key", 2);
                this.d_renamed.setCurrentIndex(i6);
                this.d_renamed.a_renamed(i6);
                a_renamed(true, z_renamed);
                return;
            }
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
            this.d_renamed.setCurrentIndex(0);
            this.d_renamed.a_renamed(0);
            a_renamed(false, z_renamed);
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.longexposure.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            iVar.setEnabled(true);
        }
        a_renamed(z_renamed, this.d_renamed, this.l_renamed, this.m_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.longexposure.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            iVar.setEnabled(false);
        }
        b_renamed(z_renamed, this.d_renamed, this.l_renamed, this.m_renamed);
    }

    private void d_renamed() {
        this.d_renamed = new com.oplus.camera.longexposure.i_renamed(this.e_renamed, this.f4826c.c_renamed().size(), this.h_renamed);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_width), this.j_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_height));
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
        layoutParams.setMarginStart((int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_margin_left));
        layoutParams.setMarginEnd((int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_margin_left));
        layoutParams.setMargins(0, (int) this.j_renamed.getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_margin_top), 0, 0);
        this.d_renamed.setScaleBarValueChangeListener(this);
        this.k_renamed.addView(this.d_renamed, layoutParams);
        this.d_renamed.b_renamed(this.g_renamed.getInt("pref_long_exposure_streamer_portrait_key", 6));
    }

    private void a_renamed(int i_renamed, int i2) {
        this.f4826c = new com.oplus.camera.professional.z_renamed(this.e_renamed);
        a_renamed(this.f4826c, i_renamed, i2);
    }

    private void a_renamed(com.oplus.camera.professional.z_renamed zVar, int i_renamed, int i2) {
        java.util.ArrayList<java.lang.String> arrayListB = zVar.b_renamed();
        java.util.ArrayList<java.lang.String> arrayListC = zVar.c_renamed();
        if (i_renamed <= 0 || i2 <= 0 || i_renamed == i2) {
            com.oplus.camera.e_renamed.f_renamed("LongExposureLevelPanel", "generateIsoValues, return null, maxISOValue: " + i_renamed + ", minISOValue: " + i2 + ", maxISOValue: " + i_renamed);
            return;
        }
        arrayListB.clear();
        arrayListC.clear();
        while (i2 <= i_renamed) {
            arrayListB.add(java.lang.Integer.toString(i2));
            arrayListC.add(java.lang.Integer.toString(i2));
            i2++;
        }
    }

    private void f_renamed(int i_renamed) {
        com.oplus.camera.ae_renamed aeVarAd = this.i_renamed.ad_renamed();
        if (aeVarAd != null) {
            if (i_renamed % 4 == 0) {
                aeVarAd.f_renamed();
            } else {
                aeVarAd.d_renamed();
            }
        }
    }

    public float c_renamed(int i_renamed) {
        int i2 = 0;
        if (1 == i_renamed) {
            i2 = this.g_renamed.getInt("pref_long_exposure_streamer_portrait_key", 6);
        } else if (2 == i_renamed) {
            i2 = this.g_renamed.getInt("pref_long_exposure_busy_traffic_key", 10);
        } else if (3 == i_renamed) {
            i2 = this.g_renamed.getInt("pref_long_exposure_flowing_clouds_and_water_key", 8);
        } else if (4 == i_renamed) {
            i2 = this.g_renamed.getInt("pref_long_exposure_light_painting_key", 0);
        } else if (5 == i_renamed) {
            i2 = this.g_renamed.getInt("pref_long_exposure_moving_crowd_key", 2);
        }
        return i2 * 0.5f;
    }

    private void a_renamed(final boolean z_renamed, boolean z2) {
        if (!this.f4825b || !z2) {
            if (z_renamed) {
                this.l_renamed.setText(c_renamed(this.f4824a) + " s_renamed");
                return;
            }
            this.l_renamed.setText("∞");
            return;
        }
        this.l_renamed.clearAnimation();
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.l_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.l_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat2.setDuration(250L);
        objectAnimatorOfFloat2.setStartDelay(150L);
        android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this.m_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat3.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat4 = android.animation.ObjectAnimator.ofFloat(this.m_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat4.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat4.setDuration(250L);
        objectAnimatorOfFloat4.setStartDelay(150L);
        android.animation.ObjectAnimator objectAnimatorOfFloat5 = android.animation.ObjectAnimator.ofFloat(this.d_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat5.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat5.setDuration(250L);
        android.animation.ObjectAnimator objectAnimatorOfFloat6 = android.animation.ObjectAnimator.ofFloat(this.d_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat6.setInterpolator(this.q_renamed);
        objectAnimatorOfFloat6.setDuration(250L);
        objectAnimatorOfFloat6.setStartDelay(150L);
        objectAnimatorOfFloat2.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.e_renamed.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                super.onAnimationStart(animator);
                if (z_renamed) {
                    com.oplus.camera.longexposure.h_renamed hVar = com.oplus.camera.longexposure.e_renamed.this.l_renamed;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    com.oplus.camera.longexposure.e_renamed eVar = com.oplus.camera.longexposure.e_renamed.this;
                    sb.append(eVar.c_renamed(eVar.f4824a));
                    sb.append(" s_renamed");
                    hVar.setText(sb.toString());
                } else {
                    com.oplus.camera.longexposure.e_renamed.this.l_renamed.setText("∞");
                }
                com.oplus.camera.longexposure.e_renamed.this.d_renamed.invalidate();
            }
        });
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        animatorSet.start();
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "setOrientation: " + i_renamed);
        if (this.l_renamed.getVisibility() == 0) {
            com.oplus.camera.longexposure.h_renamed hVar = this.l_renamed;
            hVar.startAnimation(a_renamed(hVar, i_renamed, true));
        } else {
            b_renamed(this.l_renamed, i_renamed, true);
        }
        if (this.m_renamed.getVisibility() == 0) {
            com.oplus.camera.longexposure.h_renamed hVar2 = this.m_renamed;
            hVar2.startAnimation(a_renamed(hVar2, i_renamed, false));
        } else {
            b_renamed(this.m_renamed, i_renamed, false);
        }
    }

    private void a_renamed(boolean z_renamed, final android.view.View... viewArr) {
        android.animation.AnimatorSet animatorSet = this.o_renamed;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "showViews");
        if (viewArr == null) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "showViews, view is_renamed null, so return!");
            return;
        }
        android.animation.AnimatorSet animatorSet2 = this.n_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z_renamed) {
                android.animation.ObjectAnimator[] objectAnimatorArrC = c_renamed(true, viewArr);
                android.animation.ObjectAnimator[] objectAnimatorArrD = d_renamed(true, viewArr);
                this.n_renamed = new android.animation.AnimatorSet();
                this.n_renamed.playTogether(objectAnimatorArrC);
                this.n_renamed.playTogether(objectAnimatorArrD);
                this.n_renamed.setStartDelay(150L);
                this.n_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.e_renamed.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        super.onAnimationEnd(animator);
                        int i_renamed = 0;
                        while (true) {
                            android.view.View[] viewArr2 = viewArr;
                            if (i_renamed >= viewArr2.length) {
                                return;
                            }
                            android.view.View view = viewArr2[i_renamed];
                            view.setAlpha(1.0f);
                            view.setVisibility(0);
                            i_renamed++;
                        }
                    }
                });
                this.n_renamed.start();
                return;
            }
            for (android.view.View view : viewArr) {
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
        }
    }

    private void b_renamed(boolean z_renamed, final android.view.View... viewArr) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "hideViews");
        if (viewArr == null) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "hideViews, view is_renamed null, so return!");
            return;
        }
        android.animation.AnimatorSet animatorSet = this.n_renamed;
        if (animatorSet != null && (animatorSet.isStarted() || this.n_renamed.isRunning())) {
            com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "hideViews, views are showing, just invisible and return!");
            this.n_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.o_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            if (z_renamed) {
                android.animation.ObjectAnimator[] objectAnimatorArrC = c_renamed(false, viewArr);
                android.animation.ObjectAnimator[] objectAnimatorArrD = d_renamed(false, viewArr);
                this.o_renamed = new android.animation.AnimatorSet();
                this.o_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.e_renamed.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        super.onAnimationEnd(animator);
                        int i_renamed = 0;
                        while (true) {
                            android.view.View[] viewArr2 = viewArr;
                            if (i_renamed >= viewArr2.length) {
                                return;
                            }
                            android.view.View view = viewArr2[i_renamed];
                            view.setAlpha(0.0f);
                            view.setVisibility(4);
                            i_renamed++;
                        }
                    }
                });
                this.o_renamed.playTogether(objectAnimatorArrC);
                this.o_renamed.playTogether(objectAnimatorArrD);
                this.o_renamed.start();
                return;
            }
            for (android.view.View view : viewArr) {
                view.setVisibility(4);
            }
        }
    }

    private android.animation.ObjectAnimator[] c_renamed(boolean z_renamed, android.view.View... viewArr) {
        android.animation.ObjectAnimator[] objectAnimatorArr = new android.animation.ObjectAnimator[viewArr.length];
        for (int i_renamed = 0; i_renamed < viewArr.length; i_renamed++) {
            android.view.View view = viewArr[i_renamed];
            if (z_renamed) {
                view.setAlpha(0.0f);
                view.setVisibility(0);
            }
            objectAnimatorArr[i_renamed] = a_renamed(view, z_renamed);
        }
        return objectAnimatorArr;
    }

    private android.animation.ObjectAnimator[] d_renamed(boolean z_renamed, android.view.View... viewArr) {
        android.animation.ObjectAnimator[] objectAnimatorArr = new android.animation.ObjectAnimator[viewArr.length];
        for (int i_renamed = 0; i_renamed < viewArr.length; i_renamed++) {
            android.view.View view = viewArr[i_renamed];
            if (z_renamed) {
                objectAnimatorArr[i_renamed] = android.animation.ObjectAnimator.ofFloat(view, "translationY", this.p_renamed, 0.0f);
            } else {
                objectAnimatorArr[i_renamed] = android.animation.ObjectAnimator.ofFloat(view, "translationY", 0.0f, this.p_renamed);
            }
            objectAnimatorArr[i_renamed].setInterpolator(this.r_renamed);
            objectAnimatorArr[i_renamed].setDuration(400L);
        }
        return objectAnimatorArr;
    }

    private android.animation.ObjectAnimator a_renamed(android.view.View view, boolean z_renamed) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "alpha", z_renamed ? 0.0f : 1.0f, z_renamed ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.q_renamed);
        if (z_renamed) {
            objectAnimatorOfFloat.setDuration(400L);
        } else {
            objectAnimatorOfFloat.setDuration(250L);
        }
        return objectAnimatorOfFloat;
    }

    @Override // com.oplus.camera.longexposure.i_renamed.c_renamed
    public void e_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "onValueChange" + this.f4824a + ",value: " + i_renamed);
        f_renamed(i_renamed);
        if (i_renamed != 0) {
            this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "auto").apply();
            int i2 = this.f4824a;
            if (1 == i2) {
                this.g_renamed.edit().putInt("pref_long_exposure_streamer_portrait_key", i_renamed).apply();
                this.g_renamed.edit().putBoolean("pref_long_exposure_streamer_portrait_auto_key", true).apply();
            } else if (2 == i2) {
                this.g_renamed.edit().putInt("pref_long_exposure_busy_traffic_key", i_renamed).apply();
                this.g_renamed.edit().putBoolean("pref_long_exposure_busy_traffic_auto_key", true).apply();
            } else if (3 == i2) {
                this.g_renamed.edit().putInt("pref_long_exposure_flowing_clouds_and_water_key", i_renamed).apply();
                this.g_renamed.edit().putBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", true).apply();
            } else if (4 == i2) {
                this.g_renamed.edit().putInt("pref_long_exposure_light_painting_key", i_renamed).apply();
                this.g_renamed.edit().putBoolean("pref_long_exposure_light_painting_auto_key", true).apply();
            } else if (5 == i2) {
                this.g_renamed.edit().putInt("pref_long_exposure_moving_crowd_key", i_renamed).apply();
                this.g_renamed.edit().putBoolean("pref_long_exposure_moving_crowd_auto_key", true).apply();
            }
            a_renamed(true, false);
            return;
        }
        this.g_renamed.edit().putString("pref_key_long_exposure_exposure_time", "manual").apply();
        int i3 = this.f4824a;
        if (1 == i3) {
            this.g_renamed.edit().putBoolean("pref_long_exposure_streamer_portrait_auto_key", false).apply();
        } else if (2 == i3) {
            this.g_renamed.edit().putBoolean("pref_long_exposure_busy_traffic_auto_key", false).apply();
        } else if (3 == i3) {
            this.g_renamed.edit().putBoolean("pref_long_exposure_flowing_clouds_and_water_auto_key", false).apply();
        } else if (4 == i3) {
            this.g_renamed.edit().putBoolean("pref_long_exposure_light_painting_auto_key", false).apply();
        } else if (5 == i3) {
            this.g_renamed.edit().putBoolean("pref_long_exposure_moving_crowd_auto_key", false).apply();
        }
        a_renamed(false, false);
    }

    @Override // com.oplus.camera.longexposure.i_renamed.c_renamed
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "onBarMoving");
    }

    @Override // com.oplus.camera.longexposure.i_renamed.c_renamed
    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "onBarScrolling scrolling: " + z_renamed);
    }

    @Override // com.oplus.camera.longexposure.i_renamed.c_renamed
    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("LongExposureLevelPanel", "onActionUp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.animation.AnimationSet a_renamed(float f_renamed, float f2, int i_renamed) {
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.addAnimation(new android.view.animation.AlphaAnimation(f_renamed, f2));
        animationSet.setDuration(i_renamed);
        animationSet.setInterpolator(this.e_renamed, com.oplus.camera.R_renamed.anim.ultra_wide_hint_alpha_path_interpolator);
        return animationSet;
    }

    private android.view.animation.AnimationSet a_renamed(final com.oplus.camera.longexposure.h_renamed hVar, final int i_renamed, final boolean z_renamed) {
        android.view.animation.AnimationSet animationSetA = a_renamed(1.0f, 0.0f, 180);
        animationSetA.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.longexposure.e_renamed.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.longexposure.e_renamed.this.b_renamed(hVar, i_renamed, z_renamed);
                hVar.startAnimation(com.oplus.camera.longexposure.e_renamed.this.a_renamed(0.0f, 1.0f, 180));
            }
        });
        return animationSetA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.longexposure.h_renamed hVar, int i_renamed, boolean z_renamed) {
        if (i_renamed == 90) {
            hVar.setGravity(3);
        } else if (i_renamed == 270) {
            hVar.setGravity(5);
        } else {
            hVar.setGravity(17);
        }
        if (z_renamed) {
            hVar.a_renamed(i_renamed);
        } else {
            hVar.b_renamed(i_renamed);
        }
    }
}
