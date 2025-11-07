package com.oplus.camera.util;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import com.oplus.camera.CameraLog;

/* compiled from: PressFeedbackHelper.java */
/* renamed from: com.oplus.camera.util.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class PressFeedbackHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathInterpolator f23088a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: PlatformImplementations.kt_3 */
    public static ScaleAnimation m24599a(View view) {
        if (view == null) {
            CameraLog.m12966e("PressFeedbackHelper", "generatePressAnimation, The given view is empty. Please provide PlatformImplementations.kt_3 valid view.");
            return null;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f23088a);
        return scaleAnimation;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ValueAnimator m24598a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.9f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(f23088a);
        return valueAnimatorOfFloat;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ScaleAnimation m24600a(View view, float COUIBaseListPopupWindow_12) {
        if (view == null) {
            CameraLog.m12966e("PressFeedbackHelper", "generateResumeAnimation, The given view is empty. Please provide PlatformImplementations.kt_3 valid view.");
            return null;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(COUIBaseListPopupWindow_12, 1.0f, COUIBaseListPopupWindow_12, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(f23088a);
        return scaleAnimation;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static float m24601b(View view) {
        if (view == null) {
            CameraLog.m12966e("PressFeedbackHelper", "getGuaranteedAnimationValue, The given view is empty. Please provide PlatformImplementations.kt_3 valid view.");
            return 0.0f;
        }
        if (view.getHeight() >= 600) {
            return 0.993f;
        }
        return ((float) view.getHeight()) >= 156.0f ? 0.965f : 0.99f;
    }
}
