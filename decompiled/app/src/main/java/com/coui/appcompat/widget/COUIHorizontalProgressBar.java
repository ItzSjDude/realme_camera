package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIHorizontalProgressBar extends android.widget.ProgressBar {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f2737a = android.graphics.Color.argb(12, 0, 0, 0);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int f2738b = android.graphics.Color.parseColor("#FF2AD181");
    private static final int[] m_renamed = {coui.support.appcompat.R_renamed.attr.couiSeekBarProgressColorDisabled};

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f2739c;
    private android.content.res.ColorStateList d_renamed;
    private android.content.res.ColorStateList e_renamed;
    private android.graphics.RectF f_renamed;
    private android.graphics.RectF g_renamed;
    private int h_renamed;
    private android.graphics.Path i_renamed;
    private android.graphics.Path j_renamed;
    private int k_renamed;
    private android.content.Context l_renamed;

    public COUIHorizontalProgressBar(android.content.Context context) {
        this(context, null);
    }

    public COUIHorizontalProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiHorizontalProgressBarStyle);
    }

    public COUIHorizontalProgressBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiHorizontalProgressBarStyle);
        this.f2739c = new android.graphics.Paint();
        this.f_renamed = new android.graphics.RectF();
        this.g_renamed = new android.graphics.RectF();
        this.h_renamed = Integer.MAX_VALUE;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.k_renamed = attributeSet.getStyleAttribute();
        } else {
            this.k_renamed = i_renamed;
        }
        this.l_renamed = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(m_renamed);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIHorizontalProgressBar, i_renamed, 0);
        this.d_renamed = typedArrayObtainStyledAttributes2.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUIHorizontalProgressBar_couiHorizontalProgressBarBackgroundColor);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.e_renamed = typedArrayObtainStyledAttributes2.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUIHorizontalProgressBar_couiHorizontalProgressBarProgressColor);
        } else {
            this.e_renamed = com.coui.appcompat.a_renamed.r_renamed.a_renamed(com.coui.appcompat.a_renamed.d_renamed.a_renamed(context, coui.support.appcompat.R_renamed.attr.couiTintControlNormal, 0), color);
        }
        typedArrayObtainStyledAttributes2.recycle();
        this.f2739c.setDither(true);
        this.f2739c.setAntiAlias(true);
        setLayerType(1, this.f2739c);
        this.i_renamed = new android.graphics.Path();
        this.j_renamed = new android.graphics.Path();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        int paddingRight = (i_renamed - getPaddingRight()) - getPaddingLeft();
        int paddingTop = (i2 - getPaddingTop()) - getPaddingBottom();
        this.h_renamed = paddingRight >= paddingTop ? paddingTop / 2 : paddingRight / 2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.j_renamed.reset();
        this.i_renamed.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.f2739c.setColor(a_renamed(this.d_renamed, f2737a));
        this.f_renamed.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        android.graphics.RectF rectF = this.f_renamed;
        int i_renamed = this.h_renamed;
        canvas.drawRoundRect(rectF, i_renamed, i_renamed, this.f2739c);
        android.graphics.Path path = this.i_renamed;
        android.graphics.RectF rectF2 = this.f_renamed;
        int i2 = this.h_renamed;
        path.addRoundRect(rectF2, i2, i2, android.graphics.Path.Direction.CCW);
        boolean z_renamed = android.os.Build.VERSION.SDK_INT >= 19;
        float progress = getProgress() / getMax();
        if (isLayoutRtl()) {
            if (z_renamed) {
                this.g_renamed.set(java.lang.Math.round((getWidth() - getPaddingRight()) - (progress * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
            } else {
                this.g_renamed.set(getPaddingLeft() + ((1.0f - progress) * width), getPaddingTop(), getPaddingLeft() + width, getHeight() - getPaddingBottom());
            }
        } else if (z_renamed) {
            this.g_renamed.set(java.lang.Math.round(getPaddingLeft() - ((1.0f - progress) * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        } else {
            this.g_renamed.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (progress * width), getHeight() - getPaddingBottom());
        }
        this.f2739c.setColor(a_renamed(this.e_renamed, f2738b));
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            android.graphics.Path path2 = this.j_renamed;
            android.graphics.RectF rectF3 = this.g_renamed;
            int i3 = this.h_renamed;
            path2.addRoundRect(rectF3, i3, i3, android.graphics.Path.Direction.CCW);
            this.j_renamed.op(this.i_renamed, android.graphics.Path.Op.INTERSECT);
            canvas.drawPath(this.j_renamed, this.f2739c);
            return;
        }
        android.graphics.RectF rectF4 = this.g_renamed;
        int i4 = this.h_renamed;
        canvas.drawRoundRect(rectF4, i4, i4, this.f2739c);
    }

    private int a_renamed(android.content.res.ColorStateList colorStateList, int i_renamed) {
        return colorStateList == null ? i_renamed : colorStateList.getColorForState(getDrawableState(), i_renamed);
    }

    public boolean isLayoutRtl() {
        return android.os.Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    public void setProgressColor(android.content.res.ColorStateList colorStateList) {
        this.e_renamed = colorStateList;
    }
}
