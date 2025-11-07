package com.oplus.camera.sticker.ui;

/* compiled from: StickerCategoryContainer.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f5527a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f5528b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5529c;
    private int d_renamed;

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public f_renamed(android.content.Context context) {
        super(context);
        this.f5527a = false;
        this.f5528b = null;
        this.f5529c = 0;
        this.d_renamed = 0;
        this.f5528b = new android.graphics.Paint();
        this.f5528b.setStrokeWidth(1.0f);
        this.f5528b.setColor(getContext().getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.f5528b.setAlpha(51);
        this.f5528b.setAntiAlias(true);
        this.f5529c = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_music_divider_margin_right);
        this.d_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_music_divider_margin_top);
        setLayerType(1, null);
    }

    public void a_renamed(boolean z_renamed) {
        this.f5527a = z_renamed;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawLine(0.0f, getHeight(), getWidth(), getHeight(), this.f5528b);
        if (this.f5527a) {
            canvas.drawLine(getWidth() - this.f5529c, this.d_renamed, getWidth() - this.f5529c, getHeight() - this.d_renamed, this.f5528b);
        }
        canvas.restore();
    }
}
