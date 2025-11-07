package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseMakeupItemView extends com.oplus.camera.ui.inverse.InverseImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6230a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f6231b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f6232c;

    public InverseMakeupItemView(android.content.Context context) {
        this(context, null);
    }

    public InverseMakeupItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InverseMakeupItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6230a = 0;
        this.f6231b = null;
        this.f6232c = null;
    }

    public void setCornerMark(int i_renamed) {
        this.f6230a = i_renamed;
        if (this.f6230a != 0) {
            if (com.oplus.camera.util.Util.aq_renamed()) {
                int i2 = this.f6230a;
                if (1 == i2) {
                    this.f6231b = com.oplus.camera.util.Util.n_renamed(com.oplus.camera.R_renamed.drawable.makeup_corner_mark_exclusive_cn);
                } else if (2 == i2) {
                    this.f6231b = com.oplus.camera.util.Util.n_renamed(com.oplus.camera.R_renamed.drawable.makeup_corner_mark_custom_cn);
                }
            } else {
                int i3 = this.f6230a;
                if (1 == i3) {
                    this.f6231b = com.oplus.camera.util.Util.n_renamed(com.oplus.camera.R_renamed.drawable.makeup_corner_mark_exclusive_en);
                } else if (2 == i3) {
                    this.f6231b = com.oplus.camera.util.Util.n_renamed(com.oplus.camera.R_renamed.drawable.makeup_corner_mark_custom_en);
                }
            }
            this.f6232c = new android.graphics.Paint();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap;
        super.onDraw(canvas);
        if (this.f6230a == 0 || (bitmap = this.f6231b) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, getPaddingStart(), getPaddingEnd(), this.f6232c);
    }
}
