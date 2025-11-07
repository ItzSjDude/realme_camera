package com.oplus.camera.photo3d.p159ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.util.Util;

/* compiled from: MenuSwitcher.java */
/* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class MenuSwitcher {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f15274a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f15275b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RotateImageView f15276c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout f15277d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathInterpolator f15278e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathInterpolator f15279f = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AnimatorSet f15280g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AnimatorSet f15281h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f15282i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f15283j;

    /* compiled from: MenuSwitcher.java */
    /* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15276a();
    }

    public MenuSwitcher(Activity activity, RelativeLayout relativeLayout) {
        this.f15275b = activity;
        this.f15277d = relativeLayout;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15270b() {
        if (this.f15276c != null) {
            return;
        }
        this.f15274a = this.f15275b.getResources().getDimensionPixelSize(R.dimen.long_exposure_scale_translate_y);
        this.f15276c = new RotateImageView(this.f15275b);
        this.f15276c.setImageDrawable(this.f15275b.getDrawable(R.drawable.ic_long_exposure_menu_state));
        this.f15276c.setBackground(this.f15275b.getDrawable(R.drawable.face_beauty_menu_control_button_background));
        this.f15276c.setColorFilter(Util.m24164A(this.f15275b), PorterDuff.Mode.SRC_ATOP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f15275b.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_icon_width), this.f15275b.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_icon_width));
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.setMarginStart((int) this.f15275b.getResources().getDimension(R.dimen.long_exposure_effect_icon_margin_left));
        layoutParams.setMargins(0, (int) this.f15275b.getResources().getDimension(R.dimen.long_exposure_effect_icon_margin_top), 0, 0);
        this.f15276c.setVisibility(4);
        this.f15276c.m18348a(this.f15283j, false);
        this.f15277d.addView(this.f15276c, layoutParams);
        this.f15276c.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuSwitcher.this.m15275b(true, true);
                if (MenuSwitcher.this.f15282i != null) {
                    MenuSwitcher.this.f15282i.mo15276a();
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15274a(boolean z, boolean z2) {
        m15270b();
        if (!z) {
            this.f15276c.setAlpha(1.0f);
            this.f15276c.setVisibility(0);
            return;
        }
        this.f15276c.setAlpha(0.0f);
        this.f15276c.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f15276c, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f15278e);
        objectAnimatorOfFloat.setDuration(250L);
        this.f15280g = new AnimatorSet();
        AnimatorSet.Builder builderPlay = this.f15280g.play(objectAnimatorOfFloat);
        if (z2) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f15276c, "translationY", -this.f15274a, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f15279f);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
            this.f15280g.setStartDelay(150L);
        } else {
            this.f15276c.setTranslationY(0.0f);
        }
        this.f15280g.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_3.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MenuSwitcher.this.f15276c != null) {
                    MenuSwitcher.this.f15276c.setTranslationY(0.0f);
                    MenuSwitcher.this.f15276c.setAlpha(1.0f);
                    MenuSwitcher.this.f15276c.setVisibility(0);
                }
            }
        });
        this.f15280g.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15275b(boolean z, boolean z2) {
        RotateImageView rotateImageView = this.f15276c;
        if (rotateImageView == null) {
            CameraLog.m12959b("MenuSwitcher", "hideEffectIcon, return for mMenuIcon not init");
            return;
        }
        if (!z) {
            rotateImageView.setVisibility(4);
            return;
        }
        AnimatorSet animatorSet = this.f15280g;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f15280g.cancel();
        } else {
            RotateImageView rotateImageView2 = this.f15276c;
            if (rotateImageView2 == null || !rotateImageView2.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f15281h;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f15276c, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f15278e);
        objectAnimatorOfFloat.setDuration(300L);
        this.f15281h = new AnimatorSet();
        AnimatorSet.Builder builderPlay = this.f15281h.play(objectAnimatorOfFloat);
        if (z2) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f15276c, "translationY", 0.0f, -this.f15274a);
            objectAnimatorOfFloat2.setInterpolator(this.f15279f);
            objectAnimatorOfFloat2.setDuration(400L);
            builderPlay.with(objectAnimatorOfFloat2);
        }
        this.f15281h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_3.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (MenuSwitcher.this.f15276c != null) {
                    MenuSwitcher.this.f15276c.setTranslationY(0.0f);
                    MenuSwitcher.this.f15276c.setAlpha(1.0f);
                    MenuSwitcher.this.f15276c.setVisibility(0);
                    MenuSwitcher.this.f15276c.setEnabled(false);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MenuSwitcher.this.f15276c != null) {
                    MenuSwitcher.this.f15276c.setTranslationY(0.0f);
                    MenuSwitcher.this.f15276c.setAlpha(0.0f);
                    MenuSwitcher.this.f15276c.setVisibility(4);
                    MenuSwitcher.this.f15276c.setEnabled(true);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (MenuSwitcher.this.f15276c != null) {
                    MenuSwitcher.this.f15276c.setEnabled(true);
                }
            }
        });
        this.f15281h.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15272a(int OplusGLSurfaceView_13) {
        this.f15283j = OplusGLSurfaceView_13;
        RotateImageView rotateImageView = this.f15276c;
        if (rotateImageView != null) {
            rotateImageView.m18348a(this.f15283j, true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15273a(PlatformImplementations.kt_3 aVar) {
        this.f15282i = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15271a() {
        RotateImageView rotateImageView = this.f15276c;
        if (rotateImageView != null) {
            this.f15277d.removeView(rotateImageView);
        }
        this.f15282i = null;
    }
}
