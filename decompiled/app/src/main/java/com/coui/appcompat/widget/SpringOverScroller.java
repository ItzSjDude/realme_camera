package com.coui.appcompat.widget;

/* compiled from: SpringOverScroller.java */
/* loaded from: classes.dex */
public class y_renamed extends android.widget.OverScroller implements com.coui.appcompat.widget.h_renamed {
    private static float e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.y_renamed.b_renamed f3129a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.y_renamed.b_renamed f3130b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f3131c;
    private int d_renamed;
    private android.content.Context f_renamed;
    private com.oplus.dynamicvsync.IOplusDynamicVsyncFeature g_renamed;

    @Override // com.coui.appcompat.widget.h_renamed
    public void setFinalX(int i_renamed) {
    }

    public void setFinalY(int i_renamed) {
    }

    public y_renamed(android.content.Context context, android.view.animation.Interpolator interpolator) {
        super(context, interpolator);
        this.d_renamed = 2;
        this.f3129a = new com.coui.appcompat.widget.y_renamed.b_renamed();
        this.f3130b = new com.coui.appcompat.widget.y_renamed.b_renamed();
        if (interpolator == null) {
            this.f3131c = new com.coui.appcompat.widget.y_renamed.a_renamed();
        } else {
            this.f3131c = interpolator;
        }
        e_renamed = 0.016f;
        this.f_renamed = context;
        i_renamed();
    }

    private void i_renamed() {
        try {
            this.g_renamed = (com.oplus.dynamicvsync.IOplusDynamicVsyncFeature) android.common.OplusFrameworkFactory.getInstance().getFeature(com.oplus.dynamicvsync.IOplusDynamicVsyncFeature.DEFAULT, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            android.util.Log.d_renamed("SpringOverScroller", th.toString());
        }
    }

    public y_renamed(android.content.Context context) {
        this(context, null);
    }

    public void a_renamed(float f_renamed) {
        e_renamed = java.lang.Math.round(10000.0f / f_renamed) / 10000.0f;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public void a_renamed(android.view.animation.Interpolator interpolator) {
        if (interpolator == null) {
            this.f3131c = new com.coui.appcompat.widget.y_renamed.a_renamed();
        } else {
            this.f3131c = interpolator;
        }
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public boolean computeScrollOffset() {
        if (a_renamed()) {
            return false;
        }
        int i_renamed = this.d_renamed;
        if (i_renamed != 0) {
            if (i_renamed == 1 && !this.f3129a.f_renamed() && !this.f3130b.f_renamed()) {
                abortAnimation();
            }
        } else {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.f3129a.p_renamed;
            int i2 = this.f3129a.n_renamed;
            if (jCurrentAnimationTimeMillis < i2) {
                float interpolation = this.f3131c.getInterpolation(jCurrentAnimationTimeMillis / i2);
                this.f3129a.a_renamed(interpolation);
                this.f3130b.a_renamed(interpolation);
            } else {
                this.f3129a.a_renamed(1.0f);
                this.f3130b.a_renamed(1.0f);
                abortAnimation();
            }
        }
        return true;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public final boolean a_renamed() {
        return this.f3129a.e_renamed() && this.f3130b.e_renamed() && this.d_renamed != 0;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public final int b_renamed() {
        return (int) java.lang.Math.round(this.f3129a.a_renamed());
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public final int c_renamed() {
        return (int) java.lang.Math.round(this.f3130b.a_renamed());
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public final int d_renamed() {
        return (int) this.f3129a.c_renamed();
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public final int e_renamed() {
        return (int) this.f3130b.c_renamed();
    }

    @Override // android.widget.OverScroller
    public void fling(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i2 <= i8 && i2 >= i7) {
            fling(i_renamed, i2, i3, i4, i5, i6, i7, i8);
            return;
        }
        springBack(i_renamed, i2, i5, i6, i7, i8);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void fling(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a_renamed(i_renamed, i2, i3, i4);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        j_renamed();
        this.d_renamed = 1;
        this.f3129a.a_renamed(i_renamed, i3);
        this.f3130b.a_renamed(i2, i4);
    }

    @Override // android.widget.OverScroller
    public boolean springBack(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        j_renamed();
        boolean zA = this.f3129a.a_renamed(i_renamed, i3, i4);
        boolean zA2 = this.f3130b.a_renamed(i2, i5, i6);
        if (zA || zA2) {
            this.d_renamed = 1;
        }
        return zA || zA2;
    }

    private void j_renamed() {
        try {
            if (this.g_renamed != null) {
                this.g_renamed.flingEvent(this.f_renamed.getPackageName(), 5000);
            }
        } catch (java.lang.Exception e2) {
            android.util.Log.e_renamed("SpringOverScroller", e2.getMessage(), e2);
        }
    }

    @Override // android.widget.OverScroller
    public void startScroll(int i_renamed, int i2, int i3, int i4) {
        startScroll(i_renamed, i2, i3, i4, 250);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void startScroll(int i_renamed, int i2, int i3, int i4, int i5) {
        this.d_renamed = 0;
        this.f3129a.b_renamed(i_renamed, i3, i5);
        this.f3130b.b_renamed(i2, i4, i5);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void abortAnimation() {
        this.d_renamed = 2;
        this.f3129a.d_renamed();
        this.f3130b.d_renamed();
    }

    public boolean isScrollingInDirection(float f_renamed, float f2) {
        return !isFinished() && java.lang.Math.signum(f_renamed) == java.lang.Math.signum((float) ((int) (this.f3129a.l_renamed - this.f3129a.k_renamed))) && java.lang.Math.signum(f2) == java.lang.Math.signum((float) ((int) (this.f3130b.l_renamed - this.f3130b.k_renamed)));
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void notifyVerticalEdgeReached(int i_renamed, int i2, int i3) {
        this.f3130b.c_renamed(i_renamed, i2, i3);
        springBack(0, i_renamed, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void notifyHorizontalEdgeReached(int i_renamed, int i2, int i3) {
        this.f3129a.c_renamed(i_renamed, i2, i3);
        springBack(i_renamed, 0, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        double dB_renamed = this.f3129a.b_renamed();
        double dB2 = this.f3130b.b_renamed();
        return (int) java.lang.Math.sqrt((dB_renamed * dB_renamed) + (dB2 * dB2));
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public float f_renamed() {
        return (float) this.f3129a.b_renamed();
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public float g_renamed() {
        return (float) this.f3130b.b_renamed();
    }

    public void b_renamed(float f_renamed) {
        this.f3129a.e_renamed.f3138b = f_renamed;
    }

    public void c_renamed(float f_renamed) {
        this.f3130b.e_renamed.f3138b = f_renamed;
    }

    public void d_renamed(float f_renamed) {
        this.f3129a.u_renamed = f_renamed;
        this.f3130b.u_renamed = f_renamed;
    }

    /* compiled from: SpringOverScroller.java */
    static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static float f3134a = 1.0f;

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3 f3135b;
        private double k_renamed;
        private double l_renamed;
        private int m_renamed;
        private int n_renamed;
        private int o_renamed;
        private long p_renamed;
        private boolean s_renamed;
        private boolean t_renamed;
        private long v_renamed;
        private long w_renamed;
        private com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed e_renamed = new com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed();
        private com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed f_renamed = new com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed();
        private com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed g_renamed = new com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed();
        private float h_renamed = 0.32f;
        private double i_renamed = 20.0d;
        private double j_renamed = 0.05d;
        private int q_renamed = 1;
        private boolean r_renamed = false;
        private float u_renamed = 0.83f;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3 f3136c = new com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3(this.h_renamed, 0.0d);
        private com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3 d_renamed = new com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3(12.1899995803833d, 16.0d);

        b_renamed() {
            a_renamed(this.f3136c);
        }

        void a_renamed(int i_renamed, int i2) {
            this.v_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.w_renamed = this.v_renamed;
            this.q_renamed = 1;
            f3134a = 1.0f;
            this.f3136c.a_renamed(this.h_renamed);
            this.f3136c.b_renamed(0.0d);
            a_renamed(this.f3136c);
            a_renamed(i_renamed, true);
            a_renamed(i2);
        }

        boolean a_renamed(int i_renamed, int i2, int i3) {
            a_renamed(i_renamed, false);
            if (i_renamed > i3 || i_renamed < i2) {
                if (i_renamed > i3) {
                    b_renamed(i3);
                } else if (i_renamed < i2) {
                    b_renamed(i2);
                }
                this.s_renamed = true;
                this.d_renamed.a_renamed(12.1899995803833d);
                this.d_renamed.b_renamed(this.u_renamed * 16.0f);
                a_renamed(this.d_renamed);
                return true;
            }
            a_renamed(new com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3(this.h_renamed, 0.0d));
            return false;
        }

        void b_renamed(int i_renamed, int i2, int i3) {
            this.m_renamed = i_renamed;
            this.o_renamed = i_renamed + i2;
            this.n_renamed = i3;
            this.p_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            a_renamed(this.f3136c);
        }

        void a_renamed(com.coui.appcompat.widget.y_renamed.b_renamed.SpringOverScroller_3 c0064b) {
            if (c0064b == null) {
                throw new java.lang.IllegalArgumentException("springConfig is_renamed required");
            }
            this.f3135b = c0064b;
        }

        void a_renamed(double d_renamed, boolean z_renamed) {
            this.k_renamed = d_renamed;
            if (!this.r_renamed) {
                this.f_renamed.f3137a = 0.0d;
                this.g_renamed.f3137a = 0.0d;
            }
            this.e_renamed.f3137a = d_renamed;
            if (z_renamed) {
                d_renamed();
            }
        }

        double a_renamed() {
            return this.e_renamed.f3137a;
        }

        double b_renamed() {
            return this.e_renamed.f3138b;
        }

        void a_renamed(double d_renamed) {
            if (d_renamed == this.e_renamed.f3138b) {
                return;
            }
            this.e_renamed.f3138b = d_renamed;
        }

        double c_renamed() {
            return this.l_renamed;
        }

        void b_renamed(double d_renamed) {
            if (this.l_renamed == d_renamed) {
                return;
            }
            this.k_renamed = a_renamed();
            this.l_renamed = d_renamed;
        }

        void d_renamed() {
            this.l_renamed = this.e_renamed.f3137a;
            this.g_renamed.f3137a = this.e_renamed.f3137a;
            this.e_renamed.f3138b = 0.0d;
            this.s_renamed = false;
        }

        boolean e_renamed() {
            return java.lang.Math.abs(this.e_renamed.f3138b) <= this.i_renamed && (a_renamed(this.e_renamed) <= this.j_renamed || this.f3135b.f3140b == 0.0d);
        }

        void a_renamed(float f_renamed) {
            com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar = this.e_renamed;
            int i_renamed = this.m_renamed;
            aVar.f3137a = i_renamed + java.lang.Math.round(f_renamed * (this.o_renamed - i_renamed));
        }

        void c_renamed(int i_renamed, int i2, int i3) {
            this.e_renamed.f3137a = i_renamed;
            com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar = this.f_renamed;
            aVar.f3137a = 0.0d;
            aVar.f3138b = 0.0d;
            com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar2 = this.g_renamed;
            aVar2.f3137a = 0.0d;
            aVar2.f3138b = 0.0d;
        }

        double a_renamed(com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar) {
            return java.lang.Math.abs(this.l_renamed - aVar.f3137a);
        }

        boolean f_renamed() {
            if (e_renamed()) {
                return false;
            }
            double d_renamed = this.e_renamed.f3137a;
            double d2 = this.e_renamed.f3138b;
            double d3 = this.g_renamed.f3137a;
            double d4 = this.g_renamed.f3138b;
            if (!this.s_renamed) {
                long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
                long j_renamed = jCurrentAnimationTimeMillis - this.v_renamed;
                if (this.q_renamed == 1) {
                    if (java.lang.Math.abs(this.e_renamed.f3138b) > 4000.0d && java.lang.Math.abs(this.e_renamed.f3138b) < 10000.0d) {
                        this.f3135b.f3139a = (java.lang.Math.abs(this.e_renamed.f3138b) / 10000.0d) + 2.6d;
                    } else if (java.lang.Math.abs(this.e_renamed.f3138b) <= 4000.0d) {
                        this.f3135b.f3139a = (java.lang.Math.abs(this.e_renamed.f3138b) / 10000.0d) + 4.5d;
                    }
                    this.w_renamed = jCurrentAnimationTimeMillis;
                }
                if (this.q_renamed > 1) {
                    if (j_renamed > 480) {
                        if (java.lang.Math.abs(this.e_renamed.f3138b) > 2000.0d) {
                            this.f3135b.f3139a += (jCurrentAnimationTimeMillis - this.w_renamed) * 0.00125d;
                        } else if (this.f3135b.f3139a > 2.0d) {
                            this.f3135b.f3139a -= (jCurrentAnimationTimeMillis - this.w_renamed) * 0.00125d;
                        }
                    }
                    this.w_renamed = jCurrentAnimationTimeMillis;
                }
            } else {
                double dA_renamed = a_renamed(this.e_renamed);
                if (!this.t_renamed && dA_renamed < 180.0d) {
                    this.f3135b.f3140b += 100.0d;
                    this.t_renamed = true;
                } else if (dA_renamed < 2.0d) {
                    this.e_renamed.f3137a = this.l_renamed;
                    this.t_renamed = false;
                    this.s_renamed = false;
                    return false;
                }
            }
            double d5 = (this.f3135b.f3140b * (this.l_renamed - d3)) - (this.f3135b.f3139a * this.f_renamed.f3138b);
            double d6 = ((com.coui.appcompat.widget.y_renamed.e_renamed * d5) / 2.0d) + d2;
            double d7 = (this.f3135b.f3140b * (this.l_renamed - (((com.coui.appcompat.widget.y_renamed.e_renamed * d2) / 2.0d) + d_renamed))) - (this.f3135b.f3139a * d6);
            double d8 = ((com.coui.appcompat.widget.y_renamed.e_renamed * d7) / 2.0d) + d2;
            double d9 = (this.f3135b.f3140b * (this.l_renamed - (((com.coui.appcompat.widget.y_renamed.e_renamed * d6) / 2.0d) + d_renamed))) - (this.f3135b.f3139a * d8);
            double d10 = (com.coui.appcompat.widget.y_renamed.e_renamed * d8) + d_renamed;
            double d11 = (com.coui.appcompat.widget.y_renamed.e_renamed * d9) + d2;
            double d12 = (((d6 + d8) * 2.0d) + d2 + d11) * 0.16699999570846558d;
            double d13 = d2 + ((d5 + ((d7 + d9) * 2.0d) + ((this.f3135b.f3140b * (this.l_renamed - d10)) - (this.f3135b.f3139a * d11))) * 0.16699999570846558d * com.coui.appcompat.widget.y_renamed.e_renamed);
            com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar = this.g_renamed;
            aVar.f3138b = d11;
            aVar.f3137a = d10;
            com.coui.appcompat.widget.y_renamed.b_renamed.a_renamed aVar2 = this.e_renamed;
            aVar2.f3138b = d13;
            aVar2.f3137a = d_renamed + (d12 * com.coui.appcompat.widget.y_renamed.e_renamed);
            this.q_renamed++;
            return true;
        }

        /* compiled from: SpringOverScroller.java */
        /* renamed from: com.coui.appcompat.widget.y_renamed$b_renamed$b_renamed, reason: collision with other inner class name */
        static class SpringOverScroller_3 {

            /* renamed from: a_renamed, reason: collision with root package name */
            double f3139a;

            /* renamed from: b_renamed, reason: collision with root package name */
            double f3140b;

            private float a_renamed(float f_renamed) {
                if (f_renamed == 0.0f) {
                    return 0.0f;
                }
                return 25.0f + ((f_renamed - 8.0f) * 3.0f);
            }

            private double b_renamed(float f_renamed) {
                if (f_renamed == 0.0f) {
                    return 0.0d;
                }
                return ((f_renamed - 30.0f) * 3.62f) + 194.0f;
            }

            SpringOverScroller_3(double d_renamed, double d2) {
                this.f3139a = a_renamed((float) d_renamed);
                this.f3140b = b_renamed((float) d2);
            }

            void a_renamed(double d_renamed) {
                this.f3139a = a_renamed((float) d_renamed);
            }

            void b_renamed(double d_renamed) {
                this.f3140b = b_renamed((float) d_renamed);
            }
        }

        /* compiled from: SpringOverScroller.java */
        static class a_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            double f3137a;

            /* renamed from: b_renamed, reason: collision with root package name */
            double f3138b;

            a_renamed() {
            }
        }
    }

    /* compiled from: SpringOverScroller.java */
    static class a_renamed implements android.view.animation.Interpolator {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final float f3132a = 1.0f / a_renamed(1.0f);

        /* renamed from: b_renamed, reason: collision with root package name */
        private static final float f3133b = 1.0f - (f3132a * a_renamed(1.0f));

        a_renamed() {
        }

        private static float a_renamed(float f_renamed) {
            float f2 = f_renamed * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) java.lang.Math.exp(-f2)));
            }
            return ((1.0f - ((float) java.lang.Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f_renamed) {
            float fA_renamed = f3132a * a_renamed(f_renamed);
            return fA_renamed > 0.0f ? fA_renamed + f3133b : fA_renamed;
        }
    }
}
