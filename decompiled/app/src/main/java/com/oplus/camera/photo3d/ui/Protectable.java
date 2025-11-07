package com.oplus.camera.photo3d.ui;

/* compiled from: MenuSwitcher.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5054a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f5055b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.RotateImageView f5056c;
    private android.widget.RelativeLayout d_renamed;
    private android.view.animation.PathInterpolator e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator f_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private android.animation.AnimatorSet g_renamed;
    private android.animation.AnimatorSet h_renamed;
    private com.oplus.camera.photo3d.ui.c_renamed.a_renamed i_renamed;
    private int j_renamed;

    /* compiled from: MenuSwitcher.java */
    public interface a_renamed {
        void a_renamed();
    }

    public c_renamed(android.app.Activity activity, android.widget.RelativeLayout relativeLayout) {
        this.f5055b = activity;
        this.d_renamed = relativeLayout;
    }

    private void b_renamed() {
        if (this.f5056c != null) {
            return;
        }
        this.f5054a = this.f5055b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_translate_y);
        this.f5056c = new com.oplus.camera.ui.RotateImageView(this.f5055b);
        this.f5056c.setImageDrawable(this.f5055b.getDrawable(com.oplus.camera.R_renamed.drawable.ic_long_exposure_menu_state));
        this.f5056c.setBackground(this.f5055b.getDrawable(com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button_background));
        this.f5056c.setColorFilter(com.oplus.camera.util.Util.A_renamed(this.f5055b), android.graphics.PorterDuff.Mode.SRC_ATOP);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.f5055b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_width), this.f5055b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_width));
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
        layoutParams.setMarginStart((int) this.f5055b.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_margin_left));
        layoutParams.setMargins(0, (int) this.f5055b.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_icon_margin_top), 0, 0);
        this.f5056c.setVisibility(4);
        this.f5056c.a_renamed(this.j_renamed, false);
        this.d_renamed.addView(this.f5056c, layoutParams);
        this.f5056c.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.c_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.oplus.camera.photo3d.ui.c_renamed.this.b_renamed(true, true);
                if (com.oplus.camera.photo3d.ui.c_renamed.this.i_renamed != null) {
                    com.oplus.camera.photo3d.ui.c_renamed.this.i_renamed.a_renamed();
                }
            }
        });
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        b_renamed();
        if (!z_renamed) {
            this.f5056c.setAlpha(1.0f);
            this.f5056c.setVisibility(0);
            return;
        }
        this.f5056c.setAlpha(0.0f);
        this.f5056c.setVisibility(0);
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5056c, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.e_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        this.g_renamed = new android.animation.AnimatorSet();
        android.animation.AnimatorSet.Builder builderPlay = this.g_renamed.play(objectAnimatorOfFloat);
        if (z2) {
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f5056c, "translationY", -this.f5054a, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
            this.g_renamed.setStartDelay(150L);
        } else {
            this.f5056c.setTranslationY(0.0f);
        }
        this.g_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.c_renamed.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.photo3d.ui.c_renamed.this.f5056c != null) {
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setTranslationY(0.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setAlpha(1.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setVisibility(0);
                }
            }
        });
        this.g_renamed.start();
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f5056c;
        if (rotateImageView == null) {
            com.oplus.camera.e_renamed.b_renamed("MenuSwitcher", "hideEffectIcon, return for mMenuIcon not init");
            return;
        }
        if (!z_renamed) {
            rotateImageView.setVisibility(4);
            return;
        }
        android.animation.AnimatorSet animatorSet = this.g_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.g_renamed.cancel();
        } else {
            com.oplus.camera.ui.RotateImageView rotateImageView2 = this.f5056c;
            if (rotateImageView2 == null || !rotateImageView2.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.h_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.f5056c, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.e_renamed);
        objectAnimatorOfFloat.setDuration(300L);
        this.h_renamed = new android.animation.AnimatorSet();
        android.animation.AnimatorSet.Builder builderPlay = this.h_renamed.play(objectAnimatorOfFloat);
        if (z2) {
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.f5056c, "translationY", 0.0f, -this.f5054a);
            objectAnimatorOfFloat2.setInterpolator(this.f_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
        }
        this.h_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.c_renamed.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                if (com.oplus.camera.photo3d.ui.c_renamed.this.f5056c != null) {
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setTranslationY(0.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setAlpha(1.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setVisibility(0);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setEnabled(false);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.photo3d.ui.c_renamed.this.f5056c != null) {
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setTranslationY(0.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setAlpha(0.0f);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setVisibility(4);
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setEnabled(true);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                if (com.oplus.camera.photo3d.ui.c_renamed.this.f5056c != null) {
                    com.oplus.camera.photo3d.ui.c_renamed.this.f5056c.setEnabled(true);
                }
            }
        });
        this.h_renamed.start();
    }

    public void a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f5056c;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(this.j_renamed, true);
        }
    }

    public void a_renamed(com.oplus.camera.photo3d.ui.c_renamed.a_renamed aVar) {
        this.i_renamed = aVar;
    }

    public void a_renamed() {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.f5056c;
        if (rotateImageView != null) {
            this.d_renamed.removeView(rotateImageView);
        }
        this.i_renamed = null;
    }
}
