package com.coui.appcompat.widget.popupwindow;

/* loaded from: classes.dex */
public class RoundFrameLayout extends android.widget.FrameLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Path f3033a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f3034b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.RectF f3035c;
    private float d_renamed;

    public RoundFrameLayout(android.content.Context context) {
        this(context, null);
    }

    public RoundFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.RoundFrameLayout);
        this.d_renamed = typedArrayObtainStyledAttributes.getDimension(coui.support.appcompat.R_renamed.styleable.RoundFrameLayout_rfRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f3033a = new android.graphics.Path();
        this.f3034b = new android.graphics.Paint(1);
        this.f3035c = new android.graphics.RectF();
        this.f3034b.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f_renamed) {
        this.d_renamed = f_renamed;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        this.f3035c.set(getPaddingLeft(), getPaddingTop(), i_renamed - getPaddingRight(), i2 - getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            b_renamed(canvas);
        } else {
            a_renamed(canvas);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        canvas.saveLayer(this.f3035c, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(a_renamed(), this.f3034b);
        canvas.restore();
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        canvas.save();
        canvas.clipPath(a_renamed());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private android.graphics.Path a_renamed() {
        this.f3033a.reset();
        android.graphics.Path path = this.f3033a;
        android.graphics.RectF rectF = this.f3035c;
        float f_renamed = this.d_renamed;
        path.addRoundRect(rectF, f_renamed, f_renamed, android.graphics.Path.Direction.CW);
        return this.f3033a;
    }
}
