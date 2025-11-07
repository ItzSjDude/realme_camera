package com.oplus.camera.ui.menu;

/* compiled from: RotationOptionItemView.java */
/* loaded from: classes2.dex */
public class i_renamed extends com.airbnb.lottie.LottieAnimationView implements com.oplus.camera.ui.inverse.a_renamed {
    private android.graphics.Bitmap A_renamed;
    private android.graphics.Bitmap B_renamed;
    private android.graphics.Bitmap C_renamed;
    private android.graphics.Paint D_renamed;
    private java.lang.String E_renamed;
    private android.graphics.Paint F_renamed;
    private java.lang.String G_renamed;
    private java.lang.String H_renamed;
    private android.graphics.Paint I_renamed;
    private android.graphics.Paint J_renamed;
    private android.graphics.Paint K_renamed;
    private android.graphics.Paint L_renamed;
    private android.graphics.Paint M_renamed;
    private android.graphics.Paint N_renamed;
    private android.graphics.Matrix O_renamed;
    private com.oplus.camera.ComboPreferences P_renamed;
    private android.animation.ValueAnimator Q_renamed;
    private android.animation.ValueAnimator R_renamed;
    private android.animation.ValueAnimator S_renamed;
    private java.lang.String T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6447a;
    private int aa_renamed;
    private int ab_renamed;
    private int ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private int ag_renamed;
    private int ah_renamed;
    private int ai_renamed;
    private int aj_renamed;
    private long ak_renamed;
    private long al_renamed;
    private float am_renamed;
    private int[] an_renamed;
    private com.oplus.camera.ui.CameraUIListener ao_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.animation.ArgbEvaluator f6448b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.animation.ValueAnimator f6449c;
    private android.view.animation.PathInterpolator d_renamed;
    private float e_renamed;
    private float f_renamed;
    private float g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private android.content.Context s_renamed;
    private android.graphics.Canvas t_renamed;
    private android.graphics.drawable.Drawable u_renamed;
    private android.graphics.drawable.Drawable v_renamed;
    private android.graphics.Bitmap w_renamed;
    private android.graphics.Bitmap x_renamed;
    private android.graphics.Bitmap y_renamed;
    private android.graphics.Bitmap z_renamed;

    public i_renamed(android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener, boolean z_renamed, android.graphics.Bitmap bitmap, boolean z2, boolean z3, com.oplus.camera.ComboPreferences comboPreferences) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.f6447a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f6448b = new android.animation.ArgbEvaluator();
        this.f6449c = null;
        this.d_renamed = new android.view.animation.PathInterpolator(0.28f, 0.0f, 0.17f, 1.0f);
        this.e_renamed = 0.0f;
        this.f_renamed = 1.0f;
        this.g_renamed = 0.0f;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = null;
        this.D_renamed = new android.graphics.Paint();
        this.E_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = null;
        this.K_renamed = null;
        this.L_renamed = null;
        this.M_renamed = null;
        this.N_renamed = null;
        this.O_renamed = null;
        this.P_renamed = null;
        this.Q_renamed = null;
        this.R_renamed = null;
        this.S_renamed = null;
        this.T_renamed = null;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = 0;
        this.ah_renamed = 0;
        this.ai_renamed = 0;
        this.aj_renamed = 0;
        this.ak_renamed = 0L;
        this.al_renamed = 0L;
        this.am_renamed = 0.5f;
        this.an_renamed = null;
        this.ao_renamed = null;
        this.s_renamed = context;
        this.ao_renamed = cameraUIListener;
        this.i_renamed = z_renamed;
        this.y_renamed = bitmap;
        this.k_renamed = z2;
        this.P_renamed = comboPreferences;
        this.p_renamed = z3;
        if (this.i_renamed) {
            this.ad_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_layout_height);
            this.ac_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_item_layout_width);
        } else {
            this.ad_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_indicator_layout_height);
            this.ac_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_indicator_layout_width);
        }
        this.H_renamed = this.s_renamed.getResources().getString(com.oplus.camera.R_renamed.string.camera_sub_setting_menu_description_setting_title);
        this.af_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_text_length);
        this.ag_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_text_length_land);
        k_renamed();
        l_renamed();
        m_renamed();
        this.an_renamed = new int[2];
    }

    private void k_renamed() {
        setLayerType(1, null);
        this.J_renamed = new android.graphics.Paint();
        this.J_renamed.setMaskFilter(new android.graphics.BlurMaskFilter(4.0f, android.graphics.BlurMaskFilter.Blur.OUTER));
        this.J_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_70_percent_transparency));
    }

    private void l_renamed() {
        this.K_renamed = new android.graphics.Paint();
        this.K_renamed.setAntiAlias(true);
        this.L_renamed = new android.graphics.Paint();
        this.L_renamed.setAntiAlias(true);
        this.L_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
    }

    private void m_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.i_renamed) {
            this.ab_renamed = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_layout_height);
        } else {
            this.ab_renamed = com.oplus.camera.util.Util.getSettingMenuPanelHeight();
        }
        int dimensionPixelSize = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
        int dimensionPixelSize2 = 0;
        if (com.oplus.camera.util.Util.ai_renamed() && !this.i_renamed) {
            dimensionPixelSize2 = this.s_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.ear_screen_menu_offset);
            dimensionPixelSize = 0;
        } else if (this.i_renamed) {
            dimensionPixelSize = 0;
        }
        float measuredHeight = (int) ((this.ab_renamed - getMeasuredHeight()) / 2.0f);
        if (this.ab_renamed > 0) {
            this.am_renamed = ((((getMeasuredHeight() / 2.0f) + measuredHeight) + dimensionPixelSize2) + dimensionPixelSize) / this.ab_renamed;
        }
    }

    public void setShadowOn(boolean z_renamed) {
        this.p_renamed = z_renamed;
    }

    public boolean getShadowOn() {
        return this.p_renamed;
    }

    public void setMenuName(java.lang.String str) {
        this.G_renamed = str;
    }

    public void setSwitchIconNeedAnim(boolean z_renamed) {
        this.l_renamed = z_renamed;
    }

    public void setOffAnimIcon(android.graphics.Bitmap bitmap) {
        this.z_renamed = bitmap;
        android.graphics.Bitmap bitmap2 = this.z_renamed;
        if (bitmap2 != null) {
            this.B_renamed = android.graphics.Bitmap.createScaledBitmap(bitmap2.extractAlpha(), this.z_renamed.getWidth(), this.z_renamed.getHeight(), true);
        }
    }

    public void setLottieIconNeedAnim(boolean z_renamed) {
        this.r_renamed = z_renamed;
    }

    public boolean h_renamed() {
        return this.r_renamed;
    }

    public float getPivotYScaleValue() {
        return this.am_renamed;
    }

    private void n_renamed() {
        if (this.R_renamed == null) {
            this.R_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.R_renamed.setInterpolator(this.d_renamed);
            this.R_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.i_renamed.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.i_renamed.this.f_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.menu.i_renamed.this.postInvalidate();
                }
            });
            this.R_renamed.setDuration(583L);
        }
        this.R_renamed.cancel();
        this.R_renamed.start();
    }

    private void o_renamed() {
        if (this.S_renamed == null) {
            this.S_renamed = android.animation.ValueAnimator.ofFloat(0.001f, 1.0f);
            this.S_renamed.setInterpolator(this.d_renamed);
            this.S_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.i_renamed.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.i_renamed.this.g_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.menu.i_renamed.this.postInvalidate();
                }
            });
            this.S_renamed.setDuration(583L);
        }
        this.S_renamed.cancel();
        this.S_renamed.start();
        this.q_renamed = true;
    }

    private void p_renamed() {
        if (this.Q_renamed == null) {
            this.Q_renamed = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.Q_renamed.setInterpolator(this.d_renamed);
            this.Q_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.i_renamed.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.ui.menu.i_renamed.this.e_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.oplus.camera.ui.menu.i_renamed.this.postInvalidate();
                }
            });
            this.Q_renamed.setDuration(583L);
        }
        this.Q_renamed.cancel();
        this.Q_renamed.start();
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        if (this.l_renamed) {
            this.q_renamed = false;
            this.u_renamed = this.v_renamed;
            this.w_renamed = this.x_renamed;
        }
        if (drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        this.k_renamed = z_renamed;
        refreshDrawableState();
        setImageDrawable(drawable);
        this.x_renamed = com.oplus.camera.util.Util.a_renamed(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        this.t_renamed = new android.graphics.Canvas(this.x_renamed);
        q_renamed();
        this.v_renamed = drawable;
        if (this.j_renamed) {
            this.j_renamed = false;
            if (this.k_renamed) {
                if (this.y_renamed != null) {
                    p_renamed();
                }
            } else {
                n_renamed();
                if (this.l_renamed && !this.v_renamed.equals(this.u_renamed)) {
                    o_renamed();
                }
            }
        } else {
            if (this.k_renamed) {
                this.e_renamed = 1.0f;
                this.f_renamed = 0.0f;
            } else {
                this.e_renamed = 0.0f;
                this.f_renamed = 1.0f;
            }
            if (this.l_renamed && !this.v_renamed.equals(this.u_renamed)) {
                o_renamed();
            }
        }
        invalidate();
    }

    private void q_renamed() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (d_renamed() || drawable == null || (drawable instanceof com.airbnb.lottie.f_renamed)) {
            return;
        }
        if (this.x_renamed == null) {
            this.x_renamed = com.oplus.camera.util.Util.a_renamed(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            this.x_renamed.setDensity(com.oplus.camera.util.Util.f7297a);
            this.t_renamed = new android.graphics.Canvas(this.x_renamed);
        }
        drawable.setBounds(0, 0, this.t_renamed.getWidth(), this.t_renamed.getHeight());
        this.t_renamed.drawColor(0, android.graphics.BlendMode.CLEAR);
        drawable.draw(this.t_renamed);
    }

    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
        if (z_renamed) {
            if (this.I_renamed == null) {
                this.I_renamed = new android.graphics.Paint();
                this.I_renamed.setAntiAlias(true);
                this.I_renamed.setColor(this.s_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.camera_red_dot_hint_color, null));
            }
        } else {
            this.I_renamed = null;
        }
        boolean z2 = this.m_renamed != z_renamed;
        this.m_renamed = z_renamed;
        this.ah_renamed = i_renamed;
        this.ai_renamed = i2;
        if (z2) {
            invalidate();
        }
    }

    public void setItemText(java.lang.String str) {
        if (android.text.TextUtils.equals(this.E_renamed, str)) {
            return;
        }
        this.E_renamed = str;
        u_renamed();
        v_renamed();
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        if (!z_renamed && d_renamed() && !this.r_renamed) {
            e_renamed();
        }
        setClickable(z_renamed);
        setAlpha(z_renamed ? 1.0f : 0.5f);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.W_renamed) {
            return;
        }
        this.W_renamed = i2;
        v_renamed();
        if (isShown() && z_renamed) {
            this.V_renamed = this.U_renamed;
            this.ak_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.W_renamed - this.U_renamed;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.h_renamed = i3 >= 0;
            this.al_renamed = this.ak_renamed + ((java.lang.Math.abs(i3) * 1000) / 360);
        } else {
            this.U_renamed = this.W_renamed;
        }
        j_renamed();
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.aa_renamed = i3 - i_renamed;
        this.ab_renamed = i4 - i2;
    }

    public void setKey(java.lang.String str) {
        this.T_renamed = str;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:114:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:138:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:157:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:167:0x0470  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.i_renamed.onDraw(android.graphics.Canvas):void");
    }

    private boolean r_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.ao_renamed;
        int iCa = cameraUIListener != null ? cameraUIListener.ca_renamed() : 0;
        if (2 == iCa) {
            int i_renamed = this.ae_renamed;
            if (5 == i_renamed || 1 == i_renamed) {
                return true;
            }
        } else if (3 == iCa) {
            int i2 = this.ae_renamed;
            if (i2 == 0 || 1 == i2) {
                return true;
            }
        } else if (4 == iCa) {
            if (this.ao_renamed.bL_renamed().q_renamed()) {
                return true;
            }
        } else if (5 == this.ae_renamed) {
            return true;
        }
        return false;
    }

    private void s_renamed() {
        if (this.A_renamed == null) {
            this.A_renamed = com.oplus.camera.util.Util.a_renamed(this.z_renamed.getWidth(), this.z_renamed.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(this.A_renamed);
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setColorFilter(new android.graphics.PorterDuffColorFilter(getContext().getColor(com.oplus.camera.R_renamed.color.inverse_text_color), android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.z_renamed, 0.0f, 0.0f, paint);
        }
    }

    private void t_renamed() {
        this.F_renamed.setColor(this.s_renamed.getColorStateList(com.oplus.camera.R_renamed.color.menu_item_text_color_selector).getColorForState(getDrawableState(), com.oplus.camera.R_renamed.color.oplus_submenu_text_color));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.ao_renamed;
        if (cameraUIListener != null && cameraUIListener.p_renamed() && (actionMasked = motionEvent.getActionMasked()) != 3 && actionMasked != 2) {
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        if (motionEvent.getActionMasked() == 3 && isEnabled()) {
            setAlpha(1.0f);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.y_renamed != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getHitRect(rect);
            if (1 == motionEvent.getAction() && (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) || 1 == this.ao_renamed.ca_renamed())) {
                this.j_renamed = true;
            }
        }
        if (isEnabled()) {
            if (!this.i_renamed) {
                android.graphics.Rect rect2 = (android.graphics.Rect) getTag(com.oplus.camera.R_renamed.id_renamed.touch_area_tag);
                if (!rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.oplus.camera.e_renamed.b_renamed("RotationOptionItemView", "onTouchEvent, The click area is_renamed not included in_renamed the hot rect: " + rect2.toString() + ", x_renamed: " + motionEvent.getX() + ", y_renamed: " + motionEvent.getY() + ", mItemYOffset: " + this.aj_renamed + ", mLayoutHeight:" + this.ad_renamed + ", sSettingMenuItemHeight: " + com.oplus.camera.util.Util.Q_renamed());
                    getDrawingRect(rect2);
                    if (!rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        com.oplus.camera.e_renamed.b_renamed("RotationOptionItemView", "onTouchEvent, The click area is_renamed not included in_renamed the drawing rect, the drawing zone: " + rect2.toString());
                        return true;
                    }
                }
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                setAlpha(0.3f);
            } else if (action == 1 || (action != 2 && action == 3)) {
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public java.lang.Object getTag(int i_renamed) {
        if (com.oplus.camera.R_renamed.id_renamed.touch_area_tag == i_renamed) {
            android.graphics.Rect rect = new android.graphics.Rect();
            getDrawingRect(rect);
            if (rect.right == 0 && rect.bottom == 0) {
                com.oplus.camera.e_renamed.b_renamed("RotationOptionItemView", "getTag, left: " + rect.left + ", top: " + rect.top + ", right: " + rect.right + ", bottom: " + rect.bottom);
                rect.right = this.ac_renamed;
                rect.bottom = com.oplus.camera.util.Util.Q_renamed();
            }
            return new android.graphics.Rect(rect.left, rect.top + (((com.oplus.camera.util.Util.Q_renamed() / 2) + this.aj_renamed) - (this.ad_renamed / 2)), rect.right, rect.bottom + this.ad_renamed);
        }
        return super.getTag(i_renamed);
    }

    public int getViewWidth() {
        android.graphics.Bitmap bitmap = this.x_renamed;
        int width = bitmap != null ? 0 + bitmap.getWidth() : 0;
        if (!android.text.TextUtils.isEmpty(this.E_renamed)) {
            width = java.lang.Math.max(width, (int) this.F_renamed.measureText(this.E_renamed));
        }
        if (this.i_renamed) {
            int i_renamed = this.af_renamed;
            return width > i_renamed ? i_renamed : this.ac_renamed;
        }
        return java.lang.Math.max(width, this.ac_renamed);
    }

    public int getViewHeight() {
        android.graphics.Bitmap bitmap = this.x_renamed;
        int height = bitmap != null ? 0 + bitmap.getHeight() : 0;
        if (!android.text.TextUtils.isEmpty(this.E_renamed)) {
            height = (int) (height + (this.F_renamed.getFontMetrics().bottom - this.F_renamed.getFontMetrics().top));
        }
        int i_renamed = this.ad_renamed;
        return height > i_renamed ? height : i_renamed;
    }

    private void u_renamed() {
        if (this.F_renamed == null) {
            this.F_renamed = new android.graphics.Paint();
            this.F_renamed.setTextSize(this.s_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.rotableview_text_size));
            this.F_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
            this.F_renamed.setFlags(1);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z_renamed) {
        if (this.F_renamed == null) {
            u_renamed();
        }
        super.setSelected(z_renamed);
        invalidate();
    }

    private void v_renamed() {
        if (android.text.TextUtils.isEmpty(this.E_renamed)) {
            return;
        }
        this.F_renamed.setTextSize(this.s_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.rotableview_text_size));
        int iMeasureText = (int) this.F_renamed.measureText(this.E_renamed);
        if (this.W_renamed % 180 == 0 || iMeasureText < com.oplus.camera.util.Util.Q_renamed()) {
            return;
        }
        this.F_renamed.setTextSize(this.s_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.rotableview_text_size_small));
    }

    public void setSizeRatioType(int i_renamed) {
        int i2;
        this.ae_renamed = i_renamed;
        if (1 == this.ao_renamed.ca_renamed()) {
            if (this.ao_renamed.bL_renamed().k_renamed() == 0 && !this.n_renamed && ((i2 = this.ae_renamed) == 0 || 1 == i2)) {
                this.K_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_20_percent_transparency));
            } else if (270 == this.ao_renamed.bL_renamed().k_renamed() && !this.n_renamed && this.an_renamed[0] < 350 && 1 == this.ae_renamed) {
                this.K_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_20_percent_transparency));
            } else if (90 == this.ao_renamed.bL_renamed().k_renamed() && !this.n_renamed && this.an_renamed[0] > 1440 && 1 == this.ae_renamed) {
                this.K_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_20_percent_transparency));
            } else {
                this.K_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
            }
        }
        if (r_renamed()) {
            if ("off".equals(this.P_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                this.L_renamed.setColor(this.s_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
            } else {
                this.L_renamed.setColor(this.s_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency));
            }
        }
        postInvalidate();
    }

    public void a_renamed(final boolean z_renamed, boolean z2, int i_renamed) {
        android.animation.ValueAnimator valueAnimator = this.f6449c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f6449c.end();
        }
        final int color = this.s_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency);
        final int color2 = this.s_renamed.getColor(com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency);
        int color3 = this.L_renamed.getColor();
        if (z_renamed && color3 == color) {
            return;
        }
        if ((z_renamed || color3 != color2) && z2 && r_renamed()) {
            android.animation.ArgbEvaluator argbEvaluator = this.f6448b;
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = java.lang.Integer.valueOf(z_renamed ? color2 : color);
            objArr[1] = java.lang.Integer.valueOf(z_renamed ? color : color2);
            this.f6449c = android.animation.ValueAnimator.ofObject(argbEvaluator, objArr);
            this.f6449c.setInterpolator(this.f6447a);
            this.f6449c.setDuration(i_renamed);
            this.f6449c.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.i_renamed.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    com.oplus.camera.ui.menu.i_renamed.this.L_renamed.setColor(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                    com.oplus.camera.ui.menu.i_renamed.this.postInvalidate();
                }
            });
            this.f6449c.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.i_renamed.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.ui.menu.i_renamed.this.L_renamed.setColor(z_renamed ? color : color2);
                    com.oplus.camera.ui.menu.i_renamed.this.postInvalidate();
                }
            });
            this.f6449c.start();
        }
    }

    public void i_renamed() {
        this.s_renamed = null;
        this.x_renamed = null;
        this.t_renamed = null;
        this.F_renamed = null;
        this.E_renamed = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 2);
        if (this.n_renamed && ((this.y_renamed == null || !this.k_renamed) && w_renamed())) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        if (this.o_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_style_second});
        }
        return iArrOnCreateDrawableState;
    }

    public void setStateSecond(boolean z_renamed) {
        this.o_renamed = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.n_renamed = z_renamed;
        refreshDrawableState();
        setSizeRatioType(this.ae_renamed);
        invalidate();
    }

    public void j_renamed() {
        getLocationOnScreen(this.an_renamed);
        setSizeRatioType(this.ae_renamed);
    }

    private boolean w_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.ao_renamed;
        switch (cameraUIListener != null ? cameraUIListener.bL_renamed().h_renamed() : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON) {
            case "out":
                int i_renamed = this.ae_renamed;
                if (2 == i_renamed || i_renamed == 0) {
                    return true;
                }
                break;
            case "full":
                int i2 = this.ae_renamed;
                if (1 == i2 || i2 == 0) {
                    return true;
                }
                break;
            case "left":
            case "right":
                int i3 = this.ae_renamed;
                if (2 == i3 || 6 == i3) {
                    return true;
                }
                break;
            case "rack90":
            case "rack270":
                return true;
            case "full90":
            case "full270":
            case "low90":
            case "low270":
                break;
            default:
                if (5 != this.ae_renamed) {
                    return true;
                }
                break;
        }
        return false;
    }
}
