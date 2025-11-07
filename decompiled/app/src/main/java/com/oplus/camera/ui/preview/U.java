package com.oplus.camera.ui.preview;

/* compiled from: FocusIndicatorRotateLayout.java */
/* loaded from: classes2.dex */
public class n_renamed extends android.widget.RelativeLayout implements com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed, com.oplus.camera.ui.preview.m_renamed {
    private boolean A_renamed;
    private float B_renamed;
    private float C_renamed;
    private android.graphics.PointF D_renamed;
    private android.graphics.PointF E_renamed;
    private float F_renamed;
    private float G_renamed;
    private boolean H_renamed;
    private android.animation.TimeInterpolator I_renamed;
    private android.view.animation.Interpolator J_renamed;
    private android.animation.ValueAnimator K_renamed;
    private float L_renamed;
    private com.oplus.camera.ui.preview.n_renamed.c_renamed M_renamed;
    private android.animation.AnimatorListenerAdapter N_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7095a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.Runnable f7096b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.Runnable f7097c;
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
    private com.oplus.camera.ui.preview.s_renamed p_renamed;
    private android.widget.RelativeLayout q_renamed;
    private android.widget.ImageView r_renamed;
    private android.widget.TextView s_renamed;
    private android.widget.RelativeLayout t_renamed;
    private android.widget.ImageView u_renamed;
    private android.widget.TextView v_renamed;
    private com.oplus.camera.ui.preview.ExposureSeekbarContainer w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private boolean z_renamed;

    /* compiled from: FocusIndicatorRotateLayout.java */
    public interface c_renamed {
        void onVisibilityChanged(android.view.View view, int i_renamed);
    }

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f7096b = new com.oplus.camera.ui.preview.n_renamed.a_renamed();
        this.f7097c = new com.oplus.camera.ui.preview.n_renamed.b_renamed();
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = false;
        this.y_renamed = false;
        this.z_renamed = false;
        this.A_renamed = false;
        this.B_renamed = -1.0f;
        this.C_renamed = -1.0f;
        this.D_renamed = new android.graphics.PointF(0.0f, 0.0f);
        this.E_renamed = new android.graphics.PointF(0.0f, 0.0f);
        this.F_renamed = -1.0f;
        this.G_renamed = -1.0f;
        this.H_renamed = false;
        this.I_renamed = new android.view.animation.LinearInterpolator();
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = 1.0f;
        this.M_renamed = null;
        this.N_renamed = new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.n_renamed.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ui.preview.n_renamed.this.w_renamed != null) {
                    com.oplus.camera.ui.preview.n_renamed.this.w_renamed.a_renamed(com.oplus.camera.ui.preview.n_renamed.this.w_renamed.getTranslationX() + (com.oplus.camera.ui.preview.n_renamed.this.w_renamed.getContainerWidth() / 2.0f), com.oplus.camera.ui.preview.n_renamed.this.w_renamed.getTranslationY() + (com.oplus.camera.ui.preview.n_renamed.this.w_renamed.getContainerHeight() / 2.0f), com.oplus.camera.ui.preview.n_renamed.this.e_renamed, com.oplus.camera.ui.preview.n_renamed.this.d_renamed, com.oplus.camera.ui.preview.n_renamed.this.o_renamed);
                }
            }
        };
        android.content.res.Resources resources = context.getResources();
        this.f_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.focus_indicator_container_width);
        this.g_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.focus_indicator_container_height);
        this.i_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_container_height);
        this.h_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_container_width);
        this.j_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_width);
        this.k_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_height);
        this.l_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.focus_indicator_width);
        this.m_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.focus_indicator_height);
        this.n_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_min_margin);
        this.J_renamed = android.view.animation.AnimationUtils.loadInterpolator(context, com.oplus.camera.R_renamed.anim.unity_in_out_path_interpolator);
        a_renamed(context);
        this.K_renamed = android.animation.ValueAnimator.ofFloat(0.0f);
        this.K_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$n_renamed$QTgl4PKG4LN4-eEPUCmG8NWSAI0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        this.K_renamed.addListener(this.N_renamed);
        setId(com.oplus.camera.R_renamed.id_renamed.focus_exposure_indicator_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        android.widget.RelativeLayout relativeLayout = this.t_renamed;
        if (relativeLayout != null) {
            relativeLayout.setRotation(fFloatValue);
        }
        android.widget.RelativeLayout relativeLayout2 = this.q_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.setRotation(fFloatValue);
        }
        com.oplus.camera.ui.preview.ExposureSeekbarContainer exposureSeekbarContainer = this.w_renamed;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.setRotation(fFloatValue);
        }
    }

    private void a_renamed(android.content.Context context) {
        inflate(context, com.oplus.camera.R_renamed.layout.focus_exposure_indicator, this);
        setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$n_renamed$JxbP8c3M2Q_3LFygzSxqHKObnmQ
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return this.f_renamed$0.c_renamed(view, motionEvent);
            }
        });
        if (this.t_renamed == null) {
            this.t_renamed = (android.widget.RelativeLayout) findViewById(com.oplus.camera.R_renamed.id_renamed.focus_indicator_container);
            this.u_renamed = (android.widget.ImageView) findViewById(com.oplus.camera.R_renamed.id_renamed.focus_indicator);
            this.t_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$n_renamed$rU1Yx006DxsePhrLYwKoUM4qOCo
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f_renamed$0.b_renamed(view, motionEvent);
                }
            });
            this.v_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.focus_indicator_text);
        }
        if (this.q_renamed == null) {
            this.q_renamed = (android.widget.RelativeLayout) findViewById(com.oplus.camera.R_renamed.id_renamed.exposure_indicator_container);
            this.r_renamed = (android.widget.ImageView) findViewById(com.oplus.camera.R_renamed.id_renamed.exposure_indicator);
            this.r_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$n_renamed$64K9V7jIyMTZz9MdAQdK0PRM78I
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f_renamed$0.a_renamed(view, motionEvent);
                }
            });
            this.s_renamed = (android.widget.TextView) findViewById(com.oplus.camera.R_renamed.id_renamed.exposure_indicator_text);
        }
        if (this.w_renamed == null) {
            this.w_renamed = (com.oplus.camera.ui.preview.ExposureSeekbarContainer) findViewById(com.oplus.camera.R_renamed.id_renamed.exposure_seekbar_container);
            this.w_renamed.setOnSeekbarChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent != null) {
            return a_renamed(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a_renamed(view, motionEvent, 0.2f) || !this.p_renamed.F_renamed()) {
            return false;
        }
        i_renamed();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !this.p_renamed.F_renamed()) {
            return false;
        }
        g_renamed();
        return false;
    }

    private boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent, float f_renamed) {
        float x_renamed = motionEvent.getX();
        float y_renamed = motionEvent.getY();
        return (((((float) view.getWidth()) * f_renamed) > x_renamed ? 1 : ((((float) view.getWidth()) * f_renamed) == x_renamed ? 0 : -1)) < 0 && (x_renamed > (((float) view.getWidth()) - (((float) view.getWidth()) * f_renamed)) ? 1 : (x_renamed == (((float) view.getWidth()) - (((float) view.getWidth()) * f_renamed)) ? 0 : -1)) < 0) && (((((float) view.getHeight()) * f_renamed) > y_renamed ? 1 : ((((float) view.getHeight()) * f_renamed) == y_renamed ? 0 : -1)) < 0 && (y_renamed > (((float) view.getHeight()) - (((float) view.getHeight()) * f_renamed)) ? 1 : (y_renamed == (((float) view.getHeight()) - (((float) view.getHeight()) * f_renamed)) ? 0 : -1)) < 0);
    }

    private void g_renamed() {
        com.oplus.camera.e_renamed.b_renamed("FocusIndicatorRotateLayout", "startMovingExposure, mbIsStartMovingFocus: " + this.A_renamed + ", mbIsStartMovingExposure: " + this.z_renamed);
        com.oplus.camera.ui.preview.s_renamed sVar = this.p_renamed;
        if (sVar == null || this.A_renamed || this.z_renamed || !sVar.K_renamed() || !this.p_renamed.F_renamed()) {
            return;
        }
        this.z_renamed = true;
        this.D_renamed.set(this.q_renamed.getTranslationX() + (this.h_renamed / 2.0f), this.q_renamed.getTranslationY() + (this.i_renamed / 2.0f));
    }

    private void h_renamed() {
        com.oplus.camera.e_renamed.b_renamed("FocusIndicatorRotateLayout", "stopMovingExposure, mbIsStartMovingExposure: " + this.z_renamed + ", mMovingExposurePointf: " + this.D_renamed);
        if (this.z_renamed) {
            this.z_renamed = false;
            this.p_renamed.a_renamed(this.D_renamed.x_renamed, this.D_renamed.y_renamed, this.j_renamed, this.k_renamed);
            this.D_renamed.set(0.0f, 0.0f);
        }
    }

    private void i_renamed() {
        com.oplus.camera.e_renamed.b_renamed("FocusIndicatorRotateLayout", "startMovingFocus, mbIsStartMovingFocus: " + this.A_renamed + ", mbIsStartMovingExposure: " + this.z_renamed);
        com.oplus.camera.ui.preview.s_renamed sVar = this.p_renamed;
        if (sVar == null || this.A_renamed || this.z_renamed || !sVar.K_renamed() || !this.p_renamed.F_renamed()) {
            return;
        }
        this.A_renamed = true;
        this.E_renamed.set(this.t_renamed.getTranslationX() + (this.f_renamed / 2.0f), this.t_renamed.getTranslationY() + (this.g_renamed / 2.0f));
    }

    private void j_renamed() {
        com.oplus.camera.e_renamed.b_renamed("FocusIndicatorRotateLayout", "stopMovingFocus, mbIsStartMovingFocus: " + this.A_renamed + ", mMovingFocusPointf: " + this.E_renamed);
        if (this.A_renamed) {
            this.A_renamed = false;
            this.p_renamed.b_renamed(this.E_renamed.x_renamed, this.E_renamed.y_renamed, this.l_renamed, this.m_renamed);
            this.E_renamed.set(0.0f, 0.0f);
        }
    }

    public void setFocusManager(com.oplus.camera.ui.preview.s_renamed sVar) {
        this.p_renamed = sVar;
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent) {
        boolean zB;
        com.oplus.camera.ui.preview.s_renamed sVar = this.p_renamed;
        if (sVar == null || !sVar.K_renamed()) {
            return false;
        }
        float x_renamed = motionEvent.getX();
        float y_renamed = motionEvent.getY();
        if (this.p_renamed != null) {
            setAlpha(1.0f);
            this.p_renamed.L_renamed();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.A_renamed && !this.z_renamed) {
                return false;
            }
            this.B_renamed = x_renamed;
            this.C_renamed = y_renamed;
            this.F_renamed = this.B_renamed;
            this.G_renamed = this.C_renamed;
            return true;
        }
        if (action != 2) {
            h_renamed();
            j_renamed();
            this.F_renamed = -1.0f;
            this.G_renamed = -1.0f;
            return true;
        }
        if (this.F_renamed > -0.5f && this.G_renamed > -0.5f) {
            float x2 = motionEvent.getX() - this.F_renamed;
            float y2 = motionEvent.getY() - this.G_renamed;
            if (this.z_renamed) {
                zB = this.p_renamed.b_renamed((int) (this.D_renamed.x_renamed + x2), (int) (this.D_renamed.y_renamed + y2));
                if (zB) {
                    this.D_renamed.offset(x2, y2);
                    d_renamed((int) this.D_renamed.x_renamed, (int) this.D_renamed.y_renamed);
                }
            } else {
                zB = false;
            }
            if (this.A_renamed && (zB = this.p_renamed.b_renamed((int) (this.E_renamed.x_renamed + x2), (int) (this.E_renamed.y_renamed + y2)))) {
                this.E_renamed.offset(x2, y2);
                c_renamed((int) this.E_renamed.x_renamed, (int) this.E_renamed.y_renamed);
            }
            this.H_renamed = true;
            if (zB) {
                this.F_renamed = x_renamed;
                this.G_renamed = y_renamed;
            }
            c_renamed(false);
        }
        return true;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.d_renamed = i2;
        this.e_renamed = i_renamed;
    }

    private float b_renamed(float f_renamed) {
        int i_renamed = this.j_renamed;
        int i2 = this.n_renamed;
        return com.oplus.camera.util.Util.a_renamed(f_renamed, (i_renamed / 2.0f) + i2, (this.e_renamed - (i_renamed / 2.0f)) - i2);
    }

    private float c_renamed(float f_renamed) {
        int i_renamed = this.k_renamed;
        int i2 = this.n_renamed;
        return com.oplus.camera.util.Util.a_renamed(f_renamed, (i_renamed / 2.0f) + i2, (this.d_renamed - (i_renamed / 2.0f)) - i2);
    }

    public void b_renamed(int i_renamed, int i2) {
        d_renamed(i_renamed, i2);
        c_renamed(i_renamed, i2);
        a_renamed(i_renamed, i2, false);
        a_renamed(this.p_renamed.s_renamed());
        c_renamed(true);
    }

    public void c_renamed(int i_renamed, int i2) {
        float fB_renamed = b_renamed(i_renamed);
        float fC_renamed = c_renamed(i2) - (this.g_renamed / 2.0f);
        this.t_renamed.setRotation(-this.o_renamed);
        this.t_renamed.setTranslationX(fB_renamed - (this.f_renamed / 2.0f));
        this.t_renamed.setTranslationY(fC_renamed);
        this.t_renamed.requestLayout();
    }

    public void d_renamed(int i_renamed, int i2) {
        float fB_renamed = b_renamed(i_renamed);
        float fC_renamed = c_renamed(i2) - (this.i_renamed / 2.0f);
        this.q_renamed.setRotation(-this.o_renamed);
        this.q_renamed.setTranslationX(fB_renamed - (this.h_renamed / 2.0f));
        this.q_renamed.setTranslationY(fC_renamed);
        this.q_renamed.requestLayout();
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (this.H_renamed) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final float fB_renamed = b_renamed(i_renamed);
        final float fC_renamed = c_renamed(i2);
        if (z_renamed) {
            com.oplus.camera.ui.preview.ExposureSeekbarContainer exposureSeekbarContainer = this.w_renamed;
            float alpha = exposureSeekbarContainer != null ? exposureSeekbarContainer.getAlpha() : 1.0f;
            if (java.lang.Float.compare(alpha, 0.0f) > 0) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.w_renamed, (android.util.Property<com.oplus.camera.ui.preview.ExposureSeekbarContainer, java.lang.Float>) ALPHA, alpha, 0.0f);
                objectAnimatorOfFloat.setDuration(300L);
                objectAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.n_renamed.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.oplus.camera.ui.preview.n_renamed.this.a_renamed(fB_renamed, fC_renamed);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            a_renamed(fB_renamed, fC_renamed);
            return;
        }
        this.w_renamed.a_renamed(fB_renamed, fC_renamed, this.e_renamed, this.d_renamed, this.o_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.ui.preview.ExposureSeekbarContainer exposureSeekbarContainer = this.w_renamed;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.a_renamed(f_renamed, f2, this.e_renamed, this.d_renamed, this.o_renamed);
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.w_renamed, (android.util.Property<com.oplus.camera.ui.preview.ExposureSeekbarContainer, java.lang.Float>) ALPHA, this.w_renamed.getAlpha(), 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
        }
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            android.graphics.PorterDuffColorFilter porterDuffColorFilter = new android.graphics.PorterDuffColorFilter(com.oplus.camera.util.Util.A_renamed(getContext()), android.graphics.PorterDuff.Mode.SRC_ATOP);
            this.u_renamed.setColorFilter(porterDuffColorFilter);
            this.r_renamed.setColorFilter(porterDuffColorFilter);
        } else {
            this.u_renamed.setColorFilter((android.graphics.ColorFilter) null);
            this.r_renamed.setColorFilter((android.graphics.ColorFilter) null);
        }
        this.w_renamed.setLockedState(z_renamed);
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.ExposureSeekbarContainer exposureSeekbarContainer = this.w_renamed;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.a_renamed(z_renamed);
        }
        this.H_renamed = false;
    }

    public void c_renamed(boolean z_renamed) {
        boolean z2 = false;
        if (this.H_renamed) {
            this.v_renamed.setVisibility(0);
        } else {
            this.v_renamed.setVisibility(8);
        }
        if (this.H_renamed) {
            this.s_renamed.setVisibility(0);
        } else {
            this.s_renamed.setVisibility(8);
        }
        if (this.p_renamed.G_renamed()) {
            this.r_renamed.setVisibility(8);
            this.u_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.hasselbald_xpan_indicator_focus);
        } else {
            this.r_renamed.setVisibility(0);
            this.u_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.ic_indicator_focus);
        }
        this.w_renamed.setToggleViewEnable(this.p_renamed.J_renamed());
        if (this.p_renamed.D_renamed()) {
            if (!this.H_renamed && !d_renamed()) {
                z2 = true;
            }
            setManualExposureEnable(z2);
            return;
        }
        setManualExposureEnable(false);
    }

    public void setManualExposureEnable(boolean z_renamed) {
        this.y_renamed = z_renamed;
        this.w_renamed.setVisibility(z_renamed ? 0 : 8);
    }

    public boolean b_renamed() {
        return this.w_renamed.isShown();
    }

    public void d_renamed(boolean z_renamed) {
        this.w_renamed.b_renamed(z_renamed);
    }

    public void setMoveDistance(float f_renamed) {
        this.w_renamed.setMoveDistance(f_renamed);
    }

    public int getFocusRectWidth() {
        return this.l_renamed;
    }

    public int getExposureRectWidth() {
        return this.j_renamed;
    }

    public void c_renamed() {
        if (this.x_renamed) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showStart, mbForceDisableFocusIndicator is_renamed true.");
            return;
        }
        e_renamed();
        if (this.f7095a != 0) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showStart, short circle, mState: " + this.f7095a);
            return;
        }
        setVisibility(0);
        c_renamed(false);
        a_renamed(1.2f, 1.2f, false);
        a_renamed(1.0f, 1.0f, true, false, 250L);
        k_renamed();
        this.f7095a = 1;
    }

    private void k_renamed() {
        this.w_renamed.animate().alphaBy(0.0f).alpha(1.0f).setDuration(250L).setInterpolator(this.J_renamed);
    }

    @Override // com.oplus.camera.ui.preview.m_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        a_renamed(z_renamed, false, z2);
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.x_renamed || z3) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showSuccess, mbForceDisableFocusIndicator: " + this.x_renamed + ", isExposureAdjusting: " + z3);
            return;
        }
        if (!z2 && this.f7095a != 1) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showSuccess, short circle, aEAFLocked: " + z2 + " mState: " + this.f7095a);
            return;
        }
        setVisibility(0);
        c_renamed(false);
        a_renamed(1.0f, 1.0f, true, z_renamed, 100L);
        this.f7095a = 2;
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        if (this.x_renamed || z2) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showFail, mbForceDisableFocusIndicator: " + this.x_renamed + ", isExposureAdjusting: " + z2);
            return;
        }
        if (this.f7095a != 1) {
            com.oplus.camera.e_renamed.c_renamed("FocusIndicatorRotateLayout", "showFail, short circle, mState: " + this.f7095a);
            return;
        }
        setVisibility(0);
        c_renamed(false);
        a_renamed(1.0f, 1.0f, true, z_renamed, 100L);
        this.f7095a = 2;
    }

    public boolean d_renamed() {
        return this.f7095a == 0;
    }

    public void setOnVisibilityChangedListener(com.oplus.camera.ui.preview.n_renamed.c_renamed cVar) {
        this.M_renamed = cVar;
    }

    public void e_renamed() {
        removeCallbacks(this.f7096b);
        this.H_renamed = false;
        b_renamed(true);
        this.f7096b.run();
        a_renamed(1.0f, 1.0f, false);
    }

    @Override // android.view.View
    public void setAlpha(float f_renamed) {
        this.L_renamed = f_renamed;
        this.w_renamed.setAlpha(f_renamed);
        this.t_renamed.setAlpha(f_renamed);
        this.r_renamed.setAlpha(f_renamed);
        this.s_renamed.setAlpha(f_renamed);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i_renamed) {
        super.onVisibilityChanged(view, i_renamed);
        com.oplus.camera.ui.preview.n_renamed.c_renamed cVar = this.M_renamed;
        if (cVar != null) {
            cVar.onVisibilityChanged(view, i_renamed);
        }
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.L_renamed;
    }

    private void a_renamed(float f_renamed, float f2, boolean z_renamed) {
        a_renamed(f_renamed, f2, z_renamed, false, 0L);
    }

    private void a_renamed(float f_renamed, float f2, boolean z_renamed, boolean z2, long j_renamed) {
        this.q_renamed.animate().cancel();
        this.t_renamed.animate().cancel();
        if (z_renamed) {
            this.q_renamed.animate().withLayer().setDuration(j_renamed).scaleX(f_renamed).scaleY(f2).setInterpolator(this.J_renamed).withEndAction(z2 ? this.f7097c : null);
            this.t_renamed.animate().withLayer().setDuration(j_renamed).scaleX(f_renamed).scaleY(f2).setInterpolator(this.J_renamed).withEndAction(z2 ? this.f7097c : null);
        } else {
            this.q_renamed.setScaleX(f_renamed);
            this.q_renamed.setScaleY(f2);
            this.t_renamed.setScaleX(f_renamed);
            this.t_renamed.setScaleY(f2);
        }
    }

    public void e_renamed(boolean z_renamed) {
        this.x_renamed = z_renamed;
    }

    public boolean f_renamed() {
        return this.H_renamed;
    }

    private void a_renamed(int i_renamed) {
        this.K_renamed.cancel();
        float rotation = this.q_renamed.getRotation();
        int i2 = (int) rotation;
        long jC = com.oplus.camera.ui.RotateImageView.c_renamed(i2, i_renamed);
        this.K_renamed.setFloatValues(rotation, com.oplus.camera.ui.RotateImageView.b_renamed(i2, i_renamed) + rotation);
        this.K_renamed.setDuration(jC);
        this.K_renamed.start();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.o_renamed = i_renamed;
        a_renamed(-i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed
    public void a_renamed(float f_renamed) {
        this.p_renamed.a_renamed(f_renamed);
    }

    @Override // com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed
    public void a_renamed() {
        this.p_renamed.i_renamed(true);
    }

    /* compiled from: FocusIndicatorRotateLayout.java */
    private class b_renamed implements java.lang.Runnable {
        private b_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.ui.preview.n_renamed nVar = com.oplus.camera.ui.preview.n_renamed.this;
            nVar.postDelayed(nVar.f7096b, 200L);
        }
    }

    /* compiled from: FocusIndicatorRotateLayout.java */
    private class a_renamed implements java.lang.Runnable {
        private a_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.ui.preview.n_renamed.this.setVisibility(4);
            com.oplus.camera.ui.preview.n_renamed.this.f7095a = 0;
        }
    }
}
