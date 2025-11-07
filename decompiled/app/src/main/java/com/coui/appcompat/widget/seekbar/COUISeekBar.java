package com.coui.appcompat.widget.seekbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import androidx.customview.p039a.ExploreByTouchHelper;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUIStateListUtil;
import com.p078a.p079a.BaseSpringSystem;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import com.p078a.p079a.SpringListener;
import coui.support.appcompat.R;
import java.util.List;

/* loaded from: classes.dex */
public class COUISeekBar extends View {

    /* renamed from: A */
    private int f8686A;

    /* renamed from: B */
    private C1518c f8687B;

    /* renamed from: C */
    private RunnableC1516a f8688C;

    /* renamed from: D */
    private AccessibilityManager f8689D;

    /* renamed from: E */
    private RectF f8690E;

    /* renamed from: F */
    private AnimatorSet f8691F;

    /* renamed from: G */
    private int f8692G;

    /* renamed from: H */
    private float f8693H;

    /* renamed from: I */
    private float f8694I;

    /* renamed from: J */
    private float f8695J;

    /* renamed from: K */
    private int f8696K;

    /* renamed from: L */
    private int f8697L;

    /* renamed from: M */
    private int f8698M;

    /* renamed from: N */
    private float f8699N;

    /* renamed from: O */
    private float f8700O;

    /* renamed from: P */
    private final BaseSpringSystem f8701P;

    /* renamed from: Q */
    private final Spring f8702Q;

    /* renamed from: R */
    private SpringConfig f8703R;

    /* renamed from: S */
    private VelocityTracker f8704S;

    /* renamed from: T */
    private boolean f8705T;

    /* renamed from: U */
    private float f8706U;

    /* renamed from: V */
    private Interpolator f8707V;

    /* renamed from: W */
    private int f8708W;

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f8709a;

    /* renamed from: aa */
    private String f8710aa;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8711b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f8712c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InterfaceC1517b f8713d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8714e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8715f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8716g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8717h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f8718i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f8719j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ColorStateList f8720k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f8721l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ColorStateList f8722m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ColorStateList f8723n;

    /* renamed from: o */
    private ColorStateList f8724o;

    /* renamed from: p */
    private float f8725p;

    /* renamed from: q */
    private float f8726q;

    /* renamed from: r */
    private float f8727r;

    /* renamed from: s */
    private float f8728s;

    /* renamed from: t */
    private RectF f8729t;

    /* renamed from: u */
    private RectF f8730u;

    /* renamed from: v */
    private RectF f8731v;

    /* renamed from: w */
    private float f8732w;

    /* renamed from: x */
    private Paint f8733x;

    /* renamed from: y */
    private ValueAnimator f8734y;

    /* renamed from: z */
    private AnimatorSet f8735z;

    /* renamed from: com.coui.appcompat.widget.seekbar.COUISeekBar$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1517b {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8176a(COUISeekBar cOUISeekBar);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8177a(COUISeekBar cOUISeekBar, int OplusGLSurfaceView_13, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo8178b(COUISeekBar cOUISeekBar);
    }

    public COUISeekBar(Context context) {
        this(context, null);
    }

    public COUISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiSeekBarStyle);
    }

    public COUISeekBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f8709a = getClass().getSimpleName();
        this.f8711b = 0;
        this.f8714e = 0;
        this.f8715f = 0;
        this.f8716g = 100;
        this.f8717h = 1;
        this.f8718i = false;
        this.f8719j = false;
        this.f8729t = new RectF();
        this.f8730u = new RectF();
        this.f8731v = new RectF();
        this.f8686A = 1;
        this.f8690E = new RectF();
        this.f8691F = new AnimatorSet();
        this.f8701P = SpringSystem.m5492c();
        this.f8702Q = this.f8701P.m5449b();
        this.f8703R = SpringConfig.m5489a(500.0d, 30.0d);
        this.f8705T = false;
        this.f8706U = 0.4f;
        this.f8707V = PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f);
        if (attributeSet != null) {
            this.f8708W = attributeSet.getStyleAttribute();
        }
        if (this.f8708W == 0) {
            this.f8708W = OplusGLSurfaceView_13;
        }
        COUIDarkModeUtil.m6400a(this, false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUISeekBar, OplusGLSurfaceView_13, 0);
        this.f8720k = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.COUISeekBar_couiSeekBarThumbColor);
        this.f8721l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarThumbInScaleRadius, (int) m8158d(3.67f));
        this.f8693H = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarThumbOutRadius, (int) m8158d(6.0f));
        this.f8694I = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarThumbOutScaleRadius, (int) m8158d(7.0f));
        this.f8727r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarProgressScaleRadius, (int) m8158d(2.0f));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f8722m = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.COUISeekBar_couiSeekBarProgressColor);
        } else {
            this.f8722m = COUIStateListUtil.m6465a(COUIContextUtil.m6399a(context, R.attr.couiTintControlNormal, 0), getResources().getColor(R.color.coui_seekbar_progress_color_disabled));
        }
        this.f8726q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarProgressRadius, (int) m8158d(1.0f));
        this.f8724o = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.COUISeekBar_couiSeekBarBackgroundColor);
        this.f8725p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUISeekBar_couiSeekBarBackgroundRadius, (int) m8158d(1.0f));
        this.f8723n = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.COUISeekBar_couiSeekBarSecondaryProgressColor);
        this.f8692G = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISeekBar_couiSeekBarBackgroundHighlightColor, getResources().getColor(R.color.coui_seekbar_background_highlight_color));
        this.f8697L = typedArrayObtainStyledAttributes.getColor(R.styleable.COUISeekBar_couiSeekBarThumbShadowColor, getResources().getColor(R.color.coui_seekbar_thumb_shadow_color));
        this.f8696K = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.COUISeekBar_couiSeekBarThumbShadowRadius, (int) m8158d(14.0f));
        typedArrayObtainStyledAttributes.recycle();
        m8161d();
        m8155c();
        m8164e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8155c() {
        this.f8728s = this.f8726q;
        this.f8695J = this.f8693H;
        this.f8699N = this.f8725p;
        this.f8698M = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8161d() {
        this.f8711b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f8687B = new C1518c(this);
        ViewCompat.m2854a(this, this.f8687B);
        if (Build.VERSION.SDK_INT >= 16) {
            ViewCompat.m2867b((View) this, 1);
        }
        this.f8687B.invalidateRoot();
        this.f8689D = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f8733x = new Paint();
        this.f8733x.setAntiAlias(true);
        this.f8733x.setDither(true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m8164e() {
        this.f8702Q.m5472a(this.f8703R);
        this.f8702Q.m5473a(new SpringListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.1
            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo5465b(Spring c1032f) {
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo5466c(Spring c1032f) {
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo5467d(Spring c1032f) {
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                if (COUISeekBar.this.f8700O != c1032f.m5480d()) {
                    if (!COUISeekBar.this.isEnabled()) {
                        COUISeekBar.this.f8700O = 0.0f;
                        COUISeekBar.this.invalidate();
                    } else {
                        COUISeekBar.this.f8700O = (float) c1032f.m5478c();
                        COUISeekBar.this.invalidate();
                    }
                }
            }
        });
        this.f8691F.setInterpolator(PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f));
        float COUIBaseListPopupWindow_12 = this.f8725p;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12 * 2.0f);
        valueAnimatorOfFloat.setDuration(115L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISeekBar.this.f8699N = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                COUISeekBar.this.f8728s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUISeekBar cOUISeekBar = COUISeekBar.this;
                cOUISeekBar.f8695J = cOUISeekBar.f8693H + (animatedFraction * ((COUISeekBar.this.f8693H * 1.722f) - COUISeekBar.this.f8693H));
                COUISeekBar.this.invalidate();
            }
        });
        float f2 = this.f8725p;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(2.0f * f2, f2);
        valueAnimatorOfFloat2.setStartDelay(115L);
        valueAnimatorOfFloat2.setDuration(87L);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                COUISeekBar cOUISeekBar = COUISeekBar.this;
                cOUISeekBar.f8695J = cOUISeekBar.f8694I + ((1.0f - animatedFraction) * ((COUISeekBar.this.f8693H * 1.722f) - COUISeekBar.this.f8694I));
                COUISeekBar.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f8696K);
        valueAnimatorOfInt.setDuration(202L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISeekBar.this.f8698M = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.f8691F.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2).with(valueAnimatorOfInt);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int iRound = Math.round(this.f8696K * 2) + getPaddingTop() + getPaddingBottom();
        if (1073741824 != mode || size < iRound) {
            size = iRound;
        }
        setMeasuredDimension(size2, size);
    }

    private int getStart() {
        return getPaddingLeft();
    }

    private int getEnd() {
        return getPaddingRight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        float start;
        float f4;
        this.f8733x.setColor(COUISeekBarHelper.m8180a(this, this.f8724o));
        float start2 = (getStart() + this.f8696K) - this.f8725p;
        float width = ((getWidth() - getEnd()) - this.f8696K) + this.f8725p;
        float width2 = ((getWidth() - getEnd()) - (this.f8696K * 2)) - getStart();
        this.f8729t.set(start2, (getHeight() >> 1) - this.f8699N, width, (getHeight() >> 1) + this.f8699N);
        RectF rectF = this.f8729t;
        float f5 = this.f8699N;
        canvas.drawRoundRect(rectF, f5, f5, this.f8733x);
        if (this.f8705T) {
            if (isLayoutRtl()) {
                float width3 = getWidth() / 2.0f;
                float f6 = this.f8714e;
                int OplusGLSurfaceView_13 = this.f8716g;
                f2 = width3 - (((f6 - (OplusGLSurfaceView_13 / 2.0f)) * width2) / OplusGLSurfaceView_13);
                f3 = f2;
                COUIBaseListPopupWindow_12 = width3;
                f4 = COUIBaseListPopupWindow_12;
                start = f3;
            } else {
                start = getWidth() / 2.0f;
                float f7 = this.f8714e;
                int i2 = this.f8716g;
                f4 = start + (((f7 - (i2 / 2.0f)) * width2) / i2);
                COUIBaseListPopupWindow_12 = f4;
                f3 = COUIBaseListPopupWindow_12;
                f2 = start;
            }
        } else if (isLayoutRtl()) {
            start = getStart() + this.f8696K + width2;
            float f8 = this.f8714e * width2;
            int i3 = this.f8716g;
            f4 = start - ((this.f8715f * width2) / i3);
            f2 = start;
            COUIBaseListPopupWindow_12 = start - (f8 / i3);
            f3 = COUIBaseListPopupWindow_12;
        } else {
            float start3 = getStart() + this.f8696K;
            int i4 = this.f8716g;
            COUIBaseListPopupWindow_12 = start3;
            f2 = ((this.f8714e * width2) / i4) + start3;
            f3 = f2;
            start = start3 + ((this.f8715f * width2) / i4);
            f4 = COUIBaseListPopupWindow_12;
        }
        this.f8733x.setColor(COUISeekBarHelper.m8181a(this, this.f8723n, COUISeekBarHelper.f8748c));
        this.f8731v.set(f4, this.f8729t.top, start, this.f8729t.bottom);
        canvas.drawRect(this.f8731v, this.f8733x);
        if (!this.f8705T) {
            if (isLayoutRtl()) {
                this.f8690E.set(width - (this.f8725p * 2.0f), this.f8729t.top, width, this.f8729t.bottom);
                canvas.drawArc(this.f8690E, -90.0f, 180.0f, true, this.f8733x);
                if (this.f8715f == this.f8716g) {
                    this.f8690E.set(start2, this.f8729t.top, (this.f8725p * 2.0f) + start2, this.f8729t.bottom);
                    canvas.drawArc(this.f8690E, 90.0f, 180.0f, true, this.f8733x);
                }
            } else {
                this.f8690E.set(start2, this.f8729t.top, (this.f8725p * 2.0f) + start2, this.f8729t.bottom);
                canvas.drawArc(this.f8690E, 90.0f, 180.0f, true, this.f8733x);
                if (this.f8715f == this.f8716g) {
                    this.f8690E.set(width - (this.f8725p * 2.0f), this.f8729t.top, width, this.f8729t.bottom);
                    canvas.drawArc(this.f8690E, -90.0f, 180.0f, true, this.f8733x);
                }
            }
        }
        this.f8733x.setColor(COUISeekBarHelper.m8181a(this, this.f8722m, COUISeekBarHelper.f8747b));
        this.f8730u.set(COUIBaseListPopupWindow_12, (getHeight() >> 1) - this.f8728s, f2, (getHeight() >> 1) + this.f8728s);
        canvas.drawRect(this.f8730u, this.f8733x);
        if (!this.f8705T) {
            if (isLayoutRtl()) {
                this.f8690E.set((width - this.f8725p) - this.f8728s, this.f8730u.top, (width - this.f8725p) + this.f8728s, this.f8730u.bottom);
                canvas.drawArc(this.f8690E, -90.0f, 180.0f, true, this.f8733x);
            } else {
                this.f8690E.set(COUIBaseListPopupWindow_12 - this.f8728s, this.f8730u.top, COUIBaseListPopupWindow_12 + this.f8728s, this.f8730u.bottom);
                canvas.drawArc(this.f8690E, 90.0f, 180.0f, true, this.f8733x);
            }
        } else if (isLayoutRtl()) {
            this.f8690E.set(COUIBaseListPopupWindow_12 - this.f8728s, this.f8730u.top, COUIBaseListPopupWindow_12 + this.f8728s, this.f8730u.bottom);
            canvas.drawArc(this.f8690E, -90.0f, 360.0f, true, this.f8733x);
        } else {
            this.f8690E.set(f2 - this.f8728s, this.f8730u.top, f2 + this.f8728s, this.f8730u.bottom);
            canvas.drawArc(this.f8690E, 90.0f, 360.0f, true, this.f8733x);
        }
        int i5 = this.f8698M;
        float f9 = f3 - i5;
        float f10 = i5 + f3;
        float f11 = this.f8695J;
        float f12 = f3 - f11;
        float f13 = f3 + f11;
        float f14 = this.f8700O;
        float f15 = this.f8721l * 2.0f * 2.0f * f14;
        if (f14 > 0.0f) {
            f9 -= f15;
            f12 -= f15;
        } else {
            f10 -= f15;
            f13 -= f15;
        }
        float f16 = f12;
        float f17 = f10;
        this.f8733x.setColor(this.f8697L);
        float height = (getHeight() >> 1) - this.f8698M;
        int height2 = getHeight() >> 1;
        int i6 = this.f8698M;
        canvas.drawRoundRect(f9, height, f17, height2 + i6, i6, i6, this.f8733x);
        this.f8733x.setColor(COUISeekBarHelper.m8181a(this, this.f8722m, COUISeekBarHelper.f8747b));
        float height3 = (getHeight() >> 1) - this.f8695J;
        float height4 = getHeight() >> 1;
        float f18 = this.f8695J;
        canvas.drawRoundRect(f16, height3, f13, height4 + f18, f18, f18, this.f8733x);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r6.getAction()
            r2 = 1
            if (r0 == 0) goto Lb7
            if (r0 == r2) goto L94
            r3 = 2
            if (r0 == r3) goto L19
            r3 = 3
            if (r0 == r3) goto L94
            goto Ld2
        L19:
            android.view.VelocityTracker r0 = r5.f8704S
            r0.addMovement(r6)
            int r0 = r5.getWidth()
            int r4 = r5.getEnd()
            int r0 = r0 - r4
            int r4 = r5.f8696K
            int r4 = r4 * r3
            int r0 = r0 - r4
            int r3 = r5.getStart()
            int r0 = r0 - r3
            float r0 = (float) r0
            int r3 = r5.f8714e
            float r3 = (float) r3
            float r3 = r3 * r0
            int r4 = r5.f8716g
            float r4 = (float) r4
            float r3 = r3 / r4
            boolean r4 = r5.f8705T
            if (r4 == 0) goto L57
            r4 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r4
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 != 0) goto L57
            float r0 = r6.getX()
            float r3 = r5.f8732w
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            r3 = 1101004800(0x41a00000, float:20.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L57
            goto Ld2
        L57:
            boolean r0 = r5.f8718i
            if (r0 == 0) goto L6e
            boolean r0 = r5.f8719j
            if (r0 == 0) goto L6e
            int r0 = r5.f8686A
            if (r0 == 0) goto L6a
            if (r0 == r2) goto L66
            goto Ld2
        L66:
            r5.m8157c(r6)
            goto Ld2
        L6a:
            r5.m8162d(r6)
            goto Ld2
        L6e:
            boolean r0 = com.coui.appcompat.widget.seekbar.COUISeekBarHelper.m8182a(r6, r5)
            if (r0 != 0) goto L75
            return r1
        L75:
            float r0 = r6.getX()
            float r1 = r5.f8712c
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r3 = r5.f8711b
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto Ld2
            r5.m8152b(r6)
            r5.m8146a(r6)
            r5.m8168g()
            r5.f8732w = r0
            goto Ld2
        L94:
            com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 r0 = r5.f8702Q
            r3 = 0
            r0.m5476b(r3)
            boolean r0 = r5.f8718i
            if (r0 == 0) goto La9
            r5.m8175b()
            r5.setPressed(r1)
            r5.m8170h()
            goto Ld2
        La9:
            boolean r0 = com.coui.appcompat.widget.seekbar.COUISeekBarHelper.m8182a(r6, r5)
            if (r0 == 0) goto Ld2
            float r6 = r6.getX()
            r5.m8144a(r6)
            goto Ld2
        Lb7:
            r5.f8718i = r1
            r5.f8719j = r1
            float r0 = r6.getX()
            r5.f8712c = r0
            float r0 = r6.getX()
            r5.f8732w = r0
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r5.f8704S = r0
            android.view.VelocityTracker r5 = r5.f8704S
            r5.addMovement(r6)
        Ld2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.seekbar.COUISeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8144a(float COUIBaseListPopupWindow_12) {
        int iRound;
        float width = ((getWidth() - getEnd()) - (this.f8696K * 2)) - getStart();
        if (isLayoutRtl()) {
            int OplusGLSurfaceView_13 = this.f8716g;
            iRound = OplusGLSurfaceView_13 - Math.round((OplusGLSurfaceView_13 * ((COUIBaseListPopupWindow_12 - getStart()) - this.f8727r)) / width);
        } else {
            iRound = Math.round((this.f8716g * ((COUIBaseListPopupWindow_12 - getStart()) - this.f8727r)) / width);
        }
        m8145a(m8150b(iRound));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8145a(int OplusGLSurfaceView_13) {
        if (this.f8735z == null) {
            this.f8735z = new AnimatorSet();
            this.f8735z.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    COUISeekBar.this.m8172a();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (COUISeekBar.this.f8713d != null) {
                        InterfaceC1517b interfaceC1517b = COUISeekBar.this.f8713d;
                        COUISeekBar cOUISeekBar = COUISeekBar.this;
                        interfaceC1517b.mo8177a(cOUISeekBar, cOUISeekBar.f8714e, true);
                    }
                    COUISeekBar.this.m8175b();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (COUISeekBar.this.f8713d != null) {
                        InterfaceC1517b interfaceC1517b = COUISeekBar.this.f8713d;
                        COUISeekBar cOUISeekBar = COUISeekBar.this;
                        interfaceC1517b.mo8177a(cOUISeekBar, cOUISeekBar.f8714e, true);
                    }
                    COUISeekBar.this.m8175b();
                }
            });
        }
        this.f8735z.cancel();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f8714e, OplusGLSurfaceView_13);
        valueAnimatorOfInt.setInterpolator(PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.67f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISeekBar.this.f8714e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                COUISeekBar.this.invalidate();
            }
        });
        long jAbs = (long) ((Math.abs(OplusGLSurfaceView_13 - r0) / this.f8716g) * 400.0f);
        if (jAbs < 150) {
            jAbs = 150;
        }
        this.f8735z.setDuration(jAbs);
        this.f8735z.play(valueAnimatorOfInt);
        this.f8735z.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8146a(MotionEvent motionEvent) {
        int OplusGLSurfaceView_13 = this.f8714e;
        float width = ((getWidth() - getEnd()) - (this.f8696K * 2)) - getStart();
        if (isLayoutRtl()) {
            int i2 = this.f8716g;
            this.f8714e = i2 - Math.round((i2 * ((motionEvent.getX() - getStart()) - this.f8727r)) / width);
        } else {
            this.f8714e = Math.round((this.f8716g * ((motionEvent.getX() - getStart()) - this.f8727r)) / width);
        }
        this.f8714e = m8150b(this.f8714e);
        int i3 = this.f8714e;
        if (OplusGLSurfaceView_13 != i3) {
            InterfaceC1517b interfaceC1517b = this.f8713d;
            if (interfaceC1517b != null) {
                interfaceC1517b.mo8177a(this, i3, true);
            }
            m8171i();
        }
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8152b(MotionEvent motionEvent) {
        setPressed(true);
        m8172a();
        m8166f();
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        this.f8719j = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m8157c(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getX()
            float r1 = r5.f8732w
            float r0 = r0 - r1
            float r1 = r6.getX()
            float r1 = r5.m8147b(r1)
            float r0 = r0 * r1
            float r1 = r5.f8732w
            float r0 = r0 + r1
            int r0 = java.lang.Math.round(r0)
            float r6 = r6.getY()
            java.lang.Math.round(r6)
            int r6 = r5.getWidth()
            int r1 = r5.getEnd()
            int r1 = r6 - r1
            float r1 = (float) r1
            float r2 = r5.f8727r
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r3
            float r1 = r1 - r2
            int r2 = r5.getStart()
            float r2 = (float) r2
            float r1 = r1 - r2
            int r1 = java.lang.Math.round(r1)
            boolean r2 = r5.isLayoutRtl()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r2 == 0) goto L59
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L4a
            goto L5f
        L4a:
            int r6 = r5.getPaddingLeft()
            if (r0 >= r6) goto L51
            goto L73
        L51:
            int r6 = r1 - r0
            int r2 = r5.getPaddingLeft()
            int r6 = r6 + r2
            goto L6f
        L59:
            int r2 = r5.getPaddingLeft()
            if (r0 >= r2) goto L61
        L5f:
            r3 = r4
            goto L73
        L61:
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            if (r0 <= r6) goto L69
            goto L73
        L69:
            int r6 = r5.getPaddingLeft()
            int r6 = r0 - r6
        L6f:
            float r6 = (float) r6
            float r1 = (float) r1
            float r3 = r6 / r1
        L73:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r3 = r3 * r6
            float r4 = r4 + r3
            int r6 = r5.f8714e
            int r1 = java.lang.Math.round(r4)
            int r1 = r5.m8150b(r1)
            r5.f8714e = r1
            r5.invalidate()
            int r1 = r5.f8714e
            if (r6 == r1) goto L9b
            float r6 = (float) r0
            r5.f8732w = r6
            com.coui.appcompat.widget.seekbar.COUISeekBar$IntrinsicsJvm.kt_4 r6 = r5.f8713d
            if (r6 == 0) goto L98
            r0 = 1
            r6.mo8177a(r5, r1, r0)
        L98:
            r5.m8171i()
        L9b:
            android.view.VelocityTracker r6 = r5.f8704S
            r0 = 100
            r6.computeCurrentVelocity(r0)
            android.view.VelocityTracker r6 = r5.f8704S
            float r6 = r6.getXVelocity()
            r5.m8156c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.seekbar.COUISeekBar.m8157c(android.view.MotionEvent):void");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8162d(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float COUIBaseListPopupWindow_12 = x - this.f8732w;
        if (isLayoutRtl()) {
            COUIBaseListPopupWindow_12 = -COUIBaseListPopupWindow_12;
        }
        int iM8150b = m8150b(this.f8714e + Math.round(((COUIBaseListPopupWindow_12 * m8147b(x)) / (((getWidth() - getEnd()) - (this.f8696K * 2)) - getStart())) * this.f8716g));
        int OplusGLSurfaceView_13 = this.f8714e;
        this.f8714e = iM8150b;
        invalidate();
        int i2 = this.f8714e;
        if (OplusGLSurfaceView_13 != i2) {
            this.f8732w = x;
            InterfaceC1517b interfaceC1517b = this.f8713d;
            if (interfaceC1517b != null) {
                interfaceC1517b.mo8177a(this, i2, true);
            }
            m8171i();
        }
        this.f8704S.computeCurrentVelocity(100);
        m8156c(this.f8704S.getXVelocity());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float m8147b(float COUIBaseListPopupWindow_12) {
        float width = ((getWidth() - getEnd()) - (this.f8696K * 2)) - getStart();
        float f2 = width / 2.0f;
        float interpolation = 1.0f - this.f8707V.getInterpolation(Math.abs(COUIBaseListPopupWindow_12 - f2) / f2);
        return (COUIBaseListPopupWindow_12 > width - ((float) getPaddingRight()) || COUIBaseListPopupWindow_12 < ((float) getPaddingLeft()) || interpolation < this.f8706U) ? this.f8706U : interpolation;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8156c(float COUIBaseListPopupWindow_12) {
        if (this.f8702Q.m5478c() == this.f8702Q.m5480d()) {
            if (COUIBaseListPopupWindow_12 >= 95.0f) {
                int OplusGLSurfaceView_13 = this.f8714e;
                double IntrinsicsJvm.kt_5 = OplusGLSurfaceView_13;
                int i2 = this.f8716g;
                if (IntrinsicsJvm.kt_5 > i2 * 0.95d || OplusGLSurfaceView_13 < i2 * 0.05d) {
                    return;
                }
                this.f8702Q.m5476b(1.0d);
                return;
            }
            if (COUIBaseListPopupWindow_12 <= -95.0f) {
                int i3 = this.f8714e;
                double d2 = i3;
                int i4 = this.f8716g;
                if (d2 > i4 * 0.95d || i3 < i4 * 0.05d) {
                    return;
                }
                this.f8702Q.m5476b(-1.0d);
                return;
            }
            this.f8702Q.m5476b(0.0d);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m8166f() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float m8158d(float COUIBaseListPopupWindow_12) {
        return TypedValue.applyDimension(1, COUIBaseListPopupWindow_12, getResources().getDisplayMetrics());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8150b(int OplusGLSurfaceView_13) {
        return Math.max(0, Math.min(OplusGLSurfaceView_13, this.f8716g));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m8172a() {
        this.f8718i = true;
        this.f8719j = true;
        InterfaceC1517b interfaceC1517b = this.f8713d;
        if (interfaceC1517b != null) {
            interfaceC1517b.mo8176a(this);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m8168g() {
        if (this.f8691F.isRunning()) {
            this.f8691F.cancel();
        }
        this.f8691F.start();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m8170h() {
        if (this.f8734y == null) {
            this.f8734y = new ValueAnimator();
            this.f8734y.setValues(PropertyValuesHolder.ofFloat("radiusOut", this.f8695J, this.f8693H), PropertyValuesHolder.ofFloat("progress", this.f8728s, this.f8726q), PropertyValuesHolder.ofInt("thumbShadowRadius", this.f8698M, 0), PropertyValuesHolder.ofFloat("backgroundRadius", this.f8699N, this.f8725p));
            this.f8734y.setDuration(120L);
            if (Build.VERSION.SDK_INT > 21) {
                this.f8734y.setInterpolator(PathInterpolatorCompat_2.m2772a(0.0f, 0.0f, 0.2f, 1.0f));
            }
            this.f8734y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.seekbar.COUISeekBar.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISeekBar.this.f8728s = ((Float) valueAnimator.getAnimatedValue("progress")).floatValue();
                    COUISeekBar.this.f8695J = ((Float) valueAnimator.getAnimatedValue("radiusOut")).floatValue();
                    COUISeekBar.this.f8698M = ((Integer) valueAnimator.getAnimatedValue("thumbShadowRadius")).intValue();
                    COUISeekBar.this.f8699N = ((Float) valueAnimator.getAnimatedValue("backgroundRadius")).floatValue();
                    COUISeekBar.this.invalidate();
                }
            });
        }
        this.f8691F.cancel();
        this.f8734y.cancel();
        this.f8734y.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m8175b() {
        this.f8718i = false;
        this.f8719j = false;
        InterfaceC1517b interfaceC1517b = this.f8713d;
        if (interfaceC1517b != null) {
            interfaceC1517b.mo8178b(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        RunnableC1516a runnableC1516a = this.f8688C;
        if (runnableC1516a != null) {
            removeCallbacks(runnableC1516a);
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: com.coui.appcompat.widget.seekbar.COUISeekBar$PlatformImplementations.kt_3 */
    private class RunnableC1516a implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUISeekBar f8743a;

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f8743a.announceForAccessibility(this.f8743a.f8714e + "");
            }
        }
    }

    /* renamed from: com.coui.appcompat.widget.seekbar.COUISeekBar$IntrinsicsJvm.kt_3 */
    private final class C1518c extends ExploreByTouchHelper {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Rect f8745b;

        public C1518c(View view) {
            super(view);
            this.f8745b = new Rect();
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper, androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
            if (Build.VERSION.SDK_INT >= 24) {
                c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3010H);
            }
            c0483d.m2680a(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_5.m2748a(1, 0.0f, COUISeekBar.this.getMax(), COUISeekBar.this.f8714e));
            if (COUISeekBar.this.isEnabled()) {
                int progress = COUISeekBar.this.getProgress();
                if (progress > 0) {
                    c0483d.m2676a(8192);
                }
                if (progress < COUISeekBar.this.getMax()) {
                    c0483d.m2676a(4096);
                }
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2) {
            return (COUIBaseListPopupWindow_12 < 0.0f || COUIBaseListPopupWindow_12 > ((float) COUISeekBar.this.getWidth()) || f2 < 0.0f || f2 > ((float) COUISeekBar.this.getHeight())) ? -1 : 0;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 1; OplusGLSurfaceView_13++) {
                list.add(Integer.valueOf(OplusGLSurfaceView_13));
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int OplusGLSurfaceView_13, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getClass().getSimpleName());
            accessibilityEvent.setItemCount(COUISeekBar.this.f8716g);
            accessibilityEvent.setCurrentItemIndex(COUISeekBar.this.f8714e);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d) {
            c0483d.m2702e("");
            c0483d.m2690b((CharSequence) COUISeekBar.class.getName());
            c0483d.m2687b(m8179a(OplusGLSurfaceView_13));
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
            if (super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
                return true;
            }
            if (!COUISeekBar.this.isEnabled()) {
                return false;
            }
            if (OplusGLSurfaceView_13 == 4096) {
                COUISeekBar cOUISeekBar = COUISeekBar.this;
                cOUISeekBar.m8174a(cOUISeekBar.getProgress() + COUISeekBar.this.f8717h, false, true);
                COUISeekBar cOUISeekBar2 = COUISeekBar.this;
                cOUISeekBar2.announceForAccessibility(cOUISeekBar2.f8710aa);
                return true;
            }
            if (OplusGLSurfaceView_13 != 8192) {
                return false;
            }
            COUISeekBar cOUISeekBar3 = COUISeekBar.this;
            cOUISeekBar3.m8174a(cOUISeekBar3.getProgress() - COUISeekBar.this.f8717h, false, true);
            COUISeekBar cOUISeekBar4 = COUISeekBar.this;
            cOUISeekBar4.announceForAccessibility(cOUISeekBar4.f8710aa);
            return true;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            sendEventForVirtualView(OplusGLSurfaceView_13, 4);
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Rect m8179a(int OplusGLSurfaceView_13) {
            Rect rect = this.f8745b;
            rect.left = 0;
            rect.top = 0;
            rect.right = COUISeekBar.this.getWidth();
            rect.bottom = COUISeekBar.this.getHeight();
            return rect;
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public void setProgressContentDescription(String str) {
        this.f8710aa = str;
    }

    public void setProgress(int OplusGLSurfaceView_13) {
        m8173a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8173a(int OplusGLSurfaceView_13, boolean z) {
        m8174a(OplusGLSurfaceView_13, z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8174a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        int i2 = this.f8714e;
        int iMax = Math.max(0, Math.min(OplusGLSurfaceView_13, this.f8716g));
        if (i2 != iMax) {
            if (z) {
                m8145a(iMax);
            } else {
                this.f8714e = iMax;
                InterfaceC1517b interfaceC1517b = this.f8713d;
                if (interfaceC1517b != null) {
                    interfaceC1517b.mo8177a(this, iMax, z2);
                }
                invalidate();
            }
            m8171i();
        }
    }

    public int getProgress() {
        return this.f8714e;
    }

    public int getMax() {
        return this.f8716g;
    }

    public void setMax(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 != this.f8716g) {
            this.f8716g = OplusGLSurfaceView_13;
            if (this.f8714e > OplusGLSurfaceView_13) {
                this.f8714e = OplusGLSurfaceView_13;
            }
        }
        invalidate();
    }

    public void setIncrement(int OplusGLSurfaceView_13) {
        this.f8717h = Math.abs(OplusGLSurfaceView_13);
    }

    public void setOnSeekBarChangeListener(InterfaceC1517b interfaceC1517b) {
        this.f8713d = interfaceC1517b;
    }

    public void setSecondaryProgress(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0) {
            this.f8715f = Math.max(0, Math.min(OplusGLSurfaceView_13, this.f8716g));
            invalidate();
        }
    }

    public int getSecondaryProgress() {
        return this.f8715f;
    }

    public boolean isLayoutRtl() {
        return Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    public void setMoveType(int OplusGLSurfaceView_13) {
        this.f8686A = OplusGLSurfaceView_13;
    }

    public void setStartFromMiddle(boolean z) {
        this.f8705T = z;
    }

    public void setThumbColor(ColorStateList colorStateList) {
        if (this.f8720k != colorStateList) {
            this.f8720k = colorStateList;
            invalidate();
        }
    }

    public void setProgressColor(ColorStateList colorStateList) {
        if (this.f8722m != colorStateList) {
            this.f8722m = colorStateList;
            invalidate();
        }
    }

    public void setSecondaryProgressColor(ColorStateList colorStateList) {
        if (this.f8723n != colorStateList) {
            this.f8723n = colorStateList;
            invalidate();
        }
    }

    public void setSeekBarBackgroundColor(ColorStateList colorStateList) {
        if (this.f8724o != colorStateList) {
            this.f8724o = colorStateList;
            invalidate();
        }
    }

    public void setThumbShadowColor(int OplusGLSurfaceView_13) {
        if (this.f8697L != OplusGLSurfaceView_13) {
            this.f8697L = OplusGLSurfaceView_13;
            invalidate();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m8171i() {
        if (this.f8714e == getMax() || this.f8714e == 0) {
            performHapticFeedback(306, 0);
        } else {
            performHapticFeedback(305, 0);
        }
    }
}
