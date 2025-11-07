package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUISwitch extends android.widget.CompoundButton {
    private float A_renamed;
    private float B_renamed;
    private int C_renamed;
    private float D_renamed;
    private float E_renamed;
    private float F_renamed;
    private boolean G_renamed;
    private boolean H_renamed;
    private boolean I_renamed;
    private boolean J_renamed;
    private boolean K_renamed;
    private boolean L_renamed;
    private android.graphics.Paint M_renamed;
    private android.graphics.Paint N_renamed;
    private android.graphics.Paint O_renamed;
    private android.graphics.drawable.Drawable P_renamed;
    private android.graphics.drawable.Drawable Q_renamed;
    private android.graphics.drawable.Drawable R_renamed;
    private android.graphics.drawable.Drawable S_renamed;
    private android.graphics.drawable.Drawable T_renamed;
    private android.graphics.drawable.Drawable U_renamed;
    private android.animation.AnimatorSet V_renamed;
    private android.animation.AnimatorSet W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f2844a;
    private android.animation.AnimatorSet aa_renamed;
    private android.animation.AnimatorSet ab_renamed;
    private com.coui.appcompat.a_renamed.q_renamed ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private boolean af_renamed;
    private boolean ag_renamed;
    private android.view.accessibility.AccessibilityManager ah_renamed;
    private com.coui.appcompat.widget.COUISwitch.a_renamed ai_renamed;
    private int aj_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f2845b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f2846c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private android.graphics.RectF v_renamed;
    private android.graphics.RectF w_renamed;
    private int x_renamed;
    private int y_renamed;
    private float z_renamed;

    public interface a_renamed {
        void a_renamed();
    }

    public COUISwitch(android.content.Context context) {
        this(context, null);
    }

    public COUISwitch(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiSwitchStyle);
    }

    public COUISwitch(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.v_renamed = new android.graphics.RectF();
        this.w_renamed = new android.graphics.RectF();
        this.z_renamed = 1.0f;
        this.A_renamed = 1.0f;
        this.G_renamed = false;
        this.H_renamed = false;
        this.V_renamed = new android.animation.AnimatorSet();
        this.ag_renamed = false;
        setSoundEffectsEnabled(false);
        com.coui.appcompat.a_renamed.e_renamed.a_renamed(this, false);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.aj_renamed = attributeSet.getStyleAttribute();
        } else {
            this.aj_renamed = i_renamed;
        }
        this.ah_renamed = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUISwitch, i_renamed, 0);
        this.d_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISwitch_barWidth, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISwitch_barHeight, 0);
        this.i_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerCircleStrokeWidth, 0);
        this.g_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_barUncheckedColor, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_barCheckedColor, 0);
        this.h_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerCircleWidth, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerCircleColor, 0);
        this.k_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerUnCheckedCircleColor, 0);
        this.l_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISwitch_innerCircleWidth, 0);
        this.m_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_innerCircleColor, 0);
        this.t_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUISwitch_circlePadding, 0);
        this.P_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_loadingDrawable);
        this.n_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_barUncheckedDisabledColor, 0);
        this.o_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_barCheckedDisabledColor, 0);
        this.p_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_innerCircleUncheckedDisabledColor, 0);
        this.q_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_innerCircleCheckedDisabledColor, 0);
        this.r_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerCircleUncheckedDisabledColor, 0);
        this.s_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUISwitch_outerCircleCheckedDisabledColor, 0);
        this.Q_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_themedCheckedDrawable);
        this.R_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_themedUncheckedDrawable);
        this.S_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_themedLoadingCheckedBackground);
        this.T_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_themedLoadingUncheckedBackground);
        this.U_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUISwitch_themedLoadingDrawable);
        this.y_renamed = (this.d_renamed - (this.t_renamed * 2)) - this.h_renamed;
        typedArrayObtainStyledAttributes.recycle();
        this.u_renamed = getContext().getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_switch_padding);
        this.L_renamed = getContext().getResources().getBoolean(coui.support.appcompat.R_renamed.bool.coui_switch_theme_enable);
        e_renamed();
        f_renamed();
        this.ac_renamed = com.coui.appcompat.a_renamed.q_renamed.a_renamed();
        this.ad_renamed = this.ac_renamed.a_renamed(context, coui.support.appcompat.R_renamed.raw.coui_switch_sound_on);
        this.ae_renamed = this.ac_renamed.a_renamed(context, coui.support.appcompat.R_renamed.raw.coui_switch_sound_off);
        this.f2844a = getResources().getString(coui.support.appcompat.R_renamed.string.switch_on);
        this.f2845b = getResources().getString(coui.support.appcompat.R_renamed.string.switch_off);
        this.f2846c = getResources().getString(coui.support.appcompat.R_renamed.string.switch_loading);
    }

    private void e_renamed() {
        this.M_renamed = new android.graphics.Paint(1);
        this.N_renamed = new android.graphics.Paint(1);
        this.O_renamed = new android.graphics.Paint(1);
    }

    private void f_renamed() {
        g_renamed();
        h_renamed();
        i_renamed();
    }

    private void g_renamed() {
        android.view.animation.Interpolator interpolatorA = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f);
        this.W_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "circleScale", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(interpolatorA);
        objectAnimatorOfFloat.setDuration(433L);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, "loadingScale", 0.5f, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorA);
        objectAnimatorOfFloat2.setDuration(550L);
        android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this, "loadingAlpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(interpolatorA);
        objectAnimatorOfFloat3.setDuration(550L);
        android.animation.ObjectAnimator objectAnimatorOfFloat4 = android.animation.ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setDuration(800L);
        objectAnimatorOfFloat4.setInterpolator(new android.view.animation.LinearInterpolator());
        this.W_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat4);
    }

    private void h_renamed() {
        android.view.animation.Interpolator interpolatorA = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f);
        this.aa_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "loadingAlpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(interpolatorA);
        objectAnimatorOfFloat.setDuration(100L);
        this.aa_renamed.play(objectAnimatorOfFloat);
    }

    private void i_renamed() {
        this.ab_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setInterpolator(new android.view.animation.LinearInterpolator());
        this.ab_renamed.play(objectAnimatorOfFloat);
    }

    public void setOnLoadingStateChangedListener(com.coui.appcompat.widget.COUISwitch.a_renamed aVar) {
        this.ai_renamed = aVar;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    private void a_renamed(boolean z_renamed) {
        this.ac_renamed.a_renamed(getContext(), z_renamed ? this.ad_renamed : this.ae_renamed, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void j_renamed() {
        if (a_renamed()) {
            performHapticFeedback(302);
            setTactileFeedbackEnabled(false);
        }
    }

    public void setTactileFeedbackEnabled(boolean z_renamed) {
        this.K_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.K_renamed;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        if (z_renamed == isChecked()) {
            return;
        }
        super.setChecked(z_renamed);
        if (!this.L_renamed) {
            z_renamed = isChecked();
            android.animation.AnimatorSet animatorSet = this.V_renamed;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.V_renamed.end();
            }
            if (this.I_renamed && this.J_renamed) {
                b_renamed(z_renamed);
            } else {
                if (o_renamed()) {
                    setCircleTranslation(z_renamed ? 0 : this.y_renamed);
                } else {
                    setCircleTranslation(z_renamed ? this.y_renamed : 0);
                }
                setInnerCircleAlpha(z_renamed ? 0.0f : 1.0f);
                setBarColor(z_renamed ? this.f_renamed : this.g_renamed);
            }
        }
        if (this.af_renamed) {
            a_renamed(z_renamed);
            this.af_renamed = false;
        }
        j_renamed();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:5:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(boolean r11) {
        /*
            r10 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r2 = 1050253722(0x3e99999a, float:0.3)
            r3 = 1036831949(0x3dcccccd, float:0.1)
            android.view.animation.Interpolator r2 = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(r2, r1, r3, r0)
            android.animation.AnimatorSet r3 = r10.V_renamed
            r3.setInterpolator(r2)
            r2 = 2
            float[] r3 = new float[r2]
            r3 = {x00ac: FILL_ARRAY_DATA , data: [1065353216, 1067869798} // fill-array
            java.lang.String r4 = "circleScaleX"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r10, r4, r3)
            r5 = 133(0x85, double:6.57E-322)
            r3.setDuration(r5)
            float[] r7 = new float[r2]
            r7 = {x00b4: FILL_ARRAY_DATA , data: [1067869798, 1065353216} // fill-array
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r10, r4, r7)
            r4.setStartDelay(r5)
            r5 = 250(0xfa, double:1.235E-321)
            r4.setDuration(r5)
            int r5 = r10.getCircleTranslation()
            boolean r6 = r10.o_renamed()
            r7 = 0
            if (r6 == 0) goto L46
            if (r11 == 0) goto L43
        L41:
            r6 = r7
            goto L4a
        L43:
            int r6 = r10.y_renamed
            goto L4a
        L46:
            if (r11 == 0) goto L41
            int r6 = r10.y_renamed
        L4a:
            int[] r8 = new int[r2]
            r8[r7] = r5
            r5 = 1
            r8[r5] = r6
            java.lang.String r6 = "circleTranslation"
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r10, r6, r8)
            r8 = 383(0x17f, double:1.89E-321)
            r6.setDuration(r8)
            float r8 = r10.getInnerCircleAlpha()
            if (r11 == 0) goto L63
            r0 = r1
        L63:
            float[] r1 = new float[r2]
            r1[r7] = r8
            r1[r5] = r0
            java.lang.String r0 = "innerCircleAlpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r10, r0, r1)
            r8 = 100
            r0.setDuration(r8)
            int r1 = r10.getBarColor()
            if (r11 == 0) goto L7d
            int r11 = r10.f_renamed
            goto L7f
        L7d:
            int r11 = r10.g_renamed
        L7f:
            int[] r2 = new int[r2]
            r2[r7] = r1
            r2[r5] = r11
            java.lang.String r11 = "barColor"
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofArgb(r10, r11, r2)
            r1 = 450(0x1c2, double:2.223E-321)
            r11.setDuration(r1)
            android.animation.AnimatorSet r1 = r10.V_renamed
            android.animation.AnimatorSet$Builder r1 = r1.play(r3)
            android.animation.AnimatorSet$Builder r1 = r1.with(r4)
            android.animation.AnimatorSet$Builder r1 = r1.with(r6)
            android.animation.AnimatorSet$Builder r0 = r1.with(r0)
            r0.with(r11)
            android.animation.AnimatorSet r10 = r10.V_renamed
            r10.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUISwitch.b_renamed(boolean):void");
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.L_renamed) {
            a_renamed(canvas);
            f_renamed(canvas);
            return;
        }
        m_renamed();
        n_renamed();
        b_renamed(canvas);
        e_renamed(canvas);
        c_renamed(canvas);
        d_renamed(canvas);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        android.graphics.drawable.Drawable drawableL = l_renamed();
        drawableL.setAlpha(k_renamed());
        int i_renamed = this.u_renamed;
        drawableL.setBounds(i_renamed, i_renamed, this.d_renamed + i_renamed, this.e_renamed + i_renamed);
        l_renamed().draw(canvas);
        canvas.restore();
    }

    private int k_renamed() {
        return (int) ((isEnabled() ? 1.0f : 0.5f) * 255.0f);
    }

    private android.graphics.drawable.Drawable l_renamed() {
        return c_renamed() ? isChecked() ? this.S_renamed : this.T_renamed : isChecked() ? this.Q_renamed : this.R_renamed;
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        this.M_renamed.setColor(this.C_renamed);
        if (!isEnabled()) {
            this.M_renamed.setColor(isChecked() ? this.o_renamed : this.n_renamed);
        }
        float f_renamed = this.e_renamed / 2.0f;
        int i_renamed = this.u_renamed;
        canvas.drawRoundRect(i_renamed, i_renamed, this.d_renamed + i_renamed, r0 + i_renamed, f_renamed, f_renamed, this.M_renamed);
        canvas.restore();
    }

    private void c_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        float f_renamed = this.A_renamed;
        canvas.scale(f_renamed, f_renamed, this.v_renamed.centerX(), this.v_renamed.centerY());
        this.N_renamed.setColor(isChecked() ? this.j_renamed : this.k_renamed);
        if (!isEnabled()) {
            this.N_renamed.setColor(isChecked() ? this.s_renamed : this.r_renamed);
        }
        float f2 = this.h_renamed / 2.0f;
        canvas.drawRoundRect(this.v_renamed, f2, f2, this.N_renamed);
        canvas.restore();
    }

    private void m_renamed() {
        float f_renamed;
        float f2;
        float f3;
        float f4;
        if (isChecked()) {
            if (o_renamed()) {
                f_renamed = this.t_renamed + this.x_renamed + this.u_renamed;
                f2 = this.h_renamed;
                f3 = this.z_renamed;
                f4 = (f2 * f3) + f_renamed;
            } else {
                f4 = ((this.d_renamed - this.t_renamed) - (this.y_renamed - this.x_renamed)) + this.u_renamed;
                f_renamed = f4 - (this.h_renamed * this.z_renamed);
            }
        } else if (o_renamed()) {
            int i_renamed = (this.d_renamed - this.t_renamed) - (this.y_renamed - this.x_renamed);
            int i2 = this.u_renamed;
            float f5 = i_renamed + i2;
            float f6 = i2 + (f5 - (this.h_renamed * this.z_renamed));
            f4 = f5;
            f_renamed = f6;
        } else {
            f_renamed = this.t_renamed + this.x_renamed + this.u_renamed;
            f2 = this.h_renamed;
            f3 = this.z_renamed;
            f4 = (f2 * f3) + f_renamed;
        }
        int i3 = this.e_renamed;
        float f7 = ((i3 - r3) / 2.0f) + this.u_renamed;
        this.v_renamed.set(f_renamed, f7, f4, this.h_renamed + f7);
    }

    private void d_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        float f_renamed = this.A_renamed;
        canvas.scale(f_renamed, f_renamed, this.v_renamed.centerX(), this.v_renamed.centerY());
        float f2 = this.l_renamed / 2.0f;
        this.O_renamed.setColor(this.m_renamed);
        if (!isEnabled()) {
            this.O_renamed.setColor(isChecked() ? this.q_renamed : this.p_renamed);
        }
        float f3 = this.B_renamed;
        if (f3 == 0.0f) {
            this.O_renamed.setAlpha((int) (f3 * 255.0f));
        }
        canvas.drawRoundRect(this.w_renamed, f2, f2, this.O_renamed);
        canvas.restore();
    }

    private void n_renamed() {
        this.w_renamed.set(this.v_renamed.left + this.i_renamed, this.v_renamed.top + this.i_renamed, this.v_renamed.right - this.i_renamed, this.v_renamed.bottom - this.i_renamed);
    }

    private void e_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        float f_renamed = this.D_renamed;
        canvas.scale(f_renamed, f_renamed, this.v_renamed.centerX(), this.v_renamed.centerY());
        canvas.rotate(this.F_renamed, this.v_renamed.centerX(), this.v_renamed.centerY());
        android.graphics.drawable.Drawable drawable = this.P_renamed;
        if (drawable != null) {
            drawable.setBounds((int) this.v_renamed.left, (int) this.v_renamed.top, (int) this.v_renamed.right, (int) this.v_renamed.bottom);
            this.P_renamed.setAlpha((int) (this.E_renamed * 255.0f));
            this.P_renamed.draw(canvas);
        }
        canvas.restore();
    }

    private void f_renamed(android.graphics.Canvas canvas) {
        if (this.G_renamed) {
            int width = (getWidth() - this.h_renamed) / 2;
            int width2 = (getWidth() + this.h_renamed) / 2;
            int height = (getHeight() - this.h_renamed) / 2;
            int height2 = (getHeight() + this.h_renamed) / 2;
            int width3 = getWidth() / 2;
            int height3 = getHeight() / 2;
            canvas.save();
            canvas.rotate(this.F_renamed, width3, height3);
            this.U_renamed.setBounds(width, height, width2, height2);
            this.U_renamed.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.af_renamed = true;
            this.K_renamed = true;
        }
        if (this.H_renamed && motionEvent.getAction() == 1 && isEnabled()) {
            b_renamed();
            return false;
        }
        if (this.G_renamed) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void b_renamed() {
        if (this.G_renamed) {
            return;
        }
        android.view.accessibility.AccessibilityManager accessibilityManager = this.ah_renamed;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            announceForAccessibility(this.f2846c);
        }
        this.G_renamed = true;
        if (this.L_renamed) {
            this.ab_renamed.start();
        } else {
            this.W_renamed.start();
        }
        com.coui.appcompat.widget.COUISwitch.a_renamed aVar = this.ai_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I_renamed = true;
        this.J_renamed = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        int i3 = this.d_renamed;
        int i4 = this.u_renamed;
        setMeasuredDimension(i3 + (i4 * 2), this.e_renamed + (i4 * 2));
        if (this.ag_renamed) {
            return;
        }
        this.ag_renamed = true;
        if (o_renamed()) {
            this.x_renamed = isChecked() ? 0 : this.y_renamed;
        } else {
            this.x_renamed = isChecked() ? this.y_renamed : 0;
        }
        this.B_renamed = isChecked() ? 0.0f : 1.0f;
        this.C_renamed = isChecked() ? this.f_renamed : this.g_renamed;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.I_renamed = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J_renamed = false;
        this.I_renamed = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.animation.AnimatorSet animatorSet = this.V_renamed;
        if (animatorSet == null || !animatorSet.isStarted()) {
            return;
        }
        this.V_renamed.end();
    }

    public void setShouldPlaySound(boolean z_renamed) {
        this.af_renamed = z_renamed;
    }

    public boolean c_renamed() {
        return this.G_renamed;
    }

    public void d_renamed() {
        this.I_renamed = true;
    }

    public void setLoadingStyle(boolean z_renamed) {
        this.H_renamed = z_renamed;
    }

    public void setCircleTranslation(int i_renamed) {
        this.x_renamed = i_renamed;
        invalidate();
    }

    public int getCircleTranslation() {
        return this.x_renamed;
    }

    public void setCircleScaleX(float f_renamed) {
        this.z_renamed = f_renamed;
        invalidate();
    }

    public float getCircleScaleX() {
        return this.z_renamed;
    }

    public void setInnerCircleAlpha(float f_renamed) {
        this.B_renamed = f_renamed;
        invalidate();
    }

    public float getInnerCircleAlpha() {
        return this.B_renamed;
    }

    public void setBarColor(int i_renamed) {
        this.C_renamed = i_renamed;
        invalidate();
    }

    public int getBarColor() {
        return this.C_renamed;
    }

    public void setCircleScale(float f_renamed) {
        this.A_renamed = f_renamed;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
    }

    public float getCircleScale() {
        return this.A_renamed;
    }

    public void setLoadingScale(float f_renamed) {
        this.D_renamed = f_renamed;
        invalidate();
    }

    public float getLoadingScale() {
        return this.D_renamed;
    }

    public void setLoadingAlpha(float f_renamed) {
        this.E_renamed = f_renamed;
        invalidate();
    }

    public float getLoadingAlpha() {
        return this.E_renamed;
    }

    public void setLoadingRotation(float f_renamed) {
        this.F_renamed = f_renamed;
        invalidate();
    }

    public float getLoadingRotation() {
        return this.F_renamed;
    }

    @Override // android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public java.lang.CharSequence getAccessibilityClassName() {
        return android.widget.Switch.class.getName();
    }

    private boolean o_renamed() {
        return android.os.Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.H_renamed) {
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setText(isChecked() ? this.f2844a : this.f2845b);
        } else {
            accessibilityNodeInfo.setText(isChecked() ? this.f2844a : this.f2845b);
        }
    }

    public void setBarWidth(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public void setBarHeight(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public void setOuterCircleStrokeWidth(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public void setOuterCircleWidth(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void setInnerCircleWidth(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    public void setCirclePadding(int i_renamed) {
        this.t_renamed = i_renamed;
    }

    public void setBarUnCheckedColor(int i_renamed) {
        this.g_renamed = i_renamed;
        setBarColor(isChecked() ? this.f_renamed : this.g_renamed);
    }

    public void setBarCheckedColor(int i_renamed) {
        this.f_renamed = i_renamed;
        setBarColor(isChecked() ? this.f_renamed : this.g_renamed);
    }

    public void setInnerCircleColor(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    public void setOuterCircleColor(int i_renamed) {
        this.j_renamed = i_renamed;
    }

    public void setBarUncheckedDisabledColor(int i_renamed) {
        this.n_renamed = i_renamed;
    }

    public void setBarCheckedDisabledColor(int i_renamed) {
        this.o_renamed = i_renamed;
    }

    public void setInnerCircleUncheckedDisabledColor(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    public void setInnerCircleCheckedDisabledColor(int i_renamed) {
        this.q_renamed = i_renamed;
    }

    public void setOuterCircleUncheckedDisabledColor(int i_renamed) {
        this.r_renamed = i_renamed;
    }

    public void setOuterCircleCheckedDisabledColor(int i_renamed) {
        this.s_renamed = i_renamed;
    }

    public void setLoadingDrawable(android.graphics.drawable.Drawable drawable) {
        this.P_renamed = drawable;
    }

    public void setCheckedDrawable(android.graphics.drawable.Drawable drawable) {
        this.Q_renamed = drawable;
    }

    public void setUncheckedDrawable(android.graphics.drawable.Drawable drawable) {
        this.R_renamed = drawable;
    }

    public void setThemedLoadingCheckedBackground(android.graphics.drawable.Drawable drawable) {
        this.S_renamed = drawable;
    }

    public void setThemedLoadingUncheckedBackground(android.graphics.drawable.Drawable drawable) {
        this.T_renamed = drawable;
    }

    public void setThemedLoadingDrawable(android.graphics.drawable.Drawable drawable) {
        this.U_renamed = drawable;
    }
}
