package com.google.android.material.navigation;

/* loaded from: classes.dex */
public class NavigationView extends com.google.android.material.internal.ScrimInsetsFrameLayout {
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final com.google.android.material.internal.NavigationMenu menu;
    private android.view.MenuInflater menuInflater;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final com.google.android.material.internal.NavigationMenuPresenter presenter;
    private final int[] tmpLocation;
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_NavigationView;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(android.view.MenuItem menuItem);
    }

    public NavigationView(android.content.Context context) {
        this(context, null);
    }

    public NavigationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.navigationViewStyle);
    }

    public NavigationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.ColorStateList colorStateListCreateDefaultColorStateList;
        boolean z_renamed;
        int iG;
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.presenter = new com.google.android.material.internal.NavigationMenuPresenter();
        this.tmpLocation = new int[2];
        android.content.Context context2 = getContext();
        this.menu = new com.google.android.material.internal.NavigationMenu(context2);
        androidx.appcompat.widget.ar_renamed arVarObtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.NavigationView, i_renamed, DEF_STYLE_RES, new int[0]);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_android_background)) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof android.graphics.drawable.ColorDrawable)) {
            android.graphics.drawable.Drawable background = getBackground();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            if (background instanceof android.graphics.drawable.ColorDrawable) {
                materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(((android.graphics.drawable.ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            androidx.core.h_renamed.v_renamed.a_renamed(this, materialShapeDrawable);
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_elevation)) {
            setElevation(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_android_maxWidth, 0);
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemIconTint)) {
            colorStateListCreateDefaultColorStateList = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListCreateDefaultColorStateList = createDefaultColorStateList(android.R_renamed.attr.textColorSecondary);
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemTextAppearance)) {
            iG = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemTextAppearance, 0);
            z_renamed = true;
        } else {
            z_renamed = false;
            iG = 0;
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemIconSize)) {
            setItemIconSize(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemIconSize, 0));
        }
        android.content.res.ColorStateList colorStateListE = arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemTextColor) ? arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemTextColor) : null;
        if (!z_renamed && colorStateListE == null) {
            colorStateListE = createDefaultColorStateList(android.R_renamed.attr.textColorPrimary);
        }
        android.graphics.drawable.Drawable drawableA = arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemBackground);
        if (drawableA == null && hasShapeAppearance(arVarObtainTintedStyledAttributes)) {
            drawableA = createDefaultItemBackground(arVarObtainTintedStyledAttributes);
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemHorizontalPadding)) {
            this.presenter.setItemHorizontalPadding(arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int iE = arVarObtainTintedStyledAttributes.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(arVarObtainTintedStyledAttributes.a_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemMaxLines, 1));
        this.menu.setCallback(new androidx.appcompat.view.menu.h_renamed.a_renamed() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
            public void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar) {
            }

            @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
            public boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
                return com.google.android.material.navigation.NavigationView.this.listener != null && com.google.android.material.navigation.NavigationView.this.listener.onNavigationItemSelected(menuItem);
            }
        });
        this.presenter.setId(1);
        this.presenter.initForMenu(context2, this.menu);
        this.presenter.setItemIconTintList(colorStateListCreateDefaultColorStateList);
        this.presenter.setOverScrollMode(getOverScrollMode());
        if (z_renamed) {
            this.presenter.setItemTextAppearance(iG);
        }
        this.presenter.setItemTextColor(colorStateListE);
        this.presenter.setItemBackground(drawableA);
        this.presenter.setItemIconPadding(iE);
        this.menu.addMenuPresenter(this.presenter);
        addView((android.view.View) this.presenter.getMenuView(this));
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_menu)) {
            inflateMenu(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_menu, 0));
        }
        if (arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_headerLayout)) {
            inflateHeaderView(arVarObtainTintedStyledAttributes.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_headerLayout, 0));
        }
        arVarObtainTintedStyledAttributes.b_renamed();
        setupInsetScrimsListener();
    }

    @Override // android.view.View
    public void setOverScrollMode(int i_renamed) {
        super.setOverScrollMode(i_renamed);
        com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i_renamed);
        }
    }

    private boolean hasShapeAppearance(androidx.appcompat.widget.ar_renamed arVar) {
        return arVar.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeAppearance) || arVar.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f_renamed);
        }
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f_renamed);
    }

    private final android.graphics.drawable.Drawable createDefaultItemBackground(androidx.appcompat.widget.ar_renamed arVar) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(com.google.android.material.shape.ShapeAppearanceModel.builder(getContext(), arVar.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeAppearance, 0), arVar.g_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(com.google.android.material.resources.MaterialResources.getColorStateList(getContext(), arVar, com.google.android.material.R_renamed.styleable.NavigationView_itemShapeFillColor));
        return new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) materialShapeDrawable, arVar.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeInsetStart, 0), arVar.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeInsetTop, 0), arVar.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeInsetEnd, 0), arVar.e_renamed(com.google.android.material.R_renamed.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.navigation.NavigationView.SavedState savedState = new com.google.android.material.navigation.NavigationView.SavedState(super.onSaveInstanceState());
        savedState.menuState = new android.os.Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.navigation.NavigationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.navigation.NavigationView.SavedState savedState = (com.google.android.material.navigation.NavigationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public void setNavigationItemSelectedListener(com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        if (mode == Integer.MIN_VALUE) {
            i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(android.view.View.MeasureSpec.getSize(i_renamed), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i_renamed, i2);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void onInsetsChanged(androidx.core.h_renamed.ad_renamed adVar) {
        this.presenter.dispatchApplyWindowInsets(adVar);
    }

    public void inflateMenu(int i_renamed) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i_renamed, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public android.view.Menu getMenu() {
        return this.menu;
    }

    public android.view.View inflateHeaderView(int i_renamed) {
        return this.presenter.inflateHeaderView(i_renamed);
    }

    public void addHeaderView(android.view.View view) {
        this.presenter.addHeaderView(view);
    }

    public void removeHeaderView(android.view.View view) {
        this.presenter.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public android.view.View getHeaderView(int i_renamed) {
        return this.presenter.getHeaderView(i_renamed);
    }

    public android.content.res.ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(android.content.res.ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public android.graphics.drawable.Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(int i_renamed) {
        setItemBackground(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public void setItemBackground(android.graphics.drawable.Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(int i_renamed) {
        this.presenter.setItemHorizontalPadding(i_renamed);
    }

    public void setItemHorizontalPaddingResource(int i_renamed) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i_renamed));
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(int i_renamed) {
        this.presenter.setItemIconPadding(i_renamed);
    }

    public void setItemIconPaddingResource(int i_renamed) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i_renamed));
    }

    public void setCheckedItem(int i_renamed) {
        android.view.MenuItem menuItemFindItem = this.menu.findItem(i_renamed);
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((androidx.appcompat.view.menu.j_renamed) menuItemFindItem);
        }
    }

    public void setCheckedItem(android.view.MenuItem menuItem) {
        android.view.MenuItem menuItemFindItem = this.menu.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((androidx.appcompat.view.menu.j_renamed) menuItemFindItem);
            return;
        }
        throw new java.lang.IllegalArgumentException("Called setCheckedItem(MenuItem) with an_renamed item that is_renamed not in_renamed the current menu.");
    }

    public android.view.MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(int i_renamed) {
        this.presenter.setItemTextAppearance(i_renamed);
    }

    public void setItemIconSize(int i_renamed) {
        this.presenter.setItemIconSize(i_renamed);
    }

    public void setItemMaxLines(int i_renamed) {
        this.presenter.setItemMaxLines(i_renamed);
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    private android.view.MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new androidx.appcompat.view.g_renamed(getContext());
        }
        return this.menuInflater;
    }

    private android.content.res.ColorStateList createDefaultColorStateList(int i_renamed) throws android.content.res.Resources.NotFoundException {
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

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (android.os.Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.google.android.material.navigation.NavigationView navigationView = com.google.android.material.navigation.NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z_renamed = com.google.android.material.navigation.NavigationView.this.tmpLocation[1] == 0;
                com.google.android.material.navigation.NavigationView.this.presenter.setBehindStatusBar(z_renamed);
                com.google.android.material.navigation.NavigationView.this.setDrawTopInsetForeground(z_renamed);
                android.content.Context context = com.google.android.material.navigation.NavigationView.this.getContext();
                if (!(context instanceof android.app.Activity) || android.os.Build.VERSION.SDK_INT < 21) {
                    return;
                }
                android.app.Activity activity = (android.app.Activity) context;
                com.google.android.material.navigation.NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(android.R_renamed.id_renamed.content).getHeight() == com.google.android.material.navigation.NavigationView.this.getHeight()) && (android.graphics.Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.navigation.NavigationView.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.navigation.NavigationView.SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.navigation.NavigationView.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.navigation.NavigationView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.navigation.NavigationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.navigation.NavigationView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.navigation.NavigationView.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.navigation.NavigationView.SavedState[i_renamed];
            }
        };
        public android.os.Bundle menuState;

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeBundle(this.menuState);
        }
    }
}
