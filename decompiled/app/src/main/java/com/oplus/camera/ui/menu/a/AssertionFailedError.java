package com.oplus.camera.ui.menu.a_renamed;

/* compiled from: HeadlineBackground.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.view.View implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6342a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6343b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6344c;
    private int d_renamed;
    private int e_renamed;
    private float f_renamed;
    private android.graphics.Paint g_renamed;
    private android.graphics.RectF h_renamed;
    private float i_renamed;
    private int j_renamed;
    private android.content.Context k_renamed;
    private boolean l_renamed;
    private float m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private android.view.animation.PathInterpolator r_renamed;
    private android.animation.ValueAnimator s_renamed;
    private java.util.List<android.view.View> t_renamed;

    public b_renamed(android.content.Context context) {
        super(context);
        this.f6342a = 0;
        this.f6343b = 0;
        this.f6344c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0.0f;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = 1.0f;
        this.j_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = false;
        this.m_renamed = 0.0f;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.s_renamed = null;
        this.t_renamed = new java.util.ArrayList();
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        this.k_renamed = context;
        this.f6344c = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_bg_radius);
        this.d_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_check_line_width);
        this.e_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_background_space);
        this.f_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_margin_space);
        this.j_renamed = context.getColor(com.oplus.camera.R_renamed.color.camera_white);
        this.o_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_view_margin_top);
        this.p_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_bg_fold_offset);
        this.g_renamed = new android.graphics.Paint();
        this.g_renamed.setAntiAlias(true);
        this.g_renamed.setColor(this.j_renamed);
        this.h_renamed = new android.graphics.RectF();
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "initialize, mBackgroundRadius: " + this.f6344c);
    }

    public void a_renamed(android.view.View view) {
        if (this.t_renamed.contains(view)) {
            return;
        }
        this.t_renamed.add(view);
    }

    public void b_renamed(android.view.View view) {
        this.t_renamed.remove(view);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "animateView, width: " + i_renamed + ", height: " + i2);
        this.f6343b = i2;
        int i5 = this.f6342a;
        if (i_renamed != i5) {
            if (i5 == 0) {
                this.f6342a = i_renamed;
                invalidate();
                return;
            }
            this.q_renamed = i_renamed;
            this.s_renamed = android.animation.ValueAnimator.ofInt(i5, i_renamed);
            this.s_renamed.setDuration(i3);
            this.s_renamed.setStartDelay(i4);
            this.s_renamed.setInterpolator(this.r_renamed);
            this.s_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.b_renamed.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.a_renamed.b_renamed.this.f6342a = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                    com.oplus.camera.ui.menu.a_renamed.b_renamed.this.invalidate();
                }
            });
            this.s_renamed.start();
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "updateView, width: " + i_renamed + ", height: " + i2);
        this.f6343b = i2;
        android.animation.ValueAnimator valueAnimator = this.s_renamed;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            if (i_renamed == this.q_renamed) {
                return;
            }
            this.s_renamed.cancel();
            this.s_renamed = null;
            this.q_renamed = 0;
        }
        this.f6342a = i_renamed;
    }

    public int getBGWidth() {
        return this.f6342a;
    }

    public int getBGHeight() {
        return this.f6343b;
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "setVisibility, visibility: " + i_renamed);
        if (i_renamed != 0) {
            this.i_renamed = 0.0f;
        }
        super.setVisibility(i_renamed);
    }

    private boolean b_renamed(int i_renamed, android.view.View view) {
        for (int i2 = 0; i2 < this.t_renamed.size(); i2++) {
            android.view.View view2 = this.t_renamed.get(i2);
            if (view2 != null && view2 != view && view2.getVisibility() == 0 && i_renamed != 0) {
                return false;
            }
        }
        return true;
    }

    public void a_renamed(int i_renamed, android.view.View view) {
        if (b_renamed(i_renamed, view)) {
            com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "setVisibility, visibility: " + i_renamed + ", fromView:" + view);
            super.setVisibility(i_renamed);
        }
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.i_renamed;
    }

    @Override // android.view.View
    public void setAlpha(float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "setAlpha, alpha: " + f_renamed);
        super.setAlpha(f_renamed);
        this.i_renamed = f_renamed;
        postInvalidate();
    }

    public void setOffsetY(float f_renamed) {
        this.m_renamed = f_renamed;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawColor(0);
        if (this.f6342a <= 0 || this.f6343b <= 0 || this.g_renamed == null || getWidth() <= 0 || getHeight() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("HeadlineBackground", "onDraw, mBackgroundWidth: " + this.f6342a + ", mBackgroundHeight: " + this.f6343b + ", mPaint: " + this.g_renamed + ", getWidth: " + getWidth() + ", getHeight: " + getHeight());
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("HeadlineBackground", "onDraw: " + this.i_renamed);
        this.g_renamed.setAlpha((int) (this.i_renamed * 255.0f));
        a_renamed();
        android.graphics.RectF rectF = this.h_renamed;
        int i_renamed = this.f6344c;
        canvas.drawRoundRect(rectF, i_renamed, i_renamed, this.g_renamed);
        super.onDraw(canvas);
    }

    private void a_renamed() {
        if (this.n_renamed == 1) {
            this.h_renamed.left = ((getWidth() / 2.0f) - (this.f6342a / 2.0f)) - this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_bg_paddingX);
            this.h_renamed.right = (getWidth() / 2.0f) + (this.f6342a / 2.0f) + this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.vertical_headline_bg_paddingX);
            this.h_renamed.top = (getHeight() / 2.0f) - (this.f6343b / 2.0f);
            this.h_renamed.bottom = (getHeight() / 2.0f) + (this.f6343b / 2.0f);
            return;
        }
        this.h_renamed.left = (((getWidth() / 2.0f) - (this.f6342a / 2.0f)) + this.e_renamed) - this.f_renamed;
        this.h_renamed.right = (((getWidth() / 2.0f) + (this.f6342a / 2.0f)) - this.e_renamed) + this.f_renamed;
        android.graphics.RectF rectF = this.h_renamed;
        rectF.top = this.m_renamed + this.o_renamed + this.p_renamed;
        rectF.bottom = ((getHeight() + this.m_renamed) - this.o_renamed) + this.p_renamed;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        android.content.Context context;
        int i_renamed;
        this.l_renamed = z_renamed;
        android.graphics.Paint paint = this.g_renamed;
        if (this.l_renamed) {
            context = this.k_renamed;
            i_renamed = com.oplus.camera.R_renamed.color.bg_black;
        } else {
            context = this.k_renamed;
            i_renamed = com.oplus.camera.R_renamed.color.camera_white;
        }
        paint.setColor(context.getColor(i_renamed));
        invalidate();
    }

    public void setScreenLayoutMode(int i_renamed) {
        this.n_renamed = i_renamed;
    }
}
