package com.oplus.camera.timelapsepro;

/* loaded from: classes2.dex */
public class TimeLapseProParamScaleBar extends com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar {
    private android.animation.ValueAnimator A_renamed;
    private android.animation.ValueAnimator B_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed C_renamed;
    private final int i_renamed;
    private final int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private java.util.List<? extends com.oplus.camera.timelapsepro.a_renamed.g_renamed> n_renamed;
    private final android.graphics.Paint o_renamed;
    private java.lang.String p_renamed;
    private float q_renamed;
    private float r_renamed;
    private float s_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed t_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed u_renamed;
    private com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.c_renamed v_renamed;
    private long w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private int z_renamed;

    public interface a_renamed {
        void a_renamed();

        void a_renamed(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar);
    }

    public interface b_renamed {
        void onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar, int i_renamed);
    }

    public interface c_renamed {
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    public boolean d_renamed() {
        return false;
    }

    public TimeLapseProParamScaleBar(android.content.Context context) {
        this(context, null);
    }

    public TimeLapseProParamScaleBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeLapseProParamScaleBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = true;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = 0L;
        this.x_renamed = true;
        this.y_renamed = false;
        this.z_renamed = 255;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = new com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.1
            @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed, com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
            public void a_renamed(int i2) {
                super.a_renamed(i2);
                if (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.t_renamed == null || com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.f6462c == com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.l_renamed) {
                    return;
                }
                com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.t_renamed.onValueChanged(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this, i2);
                if (com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.m_renamed) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar timeLapseProParamScaleBar = com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this;
                    timeLapseProParamScaleBar.l_renamed = timeLapseProParamScaleBar.f6462c;
                }
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed, com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
            public void a_renamed() {
                super.a_renamed();
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed, com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
            public void a_renamed(boolean z_renamed) {
                super.a_renamed(z_renamed);
                if (z_renamed || com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.u_renamed == null) {
                    return;
                }
                com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.u_renamed.a_renamed();
            }

            @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.c_renamed, com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar.d_renamed
            public void b_renamed() {
                super.b_renamed();
            }
        };
        this.o_renamed = new android.graphics.Paint();
        g_renamed();
        setScaleBarValueChangeListener(this.C_renamed);
        this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height_offset0);
        e_renamed();
        this.j_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_space_gap);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    protected void a_renamed() {
        this.g_renamed = new int[]{0, 0, 0, 0, 0, 0};
        this.h_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_line_height);
        this.f6461b = getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_0_percent_transparency);
    }

    public void setLineSpace(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public void setAutoState(final boolean z_renamed) {
        if (z_renamed) {
            this.C_renamed.a_renamed(this.k_renamed);
        } else {
            this.C_renamed.a_renamed(this.l_renamed);
            com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed bVar = this.t_renamed;
            if (bVar != null) {
                bVar.onValueChanged(this, this.l_renamed);
            }
        }
        a_renamed(!z_renamed, new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$xlfwaDzBjMFpdGiACziW5O8brf0
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.g_renamed(z_renamed);
            }
        }, new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$cLlMrtj8OSzMdwiNQYHg6MarDjg
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.f_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed(boolean z_renamed) {
        this.m_renamed = !z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed(boolean z_renamed) {
        this.m_renamed = !z_renamed;
    }

    public void a_renamed(final boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        super.a_renamed(z_renamed, new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$2ZepaALwnTxHUpHtvX40N4CfGtM
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.e_renamed(z_renamed);
            }
        }, new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$ranlkqjM1bzxzD99u5kjNwnCea4
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.d_renamed(z_renamed);
            }
        });
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    protected void b_renamed() {
        super.b_renamed();
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed aVar = this.u_renamed;
        if (aVar != null) {
            aVar.a_renamed(this);
        }
    }

    public void setValueList(java.util.List<? extends com.oplus.camera.timelapsepro.a_renamed.g_renamed> list) {
        this.n_renamed = list;
        super.setLevelNum(list.size());
        if (this.m_renamed) {
            setTextForDraw(d_renamed(this.f6462c));
        } else {
            setTextForDraw(d_renamed(this.k_renamed));
        }
    }

    public int getCurrentIndex() {
        return this.f6462c;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    public void setCurrentIndex(int i_renamed) {
        super.setCurrentIndex(i_renamed);
        java.util.List<? extends com.oplus.camera.timelapsepro.a_renamed.g_renamed> list = this.n_renamed;
        if (list == null || list.size() <= 0) {
            return;
        }
        setTextForDraw(d_renamed(i_renamed));
    }

    public void setDefaultIndex(int i_renamed) {
        this.k_renamed = i_renamed;
    }

    private void g_renamed() throws android.content.res.Resources.NotFoundException {
        this.o_renamed.setAntiAlias(true);
        this.o_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_80_percent_transparency));
        this.o_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.o_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.o_renamed.setTextSize(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_value_text_size_small));
        this.o_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_radius_size), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dx), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dy), androidx.core.a_renamed.a_renamed.c_renamed(this.f6460a, com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
    }

    private int b_renamed(java.lang.String str) {
        float[] fArr = new float[str.length()];
        this.o_renamed.getTextWidths(str, fArr);
        float f_renamed = 0.0f;
        for (float f2 : fArr) {
            f_renamed += f2;
        }
        return (int) f_renamed;
    }

    private java.lang.String d_renamed(int i_renamed) {
        return android.text.TextUtils.isEmpty(this.n_renamed.get(i_renamed).g__renamed()) ? this.n_renamed.get(i_renamed).f__renamed() : java.lang.String.format("%s_renamed %s_renamed", this.n_renamed.get(i_renamed).f__renamed(), this.n_renamed.get(i_renamed).g__renamed());
    }

    private void setTextForDraw(java.lang.String str) {
        if (str.equals(this.p_renamed)) {
            return;
        }
        this.p_renamed = str;
        this.o_renamed.getTextBounds(str, 0, str.length(), new android.graphics.Rect());
        this.q_renamed = r0.width() >> 1;
        this.s_renamed = r0.height() >> 1;
        this.r_renamed = getMeasuredHeight() - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_text_y_default);
        if (this.v_renamed == null || java.lang.System.currentTimeMillis() - this.w_renamed <= 40) {
            return;
        }
        this.w_renamed = java.lang.System.currentTimeMillis();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    protected void a_renamed(int i_renamed) {
        super.a_renamed(i_renamed);
        java.util.List<? extends com.oplus.camera.timelapsepro.a_renamed.g_renamed> list = this.n_renamed;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k_renamed = i_renamed;
        this.l_renamed = i_renamed;
        setTextForDraw(d_renamed(i_renamed));
    }

    public void setShowText(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProParamScaleBar", "setShowText, showText: " + z_renamed);
        this.x_renamed = z_renamed;
        if (!z_renamed) {
            this.y_renamed = false;
        }
        this.z_renamed = this.x_renamed ? 255 : 0;
        invalidate();
    }

    public void b_renamed(boolean z_renamed) {
        a_renamed(z_renamed, true);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProParamScaleBar", "showTextWithAnim, showText: " + z_renamed + ", anim: " + z2 + ", mbShowText: " + this.x_renamed);
        if (this.x_renamed == z_renamed) {
            return;
        }
        this.x_renamed = z_renamed;
        this.y_renamed = z2;
        if (this.y_renamed) {
            this.z_renamed = this.x_renamed ? 0 : 255;
            if (this.x_renamed) {
                h_renamed();
                return;
            }
            if (this.A_renamed != null) {
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProParamScaleBar", "showTextWithAnim, cancel: ");
                this.A_renamed.cancel();
            }
            i_renamed();
        }
    }

    private void h_renamed() {
        if (this.A_renamed == null) {
            this.A_renamed = android.animation.ValueAnimator.ofInt(0, 255);
            this.A_renamed.setDuration(250L);
            this.A_renamed.setStartDelay(150L);
            this.A_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            this.A_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.z_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.invalidate();
                }
            });
            this.A_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.z_renamed = 0;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.z_renamed = 255;
                }
            });
        }
        this.A_renamed.start();
    }

    private void i_renamed() {
        if (this.B_renamed == null) {
            this.B_renamed = android.animation.ValueAnimator.ofInt(255, 0);
            this.B_renamed.setDuration(250L);
            this.B_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5227a);
            this.B_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.z_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.invalidate();
                }
            });
            this.B_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    super.onAnimationCancel(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.this.z_renamed = 0;
                }
            });
        }
        this.B_renamed.start();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.o_renamed.setAlpha(this.z_renamed);
        if (this.r_renamed < 0.0f) {
            this.r_renamed = getMeasuredHeight() - getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_text_y_default);
        }
        if (this.p_renamed == null || this.z_renamed <= 0) {
            return;
        }
        canvas.save();
        if (getRotation() == 0.0f) {
            a_renamed(canvas, getMeasuredWidth() >> 1, this.r_renamed);
        } else if (getRotation() == 270.0f) {
            canvas.rotate(90.0f, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
            a_renamed(canvas, getMeasuredWidth() - (this.q_renamed + getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_text_margin_vertical)), (getMeasuredHeight() >> 1) + this.s_renamed);
        } else {
            canvas.rotate(270.0f, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
            a_renamed(canvas, this.q_renamed + getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_scale_text_margin_vertical), (getMeasuredHeight() >> 1) + this.s_renamed);
        }
        canvas.restore();
    }

    private void a_renamed(android.graphics.Canvas canvas, float f_renamed, float f2) {
        java.lang.String[] strArrSplit = this.p_renamed.split(" ");
        if (strArrSplit.length > 1) {
            int iB = b_renamed(strArrSplit[0]);
            int iB2 = b_renamed(strArrSplit[1]);
            this.o_renamed.setTextSize(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.blur_menu_seekbar_value_text_size_small));
            canvas.drawText(strArrSplit[0], (f_renamed - (this.j_renamed >> 1)) - (iB2 >> 1), f2, this.o_renamed);
            if (a_renamed(strArrSplit[1])) {
                this.o_renamed.setTextSize(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_guide_title_text_size));
            }
            canvas.drawText(strArrSplit[1], f_renamed + (this.j_renamed >> 1) + (iB >> 1), f2, this.o_renamed);
            return;
        }
        canvas.drawText(this.p_renamed, f_renamed, f2, this.o_renamed);
    }

    public static boolean a_renamed(java.lang.String str) {
        return java.util.regex.Pattern.compile("[一-龥]").matcher(str).find();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.BlurMenuSeekBar
    protected void c_renamed() {
        super.c_renamed();
        com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed aVar = this.u_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    public void setScaleListener(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.b_renamed bVar) {
        this.t_renamed = bVar;
    }

    public void setScaleSpace(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        setScaleSpace(i_renamed);
        setRemainder(i2);
    }

    public void setMoveListener(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.a_renamed aVar) {
        this.u_renamed = aVar;
    }

    public void setTextUpdateListener(com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.c_renamed cVar) {
        this.v_renamed = cVar;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.u_renamed = null;
        this.t_renamed = null;
        this.v_renamed = null;
        super.onDetachedFromWindow();
    }
}
