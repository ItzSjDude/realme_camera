package androidx.appcompat.widget;

/* loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.c_renamed implements androidx.core.h_renamed.b_renamed.a_renamed {
    androidx.appcompat.widget.ActionMenuPresenter.d_renamed g_renamed;
    androidx.appcompat.widget.ActionMenuPresenter.e_renamed h_renamed;
    androidx.appcompat.widget.ActionMenuPresenter.a_renamed i_renamed;
    androidx.appcompat.widget.ActionMenuPresenter.c_renamed j_renamed;
    final androidx.appcompat.widget.ActionMenuPresenter.f_renamed k_renamed;
    int l_renamed;
    private android.graphics.drawable.Drawable m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private int x_renamed;
    private final android.util.SparseBooleanArray y_renamed;
    private androidx.appcompat.widget.ActionMenuPresenter.b_renamed z_renamed;

    public ActionMenuPresenter(android.content.Context context) {
        super(context, androidx.appcompat.R_renamed.layout.abc_action_menu_layout, androidx.appcompat.R_renamed.layout.abc_action_menu_item_layout);
        this.y_renamed = new android.util.SparseBooleanArray();
        this.k_renamed = new androidx.appcompat.widget.ActionMenuPresenter.f_renamed();
    }

    @Override // androidx.appcompat.view.menu.c_renamed, androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        super.initForMenu(context, hVar);
        android.content.res.Resources resources = context.getResources();
        androidx.appcompat.view.a_renamed aVarA = androidx.appcompat.view.a_renamed.a_renamed(context);
        if (!this.p_renamed) {
            this.o_renamed = aVarA.b_renamed();
        }
        if (!this.v_renamed) {
            this.q_renamed = aVarA.c_renamed();
        }
        if (!this.t_renamed) {
            this.s_renamed = aVarA.a_renamed();
        }
        int measuredWidth = this.q_renamed;
        if (this.o_renamed) {
            if (this.g_renamed == null) {
                this.g_renamed = new androidx.appcompat.widget.ActionMenuPresenter.d_renamed(this.f364a);
                if (this.n_renamed) {
                    this.g_renamed.setImageDrawable(this.m_renamed);
                    this.m_renamed = null;
                    this.n_renamed = false;
                }
                int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g_renamed.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.g_renamed.getMeasuredWidth();
        } else {
            this.g_renamed = null;
        }
        this.r_renamed = measuredWidth;
        this.x_renamed = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a_renamed(android.content.res.Configuration configuration) {
        if (!this.t_renamed) {
            this.s_renamed = androidx.appcompat.view.a_renamed.a_renamed(this.f365b).a_renamed();
        }
        if (this.f366c != null) {
            this.f366c.onItemsChanged(true);
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
        this.p_renamed = true;
    }

    public void b_renamed(boolean z_renamed) {
        this.w_renamed = z_renamed;
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.widget.ActionMenuPresenter.d_renamed dVar = this.g_renamed;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.n_renamed = true;
            this.m_renamed = drawable;
        }
    }

    public android.graphics.drawable.Drawable b_renamed() {
        androidx.appcompat.widget.ActionMenuPresenter.d_renamed dVar = this.g_renamed;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n_renamed) {
            return this.m_renamed;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.c_renamed
    public androidx.appcompat.view.menu.o_renamed a_renamed(android.view.ViewGroup viewGroup) {
        androidx.appcompat.view.menu.o_renamed oVar = this.f_renamed;
        androidx.appcompat.view.menu.o_renamed oVarA = super.a_renamed(viewGroup);
        if (oVar != oVarA) {
            ((androidx.appcompat.widget.ActionMenuView) oVarA).setPresenter(this);
        }
        return oVarA;
    }

    @Override // androidx.appcompat.view.menu.c_renamed
    public android.view.View a_renamed(androidx.appcompat.view.menu.j_renamed jVar, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View actionView = jVar.getActionView();
        if (actionView == null || jVar.m_renamed()) {
            actionView = super.a_renamed(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        androidx.appcompat.widget.ActionMenuView actionMenuView = (androidx.appcompat.widget.ActionMenuView) viewGroup;
        android.view.ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.c_renamed
    public void a_renamed(androidx.appcompat.view.menu.j_renamed jVar, androidx.appcompat.view.menu.o_renamed.a_renamed aVar) {
        aVar.initialize(jVar, 0);
        androidx.appcompat.view.menu.b_renamed bVar = (androidx.appcompat.view.menu.b_renamed) aVar;
        bVar.setItemInvoker((androidx.appcompat.widget.ActionMenuView) this.f_renamed);
        if (this.z_renamed == null) {
            this.z_renamed = new androidx.appcompat.widget.ActionMenuPresenter.b_renamed();
        }
        bVar.setPopupCallback(this.z_renamed);
    }

    @Override // androidx.appcompat.view.menu.c_renamed
    public boolean a_renamed(int i_renamed, androidx.appcompat.view.menu.j_renamed jVar) {
        return jVar.j_renamed();
    }

    @Override // androidx.appcompat.view.menu.c_renamed, androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        super.updateMenuView(z_renamed);
        ((android.view.View) this.f_renamed).requestLayout();
        boolean z2 = false;
        if (this.f366c != null) {
            java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> actionItems = this.f366c.getActionItems();
            int size = actionItems.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.core.h_renamed.b_renamed bVarA = actionItems.get(i_renamed).a_renamed();
                if (bVarA != null) {
                    bVarA.a_renamed(this);
                }
            }
        }
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = this.f366c != null ? this.f366c.getNonActionItems() : null;
        if (this.o_renamed && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g_renamed == null) {
                this.g_renamed = new androidx.appcompat.widget.ActionMenuPresenter.d_renamed(this.f364a);
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.g_renamed.getParent();
            if (viewGroup != this.f_renamed) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g_renamed);
                }
                androidx.appcompat.widget.ActionMenuView actionMenuView = (androidx.appcompat.widget.ActionMenuView) this.f_renamed;
                actionMenuView.addView(this.g_renamed, actionMenuView.c_renamed());
            }
        } else {
            androidx.appcompat.widget.ActionMenuPresenter.d_renamed dVar = this.g_renamed;
            if (dVar != null && dVar.getParent() == this.f_renamed) {
                ((android.view.ViewGroup) this.f_renamed).removeView(this.g_renamed);
            }
        }
        ((androidx.appcompat.widget.ActionMenuView) this.f_renamed).setOverflowReserved(this.o_renamed);
    }

    @Override // androidx.appcompat.view.menu.c_renamed
    public boolean a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        if (viewGroup.getChildAt(i_renamed) == this.g_renamed) {
            return false;
        }
        return super.a_renamed(viewGroup, i_renamed);
    }

    @Override // androidx.appcompat.view.menu.c_renamed, androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        boolean z_renamed = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.s_renamed sVar2 = sVar;
        while (sVar2.getParentMenu() != this.f366c) {
            sVar2 = (androidx.appcompat.view.menu.s_renamed) sVar2.getParentMenu();
        }
        android.view.View viewA = a_renamed(sVar2.getItem());
        if (viewA == null) {
            return false;
        }
        this.l_renamed = sVar.getItem().getItemId();
        int size = sVar.size();
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= size) {
                break;
            }
            android.view.MenuItem item = sVar.getItem(i_renamed);
            if (item.isVisible() && item.getIcon() != null) {
                z_renamed = true;
                break;
            }
            i_renamed++;
        }
        this.i_renamed = new androidx.appcompat.widget.ActionMenuPresenter.a_renamed(this.f365b, sVar, viewA);
        this.i_renamed.a_renamed(z_renamed);
        this.i_renamed.a_renamed();
        super.onSubMenuSelected(sVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private android.view.View a_renamed(android.view.MenuItem menuItem) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.f_renamed;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = viewGroup.getChildAt(i_renamed);
            if ((childAt instanceof androidx.appcompat.view.menu.o_renamed.a_renamed) && ((androidx.appcompat.view.menu.o_renamed.a_renamed) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean c_renamed() {
        if (!this.o_renamed || g_renamed() || this.f366c == null || this.f_renamed == null || this.j_renamed != null || this.f366c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.j_renamed = new androidx.appcompat.widget.ActionMenuPresenter.c_renamed(new androidx.appcompat.widget.ActionMenuPresenter.e_renamed(this.f365b, this.f366c, this.g_renamed, true));
        ((android.view.View) this.f_renamed).post(this.j_renamed);
        super.onSubMenuSelected(null);
        return true;
    }

    public boolean d_renamed() {
        if (this.j_renamed != null && this.f_renamed != null) {
            ((android.view.View) this.f_renamed).removeCallbacks(this.j_renamed);
            this.j_renamed = null;
            return true;
        }
        androidx.appcompat.widget.ActionMenuPresenter.e_renamed eVar = this.h_renamed;
        if (eVar == null) {
            return false;
        }
        eVar.d_renamed();
        return true;
    }

    public boolean e_renamed() {
        return f_renamed() | d_renamed();
    }

    public boolean f_renamed() {
        androidx.appcompat.widget.ActionMenuPresenter.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return false;
        }
        aVar.d_renamed();
        return true;
    }

    public boolean g_renamed() {
        androidx.appcompat.widget.ActionMenuPresenter.e_renamed eVar = this.h_renamed;
        return eVar != null && eVar.f_renamed();
    }

    public boolean h_renamed() {
        return this.j_renamed != null || g_renamed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // androidx.appcompat.view.menu.c_renamed, androidx.appcompat.view.menu.n_renamed
    public boolean flagActionItems() {
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> visibleItems;
        int size;
        int i_renamed;
        int iA;
        boolean z_renamed;
        int i2;
        boolean z2;
        androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter = this;
        android.view.View view = null;
        ?? r3 = 0;
        if (actionMenuPresenter.f366c != null) {
            visibleItems = actionMenuPresenter.f366c.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i3 = actionMenuPresenter.s_renamed;
        int i4 = actionMenuPresenter.r_renamed;
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) actionMenuPresenter.f_renamed;
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.appcompat.view.menu.j_renamed jVar = visibleItems.get(i8);
            if (jVar.requiresActionButton()) {
                i5++;
            } else if (jVar.k_renamed()) {
                i6++;
            } else {
                z3 = true;
            }
            if (actionMenuPresenter.w_renamed && jVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.o_renamed && (z3 || i6 + i5 > i7)) {
            i7--;
        }
        int i9 = i7 - i5;
        android.util.SparseBooleanArray sparseBooleanArray = actionMenuPresenter.y_renamed;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.u_renamed) {
            int i10 = actionMenuPresenter.x_renamed;
            iA = i4 / i10;
            i_renamed = i10 + ((i4 % i10) / iA);
        } else {
            i_renamed = 0;
            iA = 0;
        }
        int i11 = 0;
        int i12 = i4;
        int i13 = 0;
        while (i13 < size) {
            androidx.appcompat.view.menu.j_renamed jVar2 = visibleItems.get(i13);
            if (jVar2.requiresActionButton()) {
                android.view.View viewA = actionMenuPresenter.a_renamed(jVar2, view, viewGroup);
                if (actionMenuPresenter.u_renamed) {
                    iA -= androidx.appcompat.widget.ActionMenuView.a_renamed(viewA, i_renamed, iA, iMakeMeasureSpec, r3);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewA.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i11 != 0) {
                    measuredWidth = i11;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z2 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z2 = true;
                }
                jVar2.d_renamed(z2);
                i11 = measuredWidth;
                z_renamed = r3;
                i2 = size;
            } else if (jVar2.k_renamed()) {
                int groupId2 = jVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i9 > 0 || z4) && i12 > 0 && (!actionMenuPresenter.u_renamed || iA > 0);
                if (z5) {
                    boolean z6 = z5;
                    i2 = size;
                    android.view.View viewA2 = actionMenuPresenter.a_renamed(jVar2, null, viewGroup);
                    if (actionMenuPresenter.u_renamed) {
                        int iA2 = androidx.appcompat.widget.ActionMenuView.a_renamed(viewA2, i_renamed, iA, iMakeMeasureSpec, 0);
                        iA -= iA2;
                        z6 = iA2 == 0 ? false : z6;
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z5 = z6 & (!actionMenuPresenter.u_renamed ? i12 + i11 <= 0 : i12 < 0);
                } else {
                    i2 = size;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i13; i14++) {
                        androidx.appcompat.view.menu.j_renamed jVar3 = visibleItems.get(i14);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.j_renamed()) {
                                i9++;
                            }
                            jVar3.d_renamed(false);
                        }
                    }
                }
                if (z5) {
                    i9--;
                }
                jVar2.d_renamed(z5);
                z_renamed = false;
            } else {
                z_renamed = r3;
                i2 = size;
                jVar2.d_renamed(z_renamed);
            }
            i13++;
            r3 = z_renamed;
            size = i2;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.c_renamed, androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        e_renamed();
        super.onCloseMenu(hVar, z_renamed);
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.ActionMenuPresenter.SavedState savedState = new androidx.appcompat.widget.ActionMenuPresenter.SavedState();
        savedState.openSubMenuId = this.l_renamed;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        android.view.MenuItem menuItemFindItem;
        if (parcelable instanceof androidx.appcompat.widget.ActionMenuPresenter.SavedState) {
            androidx.appcompat.widget.ActionMenuPresenter.SavedState savedState = (androidx.appcompat.widget.ActionMenuPresenter.SavedState) parcelable;
            if (savedState.openSubMenuId <= 0 || (menuItemFindItem = this.f366c.findItem(savedState.openSubMenuId)) == null) {
                return;
            }
            onSubMenuSelected((androidx.appcompat.view.menu.s_renamed) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.core.h_renamed.b_renamed.a_renamed
    public void c_renamed(boolean z_renamed) {
        if (z_renamed) {
            super.onSubMenuSelected(null);
        } else if (this.f366c != null) {
            this.f366c.close(false);
        }
    }

    public void a_renamed(androidx.appcompat.widget.ActionMenuView actionMenuView) {
        this.f_renamed = actionMenuView;
        actionMenuView.initialize(this.f366c);
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.appcompat.widget.ActionMenuPresenter.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.appcompat.widget.ActionMenuPresenter.SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.appcompat.widget.ActionMenuPresenter.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.appcompat.widget.ActionMenuPresenter.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.appcompat.widget.ActionMenuPresenter.SavedState[] newArray(int i_renamed) {
                return new androidx.appcompat.widget.ActionMenuPresenter.SavedState[i_renamed];
            }
        };
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(android.os.Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    private class d_renamed extends androidx.appcompat.widget.AppCompatImageView implements androidx.appcompat.widget.ActionMenuView.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final float[] f435b;

        @Override // androidx.appcompat.widget.ActionMenuView.a_renamed
        public boolean b_renamed() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a_renamed
        public boolean c_renamed() {
            return false;
        }

        public d_renamed(android.content.Context context) {
            super(context, null, androidx.appcompat.R_renamed.attr.actionOverflowButtonStyle);
            this.f435b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            androidx.appcompat.widget.at_renamed.a_renamed(this, getContentDescription());
            setOnTouchListener(new androidx.appcompat.widget.ad_renamed(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.d_renamed.1
                @Override // androidx.appcompat.widget.ad_renamed
                public androidx.appcompat.view.menu.q_renamed a_renamed() {
                    if (androidx.appcompat.widget.ActionMenuPresenter.this.h_renamed == null) {
                        return null;
                    }
                    return androidx.appcompat.widget.ActionMenuPresenter.this.h_renamed.b_renamed();
                }

                @Override // androidx.appcompat.widget.ad_renamed
                public boolean b_renamed() {
                    androidx.appcompat.widget.ActionMenuPresenter.this.c_renamed();
                    return true;
                }

                @Override // androidx.appcompat.widget.ad_renamed
                public boolean c_renamed() {
                    if (androidx.appcompat.widget.ActionMenuPresenter.this.j_renamed != null) {
                        return false;
                    }
                    androidx.appcompat.widget.ActionMenuPresenter.this.d_renamed();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            androidx.appcompat.widget.ActionMenuPresenter.this.c_renamed();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i_renamed, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i_renamed, i2, i3, i4);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = java.lang.Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a_renamed.a_renamed(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e_renamed extends androidx.appcompat.view.menu.m_renamed {
        public e_renamed(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar, android.view.View view, boolean z_renamed) {
            super(context, hVar, view, z_renamed, androidx.appcompat.R_renamed.attr.actionOverflowMenuStyle);
            a_renamed(8388613);
            a_renamed(androidx.appcompat.widget.ActionMenuPresenter.this.k_renamed);
        }

        @Override // androidx.appcompat.view.menu.m_renamed
        protected void e_renamed() {
            if (androidx.appcompat.widget.ActionMenuPresenter.this.f366c != null) {
                androidx.appcompat.widget.ActionMenuPresenter.this.f366c.close();
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.h_renamed = null;
            super.e_renamed();
        }
    }

    private class a_renamed extends androidx.appcompat.view.menu.m_renamed {
        public a_renamed(android.content.Context context, androidx.appcompat.view.menu.s_renamed sVar, android.view.View view) {
            super(context, sVar, view, false, androidx.appcompat.R_renamed.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.j_renamed) sVar.getItem()).j_renamed()) {
                a_renamed(androidx.appcompat.widget.ActionMenuPresenter.this.g_renamed == null ? (android.view.View) androidx.appcompat.widget.ActionMenuPresenter.this.f_renamed : androidx.appcompat.widget.ActionMenuPresenter.this.g_renamed);
            }
            a_renamed(androidx.appcompat.widget.ActionMenuPresenter.this.k_renamed);
        }

        @Override // androidx.appcompat.view.menu.m_renamed
        protected void e_renamed() {
            androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter = androidx.appcompat.widget.ActionMenuPresenter.this;
            actionMenuPresenter.i_renamed = null;
            actionMenuPresenter.l_renamed = 0;
            super.e_renamed();
        }
    }

    private class f_renamed implements androidx.appcompat.view.menu.n_renamed.a_renamed {
        f_renamed() {
        }

        @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
        public boolean a_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
            if (hVar == null) {
                return false;
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.l_renamed = ((androidx.appcompat.view.menu.s_renamed) hVar).getItem().getItemId();
            androidx.appcompat.view.menu.n_renamed.a_renamed aVarA = androidx.appcompat.widget.ActionMenuPresenter.this.a_renamed();
            if (aVarA != null) {
                return aVarA.a_renamed(hVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
        public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
            if (hVar instanceof androidx.appcompat.view.menu.s_renamed) {
                hVar.getRootMenu().close(false);
            }
            androidx.appcompat.view.menu.n_renamed.a_renamed aVarA = androidx.appcompat.widget.ActionMenuPresenter.this.a_renamed();
            if (aVarA != null) {
                aVarA.a_renamed(hVar, z_renamed);
            }
        }
    }

    private class c_renamed implements java.lang.Runnable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.appcompat.widget.ActionMenuPresenter.e_renamed f433b;

        public c_renamed(androidx.appcompat.widget.ActionMenuPresenter.e_renamed eVar) {
            this.f433b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (androidx.appcompat.widget.ActionMenuPresenter.this.f366c != null) {
                androidx.appcompat.widget.ActionMenuPresenter.this.f366c.changeMenuMode();
            }
            android.view.View view = (android.view.View) androidx.appcompat.widget.ActionMenuPresenter.this.f_renamed;
            if (view != null && view.getWindowToken() != null && this.f433b.c_renamed()) {
                androidx.appcompat.widget.ActionMenuPresenter.this.h_renamed = this.f433b;
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.j_renamed = null;
        }
    }

    private class b_renamed extends androidx.appcompat.view.menu.b_renamed.ActionMenuItemView_2 {
        b_renamed() {
        }

        @Override // androidx.appcompat.view.menu.b_renamed.ActionMenuItemView_2
        public androidx.appcompat.view.menu.q_renamed a_renamed() {
            if (androidx.appcompat.widget.ActionMenuPresenter.this.i_renamed != null) {
                return androidx.appcompat.widget.ActionMenuPresenter.this.i_renamed.b_renamed();
            }
            return null;
        }
    }
}
