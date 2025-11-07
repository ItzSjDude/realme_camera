package com.oplus.camera.longexposure;

/* compiled from: LongExposureScaleBar.java */
/* loaded from: classes2.dex */
public class i_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.PathInterpolator f4845a = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f4846b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f4847c;
    private static int d_renamed;
    private float A_renamed;
    private float B_renamed;
    private int C_renamed;
    private boolean D_renamed;
    private boolean E_renamed;
    private boolean F_renamed;
    private android.content.Context G_renamed;
    private android.graphics.Paint H_renamed;
    private android.graphics.Paint I_renamed;
    private android.graphics.Paint J_renamed;
    private com.oplus.camera.longexposure.i_renamed.c_renamed K_renamed;
    private android.view.VelocityTracker L_renamed;
    private com.oplus.camera.longexposure.i_renamed.b_renamed M_renamed;
    private android.os.Handler N_renamed;
    private android.animation.ValueAnimator O_renamed;
    private float P_renamed;
    private android.view.animation.PathInterpolator Q_renamed;
    private float R_renamed;
    private int S_renamed;
    private android.animation.ValueAnimator T_renamed;
    private android.animation.AnimatorSet U_renamed;
    private int V_renamed;
    private float e_renamed;
    private float f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int[] n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private float w_renamed;
    private float x_renamed;
    private float y_renamed;
    private float z_renamed;

    /* compiled from: LongExposureScaleBar.java */
    public interface c_renamed {
        void a_renamed();

        void b_renamed();

        void c_renamed(boolean z_renamed);

        void e_renamed(int i_renamed);
    }

    public i_renamed(android.content.Context context, int i_renamed, android.os.Handler handler) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.e_renamed = 0.0f;
        this.f_renamed = 0.0f;
        this.g_renamed = 0;
        this.k_renamed = 0;
        this.q_renamed = 1;
        this.s_renamed = 4;
        this.t_renamed = 2;
        this.w_renamed = 0.0f;
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = 0.0f;
        this.B_renamed = 0.0f;
        this.C_renamed = 10;
        this.F_renamed = true;
        this.O_renamed = null;
        this.P_renamed = 0.0f;
        this.Q_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.V_renamed = 1;
        this.N_renamed = handler;
        this.h_renamed = i_renamed;
        this.G_renamed = context;
        b_renamed();
    }

    private void a_renamed() {
        this.T_renamed = new android.animation.ValueAnimator();
        this.T_renamed.setDuration(350L);
        this.T_renamed.setInterpolator(f4845a);
        this.T_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.i_renamed.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.longexposure.i_renamed.this.A_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.longexposure.i_renamed iVar = com.oplus.camera.longexposure.i_renamed.this;
                iVar.B_renamed = (iVar.A_renamed / com.oplus.camera.longexposure.i_renamed.this.w_renamed) * com.oplus.camera.longexposure.i_renamed.this.x_renamed;
                com.oplus.camera.longexposure.i_renamed.this.invalidate();
            }
        });
        this.U_renamed = new android.animation.AnimatorSet();
        this.U_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.longexposure.i_renamed.2
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
                com.oplus.camera.longexposure.i_renamed.this.e_renamed();
            }
        });
    }

    private void b_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed <= 0) {
            this.F_renamed = false;
            return;
        }
        this.F_renamed = true;
        this.R_renamed = com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a);
        this.S_renamed = getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        android.content.res.Resources resources = this.G_renamed.getResources();
        this.o_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.p_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.k_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_scale_margin);
        int i_renamed = this.k_renamed;
        this.w_renamed = this.C_renamed * i_renamed;
        this.x_renamed = i_renamed * 1.5f;
        this.l_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height);
        this.m_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_scale_offsetY);
        this.n_renamed = new int[]{0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level1), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level2), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level3), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level4), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height_offset_level5)};
        f4846b = this.G_renamed.getColor(com.oplus.camera.R_renamed.color.professional_mode_scale_bar_big_scale_color);
        f4847c = this.G_renamed.getColor(com.oplus.camera.R_renamed.color.blur_menu_seek_bar_line_color);
        d_renamed = com.oplus.camera.util.Util.A_renamed(this.G_renamed);
        this.v_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.long_exposure_scale_bar_pointer_offset);
        setLayerType(1, null);
        this.H_renamed = new android.graphics.Paint();
        this.H_renamed.setMaskFilter(new android.graphics.BlurMaskFilter(this.R_renamed, android.graphics.BlurMaskFilter.Blur.OUTER));
        this.H_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.H_renamed.setStrokeWidth(this.o_renamed);
        this.H_renamed.setColor(this.S_renamed);
        this.I_renamed = new android.graphics.Paint();
        this.I_renamed.setAntiAlias(true);
        this.I_renamed.setColor(f4846b);
        this.I_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.I_renamed.setStrokeWidth(this.p_renamed);
        this.J_renamed = new android.graphics.Paint();
        this.J_renamed.setAntiAlias(true);
        this.J_renamed.setColor(d_renamed);
        this.J_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.J_renamed.setStrokeWidth(this.o_renamed);
        this.J_renamed.setAlpha(255);
        android.view.ViewConfiguration.get(this.G_renamed);
        this.u_renamed = android.view.ViewConfiguration.getMaximumFlingVelocity();
        int i2 = this.h_renamed;
        this.r_renamed = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        if (this.r_renamed < 0) {
            this.r_renamed = 0;
        }
        this.O_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.O_renamed.setDuration(500L);
        this.O_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
        this.O_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.longexposure.i_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.longexposure.i_renamed.this.P_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.longexposure.i_renamed.this.invalidate();
            }
        });
        int color = getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        this.I_renamed.setShadowLayer(this.R_renamed, 0.0f, 0.0f, color);
        this.J_renamed.setShadowLayer(this.R_renamed, 0.0f, 0.0f, color);
    }

    public void setCurrentIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.h_renamed) {
            return;
        }
        this.g_renamed = i_renamed;
    }

    public void setLevelNum(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("LongExposureScaleBar", "setLevelNum, levelNum: " + i_renamed);
        this.h_renamed = i_renamed;
        if (this.F_renamed) {
            int i2 = this.h_renamed;
            this.r_renamed = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            b_renamed();
        }
    }

    public int getCurrentIndex() {
        return this.g_renamed;
    }

    public void setScaleBarValueChangeListener(com.oplus.camera.longexposure.i_renamed.c_renamed cVar) {
        this.K_renamed = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:58:0x015d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.longexposure.i_renamed.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    float x_renamed = motionEvent.getX() - this.y_renamed;
                    float y_renamed = motionEvent.getY() - this.z_renamed;
                    this.y_renamed = motionEvent.getX();
                    this.z_renamed = motionEvent.getY();
                    if (java.lang.Math.abs(x_renamed) >= java.lang.Math.abs(y_renamed)) {
                        android.view.VelocityTracker velocityTracker = this.L_renamed;
                        if (velocityTracker != null) {
                            velocityTracker.addMovement(motionEvent);
                        }
                        if (1 == getLayoutDirection()) {
                            a_renamed(-x_renamed);
                        } else {
                            a_renamed(x_renamed);
                        }
                    }
                } else if (action == 3) {
                    if (this.A_renamed != 0.0f) {
                        c_renamed();
                    } else {
                        android.view.VelocityTracker velocityTracker2 = this.L_renamed;
                        if (velocityTracker2 != null) {
                            velocityTracker2.recycle();
                            this.L_renamed = null;
                        }
                        d_renamed();
                    }
                }
            } else if (this.A_renamed != 0.0f) {
                c_renamed();
            } else {
                android.view.VelocityTracker velocityTracker3 = this.L_renamed;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                    this.L_renamed.computeCurrentVelocity(1000, this.u_renamed);
                    xVelocity = this.L_renamed.getXVelocity();
                    this.L_renamed.clear();
                }
                if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                    if (1 == getLayoutDirection()) {
                        xVelocity = -xVelocity;
                    }
                    this.M_renamed = new com.oplus.camera.longexposure.i_renamed.b_renamed(xVelocity);
                    this.N_renamed.post(this.M_renamed);
                } else {
                    d_renamed();
                    com.oplus.camera.longexposure.i_renamed.c_renamed cVar = this.K_renamed;
                    if (cVar != null) {
                        cVar.b_renamed();
                    }
                }
            }
        } else {
            this.y_renamed = motionEvent.getX();
            this.z_renamed = motionEvent.getY();
            this.L_renamed = android.view.VelocityTracker.obtain();
            com.oplus.camera.longexposure.i_renamed.b_renamed bVar = this.M_renamed;
            if (bVar != null) {
                bVar.a_renamed();
                this.M_renamed = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed() {
        if (this.T_renamed == null || this.U_renamed == null) {
            a_renamed();
        }
        if (this.T_renamed.isRunning()) {
            this.T_renamed.cancel();
        }
        if (this.U_renamed.isRunning()) {
            this.U_renamed.cancel();
        }
        this.T_renamed.setFloatValues(this.A_renamed, 0.0f);
        this.U_renamed.play(this.T_renamed);
        this.U_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        int i_renamed = (int) ((this.e_renamed - this.f_renamed) % this.k_renamed);
        if (i_renamed != 0) {
            int iAbs = java.lang.Math.abs(i_renamed);
            int i2 = this.k_renamed;
            if (iAbs < i2 / 2) {
                this.e_renamed -= i_renamed;
            } else if (i_renamed > 0) {
                this.e_renamed = (this.e_renamed - i_renamed) + i2;
            } else {
                this.e_renamed = (this.e_renamed - i_renamed) - i2;
            }
            e_renamed();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        if (!this.F_renamed) {
            com.oplus.camera.e_renamed.f_renamed("LongExposureScaleBar", "onMove return, is_renamed not valid");
            return;
        }
        if (f_renamed == 0.0f) {
            return;
        }
        int i_renamed = 0.0f < f_renamed ? 1 : -1;
        if (this.V_renamed != i_renamed) {
            float f2 = this.A_renamed;
            if (0.0f != f2) {
                if (i_renamed == 1) {
                    this.A_renamed = f2 + f_renamed < 0.0f ? f2 + f_renamed : 0.0f;
                } else {
                    this.A_renamed = f2 + f_renamed > 0.0f ? f2 + f_renamed : 0.0f;
                }
                this.B_renamed = (this.A_renamed / this.w_renamed) * this.x_renamed;
                invalidate();
                return;
            }
        }
        this.V_renamed = i_renamed;
        this.e_renamed += (int) f_renamed;
        float f3 = this.e_renamed;
        int i2 = this.j_renamed;
        if (f3 >= i2) {
            float f4 = this.w_renamed;
            if (f3 <= i2 + f4) {
                float f5 = this.A_renamed;
                if (f5 == 0.0f) {
                    this.A_renamed = (f3 - i2) * 0.3f;
                } else {
                    float f6 = f_renamed * 0.3f;
                    if (f5 + f6 < f4) {
                        f4 = f5 + f6;
                    }
                    this.A_renamed = f4;
                }
            } else {
                this.A_renamed = 0.0f;
            }
            this.e_renamed = this.j_renamed;
        } else {
            int i3 = this.k_renamed;
            int i4 = this.h_renamed;
            if (((i4 - 1) * i3) + f3 <= i2) {
                float f7 = ((i4 - 1) * i3) + f3;
                float f8 = this.w_renamed;
                if (f7 >= i2 - f8) {
                    float f9 = this.A_renamed;
                    if (f9 == 0.0f) {
                        this.A_renamed = ((f3 + (i3 * (i4 - 1))) - i2) * 0.3f;
                    } else {
                        float f10 = f_renamed * 0.3f;
                        this.A_renamed = f9 + f10 <= (-f8) ? -f8 : f10 + f9;
                    }
                } else {
                    this.A_renamed = 0.0f;
                }
                this.e_renamed = this.j_renamed - (this.k_renamed * (this.h_renamed - 1));
            }
        }
        this.B_renamed = (this.A_renamed / this.w_renamed) * this.x_renamed;
        e_renamed();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        if (this.h_renamed != 0) {
            float fAbs = java.lang.Math.abs(this.j_renamed - this.e_renamed);
            int i_renamed = (int) (((fAbs + (r1 / 2)) / this.k_renamed) % this.h_renamed);
            com.oplus.camera.longexposure.i_renamed.c_renamed cVar = this.K_renamed;
            if (cVar != null && i_renamed != this.g_renamed) {
                cVar.a_renamed();
                this.K_renamed.e_renamed(i_renamed);
            }
            setCurrentIndex(i_renamed);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (this.i_renamed > 0) {
            return;
        }
        this.i_renamed = getMeasuredWidth();
        this.j_renamed = (this.i_renamed / 2) - (this.o_renamed / 2);
        this.f_renamed = (r2 % this.k_renamed) - (r3 / 2);
        this.E_renamed = true;
        if (!this.D_renamed) {
            this.e_renamed = 0.0f;
        }
        int i3 = this.g_renamed;
        if (i3 >= 0) {
            b_renamed(i3);
        }
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.h_renamed) {
            return;
        }
        this.e_renamed = this.j_renamed - (this.k_renamed * i_renamed);
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.h_renamed) {
            return;
        }
        this.g_renamed = i_renamed;
        if (this.E_renamed) {
            this.e_renamed = this.j_renamed - (this.k_renamed * i_renamed);
            this.D_renamed = true;
            invalidate();
        }
    }

    public void setAlign(int i_renamed) {
        if (i_renamed == 1 || i_renamed == 2) {
            this.q_renamed = i_renamed;
        }
    }

    /* compiled from: LongExposureScaleBar.java */
    private class a_renamed extends android.view.animation.PathInterpolator {
        a_renamed() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    /* compiled from: LongExposureScaleBar.java */
    private class b_renamed implements java.lang.Runnable {
        private float d_renamed;
        private float e_renamed;
        private float f_renamed;
        private float g_renamed;
        private long j_renamed;
        private android.view.animation.Interpolator k_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f4853b = 400;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f4854c = 16;
        private float h_renamed = 0.15f;
        private boolean i_renamed = false;

        public b_renamed(float f_renamed) {
            this.k_renamed = com.oplus.camera.longexposure.i_renamed.this.new a_renamed();
            if (com.oplus.camera.longexposure.i_renamed.this.K_renamed != null) {
                com.oplus.camera.longexposure.i_renamed.this.K_renamed.c_renamed(!this.i_renamed);
            }
            this.g_renamed = 0.0f;
            int i_renamed = this.f4853b;
            this.d_renamed = 1.0f / i_renamed;
            this.e_renamed = f_renamed;
            this.f_renamed = ((i_renamed * this.e_renamed) / 1000.0f) * this.h_renamed;
            this.j_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        }

        public void a_renamed() {
            this.i_renamed = true;
            if (com.oplus.camera.longexposure.i_renamed.this.K_renamed != null) {
                com.oplus.camera.longexposure.i_renamed.this.K_renamed.c_renamed(!this.i_renamed);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.i_renamed) {
                return;
            }
            int iCurrentAnimationTimeMillis = (int) (android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.j_renamed);
            float interpolation = this.k_renamed.getInterpolation(iCurrentAnimationTimeMillis * this.d_renamed);
            float f_renamed = (interpolation - this.g_renamed) * this.f_renamed;
            this.g_renamed = interpolation;
            int i_renamed = this.f4853b;
            if (iCurrentAnimationTimeMillis < i_renamed) {
                com.oplus.camera.longexposure.i_renamed.this.a_renamed(f_renamed);
                com.oplus.camera.longexposure.i_renamed.this.N_renamed.postDelayed(this, this.f4854c);
            } else if (iCurrentAnimationTimeMillis >= i_renamed) {
                this.g_renamed = 0.0f;
                if (com.oplus.camera.longexposure.i_renamed.this.A_renamed == 0.0f) {
                    com.oplus.camera.longexposure.i_renamed.this.d_renamed();
                }
                com.oplus.camera.longexposure.i_renamed.this.d_renamed();
                this.i_renamed = true;
                if (com.oplus.camera.longexposure.i_renamed.this.K_renamed != null) {
                    com.oplus.camera.longexposure.i_renamed.this.K_renamed.c_renamed(true ^ this.i_renamed);
                }
            }
            if (0.0f != com.oplus.camera.longexposure.i_renamed.this.A_renamed) {
                com.oplus.camera.longexposure.i_renamed.this.c_renamed();
            }
        }
    }
}
