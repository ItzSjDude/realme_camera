package com.coui.appcompat.p099a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.widget.floatingbutton.COUIFloatingButtonTouchAnimation;

/* compiled from: COUIFABPressFeedbackUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class COUIFABPressFeedbackUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathInterpolator f6316a = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUIFloatingButtonTouchAnimation m6403a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("The given view is empty. Please provide PlatformImplementations.kt_3 valid view.");
        }
        COUIFloatingButtonTouchAnimation c1471b = new COUIFloatingButtonTouchAnimation(1.0f, 0.9f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        c1471b.setDuration(200L);
        c1471b.setFillAfter(true);
        c1471b.setInterpolator(f6316a);
        c1471b.m7765a(view);
        return c1471b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ValueAnimator m6402a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.9f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(f6316a);
        return valueAnimatorOfFloat;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUIFloatingButtonTouchAnimation m6404a(View view, float COUIBaseListPopupWindow_12) {
        if (view == null) {
            throw new IllegalArgumentException("The given view is empty. Please provide PlatformImplementations.kt_3 valid view.");
        }
        COUIFloatingButtonTouchAnimation c1471b = new COUIFloatingButtonTouchAnimation(COUIBaseListPopupWindow_12, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        c1471b.setDuration(340L);
        c1471b.setFillAfter(true);
        c1471b.setInterpolator(f6316a);
        c1471b.m7765a(view);
        return c1471b;
    }
}
