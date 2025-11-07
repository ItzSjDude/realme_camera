package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class TabContainerTextView extends android.widget.TextView implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6398a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.animation.ArgbEvaluator f6399b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6400c;
    private boolean d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private android.animation.Animator g_renamed;
    private android.animation.Animator h_renamed;
    private android.content.res.ColorStateList i_renamed;
    private android.content.res.ColorStateList j_renamed;
    private int k_renamed;
    private int[] l_renamed;
    private int[] m_renamed;
    private android.graphics.drawable.GradientDrawable n_renamed;
    private boolean o_renamed;
    private float p_renamed;
    private float q_renamed;
    private android.view.animation.Interpolator r_renamed;
    private boolean s_renamed;
    private float t_renamed;
    private android.animation.ValueAnimator u_renamed;

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.o_renamed) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a_renamed(true);
            } else if (action == 1 || action == 3) {
                a_renamed(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final boolean z_renamed) {
        this.s_renamed = false;
        b_renamed(z_renamed);
        if (this.s_renamed) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.p_renamed;
        fArr[1] = z_renamed ? this.q_renamed : 1.0f;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z_renamed ? 1.0f : this.t_renamed;
        fArr2[1] = z_renamed ? 0.92f : 1.0f;
        this.u_renamed = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.u_renamed.setInterpolator(this.r_renamed);
        this.u_renamed.setDuration(z_renamed ? 200L : 340L);
        this.u_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.t_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.s_renamed && z_renamed && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.a_renamed(false);
                } else {
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.p_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView tabContainerTextView = com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this;
                    tabContainerTextView.setScale(tabContainerTextView.t_renamed);
                }
            }
        });
        this.u_renamed.start();
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.u_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.s_renamed = !z_renamed && ((float) this.u_renamed.getCurrentPlayTime()) < ((float) this.u_renamed.getDuration()) * 0.4f;
        if (this.s_renamed) {
            return;
        }
        this.u_renamed.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    public TabContainerTextView(android.content.Context context) {
        this(context, null);
    }

    public TabContainerTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabContainerTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6398a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f6399b = new android.animation.ArgbEvaluator();
        this.f6400c = false;
        this.d_renamed = false;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 0;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = true;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.i_renamed = context.getColorStateList(com.oplus.camera.R_renamed.color.face_beauty_text_color);
        this.j_renamed = context.getColorStateList(com.oplus.camera.R_renamed.color.face_beauty_tab_bg_color_list);
        setTextColor(this.i_renamed);
        this.k_renamed = com.oplus.camera.R_renamed.drawable.face_beauty_custom_tab_text_bg;
        setBackgroundResource(this.k_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this);
        this.p_renamed = 1.0f;
        this.t_renamed = 1.0f;
        if (this.o_renamed) {
            this.q_renamed = 0.8f;
        }
        this.r_renamed = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 2);
        if (this.f6400c && a_renamed()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        if (this.d_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    private boolean a_renamed() {
        if (this.f_renamed) {
            return true;
        }
        int i_renamed = this.e_renamed;
        return (i_renamed == 90 || i_renamed == 270) ? false : true;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.f6400c = z_renamed;
        refreshDrawableState();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z_renamed) {
        boolean zIsSelected = isSelected();
        this.l_renamed = getDrawableState();
        super.setSelected(z_renamed);
        this.m_renamed = getDrawableState();
        if (zIsSelected != z_renamed) {
            android.animation.Animator animator = this.g_renamed;
            if (animator != null && animator.isRunning()) {
                this.g_renamed.cancel();
            }
            android.animation.Animator animator2 = this.h_renamed;
            if (animator2 != null && animator2.isRunning()) {
                this.h_renamed.cancel();
            }
            if (z_renamed) {
                this.g_renamed = b_renamed();
            } else {
                this.h_renamed = b_renamed();
            }
        }
    }

    private android.animation.Animator b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TabContainerTextView", "executeShowAnimator.");
        int colorForState = this.i_renamed.getColorForState(this.l_renamed, 0);
        int colorForState2 = this.i_renamed.getColorForState(this.m_renamed, 0);
        int colorForState3 = this.j_renamed.getColorForState(this.l_renamed, 0);
        int colorForState4 = this.j_renamed.getColorForState(this.m_renamed, 0);
        android.graphics.drawable.StateListDrawable stateListDrawable = (android.graphics.drawable.StateListDrawable) getBackground();
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        if (stateListDrawable != null) {
            android.animation.ValueAnimator valueAnimatorOfObject = android.animation.ValueAnimator.ofObject(this.f6399b, java.lang.Integer.valueOf(colorForState), java.lang.Integer.valueOf(colorForState2));
            valueAnimatorOfObject.setInterpolator(this.f6398a);
            valueAnimatorOfObject.setDuration(200L);
            valueAnimatorOfObject.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.setTextColor(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.n_renamed = (android.graphics.drawable.GradientDrawable) stateListDrawable.getCurrent();
            android.animation.ValueAnimator valueAnimatorOfObject2 = android.animation.ValueAnimator.ofObject(this.f6399b, java.lang.Integer.valueOf(colorForState3), java.lang.Integer.valueOf(colorForState4));
            valueAnimatorOfObject2.setInterpolator(this.f6398a);
            valueAnimatorOfObject2.setDuration(200L);
            valueAnimatorOfObject2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.n_renamed.setColor(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            animatorSet.play(valueAnimatorOfObject).with(valueAnimatorOfObject2);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView tabContainerTextView = com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this;
                    tabContainerTextView.setTextColor(tabContainerTextView.i_renamed);
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.setBackground(null);
                    com.oplus.camera.ui.menu.facebeauty.TabContainerTextView tabContainerTextView2 = com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this;
                    tabContainerTextView2.setBackgroundResource(tabContainerTextView2.k_renamed);
                    com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this.getContext(), com.oplus.camera.ui.menu.facebeauty.TabContainerTextView.this);
                }
            });
            animatorSet.start();
        }
        return animatorSet;
    }

    public void setLightBgColor(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TabContainerTextView", "setBackgroundRes, isLight: " + z_renamed);
        if (z_renamed == this.d_renamed) {
            return;
        }
        this.d_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    public void setOrientation(int i_renamed) {
        this.e_renamed = i_renamed;
        refreshDrawableState();
        invalidate();
    }

    public void setHorizontalInverseAble(boolean z_renamed) {
        this.f_renamed = z_renamed;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        android.animation.Animator animator = this.g_renamed;
        if (animator != null && animator.isRunning()) {
            this.g_renamed.cancel();
        }
        android.animation.Animator animator2 = this.h_renamed;
        if (animator2 != null && animator2.isRunning()) {
            this.h_renamed.cancel();
        }
        this.n_renamed = null;
        super.onDetachedFromWindow();
    }
}
