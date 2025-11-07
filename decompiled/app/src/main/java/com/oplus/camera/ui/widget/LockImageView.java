package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class LockImageView extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f7214a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f7215b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f7216c;
    private float d_renamed;
    private boolean e_renamed;

    public LockImageView(android.content.Context context) {
        super(context);
        this.f7214a = null;
        this.f7215b = null;
        this.f7216c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = false;
        a_renamed();
    }

    public LockImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7214a = null;
        this.f7215b = null;
        this.f7216c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = false;
        a_renamed();
    }

    public LockImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7214a = null;
        this.f7215b = null;
        this.f7216c = null;
        this.d_renamed = 0.0f;
        this.e_renamed = false;
        a_renamed();
    }

    private void a_renamed() {
        this.f7214a = android.graphics.BitmapFactory.decodeResource(getResources(), com.oplus.camera.R_renamed.drawable.icon_locked);
        this.f7215b = android.graphics.BitmapFactory.decodeResource(getResources(), com.oplus.camera.R_renamed.drawable.icon_unlock);
        this.f7216c = new android.graphics.Paint();
        this.f7216c.setAntiAlias(true);
    }

    @Override // android.view.View
    public void setAlpha(float f_renamed) {
        super.setAlpha(f_renamed);
    }

    public void setChangIcon(float f_renamed) {
        this.d_renamed = f_renamed;
        invalidate();
    }

    public void setLock(boolean z_renamed) {
        this.e_renamed = z_renamed;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (1.0f < this.d_renamed) {
            this.d_renamed = 1.0f;
        }
        this.f7216c.setAlpha((int) (this.d_renamed * 255.0f));
        canvas.drawBitmap(this.f7214a, (getWidth() - this.f7214a.getWidth()) / 2, (getHeight() - this.f7214a.getHeight()) / 2, this.f7216c);
        this.f7216c.setAlpha((int) ((1.0f - this.d_renamed) * 255.0f));
        canvas.drawBitmap(this.f7215b, (getWidth() - this.f7215b.getWidth()) / 2, (getHeight() - this.f7215b.getHeight()) / 2, this.f7216c);
    }
}
