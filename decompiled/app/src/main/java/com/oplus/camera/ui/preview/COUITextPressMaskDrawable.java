package com.oplus.camera.ui.preview;

/* compiled from: GradienterView.java */
/* loaded from: classes2.dex */
public class q_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.String f7123a = "GradienterView";

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7124b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f7125c;
    private android.graphics.Paint d_renamed;
    private android.graphics.Path e_renamed;
    private android.content.Context f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private float l_renamed;
    private android.animation.ValueAnimator m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;

    public q_renamed(android.content.Context context, int i_renamed, int i2, int i3) {
        super(context);
        this.f7124b = 0;
        this.f7125c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = -1;
        this.h_renamed = -1;
        this.i_renamed = 200;
        this.j_renamed = 300;
        this.k_renamed = 9;
        this.l_renamed = 4.0f;
        this.m_renamed = null;
        this.n_renamed = true;
        this.o_renamed = false;
        this.f_renamed = context;
        this.j_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_dash_width) + (this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_dash_gap) / 2);
        this.i_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_excircle_radius);
        this.k_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_inner_circle_radius);
        this.l_renamed = this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_line_width);
        this.g_renamed = i_renamed;
        this.h_renamed = i2;
        this.f7124b = i3;
        if ((i3 > 75 && i3 < 105) || (i3 > 255 && i3 < 285)) {
            this.n_renamed = false;
        } else {
            this.n_renamed = true;
            if (i3 > 345 && i3 < 360) {
                this.f7124b = i3 - 360;
            }
        }
        d_renamed();
    }

    private void d_renamed() {
        this.f7125c = new android.graphics.Paint();
        this.f7125c.setStrokeWidth(this.l_renamed);
        this.f7125c.setAntiAlias(true);
        this.f7125c.setStyle(android.graphics.Paint.Style.FILL);
        this.f7125c.setColor(-1);
        this.d_renamed = new android.graphics.Paint();
        this.d_renamed.setColor(-1);
        this.d_renamed.setPathEffect(new android.graphics.DashPathEffect(new float[]{this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_dash_width), this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_dash_gap)}, 0.0f));
        this.d_renamed.setStrokeWidth(this.l_renamed);
        this.d_renamed.setAntiAlias(true);
        this.d_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.e_renamed = new android.graphics.Path();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        a_renamed(canvas);
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        int i_renamed = this.g_renamed;
        float f_renamed = i_renamed;
        int i2 = this.h_renamed;
        float f2 = i2;
        float f3 = i_renamed;
        float f4 = i2;
        if (!this.n_renamed) {
            int i3 = this.j_renamed;
            f2 = i2 - i3;
            f4 = i2 + i3;
        } else {
            int i4 = this.j_renamed;
            f3 = i_renamed + i4;
            f_renamed = i_renamed - i4;
        }
        this.e_renamed.moveTo(f_renamed, f2);
        this.e_renamed.lineTo(f3, f4);
        canvas.drawPath(this.e_renamed, this.d_renamed);
        this.e_renamed.reset();
        canvas.save();
        canvas.drawCircle(this.g_renamed, this.h_renamed, this.k_renamed, this.f7125c);
        canvas.rotate(this.f7124b, this.g_renamed, this.h_renamed);
        int i5 = this.g_renamed;
        float f5 = i5;
        int i6 = this.h_renamed;
        float f6 = i6;
        float f7 = i5 + this.i_renamed;
        float f8 = i6;
        canvas.drawLine(f5, f6, f7, f8, this.f7125c);
        canvas.drawLine(this.g_renamed, f6, r1 - this.i_renamed, f8, this.f7125c);
        canvas.restore();
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.b_renamed(f7123a, "showWithAnimation, mOrientation: " + this.f7124b);
        int i_renamed = this.f7124b;
        if (i_renamed % 90 > 75 || i_renamed % 90 < 15) {
            int i2 = this.f7124b;
            if (i2 % 90 > 89 || java.lang.Math.abs(i2 % 90) < 1) {
                this.f7125c.setColor(com.oplus.camera.util.Util.A_renamed(getContext()));
            } else {
                this.f7125c.setColor(-1);
            }
            invalidate();
            setVisibilityWithAnimation(0);
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.b_renamed(f7123a, "hideWithAnimation");
        setVisibilityWithAnimation(4);
    }

    private void setVisibilityWithAnimation(final int i_renamed) {
        if (this.o_renamed) {
            return;
        }
        com.oplus.camera.util.Util.a_renamed(this, i_renamed, new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.q_renamed.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.oplus.camera.ui.preview.q_renamed.this.o_renamed = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.ui.preview.q_renamed.this.setVisibility(i_renamed);
                com.oplus.camera.ui.preview.q_renamed.this.o_renamed = false;
            }
        }, 300L);
    }

    public void setOrientation(int i_renamed) {
        if (i_renamed > 315 && i_renamed < 360) {
            this.f7124b = i_renamed - 360;
        } else {
            this.f7124b = i_renamed;
        }
    }

    public java.lang.String getGradienterStatus() {
        int i_renamed = this.f7124b;
        if (i_renamed % 90 <= 75 && i_renamed % 90 >= 15) {
            return "3";
        }
        int i2 = this.f7124b;
        return (i2 % 90 > 89 || java.lang.Math.abs(i2 % 90) < 1) ? "1" : "2";
    }

    public void a_renamed(int i_renamed) {
        c_renamed();
        int i2 = i_renamed % 90;
        if (i2 > 75 || i2 < 15) {
            if ((i_renamed > 75 && i_renamed < 105) || (i_renamed > 255 && i_renamed < 285)) {
                this.n_renamed = false;
            } else {
                this.n_renamed = true;
                if (i_renamed > 345 && i_renamed < 360) {
                    i_renamed -= 360;
                }
            }
            this.m_renamed = android.animation.ValueAnimator.ofInt(this.f7124b, i_renamed);
            this.m_renamed.setDuration(100L);
            this.m_renamed.setInterpolator(new android.view.animation.DecelerateInterpolator());
            this.m_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.q_renamed.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (com.oplus.camera.ui.preview.q_renamed.this.f7124b != iIntValue) {
                        com.oplus.camera.ui.preview.q_renamed.this.f7124b = iIntValue;
                        com.oplus.camera.ui.preview.q_renamed.this.a_renamed();
                    }
                }
            });
            this.m_renamed.start();
            return;
        }
        setOrientation(i_renamed);
        b_renamed();
    }

    public void c_renamed() {
        android.animation.ValueAnimator valueAnimator = this.m_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.m_renamed = null;
        }
    }
}
