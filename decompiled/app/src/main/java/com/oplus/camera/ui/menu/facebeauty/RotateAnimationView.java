package com.oplus.camera.ui.menu.facebeauty;

/* loaded from: classes2.dex */
public class RotateAnimationView extends android.widget.ImageView implements com.oplus.camera.ui.a_renamed.BackgroundSplitManager_2, com.oplus.camera.ui.inverse.a_renamed, com.oplus.camera.ui.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f6388a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f6389b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f6390c;
    public boolean d_renamed;
    public boolean e_renamed;
    public long f_renamed;
    public long g_renamed;
    protected boolean h_renamed;
    protected boolean i_renamed;
    protected boolean j_renamed;
    private final android.view.animation.PathInterpolator k_renamed;
    private final android.animation.ArgbEvaluator l_renamed;
    private int m_renamed;
    private int n_renamed;
    private boolean o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private android.graphics.Paint s_renamed;
    private boolean t_renamed;
    private android.animation.ValueAnimator u_renamed;
    private android.animation.ValueAnimator v_renamed;

    public RotateAnimationView(android.content.Context context) {
        super(context);
        this.k_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.l_renamed = new android.animation.ArgbEvaluator();
        this.f6388a = 0;
        this.f6389b = 0;
        this.f6390c = 0;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = false;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = true;
        this.u_renamed = null;
        this.v_renamed = null;
        b_renamed();
    }

    private void b_renamed() {
        this.n_renamed = com.oplus.camera.util.Util.A_renamed(getContext());
        this.m_renamed = getContext().getColor(com.oplus.camera.R_renamed.color.camera_white);
    }

    public RotateAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.l_renamed = new android.animation.ArgbEvaluator();
        this.f6388a = 0;
        this.f6389b = 0;
        this.f6390c = 0;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = false;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = true;
        this.u_renamed = null;
        this.v_renamed = null;
        b_renamed();
    }

    public RotateAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.k_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.l_renamed = new android.animation.ArgbEvaluator();
        this.f6388a = 0;
        this.f6389b = 0;
        this.f6390c = 0;
        this.d_renamed = false;
        this.e_renamed = true;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = false;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = null;
        this.t_renamed = true;
        this.u_renamed = null;
        this.v_renamed = null;
        b_renamed();
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
        if (i2 == this.f6390c) {
            return;
        }
        this.f6390c = i2;
        if (this.e_renamed) {
            this.f6389b = this.f6388a;
            this.f_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f6390c - this.f6388a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.d_renamed = i3 >= 0;
            this.g_renamed = this.f_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.f6388a = this.f6390c;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
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
        if (this.f6388a != this.f6390c) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.g_renamed) {
                int i4 = (int) (jCurrentAnimationTimeMillis - this.f_renamed);
                int i5 = this.f6389b;
                if (!this.d_renamed) {
                    i4 = -i4;
                }
                int i6 = i5 + ((i4 * 270) / 1000);
                if (i6 >= 0) {
                    i_renamed = i6 % 360;
                } else {
                    i_renamed = (i6 % 360) + 360;
                }
                this.f6388a = i_renamed;
                invalidate();
            } else {
                this.f6388a = this.f6390c;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        if (this.t_renamed && this.s_renamed != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rotate_item_radius);
            float f_renamed = (width - dimensionPixelSize) + this.q_renamed;
            float f2 = this.r_renamed + dimensionPixelSize;
            android.graphics.Paint paint = this.s_renamed;
            if (paint != null) {
                canvas.drawCircle(f_renamed, f2, dimensionPixelSize, paint);
            }
        }
        if (getScaleType() == android.widget.ImageView.ScaleType.FIT_CENTER && (width < i2 || height < i3)) {
            float f3 = width;
            float f4 = height;
            float fMin = java.lang.Math.min(f3 / i2, f4 / i3);
            canvas.scale(fMin, fMin, f3 * 0.5f, f4 * 0.5f);
        }
        canvas.translate(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f));
        canvas.rotate(-this.f6388a);
        canvas.translate((-i2) / 2.0f, (-i3) / 2.0f);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 3);
        if (this.h_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        if (this.i_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_high_light});
        }
        if (this.j_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_light_bg_color});
        }
        return iArrOnCreateDrawableState;
    }

    public void setHighLight(boolean z_renamed) {
        this.i_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.h_renamed = z_renamed;
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
        setLightBackground(z_renamed);
    }

    @Override // com.oplus.camera.ui.n_renamed
    public void setLightBackground(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("RotateAnimationView", "setLightBackground, isLightBackground: " + z_renamed);
        if (this.j_renamed == z_renamed) {
            return;
        }
        this.j_renamed = z_renamed;
        refreshDrawableState();
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("RotateAnimationView", "setSelected, isSelected: " + isSelected() + ", selected: " + z_renamed);
        boolean zIsSelected = isSelected();
        super.setSelected(z_renamed);
        if (zIsSelected != z_renamed) {
            if (z_renamed) {
                d_renamed();
            } else {
                c_renamed();
            }
        }
    }

    private void c_renamed() {
        android.animation.ValueAnimator valueAnimator = this.u_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.u_renamed.cancel();
        }
        if (this.v_renamed == null) {
            this.v_renamed = android.animation.ValueAnimator.ofObject(new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(this.n_renamed), java.lang.Integer.valueOf(this.m_renamed));
            this.v_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.this;
                    rotateAnimationView.setColorFilter(rotateAnimationView.m_renamed);
                }
            });
            this.v_renamed.setInterpolator(this.k_renamed);
            this.v_renamed.setDuration(250L);
            this.v_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.this.setColorFilter(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        }
        this.v_renamed.start();
    }

    private void d_renamed() {
        android.animation.ValueAnimator valueAnimator = this.v_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.v_renamed.cancel();
        }
        if (this.u_renamed == null) {
            this.u_renamed = android.animation.ValueAnimator.ofObject(this.l_renamed, java.lang.Integer.valueOf(this.m_renamed), java.lang.Integer.valueOf(this.n_renamed));
            this.u_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.this;
                    rotateAnimationView.setColorFilter(rotateAnimationView.n_renamed);
                }
            });
            this.u_renamed.setInterpolator(this.k_renamed);
            this.u_renamed.setDuration(250L);
            this.u_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.menu.facebeauty.RotateAnimationView.this.setColorFilter(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
        }
        this.u_renamed.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        android.animation.ValueAnimator valueAnimator = this.u_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.u_renamed.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.v_renamed;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.v_renamed.cancel();
        }
        this.v_renamed = null;
        this.u_renamed = null;
        com.oplus.camera.ui.a_renamed.a_renamed(getContext()).a_renamed(this);
        super.onDetachedFromWindow();
    }

    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
        if (z_renamed) {
            if (this.s_renamed == null) {
                this.s_renamed = new android.graphics.Paint();
                this.s_renamed.setAntiAlias(true);
                this.s_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.camera_red_dot_hint_color, null));
            }
        } else {
            this.s_renamed = null;
        }
        boolean z2 = this.t_renamed != z_renamed;
        this.t_renamed = z_renamed;
        this.q_renamed = i_renamed;
        this.r_renamed = i2;
        if (z2) {
            invalidate();
        }
    }

    public void a_renamed() {
        android.animation.ValueAnimator valueAnimator = this.v_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.v_renamed.cancel();
    }
}
