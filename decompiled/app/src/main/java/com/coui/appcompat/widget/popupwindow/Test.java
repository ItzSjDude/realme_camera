package com.coui.appcompat.widget.popupwindow;

/* compiled from: COUIPopupListWindow.java */
/* loaded from: classes.dex */
public class d_renamed extends android.widget.PopupWindow implements android.view.View.OnLayoutChangeListener {
    private boolean A_renamed;
    private boolean B_renamed;
    private boolean C_renamed;
    private android.view.animation.Animation.AnimationListener D_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f3059a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.BaseAdapter f3060b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.BaseAdapter f3061c;
    private android.widget.BaseAdapter d_renamed;
    private android.view.View e_renamed;
    private android.graphics.Rect f_renamed;
    private android.graphics.Rect g_renamed;
    private android.graphics.Rect h_renamed;
    private android.graphics.Rect i_renamed;
    private java.util.List<com.coui.appcompat.widget.popupwindow.g_renamed> j_renamed;
    private android.view.ViewGroup k_renamed;
    private android.widget.ListView l_renamed;
    private android.widget.ListView m_renamed;
    private android.widget.AdapterView.OnItemClickListener n_renamed;
    private android.graphics.Point o_renamed;
    private int[] p_renamed;
    private int[] q_renamed;
    private int[] r_renamed;
    private float s_renamed;
    private float t_renamed;
    private int u_renamed;
    private int v_renamed;
    private android.view.animation.Interpolator w_renamed;
    private android.view.animation.Interpolator x_renamed;
    private int y_renamed;
    private boolean z_renamed;

    public d_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.o_renamed = new android.graphics.Point();
        this.p_renamed = new int[2];
        this.q_renamed = new int[2];
        this.r_renamed = new int[4];
        this.D_renamed = new android.view.animation.Animation.AnimationListener() { // from class: com.coui.appcompat.widget.popupwindow.d_renamed.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.coui.appcompat.widget.popupwindow.d_renamed.this.C_renamed = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.coui.appcompat.widget.popupwindow.d_renamed.this.b_renamed();
                com.coui.appcompat.widget.popupwindow.d_renamed.this.C_renamed = false;
            }
        };
        this.f3059a = context;
        this.j_renamed = new java.util.ArrayList();
        this.u_renamed = context.getResources().getInteger(coui.support.appcompat.R_renamed.integer.coui_animation_time_move_veryfast);
        this.v_renamed = context.getResources().getInteger(coui.support.appcompat.R_renamed.integer.coui_animation_time_move_veryfast);
        android.view.animation.Interpolator interpolatorLoadInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, coui.support.appcompat.R_renamed.anim.coui_curve_opacity_inout);
        this.x_renamed = interpolatorLoadInterpolator;
        this.w_renamed = interpolatorLoadInterpolator;
        this.y_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_popup_list_window_min_width);
        this.m_renamed = new android.widget.ListView(context);
        this.m_renamed.setDivider(null);
        this.m_renamed.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        this.k_renamed = a_renamed(context);
        setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        setClippingEnabled(false);
        if (android.os.Build.VERSION.SDK_INT > 23) {
            setExitTransition(null);
            setEnterTransition(null);
        }
    }

    private android.view.ViewGroup a_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) android.view.LayoutInflater.from(context).inflate(coui.support.appcompat.R_renamed.layout.coui_popup_list_window_layout, (android.view.ViewGroup) null);
        this.l_renamed = (android.widget.ListView) frameLayout.findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_popup_list_view);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{coui.support.appcompat.R_renamed.attr.couiPopupListWindowBackground});
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = context.getResources().getDrawable(coui.support.appcompat.R_renamed.drawable.coui_popup_list_window_bg);
        }
        this.i_renamed = new android.graphics.Rect();
        drawable.getPadding(this.i_renamed);
        frameLayout.setBackground(drawable);
        typedArrayObtainStyledAttributes.recycle();
        return frameLayout;
    }

    public void a_renamed(android.view.View view) {
        if (view != null) {
            if ((this.f3060b == null && this.f3061c == null) || isShowing()) {
                return;
            }
            this.e_renamed = view;
            this.e_renamed.getRootView().removeOnLayoutChangeListener(this);
            this.e_renamed.getRootView().addOnLayoutChangeListener(this);
            android.widget.BaseAdapter baseAdapter = this.f3061c;
            if (baseAdapter == null) {
                this.d_renamed = this.f3060b;
            } else {
                this.d_renamed = baseAdapter;
            }
            this.l_renamed.setAdapter((android.widget.ListAdapter) this.d_renamed);
            android.widget.AdapterView.OnItemClickListener onItemClickListener = this.n_renamed;
            if (onItemClickListener != null) {
                this.l_renamed.setOnItemClickListener(onItemClickListener);
            }
            this.f_renamed = new android.graphics.Rect();
            this.g_renamed = new android.graphics.Rect();
            this.h_renamed = new android.graphics.Rect();
            this.e_renamed.getWindowVisibleDisplayFrame(this.f_renamed);
            this.e_renamed.getGlobalVisibleRect(this.g_renamed);
            this.e_renamed.getRootView().getGlobalVisibleRect(this.h_renamed);
            this.g_renamed.left -= this.r_renamed[0];
            this.g_renamed.top -= this.r_renamed[1];
            this.g_renamed.right += this.r_renamed[2];
            this.g_renamed.bottom += this.r_renamed[3];
            this.e_renamed.getRootView().getLocationOnScreen(this.p_renamed);
            android.graphics.Rect rect = this.g_renamed;
            int[] iArr = this.p_renamed;
            rect.offset(iArr[0], iArr[1]);
            android.graphics.Rect rect2 = this.h_renamed;
            int[] iArr2 = this.p_renamed;
            rect2.offset(iArr2[0], iArr2[1]);
            android.graphics.Rect rect3 = this.f_renamed;
            rect3.left = java.lang.Math.max(rect3.left, this.h_renamed.left);
            android.graphics.Rect rect4 = this.f_renamed;
            rect4.top = java.lang.Math.max(rect4.top, this.h_renamed.top);
            android.graphics.Rect rect5 = this.f_renamed;
            rect5.right = java.lang.Math.min(rect5.right, this.h_renamed.right);
            android.graphics.Rect rect6 = this.f_renamed;
            rect6.bottom = java.lang.Math.min(rect6.bottom, this.h_renamed.bottom);
            d_renamed();
            a_renamed();
            f_renamed();
            if (this.z_renamed && this.A_renamed) {
                setContentView(this.k_renamed);
                g_renamed();
                h_renamed();
                showAtLocation(this.e_renamed, 0, this.o_renamed.x_renamed, this.o_renamed.y_renamed);
            }
        }
    }

    private void d_renamed() {
        this.e_renamed.getRootView().getLocationOnScreen(this.p_renamed);
        int[] iArr = this.p_renamed;
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        this.e_renamed.getRootView().getLocationInWindow(this.p_renamed);
        int[] iArr2 = this.p_renamed;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        int[] iArr3 = this.q_renamed;
        iArr3[0] = i_renamed - i3;
        iArr3[1] = i2 - i4;
    }

    public void a_renamed() {
        android.widget.BaseAdapter baseAdapter = this.d_renamed;
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(e_renamed(), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = baseAdapter.getCount();
        int i_renamed = 0;
        int iMakeMeasureSpec3 = iMakeMeasureSpec2;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            android.view.View view = baseAdapter.getView(i3, null, this.m_renamed);
            android.widget.AbsListView.LayoutParams layoutParams = (android.widget.AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams.height != -2) {
                iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
            i_renamed += measuredHeight;
        }
        setWidth(java.lang.Math.max(i2, this.y_renamed) + this.i_renamed.left + this.i_renamed.right);
        setHeight(i_renamed + this.i_renamed.top + this.i_renamed.bottom);
    }

    private int e_renamed() {
        return ((this.f_renamed.right - this.f_renamed.left) - this.i_renamed.left) - this.i_renamed.right;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f_renamed() {
        /*
            r9 = this;
            r0 = 1
            r9.A_renamed = r0
            r9.z_renamed = r0
            android.graphics.Rect r1 = r9.f_renamed
            int r1 = r1.right
            android.graphics.Rect r2 = r9.f_renamed
            int r2 = r2.left
            int r1 = r1 - r2
            int r2 = r9.getWidth()
            r3 = 0
            if (r1 >= r2) goto L18
            r9.A_renamed = r3
            return
        L18:
            android.graphics.Rect r1 = r9.g_renamed
            int r1 = r1.centerX()
            int r2 = r9.getWidth()
            int r2 = r2 / 2
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.f_renamed
            int r2 = r2.right
            int r4 = r9.getWidth()
            int r2 = r2 - r4
            int r1 = java.lang.Math.min(r1, r2)
            android.graphics.Rect r2 = r9.f_renamed
            int r2 = r2.left
            int r1 = java.lang.Math.max(r2, r1)
            int[] r2 = r9.q_renamed
            r2 = r2[r3]
            int r1 = r1 - r2
            android.graphics.Rect r2 = r9.g_renamed
            int r2 = r2.top
            android.graphics.Rect r4 = r9.f_renamed
            int r4 = r4.top
            int r2 = r2 - r4
            android.graphics.Rect r4 = r9.f_renamed
            int r4 = r4.bottom
            android.graphics.Rect r5 = r9.g_renamed
            int r5 = r5.bottom
            int r4 = r4 - r5
            int r5 = r9.getHeight()
            if (r2 < r5) goto L59
            r6 = r0
            goto L5a
        L59:
            r6 = r3
        L5a:
            if (r4 < r5) goto L5e
            r7 = r0
            goto L5f
        L5e:
            r7 = r3
        L5f:
            android.graphics.Rect r8 = r9.g_renamed
            int r8 = r8.top
            int r8 = r8 - r5
            android.graphics.Rect r5 = r9.g_renamed
            int r5 = r5.bottom
            if (r4 > 0) goto L6f
            if (r2 > 0) goto L6f
            r9.z_renamed = r3
            return
        L6f:
            boolean r3 = r9.B_renamed
            if (r3 == 0) goto L76
            if (r6 == 0) goto L7e
            goto L78
        L76:
            if (r7 == 0) goto L7e
        L78:
            boolean r2 = r9.B_renamed
            if (r2 == 0) goto L9d
        L7c:
            r5 = r8
            goto L9d
        L7e:
            boolean r3 = r9.B_renamed
            if (r3 == 0) goto L85
            if (r7 == 0) goto L8c
            goto L87
        L85:
            if (r6 == 0) goto L8c
        L87:
            boolean r2 = r9.B_renamed
            if (r2 == 0) goto L7c
            goto L9d
        L8c:
            if (r2 <= r4) goto L96
            android.graphics.Rect r3 = r9.f_renamed
            int r5 = r3.top
            r9.setHeight(r2)
            goto L9d
        L96:
            android.graphics.Rect r2 = r9.g_renamed
            int r5 = r2.bottom
            r9.setHeight(r4)
        L9d:
            android.graphics.Point r2 = r9.o_renamed
            int[] r9 = r9.q_renamed
            r9 = r9[r0]
            int r5 = r5 - r9
            r2.set(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.d_renamed.f_renamed():void");
    }

    private void g_renamed() {
        if ((this.g_renamed.centerX() - this.q_renamed[0]) - this.o_renamed.x_renamed >= getWidth()) {
            this.s_renamed = 1.0f;
        } else {
            this.s_renamed = ((this.g_renamed.centerX() - this.q_renamed[0]) - this.o_renamed.x_renamed) / getWidth();
        }
        if (this.o_renamed.y_renamed >= this.g_renamed.top - this.q_renamed[1]) {
            this.t_renamed = 0.0f;
        } else {
            this.t_renamed = 1.0f;
        }
    }

    private void h_renamed() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, this.s_renamed, 1, this.t_renamed);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration(this.u_renamed);
        scaleAnimation.setInterpolator(this.w_renamed);
        alphaAnimation.setDuration(this.v_renamed);
        alphaAnimation.setInterpolator(this.x_renamed);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.k_renamed.startAnimation(animationSet);
    }

    private void i_renamed() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.v_renamed);
        alphaAnimation.setInterpolator(this.x_renamed);
        alphaAnimation.setAnimationListener(this.D_renamed);
        this.k_renamed.startAnimation(alphaAnimation);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        android.graphics.Rect rect = new android.graphics.Rect(i_renamed, i2, i3, i4);
        android.graphics.Rect rect2 = new android.graphics.Rect(i5, i6, i7, i8);
        if (!isShowing() || rect.equals(rect2)) {
            return;
        }
        b_renamed();
    }

    public void b_renamed() {
        super.dismiss();
        this.C_renamed = false;
        this.e_renamed.getRootView().removeOnLayoutChangeListener(this);
        setContentView(null);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!this.C_renamed) {
            i_renamed();
        } else {
            b_renamed();
        }
    }

    public void a_renamed(java.util.List<com.coui.appcompat.widget.popupwindow.g_renamed> list) {
        if (list != null) {
            this.j_renamed = list;
            this.f3060b = new com.coui.appcompat.widget.popupwindow.f_renamed(this.f3059a, list);
        }
    }

    public void a_renamed(android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        this.n_renamed = onItemClickListener;
    }

    public android.widget.ListView c_renamed() {
        return this.l_renamed;
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
}
