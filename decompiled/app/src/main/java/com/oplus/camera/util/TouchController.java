package com.oplus.camera.util;

/* compiled from: PressFeedbackHelper.java */
/* loaded from: classes2.dex */
public class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.PathInterpolator f7352a = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    public static android.view.animation.ScaleAnimation a_renamed(android.view.View view) {
        if (view == null) {
            com.oplus.camera.e_renamed.e_renamed("PressFeedbackHelper", "generatePressAnimation, The given view is_renamed empty. Please provide a_renamed valid view.");
            return null;
        }
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f7352a);
        return scaleAnimation;
    }

    public static android.animation.ValueAnimator a_renamed() {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.9f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(f7352a);
        return valueAnimatorOfFloat;
    }

    public static android.view.animation.ScaleAnimation a_renamed(android.view.View view, float f_renamed) {
        if (view == null) {
            com.oplus.camera.e_renamed.e_renamed("PressFeedbackHelper", "generateResumeAnimation, The given view is_renamed empty. Please provide a_renamed valid view.");
            return null;
        }
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(f_renamed, 1.0f, f_renamed, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f7352a);
        return scaleAnimation;
    }

    public static float b_renamed(android.view.View view) {
        if (view == null) {
            com.oplus.camera.e_renamed.e_renamed("PressFeedbackHelper", "getGuaranteedAnimationValue, The given view is_renamed empty. Please provide a_renamed valid view.");
            return 0.0f;
        }
        if (view.getHeight() >= 600) {
            return 0.993f;
        }
        return ((float) view.getHeight()) >= 156.0f ? 0.965f : 0.99f;
    }
}
