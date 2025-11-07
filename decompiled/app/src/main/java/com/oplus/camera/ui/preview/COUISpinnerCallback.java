package com.oplus.camera.ui.preview;

/* compiled from: GradienterAssistView.java */
/* loaded from: classes2.dex */
public class p_renamed extends android.view.View {
    private android.graphics.Point A_renamed;
    private android.graphics.Paint B_renamed;
    private com.oplus.camera.ui.preview.p_renamed.a_renamed C_renamed;
    private com.oplus.camera.ui.preview.p_renamed.a_renamed D_renamed;
    private com.oplus.camera.ui.preview.p_renamed.a_renamed E_renamed;
    private android.animation.ValueAnimator F_renamed;
    private android.animation.ValueAnimator G_renamed;
    private android.animation.ValueAnimator H_renamed;
    private android.animation.ValueAnimator I_renamed;
    private android.animation.ValueAnimator J_renamed;
    private android.animation.AnimatorSet K_renamed;
    private android.animation.AnimatorSet L_renamed;
    private float[] M_renamed;
    private float[] N_renamed;
    private float[] O_renamed;
    private int[] P_renamed;
    private int[] Q_renamed;
    private java.util.LinkedList<com.oplus.camera.ui.preview.p_renamed.a_renamed> R_renamed;
    private com.oplus.camera.ui.preview.p_renamed.b_renamed S_renamed;
    private android.hardware.SensorEventCallback T_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f7108a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f7109b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f7110c;
    private boolean d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private float p_renamed;
    private long q_renamed;
    private long r_renamed;
    private android.graphics.Rect s_renamed;
    private android.graphics.Rect t_renamed;
    private android.graphics.drawable.Drawable u_renamed;
    private android.graphics.drawable.Drawable v_renamed;
    private android.graphics.Bitmap w_renamed;
    private android.graphics.Bitmap x_renamed;
    private android.graphics.Bitmap y_renamed;
    private android.graphics.Bitmap z_renamed;

    /* compiled from: GradienterAssistView.java */
    interface b_renamed {
        void a_renamed();
    }

    private boolean a_renamed(int i_renamed, int i2) {
        return (i_renamed & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float c_renamed(float f_renamed, float f2) {
        float f3 = f2 - f_renamed;
        return f3 < -90.0f ? f3 + 180.0f : f3 > 90.0f ? f3 - 180.0f : f3;
    }

    static /* synthetic */ int f_renamed(com.oplus.camera.ui.preview.p_renamed pVar) {
        int i_renamed = pVar.i_renamed;
        pVar.i_renamed = i_renamed + 1;
        return i_renamed;
    }

    public void setViewLayoutType(int i_renamed) {
        this.n_renamed = i_renamed;
        this.e_renamed = a_renamed(this.n_renamed, 1);
        this.f_renamed = a_renamed(this.n_renamed, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(float[] fArr) {
        if (fArr == null) {
            return true;
        }
        for (float f_renamed : fArr) {
            if (java.lang.Float.compare(f_renamed, 0.0f) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean a_renamed(float f_renamed) {
        return 1.5707963267948966d - ((double) java.lang.Math.abs(this.O_renamed[2])) < ((double) f_renamed) && java.lang.Math.abs(this.O_renamed[0]) < f_renamed && java.lang.Math.abs(this.O_renamed[1]) < f_renamed;
    }

    private boolean b_renamed(float f_renamed) {
        return 1.5707963267948966d - ((double) java.lang.Math.abs(this.O_renamed[0])) < ((double) f_renamed) && java.lang.Math.abs(this.O_renamed[2]) < f_renamed && java.lang.Math.abs(this.O_renamed[1]) < f_renamed;
    }

    private boolean d_renamed() {
        return 1.5707963267948966d - ((double) java.lang.Math.abs(this.O_renamed[0])) < 1.0d && java.lang.Math.abs(this.O_renamed[1]) < 1.0f;
    }

    private boolean e_renamed() {
        return 1.5707963267948966d - ((double) java.lang.Math.abs(this.O_renamed[1])) < 1.0d && java.lang.Math.abs(this.O_renamed[0]) < 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(long r10) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.p_renamed.a_renamed(long):void");
    }

    private boolean f_renamed() {
        return 0.0f > this.O_renamed[0];
    }

    private boolean g_renamed() {
        return 0.0f < this.O_renamed[1];
    }

    private void a_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar) {
        if (aVar.a_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("GradienterAssistView", "checkAndAddAttitude, empty attitude is_renamed dismissed.");
            return;
        }
        if (1 < this.R_renamed.size()) {
            this.R_renamed.removeLast();
        }
        while (!this.R_renamed.isEmpty() && this.R_renamed.peekLast().f7120a != aVar.f7120a) {
            this.R_renamed.removeLast();
        }
        if (!this.C_renamed.a_renamed()) {
            if (!b_renamed(this.C_renamed, this.E_renamed) || this.e_renamed) {
                if (c_renamed(this.C_renamed, this.E_renamed)) {
                    android.animation.ValueAnimator valueAnimator = this.F_renamed;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    this.R_renamed.add(this.E_renamed.c_renamed());
                    a_renamed(true);
                    return;
                }
                android.animation.ValueAnimator valueAnimator2 = this.F_renamed;
                if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && !this.R_renamed.isEmpty()) {
                    this.R_renamed.removeFirst();
                }
                this.R_renamed.add(this.E_renamed.c_renamed());
                j_renamed();
                return;
            }
            this.R_renamed.add(this.E_renamed.c_renamed());
            h_renamed();
            j_renamed();
            return;
        }
        this.C_renamed.j_renamed(this.E_renamed);
        this.D_renamed.j_renamed(this.E_renamed);
        a_renamed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h_renamed() {
        if (this.I_renamed == null) {
            this.I_renamed = android.animation.ValueAnimator.ofFloat(255.0f, 0.0f);
            this.I_renamed.setDuration(250L);
            this.I_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
            this.I_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p_renamed.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.p_renamed.this.i_renamed();
                }
            });
            this.I_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p_renamed$kyMNmhchBKZ-NtoV1RyG-_XlIiM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.d_renamed(valueAnimator);
                }
            });
        }
        if (this.J_renamed == null) {
            this.J_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 255.0f);
            this.J_renamed.setDuration(250L);
            this.J_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
            this.J_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p_renamed$abpvEjp3V7jRpu-XuvjMwNhB2_k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.c_renamed(valueAnimator);
                }
            });
        }
        if (this.L_renamed == null) {
            this.L_renamed = new android.animation.AnimatorSet();
            this.L_renamed.play(this.J_renamed).after(this.I_renamed);
            this.L_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.preview.p_renamed.this.d_renamed) {
                        com.oplus.camera.ui.preview.p_renamed.this.h_renamed();
                    }
                }
            });
        }
        if (!this.L_renamed.isRunning()) {
            com.oplus.camera.ui.preview.p_renamed.a_renamed first = this.R_renamed.isEmpty() ? null : this.R_renamed.getFirst();
            if (first == null || java.lang.Float.compare(this.D_renamed.g_renamed, first.g_renamed) == 0) {
                return;
            }
            this.L_renamed.start();
            this.d_renamed = false;
            return;
        }
        this.d_renamed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.animation.ValueAnimator valueAnimator) {
        this.o_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.animation.ValueAnimator valueAnimator) {
        this.o_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i_renamed() {
        this.D_renamed.a_renamed(this.R_renamed.peekFirst(), this.E_renamed, this.C_renamed);
    }

    private void a_renamed(boolean z_renamed) {
        if (this.G_renamed == null) {
            this.G_renamed = android.animation.ValueAnimator.ofInt(255, 0);
            this.G_renamed.setDuration(250L);
            this.G_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
            this.G_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.p_renamed.this.C_renamed.j_renamed(com.oplus.camera.ui.preview.p_renamed.this.E_renamed);
                    com.oplus.camera.ui.preview.p_renamed.this.D_renamed.j_renamed(com.oplus.camera.ui.preview.p_renamed.this.E_renamed);
                }
            });
            this.G_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p_renamed$huPWvN5IGm0aedMQXvphT9Z-2ZM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.b_renamed(valueAnimator);
                }
            });
        }
        if (this.H_renamed == null) {
            this.H_renamed = android.animation.ValueAnimator.ofInt(0, 255);
            this.H_renamed.setDuration(250L);
            this.H_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
            this.H_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p_renamed.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.p_renamed.this.i_renamed();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.p_renamed.this.j_renamed();
                }
            });
            this.H_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$p_renamed$L53pcdHO_AJ5Es-r3YCe22h7wl4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.a_renamed(valueAnimator);
                }
            });
        }
        if (this.K_renamed == null) {
            this.K_renamed = new android.animation.AnimatorSet();
            this.K_renamed.play(this.H_renamed).after(this.G_renamed);
        }
        if (z_renamed) {
            if (this.K_renamed.isRunning()) {
                return;
            }
            this.K_renamed.start();
        } else {
            if (this.H_renamed.isRunning()) {
                return;
            }
            this.H_renamed.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        this.h_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.h_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    private boolean a_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar2) {
        return aVar.f7120a != aVar2.f7120a;
    }

    private boolean b_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar2) {
        return (aVar.f7120a == 3 && aVar2.f7120a == 2) || (aVar.f7120a == 2 && aVar2.f7120a == 3);
    }

    private boolean c_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar2) {
        return a_renamed(aVar, aVar2) && !b_renamed(aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() {
        android.animation.AnimatorSet animatorSet = this.K_renamed;
        if (animatorSet == null || !animatorSet.isRunning()) {
            android.animation.ValueAnimator valueAnimator = this.H_renamed;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                android.animation.ValueAnimator valueAnimator2 = this.F_renamed;
                if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && this.R_renamed.size() > 0) {
                    k_renamed();
                }
            }
        }
    }

    private void k_renamed() {
        if (this.F_renamed == null) {
            this.F_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 100.0f);
            this.F_renamed.setDuration(60L);
            this.F_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
            this.F_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.p_renamed.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.preview.p_renamed.a_renamed aVar = (com.oplus.camera.ui.preview.p_renamed.a_renamed) com.oplus.camera.ui.preview.p_renamed.this.R_renamed.peekFirst();
                    if (aVar == null) {
                        com.oplus.camera.e_renamed.e_renamed("GradienterAssistView", "startTransitionAnimation, attitude list is_renamed empty.");
                        return;
                    }
                    com.oplus.camera.ui.preview.p_renamed.this.D_renamed.a_renamed(com.oplus.camera.ui.preview.p_renamed.this.C_renamed, aVar, fFloatValue / 100.0f, com.oplus.camera.ui.preview.p_renamed.this.p_renamed);
                    if (java.lang.Float.compare(fFloatValue, 100.0f) == 0) {
                        com.oplus.camera.ui.preview.p_renamed.this.C_renamed.j_renamed(aVar);
                        com.oplus.camera.ui.preview.p_renamed.this.R_renamed.removeFirst();
                    }
                    if (com.oplus.camera.ui.preview.p_renamed.this.f7110c && aVar.e_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.preview.p_renamed.this.invalidate();
                }
            });
            this.F_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.p_renamed.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    com.oplus.camera.ui.preview.p_renamed.this.j_renamed();
                }
            });
        }
        if (this.F_renamed.isRunning() || this.R_renamed.size() <= 0) {
            return;
        }
        this.F_renamed.start();
    }

    public p_renamed(android.content.Context context) {
        super(context);
        this.f7108a = false;
        this.f7109b = false;
        this.f7110c = false;
        this.d_renamed = false;
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 255.0f;
        this.p_renamed = 0.0f;
        this.q_renamed = 0L;
        this.r_renamed = 0L;
        this.s_renamed = new android.graphics.Rect();
        this.t_renamed = new android.graphics.Rect();
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = new android.graphics.Point(0, 0);
        this.B_renamed = null;
        this.C_renamed = new com.oplus.camera.ui.preview.p_renamed.a_renamed();
        this.D_renamed = new com.oplus.camera.ui.preview.p_renamed.a_renamed();
        this.E_renamed = new com.oplus.camera.ui.preview.p_renamed.a_renamed();
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = new float[3];
        this.N_renamed = new float[4];
        this.O_renamed = new float[4];
        this.P_renamed = new int[3];
        this.Q_renamed = new int[1];
        this.R_renamed = new java.util.LinkedList<>();
        this.S_renamed = null;
        this.T_renamed = new android.hardware.SensorEventCallback() { // from class: com.oplus.camera.ui.preview.p_renamed.1
            @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
            public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
                if (9 == sensorEvent.sensor.getType()) {
                    com.oplus.camera.ui.preview.p_renamed.this.M_renamed = (float[]) sensorEvent.values.clone();
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.oplusos.gradientereffects.GradienterNative.processGravity(com.oplus.camera.ui.preview.p_renamed.this.M_renamed[0], com.oplus.camera.ui.preview.p_renamed.this.M_renamed[1], com.oplus.camera.ui.preview.p_renamed.this.M_renamed[2], com.oplus.camera.ui.preview.p_renamed.this.O_renamed, com.oplus.camera.ui.preview.p_renamed.this.P_renamed, com.oplus.camera.ui.preview.p_renamed.this.Q_renamed);
                com.oplus.camera.ui.preview.p_renamed pVar = com.oplus.camera.ui.preview.p_renamed.this;
                if (pVar.a_renamed(pVar.N_renamed) || 0.05f <= java.lang.Math.abs(com.oplus.camera.ui.preview.p_renamed.this.O_renamed[0] - com.oplus.camera.ui.preview.p_renamed.this.N_renamed[0]) || 0.05f <= java.lang.Math.abs(com.oplus.camera.ui.preview.p_renamed.this.O_renamed[1] - com.oplus.camera.ui.preview.p_renamed.this.N_renamed[1])) {
                    com.oplus.camera.ui.preview.p_renamed.this.i_renamed = 0;
                } else {
                    com.oplus.camera.ui.preview.p_renamed.f_renamed(com.oplus.camera.ui.preview.p_renamed.this);
                }
                com.oplus.camera.ui.preview.p_renamed pVar2 = com.oplus.camera.ui.preview.p_renamed.this;
                pVar2.N_renamed = (float[]) pVar2.O_renamed.clone();
                if (10 <= com.oplus.camera.ui.preview.p_renamed.this.i_renamed) {
                    return;
                }
                com.oplus.camera.ui.preview.p_renamed.this.a_renamed(jCurrentTimeMillis);
                super.onSensorChanged(sensorEvent);
            }
        };
        a_renamed(context);
    }

    public void setOnAdjustedListener(com.oplus.camera.ui.preview.p_renamed.b_renamed bVar) {
        this.S_renamed = bVar;
    }

    private void a_renamed(android.content.Context context) {
        this.B_renamed = new android.graphics.Paint();
        this.B_renamed.setAlpha(0);
        this.B_renamed.setAntiAlias(true);
        this.B_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.g_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gradienter_cross_max_offset);
        this.p_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gradienter_adjusted_threshold_in_distance);
        this.j_renamed = com.oplus.camera.util.Util.A_renamed(context);
        this.k_renamed = context.getColor(com.oplus.camera.R_renamed.color.gradienter_adjusting_color);
        this.m_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_base_line_length);
        this.l_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_base_line_width);
        this.A_renamed.set(0, getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gradienter_vertical_offset));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        if ((i3 == 0 || i4 == 0) && i_renamed > 0 && i2 > 0 && this.t_renamed.left < 0 && isShown()) {
            com.oplus.camera.e_renamed.b_renamed("GradienterAssistView", "onSizeChanged, need invalidate, mBaseLineRect: " + this.t_renamed);
            a_renamed(java.lang.System.currentTimeMillis());
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.f7108a) {
            if (255 > this.h_renamed) {
                com.oplus.camera.e_renamed.b_renamed("GradienterAssistView", "onDraw, alpha: " + this.h_renamed + ", Gradienter type: " + this.D_renamed.f7120a);
            }
            this.B_renamed.setAlpha(this.h_renamed);
            if (this.f_renamed) {
                canvas.translate(this.A_renamed.x_renamed, this.A_renamed.y_renamed);
            }
            if (5 == this.D_renamed.f7120a) {
                if (this.D_renamed.e_renamed) {
                    l_renamed();
                    canvas.drawBitmap(this.z_renamed, c_renamed(0.0f), d_renamed(0.0f), this.B_renamed);
                } else {
                    this.f7110c = false;
                    this.B_renamed.setAlpha((int) (this.h_renamed * 0.3f));
                    canvas.drawBitmap(this.y_renamed, c_renamed(0.0f), d_renamed(0.0f), this.B_renamed);
                    this.B_renamed.setAlpha(this.h_renamed);
                    canvas.drawBitmap(this.y_renamed, c_renamed(this.D_renamed.f7121b), d_renamed(this.D_renamed.f7122c), this.B_renamed);
                }
            } else if (3 == this.D_renamed.f7120a || 2 == this.D_renamed.f7120a) {
                boolean z_renamed = java.lang.Float.compare(this.D_renamed.g_renamed, 0.0f) != 0;
                if (this.e_renamed) {
                    canvas.rotate(90.0f, getCenterX(), getCenterY());
                } else if (z_renamed) {
                    canvas.rotate(this.D_renamed.g_renamed, getCenterX(), getCenterY());
                }
                this.B_renamed.setColor(this.k_renamed);
                this.B_renamed.setAlpha((int) (this.h_renamed * 0.55f * (this.o_renamed / 255.0f)));
                a_renamed(canvas, this.t_renamed, this.B_renamed);
                if (this.e_renamed) {
                    canvas.rotate(-90.0f, getCenterX(), getCenterY());
                } else if (z_renamed) {
                    canvas.rotate(-this.D_renamed.g_renamed, getCenterX(), getCenterY());
                }
                if (3 == this.D_renamed.f7120a) {
                    canvas.rotate(90.0f, getCenterX(), getCenterY());
                }
                this.B_renamed.setAlpha(this.h_renamed);
                if ((!this.e_renamed || 3 == this.D_renamed.f7120a) && this.D_renamed.e_renamed) {
                    l_renamed();
                    a_renamed(canvas, this.s_renamed, 0.0f, this.x_renamed);
                } else {
                    this.f7110c = false;
                    a_renamed(canvas, this.s_renamed, this.D_renamed.f_renamed, this.w_renamed);
                }
                if (3 == this.D_renamed.f7120a) {
                    canvas.rotate(-90.0f, getCenterX(), getCenterY());
                }
            }
            if (this.f_renamed) {
                canvas.translate(-this.A_renamed.x_renamed, -this.A_renamed.y_renamed);
            }
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Rect rect, android.graphics.Paint paint) {
        canvas.save();
        canvas.drawRect(rect, paint);
        canvas.rotate(180.0f, getCenterX(), getCenterY());
        canvas.drawRect(rect, paint);
        canvas.restore();
    }

    private void a_renamed(android.graphics.Canvas canvas, android.graphics.Rect rect, float f_renamed, android.graphics.Bitmap bitmap) {
        canvas.rotate(f_renamed, getCenterX(), getCenterY());
        canvas.drawBitmap(bitmap, rect.left, rect.top, this.B_renamed);
        canvas.rotate(-f_renamed, getCenterX(), getCenterY());
    }

    private int getCenterX() {
        return (int) (getWidth() / 2.0f);
    }

    private int getCenterY() {
        return (int) (getHeight() / 2.0f);
    }

    private void l_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.ui.preview.p_renamed.b_renamed bVar = this.S_renamed;
        if (bVar != null && 1000 < jCurrentTimeMillis - this.r_renamed) {
            this.r_renamed = jCurrentTimeMillis;
            bVar.a_renamed();
        }
        this.f7110c = true;
    }

    private int c_renamed(float f_renamed) {
        return (int) (((int) (getCenterX() - (this.v_renamed.getIntrinsicWidth() / 2.0f))) + f_renamed);
    }

    private int d_renamed(float f_renamed) {
        return (int) (((int) (getCenterY() - (this.v_renamed.getIntrinsicHeight() / 2.0f))) - f_renamed);
    }

    private void getLevelLineRectF() {
        this.s_renamed.set(getCenterX() - ((int) (this.u_renamed.getIntrinsicWidth() / 2.0f)), getCenterY() - ((int) (this.u_renamed.getIntrinsicHeight() / 2.0f)), getCenterX() + ((int) (this.u_renamed.getIntrinsicWidth() / 2.0f)), getCenterY() + ((int) (this.u_renamed.getIntrinsicHeight() / 2.0f)));
    }

    private void getBaseLineRectF() {
        this.t_renamed.set((getCenterX() - ((int) (this.u_renamed.getIntrinsicWidth() / 2.0f))) - this.m_renamed, getCenterY() - ((int) (this.l_renamed / 2.0f)), getCenterX() - ((int) (this.u_renamed.getIntrinsicWidth() / 2.0f)), getCenterY() + ((int) (this.l_renamed / 2.0f)));
    }

    private int b_renamed(float f_renamed, float f2) {
        if (f2 < f_renamed) {
            f_renamed = f2;
        }
        return (int) ((f_renamed / f2) * this.g_renamed);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("GradienterAssistView", "startDrawGradienter.");
        if (this.f7108a) {
            return;
        }
        this.f7108a = true;
        setVisibility(0);
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.p_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.b_renamed("GradienterAssistView", "startDrawGradienter, run register gravitySensor");
                android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) com.oplus.camera.ui.preview.p_renamed.this.getContext().getSystemService("sensor");
                if (sensorManager != null) {
                    sensorManager.registerListener(com.oplus.camera.ui.preview.p_renamed.this.T_renamed, sensorManager.getDefaultSensor(9), 1);
                    com.oplus.camera.ui.preview.p_renamed.this.f7109b = true;
                    com.oplus.camera.ui.preview.p_renamed.this.h_renamed = 0;
                }
            }
        });
        this.j_renamed = com.oplus.camera.util.Util.A_renamed(getContext());
        if (this.u_renamed == null) {
            this.u_renamed = getResources().getDrawable(com.oplus.camera.R_renamed.drawable.ic_level_horizontal_line, null);
        }
        if (this.w_renamed == null) {
            this.u_renamed.setTint(this.k_renamed);
            this.w_renamed = com.oplus.camera.util.Util.a_renamed(this.u_renamed);
        }
        if (this.x_renamed == null) {
            this.u_renamed.setTint(this.j_renamed);
            this.x_renamed = com.oplus.camera.util.Util.a_renamed(this.u_renamed);
        }
        if (this.v_renamed == null) {
            this.v_renamed = getResources().getDrawable(com.oplus.camera.R_renamed.drawable.ic_level_cross, null);
        }
        if (this.y_renamed == null) {
            this.v_renamed.setTint(this.k_renamed);
            this.y_renamed = com.oplus.camera.util.Util.a_renamed(this.v_renamed);
        }
        if (this.z_renamed == null) {
            this.v_renamed.setTint(this.j_renamed);
            this.z_renamed = com.oplus.camera.util.Util.a_renamed(this.v_renamed);
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("GradienterAssistView", "stopDrawGradienter.");
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.p_renamed.9
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("GradienterAssistView", "stopDrawGradienter, run mbSensorRegistered:" + com.oplus.camera.ui.preview.p_renamed.this.f7109b);
                if (com.oplus.camera.ui.preview.p_renamed.this.f7109b) {
                    android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) com.oplus.camera.ui.preview.p_renamed.this.getContext().getSystemService("sensor");
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(com.oplus.camera.ui.preview.p_renamed.this.T_renamed);
                    }
                    com.oplus.camera.ui.preview.p_renamed.this.f7109b = false;
                }
            }
        });
        invalidate();
        this.f7108a = false;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.C_renamed.b_renamed();
        this.E_renamed.b_renamed();
        setVisibility(4);
        java.util.LinkedList<com.oplus.camera.ui.preview.p_renamed.a_renamed> linkedList = this.R_renamed;
        if (linkedList != null && linkedList.size() > 0) {
            this.R_renamed.clear();
        }
        android.animation.ValueAnimator valueAnimator = this.F_renamed;
        if (valueAnimator != null) {
            a_renamed((android.animation.Animator) valueAnimator);
            this.F_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator2 = this.G_renamed;
        if (valueAnimator2 != null) {
            a_renamed((android.animation.Animator) valueAnimator2);
            this.G_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator3 = this.H_renamed;
        if (valueAnimator3 != null) {
            a_renamed((android.animation.Animator) valueAnimator3);
            this.H_renamed = null;
        }
        android.animation.AnimatorSet animatorSet = this.K_renamed;
        if (animatorSet != null) {
            a_renamed(animatorSet);
            this.K_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator4 = this.I_renamed;
        if (valueAnimator4 != null) {
            a_renamed((android.animation.Animator) valueAnimator4);
            this.I_renamed = null;
        }
        android.animation.ValueAnimator valueAnimator5 = this.J_renamed;
        if (valueAnimator5 != null) {
            a_renamed((android.animation.Animator) valueAnimator5);
            this.J_renamed = null;
        }
        android.animation.AnimatorSet animatorSet2 = this.L_renamed;
        if (animatorSet2 != null) {
            a_renamed(animatorSet2);
            this.L_renamed = null;
        }
        android.graphics.Bitmap bitmap = this.y_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.y_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.z_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.z_renamed = null;
        }
        android.graphics.Bitmap bitmap3 = this.w_renamed;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.w_renamed = null;
        }
        android.graphics.Bitmap bitmap4 = this.x_renamed;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.x_renamed = null;
        }
    }

    private void a_renamed(android.animation.Animator animator) {
        if (animator != null) {
            if (animator instanceof android.animation.ValueAnimator) {
                ((android.animation.ValueAnimator) animator).removeAllUpdateListeners();
            }
            animator.removeAllListeners();
            if (animator.isRunning() || animator.isStarted()) {
                animator.cancel();
            }
        }
    }

    public boolean c_renamed() {
        return 0 != this.q_renamed && 1000 <= java.lang.System.currentTimeMillis() - this.q_renamed;
    }

    public java.lang.String getOrientation() {
        return (3 == this.E_renamed.f7120a || 2 == this.E_renamed.f7120a) ? "vertical" : "horizontal";
    }

    /* compiled from: GradienterAssistView.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f7120a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f7121b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f7122c;
        private long d_renamed;
        private boolean e_renamed;
        private float f_renamed;
        private float g_renamed;

        private a_renamed() {
            this.f7120a = -1;
            this.f7121b = 0;
            this.f7122c = 0;
            this.d_renamed = 0L;
            this.e_renamed = false;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a_renamed() {
            return -1 == this.f7120a && this.f7121b == 0 && this.f7122c == 0 && java.lang.Float.compare(this.f_renamed, 0.0f) == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b_renamed() {
            this.f7120a = -1;
            this.f7121b = 0;
            this.f7122c = 0;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar) {
            this.f7120a = aVar.f7120a;
            this.f7121b = aVar.f7121b;
            this.f7122c = aVar.f7122c;
            this.f_renamed = aVar.f_renamed;
            this.e_renamed = aVar.e_renamed;
            this.d_renamed = aVar.d_renamed;
            this.g_renamed = aVar.g_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.oplus.camera.ui.preview.p_renamed.a_renamed c_renamed() {
            com.oplus.camera.ui.preview.p_renamed.a_renamed aVar = new com.oplus.camera.ui.preview.p_renamed.a_renamed();
            aVar.j_renamed(this);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar2, float f_renamed, float f2) {
            this.f7120a = aVar2.f7120a;
            this.d_renamed = aVar2.d_renamed;
            this.f7121b = (int) (aVar.f7121b + ((aVar2.f7121b - r0) * f_renamed));
            this.f7122c = (int) (aVar.f7122c + ((aVar2.f7122c - r0) * f_renamed));
            this.e_renamed = aVar2.e_renamed && f2 > ((float) java.lang.Math.abs(this.f7121b - aVar2.f7121b)) && f2 > ((float) java.lang.Math.abs(this.f7122c - aVar2.f7122c));
            int i_renamed = aVar2.f7120a;
            if (2 == i_renamed || 3 == i_renamed) {
                if (aVar2.f7120a != aVar.f7120a) {
                    float f3 = aVar.f_renamed;
                    float f4 = f3 > 0.0f ? f3 - 90.0f : f3 + 90.0f;
                    this.f_renamed = f4 + (f_renamed * (aVar2.f_renamed - f4));
                } else {
                    float f5 = aVar.f_renamed;
                    this.f_renamed = f5 + (f_renamed * com.oplus.camera.ui.preview.p_renamed.c_renamed(f5, aVar2.f_renamed));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(com.oplus.camera.ui.preview.p_renamed.a_renamed aVar, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar2, com.oplus.camera.ui.preview.p_renamed.a_renamed aVar3) {
            if (aVar == null) {
                aVar = aVar2;
            }
            if (aVar == null) {
                aVar = aVar3;
            }
            if (aVar != null) {
                this.g_renamed = aVar.g_renamed;
            }
        }

        public java.lang.String toString() {
            return "attitude={\"mCanvasRotateDegree\": " + this.g_renamed + ",\"mIndicatorLeftOffset\": " + this.f7121b + ",\"mIndicatorTopOffset\": " + this.f7122c + ",\"mRectRotateDegrees\": " + this.f_renamed + ",\"mTimeStamp\": " + this.d_renamed + ",\"mType\": " + this.f7120a + ",\"mbAdjusted\": " + this.e_renamed + "\"}";
        }
    }
}
