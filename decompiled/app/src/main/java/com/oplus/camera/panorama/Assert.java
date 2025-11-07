package com.oplus.camera.panorama;

/* loaded from: classes2.dex */
public class FrontPanoramaGuideView extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Path f4927a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f4928b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4929c;
    private android.graphics.PathMeasure d_renamed;
    private float e_renamed;
    private float f_renamed;
    private float[] g_renamed;
    private float[] h_renamed;
    private android.graphics.RectF i_renamed;
    private android.graphics.Path j_renamed;
    private float k_renamed;
    private float l_renamed;
    private int m_renamed;
    private int n_renamed;
    private android.graphics.Bitmap o_renamed;
    private int p_renamed;
    private com.oplus.camera.panorama.c_renamed q_renamed;
    private com.oplus.camera.panorama.c_renamed r_renamed;
    private com.oplus.camera.panorama.c_renamed s_renamed;
    private android.animation.ValueAnimator t_renamed;
    private com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed u_renamed;
    private java.lang.Runnable v_renamed;

    public interface a_renamed {
        void a_renamed(int i_renamed);
    }

    private float a_renamed(float f_renamed) {
        return (float) ((f_renamed * 3.141592653589793d) / 180.0d);
    }

    public FrontPanoramaGuideView(android.content.Context context) {
        super(context);
        this.f4927a = null;
        this.f4928b = null;
        this.f4929c = true;
        this.d_renamed = null;
        this.e_renamed = 100.0f;
        this.f_renamed = 50.0f;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 30.0f;
        this.l_renamed = 5.0f;
        this.m_renamed = -256;
        this.n_renamed = 40;
        this.o_renamed = null;
        this.p_renamed = 1;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed == null || com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.isRunning()) {
                    return;
                }
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.b_renamed() != com.oplus.camera.panorama.FrontPanoramaGuideView.this.p_renamed) {
                    com.oplus.camera.panorama.FrontPanoramaGuideView.this.e_renamed();
                }
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.a_renamed();
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.start();
            }
        };
    }

    public FrontPanoramaGuideView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4927a = null;
        this.f4928b = null;
        this.f4929c = true;
        this.d_renamed = null;
        this.e_renamed = 100.0f;
        this.f_renamed = 50.0f;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 30.0f;
        this.l_renamed = 5.0f;
        this.m_renamed = -256;
        this.n_renamed = 40;
        this.o_renamed = null;
        this.p_renamed = 1;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed == null || com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.isRunning()) {
                    return;
                }
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.b_renamed() != com.oplus.camera.panorama.FrontPanoramaGuideView.this.p_renamed) {
                    com.oplus.camera.panorama.FrontPanoramaGuideView.this.e_renamed();
                }
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.a_renamed();
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.start();
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.FrontPanoramaGuideView);
        this.k_renamed = typedArrayObtainStyledAttributes.getDimension(0, this.k_renamed);
        this.l_renamed = typedArrayObtainStyledAttributes.getDimension(2, this.l_renamed);
        this.e_renamed = typedArrayObtainStyledAttributes.getDimension(3, this.e_renamed);
        this.f_renamed = typedArrayObtainStyledAttributes.getDimension(4, this.f_renamed);
        this.m_renamed = typedArrayObtainStyledAttributes.getColor(1, -256);
        typedArrayObtainStyledAttributes.recycle();
        c_renamed();
    }

    public FrontPanoramaGuideView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f4927a = null;
        this.f4928b = null;
        this.f4929c = true;
        this.d_renamed = null;
        this.e_renamed = 100.0f;
        this.f_renamed = 50.0f;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 30.0f;
        this.l_renamed = 5.0f;
        this.m_renamed = -256;
        this.n_renamed = 40;
        this.o_renamed = null;
        this.p_renamed = 1;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed == null || com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.isRunning()) {
                    return;
                }
                if (com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.b_renamed() != com.oplus.camera.panorama.FrontPanoramaGuideView.this.p_renamed) {
                    com.oplus.camera.panorama.FrontPanoramaGuideView.this.e_renamed();
                }
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.a_renamed();
                com.oplus.camera.panorama.FrontPanoramaGuideView.this.t_renamed.start();
            }
        };
    }

    public void setOnDirectionChangeListener(com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed aVar) {
        this.u_renamed = aVar;
    }

    private void c_renamed() {
        this.f4928b = new android.graphics.Paint();
        this.f4928b.setAntiAlias(true);
        this.f4928b.setDither(true);
        this.f4928b.setStyle(android.graphics.Paint.Style.STROKE);
        this.f4928b.setColor(this.m_renamed);
        this.f4928b.setStrokeWidth(this.l_renamed);
        this.f4928b.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.f4928b.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.f4927a = new android.graphics.Path();
        this.g_renamed = new float[2];
        this.h_renamed = new float[2];
        this.d_renamed = new android.graphics.PathMeasure(this.f4927a, false);
        float fA_renamed = a_renamed(this.n_renamed);
        this.j_renamed = new android.graphics.Path();
        double d_renamed = fA_renamed;
        this.j_renamed.setLastPoint(-((float) (this.k_renamed * java.lang.Math.cos(d_renamed))), (float) (this.k_renamed * java.lang.Math.sin(d_renamed)));
        this.j_renamed.lineTo(0.0f, 0.0f);
        this.j_renamed.lineTo(-((float) (this.k_renamed * java.lang.Math.cos(d_renamed))), -((float) (this.k_renamed * java.lang.Math.sin(d_renamed))));
        this.o_renamed = android.graphics.BitmapFactory.decodeResource(getResources(), com.oplus.camera.R_renamed.drawable.front_panorama_guide_phone_icon);
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaGuideView", "startAnimation, direction: " + i_renamed);
        this.p_renamed = i_renamed;
        e_renamed();
        this.f4929c = false;
        if (this.t_renamed == null) {
            this.t_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.t_renamed.setDuration(820L);
            this.t_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.43f, 0.0f, 0.42f, 1.0f));
            this.t_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.panorama.FrontPanoramaGuideView.this.s_renamed.a_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                    com.oplus.camera.panorama.FrontPanoramaGuideView.this.invalidate();
                }
            });
            this.t_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.FrontPanoramaGuideView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.panorama.FrontPanoramaGuideView frontPanoramaGuideView = com.oplus.camera.panorama.FrontPanoramaGuideView.this;
                    frontPanoramaGuideView.removeCallbacks(frontPanoramaGuideView.v_renamed);
                    com.oplus.camera.panorama.FrontPanoramaGuideView frontPanoramaGuideView2 = com.oplus.camera.panorama.FrontPanoramaGuideView.this;
                    frontPanoramaGuideView2.postDelayed(frontPanoramaGuideView2.v_renamed, 680L);
                }
            });
            this.t_renamed.start();
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaGuideView", "stopAnimation");
        this.f4929c = true;
        removeCallbacks(this.v_renamed);
        android.animation.ValueAnimator valueAnimator = this.t_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t_renamed = null;
        }
    }

    public void setNextDirection(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    public void b_renamed() {
        android.graphics.Bitmap bitmap = this.o_renamed;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.o_renamed.recycle();
            this.o_renamed = null;
        }
        this.f4929c = true;
    }

    public java.lang.String getCurrentGuideTips() {
        com.oplus.camera.panorama.c_renamed cVar = this.s_renamed;
        return cVar != null ? cVar.a_renamed(getContext()) : "";
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        d_renamed();
        if (this.f4929c) {
            return;
        }
        canvas.drawBitmap(this.o_renamed, this.s_renamed.a_renamed(this.o_renamed.getWidth(), this.o_renamed.getHeight(), getWidth(), getHeight()), this.f4928b);
        this.f4927a.reset();
        this.f4927a.addArc(this.i_renamed, this.s_renamed.d_renamed(), this.s_renamed.e_renamed());
        canvas.drawPath(this.f4927a, this.f4928b);
        this.d_renamed.setPath(this.f4927a, false);
        this.d_renamed.getPosTan(this.s_renamed.b_renamed(this.d_renamed.getLength()), this.g_renamed, this.h_renamed);
        float[] fArr = this.h_renamed;
        float fC_renamed = this.s_renamed.c_renamed((float) ((java.lang.Math.atan2(fArr[1], fArr[0]) * 180.0d) / 3.141592653589793d));
        canvas.save();
        float[] fArr2 = this.g_renamed;
        canvas.rotate(fC_renamed, fArr2[0], fArr2[1]);
        canvas.save();
        float[] fArr3 = this.g_renamed;
        canvas.translate(fArr3[0], fArr3[1]);
        canvas.drawPath(this.j_renamed, this.f4928b);
        canvas.restore();
        canvas.restore();
    }

    private void d_renamed() {
        if (this.i_renamed == null) {
            float width = (getWidth() - (this.e_renamed * 2.0f)) / 2.0f;
            float height = (getHeight() / 2) - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.front_panorama_guide_ellipse_margin_top_by_center);
            this.i_renamed = new android.graphics.RectF(width, height, (this.e_renamed * 2.0f) + width, (this.f_renamed * 2.0f) + height);
            com.oplus.camera.e_renamed.a_renamed("FrontPanoramaGuideView", "initEllipseRect, mEllipseRect: " + this.i_renamed);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        if (i_renamed != getVisibility()) {
            if (i_renamed == 8 || i_renamed == 4) {
                a_renamed();
            } else {
                a_renamed(this.p_renamed);
            }
        }
        super.setVisibility(i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FrontPanoramaGuideView", "changeDirectionMode, mNextDirection: " + this.p_renamed);
        int i_renamed = this.p_renamed;
        if (i_renamed == 0) {
            if (this.q_renamed == null) {
                this.q_renamed = new com.oplus.camera.panorama.b_renamed(getContext());
            }
            this.s_renamed = this.q_renamed;
        } else if (i_renamed == 1) {
            if (this.r_renamed == null) {
                this.r_renamed = new com.oplus.camera.panorama.a_renamed(getContext());
            }
            this.s_renamed = this.r_renamed;
        }
        com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed aVar = this.u_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.s_renamed.b_renamed());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4929c = true;
    }
}
