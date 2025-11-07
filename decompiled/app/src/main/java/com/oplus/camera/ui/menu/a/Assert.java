package com.oplus.camera.ui.menu.a_renamed;

/* compiled from: ArrangeAnim.java */
/* loaded from: classes2.dex */
public class a_renamed {
    private com.oplus.camera.ui.menu.a_renamed.b_renamed K_renamed;
    private com.oplus.camera.ui.menu.a_renamed.e_renamed N_renamed;
    private android.graphics.Paint O_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6339a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6341c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private float j_renamed;
    private float k_renamed;
    private float l_renamed;
    private float m_renamed;
    private float r_renamed;
    private float s_renamed;
    private float t_renamed;
    private float u_renamed;
    private float v_renamed;
    private float x_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6340b = 255;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private float n_renamed = 0.0f;
    private float o_renamed = 0.0f;
    private float p_renamed = 0.0f;
    private float q_renamed = 0.0f;
    private float w_renamed = 0.99f;
    private float[] y_renamed = null;
    private float[] z_renamed = null;
    private float[] A_renamed = null;
    private float[] B_renamed = null;
    private android.animation.ValueAnimator C_renamed = null;
    private android.animation.ValueAnimator D_renamed = null;
    private android.animation.ValueAnimator E_renamed = null;
    private android.view.animation.PathInterpolator F_renamed = null;
    private android.graphics.Paint G_renamed = null;
    private android.graphics.Paint H_renamed = null;
    private android.graphics.RectF I_renamed = null;
    private android.text.TextPaint J_renamed = null;
    private java.lang.Runnable L_renamed = null;
    private android.graphics.Paint.FontMetrics M_renamed = null;
    private android.animation.Animator.AnimatorListener P_renamed = null;
    private android.animation.Animator.AnimatorListener Q_renamed = null;

    private boolean b_renamed(int i_renamed) {
        return (20 == i_renamed || 21 == i_renamed) ? false : true;
    }

    public a_renamed(com.oplus.camera.ui.menu.a_renamed.b_renamed bVar, com.oplus.camera.ui.menu.a_renamed.e_renamed eVar, android.graphics.Paint paint) throws android.content.res.Resources.NotFoundException {
        this.f6339a = 0;
        this.f6341c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.j_renamed = 0.0f;
        this.k_renamed = 0.0f;
        this.l_renamed = 0.0f;
        this.m_renamed = 0.0f;
        this.r_renamed = 0.0f;
        this.s_renamed = 0.0f;
        this.t_renamed = 0.0f;
        this.u_renamed = 0.0f;
        this.v_renamed = 0.0f;
        this.x_renamed = 0.0f;
        this.K_renamed = null;
        this.N_renamed = null;
        this.O_renamed = null;
        android.content.res.Resources resources = com.oplus.camera.util.Util.l_renamed().getResources();
        this.m_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_radius);
        this.l_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_height);
        this.j_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_recycle_view_text_padding_left_right);
        this.f6341c = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_background_padding);
        this.d_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_check_line_width);
        this.x_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.baseline_vertical_offset);
        this.r_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.baseline_arrange_vertical_offset);
        this.e_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.select_line_arrange_vertical_offset);
        this.f6339a = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_item_gap);
        this.k_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_padding_left_right);
        this.f_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.head_line_view_margin_top);
        this.g_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_bg_fold_offset);
        this.s_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_vertical_anim_more_offset);
        this.t_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_vertical_anim_first_item_offset);
        this.u_renamed = resources.getDimension(com.oplus.camera.R_renamed.dimen.headline_vertical_anim_second_item_offset);
        this.v_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_headline_double_line_text_height);
        this.K_renamed = bVar;
        this.N_renamed = eVar;
        this.O_renamed = paint;
        f_renamed();
    }

    private float a_renamed(java.lang.String str) {
        return this.O_renamed.measureText(str);
    }

    private void f_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.G_renamed == null) {
            this.G_renamed = new android.graphics.Paint();
            this.G_renamed.setAntiAlias(true);
            this.G_renamed.setColor(com.oplus.camera.util.Util.l_renamed().getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_10_percent_transparency, null));
        }
        if (this.F_renamed == null) {
            this.F_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        }
        this.J_renamed = new android.text.TextPaint();
        this.J_renamed.setAntiAlias(true);
    }

    public void a_renamed(int i_renamed, final java.lang.String[] strArr, float[] fArr) {
        final int length = strArr.length;
        final long j_renamed = 500 + (length * 32);
        this.y_renamed = new float[length];
        this.z_renamed = new float[length];
        this.A_renamed = new float[length];
        this.B_renamed = new float[length];
        float f_renamed = i_renamed;
        int i2 = length - 2;
        int iA = (int) (((this.j_renamed + f_renamed) + (a_renamed(strArr[i2]) / 2.0f)) - (g_renamed() / 2));
        if (4 == this.i_renamed) {
            iA = (int) (((f_renamed + this.j_renamed) + (a_renamed(strArr[i2]) / 2.0f)) - (com.oplus.camera.util.Util.getScreenHeight() / 2));
        }
        int i3 = length - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            float[] fArr2 = this.z_renamed;
            fArr2[i4] = fArr[i4];
            this.y_renamed[i4] = fArr2[i4];
            this.B_renamed[i4] = 0.0f;
            if (i4 == i3) {
                this.A_renamed[i4] = iA + fArr2[i4] + this.f6339a + a_renamed(strArr[i4]) + ((this.j_renamed + this.k_renamed) / 2.0f);
            } else if (i4 == i2) {
                this.A_renamed[i4] = iA + fArr2[i4 + 1];
            } else {
                float[] fArr3 = this.A_renamed;
                int i5 = i4 + 1;
                fArr3[i4] = (fArr3[i5] - ((this.j_renamed + this.k_renamed) * 2.0f)) - ((a_renamed(strArr[i4]) + a_renamed(strArr[i5])) / 2.0f);
            }
        }
        this.C_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.C_renamed.setInterpolator(new android.view.animation.LinearInterpolator());
        this.C_renamed.setDuration(j_renamed);
        this.C_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.-$$Lambda$a_renamed$lYvp54_FAVCID9OeHdochKKzlPg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(strArr, j_renamed, length, valueAnimator);
            }
        });
        this.C_renamed.addListener(this.P_renamed);
        this.C_renamed.start();
        a_renamed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(java.lang.String[] strArr, long j_renamed, int i_renamed, android.animation.ValueAnimator valueAnimator) {
        java.lang.Float f_renamed = (java.lang.Float) valueAnimator.getAnimatedValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            float fFloatValue = ((f_renamed.floatValue() * j_renamed) - (i2 * 32)) / 500.0f;
            if (fFloatValue >= 0.0f && fFloatValue <= 1.0f) {
                this.B_renamed[i2] = fFloatValue;
                int i3 = (i_renamed - 1) - i2;
                float[] fArr = this.y_renamed;
                float interpolation = this.F_renamed.getInterpolation(fFloatValue);
                float f2 = this.A_renamed[i3];
                float[] fArr2 = this.z_renamed;
                fArr[i3] = (interpolation * (f2 - fArr2[i3])) + fArr2[i3];
            }
        }
        this.N_renamed.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x00b3 A_renamed[LOOP:1: B_renamed:19:0x00b1->B_renamed:20:0x00b3, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(int[] r18, final java.lang.String[] r19, float[] r20, int r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.a_renamed.a_renamed(int[], java.lang.String[], float[], int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.String[] strArr, long j_renamed, int i_renamed, android.animation.ValueAnimator valueAnimator) {
        java.lang.Float f_renamed = (java.lang.Float) valueAnimator.getAnimatedValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            float fFloatValue = ((f_renamed.floatValue() * j_renamed) - (i2 * 32)) / 500.0f;
            if (fFloatValue >= 0.0f && fFloatValue <= 1.0f) {
                this.B_renamed[i2] = fFloatValue;
                int i3 = (i_renamed - 1) - i2;
                float[] fArr = this.y_renamed;
                float interpolation = this.F_renamed.getInterpolation(fFloatValue);
                float f2 = this.A_renamed[i3];
                float[] fArr2 = this.z_renamed;
                fArr[i3] = (interpolation * (f2 - fArr2[i3])) + fArr2[i3];
            }
        }
        this.N_renamed.invalidate();
    }

    public void a_renamed(int[] iArr, final java.lang.String[] strArr, float f_renamed) {
        int length = strArr.length;
        long j_renamed = (length * 32) + 500;
        int[] iArr2 = new int[length];
        this.z_renamed = new float[length];
        this.A_renamed = new float[length];
        this.y_renamed = new float[length];
        this.B_renamed = new float[length];
        iArr2[iArr[0]] = (int) (iArr[1] + this.j_renamed + (a_renamed(strArr[iArr[0]]) / 2.0f));
        for (int i_renamed = iArr[0] - 1; i_renamed >= 0; i_renamed--) {
            iArr2[i_renamed] = (int) ((iArr2[r7] - ((this.k_renamed + this.j_renamed) * 2.0f)) - ((a_renamed(strArr[i_renamed]) + a_renamed(strArr[i_renamed + 1])) / 2.0f));
        }
        for (int i2 = iArr[0] + 1; i2 < length; i2++) {
            iArr2[i2] = (int) (iArr2[r5] + ((this.k_renamed + this.j_renamed) * 2.0f) + ((a_renamed(strArr[i2]) + a_renamed(strArr[i2 - 1])) / 2.0f));
        }
        for (int i3 = 0; i3 < length; i3++) {
            this.B_renamed[i3] = 255.0f;
            this.z_renamed[i3] = (iArr2[i3] - (g_renamed() / 2.0f)) + f_renamed;
            int i4 = length - 1;
            int i5 = i4 - i3;
            android.content.Context contextL = com.oplus.camera.util.Util.l_renamed();
            float dimensionPixelSize = contextL.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_arrange_text_right_offset);
            float dimensionPixelSize2 = contextL.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_arrange_text_left_offset);
            if (i5 == i4) {
                this.A_renamed[i5] = f_renamed;
            } else if (i5 == length - 2) {
                float[] fArr = this.A_renamed;
                int i6 = i5 + 1;
                fArr[i5] = ((fArr[i6] - this.f6339a) - ((a_renamed(strArr[i6]) + a_renamed(strArr[i5])) / 2.0f)) - dimensionPixelSize2;
            } else {
                float[] fArr2 = this.A_renamed;
                int i7 = i5 + 1;
                fArr2[i5] = ((fArr2[i7] - this.f6339a) - ((a_renamed(strArr[i7]) + a_renamed(strArr[i5])) / 2.0f)) + dimensionPixelSize;
            }
        }
        this.D_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.D_renamed.setInterpolator(this.F_renamed);
        this.D_renamed.setDuration(j_renamed);
        this.D_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.-$$Lambda$a_renamed$iM5miySNsRqqxHlBsLaMHu0mppg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(strArr, valueAnimator);
            }
        });
        this.D_renamed.addListener(this.Q_renamed);
        this.D_renamed.start();
        a_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(java.lang.String[] strArr, android.animation.ValueAnimator valueAnimator) {
        java.lang.Float f_renamed = (java.lang.Float) valueAnimator.getAnimatedValue();
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            this.B_renamed[i_renamed] = 1.0f - f_renamed.floatValue();
            float[] fArr = this.y_renamed;
            float fFloatValue = f_renamed.floatValue();
            float f2 = this.A_renamed[i_renamed];
            float[] fArr2 = this.z_renamed;
            fArr[i_renamed] = (fFloatValue * (f2 - fArr2[i_renamed])) + fArr2[i_renamed];
        }
        this.N_renamed.invalidate();
    }

    public void a_renamed(int[] iArr, final java.lang.String[] strArr, float f_renamed, int i_renamed) {
        char c2;
        int i2;
        int i3;
        int[] iArr2 = iArr;
        int length = strArr.length;
        long j_renamed = (length * 32) + 500;
        this.z_renamed = new float[length];
        this.A_renamed = new float[length];
        this.y_renamed = new float[length];
        this.B_renamed = new float[length];
        android.graphics.Paint.FontMetrics fontMetrics = this.O_renamed.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        float f3 = (this.l_renamed - f2) / 2.0f;
        int[] iArr3 = new int[2];
        this.N_renamed.getLocationOnScreen(iArr3);
        int length2 = iArr2.length;
        this.h_renamed = length2;
        if (90 == i_renamed) {
            i2 = -1;
            c2 = 0;
        } else {
            c2 = 270 == i_renamed ? (char) 0 : (char) 1;
            i2 = 1;
        }
        int i4 = iArr3[c2];
        int i5 = length - 1;
        this.A_renamed[i5] = (f_renamed - fontMetrics.descent) + this.t_renamed;
        int i6 = length2 < i5 ? i5 - length2 : 0;
        int i7 = length - 2;
        if (this.N_renamed.a_renamed(strArr[i7])) {
            float[] fArr = this.A_renamed;
            fArr[i7] = ((fArr[i5] - f2) - this.N_renamed.getTextGap()) - (this.u_renamed / 2.0f);
        } else {
            float[] fArr2 = this.A_renamed;
            fArr2[i7] = ((fArr2[i5] - f2) - this.N_renamed.getTextGap()) - this.u_renamed;
        }
        int i8 = 0;
        while (i8 < i5) {
            this.B_renamed[i8] = 255.0f;
            if (i8 >= i6) {
                this.z_renamed[i8] = ((((iArr2[i8 - i6] - i4) * i2) - this.N_renamed.getVerticalOffset()) - f3) - fontMetrics.descent;
            }
            int i9 = i5 - i8;
            boolean z_renamed = i9 < i5 && this.N_renamed.a_renamed(strArr[i9 + 1]);
            if (i9 >= i7) {
                i3 = i4;
            } else if (z_renamed) {
                float[] fArr3 = this.A_renamed;
                i3 = i4;
                fArr3[i9] = ((fArr3[i9 + 1] - this.v_renamed) - this.N_renamed.getTextGap()) + this.t_renamed;
            } else {
                i3 = i4;
                float[] fArr4 = this.A_renamed;
                fArr4[i9] = (fArr4[i9 + 1] - f2) - this.N_renamed.getTextGap();
            }
            i8++;
            iArr2 = iArr;
            i4 = i3;
        }
        float[] fArr5 = this.z_renamed;
        fArr5[i5] = fArr5[i7] + this.s_renamed + f2 + this.N_renamed.getTextGap();
        this.D_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.D_renamed.setInterpolator(this.F_renamed);
        this.D_renamed.setDuration(j_renamed);
        this.D_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.-$$Lambda$a_renamed$o4MIPm6F4gpDj7FzwpzOCJkux8E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(strArr, valueAnimator);
            }
        });
        this.D_renamed.addListener(this.Q_renamed);
        this.D_renamed.start();
        a_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.String[] strArr, android.animation.ValueAnimator valueAnimator) {
        java.lang.Float f_renamed = (java.lang.Float) valueAnimator.getAnimatedValue();
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            this.B_renamed[i_renamed] = 1.0f - f_renamed.floatValue();
            float[] fArr = this.y_renamed;
            float fFloatValue = f_renamed.floatValue();
            float f2 = this.A_renamed[i_renamed];
            float[] fArr2 = this.z_renamed;
            fArr[i_renamed] = (fFloatValue * (f2 - fArr2[i_renamed])) + fArr2[i_renamed];
        }
        this.N_renamed.invalidate();
        if (f_renamed.floatValue() > this.w_renamed) {
            this.K_renamed.setVisibility(8);
            this.N_renamed.h_renamed();
        }
    }

    private void a_renamed(final boolean z_renamed) {
        this.E_renamed = android.animation.ValueAnimator.ofInt(0, 255);
        this.E_renamed.setDuration(320L);
        this.E_renamed.setInterpolator(new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.E_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.a_renamed.-$$Lambda$a_renamed$qZuUuNlIPT7gkDdz0FZ04Axqazw
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(z_renamed, valueAnimator);
            }
        });
        this.E_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(boolean z_renamed, android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        com.oplus.camera.e_renamed.f_renamed("ArrangeAnim", "editeAndMoreAnimation, value:" + iIntValue);
        if (!z_renamed) {
            iIntValue = 255 - iIntValue;
        }
        this.f6340b = iIntValue;
        this.N_renamed.setArrangeEditAlpha(this.f6340b);
    }

    public java.lang.Runnable a_renamed() {
        return this.L_renamed;
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.L_renamed = runnable;
    }

    public void a_renamed(float f_renamed, float f2, android.graphics.Paint.FontMetrics fontMetrics, boolean z_renamed, int i_renamed) {
        this.p_renamed = f_renamed;
        float f3 = this.x_renamed;
        this.o_renamed = f_renamed - f3;
        this.q_renamed = f2;
        this.n_renamed = f2 - f3;
        this.M_renamed = fontMetrics;
        this.J_renamed.setTextSize(com.oplus.camera.k_renamed.m_renamed());
        this.J_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        android.text.TextPaint textPaint = this.J_renamed;
        if (!z_renamed) {
            i_renamed = -1;
        }
        textPaint.setColor(i_renamed);
        this.J_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.H_renamed = new android.graphics.Paint();
        this.H_renamed.setAntiAlias(true);
        this.H_renamed.setColor(com.oplus.camera.util.Util.l_renamed().getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.I_renamed = new android.graphics.RectF();
    }

    public void a_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        this.P_renamed = animatorListener;
    }

    public void b_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        this.Q_renamed = animatorListener;
    }

    public void a_renamed(int i_renamed, android.graphics.Canvas canvas, android.graphics.Paint paint, java.lang.String[] strArr, int i2, float f_renamed) {
        if (i_renamed == strArr.length - 1) {
            paint.setAlpha(this.f6340b);
            this.H_renamed.setAlpha(this.f6340b);
            this.I_renamed.left = (this.y_renamed[i_renamed] - (this.K_renamed.getBGWidth() / 2)) + 11.0f;
            this.I_renamed.right = (this.y_renamed[i_renamed] + (this.K_renamed.getBGWidth() / 2)) - 11.0f;
            android.graphics.RectF rectF = this.I_renamed;
            rectF.top = this.f_renamed + this.g_renamed;
            rectF.bottom = (this.K_renamed.getHeight() - this.f_renamed) + this.g_renamed;
            float dimensionPixelSize = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_arrange_radius);
            canvas.drawRoundRect(this.I_renamed, dimensionPixelSize, dimensionPixelSize, this.H_renamed);
            canvas.drawText(strArr[i_renamed], this.y_renamed[i_renamed], this.q_renamed, paint);
            return;
        }
        this.G_renamed.setAlpha(i2 == 0 ? 0 : (int) (this.B_renamed[i_renamed] * 0.1f * 255.0f));
        float[] fArr = this.y_renamed;
        float f2 = f_renamed / 2.0f;
        float f3 = fArr[i_renamed] - f2;
        float f4 = this.j_renamed;
        float f5 = f3 - f4;
        int i3 = this.f_renamed;
        float f6 = i3;
        float f7 = f4 + fArr[i_renamed] + f2;
        float f8 = i3 + this.l_renamed;
        float f9 = this.m_renamed;
        canvas.drawRoundRect(f5, f6, f7, f8, f9, f9, this.G_renamed);
        if (i2 == 0) {
            this.J_renamed.setAlpha(0);
        } else {
            this.J_renamed.setAlpha(b_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.c_renamed(strArr[i_renamed])) ? 255 : (int) ((((1.0f - this.B_renamed[i_renamed]) * 0.9d) + 0.10000000149011612d) * 255.0d));
        }
        canvas.drawText(strArr[i_renamed], this.y_renamed[i_renamed], this.p_renamed, this.J_renamed);
    }

    public boolean b_renamed() {
        android.animation.ValueAnimator valueAnimator;
        android.animation.ValueAnimator valueAnimator2 = this.C_renamed;
        return (valueAnimator2 != null && valueAnimator2.isRunning()) || ((valueAnimator = this.D_renamed) != null && valueAnimator.isRunning());
    }

    public void a_renamed(int i_renamed, android.graphics.Canvas canvas, android.graphics.Paint paint, java.lang.String[] strArr, int i2, float f_renamed, float f2, int i3, float f3) {
        float fMeasureText;
        if (i_renamed < (strArr.length - 1) - this.h_renamed) {
            return;
        }
        float f4 = this.l_renamed;
        boolean zA = this.N_renamed.a_renamed(strArr[i_renamed]);
        if (zA) {
            fMeasureText = this.J_renamed.measureText(this.N_renamed.b_renamed(strArr[i_renamed])[0]);
            f4 = this.v_renamed;
        } else {
            fMeasureText = f_renamed;
        }
        android.graphics.Paint.FontMetrics fontMetrics = this.J_renamed.getFontMetrics();
        float f5 = (f4 - (fontMetrics.bottom - fontMetrics.top)) / 2.0f;
        android.graphics.RectF rectF = this.I_renamed;
        float f6 = i3 / 2.0f;
        float f7 = fMeasureText / 2.0f;
        float f8 = this.j_renamed;
        int i4 = this.g_renamed;
        rectF.left = ((f6 - f7) - f8) + i4;
        rectF.right = ((f6 + f7) + f8) - i4;
        rectF.top = ((((this.y_renamed[i_renamed] + fontMetrics.ascent) + fontMetrics.leading) - f5) - this.g_renamed) - 2.0f;
        android.graphics.RectF rectF2 = this.I_renamed;
        rectF2.bottom = rectF2.top + f4;
        if (i_renamed == strArr.length - 1) {
            paint.setAlpha(this.f6340b);
            this.H_renamed.setAlpha(this.f6340b);
            float dimensionPixelSize = com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.headline_arrange_radius);
            canvas.drawRoundRect(this.I_renamed, dimensionPixelSize, dimensionPixelSize, this.H_renamed);
            canvas.drawText(strArr[i_renamed], f2, this.y_renamed[i_renamed], paint);
            return;
        }
        this.G_renamed.setAlpha(i2 == 0 ? 0 : (int) (this.B_renamed[i_renamed] * 0.1f * 255.0f));
        android.graphics.RectF rectF3 = this.I_renamed;
        float f9 = this.m_renamed;
        canvas.drawRoundRect(rectF3, f9, f9, this.G_renamed);
        if (i2 == 0) {
            this.J_renamed.setAlpha(0);
        } else {
            this.J_renamed.setAlpha(b_renamed(com.oplus.camera.ui.menu.a_renamed.c_renamed.c_renamed(strArr[i_renamed])) ? 255 : (int) ((((1.0f - this.B_renamed[i_renamed]) * 0.9d) + 0.10000000149011612d) * 255.0d));
        }
        if (this.y_renamed[i_renamed] < (-f3)) {
            this.J_renamed.setAlpha((int) (this.B_renamed[i_renamed] * 255.0f));
        }
        if (zA) {
            java.lang.String[] strArrB = this.N_renamed.b_renamed(strArr[i_renamed]);
            canvas.drawText(strArrB[0], f2, this.y_renamed[i_renamed] - (this.v_renamed / 2.0f), this.J_renamed);
            canvas.drawText(strArrB[1], f2, this.y_renamed[i_renamed], this.J_renamed);
            return;
        }
        canvas.drawText(strArr[i_renamed], f2, this.y_renamed[i_renamed], this.J_renamed);
    }

    private int g_renamed() {
        if (3 == this.i_renamed) {
            return com.oplus.camera.util.Util.getScreenWidth() / 2;
        }
        return com.oplus.camera.util.Util.getScreenWidth();
    }

    public void a_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
        int i2 = this.i_renamed;
        if (i2 == 3 || i2 == 4) {
            this.k_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.fold_headline_recycle_view_item_padding_left_right);
        } else {
            this.k_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_padding_left_right);
        }
    }

    public void c_renamed() {
        android.animation.ValueAnimator valueAnimator = this.D_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.D_renamed.end();
        this.D_renamed.cancel();
    }

    public boolean d_renamed() {
        android.animation.ValueAnimator valueAnimator = this.C_renamed;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void e_renamed() {
        if (d_renamed()) {
            this.C_renamed.end();
            this.C_renamed.cancel();
        }
    }
}
