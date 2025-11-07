package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIHintRedDot extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final android.view.animation.Interpolator f2734a = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2735b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2736c;
    private int d_renamed;
    private int e_renamed;
    private com.coui.appcompat.a_renamed.g_renamed f_renamed;
    private android.graphics.RectF g_renamed;
    private java.lang.String h_renamed;
    private int i_renamed;
    private int j_renamed;
    private boolean k_renamed;
    private android.animation.ValueAnimator l_renamed;
    private int m_renamed;
    private boolean n_renamed;
    private android.animation.ValueAnimator o_renamed;
    private android.graphics.drawable.Drawable p_renamed;

    public COUIHintRedDot(android.content.Context context) {
        this(context, null);
    }

    public COUIHintRedDot(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiHintRedDotStyle);
    }

    public COUIHintRedDot(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2736c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.j_renamed = 255;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIHintRedDot, i_renamed, 0);
        this.f2736c = typedArrayObtainStyledAttributes.getInteger(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHintRedPointMode, 0);
        this.d_renamed = typedArrayObtainStyledAttributes.getInteger(coui.support.appcompat.R_renamed.styleable.COUIHintRedDot_couiHintRedPointNum, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f_renamed = new com.coui.appcompat.a_renamed.g_renamed(context, attributeSet, coui.support.appcompat.R_renamed.styleable.COUIHintRedDot, i_renamed, 0);
        this.g_renamed = new android.graphics.RectF();
        this.h_renamed = getResources().getString(coui.support.appcompat.R_renamed.string.red_dot_description);
        this.i_renamed = coui.support.appcompat.R_renamed.plurals.red_dot_with_number_description;
        this.p_renamed = context.getResources().getDrawable(coui.support.appcompat.R_renamed.drawable.red_dot_stroke_circle);
        if (this.f2736c == 4) {
            setBackground(this.p_renamed);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int iA;
        if (this.n_renamed) {
            iA = this.m_renamed;
        } else {
            iA = this.f_renamed.a_renamed(this.f2736c, this.d_renamed);
        }
        setMeasuredDimension(iA, this.f_renamed.a_renamed(this.f2736c));
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.f2735b = true;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.RectF rectF = this.g_renamed;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.g_renamed.bottom = getHeight();
        if (this.k_renamed && (this.d_renamed < 1000 || this.e_renamed < 1000)) {
            com.coui.appcompat.a_renamed.g_renamed gVar = this.f_renamed;
            int i_renamed = this.d_renamed;
            int i2 = this.j_renamed;
            gVar.a_renamed(canvas, i_renamed, i2, this.e_renamed, 255 - i2, this.g_renamed);
            return;
        }
        this.f_renamed.a_renamed(canvas, this.f2736c, this.d_renamed, this.g_renamed);
    }

    public void a_renamed() {
        this.f2735b = true;
    }

    public boolean getIsLaidOut() {
        return this.f2735b;
    }

    public void setPointNumber(int i_renamed) {
        this.d_renamed = i_renamed;
        requestLayout();
        if (i_renamed > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(",");
            android.content.res.Resources resources = getResources();
            int i2 = this.i_renamed;
            int i3 = this.d_renamed;
            sb.append(resources.getQuantityString(i2, i3, java.lang.Integer.valueOf(i3)));
            setContentDescription(sb.toString());
        }
    }

    public void setPointMode(int i_renamed) {
        if (this.f2736c != i_renamed) {
            this.f2736c = i_renamed;
            if (this.f2736c == 4) {
                setBackground(this.p_renamed);
            }
            requestLayout();
            int i2 = this.f2736c;
            if (i2 == 1 || i2 == 4) {
                setContentDescription(this.h_renamed);
            } else if (i2 == 0) {
                setContentDescription("");
            }
        }
    }

    public int getPointMode() {
        return this.f2736c;
    }

    public int getPointNumber() {
        return this.d_renamed;
    }

    private void b_renamed() {
        android.animation.ValueAnimator valueAnimator = this.l_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.l_renamed.end();
        }
        android.animation.ValueAnimator valueAnimator2 = this.o_renamed;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.o_renamed.end();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b_renamed();
        super.onDetachedFromWindow();
        this.f2735b = false;
    }

    public void setBgColor(int i_renamed) {
        this.f_renamed.b_renamed(i_renamed);
    }

    public void setTextColor(int i_renamed) {
        this.f_renamed.c_renamed(i_renamed);
    }

    public void setTextSize(int i_renamed) {
        this.f_renamed.d_renamed(i_renamed);
    }

    public void setSmallWidth(int i_renamed) {
        this.f_renamed.e_renamed(i_renamed);
    }

    public void setMediumWidth(int i_renamed) {
        this.f_renamed.f_renamed(i_renamed);
    }

    public void setLargeWidth(int i_renamed) {
        this.f_renamed.g_renamed(i_renamed);
    }

    public void setViewHeight(int i_renamed) {
        this.f_renamed.h_renamed(i_renamed);
    }

    public void setCornerRadius(int i_renamed) {
        this.f_renamed.i_renamed(i_renamed);
    }

    public void setDotDiameter(int i_renamed) {
        this.f_renamed.j_renamed(i_renamed);
    }

    public void setEllipsisDiameter(int i_renamed) {
        this.f_renamed.k_renamed(i_renamed);
    }
}
