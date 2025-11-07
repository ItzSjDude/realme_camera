package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class RotateLottieAnimationView extends com.airbnb.lottie.LottieAnimationView implements com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5789a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5790b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5791c;
    private boolean d_renamed;
    private boolean e_renamed;
    private long f_renamed;
    private long g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private int j_renamed;

    public RotateLottieAnimationView(android.content.Context context) {
        this(context, null);
    }

    public RotateLottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateLottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5789a = 0;
        this.f5790b = 0;
        this.f5791c = 0;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = 0;
        com.oplus.camera.ui.a_renamed.a_renamed(context).a_renamed(this, "RotateLottieAnimationView");
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (getVisibility() == 0) {
            this.e_renamed = z_renamed;
        } else {
            this.e_renamed = false;
        }
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.f5791c) {
            return;
        }
        this.f5791c = i2;
        if (this.e_renamed) {
            this.f5790b = this.f5789a;
            this.f_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f5791c - this.f5789a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.d_renamed = i3 >= 0;
            this.g_renamed = this.f_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.f5789a = this.f5791c;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int i_renamed;
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (this.h_renamed && !com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(getContext().hashCode())) {
            com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, canvas, this.j_renamed);
        }
        android.graphics.Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.f5789a != this.f5791c) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.g_renamed) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f_renamed);
                int i5 = this.f5790b;
                if (!this.d_renamed) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    i_renamed = i6 % 360;
                } else {
                    i_renamed = (i6 % 360) + 360;
                }
                this.f5789a = i_renamed;
                invalidate();
            } else {
                this.f5789a = this.f5791c;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        if (getScaleType() == android.widget.ImageView.ScaleType.FIT_CENTER && (width < i2 || height < i3)) {
            float f_renamed = width;
            float f2 = height;
            float fMin = java.lang.Math.min(f_renamed / i2, f2 / i3);
            canvas.scale(fMin, fMin, f_renamed * 0.5f, f2 * 0.5f);
        }
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        canvas.rotate(-this.f5789a);
        canvas.translate((-i2) / 2, (-i3) / 2);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void a_renamed(boolean z_renamed, int i_renamed) {
        this.h_renamed = z_renamed;
        this.j_renamed = i_renamed;
        postInvalidate();
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void setNormalBackground(boolean z_renamed) {
        setLightBackground(z_renamed);
    }

    public void setLightBackground(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("RotateLottieAnimationView", "setLightBackground, isLightBackground: " + z_renamed);
        if (this.i_renamed == z_renamed) {
            return;
        }
        this.i_renamed = z_renamed;
        refreshDrawableState();
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.i_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this);
    }
}
