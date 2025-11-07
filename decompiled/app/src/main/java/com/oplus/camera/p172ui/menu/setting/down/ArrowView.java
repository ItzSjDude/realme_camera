package com.oplus.camera.p172ui.menu.setting.down;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseAble;

/* loaded from: classes2.dex */
public class ArrowView extends View implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f20052a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f20053b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f20054c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f20055d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Path f20056e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20057f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BlurMaskFilter f20058g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PorterDuffXfermode f20059h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ValueAnimator f20060i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ValueAnimator f20061j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ValueAnimator f20062k;

    /* renamed from: OplusGLSurfaceView_14 */
    private AnimatorSet f20063l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f20064m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f20065n;

    /* renamed from: o */
    private boolean f20066o;

    /* renamed from: p */
    private boolean f20067p;

    /* renamed from: q */
    private float f20068q;

    /* renamed from: r */
    private float f20069r;

    /* renamed from: s */
    private C3319a f20070s;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20052a = null;
        this.f20053b = 0.0f;
        this.f20054c = null;
        this.f20055d = 0.0f;
        this.f20056e = null;
        this.f20057f = 0;
        this.f20058g = null;
        this.f20059h = null;
        this.f20060i = null;
        this.f20061j = null;
        this.f20062k = null;
        this.f20063l = null;
        this.f20064m = true;
        this.f20065n = false;
        this.f20066o = false;
        this.f20067p = false;
        this.f20068q = 0.0f;
        this.f20069r = 0.0f;
        this.f20070s = null;
        m21337a(attributeSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21337a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, 0, 0);
            this.f20057f = typedArrayObtainStyledAttributes.getColor(0, -7829368);
            this.f20053b = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
            this.f20055d = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f20056e = new Path();
        this.f20054c = new Paint();
        this.f20054c.setStyle(Paint.Style.STROKE);
        this.f20054c.setAntiAlias(true);
        this.f20054c.setStrokeCap(Paint.Cap.ROUND);
        this.f20054c.setStrokeJoin(Paint.Join.ROUND);
        this.f20058g = new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.SOLID);
        this.f20059h = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f20070s = new C3319a(this, null);
        setLayerType(1, null);
        this.f20054c.setColor(this.f20057f);
        this.f20054c.setStrokeWidth(this.f20053b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        if (OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
            return;
        }
        this.f20069r = (OplusGLSurfaceView_13 - (this.f20055d * 2.0f)) / 8.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        float measuredWidth = getMeasuredWidth() >> 1;
        this.f20056e.moveTo(measuredWidth - 28.0f, this.f20053b / 2.0f);
        this.f20056e.lineTo(measuredWidth + 28.0f, this.f20053b / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f20065n) {
            this.f20054c.setColor(-12303292);
            this.f20054c.setMaskFilter(this.f20058g);
            canvas.drawPath(this.f20056e, this.f20054c);
            this.f20054c.setMaskFilter(null);
            this.f20054c.setXfermode(this.f20059h);
            canvas.drawPath(this.f20056e, this.f20054c);
            this.f20054c.setXfermode(null);
        }
        this.f20054c.setColor(this.f20057f);
        canvas.drawPath(this.f20056e, this.f20054c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m21336a(float COUIBaseListPopupWindow_12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f20056e.reset();
        this.f20064m = 0.0f == COUIBaseListPopupWindow_12;
        float f2 = measuredWidth >> 1;
        float f3 = measuredHeight >> 1;
        this.f20056e.moveTo(f2 - 28.0f, f3);
        this.f20056e.lineTo(f2 + 28.0f, f3);
        invalidate();
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.down.ArrowView$1 */
    class C33181 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ ArrowView f20071a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f20071a.m21340b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21340b(float COUIBaseListPopupWindow_12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = (((measuredWidth - (this.f20055d * 2.0f)) / 8.0f) / 2.0f) * COUIBaseListPopupWindow_12;
        int iSqrt = (int) Math.sqrt(Math.pow(r2 / 4.0f, 2.0d) - Math.pow(f2, 2.0d));
        this.f20056e.reset();
        float f3 = (measuredHeight / 2) + ((measuredHeight / 3) * COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = measuredWidth / 2;
        float f4 = OplusGLSurfaceView_13 - (iSqrt * 2);
        float f5 = f3 - f2;
        this.f20056e.moveTo(f4, f5);
        this.f20056e.lineTo(f4, f5);
        this.f20056e.lineTo(OplusGLSurfaceView_13, f3 + f2);
        this.f20056e.lineTo(OplusGLSurfaceView_13 + r2, f5);
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f20065n = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f20063l;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f20063l.cancel();
            this.f20063l = null;
        }
    }

    /* renamed from: com.oplus.camera.ui.menu.setting.down.ArrowView$PlatformImplementations.kt_3 */
    private class C3319a implements ValueAnimator.AnimatorUpdateListener {
        private C3319a() {
        }

        /* synthetic */ C3319a(ArrowView arrowView, C33181 c33181) {
            this();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ArrowView.this.f20068q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ArrowView arrowView = ArrowView.this;
            arrowView.m21336a(arrowView.f20068q);
        }
    }
}
