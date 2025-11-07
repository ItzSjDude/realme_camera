package com.oplus.camera;

/* compiled from: ScaleGestureDetector.java */
/* loaded from: classes2.dex */
public class ab_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f4080a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.camera.ab_renamed.a_renamed f4081b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f4082c;
    private float d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private float g_renamed;
    private float h_renamed;
    private float i_renamed;
    private float j_renamed;
    private float k_renamed;
    private float l_renamed;
    private float m_renamed;
    private long n_renamed;
    private long o_renamed;
    private boolean p_renamed;
    private int q_renamed;
    private int r_renamed;
    private final android.os.Handler s_renamed;
    private float t_renamed;
    private float u_renamed;
    private int v_renamed;
    private android.view.GestureDetector w_renamed;
    private boolean x_renamed;

    /* compiled from: ScaleGestureDetector.java */
    public interface a_renamed {
        boolean a_renamed(com.oplus.camera.ab_renamed abVar);

        boolean b_renamed(com.oplus.camera.ab_renamed abVar);

        void c_renamed(com.oplus.camera.ab_renamed abVar);
    }

    public ab_renamed(android.content.Context context, com.oplus.camera.ab_renamed.a_renamed aVar) {
        this(context, aVar, null);
    }

    public ab_renamed(android.content.Context context, com.oplus.camera.ab_renamed.a_renamed aVar, android.os.Handler handler) {
        this.v_renamed = 0;
        this.f4080a = context;
        this.f4081b = aVar;
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.q_renamed = viewConfiguration.getScaledTouchSlop() / 3;
        this.r_renamed = viewConfiguration.getScaledMinimumScalingSpan() / 3;
        this.s_renamed = handler;
        int i_renamed = context.getApplicationInfo().targetSdkVersion;
        if (i_renamed > 18) {
            a_renamed(true);
        }
        if (i_renamed > 22) {
            b_renamed(true);
        }
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        float f_renamed;
        float f2;
        this.n_renamed = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.e_renamed) {
            this.w_renamed.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z_renamed = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.v_renamed == 2 && !z_renamed;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        if (actionMasked == 0 || z3) {
            if (this.p_renamed) {
                this.f4081b.c_renamed(this);
                c_renamed(false);
                this.i_renamed = 0.0f;
                this.v_renamed = 0;
            } else if (f_renamed() && z3) {
                c_renamed(false);
                this.i_renamed = 0.0f;
                this.v_renamed = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.p_renamed && this.f_renamed && !f_renamed() && !z3 && z_renamed) {
            this.t_renamed = motionEvent.getX();
            this.u_renamed = motionEvent.getY();
            this.v_renamed = 2;
            this.i_renamed = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int i_renamed = z5 ? pointerCount - 1 : pointerCount;
        if (f_renamed()) {
            f2 = this.t_renamed;
            f_renamed = this.u_renamed;
            if (motionEvent.getY() < f_renamed) {
                this.x_renamed = true;
            } else {
                this.x_renamed = false;
            }
        } else {
            float x_renamed = 0.0f;
            float y_renamed = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    x_renamed += motionEvent.getX(i2);
                    y_renamed += motionEvent.getY(i2);
                }
            }
            float f3 = i_renamed;
            float f4 = x_renamed / f3;
            f_renamed = y_renamed / f3;
            f2 = f4;
        }
        float fAbs = 0.0f;
        float fAbs2 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                fAbs += java.lang.Math.abs(motionEvent.getX(i3) - f2);
                fAbs2 += java.lang.Math.abs(motionEvent.getY(i3) - f_renamed);
            }
        }
        float f5 = i_renamed;
        float f6 = (fAbs / f5) * 2.0f;
        float f7 = (fAbs2 / f5) * 2.0f;
        float fHypot = f_renamed() ? f7 : (float) java.lang.Math.hypot(f6, f7);
        boolean z6 = this.p_renamed;
        this.f4082c = f2;
        this.d_renamed = f_renamed;
        if (!f_renamed() && this.p_renamed && (fHypot < this.r_renamed || z4)) {
            this.f4081b.c_renamed(this);
            c_renamed(false);
            this.i_renamed = fHypot;
        }
        if (z4) {
            this.j_renamed = f6;
            this.l_renamed = f6;
            this.k_renamed = f7;
            this.m_renamed = f7;
            this.g_renamed = fHypot;
            this.h_renamed = fHypot;
            this.i_renamed = fHypot;
        }
        int i4 = f_renamed() ? this.q_renamed : this.r_renamed;
        if (!this.p_renamed && fHypot >= i4 && (z6 || java.lang.Math.abs(fHypot - this.i_renamed) > this.q_renamed)) {
            this.j_renamed = f6;
            this.l_renamed = f6;
            this.k_renamed = f7;
            this.m_renamed = f7;
            this.g_renamed = fHypot;
            this.h_renamed = fHypot;
            this.o_renamed = this.n_renamed;
            c_renamed(this.f4081b.b_renamed(this));
        }
        if (actionMasked == 2) {
            this.j_renamed = f6;
            this.k_renamed = f7;
            this.g_renamed = fHypot;
            if (this.p_renamed ? this.f4081b.a_renamed(this) : true) {
                this.l_renamed = this.j_renamed;
                this.m_renamed = this.k_renamed;
                this.h_renamed = this.g_renamed;
                this.o_renamed = this.n_renamed;
            }
        }
        return true;
    }

    private boolean f_renamed() {
        return this.v_renamed != 0;
    }

    public void a_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
        if (this.e_renamed && this.w_renamed == null) {
            this.w_renamed = new android.view.GestureDetector(this.f4080a, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.oplus.camera.ab_renamed.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                    com.oplus.camera.ab_renamed.this.t_renamed = motionEvent.getX();
                    com.oplus.camera.ab_renamed.this.u_renamed = motionEvent.getY();
                    com.oplus.camera.ab_renamed.this.v_renamed = 1;
                    return true;
                }
            }, this.s_renamed);
        }
    }

    public void b_renamed(boolean z_renamed) {
        this.f_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.p_renamed;
    }

    public float b_renamed() {
        return this.g_renamed;
    }

    public float c_renamed() {
        return this.i_renamed;
    }

    public float d_renamed() {
        if (f_renamed()) {
            boolean z_renamed = (this.x_renamed && this.g_renamed < this.h_renamed) || (!this.x_renamed && this.g_renamed > this.h_renamed);
            float fAbs = java.lang.Math.abs(1.0f - (this.g_renamed / this.h_renamed)) * 0.5f;
            if (this.h_renamed <= this.q_renamed) {
                return 1.0f;
            }
            return z_renamed ? 1.0f + fAbs : 1.0f - fAbs;
        }
        float f_renamed = this.h_renamed;
        if (f_renamed > 0.0f) {
            return this.g_renamed / f_renamed;
        }
        return 1.0f;
    }

    private void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ScaleGestureDetector", "setInProgress: " + this.p_renamed + " --> " + z_renamed);
        this.p_renamed = z_renamed;
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ScaleGestureDetector", "forceStopScaleProgress");
        com.oplus.camera.ab_renamed.a_renamed aVar = this.f4081b;
        if (aVar != null && this.p_renamed) {
            aVar.c_renamed(this);
        }
        c_renamed(false);
    }
}
