package com.oplus.camera.ui.menu.setting.down;

/* loaded from: classes2.dex */
public class ArrowView extends android.view.View implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f6619a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6620b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f6621c;
    private float d_renamed;
    private android.graphics.Path e_renamed;
    private int f_renamed;
    private android.graphics.BlurMaskFilter g_renamed;
    private android.graphics.PorterDuffXfermode h_renamed;
    private android.animation.ValueAnimator i_renamed;
    private android.animation.ValueAnimator j_renamed;
    private android.animation.ValueAnimator k_renamed;
    private android.animation.AnimatorSet l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private float q_renamed;
    private float r_renamed;
    private com.oplus.camera.ui.menu.setting.down.ArrowView.a_renamed s_renamed;

    public ArrowView(android.content.Context context) {
        this(context, null);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6619a = null;
        this.f6620b = 0.0f;
        this.f6621c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = null;
        this.f_renamed = 0;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = true;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = 0.0f;
        this.r_renamed = 0.0f;
        this.s_renamed = null;
        a_renamed(attributeSet);
    }

    private void a_renamed(android.util.AttributeSet attributeSet) {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.DrawerLayout, 0, 0);
            this.f_renamed = typedArrayObtainStyledAttributes.getColor(0, -7829368);
            this.f6620b = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            this.d_renamed = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.e_renamed = new android.graphics.Path();
        this.f6621c = new android.graphics.Paint();
        this.f6621c.setStyle(android.graphics.Paint.Style.STROKE);
        this.f6621c.setAntiAlias(true);
        this.f6621c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.f6621c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.g_renamed = new android.graphics.BlurMaskFilter(4.0f, android.graphics.BlurMaskFilter.Blur.SOLID);
        this.h_renamed = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.XOR);
        this.s_renamed = new com.oplus.camera.ui.menu.setting.down.ArrowView.a_renamed(this, null);
        setLayerType(1, null);
        this.f6621c.setColor(this.f_renamed);
        this.f6621c.setStrokeWidth(this.f6620b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        if (i_renamed <= 0 || i2 <= 0) {
            return;
        }
        this.r_renamed = (i_renamed - (this.d_renamed * 2.0f)) / 8.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        float measuredWidth = getMeasuredWidth() >> 1;
        this.e_renamed.moveTo(measuredWidth - 28.0f, this.f6620b / 2.0f);
        this.e_renamed.lineTo(measuredWidth + 28.0f, this.f6620b / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.n_renamed) {
            this.f6621c.setColor(-12303292);
            this.f6621c.setMaskFilter(this.g_renamed);
            canvas.drawPath(this.e_renamed, this.f6621c);
            this.f6621c.setMaskFilter(null);
            this.f6621c.setXfermode(this.h_renamed);
            canvas.drawPath(this.e_renamed, this.f6621c);
            this.f6621c.setXfermode(null);
        }
        this.f6621c.setColor(this.f_renamed);
        canvas.drawPath(this.e_renamed, this.f6621c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.e_renamed.reset();
        this.m_renamed = 0.0f == f_renamed;
        float f2 = measuredWidth >> 1;
        float f3 = measuredHeight >> 1;
        this.e_renamed.moveTo(f2 - 28.0f, f3);
        this.e_renamed.lineTo(f2 + 28.0f, f3);
        invalidate();
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.down.ArrowView$1, reason: invalid class name */
    class SceneLoader_2 implements android.animation.ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.camera.ui.menu.setting.down.ArrowView f6622a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            this.f6622a.b_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(float f_renamed) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = (((measuredWidth - (this.d_renamed * 2.0f)) / 8.0f) / 2.0f) * f_renamed;
        int iSqrt = (int) java.lang.Math.sqrt(java.lang.Math.pow(r2 / 4.0f, 2.0d) - java.lang.Math.pow(f2, 2.0d));
        this.e_renamed.reset();
        float f3 = (measuredHeight / 2) + ((measuredHeight / 3) * f_renamed);
        int i_renamed = measuredWidth / 2;
        float f4 = i_renamed - (iSqrt * 2);
        float f5 = f3 - f2;
        this.e_renamed.moveTo(f4, f5);
        this.e_renamed.lineTo(f4, f5);
        this.e_renamed.lineTo(i_renamed, f3 + f2);
        this.e_renamed.lineTo(i_renamed + r2, f5);
        invalidate();
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.n_renamed = z_renamed;
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.AnimatorSet animatorSet = this.l_renamed;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.l_renamed.cancel();
            this.l_renamed = null;
        }
    }

    private class a_renamed implements android.animation.ValueAnimator.AnimatorUpdateListener {
        private a_renamed() {
        }

        /* synthetic */ a_renamed(com.oplus.camera.ui.menu.setting.down.ArrowView arrowView, com.oplus.camera.ui.menu.setting.down.ArrowView.SceneLoader_2 anonymousClass1) {
            this();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.oplus.camera.ui.menu.setting.down.ArrowView.this.q_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.oplus.camera.ui.menu.setting.down.ArrowView arrowView = com.oplus.camera.ui.menu.setting.down.ArrowView.this;
            arrowView.a_renamed(arrowView.q_renamed);
        }
    }
}
