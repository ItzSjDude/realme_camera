package com.google.android.material.bottomnavigation;

/* loaded from: classes.dex */
public class BottomNavigationMenuView extends android.view.ViewGroup implements androidx.appcompat.view.menu.o_renamed {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> badgeDrawables;
    private com.google.android.material.bottomnavigation.BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private android.graphics.drawable.Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int itemIconSize;
    private android.content.res.ColorStateList itemIconTint;
    private final androidx.core.g_renamed.e_renamed.a_renamed<com.google.android.material.bottomnavigation.BottomNavigationItemView> itemPool;
    private int itemTextAppearanceActive;
    private int itemTextAppearanceInactive;
    private final android.content.res.ColorStateList itemTextColorDefault;
    private android.content.res.ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private androidx.appcompat.view.menu.h_renamed menu;
    private final android.view.View.OnClickListener onClickListener;
    private com.google.android.material.bottomnavigation.BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final androidx.transition.q_renamed set;
    private int[] tempChildWidths;

    private boolean isShifting(int i_renamed, int i2) {
        if (i_renamed == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i_renamed == 0) {
            return true;
        }
        return false;
    }

    private boolean isValidId(int i_renamed) {
        return i_renamed != -1;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public BottomNavigationMenuView(android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemPool = new androidx.core.g_renamed.e_renamed.c_renamed(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new android.util.SparseArray<>(5);
        android.content.res.Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(android.R_renamed.attr.textColorSecondary);
        this.set = new androidx.transition.b_renamed();
        this.set.a_renamed(0);
        this.set.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        this.set.setInterpolator(new androidx.d_renamed.a_renamed.a_renamed.b_renamed());
        this.set.a_renamed(new com.google.android.material.internal.TextScale());
        this.onClickListener = new android.view.View.OnClickListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                androidx.appcompat.view.menu.j_renamed itemData = ((com.google.android.material.bottomnavigation.BottomNavigationItemView) view).getItemData();
                if (com.google.android.material.bottomnavigation.BottomNavigationMenuView.this.menu.performItemAction(itemData, com.google.android.material.bottomnavigation.BottomNavigationMenuView.this.presenter, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.tempChildWidths = new int[5];
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
    }

    @Override // androidx.appcompat.view.menu.o_renamed
    public void initialize(androidx.appcompat.view.menu.h_renamed hVar) {
        this.menu = hVar;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int size2 = this.menu.getVisibleItems().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (isShifting(this.labelVisibilityMode, size2) && this.itemHorizontalTranslationEnabled) {
            android.view.View childAt = getChildAt(this.selectedItemPosition);
            int iMax = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = java.lang.Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i3 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = java.lang.Math.min(size - (this.inactiveItemMinWidth * i3), java.lang.Math.min(iMax, this.activeItemMaxWidth));
            int i4 = size - iMin;
            int iMin2 = java.lang.Math.min(i4 / (i3 == 0 ? 1 : i3), this.inactiveItemMaxWidth);
            int i5 = i4 - (i3 * iMin2);
            int i6 = 0;
            while (i6 < childCount) {
                if (getChildAt(i6).getVisibility() != 8) {
                    this.tempChildWidths[i6] = i6 == this.selectedItemPosition ? iMin : iMin2;
                    if (i5 > 0) {
                        int[] iArr = this.tempChildWidths;
                        iArr[i6] = iArr[i6] + 1;
                        i5--;
                    }
                } else {
                    this.tempChildWidths[i6] = 0;
                }
                i6++;
            }
        } else {
            int iMin3 = java.lang.Math.min(size / (size2 == 0 ? 1 : size2), this.activeItemMaxWidth);
            int i7 = size - (size2 * iMin3);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr2 = this.tempChildWidths;
                    iArr2[i8] = iMin3;
                    if (i7 > 0) {
                        iArr2[i8] = iArr2[i8] + 1;
                        i7--;
                    }
                } else {
                    this.tempChildWidths[i8] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            android.view.View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i9], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(android.view.View.resolveSizeAndState(measuredWidth, android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), android.view.View.resolveSizeAndState(this.itemHeight, iMakeMeasureSpec, 0));
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
                if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo).a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(1, this.menu.getVisibleItems().size(), false, 1));
    }

    public void setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public android.content.res.ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public void setItemIconSize(int i_renamed) {
        this.itemIconSize = i_renamed;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i_renamed);
            }
        }
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public void setItemTextAppearanceInactive(int i_renamed) {
        this.itemTextAppearanceInactive = i_renamed;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i_renamed);
                android.content.res.ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public void setItemTextAppearanceActive(int i_renamed) {
        this.itemTextAppearanceActive = i_renamed;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i_renamed);
                android.content.res.ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public void setItemBackgroundRes(int i_renamed) {
        this.itemBackgroundRes = i_renamed;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i_renamed);
            }
        }
    }

    @java.lang.Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public void setItemBackground(android.graphics.drawable.Drawable drawable) {
        this.itemBackground = drawable;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public android.graphics.drawable.Drawable getItemBackground() {
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null && bottomNavigationItemViewArr.length > 0) {
            return bottomNavigationItemViewArr[0].getBackground();
        }
        return this.itemBackground;
    }

    public void setLabelVisibilityMode(int i_renamed) {
        this.labelVisibilityMode = i_renamed;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public void setItemHorizontalTranslationEnabled(boolean z_renamed) {
        this.itemHorizontalTranslationEnabled = z_renamed;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public android.content.res.ColorStateList createDefaultColorStateList(int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!getContext().getTheme().resolveAttribute(i_renamed, typedValue, true)) {
            return null;
        }
        android.content.res.ColorStateList colorStateListA = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        return new android.content.res.ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    public void setPresenter(com.google.android.material.bottomnavigation.BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    public void buildMenuView() {
        removeAllViews();
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.itemPool.a_renamed(bottomNavigationItemView);
                    bottomNavigationItemView.removeBadge();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new com.google.android.material.bottomnavigation.BottomNavigationItemView[this.menu.size()];
        boolean zIsShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i_renamed = 0; i_renamed < this.menu.size(); i_renamed++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i_renamed).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            com.google.android.material.bottomnavigation.BottomNavigationItemView newItem = getNewItem();
            this.buttons[i_renamed] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextColor(this.itemTextColorFromUser);
            android.graphics.drawable.Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setShifting(zIsShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            newItem.initialize((androidx.appcompat.view.menu.j_renamed) this.menu.getItem(i_renamed), 0);
            newItem.setItemPosition(i_renamed);
            newItem.setOnClickListener(this.onClickListener);
            if (this.selectedItemId != 0 && this.menu.getItem(i_renamed).getItemId() == this.selectedItemId) {
                this.selectedItemPosition = i_renamed;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        this.selectedItemPosition = java.lang.Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.menu.getItem(this.selectedItemPosition).setChecked(true);
    }

    public void updateMenuView() {
        androidx.appcompat.view.menu.h_renamed hVar = this.menu;
        if (hVar == null || this.buttons == null) {
            return;
        }
        int size = hVar.size();
        if (size != this.buttons.length) {
            buildMenuView();
            return;
        }
        int i_renamed = this.selectedItemId;
        for (int i2 = 0; i2 < size; i2++) {
            android.view.MenuItem item = this.menu.getItem(i2);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i2;
            }
        }
        if (i_renamed != this.selectedItemId) {
            androidx.transition.o_renamed.a_renamed(this, this.set);
        }
        boolean zIsShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i3].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i3].setShifting(zIsShifting);
            this.buttons[i3].initialize((androidx.appcompat.view.menu.j_renamed) this.menu.getItem(i3), 0);
            this.presenter.setUpdateSuspended(false);
        }
    }

    private com.google.android.material.bottomnavigation.BottomNavigationItemView getNewItem() {
        com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemViewA = this.itemPool.a_renamed();
        return bottomNavigationItemViewA == null ? new com.google.android.material.bottomnavigation.BottomNavigationItemView(getContext()) : bottomNavigationItemViewA;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    void tryRestoreSelectedItemId(int i_renamed) {
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            android.view.MenuItem item = this.menu.getItem(i2);
            if (i_renamed == item.getItemId()) {
                this.selectedItemId = i_renamed;
                this.selectedItemPosition = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    void setBadgeDrawables(android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> sparseArray) {
        this.badgeDrawables = sparseArray;
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    com.google.android.material.badge.BadgeDrawable getBadge(int i_renamed) {
        return this.badgeDrawables.get(i_renamed);
    }

    com.google.android.material.badge.BadgeDrawable getOrCreateBadge(int i_renamed) {
        validateMenuItemId(i_renamed);
        com.google.android.material.badge.BadgeDrawable badgeDrawableCreate = this.badgeDrawables.get(i_renamed);
        if (badgeDrawableCreate == null) {
            badgeDrawableCreate = com.google.android.material.badge.BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i_renamed, badgeDrawableCreate);
        }
        com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemViewFindItemView = findItemView(i_renamed);
        if (bottomNavigationItemViewFindItemView != null) {
            bottomNavigationItemViewFindItemView.setBadge(badgeDrawableCreate);
        }
        return badgeDrawableCreate;
    }

    void removeBadge(int i_renamed) {
        validateMenuItemId(i_renamed);
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawables.get(i_renamed);
        com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemViewFindItemView = findItemView(i_renamed);
        if (bottomNavigationItemViewFindItemView != null) {
            bottomNavigationItemViewFindItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i_renamed);
        }
    }

    private void setBadgeIfNeeded(com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView) {
        com.google.android.material.badge.BadgeDrawable badgeDrawable;
        int id_renamed = bottomNavigationItemView.getId();
        if (isValidId(id_renamed) && (badgeDrawable = this.badgeDrawables.get(id_renamed)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    private void removeUnusedBadges() {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int i_renamed = 0; i_renamed < this.menu.size(); i_renamed++) {
            hashSet.add(java.lang.Integer.valueOf(this.menu.getItem(i_renamed).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int iKeyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(java.lang.Integer.valueOf(iKeyAt))) {
                this.badgeDrawables.delete(iKeyAt);
            }
        }
    }

    com.google.android.material.bottomnavigation.BottomNavigationItemView findItemView(int i_renamed) {
        validateMenuItemId(i_renamed);
        com.google.android.material.bottomnavigation.BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr == null) {
            return null;
        }
        for (com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
            if (bottomNavigationItemView.getId() == i_renamed) {
                return bottomNavigationItemView;
            }
        }
        return null;
    }

    private void validateMenuItemId(int i_renamed) {
        if (isValidId(i_renamed)) {
            return;
        }
        throw new java.lang.IllegalArgumentException(i_renamed + " is_renamed not a_renamed valid view id_renamed");
    }
}
