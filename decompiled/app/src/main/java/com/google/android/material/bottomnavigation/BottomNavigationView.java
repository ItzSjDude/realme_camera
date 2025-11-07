package com.google.android.material.bottomnavigation;

/* loaded from: classes.dex */
public class BottomNavigationView extends android.widget.FrameLayout {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_BottomNavigationView;
    private static final int MENU_PRESENTER_ID = 1;
    private android.content.res.ColorStateList itemRippleColor;
    private final androidx.appcompat.view.menu.h_renamed menu;
    private android.view.MenuInflater menuInflater;
    final com.google.android.material.bottomnavigation.BottomNavigationMenuView menuView;
    private final com.google.android.material.bottomnavigation.BottomNavigationPresenter presenter;
    private com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener reselectedListener;
    private com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener selectedListener;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(android.view.MenuItem menuItem);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(android.view.MenuItem menuItem);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.presenter = new com.google.android.material.bottomnavigation.BottomNavigationPresenter();
        android.content.Context context2 = getContext();
        this.menu = new com.google.android.material.bottomnavigation.BottomNavigationMenu(context2);
        this.menuView = new com.google.android.material.bottomnavigation.BottomNavigationMenuView(context2);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.menuView.setLayoutParams(layoutParams);
        this.presenter.setBottomNavigationMenuView(this.menuView);
        this.presenter.setId(1);
        this.menuView.setPresenter(this.presenter);
        this.menu.addMenuPresenter(this.presenter);
        this.presenter.initForMenu(getContext(), this.menu);
        androidx.appcompat.widget.ar_renamed arVarObtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.BottomNavigationView, i_renamed, com.google.android.material.R_renamed.style.Widget_Design_BottomNavigationView, com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceInactive, com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemIconTint)) {
            this.menuView.setIconTintList(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemIconTint));
        } else {
            com.google.android.material.bottomnavigation.BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.createDefaultColorStateList(android.R_renamed.attr.textColorSecondary));
        }
        setItemIconSize(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_icon_size)));
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof android.graphics.drawable.ColorDrawable)) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, createMaterialShapeDrawableBackground(context2));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_elevation)) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_elevation, 0));
        }
        androidx.core.graphics.drawable.a_renamed.a_renamed(getBackground().mutate(), com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(arVarObtainTintedStyledAttributes.c_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int iG = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_itemBackground, 0);
        if (iG != 0) {
            this.menuView.setItemBackgroundRes(iG);
        } else {
            setItemRippleColor(com.google.android.material.resources.MaterialResources.getColorStateList(context2, arVarObtainTintedStyledAttributes, com.google.android.material.R_renamed.styleable.BottomNavigationView_itemRippleColor));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_menu)) {
            inflateMenu(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.BottomNavigationView_menu, 0));
        }
        arVarObtainTintedStyledAttributes.b_renamed();
        addView(this.menuView, layoutParams);
        if (android.os.Build.VERSION.SDK_INT < 21) {
            addCompatibilityTopDivider(context2);
        }
        this.menu.setCallback(new androidx.appcompat.view.menu.h_renamed.a_renamed() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.1
            @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
            public void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar) {
            }

            @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
            public boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
                if (com.google.android.material.bottomnavigation.BottomNavigationView.this.reselectedListener == null || menuItem.getItemId() != com.google.android.material.bottomnavigation.BottomNavigationView.this.getSelectedItemId()) {
                    return (com.google.android.material.bottomnavigation.BottomNavigationView.this.selectedListener == null || com.google.android.material.bottomnavigation.BottomNavigationView.this.selectedListener.onNavigationItemSelected(menuItem)) ? false : true;
                }
                com.google.android.material.bottomnavigation.BottomNavigationView.this.reselectedListener.onNavigationItemReselected(menuItem);
                return true;
            }
        });
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(this, new com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public androidx.core.h_renamed.ad_renamed onApplyWindowInsets(android.view.View view, androidx.core.h_renamed.ad_renamed adVar, com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
                relativePadding.bottom += adVar.d_renamed();
                relativePadding.applyToView(view);
                return adVar;
            }
        });
    }

    private com.google.android.material.shape.MaterialShapeDrawable createMaterialShapeDrawableBackground(android.content.Context context) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.ColorDrawable) {
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(((android.graphics.drawable.ColorDrawable) background).getColor()));
        }
        materialShapeDrawable.initializeElevationOverlay(context);
        return materialShapeDrawable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f_renamed);
    }

    public void setOnNavigationItemSelectedListener(com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.selectedListener = onNavigationItemSelectedListener;
    }

    public void setOnNavigationItemReselectedListener(com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        this.reselectedListener = onNavigationItemReselectedListener;
    }

    public android.view.Menu getMenu() {
        return this.menu;
    }

    public void inflateMenu(int i_renamed) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i_renamed, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public android.content.res.ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public void setItemIconTintList(android.content.res.ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i_renamed) {
        this.menuView.setItemIconSize(i_renamed);
    }

    public void setItemIconSizeRes(int i_renamed) {
        setItemIconSize(getResources().getDimensionPixelSize(i_renamed));
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    @java.lang.Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i_renamed) {
        this.menuView.setItemBackgroundRes(i_renamed);
        this.itemRippleColor = null;
    }

    public android.graphics.drawable.Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public void setItemBackground(android.graphics.drawable.Drawable drawable) {
        this.menuView.setItemBackground(drawable);
        this.itemRippleColor = null;
    }

    public android.content.res.ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public void setItemRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.itemRippleColor == colorStateList) {
            if (colorStateList != null || this.menuView.getItemBackground() == null) {
                return;
            }
            this.menuView.setItemBackground(null);
            return;
        }
        this.itemRippleColor = colorStateList;
        if (colorStateList == null) {
            this.menuView.setItemBackground(null);
            return;
        }
        android.content.res.ColorStateList colorStateListConvertToRippleDrawableColor = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(colorStateList);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.menuView.setItemBackground(new android.graphics.drawable.RippleDrawable(colorStateListConvertToRippleDrawableColor, null, null));
            return;
        }
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(gradientDrawable);
        androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, colorStateListConvertToRippleDrawableColor);
        this.menuView.setItemBackground(drawableG);
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void setSelectedItemId(int i_renamed) {
        android.view.MenuItem menuItemFindItem = this.menu.findItem(i_renamed);
        if (menuItemFindItem == null || this.menu.performItemAction(menuItemFindItem, this.presenter, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setLabelVisibilityMode(int i_renamed) {
        if (this.menuView.getLabelVisibilityMode() != i_renamed) {
            this.menuView.setLabelVisibilityMode(i_renamed);
            this.presenter.updateMenuView(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i_renamed) {
        this.menuView.setItemTextAppearanceInactive(i_renamed);
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i_renamed) {
        this.menuView.setItemTextAppearanceActive(i_renamed);
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z_renamed) {
        if (this.menuView.isItemHorizontalTranslationEnabled() != z_renamed) {
            this.menuView.setItemHorizontalTranslationEnabled(z_renamed);
            this.presenter.updateMenuView(false);
        }
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    public com.google.android.material.badge.BadgeDrawable getBadge(int i_renamed) {
        return this.menuView.getBadge(i_renamed);
    }

    public com.google.android.material.badge.BadgeDrawable getOrCreateBadge(int i_renamed) {
        return this.menuView.getOrCreateBadge(i_renamed);
    }

    public void removeBadge(int i_renamed) {
        this.menuView.removeBadge(i_renamed);
    }

    private void addCompatibilityTopDivider(android.content.Context context) {
        android.view.View view = new android.view.View(context);
        view.setBackgroundColor(androidx.core.a_renamed.a_renamed.c_renamed(context, com.google.android.material.R_renamed.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private android.view.MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new androidx.appcompat.view.g_renamed(getContext());
        }
        return this.menuInflater;
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.bottomnavigation.BottomNavigationView.SavedState savedState = new com.google.android.material.bottomnavigation.BottomNavigationView.SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new android.os.Bundle();
        this.menu.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.bottomnavigation.BottomNavigationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.bottomnavigation.BottomNavigationView.SavedState savedState = (com.google.android.material.bottomnavigation.BottomNavigationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomnavigation.BottomNavigationView.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.bottomnavigation.BottomNavigationView.SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.bottomnavigation.BottomNavigationView.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.bottomnavigation.BottomNavigationView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomnavigation.BottomNavigationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.bottomnavigation.BottomNavigationView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomnavigation.BottomNavigationView.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.bottomnavigation.BottomNavigationView.SavedState[i_renamed];
            }
        };
        android.os.Bundle menuPresenterState;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }
    }
}
