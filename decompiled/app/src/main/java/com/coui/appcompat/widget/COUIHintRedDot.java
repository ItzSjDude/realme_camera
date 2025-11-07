package com.coui.appcompat.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.p099a.COUIHintRedDotHelper;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIHintRedDot extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Interpolator f7318a = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f7319b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7320c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f7321d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7322e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUIHintRedDotHelper f7323f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RectF f7324g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f7325h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7326i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7327j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f7328k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ValueAnimator f7329l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7330m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f7331n;

    /* renamed from: o */
    private ValueAnimator f7332o;

    /* renamed from: p */
    private Drawable f7333p;

    public COUIHintRedDot(Context context) {
        this(context, null);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiHintRedDotStyle);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7320c = 0;
        this.f7321d = 0;
        this.f7322e = 0;
        this.f7327j = 255;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIHintRedDot, OplusGLSurfaceView_13, 0);
        this.f7320c = typedArrayObtainStyledAttributes.getInteger(R.styleable.COUIHintRedDot_couiHintRedPointMode, 0);
        this.f7321d = typedArrayObtainStyledAttributes.getInteger(R.styleable.COUIHintRedDot_couiHintRedPointNum, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f7323f = new COUIHintRedDotHelper(context, attributeSet, R.styleable.COUIHintRedDot, OplusGLSurfaceView_13, 0);
        this.f7324g = new RectF();
        this.f7325h = getResources().getString(R.string.red_dot_description);
        this.f7326i = R.plurals.red_dot_with_number_description;
        this.f7333p = context.getResources().getDrawable(R.drawable.red_dot_stroke_circle);
        if (this.f7320c == 4) {
            setBackground(this.f7333p);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int iM6413a;
        if (this.f7331n) {
            iM6413a = this.f7330m;
        } else {
            iM6413a = this.f7323f.m6413a(this.f7320c, this.f7321d);
        }
        setMeasuredDimension(iM6413a, this.f7323f.m6412a(this.f7320c));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f7319b = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f7324g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f7324g.bottom = getHeight();
        if (this.f7328k && (this.f7321d < 1000 || this.f7322e < 1000)) {
            COUIHintRedDotHelper c1263g = this.f7323f;
            int OplusGLSurfaceView_13 = this.f7321d;
            int i2 = this.f7327j;
            c1263g.m6414a(canvas, OplusGLSurfaceView_13, i2, this.f7322e, 255 - i2, this.f7324g);
            return;
        }
        this.f7323f.m6415a(canvas, this.f7320c, this.f7321d, this.f7324g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7140a() {
        this.f7319b = true;
    }

    public boolean getIsLaidOut() {
        return this.f7319b;
    }

    public void setPointNumber(int OplusGLSurfaceView_13) {
        this.f7321d = OplusGLSurfaceView_13;
        requestLayout();
        if (OplusGLSurfaceView_13 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(",");
            Resources resources = getResources();
            int i2 = this.f7326i;
            int i3 = this.f7321d;
            sb.append(resources.getQuantityString(i2, i3, Integer.valueOf(i3)));
            setContentDescription(sb.toString());
        }
    }

    public void setPointMode(int OplusGLSurfaceView_13) {
        if (this.f7320c != OplusGLSurfaceView_13) {
            this.f7320c = OplusGLSurfaceView_13;
            if (this.f7320c == 4) {
                setBackground(this.f7333p);
            }
            requestLayout();
            int i2 = this.f7320c;
            if (i2 == 1 || i2 == 4) {
                setContentDescription(this.f7325h);
            } else if (i2 == 0) {
                setContentDescription("");
            }
        }
    }

    public int getPointMode() {
        return this.f7320c;
    }

    public int getPointNumber() {
        return this.f7321d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7139b() {
        ValueAnimator valueAnimator = this.f7329l;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7329l.end();
        }
        ValueAnimator valueAnimator2 = this.f7332o;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f7332o.end();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        m7139b();
        super.onDetachedFromWindow();
        this.f7319b = false;
    }

    public void setBgColor(int OplusGLSurfaceView_13) {
        this.f7323f.m6416b(OplusGLSurfaceView_13);
    }

    public void setTextColor(int OplusGLSurfaceView_13) {
        this.f7323f.m6417c(OplusGLSurfaceView_13);
    }

    public void setTextSize(int OplusGLSurfaceView_13) {
        this.f7323f.m6418d(OplusGLSurfaceView_13);
    }

    public void setSmallWidth(int OplusGLSurfaceView_13) {
        this.f7323f.m6419e(OplusGLSurfaceView_13);
    }

    public void setMediumWidth(int OplusGLSurfaceView_13) {
        this.f7323f.m6420f(OplusGLSurfaceView_13);
    }

    public void setLargeWidth(int OplusGLSurfaceView_13) {
        this.f7323f.m6421g(OplusGLSurfaceView_13);
    }

    public void setViewHeight(int OplusGLSurfaceView_13) {
        this.f7323f.m6422h(OplusGLSurfaceView_13);
    }

    public void setCornerRadius(int OplusGLSurfaceView_13) {
        this.f7323f.m6423i(OplusGLSurfaceView_13);
    }

    public void setDotDiameter(int OplusGLSurfaceView_13) {
        this.f7323f.m6424j(OplusGLSurfaceView_13);
    }

    public void setEllipsisDiameter(int OplusGLSurfaceView_13) {
        this.f7323f.m6425k(OplusGLSurfaceView_13);
    }
}
