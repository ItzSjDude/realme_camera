package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUIPageIndicator extends FrameLayout {

    /* renamed from: A */
    private RectF f7649A;

    /* renamed from: B */
    private ValueAnimator f7650B;

    /* renamed from: C */
    private Handler f7651C;

    /* renamed from: D */
    private int f7652D;

    /* renamed from: E */
    private InterfaceC1419a f7653E;

    /* renamed from: F */
    private int f7654F;

    /* renamed from: G */
    private Context f7655G;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7656a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f7657b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7658c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f7659d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7660e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f7661f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f7662g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f7663h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7664i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7665j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7666k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f7667l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f7668m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f7669n;

    /* renamed from: o */
    private float f7670o;

    /* renamed from: p */
    private float f7671p;

    /* renamed from: q */
    private boolean f7672q;

    /* renamed from: r */
    private boolean f7673r;

    /* renamed from: s */
    private boolean f7674s;

    /* renamed from: t */
    private boolean f7675t;

    /* renamed from: u */
    private boolean f7676u;

    /* renamed from: v */
    private boolean f7677v;

    /* renamed from: w */
    private boolean f7678w;

    /* renamed from: x */
    private LinearLayout f7679x;

    /* renamed from: y */
    private List<View> f7680y;

    /* renamed from: z */
    private Paint f7681z;

    /* renamed from: com.coui.appcompat.widget.COUIPageIndicator$PlatformImplementations.kt_3 */
    public interface InterfaceC1419a {
        void onClick(int OplusGLSurfaceView_13);
    }

    public COUIPageIndicator(Context context) {
        this(context, null);
    }

    public COUIPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiPageIndicatorStyle);
    }

    @TargetApi(21)
    public COUIPageIndicator(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7667l = 0;
        this.f7668m = 0.0f;
        this.f7669n = 0.0f;
        this.f7670o = 0.0f;
        this.f7671p = 0.0f;
        this.f7672q = false;
        this.f7673r = false;
        this.f7674s = false;
        this.f7675t = false;
        this.f7676u = false;
        this.f7677v = false;
        this.f7678w = false;
        this.f7649A = new RectF();
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7654F = attributeSet.getStyleAttribute();
        } else {
            this.f7654F = OplusGLSurfaceView_13;
        }
        this.f7655G = context;
        COUIDarkModeUtil.m6400a(this, false);
        this.f7680y = new ArrayList();
        this.f7663h = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPageIndicator, OplusGLSurfaceView_13, 0);
            this.f7661f = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIPageIndicator_traceDotColor, 0);
            this.f7658c = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIPageIndicator_dotColor, 0);
            this.f7656a = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIPageIndicator_dotSize, 0.0f);
            this.f7657b = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIPageIndicator_dotSpacing, 0.0f);
            this.f7660e = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIPageIndicator_dotCornerRadius, this.f7656a / 2);
            this.f7662g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPageIndicator_dotClickable, true);
            this.f7659d = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIPageIndicator_dotStrokeWidth, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        RectF rectF = this.f7649A;
        rectF.top = 0.0f;
        rectF.bottom = this.f7656a;
        this.f7650B = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7650B.setDuration(240L);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7650B.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        }
        this.f7650B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIPageIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIPageIndicator.this.f7675t) {
                    return;
                }
                float COUIBaseListPopupWindow_12 = COUIPageIndicator.this.f7668m - COUIPageIndicator.this.f7670o;
                float f2 = COUIPageIndicator.this.f7669n - COUIPageIndicator.this.f7671p;
                float f3 = COUIPageIndicator.this.f7668m - (COUIBaseListPopupWindow_12 * fFloatValue);
                if (f3 > COUIPageIndicator.this.f7649A.right - COUIPageIndicator.this.f7656a) {
                    f3 = COUIPageIndicator.this.f7649A.right - COUIPageIndicator.this.f7656a;
                }
                float f4 = COUIPageIndicator.this.f7669n - (f2 * fFloatValue);
                if (f4 < COUIPageIndicator.this.f7649A.left + COUIPageIndicator.this.f7656a) {
                    f4 = COUIPageIndicator.this.f7656a + COUIPageIndicator.this.f7649A.left;
                }
                if (!COUIPageIndicator.this.f7677v) {
                    if (COUIPageIndicator.this.f7672q) {
                        COUIPageIndicator.this.f7649A.right = f4;
                    } else {
                        COUIPageIndicator.this.f7649A.left = f3;
                    }
                } else {
                    COUIPageIndicator.this.f7649A.left = f3;
                    COUIPageIndicator.this.f7649A.right = f4;
                }
                COUIPageIndicator.this.invalidate();
            }
        });
        this.f7650B.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.widget.COUIPageIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!COUIPageIndicator.this.f7675t) {
                    COUIPageIndicator.this.f7649A.right = COUIPageIndicator.this.f7649A.left + COUIPageIndicator.this.f7656a;
                    COUIPageIndicator.this.f7677v = false;
                    COUIPageIndicator.this.f7673r = true;
                    COUIPageIndicator.this.invalidate();
                }
                COUIPageIndicator.this.f7674s = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                COUIPageIndicator.this.f7675t = false;
                COUIPageIndicator cOUIPageIndicator = COUIPageIndicator.this;
                cOUIPageIndicator.f7668m = cOUIPageIndicator.f7649A.left;
                COUIPageIndicator cOUIPageIndicator2 = COUIPageIndicator.this;
                cOUIPageIndicator2.f7669n = cOUIPageIndicator2.f7649A.right;
            }
        });
        this.f7681z = new Paint(1);
        this.f7681z.setStyle(Paint.Style.FILL);
        this.f7681z.setColor(this.f7661f);
        this.f7667l = this.f7656a + (this.f7657b * 2);
        this.f7651C = new Handler() { // from class: com.coui.appcompat.widget.COUIPageIndicator.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 17) {
                    COUIPageIndicator.this.m7384c();
                }
                super.handleMessage(message);
            }
        };
        this.f7679x = new LinearLayout(context);
        this.f7679x.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f7679x.setOrientation(0);
        addView(this.f7679x);
        m7385c(this.f7665j);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7385c(int OplusGLSurfaceView_13) {
        m7395f(this.f7665j);
        RectF rectF = this.f7649A;
        rectF.left = this.f7670o;
        rectF.right = this.f7671p;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        RectF rectF = this.f7649A;
        int OplusGLSurfaceView_13 = this.f7660e;
        canvas.drawRoundRect(rectF, OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f7681z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7376a(boolean z, View view, int OplusGLSurfaceView_13) {
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
        if (z) {
            gradientDrawable.setStroke(this.f7659d, OplusGLSurfaceView_13);
        } else {
            gradientDrawable.setColor(OplusGLSurfaceView_13);
        }
        gradientDrawable.setCornerRadius(this.f7660e);
    }

    @TargetApi(21)
    /* renamed from: PlatformImplementations.kt_3 */
    private View m7375a(boolean z, int OplusGLSurfaceView_13) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.coui_page_indicator_dot_layout, (ViewGroup) this, false);
        View viewFindViewById = viewInflate.findViewById(R.id_renamed.page_indicator_dot);
        if (Build.VERSION.SDK_INT > 16) {
            viewFindViewById.setBackground(getContext().getResources().getDrawable(z ? R.drawable.coui_page_indicator_dot_stroke : R.drawable.coui_page_indicator_dot));
        } else {
            viewFindViewById.setBackgroundDrawable(getContext().getResources().getDrawable(z ? R.drawable.coui_page_indicator_dot_stroke : R.drawable.coui_page_indicator_dot));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
        int i2 = this.f7656a;
        layoutParams.height = i2;
        layoutParams.width = i2;
        viewFindViewById.setLayoutParams(layoutParams);
        int i3 = this.f7657b;
        layoutParams.setMargins(i3, 0, i3, 0);
        m7376a(z, viewFindViewById, OplusGLSurfaceView_13);
        return viewInflate;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7389d(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            this.f7679x.removeViewAt(r1.getChildCount() - 1);
            this.f7680y.remove(r1.size() - 1);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7393e(int OplusGLSurfaceView_13) {
        for (final int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            View viewM7375a = m7375a(this.f7663h, this.f7658c);
            if (this.f7662g) {
                viewM7375a.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.COUIPageIndicator.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (COUIPageIndicator.this.f7653E == null || COUIPageIndicator.this.f7666k == i2) {
                            return;
                        }
                        COUIPageIndicator.this.f7677v = true;
                        COUIPageIndicator.this.f7673r = false;
                        COUIPageIndicator.this.m7402a();
                        COUIPageIndicator.this.f7653E.onClick(i2);
                    }
                });
            }
            this.f7680y.add(viewM7375a.findViewById(R.id_renamed.page_indicator_dot));
            this.f7679x.addView(viewM7375a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7381b() {
        int OplusGLSurfaceView_13 = this.f7664i;
        if (OplusGLSurfaceView_13 < 1) {
            return;
        }
        this.f7652D = this.f7667l * OplusGLSurfaceView_13;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7384c() {
        if (this.f7650B == null) {
            return;
        }
        m7402a();
        this.f7650B.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7402a() {
        if (!this.f7675t) {
            this.f7675t = true;
        }
        ValueAnimator valueAnimator = this.f7650B;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f7650B.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7388d() {
        this.f7676u = true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7392e() {
        this.f7676u = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(this.f7652D, this.f7656a);
    }

    public void setDotsCount(int OplusGLSurfaceView_13) {
        m7389d(this.f7664i);
        this.f7664i = OplusGLSurfaceView_13;
        m7381b();
        m7393e(OplusGLSurfaceView_13);
    }

    public void setCurrentPosition(int OplusGLSurfaceView_13) {
        this.f7665j = OplusGLSurfaceView_13;
        this.f7666k = OplusGLSurfaceView_13;
        m7385c(OplusGLSurfaceView_13);
    }

    public void setTraceDotColor(int OplusGLSurfaceView_13) {
        this.f7661f = OplusGLSurfaceView_13;
        this.f7681z.setColor(OplusGLSurfaceView_13);
    }

    public void setPageIndicatorDotsColor(int OplusGLSurfaceView_13) {
        this.f7658c = OplusGLSurfaceView_13;
        List<View> list = this.f7680y;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<View> it = this.f7680y.iterator();
        while (it.hasNext()) {
            m7376a(this.f7663h, it.next(), OplusGLSurfaceView_13);
        }
    }

    public void setOnDotClickListener(InterfaceC1419a interfaceC1419a) {
        this.f7653E = interfaceC1419a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7404a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        boolean zIsLayoutRtl = isLayoutRtl();
        boolean z = true;
        if (!zIsLayoutRtl ? this.f7665j > OplusGLSurfaceView_13 : this.f7665j <= OplusGLSurfaceView_13) {
            z = false;
        }
        if (z) {
            if (zIsLayoutRtl) {
                float f2 = this.f7652D;
                int i3 = this.f7657b;
                this.f7649A.right = f2 - ((i3 + (OplusGLSurfaceView_13 * r1)) + (this.f7667l * COUIBaseListPopupWindow_12));
            } else {
                int i4 = this.f7657b + this.f7656a;
                this.f7649A.right = i4 + (OplusGLSurfaceView_13 * r0) + (this.f7667l * COUIBaseListPopupWindow_12);
            }
            if (this.f7676u) {
                if (!this.f7674s && this.f7673r) {
                    RectF rectF = this.f7649A;
                    rectF.left = rectF.right - this.f7656a;
                } else if (this.f7649A.right - this.f7649A.left < this.f7656a) {
                    RectF rectF2 = this.f7649A;
                    rectF2.left = rectF2.right - this.f7656a;
                }
            } else if (this.f7673r) {
                RectF rectF3 = this.f7649A;
                rectF3.left = rectF3.right - this.f7656a;
            } else if (this.f7649A.right - this.f7649A.left < this.f7656a) {
                RectF rectF4 = this.f7649A;
                rectF4.left = rectF4.right - this.f7656a;
            }
        } else {
            if (zIsLayoutRtl) {
                this.f7649A.left = ((this.f7652D - (this.f7667l * (OplusGLSurfaceView_13 + COUIBaseListPopupWindow_12))) - this.f7657b) - this.f7656a;
            } else {
                this.f7649A.left = this.f7657b + (this.f7667l * (OplusGLSurfaceView_13 + COUIBaseListPopupWindow_12));
            }
            if (this.f7676u) {
                if (!this.f7674s && this.f7673r) {
                    RectF rectF5 = this.f7649A;
                    rectF5.right = rectF5.left + this.f7656a;
                } else if (this.f7649A.right - this.f7649A.left < this.f7656a) {
                    RectF rectF6 = this.f7649A;
                    rectF6.right = rectF6.left + this.f7656a;
                }
            } else if (this.f7673r) {
                RectF rectF7 = this.f7649A;
                rectF7.right = rectF7.left + this.f7656a;
            } else if (this.f7649A.right - this.f7649A.left < this.f7656a) {
                RectF rectF8 = this.f7649A;
                rectF8.right = rectF8.left + this.f7656a;
            }
        }
        this.f7668m = this.f7649A.left;
        this.f7669n = this.f7649A.right;
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            this.f7665j = OplusGLSurfaceView_13;
        }
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7395f(int OplusGLSurfaceView_13) {
        if (isLayoutRtl()) {
            this.f7671p = this.f7652D - (this.f7657b + (OplusGLSurfaceView_13 * this.f7667l));
            this.f7670o = this.f7671p - this.f7656a;
        } else {
            int i2 = this.f7657b;
            int i3 = this.f7656a;
            this.f7671p = i2 + i3 + (OplusGLSurfaceView_13 * this.f7667l);
            this.f7670o = this.f7671p - i3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7403a(int OplusGLSurfaceView_13) {
        boolean z = true;
        this.f7678w = true;
        if (this.f7666k != OplusGLSurfaceView_13 && this.f7673r) {
            this.f7673r = false;
        }
        if (!isLayoutRtl() ? this.f7666k <= OplusGLSurfaceView_13 : this.f7666k > OplusGLSurfaceView_13) {
            z = false;
        }
        this.f7672q = z;
        m7395f(OplusGLSurfaceView_13);
        if (this.f7666k != OplusGLSurfaceView_13) {
            if (this.f7651C.hasMessages(17)) {
                this.f7651C.removeMessages(17);
            }
            m7402a();
            this.f7651C.sendEmptyMessageDelayed(17, 100L);
        } else if (this.f7651C.hasMessages(17)) {
            this.f7651C.removeMessages(17);
        }
        this.f7666k = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7405b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            m7388d();
            if (this.f7673r) {
                this.f7673r = false;
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            m7392e();
        } else if (OplusGLSurfaceView_13 == 0 && (this.f7676u || !this.f7678w)) {
            if (this.f7651C.hasMessages(17)) {
                this.f7651C.removeMessages(17);
            }
            m7402a();
            this.f7651C.sendEmptyMessageDelayed(17, 100L);
        }
        this.f7678w = false;
    }

    public boolean isLayoutRtl() {
        return Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    public void setDotSize(int OplusGLSurfaceView_13) {
        this.f7656a = OplusGLSurfaceView_13;
    }

    public void setDotSpacing(int OplusGLSurfaceView_13) {
        this.f7657b = OplusGLSurfaceView_13;
    }

    public void setDotCornerRadius(int OplusGLSurfaceView_13) {
        this.f7660e = OplusGLSurfaceView_13;
    }

    public void setIsClickable(boolean z) {
        this.f7662g = z;
    }

    public void setDotStrokeWidth(int OplusGLSurfaceView_13) {
        this.f7659d = OplusGLSurfaceView_13;
    }
}
