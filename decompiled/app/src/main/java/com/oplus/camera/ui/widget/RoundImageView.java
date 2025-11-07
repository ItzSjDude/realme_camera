package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class RoundImageView extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f7227a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Shader f7228b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f7229c;
    private float d_renamed;
    private android.graphics.RectF e_renamed;

    public RoundImageView(android.content.Context context) {
        super(context);
        this.f7229c = new android.graphics.Paint();
        this.d_renamed = 0.0f;
        this.e_renamed = new android.graphics.RectF();
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7229c = new android.graphics.Paint();
        this.d_renamed = 0.0f;
        this.e_renamed = new android.graphics.RectF();
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7229c = new android.graphics.Paint();
        this.d_renamed = 0.0f;
        this.e_renamed = new android.graphics.RectF();
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.f7227a = bitmap;
        this.f7228b = new android.graphics.BitmapShader(this.f7227a, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
    }

    public void a_renamed() {
        android.graphics.Bitmap bitmap = this.f7227a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7227a.recycle();
        }
        this.f7229c.setShader(null);
        this.f7228b = null;
        this.f7227a = null;
    }

    public void setMRadius(float f_renamed) {
        this.d_renamed = f_renamed;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.f7228b != null) {
            canvas.save();
            this.f7229c.setShader(this.f7228b);
            this.f7229c.setAntiAlias(true);
            this.e_renamed.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            android.graphics.RectF rectF = this.e_renamed;
            float f_renamed = this.d_renamed;
            canvas.drawRoundRect(rectF, f_renamed, f_renamed, this.f7229c);
            canvas.restore();
        }
    }
}
