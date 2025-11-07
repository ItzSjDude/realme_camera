package com.oplus.camera.ui.widget;

/* loaded from: classes2.dex */
public class SplitBackgroundView extends com.oplus.camera.ui.menu.facebeauty.RotateAnimationView {
    private android.graphics.Paint k_renamed;
    private android.graphics.Paint l_renamed;
    private android.graphics.Paint m_renamed;
    private android.graphics.Paint n_renamed;
    private android.graphics.RectF o_renamed;
    private android.graphics.Rect p_renamed;
    private boolean q_renamed;
    private int[] r_renamed;
    private int s_renamed;
    private boolean t_renamed;

    public SplitBackgroundView(android.content.Context context) {
        this(context, null);
    }

    public SplitBackgroundView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplitBackgroundView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = new android.graphics.Rect();
        this.q_renamed = false;
        this.r_renamed = new int[2];
        this.s_renamed = 0;
        this.t_renamed = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.widget.SplitBackgroundView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.oplus.camera.ui.widget.SplitBackgroundView.this.o_renamed = new android.graphics.RectF(r0.getPaddingLeft(), com.oplus.camera.ui.widget.SplitBackgroundView.this.getPaddingTop(), com.oplus.camera.ui.widget.SplitBackgroundView.this.getWidth() - com.oplus.camera.ui.widget.SplitBackgroundView.this.getPaddingRight(), com.oplus.camera.ui.widget.SplitBackgroundView.this.getHeight() - com.oplus.camera.ui.widget.SplitBackgroundView.this.getPaddingBottom());
                com.oplus.camera.ui.widget.SplitBackgroundView.this.postInvalidate();
            }
        });
        b_renamed();
    }

    private void b_renamed() {
        this.k_renamed = new android.graphics.Paint();
        this.k_renamed.setAntiAlias(true);
        this.k_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.k_renamed.setStrokeWidth(5.0f);
        this.k_renamed.setColor(androidx.core.a_renamed.a_renamed.c_renamed(getContext(), com.oplus.camera.R_renamed.color.color_white_with_20_percent_transparency));
        this.k_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        this.l_renamed = new android.graphics.Paint();
        this.l_renamed.setAntiAlias(true);
        this.l_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.l_renamed.setStrokeWidth(5.0f);
        this.l_renamed.setColor(androidx.core.a_renamed.a_renamed.c_renamed(getContext(), com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
        this.l_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x00f7  */
    @Override // com.oplus.camera.ui.menu.facebeauty.RotateAnimationView, android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.widget.SplitBackgroundView.onDraw(android.graphics.Canvas):void");
    }

    public void setInterceptTouchEvent(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        android.graphics.Rect rect = this.p_renamed;
        rect.left = i_renamed;
        rect.top = i2;
        rect.right = i_renamed + i3;
        rect.bottom = i2 + i4;
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return isEnabled() ? super.onTouchEvent(motionEvent) : this.t_renamed;
    }

    public void setSplitBackground(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }

    public void setOrientation(int i_renamed) {
        this.s_renamed = i_renamed;
    }
}
