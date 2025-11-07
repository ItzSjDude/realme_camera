package com.oplus.camera.longexposure;

/* compiled from: LongExposureIcon.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f4819b;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.RotateImageView f4818a = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.RelativeLayout f4820c = null;
    private com.oplus.camera.longexposure.f_renamed d_renamed = null;
    private android.view.animation.PathInterpolator e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator f_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private android.animation.AnimatorSet g_renamed = null;
    private android.animation.AnimatorSet h_renamed = null;
    private int i_renamed = 0;

    public d_renamed(android.app.Activity activity) {
        this.f4819b = null;
        this.f4819b = activity;
        a_renamed();
    }

    public void a_renamed(com.oplus.camera.longexposure.f_renamed fVar) {
        this.d_renamed = fVar;
    }

    private void a_renamed() {
        this.f4820c = (android.widget.RelativeLayout) this.f4819b.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.i_renamed = this.f4819b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_translate_y);
        if (this.f4818a == null) {
            this.f4818a = new com.oplus.camera.ui.RotateImageView(this.f4819b);
            this.f4818a.setImageDrawable(this.f4819b.getDrawable(com.oplus.camera.R_renamed.drawable.ic_long_exposure_menu_state));
            this.f4818a.setBackground(this.f4819b.getDrawable(com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button_background));
            this.f4818a.setColorFilter(com.oplus.camera.util.Util.A_renamed(this.f4819b), android.graphics.PorterDuff.Mode.SRC_ATOP);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.f4819b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_width), this.f4819b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_width));
            layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
            layoutParams.setMarginStart((int) this.f4819b.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_margin_left));
            layoutParams.setMargins(0, (int) this.f4819b.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_margin_top), 0, 0);
            this.f4818a.setVisibility(4);
            this.f4820c.addView(this.f4818a, layoutParams);
            this.f4818a.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.longexposure.d_renamed.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.longexposure.d_renamed.this.d_renamed.a_renamed();
                }
            });
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f4818a;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(i_renamed, true);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        if (this.f4818a != null) {
            android.animation.AnimatorSet animatorSet = this.g_renamed;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.g_renamed.cancel();
            } else {
                com.oplus.camera.ui.RotateImageView rotateImageView = this.f4818a;
                if (rotateImageView == null || !rotateImageView.isShown()) {
                    return;
                }
                android.animation.AnimatorSet animatorSet2 = this.h_renamed;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            this.f4818a.setEnabled(false);
            if (z_renamed) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f4818a, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.e_renamed);
                objectAnimatorOfFloat.setDuration(250L);
                this.h_renamed = new android.animation.AnimatorSet();
                android.animation.AnimatorSet.Builder builderPlay = this.h_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f4818a, "translationY", 0.0f, -this.i_renamed);
                    objectAnimatorOfFloat2.setInterpolator(this.f_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                this.h_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.d_renamed.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.longexposure.d_renamed.this.f4818a != null) {
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setTranslationY(0.0f);
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setAlpha(1.0f);
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.longexposure.d_renamed.this.f4818a != null) {
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setTranslationY(0.0f);
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setAlpha(0.0f);
                            com.oplus.camera.longexposure.d_renamed.this.f4818a.setVisibility(4);
                        }
                    }
                });
                this.h_renamed.start();
                return;
            }
            this.f4818a.setVisibility(4);
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f4818a;
        if (rotateImageView != null) {
            rotateImageView.setEnabled(z_renamed);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.f4818a == null) {
            a_renamed();
            return;
        }
        if (!z3) {
            a_renamed(z3);
        }
        android.animation.AnimatorSet animatorSet = this.h_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.h_renamed.end();
        } else {
            if (this.f4818a.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.g_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            a_renamed(z3);
            this.f4818a.setAlpha(0.0f);
            this.f4818a.setVisibility(0);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f4818a, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.e_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            this.g_renamed = new android.animation.AnimatorSet();
            android.animation.AnimatorSet.Builder builderPlay = this.g_renamed.play(objectAnimatorOfFloat);
            if (z2) {
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f4818a, "translationY", -this.i_renamed, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.f_renamed);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
                this.g_renamed.setStartDelay(150L);
            } else {
                this.f4818a.setTranslationY(0.0f);
            }
            this.g_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.d_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.longexposure.d_renamed.this.f4818a != null) {
                        com.oplus.camera.longexposure.d_renamed.this.f4818a.setTranslationY(0.0f);
                        com.oplus.camera.longexposure.d_renamed.this.f4818a.setAlpha(1.0f);
                        com.oplus.camera.longexposure.d_renamed.this.f4818a.setVisibility(0);
                    }
                }
            });
            this.g_renamed.start();
            return;
        }
        this.f4818a.setAlpha(1.0f);
        this.f4818a.setVisibility(0);
        if (z3) {
            a_renamed(z3);
        }
    }
}
