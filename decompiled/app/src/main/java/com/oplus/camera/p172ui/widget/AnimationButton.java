package com.oplus.camera.p172ui.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.ColorUtils;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIRoundRectUtil;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class AnimationButton extends AppCompatButton {

    /* renamed from: PlatformImplementations.kt_3 */
    private static String f22515a = "AnimationButton";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Interpolator f22516b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Interpolator f22517c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ValueAnimator f22518e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ValueAnimator f22519f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Paint f22520g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Rect f22521h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f22522i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f22523j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22524k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22525l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22526m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22527n;

    /* renamed from: o */
    private float f22528o;

    /* renamed from: p */
    private float f22529p;

    /* renamed from: q */
    private float f22530q;

    /* renamed from: r */
    private float f22531r;

    /* renamed from: s */
    private float f22532s;

    /* renamed from: t */
    private float[] f22533t;

    /* renamed from: u */
    private Context f22534u;

    public AnimationButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnimationButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AnimationButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22516b = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        this.f22517c = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f22518e = null;
        this.f22519f = null;
        this.f22520g = new Paint(1);
        this.f22521h = new Rect();
        this.f22522i = false;
        this.f22523j = false;
        this.f22524k = 1;
        this.f22525l = 0;
        this.f22526m = 0;
        this.f22527n = 0;
        this.f22528o = 21.0f;
        this.f22529p = 0.0f;
        this.f22530q = 0.0f;
        this.f22531r = 0.0f;
        this.f22532s = 0.0f;
        this.f22533t = new float[3];
        this.f22534u = null;
        this.f22530q = 1.0f;
        this.f22531r = 1.0f;
        this.f22532s = 1.0f;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f22527n = attributeSet.getStyleAttribute();
        } else {
            this.f22527n = OplusGLSurfaceView_13;
        }
        this.f22534u = context;
        COUIDarkModeUtil.m6400a(this, false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AnimationButton, OplusGLSurfaceView_13, 0);
        this.f22523j = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f22524k = typedArrayObtainStyledAttributes.getInteger(1, 1);
        if (this.f22523j) {
            this.f22529p = typedArrayObtainStyledAttributes.getFloat(2, 0.8f);
            this.f22528o = typedArrayObtainStyledAttributes.getDimension(5, 7.0f);
            this.f22526m = typedArrayObtainStyledAttributes.getColor(3, 0);
            this.f22525l = typedArrayObtainStyledAttributes.getColor(4, 0);
            m23924a();
        }
        typedArrayObtainStyledAttributes.recycle();
        COUIChangeTextUtil.m6390a(this, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23924a() {
        if (1 == this.f22524k) {
            setBackgroundDrawable((Drawable) null);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f22521h.right = getWidth();
        this.f22521h.bottom = getHeight();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f22523j) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (1 == this.f22524k) {
                this.f22520g.setColor(m23923a(this.f22525l));
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6451a(this.f22521h, this.f22528o), this.f22520g);
            }
            canvas.restoreToCount(iSave);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f22523j) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m23926a(true);
            } else if (action == 1 || action == 3) {
                m23926a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23926a(final boolean z) {
        this.f22522i = false;
        m23930b(z);
        if (this.f22522i) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f22530q;
        fArr[1] = z ? this.f22529p : 1.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 1.0f : this.f22531r;
        fArr2[1] = z ? 0.92f : 1.0f;
        this.f22518e = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f22518e.setInterpolator(this.f22516b);
        this.f22518e.setDuration(z ? 200L : 340L);
        this.f22518e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.AnimationButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationButton.this.f22531r = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                float duration = valueAnimator.getDuration() * 0.4f;
                if (AnimationButton.this.f22522i && z && valueAnimator.getCurrentPlayTime() > duration) {
                    valueAnimator.cancel();
                    AnimationButton.this.m23926a(false);
                } else {
                    AnimationButton.this.f22530q = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    AnimationButton animationButton = AnimationButton.this;
                    animationButton.setScale(animationButton.f22531r);
                }
            }
        });
        this.f22518e.start();
        float[] fArr3 = new float[2];
        fArr3[0] = z ? 1.0f : this.f22532s;
        fArr3[1] = z ? 2.0f : 1.0f;
        this.f22519f = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("alphaHolder", fArr3));
        this.f22519f.setInterpolator(this.f22517c);
        this.f22519f.setDuration(200L);
        this.f22519f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.AnimationButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationButton.this.f22532s = ((Float) valueAnimator.getAnimatedValue("alphaHolder")).floatValue();
            }
        });
        this.f22519f.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23930b(boolean z) {
        ValueAnimator valueAnimator = this.f22518e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f22522i = !z && ((float) this.f22518e.getCurrentPlayTime()) < ((float) this.f22518e.getDuration()) * 0.4f;
            if (!this.f22522i) {
                this.f22518e.cancel();
            }
        }
        ValueAnimator valueAnimator2 = this.f22519f;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f22522i = !z && ((float) this.f22519f.getCurrentPlayTime()) < ((float) this.f22519f.getDuration()) * 0.4f;
        if (this.f22522i) {
            return;
        }
        this.f22519f.cancel();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m23923a(int OplusGLSurfaceView_13) {
        if (!isEnabled()) {
            return this.f22526m;
        }
        ColorUtils.m2549a(OplusGLSurfaceView_13, this.f22533t);
        float[] fArr = this.f22533t;
        fArr[2] = fArr[2] * this.f22530q;
        int iM2547a = ColorUtils.m2547a(fArr);
        return Color.argb((int) (this.f22532s * Color.alpha(OplusGLSurfaceView_13)), Math.min(255, Color.red(iM2547a)), Math.min(255, Color.green(iM2547a)), Math.min(255, Color.blue(iM2547a)));
    }

    public void setAnimEnable(boolean z) {
        this.f22523j = z;
    }

    public void setAnimType(int OplusGLSurfaceView_13) {
        this.f22524k = OplusGLSurfaceView_13;
    }

    public void setDisabledColor(int OplusGLSurfaceView_13) {
        this.f22526m = OplusGLSurfaceView_13;
    }

    public void setDrawableColor(int OplusGLSurfaceView_13) {
        this.f22525l = OplusGLSurfaceView_13;
    }

    public void setDrawableRadius(int OplusGLSurfaceView_13) {
        this.f22528o = OplusGLSurfaceView_13;
    }

    public void setMaxBrightness(int OplusGLSurfaceView_13) {
        this.f22529p = OplusGLSurfaceView_13;
    }
}
