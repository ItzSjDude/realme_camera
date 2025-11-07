package com.coui.appcompat.widget;

/* compiled from: COUILocateOverScroller.java */
/* loaded from: classes.dex */
public class j_renamed extends android.widget.OverScroller implements com.coui.appcompat.widget.h_renamed {
    private static final android.view.animation.Interpolator d_renamed = new android.view.animation.Interpolator() { // from class: com.coui.appcompat.widget.j_renamed.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f_renamed) {
            float f2 = f_renamed - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.j_renamed.a_renamed f2960a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.j_renamed.a_renamed f2961b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f2962c;
    private int e_renamed;

    public j_renamed(android.content.Context context) {
        this(context, null);
    }

    public j_renamed(android.content.Context context, android.view.animation.Interpolator interpolator) {
        super(context, interpolator);
        this.f2960a = new com.coui.appcompat.widget.j_renamed.a_renamed(context);
        this.f2961b = new com.coui.appcompat.widget.j_renamed.a_renamed(context);
        if (interpolator == null) {
            this.f2962c = d_renamed;
        } else {
            this.f2962c = interpolator;
        }
    }

    public void a_renamed(float f_renamed) {
        this.f2960a.a_renamed(f_renamed);
        this.f2961b.a_renamed(f_renamed);
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public void a_renamed(android.view.animation.Interpolator interpolator) {
        if (interpolator == null) {
            this.f2962c = d_renamed;
        } else {
            this.f2962c = interpolator;
        }
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public boolean computeScrollOffset() {
        if (a_renamed()) {
            return false;
        }
        int i_renamed = this.e_renamed;
        if (i_renamed == 0) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.f2960a.g_renamed;
            int i2 = this.f2960a.h_renamed;
            if (jCurrentAnimationTimeMillis < i2) {
                float interpolation = this.f2962c.getInterpolation(jCurrentAnimationTimeMillis / i2);
                this.f2960a.b_renamed(interpolation);
                this.f2961b.b_renamed(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i_renamed == 1) {
            if (!this.f2960a.k_renamed && !this.f2960a.c_renamed() && !this.f2960a.b_renamed()) {
                this.f2960a.a_renamed();
            }
            if (!this.f2961b.k_renamed && !this.f2961b.c_renamed() && !this.f2961b.b_renamed()) {
                this.f2961b.a_renamed();
            }
        }
        return true;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public boolean a_renamed() {
        return this.f2960a.k_renamed && this.f2961b.k_renamed;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public int b_renamed() {
        return this.f2960a.f2964b;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public int c_renamed() {
        return this.f2961b.f2964b;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public int d_renamed() {
        return this.f2960a.f2965c;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public int e_renamed() {
        return this.f2961b.f2965c;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public void setFinalX(int i_renamed) {
        if (i_renamed == -1) {
            return;
        }
        this.f2960a.a_renamed(i_renamed);
    }

    public void setFinalY(int i_renamed) {
        if (i_renamed == -1) {
            return;
        }
        this.f2961b.a_renamed(i_renamed);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void fling(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i_renamed, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    @Override // android.widget.OverScroller
    public void fling(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (i2 <= i8 && i2 >= i7) {
            a_renamed(i_renamed, i2, i3, i4);
            return;
        }
        springBack(i_renamed, i2, i5, i6, i7, i8);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        this.e_renamed = 1;
        this.f2960a.a_renamed(i_renamed, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        this.f2961b.a_renamed(i2, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    @Override // android.widget.OverScroller
    public boolean springBack(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        boolean zB = this.f2960a.b_renamed(i_renamed, i3, i4);
        boolean zB2 = this.f2961b.b_renamed(i2, i5, i6);
        if (zB || zB2) {
            this.e_renamed = 1;
        }
        return zB || zB2;
    }

    @Override // android.widget.OverScroller
    public void startScroll(int i_renamed, int i2, int i3, int i4) {
        startScroll(i_renamed, i2, i3, i4, 250);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void startScroll(int i_renamed, int i2, int i3, int i4, int i5) {
        this.e_renamed = 0;
        this.f2960a.a_renamed(i_renamed, i3, i5);
        this.f2961b.a_renamed(i2, i4, i5);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void abortAnimation() {
        this.f2960a.a_renamed();
        this.f2961b.a_renamed();
    }

    public boolean isScrollingInDirection(float f_renamed, float f2) {
        return !isFinished() && java.lang.Math.signum(f_renamed) == java.lang.Math.signum((float) (this.f2960a.f2965c - this.f2960a.f2963a)) && java.lang.Math.signum(f2) == java.lang.Math.signum((float) (this.f2961b.f2965c - this.f2961b.f2963a));
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void notifyVerticalEdgeReached(int i_renamed, int i2, int i3) {
        this.f2961b.c_renamed(i_renamed, i2, i3);
        springBack(0, i_renamed, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.widget.h_renamed
    public void notifyHorizontalEdgeReached(int i_renamed, int i2, int i3) {
        this.f2960a.c_renamed(i_renamed, i2, i3);
        springBack(i_renamed, 0, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        return (float) java.lang.Math.hypot(this.f2960a.e_renamed, this.f2961b.e_renamed);
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public float f_renamed() {
        return this.f2960a.e_renamed;
    }

    @Override // com.coui.appcompat.widget.h_renamed
    public float g_renamed() {
        return this.f2961b.e_renamed;
    }

    /* compiled from: COUILocateOverScroller.java */
    private static class a_renamed {
        private static float p_renamed = (float) (java.lang.Math.log(0.78d) / java.lang.Math.log(0.9d));
        private static final float[] q_renamed = new float[101];
        private static final float[] r_renamed = new float[101];

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f2963a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f2964b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f2965c;
        private int d_renamed;
        private float e_renamed;
        private float f_renamed;
        private long g_renamed;
        private int h_renamed;
        private int i_renamed;
        private int j_renamed;
        private int l_renamed;
        private float o_renamed;
        private float m_renamed = android.view.ViewConfiguration.getScrollFriction() * 2.5f;
        private int n_renamed = 0;
        private boolean k_renamed = true;

        private static float b_renamed(int i_renamed) {
            return i_renamed > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float f_renamed;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i_renamed = 0; i_renamed < 100; i_renamed++) {
                float f13 = i_renamed / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    f_renamed = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                    if (java.lang.Math.abs(f15 - f13) < 1.0E-5d) {
                        break;
                    } else if (f15 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                q_renamed[i_renamed] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f16 = 1.0f;
                while (true) {
                    f7 = ((f16 - f12) / f_renamed) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f17 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (java.lang.Math.abs(f17 - f13) < 1.0E-5d) {
                        break;
                    }
                    if (f17 > f13) {
                        f16 = f7;
                    } else {
                        f12 = f7;
                    }
                    f_renamed = 2.0f;
                    f3 = 3.0f;
                }
                r_renamed[i_renamed] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            }
            float[] fArr = q_renamed;
            r_renamed[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void a_renamed(float f_renamed) {
            this.m_renamed = f_renamed;
        }

        a_renamed(android.content.Context context) {
            this.o_renamed = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void b_renamed(float f_renamed) {
            this.f2964b = this.f2963a + java.lang.Math.round(f_renamed * (this.f2965c - r0));
        }

        private void d_renamed(int i_renamed, int i2, int i3) {
            float fAbs = java.lang.Math.abs((i3 - i_renamed) / (i2 - i_renamed));
            int i4 = (int) (fAbs * 100.0f);
            if (i4 < 100) {
                float f_renamed = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = r_renamed;
                float f2 = fArr[i4];
                this.h_renamed = (int) (this.h_renamed * (f2 + (((fAbs - f_renamed) / ((i5 / 100.0f) - f_renamed)) * (fArr[i5] - f2))));
            }
        }

        void a_renamed(int i_renamed, int i2, int i3) {
            this.k_renamed = false;
            this.f2963a = i_renamed;
            this.f2964b = i_renamed;
            this.f2965c = i_renamed + i2;
            this.g_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.h_renamed = i3;
            this.f_renamed = 0.0f;
            this.d_renamed = 0;
        }

        void a_renamed() {
            this.f2964b = this.f2965c;
            this.k_renamed = true;
        }

        void a_renamed(int i_renamed) {
            this.f2965c = i_renamed;
            this.j_renamed = this.f2965c - this.f2963a;
            this.k_renamed = false;
        }

        boolean b_renamed(int i_renamed, int i2, int i3) {
            this.k_renamed = true;
            this.f2965c = i_renamed;
            this.f2963a = i_renamed;
            this.f2964b = i_renamed;
            this.d_renamed = 0;
            this.g_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.h_renamed = 0;
            if (i_renamed < i2) {
                e_renamed(i_renamed, i2, 0);
            } else if (i_renamed > i3) {
                e_renamed(i_renamed, i3, 0);
            }
            return !this.k_renamed;
        }

        private void e_renamed(int i_renamed, int i2, int i3) {
            this.k_renamed = false;
            this.n_renamed = 1;
            this.f2963a = i_renamed;
            this.f2964b = i_renamed;
            this.f2965c = i2;
            int i4 = i_renamed - i2;
            this.f_renamed = b_renamed(i4);
            this.d_renamed = -i4;
            this.l_renamed = java.lang.Math.abs(i4);
            this.h_renamed = (int) (java.lang.Math.sqrt((i4 * (-2.0d)) / this.f_renamed) * 1000.0d);
        }

        void a_renamed(int i_renamed, int i2, int i3, int i4, int i5) {
            this.l_renamed = i5;
            this.k_renamed = false;
            this.d_renamed = i2;
            this.e_renamed = i2;
            this.i_renamed = 0;
            this.h_renamed = 0;
            this.g_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.f2963a = i_renamed;
            this.f2964b = i_renamed;
            if (i_renamed > i4 || i_renamed < i3) {
                a_renamed(i_renamed, i3, i4, i2);
                return;
            }
            this.n_renamed = 0;
            double d_renamed = 0.0d;
            if (i2 != 0) {
                int iE = e_renamed(i2);
                this.i_renamed = iE;
                this.h_renamed = iE;
                d_renamed = d_renamed(i2);
            }
            this.j_renamed = (int) (d_renamed * java.lang.Math.signum(r0));
            this.f2965c = i_renamed + this.j_renamed;
            int i6 = this.f2965c;
            if (i6 < i3) {
                d_renamed(this.f2963a, i6, i3);
                this.f2965c = i3;
            }
            int i7 = this.f2965c;
            if (i7 > i4) {
                d_renamed(this.f2963a, i7, i4);
                this.f2965c = i4;
            }
        }

        private double c_renamed(int i_renamed) {
            return java.lang.Math.log((java.lang.Math.abs(i_renamed) * 0.35f) / (this.m_renamed * this.o_renamed));
        }

        private double d_renamed(int i_renamed) {
            double dC_renamed = c_renamed(i_renamed);
            float f_renamed = p_renamed;
            return this.m_renamed * this.o_renamed * java.lang.Math.exp((f_renamed / (f_renamed - 1.0d)) * dC_renamed);
        }

        private int e_renamed(int i_renamed) {
            return (int) (java.lang.Math.exp(c_renamed(i_renamed) / (p_renamed - 1.0d)) * 1000.0d);
        }

        private void f_renamed(int i_renamed, int i2, int i3) {
            float f_renamed = (-i3) / this.f_renamed;
            float f2 = i3;
            float fSqrt = (float) java.lang.Math.sqrt((((((f2 * f2) / 2.0f) / java.lang.Math.abs(r1)) + java.lang.Math.abs(i2 - i_renamed)) * 2.0d) / java.lang.Math.abs(this.f_renamed));
            this.g_renamed -= (int) ((fSqrt - f_renamed) * 1000.0f);
            this.f2963a = i2;
            this.f2964b = i2;
            this.d_renamed = (int) ((-this.f_renamed) * fSqrt);
        }

        private void g_renamed(int i_renamed, int i2, int i3) {
            this.f_renamed = b_renamed(i3 == 0 ? i_renamed - i2 : i3);
            f_renamed(i_renamed, i2, i3);
            d_renamed();
        }

        private void a_renamed(int i_renamed, int i2, int i3, int i4) {
            if (i_renamed > i2 && i_renamed < i3) {
                android.util.Log.e_renamed("COUILocateOverScroller", "startAfterEdge called from a_renamed valid position");
                this.k_renamed = true;
                return;
            }
            boolean z_renamed = i_renamed > i3;
            int i5 = z_renamed ? i3 : i2;
            if ((i_renamed - i5) * i4 >= 0) {
                g_renamed(i_renamed, i5, i4);
            } else if (d_renamed(i4) > java.lang.Math.abs(r4)) {
                a_renamed(i_renamed, i4, z_renamed ? i2 : i_renamed, z_renamed ? i_renamed : i3, this.l_renamed);
            } else {
                e_renamed(i_renamed, i5, i4);
            }
        }

        void c_renamed(int i_renamed, int i2, int i3) {
            if (this.n_renamed == 0) {
                this.l_renamed = i3;
                this.g_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
                a_renamed(i_renamed, i2, i2, (int) this.e_renamed);
            }
        }

        private void d_renamed() {
            int i_renamed = this.d_renamed;
            float f_renamed = i_renamed * i_renamed;
            float fAbs = f_renamed / (java.lang.Math.abs(this.f_renamed) * 2.0f);
            float fSignum = java.lang.Math.signum(this.d_renamed);
            int i2 = this.l_renamed;
            if (fAbs > i2) {
                this.f_renamed = ((-fSignum) * f_renamed) / (i2 * 2.0f);
                fAbs = i2;
            }
            this.l_renamed = (int) fAbs;
            this.n_renamed = 2;
            int i3 = this.f2963a;
            if (this.d_renamed <= 0) {
                fAbs = -fAbs;
            }
            this.f2965c = i3 + ((int) fAbs);
            this.h_renamed = -((int) ((this.d_renamed * 1000.0f) / this.f_renamed));
        }

        boolean b_renamed() {
            int i_renamed = this.n_renamed;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    return false;
                }
                if (i_renamed == 2) {
                    this.g_renamed += this.h_renamed;
                    e_renamed(this.f2965c, this.f2963a, 0);
                }
            } else {
                if (this.h_renamed >= this.i_renamed) {
                    return false;
                }
                int i2 = this.f2965c;
                this.f2963a = i2;
                this.f2964b = i2;
                this.d_renamed = (int) this.e_renamed;
                this.f_renamed = b_renamed(this.d_renamed);
                this.g_renamed += this.h_renamed;
                d_renamed();
            }
            c_renamed();
            return true;
        }

        boolean c_renamed() {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.g_renamed;
            if (jCurrentAnimationTimeMillis == 0) {
                return this.h_renamed > 0;
            }
            int i_renamed = this.h_renamed;
            if (jCurrentAnimationTimeMillis > i_renamed) {
                return false;
            }
            double d_renamed = 0.0d;
            int i2 = this.n_renamed;
            if (i2 == 0) {
                float f_renamed = jCurrentAnimationTimeMillis / this.i_renamed;
                int i3 = (int) (f_renamed * 100.0f);
                float f2 = 1.0f;
                float f3 = 0.0f;
                if (i3 < 100) {
                    float f4 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = q_renamed;
                    float f5 = fArr[i3];
                    f3 = (fArr[i4] - f5) / ((i4 / 100.0f) - f4);
                    f2 = f5 + ((f_renamed - f4) * f3);
                }
                int i5 = this.j_renamed;
                this.e_renamed = ((f3 * i5) / this.i_renamed) * 1000.0f;
                d_renamed = f2 * i5;
            } else if (i2 == 1) {
                float f6 = jCurrentAnimationTimeMillis / i_renamed;
                float f7 = f6 * f6;
                float fSignum = java.lang.Math.signum(this.d_renamed);
                int i6 = this.l_renamed;
                d_renamed = i6 * fSignum * ((3.0f * f7) - ((2.0f * f6) * f7));
                this.e_renamed = fSignum * i6 * 6.0f * ((-f6) + f7);
            } else if (i2 == 2) {
                float f8 = jCurrentAnimationTimeMillis / 1000.0f;
                int i7 = this.d_renamed;
                float f9 = this.f_renamed;
                this.e_renamed = i7 + (f9 * f8);
                d_renamed = (i7 * f8) + (((f9 * f8) * f8) / 2.0f);
            }
            this.f2964b = this.f2963a + ((int) java.lang.Math.round(d_renamed));
            return true;
        }
    }
}
