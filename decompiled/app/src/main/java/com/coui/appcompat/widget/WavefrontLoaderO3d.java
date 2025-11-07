package com.coui.appcompat.widget;

/* compiled from: COUISpinner.java */
/* loaded from: classes.dex */
public class o_renamed extends com.coui.appcompat.widget.COUIBaseSpinner implements com.coui.appcompat.widget.p_renamed {
    private static final android.view.animation.Interpolator H_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.133f, 0.0f, 0.3f, 1.0f);
    private static final android.view.animation.Interpolator I_renamed;
    private static final android.view.animation.Interpolator J_renamed;
    private static final android.view.animation.Interpolator K_renamed;
    private static final android.view.animation.Interpolator L_renamed;
    private final android.graphics.Rect M_renamed;
    private android.animation.AnimatorSet N_renamed;
    private android.graphics.drawable.RotateDrawable O_renamed;
    private int P_renamed;
    private int Q_renamed;
    private boolean R_renamed;
    private boolean S_renamed;
    private boolean T_renamed;
    private boolean U_renamed;
    private boolean V_renamed;
    private com.coui.appcompat.widget.p_renamed.a_renamed W_renamed;
    private android.widget.TextView aa_renamed;
    private int ab_renamed;
    private float ac_renamed;
    private android.content.res.ColorStateList ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private com.coui.appcompat.widget.o_renamed.a_renamed ag_renamed;

    /* compiled from: COUISpinner.java */
    public interface a_renamed {
        void a_renamed(com.coui.appcompat.widget.o_renamed oVar, boolean z_renamed);

        void b_renamed(com.coui.appcompat.widget.o_renamed oVar, boolean z_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ android.widget.SpinnerAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ int getBaseline() {
        return super.getBaseline();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownHorizontalOffset() {
        return super.getDropDownHorizontalOffset();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownVerticalOffset() {
        return super.getDropDownVerticalOffset();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownWidth() {
        return super.getDropDownWidth();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ android.graphics.drawable.Drawable getPopupBackground() {
        return super.getPopupBackground();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ java.lang.CharSequence getPrompt() {
        return super.getPrompt();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ android.view.View getSelectedView() {
        return super.getSelectedView();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.content.DialogInterface.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
        super.onClick(dialogInterface, i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public /* bridge */ /* synthetic */ android.os.Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ boolean performClick() {
        return super.performClick();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, android.view.View, android.view.ViewParent
    public /* bridge */ /* synthetic */ void requestLayout() {
        super.requestLayout();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner
    public /* bridge */ /* synthetic */ void setAdapter(android.widget.SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownHorizontalOffset(int i_renamed) {
        super.setDropDownHorizontalOffset(i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownVerticalOffset(int i_renamed) {
        super.setDropDownVerticalOffset(i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownWidth(int i_renamed) {
        super.setDropDownWidth(i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setGravity(int i_renamed) {
        super.setGravity(i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPopupBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setPopupBackgroundDrawable(drawable);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPopupBackgroundResource(int i_renamed) {
        super.setPopupBackgroundResource(i_renamed);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPrompt(java.lang.CharSequence charSequence) {
        super.setPrompt(charSequence);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPromptId(int i_renamed) {
        super.setPromptId(i_renamed);
    }

    static {
        android.view.animation.Interpolator interpolator = H_renamed;
        I_renamed = interpolator;
        J_renamed = interpolator;
        K_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.15f, 0.0f, 0.0f, 1.0f);
        L_renamed = androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.33f, 0.0f, 0.66f, 1.0f);
    }

    public com.coui.appcompat.widget.o_renamed.a_renamed getOnPopupWindowActionListener() {
        return this.ag_renamed;
    }

    public void setOnPopupWindowActionListener(com.coui.appcompat.widget.o_renamed.a_renamed aVar) {
        this.ag_renamed = aVar;
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.a_renamed
    public void setOnItemClickListener(com.coui.appcompat.widget.a_renamed.b_renamed bVar) {
        setOnItemClickListenerInt(bVar);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        android.graphics.drawable.RotateDrawable rotateDrawable = this.O_renamed;
        if (rotateDrawable == null || !this.R_renamed) {
            return;
        }
        int intrinsicWidth = rotateDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.O_renamed.getIntrinsicHeight();
        setMeasuredDimension(this.ab_renamed + intrinsicWidth + this.Q_renamed, a_renamed(i_renamed, i2));
        boolean z_renamed = !androidx.appcompat.widget.ax_renamed.a_renamed(this);
        int measuredWidth = z_renamed ? (getMeasuredWidth() - intrinsicWidth) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop() + ((((getMeasuredHeight() - intrinsicHeight) - getPaddingTop()) - getPaddingBottom()) / 2);
        if (z_renamed) {
            intrinsicWidth += measuredWidth;
        }
        this.O_renamed.setBounds(measuredWidth, paddingTop, intrinsicWidth, intrinsicHeight + paddingTop);
        this.R_renamed = false;
    }

    private int a_renamed(int i_renamed, int i2) {
        android.widget.TextView textView;
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || (textView = this.aa_renamed) == null) {
            return size;
        }
        measureChild(textView, i_renamed, i2);
        return java.lang.Math.max(this.aa_renamed.getMeasuredHeight(), getMeasuredHeight());
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.a_renamed, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.S_renamed = true;
        android.widget.TextView textView = (android.widget.TextView) findViewById(android.R_renamed.id_renamed.text1);
        if (textView != null) {
            textView.setTextColor(this.ad_renamed);
            n_renamed();
            if (textView.getPaint() != null) {
                com.coui.appcompat.a_renamed.a_renamed.a_renamed(textView, true);
                this.aa_renamed = textView;
                m_renamed();
            }
        }
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner
    void a_renamed(int i_renamed, boolean z_renamed) {
        int minimumWidth;
        android.graphics.drawable.RotateDrawable rotateDrawable;
        if (this.h_renamed == null || (rotateDrawable = this.O_renamed) == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = this.Q_renamed + rotateDrawable.getMinimumWidth();
            if (getLayoutDirection() == 1) {
                this.h_renamed.left += minimumWidth;
            } else {
                this.h_renamed.right += minimumWidth;
            }
        }
        super.a_renamed(i_renamed, z_renamed);
        this.h_renamed.right -= minimumWidth;
    }

    private void m_renamed() {
        android.widget.TextView textView = this.aa_renamed;
        if (textView == null) {
            return;
        }
        float textSize = textView.getTextSize();
        this.aa_renamed.setTextSize(0, (int) this.ac_renamed);
        if (android.os.Build.VERSION.SDK_INT >= 21 || textSize == this.ac_renamed) {
            return;
        }
        post(new java.lang.Runnable() { // from class: com.coui.appcompat.widget.o_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.coui.appcompat.widget.o_renamed.this.requestLayout();
            }
        });
    }

    public void setSpinnerTextSize(float f_renamed) {
        this.ac_renamed = f_renamed;
    }

    public void setSpinnerColorResource(int i_renamed) {
        setSpinnerColor(getResources().getColorStateList(i_renamed));
    }

    public void setSpinnerColor(int i_renamed) {
        setSpinnerColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setSpinnerColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        try {
            this.ad_renamed = colorStateList;
            this.ae_renamed = this.ad_renamed.getDefaultColor();
            this.af_renamed = this.ad_renamed.getColorForState(new int[]{-16842910}, -16777216);
            if (this.aa_renamed != null) {
                this.aa_renamed.setTextColor(this.ad_renamed);
            }
            if (this.O_renamed != null) {
                n_renamed();
                invalidate();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private void n_renamed() {
        int i_renamed;
        if (isEnabled()) {
            i_renamed = this.ae_renamed;
        } else {
            i_renamed = this.af_renamed;
        }
        this.O_renamed.setColorFilter(i_renamed, android.graphics.PorterDuff.Mode.SRC_IN);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        android.widget.TextView textView = this.aa_renamed;
        if (textView != null) {
            textView.setEnabled(z_renamed);
        }
        if (this.O_renamed != null) {
            n_renamed();
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U_renamed = false;
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.a_renamed, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.U_renamed = true;
        android.animation.AnimatorSet animatorSet = this.N_renamed;
        if (animatorSet != null) {
            animatorSet.end();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        this.V_renamed = true;
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        android.graphics.drawable.RotateDrawable rotateDrawable = this.O_renamed;
        if (rotateDrawable != null) {
            rotateDrawable.draw(canvas);
        }
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    int a_renamed(android.widget.SpinnerAdapter spinnerAdapter, android.graphics.drawable.Drawable drawable) {
        this.R_renamed = true;
        if (spinnerAdapter == null) {
            return 0;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= spinnerAdapter.getCount()) {
            return super.a_renamed(spinnerAdapter, drawable);
        }
        int iO = o_renamed();
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        spinnerAdapter.getItemViewType(selectedItemPosition);
        android.view.View view = spinnerAdapter.getView(selectedItemPosition, null, this);
        if (view instanceof android.widget.TextView) {
            this.aa_renamed = (android.widget.TextView) view;
            com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.aa_renamed, true);
            m_renamed();
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        }
        view.measure(iO, iMakeMeasureSpec);
        int measuredWidth = view.getMeasuredWidth();
        this.ab_renamed = measuredWidth;
        if (drawable == null) {
            return measuredWidth;
        }
        drawable.getPadding(this.M_renamed);
        return measuredWidth + this.M_renamed.left + this.M_renamed.right;
    }

    private int o_renamed() {
        int mode = android.view.View.MeasureSpec.getMode(this.f2680c);
        int size = android.view.View.MeasureSpec.getSize(this.f2680c) - (this.O_renamed.getMinimumWidth() + this.Q_renamed);
        if (size > 0) {
            return android.view.View.MeasureSpec.makeMeasureSpec(size, mode);
        }
        return this.f2680c;
    }

    @Override // com.coui.appcompat.widget.a_renamed
    void e_renamed() {
        if (this.S_renamed) {
            super.e_renamed();
        }
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.a_renamed
    public void setSelection(int i_renamed) {
        if (!this.T_renamed || this.F_renamed == null || !this.F_renamed.d_renamed() || !(this.F_renamed instanceof com.coui.appcompat.widget.o_renamed.b_renamed)) {
            super.setSelection(i_renamed);
        } else {
            ((com.coui.appcompat.widget.o_renamed.b_renamed) this.F_renamed).h_renamed = i_renamed;
        }
    }

    public void setDropdownDismissCallback(com.coui.appcompat.widget.p_renamed.a_renamed aVar) {
        this.W_renamed = aVar;
    }

    public void setDropdownItemClickListener(com.coui.appcompat.widget.a_renamed.b_renamed bVar) {
        setOnItemClickListener(bVar);
    }

    public void setDropdownUpdateAfterAnim(boolean z_renamed) {
        this.T_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(float f_renamed) {
        android.graphics.drawable.RotateDrawable rotateDrawable = this.O_renamed;
        if (rotateDrawable != null) {
            rotateDrawable.setLevel((int) (f_renamed * 10000.0f));
            invalidate();
        }
    }

    /* compiled from: COUISpinner.java */
    private class b_renamed extends com.coui.appcompat.widget.COUIBaseSpinner.b_renamed implements com.coui.appcompat.widget.p_renamed.b_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ com.coui.appcompat.widget.o_renamed f3011b;
        private final com.coui.appcompat.widget.popupwindow.a_renamed.g_renamed e_renamed;
        private final android.graphics.drawable.ColorDrawable f_renamed;
        private final int g_renamed;
        private int h_renamed;
        private boolean i_renamed;
        private com.coui.appcompat.widget.popupwindow.e_renamed j_renamed;
        private int k_renamed;

        @Override // com.coui.appcompat.widget.popupwindow.a_renamed
        public void h_renamed() {
            super.h_renamed();
            q_renamed();
        }

        @Override // com.coui.appcompat.widget.popupwindow.a_renamed, com.coui.appcompat.widget.COUIBaseSpinner.c_renamed
        public void c_renamed() {
            this.f3038c.dismiss();
        }

        @Override // com.coui.appcompat.widget.COUIBaseSpinner.b_renamed, com.coui.appcompat.widget.COUIBaseSpinner.c_renamed
        public void a_renamed(int i_renamed, int i2) {
            android.view.ViewTreeObserver viewTreeObserver;
            boolean zD = d_renamed();
            b_renamed();
            f_renamed(2);
            h_renamed();
            android.widget.ListView listViewP = p_renamed();
            listViewP.setDivider(null);
            listViewP.setChoiceMode(1);
            listViewP.setTextDirection(i_renamed);
            listViewP.setBackgroundColor(this.f3011b.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_spinner_popupwindow_listview_bg_color));
            a_renamed(listViewP);
            com.coui.appcompat.widget.t_renamed.a_renamed(listViewP, i2);
            g_renamed(this.f3011b.getSelectedItemPosition());
            u_renamed();
            if (zD || (viewTreeObserver = this.f3011b.getViewTreeObserver()) == null) {
                return;
            }
            final android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!com.coui.appcompat.widget.t_renamed.c_renamed(com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b)) {
                        com.coui.appcompat.widget.o_renamed.b_renamed.this.c_renamed();
                        return;
                    }
                    com.coui.appcompat.widget.o_renamed.b_renamed.this.b_renamed();
                    com.coui.appcompat.widget.o_renamed.b_renamed bVar = com.coui.appcompat.widget.o_renamed.b_renamed.this;
                    bVar.a_renamed(bVar.p_renamed());
                    com.coui.appcompat.widget.o_renamed.b_renamed.this.h_renamed();
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a_renamed(new com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.6
                @Override // com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed
                public void a_renamed() {
                    android.view.ViewTreeObserver viewTreeObserver2 = com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        com.coui.appcompat.widget.u_renamed.a_renamed(viewTreeObserver2, onGlobalLayoutListener);
                    }
                    com.coui.appcompat.widget.o_renamed.b_renamed.super.c_renamed();
                }
            });
        }

        @Override // com.coui.appcompat.widget.popupwindow.c_renamed, com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed
        public void a_renamed(android.view.WindowManager.LayoutParams layoutParams) {
            layoutParams.windowAnimations = 0;
        }

        @Override // com.coui.appcompat.widget.popupwindow.c_renamed, com.coui.appcompat.widget.popupwindow.e_renamed.a_renamed
        public void a_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar) {
            this.j_renamed = eVar;
            if (this.f3011b.W_renamed != null && this.i_renamed) {
                this.f3011b.W_renamed.a_renamed(this);
            } else {
                i_renamed();
            }
        }

        @Override // com.coui.appcompat.widget.popupwindow.c_renamed, com.coui.appcompat.widget.popupwindow.e_renamed.a_renamed
        public void b_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar) {
            if (!this.f3011b.T_renamed || this.h_renamed == -1) {
                return;
            }
            this.f3011b.S_renamed = false;
            this.f3011b.setSelection(this.h_renamed);
            this.h_renamed = -1;
        }

        public void i_renamed() {
            c_renamed(this.j_renamed);
        }

        @Override // com.coui.appcompat.widget.popupwindow.a_renamed
        protected int j_renamed() {
            if (this.f3011b.G_renamed == -1) {
                c_renamed(this.f3011b.getContext().getResources().getDisplayMetrics().widthPixels);
            }
            if (this.f3011b.P_renamed == -1) {
                e_renamed(this.f3038c.getMaxAvailableHeight(l_renamed(), f_renamed(), false));
            }
            return super.j_renamed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(final android.widget.ListView listView) {
            if (listView == null) {
                return;
            }
            listView.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (com.coui.appcompat.widget.o_renamed.b_renamed.this.a_renamed((android.view.View) listView) <= com.coui.appcompat.widget.o_renamed.b_renamed.this.k_renamed) {
                        return true;
                    }
                    android.view.ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
                    layoutParams.height = com.coui.appcompat.widget.o_renamed.b_renamed.this.k_renamed;
                    listView.setLayoutParams(layoutParams);
                    return false;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a_renamed(android.view.View view) {
            int height = view.getHeight();
            return height == 0 ? view.getMeasuredHeight() : height;
        }

        private void q_renamed() {
            this.f3038c.setTouchInterceptor(this.e_renamed);
            this.f3038c.setAnimationStyle(0);
        }

        private void r_renamed() {
            this.f_renamed.setColor(this.f3011b.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_spiner_background_color));
            this.f_renamed.setAlpha(this.g_renamed);
            this.f3038c.setBackgroundDrawable(this.f_renamed);
        }

        private void s_renamed() {
            android.widget.ListView listViewP = p_renamed();
            android.view.ViewGroup.LayoutParams layoutParams = listViewP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new android.view.ViewGroup.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
            listViewP.setLayoutParams(layoutParams);
            if (listViewP.getWidth() == 0 || listViewP.getHeight() == 0) {
                listViewP.measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.width, 0), android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, Integer.MIN_VALUE));
            }
        }

        private android.animation.AnimatorSet t_renamed() {
            final android.widget.ListView listViewP = p_renamed();
            final android.graphics.drawable.Drawable drawableE = e_renamed();
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(com.coui.appcompat.widget.o_renamed.I_renamed);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.a_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 102);
            valueAnimatorOfInt.setDuration(350L);
            valueAnimatorOfInt.setStartDelay(150L);
            valueAnimatorOfInt.setInterpolator(com.coui.appcompat.widget.o_renamed.L_renamed);
            valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    drawableE.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat2.setDuration(350L);
            valueAnimatorOfFloat2.setStartDelay(150L);
            valueAnimatorOfFloat2.setInterpolator(com.coui.appcompat.widget.o_renamed.K_renamed);
            valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    listViewP.setTranslationY((-com.coui.appcompat.widget.o_renamed.b_renamed.this.a_renamed((android.view.View) r0)) * (1.0f - fFloatValue));
                }
            });
            animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt).with(valueAnimatorOfFloat2);
            animatorSet.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.11
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    listViewP.setTranslationY(-com.coui.appcompat.widget.o_renamed.b_renamed.this.a_renamed((android.view.View) r2));
                    drawableE.setAlpha(0);
                    if (com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed != null) {
                        com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed.a_renamed(com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b, true);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed != null) {
                        com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed.a_renamed(com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b, false);
                    }
                }
            });
            return animatorSet;
        }

        android.animation.AnimatorSet k_renamed() {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            final android.widget.ListView listViewP = p_renamed();
            final android.graphics.drawable.Drawable drawableE = e_renamed();
            android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(102, 0);
            valueAnimatorOfInt.setInterpolator(com.coui.appcompat.widget.o_renamed.L_renamed);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    drawableE.setAlpha(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(com.coui.appcompat.widget.o_renamed.K_renamed);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    listViewP.setTranslationY((-com.coui.appcompat.widget.o_renamed.b_renamed.this.a_renamed((android.view.View) r0)) * fFloatValue);
                }
            });
            android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat2.setDuration(300L);
            valueAnimatorOfFloat2.setInterpolator(com.coui.appcompat.widget.o_renamed.I_renamed);
            valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.a_renamed(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.play(valueAnimatorOfInt).with(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.widget.o_renamed.b_renamed.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    if (com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed != null) {
                        com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed.b_renamed(com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b, false);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    super.onAnimationStart(animator);
                    if (com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed != null) {
                        com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.ag_renamed.b_renamed(com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b, true);
                    }
                }
            });
            return animatorSet;
        }

        private void u_renamed() {
            q_renamed();
            r_renamed();
            s_renamed();
            if (this.f3011b.N_renamed != null) {
                this.f3011b.N_renamed.end();
            }
            this.f3011b.N_renamed = t_renamed();
            this.f3011b.N_renamed.addListener(new com.coui.appcompat.widget.o_renamed.b_renamed.a_renamed(null));
            this.f3011b.N_renamed.start();
            if (this.f3011b.V_renamed) {
                this.f3011b.V_renamed = false;
                this.f3011b.N_renamed.end();
            }
        }

        private void c_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar) {
            if (this.f3011b.N_renamed != null) {
                this.f3011b.N_renamed.end();
            }
            this.f3011b.N_renamed = k_renamed();
            this.f3011b.N_renamed.addListener(new com.coui.appcompat.widget.o_renamed.b_renamed.a_renamed(this.f3011b.U_renamed ? null : eVar));
            this.f3011b.N_renamed.start();
            if (this.f3011b.U_renamed) {
                this.f3011b.U_renamed = false;
                eVar.b_renamed();
                this.f3011b.N_renamed.end();
            }
        }

        /* compiled from: COUISpinner.java */
        private class a_renamed extends android.animation.AnimatorListenerAdapter {

            /* renamed from: b_renamed, reason: collision with root package name */
            private final com.coui.appcompat.widget.popupwindow.e_renamed f3032b;

            public a_renamed(com.coui.appcompat.widget.popupwindow.e_renamed eVar) {
                this.f3032b = eVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.widget.o_renamed.b_renamed.this.f3011b.N_renamed = null;
                com.coui.appcompat.widget.popupwindow.e_renamed eVar = this.f3032b;
                if (eVar != null) {
                    eVar.b_renamed();
                }
            }
        }
    }
}
