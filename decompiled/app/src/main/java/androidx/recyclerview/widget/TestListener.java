package androidx.recyclerview.widget;

/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
class g_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed implements androidx.recyclerview.widget.RecyclerView.m_renamed {
    private static final int[] k_renamed = {android.R_renamed.attr.state_pressed};
    private static final int[] l_renamed = new int[0];

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.drawable.StateListDrawable f1518a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.graphics.drawable.Drawable f1519b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1520c;
    int d_renamed;
    float e_renamed;
    int f_renamed;
    int g_renamed;
    float h_renamed;
    private final int m_renamed;
    private final int n_renamed;
    private final int o_renamed;
    private final int p_renamed;
    private final android.graphics.drawable.StateListDrawable q_renamed;
    private final android.graphics.drawable.Drawable r_renamed;
    private final int s_renamed;
    private final int t_renamed;
    private androidx.recyclerview.widget.RecyclerView w_renamed;
    private int u_renamed = 0;
    private int v_renamed = 0;
    private boolean x_renamed = false;
    private boolean y_renamed = false;
    private int z_renamed = 0;
    private int A_renamed = 0;
    private final int[] B_renamed = new int[2];
    private final int[] C_renamed = new int[2];
    final android.animation.ValueAnimator i_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
    int j_renamed = 0;
    private final java.lang.Runnable D_renamed = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.g_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.g_renamed.this.b_renamed(500);
        }
    };
    private final androidx.recyclerview.widget.RecyclerView.n_renamed E_renamed = new androidx.recyclerview.widget.RecyclerView.n_renamed() { // from class: androidx.recyclerview.widget.g_renamed.2
        @Override // androidx.recyclerview.widget.RecyclerView.n_renamed
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
            androidx.recyclerview.widget.g_renamed.this.a_renamed(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
    public void a_renamed(boolean z_renamed) {
    }

    g_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.graphics.drawable.StateListDrawable stateListDrawable, android.graphics.drawable.Drawable drawable, android.graphics.drawable.StateListDrawable stateListDrawable2, android.graphics.drawable.Drawable drawable2, int i_renamed, int i2, int i3) {
        this.f1518a = stateListDrawable;
        this.f1519b = drawable;
        this.q_renamed = stateListDrawable2;
        this.r_renamed = drawable2;
        this.o_renamed = java.lang.Math.max(i_renamed, stateListDrawable.getIntrinsicWidth());
        this.p_renamed = java.lang.Math.max(i_renamed, drawable.getIntrinsicWidth());
        this.s_renamed = java.lang.Math.max(i_renamed, stateListDrawable2.getIntrinsicWidth());
        this.t_renamed = java.lang.Math.max(i_renamed, drawable2.getIntrinsicWidth());
        this.m_renamed = i2;
        this.n_renamed = i3;
        this.f1518a.setAlpha(255);
        this.f1519b.setAlpha(255);
        this.i_renamed.addListener(new androidx.recyclerview.widget.g_renamed.a_renamed());
        this.i_renamed.addUpdateListener(new androidx.recyclerview.widget.g_renamed.b_renamed());
        a_renamed(recyclerView);
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.w_renamed;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            d_renamed();
        }
        this.w_renamed = recyclerView;
        if (this.w_renamed != null) {
            c_renamed();
        }
    }

    private void c_renamed() {
        this.w_renamed.addItemDecoration(this);
        this.w_renamed.addOnItemTouchListener(this);
        this.w_renamed.addOnScrollListener(this.E_renamed);
    }

    private void d_renamed() {
        this.w_renamed.removeItemDecoration(this);
        this.w_renamed.removeOnItemTouchListener(this);
        this.w_renamed.removeOnScrollListener(this.E_renamed);
        f_renamed();
    }

    void a_renamed() {
        this.w_renamed.invalidate();
    }

    void a_renamed(int i_renamed) {
        if (i_renamed == 2 && this.z_renamed != 2) {
            this.f1518a.setState(k_renamed);
            f_renamed();
        }
        if (i_renamed == 0) {
            a_renamed();
        } else {
            b_renamed();
        }
        if (this.z_renamed == 2 && i_renamed != 2) {
            this.f1518a.setState(l_renamed);
            c_renamed(1200);
        } else if (i_renamed == 1) {
            c_renamed(1500);
        }
        this.z_renamed = i_renamed;
    }

    private boolean e_renamed() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this.w_renamed) == 1;
    }

    public void b_renamed() {
        int i_renamed = this.j_renamed;
        if (i_renamed != 0) {
            if (i_renamed != 3) {
                return;
            } else {
                this.i_renamed.cancel();
            }
        }
        this.j_renamed = 1;
        android.animation.ValueAnimator valueAnimator = this.i_renamed;
        valueAnimator.setFloatValues(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.i_renamed.setDuration(500L);
        this.i_renamed.setStartDelay(0L);
        this.i_renamed.start();
    }

    void b_renamed(int i_renamed) {
        int i2 = this.j_renamed;
        if (i2 == 1) {
            this.i_renamed.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.j_renamed = 3;
        android.animation.ValueAnimator valueAnimator = this.i_renamed;
        valueAnimator.setFloatValues(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.i_renamed.setDuration(i_renamed);
        this.i_renamed.start();
    }

    private void f_renamed() {
        this.w_renamed.removeCallbacks(this.D_renamed);
    }

    private void c_renamed(int i_renamed) {
        f_renamed();
        this.w_renamed.postDelayed(this.D_renamed, i_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (this.u_renamed != this.w_renamed.getWidth() || this.v_renamed != this.w_renamed.getHeight()) {
            this.u_renamed = this.w_renamed.getWidth();
            this.v_renamed = this.w_renamed.getHeight();
            a_renamed(0);
        } else if (this.j_renamed != 0) {
            if (this.x_renamed) {
                a_renamed(canvas);
            }
            if (this.y_renamed) {
                b_renamed(canvas);
            }
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        int i_renamed = this.u_renamed;
        int i2 = this.o_renamed;
        int i3 = i_renamed - i2;
        int i4 = this.d_renamed;
        int i5 = this.f1520c;
        int i6 = i4 - (i5 / 2);
        this.f1518a.setBounds(0, 0, i2, i5);
        this.f1519b.setBounds(0, 0, this.p_renamed, this.v_renamed);
        if (e_renamed()) {
            this.f1519b.draw(canvas);
            canvas.translate(this.o_renamed, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f1518a.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.o_renamed, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f1519b.draw(canvas);
        canvas.translate(0.0f, i6);
        this.f1518a.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        int i_renamed = this.v_renamed;
        int i2 = this.s_renamed;
        int i3 = this.g_renamed;
        int i4 = this.f_renamed;
        this.q_renamed.setBounds(0, 0, i4, i2);
        this.r_renamed.setBounds(0, 0, this.u_renamed, this.t_renamed);
        canvas.translate(0.0f, i_renamed - i2);
        this.r_renamed.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.q_renamed.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    void a_renamed(int i_renamed, int i2) {
        int iComputeVerticalScrollRange = this.w_renamed.computeVerticalScrollRange();
        int i3 = this.v_renamed;
        this.x_renamed = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.m_renamed;
        int iComputeHorizontalScrollRange = this.w_renamed.computeHorizontalScrollRange();
        int i4 = this.u_renamed;
        this.y_renamed = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.m_renamed;
        if (!this.x_renamed && !this.y_renamed) {
            if (this.z_renamed != 0) {
                a_renamed(0);
                return;
            }
            return;
        }
        if (this.x_renamed) {
            float f_renamed = i3;
            this.d_renamed = (int) ((f_renamed * (i2 + (f_renamed / 2.0f))) / iComputeVerticalScrollRange);
            this.f1520c = java.lang.Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.y_renamed) {
            float f2 = i4;
            this.g_renamed = (int) ((f2 * (i_renamed + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f_renamed = java.lang.Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.z_renamed;
        if (i5 == 0 || i5 == 1) {
            a_renamed(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
        int i_renamed = this.z_renamed;
        if (i_renamed == 1) {
            boolean zA = a_renamed(motionEvent.getX(), motionEvent.getY());
            boolean zB = b_renamed(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zA && !zB) {
                return false;
            }
            if (zB) {
                this.A_renamed = 1;
                this.h_renamed = (int) motionEvent.getX();
            } else if (zA) {
                this.A_renamed = 2;
                this.e_renamed = (int) motionEvent.getY();
            }
            a_renamed(2);
        } else if (i_renamed != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
    public void b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
        if (this.z_renamed == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zA = a_renamed(motionEvent.getX(), motionEvent.getY());
            boolean zB = b_renamed(motionEvent.getX(), motionEvent.getY());
            if (zA || zB) {
                if (zB) {
                    this.A_renamed = 1;
                    this.h_renamed = (int) motionEvent.getX();
                } else if (zA) {
                    this.A_renamed = 2;
                    this.e_renamed = (int) motionEvent.getY();
                }
                a_renamed(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.z_renamed == 2) {
            this.e_renamed = 0.0f;
            this.h_renamed = 0.0f;
            a_renamed(1);
            this.A_renamed = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.z_renamed == 2) {
            b_renamed();
            if (this.A_renamed == 1) {
                b_renamed(motionEvent.getX());
            }
            if (this.A_renamed == 2) {
                a_renamed(motionEvent.getY());
            }
        }
    }

    private void a_renamed(float f_renamed) {
        int[] iArrG = g_renamed();
        float fMax = java.lang.Math.max(iArrG[0], java.lang.Math.min(iArrG[1], f_renamed));
        if (java.lang.Math.abs(this.d_renamed - fMax) < 2.0f) {
            return;
        }
        int iA = a_renamed(this.e_renamed, fMax, iArrG, this.w_renamed.computeVerticalScrollRange(), this.w_renamed.computeVerticalScrollOffset(), this.v_renamed);
        if (iA != 0) {
            this.w_renamed.scrollBy(0, iA);
        }
        this.e_renamed = fMax;
    }

    private void b_renamed(float f_renamed) {
        int[] iArrH = h_renamed();
        float fMax = java.lang.Math.max(iArrH[0], java.lang.Math.min(iArrH[1], f_renamed));
        if (java.lang.Math.abs(this.g_renamed - fMax) < 2.0f) {
            return;
        }
        int iA = a_renamed(this.h_renamed, fMax, iArrH, this.w_renamed.computeHorizontalScrollRange(), this.w_renamed.computeHorizontalScrollOffset(), this.u_renamed);
        if (iA != 0) {
            this.w_renamed.scrollBy(iA, 0);
        }
        this.h_renamed = fMax;
    }

    private int a_renamed(float f_renamed, float f2, int[] iArr, int i_renamed, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i_renamed - i3;
        int i6 = (int) (((f2 - f_renamed) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a_renamed(float f_renamed, float f2) {
        if (!e_renamed() ? f_renamed >= this.u_renamed - this.o_renamed : f_renamed <= this.o_renamed) {
            int i_renamed = this.d_renamed;
            int i2 = this.f1520c;
            if (f2 >= i_renamed - (i2 / 2) && f2 <= i_renamed + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean b_renamed(float f_renamed, float f2) {
        if (f2 >= this.v_renamed - this.s_renamed) {
            int i_renamed = this.g_renamed;
            int i2 = this.f_renamed;
            if (f_renamed >= i_renamed - (i2 / 2) && f_renamed <= i_renamed + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    private int[] g_renamed() {
        int[] iArr = this.B_renamed;
        int i_renamed = this.n_renamed;
        iArr[0] = i_renamed;
        iArr[1] = this.v_renamed - i_renamed;
        return iArr;
    }

    private int[] h_renamed() {
        int[] iArr = this.C_renamed;
        int i_renamed = this.n_renamed;
        iArr[0] = i_renamed;
        iArr[1] = this.u_renamed - i_renamed;
        return iArr;
    }

    /* compiled from: FastScroller.java */
    private class a_renamed extends android.animation.AnimatorListenerAdapter {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f1524b = false;

        a_renamed() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.f1524b) {
                this.f1524b = false;
                return;
            }
            if (((java.lang.Float) androidx.recyclerview.widget.g_renamed.this.i_renamed.getAnimatedValue()).floatValue() == 0.0f) {
                androidx.recyclerview.widget.g_renamed gVar = androidx.recyclerview.widget.g_renamed.this;
                gVar.j_renamed = 0;
                gVar.a_renamed(0);
            } else {
                androidx.recyclerview.widget.g_renamed gVar2 = androidx.recyclerview.widget.g_renamed.this;
                gVar2.j_renamed = 2;
                gVar2.a_renamed();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.f1524b = true;
        }
    }

    /* compiled from: FastScroller.java */
    private class b_renamed implements android.animation.ValueAnimator.AnimatorUpdateListener {
        b_renamed() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            androidx.recyclerview.widget.g_renamed.this.f1518a.setAlpha(iFloatValue);
            androidx.recyclerview.widget.g_renamed.this.f1519b.setAlpha(iFloatValue);
            androidx.recyclerview.widget.g_renamed.this.a_renamed();
        }
    }
}
