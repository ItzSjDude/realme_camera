package com.coui.appcompat.widget.seekbar;

/* loaded from: classes.dex */
public class COUISeekBar extends android.view.View {
    private int A_renamed;
    private com.coui.appcompat.widget.seekbar.COUISeekBar.c_renamed B_renamed;
    private com.coui.appcompat.widget.seekbar.COUISeekBar.a_renamed C_renamed;
    private android.view.accessibility.AccessibilityManager D_renamed;
    private android.graphics.RectF E_renamed;
    private android.animation.AnimatorSet F_renamed;
    private int G_renamed;
    private float H_renamed;
    private float I_renamed;
    private float J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private float N_renamed;
    private float O_renamed;
    private final com.a_renamed.a_renamed.b_renamed P_renamed;
    private final com.a_renamed.a_renamed.f_renamed Q_renamed;
    private com.a_renamed.a_renamed.g_renamed R_renamed;
    private android.view.VelocityTracker S_renamed;
    private boolean T_renamed;
    private float U_renamed;
    private android.view.animation.Interpolator V_renamed;
    private int W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3088a;
    private java.lang.String aa_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3089b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f3090c;
    private com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private android.content.res.ColorStateList k_renamed;
    private float l_renamed;
    private android.content.res.ColorStateList m_renamed;
    private android.content.res.ColorStateList n_renamed;
    private android.content.res.ColorStateList o_renamed;
    private float p_renamed;
    private float q_renamed;
    private float r_renamed;
    private float s_renamed;
    private android.graphics.RectF t_renamed;
    private android.graphics.RectF u_renamed;
    private android.graphics.RectF v_renamed;
    private float w_renamed;
    private android.graphics.Paint x_renamed;
    private android.animation.ValueAnimator y_renamed;
    private android.animation.AnimatorSet z_renamed;

    public interface b_renamed {
        void a_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar);

        void a_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar, int i_renamed, boolean z_renamed);

        void b_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar);
    }

    public COUISeekBar(android.content.Context context) {
        this(context, null);
    }

    public COUISeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiSeekBarStyle);
    }

    public COUISeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f3088a = getClass().getSimpleName();
        this.f3089b = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 100;
        this.h_renamed = 1;
        this.i_renamed = false;
        this.j_renamed = false;
        this.t_renamed = new android.graphics.RectF();
        this.u_renamed = new android.graphics.RectF();
        this.v_renamed = new android.graphics.RectF();
        this.A_renamed = 1;
        this.E_renamed = new android.graphics.RectF();
        this.F_renamed = new android.animation.AnimatorSet();
        this.P_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed();
        this.Q_renamed = this.P_renamed.b_renamed();
        this.R_renamed = com.a_renamed.a_renamed.g_renamed.a_renamed(500.0d, 30.0d);
        this.T_renamed = false;
        this.U_renamed = 0.4f;
        this.V_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f);
        if (attributeSet != null) {
            this.W_renamed = attributeSet.getStyleAttribute();
        }
        if (this.W_renamed == 0) {
            this.W_renamed = i_renamed;
        }
        com.coui.appcompat.a_renamed.e_renamed.a_renamed(this, false);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUISeekBar, i_renamed, 0);
        this.k_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbColor);
        this.l_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbInScaleRadius, (int) d_renamed(3.67f));
        this.H_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbOutRadius, (int) d_renamed(6.0f));
        this.I_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbOutScaleRadius, (int) d_renamed(7.0f));
        this.r_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarProgressScaleRadius, (int) d_renamed(2.0f));
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.m_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarProgressColor);
        } else {
            this.m_renamed = com.coui.appcompat.a_renamed.r_renamed.a_renamed(com.coui.appcompat.a_renamed.d_renamed.a_renamed(context, coui.support.appcompat.R_renamed.attr.couiTintControlNormal, 0), getResources().getColor(coui.support.appcompat.R_renamed.color.coui_seekbar_progress_color_disabled));
        }
        this.q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarProgressRadius, (int) d_renamed(1.0f));
        this.o_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarBackgroundColor);
        this.p_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarBackgroundRadius, (int) d_renamed(1.0f));
        this.n_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarSecondaryProgressColor);
        this.G_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarBackgroundHighlightColor, getResources().getColor(coui.support.appcompat.R_renamed.color.coui_seekbar_background_highlight_color));
        this.L_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbShadowColor, getResources().getColor(coui.support.appcompat.R_renamed.color.coui_seekbar_thumb_shadow_color));
        this.K_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R_renamed.styleable.COUISeekBar_couiSeekBarThumbShadowRadius, (int) d_renamed(14.0f));
        typedArrayObtainStyledAttributes.recycle();
        d_renamed();
        c_renamed();
        e_renamed();
    }

    private void c_renamed() {
        this.s_renamed = this.q_renamed;
        this.J_renamed = this.H_renamed;
        this.N_renamed = this.p_renamed;
        this.M_renamed = 0;
    }

    private void d_renamed() {
        this.f3089b = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.B_renamed = new com.coui.appcompat.widget.seekbar.COUISeekBar.c_renamed(this);
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.B_renamed);
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
        }
        this.B_renamed.invalidateRoot();
        this.D_renamed = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
        this.x_renamed = new android.graphics.Paint();
        this.x_renamed.setAntiAlias(true);
        this.x_renamed.setDither(true);
    }

    private void e_renamed() {
        this.Q_renamed.a_renamed(this.R_renamed);
        this.Q_renamed.a_renamed(new com.a_renamed.a_renamed.h_renamed() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.1
            @Override // com.a_renamed.a_renamed.h_renamed
            public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void c_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void d_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                if (com.coui.appcompat.widget.seekbar.COUISeekBar.this.O_renamed != fVar.d_renamed()) {
                    if (!com.coui.appcompat.widget.seekbar.COUISeekBar.this.isEnabled()) {
                        com.coui.appcompat.widget.seekbar.COUISeekBar.this.O_renamed = 0.0f;
                        com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
                    } else {
                        com.coui.appcompat.widget.seekbar.COUISeekBar.this.O_renamed = (float) fVar.c_renamed();
                        com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
                    }
                }
            }
        });
        this.F_renamed.setInterpolator(androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f));
        float f_renamed = this.p_renamed;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f_renamed, f_renamed * 2.0f);
        valueAnimatorOfFloat.setDuration(115L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.N_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.s_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                cOUISeekBar.J_renamed = cOUISeekBar.H_renamed + (animatedFraction * ((com.coui.appcompat.widget.seekbar.COUISeekBar.this.H_renamed * 1.722f) - com.coui.appcompat.widget.seekbar.COUISeekBar.this.H_renamed));
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
            }
        });
        float f2 = this.p_renamed;
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(2.0f * f2, f2);
        valueAnimatorOfFloat2.setStartDelay(115L);
        valueAnimatorOfFloat2.setDuration(87L);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                cOUISeekBar.J_renamed = cOUISeekBar.I_renamed + ((1.0f - animatedFraction) * ((com.coui.appcompat.widget.seekbar.COUISeekBar.this.H_renamed * 1.722f) - com.coui.appcompat.widget.seekbar.COUISeekBar.this.I_renamed));
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, this.K_renamed);
        valueAnimatorOfInt.setDuration(202L);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.M_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.F_renamed.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2).with(valueAnimatorOfInt);
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i_renamed);
        int iRound = java.lang.Math.round(this.K_renamed * 2) + getPaddingTop() + getPaddingBottom();
        if (1073741824 != mode || size < iRound) {
            size = iRound;
        }
        setMeasuredDimension(size2, size);
    }

    private int getStart() {
        return getPaddingLeft();
    }

    private int getEnd() {
        return getPaddingRight();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float f_renamed;
        float f2;
        float f3;
        float start;
        float f4;
        this.x_renamed.setColor(com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(this, this.o_renamed));
        float start2 = (getStart() + this.K_renamed) - this.p_renamed;
        float width = ((getWidth() - getEnd()) - this.K_renamed) + this.p_renamed;
        float width2 = ((getWidth() - getEnd()) - (this.K_renamed * 2)) - getStart();
        this.t_renamed.set(start2, (getHeight() >> 1) - this.N_renamed, width, (getHeight() >> 1) + this.N_renamed);
        android.graphics.RectF rectF = this.t_renamed;
        float f5 = this.N_renamed;
        canvas.drawRoundRect(rectF, f5, f5, this.x_renamed);
        if (this.T_renamed) {
            if (isLayoutRtl()) {
                float width3 = getWidth() / 2.0f;
                float f6 = this.e_renamed;
                int i_renamed = this.g_renamed;
                f2 = width3 - (((f6 - (i_renamed / 2.0f)) * width2) / i_renamed);
                f3 = f2;
                f_renamed = width3;
                f4 = f_renamed;
                start = f3;
            } else {
                start = getWidth() / 2.0f;
                float f7 = this.e_renamed;
                int i2 = this.g_renamed;
                f4 = start + (((f7 - (i2 / 2.0f)) * width2) / i2);
                f_renamed = f4;
                f3 = f_renamed;
                f2 = start;
            }
        } else if (isLayoutRtl()) {
            start = getStart() + this.K_renamed + width2;
            float f8 = this.e_renamed * width2;
            int i3 = this.g_renamed;
            f4 = start - ((this.f_renamed * width2) / i3);
            f2 = start;
            f_renamed = start - (f8 / i3);
            f3 = f_renamed;
        } else {
            float start3 = getStart() + this.K_renamed;
            int i4 = this.g_renamed;
            f_renamed = start3;
            f2 = ((this.e_renamed * width2) / i4) + start3;
            f3 = f2;
            start = start3 + ((this.f_renamed * width2) / i4);
            f4 = f_renamed;
        }
        this.x_renamed.setColor(com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(this, this.n_renamed, com.coui.appcompat.widget.seekbar.a_renamed.f3103c));
        this.v_renamed.set(f4, this.t_renamed.top, start, this.t_renamed.bottom);
        canvas.drawRect(this.v_renamed, this.x_renamed);
        if (!this.T_renamed) {
            if (isLayoutRtl()) {
                this.E_renamed.set(width - (this.p_renamed * 2.0f), this.t_renamed.top, width, this.t_renamed.bottom);
                canvas.drawArc(this.E_renamed, -90.0f, 180.0f, true, this.x_renamed);
                if (this.f_renamed == this.g_renamed) {
                    this.E_renamed.set(start2, this.t_renamed.top, (this.p_renamed * 2.0f) + start2, this.t_renamed.bottom);
                    canvas.drawArc(this.E_renamed, 90.0f, 180.0f, true, this.x_renamed);
                }
            } else {
                this.E_renamed.set(start2, this.t_renamed.top, (this.p_renamed * 2.0f) + start2, this.t_renamed.bottom);
                canvas.drawArc(this.E_renamed, 90.0f, 180.0f, true, this.x_renamed);
                if (this.f_renamed == this.g_renamed) {
                    this.E_renamed.set(width - (this.p_renamed * 2.0f), this.t_renamed.top, width, this.t_renamed.bottom);
                    canvas.drawArc(this.E_renamed, -90.0f, 180.0f, true, this.x_renamed);
                }
            }
        }
        this.x_renamed.setColor(com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(this, this.m_renamed, com.coui.appcompat.widget.seekbar.a_renamed.f3102b));
        this.u_renamed.set(f_renamed, (getHeight() >> 1) - this.s_renamed, f2, (getHeight() >> 1) + this.s_renamed);
        canvas.drawRect(this.u_renamed, this.x_renamed);
        if (!this.T_renamed) {
            if (isLayoutRtl()) {
                this.E_renamed.set((width - this.p_renamed) - this.s_renamed, this.u_renamed.top, (width - this.p_renamed) + this.s_renamed, this.u_renamed.bottom);
                canvas.drawArc(this.E_renamed, -90.0f, 180.0f, true, this.x_renamed);
            } else {
                this.E_renamed.set(f_renamed - this.s_renamed, this.u_renamed.top, f_renamed + this.s_renamed, this.u_renamed.bottom);
                canvas.drawArc(this.E_renamed, 90.0f, 180.0f, true, this.x_renamed);
            }
        } else if (isLayoutRtl()) {
            this.E_renamed.set(f_renamed - this.s_renamed, this.u_renamed.top, f_renamed + this.s_renamed, this.u_renamed.bottom);
            canvas.drawArc(this.E_renamed, -90.0f, 360.0f, true, this.x_renamed);
        } else {
            this.E_renamed.set(f2 - this.s_renamed, this.u_renamed.top, f2 + this.s_renamed, this.u_renamed.bottom);
            canvas.drawArc(this.E_renamed, 90.0f, 360.0f, true, this.x_renamed);
        }
        int i5 = this.M_renamed;
        float f9 = f3 - i5;
        float f10 = i5 + f3;
        float f11 = this.J_renamed;
        float f12 = f3 - f11;
        float f13 = f3 + f11;
        float f14 = this.O_renamed;
        float f15 = this.l_renamed * 2.0f * 2.0f * f14;
        if (f14 > 0.0f) {
            f9 -= f15;
            f12 -= f15;
        } else {
            f10 -= f15;
            f13 -= f15;
        }
        float f16 = f12;
        float f17 = f10;
        this.x_renamed.setColor(this.L_renamed);
        float height = (getHeight() >> 1) - this.M_renamed;
        int height2 = getHeight() >> 1;
        int i6 = this.M_renamed;
        canvas.drawRoundRect(f9, height, f17, height2 + i6, i6, i6, this.x_renamed);
        this.x_renamed.setColor(com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(this, this.m_renamed, com.coui.appcompat.widget.seekbar.a_renamed.f3102b));
        float height3 = (getHeight() >> 1) - this.J_renamed;
        float height4 = getHeight() >> 1;
        float f18 = this.J_renamed;
        canvas.drawRoundRect(f16, height3, f13, height4 + f18, f18, f18, this.x_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x0094  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r6.getAction()
            r2 = 1
            if (r0 == 0) goto Lb7
            if (r0 == r2) goto L94
            r3 = 2
            if (r0 == r3) goto L19
            r3 = 3
            if (r0 == r3) goto L94
            goto Ld2
        L19:
            android.view.VelocityTracker r0 = r5.S_renamed
            r0.addMovement(r6)
            int r0 = r5.getWidth()
            int r4 = r5.getEnd()
            int r0 = r0 - r4
            int r4 = r5.K_renamed
            int r4 = r4 * r3
            int r0 = r0 - r4
            int r3 = r5.getStart()
            int r0 = r0 - r3
            float r0 = (float) r0
            int r3 = r5.e_renamed
            float r3 = (float) r3
            float r3 = r3 * r0
            int r4 = r5.g_renamed
            float r4 = (float) r4
            float r3 = r3 / r4
            boolean r4 = r5.T_renamed
            if (r4 == 0) goto L57
            r4 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r4
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 != 0) goto L57
            float r0 = r6.getX()
            float r3 = r5.w_renamed
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            r3 = 1101004800(0x41a00000, float:20.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L57
            goto Ld2
        L57:
            boolean r0 = r5.i_renamed
            if (r0 == 0) goto L6e
            boolean r0 = r5.j_renamed
            if (r0 == 0) goto L6e
            int r0 = r5.A_renamed
            if (r0 == 0) goto L6a
            if (r0 == r2) goto L66
            goto Ld2
        L66:
            r5.c_renamed(r6)
            goto Ld2
        L6a:
            r5.d_renamed(r6)
            goto Ld2
        L6e:
            boolean r0 = com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(r6, r5)
            if (r0 != 0) goto L75
            return r1
        L75:
            float r0 = r6.getX()
            float r1 = r5.f3090c
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r3 = r5.f3089b
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto Ld2
            r5.b_renamed(r6)
            r5.a_renamed(r6)
            r5.g_renamed()
            r5.w_renamed = r0
            goto Ld2
        L94:
            com.a_renamed.a_renamed.f_renamed r0 = r5.Q_renamed
            r3 = 0
            r0.b_renamed(r3)
            boolean r0 = r5.i_renamed
            if (r0 == 0) goto La9
            r5.b_renamed()
            r5.setPressed(r1)
            r5.h_renamed()
            goto Ld2
        La9:
            boolean r0 = com.coui.appcompat.widget.seekbar.a_renamed.a_renamed(r6, r5)
            if (r0 == 0) goto Ld2
            float r6 = r6.getX()
            r5.a_renamed(r6)
            goto Ld2
        Lb7:
            r5.i_renamed = r1
            r5.j_renamed = r1
            float r0 = r6.getX()
            r5.f3090c = r0
            float r0 = r6.getX()
            r5.w_renamed = r0
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r5.S_renamed = r0
            android.view.VelocityTracker r5 = r5.S_renamed
            r5.addMovement(r6)
        Ld2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.seekbar.COUISeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void a_renamed(float f_renamed) {
        int iRound;
        float width = ((getWidth() - getEnd()) - (this.K_renamed * 2)) - getStart();
        if (isLayoutRtl()) {
            int i_renamed = this.g_renamed;
            iRound = i_renamed - java.lang.Math.round((i_renamed * ((f_renamed - getStart()) - this.r_renamed)) / width);
        } else {
            iRound = java.lang.Math.round((this.g_renamed * ((f_renamed - getStart()) - this.r_renamed)) / width);
        }
        a_renamed(b_renamed(iRound));
    }

    private void a_renamed(int i_renamed) {
        if (this.z_renamed == null) {
            this.z_renamed = new android.animation.AnimatorSet();
            this.z_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.a_renamed();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.coui.appcompat.widget.seekbar.COUISeekBar.this.d_renamed != null) {
                        com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = com.coui.appcompat.widget.seekbar.COUISeekBar.this.d_renamed;
                        com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                        bVar.a_renamed(cOUISeekBar, cOUISeekBar.e_renamed, true);
                    }
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.b_renamed();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if (com.coui.appcompat.widget.seekbar.COUISeekBar.this.d_renamed != null) {
                        com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = com.coui.appcompat.widget.seekbar.COUISeekBar.this.d_renamed;
                        com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                        bVar.a_renamed(cOUISeekBar, cOUISeekBar.e_renamed, true);
                    }
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.b_renamed();
                }
            });
        }
        this.z_renamed.cancel();
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(this.e_renamed, i_renamed);
        valueAnimatorOfInt.setInterpolator(androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.33f, 0.0f, 0.67f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.e_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
            }
        });
        long jAbs = (long) ((java.lang.Math.abs(i_renamed - r0) / this.g_renamed) * 400.0f);
        if (jAbs < 150) {
            jAbs = 150;
        }
        this.z_renamed.setDuration(jAbs);
        this.z_renamed.play(valueAnimatorOfInt);
        this.z_renamed.start();
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        int i_renamed = this.e_renamed;
        float width = ((getWidth() - getEnd()) - (this.K_renamed * 2)) - getStart();
        if (isLayoutRtl()) {
            int i2 = this.g_renamed;
            this.e_renamed = i2 - java.lang.Math.round((i2 * ((motionEvent.getX() - getStart()) - this.r_renamed)) / width);
        } else {
            this.e_renamed = java.lang.Math.round((this.g_renamed * ((motionEvent.getX() - getStart()) - this.r_renamed)) / width);
        }
        this.e_renamed = b_renamed(this.e_renamed);
        int i3 = this.e_renamed;
        if (i_renamed != i3) {
            com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = this.d_renamed;
            if (bVar != null) {
                bVar.a_renamed(this, i3, true);
            }
            i_renamed();
        }
        invalidate();
    }

    private void b_renamed(android.view.MotionEvent motionEvent) {
        setPressed(true);
        a_renamed();
        f_renamed();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        this.j_renamed = false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c_renamed(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getX()
            float r1 = r5.w_renamed
            float r0 = r0 - r1
            float r1 = r6.getX()
            float r1 = r5.b_renamed(r1)
            float r0 = r0 * r1
            float r1 = r5.w_renamed
            float r0 = r0 + r1
            int r0 = java.lang.Math.round(r0)
            float r6 = r6.getY()
            java.lang.Math.round(r6)
            int r6 = r5.getWidth()
            int r1 = r5.getEnd()
            int r1 = r6 - r1
            float r1 = (float) r1
            float r2 = r5.r_renamed
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r3
            float r1 = r1 - r2
            int r2 = r5.getStart()
            float r2 = (float) r2
            float r1 = r1 - r2
            int r1 = java.lang.Math.round(r1)
            boolean r2 = r5.isLayoutRtl()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r2 == 0) goto L59
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L4a
            goto L5f
        L4a:
            int r6 = r5.getPaddingLeft()
            if (r0 >= r6) goto L51
            goto L73
        L51:
            int r6 = r1 - r0
            int r2 = r5.getPaddingLeft()
            int r6 = r6 + r2
            goto L6f
        L59:
            int r2 = r5.getPaddingLeft()
            if (r0 >= r2) goto L61
        L5f:
            r3 = r4
            goto L73
        L61:
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L69
            goto L73
        L69:
            int r6 = r5.getPaddingLeft()
            int r6 = r0 - r6
        L6f:
            float r6 = (float) r6
            float r1 = (float) r1
            float r3 = r6 / r1
        L73:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r3 = r3 * r6
            float r4 = r4 + r3
            int r6 = r5.e_renamed
            int r1 = java.lang.Math.round(r4)
            int r1 = r5.b_renamed(r1)
            r5.e_renamed = r1
            r5.invalidate()
            int r1 = r5.e_renamed
            if (r6 == r1) goto L9b
            float r6 = (float) r0
            r5.w_renamed = r6
            com.coui.appcompat.widget.seekbar.COUISeekBar$b_renamed r6 = r5.d_renamed
            if (r6 == 0) goto L98
            r0 = 1
            r6.a_renamed(r5, r1, r0)
        L98:
            r5.i_renamed()
        L9b:
            android.view.VelocityTracker r6 = r5.S_renamed
            r0 = 100
            r6.computeCurrentVelocity(r0)
            android.view.VelocityTracker r6 = r5.S_renamed
            float r6 = r6.getXVelocity()
            r5.c_renamed(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.seekbar.COUISeekBar.c_renamed(android.view.MotionEvent):void");
    }

    private void d_renamed(android.view.MotionEvent motionEvent) {
        float x_renamed = motionEvent.getX();
        float f_renamed = x_renamed - this.w_renamed;
        if (isLayoutRtl()) {
            f_renamed = -f_renamed;
        }
        int iB = b_renamed(this.e_renamed + java.lang.Math.round(((f_renamed * b_renamed(x_renamed)) / (((getWidth() - getEnd()) - (this.K_renamed * 2)) - getStart())) * this.g_renamed));
        int i_renamed = this.e_renamed;
        this.e_renamed = iB;
        invalidate();
        int i2 = this.e_renamed;
        if (i_renamed != i2) {
            this.w_renamed = x_renamed;
            com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = this.d_renamed;
            if (bVar != null) {
                bVar.a_renamed(this, i2, true);
            }
            i_renamed();
        }
        this.S_renamed.computeCurrentVelocity(100);
        c_renamed(this.S_renamed.getXVelocity());
    }

    private float b_renamed(float f_renamed) {
        float width = ((getWidth() - getEnd()) - (this.K_renamed * 2)) - getStart();
        float f2 = width / 2.0f;
        float interpolation = 1.0f - this.V_renamed.getInterpolation(java.lang.Math.abs(f_renamed - f2) / f2);
        return (f_renamed > width - ((float) getPaddingRight()) || f_renamed < ((float) getPaddingLeft()) || interpolation < this.U_renamed) ? this.U_renamed : interpolation;
    }

    private void c_renamed(float f_renamed) {
        if (this.Q_renamed.c_renamed() == this.Q_renamed.d_renamed()) {
            if (f_renamed >= 95.0f) {
                int i_renamed = this.e_renamed;
                double d_renamed = i_renamed;
                int i2 = this.g_renamed;
                if (d_renamed > i2 * 0.95d || i_renamed < i2 * 0.05d) {
                    return;
                }
                this.Q_renamed.b_renamed(1.0d);
                return;
            }
            if (f_renamed <= -95.0f) {
                int i3 = this.e_renamed;
                double d2 = i3;
                int i4 = this.g_renamed;
                if (d2 > i4 * 0.95d || i3 < i4 * 0.05d) {
                    return;
                }
                this.Q_renamed.b_renamed(-1.0d);
                return;
            }
            this.Q_renamed.b_renamed(0.0d);
        }
    }

    private void f_renamed() {
        if (getParent() instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        }
    }

    private float d_renamed(float f_renamed) {
        return android.util.TypedValue.applyDimension(1, f_renamed, getResources().getDisplayMetrics());
    }

    private int b_renamed(int i_renamed) {
        return java.lang.Math.max(0, java.lang.Math.min(i_renamed, this.g_renamed));
    }

    void a_renamed() {
        this.i_renamed = true;
        this.j_renamed = true;
        com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.a_renamed(this);
        }
    }

    private void g_renamed() {
        if (this.F_renamed.isRunning()) {
            this.F_renamed.cancel();
        }
        this.F_renamed.start();
    }

    private void h_renamed() {
        if (this.y_renamed == null) {
            this.y_renamed = new android.animation.ValueAnimator();
            this.y_renamed.setValues(android.animation.PropertyValuesHolder.ofFloat("radiusOut", this.J_renamed, this.H_renamed), android.animation.PropertyValuesHolder.ofFloat("progress", this.s_renamed, this.q_renamed), android.animation.PropertyValuesHolder.ofInt("thumbShadowRadius", this.M_renamed, 0), android.animation.PropertyValuesHolder.ofFloat("backgroundRadius", this.N_renamed, this.p_renamed));
            this.y_renamed.setDuration(120L);
            if (android.os.Build.VERSION.SDK_INT > 21) {
                this.y_renamed.setInterpolator(androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.0f, 0.0f, 0.2f, 1.0f));
            }
            this.y_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.s_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("progress")).floatValue();
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.J_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("radiusOut")).floatValue();
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.M_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue("thumbShadowRadius")).intValue();
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.N_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue("backgroundRadius")).floatValue();
                    com.coui.appcompat.widget.seekbar.COUISeekBar.this.invalidate();
                }
            });
        }
        this.F_renamed.cancel();
        this.y_renamed.cancel();
        this.y_renamed.start();
    }

    void b_renamed() {
        this.i_renamed = false;
        this.j_renamed = false;
        com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.b_renamed(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        com.coui.appcompat.widget.seekbar.COUISeekBar.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        super.onDetachedFromWindow();
    }

    private class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.seekbar.COUISeekBar f3098a;

        @Override // java.lang.Runnable
        public void run() {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                this.f3098a.announceForAccessibility(this.f3098a.e_renamed + "");
            }
        }
    }

    private final class c_renamed extends androidx.customview.a_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.graphics.Rect f3100b;

        public c_renamed(android.view.View view) {
            super(view);
            this.f3100b = new android.graphics.Rect();
        }

        @Override // androidx.customview.a_renamed.a_renamed, androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.H_renamed);
            }
            dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.AccessibilityNodeInfoCompat_5.a_renamed(1, 0.0f, com.coui.appcompat.widget.seekbar.COUISeekBar.this.getMax(), com.coui.appcompat.widget.seekbar.COUISeekBar.this.e_renamed));
            if (com.coui.appcompat.widget.seekbar.COUISeekBar.this.isEnabled()) {
                int progress = com.coui.appcompat.widget.seekbar.COUISeekBar.this.getProgress();
                if (progress > 0) {
                    dVar.a_renamed(8192);
                }
                if (progress < com.coui.appcompat.widget.seekbar.COUISeekBar.this.getMax()) {
                    dVar.a_renamed(4096);
                }
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected int getVirtualViewAt(float f_renamed, float f2) {
            return (f_renamed < 0.0f || f_renamed > ((float) com.coui.appcompat.widget.seekbar.COUISeekBar.this.getWidth()) || f2 < 0.0f || f2 > ((float) com.coui.appcompat.widget.seekbar.COUISeekBar.this.getHeight())) ? -1 : 0;
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void getVisibleVirtualViews(java.util.List<java.lang.Integer> list) {
            for (int i_renamed = 0; i_renamed < 1; i_renamed++) {
                list.add(java.lang.Integer.valueOf(i_renamed));
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onPopulateEventForVirtualView(int i_renamed, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getClass().getSimpleName());
            accessibilityEvent.setItemCount(com.coui.appcompat.widget.seekbar.COUISeekBar.this.g_renamed);
            accessibilityEvent.setCurrentItemIndex(com.coui.appcompat.widget.seekbar.COUISeekBar.this.e_renamed);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onPopulateNodeForVirtualView(int i_renamed, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            dVar.e_renamed("");
            dVar.b_renamed((java.lang.CharSequence) com.coui.appcompat.widget.seekbar.COUISeekBar.class.getName());
            dVar.b_renamed(a_renamed(i_renamed));
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
            if (super.performAccessibilityAction(view, i_renamed, bundle)) {
                return true;
            }
            if (!com.coui.appcompat.widget.seekbar.COUISeekBar.this.isEnabled()) {
                return false;
            }
            if (i_renamed == 4096) {
                com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                cOUISeekBar.a_renamed(cOUISeekBar.getProgress() + com.coui.appcompat.widget.seekbar.COUISeekBar.this.h_renamed, false, true);
                com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar2 = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
                cOUISeekBar2.announceForAccessibility(cOUISeekBar2.aa_renamed);
                return true;
            }
            if (i_renamed != 8192) {
                return false;
            }
            com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar3 = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
            cOUISeekBar3.a_renamed(cOUISeekBar3.getProgress() - com.coui.appcompat.widget.seekbar.COUISeekBar.this.h_renamed, false, true);
            com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar4 = com.coui.appcompat.widget.seekbar.COUISeekBar.this;
            cOUISeekBar4.announceForAccessibility(cOUISeekBar4.aa_renamed);
            return true;
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected boolean onPerformActionForVirtualView(int i_renamed, int i2, android.os.Bundle bundle) {
            sendEventForVirtualView(i_renamed, 4);
            return false;
        }

        private android.graphics.Rect a_renamed(int i_renamed) {
            android.graphics.Rect rect = this.f3100b;
            rect.left = 0;
            rect.top = 0;
            rect.right = com.coui.appcompat.widget.seekbar.COUISeekBar.this.getWidth();
            rect.bottom = com.coui.appcompat.widget.seekbar.COUISeekBar.this.getHeight();
            return rect;
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public void setProgressContentDescription(java.lang.String str) {
        this.aa_renamed = str;
    }

    public void setProgress(int i_renamed) {
        a_renamed(i_renamed, false);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        a_renamed(i_renamed, z_renamed, false);
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        int i2 = this.e_renamed;
        int iMax = java.lang.Math.max(0, java.lang.Math.min(i_renamed, this.g_renamed));
        if (i2 != iMax) {
            if (z_renamed) {
                a_renamed(iMax);
            } else {
                this.e_renamed = iMax;
                com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar = this.d_renamed;
                if (bVar != null) {
                    bVar.a_renamed(this, iMax, z2);
                }
                invalidate();
            }
            i_renamed();
        }
    }

    public int getProgress() {
        return this.e_renamed;
    }

    public int getMax() {
        return this.g_renamed;
    }

    public void setMax(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = 0;
        }
        if (i_renamed != this.g_renamed) {
            this.g_renamed = i_renamed;
            if (this.e_renamed > i_renamed) {
                this.e_renamed = i_renamed;
            }
        }
        invalidate();
    }

    public void setIncrement(int i_renamed) {
        this.h_renamed = java.lang.Math.abs(i_renamed);
    }

    public void setOnSeekBarChangeListener(com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed bVar) {
        this.d_renamed = bVar;
    }

    public void setSecondaryProgress(int i_renamed) {
        if (i_renamed >= 0) {
            this.f_renamed = java.lang.Math.max(0, java.lang.Math.min(i_renamed, this.g_renamed));
            invalidate();
        }
    }

    public int getSecondaryProgress() {
        return this.f_renamed;
    }

    public boolean isLayoutRtl() {
        return android.os.Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    public void setMoveType(int i_renamed) {
        this.A_renamed = i_renamed;
    }

    public void setStartFromMiddle(boolean z_renamed) {
        this.T_renamed = z_renamed;
    }

    public void setThumbColor(android.content.res.ColorStateList colorStateList) {
        if (this.k_renamed != colorStateList) {
            this.k_renamed = colorStateList;
            invalidate();
        }
    }

    public void setProgressColor(android.content.res.ColorStateList colorStateList) {
        if (this.m_renamed != colorStateList) {
            this.m_renamed = colorStateList;
            invalidate();
        }
    }

    public void setSecondaryProgressColor(android.content.res.ColorStateList colorStateList) {
        if (this.n_renamed != colorStateList) {
            this.n_renamed = colorStateList;
            invalidate();
        }
    }

    public void setSeekBarBackgroundColor(android.content.res.ColorStateList colorStateList) {
        if (this.o_renamed != colorStateList) {
            this.o_renamed = colorStateList;
            invalidate();
        }
    }

    public void setThumbShadowColor(int i_renamed) {
        if (this.L_renamed != i_renamed) {
            this.L_renamed = i_renamed;
            invalidate();
        }
    }

    private void i_renamed() {
        if (this.e_renamed == getMax() || this.e_renamed == 0) {
            performHapticFeedback(306, 0);
        } else {
            performHapticFeedback(305, 0);
        }
    }
}
