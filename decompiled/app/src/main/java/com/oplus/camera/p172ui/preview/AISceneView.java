package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class AISceneView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private SweepGradient f20668a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PathInterpolator f20669b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PathInterpolator f20670c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PathInterpolator f20671d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathInterpolator f20672e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private AnimatorSet f20673f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AnimatorSet f20674g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f20675h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20676i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f20677j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f20678k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RectF f20679l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Matrix f20680m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Paint f20681n;

    /* renamed from: o */
    private int f20682o;

    /* renamed from: p */
    private int f20683p;

    /* renamed from: q */
    private Context f20684q;

    /* renamed from: r */
    private float f20685r;

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public AISceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20668a = null;
        this.f20669b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20670c = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20671d = new PathInterpolator(0.27f, 0.05f, 0.06f, 1.0f);
        this.f20672e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20673f = new AnimatorSet();
        this.f20674g = new AnimatorSet();
        this.f20675h = null;
        this.f20676i = 0;
        this.f20677j = 255;
        this.f20678k = 0.0f;
        this.f20679l = new RectF();
        this.f20680m = new Matrix();
        this.f20681n = new Paint(1);
        this.f20682o = 0;
        this.f20683p = 0;
        this.f20684q = null;
        this.f20685r = 2.0f;
        this.f20684q = context;
        m22064c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22064c() {
        this.f20682o = getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_outline_border_background_stroke_width);
        this.f20683p = getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_background_radius);
        this.f20675h = getResources().getIntArray(R.array.ai_scene_text_function_enable_color);
        this.f20676i = ContextCompat.m2254c(this.f20684q, R.color.ai_scene_text_function_disable_color);
        setTypeface(Util.m24473l(this.f20684q));
        this.f20681n.setStyle(Paint.Style.STROKE);
        this.f20681n.setStrokeWidth(this.f20682o);
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        this.f20668a = new SweepGradient(OplusGLSurfaceView_13 / 2.0f, i2 / 2.0f, this.f20675h, (float[]) null);
        RectF rectF = this.f20679l;
        int i5 = this.f20682o;
        float COUIBaseListPopupWindow_12 = this.f20685r;
        rectF.left = i5 - COUIBaseListPopupWindow_12;
        rectF.top = i5 - COUIBaseListPopupWindow_12;
        rectF.right = (OplusGLSurfaceView_13 - i5) + COUIBaseListPopupWindow_12;
        rectF.bottom = (i2 - i5) + COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22066a(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20669b);
        objectAnimatorOfFloat.setDuration(250L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f20670c);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.AISceneView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AISceneView.this.f20677j = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                AISceneView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.AISceneView.2
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AISceneView.this.f20677j = 255;
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(-540.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(this.f20671d);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.AISceneView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AISceneView.this.f20678k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AISceneView.this.invalidate();
            }
        });
        valueAnimatorOfFloat2.setDuration(1033L);
        this.f20673f.play(valueAnimatorOfFloat2).with(valueAnimatorOfFloat).with(objectAnimatorOfFloat);
        this.f20673f.addListener(animatorListener);
        this.f20673f.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22067b(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f20672e);
        objectAnimatorOfFloat.setDuration(150L);
        this.f20674g.play(objectAnimatorOfFloat);
        this.f20674g.addListener(animatorListener);
        this.f20674g.start();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f20668a.setLocalMatrix(this.f20680m);
        this.f20680m.setRotate(this.f20678k, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
        this.f20681n.setShader(this.f20668a);
        this.f20681n.setAlpha(this.f20677j);
        RectF rectF = this.f20679l;
        int OplusGLSurfaceView_13 = this.f20683p;
        canvas.drawRoundRect(rectF, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f20681n);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22065a() {
        AnimatorSet animatorSet = this.f20673f;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f20673f.cancel();
        }
        AnimatorSet animatorSet2 = this.f20674g;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            return;
        }
        this.f20674g.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m22068b() {
        AnimatorSet animatorSet = this.f20674g;
        return animatorSet != null && animatorSet.isRunning();
    }
}
