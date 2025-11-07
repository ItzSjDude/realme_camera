package com.oplus.camera.ui.preview;

/* compiled from: ZoomRotableTextView.java */
/* loaded from: classes2.dex */
public class ah_renamed extends com.oplus.camera.ui.RotableTextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7002a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7003b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7004c;
    private int d_renamed;
    private android.animation.Animator e_renamed;

    public ah_renamed(android.content.Context context) {
        this(context, null);
    }

    public ah_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ah_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public ah_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f7002a = 0;
        this.f7003b = 0;
        this.f7004c = 0;
        this.d_renamed = 0;
        this.e_renamed = null;
        this.f7003b = com.oplus.camera.util.Util.A_renamed(getContext());
        this.f7002a = getContext().getColor(com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency);
        this.d_renamed = getContext().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency);
        this.f7004c = getContext().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency);
        setTextColor(this.f7004c);
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        drawable.setTint(this.f7002a);
        super.setBackground(drawable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        android.animation.Animator animator = this.e_renamed;
        if (animator != null && animator.isRunning()) {
            this.e_renamed.cancel();
        }
        this.e_renamed = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z_renamed) {
        boolean zIsSelected = isSelected();
        super.setSelected(z_renamed);
        if (zIsSelected != z_renamed) {
            android.animation.Animator animator = this.e_renamed;
            if (animator != null && animator.isRunning()) {
                this.e_renamed.cancel();
            }
            this.e_renamed = com.oplus.camera.util.b_renamed.a_renamed(this, z_renamed ? this.d_renamed : this.f7004c, z_renamed ? this.f7003b : this.f7002a);
            android.animation.Animator animator2 = this.e_renamed;
            if (animator2 != null) {
                animator2.start();
            }
        }
    }
}
