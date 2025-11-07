package com.oplus.camera.ui.menu.setting.down;

/* loaded from: classes2.dex */
public class DrawerLayout extends android.view.ViewGroup {
    private android.view.animation.PathInterpolator A_renamed;
    private android.view.animation.PathInterpolator B_renamed;
    private android.graphics.drawable.ShapeDrawable C_renamed;
    private android.graphics.drawable.ShapeDrawable D_renamed;
    private long E_renamed;
    private long F_renamed;
    private long G_renamed;
    private float H_renamed;
    private int I_renamed;
    private com.oplus.camera.ComboPreferences J_renamed;
    private int K_renamed;
    private int L_renamed;
    private boolean M_renamed;
    private boolean N_renamed;
    private float O_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6624a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6625b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6626c;
    private int d_renamed;
    private float e_renamed;
    private float f_renamed;
    private boolean g_renamed;
    private com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel mSubSettingView;
    private boolean n_renamed;
    private int o_renamed;
    private com.oplus.camera.ui.menu.setting.down.DrawerLayout.a_renamed p_renamed;
    private android.animation.ValueAnimator q_renamed;
    private android.animation.ValueAnimator r_renamed;
    private android.animation.ValueAnimator s_renamed;
    private float t_renamed;
    private android.view.View u_renamed;
    private android.view.View v_renamed;
    private android.graphics.Rect w_renamed;
    private android.graphics.Rect x_renamed;
    private float y_renamed;
    private android.view.animation.PathInterpolator z_renamed;

    public interface b_renamed {
        void a_renamed(float f_renamed);

        void a_renamed(boolean z_renamed);

        void a_renamed(boolean z_renamed, boolean z2, int i_renamed);

        void e_renamed();

        void f_renamed();

        boolean k_renamed();

        void l_renamed();

        boolean u_renamed();

        void v_renamed();

        void w_renamed();
    }

    public interface c_renamed {
        void setOffset(float f_renamed);
    }

    public void c_renamed() {
    }

    public DrawerLayout(android.content.Context context) {
        this(context, null);
    }

    public DrawerLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6624a = false;
        this.f6625b = 0;
        this.f6626c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0.0f;
        this.f_renamed = 0.0f;
        this.g_renamed = false;
        this.h_renamed = null;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = true;
        this.n_renamed = false;
        this.o_renamed = 0;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = 0.0f;
        this.u_renamed = null;
        this.mSubSettingView = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = 0.0f;
        this.z_renamed = new android.view.animation.PathInterpolator(0.4f, 0.0f, 0.3f, 1.0f);
        this.A_renamed = new android.view.animation.PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.B_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.C_renamed = null;
        this.D_renamed = null;
        this.E_renamed = 0L;
        this.F_renamed = 0L;
        this.G_renamed = -1L;
        this.H_renamed = 0.0f;
        this.I_renamed = 0;
        this.J_renamed = null;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = false;
        this.N_renamed = false;
        this.O_renamed = 0.0f;
        com.oplus.camera.ui.inverse.e_renamed.INS.registerBackgroundInverse(context, this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.u_renamed = findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar);
    }

    public void a_renamed() {
        this.mSubSettingView = (com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel) findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_subsetting_bar);
        this.v_renamed = findViewById(com.oplus.camera.R_renamed.id_renamed.setting_arrow);
        this.v_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.down.DrawerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.N_renamed = false;
                    com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.O_renamed = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.N_renamed = java.lang.Math.abs(motionEvent.getY() - com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.O_renamed) > 20.0f;
                        return false;
                    }
                    if (action == 3) {
                        return false;
                    }
                } else {
                    if (com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.N_renamed || com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.v_renamed.getVisibility() != 0 || 1.0f != com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.v_renamed.getAlpha()) {
                        return false;
                    }
                    com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.m_renamed();
                }
                return true;
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int measuredHeight;
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        this.f6626c = 0;
        measureChild(this.u_renamed, i_renamed, i2);
        int measuredHeight2 = this.u_renamed.getMeasuredHeight() + 0;
        com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
        if (cameraDrawerSettingMenuPanel != null) {
            measureChild(cameraDrawerSettingMenuPanel, i_renamed, i2);
            measuredHeight = this.mSubSettingView.getMeasuredHeight();
        } else {
            measuredHeight = 0;
        }
        android.view.View view = this.v_renamed;
        if (view != null) {
            measureChild(view, i_renamed, i2);
        }
        this.k_renamed = measuredHeight == 0;
        this.f6626c = measuredHeight;
        if (1 == this.K_renamed) {
            this.f6626c = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tool_draw_panel_max_scroll);
        }
        setMeasuredDimension(size, (int) (measuredHeight2 + this.t_renamed));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) throws android.content.res.Resources.NotFoundException {
        int i5;
        int i6;
        boolean zEquals = this.J_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").equals("on_renamed");
        int measuredWidth = getMeasuredWidth();
        this.y_renamed = getViewOffsetPercent();
        if (4 == this.K_renamed) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = i_renamed;
            i6 = i2;
        }
        android.view.View view = this.u_renamed;
        view.layout(((measuredWidth - view.getMeasuredWidth()) / 2) + i5, i6, ((this.u_renamed.getMeasuredWidth() + measuredWidth) / 2) + i5, this.u_renamed.getMeasuredHeight() + i6);
        if (this.mSubSettingView != null) {
            this.H_renamed = this.B_renamed.getInterpolation(java.lang.Math.min(this.y_renamed, 1.0f));
            this.mSubSettingView.setAlpha(this.H_renamed);
            this.mSubSettingView.setOffset(this.y_renamed);
            com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
            cameraDrawerSettingMenuPanel.layout(((measuredWidth - cameraDrawerSettingMenuPanel.getMeasuredWidth()) / 2) + i5, this.u_renamed.getMeasuredHeight(), ((this.mSubSettingView.getMeasuredWidth() + measuredWidth) / 2) + i5, this.u_renamed.getMeasuredHeight() + this.mSubSettingView.getMeasuredHeight());
            if (1 == this.K_renamed) {
                int color = getResources().getColor(com.oplus.camera.R_renamed.color.camera_sub_setting_bg_color_for_full_screen_mode);
                float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_bg_radius);
                this.mSubSettingView.setBackground(a_renamed(0.0f == this.H_renamed ? 0 : com.oplus.camera.ui.inverse.e_renamed.INS.getBackgroundColor(this, color), new android.graphics.drawable.shapes.RoundRectShape(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize}, null, null)));
            } else {
                this.mSubSettingView.setBackgroundResource(0);
            }
        }
        android.view.View view2 = this.v_renamed;
        if (view2 != null) {
            view2.setAlpha(this.H_renamed);
            android.view.View view3 = this.v_renamed;
            view3.layout(((measuredWidth - view3.getMeasuredWidth()) / 2) + i5, i4 - this.v_renamed.getMeasuredHeight(), i5 + ((measuredWidth + this.v_renamed.getMeasuredWidth()) / 2), i4);
        }
        if (4 == this.K_renamed && zEquals) {
            int color2 = getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_20_percent_transparency);
            if (this.M_renamed) {
                color2 = getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_80_percent_transparency);
            }
            float dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_bg_radius);
            setBackground(a_renamed(0.0f != this.H_renamed ? com.oplus.camera.ui.inverse.e_renamed.INS.getBackgroundColor(this, color2) : 0, new android.graphics.drawable.shapes.RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2}, null, null)));
            return;
        }
        if (1 == this.K_renamed) {
            setBackgroundResource(0);
            removeView(this.v_renamed);
        } else {
            c_renamed(this.H_renamed);
        }
    }

    private float getViewOffsetPercent() {
        int i_renamed = this.f6626c;
        if (i_renamed == 0) {
            return 0.0f;
        }
        return this.t_renamed / (i_renamed * 1.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "onInterceptTouchEvent, mbEnabled: " + this.l_renamed + ", isAnimationRun: " + i_renamed() + ", mbTouch: " + this.i_renamed);
        if (!this.l_renamed || i_renamed() || (1 == motionEvent.getAction() && this.i_renamed)) {
            setEnableTouch(false);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:120:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.down.DrawerLayout.a_renamed(android.view.MotionEvent):boolean");
    }

    private boolean a_renamed(float f_renamed, float f2) {
        if (this.u_renamed == null) {
            return false;
        }
        if (this.w_renamed == null) {
            this.w_renamed = new android.graphics.Rect();
            this.u_renamed.getHitRect(this.w_renamed);
        }
        return this.w_renamed.contains((int) f_renamed, (int) f2);
    }

    public void setPreferences(com.oplus.camera.ComboPreferences comboPreferences) {
        this.J_renamed = comboPreferences;
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "setEnabled, mbEnabled: " + this.l_renamed + " > " + z_renamed + ", mDealEventFromOutState: " + this.o_renamed);
        if (2 == this.o_renamed) {
            setEnableTouch(false);
        }
        this.l_renamed = z_renamed;
        super.setEnabled(z_renamed);
    }

    private void setDealStateFromOut(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "setDealStateFromOut, mDealEventFromOutState: " + this.o_renamed + " -> " + i_renamed);
        this.o_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationState(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "setAnimationState, mAnimationState: " + this.I_renamed + " -> " + i_renamed);
        this.I_renamed = i_renamed;
    }

    private void a_renamed(android.view.MotionEvent motionEvent, float f_renamed) {
        this.f6625b = (int) this.t_renamed;
        float f2 = f_renamed - this.f_renamed;
        setEnableTouch(false);
        setDealStateFromOut(0);
        if (this.n_renamed) {
            this.f6624a = true;
            a_renamed(this.f6625b, this.f6626c);
        } else {
            float eventTime = f2 / (motionEvent.getEventTime() - motionEvent.getDownTime());
            com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "handleDrawerSettingEventUp, speed: " + eventTime + ", mScrollTo: " + this.f6625b + ", offsetUpDownY: " + f2 + ", mMaxScroll: " + this.f6626c);
            if (((1.2f < java.lang.Math.abs(eventTime) && 0.0f < eventTime) || this.f6625b > this.f6626c / 2) && ((f2 > 0.0f || this.f6625b > this.f6626c) && android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop() <= java.lang.Math.abs(f2) && motionEvent.getPointerCount() <= 1)) {
                this.f6624a = true;
                b_renamed(this.f6625b, this.f6626c, true);
            } else {
                this.f6624a = false;
                int i_renamed = this.f6625b;
                int i2 = this.d_renamed;
                if (i_renamed != i2) {
                    b_renamed(i_renamed, i2);
                }
            }
        }
        this.f_renamed = 0.0f;
        this.g_renamed = false;
        if (this.h_renamed == null || java.lang.Math.abs(f2) <= 0.0f) {
            return;
        }
        this.h_renamed.a_renamed(this.f6624a);
        this.h_renamed.e_renamed();
    }

    private float a_renamed(float f_renamed) {
        int i_renamed = this.f6626c;
        float f2 = ((f_renamed - i_renamed) / 2.0f) + i_renamed;
        return f2 > ((float) (i_renamed + 100)) ? i_renamed + 100 : f2;
    }

    private void b_renamed(float f_renamed) {
        this.n_renamed = true;
        this.t_renamed = f_renamed;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScroll(float f_renamed) {
        this.n_renamed = false;
        this.t_renamed = f_renamed;
        requestLayout();
        com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            int i_renamed = this.f6626c;
            if (i_renamed > 0) {
                bVar.a_renamed((i_renamed - f_renamed) / ((i_renamed - this.d_renamed) * 1.0f));
            } else {
                bVar.a_renamed(1.0f);
            }
        }
    }

    private void c_renamed(float f_renamed) {
        setBackground(a_renamed(0.0f == f_renamed ? 0 : com.oplus.camera.ui.inverse.e_renamed.INS.getBackgroundColor(this, android.graphics.Color.argb(0.8f * f_renamed, 0.0f, 0.0f, 0.0f))));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        c_renamed(java.lang.Math.min(this.y_renamed, 1.0f));
        if (getBackground() == this.C_renamed) {
            invalidate();
        }
    }

    private android.graphics.drawable.Drawable a_renamed(int i_renamed) {
        if (this.C_renamed == null) {
            float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_bg_radius);
            this.C_renamed = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize}, null, null));
        }
        this.C_renamed.getPaint().setColor(i_renamed);
        return this.C_renamed;
    }

    private android.graphics.drawable.Drawable a_renamed(int i_renamed, android.graphics.drawable.shapes.Shape shape) {
        if (this.D_renamed == null) {
            this.D_renamed = new android.graphics.drawable.ShapeDrawable();
        }
        this.D_renamed.setShape(shape);
        this.D_renamed.getPaint().setColor(i_renamed);
        return this.D_renamed;
    }

    private void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "startUpDampAnimator, start: " + i_renamed + ", end: " + i2);
        android.animation.ValueAnimator valueAnimator = this.s_renamed;
        if (valueAnimator == null) {
            this.s_renamed = android.animation.ValueAnimator.ofInt(i_renamed, i2);
            this.s_renamed.setDuration(450L);
            this.s_renamed.setInterpolator(android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.drawer_damp_up_interpolator));
            this.s_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.-$$Lambda$DrawerLayout$qaOpDagCjdOg-qrsZ9_n81oLMis
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    this.f_renamed$0.b_renamed(valueAnimator2);
                }
            });
        } else {
            valueAnimator.setIntValues(i_renamed, i2);
        }
        if (this.p_renamed == null) {
            this.p_renamed = new com.oplus.camera.ui.menu.setting.down.DrawerLayout.a_renamed();
        }
        this.p_renamed.a_renamed(this.f6624a ? 1 : 2);
        this.s_renamed.addListener(this.p_renamed);
        com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.a_renamed(this.f6624a, true, 450);
        }
        this.s_renamed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        if (this.f6624a) {
            int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f6625b = iIntValue;
            b_renamed(iIntValue);
            return;
        }
        this.s_renamed.cancel();
    }

    private void b_renamed(int i_renamed, int i2) {
        b_renamed(i_renamed, i2, false);
    }

    private void b_renamed(int i_renamed, final int i2, boolean z_renamed) {
        android.animation.ValueAnimator valueAnimator = this.q_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.q_renamed.cancel();
        }
        com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.a_renamed(this.f6624a, true, c_renamed(i_renamed, i2));
        }
        this.q_renamed = android.animation.ValueAnimator.ofInt(i_renamed, i2);
        this.q_renamed.setDuration(a_renamed(i_renamed, i2, z_renamed ? 1.1f : 1.0f));
        if (z_renamed) {
            this.q_renamed.setInterpolator(this.A_renamed);
        } else {
            this.q_renamed.setInterpolator(this.z_renamed);
        }
        this.q_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.DrawerLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.f6625b = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setScroll(r2.f6625b);
                if (com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.f6625b == 0 && com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.J_renamed != null && i2 == 0) {
                    com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.J_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
                }
            }
        });
        if (this.p_renamed == null) {
            this.p_renamed = new com.oplus.camera.ui.menu.setting.down.DrawerLayout.a_renamed();
        }
        if (!this.f6624a) {
            this.r_renamed = android.animation.ValueAnimator.ofFloat(this.H_renamed, 0.0f);
            this.r_renamed.setInterpolator(this.B_renamed);
            this.r_renamed.setDuration(c_renamed(i_renamed, i2));
            this.r_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.setting.down.-$$Lambda$DrawerLayout$XM906D_UWsT_wQEI1_QKLQrxqhQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    this.f_renamed$0.a_renamed(valueAnimator2);
                }
            });
            this.r_renamed.start();
        }
        this.p_renamed.a_renamed(this.f6624a ? 1 : 2);
        this.q_renamed.addListener(this.p_renamed);
        this.q_renamed.start();
        com.oplus.camera.ui.menu.g_renamed.a_renamed(this.f6624a, c_renamed(i_renamed, i2));
        com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "startAnimator, mbOpen: " + this.f6624a + ", duration: " + this.q_renamed.getDuration() + ", start: " + i_renamed + ", end: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        this.H_renamed = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    private int a_renamed(int i_renamed, int i2, float f_renamed) {
        boolean z_renamed = this.f6624a;
        return (int) ((java.lang.Math.abs(i_renamed - i2) / (this.f6626c * 1.0f)) * 500 * f_renamed);
    }

    private int c_renamed(int i_renamed, int i2) {
        return (int) ((java.lang.Math.abs(i_renamed - i2) / (this.f6626c * 1.0f)) * 250.0f);
    }

    public void b_renamed() {
        android.animation.ValueAnimator valueAnimator = this.q_renamed;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.q_renamed.cancel();
    }

    public void setOpenAndClose(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "setOpenAndClose, isShow: " + z_renamed + ", mbPause: " + this.j_renamed + ", mbTouch: " + this.i_renamed + ", mbOpen: " + this.f6624a);
        com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            if (z_renamed) {
                bVar.w_renamed();
            } else {
                bVar.v_renamed();
            }
        }
        if (this.j_renamed || !(this.i_renamed || this.f6624a == z_renamed)) {
            this.f6624a = z_renamed;
            if (!this.j_renamed) {
                b_renamed(this.f6625b, this.f6624a ? this.f6626c : this.d_renamed);
            } else {
                android.animation.ValueAnimator valueAnimator = this.q_renamed;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.q_renamed.cancel();
                }
                this.f6625b = this.f6624a ? this.f6626c : this.d_renamed;
                setScroll(this.f6625b);
            }
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar2 = this.h_renamed;
            if (bVar2 != null) {
                bVar2.a_renamed(this.f6624a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "onArrowClick");
        setEnableTouch(false);
        com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.f_renamed();
        }
    }

    private class a_renamed extends android.animation.AnimatorListenerAdapter {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f6631b;

        private a_renamed() {
            this.f6631b = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "AnimatorListener, onAnimationEnd");
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setScroll(r2.f6625b);
            if (com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.j_renamed() && com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.h_renamed != null) {
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.h_renamed.l_renamed();
            }
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setAnimationState(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "AnimatorListener, onAnimationStart");
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.g_renamed = false;
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setAnimationState(this.f6631b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "AnimatorListener, onAnimationCancel");
            if (com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.q_renamed != null) {
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.q_renamed.removeListener(com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.p_renamed);
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.q_renamed = null;
            }
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setScroll(r2.f6625b);
            if (com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.j_renamed() && com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.h_renamed != null) {
                com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.h_renamed.l_renamed();
            }
            com.oplus.camera.ui.menu.setting.down.DrawerLayout.this.setAnimationState(0);
        }

        public void a_renamed(int i_renamed) {
            this.f6631b = i_renamed;
        }
    }

    public void setOnDrawerListener(com.oplus.camera.ui.menu.setting.down.DrawerLayout.b_renamed bVar) {
        this.h_renamed = bVar;
    }

    public void setRollVisibility(int i_renamed) {
        if (this.mSubSettingView != null) {
            this.m_renamed = i_renamed == 0;
            this.mSubSettingView.setVisibility(i_renamed);
        }
    }

    public void setEnableTouch(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("DrawerLayout", "setEnableTouch, mbTouch: " + this.i_renamed + " > " + z_renamed);
        this.i_renamed = z_renamed;
    }

    public void d_renamed() {
        int i_renamed;
        int i2;
        if (i_renamed() || (i_renamed = this.d_renamed) == (i2 = this.f6625b)) {
            return;
        }
        b_renamed(i2, i_renamed);
    }

    public boolean getEnableTouch() {
        return this.i_renamed;
    }

    public boolean e_renamed() {
        return this.f6624a;
    }

    public void f_renamed() {
        this.f6624a = false;
        this.j_renamed = true;
        this.t_renamed = 0.0f;
        this.f6625b = 0;
        setEnableTouch(false);
    }

    public void g_renamed() {
        this.j_renamed = false;
    }

    public boolean h_renamed() {
        return this.k_renamed;
    }

    public boolean i_renamed() {
        return this.I_renamed != 0;
    }

    public boolean j_renamed() {
        return 2 == this.I_renamed;
    }

    public boolean k_renamed() {
        return 0.0f != this.t_renamed && isShown();
    }

    public boolean a_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DrawerLayout", "hasDealEvent, mDownEventTimeFromOut: " + this.E_renamed + ", eventTime: " + j_renamed);
        boolean z_renamed = this.E_renamed == j_renamed;
        if (!z_renamed) {
            setEnableTouch(false);
        }
        return z_renamed;
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        this.K_renamed = i_renamed;
        this.L_renamed = i2;
        this.M_renamed = z_renamed;
    }

    public void l_renamed() {
        android.animation.ValueAnimator valueAnimator = this.q_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.oplus.camera.ui.menu.setting.CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = this.mSubSettingView;
        if (cameraDrawerSettingMenuPanel != null) {
            cameraDrawerSettingMenuPanel.setBackgroundResource(0);
        }
        this.f6625b = 0;
        setScroll(this.f6625b);
        this.J_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
    }
}
