package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class MaskView extends android.view.View implements com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f5761a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Paint f5762b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5763c;

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void setNormalBackground(boolean z_renamed) {
    }

    public MaskView(android.content.Context context) {
        super(context);
        this.f5761a = "MaskView";
        this.f5762b = null;
        this.f5763c = false;
        a_renamed();
    }

    public MaskView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5761a = "MaskView";
        this.f5762b = null;
        this.f5763c = false;
        a_renamed();
    }

    public MaskView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5761a = "MaskView";
        this.f5762b = null;
        this.f5763c = false;
        a_renamed();
    }

    private void a_renamed() {
        this.f5762b = new android.graphics.Paint();
        this.f5762b.setAntiAlias(true);
        this.f5762b.setStyle(android.graphics.Paint.Style.FILL);
        this.f5762b.setStrokeWidth(1.0f);
        this.f5762b.setColor(com.oplus.camera.util.c_renamed.a_renamed(getContext().getColor(com.oplus.camera.R_renamed.color.background_color)));
        this.f5762b.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, "MaskView");
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int iB;
        if (!this.f5763c || com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(getContext().hashCode()) || (iB = com.oplus.camera.ui.a_renamed.a_renamed(getContext()).b_renamed()) == -1) {
            return;
        }
        canvas.drawRect(new android.graphics.RectF(getLeft(), iB, getRight(), getBottom()), this.f5762b);
        invalidate();
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void a_renamed(boolean z_renamed, int i_renamed) {
        this.f5763c = z_renamed;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this);
        super.onDetachedFromWindow();
    }
}
