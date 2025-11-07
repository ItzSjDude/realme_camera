package com.oplus.camera.ui.beauty3d;

/* loaded from: classes2.dex */
public class OplusCircleProgressView extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f5894a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f5895b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.RectF f5896c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int[] g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private android.graphics.LinearGradient k_renamed;
    private android.graphics.Point l_renamed;

    public OplusCircleProgressView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5894a = null;
        this.f5895b = null;
        this.f5896c = null;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = new int[2];
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = null;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.shapeCircleProgress);
        this.e_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        com.oplus.camera.e_renamed.a_renamed("OplusCircleProgressView", "OplusCircleProgressView, mDiameter: " + this.e_renamed + ", mRingWidth: " + this.f_renamed);
        this.g_renamed[0] = typedArrayObtainStyledAttributes.getColor(3, 0);
        this.g_renamed[1] = typedArrayObtainStyledAttributes.getColor(1, 0);
        this.h_renamed = context.getColor(com.oplus.camera.R_renamed.color.beauty3d_progress_background);
        typedArrayObtainStyledAttributes.recycle();
        a_renamed();
    }

    private void a_renamed() {
        this.f5894a = new android.graphics.Paint();
        this.f5895b = new android.graphics.Paint();
        this.f5896c = new android.graphics.RectF();
        this.f5894a.setAntiAlias(true);
        this.f5894a.setStrokeWidth(this.f_renamed);
        this.f5894a.setStyle(android.graphics.Paint.Style.STROKE);
        this.f5894a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.f5894a.setColor(0);
        this.f5895b.setAntiAlias(true);
        this.f5895b.setStrokeWidth(this.f_renamed);
        this.f5895b.setStyle(android.graphics.Paint.Style.STROKE);
        this.f5895b.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.f5895b.setColor(this.h_renamed);
        this.f5894a.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.beauty3d_progress_start));
    }

    public android.graphics.Point getCenterPoint() {
        if (this.l_renamed == null) {
            this.l_renamed = new android.graphics.Point(this.i_renamed, this.j_renamed);
        }
        return this.l_renamed;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int i_renamed = this.e_renamed;
        int i2 = this.f_renamed;
        int i3 = (i_renamed / 2) + i2;
        int i4 = (i_renamed / 2) + i2;
        canvas.rotate(-90.0f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        android.graphics.RectF rectF = this.f5896c;
        int i5 = this.i_renamed;
        int i6 = this.j_renamed;
        rectF.set(i5 - i3, i6 - i4, i5 + i3, i6 + i4);
        canvas.drawArc(this.f5896c, 0.0f, 360.0f, false, this.f5895b);
        this.f5894a.setShader(this.k_renamed);
        canvas.drawArc(this.f5896c, 0.0f, (this.d_renamed / 100.0f) * 360.0f, false, this.f5894a);
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed >= 100) {
            i_renamed = 100;
        }
        com.oplus.camera.e_renamed.a_renamed("OplusCircleProgressView", "progressInvalidate, progressValue: " + i_renamed);
        this.d_renamed = i_renamed;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        this.i_renamed = (i3 - i_renamed) / 2;
        this.j_renamed = (i4 - i2) / 2;
        com.oplus.camera.e_renamed.a_renamed("OplusCircleProgressView", "onLayout, mCenterX: " + this.i_renamed + ", mCenterY: " + this.j_renamed);
        int i5 = (this.e_renamed / 2) + this.f_renamed;
        int i6 = this.i_renamed;
        int i7 = this.j_renamed;
        this.k_renamed = new android.graphics.LinearGradient((float) (i6 + i5), (float) i7, (float) i6, (float) (i7 + i5), this.g_renamed, (float[]) null, android.graphics.Shader.TileMode.CLAMP);
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
    }
}
