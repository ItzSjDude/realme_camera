package com.google.android.material.internal;

/* loaded from: classes.dex */
public class NavigationMenuPresenter implements androidx.appcompat.view.menu.n_renamed {
    private static final java.lang.String STATE_ADAPTER = "android:menu:adapter";
    private static final java.lang.String STATE_HEADER = "android:menu:header";
    private static final java.lang.String STATE_HIERARCHY = "android:menu:list";
    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter adapter;
    private androidx.appcompat.view.menu.n_renamed.a_renamed callback;
    boolean hasCustomItemIconSize;
    android.widget.LinearLayout headerLayout;
    android.content.res.ColorStateList iconTintList;
    private int id_renamed;
    android.graphics.drawable.Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;
    android.view.LayoutInflater layoutInflater;
    androidx.appcompat.view.menu.h_renamed menu;
    private com.google.android.material.internal.NavigationMenuView menuView;
    int paddingSeparator;
    private int paddingTopDefault;
    int textAppearance;
    boolean textAppearanceSet;
    android.content.res.ColorStateList textColor;
    boolean isBehindStatusBar = true;
    private int overScrollMode = -1;
    final android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            boolean z_renamed = true;
            com.google.android.material.internal.NavigationMenuPresenter.this.setUpdateSuspended(true);
            androidx.appcompat.view.menu.j_renamed itemData = ((com.google.android.material.internal.NavigationMenuItemView) view).getItemData();
            boolean zPerformItemAction = com.google.android.material.internal.NavigationMenuPresenter.this.menu.performItemAction(itemData, com.google.android.material.internal.NavigationMenuPresenter.this, 0);
            if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
                com.google.android.material.internal.NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            } else {
                z_renamed = false;
            }
            com.google.android.material.internal.NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z_renamed) {
                com.google.android.material.internal.NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };

    private interface NavigationMenuItem {
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        this.layoutInflater = android.view.LayoutInflater.from(context);
        this.menu = hVar;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(com.google.android.material.R_renamed.dimen.design_navigation_separator_vertical_padding);
    }

    public androidx.appcompat.view.menu.o_renamed getMenuView(android.view.ViewGroup viewGroup) {
        if (this.menuView == null) {
            this.menuView = (com.google.android.material.internal.NavigationMenuView) this.layoutInflater.inflate(com.google.android.material.R_renamed.layout.design_navigation_menu, viewGroup, false);
            com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setAccessibilityDelegateCompat(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate(navigationMenuView));
            if (this.adapter == null) {
                this.adapter = new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter();
            }
            int i_renamed = this.overScrollMode;
            if (i_renamed != -1) {
                this.menuView.setOverScrollMode(i_renamed);
            }
            this.headerLayout = (android.widget.LinearLayout) this.layoutInflater.inflate(com.google.android.material.R_renamed.layout.design_navigation_item_header, (android.view.ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.callback = aVar;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.callback;
        if (aVar != null) {
            aVar.a_renamed(hVar, z_renamed);
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return this.id_renamed;
    }

    public void setId(int i_renamed) {
        this.id_renamed = i_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        if (this.menuView != null) {
            android.util.SparseArray<? extends android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(STATE_HIERARCHY, sparseArray);
        }
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            android.util.SparseArray<? extends android.os.Parcelable> sparseArray2 = new android.util.SparseArray<>();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof android.os.Bundle) {
            android.os.Bundle bundle = (android.os.Bundle) parcelable;
            android.util.SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_HIERARCHY);
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            android.os.Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            android.util.SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void setCheckedItem(androidx.appcompat.view.menu.j_renamed jVar) {
        this.adapter.setCheckedItem(jVar);
    }

    public androidx.appcompat.view.menu.j_renamed getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public android.view.View inflateHeaderView(int i_renamed) {
        android.view.View viewInflate = this.layoutInflater.inflate(i_renamed, (android.view.ViewGroup) this.headerLayout, false);
        addHeaderView(viewInflate);
        return viewInflate;
    }

    public void addHeaderView(android.view.View view) {
        this.headerLayout.addView(view);
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void removeHeaderView(android.view.View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public android.view.View getHeaderView(int i_renamed) {
        return this.headerLayout.getChildAt(i_renamed);
    }

    public android.content.res.ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public void setItemIconTintList(android.content.res.ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setItemTextAppearance(int i_renamed) {
        this.textAppearance = i_renamed;
        this.textAppearanceSet = true;
        updateMenuView(false);
    }

    public android.graphics.drawable.Drawable getItemBackground() {
        return this.itemBackground;
    }

    public void setItemBackground(android.graphics.drawable.Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public void setItemHorizontalPadding(int i_renamed) {
        this.itemHorizontalPadding = i_renamed;
        updateMenuView(false);
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public void setItemIconPadding(int i_renamed) {
        this.itemIconPadding = i_renamed;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i_renamed) {
        this.itemMaxLines = i_renamed;
        updateMenuView(false);
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    public void setItemIconSize(int i_renamed) {
        if (this.itemIconSize != i_renamed) {
            this.itemIconSize = i_renamed;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setUpdateSuspended(boolean z_renamed) {
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z_renamed);
        }
    }

    public void setBehindStatusBar(boolean z_renamed) {
        if (this.isBehindStatusBar != z_renamed) {
            this.isBehindStatusBar = z_renamed;
            updateTopPadding();
        }
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    private void updateTopPadding() {
        int i_renamed = (this.headerLayout.getChildCount() == 0 && this.isBehindStatusBar) ? this.paddingTopDefault : 0;
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i_renamed, 0, navigationMenuView.getPaddingBottom());
    }

    public void dispatchApplyWindowInsets(androidx.core.h_renamed.ad_renamed adVar) {
        int iB = adVar.b_renamed();
        if (this.paddingTopDefault != iB) {
            this.paddingTopDefault = iB;
            updateTopPadding();
        }
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, adVar.d_renamed());
        androidx.core.h_renamed.v_renamed.b_renamed(this.headerLayout, adVar);
    }

    public void setOverScrollMode(int i_renamed) {
        this.overScrollMode = i_renamed;
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i_renamed);
        }
    }

    private static abstract class ViewHolder extends androidx.recyclerview.widget.RecyclerView.w_renamed {
        public ViewHolder(android.view.View view) {
            super(view);
        }
    }

    private static class NormalViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public NormalViewHolder(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.view.View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(com.google.android.material.R_renamed.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class SubheaderViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public SubheaderViewHolder(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup) {
            super(layoutInflater.inflate(com.google.android.material.R_renamed.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static class SeparatorViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public SeparatorViewHolder(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup) {
            super(layoutInflater.inflate(com.google.android.material.R_renamed.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class HeaderViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public HeaderViewHolder(android.view.View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.google.android.material.internal.NavigationMenuPresenter.ViewHolder> {
        private static final java.lang.String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final java.lang.String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private androidx.appcompat.view.menu.j_renamed checkedItem;
        private final java.util.ArrayList<com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem> items = new java.util.ArrayList<>();
        private boolean updateSuspended;

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        NavigationMenuAdapter() {
            prepareMenuItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public int getItemViewType(int i_renamed) {
            com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i_renamed);
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) {
                return ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu() ? 1 : 0;
            }
            throw new java.lang.RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public com.google.android.material.internal.NavigationMenuPresenter.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
            if (i_renamed == 0) {
                return new com.google.android.material.internal.NavigationMenuPresenter.NormalViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.layoutInflater, viewGroup, com.google.android.material.internal.NavigationMenuPresenter.this.onClickListener);
            }
            if (i_renamed == 1) {
                return new com.google.android.material.internal.NavigationMenuPresenter.SubheaderViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i_renamed == 2) {
                return new com.google.android.material.internal.NavigationMenuPresenter.SeparatorViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i_renamed != 3) {
                return null;
            }
            return new com.google.android.material.internal.NavigationMenuPresenter.HeaderViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.headerLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public void onBindViewHolder(com.google.android.material.internal.NavigationMenuPresenter.ViewHolder viewHolder, int i_renamed) {
            int itemViewType = getItemViewType(i_renamed);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((android.widget.TextView) viewHolder.itemView).setText(((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i_renamed)).getMenuItem().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem navigationMenuSeparatorItem = (com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem) this.items.get(i_renamed);
                    viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.getPaddingTop(), 0, navigationMenuSeparatorItem.getPaddingBottom());
                    return;
                }
            }
            com.google.android.material.internal.NavigationMenuItemView navigationMenuItemView = (com.google.android.material.internal.NavigationMenuItemView) viewHolder.itemView;
            navigationMenuItemView.setIconTintList(com.google.android.material.internal.NavigationMenuPresenter.this.iconTintList);
            if (com.google.android.material.internal.NavigationMenuPresenter.this.textAppearanceSet) {
                navigationMenuItemView.setTextAppearance(com.google.android.material.internal.NavigationMenuPresenter.this.textAppearance);
            }
            if (com.google.android.material.internal.NavigationMenuPresenter.this.textColor != null) {
                navigationMenuItemView.setTextColor(com.google.android.material.internal.NavigationMenuPresenter.this.textColor);
            }
            androidx.core.h_renamed.v_renamed.a_renamed(navigationMenuItemView, com.google.android.material.internal.NavigationMenuPresenter.this.itemBackground != null ? com.google.android.material.internal.NavigationMenuPresenter.this.itemBackground.getConstantState().newDrawable() : null);
            com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = (com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i_renamed);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
            navigationMenuItemView.setHorizontalPadding(com.google.android.material.internal.NavigationMenuPresenter.this.itemHorizontalPadding);
            navigationMenuItemView.setIconPadding(com.google.android.material.internal.NavigationMenuPresenter.this.itemIconPadding);
            if (com.google.android.material.internal.NavigationMenuPresenter.this.hasCustomItemIconSize) {
                navigationMenuItemView.setIconSize(com.google.android.material.internal.NavigationMenuPresenter.this.itemIconSize);
            }
            navigationMenuItemView.setMaxLines(com.google.android.material.internal.NavigationMenuPresenter.this.itemMaxLines);
            navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public void onViewRecycled(com.google.android.material.internal.NavigationMenuPresenter.ViewHolder viewHolder) {
            if (viewHolder instanceof com.google.android.material.internal.NavigationMenuPresenter.NormalViewHolder) {
                ((com.google.android.material.internal.NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }

        private void prepareMenuItems() {
            if (this.updateSuspended) {
                return;
            }
            boolean z_renamed = true;
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuHeaderItem());
            int size = com.google.android.material.internal.NavigationMenuPresenter.this.menu.getVisibleItems().size();
            int i_renamed = -1;
            int i2 = 0;
            boolean z2 = false;
            int size2 = 0;
            while (i2 < size) {
                androidx.appcompat.view.menu.j_renamed jVar = com.google.android.material.internal.NavigationMenuPresenter.this.menu.getVisibleItems().get(i2);
                if (jVar.isChecked()) {
                    setCheckedItem(jVar);
                }
                if (jVar.isCheckable()) {
                    jVar.a_renamed(false);
                }
                if (jVar.hasSubMenu()) {
                    android.view.SubMenu subMenu = jVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem(com.google.android.material.internal.NavigationMenuPresenter.this.paddingSeparator, 0));
                        }
                        this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(jVar));
                        int size3 = this.items.size();
                        int size4 = subMenu.size();
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < size4) {
                            androidx.appcompat.view.menu.j_renamed jVar2 = (androidx.appcompat.view.menu.j_renamed) subMenu.getItem(i3);
                            if (jVar2.isVisible()) {
                                if (!z3 && jVar2.getIcon() != null) {
                                    z3 = z_renamed;
                                }
                                if (jVar2.isCheckable()) {
                                    jVar2.a_renamed(false);
                                }
                                if (jVar.isChecked()) {
                                    setCheckedItem(jVar);
                                }
                                this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(jVar2));
                            }
                            i3++;
                            z_renamed = true;
                        }
                        if (z3) {
                            appendTransparentIconIfMissing(size3, this.items.size());
                        }
                    }
                } else {
                    int groupId = jVar.getGroupId();
                    if (groupId != i_renamed) {
                        size2 = this.items.size();
                        boolean z4 = jVar.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem(com.google.android.material.internal.NavigationMenuPresenter.this.paddingSeparator, com.google.android.material.internal.NavigationMenuPresenter.this.paddingSeparator));
                        }
                        z2 = z4;
                    } else if (!z2 && jVar.getIcon() != null) {
                        appendTransparentIconIfMissing(size2, this.items.size());
                        z2 = true;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(jVar);
                    navigationMenuTextItem.needsEmptyIcon = z2;
                    this.items.add(navigationMenuTextItem);
                    i_renamed = groupId;
                }
                i2++;
                z_renamed = true;
            }
            this.updateSuspended = false;
        }

        private void appendTransparentIconIfMissing(int i_renamed, int i2) {
            while (i_renamed < i2) {
                ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i_renamed)).needsEmptyIcon = true;
                i_renamed++;
            }
        }

        public void setCheckedItem(androidx.appcompat.view.menu.j_renamed jVar) {
            if (this.checkedItem == jVar || !jVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.j_renamed jVar2 = this.checkedItem;
            if (jVar2 != null) {
                jVar2.setChecked(false);
            }
            this.checkedItem = jVar;
            jVar.setChecked(true);
        }

        public androidx.appcompat.view.menu.j_renamed getCheckedItem() {
            return this.checkedItem;
        }

        public android.os.Bundle createInstanceState() {
            android.os.Bundle bundle = new android.os.Bundle();
            androidx.appcompat.view.menu.j_renamed jVar = this.checkedItem;
            if (jVar != null) {
                bundle.putInt(STATE_CHECKED_ITEM, jVar.getItemId());
            }
            android.util.SparseArray<? extends android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
            int size = this.items.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i_renamed);
                if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) {
                    androidx.appcompat.view.menu.j_renamed menuItem = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    android.view.View actionView = menuItem != null ? menuItem.getActionView() : null;
                    if (actionView != null) {
                        com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray = new com.google.android.material.internal.ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
            return bundle;
        }

        public void restoreInstanceState(android.os.Bundle bundle) {
            androidx.appcompat.view.menu.j_renamed menuItem;
            android.view.View actionView;
            com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.j_renamed menuItem2;
            int i_renamed = bundle.getInt(STATE_CHECKED_ITEM, 0);
            if (i_renamed != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i2);
                    if ((navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) && (menuItem2 = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i_renamed) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i2++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            android.util.SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem2 = this.items.get(i3);
                    if ((navigationMenuItem2 instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) && (menuItem = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) != null && (actionView = menuItem.getActionView()) != null && (parcelableSparseArray = (com.google.android.material.internal.ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setUpdateSuspended(boolean z_renamed) {
            this.updateSuspended = z_renamed;
        }

        int getRowCount() {
            int i_renamed = com.google.android.material.internal.NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getItemCount(); i2++) {
                if (com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getItemViewType(i2) == 0) {
                    i_renamed++;
                }
            }
            return i_renamed;
        }
    }

    private static class NavigationMenuTextItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
        private final androidx.appcompat.view.menu.j_renamed menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(androidx.appcompat.view.menu.j_renamed jVar) {
            this.menuItem = jVar;
        }

        public androidx.appcompat.view.menu.j_renamed getMenuItem() {
            return this.menuItem;
        }
    }

    private static class NavigationMenuSeparatorItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i_renamed, int i2) {
            this.paddingTop = i_renamed;
            this.paddingBottom = i2;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }
    }

    private static class NavigationMenuHeaderItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends androidx.recyclerview.widget.p_renamed {
        NavigationMenuViewAccessibilityDelegate(androidx.recyclerview.widget.RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.p_renamed, androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getRowCount(), 0, false));
        }
    }
}
