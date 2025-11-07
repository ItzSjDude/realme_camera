package com.oplus.camera.ui.beauty3d;

/* loaded from: classes2.dex */
public class BorderRoundImageView extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Paint f5891a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f5892b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f5893c;
    private android.graphics.Canvas d_renamed;
    private android.graphics.BitmapShader e_renamed;
    private android.graphics.Matrix f_renamed;
    private float g_renamed;
    private int h_renamed;
    private boolean i_renamed;

    public BorderRoundImageView(android.content.Context context) {
        this(context, null);
    }

    public BorderRoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderRoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet);
        this.f5891a = new android.graphics.Paint(1);
        this.f5892b = new android.graphics.Paint(1);
        this.f5893c = null;
        this.d_renamed = new android.graphics.Canvas();
        this.e_renamed = null;
        this.f_renamed = new android.graphics.Matrix();
        this.g_renamed = 0.0f;
        this.h_renamed = 0;
        this.i_renamed = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.borderRoundImageView, i_renamed, 0);
        this.g_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.beauty3d_edit_recyclerview_item_border_width));
        this.h_renamed = typedArrayObtainStyledAttributes.getColor(0, com.oplus.camera.util.Util.A_renamed(context));
        typedArrayObtainStyledAttributes.recycle();
        this.f5892b.setStyle(android.graphics.Paint.Style.STROKE);
        this.f5892b.setStrokeWidth(this.g_renamed);
        this.f5892b.setColor(this.h_renamed);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmapA = a_renamed(getDrawable());
        if (bitmapA != null) {
            int iMin = java.lang.Math.min(getWidth(), getHeight());
            if (this.e_renamed == null || !bitmapA.equals(this.f5893c)) {
                this.f5893c = bitmapA;
                this.e_renamed = new android.graphics.BitmapShader(this.f5893c, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            }
            if (this.e_renamed != null) {
                float f_renamed = iMin;
                this.f_renamed.setScale((f_renamed - (this.g_renamed * 2.0f)) / bitmapA.getWidth(), (f_renamed - (this.g_renamed * 2.0f)) / bitmapA.getHeight());
                this.e_renamed.setLocalMatrix(this.f_renamed);
            }
            this.f5891a.setShader(this.e_renamed);
            float f2 = iMin / 2.0f;
            if (this.i_renamed) {
                canvas.drawCircle(f2, f2, f2 - (this.g_renamed / 2.0f), this.f5892b);
            }
            float f3 = this.g_renamed;
            canvas.translate(f3, f3);
            float f4 = this.g_renamed;
            canvas.drawCircle(f2 - f4, f2 - f4, f2 - f4, this.f5891a);
            return;
        }
        super.onDraw(canvas);
    }

    private android.graphics.Bitmap a_renamed(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof android.graphics.drawable.ColorDrawable)) {
            return null;
        }
        android.graphics.Rect bounds = drawable.getBounds();
        int i_renamed = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        int color = ((android.graphics.drawable.ColorDrawable) drawable).getColor();
        android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = this.d_renamed;
        if (canvas != null) {
            canvas.setBitmap(bitmapA);
            this.d_renamed.drawARGB(android.graphics.Color.alpha(color), android.graphics.Color.red(color), android.graphics.Color.green(color), android.graphics.Color.blue(color));
        }
        return bitmapA;
    }

    public void setHighLight(boolean z_renamed) {
        this.i_renamed = z_renamed;
        invalidate();
    }
}
