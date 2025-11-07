package com.coui.appcompat.widget;

/* compiled from: COUIToolTips.java */
/* loaded from: classes.dex */
public class s_renamed extends android.widget.PopupWindow {
    private android.graphics.Rect A_renamed;
    private android.graphics.Rect B_renamed;
    private int C_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f3077a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f3078b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.View f3079c;
    private android.graphics.Rect d_renamed;
    private android.graphics.Rect e_renamed;
    private android.view.ViewGroup f_renamed;
    private android.view.ViewGroup g_renamed;
    private android.widget.TextView h_renamed;
    private android.widget.ScrollView i_renamed;
    private android.widget.ImageView j_renamed;
    private boolean k_renamed;
    private android.view.View l_renamed;
    private android.graphics.drawable.Drawable m_renamed;
    private android.graphics.drawable.Drawable n_renamed;
    private android.graphics.drawable.Drawable o_renamed;
    private android.graphics.drawable.Drawable p_renamed;
    private int q_renamed;
    private final int[] r_renamed;
    private int[] s_renamed;
    private final android.graphics.Point t_renamed;
    private float u_renamed;
    private float v_renamed;
    private android.view.animation.Interpolator w_renamed;
    private boolean x_renamed;
    private android.view.View.OnLayoutChangeListener y_renamed;
    private android.widget.PopupWindow.OnDismissListener z_renamed;

    public s_renamed(android.content.Context context) {
        this(context, 0);
    }

    public s_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.d_renamed = new android.graphics.Rect();
        this.k_renamed = false;
        this.q_renamed = 4;
        this.r_renamed = new int[2];
        this.s_renamed = new int[2];
        this.t_renamed = new android.graphics.Point();
        this.y_renamed = new android.view.View.OnLayoutChangeListener() { // from class: com.coui.appcompat.widget.s_renamed.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                android.graphics.Rect rect = new android.graphics.Rect(i2, i3, i4, i5);
                android.graphics.Rect rect2 = new android.graphics.Rect(i6, i7, i8, i9);
                if (!com.coui.appcompat.widget.s_renamed.this.isShowing() || rect.equals(rect2) || com.coui.appcompat.widget.s_renamed.this.l_renamed == null) {
                    return;
                }
                com.coui.appcompat.widget.s_renamed.this.g_renamed();
            }
        };
        this.z_renamed = new android.widget.PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.widget.s_renamed.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                com.coui.appcompat.widget.s_renamed.this.f_renamed.removeAllViews();
            }
        };
        this.f3077a = context;
        a_renamed(i_renamed);
    }

    public void a_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        int i2;
        int i3;
        this.f3078b = i_renamed;
        if (i_renamed == 0) {
            i2 = coui.support.appcompat.R_renamed.attr.couiToolTipsStyle;
            i3 = coui.support.appcompat.R_renamed.style.COUIToolTips;
        } else {
            i2 = coui.support.appcompat.R_renamed.attr.couiToolTipsDetailFloatingStyle;
            i3 = coui.support.appcompat.R_renamed.style.COUIToolTips_DetailFloating;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.f3077a.obtainStyledAttributes(null, coui.support.appcompat.R_renamed.styleable.COUIToolTips, i2, i3);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsBackground);
        drawable.setDither(true);
        this.m_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsArrowUpDrawable);
        this.n_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsArrowDownDrawable);
        this.o_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsArrowLeftDrawable);
        this.p_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsArrowRightDrawable);
        this.C_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsArrowOverflowOffset, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsMinWidth, 0);
        int i4 = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContainerLayoutGravity, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginStart, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginTop, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginEnd, 0);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginBottom, 0);
        android.content.res.ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsContentTextColor);
        int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsViewportOffsetStart, 0);
        int dimensionPixelSize7 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsViewportOffsetTop, 0);
        int dimensionPixelSize8 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsViewportOffsetEnd, 0);
        int dimensionPixelSize9 = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIToolTips_couiToolTipsViewportOffsetBottom, 0);
        final int dimensionPixelOffset = this.f3077a.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.couiToolTipsCancelButtonInsects);
        typedArrayObtainStyledAttributes.recycle();
        this.w_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.g_renamed = (android.view.ViewGroup) android.view.LayoutInflater.from(this.f3077a).inflate(coui.support.appcompat.R_renamed.layout.coui_tool_tips_layout, (android.view.ViewGroup) null);
        this.g_renamed.setBackground(drawable);
        this.g_renamed.setMinimumWidth(dimensionPixelSize);
        this.f_renamed = a_renamed(this.f3077a);
        com.coui.appcompat.a_renamed.e_renamed.a_renamed(this.f_renamed, false);
        this.h_renamed = (android.widget.TextView) this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.contentTv);
        this.i_renamed = (android.widget.ScrollView) this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.scrollView);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.i_renamed.getLayoutParams();
        layoutParams.gravity = i4;
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5);
        layoutParams.setMarginStart(dimensionPixelSize2);
        layoutParams.setMarginEnd(dimensionPixelSize4);
        this.i_renamed.setLayoutParams(layoutParams);
        this.h_renamed.setTextSize(0, (int) com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.f3077a.getResources().getDimensionPixelSize(i_renamed == 0 ? coui.support.appcompat.R_renamed.dimen.tool_tips_content_text_size : coui.support.appcompat.R_renamed.dimen.detail_floating_content_text_size), this.f3077a.getResources().getConfiguration().fontScale, 4));
        this.h_renamed.setTextColor(colorStateList);
        final android.widget.ImageView imageView = (android.widget.ImageView) this.g_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.dismissIv);
        if (i_renamed == 0) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.widget.s_renamed.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.coui.appcompat.widget.s_renamed.this.dismiss();
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        imageView.post(new java.lang.Runnable() { // from class: com.coui.appcompat.widget.s_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                android.graphics.Rect rect = new android.graphics.Rect();
                androidx.coordinatorlayout.widget.b_renamed.b_renamed(com.coui.appcompat.widget.s_renamed.this.g_renamed, imageView, rect);
                int i5 = dimensionPixelOffset;
                rect.inset(-i5, -i5);
                com.coui.appcompat.widget.s_renamed.this.g_renamed.setTouchDelegate(new android.view.TouchDelegate(rect, imageView));
            }
        });
        if (!b_renamed(this.g_renamed)) {
            this.e_renamed = new android.graphics.Rect(dimensionPixelSize6, dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize9);
        } else {
            this.e_renamed = new android.graphics.Rect(dimensionPixelSize8, dimensionPixelSize7, dimensionPixelSize6, dimensionPixelSize9);
        }
        setClippingEnabled(false);
        setAnimationStyle(0);
        setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        setOnDismissListener(this.z_renamed);
    }

    private static android.view.ViewGroup a_renamed(android.content.Context context) {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
        frameLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        return frameLayout;
    }

    public void a_renamed(android.view.View view) {
        a_renamed(view, true);
    }

    public void a_renamed(android.view.View view, boolean z_renamed) {
        a_renamed(view, 4, z_renamed);
    }

    public void a_renamed(android.view.View view, int i_renamed) {
        a_renamed(view, i_renamed, true);
    }

    public void a_renamed(android.view.View view, int i_renamed, boolean z_renamed) {
        if (isShowing()) {
            return;
        }
        this.q_renamed = i_renamed;
        this.f3079c = view.getRootView();
        int i2 = this.q_renamed;
        if (i2 == 32 || i2 == 64) {
            if (b_renamed(view)) {
                this.q_renamed = this.q_renamed == 32 ? 8 : 16;
            } else {
                this.q_renamed = this.q_renamed != 32 ? 8 : 16;
            }
        }
        this.l_renamed = view;
        this.f3079c.getWindowVisibleDisplayFrame(this.d_renamed);
        h_renamed();
        this.A_renamed = new android.graphics.Rect();
        view.getGlobalVisibleRect(this.A_renamed);
        this.B_renamed = new android.graphics.Rect();
        this.f3079c.getGlobalVisibleRect(this.B_renamed);
        int[] iArr = new int[2];
        this.f3079c.getLocationOnScreen(iArr);
        this.A_renamed.offset(iArr[0], iArr[1]);
        this.B_renamed.offset(iArr[0], iArr[1]);
        android.graphics.Rect rect = this.d_renamed;
        rect.left = java.lang.Math.max(rect.left, this.B_renamed.left);
        android.graphics.Rect rect2 = this.d_renamed;
        rect2.top = java.lang.Math.max(rect2.top, this.B_renamed.top);
        android.graphics.Rect rect3 = this.d_renamed;
        rect3.right = java.lang.Math.min(rect3.right, this.B_renamed.right);
        android.graphics.Rect rect4 = this.d_renamed;
        rect4.bottom = java.lang.Math.min(rect4.bottom, this.B_renamed.bottom);
        a_renamed();
        b_renamed(this.A_renamed);
        a_renamed(this.A_renamed, z_renamed);
        setContentView(this.f_renamed);
        d_renamed();
        e_renamed();
        showAtLocation(this.f3079c, 0, this.t_renamed.x_renamed, this.t_renamed.y_renamed);
    }

    private void a_renamed(android.graphics.Rect rect, boolean z_renamed) {
        this.f_renamed.removeAllViews();
        this.f_renamed.addView(this.g_renamed);
        if (z_renamed) {
            a_renamed(rect);
        }
    }

    private void a_renamed() {
        int dimensionPixelSize = this.f3077a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.tool_tips_max_width) + this.g_renamed.getPaddingLeft() + this.g_renamed.getPaddingRight();
        int i_renamed = this.q_renamed;
        if (i_renamed == 8) {
            dimensionPixelSize = java.lang.Math.min(this.d_renamed.right - this.A_renamed.right, dimensionPixelSize);
        } else if (i_renamed == 16) {
            dimensionPixelSize = java.lang.Math.min(this.A_renamed.left - this.d_renamed.left, dimensionPixelSize);
        }
        int iMin = java.lang.Math.min(this.d_renamed.right - this.d_renamed.left, dimensionPixelSize);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.i_renamed.getLayoutParams();
        this.h_renamed.setMaxWidth((((iMin - this.g_renamed.getPaddingLeft()) - this.g_renamed.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
        this.g_renamed.measure(0, 0);
        setWidth(java.lang.Math.min(this.g_renamed.getMeasuredWidth(), iMin));
        setHeight(this.g_renamed.getMeasuredHeight());
        if ((this.A_renamed.centerY() - (((c_renamed() + this.g_renamed.getPaddingTop()) - this.g_renamed.getPaddingBottom()) / 2)) + c_renamed() >= this.d_renamed.bottom) {
            this.q_renamed = 4;
            int iMin2 = java.lang.Math.min(this.d_renamed.right - this.d_renamed.left, this.f3077a.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.tool_tips_max_width) + this.g_renamed.getPaddingLeft() + this.g_renamed.getPaddingRight());
            this.h_renamed.setMaxWidth((((iMin2 - this.g_renamed.getPaddingLeft()) - this.g_renamed.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
            this.g_renamed.measure(0, 0);
            setWidth(java.lang.Math.min(this.g_renamed.getMeasuredWidth(), iMin2));
            setHeight(this.g_renamed.getMeasuredHeight());
        }
    }

    private void a_renamed(android.graphics.Rect rect) {
        this.j_renamed = new android.widget.ImageView(this.f3077a);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        int i_renamed = this.q_renamed;
        if (i_renamed == 4 || i_renamed == 128) {
            this.f3079c.getRootView().getLocationOnScreen(this.r_renamed);
            int i2 = this.r_renamed[0];
            this.f3079c.getRootView().getLocationInWindow(this.r_renamed);
            layoutParams.leftMargin = ((rect.centerX() - this.t_renamed.x_renamed) - (i2 - this.r_renamed[0])) - (this.m_renamed.getIntrinsicWidth() / 2);
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.m_renamed.getIntrinsicWidth();
            if (this.t_renamed.y_renamed >= rect.top - this.s_renamed[1]) {
                this.j_renamed.setBackground(this.m_renamed);
                this.k_renamed = true;
                layoutParams.topMargin = (this.g_renamed.getPaddingTop() - this.m_renamed.getIntrinsicHeight()) + this.C_renamed;
            } else {
                this.j_renamed.setBackground(this.n_renamed);
                layoutParams.gravity = 80;
                layoutParams.bottomMargin = (this.g_renamed.getPaddingBottom() - this.n_renamed.getIntrinsicHeight()) + this.C_renamed;
            }
        } else if (i_renamed == 16) {
            this.k_renamed = true;
            layoutParams.rightMargin = (this.g_renamed.getPaddingRight() - this.p_renamed.getIntrinsicWidth()) + this.C_renamed;
            layoutParams.leftMargin = (getWidth() - layoutParams.rightMargin) - this.p_renamed.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.t_renamed.y_renamed) - this.s_renamed[1]) - (this.p_renamed.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.p_renamed.getIntrinsicHeight();
            this.j_renamed.setBackground(this.p_renamed);
        } else {
            layoutParams.leftMargin = (this.g_renamed.getPaddingLeft() - this.o_renamed.getIntrinsicWidth()) + this.C_renamed;
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.o_renamed.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.t_renamed.y_renamed) - this.s_renamed[1]) - (this.p_renamed.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.p_renamed.getIntrinsicHeight();
            this.j_renamed.setBackground(this.o_renamed);
        }
        this.f_renamed.addView(this.j_renamed, layoutParams);
    }

    private void b_renamed(android.graphics.Rect rect) {
        int iB;
        int iCenterY;
        int iC;
        int i_renamed;
        int i2 = this.q_renamed;
        if (i2 == 4) {
            iB = java.lang.Math.min(rect.centerX() - (b_renamed() / 2), this.d_renamed.right - b_renamed());
            int i3 = rect.top - this.d_renamed.top;
            int i4 = this.d_renamed.bottom - rect.bottom;
            iC = c_renamed();
            if (i3 >= iC) {
                i_renamed = rect.top;
                iCenterY = i_renamed - iC;
            } else if (i4 >= iC) {
                iCenterY = rect.bottom;
            } else if (i3 > i4) {
                iCenterY = this.d_renamed.top;
                setHeight(i3);
            } else {
                iCenterY = rect.bottom;
                setHeight(i4);
            }
        } else if (i2 == 128) {
            iB = java.lang.Math.min(rect.centerX() - (b_renamed() / 2), this.d_renamed.right - b_renamed());
            int i5 = rect.top - this.d_renamed.top;
            int i6 = this.d_renamed.bottom - rect.bottom;
            iC = c_renamed();
            if (i6 >= iC) {
                iCenterY = rect.bottom;
            } else if (i5 >= iC) {
                i_renamed = rect.top;
                iCenterY = i_renamed - iC;
            } else if (i5 > i6) {
                iCenterY = this.d_renamed.top;
                setHeight(i5);
            } else {
                iCenterY = rect.bottom;
                setHeight(i6);
            }
        } else {
            iB = i2 == 16 ? rect.left - b_renamed() : rect.right;
            iCenterY = rect.centerY() - (((c_renamed() + this.g_renamed.getPaddingTop()) - this.g_renamed.getPaddingBottom()) / 2);
        }
        this.f3079c.getRootView().getLocationOnScreen(this.r_renamed);
        int[] iArr = this.r_renamed;
        int i7 = iArr[0];
        int i8 = iArr[1];
        this.f3079c.getRootView().getLocationInWindow(this.r_renamed);
        int[] iArr2 = this.r_renamed;
        int i9 = iArr2[0];
        int i10 = iArr2[1];
        int[] iArr3 = this.s_renamed;
        iArr3[0] = i7 - i9;
        iArr3[1] = i8 - i10;
        this.t_renamed.set(java.lang.Math.max(0, (iB - iArr3[0]) - this.e_renamed.left), java.lang.Math.max(0, (iCenterY - this.s_renamed[1]) - this.e_renamed.top));
    }

    private int b_renamed() {
        return (getWidth() - this.e_renamed.left) + this.e_renamed.right;
    }

    private int c_renamed() {
        return (getHeight() - this.e_renamed.top) + this.e_renamed.bottom;
    }

    public void a_renamed(java.lang.CharSequence charSequence) {
        this.h_renamed.setText(charSequence);
    }

    private void d_renamed() {
        int i_renamed = this.q_renamed;
        if (i_renamed == 4) {
            if ((this.A_renamed.centerX() - this.s_renamed[0]) - this.t_renamed.x_renamed >= b_renamed()) {
                this.u_renamed = 1.0f;
            } else if (b_renamed() != 0) {
                int iCenterX = (this.A_renamed.centerX() - this.s_renamed[0]) - this.t_renamed.x_renamed;
                if (iCenterX <= 0) {
                    iCenterX = -iCenterX;
                }
                this.u_renamed = iCenterX / b_renamed();
            } else {
                this.u_renamed = 0.5f;
            }
            if (this.t_renamed.y_renamed >= this.A_renamed.top - this.s_renamed[1]) {
                this.v_renamed = 0.0f;
                return;
            } else {
                this.v_renamed = 1.0f;
                return;
            }
        }
        this.u_renamed = i_renamed == 16 ? 1.0f : 0.0f;
        this.v_renamed = ((this.A_renamed.centerY() - this.t_renamed.y_renamed) - this.s_renamed[1]) / c_renamed();
    }

    private void e_renamed() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, this.u_renamed, 1, this.v_renamed);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.setInterpolator(this.w_renamed);
        animationSet.setDuration(300L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.coui.appcompat.widget.s_renamed.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }
        });
        this.f_renamed.startAnimation(animationSet);
    }

    private void f_renamed() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, this.u_renamed, 1, this.v_renamed);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.setDuration(300L);
        animationSet.setInterpolator(this.w_renamed);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.coui.appcompat.widget.s_renamed.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.coui.appcompat.widget.s_renamed.this.x_renamed = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.coui.appcompat.widget.s_renamed.this.g_renamed();
                com.coui.appcompat.widget.s_renamed.this.x_renamed = false;
            }
        });
        this.f_renamed.startAnimation(animationSet);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!this.x_renamed) {
            f_renamed();
        } else {
            g_renamed();
            this.x_renamed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g_renamed() {
        super.dismiss();
        i_renamed();
        this.f_renamed.removeAllViews();
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    private void h_renamed() {
        i_renamed();
        this.f3079c.addOnLayoutChangeListener(this.y_renamed);
    }

    private void i_renamed() {
        this.f3079c.removeOnLayoutChangeListener(this.y_renamed);
    }

    public boolean b_renamed(android.view.View view) {
        return view.getLayoutDirection() == 1;
    }
}
