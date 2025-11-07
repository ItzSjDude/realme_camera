package com.oplus.camera.t_renamed;

/* compiled from: ScaleBar.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f5585a = 255;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int f5586b = (int) (f5585a * 0.5d);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f5587c;
    private static int d_renamed;
    private static int e_renamed;
    private android.content.Context A_renamed;
    private android.graphics.Paint B_renamed;
    private com.oplus.camera.t_renamed.b_renamed.c_renamed C_renamed;
    private android.view.VelocityTracker D_renamed;
    private com.oplus.camera.t_renamed.b_renamed.ScaleBar_4 E_renamed;
    private android.os.Handler F_renamed;
    private int G_renamed;
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
    private float v_renamed;
    private boolean w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private boolean z_renamed;

    /* compiled from: ScaleBar.java */
    public interface c_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(boolean z_renamed);

        void b_renamed();
    }

    public b_renamed(android.content.Context context, int i_renamed, android.os.Handler handler) {
        super(context);
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.l_renamed = 30;
        this.r_renamed = 1;
        this.t_renamed = 10;
        this.v_renamed = 0.0f;
        this.z_renamed = true;
        this.G_renamed = -1;
        this.F_renamed = handler;
        this.i_renamed = i_renamed;
        this.A_renamed = context;
        c_renamed();
    }

    private void c_renamed() {
        if (this.i_renamed <= 0) {
            this.z_renamed = false;
            return;
        }
        this.z_renamed = true;
        android.content.res.Resources resources = this.A_renamed.getResources();
        this.p_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        this.q_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_small_scale_stroke_width);
        this.o_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_level_panel_height) / 2;
        this.l_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_margin);
        this.m_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_scale_height);
        this.n_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_scale_bar_scale_pointer_height);
        this.p_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_scale_bar_big_scale_stroke_width);
        f5587c = this.A_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white);
        d_renamed = resources.getColor(com.oplus.camera.R_renamed.color.pointer_scale_color);
        e_renamed = com.oplus.camera.util.Util.A_renamed(this.A_renamed);
        this.B_renamed = new android.graphics.Paint();
        this.B_renamed.setAntiAlias(true);
        this.B_renamed.setColor(f5587c);
        this.B_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.B_renamed.setStrokeWidth(this.q_renamed);
        android.view.ViewConfiguration.get(this.A_renamed);
        this.u_renamed = android.view.ViewConfiguration.getMaximumFlingVelocity();
        int i_renamed = this.i_renamed;
        this.s_renamed = i_renamed % 2 == 0 ? (i_renamed / 2) - 1 : i_renamed / 2;
        if (this.s_renamed < 0) {
            this.s_renamed = 0;
        }
    }

    public void setCurrentIndex(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.i_renamed) {
            return;
        }
        this.h_renamed = i_renamed;
    }

    public void setLevelNum(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ScaleBar", "setLevelNum, levelNum: " + i_renamed);
        this.i_renamed = i_renamed;
        if (this.z_renamed) {
            int i2 = this.i_renamed;
            this.s_renamed = i2 % 2 == 0 ? (i2 / 2) - 1 : i2 / 2;
        } else {
            c_renamed();
        }
    }

    public int getCurrentIndex() {
        return this.h_renamed;
    }

    public void setScaleBarValueChangeListener(com.oplus.camera.t_renamed.b_renamed.c_renamed cVar) {
        this.C_renamed = cVar;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.z_renamed) {
            if (1 == getLayoutDirection()) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
            }
            this.B_renamed.setColor(f5587c);
            int i_renamed = this.o_renamed;
            int i2 = this.m_renamed;
            int i3 = (i2 / 2) + i_renamed;
            int i4 = i_renamed - (i2 / 10);
            int i5 = this.r_renamed == 2 ? this.s_renamed % this.t_renamed : 0;
            for (int i6 = 0; i6 < this.i_renamed; i6++) {
                float fMax = java.lang.Math.max((this.j_renamed / 2) - ((java.lang.Math.abs(this.h_renamed - i6) + 1) * this.l_renamed), 0) / (this.j_renamed / 2);
                if (i6 % this.t_renamed == i5 || i6 == this.G_renamed) {
                    this.B_renamed.setStrokeWidth(this.q_renamed);
                    this.B_renamed.setAlpha((int) (f5585a * fMax));
                } else {
                    this.B_renamed.setStrokeWidth(this.q_renamed);
                    this.B_renamed.setAlpha((int) (f5586b * fMax));
                }
                int i7 = this.f_renamed;
                int i8 = this.l_renamed;
                canvas.drawLine((i8 * i6) + i7, i3, i7 + (i8 * i6), i4, this.B_renamed);
            }
            int i9 = this.o_renamed;
            int i10 = this.m_renamed;
            int i11 = (i10 / 2) + i9;
            int i12 = i9 - (i10 / 2);
            if (this.w_renamed) {
                this.B_renamed.setColor(e_renamed);
            } else {
                this.B_renamed.setColor(d_renamed);
            }
            this.B_renamed.setAlpha(f5585a);
            this.B_renamed.setStrokeWidth(this.p_renamed);
            int i13 = this.k_renamed;
            canvas.drawLine(i13, i11, i13, i12, this.B_renamed);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.v_renamed = motionEvent.getX();
            this.D_renamed = android.view.VelocityTracker.obtain();
            com.oplus.camera.t_renamed.b_renamed.ScaleBar_4 runnableC0119b = this.E_renamed;
            if (runnableC0119b != null) {
                runnableC0119b.a_renamed();
                this.E_renamed = null;
            }
        } else if (action == 1) {
            float xVelocity = 0.0f;
            android.view.VelocityTracker velocityTracker = this.D_renamed;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.D_renamed.computeCurrentVelocity(1000, this.u_renamed);
                xVelocity = this.D_renamed.getXVelocity();
                this.D_renamed.clear();
            }
            if (java.lang.Math.abs(xVelocity) >= 1000.0f) {
                if (1 == getLayoutDirection()) {
                    xVelocity = -xVelocity;
                }
                this.E_renamed = new com.oplus.camera.t_renamed.b_renamed.ScaleBar_4(xVelocity);
                this.F_renamed.post(this.E_renamed);
            } else {
                d_renamed();
                com.oplus.camera.t_renamed.b_renamed.c_renamed cVar = this.C_renamed;
                if (cVar != null) {
                    cVar.b_renamed();
                }
            }
        } else if (action == 2) {
            float x_renamed = motionEvent.getX() - this.v_renamed;
            this.v_renamed = motionEvent.getX();
            android.view.VelocityTracker velocityTracker2 = this.D_renamed;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (1 == getLayoutDirection()) {
                a_renamed(-x_renamed);
            } else {
                a_renamed(x_renamed);
            }
        } else if (action == 3) {
            android.view.VelocityTracker velocityTracker3 = this.D_renamed;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.D_renamed = null;
            }
            d_renamed();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed() {
        int i_renamed = (this.f_renamed - this.g_renamed) % this.l_renamed;
        if (i_renamed != 0) {
            int iAbs = java.lang.Math.abs(i_renamed);
            int i2 = this.l_renamed;
            if (iAbs < i2 / 2) {
                this.f_renamed -= i_renamed;
            } else if (i_renamed > 0) {
                this.f_renamed = (this.f_renamed - i_renamed) + i2;
            } else {
                this.f_renamed = (this.f_renamed - i_renamed) - i2;
            }
            a_renamed();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        if (!this.z_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ScaleBar", "onMove return, is_renamed not valid");
            return;
        }
        this.f_renamed += (int) f_renamed;
        int i_renamed = this.f_renamed;
        int i2 = this.k_renamed;
        if (i_renamed >= i2) {
            this.f_renamed = i2;
        } else {
            int i3 = this.l_renamed;
            int i4 = this.i_renamed;
            if (i_renamed + ((i4 - 1) * i3) <= i2) {
                this.f_renamed = i2 - (i3 * (i4 - 1));
            }
        }
        this.C_renamed.a_renamed();
        a_renamed();
        invalidate();
    }

    public void a_renamed() {
        if (this.i_renamed != 0) {
            int iAbs = java.lang.Math.abs((this.k_renamed - this.f_renamed) / this.l_renamed) % this.i_renamed;
            com.oplus.camera.t_renamed.b_renamed.c_renamed cVar = this.C_renamed;
            if (cVar != null && iAbs != this.h_renamed) {
                cVar.a_renamed(iAbs);
            }
            setCurrentIndex(iAbs);
        }
    }

    public void b_renamed() {
        if (this.i_renamed != 0) {
            int iAbs = java.lang.Math.abs((this.k_renamed - this.f_renamed) / this.l_renamed) % this.i_renamed;
            com.oplus.camera.t_renamed.b_renamed.c_renamed cVar = this.C_renamed;
            if (cVar != null) {
                cVar.a_renamed(iAbs);
            }
            setCurrentIndex(iAbs);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (this.j_renamed > 0) {
            return;
        }
        this.j_renamed = getMeasuredWidth();
        int i3 = this.j_renamed / 2;
        int i4 = this.p_renamed;
        this.k_renamed = i3 - (i4 / 2);
        this.g_renamed = (i3 % this.l_renamed) - (i4 / 2);
        this.y_renamed = true;
        if (!this.x_renamed) {
            this.f_renamed = 0;
        }
        int i5 = this.h_renamed;
        if (i5 >= 0) {
            b_renamed(i5);
        }
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.i_renamed) {
            return;
        }
        this.f_renamed = this.k_renamed - (this.l_renamed * i_renamed);
        invalidate();
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.i_renamed) {
            return;
        }
        this.h_renamed = i_renamed;
        if (this.y_renamed) {
            this.f_renamed = this.k_renamed - (this.l_renamed * i_renamed);
            this.x_renamed = true;
            invalidate();
        }
    }

    public void setAuto(boolean z_renamed) {
        this.w_renamed = z_renamed;
        invalidate();
    }

    public void setAlign(int i_renamed) {
        if (i_renamed == 1 || i_renamed == 2) {
            this.r_renamed = i_renamed;
        }
    }

    /* compiled from: ScaleBar.java */
    private class a_renamed extends android.view.animation.PathInterpolator {
        a_renamed() {
            super(0.0f, 0.0f, 0.58f, 1.0f);
        }
    }

    /* compiled from: ScaleBar.java */
    /* renamed from: com.oplus.camera.t_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    private class ScaleBar_4 implements java.lang.Runnable {
        private float d_renamed;
        private float e_renamed;
        private float f_renamed;
        private float g_renamed;
        private long j_renamed;
        private android.view.animation.Interpolator k_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5590b = 400;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f5591c = 16;
        private float h_renamed = 0.15f;
        private boolean i_renamed = false;

        public ScaleBar_4(float f_renamed) {
            this.k_renamed = com.oplus.camera.t_renamed.b_renamed.this.new a_renamed();
            if (com.oplus.camera.t_renamed.b_renamed.this.C_renamed != null) {
                com.oplus.camera.t_renamed.b_renamed.this.C_renamed.a_renamed(!this.i_renamed);
            }
            this.g_renamed = 0.0f;
            int i_renamed = this.f5590b;
            this.d_renamed = 1.0f / i_renamed;
            this.e_renamed = f_renamed;
            this.f_renamed = ((i_renamed * this.e_renamed) / 1000.0f) * this.h_renamed;
            this.j_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        }

        public void a_renamed() {
            this.i_renamed = true;
            if (com.oplus.camera.t_renamed.b_renamed.this.C_renamed != null) {
                com.oplus.camera.t_renamed.b_renamed.this.C_renamed.a_renamed(!this.i_renamed);
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
            int i_renamed = this.f5590b;
            if (iCurrentAnimationTimeMillis < i_renamed) {
                com.oplus.camera.t_renamed.b_renamed.this.a_renamed(f_renamed);
                com.oplus.camera.t_renamed.b_renamed.this.F_renamed.postDelayed(this, this.f5591c);
            } else if (iCurrentAnimationTimeMillis >= i_renamed) {
                this.g_renamed = 0.0f;
                com.oplus.camera.t_renamed.b_renamed.this.d_renamed();
                this.i_renamed = true;
                if (com.oplus.camera.t_renamed.b_renamed.this.C_renamed != null) {
                    com.oplus.camera.t_renamed.b_renamed.this.C_renamed.a_renamed(!this.i_renamed);
                }
            }
        }
    }

    public void setForceBigScaleAlphaPosition(int i_renamed) {
        this.G_renamed = i_renamed;
    }
}
