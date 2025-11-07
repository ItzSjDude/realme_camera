package com.oplus.camera.ui.control;

/* loaded from: classes2.dex */
public class ThumbImageView extends com.oplus.camera.ui.w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f6022a;
    private boolean A_renamed;
    private android.view.animation.PathInterpolator B_renamed;
    private android.view.animation.PathInterpolator C_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6023b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6024c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private long l_renamed;
    private long m_renamed;
    private float n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private android.graphics.Bitmap q_renamed;
    private android.graphics.Bitmap r_renamed;
    private android.graphics.Rect s_renamed;
    private android.graphics.Rect t_renamed;
    private android.graphics.drawable.Drawable u_renamed;
    private android.graphics.drawable.Drawable v_renamed;
    private android.graphics.drawable.Drawable w_renamed;
    private android.animation.ValueAnimator x_renamed;
    private android.graphics.Paint y_renamed;
    private int z_renamed;

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        return false;
    }

    public ThumbImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6023b = 0;
        this.f6024c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0L;
        this.m_renamed = 0L;
        this.n_renamed = 0.5f;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = new android.graphics.Paint();
        this.z_renamed = 0;
        this.A_renamed = false;
        this.B_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.C_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        android.content.res.Resources resources = context.getResources();
        this.f6023b = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_round_corner_radius);
        this.f6024c = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_round_stroke_width);
        this.u_renamed = resources.getDrawable(com.oplus.camera.R_renamed.drawable.thumbnail_bg_normal);
        f6022a = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.thumbnail_width_nomal);
        this.z_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_thumbnail_round_corner_radius);
        this.y_renamed.setStrokeWidth(this.f6024c);
        this.y_renamed.setAntiAlias(true);
        this.y_renamed.setColor(context.getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency));
        this.y_renamed.setStyle(android.graphics.Paint.Style.STROKE);
    }

    public ThumbImageView(android.content.Context context) {
        this(context, null);
    }

    protected int getDegree() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.e_renamed) {
            return;
        }
        this.e_renamed = i2;
        if (this.j_renamed != 0) {
            return;
        }
        if (z_renamed) {
            this.f_renamed = this.d_renamed;
            this.l_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.e_renamed - this.d_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.o_renamed = i3 >= 0;
            this.m_renamed = this.l_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.d_renamed = this.e_renamed;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        int i_renamed;
        int i2;
        int paddingLeft = getPaddingLeft() + this.k_renamed;
        int paddingTop = getPaddingTop() + this.k_renamed;
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.p_renamed) {
            android.graphics.drawable.Drawable drawable = getDrawable();
            if (drawable == null) {
                com.oplus.camera.e_renamed.a_renamed("ThumbImageView", "ondraw(), drawable is_renamed null 1 ,so return ");
                return;
            }
            android.graphics.Rect bounds = drawable.getBounds();
            int i3 = bounds.right - bounds.left;
            int i4 = bounds.bottom - bounds.top;
            if (i3 == 0 || i4 == 0) {
                com.oplus.camera.e_renamed.f_renamed("ThumbImageView", "ondraw w_renamed and h_renamed is_renamed zero,so return ");
                return;
            }
            if (this.d_renamed != this.e_renamed) {
                long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
                if (jCurrentAnimationTimeMillis < this.m_renamed) {
                    int i5 = (int) (jCurrentAnimationTimeMillis - this.l_renamed);
                    int i6 = this.f_renamed;
                    if (!this.o_renamed) {
                        i5 = -i5;
                    }
                    int i7 = i6 + ((i5 * 270) / 1000);
                    if (i7 >= 0) {
                        i2 = i7 % 360;
                    } else {
                        i2 = (i7 % 360) + 360;
                    }
                    this.d_renamed = i2;
                    invalidate();
                } else {
                    this.d_renamed = this.e_renamed;
                }
            }
            int saveCount = canvas.getSaveCount();
            if (getScaleType() == android.widget.ImageView.ScaleType.FIT_CENTER && (width < i3 || height < i4)) {
                float f_renamed = width;
                float f2 = height;
                float fMin = java.lang.Math.min(f_renamed / i3, f2 / i4);
                canvas.scale(fMin, fMin, f_renamed * 0.5f, f2 * 0.5f);
            }
            float f3 = paddingLeft;
            float f4 = width * 0.5f;
            float f5 = height * 0.5f;
            canvas.translate(f3 + f4, f3 + f5);
            canvas.rotate(-this.d_renamed);
            float f6 = -paddingLeft;
            canvas.translate(f6 - f4, f6 - f5);
            drawable.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
            a_renamed(canvas);
            return;
        }
        int i8 = this.j_renamed;
        if (i8 != 0) {
            if (i8 == 2) {
                float f7 = width;
                float f8 = f7 * 0.5f;
                float f9 = height;
                float f10 = 0.5f * f9;
                canvas.translate(paddingLeft + f8, paddingTop + f10);
                canvas.rotate(-this.d_renamed);
                canvas.translate((-paddingLeft) - f8, (-paddingTop) - f10);
                float f11 = this.n_renamed;
                this.h_renamed = (int) (f7 * f11);
                this.i_renamed = (int) (f9 * f11);
                android.graphics.Rect rect = this.s_renamed;
                int i9 = (width / 2) + paddingLeft;
                int i10 = this.h_renamed;
                rect.left = i9 - i10;
                int i11 = (height / 2) + paddingTop;
                int i12 = this.i_renamed;
                rect.top = i11 - i12;
                rect.right = i9 + i10;
                rect.bottom = i11 + i12;
                android.graphics.drawable.Drawable drawable2 = this.w_renamed;
                if (drawable2 != null) {
                    drawable2.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
                    this.w_renamed.draw(canvas);
                }
                android.graphics.Bitmap bitmap = this.q_renamed;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, this.t_renamed, this.s_renamed, (android.graphics.Paint) null);
                    a_renamed(canvas);
                    return;
                }
                return;
            }
            return;
        }
        android.graphics.drawable.Drawable drawable3 = getDrawable();
        if (drawable3 == null) {
            return;
        }
        android.graphics.Rect bounds2 = drawable3.getBounds();
        int i13 = bounds2.right - bounds2.left;
        int i14 = bounds2.bottom - bounds2.top;
        if (i13 == 0 || i14 == 0) {
            return;
        }
        if (this.d_renamed != this.e_renamed) {
            long jCurrentAnimationTimeMillis2 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis2 < this.m_renamed) {
                int i15 = (int) (jCurrentAnimationTimeMillis2 - this.l_renamed);
                int i16 = this.f_renamed;
                if (!this.o_renamed) {
                    i15 = -i15;
                }
                int i17 = i16 + ((i15 * 270) / 1000);
                if (i17 >= 0) {
                    i_renamed = i17 % 360;
                } else {
                    i_renamed = (i17 % 360) + 360;
                }
                this.d_renamed = i_renamed;
                invalidate();
            } else {
                this.d_renamed = this.e_renamed;
            }
        }
        int saveCount2 = canvas.getSaveCount();
        if (getScaleType() == android.widget.ImageView.ScaleType.FIT_CENTER && (width < i13 || height < i14)) {
            float f12 = width;
            float f13 = height;
            float fMin2 = java.lang.Math.min(f12 / i13, f13 / i14);
            canvas.scale(fMin2, fMin2, f12 * 0.5f, f13 * 0.5f);
        }
        float f14 = width * 0.5f;
        float f15 = height * 0.5f;
        canvas.translate(paddingLeft + f14, paddingTop + f15);
        canvas.rotate(-this.d_renamed);
        canvas.translate((-paddingLeft) - f14, (-paddingTop) - f15);
        canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        drawable3.setBounds(paddingLeft, paddingTop, width + paddingLeft, height + paddingTop);
        drawable3.draw(canvas);
        a_renamed(canvas);
        canvas.restoreToCount(saveCount2);
    }

    public void setPaddingPlus(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.A_renamed && layoutParams != null) {
            float f_renamed = layoutParams.width - ((paddingLeft - this.k_renamed) * 2);
            float f2 = layoutParams.height - ((paddingTop - this.k_renamed) * 2);
            int i_renamed = this.z_renamed;
            canvas.drawRoundRect(0.0f, 0.0f, f_renamed, f2, i_renamed, i_renamed, this.y_renamed);
            return;
        }
        if (this.A_renamed || layoutParams == null) {
            return;
        }
        canvas.drawCircle(layoutParams.width / 2, layoutParams.height / 2, this.f6023b - this.k_renamed, this.y_renamed);
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("ThumbImageView", "setBitmap, mAnimationState: " + this.j_renamed + ", bitmap: " + bitmap + ", isdefault: " + z_renamed + ", mbDefaultBitmap: " + this.p_renamed);
        boolean z3 = this.p_renamed;
        this.p_renamed = z_renamed;
        if (bitmap == null) {
            this.q_renamed = bitmap;
            this.w_renamed = null;
            setImageDrawable(null);
            return;
        }
        if (z2) {
            this.w_renamed = this.v_renamed;
        } else {
            this.w_renamed = null;
        }
        if (z3 && !this.p_renamed) {
            setImageDrawable(this.u_renamed);
        }
        this.r_renamed = bitmap;
        this.q_renamed = a_renamed(bitmap, true, false);
        this.v_renamed = com.oplus.camera.util.Util.a_renamed(getContext(), this.q_renamed);
        com.oplus.camera.perf.b_renamed.b_renamed("capture");
        if (1 == i_renamed && getVisibility() == 0) {
            a_renamed();
            return;
        }
        if (2 == i_renamed && getVisibility() == 0) {
            android.graphics.drawable.Drawable drawable = this.w_renamed;
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            android.animation.ValueAnimator valueAnimator = this.x_renamed;
            if (valueAnimator == null || ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue() <= 0.4f) {
                return;
            }
            a_renamed();
            return;
        }
        setImageDrawable(this.v_renamed);
    }

    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, boolean z_renamed, boolean z2) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = (layoutParams.width - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (layoutParams.height - getPaddingTop()) - getPaddingBottom();
        if (bitmap.getWidth() != paddingLeft || bitmap.getHeight() != paddingTop) {
            bitmap = android.media.ThumbnailUtils.extractThumbnail(bitmap, paddingLeft, paddingTop);
        }
        if (z_renamed) {
            return com.oplus.camera.ui.control.e_renamed.a_renamed(bitmap, this.f6023b, this.f6024c, z2 && this.A_renamed);
        }
        return bitmap;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ThumbImageView", "startNewThumbAnimation");
        this.j_renamed = 2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.x_renamed == null) {
            c_renamed();
        }
        this.t_renamed = new android.graphics.Rect(0, 0, width, height);
        int i_renamed = paddingLeft + (width / 2);
        int i2 = paddingTop + (height / 2);
        this.s_renamed = new android.graphics.Rect(i_renamed, i2, i_renamed, i2);
        if (this.x_renamed.isRunning() || this.x_renamed.isStarted()) {
            this.x_renamed.cancel();
        }
        this.x_renamed.start();
    }

    private void c_renamed() {
        this.x_renamed = android.animation.ValueAnimator.ofFloat(0.03f, 0.5f);
        this.x_renamed.setDuration(300L);
        this.x_renamed.setInterpolator(this.B_renamed);
        this.x_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.ThumbImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.control.ThumbImageView.this.j_renamed = 2;
                com.oplus.camera.ui.control.ThumbImageView.this.n_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                if (java.lang.Float.compare(com.oplus.camera.ui.control.ThumbImageView.this.n_renamed, 0.5f) > 0) {
                    com.oplus.camera.ui.control.ThumbImageView.this.n_renamed = 0.5f;
                    com.oplus.camera.ui.control.ThumbImageView.this.x_renamed.cancel();
                }
                com.oplus.camera.ui.control.ThumbImageView.this.invalidate();
            }
        });
        this.x_renamed.addListener(new com.oplus.camera.ui.control.ThumbImageView.a_renamed());
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        android.view.animation.AlphaAnimation alphaAnimation;
        android.view.animation.ScaleAnimation scaleAnimation;
        if (getVisibility() == i_renamed) {
            return;
        }
        if (8 == i_renamed && 4 == getVisibility()) {
            return;
        }
        if (4 == i_renamed && 8 == getVisibility()) {
            return;
        }
        setVisibility(i_renamed);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        if (i_renamed == 0) {
            alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            scaleAnimation = new android.view.animation.ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        } else {
            alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        }
        if (!z_renamed) {
            scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        }
        scaleAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(this.C_renamed);
        scaleAnimation.setInterpolator(this.B_renamed);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        clearAnimation();
        startAnimation(animationSet);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
        if (i_renamed == 0) {
            invalidate();
        }
    }

    public void b_renamed() {
        android.graphics.Bitmap bitmap = this.q_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.q_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.r_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.r_renamed = null;
        }
    }

    private class a_renamed extends com.oplus.camera.b_renamed.a_renamed {
        private a_renamed() {
        }

        @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.oplus.camera.e_renamed.a_renamed("ThumbImageView", "ThumbReboundListener, onAnimationEnd, endNewThumbAnimation");
            com.oplus.camera.ui.control.ThumbImageView.this.j_renamed = 0;
            if (com.oplus.camera.ui.control.ThumbImageView.this.v_renamed != null) {
                com.oplus.camera.ui.control.ThumbImageView thumbImageView = com.oplus.camera.ui.control.ThumbImageView.this;
                thumbImageView.setImageDrawable(thumbImageView.v_renamed);
            }
        }

        @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            super.onAnimationCancel(animator);
            com.oplus.camera.e_renamed.a_renamed("ThumbImageView", "ThumbReboundListener, onAnimationCancel, endNewThumbAnimation");
            com.oplus.camera.ui.control.ThumbImageView.this.j_renamed = 0;
            if (com.oplus.camera.ui.control.ThumbImageView.this.v_renamed != null) {
                com.oplus.camera.ui.control.ThumbImageView thumbImageView = com.oplus.camera.ui.control.ThumbImageView.this;
                thumbImageView.setImageDrawable(thumbImageView.v_renamed);
            }
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        this.f6023b = i_renamed;
        this.A_renamed = z_renamed;
        if (this.r_renamed != null) {
            a_renamed(i2, false);
            a_renamed(this.r_renamed, 0, this.p_renamed, false);
        }
    }
}
