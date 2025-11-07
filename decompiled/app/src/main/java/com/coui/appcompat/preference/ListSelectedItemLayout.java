package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class ListSelectedItemLayout extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f2644a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f2645b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2646c;
    private boolean d_renamed;
    private boolean e_renamed;
    private android.graphics.drawable.Drawable f_renamed;
    private int g_renamed;
    private android.view.animation.Interpolator h_renamed;
    private android.view.animation.Interpolator i_renamed;

    public ListSelectedItemLayout(android.content.Context context) {
        this(context, null);
    }

    public ListSelectedItemLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListSelectedItemLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public ListSelectedItemLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f2646c = true;
        this.d_renamed = false;
        this.e_renamed = true;
        this.g_renamed = 2;
        this.h_renamed = new android.view.animation.PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        this.i_renamed = new android.view.animation.LinearInterpolator();
        a_renamed(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && isClickable() && this.f2646c) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b_renamed();
            } else if (action == 1 || action == 3) {
                a_renamed();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void a_renamed() {
        if (this.f2644a.isRunning()) {
            this.d_renamed = true;
        } else {
            if (this.f2645b.isRunning() || this.g_renamed != 1) {
                return;
            }
            this.f2645b.start();
        }
    }

    public void b_renamed() {
        if (this.f2645b.isRunning()) {
            this.f2645b.cancel();
        }
        if (this.f2644a.isRunning()) {
            this.f2644a.cancel();
        }
        this.f2644a.start();
    }

    public void setBackgroundAnimationEnabled(boolean z_renamed) {
        this.f2646c = z_renamed;
    }

    public void setBackgroundAnimationDrawable(android.graphics.drawable.Drawable drawable) {
        this.f_renamed = drawable;
    }

    private void a_renamed(android.content.Context context) {
        if (this.f_renamed == null) {
            this.f_renamed = new android.graphics.drawable.ColorDrawable(context.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_list_color_pressed));
        }
        int iAlpha = android.graphics.Color.alpha(context.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_list_selector_color_pressed));
        this.f2644a = android.animation.ValueAnimator.ofInt(0, iAlpha);
        this.f2644a.setDuration(150L);
        this.f2644a.setInterpolator(this.i_renamed);
        this.f2644a.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.preference.ListSelectedItemLayout.this.f_renamed.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                com.coui.appcompat.preference.ListSelectedItemLayout listSelectedItemLayout = com.coui.appcompat.preference.ListSelectedItemLayout.this;
                listSelectedItemLayout.setBackground(listSelectedItemLayout.f_renamed);
                com.coui.appcompat.preference.ListSelectedItemLayout.this.invalidate();
            }
        });
        this.f2644a.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.preference.ListSelectedItemLayout.this.g_renamed = 1;
                if (com.coui.appcompat.preference.ListSelectedItemLayout.this.d_renamed) {
                    com.coui.appcompat.preference.ListSelectedItemLayout.this.d_renamed = false;
                    com.coui.appcompat.preference.ListSelectedItemLayout.this.f2645b.start();
                }
            }
        });
        this.f2645b = android.animation.ValueAnimator.ofInt(iAlpha, 0);
        this.f2645b.setDuration(367L);
        this.f2645b.setInterpolator(this.h_renamed);
        this.f2645b.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.preference.ListSelectedItemLayout.this.f_renamed.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                com.coui.appcompat.preference.ListSelectedItemLayout listSelectedItemLayout = com.coui.appcompat.preference.ListSelectedItemLayout.this;
                listSelectedItemLayout.setBackground(listSelectedItemLayout.f_renamed);
                com.coui.appcompat.preference.ListSelectedItemLayout.this.invalidate();
            }
        });
        this.f2645b.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.coui.appcompat.preference.ListSelectedItemLayout.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.preference.ListSelectedItemLayout.this.g_renamed = 2;
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a_renamed(getContext().createConfigurationContext(configuration));
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        if (!z_renamed && isEnabled()) {
            a_renamed();
        }
        super.setEnabled(z_renamed);
    }
}
