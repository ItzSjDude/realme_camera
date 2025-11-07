package com.oplus.camera.ui.menu.levelcontrol;

/* loaded from: classes2.dex */
public class BlurMenuSeekBar extends android.view.View {
    private static final android.view.animation.PathInterpolator i_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private static final android.view.animation.PathInterpolator j_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private static int k_renamed;
    private static int l_renamed;
    private float A_renamed;
    private float B_renamed;
    private float C_renamed;
    private float D_renamed;
    private float E_renamed;
    private float F_renamed;
    private int G_renamed;
    private android.animation.ValueAnimator H_renamed;
    private android.animation.AnimatorSet I_renamed;
    private int J_renamed;
    private boolean K_renamed;
    private boolean L_renamed;
    private boolean M_renamed;
    private android.graphics.Paint N_renamed;
    private android.graphics.Paint O_renamed;
    private android.graphics.Paint P_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed Q_renamed;
    private android.view.VelocityTracker R_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.b_renamed S_renamed;
    private android.os.Handler T_renamed;
    private boolean U_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed V_renamed;
    private float W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.content.Context f6460a;
    private float aa_renamed;
    private float ab_renamed;
    private int ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private int ag_renamed;
    private int ah_renamed;
    private int ai_renamed;
    private boolean aj_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f6461b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f6462c;
    protected int d_renamed;
    protected int e_renamed;
    protected int f_renamed;
    protected int[] g_renamed;
    protected int h_renamed;
    private int m_renamed;
    private float n_renamed;
    private float o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;

    public static abstract class c_renamed implements com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed {
        @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
        public void a_renamed() {
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
        public void a_renamed(int i_renamed) {
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
        public void a_renamed(boolean z_renamed) {
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
        public void b_renamed() {
        }
    }

    public interface d_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(boolean z_renamed);

        void b_renamed();
    }

    protected void a_renamed(int i2) {
    }

    protected void b_renamed() {
    }

    protected void c_renamed() {
    }

    public boolean d_renamed() {
        return true;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    public BlurMenuSeekBar(android.content.Context context) {
        this(context, null);
    }

    public BlurMenuSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlurMenuSeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6462c = 0;
        this.m_renamed = 0;
        this.e_renamed = 30;
        this.f_renamed = 0;
        this.g_renamed = null;
        this.n_renamed = 0.0f;
        this.o_renamed = 0.0f;
        this.s_renamed = 0;
        this.t_renamed = 0;
        this.y_renamed = 0;
        this.z_renamed = 0;
        this.A_renamed = 0.0f;
        this.B_renamed = 0.0f;
        this.C_renamed = 0.0f;
        this.D_renamed = 0.0f;
        this.E_renamed = 0.0f;
        this.F_renamed = 0.0f;
        this.G_renamed = 10;
        this.J_renamed = 1;
        this.M_renamed = true;
        this.U_renamed = false;
        this.V_renamed = null;
        this.aa_renamed = 0.0f;
        this.ab_renamed = 0.0f;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = 0;
        this.ah_renamed = 0;
        this.ai_renamed = 0;
        this.aj_renamed = false;
        this.f6460a = context;
        g_renamed();
    }

    private void g_renamed() {
        if (this.d_renamed <= 0) {
            this.M_renamed = false;
            return;
        }
        this.M_renamed = true;
        this.W_renamed = com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a);
        this.ac_renamed = getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        this.T_renamed = new android.os.Handler(android.os.Looper.getMainLooper());
        android.content.res.Resources resources = this.f6460a.getResources();
        this.u_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_stroke_line_width);
        this.v_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_stroke_line_width);
        this.aa_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.blur_default_index_radus);
        this.ab_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.blur_default_circle_top_margin);
        if (0.0f == getRotation()) {
            this.t_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_pannel_height);
        } else {
            this.t_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_blur_menu_seekbar_pannel_height);
        }
        this.e_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_margin);
        this.r_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height);
        this.h_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_center_line_height);
        int i2 = this.e_renamed;
        this.C_renamed = this.G_renamed * i2;
        this.D_renamed = i2 * 1.5f;
        this.y_renamed = 0.0f == getRotation() ? resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_padding_bottom) : resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_blur_menu_seekbar_margin_left);
        l_renamed = this.f6460a.getColor(com.oplus.camera.R_renamed.color.camera_white);
        this.f6461b = com.oplus.camera.util.Util.A_renamed(this.f6460a);
        k_renamed = this.f6460a.getColor(com.oplus.camera.R_renamed.color.blur_menu_seek_bar_line_color);
        this.ad_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset0);
        this.ae_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset1);
        this.af_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset2);
        this.ag_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset3);
        this.ah_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset4);
        a_renamed();
        this.s_renamed = this.g_renamed.length;
        setLayerType(1, null);
        this.O_renamed = new android.graphics.Paint();
        this.O_renamed.setAntiAlias(true);
        this.O_renamed.setMaskFilter(new android.graphics.BlurMaskFilter(this.W_renamed, android.graphics.BlurMaskFilter.Blur.OUTER));
        this.O_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.O_renamed.setStrokeWidth(this.u_renamed);
        this.O_renamed.setColor(this.ac_renamed);
        this.N_renamed = new android.graphics.Paint();
        this.N_renamed.setAntiAlias(true);
        this.N_renamed.setColor(l_renamed);
        this.N_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.N_renamed.setStrokeWidth(this.v_renamed);
        this.P_renamed = new android.graphics.Paint();
        this.P_renamed.setAntiAlias(true);
        this.P_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.P_renamed.setShadowLayer(this.W_renamed, 0.0f, 0.0f, this.ac_renamed);
        this.P_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.x_renamed = android.view.ViewConfiguration.getMaximumFlingVelocity();
        int i3 = this.d_renamed;
        this.w_renamed = i3 % 2 == 0 ? (i3 / 2) - 1 : i3 / 2;
        if (this.w_renamed < 0) {
            this.w_renamed = 0;
        }
    }

    protected void a_renamed() {
        this.g_renamed = new int[]{this.ad_renamed, this.ae_renamed, this.af_renamed, this.ag_renamed, this.ah_renamed, this.ai_renamed};
    }

    private void h_renamed() {
        this.H_renamed = new android.animation.ValueAnimator();
        this.H_renamed.setDuration(350L);
        this.H_renamed.setInterpolator(i_renamed);
        this.H_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.E_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar blurMenuSeekBar = com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this;
                blurMenuSeekBar.F_renamed = (blurMenuSeekBar.E_renamed / com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.C_renamed) * com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.D_renamed;
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.invalidate();
            }
        });
        this.I_renamed = new android.animation.AnimatorSet();
        this.I_renamed.play(this.H_renamed);
        this.I_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.2
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
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.k_renamed();
            }
        });
    }

    public void setCurrentIndex(int i2) {
        if (i2 < 0 || i2 >= this.d_renamed) {
            return;
        }
        this.f6462c = i2;
        com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed dVar = this.Q_renamed;
        if (dVar != null) {
            dVar.a_renamed(this.f6462c);
        }
    }

    public void setLevelNum(int i2) {
        com.oplus.camera.e_renamed.a_renamed("BlurMenuSeekBar", "setLevelNum, levelNum: " + i2);
        this.d_renamed = i2;
        if (this.M_renamed) {
            int i3 = this.d_renamed;
            this.w_renamed = i3 % 2 == 0 ? (i3 / 2) - 1 : i3 / 2;
        } else {
            g_renamed();
        }
    }

    public void setDefaultDotPosition(int i2) {
        com.oplus.camera.e_renamed.a_renamed("BlurMenuSeekBar", "setDefaultDotPosition, dotPosition: " + i2);
        this.m_renamed = i2;
    }

    public void setScaleBarValueChangeListener(com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed dVar) {
        this.Q_renamed = dVar;
    }

    public void e_renamed() {
        this.U_renamed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x01d5 A_renamed[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r21) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.onDraw(android.graphics.Canvas):void");
    }

    public boolean f_renamed() {
        return this.m_renamed != 0;
    }

    private void a_renamed(android.graphics.Canvas canvas, float f_renamed, float f2, float f3, float f4, android.graphics.Paint paint) {
        if (this.U_renamed) {
            canvas.drawLine(f_renamed, f2, f3, f4, this.O_renamed);
        }
        canvas.drawLine(f_renamed, f2, f3, f4, paint);
    }

    public void setRemainder(int i2) {
        this.z_renamed = i2;
    }

    private int getRemainder() {
        return this.z_renamed;
    }

    public void c_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        a_renamed(z_renamed, null, null);
    }

    public void a_renamed(boolean z_renamed, final java.lang.Runnable runnable, final java.lang.Runnable runnable2) throws android.content.res.Resources.NotFoundException {
        if (this.g_renamed == null) {
            return;
        }
        this.aj_renamed = z_renamed;
        float[] fArr = new float[2];
        fArr[0] = z_renamed ? 0.0f : 1.0f;
        fArr[1] = z_renamed ? 1.0f : 0.0f;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(i_renamed);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.-$$Lambda$BlurMenuSeekBar$GMW0HA0VquiQGyuQwef8UQZYKVM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(valueAnimator);
            }
        });
        int color = getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_0_percent_transparency);
        int iA = com.oplus.camera.util.Util.A_renamed(this.f6460a);
        int[] iArr = new int[2];
        iArr[0] = z_renamed ? color : iA;
        if (z_renamed) {
            color = iA;
        }
        iArr[1] = color;
        android.animation.ValueAnimator valueAnimatorOfArgb = android.animation.ValueAnimator.ofArgb(iArr);
        valueAnimatorOfArgb.setInterpolator(j_renamed);
        valueAnimatorOfArgb.setDuration(500L);
        valueAnimatorOfArgb.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.levelcontrol.-$$Lambda$BlurMenuSeekBar$d3YQmsW6XCpsFb7gm72TtG88zbg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfArgb);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                java.lang.Runnable runnable3 = runnable;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                java.lang.Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        int[] iArr = this.g_renamed;
        iArr[0] = (int) (this.ad_renamed * fFloatValue);
        iArr[1] = (int) (this.ae_renamed * fFloatValue);
        iArr[2] = (int) (this.af_renamed * fFloatValue);
        iArr[3] = (int) (this.ag_renamed * fFloatValue);
        iArr[4] = (int) (this.ah_renamed * fFloatValue);
        this.h_renamed = this.r_renamed + iArr[0];
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.f6461b = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            float xVelocity = 0.0f;
            if (action == 1) {
                c_renamed();
                if (this.E_renamed != 0.0f) {
                    i_renamed();
                } else {
                    android.view.VelocityTracker velocityTracker = this.R_renamed;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        this.R_renamed.computeCurrentVelocity(1000, this.x_renamed);
                        xVelocity = this.R_renamed.getXVelocity();
                        this.R_renamed.clear();
                    }
                    if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                        if (1 == getLayoutDirection()) {
                            xVelocity = -xVelocity;
                        }
                        this.S_renamed = new com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.b_renamed(xVelocity);
                        this.T_renamed.post(this.S_renamed);
                    } else {
                        j_renamed();
                        com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed dVar = this.Q_renamed;
                        if (dVar != null) {
                            dVar.b_renamed();
                        }
                    }
                }
            } else if (action == 2) {
                float x_renamed = motionEvent.getX() - this.A_renamed;
                float y_renamed = motionEvent.getY() - this.B_renamed;
                this.A_renamed = motionEvent.getX();
                this.B_renamed = motionEvent.getY();
                if (java.lang.Math.abs(x_renamed) >= java.lang.Math.abs(y_renamed)) {
                    android.view.VelocityTracker velocityTracker2 = this.R_renamed;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                    if (1 == getLayoutDirection()) {
                        a_renamed(-x_renamed);
                    } else {
                        a_renamed(x_renamed);
                    }
                }
            } else if (action == 3) {
                if (this.E_renamed != 0.0f) {
                    i_renamed();
                } else {
                    android.view.VelocityTracker velocityTracker3 = this.R_renamed;
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                        this.R_renamed = null;
                    }
                    j_renamed();
                }
            }
        } else {
            this.A_renamed = motionEvent.getX();
            this.B_renamed = motionEvent.getY();
            if (motionEvent.getY() < getHeight() * 0.2f) {
                return false;
            }
            android.animation.AnimatorSet animatorSet = this.I_renamed;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.I_renamed.cancel();
            }
            this.R_renamed = android.view.VelocityTracker.obtain();
            com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.b_renamed bVar = this.S_renamed;
            if (bVar != null) {
                bVar.a_renamed();
                this.S_renamed = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        if (this.H_renamed == null || this.I_renamed == null) {
            h_renamed();
        }
        if (this.H_renamed.isRunning()) {
            this.H_renamed.cancel();
        }
        if (this.I_renamed.isRunning()) {
            this.I_renamed.cancel();
        }
        this.H_renamed.setFloatValues(this.E_renamed, 0.0f);
        this.I_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        int i2 = (int) ((this.n_renamed - this.o_renamed) % this.e_renamed);
        if (i2 != 0) {
            int iAbs = java.lang.Math.abs(i2);
            int i3 = this.e_renamed;
            if (iAbs < i3 / 2) {
                this.n_renamed -= i2;
            } else if (i2 > 0) {
                this.n_renamed = (this.n_renamed - i2) + i3;
            } else {
                this.n_renamed = (this.n_renamed - i2) - i3;
            }
            k_renamed();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        if (!this.M_renamed) {
            com.oplus.camera.e_renamed.f_renamed("BlurMenuSeekBar", "onMove return, is_renamed not valid");
            return;
        }
        b_renamed();
        if (f_renamed == 0.0f) {
            return;
        }
        int i2 = 0.0f < f_renamed ? 1 : -1;
        if (this.J_renamed != i2) {
            float f2 = this.E_renamed;
            if (0.0f != f2) {
                if (i2 == 1) {
                    this.E_renamed = f2 + f_renamed < 0.0f ? f2 + f_renamed : 0.0f;
                } else {
                    this.E_renamed = f2 + f_renamed > 0.0f ? f2 + f_renamed : 0.0f;
                }
                this.F_renamed = (this.E_renamed / this.C_renamed) * this.D_renamed;
                invalidate();
                return;
            }
        }
        this.J_renamed = i2;
        this.n_renamed += (int) f_renamed;
        float f3 = this.n_renamed;
        int i3 = this.q_renamed;
        if (f3 >= i3) {
            float f4 = this.C_renamed;
            if (f3 <= i3 + f4) {
                float f5 = this.E_renamed;
                if (f5 == 0.0f) {
                    this.E_renamed = (f3 - i3) * 0.3f;
                } else {
                    float f6 = f_renamed * 0.3f;
                    if (f5 + f6 < f4) {
                        f4 = f5 + f6;
                    }
                    this.E_renamed = f4;
                }
            } else {
                this.E_renamed = 0.0f;
            }
            this.n_renamed = this.q_renamed;
        } else {
            int i4 = this.e_renamed;
            int i5 = this.d_renamed;
            if (((i5 - 1) * i4) + f3 <= i3) {
                float f7 = ((i5 - 1) * i4) + f3;
                float f8 = this.C_renamed;
                if (f7 >= i3 - f8) {
                    float f9 = this.E_renamed;
                    if (f9 == 0.0f) {
                        this.E_renamed = ((f3 + (i4 * (i5 - 1))) - i3) * 0.3f;
                    } else {
                        float f10 = f_renamed * 0.3f;
                        this.E_renamed = f9 + f10 <= (-f8) ? -f8 : f10 + f9;
                    }
                } else {
                    this.E_renamed = 0.0f;
                }
                this.n_renamed = this.q_renamed - (this.e_renamed * (this.d_renamed - 1));
            }
        }
        this.F_renamed = (this.E_renamed / this.C_renamed) * this.D_renamed;
        k_renamed();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k_renamed() {
        if (this.d_renamed != 0) {
            float fAbs = java.lang.Math.abs(this.q_renamed - this.n_renamed);
            int i2 = (int) (((fAbs + (r1 / 2)) / this.e_renamed) % this.d_renamed);
            if (this.Q_renamed != null && i2 != this.f6462c) {
                com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed aVar = this.V_renamed;
                com.oplus.camera.ui.a_renamed.a_renamed aVarN = aVar != null ? aVar.n_renamed() : null;
                if (aVarN != null) {
                    aVarN.a_renamed(true);
                    aVarN.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
                }
                this.Q_renamed.a_renamed();
                this.Q_renamed.a_renamed(i2);
                if (aVarN != null) {
                    aVarN.a_renamed(false);
                    aVarN.b_renamed((java.lang.String) null);
                }
            }
            setCurrentIndex(i2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.p_renamed > 0 || !this.M_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("BlurMenuSeekBar", "onMeasure, widthMeasureSpec: " + i2 + ", heightMeasureSpec: " + i3);
        this.p_renamed = getMeasuredWidth();
        int i4 = this.p_renamed / 2;
        int i5 = this.u_renamed;
        this.q_renamed = i4 - (i5 / 2);
        this.o_renamed = (float) ((i4 % this.e_renamed) - (i5 / 2));
        this.L_renamed = true;
        if (!this.K_renamed) {
            this.n_renamed = 0.0f;
        }
        int i6 = this.f6462c;
        if (i6 >= 0) {
            c_renamed(i6);
        }
    }

    public void b_renamed(int i2) {
        com.oplus.camera.e_renamed.a_renamed("BlurMenuSeekBar", "scrollTo, index: " + i2);
        if (i2 < 0 || i2 >= this.d_renamed) {
            return;
        }
        this.f6462c = i2;
        a_renamed(i2);
        this.n_renamed = this.q_renamed - (this.e_renamed * i2);
        invalidate();
    }

    public void c_renamed(int i2) {
        if (i2 < 0 || i2 >= this.d_renamed) {
            return;
        }
        this.f6462c = i2;
        if (this.L_renamed) {
            this.n_renamed = this.q_renamed - (this.e_renamed * i2);
            this.K_renamed = true;
            invalidate();
        }
    }

    public void setBlurListener(com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed aVar) {
        this.V_renamed = aVar;
    }

    private static class a_renamed extends android.view.animation.PathInterpolator {
        a_renamed() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    private class b_renamed implements java.lang.Runnable {
        private float d_renamed;
        private float e_renamed;
        private float f_renamed;
        private float g_renamed;
        private long j_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f6469b = 400;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f6470c = 16;
        private float h_renamed = 0.15f;
        private android.view.animation.Interpolator k_renamed = new com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.a_renamed();
        private boolean i_renamed = false;

        public b_renamed(float f_renamed) {
            if (com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed.a_renamed(!this.i_renamed);
            }
            this.g_renamed = 0.0f;
            int i_renamed = this.f6469b;
            this.d_renamed = 1.0f / i_renamed;
            this.e_renamed = f_renamed;
            this.f_renamed = ((i_renamed * this.e_renamed) / 1000.0f) * this.h_renamed;
            this.j_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        }

        public void a_renamed() {
            this.i_renamed = true;
            if (com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed != null) {
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed.a_renamed(false);
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
            if (iCurrentAnimationTimeMillis < this.f6469b) {
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.a_renamed(f_renamed);
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.T_renamed.postDelayed(this, this.f6470c);
            } else {
                this.g_renamed = 0.0f;
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.j_renamed();
                this.i_renamed = true;
                if (com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed != null) {
                    com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.Q_renamed.a_renamed(true ^ this.i_renamed);
                }
            }
            if (0.0f != com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.E_renamed) {
                com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.this.i_renamed();
            }
        }
    }
}
