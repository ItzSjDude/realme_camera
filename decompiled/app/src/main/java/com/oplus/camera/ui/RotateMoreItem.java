package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class RotateMoreItem extends android.view.View {
    private int A_renamed;
    private int B_renamed;
    private boolean C_renamed;
    private boolean D_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f5792a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5793b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5794c;
    private int d_renamed;
    private boolean e_renamed;
    private long f_renamed;
    private long g_renamed;
    private android.graphics.Bitmap h_renamed;
    private android.graphics.Bitmap i_renamed;
    private java.lang.String j_renamed;
    private android.text.TextPaint k_renamed;
    private android.graphics.Paint l_renamed;
    private android.graphics.Paint m_renamed;
    private android.graphics.Paint n_renamed;
    private android.animation.ValueAnimator o_renamed;
    private android.animation.ValueAnimator p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;
    private float y_renamed;
    private float z_renamed;

    public RotateMoreItem(android.content.Context context) {
        this(context, null);
    }

    public RotateMoreItem(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateMoreItem(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.f5792a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f5793b = 0;
        this.f5794c = 0;
        this.d_renamed = 0;
        this.e_renamed = false;
        this.f_renamed = 0L;
        this.g_renamed = 0L;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = 0;
        this.u_renamed = 0;
        this.v_renamed = 0;
        this.w_renamed = 0;
        this.x_renamed = 0;
        this.y_renamed = 0.0f;
        this.z_renamed = 0.0f;
        this.A_renamed = 0;
        this.B_renamed = 0;
        this.C_renamed = false;
        this.D_renamed = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.RotateMoreItem, i_renamed, 0);
        this.q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 32);
        this.r_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 32);
        this.B_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 8);
        this.t_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 32);
        this.u_renamed = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.v_renamed = typedArrayObtainStyledAttributes.getInt(6, 1);
        this.z_renamed = typedArrayObtainStyledAttributes.getDimension(8, 12.0f);
        this.w_renamed = typedArrayObtainStyledAttributes.getColor(5, -1);
        this.x_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 70);
        this.A_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 10);
        typedArrayObtainStyledAttributes.recycle();
        b_renamed();
    }

    private void b_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.k_renamed != null) {
            return;
        }
        this.k_renamed = new android.text.TextPaint();
        this.k_renamed.setTextSize(this.z_renamed);
        this.k_renamed.setColor(this.w_renamed);
        this.k_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.k_renamed.setFlags(1);
        this.k_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        this.k_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(com.oplus.camera.R_renamed.color.num_seekbar_thumb_text_shadow_color, null));
        this.l_renamed = new android.graphics.Paint();
        this.l_renamed.setAntiAlias(false);
        this.l_renamed.setColor(-65536);
        this.m_renamed = new android.graphics.Paint();
        this.m_renamed.setAntiAlias(true);
        this.m_renamed.setColor(this.u_renamed);
        c_renamed();
    }

    private void c_renamed() throws android.content.res.Resources.NotFoundException {
        this.n_renamed = new android.graphics.Paint();
        this.n_renamed.setAntiAlias(true);
        this.n_renamed.setColor(-1);
        this.n_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        float dimension = getResources().getDimension(com.oplus.camera.R_renamed.dimen.makeup_item_highlight_stroke_width);
        this.n_renamed.setStrokeWidth(dimension);
        this.y_renamed = getResources().getDimension(com.oplus.camera.R_renamed.dimen.multicamera_layout_select_frame_radius) - (dimension / 2.0f);
        this.o_renamed = android.animation.ValueAnimator.ofInt(0, 255);
        this.o_renamed.setDuration(250L);
        this.o_renamed.setInterpolator(this.f5792a);
        this.o_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.RotateMoreItem.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.RotateMoreItem.this.n_renamed.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                com.oplus.camera.ui.RotateMoreItem.this.postInvalidate();
            }
        });
        this.o_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.RotateMoreItem.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.RotateMoreItem.this.D_renamed = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.RotateMoreItem.this.n_renamed.setAlpha(255);
            }
        });
        this.p_renamed = android.animation.ValueAnimator.ofInt(255, 0);
        this.p_renamed.setDuration(250L);
        this.p_renamed.setInterpolator(this.f5792a);
        this.p_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.RotateMoreItem.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.RotateMoreItem.this.n_renamed.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                com.oplus.camera.ui.RotateMoreItem.this.postInvalidate();
            }
        });
        this.p_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.RotateMoreItem.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.RotateMoreItem.this.D_renamed = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.RotateMoreItem.this.D_renamed = false;
                com.oplus.camera.ui.RotateMoreItem.this.n_renamed.setAlpha(0);
            }
        });
    }

    public void setText(java.lang.String str) {
        this.j_renamed = str;
        setContentDescription(str);
    }

    public void setFrameShow(boolean z_renamed) {
        if (this.D_renamed == z_renamed) {
            return;
        }
        if (z_renamed) {
            android.animation.ValueAnimator valueAnimator = this.p_renamed;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.p_renamed.cancel();
            }
            this.o_renamed.start();
            return;
        }
        android.animation.ValueAnimator valueAnimator2 = this.o_renamed;
        if (valueAnimator2 != null && valueAnimator2.isStarted()) {
            this.o_renamed.cancel();
        }
        this.p_renamed.start();
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        android.graphics.Bitmap bitmap = this.h_renamed;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.h_renamed.recycle();
    }

    public void setImage(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.h_renamed;
        if (bitmap == bitmap2) {
            return;
        }
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.h_renamed.recycle();
            }
            this.h_renamed = null;
        }
        this.h_renamed = bitmap;
    }

    public void setSubscriptHint(android.graphics.Bitmap bitmap) {
        if (bitmap == null && this.i_renamed == null) {
            return;
        }
        android.graphics.Bitmap bitmap2 = this.i_renamed;
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.i_renamed.recycle();
            }
            this.i_renamed = null;
        }
        this.i_renamed = bitmap;
        invalidate();
    }

    public boolean a_renamed() {
        return this.i_renamed != null;
    }

    public void setSubscriptHintRTL(boolean z_renamed) {
        this.C_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        int i3;
        this.f5793b = i_renamed;
        if (i2 >= 0) {
            i3 = i2 % 360;
        } else {
            i3 = (i2 % 360) + 360;
        }
        this.d_renamed = i3;
        this.f5794c = this.f5793b;
        this.f_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        int i4 = this.d_renamed - this.f5793b;
        if (i4 < 0) {
            i4 += 360;
        }
        if (i4 > 180) {
            i4 -= 360;
        }
        this.e_renamed = i4 >= 0;
        this.g_renamed = this.f_renamed + ((java.lang.Math.abs(i4) * 1000) / 270);
        invalidate();
    }

    private android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        float f_renamed = 1.0f;
        if (width > this.q_renamed || height > this.r_renamed) {
            f_renamed = this.q_renamed / width;
            float f2 = this.r_renamed / height;
            if (f_renamed >= f2) {
                f_renamed = f2;
            }
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(f_renamed, f_renamed);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        if (this.f5793b != this.d_renamed) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.g_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f_renamed);
                int i3 = this.f5794c;
                if (!this.e_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 270) / 1000);
                if (i4 >= 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.f5793b = i_renamed;
                invalidate();
            } else {
                this.f5793b = this.d_renamed;
            }
        }
        canvas.rotate(-this.f5793b, getWidth() * 0.5f, getHeight() * 0.5f);
        android.graphics.Bitmap bitmapA = a_renamed(this.h_renamed);
        float width = getWidth() * 0.5f;
        int i5 = this.t_renamed;
        float f_renamed = this.A_renamed + i5;
        android.graphics.Paint paint = this.m_renamed;
        if (paint != null) {
            canvas.drawCircle(width, f_renamed, i5, paint);
        }
        if (this.D_renamed) {
            canvas.drawCircle(width, f_renamed, this.y_renamed, this.n_renamed);
        }
        if (bitmapA != null) {
            canvas.drawBitmap(bitmapA, (getWidth() - bitmapA.getWidth()) * 0.5f, (((this.t_renamed * 2) - bitmapA.getHeight()) * 0.5f) + this.A_renamed, (android.graphics.Paint) null);
        }
        if (a_renamed(this.i_renamed) != null && bitmapA != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rotate_item_radius);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rotate_item_red_dot_offset);
            float width2 = ((getWidth() * 0.5f) + this.t_renamed) - dimensionPixelSize2;
            float f2 = this.A_renamed + dimensionPixelSize2;
            android.graphics.Paint paint2 = this.l_renamed;
            if (paint2 != null) {
                canvas.drawCircle(width2, f2, dimensionPixelSize, paint2);
            }
        }
        canvas.save();
        if (android.text.TextUtils.isEmpty(this.j_renamed)) {
            return;
        }
        java.lang.String str = this.j_renamed;
        android.text.StaticLayout staticLayoutBuild = android.text.StaticLayout.Builder.obtain(str, 0, str.length(), this.k_renamed, this.x_renamed).setMaxLines(this.v_renamed).setAlignment(android.text.Layout.Alignment.ALIGN_CENTER).setEllipsize(android.text.TextUtils.TruncateAt.END).setTextDirection(android.text.TextDirectionHeuristics.LOCALE).build();
        canvas.translate((getWidth() - this.x_renamed) * 0.5f, (this.t_renamed * 2) + this.B_renamed + this.A_renamed);
        staticLayoutBuild.draw(canvas);
        canvas.restore();
    }

    public java.lang.String getName() {
        return this.j_renamed;
    }

    public void setTextColor(int i_renamed) {
        this.w_renamed = i_renamed;
        this.k_renamed.setColor(i_renamed);
    }

    public int getTargetDegree() {
        return this.d_renamed;
    }
}
