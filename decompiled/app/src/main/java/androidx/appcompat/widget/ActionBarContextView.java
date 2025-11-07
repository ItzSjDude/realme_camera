package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a_renamed {
    private java.lang.CharSequence g_renamed;
    private java.lang.CharSequence h_renamed;
    private android.view.View i_renamed;
    private android.view.View j_renamed;
    private android.widget.LinearLayout k_renamed;
    private android.widget.TextView l_renamed;
    private android.widget.TextView m_renamed;
    private int n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private int q_renamed;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ androidx.core.h_renamed.z_renamed a_renamed(int i_renamed, long j_renamed) {
        return super.a_renamed(i_renamed, j_renamed);
    }

    @Override // androidx.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a_renamed
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.a_renamed, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a_renamed, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a_renamed, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
    }

    public ActionBarContextView(android.content.Context context) {
        this(context, null);
    }

    public ActionBarContextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.actionModeStyle);
    }

    public ActionBarContextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, androidx.appcompat.R_renamed.styleable.ActionMode, i_renamed, 0);
        androidx.core.h_renamed.v_renamed.a_renamed(this, arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ActionMode_background));
        this.n_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionMode_titleTextStyle, 0);
        this.o_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionMode_subtitleTextStyle, 0);
        this.e_renamed = arVarA.f_renamed(androidx.appcompat.R_renamed.styleable.ActionMode_height, 0);
        this.q_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionMode_closeItemLayout, androidx.appcompat.R_renamed.layout.abc_action_mode_close_item_material);
        arVarA.b_renamed();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d_renamed != null) {
            this.d_renamed.d_renamed();
            this.d_renamed.f_renamed();
        }
    }

    @Override // androidx.appcompat.widget.a_renamed
    public void setContentHeight(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public void setCustomView(android.view.View view) {
        android.widget.LinearLayout linearLayout;
        android.view.View view2 = this.j_renamed;
        if (view2 != null) {
            removeView(view2);
        }
        this.j_renamed = view;
        if (view != null && (linearLayout = this.k_renamed) != null) {
            removeView(linearLayout);
            this.k_renamed = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.g_renamed = charSequence;
        e_renamed();
    }

    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.h_renamed = charSequence;
        e_renamed();
    }

    public java.lang.CharSequence getTitle() {
        return this.g_renamed;
    }

    public java.lang.CharSequence getSubtitle() {
        return this.h_renamed;
    }

    private void e_renamed() {
        if (this.k_renamed == null) {
            android.view.LayoutInflater.from(getContext()).inflate(androidx.appcompat.R_renamed.layout.abc_action_bar_title_item, this);
            this.k_renamed = (android.widget.LinearLayout) getChildAt(getChildCount() - 1);
            this.l_renamed = (android.widget.TextView) this.k_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar_title);
            this.m_renamed = (android.widget.TextView) this.k_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar_subtitle);
            if (this.n_renamed != 0) {
                this.l_renamed.setTextAppearance(getContext(), this.n_renamed);
            }
            if (this.o_renamed != 0) {
                this.m_renamed.setTextAppearance(getContext(), this.o_renamed);
            }
        }
        this.l_renamed.setText(this.g_renamed);
        this.m_renamed.setText(this.h_renamed);
        boolean z_renamed = !android.text.TextUtils.isEmpty(this.g_renamed);
        boolean z2 = !android.text.TextUtils.isEmpty(this.h_renamed);
        int i_renamed = 0;
        this.m_renamed.setVisibility(z2 ? 0 : 8);
        android.widget.LinearLayout linearLayout = this.k_renamed;
        if (!z_renamed && !z2) {
            i_renamed = 8;
        }
        linearLayout.setVisibility(i_renamed);
        if (this.k_renamed.getParent() == null) {
            addView(this.k_renamed);
        }
    }

    public void a_renamed(final androidx.appcompat.view.b_renamed bVar) {
        android.view.View view = this.i_renamed;
        if (view == null) {
            this.i_renamed = android.view.LayoutInflater.from(getContext()).inflate(this.q_renamed, (android.view.ViewGroup) this, false);
            addView(this.i_renamed);
        } else if (view.getParent() == null) {
            addView(this.i_renamed);
        }
        this.i_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.action_mode_close_button).setOnClickListener(new android.view.View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                bVar.c_renamed();
            }
        });
        androidx.appcompat.view.menu.h_renamed hVar = (androidx.appcompat.view.menu.h_renamed) bVar.b_renamed();
        if (this.d_renamed != null) {
            this.d_renamed.e_renamed();
        }
        this.d_renamed = new androidx.appcompat.widget.ActionMenuPresenter(getContext());
        this.d_renamed.a_renamed(true);
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-2, -1);
        hVar.addMenuPresenter(this.d_renamed, this.f515b);
        this.f516c = (androidx.appcompat.widget.ActionMenuView) this.d_renamed.a_renamed(this);
        androidx.core.h_renamed.v_renamed.a_renamed(this.f516c, (android.graphics.drawable.Drawable) null);
        addView(this.f516c, layoutParams);
    }

    public void b_renamed() {
        if (this.i_renamed == null) {
            c_renamed();
        }
    }

    public void c_renamed() {
        removeAllViews();
        this.j_renamed = null;
        this.f516c = null;
    }

    @Override // androidx.appcompat.widget.a_renamed
    public boolean a_renamed() {
        if (this.d_renamed != null) {
            return this.d_renamed.c_renamed();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new android.view.ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        if (android.view.View.MeasureSpec.getMode(i_renamed) != 1073741824) {
            throw new java.lang.IllegalStateException(getClass().getSimpleName() + " can only be_renamed used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (android.view.View.MeasureSpec.getMode(i2) == 0) {
            throw new java.lang.IllegalStateException(getClass().getSimpleName() + " can only be_renamed used with android:layout_height=\"wrap_content\"");
        }
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int size2 = this.e_renamed > 0 ? this.e_renamed : android.view.View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        android.view.View view = this.i_renamed;
        if (view != null) {
            int iA = a_renamed(view, paddingLeft, iMakeMeasureSpec, 0);
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.i_renamed.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.f516c != null && this.f516c.getParent() == this) {
            paddingLeft = a_renamed(this.f516c, paddingLeft, iMakeMeasureSpec, 0);
        }
        android.widget.LinearLayout linearLayout = this.k_renamed;
        if (linearLayout != null && this.j_renamed == null) {
            if (this.p_renamed) {
                this.k_renamed.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.k_renamed.getMeasuredWidth();
                boolean z_renamed = measuredWidth <= paddingLeft;
                if (z_renamed) {
                    paddingLeft -= measuredWidth;
                }
                this.k_renamed.setVisibility(z_renamed ? 0 : 8);
            } else {
                paddingLeft = a_renamed(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        android.view.View view2 = this.j_renamed;
        if (view2 != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = java.lang.Math.min(layoutParams.width, paddingLeft);
            }
            int i4 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
            if (layoutParams.height >= 0) {
                iMin = java.lang.Math.min(layoutParams.height, iMin);
            }
            this.j_renamed.measure(android.view.View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), android.view.View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.e_renamed <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i5) {
                    i5 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i5);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int iA;
        boolean zA = androidx.appcompat.widget.ax_renamed.a_renamed(this);
        int paddingRight = zA ? (i3 - i_renamed) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        android.view.View view = this.i_renamed;
        if (view == null || view.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.i_renamed.getLayoutParams();
            int i5 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = a_renamed(paddingRight, i5, zA);
            iA = a_renamed(iA2 + a_renamed(this.i_renamed, iA2, paddingTop, paddingTop2, zA), i6, zA);
        }
        android.widget.LinearLayout linearLayout = this.k_renamed;
        if (linearLayout != null && this.j_renamed == null && linearLayout.getVisibility() != 8) {
            iA += a_renamed(this.k_renamed, iA, paddingTop, paddingTop2, zA);
        }
        int i7 = iA;
        android.view.View view2 = this.j_renamed;
        if (view2 != null) {
            a_renamed(view2, i7, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i3 - i_renamed) - getPaddingRight();
        if (this.f516c != null) {
            a_renamed(this.f516c, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g_renamed);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z_renamed) {
        if (z_renamed != this.p_renamed) {
            requestLayout();
        }
        this.p_renamed = z_renamed;
    }

    public boolean d_renamed() {
        return this.p_renamed;
    }
}
