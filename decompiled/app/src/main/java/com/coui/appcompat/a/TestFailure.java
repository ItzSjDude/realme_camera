package com.coui.appcompat.a_renamed;

/* compiled from: COUIFABPressFeedbackUtil.java */
/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.PathInterpolator f2389a = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);

    public static com.coui.appcompat.widget.floatingbutton.b_renamed a_renamed(android.view.View view) {
        if (view == null) {
            throw new java.lang.IllegalArgumentException("The given view is_renamed empty. Please provide a_renamed valid view.");
        }
        com.coui.appcompat.widget.floatingbutton.b_renamed bVar = new com.coui.appcompat.widget.floatingbutton.b_renamed(1.0f, 0.9f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        bVar.setDuration(200L);
        bVar.setFillAfter(true);
        bVar.setInterpolator(f2389a);
        bVar.a_renamed(view);
        return bVar;
    }

    public static android.animation.ValueAnimator a_renamed() {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.9f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(f2389a);
        return valueAnimatorOfFloat;
    }

    public static com.coui.appcompat.widget.floatingbutton.b_renamed a_renamed(android.view.View view, float f_renamed) {
        if (view == null) {
            throw new java.lang.IllegalArgumentException("The given view is_renamed empty. Please provide a_renamed valid view.");
        }
        com.coui.appcompat.widget.floatingbutton.b_renamed bVar = new com.coui.appcompat.widget.floatingbutton.b_renamed(f_renamed, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        bVar.setDuration(340L);
        bVar.setFillAfter(true);
        bVar.setInterpolator(f2389a);
        bVar.a_renamed(view);
        return bVar;
    }
}
