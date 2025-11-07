package com.oplus.camera.ui;

/* compiled from: CameraSeekBar.java */
/* loaded from: classes2.dex */
public abstract class b_renamed extends android.view.View {
    protected float A_renamed;
    protected float B_renamed;
    protected float C_renamed;
    protected float D_renamed;
    protected float E_renamed;
    protected volatile float F_renamed;
    protected float G_renamed;
    protected float H_renamed;
    protected float I_renamed;
    protected float J_renamed;
    protected float K_renamed;
    protected float L_renamed;
    protected int M_renamed;
    protected float N_renamed;
    protected float O_renamed;
    protected float P_renamed;
    protected float Q_renamed;
    protected int R_renamed;
    protected volatile int S_renamed;
    protected boolean T_renamed;
    protected boolean U_renamed;
    protected boolean V_renamed;
    protected boolean W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.animation.ValueAnimator f5848a;
    protected android.view.animation.Interpolator aa_renamed;
    protected android.view.animation.Interpolator ab_renamed;
    protected float ac_renamed;
    protected float ad_renamed;
    protected float ae_renamed;
    protected float af_renamed;
    protected float ag_renamed;
    protected float ah_renamed;
    protected long ai_renamed;
    protected android.graphics.Paint aj_renamed;
    protected android.content.Context ak_renamed;
    protected com.oplus.camera.ui.b_renamed.a_renamed al_renamed;
    public boolean am_renamed;
    protected android.os.Handler an_renamed;
    private final android.view.animation.PathInterpolator ao_renamed;
    private final android.view.animation.PathInterpolator ap_renamed;
    private android.animation.AnimatorSet aq_renamed;
    private android.animation.AnimatorSet ar_renamed;
    private int as_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected android.animation.ValueAnimator f5849b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.animation.ValueAnimator f5850c;
    protected android.animation.ValueAnimator d_renamed;
    protected android.animation.ValueAnimator e_renamed;
    protected android.animation.ValueAnimator f_renamed;
    protected android.animation.ValueAnimator g_renamed;
    protected android.animation.ValueAnimator h_renamed;
    protected android.animation.ValueAnimator i_renamed;
    protected android.animation.ValueAnimator j_renamed;
    protected android.animation.ValueAnimator k_renamed;
    protected android.animation.ValueAnimator l_renamed;
    protected android.animation.ValueAnimator m_renamed;
    protected android.animation.ValueAnimator n_renamed;
    protected android.animation.ValueAnimator o_renamed;
    protected android.animation.ValueAnimator p_renamed;
    protected android.animation.ValueAnimator q_renamed;
    protected android.animation.AnimatorSet r_renamed;
    protected android.animation.AnimatorSet s_renamed;
    protected android.animation.AnimatorSet t_renamed;
    protected android.graphics.Paint u_renamed;
    protected android.graphics.Paint v_renamed;
    protected android.graphics.Paint w_renamed;
    protected android.graphics.Paint x_renamed;
    protected android.graphics.Paint y_renamed;
    protected float z_renamed;

    /* compiled from: CameraSeekBar.java */
    public interface a_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(float f_renamed, boolean z_renamed);

        boolean a_renamed();

        void b_renamed();

        void b_renamed(float f_renamed);

        void c_renamed();

        void c_renamed(float f_renamed);

        void d_renamed();

        void d_renamed(float f_renamed);

        void e_renamed();

        void f_renamed();

        void g_renamed();

        void h_renamed();
    }

    protected void a_renamed(android.graphics.Canvas canvas) {
    }

    protected void b_renamed(android.graphics.Canvas canvas) {
    }

    protected void c_renamed(android.graphics.Canvas canvas) {
    }

    protected void d_renamed(android.graphics.Canvas canvas) {
    }

    protected void e_renamed(android.graphics.Canvas canvas) {
    }

    protected void h_renamed(android.graphics.Canvas canvas) {
    }

    protected void i_renamed(android.graphics.Canvas canvas) {
    }

    protected void j_renamed(android.graphics.Canvas canvas) {
    }

    protected void k_renamed() {
    }

    protected abstract void o_renamed();

    public void p_renamed() {
    }

    public void q_renamed() {
    }

    protected void t_renamed() {
    }

    protected void a_renamed() {
        d_renamed();
        this.f5848a.start();
        this.f5849b.start();
        this.f5850c.start();
        this.e_renamed.start();
        this.f_renamed.start();
        this.g_renamed.start();
    }

    protected void a_renamed(boolean z_renamed) {
        c_renamed();
        if (z_renamed) {
            this.i_renamed.setFloatValues(0.0f, 1.0f);
        } else {
            this.i_renamed.setFloatValues(0.0f, 0.0f);
        }
        this.h_renamed.start();
        this.i_renamed.start();
        this.j_renamed.start();
        this.k_renamed.start();
        this.l_renamed.start();
        this.m_renamed.start();
    }

    protected boolean b_renamed() {
        return this.h_renamed.isRunning() || this.i_renamed.isRunning() || this.j_renamed.isRunning() || this.k_renamed.isRunning() || this.l_renamed.isRunning() || this.m_renamed.isRunning();
    }

    protected void c_renamed() {
        this.f5848a.cancel();
        this.f5849b.cancel();
        this.f5850c.cancel();
        this.e_renamed.cancel();
        this.f_renamed.cancel();
        this.g_renamed.cancel();
    }

    protected void d_renamed() {
        this.h_renamed.cancel();
        this.i_renamed.cancel();
        this.j_renamed.cancel();
        this.k_renamed.cancel();
        this.l_renamed.cancel();
        this.m_renamed.cancel();
    }

    protected void e_renamed() {
        this.h_renamed.end();
        this.i_renamed.end();
        this.j_renamed.end();
        this.k_renamed.end();
        this.l_renamed.end();
        this.m_renamed.end();
    }

    protected void f_renamed() {
        this.z_renamed = 1.0f;
        this.A_renamed = 0.0f;
        this.B_renamed = 1.0f;
        this.C_renamed = 1.0f;
        this.D_renamed = 1.0f;
        this.E_renamed = 1.0f;
    }

    protected void g_renamed() {
        this.z_renamed = 0.0f;
        this.A_renamed = 1.0f;
        this.B_renamed = 0.0f;
        this.C_renamed = 0.0f;
        this.D_renamed = 0.0f;
        this.E_renamed = 0.0f;
        k_renamed();
    }

    protected void h_renamed() {
        this.f5848a = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5848a.setDuration(500L);
        this.f5848a.setInterpolator(getExpandInterpolator());
        this.f5848a.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.z_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.invalidate();
            }
        });
        this.f5849b = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f5849b.setDuration(250L);
        this.f5849b.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.f5849b.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.23
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.A_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f5850c = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5850c.setDuration(400L);
        this.f5850c.setInterpolator(getExpandInterpolator());
        this.f5850c.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.29
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.B_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.e_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.e_renamed.setDuration(500L);
        this.e_renamed.setInterpolator(getExpandControlPanelInterpolator());
        this.e_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.30
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.C_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f_renamed.setDuration(500L);
        this.f_renamed.setInterpolator(getExpandInterpolator());
        this.f_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.31
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.D_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.g_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g_renamed.setDuration(500L);
        this.g_renamed.setInterpolator(getExpandInterpolator());
        this.g_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.32
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.E_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    protected void i_renamed() {
        this.h_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.h_renamed.setDuration(500L);
        this.h_renamed.setInterpolator(getExpandInterpolator());
        this.h_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.33
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.z_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.invalidate();
            }
        });
        this.h_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.b_renamed.34
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
                com.oplus.camera.ui.b_renamed.this.invalidate();
                com.oplus.camera.ui.b_renamed.this.g_renamed();
                com.oplus.camera.ui.b_renamed.this.setAlpha(1.0f);
                com.oplus.camera.ui.b_renamed.this.setStatus(0);
                if (com.oplus.camera.ui.b_renamed.this.T_renamed) {
                    com.oplus.camera.ui.b_renamed.this.setVisibility(8);
                }
                com.oplus.camera.ui.b_renamed.this.o_renamed();
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.T_renamed = false;
                bVar.U_renamed = false;
                if (bVar.al_renamed != null) {
                    com.oplus.camera.ui.b_renamed.this.al_renamed.d_renamed();
                }
            }
        });
        this.j_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.j_renamed.setDuration(400L);
        this.j_renamed.setStartDelay(150L);
        this.j_renamed.setInterpolator(getExpandInterpolator());
        this.j_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.B_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.i_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.i_renamed.setDuration(300L);
        this.i_renamed.setStartDelay(150L);
        this.i_renamed.setInterpolator(getExpandPointAlphaInterpolator());
        this.i_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.A_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.i_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.b_renamed.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.k_renamed();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.k_renamed();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.k_renamed();
            }
        });
        this.k_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.k_renamed.setDuration(250L);
        this.k_renamed.setInterpolator(getExpandControlPanelInterpolator());
        this.k_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.C_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                if (com.oplus.camera.ui.b_renamed.this.al_renamed != null) {
                    com.oplus.camera.ui.b_renamed.this.al_renamed.c_renamed(com.oplus.camera.ui.b_renamed.this.C_renamed);
                }
            }
        });
        this.l_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.l_renamed.setDuration(500L);
        this.l_renamed.setInterpolator(getExpandInterpolator());
        this.l_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.D_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.m_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.m_renamed.setDuration(250L);
        this.m_renamed.setInterpolator(getExpandPointAlphaInterpolator());
        this.m_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.E_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
    }

    private void u_renamed() {
        this.n_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n_renamed.setDuration(450L);
        this.n_renamed.setInterpolator(getExpandInterpolator());
        this.n_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.F_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.n_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.aj_renamed.setAlpha(255);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.setStatus(9);
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.F_renamed = 1.0f;
                bVar.u_renamed.setAlpha(255);
            }
        });
        this.p_renamed = android.animation.ValueAnimator.ofInt(0, 255);
        this.p_renamed.setDuration(200L);
        this.p_renamed.setInterpolator(getExpandControlPanelInterpolator());
        this.p_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.M_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.p_renamed.setStartDelay(150L);
        this.o_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.o_renamed.setDuration(450L);
        this.o_renamed.setInterpolator(getExpandInterpolator());
        this.o_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.F_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.o_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.setStatus(0);
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.F_renamed = 0.0f;
                bVar.N_renamed = -1.0f;
                bVar.u_renamed.setAlpha(255);
            }
        });
        this.q_renamed = android.animation.ValueAnimator.ofInt(255, 0);
        this.q_renamed.setDuration(200L);
        this.q_renamed.setInterpolator(getExpandControlPanelInterpolator());
        this.q_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.M_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5848a = null;
        this.f5849b = null;
        this.f5850c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = 0.0f;
        this.A_renamed = 0.0f;
        this.B_renamed = 0.0f;
        this.C_renamed = 0.0f;
        this.D_renamed = 0.0f;
        this.E_renamed = 0.0f;
        this.F_renamed = 0.0f;
        this.G_renamed = 0.0f;
        this.H_renamed = 0.0f;
        this.I_renamed = 0.0f;
        this.J_renamed = 1.0f;
        this.K_renamed = 0.0f;
        this.L_renamed = 1.0f;
        this.M_renamed = 0;
        this.N_renamed = -1.0f;
        this.O_renamed = -1.0f;
        this.P_renamed = -1.0f;
        this.Q_renamed = 0.0f;
        this.R_renamed = 0;
        this.S_renamed = -1;
        this.T_renamed = false;
        this.U_renamed = false;
        this.V_renamed = false;
        this.W_renamed = false;
        this.aa_renamed = null;
        this.ab_renamed = null;
        this.ac_renamed = 0.0f;
        this.ad_renamed = 0.0f;
        this.ae_renamed = 0.0f;
        this.af_renamed = 0.0f;
        this.ag_renamed = 0.0f;
        this.ah_renamed = com.oplus.camera.util.Util.O_renamed() / 2.0f;
        this.ai_renamed = 3000L;
        this.aj_renamed = null;
        this.ak_renamed = null;
        this.al_renamed = null;
        this.ao_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.ap_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.am_renamed = false;
        this.aq_renamed = null;
        this.ar_renamed = null;
        this.as_renamed = 0;
        this.an_renamed = new android.os.Handler() { // from class: com.oplus.camera.ui.b_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                com.oplus.camera.ui.b_renamed.this.b_renamed(false);
            }
        };
        this.ak_renamed = context;
        this.R_renamed = com.oplus.camera.util.Util.getScreenWidth();
        this.af_renamed = (this.R_renamed * 1.0f) / 2.0f;
        this.as_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_animation_y);
        this.aa_renamed = getCollapseInterpolator();
        this.ab_renamed = getExpandInterpolator();
        i_renamed();
        h_renamed();
        u_renamed();
        j_renamed();
        setStatus(0);
    }

    protected void j_renamed() {
        this.r_renamed = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(getExpandInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.G_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(500L);
        valueAnimatorOfFloat2.setInterpolator(this.ao_renamed);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.H_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat3 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.setInterpolator(this.ao_renamed);
        valueAnimatorOfFloat3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.I_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.r_renamed.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2).with(valueAnimatorOfFloat3);
        this.r_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.setStatus(0);
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.G_renamed = 1.0f;
                bVar.H_renamed = 1.0f;
                bVar.I_renamed = 1.0f;
            }
        });
        this.s_renamed = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat4 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat4.setDuration(500L);
        valueAnimatorOfFloat4.setInterpolator(getExpandInterpolator());
        valueAnimatorOfFloat4.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.G_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat5 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat5.setDuration(250L);
        valueAnimatorOfFloat5.setInterpolator(this.ao_renamed);
        valueAnimatorOfFloat5.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.20
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.H_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.s_renamed.play(valueAnimatorOfFloat4).with(valueAnimatorOfFloat5);
        this.s_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.21
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.b_renamed.this.setStatus(0);
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.G_renamed = 1.0f;
                bVar.H_renamed = 0.0f;
            }
        });
        this.t_renamed = new android.animation.AnimatorSet();
        android.animation.ValueAnimator valueAnimatorOfFloat6 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat6.setDuration(250L);
        valueAnimatorOfFloat6.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        valueAnimatorOfFloat6.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.22
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.K_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat7 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat7.setDuration(500L);
        valueAnimatorOfFloat7.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
        valueAnimatorOfFloat7.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.24
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.L_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        android.animation.ValueAnimator valueAnimatorOfFloat8 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat8.setDuration(500L);
        valueAnimatorOfFloat8.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
        valueAnimatorOfFloat8.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.b_renamed.25
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.b_renamed.this.J_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.b_renamed.this.postInvalidate();
            }
        });
        this.t_renamed.play(valueAnimatorOfFloat7).with(valueAnimatorOfFloat8).with(valueAnimatorOfFloat6);
        this.t_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.26
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.oplus.camera.ui.b_renamed.this.setStatus(0);
                com.oplus.camera.ui.b_renamed bVar = com.oplus.camera.ui.b_renamed.this;
                bVar.K_renamed = 0.0f;
                bVar.J_renamed = 1.0f;
                bVar.L_renamed = 1.0f;
                bVar.postInvalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                super.onAnimationCancel(animator);
            }
        });
    }

    public void setOnSeekBarChangeListener(com.oplus.camera.ui.b_renamed.a_renamed aVar) {
        this.al_renamed = aVar;
    }

    public void setStatus(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraSeekBar", "setStatus, status: " + i_renamed);
        this.S_renamed = i_renamed;
    }

    public int getStatus() {
        return this.S_renamed;
    }

    public void l_renamed() {
        e_renamed();
    }

    public void m_renamed() {
        d_renamed();
        c_renamed();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int i_renamed = this.S_renamed;
        if (i_renamed != 15) {
            switch (i_renamed) {
                case 0:
                    b_renamed(canvas);
                    break;
                case 1:
                    f_renamed(canvas);
                    break;
                case 2:
                    j_renamed(canvas);
                    break;
                case 3:
                    g_renamed(canvas);
                    break;
                case 4:
                    h_renamed(canvas);
                    break;
                case 5:
                    i_renamed(canvas);
                    break;
                case 6:
                    g_renamed();
                    g_renamed(canvas);
                    break;
                case 7:
                    r_renamed();
                    g_renamed(canvas);
                    this.U_renamed = false;
                    break;
                case 8:
                    c_renamed(canvas);
                    break;
                case 9:
                    d_renamed(canvas);
                    break;
                case 10:
                    e_renamed(canvas);
                    break;
            }
        }
        a_renamed(canvas);
    }

    protected void f_renamed(android.graphics.Canvas canvas) {
        if (1.0f > this.z_renamed) {
            this.al_renamed.b_renamed(this.C_renamed);
            return;
        }
        this.al_renamed.b_renamed(1.0f);
        j_renamed(canvas);
        f_renamed();
        setStatus(2);
    }

    protected void g_renamed(android.graphics.Canvas canvas) {
        com.oplus.camera.ui.b_renamed.a_renamed aVar = this.al_renamed;
        if (aVar != null && !this.U_renamed) {
            aVar.c_renamed();
            this.U_renamed = true;
        }
        if (0.0f >= this.z_renamed || !this.T_renamed) {
            return;
        }
        setAlpha(this.C_renamed);
    }

    public void n_renamed() {
        if (1 == this.S_renamed || 2 == this.S_renamed) {
            c_renamed();
            setStatus(7);
            invalidate();
        }
        if (3 == this.S_renamed) {
            this.ac_renamed = 0.0f;
            invalidate();
        }
    }

    public long getCollapseDelay() {
        return this.ai_renamed;
    }

    public void setCollapseDelay(long j_renamed) {
        this.ai_renamed = j_renamed;
    }

    protected void r_renamed() {
        g_renamed();
        setStatus(0);
        setAlpha(1.0f);
        this.U_renamed = false;
    }

    public void a_renamed(android.animation.AnimatorListenerAdapter animatorListenerAdapter, boolean z_renamed, boolean z2) {
        if (3 != this.S_renamed) {
            if (1 == this.S_renamed || 2 == this.S_renamed) {
                this.an_renamed.removeMessages(1);
                this.T_renamed = true;
                setStatus(3);
                a_renamed(false);
                return;
            }
            b_renamed(animatorListenerAdapter, z_renamed, z2);
            return;
        }
        this.T_renamed = true;
    }

    public boolean s_renamed() {
        return this.V_renamed || 8 == this.S_renamed || 9 == this.S_renamed || 10 == this.S_renamed;
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (6 == this.S_renamed || (3 == this.S_renamed && !this.T_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("CameraSeekBar", "performShow not prepared, mStatus: " + this.S_renamed);
            return;
        }
        if (3 == this.S_renamed) {
            d_renamed();
        }
        if (1 == this.S_renamed || 2 == this.S_renamed || 3 == this.S_renamed) {
            setAlpha(1.0f);
            setVisibility(0);
            this.T_renamed = false;
            if (z_renamed) {
                this.an_renamed.removeMessages(1);
                setStatus(3);
                a_renamed(true);
                return;
            }
            return;
        }
        a_renamed(z2, z3);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSeekBar", "showZoomMenuButton, needAnim: " + z_renamed + ", needTranslateAni: " + z2);
        android.animation.AnimatorSet animatorSet = this.aq_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.aq_renamed.cancel();
        } else {
            if (isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.ar_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.ao_renamed);
            objectAnimatorOfFloat.setDuration(z2 ? 400L : 250L);
            this.ar_renamed = new android.animation.AnimatorSet();
            android.animation.AnimatorSet.Builder builderPlay = this.ar_renamed.play(objectAnimatorOfFloat);
            if (z2) {
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, "translationY", -this.as_renamed, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.ap_renamed);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
                this.ar_renamed.setStartDelay(150L);
            } else {
                setTranslationY(0.0f);
            }
            this.ar_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.b_renamed.this.setAlpha(0.0f);
                    com.oplus.camera.ui.b_renamed.this.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.b_renamed.this.setAlpha(1.0f);
                    com.oplus.camera.ui.b_renamed.this.setTranslationY(0.0f);
                    com.oplus.camera.ui.b_renamed.this.setVisibility(0);
                }
            });
            this.ar_renamed.start();
            return;
        }
        setAlpha(1.0f);
        setTranslationY(0.0f);
        setVisibility(0);
    }

    private void b_renamed(android.animation.AnimatorListenerAdapter animatorListenerAdapter, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraSeekBar", "hideZoomMenuButton, needAnim: " + z_renamed + ", needTranslateAni: " + z2);
        android.animation.AnimatorSet animatorSet = this.ar_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.ar_renamed.cancel();
        } else {
            if (!isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.aq_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.ao_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            this.aq_renamed = new android.animation.AnimatorSet();
            android.animation.AnimatorSet.Builder builderPlay = this.aq_renamed.play(objectAnimatorOfFloat);
            if (z2) {
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this, "translationY", 0.0f, -this.as_renamed);
                objectAnimatorOfFloat2.setInterpolator(this.ap_renamed);
                objectAnimatorOfFloat2.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat2);
            } else {
                setTranslationY(0.0f);
            }
            if (animatorListenerAdapter != null) {
                this.aq_renamed.addListener(animatorListenerAdapter);
            }
            this.aq_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.b_renamed.28
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.b_renamed.this.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.b_renamed.this.setAlpha(1.0f);
                    com.oplus.camera.ui.b_renamed.this.setTranslationY(0.0f);
                    com.oplus.camera.ui.b_renamed.this.setVisibility(8);
                }
            });
            this.aq_renamed.start();
            return;
        }
        setVisibility(8);
    }

    protected boolean b_renamed(boolean z_renamed) {
        if (3 != this.S_renamed && this.S_renamed != 0 && 9 != this.S_renamed && 8 != this.S_renamed && 10 != this.S_renamed && 15 != this.S_renamed && 6 != this.S_renamed) {
            if (8 == getVisibility() || 4 == getVisibility()) {
                setStatus(0);
            } else {
                this.T_renamed = false;
                setStatus(z_renamed ? 6 : 3);
                a_renamed(true);
                return true;
            }
        }
        return false;
    }

    protected void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.b_renamed.a_renamed aVar;
        if (1 == this.S_renamed || 8 == this.S_renamed || 10 == this.S_renamed || 9 == this.S_renamed || getVisibility() != 0) {
            return;
        }
        if ((getParent() == null || ((android.view.View) getParent()).getVisibility() == 0) && (aVar = this.al_renamed) != null && aVar.a_renamed()) {
            this.T_renamed = false;
            this.W_renamed = false;
            setStatus(1);
            if (!z_renamed) {
                this.am_renamed = false;
            } else {
                this.am_renamed = true;
            }
            t_renamed();
            this.al_renamed.b_renamed();
            a_renamed();
        }
    }

    public void setRate(float f_renamed) {
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(f_renamed, -0.042f, 1.042f);
        this.ae_renamed = this.ad_renamed;
        this.ad_renamed = fA_renamed;
    }

    protected android.view.animation.Interpolator getCollapseInterpolator() {
        return android.view.animation.AnimationUtils.loadInterpolator(this.ak_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_out);
    }

    protected android.view.animation.Interpolator getExpandInterpolator() {
        return android.view.animation.AnimationUtils.loadInterpolator(this.ak_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_in);
    }

    protected android.view.animation.Interpolator getExpandControlPanelInterpolator() {
        return android.view.animation.AnimationUtils.loadInterpolator(this.ak_renamed, com.oplus.camera.R_renamed.anim.zoom_seek_bar_interpolator_in);
    }

    protected android.view.animation.Interpolator getExpandPointAlphaInterpolator() {
        return android.view.animation.AnimationUtils.loadInterpolator(this.ak_renamed, com.oplus.camera.R_renamed.anim.zoom_interpolator_point_alpha);
    }

    @Override // android.view.View
    public int getLayoutDirection() {
        return getContext().getResources().getConfiguration().getLayoutDirection();
    }
}
