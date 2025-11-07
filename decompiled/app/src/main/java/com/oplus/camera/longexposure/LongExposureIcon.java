package com.oplus.camera.longexposure;

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
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.util.Util;

/* compiled from: LongExposureIcon.java */
/* renamed from: com.oplus.camera.longexposure.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class LongExposureIcon {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f14547b;

    /* renamed from: PlatformImplementations.kt_3 */
    private RotateImageView f14546a = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RelativeLayout f14548c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LongExposureListener f14549d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathInterpolator f14550e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PathInterpolator f14551f = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AnimatorSet f14552g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private AnimatorSet f14553h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f14554i = 0;

    public LongExposureIcon(Activity activity) {
        this.f14547b = null;
        this.f14547b = activity;
        m14570a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14573a(LongExposureListener interfaceC2802f) {
        this.f14549d = interfaceC2802f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14570a() {
        this.f14548c = (RelativeLayout) this.f14547b.findViewById(R.id_renamed.camera);
        this.f14554i = this.f14547b.getResources().getDimensionPixelSize(R.dimen.long_exposure_scale_translate_y);
        if (this.f14546a == null) {
            this.f14546a = new RotateImageView(this.f14547b);
            this.f14546a.setImageDrawable(this.f14547b.getDrawable(R.drawable.ic_long_exposure_menu_state));
            this.f14546a.setBackground(this.f14547b.getDrawable(R.drawable.face_beauty_menu_control_button_background));
            this.f14546a.setColorFilter(Util.m24164A(this.f14547b), PorterDuff.Mode.SRC_ATOP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14547b.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_icon_width), this.f14547b.getResources().getDimensionPixelSize(R.dimen.long_exposure_effect_icon_width));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams.setMarginStart((int) this.f14547b.getResources().getDimension(R.dimen.long_exposure_effect_icon_margin_left));
            layoutParams.setMargins(0, (int) this.f14547b.getResources().getDimension(R.dimen.long_exposure_effect_icon_margin_top), 0, 0);
            this.f14546a.setVisibility(4);
            this.f14548c.addView(this.f14546a, layoutParams);
            this.f14546a.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.longexposure.IntrinsicsJvm.kt_5.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LongExposureIcon.this.f14549d.mo12537a();
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14572a(int OplusGLSurfaceView_13) {
        RotateImageView rotateImageView = this.f14546a;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14575a(boolean z, boolean z2) {
        if (this.f14546a != null) {
            AnimatorSet animatorSet = this.f14552g;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.f14552g.cancel();
            } else {
                RotateImageView rotateImageView = this.f14546a;
                if (rotateImageView == null || !rotateImageView.isShown()) {
                    return;
                }
                AnimatorSet animatorSet2 = this.f14553h;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            this.f14546a.setEnabled(false);
            if (z) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f14546a, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.f14550e);
                objectAnimatorOfFloat.setDuration(250L);
                this.f14553h = new AnimatorSet();
                AnimatorSet.Builder builderPlay = this.f14553h.play(objectAnimatorOfFloat);
                if (z2) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14546a, "translationY", 0.0f, -this.f14554i);
                    objectAnimatorOfFloat2.setInterpolator(this.f14551f);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                this.f14553h.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.IntrinsicsJvm.kt_5.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (LongExposureIcon.this.f14546a != null) {
                            LongExposureIcon.this.f14546a.setTranslationY(0.0f);
                            LongExposureIcon.this.f14546a.setAlpha(1.0f);
                            LongExposureIcon.this.f14546a.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (LongExposureIcon.this.f14546a != null) {
                            LongExposureIcon.this.f14546a.setTranslationY(0.0f);
                            LongExposureIcon.this.f14546a.setAlpha(0.0f);
                            LongExposureIcon.this.f14546a.setVisibility(4);
                        }
                    }
                });
                this.f14553h.start();
                return;
            }
            this.f14546a.setVisibility(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14574a(boolean z) {
        RotateImageView rotateImageView = this.f14546a;
        if (rotateImageView != null) {
            rotateImageView.setEnabled(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14576a(boolean z, boolean z2, boolean z3) {
        if (this.f14546a == null) {
            m14570a();
            return;
        }
        if (!z3) {
            m14574a(z3);
        }
        AnimatorSet animatorSet = this.f14553h;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f14553h.end();
        } else {
            if (this.f14546a.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f14552g;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            m14574a(z3);
            this.f14546a.setAlpha(0.0f);
            this.f14546a.setVisibility(0);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f14546a, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f14550e);
            objectAnimatorOfFloat.setDuration(250L);
            this.f14552g = new AnimatorSet();
            AnimatorSet.Builder builderPlay = this.f14552g.play(objectAnimatorOfFloat);
            if (z2) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14546a, "translationY", -this.f14554i, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.f14551f);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
                this.f14552g.setStartDelay(150L);
            } else {
                this.f14546a.setTranslationY(0.0f);
            }
            this.f14552g.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.longexposure.IntrinsicsJvm.kt_5.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (LongExposureIcon.this.f14546a != null) {
                        LongExposureIcon.this.f14546a.setTranslationY(0.0f);
                        LongExposureIcon.this.f14546a.setAlpha(1.0f);
                        LongExposureIcon.this.f14546a.setVisibility(0);
                    }
                }
            });
            this.f14552g.start();
            return;
        }
        this.f14546a.setAlpha(1.0f);
        this.f14546a.setVisibility(0);
        if (z3) {
            m14574a(z3);
        }
    }
}
