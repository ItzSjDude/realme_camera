package com.oplus.camera.ui.widget;

/* compiled from: VideoClipView.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.view.ViewGroup implements android.view.View.OnClickListener, com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener {
    private com.oplus.camera.ui.widget.e_renamed.b_renamed A_renamed;
    private android.graphics.RectF B_renamed;
    private android.graphics.RectF C_renamed;
    private android.graphics.RectF D_renamed;
    private android.graphics.RectF E_renamed;
    private android.graphics.RectF F_renamed;
    private android.graphics.RectF G_renamed;
    private android.graphics.RectF H_renamed;
    private android.graphics.NinePatch I_renamed;
    private java.text.DecimalFormat J_renamed;
    private float K_renamed;
    private float L_renamed;
    private float M_renamed;
    private android.graphics.Bitmap N_renamed;
    private boolean O_renamed;
    private boolean P_renamed;
    private boolean Q_renamed;
    private float R_renamed;
    private float S_renamed;
    private int T_renamed;
    private boolean U_renamed;
    private boolean V_renamed;
    private android.graphics.RectF W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.meicam.sdk.NvsLiveWindow f7269a;
    private boolean aa_renamed;
    private boolean ab_renamed;
    private android.graphics.Paint ac_renamed;
    private android.graphics.Paint ad_renamed;
    private int ae_renamed;
    private boolean af_renamed;
    private android.os.Handler ag_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.meicam.sdk.NvsMultiThumbnailSequenceView f7270b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.RotateImageView f7271c;
    private com.oplus.camera.ui.RotateImageView d_renamed;
    private com.coui.appcompat.dialog.app.c_renamed e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private float p_renamed;
    private float q_renamed;
    private float r_renamed;
    private float s_renamed;
    private float t_renamed;
    private float u_renamed;
    private float v_renamed;
    private float w_renamed;
    private float x_renamed;
    private float y_renamed;
    private com.oplus.camera.ui.widget.e_renamed.a_renamed z_renamed;

    /* compiled from: VideoClipView.java */
    public interface a_renamed {
        void c_renamed(float f_renamed);

        void d_renamed(float f_renamed);

        void k_renamed();
    }

    /* compiled from: VideoClipView.java */
    public interface b_renamed {
        void a_renamed(float f_renamed, float f2);

        void eB_renamed();
    }

    public e_renamed(android.content.Context context) {
        super(context);
        this.f7269a = null;
        this.f7270b = null;
        this.f7271c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH;
        this.l_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 1.7777778f;
        this.p_renamed = 0.0f;
        this.q_renamed = 0.0f;
        this.r_renamed = 0.0f;
        this.s_renamed = 15.0f;
        this.t_renamed = 1.0f;
        this.u_renamed = 0.0f;
        this.v_renamed = 0.0f;
        this.w_renamed = 1.0f;
        this.x_renamed = 0.0f;
        this.y_renamed = 0.0f;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = new android.graphics.RectF();
        this.C_renamed = new android.graphics.RectF();
        this.D_renamed = new android.graphics.RectF();
        this.E_renamed = new android.graphics.RectF();
        this.F_renamed = new android.graphics.RectF();
        this.G_renamed = new android.graphics.RectF();
        this.H_renamed = new android.graphics.RectF();
        this.J_renamed = new java.text.DecimalFormat("00");
        this.K_renamed = 0.0f;
        this.L_renamed = 0.0f;
        this.M_renamed = 0.0f;
        this.N_renamed = null;
        this.O_renamed = false;
        this.P_renamed = false;
        this.Q_renamed = false;
        this.R_renamed = 0.0f;
        this.S_renamed = 0.0f;
        this.T_renamed = 0;
        this.U_renamed = false;
        this.V_renamed = false;
        this.W_renamed = new android.graphics.RectF();
        this.aa_renamed = false;
        this.ab_renamed = false;
        this.ac_renamed = new android.graphics.Paint();
        this.ad_renamed = new android.graphics.Paint();
        this.ae_renamed = 0;
        this.af_renamed = false;
        this.ag_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.widget.e_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (1 == message.what) {
                    if (com.oplus.camera.ui.widget.e_renamed.this.z_renamed == null || !com.oplus.camera.ui.widget.e_renamed.this.Q_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.widget.e_renamed.this.Q_renamed = false;
                    com.oplus.camera.ui.widget.e_renamed.this.z_renamed.d_renamed(-1.0f);
                    return;
                }
                if (2 == message.what) {
                    com.oplus.camera.ui.widget.e_renamed.this.f7270b.updateThumbnails();
                    if (((android.view.ViewGroup) com.oplus.camera.ui.widget.e_renamed.this.f7270b.getChildAt(0)).getChildCount() == 0) {
                        com.oplus.camera.ui.widget.e_renamed.this.ag_renamed.sendEmptyMessageDelayed(2, 100L);
                    }
                }
            }
        };
        f_renamed();
    }

    private void f_renamed() {
        this.ac_renamed.setAntiAlias(true);
        this.ac_renamed.setTextSize(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_time_text_size));
        this.ac_renamed.setColor(-1);
        this.ac_renamed.setShadowLayer(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(com.oplus.camera.R_renamed.color.num_seekbar_thumb_text_shadow_color, null));
        this.ad_renamed.setAntiAlias(true);
        this.ad_renamed.setColor(-16777216);
        this.ae_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_time_margin_bottom);
        this.P_renamed = true;
        this.N_renamed = android.graphics.BitmapFactory.decodeResource(getResources(), com.oplus.camera.R_renamed.drawable.time_line);
        this.f7269a = new com.meicam.sdk.NvsLiveWindow(getContext());
        addView(this.f7269a, new android.view.ViewGroup.MarginLayoutParams(-2, -2));
        this.f_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_height);
        this.g_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_margin_bottom);
        this.h_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_margin_left);
        this.i_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_move_boundary);
        this.j_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_offset);
        this.f7270b = new com.meicam.sdk.NvsMultiThumbnailSequenceView(getContext());
        addView(this.f7270b, new android.view.ViewGroup.MarginLayoutParams(-1, this.f_renamed));
        this.f7270b.setOnScrollChangeListenser(this);
        this.f7270b.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.widget.e_renamed.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                if (1 != motionEvent.getAction() || 15.0f >= com.oplus.camera.ui.widget.e_renamed.this.p_renamed) {
                    return false;
                }
                com.oplus.camera.ui.widget.e_renamed.this.Q_renamed = true;
                com.oplus.camera.ui.widget.e_renamed.this.ag_renamed.removeMessages(1);
                com.oplus.camera.ui.widget.e_renamed.this.ag_renamed.sendEmptyMessageDelayed(1, 50L);
                return false;
            }
        });
        this.f7271c = new com.oplus.camera.ui.RotateImageView(getContext());
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_back_margin_left);
        this.f7271c.setImageResource(com.oplus.camera.R_renamed.drawable.btn_revert_pics_drawable);
        addView(this.f7271c, marginLayoutParams);
        this.f7271c.setOnClickListener(this);
        this.d_renamed = new com.oplus.camera.ui.RotateImageView(getContext());
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams2 = new android.view.ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams2.bottomMargin = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_clip_view_thumb_next_margin_bottom);
        this.d_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.ic_next_step);
        addView(this.d_renamed, marginLayoutParams2);
        this.d_renamed.setOnClickListener(this);
        android.graphics.Bitmap bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(getResources(), com.oplus.camera.R_renamed.drawable.video_editor_trim_normal);
        this.I_renamed = new android.graphics.NinePatch(bitmapDecodeResource, bitmapDecodeResource.getNinePatchChunk(), null);
        this.n_renamed = getContext().getResources().getDisplayMetrics().widthPixels;
        this.m_renamed = (int) (this.n_renamed * this.o_renamed);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i3 - i_renamed;
        int i10 = i4 - i2;
        int i11 = i10 - ((i10 - this.m_renamed) / 2);
        boolean z2 = 1 == getLayoutDirection();
        int i12 = this.k_renamed;
        int i13 = this.l_renamed;
        if (i12 > i13) {
            int i14 = this.m_renamed;
            i6 = (i10 - i14) / 2;
            i7 = (i13 * i14) / i12;
            i8 = (i9 - i7) / 2;
            i5 = i14;
        } else {
            int i15 = this.n_renamed;
            i5 = (i12 * i15) / i13;
            i6 = (i10 - i5) / 2;
            i7 = i15;
            i8 = i_renamed;
        }
        int i16 = this.m_renamed;
        if (i5 > i16) {
            i5 = i16;
        }
        int i17 = this.n_renamed;
        if (i7 > i17) {
            i7 = i17;
        }
        this.f7269a.layout(i8, i6, i7 + i8, i5 + i6);
        int i18 = 15.0f < this.p_renamed ? i_renamed : this.h_renamed + this.j_renamed;
        int i19 = 15.0f < this.p_renamed ? i3 : (i3 - this.h_renamed) - this.j_renamed;
        int i20 = this.g_renamed + ((i10 - this.m_renamed) / 2);
        this.f7270b.layout(i18, (i4 - this.f_renamed) - i20, i19, i4 - i20);
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.d_renamed.getLayoutParams();
        int intrinsicWidth = this.d_renamed.getDrawable().getIntrinsicWidth();
        int intrinsicWidth2 = this.d_renamed.getDrawable().getIntrinsicWidth();
        int i21 = (i9 - intrinsicWidth) / 2;
        int i22 = (i11 - intrinsicWidth2) - marginLayoutParams.bottomMargin;
        this.d_renamed.layout(i21, i22, intrinsicWidth + i21, i22 + intrinsicWidth2);
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams2 = (android.view.ViewGroup.MarginLayoutParams) this.f7271c.getLayoutParams();
        int intrinsicWidth3 = this.f7271c.getDrawable().getIntrinsicWidth();
        int intrinsicWidth4 = this.f7271c.getDrawable().getIntrinsicWidth();
        int i23 = i22 + ((intrinsicWidth2 - intrinsicWidth4) / 2);
        int i24 = z2 ? (i9 - marginLayoutParams2.leftMargin) - intrinsicWidth3 : marginLayoutParams2.leftMargin;
        this.f7271c.layout(i24, i23, intrinsicWidth3 + i24, intrinsicWidth4 + i23);
        android.graphics.Rect rect = new android.graphics.Rect();
        this.f7270b.getHitRect(rect);
        if (!rect.contains((int) this.R_renamed, (int) this.S_renamed) && !this.O_renamed && this.P_renamed) {
            this.P_renamed = false;
            this.B_renamed.set(i_renamed, this.f7270b.getTop(), i3, this.f7270b.getBottom());
            this.G_renamed.set(this.B_renamed);
            android.graphics.RectF rectF = this.G_renamed;
            int i25 = this.h_renamed;
            rectF.left = i_renamed + i25;
            rectF.right = i3 - i25;
            this.H_renamed.set(rectF);
            this.E_renamed.set(this.G_renamed);
            android.graphics.RectF rectF2 = this.E_renamed;
            rectF2.right = rectF2.left + this.j_renamed;
            this.F_renamed.set(this.G_renamed);
            android.graphics.RectF rectF3 = this.F_renamed;
            rectF3.left = rectF3.right - this.j_renamed;
            this.B_renamed.left = this.E_renamed.right;
            this.B_renamed.right = this.F_renamed.left;
            this.D_renamed.set(this.B_renamed);
            this.W_renamed.setEmpty();
            float f_renamed = this.p_renamed;
            if (15.0f < f_renamed) {
                this.r_renamed = (f_renamed / this.s_renamed) * this.D_renamed.width();
                this.f7270b.setPixelPerMicrosecond(this.r_renamed / this.q_renamed);
                this.f7270b.setStartPadding((int) (this.D_renamed.left - getLeft()));
                this.f7270b.setEndPadding((int) (getRight() - this.D_renamed.right));
                this.r_renamed += this.f7270b.getStartPadding();
                this.r_renamed += this.f7270b.getEndPadding();
                float scrollX = this.f7270b.getScrollX() + (this.B_renamed.left - this.D_renamed.left);
                this.v_renamed = scrollX / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
                this.w_renamed = (scrollX + this.B_renamed.width()) / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
            } else {
                this.r_renamed = this.f7270b.getWidth();
                this.f7270b.setPixelPerMicrosecond((r11.getWidth() * 1.0f) / this.q_renamed);
                this.f7270b.setStartPadding(0);
                this.f7270b.setEndPadding(0);
                this.v_renamed = 0.0f;
                this.w_renamed = 1.0f;
            }
            this.y_renamed = this.v_renamed;
            setCurrentTime(getSelectTimeRatio() * this.s_renamed);
            this.f7270b.updateThumbnails();
            this.f7270b.stopNestedScroll();
            this.f7270b.scrollTo(0, 0);
            this.f7270b.scrollBy(0, 0);
            this.f7270b.smoothScrollBy(0, 0);
            this.f7270b.smoothScrollTo(0, 0);
        }
        g_renamed();
        if (((android.view.ViewGroup) this.f7270b.getChildAt(0)).getChildCount() == 0 && this.V_renamed) {
            this.V_renamed = false;
            this.ag_renamed.removeMessages(2);
            this.ag_renamed.sendEmptyMessage(2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        canvas.drawColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency, null));
        super.dispatchDraw(canvas);
        java.lang.String str = "00:" + this.J_renamed.format(this.u_renamed);
        canvas.drawText(str, (getWidth() - this.ac_renamed.measureText(str)) / 2.0f, this.f7270b.getTop() - this.ae_renamed, this.ac_renamed);
        this.ad_renamed.setAlpha(127);
        float scrollX = this.D_renamed.left - this.f7270b.getScrollX();
        if (scrollX < getLeft()) {
            scrollX = getLeft();
        }
        canvas.drawRect(scrollX, this.D_renamed.top, this.B_renamed.left, this.D_renamed.bottom, this.ad_renamed);
        float scrollX2 = this.D_renamed.right + ((this.r_renamed - this.f7270b.getScrollX()) - this.f7270b.getWidth());
        if (scrollX2 > getRight()) {
            scrollX2 = getRight();
        }
        canvas.drawRect(this.B_renamed.right, this.D_renamed.top, scrollX2, this.D_renamed.bottom, this.ad_renamed);
        if (!this.W_renamed.isEmpty() && (this.aa_renamed || this.W_renamed.right > this.H_renamed.right || this.W_renamed.left < this.H_renamed.left)) {
            this.I_renamed.draw(canvas, this.W_renamed);
        } else {
            this.I_renamed.draw(canvas, this.G_renamed);
        }
        if (this.E_renamed.contains(this.K_renamed, this.L_renamed) || this.F_renamed.contains(this.K_renamed, this.L_renamed)) {
            return;
        }
        float fWidth = this.B_renamed.left + (this.B_renamed.width() * this.x_renamed);
        float width = this.N_renamed.getWidth() + fWidth;
        float height = this.B_renamed.top - ((this.N_renamed.getHeight() - this.B_renamed.height()) / 2.0f);
        float f_renamed = this.B_renamed.right;
        if (width > f_renamed) {
            fWidth = f_renamed - this.N_renamed.getWidth();
        }
        this.ad_renamed.setAlpha(255);
        canvas.drawBitmap(this.N_renamed, fWidth, height, this.ad_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.R_renamed = (int) motionEvent.getX();
            this.S_renamed = (int) motionEvent.getY();
            this.O_renamed = true;
        } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.R_renamed = 0.0f;
            this.S_renamed = 0.0f;
            this.O_renamed = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.E_renamed.contains(this.R_renamed, this.S_renamed) || this.F_renamed.contains(this.R_renamed, this.S_renamed) || this.C_renamed.contains(this.R_renamed, this.S_renamed)) {
            this.ab_renamed = 1 != motionEvent.getAction();
            return true;
        }
        if (motionEvent.getAction() == 0) {
            android.graphics.RectF rectF = new android.graphics.RectF(this.G_renamed.right, this.G_renamed.top, this.G_renamed.right + this.j_renamed, this.G_renamed.bottom);
            android.graphics.RectF rectF2 = new android.graphics.RectF(this.G_renamed.right - (this.j_renamed * 2), this.G_renamed.top, this.G_renamed.right - this.j_renamed, this.G_renamed.bottom);
            android.graphics.RectF rectF3 = new android.graphics.RectF(this.G_renamed.left - this.j_renamed, this.G_renamed.top, this.G_renamed.left, this.G_renamed.bottom);
            android.graphics.RectF rectF4 = new android.graphics.RectF(this.G_renamed.left + this.j_renamed, this.G_renamed.top, this.G_renamed.left + (this.j_renamed * 2), this.G_renamed.bottom);
            float fWidth = this.B_renamed.left + (this.B_renamed.width() * this.x_renamed);
            float width = this.N_renamed.getWidth() + fWidth;
            float height = this.B_renamed.top - ((this.N_renamed.getHeight() - this.B_renamed.height()) / 2.0f);
            float f_renamed = this.B_renamed.right;
            if (width > f_renamed) {
                fWidth = f_renamed - this.N_renamed.getWidth();
            }
            this.C_renamed.set(fWidth, height, this.N_renamed.getWidth() + fWidth, this.N_renamed.getHeight() + height);
            this.C_renamed.left -= this.N_renamed.getWidth();
            this.C_renamed.right += this.N_renamed.getWidth();
            float x_renamed = motionEvent.getX();
            float y_renamed = motionEvent.getY();
            this.ab_renamed = rectF3.contains(x_renamed, y_renamed) || rectF2.contains(x_renamed, y_renamed) || rectF.contains(x_renamed, y_renamed) || rectF4.contains(x_renamed, y_renamed) || this.C_renamed.contains(x_renamed, y_renamed);
        } else if (this.ab_renamed) {
            this.ab_renamed = 1 != motionEvent.getAction();
            return true;
        }
        return this.ab_renamed;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && !this.U_renamed) {
            if (motionEvent.getAction() == 0) {
                this.K_renamed = (int) motionEvent.getX();
                this.L_renamed = (int) motionEvent.getY();
                this.M_renamed = motionEvent.getX();
                if (this.z_renamed != null && this.C_renamed.contains(this.K_renamed, this.L_renamed)) {
                    this.af_renamed = true;
                    this.z_renamed.c_renamed(this.y_renamed);
                } else {
                    android.graphics.RectF rectF = new android.graphics.RectF(this.G_renamed.right, this.G_renamed.top, this.G_renamed.right + this.j_renamed, this.G_renamed.bottom);
                    android.graphics.RectF rectF2 = new android.graphics.RectF(this.G_renamed.right - (this.j_renamed * 2), this.G_renamed.top, this.G_renamed.right - this.j_renamed, this.G_renamed.bottom);
                    android.graphics.RectF rectF3 = new android.graphics.RectF(this.G_renamed.left - this.j_renamed, this.G_renamed.top, this.G_renamed.left, this.G_renamed.bottom);
                    android.graphics.RectF rectF4 = new android.graphics.RectF(this.G_renamed.left + this.j_renamed, this.G_renamed.top, this.G_renamed.left + (this.j_renamed * 2), this.G_renamed.bottom);
                    if (this.D_renamed.contains(this.K_renamed, this.L_renamed) && (rectF3.contains(this.K_renamed, this.L_renamed) || rectF4.contains(this.K_renamed, this.L_renamed))) {
                        android.graphics.RectF rectF5 = this.G_renamed;
                        rectF5.left = this.K_renamed - (this.j_renamed / 2.0f);
                        this.E_renamed.set(rectF5);
                        android.graphics.RectF rectF6 = this.E_renamed;
                        rectF6.right = rectF6.left + this.j_renamed;
                    } else if (this.D_renamed.contains(this.K_renamed, this.L_renamed) && (rectF.contains(this.K_renamed, this.L_renamed) || rectF2.contains(this.K_renamed, this.L_renamed))) {
                        android.graphics.RectF rectF7 = this.G_renamed;
                        rectF7.right = this.K_renamed + (this.j_renamed / 2.0f);
                        this.F_renamed.set(rectF7);
                        android.graphics.RectF rectF8 = this.F_renamed;
                        rectF8.left = rectF8.right - this.j_renamed;
                    }
                    this.W_renamed.set(this.G_renamed);
                }
            }
            if (!a_renamed(this.K_renamed, this.L_renamed) && !this.af_renamed) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                float fWidth = ((this.t_renamed / 15.0f) * this.D_renamed.width()) + (this.j_renamed * 2);
                if (this.z_renamed != null && (15.0f < this.p_renamed || a_renamed(this.K_renamed, this.L_renamed) || this.af_renamed)) {
                    this.z_renamed.d_renamed(this.af_renamed ? this.y_renamed : -1.0f);
                }
                if (this.G_renamed.left <= this.H_renamed.left && this.G_renamed.width() <= fWidth) {
                    this.G_renamed.left = this.H_renamed.left;
                    android.graphics.RectF rectF9 = this.G_renamed;
                    rectF9.right = rectF9.left + fWidth;
                }
                if (this.W_renamed.left <= this.H_renamed.left && this.W_renamed.width() <= fWidth) {
                    this.W_renamed.set(this.G_renamed);
                }
                if (this.G_renamed.right >= this.H_renamed.right && this.G_renamed.width() <= fWidth) {
                    this.G_renamed.right = this.H_renamed.right;
                    android.graphics.RectF rectF10 = this.G_renamed;
                    rectF10.left = rectF10.right - fWidth;
                }
                if (this.W_renamed.right >= this.H_renamed.right && this.W_renamed.width() <= fWidth) {
                    this.W_renamed.set(this.G_renamed);
                }
                this.B_renamed.left = this.G_renamed.left + this.j_renamed;
                this.B_renamed.right = this.G_renamed.right - this.j_renamed;
                this.E_renamed.set(this.G_renamed);
                android.graphics.RectF rectF11 = this.E_renamed;
                rectF11.right = rectF11.left + this.j_renamed;
                this.F_renamed.set(this.G_renamed);
                android.graphics.RectF rectF12 = this.F_renamed;
                rectF12.left = rectF12.right - this.j_renamed;
                this.K_renamed = 0.0f;
                this.L_renamed = 0.0f;
                this.R_renamed = 0.0f;
                this.S_renamed = 0.0f;
                this.af_renamed = false;
                setCurrentTime(getSelectTimeRatio() * this.s_renamed);
                if (this.W_renamed.right > this.H_renamed.right) {
                    b_renamed(false);
                }
                if (this.W_renamed.left < this.H_renamed.left) {
                    b_renamed(true);
                }
                com.oplus.camera.ui.widget.e_renamed.a_renamed aVar = this.z_renamed;
                if (aVar != null && 15.0f <= this.u_renamed) {
                    aVar.k_renamed();
                }
            } else if (action == 2) {
                if (!this.af_renamed && (this.E_renamed.contains(this.K_renamed, this.L_renamed) || this.F_renamed.contains(this.K_renamed, this.L_renamed))) {
                    a_renamed(motionEvent);
                } else if (this.af_renamed && (this.B_renamed.contains(this.C_renamed.left, this.C_renamed.centerY()) || (this.B_renamed.left < motionEvent.getX() && this.B_renamed.right > motionEvent.getX()))) {
                    this.x_renamed = ((motionEvent.getX() < this.B_renamed.left ? this.B_renamed.left : motionEvent.getX()) - this.B_renamed.left) / this.B_renamed.width();
                    float f_renamed = this.v_renamed;
                    this.y_renamed = f_renamed + (this.x_renamed * (this.w_renamed - f_renamed));
                    g_renamed();
                    this.z_renamed.c_renamed(this.y_renamed);
                }
            }
            invalidate();
        }
        return true;
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        float x_renamed = motionEvent.getX();
        float f_renamed = x_renamed - this.M_renamed;
        boolean z_renamed = 0.0f <= f_renamed;
        boolean zContains = this.E_renamed.contains(this.K_renamed, this.L_renamed);
        boolean zContains2 = this.F_renamed.contains(this.K_renamed, this.L_renamed);
        float fWidth = ((this.t_renamed / 15.0f) * this.D_renamed.width()) + (this.j_renamed * 2);
        if (zContains) {
            float left = getLeft() + this.i_renamed;
            if (this.W_renamed.left > this.H_renamed.left) {
                this.G_renamed.left += f_renamed;
                this.W_renamed.left = this.G_renamed.left;
            } else {
                this.W_renamed.left += f_renamed;
                this.G_renamed.left = this.H_renamed.left;
            }
            if (this.G_renamed.width() < fWidth) {
                if (this.G_renamed.right >= this.H_renamed.right) {
                    this.G_renamed.right = this.H_renamed.right;
                } else {
                    this.G_renamed.right += f_renamed;
                }
                this.W_renamed.right = this.G_renamed.right;
            }
            if (this.W_renamed.left <= left) {
                this.W_renamed.left = left;
            }
        } else if (zContains2) {
            float right = getRight() - this.i_renamed;
            if (this.W_renamed.right < this.H_renamed.right) {
                this.G_renamed.right += f_renamed;
                this.W_renamed.right = this.G_renamed.right;
            } else {
                this.W_renamed.right += f_renamed;
                this.G_renamed.right = this.H_renamed.right;
            }
            if (this.G_renamed.width() < fWidth) {
                if (this.G_renamed.left <= this.H_renamed.left) {
                    this.G_renamed.left = this.H_renamed.left;
                } else {
                    this.G_renamed.left += f_renamed;
                }
                this.W_renamed.left = this.G_renamed.left;
            }
            if (this.W_renamed.right >= right) {
                this.W_renamed.right = right;
            }
        }
        if (zContains || zContains2) {
            if (this.G_renamed.width() <= fWidth && 0.0f != f_renamed) {
                if (z_renamed && this.G_renamed.right >= this.H_renamed.right) {
                    this.G_renamed.left = this.H_renamed.right - fWidth;
                    this.G_renamed.right = this.H_renamed.right;
                } else if (this.G_renamed.left <= this.H_renamed.left) {
                    this.G_renamed.left = this.H_renamed.left;
                    this.G_renamed.right = this.H_renamed.left + fWidth;
                }
            }
            if (this.G_renamed.left < this.H_renamed.left) {
                this.G_renamed.left = this.H_renamed.left;
            }
            if (this.G_renamed.right > this.H_renamed.right) {
                this.G_renamed.right = this.H_renamed.right;
            }
            this.B_renamed.left = this.G_renamed.left + this.j_renamed;
            this.B_renamed.right = this.G_renamed.right - this.j_renamed;
            this.x_renamed = 0.0f;
            float scrollX = this.f7270b.getScrollX() + (this.B_renamed.left - this.D_renamed.left);
            this.v_renamed = scrollX / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
            this.w_renamed = (scrollX + this.B_renamed.width()) / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
            float f2 = this.E_renamed.contains(this.K_renamed, this.L_renamed) ? this.v_renamed : this.w_renamed;
            setCurrentTime(getSelectTimeRatio() * this.s_renamed);
            com.oplus.camera.ui.widget.e_renamed.a_renamed aVar = this.z_renamed;
            if (aVar != null && f2 != this.y_renamed) {
                aVar.c_renamed(f2);
            }
            this.y_renamed = f2;
            this.M_renamed = x_renamed;
        }
    }

    private void b_renamed(final boolean z_renamed) {
        float f_renamed = z_renamed ? this.W_renamed.left : this.W_renamed.right;
        final float f2 = z_renamed ? this.H_renamed.left : this.H_renamed.right;
        androidx.dynamicanimation.a_renamed.f_renamed fVar = new androidx.dynamicanimation.a_renamed.f_renamed(new androidx.dynamicanimation.a_renamed.e_renamed(f_renamed));
        androidx.dynamicanimation.a_renamed.g_renamed gVar = new androidx.dynamicanimation.a_renamed.g_renamed(f2);
        gVar.a_renamed(1500.0f);
        gVar.b_renamed(0.5f);
        fVar.a_renamed(gVar);
        fVar.a_renamed(new androidx.dynamicanimation.a_renamed.c_renamed.DynamicAnimation_3() { // from class: com.oplus.camera.ui.widget.e_renamed.3
            @Override // androidx.dynamicanimation.a_renamed.c_renamed.DynamicAnimation_3
            public void a_renamed(androidx.dynamicanimation.a_renamed.c_renamed cVar, float f3, float f4) {
                if (z_renamed) {
                    com.oplus.camera.ui.widget.e_renamed.this.W_renamed.left = f3;
                } else {
                    com.oplus.camera.ui.widget.e_renamed.this.W_renamed.right = f3;
                }
                com.oplus.camera.ui.widget.e_renamed.this.aa_renamed = f3 != f2;
                com.oplus.camera.ui.widget.e_renamed.this.invalidate();
            }
        });
        fVar.a_renamed();
    }

    private float getSelectTimeRatio() {
        if (0.0f == this.D_renamed.width()) {
            return 1.0f;
        }
        return this.B_renamed.width() / this.D_renamed.width();
    }

    private boolean a_renamed(float f_renamed, float f2) {
        return this.C_renamed.contains((float) ((int) f_renamed), (float) ((int) f2)) || this.E_renamed.contains(f_renamed, f2) || this.F_renamed.contains(f_renamed, f2);
    }

    public com.meicam.sdk.NvsLiveWindow getLiveWindow() {
        return this.f7269a;
    }

    public void setLiveWindow(com.meicam.sdk.NvsLiveWindow nvsLiveWindow) {
        this.f7269a = nvsLiveWindow;
    }

    public com.meicam.sdk.NvsMultiThumbnailSequenceView getThumbnail() {
        return this.f7270b;
    }

    public void setThumbProcess(float f_renamed) {
        a_renamed(f_renamed, true);
    }

    public float getThumbProcess() {
        return this.x_renamed;
    }

    public void a_renamed(float f_renamed, boolean z_renamed) {
        if (f_renamed == this.y_renamed) {
            return;
        }
        float fFloatValue = new java.math.BigDecimal(1.0f - f_renamed).setScale(2, java.math.RoundingMode.DOWN).floatValue();
        float f2 = this.v_renamed;
        if (f_renamed < f2) {
            f_renamed = f2;
        } else if (f_renamed >= this.w_renamed || 0.01f >= fFloatValue) {
            f_renamed = this.w_renamed;
        }
        this.y_renamed = f_renamed;
        float f3 = this.w_renamed;
        float f4 = this.v_renamed;
        this.x_renamed = (f_renamed - f4) / (f3 - f4);
        if (z_renamed) {
            invalidate();
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        this.l_renamed = i_renamed;
        this.k_renamed = i2;
        this.P_renamed = true;
        com.oplus.camera.e_renamed.b_renamed("VideoClipView", "setVideoSize mVideoWidth: " + this.l_renamed + ", mVideoHeight: " + this.k_renamed);
    }

    public void setTotalTime(long j_renamed) {
        float f_renamed = j_renamed;
        this.q_renamed = f_renamed;
        this.U_renamed = false;
        this.V_renamed = true;
        this.T_renamed = 0;
        this.p_renamed = a_renamed(f_renamed);
        this.v_renamed = 0.0f;
        float f2 = this.p_renamed;
        this.w_renamed = f2 < 15.0f ? 1.0f : 15.0f / f2;
        this.x_renamed = 0.0f;
        float f3 = this.p_renamed;
        if (f3 >= 15.0f) {
            f3 = 15.0f;
        }
        this.s_renamed = f3;
        requestLayout();
        invalidate();
        com.oplus.camera.e_renamed.b_renamed("VideoClipView", "totalTime: " + j_renamed + " mTotalTimeSecond: " + this.p_renamed);
    }

    private void g_renamed() {
        float fWidth = this.B_renamed.left + (this.B_renamed.width() * this.x_renamed);
        float width = this.N_renamed.getWidth() + fWidth;
        float height = this.B_renamed.top - ((this.N_renamed.getHeight() - this.B_renamed.height()) / 2.0f);
        float f_renamed = this.B_renamed.right;
        if (width > f_renamed) {
            fWidth = f_renamed - this.N_renamed.getWidth();
        }
        this.C_renamed.set(fWidth, height, this.N_renamed.getWidth() + fWidth, this.N_renamed.getHeight() + height);
        this.C_renamed.left -= this.N_renamed.getWidth();
        this.C_renamed.right += this.N_renamed.getWidth();
    }

    public void setCurrentTime(float f_renamed) {
        this.u_renamed = new java.math.BigDecimal(f_renamed).setScale(0, java.math.RoundingMode.DOWN).floatValue();
    }

    private float a_renamed(float f_renamed) {
        return new java.math.BigDecimal((f_renamed * 1.0f) / 1000000.0f).setScale(2, java.math.RoundingMode.DOWN).floatValue();
    }

    public void setSeekToCallback(com.oplus.camera.ui.widget.e_renamed.a_renamed aVar) {
        this.z_renamed = aVar;
    }

    public float getLeftVideoProcess() {
        return this.v_renamed;
    }

    public void setLeftVideoProcess(float f_renamed) {
        this.v_renamed = f_renamed;
    }

    public float getRightVideoProcess() {
        return this.w_renamed;
    }

    public void setRightVideoProcess(float f_renamed) {
        this.w_renamed = f_renamed;
    }

    public void setVideoClipClick(com.oplus.camera.ui.widget.e_renamed.b_renamed bVar) {
        this.A_renamed = bVar;
    }

    public void setOrientation(int i_renamed) {
        this.f7271c.a_renamed(i_renamed, true);
        this.d_renamed.a_renamed(i_renamed, true);
    }

    public void a_renamed() {
        if (this.e_renamed == null) {
            this.e_renamed = new com.coui.appcompat.dialog.app.c_renamed(getContext());
            this.e_renamed.setCancelable(false);
            this.e_renamed.setCanceledOnTouchOutside(false);
            this.e_renamed.setTitle(getResources().getString(com.oplus.camera.R_renamed.string.mode_double_exposure_video_importing));
        }
        this.e_renamed.show();
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        if (i_renamed == 0) {
            setAlpha(1.0f);
        }
        super.setVisibility(i_renamed);
    }

    public void a_renamed(final boolean z_renamed) {
        this.f7270b.scrollTo(0, 0);
        this.f7270b.smoothScrollTo(0, 0);
        this.T_renamed = 0;
        this.U_renamed = true;
        android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(0, 255).setDuration(300L);
        duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.e_renamed.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.widget.e_renamed.this.T_renamed = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                com.oplus.camera.ui.widget.e_renamed eVar = com.oplus.camera.ui.widget.e_renamed.this;
                eVar.U_renamed = 255 != eVar.T_renamed;
                if (z_renamed) {
                    if (255 == com.oplus.camera.ui.widget.e_renamed.this.T_renamed) {
                        com.oplus.camera.ui.widget.e_renamed.this.setVisibility(8);
                    } else {
                        com.oplus.camera.ui.widget.e_renamed.this.setAlpha((255 - r3.T_renamed) / 255.0f);
                    }
                }
                com.oplus.camera.ui.widget.e_renamed.this.invalidate();
            }
        });
        duration.start();
    }

    public void b_renamed() {
        com.coui.appcompat.dialog.app.c_renamed cVar = this.e_renamed;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public boolean c_renamed() {
        com.coui.appcompat.dialog.app.c_renamed cVar = this.e_renamed;
        return cVar != null && cVar.isShowing();
    }

    public boolean d_renamed() {
        return getVisibility() == 0 && getAnimationAlpha() == 0 && !e_renamed();
    }

    public int getAnimationAlpha() {
        return this.T_renamed;
    }

    public boolean e_renamed() {
        return this.U_renamed;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.ui.widget.e_renamed.b_renamed bVar = this.A_renamed;
        if (bVar == null) {
            return;
        }
        if (view == this.f7271c) {
            bVar.eB_renamed();
        } else if (view == this.d_renamed) {
            bVar.a_renamed(this.v_renamed, this.w_renamed);
        }
    }

    @Override // com.meicam.sdk.NvsMultiThumbnailSequenceView.OnScrollChangeListener
    public void onScrollChanged(com.meicam.sdk.NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, int i_renamed, int i2) {
        if (15.0f > this.p_renamed) {
            return;
        }
        float f_renamed = i_renamed + (this.B_renamed.left - this.D_renamed.left);
        this.v_renamed = f_renamed / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
        this.w_renamed = (f_renamed + this.B_renamed.width()) / ((this.r_renamed - this.f7270b.getStartPadding()) - this.f7270b.getEndPadding());
        this.y_renamed = this.v_renamed;
        a_renamed(0.0f, true);
        com.oplus.camera.ui.widget.e_renamed.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.c_renamed(this.y_renamed);
        }
        this.ag_renamed.removeMessages(1);
        this.ag_renamed.sendEmptyMessageDelayed(1, 50L);
    }
}
