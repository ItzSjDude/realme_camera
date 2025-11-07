package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class AISceneView extends android.widget.TextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.SweepGradient f6764a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.animation.PathInterpolator f6765b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.animation.PathInterpolator f6766c;
    private android.view.animation.PathInterpolator d_renamed;
    private android.view.animation.PathInterpolator e_renamed;
    private android.animation.AnimatorSet f_renamed;
    private android.animation.AnimatorSet g_renamed;
    private int[] h_renamed;
    private int i_renamed;
    private int j_renamed;
    private float k_renamed;
    private android.graphics.RectF l_renamed;
    private android.graphics.Matrix m_renamed;
    private android.graphics.Paint n_renamed;
    private int o_renamed;
    private int p_renamed;
    private android.content.Context q_renamed;
    private float r_renamed;

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public AISceneView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6764a = null;
        this.f6765b = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f6766c = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.d_renamed = new android.view.animation.PathInterpolator(0.27f, 0.05f, 0.06f, 1.0f);
        this.e_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f_renamed = new android.animation.AnimatorSet();
        this.g_renamed = new android.animation.AnimatorSet();
        this.h_renamed = null;
        this.i_renamed = 0;
        this.j_renamed = 255;
        this.k_renamed = 0.0f;
        this.l_renamed = new android.graphics.RectF();
        this.m_renamed = new android.graphics.Matrix();
        this.n_renamed = new android.graphics.Paint(1);
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = null;
        this.r_renamed = 2.0f;
        this.q_renamed = context;
        c_renamed();
    }

    private void c_renamed() {
        this.o_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ai_scene_outline_border_background_stroke_width);
        this.p_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ai_scene_background_radius);
        this.h_renamed = getResources().getIntArray(com.oplus.camera.R_renamed.array.ai_scene_text_function_enable_color);
        this.i_renamed = androidx.core.a_renamed.a_renamed.c_renamed(this.q_renamed, com.oplus.camera.R_renamed.color.ai_scene_text_function_disable_color);
        setTypeface(com.oplus.camera.util.Util.l_renamed(this.q_renamed));
        this.n_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.n_renamed.setStrokeWidth(this.o_renamed);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        this.f6764a = new android.graphics.SweepGradient(i_renamed / 2.0f, i2 / 2.0f, this.h_renamed, (float[]) null);
        android.graphics.RectF rectF = this.l_renamed;
        int i5 = this.o_renamed;
        float f_renamed = this.r_renamed;
        rectF.left = i5 - f_renamed;
        rectF.top = i5 - f_renamed;
        rectF.right = (i_renamed - i5) + f_renamed;
        rectF.bottom = (i2 - i5) + f_renamed;
    }

    public void a_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f6765b);
        objectAnimatorOfFloat.setDuration(250L);
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f6766c);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.AISceneView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.AISceneView.this.j_renamed = (int) (((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                com.oplus.camera.ui.preview.AISceneView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.AISceneView.2
            @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.preview.AISceneView.this.j_renamed = 255;
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(-540.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(this.d_renamed);
        valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.AISceneView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.preview.AISceneView.this.k_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.oplus.camera.ui.preview.AISceneView.this.invalidate();
            }
        });
        valueAnimatorOfFloat2.setDuration(1033L);
        this.f_renamed.play(valueAnimatorOfFloat2).with(valueAnimatorOfFloat).with(objectAnimatorOfFloat);
        this.f_renamed.addListener(animatorListener);
        this.f_renamed.start();
    }

    public void b_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.e_renamed);
        objectAnimatorOfFloat.setDuration(150L);
        this.g_renamed.play(objectAnimatorOfFloat);
        this.g_renamed.addListener(animatorListener);
        this.g_renamed.start();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.f6764a.setLocalMatrix(this.m_renamed);
        this.m_renamed.setRotate(this.k_renamed, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
        this.n_renamed.setShader(this.f6764a);
        this.n_renamed.setAlpha(this.j_renamed);
        android.graphics.RectF rectF = this.l_renamed;
        int i_renamed = this.p_renamed;
        canvas.drawRoundRect(rectF, i_renamed, i_renamed, this.n_renamed);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }

    public void a_renamed() {
        android.animation.AnimatorSet animatorSet = this.f_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f_renamed.cancel();
        }
        android.animation.AnimatorSet animatorSet2 = this.g_renamed;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            return;
        }
        this.g_renamed.cancel();
    }

    public boolean b_renamed() {
        android.animation.AnimatorSet animatorSet = this.g_renamed;
        return animatorSet != null && animatorSet.isRunning();
    }
}
