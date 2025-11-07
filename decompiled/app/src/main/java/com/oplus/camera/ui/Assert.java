package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class OplusNumSeekBar extends android.widget.FrameLayout implements com.oplus.camera.ui.inverse.a_renamed {
    protected float A_renamed;
    protected boolean B_renamed;
    protected boolean C_renamed;
    protected boolean D_renamed;
    protected boolean E_renamed;
    protected android.graphics.Rect F_renamed;
    protected com.coui.appcompat.widget.seekbar.COUISeekBar G_renamed;
    protected float H_renamed;
    protected float I_renamed;
    protected float J_renamed;
    protected float K_renamed;
    protected android.graphics.Paint L_renamed;
    protected android.graphics.Paint M_renamed;
    protected int N_renamed;
    protected int O_renamed;
    protected int P_renamed;
    protected int Q_renamed;
    protected int R_renamed;
    protected boolean S_renamed;
    private int T_renamed;
    private long U_renamed;
    private float V_renamed;
    private float W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f5768a;
    private int aa_renamed;
    private int ab_renamed;
    private int ac_renamed;
    private com.oplus.camera.ui.OplusNumSeekBar.a_renamed ad_renamed;
    private float ae_renamed;
    private float af_renamed;
    private long ag_renamed;
    private long ah_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.lang.String f5769b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f5770c;
    protected int d_renamed;
    protected int e_renamed;
    protected int f_renamed;
    protected int g_renamed;
    protected int h_renamed;
    protected int i_renamed;
    protected int j_renamed;
    protected int k_renamed;
    protected int l_renamed;
    protected int m_renamed;
    protected int n_renamed;
    protected int o_renamed;
    protected int p_renamed;
    protected int q_renamed;
    protected int r_renamed;
    protected int s_renamed;
    protected int t_renamed;
    protected int u_renamed;
    protected int v_renamed;
    protected int w_renamed;
    protected int x_renamed;
    protected int y_renamed;
    protected float z_renamed;

    public interface a_renamed {
        void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed);

        void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed, boolean z_renamed);

        boolean a_renamed();

        void b_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed);
    }

    public OplusNumSeekBar(android.content.Context context) {
        this(context, null);
    }

    public OplusNumSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusNumSeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5768a = false;
        this.f5769b = "";
        this.f5770c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 0;
        this.t_renamed = 0;
        this.u_renamed = 0;
        this.v_renamed = 0;
        this.w_renamed = 0;
        this.x_renamed = 0;
        this.z_renamed = 0.0f;
        this.A_renamed = 0.0f;
        this.B_renamed = false;
        this.C_renamed = false;
        this.D_renamed = false;
        this.E_renamed = false;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = 0.0f;
        this.I_renamed = 0.0f;
        this.J_renamed = 0.0f;
        this.K_renamed = 0.0f;
        this.L_renamed = null;
        this.M_renamed = null;
        this.N_renamed = 0;
        this.O_renamed = 0;
        this.P_renamed = 0;
        this.Q_renamed = 0;
        this.R_renamed = 0;
        this.S_renamed = false;
        this.T_renamed = 0;
        this.U_renamed = 0L;
        this.V_renamed = 0.0f;
        this.W_renamed = 0.0f;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = null;
        this.ae_renamed = 0.0f;
        this.af_renamed = 0.0f;
        this.ag_renamed = 0L;
        this.ah_renamed = 0L;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.OplusNumSeekBar, i_renamed, 0);
        this.N_renamed = typedArrayObtainStyledAttributes.getInt(7, 0);
        this.O_renamed = typedArrayObtainStyledAttributes.getInt(19, 0);
        this.i_renamed = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getInt(5, 100);
        this.T_renamed = typedArrayObtainStyledAttributes.getInt(8, this.i_renamed);
        this.f5770c = typedArrayObtainStyledAttributes.getDimensionPixelSize(46, (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_track_size));
        this.d_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_second_track_size));
        this.p_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_radius_on_dragging));
        this.h_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(29, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_radius));
        this.s_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(32, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_shadow_radius));
        this.e_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_section_radius));
        this.f_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_section_click_radius));
        this.m_renamed = typedArrayObtainStyledAttributes.getColor(44, context.getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.n_renamed = typedArrayObtainStyledAttributes.getColor(45, context.getColor(com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color_inverse));
        this.l_renamed = typedArrayObtainStyledAttributes.getColor(9, com.oplus.camera.util.Util.A_renamed(getContext()));
        this.k_renamed = typedArrayObtainStyledAttributes.getColor(12, context.getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.t_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(42, (int) context.getApplicationContext().getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_text_size));
        this.u_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(28, (int) context.getApplicationContext().getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_text_size));
        this.g_renamed = this.l_renamed;
        this.v_renamed = typedArrayObtainStyledAttributes.getColor(34, this.m_renamed);
        this.w_renamed = typedArrayObtainStyledAttributes.getColor(35, context.getColor(com.oplus.camera.R_renamed.color.inverse_text_color));
        this.U_renamed = typedArrayObtainStyledAttributes.getInteger(0, 200);
        this.o_renamed = typedArrayObtainStyledAttributes.getInteger(14, 0);
        this.x_renamed = typedArrayObtainStyledAttributes.getResourceId(43, 0);
        this.D_renamed = typedArrayObtainStyledAttributes.getBoolean(33, false);
        this.aa_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(37, 0);
        this.ab_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.ac_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_circle_stroke_width));
        this.r_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_thumb_circle_stroke_width_on_dragging));
        this.f5768a = typedArrayObtainStyledAttributes.getBoolean(17, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f5769b = this.f5768a ? "%" : "";
        this.L_renamed = new android.graphics.Paint();
        this.L_renamed.setAntiAlias(true);
        this.L_renamed.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.L_renamed.setTextAlign(android.graphics.Paint.Align.LEFT);
        this.L_renamed.setColor(this.v_renamed);
        this.L_renamed.setTextSize(this.t_renamed);
        this.L_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(false));
        this.M_renamed = new android.graphics.Paint();
        this.M_renamed.setAntiAlias(true);
        this.M_renamed.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.M_renamed.setTextAlign(android.graphics.Paint.Align.LEFT);
        this.M_renamed.setColor(this.v_renamed);
        this.M_renamed.setTextSize(this.u_renamed);
        this.M_renamed.setTypeface(com.oplus.camera.util.Util.y_renamed());
        a_renamed(this.L_renamed);
        this.F_renamed = new android.graphics.Rect();
        e_renamed();
        d_renamed();
    }

    protected void a_renamed(android.graphics.Paint paint) {
        java.lang.String strB = b_renamed(paint);
        this.H_renamed = paint.measureText("-");
        this.I_renamed = paint.measureText(strB);
        this.J_renamed = paint.measureText(strB + strB);
        this.K_renamed = paint.measureText(strB + strB + strB);
    }

    private java.lang.String b_renamed(android.graphics.Paint paint) {
        float f_renamed = 0.0f;
        java.lang.String str = null;
        for (int i_renamed = 0; i_renamed < 10; i_renamed++) {
            java.lang.String strL = com.oplus.camera.util.Util.l_renamed(i_renamed);
            float fMeasureText = paint.measureText(strL);
            if (fMeasureText > f_renamed) {
                str = strL;
                f_renamed = fMeasureText;
            }
        }
        return str;
    }

    private void d_renamed() {
        setClipChildren(false);
        setClipToPadding(false);
        this.m_renamed = getResources().getColor(com.oplus.camera.R_renamed.color.camera_white, getContext().getTheme());
        this.n_renamed = getResources().getColor(com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color_inverse, getContext().getTheme());
        this.v_renamed = this.m_renamed;
        this.w_renamed = getResources().getColor(com.oplus.camera.R_renamed.color.inverse_text_color, getContext().getTheme());
        this.aa_renamed = (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.blur_seekbar_thumb_text_padding_seek_bar);
        a_renamed(android.view.LayoutInflater.from(getContext()).inflate(com.oplus.camera.R_renamed.layout.color_seekbar_layout, (android.view.ViewGroup) this, true));
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        this.G_renamed.setEnabled(z_renamed);
    }

    private void a_renamed(android.view.View view) {
        this.G_renamed = (com.coui.appcompat.widget.seekbar.COUISeekBar) view.findViewById(com.oplus.camera.R_renamed.id_renamed.color_seek_bar);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.G_renamed.getLayoutParams();
        if (1 == this.N_renamed) {
            layoutParams.width = (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.vertical_face_beauty_seekbar_height);
            layoutParams.gravity = 17;
        } else {
            layoutParams.width = -1;
            layoutParams.gravity = 81;
        }
        this.G_renamed.setLayoutParams(layoutParams);
        this.G_renamed.setMax(1000);
        this.G_renamed.setOnSeekBarChangeListener(new com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed() { // from class: com.oplus.camera.ui.OplusNumSeekBar.1
            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed
            public void a_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar, int i_renamed, boolean z_renamed) {
                com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar = com.oplus.camera.ui.OplusNumSeekBar.this;
                oplusNumSeekBar.T_renamed = oplusNumSeekBar.f_renamed(i_renamed);
                if (com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed != null) {
                    com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed;
                    com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar2 = com.oplus.camera.ui.OplusNumSeekBar.this;
                    aVar.a_renamed(oplusNumSeekBar2, oplusNumSeekBar2.T_renamed, z_renamed);
                }
                com.oplus.camera.ui.OplusNumSeekBar.this.postInvalidate();
            }

            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed
            public void a_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar) {
                if (com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed != null) {
                    com.oplus.camera.ui.OplusNumSeekBar.this.setThumbOnDragging(true);
                    com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed;
                    com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar = com.oplus.camera.ui.OplusNumSeekBar.this;
                    aVar.a_renamed(oplusNumSeekBar, oplusNumSeekBar.f_renamed(cOUISeekBar.getProgress()));
                }
            }

            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.b_renamed
            public void b_renamed(com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar) {
                if (com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed != null) {
                    com.oplus.camera.ui.OplusNumSeekBar.this.setThumbOnDragging(false);
                    com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed;
                    com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar = com.oplus.camera.ui.OplusNumSeekBar.this;
                    aVar.b_renamed(oplusNumSeekBar, oplusNumSeekBar.f_renamed(cOUISeekBar.getProgress()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f_renamed(int i_renamed) {
        return this.i_renamed + java.lang.Math.round((this.V_renamed * i_renamed) / this.G_renamed.getMax());
    }

    private void e_renamed() {
        if (this.i_renamed == this.j_renamed) {
            this.i_renamed = 0;
            this.j_renamed = 100;
        }
        int i_renamed = this.i_renamed;
        int i2 = this.j_renamed;
        if (i_renamed > i2) {
            this.j_renamed = i_renamed;
            this.i_renamed = i2;
        }
        int i3 = this.T_renamed;
        int i4 = this.i_renamed;
        if (i3 < i4) {
            this.T_renamed = i4;
        }
        int i5 = this.T_renamed;
        int i6 = this.j_renamed;
        if (i5 > i6) {
            this.T_renamed = i6;
        }
        int i7 = this.d_renamed;
        int i8 = this.f5770c;
        if (i7 < i8) {
            this.d_renamed = i8 + ((int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_height_distance));
        }
        int i9 = this.h_renamed;
        int i10 = this.d_renamed;
        if (i9 <= i10) {
            this.h_renamed = i10 + ((int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.num_seekbar_height_distance));
        }
        this.V_renamed = this.j_renamed - this.i_renamed;
        c_renamed(this.T_renamed);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        this.L_renamed.getTextBounds("0123456789", 0, 10, this.F_renamed);
        java.lang.String minText = getMinText();
        this.L_renamed.getTextBounds(minText, 0, minText.length(), this.F_renamed);
        this.ae_renamed = (getPaddingLeft() + java.lang.Math.max(this.p_renamed, this.F_renamed.width() / 2.0f)) - this.z_renamed;
        java.lang.String maxText = getMaxText();
        this.L_renamed.getTextBounds(maxText, 0, maxText.length(), this.F_renamed);
        this.af_renamed = (getMeasuredWidth() - getPaddingRight()) - java.lang.Math.max(this.p_renamed, this.F_renamed.width() / 2.0f);
        int i3 = this.ab_renamed;
        if (i3 != 0 && i3 > this.ae_renamed) {
            this.ae_renamed = i3;
        }
        if (this.ac_renamed != 0 && getMeasuredWidth() - this.ac_renamed < this.af_renamed) {
            this.af_renamed = getMeasuredWidth() - this.ac_renamed;
        }
        this.W_renamed = this.af_renamed - this.ae_renamed;
    }

    protected int getYTop() {
        return getPaddingTop() + (getHeight() / 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        a_renamed(canvas, getYTop());
    }

    protected void a_renamed(android.graphics.Canvas canvas, float f_renamed) {
        android.graphics.Paint paint = this.L_renamed;
        paint.setColor(this.E_renamed ? this.w_renamed : this.v_renamed);
        paint.getTextBounds("0123456789", 0, 10, this.F_renamed);
        int progress = getProgress();
        java.lang.String str = null;
        boolean z_renamed = 1 == getLayoutDirection();
        if (this.x_renamed != 0) {
            java.lang.String string = getContext().getString(this.x_renamed);
            if (z_renamed) {
                str = " " + string.replaceAll("[d_renamed%٪ ]", "");
            } else {
                str = string.replaceAll("[d_renamed%٪ ]", "").trim() + " ";
            }
        }
        float fMeasureText = str == null ? 0.0f : paint.measureText(str);
        float fE_renamed = e_renamed(progress);
        float fMeasureText2 = paint.measureText(this.f5769b);
        float fE2 = e_renamed(100) + fMeasureText + fMeasureText2;
        float width = this.A_renamed;
        if (this.D_renamed) {
            width = (((getWidth() - getPaddingStart()) - getPaddingEnd()) - fE2) / 2.0f;
            f_renamed = (f_renamed - this.aa_renamed) - getPaddingTop();
        }
        float fA_renamed = a_renamed(paint, f_renamed, this.F_renamed);
        if (z_renamed) {
            float paddingEnd = width + getPaddingEnd();
            if (str != null) {
                canvas.drawText(str, (getWidth() - paddingEnd) - fMeasureText, fA_renamed, this.L_renamed);
            }
            canvas.drawText(com.oplus.camera.util.Util.l_renamed(progress), ((getWidth() - paddingEnd) - fMeasureText) - fE_renamed, fA_renamed, this.L_renamed);
            canvas.drawText(this.f5769b, (((getWidth() - paddingEnd) - fMeasureText) - fE_renamed) - fMeasureText2, fA_renamed, this.L_renamed);
            return;
        }
        float paddingStart = width + getPaddingStart();
        if (str != null) {
            canvas.drawText(str, paddingStart, fA_renamed, this.L_renamed);
        }
        float f2 = paddingStart + fMeasureText;
        canvas.drawText(com.oplus.camera.util.Util.l_renamed(progress), f2, fA_renamed, this.L_renamed);
        canvas.drawText(this.f5769b, f2 + fE_renamed, fA_renamed, this.L_renamed);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.R_renamed) {
            return;
        }
        this.R_renamed = i2;
        if (z_renamed) {
            this.Q_renamed = this.P_renamed;
            this.ag_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.R_renamed - this.P_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.S_renamed = i3 >= 0;
            this.ah_renamed = this.ag_renamed + ((java.lang.Math.abs(i3) * 1000) / 360);
        } else {
            this.P_renamed = this.R_renamed;
        }
        invalidate();
    }

    protected void a_renamed() {
        int i_renamed;
        if (this.P_renamed != this.R_renamed) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.ah_renamed) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.ag_renamed);
                int i3 = this.Q_renamed;
                if (!this.S_renamed) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    i_renamed = i4 % 360;
                } else {
                    i_renamed = (i4 % 360) + 360;
                }
                this.P_renamed = i_renamed;
                invalidate();
                return;
            }
            this.P_renamed = this.R_renamed;
        }
    }

    protected float a_renamed(android.graphics.Paint paint, float f_renamed, android.graphics.Rect rect) {
        return f_renamed - rect.height();
    }

    public void b_renamed() {
        animate().setDuration(this.U_renamed).setListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.OplusNumSeekBar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.OplusNumSeekBar.this.setThumbOnDragging(false);
                com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar = com.oplus.camera.ui.OplusNumSeekBar.this;
                oplusNumSeekBar.B_renamed = false;
                oplusNumSeekBar.invalidate();
                if (com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed != null) {
                    com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = com.oplus.camera.ui.OplusNumSeekBar.this.ad_renamed;
                    com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar2 = com.oplus.camera.ui.OplusNumSeekBar.this;
                    aVar.a_renamed(oplusNumSeekBar2, oplusNumSeekBar2.getProgress(), true);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                super.onAnimationStart(animator);
                com.oplus.camera.ui.OplusNumSeekBar.this.setThumbOnDragging(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.OplusNumSeekBar.this.setThumbOnDragging(false);
                com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar = com.oplus.camera.ui.OplusNumSeekBar.this;
                oplusNumSeekBar.B_renamed = false;
                oplusNumSeekBar.invalidate();
            }
        }).start();
        com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = this.ad_renamed;
        if (aVar != null) {
            aVar.b_renamed(this, getProgress());
        }
    }

    private java.lang.String getMinText() {
        return com.oplus.camera.util.Util.l_renamed(-50);
    }

    private java.lang.String getMaxText() {
        return com.oplus.camera.util.Util.l_renamed(this.j_renamed);
    }

    public float getMin() {
        return this.i_renamed;
    }

    public com.oplus.camera.ui.OplusNumSeekBar a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        this.V_renamed = this.j_renamed - this.i_renamed;
        return this;
    }

    public com.oplus.camera.ui.OplusNumSeekBar b_renamed(int i_renamed) {
        this.i_renamed = i_renamed;
        this.V_renamed = this.j_renamed - this.i_renamed;
        this.G_renamed.setStartFromMiddle(i_renamed < 0);
        return this;
    }

    public float getMax() {
        return this.j_renamed;
    }

    public com.oplus.camera.ui.OplusNumSeekBar c_renamed(int i_renamed) {
        if (this.T_renamed != i_renamed) {
            this.T_renamed = i_renamed;
            com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = this.ad_renamed;
            if (aVar != null) {
                aVar.a_renamed(this, getProgress(), false);
            }
        }
        if (!this.C_renamed) {
            this.A_renamed = ((this.W_renamed / this.V_renamed) * (this.T_renamed - this.i_renamed)) + this.ae_renamed;
        }
        com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = this.G_renamed;
        if (cOUISeekBar != null && 0.0f != this.V_renamed) {
            cOUISeekBar.setProgress((int) (((this.T_renamed - this.i_renamed) * cOUISeekBar.getMax()) / this.V_renamed));
        }
        return this;
    }

    public int getProgress() {
        return this.T_renamed;
    }

    public void setOnProgressChangedListener(com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar) {
        this.ad_renamed = aVar;
    }

    public boolean c_renamed() {
        return this.C_renamed;
    }

    public void setThumbOnDragging(boolean z_renamed) {
        this.C_renamed = z_renamed;
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.T_renamed);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof android.os.Bundle) {
            android.os.Bundle bundle = (android.os.Bundle) parcelable;
            this.T_renamed = bundle.getInt("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            c_renamed(this.T_renamed);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public com.oplus.camera.ui.OplusNumSeekBar d_renamed(int i_renamed) {
        this.o_renamed = i_renamed;
        return this;
    }

    public void setInverseColor(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        this.E_renamed = z_renamed;
        android.graphics.Paint paint = this.L_renamed;
        if (paint != null) {
            paint.setColor(z_renamed ? this.w_renamed : this.v_renamed);
            this.M_renamed.setColor(z_renamed ? this.w_renamed : this.v_renamed);
        }
        a_renamed("mBackgroundColor", getResources().getColorStateList(this.E_renamed ? com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color_inverse : com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }

    protected float e_renamed(int i_renamed) {
        if (i_renamed < 0) {
            return this.H_renamed + e_renamed(java.lang.Math.abs(getProgress()));
        }
        if (i_renamed < 10) {
            return this.I_renamed;
        }
        if (i_renamed < 100) {
            return this.J_renamed;
        }
        return this.K_renamed;
    }

    protected void a_renamed(java.lang.String str, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        try {
            java.lang.reflect.Field declaredField = this.G_renamed.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(this.G_renamed, obj);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("OplusNumSeekBar", "reflectSomethingNeed, something may be_renamed wrong: " + e_renamed);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = this.G_renamed;
        if (cOUISeekBar != null) {
            cOUISeekBar.invalidate();
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        super.postInvalidate();
        com.coui.appcompat.widget.seekbar.COUISeekBar cOUISeekBar = this.G_renamed;
        if (cOUISeekBar != null) {
            cOUISeekBar.postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar = this.ad_renamed;
        if (aVar == null || aVar.a_renamed()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
