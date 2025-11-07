package androidx.core.widget;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a_renamed implements android.view.View.OnTouchListener {
    private static final int r_renamed = android.view.ViewConfiguration.getTapTimeout();

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.view.View f1019b;

    /* renamed from: c_renamed, reason: collision with root package name */
    boolean f1020c;
    boolean d_renamed;
    boolean e_renamed;
    private java.lang.Runnable g_renamed;
    private int j_renamed;
    private int k_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.core.widget.a_renamed.AutoScrollHelper_3 f1018a = new androidx.core.widget.a_renamed.AutoScrollHelper_3();
    private final android.view.animation.Interpolator f_renamed = new android.view.animation.AccelerateInterpolator();
    private float[] h_renamed = {0.0f, 0.0f};
    private float[] i_renamed = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] l_renamed = {0.0f, 0.0f};
    private float[] m_renamed = {0.0f, 0.0f};
    private float[] n_renamed = {Float.MAX_VALUE, Float.MAX_VALUE};

    static float a_renamed(float f_renamed, float f2, float f3) {
        return f_renamed > f3 ? f3 : f_renamed < f2 ? f2 : f_renamed;
    }

    static int a_renamed(int i_renamed, int i2, int i3) {
        return i_renamed > i3 ? i3 : i_renamed < i2 ? i2 : i_renamed;
    }

    public abstract void a_renamed(int i_renamed, int i2);

    public abstract boolean e_renamed(int i_renamed);

    public abstract boolean f_renamed(int i_renamed);

    public a_renamed(android.view.View view) {
        this.f1019b = view;
        android.util.DisplayMetrics displayMetrics = android.content.res.Resources.getSystem().getDisplayMetrics();
        int i_renamed = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f_renamed = i_renamed;
        a_renamed(f_renamed, f_renamed);
        float f2 = i2;
        b_renamed(f2, f2);
        a_renamed(1);
        e_renamed(Float.MAX_VALUE, Float.MAX_VALUE);
        d_renamed(0.2f, 0.2f);
        c_renamed(1.0f, 1.0f);
        b_renamed(r_renamed);
        c_renamed(500);
        d_renamed(500);
    }

    public androidx.core.widget.a_renamed a_renamed(boolean z_renamed) {
        if (this.p_renamed && !z_renamed) {
            d_renamed();
        }
        this.p_renamed = z_renamed;
        return this;
    }

    public androidx.core.widget.a_renamed a_renamed(float f_renamed, float f2) {
        float[] fArr = this.n_renamed;
        fArr[0] = f_renamed / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public androidx.core.widget.a_renamed b_renamed(float f_renamed, float f2) {
        float[] fArr = this.m_renamed;
        fArr[0] = f_renamed / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public androidx.core.widget.a_renamed c_renamed(float f_renamed, float f2) {
        float[] fArr = this.l_renamed;
        fArr[0] = f_renamed / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public androidx.core.widget.a_renamed a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        return this;
    }

    public androidx.core.widget.a_renamed d_renamed(float f_renamed, float f2) {
        float[] fArr = this.h_renamed;
        fArr[0] = f_renamed;
        fArr[1] = f2;
        return this;
    }

    public androidx.core.widget.a_renamed e_renamed(float f_renamed, float f2) {
        float[] fArr = this.i_renamed;
        fArr[0] = f_renamed;
        fArr[1] = f2;
        return this;
    }

    public androidx.core.widget.a_renamed b_renamed(int i_renamed) {
        this.k_renamed = i_renamed;
        return this;
    }

    public androidx.core.widget.a_renamed c_renamed(int i_renamed) {
        this.f1018a.a_renamed(i_renamed);
        return this;
    }

    public androidx.core.widget.a_renamed d_renamed(int i_renamed) {
        this.f1018a.b_renamed(i_renamed);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p_renamed
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.d_renamed()
            goto L58
        L1a:
            r5.d_renamed = r2
            r5.o_renamed = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1019b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a_renamed(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1019b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a_renamed(r2, r7, r6, r3)
            androidx.core.widget.a_renamed$a_renamed r7 = r5.f1018a
            r7.a_renamed(r0, r6)
            boolean r6 = r5.e_renamed
            if (r6 != 0) goto L58
            boolean r6 = r5.a_renamed()
            if (r6 == 0) goto L58
            r5.c_renamed()
        L58:
            boolean r6 = r5.q_renamed
            if (r6 == 0) goto L61
            boolean r5 = r5.e_renamed
            if (r5 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a_renamed.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    boolean a_renamed() {
        androidx.core.widget.a_renamed.AutoScrollHelper_3 c0024a = this.f1018a;
        int iF = c0024a.f_renamed();
        int iE = c0024a.e_renamed();
        return (iF != 0 && f_renamed(iF)) || (iE != 0 && e_renamed(iE));
    }

    private void c_renamed() {
        int i_renamed;
        if (this.g_renamed == null) {
            this.g_renamed = new androidx.core.widget.a_renamed.b_renamed();
        }
        this.e_renamed = true;
        this.f1020c = true;
        if (!this.o_renamed && (i_renamed = this.k_renamed) > 0) {
            androidx.core.h_renamed.v_renamed.a_renamed(this.f1019b, this.g_renamed, i_renamed);
        } else {
            this.g_renamed.run();
        }
        this.o_renamed = true;
    }

    private void d_renamed() {
        if (this.f1020c) {
            this.e_renamed = false;
        } else {
            this.f1018a.b_renamed();
        }
    }

    private float a_renamed(int i_renamed, float f_renamed, float f2, float f3) {
        float fA_renamed = a_renamed(this.h_renamed[i_renamed], f2, this.i_renamed[i_renamed], f_renamed);
        if (fA_renamed == 0.0f) {
            return 0.0f;
        }
        float f4 = this.l_renamed[i_renamed];
        float f5 = this.m_renamed[i_renamed];
        float f6 = this.n_renamed[i_renamed];
        float f7 = f4 * f3;
        if (fA_renamed > 0.0f) {
            return a_renamed(fA_renamed * f7, f5, f6);
        }
        return -a_renamed((-fA_renamed) * f7, f5, f6);
    }

    private float a_renamed(float f_renamed, float f2, float f3, float f4) {
        float interpolation;
        float fA_renamed = a_renamed(f_renamed * f2, 0.0f, f3);
        float f5 = f_renamed(f2 - f4, fA_renamed) - f_renamed(f4, fA_renamed);
        if (f5 < 0.0f) {
            interpolation = -this.f_renamed.getInterpolation(-f5);
        } else {
            if (f5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f_renamed.getInterpolation(f5);
        }
        return a_renamed(interpolation, -1.0f, 1.0f);
    }

    private float f_renamed(float f_renamed, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i_renamed = this.j_renamed;
        if (i_renamed == 0 || i_renamed == 1) {
            if (f_renamed < f2) {
                if (f_renamed >= 0.0f) {
                    return 1.0f - (f_renamed / f2);
                }
                if (this.e_renamed && this.j_renamed == 1) {
                    return 1.0f;
                }
            }
        } else if (i_renamed == 2 && f_renamed < 0.0f) {
            return f_renamed / (-f2);
        }
        return 0.0f;
    }

    void b_renamed() {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1019b.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* compiled from: AutoScrollHelper.java */
    private class b_renamed implements java.lang.Runnable {
        b_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (androidx.core.widget.a_renamed.this.e_renamed) {
                if (androidx.core.widget.a_renamed.this.f1020c) {
                    androidx.core.widget.a_renamed aVar = androidx.core.widget.a_renamed.this;
                    aVar.f1020c = false;
                    aVar.f1018a.a_renamed();
                }
                androidx.core.widget.a_renamed.AutoScrollHelper_3 c0024a = androidx.core.widget.a_renamed.this.f1018a;
                if (c0024a.c_renamed() || !androidx.core.widget.a_renamed.this.a_renamed()) {
                    androidx.core.widget.a_renamed.this.e_renamed = false;
                    return;
                }
                if (androidx.core.widget.a_renamed.this.d_renamed) {
                    androidx.core.widget.a_renamed aVar2 = androidx.core.widget.a_renamed.this;
                    aVar2.d_renamed = false;
                    aVar2.b_renamed();
                }
                c0024a.d_renamed();
                androidx.core.widget.a_renamed.this.a_renamed(c0024a.g_renamed(), c0024a.h_renamed());
                androidx.core.h_renamed.v_renamed.a_renamed(androidx.core.widget.a_renamed.this.f1019b, this);
            }
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class AutoScrollHelper_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f1021a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f1022b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f1023c;
        private float d_renamed;
        private float j_renamed;
        private int k_renamed;
        private long e_renamed = Long.MIN_VALUE;
        private long i_renamed = -1;
        private long f_renamed = 0;
        private int g_renamed = 0;
        private int h_renamed = 0;

        private float a_renamed(float f_renamed) {
            return ((-4.0f) * f_renamed * f_renamed) + (f_renamed * 4.0f);
        }

        AutoScrollHelper_3() {
        }

        public void a_renamed(int i_renamed) {
            this.f1021a = i_renamed;
        }

        public void b_renamed(int i_renamed) {
            this.f1022b = i_renamed;
        }

        public void a_renamed() {
            this.e_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.i_renamed = -1L;
            this.f_renamed = this.e_renamed;
            this.j_renamed = 0.5f;
            this.g_renamed = 0;
            this.h_renamed = 0;
        }

        public void b_renamed() {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.k_renamed = androidx.core.widget.a_renamed.a_renamed((int) (jCurrentAnimationTimeMillis - this.e_renamed), 0, this.f1022b);
            this.j_renamed = a_renamed(jCurrentAnimationTimeMillis);
            this.i_renamed = jCurrentAnimationTimeMillis;
        }

        public boolean c_renamed() {
            return this.i_renamed > 0 && android.view.animation.AnimationUtils.currentAnimationTimeMillis() > this.i_renamed + ((long) this.k_renamed);
        }

        private float a_renamed(long j_renamed) {
            if (j_renamed < this.e_renamed) {
                return 0.0f;
            }
            long j2 = this.i_renamed;
            if (j2 < 0 || j_renamed < j2) {
                return androidx.core.widget.a_renamed.a_renamed((j_renamed - this.e_renamed) / this.f1021a, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j_renamed - j2;
            float f_renamed = this.j_renamed;
            return (1.0f - f_renamed) + (f_renamed * androidx.core.widget.a_renamed.a_renamed(j3 / this.k_renamed, 0.0f, 1.0f));
        }

        public void d_renamed() {
            if (this.f_renamed == 0) {
                throw new java.lang.RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            float fA_renamed = a_renamed(a_renamed(jCurrentAnimationTimeMillis));
            long j_renamed = jCurrentAnimationTimeMillis - this.f_renamed;
            this.f_renamed = jCurrentAnimationTimeMillis;
            float f_renamed = j_renamed * fA_renamed;
            this.g_renamed = (int) (this.f1023c * f_renamed);
            this.h_renamed = (int) (f_renamed * this.d_renamed);
        }

        public void a_renamed(float f_renamed, float f2) {
            this.f1023c = f_renamed;
            this.d_renamed = f2;
        }

        public int e_renamed() {
            float f_renamed = this.f1023c;
            return (int) (f_renamed / java.lang.Math.abs(f_renamed));
        }

        public int f_renamed() {
            float f_renamed = this.d_renamed;
            return (int) (f_renamed / java.lang.Math.abs(f_renamed));
        }

        public int g_renamed() {
            return this.g_renamed;
        }

        public int h_renamed() {
            return this.h_renamed;
        }
    }
}
