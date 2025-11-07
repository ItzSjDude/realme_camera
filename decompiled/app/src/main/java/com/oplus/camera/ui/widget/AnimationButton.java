package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class AnimationButton extends androidx.appcompat.widget.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.String f7188a = "AnimationButton";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f7189b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f7190c;
    private android.animation.ValueAnimator e_renamed;
    private android.animation.ValueAnimator f_renamed;
    private final android.graphics.Paint g_renamed;
    private android.graphics.Rect h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private float p_renamed;
    private float q_renamed;
    private float r_renamed;
    private float s_renamed;
    private float[] t_renamed;
    private android.content.Context u_renamed;

    public AnimationButton(android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    public AnimationButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.oplus.camera.R_renamed.attr.buttonStyle);
    }

    public AnimationButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7189b = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        this.f7190c = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = new android.graphics.Paint(1);
        this.h_renamed = new android.graphics.Rect();
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = 1;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 21.0f;
        this.p_renamed = 0.0f;
        this.q_renamed = 0.0f;
        this.r_renamed = 0.0f;
        this.s_renamed = 0.0f;
        this.t_renamed = new float[3];
        this.u_renamed = null;
        this.q_renamed = 1.0f;
        this.r_renamed = 1.0f;
        this.s_renamed = 1.0f;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.n_renamed = attributeSet.getStyleAttribute();
        } else {
            this.n_renamed = i_renamed;
        }
        this.u_renamed = context;
        com.coui.appcompat.a_renamed.e_renamed.a_renamed(this, false);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.AnimationButton, i_renamed, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.k_renamed = typedArrayObtainStyledAttributes.getInteger(1, 1);
        if (this.j_renamed) {
            this.p_renamed = typedArrayObtainStyledAttributes.getFloat(2, 0.8f);
            this.o_renamed = typedArrayObtainStyledAttributes.getDimension(5, 7.0f);
            this.m_renamed = typedArrayObtainStyledAttributes.getColor(3, 0);
            this.l_renamed = typedArrayObtainStyledAttributes.getColor(4, 0);
            a_renamed();
        }
        typedArrayObtainStyledAttributes.recycle();
        com.coui.appcompat.a_renamed.a_renamed.a_renamed(this, 4);
    }

    private void a_renamed() {
        if (1 == this.k_renamed) {
            setBackgroundDrawable((android.graphics.drawable.Drawable) null);
        }
    }

    @Override // androidx.appcompat.widget.f_renamed, android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.h_renamed.right = getWidth();
        this.h_renamed.bottom = getHeight();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.j_renamed) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (1 == this.k_renamed) {
                this.g_renamed.setColor(a_renamed(this.l_renamed));
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.h_renamed, this.o_renamed), this.g_renamed);
            }
            canvas.restoreToCount(iSave);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.j_renamed) {
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
        this.i_renamed = false;
        b_renamed(z_renamed);
        if (this.i_renamed) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.q_renamed;
        fArr[1] = z_renamed ? this.p_renamed : 1.0f;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z_renamed ? 1.0f : this.r_renamed;
        fArr2[1] = z_renamed ? 0.92f : 1.0f;
        this.e_renamed = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.e_renamed.setInterpolator(this.f7189b);
        this.e_renamed.setDuration(z_renamed ? 200L : 340L);
        this.e_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.AnimationButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.widget.AnimationButton.this.r_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                float duration = valueAnimator.getDuration() * 0.4f;
                if (com.oplus.camera.ui.widget.AnimationButton.this.i_renamed && z_renamed && valueAnimator.getCurrentPlayTime() > duration) {
                    valueAnimator.cancel();
                    com.oplus.camera.ui.widget.AnimationButton.this.a_renamed(false);
                } else {
                    com.oplus.camera.ui.widget.AnimationButton.this.q_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    com.oplus.camera.ui.widget.AnimationButton animationButton = com.oplus.camera.ui.widget.AnimationButton.this;
                    animationButton.setScale(animationButton.r_renamed);
                }
            }
        });
        this.e_renamed.start();
        float[] fArr3 = new float[2];
        fArr3[0] = z_renamed ? 1.0f : this.s_renamed;
        fArr3[1] = z_renamed ? 2.0f : 1.0f;
        this.f_renamed = android.animation.ValueAnimator.ofPropertyValuesHolder(android.animation.PropertyValuesHolder.ofFloat("alphaHolder", fArr3));
        this.f_renamed.setInterpolator(this.f7190c);
        this.f_renamed.setDuration(200L);
        this.f_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.AnimationButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.widget.AnimationButton.this.s_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("alphaHolder")).floatValue();
            }
        });
        this.f_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.e_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.i_renamed = !z_renamed && ((float) this.e_renamed.getCurrentPlayTime()) < ((float) this.e_renamed.getDuration()) * 0.4f;
            if (!this.i_renamed) {
                this.e_renamed.cancel();
            }
        }
        android.animation.ValueAnimator valueAnimator2 = this.f_renamed;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.i_renamed = !z_renamed && ((float) this.f_renamed.getCurrentPlayTime()) < ((float) this.f_renamed.getDuration()) * 0.4f;
        if (this.i_renamed) {
            return;
        }
        this.f_renamed.cancel();
    }

    private int a_renamed(int i_renamed) {
        if (!isEnabled()) {
            return this.m_renamed;
        }
        androidx.core.graphics.d_renamed.a_renamed(i_renamed, this.t_renamed);
        float[] fArr = this.t_renamed;
        fArr[2] = fArr[2] * this.q_renamed;
        int iA = androidx.core.graphics.d_renamed.a_renamed(fArr);
        return android.graphics.Color.argb((int) (this.s_renamed * android.graphics.Color.alpha(i_renamed)), java.lang.Math.min(255, android.graphics.Color.red(iA)), java.lang.Math.min(255, android.graphics.Color.green(iA)), java.lang.Math.min(255, android.graphics.Color.blue(iA)));
    }

    public void setAnimEnable(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    public void setAnimType(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    public void setDisabledColor(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    public void setDrawableColor(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    public void setDrawableRadius(int i_renamed) {
        this.o_renamed = i_renamed;
    }

    public void setMaxBrightness(int i_renamed) {
        this.p_renamed = i_renamed;
    }
}
