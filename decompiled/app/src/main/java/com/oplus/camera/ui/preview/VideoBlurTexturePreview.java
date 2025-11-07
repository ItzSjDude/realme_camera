package com.oplus.camera.ui.preview;

/* compiled from: TrackFocusView.java */
/* loaded from: classes2.dex */
public class ac_renamed extends android.widget.RelativeLayout implements com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed, com.oplus.camera.ui.preview.m_renamed {
    private boolean A_renamed;
    private int B_renamed;
    private java.lang.Runnable C_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Rect f6990a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.RectF f6991b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.RectF f6992c;
    private android.graphics.RectF d_renamed;
    private android.graphics.RectF e_renamed;
    private android.graphics.Paint f_renamed;
    private android.graphics.Matrix g_renamed;
    private int h_renamed;
    private float i_renamed;
    private float j_renamed;
    private float k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private float r_renamed;
    private int s_renamed;
    private com.oplus.camera.ui.preview.ExposureSeekbarContainer t_renamed;
    private android.animation.ObjectAnimator u_renamed;
    private android.animation.ObjectAnimator v_renamed;
    private android.animation.TimeInterpolator w_renamed;
    private com.oplus.camera.ui.preview.s_renamed x_renamed;
    private volatile int y_renamed;
    private volatile long z_renamed;

    @Override // com.oplus.camera.ui.preview.m_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n_renamed() {
        if (3 == this.y_renamed) {
            a_renamed(e_renamed());
        }
    }

    public ac_renamed(android.content.Context context) {
        super(context);
        this.f6990a = new android.graphics.Rect();
        this.f6991b = new android.graphics.RectF();
        this.f6992c = new android.graphics.RectF();
        this.d_renamed = new android.graphics.RectF();
        this.e_renamed = new android.graphics.RectF();
        this.f_renamed = new android.graphics.Paint();
        this.g_renamed = new android.graphics.Matrix();
        this.h_renamed = 0;
        this.i_renamed = 1.0f;
        this.j_renamed = 1.0f;
        this.k_renamed = 0.55f;
        this.l_renamed = false;
        this.m_renamed = true;
        this.n_renamed = false;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0.0f;
        this.s_renamed = 0;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = new android.view.animation.LinearInterpolator();
        this.x_renamed = null;
        this.y_renamed = 0;
        this.z_renamed = 0L;
        this.A_renamed = false;
        this.B_renamed = 0;
        this.C_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac_renamed$40H0SWpkIUCK3KXF3oihDw9ET3M
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.n_renamed();
            }
        };
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.f_renamed = new android.graphics.Paint(1);
        this.r_renamed = context.getResources().getDimension(com.oplus.camera.R_renamed.dimen.video_tracking_focus_frame_radius);
        this.f_renamed.setAntiAlias(true);
        this.f_renamed.setDither(true);
        this.f_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.f_renamed.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.f_renamed.setStrokeWidth(context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.track_focus_circle_stroke_width));
        this.f_renamed.setColor(com.oplus.camera.util.Util.A_renamed(context));
        setWillNotDraw(false);
        android.view.LayoutInflater.from(context).inflate(com.oplus.camera.R_renamed.layout.track_focus_layout, this);
        this.t_renamed = (com.oplus.camera.ui.preview.ExposureSeekbarContainer) findViewById(com.oplus.camera.R_renamed.id_renamed.exposure_seekbar_container);
        this.t_renamed.setOnSeekbarChangeListener(this);
        this.B_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_seekbar_margin);
        this.q_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_width);
        k_renamed();
    }

    public void setFocusManager(com.oplus.camera.ui.preview.s_renamed sVar) {
        this.x_renamed = sVar;
    }

    public void setZoomValue(float f_renamed) {
        this.i_renamed = f_renamed;
    }

    public void a_renamed(android.graphics.Rect rect, android.graphics.Rect rect2, android.util.Size size, android.util.Size size2) {
        com.oplus.camera.e_renamed.a_renamed("TrackFocusView", "initTrackRegionParams, cropRegion: " + rect + ", inputRegion: " + rect2 + ", trackHalAlgoSize: " + size);
        if (rect == null) {
            return;
        }
        this.f6990a = rect;
        if (size2 != null) {
            this.j_renamed = size2.getWidth() / this.f6990a.height();
        } else {
            this.j_renamed = com.oplus.camera.util.Util.getScreenWidth() / this.f6990a.height();
        }
        if (java.lang.Math.abs((size.getWidth() / size.getHeight()) - (this.f6990a.width() / this.f6990a.height())) > 0.01d) {
            this.n_renamed = true;
            this.o_renamed = this.f6990a.top;
            this.p_renamed = this.f6990a.height();
            return;
        }
        this.n_renamed = false;
    }

    public void setDisplayOrientation(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void a_renamed(int[] iArr) {
        if (iArr == null) {
            this.m_renamed = false;
            return;
        }
        if (this.l_renamed || this.m_renamed) {
            return;
        }
        b_renamed(iArr);
        if (2 == this.y_renamed && !this.d_renamed.isEmpty()) {
            this.e_renamed.setEmpty();
            this.z_renamed = 0L;
            this.y_renamed = 3;
        }
        if (3 != this.y_renamed) {
            return;
        }
        this.f6991b.set(this.d_renamed);
        post(this.C_renamed);
        postInvalidate();
    }

    private void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "fadeInOutSeekbar, fadeIn: " + z_renamed);
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimator = this.v_renamed;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.v_renamed.cancel();
            }
            if (this.u_renamed == null) {
                this.u_renamed = android.animation.ObjectAnimator.ofFloat(this.t_renamed, (android.util.Property<com.oplus.camera.ui.preview.ExposureSeekbarContainer, java.lang.Float>) ALPHA, 0.0f, 1.0f);
                this.u_renamed.setDuration(150L);
                this.u_renamed.setInterpolator(this.w_renamed);
            }
            if (this.u_renamed.isRunning()) {
                com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "fadeInOutSeekbar, mSeekbarFadeInAnimator is_renamed running.");
                return;
            }
            this.t_renamed.setVisibility(0);
            this.u_renamed.setFloatValues(this.t_renamed.getAlpha(), this.k_renamed);
            this.u_renamed.start();
            return;
        }
        android.animation.ObjectAnimator objectAnimator2 = this.u_renamed;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.u_renamed.cancel();
        }
        if (this.v_renamed == null) {
            this.v_renamed = android.animation.ObjectAnimator.ofFloat(this.t_renamed, (android.util.Property<com.oplus.camera.ui.preview.ExposureSeekbarContainer, java.lang.Float>) ALPHA, 1.0f, 0.0f);
            this.v_renamed.setDuration(150L);
            this.v_renamed.setInterpolator(this.w_renamed);
            this.v_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.ac_renamed.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.preview.ac_renamed.this.t_renamed.setVisibility(8);
                }
            });
        }
        if (this.v_renamed.isRunning()) {
            com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "fadeInOutSeekbar, mSeekbarFadeOutAnimator is_renamed running.");
        } else {
            this.v_renamed.setFloatValues(this.t_renamed.getAlpha(), 0.0f);
            this.v_renamed.start();
        }
    }

    private void b_renamed(int[] iArr) {
        if (this.n_renamed) {
            int i_renamed = iArr[1];
            int i2 = this.o_renamed;
            int i3 = i_renamed - i2;
            int i4 = iArr[3] - i2;
            android.graphics.RectF rectF = this.d_renamed;
            float f_renamed = iArr[0];
            if (i3 <= 0) {
                i3 = 0;
            }
            float f2 = i3;
            float f3 = iArr[2];
            int i5 = this.p_renamed;
            if (i4 < i5) {
                i5 = i4;
            }
            rectF.set(f_renamed, f2, f3, i5);
            return;
        }
        this.d_renamed.set(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            setVisibility(8);
            this.t_renamed.setVisibility(8);
        } else {
            post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac_renamed$Hxdc_daVzghpBU2wzaYssQCP7J8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.m_renamed();
                }
            });
        }
        this.l_renamed = true;
        this.m_renamed = true;
        h_renamed();
        this.y_renamed = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m_renamed() {
        setVisibility(8);
        this.t_renamed.setVisibility(8);
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "resume");
        setVisibility(0);
        setAlpha(0.55f);
        k_renamed();
        this.t_renamed.setToggleViewEnable(true);
        this.t_renamed.b_renamed(true);
        setLockState(this.x_renamed.I_renamed());
        this.l_renamed = false;
        this.y_renamed = 1;
    }

    public boolean d_renamed() {
        return getVisibility() == 0 && (this.t_renamed.getVisibility() == 0 || e_renamed());
    }

    public boolean e_renamed() {
        return !this.f6991b.isEmpty();
    }

    public boolean f_renamed() {
        return 2 == this.y_renamed && java.lang.System.currentTimeMillis() - this.z_renamed > 1000;
    }

    public void setLockState(boolean z_renamed) {
        this.t_renamed.setLockedState(z_renamed);
    }

    public void a_renamed(android.graphics.RectF rectF) {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "initDrawRect");
        this.e_renamed.set(rectF);
        a_renamed(true);
        postInvalidate();
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "cancelFadeInOutAnimation");
        android.animation.ObjectAnimator objectAnimator = this.u_renamed;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.v_renamed;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (!this.f6991b.isEmpty()) {
            this.g_renamed.reset();
            this.g_renamed.setTranslate((-this.f6990a.width()) / 2, (-this.f6990a.height()) / 2);
            this.g_renamed.postScale(1.0f, this.A_renamed ? -1.0f : 1.0f);
            this.g_renamed.postRotate(this.h_renamed);
            android.graphics.Matrix matrix = this.g_renamed;
            float f_renamed = this.j_renamed;
            float f2 = this.i_renamed;
            matrix.postScale(f_renamed * f2, f_renamed * f2);
            this.g_renamed.postTranslate(getWidth() / 2, getHeight() / 2);
            this.g_renamed.mapRect(this.f6992c, this.f6991b);
            android.graphics.RectF rectF = this.f6992c;
            rectF.inset((rectF.width() - this.q_renamed) / 2.0f, (this.f6992c.height() - this.q_renamed) / 2.0f);
        } else if (this.e_renamed.isEmpty()) {
            return;
        } else {
            this.f6992c.set(this.e_renamed);
        }
        b_renamed(this.f6992c);
        android.graphics.RectF rectF2 = this.f6992c;
        float f3 = this.r_renamed;
        canvas.drawRoundRect(rectF2, f3, f3, this.f_renamed);
    }

    private void b_renamed(android.graphics.RectF rectF) {
        if (rectF.right > getRight()) {
            rectF.right = getRight();
        } else if (rectF.right < 0.0f) {
            rectF.right = 0.0f;
        }
        if (rectF.left < getLeft()) {
            rectF.left = getLeft();
        } else if (rectF.left > getRight()) {
            rectF.left = getRight();
        }
        if (rectF.bottom > getBottom()) {
            rectF.bottom = getBottom();
        } else if (rectF.bottom < 0.0f) {
            rectF.bottom = 0.0f;
        }
        if (rectF.top > getBottom()) {
            rectF.top = getBottom();
        } else if (rectF.top < 0.0f) {
            rectF.top = 0.0f;
        }
    }

    public void h_renamed() {
        this.f6991b.setEmpty();
        this.d_renamed.setEmpty();
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            g_renamed();
            this.t_renamed.a_renamed(true);
            invalidate();
            return;
        }
        post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ac_renamed$yPty0RqQsX0Vzw0Tm9AtT3dj6b8
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.l_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l_renamed() {
        g_renamed();
        this.t_renamed.a_renamed(true);
        invalidate();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.s_renamed = i_renamed;
        k_renamed();
    }

    private void k_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.t_renamed.getLayoutParams();
        int i_renamed = this.B_renamed;
        layoutParams.setMargins(i_renamed, 0, i_renamed, 0);
        layoutParams.addRule(15);
        int i2 = this.s_renamed;
        if (i2 == 0 || i2 == 90) {
            layoutParams.removeRule(20);
            layoutParams.addRule(21);
        } else if (i2 == 180 || i2 == 270) {
            layoutParams.removeRule(21);
            layoutParams.addRule(20);
        }
        this.t_renamed.a_renamed(this.s_renamed, true);
        this.t_renamed.requestLayout();
    }

    public boolean i_renamed() {
        return this.t_renamed.isShown();
    }

    @Override // android.view.View
    public void setAlpha(float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TrackFocusView", "setAlpha, alpha:" + f_renamed);
        com.oplus.camera.ui.preview.ExposureSeekbarContainer exposureSeekbarContainer = this.t_renamed;
        if (exposureSeekbarContainer != null) {
            this.k_renamed = f_renamed;
            exposureSeekbarContainer.setAlpha(f_renamed);
        }
    }

    public void setMoveDistance(float f_renamed) {
        this.t_renamed.setMoveDistance(f_renamed);
    }

    @Override // com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed
    public void a_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.s_renamed sVar = this.x_renamed;
        if (sVar != null) {
            sVar.a_renamed(f_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.ExposureSeekbarContainer.a_renamed
    public void a_renamed() {
        setAlpha(1.0f);
        com.oplus.camera.ui.preview.s_renamed sVar = this.x_renamed;
        if (sVar != null) {
            sVar.H_renamed();
        }
    }

    public void j_renamed() {
        com.oplus.camera.e_renamed.b_renamed("TrackFocusView", "track, object searching.");
        this.y_renamed = 2;
        this.z_renamed = java.lang.System.currentTimeMillis();
    }

    public void setRearMirrorEnable(boolean z_renamed) {
        this.A_renamed = z_renamed;
    }

    public boolean getRearMirrorEnable() {
        return this.A_renamed;
    }
}
