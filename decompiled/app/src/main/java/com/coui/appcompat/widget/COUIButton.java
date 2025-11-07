package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIButton extends androidx.appcompat.widget.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.String f2691a = "COUIButton";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f2692b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f2693c;
    private boolean e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private final android.graphics.Paint h_renamed;
    private int i_renamed;
    private int j_renamed;
    private float k_renamed;
    private float l_renamed;
    private float m_renamed;
    private float n_renamed;
    private float o_renamed;
    private float p_renamed;
    private int q_renamed;
    private android.graphics.Rect r_renamed;
    private android.graphics.Rect s_renamed;
    private float[] t_renamed;
    private int u_renamed;

    public COUIButton(android.content.Context context) {
        this(context, null);
    }

    public COUIButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.buttonStyle);
    }

    public COUIButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.h_renamed = new android.graphics.Paint(1);
        this.k_renamed = 21.0f;
        this.m_renamed = 1.0f;
        this.n_renamed = 1.0f;
        this.r_renamed = new android.graphics.Rect();
        this.s_renamed = new android.graphics.Rect();
        this.t_renamed = new float[3];
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.u_renamed = attributeSet.getStyleAttribute();
        } else {
            this.u_renamed = i_renamed;
        }
        com.coui.appcompat.a_renamed.e_renamed.a_renamed(this, false);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIButton, i_renamed, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIButton_animEnable, false);
        this.g_renamed = typedArrayObtainStyledAttributes.getInteger(coui.support.appcompat.R_renamed.styleable.COUIButton_animType, 1);
        if (this.f_renamed) {
            this.l_renamed = typedArrayObtainStyledAttributes.getFloat(coui.support.appcompat.R_renamed.styleable.COUIButton_brightness, 0.8f);
            this.k_renamed = typedArrayObtainStyledAttributes.getDimension(coui.support.appcompat.R_renamed.styleable.COUIButton_drawableRadius, 7.0f);
            this.j_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIButton_disabledColor, 0);
            this.i_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIButton_drawableColor, 0);
            this.q_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIButton_strokeColor, 0);
            a_renamed();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.o_renamed = context.getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_bordless_btn_stroke_width);
        this.p_renamed = getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_button_radius_offset);
        com.coui.appcompat.a_renamed.a_renamed.a_renamed(this, 4);
    }

    private void a_renamed() {
        if (this.g_renamed == 1) {
            setBackgroundDrawable(null);
        }
        this.f2692b = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // androidx.appcompat.widget.f_renamed, android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.r_renamed.right = getWidth();
        this.r_renamed.bottom = getHeight();
        this.s_renamed.top = (int) (this.r_renamed.top + (this.o_renamed / 2.0f));
        this.s_renamed.left = (int) (this.r_renamed.left + (this.o_renamed / 2.0f));
        this.s_renamed.right = (int) (this.r_renamed.right - (this.o_renamed / 2.0f));
        this.s_renamed.bottom = (int) (this.r_renamed.bottom - (this.o_renamed / 2.0f));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.f_renamed) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.g_renamed == 1) {
                this.h_renamed.setStyle(android.graphics.Paint.Style.FILL);
                this.h_renamed.setColor(a_renamed(this.i_renamed));
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.r_renamed, ((this.r_renamed.bottom - this.r_renamed.top) / 2.0f) - this.p_renamed), this.h_renamed);
            } else {
                this.h_renamed.setColor(isEnabled() ? this.q_renamed : this.j_renamed);
                this.h_renamed.setStrokeWidth(this.o_renamed);
                this.h_renamed.setStyle(android.graphics.Paint.Style.STROKE);
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.s_renamed, ((r2.bottom - this.s_renamed.top) / 2.0f) - this.o_renamed), this.h_renamed);
            }
            canvas.restoreToCount(iSave);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.f_renamed) {
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
        this.e_renamed = false;
        b_renamed(z_renamed);
        if (this.e_renamed) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 1.0f : this.m_renamed;
        fArr[1] = z_renamed ? this.l_renamed : 1.0f;
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z_renamed ? 1.0f : this.n_renamed;
        fArr2[1] = z_renamed ? 0.92f : 1.0f;
        this.f2693c = android.animation.ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f2693c.setInterpolator(this.f2692b);
        this.f2693c.setDuration(z_renamed ? 200L : 340L);
        this.f2693c.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.widget.COUIButton.this.n_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (com.coui.appcompat.widget.COUIButton.this.e_renamed && z_renamed && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    com.coui.appcompat.widget.COUIButton.this.a_renamed(false);
                } else {
                    com.coui.appcompat.widget.COUIButton.this.m_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    com.coui.appcompat.widget.COUIButton cOUIButton = com.coui.appcompat.widget.COUIButton.this;
                    cOUIButton.setScale(cOUIButton.n_renamed);
                }
            }
        });
        this.f2693c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float f_renamed) {
        float fMax = java.lang.Math.max(0.92f, java.lang.Math.min(1.0f, f_renamed));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    private void b_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.f2693c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.e_renamed = !z_renamed && ((float) this.f2693c.getCurrentPlayTime()) < ((float) this.f2693c.getDuration()) * 0.4f;
        if (this.e_renamed) {
            return;
        }
        this.f2693c.cancel();
    }

    private int a_renamed(int i_renamed) {
        if (!isEnabled()) {
            return this.j_renamed;
        }
        androidx.core.graphics.d_renamed.a_renamed(i_renamed, this.t_renamed);
        float[] fArr = this.t_renamed;
        fArr[2] = fArr[2] * this.m_renamed;
        int iA = androidx.core.graphics.d_renamed.a_renamed(fArr);
        return android.graphics.Color.argb(android.graphics.Color.alpha(i_renamed), java.lang.Math.min(255, android.graphics.Color.red(iA)), java.lang.Math.min(255, android.graphics.Color.green(iA)), java.lang.Math.min(255, android.graphics.Color.blue(iA)));
    }

    public void setAnimEnable(boolean z_renamed) {
        this.f_renamed = z_renamed;
    }

    public void setAnimType(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public void setDisabledColor(int i_renamed) {
        this.j_renamed = i_renamed;
    }

    public void setDrawableColor(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public void setDrawableRadius(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    public void setMaxBrightness(int i_renamed) {
        this.l_renamed = i_renamed;
    }
}
