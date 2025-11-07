package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class RoundRingImageView extends androidx.appcompat.widget.AppCompatImageView implements android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f7230a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f7231b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f7232c;
    private android.graphics.Paint d_renamed;
    private float e_renamed;
    private android.graphics.RectF f_renamed;
    private float g_renamed;
    private float h_renamed;
    private boolean i_renamed;
    private java.lang.String j_renamed;
    private android.content.Context k_renamed;
    private float l_renamed;
    private android.view.animation.Interpolator m_renamed;
    private android.animation.ValueAnimator n_renamed;
    private float o_renamed;
    private android.animation.ValueAnimator p_renamed;

    public RoundRingImageView(android.content.Context context) {
        super(context);
        this.f7231b = new android.graphics.Paint();
        this.f7232c = new android.graphics.Paint();
        this.d_renamed = new android.graphics.Paint();
        this.e_renamed = 0.0f;
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = 0.0f;
        this.h_renamed = 0.0f;
        this.i_renamed = false;
        this.j_renamed = "";
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = 1.0f;
        this.p_renamed = null;
        this.k_renamed = context;
        a_renamed();
    }

    public RoundRingImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7231b = new android.graphics.Paint();
        this.f7232c = new android.graphics.Paint();
        this.d_renamed = new android.graphics.Paint();
        this.e_renamed = 0.0f;
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = 0.0f;
        this.h_renamed = 0.0f;
        this.i_renamed = false;
        this.j_renamed = "";
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = 1.0f;
        this.p_renamed = null;
        this.k_renamed = context;
        a_renamed();
    }

    public RoundRingImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7231b = new android.graphics.Paint();
        this.f7232c = new android.graphics.Paint();
        this.d_renamed = new android.graphics.Paint();
        this.e_renamed = 0.0f;
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = 0.0f;
        this.h_renamed = 0.0f;
        this.i_renamed = false;
        this.j_renamed = "";
        this.k_renamed = null;
        this.l_renamed = 0.0f;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = 1.0f;
        this.p_renamed = null;
        this.k_renamed = context;
        a_renamed();
    }

    private void a_renamed() {
        this.h_renamed = this.k_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_text_size);
        this.g_renamed = this.k_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_border_width);
        this.e_renamed = this.k_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_inner_radius);
        this.l_renamed = this.k_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_text_baseline);
        this.f7231b.setAntiAlias(true);
        this.d_renamed.setAntiAlias(true);
        this.d_renamed.setColor(-1);
        this.d_renamed.setStrokeWidth(this.g_renamed);
        this.d_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.f7232c.setAntiAlias(true);
        this.f7232c.setTextSize(this.h_renamed);
        this.f7232c.setColor(-1);
        this.f7232c.setShadowLayer(getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_text_shadow_blur), 0.0f, 0.0f, getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_70_percent_transparency));
        this.m_renamed = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        setOnTouchListener(this);
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.f7230a = bitmap;
        this.f7231b.setShader(new android.graphics.BitmapShader(this.f7230a, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
    }

    public void setParam(com.oplus.camera.doubleexposure.f_renamed fVar) {
        if (fVar != null) {
            setIsSelected(fVar.d_renamed());
            this.j_renamed = fVar.c_renamed();
        }
        invalidate();
    }

    public void setIsSelected(boolean z_renamed) {
        boolean z2 = this.i_renamed;
        this.i_renamed = z_renamed;
        if (z2 != this.i_renamed) {
            d_renamed();
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.f7231b.getShader() != null) {
            canvas.save();
            this.f_renamed.set(getPaddingLeft() + this.g_renamed, getPaddingTop() + this.g_renamed, (getWidth() - getPaddingRight()) - this.g_renamed, (getHeight() - getPaddingBottom()) - this.g_renamed);
            android.graphics.RectF rectF = this.f_renamed;
            float f_renamed = this.e_renamed;
            canvas.drawRoundRect(rectF, f_renamed, f_renamed, this.f7231b);
            if (this.i_renamed) {
                this.f_renamed.set(getPaddingLeft() + this.g_renamed, getPaddingTop() + this.g_renamed, (getWidth() - getPaddingRight()) - this.g_renamed, (getHeight() - getPaddingBottom()) - this.g_renamed);
                android.graphics.RectF rectF2 = this.f_renamed;
                float f2 = this.e_renamed;
                canvas.drawRoundRect(rectF2, f2, f2, this.d_renamed);
            }
            canvas.drawText(this.j_renamed, (getWidth() - this.f7232c.measureText(this.j_renamed)) / 2.0f, getHeight() - this.l_renamed, this.f7232c);
            canvas.restore();
        }
    }

    private void b_renamed() {
        android.animation.ValueAnimator valueAnimator = this.p_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.p_renamed.cancel();
    }

    private void c_renamed() {
        final float fB_renamed = com.oplus.camera.util.l_renamed.b_renamed(this);
        this.p_renamed = com.oplus.camera.util.l_renamed.a_renamed();
        this.p_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue() != null) {
                    com.oplus.camera.ui.widget.RoundRingImageView.this.o_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f_renamed = com.oplus.camera.ui.widget.RoundRingImageView.this.o_renamed;
                    float f2 = fB_renamed;
                    if (f_renamed >= f2) {
                        com.oplus.camera.ui.widget.RoundRingImageView.this.o_renamed = f2;
                    }
                }
            }
        });
    }

    private void a_renamed(android.view.View view, final android.animation.ValueAnimator valueAnimator) {
        view.clearAnimation();
        android.view.animation.ScaleAnimation scaleAnimationA = com.oplus.camera.util.l_renamed.a_renamed(view);
        scaleAnimationA.setAnimationListener(new com.coui.appcompat.widget.b_renamed() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                valueAnimator.start();
            }
        });
        view.startAnimation(scaleAnimationA);
    }

    private void a_renamed(android.view.View view, float f_renamed) {
        view.clearAnimation();
        view.startAnimation(com.oplus.camera.util.l_renamed.a_renamed(view, f_renamed));
    }

    private void d_renamed() {
        android.animation.ValueAnimator valueAnimator = this.n_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.n_renamed.cancel();
        }
        int[] iArr = new int[2];
        iArr[0] = this.i_renamed ? 0 : 255;
        iArr[1] = this.i_renamed ? 255 : 0;
        this.n_renamed = android.animation.ValueAnimator.ofPropertyValuesHolder(android.animation.PropertyValuesHolder.ofInt("brightnessHolder", iArr));
        this.n_renamed.setInterpolator(this.m_renamed);
        this.n_renamed.setDuration(200L);
        this.n_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                if (valueAnimator2.getAnimatedValue("brightnessHolder") != null) {
                    com.oplus.camera.ui.widget.RoundRingImageView.this.d_renamed.setAlpha(((java.lang.Integer) valueAnimator2.getAnimatedValue("brightnessHolder")).intValue());
                    com.oplus.camera.ui.widget.RoundRingImageView.this.invalidate();
                }
            }
        });
        this.n_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.widget.RoundRingImageView.this.d_renamed.setAlpha(com.oplus.camera.ui.widget.RoundRingImageView.this.i_renamed ? 255 : 0);
                com.oplus.camera.ui.widget.RoundRingImageView.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.widget.RoundRingImageView.this.d_renamed.setAlpha(com.oplus.camera.ui.widget.RoundRingImageView.this.i_renamed ? 255 : 0);
                com.oplus.camera.ui.widget.RoundRingImageView.this.invalidate();
            }
        });
        this.n_renamed.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                b_renamed();
                c_renamed();
                a_renamed(this, this.p_renamed);
            }
            if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                b_renamed();
                a_renamed((android.view.View) this, this.o_renamed);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
