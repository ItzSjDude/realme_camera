package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseMaskView extends android.view.View implements com.oplus.camera.ui.inverse.a_renamed {
    private android.animation.AnimatorSet A_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.PointF f6233a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6234b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6235c;
    private boolean d_renamed;
    private int e_renamed;
    private int f_renamed;
    private boolean g_renamed;
    private int h_renamed;
    private int i_renamed;
    private float j_renamed;
    private int k_renamed;
    private int l_renamed;
    private android.graphics.Paint m_renamed;
    private float n_renamed;
    private float o_renamed;
    private float p_renamed;
    private float q_renamed;
    private boolean r_renamed;
    private com.oplus.camera.ui.inverse.b_renamed s_renamed;
    private boolean t_renamed;
    private android.animation.ValueAnimator u_renamed;
    private android.animation.ValueAnimator v_renamed;
    private android.animation.ValueAnimator w_renamed;
    private android.animation.ValueAnimator x_renamed;
    private android.animation.ValueAnimator y_renamed;
    private android.animation.ValueAnimator z_renamed;

    public InverseMaskView(android.content.Context context) {
        super(context);
        this.f6233a = new android.graphics.PointF();
        this.f6234b = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f6235c = 0;
        this.d_renamed = false;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = false;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0.0f;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = null;
        this.n_renamed = 1.0f;
        this.o_renamed = 1.0f;
        this.p_renamed = 0.5f;
        this.q_renamed = 0.5f;
        this.r_renamed = true;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        a_renamed(context);
    }

    public InverseMaskView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6233a = new android.graphics.PointF();
        this.f6234b = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f6235c = 0;
        this.d_renamed = false;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = false;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0.0f;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = null;
        this.n_renamed = 1.0f;
        this.o_renamed = 1.0f;
        this.p_renamed = 0.5f;
        this.q_renamed = 0.5f;
        this.r_renamed = true;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        a_renamed(context);
    }

    public InverseMaskView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6233a = new android.graphics.PointF();
        this.f6234b = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f6235c = 0;
        this.d_renamed = false;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = false;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0.0f;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = null;
        this.n_renamed = 1.0f;
        this.o_renamed = 1.0f;
        this.p_renamed = 0.5f;
        this.q_renamed = 0.5f;
        this.r_renamed = true;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.m_renamed = new android.graphics.Paint();
        this.m_renamed.setAntiAlias(true);
        this.h_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius);
        this.k_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius_split_screen);
        this.l_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_offset_split_screen);
    }

    public void setRadius(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("InverseMaskView", "radius: " + i_renamed);
        android.animation.ValueAnimator valueAnimator = this.x_renamed;
        if (valueAnimator != null && valueAnimator.isRunning() && this.i_renamed == i_renamed) {
            return;
        }
        if (3 == this.e_renamed) {
            this.k_renamed = i_renamed;
        } else {
            this.h_renamed = i_renamed;
        }
        postInvalidate();
    }

    public void setSplitScreenYOffset(float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("InverseMaskView", "setSplitScreenYOffset: " + f_renamed);
        this.l_renamed = (int) f_renamed;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(final boolean z_renamed) {
        this.d_renamed = z_renamed;
        post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.inverse.InverseMaskView.this.setVisibility(z_renamed ? 0 : 8);
                com.oplus.camera.ui.inverse.InverseMaskView.this.invalidate();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.d_renamed) {
            int i_renamed = this.f6235c;
            if (i_renamed == 0) {
                a_renamed(canvas);
            } else {
                if (i_renamed != 1) {
                    return;
                }
                b_renamed(canvas);
            }
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        float f_renamed;
        int i_renamed = this.e_renamed;
        if (i_renamed == 1) {
            this.m_renamed.setColor(com.oplus.camera.ui.inverse.e_renamed.INS.getInverseColor());
            this.m_renamed.setBlendMode(android.graphics.BlendMode.SRC_OVER);
            this.m_renamed.setAlpha((int) (this.o_renamed * 204.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.m_renamed);
            this.m_renamed.setColor(-1);
            this.m_renamed.setBlendMode(android.graphics.BlendMode.DST_OUT);
            f_renamed = this.h_renamed * this.n_renamed;
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, f_renamed, this.m_renamed);
            this.f6233a.set(getWidth() / 2.0f, getHeight() / 2.0f);
        } else if (i_renamed == 3) {
            this.m_renamed.setColor(com.oplus.camera.ui.inverse.e_renamed.INS.getInverseColor());
            this.m_renamed.setBlendMode(android.graphics.BlendMode.SRC_OVER);
            this.m_renamed.setAlpha((int) (this.o_renamed * 204.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth() / 2.0f, getHeight(), this.m_renamed);
            this.m_renamed.setColor(-1);
            this.m_renamed.setBlendMode(android.graphics.BlendMode.DST_OUT);
            f_renamed = this.k_renamed * this.n_renamed;
            canvas.drawCircle(getWidth() / 4.0f, this.l_renamed, f_renamed, this.m_renamed);
            this.f6233a.set(getWidth() / 4.0f, this.l_renamed);
        } else if (i_renamed == 4) {
            int screenWidth = com.oplus.camera.util.Util.getScreenWidth();
            this.m_renamed.setColor(com.oplus.camera.ui.inverse.e_renamed.INS.getInverseColor());
            this.m_renamed.setBlendMode(android.graphics.BlendMode.SRC_OVER);
            this.m_renamed.setAlpha(204);
            float f2 = screenWidth;
            canvas.drawRect(0.0f, 0.0f, f2, com.oplus.camera.util.Util.N_renamed(), this.m_renamed);
            this.m_renamed.setAlpha((int) (this.o_renamed * 204.0f));
            canvas.drawRect(0.0f, com.oplus.camera.util.Util.N_renamed(), f2, com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed(), this.m_renamed);
            this.m_renamed.setColor(-1);
            this.m_renamed.setBlendMode(android.graphics.BlendMode.DST_OUT);
            f_renamed = this.k_renamed * this.n_renamed;
            if ((this.g_renamed && 90 == this.f_renamed) || (!this.g_renamed && 270 == this.f_renamed)) {
                canvas.drawCircle(getWidth() / 4.0f, getHeight() / 2, f_renamed, this.m_renamed);
                this.f6233a.set(getWidth() / 4.0f, getHeight() / 2);
            } else {
                canvas.drawCircle((getWidth() * 3) / 4.0f, getHeight() / 2, f_renamed, this.m_renamed);
                this.f6233a.set((getWidth() * 3) / 4.0f, getHeight() / 2);
            }
        } else {
            int screenWidth2 = com.oplus.camera.util.Util.getScreenWidth();
            this.m_renamed.setColor(com.oplus.camera.ui.inverse.e_renamed.INS.getInverseColor());
            this.m_renamed.setBlendMode(android.graphics.BlendMode.SRC_OVER);
            this.m_renamed.setAlpha(204);
            float f3 = screenWidth2;
            canvas.drawRect(0.0f, 0.0f, f3, com.oplus.camera.util.Util.N_renamed(), this.m_renamed);
            this.m_renamed.setAlpha((int) (this.o_renamed * 204.0f));
            canvas.drawRect(0.0f, com.oplus.camera.util.Util.N_renamed(), f3, com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed(), this.m_renamed);
            this.m_renamed.setColor(-1);
            this.m_renamed.setBlendMode(android.graphics.BlendMode.DST_OUT);
            float f4 = f3 / 2.0f;
            f_renamed = this.n_renamed * f4;
            float screenHeight = (((com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed()) - com.oplus.camera.util.Util.N_renamed()) - screenWidth2) * this.p_renamed;
            canvas.drawCircle(f4, com.oplus.camera.util.Util.N_renamed() + f4 + screenHeight, f_renamed, this.m_renamed);
            this.f6233a.set(f4, com.oplus.camera.util.Util.N_renamed() + f4 + screenHeight);
        }
        this.j_renamed = f_renamed;
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        this.m_renamed.setColor(com.oplus.camera.ui.inverse.e_renamed.INS.getInverseColor());
        this.m_renamed.setBlendMode(android.graphics.BlendMode.SRC_OVER);
        this.m_renamed.setAlpha((int) (this.o_renamed * 204.0f));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.m_renamed);
        this.m_renamed.setColor(-1);
        this.m_renamed.setBlendMode(android.graphics.BlendMode.DST_OUT);
        canvas.drawCircle(this.f6233a.x_renamed, this.f6233a.y_renamed, this.h_renamed, this.m_renamed);
        this.j_renamed = this.h_renamed;
    }

    public void setMaskAlpha(float f_renamed) {
        if (this.r_renamed) {
            this.o_renamed = f_renamed;
            invalidate();
        }
    }

    public void a_renamed(final boolean z_renamed, boolean z2) {
        this.r_renamed = z_renamed;
        if (z2) {
            android.animation.ValueAnimator valueAnimator = this.u_renamed;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.u_renamed.cancel();
            }
            if (z_renamed) {
                this.u_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            } else {
                this.u_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
            }
            this.u_renamed.setDuration(200L);
            this.u_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$-cEh4skNqqMiotN0_t5_iatUqkY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    this.f_renamed$0.a_renamed(z_renamed, valueAnimator2);
                }
            });
            this.u_renamed.start();
            return;
        }
        this.o_renamed = z_renamed ? 1.0f : 0.0f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(boolean z_renamed, android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        if ((!z_renamed || fFloatValue <= this.o_renamed) && (z_renamed || fFloatValue >= this.o_renamed)) {
            return;
        }
        this.o_renamed = fFloatValue;
        invalidate();
    }

    public void a_renamed() {
        final android.animation.ValueAnimator[] valueAnimatorArr = {android.animation.ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(83L), android.animation.ValueAnimator.ofFloat(0.0f, 0.0f).setDuration(65L), android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(185L)};
        android.view.animation.Interpolator interpolatorLoadInterpolator = android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.inverse_interpolator);
        int i_renamed = 0;
        while (i_renamed < valueAnimatorArr.length) {
            android.animation.ValueAnimator valueAnimator = valueAnimatorArr[i_renamed];
            valueAnimator.setInterpolator(interpolatorLoadInterpolator);
            final int i2 = i_renamed < valueAnimatorArr.length - 1 ? i_renamed + 1 : -1;
            valueAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    int i3 = i2;
                    if (i3 > 0) {
                        com.oplus.camera.ui.inverse.InverseMaskView.this.v_renamed = valueAnimatorArr[i3];
                        com.oplus.camera.ui.inverse.InverseMaskView.this.v_renamed.start();
                    }
                }
            });
            valueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$uIQM2DV3u9uuMvkpPWWqOdKk_Is
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    this.f_renamed$0.e_renamed(valueAnimator2);
                }
            });
            i_renamed++;
        }
        this.v_renamed = valueAnimatorArr[0];
        this.v_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed(android.animation.ValueAnimator valueAnimator) {
        this.n_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void a_renamed(float f_renamed, boolean z_renamed) {
        if (this.q_renamed != f_renamed) {
            this.q_renamed = f_renamed;
            if (z_renamed) {
                android.animation.ValueAnimator valueAnimator = this.w_renamed;
                if (valueAnimator == null) {
                    this.w_renamed = android.animation.ValueAnimator.ofFloat(this.p_renamed, f_renamed).setDuration(300L);
                    this.w_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.inverse_interpolator));
                    this.w_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$HbRBvKGdN9wI1nTI9DRRaqzf2yc
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                            this.f_renamed$0.d_renamed(valueAnimator2);
                        }
                    });
                } else {
                    if (valueAnimator.isRunning()) {
                        this.w_renamed.cancel();
                    }
                    this.w_renamed.setFloatValues(this.p_renamed, f_renamed);
                }
                this.w_renamed.start();
                return;
            }
            this.p_renamed = f_renamed;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.animation.ValueAnimator valueAnimator) {
        this.p_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        if (this.t_renamed) {
            return;
        }
        this.e_renamed = i_renamed;
        this.g_renamed = z_renamed;
        this.f_renamed = i2;
        setStatus(0);
        invalidate();
    }

    public void setMaskToLayoutMode(com.oplus.camera.ui.inverse.b_renamed bVar) {
        com.oplus.camera.e_renamed.a_renamed("InverseMaskView", "setMaskToLayoutMode, data: " + bVar + ", mbInverseColor: " + this.d_renamed);
        if (!this.d_renamed) {
            a_renamed(bVar.f6246a, bVar.g_renamed, bVar.f6247b);
        } else {
            a_renamed(bVar);
        }
    }

    private void a_renamed(com.oplus.camera.ui.inverse.b_renamed bVar) {
        if (this.t_renamed && this.A_renamed != null) {
            if (bVar.equals(this.s_renamed)) {
                return;
            } else {
                this.A_renamed.cancel();
            }
        }
        this.s_renamed = bVar;
        this.i_renamed = bVar.f6248c;
        this.t_renamed = true;
        android.graphics.PointF pointFA = a_renamed(bVar.f6246a, bVar.g_renamed, bVar.f6247b, bVar.d_renamed);
        float f_renamed = this.j_renamed;
        float f2 = this.f6233a.x_renamed;
        float f3 = this.f6233a.y_renamed;
        setStatus(1);
        if (this.A_renamed == null) {
            this.A_renamed = new android.animation.AnimatorSet();
            this.y_renamed = android.animation.ValueAnimator.ofFloat(f2, pointFA.x_renamed).setDuration(bVar.e_renamed);
            this.y_renamed.setInterpolator(this.f6234b);
            this.y_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$ARqhe98tkIETS_f5E8_2eRxV7Fk
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.c_renamed(valueAnimator);
                }
            });
            this.z_renamed = android.animation.ValueAnimator.ofFloat(f3, pointFA.y_renamed).setDuration(bVar.e_renamed);
            this.z_renamed.setInterpolator(this.f6234b);
            this.z_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$yPv0dS_8ViUbUBd4kzyP2-iUM3I
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.b_renamed(valueAnimator);
                }
            });
            this.x_renamed = android.animation.ValueAnimator.ofFloat(f_renamed, bVar.f6248c).setDuration(bVar.e_renamed);
            this.x_renamed.setInterpolator(this.f6234b);
            this.x_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$InverseMaskView$L2mf3eWdcOfMgSpi1jXxGgmKM-8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.a_renamed(valueAnimator);
                }
            });
            this.A_renamed.play(this.y_renamed).with(this.z_renamed).with(this.x_renamed);
            this.A_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.inverse.InverseMaskView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.inverse.InverseMaskView.this.s_renamed != null) {
                        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView = com.oplus.camera.ui.inverse.InverseMaskView.this;
                        inverseMaskView.e_renamed = inverseMaskView.s_renamed.f6246a;
                        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView2 = com.oplus.camera.ui.inverse.InverseMaskView.this;
                        inverseMaskView2.g_renamed = inverseMaskView2.s_renamed.g_renamed;
                        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView3 = com.oplus.camera.ui.inverse.InverseMaskView.this;
                        inverseMaskView3.f_renamed = inverseMaskView3.s_renamed.f6247b;
                        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView4 = com.oplus.camera.ui.inverse.InverseMaskView.this;
                        inverseMaskView4.k_renamed = inverseMaskView4.s_renamed.f6248c;
                        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView5 = com.oplus.camera.ui.inverse.InverseMaskView.this;
                        inverseMaskView5.h_renamed = inverseMaskView5.s_renamed.f6248c;
                    }
                    com.oplus.camera.ui.inverse.InverseMaskView.this.setStatus(0);
                    com.oplus.camera.ui.inverse.InverseMaskView.this.t_renamed = false;
                }
            });
        } else {
            this.y_renamed.setFloatValues(this.f6233a.x_renamed, pointFA.x_renamed);
            this.z_renamed.setFloatValues(this.f6233a.y_renamed, pointFA.y_renamed);
            this.x_renamed.setFloatValues(this.h_renamed, bVar.f6248c);
            this.y_renamed.setDuration(bVar.e_renamed);
            this.z_renamed.setDuration(bVar.e_renamed);
            this.x_renamed.setDuration(bVar.e_renamed);
        }
        this.A_renamed.setCurrentPlayTime(java.lang.Math.min(android.os.SystemClock.uptimeMillis() - bVar.f_renamed, bVar.e_renamed));
        this.A_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.animation.ValueAnimator valueAnimator) {
        this.f6233a.x_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        this.f6233a.y_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        int iRound = java.lang.Math.round(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        this.k_renamed = iRound;
        this.h_renamed = iRound;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("InverseMaskView", "setStatus, " + this.f6235c + " -> " + i_renamed);
        this.f6235c = i_renamed;
        postInvalidate();
    }

    private android.graphics.PointF a_renamed(int i_renamed, boolean z_renamed, int i2, float f_renamed) {
        if (i_renamed == 1) {
            return new android.graphics.PointF(getWidth() / 2.0f, getHeight() / 2.0f);
        }
        if (i_renamed == 3) {
            return new android.graphics.PointF(getWidth() / 4.0f, f_renamed);
        }
        if (i_renamed != 4) {
            int screenWidth = com.oplus.camera.util.Util.getScreenWidth();
            float screenHeight = (((com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed()) - com.oplus.camera.util.Util.N_renamed()) - screenWidth) * this.p_renamed;
            float f2 = screenWidth / 2.0f;
            return new android.graphics.PointF(f2, com.oplus.camera.util.Util.N_renamed() + f2 + screenHeight);
        }
        if ((z_renamed && 90 == i2) || (!z_renamed && 270 == i2)) {
            return new android.graphics.PointF(getWidth() / 4.0f, getHeight() / 2);
        }
        return new android.graphics.PointF((getWidth() * 3) / 4.0f, getHeight() / 2);
    }

    public static float getPositionRatioSquare() {
        return (com.oplus.camera.util.Util.L_renamed() * 1.0f) / (((com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed()) - com.oplus.camera.util.Util.N_renamed()) - com.oplus.camera.util.Util.getScreenWidth());
    }
}
