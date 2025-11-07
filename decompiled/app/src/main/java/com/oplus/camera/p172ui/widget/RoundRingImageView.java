package com.oplus.camera.p172ui.widget;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.widget.COUIAnimationListenerAdapter;
import com.oplus.camera.R;
import com.oplus.camera.doubleexposure.EffectType;
import com.oplus.camera.util.PressFeedbackHelper;

/* loaded from: classes2.dex */
public class RoundRingImageView extends AppCompatImageView implements View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap f22669a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f22670b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f22671c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Paint f22672d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f22673e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RectF f22674f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f22675g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f22676h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f22677i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f22678j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Context f22679k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f22680l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Interpolator f22681m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ValueAnimator f22682n;

    /* renamed from: o */
    private float f22683o;

    /* renamed from: p */
    private ValueAnimator f22684p;

    public RoundRingImageView(Context context) {
        super(context);
        this.f22670b = new Paint();
        this.f22671c = new Paint();
        this.f22672d = new Paint();
        this.f22673e = 0.0f;
        this.f22674f = new RectF();
        this.f22675g = 0.0f;
        this.f22676h = 0.0f;
        this.f22677i = false;
        this.f22678j = "";
        this.f22679k = null;
        this.f22680l = 0.0f;
        this.f22681m = null;
        this.f22682n = null;
        this.f22683o = 1.0f;
        this.f22684p = null;
        this.f22679k = context;
        m24032a();
    }

    public RoundRingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22670b = new Paint();
        this.f22671c = new Paint();
        this.f22672d = new Paint();
        this.f22673e = 0.0f;
        this.f22674f = new RectF();
        this.f22675g = 0.0f;
        this.f22676h = 0.0f;
        this.f22677i = false;
        this.f22678j = "";
        this.f22679k = null;
        this.f22680l = 0.0f;
        this.f22681m = null;
        this.f22682n = null;
        this.f22683o = 1.0f;
        this.f22684p = null;
        this.f22679k = context;
        m24032a();
    }

    public RoundRingImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22670b = new Paint();
        this.f22671c = new Paint();
        this.f22672d = new Paint();
        this.f22673e = 0.0f;
        this.f22674f = new RectF();
        this.f22675g = 0.0f;
        this.f22676h = 0.0f;
        this.f22677i = false;
        this.f22678j = "";
        this.f22679k = null;
        this.f22680l = 0.0f;
        this.f22681m = null;
        this.f22682n = null;
        this.f22683o = 1.0f;
        this.f22684p = null;
        this.f22679k = context;
        m24032a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24032a() {
        this.f22676h = this.f22679k.getResources().getDimension(R.dimen.effect_menu_text_size);
        this.f22675g = this.f22679k.getResources().getDimension(R.dimen.effect_menu_border_width);
        this.f22673e = this.f22679k.getResources().getDimension(R.dimen.effect_menu_inner_radius);
        this.f22680l = this.f22679k.getResources().getDimension(R.dimen.effect_menu_text_baseline);
        this.f22670b.setAntiAlias(true);
        this.f22672d.setAntiAlias(true);
        this.f22672d.setColor(-1);
        this.f22672d.setStrokeWidth(this.f22675g);
        this.f22672d.setStyle(Paint.Style.STROKE);
        this.f22671c.setAntiAlias(true);
        this.f22671c.setTextSize(this.f22676h);
        this.f22671c.setColor(-1);
        this.f22671c.setShadowLayer(getResources().getDimension(R.dimen.num_seekbar_text_shadow_blur), 0.0f, 0.0f, getResources().getColor(R.color.color_black_with_70_percent_transparency));
        this.f22681m = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        setOnTouchListener(this);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f22669a = bitmap;
        this.f22670b.setShader(new BitmapShader(this.f22669a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }

    public void setParam(EffectType c2687f) {
        if (c2687f != null) {
            setIsSelected(c2687f.m12926d());
            this.f22678j = c2687f.m12925c();
        }
        invalidate();
    }

    public void setIsSelected(boolean z) {
        boolean z2 = this.f22677i;
        this.f22677i = z;
        if (z2 != this.f22677i) {
            m24039d();
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f22670b.getShader() != null) {
            canvas.save();
            this.f22674f.set(getPaddingLeft() + this.f22675g, getPaddingTop() + this.f22675g, (getWidth() - getPaddingRight()) - this.f22675g, (getHeight() - getPaddingBottom()) - this.f22675g);
            RectF rectF = this.f22674f;
            float COUIBaseListPopupWindow_12 = this.f22673e;
            canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f22670b);
            if (this.f22677i) {
                this.f22674f.set(getPaddingLeft() + this.f22675g, getPaddingTop() + this.f22675g, (getWidth() - getPaddingRight()) - this.f22675g, (getHeight() - getPaddingBottom()) - this.f22675g);
                RectF rectF2 = this.f22674f;
                float f2 = this.f22673e;
                canvas.drawRoundRect(rectF2, f2, f2, this.f22672d);
            }
            canvas.drawText(this.f22678j, (getWidth() - this.f22671c.measureText(this.f22678j)) / 2.0f, getHeight() - this.f22680l, this.f22671c);
            canvas.restore();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24036b() {
        ValueAnimator valueAnimator = this.f22684p;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f22684p.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m24037c() {
        final float fM24601b = PressFeedbackHelper.m24601b(this);
        this.f22684p = PressFeedbackHelper.m24598a();
        this.f22684p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue() != null) {
                    RoundRingImageView.this.f22683o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float COUIBaseListPopupWindow_12 = RoundRingImageView.this.f22683o;
                    float f2 = fM24601b;
                    if (COUIBaseListPopupWindow_12 >= f2) {
                        RoundRingImageView.this.f22683o = f2;
                    }
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24034a(View view, final ValueAnimator valueAnimator) {
        view.clearAnimation();
        ScaleAnimation scaleAnimationM24599a = PressFeedbackHelper.m24599a(view);
        scaleAnimationM24599a.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                valueAnimator.start();
            }
        });
        view.startAnimation(scaleAnimationM24599a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24033a(View view, float COUIBaseListPopupWindow_12) {
        view.clearAnimation();
        view.startAnimation(PressFeedbackHelper.m24600a(view, COUIBaseListPopupWindow_12));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m24039d() {
        ValueAnimator valueAnimator = this.f22682n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f22682n.cancel();
        }
        int[] iArr = new int[2];
        iArr[0] = this.f22677i ? 0 : 255;
        iArr[1] = this.f22677i ? 255 : 0;
        this.f22682n = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("brightnessHolder", iArr));
        this.f22682n.setInterpolator(this.f22681m);
        this.f22682n.setDuration(200L);
        this.f22682n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (valueAnimator2.getAnimatedValue("brightnessHolder") != null) {
                    RoundRingImageView.this.f22672d.setAlpha(((Integer) valueAnimator2.getAnimatedValue("brightnessHolder")).intValue());
                    RoundRingImageView.this.invalidate();
                }
            }
        });
        this.f22682n.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.widget.RoundRingImageView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RoundRingImageView.this.f22672d.setAlpha(RoundRingImageView.this.f22677i ? 255 : 0);
                RoundRingImageView.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                RoundRingImageView.this.f22672d.setAlpha(RoundRingImageView.this.f22677i ? 255 : 0);
                RoundRingImageView.this.invalidate();
            }
        });
        this.f22682n.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                m24036b();
                m24037c();
                m24034a(this, this.f22684p);
            }
            if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
                m24036b();
                m24033a((View) this, this.f22683o);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
