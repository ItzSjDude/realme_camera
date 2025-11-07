package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class RotateImageView extends com.oplus.camera.ui.w_renamed implements com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2, com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f5786a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f5787b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f5788c;
    public boolean d_renamed;
    public boolean e_renamed;
    public long f_renamed;
    public long g_renamed;
    public float h_renamed;
    public float i_renamed;
    protected boolean j_renamed;
    protected boolean k_renamed;
    protected int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private boolean o_renamed;
    private int p_renamed;
    private android.animation.Animator q_renamed;

    public static float b_renamed(int i_renamed, int i2) {
        int i3 = i2 - i_renamed;
        if (i3 < 0) {
            i3 += 360;
        }
        if (i3 > 180) {
            i3 -= 360;
        }
        return i3;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    public RotateImageView(android.content.Context context) {
        this(context, null);
    }

    public RotateImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5786a = 0;
        this.f5787b = 0;
        this.f5788c = 0;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = 1.0f;
        this.i_renamed = 1.0f;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = -1;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = false;
        this.p_renamed = 0;
        this.q_renamed = null;
    }

    protected int getDegree() {
        return this.f5788c;
    }

    public void setDrawableScale(float f_renamed) {
        this.h_renamed = f_renamed;
    }

    public void setDrawableAlpha(float f_renamed) {
        this.i_renamed = f_renamed;
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
        if (i2 == this.f5788c) {
            return;
        }
        this.f5788c = i2;
        if (this.e_renamed) {
            this.f5787b = this.f5786a;
            this.f_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f5788c - this.f5786a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.d_renamed = i3 >= 0;
            this.g_renamed = this.f_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.f5786a = this.f5788c;
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
        android.graphics.Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        if (i2 == 0 || i3 == 0) {
            return;
        }
        if (this.o_renamed && !com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(getContext().hashCode())) {
            com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this, canvas, this.p_renamed);
        }
        if (this.f5786a != this.f5788c) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.g_renamed) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f_renamed);
                int i5 = this.f5787b;
                if (!this.d_renamed) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    i_renamed = i6 % 360;
                } else {
                    i_renamed = (i6 % 360) + 360;
                }
                this.f5786a = i_renamed;
                invalidate();
            } else {
                this.f5786a = this.f5788c;
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
        float f3 = this.h_renamed;
        if (0.0f > f3 || 1.0f < f3) {
            this.h_renamed = 1.0f;
        }
        float f4 = this.i_renamed;
        if (0.0f > f4 || 1.0f < f4) {
            this.i_renamed = 1.0f;
        }
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        float f5 = this.h_renamed;
        canvas.scale(f5, f5);
        canvas.rotate(-this.f5786a);
        canvas.translate((-i2) / 2, (-i3) / 2);
        drawable.setAlpha((int) (this.i_renamed * 255.0f));
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + (-1 == this.l_renamed ? 2 : 3));
        if (this.j_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        if (this.k_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_light_bg_color});
        }
        int i2 = this.l_renamed;
        if (-1 != i2) {
            if (i2 == 48) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.type_48M});
            } else if (i2 == 50) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.type_50M});
            } else if (i2 == 64) {
                mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.type_64M});
            }
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.j_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void a_renamed(boolean z_renamed, int i_renamed) {
        this.o_renamed = z_renamed;
        this.p_renamed = i_renamed;
        postInvalidate();
    }

    @Override // com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2
    public void setNormalBackground(boolean z_renamed) {
        if (z_renamed) {
            setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
        } else {
            setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
        }
    }

    public void setLightBackground(boolean z_renamed) {
        if (this.k_renamed == z_renamed) {
            return;
        }
        this.k_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    public void setHighResolutionType(int i_renamed) {
        this.l_renamed = i_renamed;
        refreshDrawableState();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        android.animation.Animator animator = this.q_renamed;
        if (animator != null && animator.isRunning()) {
            this.q_renamed.cancel();
        }
        this.q_renamed = null;
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this);
        super.onDetachedFromWindow();
    }

    public void a_renamed(int i_renamed, int i2) {
        android.animation.Animator animatorA = com.oplus.camera.util.b_renamed.a_renamed(this, i_renamed, i2);
        if (animatorA != null) {
            android.animation.Animator animator = this.q_renamed;
            if (animator != null && animator.isRunning()) {
                this.q_renamed.cancel();
            }
            this.q_renamed = animatorA;
            this.q_renamed.start();
        }
    }

    public static long c_renamed(int i_renamed, int i2) {
        return (java.lang.Math.abs((long) b_renamed(i_renamed, i2)) * 1000) / 270;
    }
}
