package com.coui.appcompat.widget.toolbar;

/* compiled from: COUIActionMenuView.java */
/* loaded from: classes.dex */
public class a_renamed extends androidx.appcompat.widget.ActionMenuView {
    private com.coui.appcompat.a_renamed.g_renamed A_renamed;
    private android.widget.PopupWindow.OnDismissListener B_renamed;
    private android.view.View C_renamed;
    private java.lang.String D_renamed;
    private java.lang.String E_renamed;
    private int F_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    public com.coui.appcompat.widget.popupwindow.d_renamed f3115c;
    private androidx.appcompat.view.menu.h_renamed d_renamed;
    private java.util.List<java.lang.Class<?>> e_renamed;
    private int f_renamed;
    private int g_renamed;
    private java.util.ArrayList h_renamed;
    private androidx.appcompat.view.menu.j_renamed i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private int q_renamed;
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;

    public a_renamed(android.content.Context context) {
        this(context, null);
    }

    public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d_renamed = null;
        this.e_renamed = new java.util.ArrayList();
        this.p_renamed = true;
        this.q_renamed = 0;
        this.q_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_actionbar_menuview_padding);
        this.j_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_action_menu_item_min_width);
        this.k_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.overflow_button_padding_horizontal);
        this.l_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.toolbar_edge_text_menu_item_margin);
        this.m_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.toolbar_edge_icon_menu_item_margin);
        this.n_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.toolbar_icon_item_horizontal_offset);
        this.o_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.toolbar_item_vertical_offset);
        this.g_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_action_menu_text_extra_padding);
        this.f_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_actionbar_menuitemview_item_spacing);
        this.r_renamed = new java.util.HashMap<>();
        this.u_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_red_dot_horizontal_offset);
        this.v_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_red_dot_vertical_offset);
        this.w_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_red_dot_with_number_vertical_offset);
        this.x_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_red_dot_with_number_horizontal_offset);
        this.y_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_red_dot_with_big_number_horizontal_offset);
        this.z_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_icon_top_padding);
        this.A_renamed = new com.coui.appcompat.a_renamed.g_renamed(getContext(), null, coui.support.appcompat.R_renamed.styleable.COUIHintRedDot, 0, coui.support.appcompat.R_renamed.style.Widget_COUI_COUIHintRedDot_Small);
        this.D_renamed = getResources().getString(coui.support.appcompat.R_renamed.string.abc_action_menu_overflow_description);
        this.E_renamed = getResources().getString(coui.support.appcompat.R_renamed.string.red_dot_description);
        this.F_renamed = coui.support.appcompat.R_renamed.plurals.red_dot_with_number_description;
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        view.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.coui.appcompat.widget.toolbar.a_renamed.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view2) {
                return true;
            }
        });
        view.setHapticFeedbackEnabled(false);
        if (((androidx.appcompat.widget.ActionMenuView.c_renamed) layoutParams).f443a) {
            this.C_renamed = view;
            this.C_renamed.setBackgroundResource(coui.support.appcompat.R_renamed.drawable.coui_toolbar_menu_bg);
            layoutParams.height = -1;
            this.C_renamed.setMinimumWidth(this.j_renamed);
            android.view.View view2 = this.C_renamed;
            view2.setPadding(this.k_renamed, view2.getPaddingTop(), this.k_renamed, this.C_renamed.getPaddingBottom());
            this.C_renamed.setOnTouchListener(null);
            view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.widget.toolbar.a_renamed.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view3) {
                    if (com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c == null) {
                        com.coui.appcompat.widget.toolbar.a_renamed aVar = com.coui.appcompat.widget.toolbar.a_renamed.this;
                        aVar.f3115c = new com.coui.appcompat.widget.popupwindow.d_renamed(aVar.getContext());
                        com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.setInputMethodMode(2);
                        com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.a_renamed(true);
                        com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.setOnDismissListener(com.coui.appcompat.widget.toolbar.a_renamed.this.B_renamed);
                        com.coui.appcompat.widget.toolbar.a_renamed.this.h_renamed = new java.util.ArrayList();
                    }
                    com.coui.appcompat.widget.toolbar.a_renamed.this.h_renamed.clear();
                    if (com.coui.appcompat.widget.toolbar.a_renamed.this.d_renamed != null) {
                        for (int i2 = 0; i2 < com.coui.appcompat.widget.toolbar.a_renamed.this.d_renamed.getNonActionItems().size(); i2++) {
                            com.coui.appcompat.widget.toolbar.a_renamed aVar2 = com.coui.appcompat.widget.toolbar.a_renamed.this;
                            aVar2.i_renamed = aVar2.d_renamed.getNonActionItems().get(i2);
                            com.coui.appcompat.widget.toolbar.a_renamed.this.h_renamed.add(new com.coui.appcompat.widget.popupwindow.g_renamed(com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.getIcon(), com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.getTitle() != null ? com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.getTitle().toString() : "", com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.isCheckable(), com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.isChecked(), com.coui.appcompat.widget.toolbar.a_renamed.this.r_renamed.containsKey(java.lang.Integer.valueOf(com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.getItemId())) ? ((java.lang.Integer) com.coui.appcompat.widget.toolbar.a_renamed.this.r_renamed.get(java.lang.Integer.valueOf(com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.getItemId()))).intValue() : -1, com.coui.appcompat.widget.toolbar.a_renamed.this.i_renamed.isEnabled()));
                        }
                        com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.a_renamed(com.coui.appcompat.widget.toolbar.a_renamed.this.h_renamed);
                        com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.a_renamed(new android.widget.AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.widget.toolbar.a_renamed.2.1
                            @Override // android.widget.AdapterView.OnItemClickListener
                            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view4, int i3, long j_renamed) {
                                com.coui.appcompat.widget.toolbar.a_renamed.this.d_renamed.performItemAction(com.coui.appcompat.widget.toolbar.a_renamed.this.d_renamed.getNonActionItems().get(i3), 0);
                                com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.dismiss();
                            }
                        });
                    }
                    com.coui.appcompat.widget.toolbar.a_renamed.this.f3115c.a_renamed(com.coui.appcompat.widget.toolbar.a_renamed.this.C_renamed);
                }
            });
        }
        super.addView(view, i_renamed, layoutParams);
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        if (this.d_renamed == null) {
            super.onMeasure(i_renamed, i2);
            return;
        }
        this.p_renamed = true;
        if ((getParent() instanceof com.coui.appcompat.widget.toolbar.COUIToolbar) && ((com.coui.appcompat.widget.toolbar.COUIToolbar) getParent()).getIsTitleCenterStyle()) {
            this.p_renamed = false;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        k_renamed();
        int iB = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            iB += b_renamed(getChildAt(i3), i_renamed, iB, i2, 0);
        }
        if (this.p_renamed) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < childCount; i6++) {
                    if (getChildAt(i6).getVisibility() != 8) {
                        i5++;
                        i4 = i6;
                    }
                }
                int i7 = iB + ((i5 - 1) * this.f_renamed);
                if (i4 != -1) {
                    android.view.View childAt = getChildAt(i4);
                    if ((childAt instanceof android.widget.TextView) && !android.text.TextUtils.isEmpty(((android.widget.TextView) childAt).getText())) {
                        i7 += this.g_renamed;
                    }
                }
                size = i7;
            } else {
                size = 0;
            }
            if (z_renamed) {
                setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void k_renamed() {
        int i_renamed = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4).getVisibility() != 8) {
                i_renamed++;
                if (i_renamed == 1) {
                    i2 = i4;
                    i3 = i2;
                } else {
                    i3 = i4;
                }
            }
        }
        if (i2 != -1 && !this.p_renamed && i_renamed > 1) {
            android.view.View childAt = getChildAt(i2);
            if (childAt instanceof androidx.appcompat.view.menu.b_renamed) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (((androidx.appcompat.view.menu.b_renamed) childAt).getItemData().getIcon() == null) {
                    if (l_renamed()) {
                        marginLayoutParams.rightMargin = this.l_renamed;
                    } else {
                        marginLayoutParams.leftMargin = this.l_renamed;
                    }
                } else if (l_renamed()) {
                    marginLayoutParams.rightMargin = this.m_renamed;
                } else {
                    marginLayoutParams.leftMargin = this.m_renamed;
                }
            }
        }
        if (i3 != -1) {
            android.view.View childAt2 = getChildAt(i3);
            if (childAt2 instanceof androidx.appcompat.view.menu.b_renamed) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams2 = (android.view.ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                if (((androidx.appcompat.view.menu.b_renamed) childAt2).getItemData().getIcon() == null) {
                    if (l_renamed()) {
                        marginLayoutParams2.leftMargin = this.l_renamed;
                        return;
                    } else {
                        marginLayoutParams2.rightMargin = this.l_renamed;
                        return;
                    }
                }
                if (l_renamed()) {
                    marginLayoutParams2.leftMargin = this.m_renamed;
                } else {
                    marginLayoutParams2.rightMargin = this.m_renamed;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (getChildAt(i7).getVisibility() != 8) {
                i6++;
            }
        }
        if (i6 > 5) {
            super.onLayout(z_renamed, i_renamed, i2, i3, i4);
            return;
        }
        boolean zA = androidx.appcompat.widget.ax_renamed.a_renamed(this);
        int i8 = (i4 - i2) / 2;
        if (this.p_renamed) {
            if (zA) {
                int width = getWidth() - getPaddingRight();
                while (i5 < childCount) {
                    android.view.View childAt = getChildAt(i5);
                    androidx.appcompat.widget.ActionMenuView.c_renamed cVar = (androidx.appcompat.widget.ActionMenuView.c_renamed) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8) {
                        int i9 = width - cVar.rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i10 = i8 - (measuredHeight / 2);
                        childAt.layout(i9 - measuredWidth, i10, i9, measuredHeight + i10);
                        width = i9 - ((measuredWidth + cVar.leftMargin) + this.f_renamed);
                    }
                    i5++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i5 < childCount) {
                android.view.View childAt2 = getChildAt(i5);
                androidx.appcompat.widget.ActionMenuView.c_renamed cVar2 = (androidx.appcompat.widget.ActionMenuView.c_renamed) childAt2.getLayoutParams();
                if (childAt2.getVisibility() != 8) {
                    int i11 = paddingLeft + cVar2.leftMargin;
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i12 = i8 - (measuredHeight2 / 2);
                    childAt2.layout(i11, i12, i11 + measuredWidth2, measuredHeight2 + i12);
                    paddingLeft = i11 + measuredWidth2 + cVar2.rightMargin + this.f_renamed;
                }
                i5++;
            }
            return;
        }
        if (zA) {
            int paddingLeft2 = getPaddingLeft();
            boolean z2 = true;
            for (int i13 = childCount - 1; i13 >= 0; i13--) {
                android.view.View childAt3 = getChildAt(i13);
                androidx.appcompat.widget.ActionMenuView.c_renamed cVar3 = (androidx.appcompat.widget.ActionMenuView.c_renamed) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8) {
                    paddingLeft2 += cVar3.leftMargin;
                    if (z2) {
                        if ((childAt3 instanceof android.widget.TextView) && !android.text.TextUtils.isEmpty(((android.widget.TextView) childAt3).getText())) {
                            paddingLeft2 += this.g_renamed;
                        }
                        z2 = false;
                    }
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i14 = i8 - (measuredHeight3 / 2);
                    if (i13 == 0 && i6 > 1) {
                        int width2 = ((getWidth() - getPaddingRight()) - cVar3.rightMargin) - measuredWidth3;
                        if ((childAt3 instanceof android.widget.TextView) && !android.text.TextUtils.isEmpty(((android.widget.TextView) childAt3).getText())) {
                            width2 -= this.q_renamed;
                        }
                        childAt3.layout(width2, i14, measuredWidth3 + width2, measuredHeight3 + i14);
                    } else {
                        childAt3.layout(paddingLeft2, i14, paddingLeft2 + measuredWidth3, measuredHeight3 + i14);
                        paddingLeft2 += measuredWidth3 + cVar3.rightMargin + this.f_renamed;
                    }
                }
            }
            return;
        }
        int width3 = getWidth() - getPaddingRight();
        boolean z3 = true;
        for (int i15 = childCount - 1; i15 >= 0; i15--) {
            android.view.View childAt4 = getChildAt(i15);
            androidx.appcompat.widget.ActionMenuView.c_renamed cVar4 = (androidx.appcompat.widget.ActionMenuView.c_renamed) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8) {
                width3 -= cVar4.rightMargin;
                if (z3) {
                    if ((childAt4 instanceof android.widget.TextView) && !android.text.TextUtils.isEmpty(((android.widget.TextView) childAt4).getText())) {
                        width3 -= this.g_renamed;
                    }
                    z3 = false;
                }
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i16 = i8 - (measuredHeight4 / 2);
                if (i15 == 0 && i6 > 1) {
                    int paddingLeft3 = getPaddingLeft() + cVar4.leftMargin;
                    if ((childAt4 instanceof android.widget.TextView) && !android.text.TextUtils.isEmpty(((android.widget.TextView) childAt4).getText())) {
                        paddingLeft3 += this.q_renamed;
                    }
                    childAt4.layout(paddingLeft3, i16, measuredWidth4 + paddingLeft3, measuredHeight4 + i16);
                } else {
                    childAt4.layout(width3 - measuredWidth4, i16, width3, measuredHeight4 + i16);
                    width3 -= (measuredWidth4 + cVar4.leftMargin) + this.f_renamed;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void setOverflowReserved(boolean z_renamed) {
        super.setOverflowReserved(z_renamed);
        com.coui.appcompat.widget.popupwindow.d_renamed dVar = this.f3115c;
        if (dVar == null || !dVar.isShowing()) {
            return;
        }
        this.h_renamed.clear();
        if (this.d_renamed.getNonActionItems().size() == 0) {
            ((android.widget.BaseAdapter) this.f3115c.c_renamed().getAdapter()).notifyDataSetChanged();
            this.f3115c.dismiss();
            return;
        }
        for (int i_renamed = 0; i_renamed < this.d_renamed.getNonActionItems().size(); i_renamed++) {
            this.i_renamed = this.d_renamed.getNonActionItems().get(i_renamed);
            this.h_renamed.add(new com.coui.appcompat.widget.popupwindow.g_renamed(this.i_renamed.getIcon(), this.i_renamed.getTitle() != null ? this.i_renamed.getTitle().toString() : "", this.i_renamed.isCheckable(), this.i_renamed.isChecked(), this.r_renamed.containsKey(java.lang.Integer.valueOf(this.i_renamed.getItemId())) ? this.r_renamed.get(java.lang.Integer.valueOf(this.i_renamed.getItemId())).intValue() : -1, this.i_renamed.isEnabled()));
        }
        ((android.widget.BaseAdapter) this.f3115c.c_renamed().getAdapter()).notifyDataSetChanged();
        this.f3115c.a_renamed();
        com.coui.appcompat.widget.popupwindow.d_renamed dVar2 = this.f3115c;
        dVar2.update(dVar2.getWidth(), this.f3115c.getHeight());
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public android.view.Menu getMenu() {
        this.d_renamed = (androidx.appcompat.view.menu.h_renamed) super.getMenu();
        return this.d_renamed;
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.view.menu.o_renamed
    public void initialize(androidx.appcompat.view.menu.h_renamed hVar) {
        this.d_renamed = hVar;
        super.initialize(hVar);
    }

    private int b_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        view.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + i5 + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + i5;
    }

    public void j_renamed() {
        this.t_renamed = 0;
        this.s_renamed = 0;
        this.r_renamed.clear();
    }

    private java.lang.String b_renamed(int i_renamed) {
        return i_renamed != -1 ? i_renamed != 0 ? getResources().getQuantityString(this.F_renamed, i_renamed, java.lang.Integer.valueOf(i_renamed)) : this.E_renamed : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (this.r_renamed.containsKey(java.lang.Integer.valueOf(childAt.getId()))) {
                a_renamed(childAt, this.r_renamed.get(java.lang.Integer.valueOf(childAt.getId())).intValue(), canvas);
            }
            if (((androidx.appcompat.widget.ActionMenuView.c_renamed) childAt.getLayoutParams()).f443a) {
                int i2 = this.s_renamed == 0 ? -1 : this.t_renamed;
                a_renamed(childAt, i2, canvas);
                childAt.setContentDescription(this.D_renamed + "," + b_renamed(i2));
            }
        }
    }

    private void a_renamed(android.view.View view, int i_renamed, android.graphics.Canvas canvas) {
        int i2;
        int i3;
        float x_renamed;
        float x2;
        int i4 = i_renamed != -1 ? i_renamed != 0 ? 2 : 1 : 0;
        if (view != null) {
            int iA = this.A_renamed.a_renamed(i4, i_renamed);
            int iA2 = this.A_renamed.a_renamed(i4);
            if (i4 == 1) {
                i2 = this.u_renamed;
                i3 = this.v_renamed;
            } else if (i_renamed < 100) {
                i2 = this.x_renamed;
                i3 = this.w_renamed;
            } else {
                i2 = this.y_renamed;
                i3 = this.w_renamed;
            }
            android.graphics.RectF rectF = new android.graphics.RectF();
            if ((view instanceof androidx.appcompat.view.menu.b_renamed) && ((androidx.appcompat.view.menu.b_renamed) view).getItemData().getIcon() == null) {
                if (l_renamed()) {
                    x2 = (view.getX() + i2) - this.q_renamed;
                    x_renamed = x2 - iA;
                } else {
                    x_renamed = ((view.getX() + view.getWidth()) - i2) + this.q_renamed;
                    x2 = iA + x_renamed;
                }
            } else if (l_renamed()) {
                x2 = ((view.getX() + i2) - this.q_renamed) + this.n_renamed;
                x_renamed = x2 - iA;
            } else {
                x_renamed = (((view.getX() + view.getWidth()) - i2) + this.q_renamed) - this.n_renamed;
                x2 = iA + x_renamed;
            }
            float f_renamed = (this.z_renamed - i3) + this.o_renamed;
            rectF.left = x_renamed;
            rectF.top = f_renamed;
            rectF.right = x2;
            rectF.bottom = iA2 + f_renamed;
            this.A_renamed.a_renamed(canvas, i4, i_renamed, rectF);
        }
    }

    private boolean l_renamed() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
    }

    public void setPopupWindowOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.B_renamed = onDismissListener;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public boolean e_renamed() {
        if (this.f3115c == null) {
            return false;
        }
        this.h_renamed.clear();
        for (int i_renamed = 0; i_renamed < this.d_renamed.getNonActionItems().size(); i_renamed++) {
            this.i_renamed = this.d_renamed.getNonActionItems().get(i_renamed);
            this.h_renamed.add(new com.coui.appcompat.widget.popupwindow.g_renamed(this.i_renamed.getIcon(), this.i_renamed.getTitle() != null ? this.i_renamed.getTitle().toString() : "", this.i_renamed.isCheckable(), this.i_renamed.isChecked(), this.r_renamed.containsKey(java.lang.Integer.valueOf(this.i_renamed.getItemId())) ? this.r_renamed.get(java.lang.Integer.valueOf(this.i_renamed.getItemId())).intValue() : -1, this.i_renamed.isEnabled()));
        }
        ((android.widget.BaseAdapter) this.f3115c.c_renamed().getAdapter()).notifyDataSetChanged();
        this.f3115c.a_renamed(this.C_renamed);
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void i_renamed() {
        com.coui.appcompat.widget.popupwindow.d_renamed dVar = this.f3115c;
        if (dVar != null) {
            dVar.dismiss();
        }
        super.i_renamed();
    }
}
