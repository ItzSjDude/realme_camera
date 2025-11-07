package com.coui.appcompat.widget.navigation;

/* compiled from: COUINavigationMenuView.java */
/* loaded from: classes.dex */
public class b_renamed extends android.view.ViewGroup implements androidx.appcompat.view.menu.o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View.OnClickListener f3005a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.navigation.a_renamed[] f3006b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.res.ColorStateList f3007c;
    private android.content.res.ColorStateList d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int[] l_renamed;
    private boolean m_renamed;
    private int n_renamed;
    private android.util.SparseArray<com.coui.appcompat.widget.navigation.b_renamed.a_renamed> o_renamed;
    private com.coui.appcompat.widget.navigation.COUINavigationPresenter p_renamed;
    private androidx.appcompat.view.menu.h_renamed q_renamed;

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.o_renamed
    public void initialize(androidx.appcompat.view.menu.h_renamed hVar) {
        this.q_renamed = hVar;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i_renamed) - (this.k_renamed * 2);
        int childCount = getChildCount();
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.f_renamed, 1073741824);
        int i3 = size / (childCount == 0 ? 1 : childCount);
        int i4 = size - (i3 * childCount);
        for (int i5 = 0; i5 < childCount; i5++) {
            int[] iArr = this.l_renamed;
            iArr[i5] = i3;
            if (i4 > 0) {
                iArr[i5] = iArr[i5] + 1;
                i4--;
            }
        }
        int measuredWidth = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            android.view.View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                if (childCount == 1) {
                    int i7 = this.k_renamed;
                    childAt.setPadding(i7, 0, i7, 0);
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.l_renamed[i6] + (this.k_renamed * 2), 1073741824), iMakeMeasureSpec);
                } else if (i6 == 0) {
                    childAt.setPadding(c_renamed() ? 0 : this.k_renamed, 0, c_renamed() ? this.k_renamed : 0, 0);
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.l_renamed[i6] + this.k_renamed, 1073741824), iMakeMeasureSpec);
                } else if (i6 == childCount - 1) {
                    childAt.setPadding(c_renamed() ? this.k_renamed : 0, 0, c_renamed() ? 0 : this.k_renamed, 0);
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.l_renamed[i6] + this.k_renamed, 1073741824), iMakeMeasureSpec);
                } else {
                    childAt.setPadding(0, 0, 0, 0);
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.l_renamed[i6], 1073741824), iMakeMeasureSpec);
                }
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(android.view.View.resolveSizeAndState(measuredWidth, android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), android.view.View.resolveSizeAndState(this.f_renamed, iMakeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i_renamed;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            android.view.View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (c_renamed()) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @java.lang.Deprecated
    public void setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.d_renamed = colorStateList;
        com.coui.appcompat.widget.navigation.a_renamed[] aVarArr = this.f3006b;
        if (aVarArr == null) {
            return;
        }
        for (com.coui.appcompat.widget.navigation.a_renamed aVar : aVarArr) {
            aVar.setIconTintList(colorStateList);
        }
    }

    public android.content.res.ColorStateList getIconTintList() {
        return this.d_renamed;
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.f3007c = colorStateList;
        com.coui.appcompat.widget.navigation.a_renamed[] aVarArr = this.f3006b;
        if (aVarArr == null) {
            return;
        }
        for (com.coui.appcompat.widget.navigation.a_renamed aVar : aVarArr) {
            aVar.setTextColor(colorStateList);
        }
    }

    public void setItemLayoutType(int i_renamed) {
        this.e_renamed = i_renamed;
        com.coui.appcompat.widget.navigation.a_renamed[] aVarArr = this.f3006b;
        if (aVarArr == null) {
            return;
        }
        for (com.coui.appcompat.widget.navigation.a_renamed aVar : aVarArr) {
            aVar.setItemLayoutType(i_renamed);
        }
    }

    public int getItemLayoutType() {
        return this.e_renamed;
    }

    public void setItemTextSize(int i_renamed) {
        this.j_renamed = i_renamed;
        com.coui.appcompat.widget.navigation.a_renamed[] aVarArr = this.f3006b;
        if (aVarArr == null) {
            return;
        }
        for (com.coui.appcompat.widget.navigation.a_renamed aVar : aVarArr) {
            aVar.setTextSize(i_renamed);
        }
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.f3007c;
    }

    public void setItemBackgroundRes(int i_renamed) {
        this.i_renamed = i_renamed;
        com.coui.appcompat.widget.navigation.a_renamed[] aVarArr = this.f3006b;
        if (aVarArr == null) {
            return;
        }
        for (com.coui.appcompat.widget.navigation.a_renamed aVar : aVarArr) {
            aVar.setItemBackground(i_renamed);
        }
    }

    public int getItemBackgroundRes() {
        return this.i_renamed;
    }

    public void setPresenter(com.coui.appcompat.widget.navigation.COUINavigationPresenter cOUINavigationPresenter) {
        this.p_renamed = cOUINavigationPresenter;
    }

    public void a_renamed() {
        int size = this.q_renamed.getVisibleItems().size();
        if (size != 0) {
            removeAllViews();
        }
        if (size == 0) {
            this.g_renamed = 0;
            this.h_renamed = 0;
            this.f3006b = null;
            return;
        }
        this.f3006b = new com.coui.appcompat.widget.navigation.a_renamed[size];
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.q_renamed.getVisibleItems().get(i_renamed);
            if (i_renamed >= 5) {
                break;
            }
            com.coui.appcompat.widget.navigation.a_renamed newItem = getNewItem();
            this.f3006b[i_renamed] = newItem;
            newItem.setIconTintList(this.d_renamed);
            newItem.setTextColor(this.f3007c);
            newItem.setTextSize(this.j_renamed);
            newItem.setItemBackground(this.i_renamed);
            newItem.initialize(jVar, 0);
            newItem.setItemPosition(i_renamed);
            newItem.setOnClickListener(this.f3005a);
            com.coui.appcompat.widget.navigation.b_renamed.a_renamed aVar = this.o_renamed.get(jVar.getItemId());
            if (aVar != null) {
                newItem.a_renamed(aVar.a_renamed(), aVar.b_renamed());
            }
            addView(newItem);
        }
        this.h_renamed = java.lang.Math.min(this.q_renamed.getVisibleItems().size() - 1, this.h_renamed);
        this.q_renamed.getVisibleItems().get(this.h_renamed).setChecked(true);
    }

    public void b_renamed() {
        int size = this.q_renamed.getVisibleItems().size();
        if (size != this.f3006b.length) {
            a_renamed();
            return;
        }
        int i_renamed = this.g_renamed;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.q_renamed.getVisibleItems().get(i2);
            if (jVar.isChecked()) {
                this.g_renamed = jVar.getItemId();
                this.h_renamed = i2;
            }
        }
        if (i_renamed != this.g_renamed) {
            int i3 = android.os.Build.VERSION.SDK_INT;
        }
        if (this.f3006b == null) {
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f3006b[i4] != null) {
                this.p_renamed.a_renamed(true);
                this.f3006b[i4].initialize(this.q_renamed.getVisibleItems().get(i4), 0);
                this.p_renamed.a_renamed(false);
            }
        }
    }

    public int getSelectedItemId() {
        return this.g_renamed;
    }

    void a_renamed(int i_renamed) {
        int size = this.q_renamed.getVisibleItems().size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.q_renamed.getVisibleItems().get(i2);
            if (i_renamed == jVar.getItemId()) {
                this.g_renamed = i_renamed;
                this.h_renamed = i2;
                jVar.setChecked(true);
                return;
            }
        }
    }

    public void setItemHeight(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    protected void setNeedTextAnim(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    private com.coui.appcompat.widget.navigation.a_renamed getNewItem() {
        return new com.coui.appcompat.widget.navigation.a_renamed(getContext(), this.e_renamed);
    }

    private boolean c_renamed() {
        return android.os.Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    /* compiled from: COUINavigationMenuView.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f3008a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f3009b;

        public int a_renamed() {
            return this.f3008a;
        }

        public int b_renamed() {
            return this.f3009b;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iA = com.coui.appcompat.a_renamed.l_renamed.a_renamed(getContext());
        if (iA != this.n_renamed) {
            a_renamed();
            this.n_renamed = iA;
        }
    }
}
