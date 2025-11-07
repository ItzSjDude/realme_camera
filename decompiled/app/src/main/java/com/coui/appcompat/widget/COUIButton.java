package com.coui.appcompat.widget;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.ColorUtils;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIRoundRectUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIButton extends AppCompatButton {

    /* renamed from: PlatformImplementations.kt_3 */
    private static String f7116a = "COUIButton";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Interpolator f7117b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ValueAnimator f7118c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f7119e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f7120f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7121g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Paint f7122h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7123i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7124j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f7125k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f7126l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f7127m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f7128n;

    /* renamed from: o */
    private float f7129o;

    /* renamed from: p */
    private float f7130p;

    /* renamed from: q */
    private int f7131q;

    /* renamed from: r */
    private Rect f7132r;

    /* renamed from: s */
    private Rect f7133s;

    /* renamed from: t */
    private float[] f7134t;

    /* renamed from: u */
    private int f7135u;

    public COUIButton(Context context) {
        this(context, null);
    }

    public COUIButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public COUIButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7122h = new Paint(1);
        this.f7125k = 21.0f;
        this.f7127m = 1.0f;
        this.f7128n = 1.0f;
        this.f7132r = new Rect();
        this.f7133s = new Rect();
        this.f7134t = new float[3];
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7135u = attributeSet.getStyleAttribute();
        } else {
            this.f7135u = OplusGLSurfaceView_13;
        }
        COUIDarkModeUtil.m6400a(this, false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIButton, OplusGLSurfaceView_13, 0);
        this.f7120f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIButton_animEnable, false);
        this.f7121g = typedArrayObtainStyledAttributes.getInteger(R.styleable.COUIButton_animType, 1);
        if (this.f7120f) {
            this.f7126l = typedArrayObtainStyledAttributes.getFloat(R.styleable.COUIButton_brightness, 0.8f);
            this.f7125k = typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIButton_drawableRadius, 7.0f);
            this.f7124j = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIButton_disabledColor, 0);
            this.f7123i = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIButton_drawableColor, 0);
            this.f7131q = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIButton_strokeColor, 0);
            m6994a();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f7129o = context.getResources().getDimension(R.dimen.coui_bordless_btn_stroke_width);
        this.f7130p = getResources().getDimension(R.dimen.coui_button_radius_offset);
        COUIChangeTextUtil.m6390a(this, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6994a() {
        if (this.f7121g == 1) {
            setBackgroundDrawable(null);
        }
        this.f7117b = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f7132r.right = getWidth();
        this.f7132r.bottom = getHeight();
        this.f7133s.top = (int) (this.f7132r.top + (this.f7129o / 2.0f));
        this.f7133s.left = (int) (this.f7132r.left + (this.f7129o / 2.0f));
        this.f7133s.right = (int) (this.f7132r.right - (this.f7129o / 2.0f));
        this.f7133s.bottom = (int) (this.f7132r.bottom - (this.f7129o / 2.0f));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7120f) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f7121g == 1) {
                this.f7122h.setStyle(Paint.Style.FILL);
                this.f7122h.setColor(m6993a(this.f7123i));
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6451a(this.f7132r, ((this.f7132r.bottom - this.f7132r.top) / 2.0f) - this.f7130p), this.f7122h);
            } else {
                this.f7122h.setColor(isEnabled() ? this.f7131q : this.f7124j);
                this.f7122h.setStrokeWidth(this.f7129o);
                this.f7122h.setStyle(Paint.Style.STROKE);
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6451a(this.f7133s, ((r2.bottom - this.f7133s.top) / 2.0f) - this.f7129o), this.f7122h);
            }
            canvas.restoreToCount(iSave);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f7120f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                m6996a(true);
            } else if (action == 1 || action == 3) {
                m6996a(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6996a(final boolean z) {
        this.f7119e = false;
        m7000b(z);
        if (this.f7119e) {
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : this.f7127m;
        fArr[1] = z ? this.f7126l : 1.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("brightnessHolder", fArr);
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 1.0f : this.f7128n;
        fArr2[1] = z ? 0.92f : 1.0f;
        this.f7118c = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("scaleHolder", fArr2));
        this.f7118c.setInterpolator(this.f7117b);
        this.f7118c.setDuration(z ? 200L : 340L);
        this.f7118c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIButton.this.f7128n = ((Float) valueAnimator.getAnimatedValue("scaleHolder")).floatValue();
                if (COUIButton.this.f7119e && z && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration() * 0.4f) {
                    valueAnimator.cancel();
                    COUIButton.this.m6996a(false);
                } else {
                    COUIButton.this.f7127m = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
                    COUIButton cOUIButton = COUIButton.this;
                    cOUIButton.setScale(cOUIButton.f7128n);
                }
            }
        });
        this.f7118c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScale(float COUIBaseListPopupWindow_12) {
        float fMax = Math.max(0.92f, Math.min(1.0f, COUIBaseListPopupWindow_12));
        setScaleX(fMax);
        setScaleY(fMax);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7000b(boolean z) {
        ValueAnimator valueAnimator = this.f7118c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f7119e = !z && ((float) this.f7118c.getCurrentPlayTime()) < ((float) this.f7118c.getDuration()) * 0.4f;
        if (this.f7119e) {
            return;
        }
        this.f7118c.cancel();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6993a(int OplusGLSurfaceView_13) {
        if (!isEnabled()) {
            return this.f7124j;
        }
        ColorUtils.m2549a(OplusGLSurfaceView_13, this.f7134t);
        float[] fArr = this.f7134t;
        fArr[2] = fArr[2] * this.f7127m;
        int iM2547a = ColorUtils.m2547a(fArr);
        return Color.argb(Color.alpha(OplusGLSurfaceView_13), Math.min(255, Color.red(iM2547a)), Math.min(255, Color.green(iM2547a)), Math.min(255, Color.blue(iM2547a)));
    }

    public void setAnimEnable(boolean z) {
        this.f7120f = z;
    }

    public void setAnimType(int OplusGLSurfaceView_13) {
        this.f7121g = OplusGLSurfaceView_13;
    }

    public void setDisabledColor(int OplusGLSurfaceView_13) {
        this.f7124j = OplusGLSurfaceView_13;
    }

    public void setDrawableColor(int OplusGLSurfaceView_13) {
        this.f7123i = OplusGLSurfaceView_13;
    }

    public void setDrawableRadius(int OplusGLSurfaceView_13) {
        this.f7125k = OplusGLSurfaceView_13;
    }

    public void setMaxBrightness(int OplusGLSurfaceView_13) {
        this.f7126l = OplusGLSurfaceView_13;
    }
}
