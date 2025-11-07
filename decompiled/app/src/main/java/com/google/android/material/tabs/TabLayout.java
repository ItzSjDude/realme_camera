package com.google.android.material.tabs;

@androidx.viewpager.widget.ViewPager.a_renamed
/* loaded from: classes.dex */
public class TabLayout extends android.widget.HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final java.lang.String LOG_TAG = "TabLayout";
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private com.google.android.material.tabs.TabLayout.AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener pageChangeListener;
    private androidx.viewpager.widget.a_renamed pagerAdapter;
    private android.database.DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private android.animation.ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener selectedListener;
    private final java.util.ArrayList<com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener> selectedListeners;
    private com.google.android.material.tabs.TabLayout.Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    final com.google.android.material.tabs.TabLayout.SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    android.content.res.ColorStateList tabIconTint;
    android.graphics.PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    android.content.res.ColorStateList tabRippleColorStateList;
    android.graphics.drawable.Drawable tabSelectedIndicator;
    int tabTextAppearance;
    android.content.res.ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final android.graphics.RectF tabViewContentBounds;
    private final androidx.core.g_renamed.e_renamed.a_renamed<com.google.android.material.tabs.TabLayout.TabView> tabViewPool;
    private final java.util.ArrayList<com.google.android.material.tabs.TabLayout.Tab> tabs;
    boolean unboundedRipple;
    androidx.viewpager.widget.ViewPager viewPager;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_Design_TabLayout;
    private static final androidx.core.g_renamed.e_renamed.a_renamed<com.google.android.material.tabs.TabLayout.Tab> tabPool = new androidx.core.g_renamed.e_renamed.c_renamed(16);

    @java.lang.Deprecated
    public interface BaseOnTabSelectedListener<T_renamed extends com.google.android.material.tabs.TabLayout.Tab> {
        void onTabReselected(T_renamed t_renamed);

        void onTabSelected(T_renamed t_renamed);

        void onTabUnselected(T_renamed t_renamed);
    }

    public @interface LabelVisibility {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener<com.google.android.material.tabs.TabLayout.Tab> {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public TabLayout(android.content.Context context) {
        this(context, null);
    }

    public TabLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.tabStyle);
    }

    public TabLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.tabs = new java.util.ArrayList<>();
        this.tabViewContentBounds = new android.graphics.RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new java.util.ArrayList<>();
        this.tabViewPool = new androidx.core.g_renamed.e_renamed.b_renamed(12);
        android.content.Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        this.slidingTabIndicator = new com.google.android.material.tabs.TabLayout.SlidingTabIndicator(context2);
        super.addView(this.slidingTabIndicator, 0, new android.widget.FrameLayout.LayoutParams(-2, -1));
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.TabLayout, i_renamed, DEF_STYLE_RES, com.google.android.material.R_renamed.styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof android.graphics.drawable.ColorDrawable) {
            android.graphics.drawable.ColorDrawable colorDrawable = (android.graphics.drawable.ColorDrawable) getBackground();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(androidx.core.h_renamed.v_renamed.o_renamed(this));
            androidx.core.h_renamed.v_renamed.a_renamed(this, materialShapeDrawable);
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabIndicatorHeight, -1));
        this.slidingTabIndicator.setSelectedIndicatorColor(typedArrayObtainStyledAttributes.getColor(com.google.android.material.R_renamed.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.resources.MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
        this.tabPaddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        this.tabTextAppearance = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.TabLayout_tabTextAppearance, com.google.android.material.R_renamed.style.TextAppearance_Design_Tab);
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(this.tabTextAppearance, androidx.appcompat.R_renamed.styleable.TextAppearance);
        try {
            this.tabTextSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(androidx.appcompat.R_renamed.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes2, androidx.appcompat.R_renamed.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes2.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.TabLayout_tabTextColor)) {
                this.tabTextColors = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(com.google.android.material.R_renamed.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.TabLayout_tabContentStart, 0);
            this.mode = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TabLayout_tabMode, 1);
            this.tabGravity = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayObtainStyledAttributes.recycle();
            android.content.res.Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (java.lang.Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i_renamed) {
        this.slidingTabIndicator.setSelectedIndicatorColor(i_renamed);
    }

    @java.lang.Deprecated
    public void setSelectedTabIndicatorHeight(int i_renamed) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(i_renamed);
    }

    public void setScrollPosition(int i_renamed, float f_renamed, boolean z_renamed) {
        setScrollPosition(i_renamed, f_renamed, z_renamed, true);
    }

    public void setScrollPosition(int i_renamed, float f_renamed, boolean z_renamed, boolean z2) {
        int iRound = java.lang.Math.round(i_renamed + f_renamed);
        if (iRound < 0 || iRound >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i_renamed, f_renamed);
        }
        android.animation.ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i_renamed, f_renamed), 0);
        if (z_renamed) {
            setSelectedTabView(iRound);
        }
    }

    public void addTab(com.google.android.material.tabs.TabLayout.Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addTab(com.google.android.material.tabs.TabLayout.Tab tab, int i_renamed) {
        addTab(tab, i_renamed, this.tabs.isEmpty());
    }

    public void addTab(com.google.android.material.tabs.TabLayout.Tab tab, boolean z_renamed) {
        addTab(tab, this.tabs.size(), z_renamed);
    }

    public void addTab(com.google.android.material.tabs.TabLayout.Tab tab, int i_renamed, boolean z_renamed) {
        if (tab.parent != this) {
            throw new java.lang.IllegalArgumentException("Tab belongs to a_renamed different TabLayout.");
        }
        configureTab(tab, i_renamed);
        addTabView(tab);
        if (z_renamed) {
            tab.select();
        }
    }

    private void addTabFromItemView(com.google.android.material.tabs.TabItem tabItem) {
        com.google.android.material.tabs.TabLayout.Tab tabNewTab = newTab();
        if (tabItem.text != null) {
            tabNewTab.setText(tabItem.text);
        }
        if (tabItem.icon != null) {
            tabNewTab.setIcon(tabItem.icon);
        }
        if (tabItem.customLayout != 0) {
            tabNewTab.setCustomView(tabItem.customLayout);
        }
        if (!android.text.TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabNewTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(tabNewTab);
    }

    @java.lang.Deprecated
    public void setOnTabSelectedListener(com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    @java.lang.Deprecated
    public void setOnTabSelectedListener(com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void addOnTabSelectedListener(com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    @java.lang.Deprecated
    public void addOnTabSelectedListener(com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.selectedListeners.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void removeOnTabSelectedListener(com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    @java.lang.Deprecated
    public void removeOnTabSelectedListener(com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public com.google.android.material.tabs.TabLayout.Tab newTab() {
        com.google.android.material.tabs.TabLayout.Tab tabCreateTabFromPool = createTabFromPool();
        tabCreateTabFromPool.parent = this;
        tabCreateTabFromPool.view = createTabView(tabCreateTabFromPool);
        return tabCreateTabFromPool;
    }

    protected com.google.android.material.tabs.TabLayout.Tab createTabFromPool() {
        com.google.android.material.tabs.TabLayout.Tab tabA = tabPool.a_renamed();
        return tabA == null ? new com.google.android.material.tabs.TabLayout.Tab() : tabA;
    }

    protected boolean releaseFromTabPool(com.google.android.material.tabs.TabLayout.Tab tab) {
        return tabPool.a_renamed(tab);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public com.google.android.material.tabs.TabLayout.Tab getTabAt(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i_renamed);
    }

    public int getSelectedTabPosition() {
        com.google.android.material.tabs.TabLayout.Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    public void removeTab(com.google.android.material.tabs.TabLayout.Tab tab) {
        if (tab.parent != this) {
            throw new java.lang.IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i_renamed) {
        com.google.android.material.tabs.TabLayout.Tab tab = this.selectedTab;
        int position = tab != null ? tab.getPosition() : 0;
        removeTabViewAt(i_renamed);
        com.google.android.material.tabs.TabLayout.Tab tabRemove = this.tabs.remove(i_renamed);
        if (tabRemove != null) {
            tabRemove.reset();
            releaseFromTabPool(tabRemove);
        }
        int size = this.tabs.size();
        for (int i2 = i_renamed; i2 < size; i2++) {
            this.tabs.get(i2).setPosition(i2);
        }
        if (position == i_renamed) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(java.lang.Math.max(0, i_renamed - 1)));
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        java.util.Iterator<com.google.android.material.tabs.TabLayout.Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            com.google.android.material.tabs.TabLayout.Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void setTabMode(int i_renamed) {
        if (i_renamed != this.mode) {
            this.mode = i_renamed;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mode;
    }

    public void setTabGravity(int i_renamed) {
        if (this.tabGravity != i_renamed) {
            this.tabGravity = i_renamed;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public void setSelectedTabIndicatorGravity(int i_renamed) {
        if (this.tabIndicatorGravity != i_renamed) {
            this.tabIndicatorGravity = i_renamed;
            androidx.core.h_renamed.v_renamed.e_renamed(this.slidingTabIndicator);
        }
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public void setTabIndicatorFullWidth(boolean z_renamed) {
        this.tabIndicatorFullWidth = z_renamed;
        androidx.core.h_renamed.v_renamed.e_renamed(this.slidingTabIndicator);
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public void setInlineLabel(boolean z_renamed) {
        if (this.inlineLabel != z_renamed) {
            this.inlineLabel = z_renamed;
            for (int i_renamed = 0; i_renamed < this.slidingTabIndicator.getChildCount(); i_renamed++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(int i_renamed) {
        setInlineLabel(getResources().getBoolean(i_renamed));
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public void setUnboundedRipple(boolean z_renamed) {
        if (this.unboundedRipple != z_renamed) {
            this.unboundedRipple = z_renamed;
            for (int i_renamed = 0; i_renamed < this.slidingTabIndicator.getChildCount(); i_renamed++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i_renamed) {
        setUnboundedRipple(getResources().getBoolean(i_renamed));
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public void setTabTextColors(android.content.res.ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    public android.content.res.ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public void setTabTextColors(int i_renamed, int i2) {
        setTabTextColors(createColorStateList(i_renamed, i2));
    }

    public void setTabIconTint(android.content.res.ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(int i_renamed) {
        setTabIconTint(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.content.res.ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public android.content.res.ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public void setTabRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i_renamed = 0; i_renamed < this.slidingTabIndicator.getChildCount(); i_renamed++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i_renamed) {
        setTabRippleColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.graphics.drawable.Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public void setSelectedTabIndicator(android.graphics.drawable.Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            this.tabSelectedIndicator = drawable;
            androidx.core.h_renamed.v_renamed.e_renamed(this.slidingTabIndicator);
        }
    }

    public void setSelectedTabIndicator(int i_renamed) {
        if (i_renamed != 0) {
            setSelectedTabIndicator(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
        } else {
            setSelectedTabIndicator((android.graphics.drawable.Drawable) null);
        }
    }

    public void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager, boolean z_renamed) {
        setupWithViewPager(viewPager, z_renamed, false);
    }

    private void setupWithViewPager(androidx.viewpager.widget.ViewPager viewPager, boolean z_renamed, boolean z2) {
        androidx.viewpager.widget.ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.b_renamed(tabLayoutOnPageChangeListener);
            }
            com.google.android.material.tabs.TabLayout.AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.b_renamed(adapterChangeListener);
            }
        }
        com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.a_renamed(this.pageChangeListener);
            this.currentVpSelectedListener = new com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener(viewPager);
            addOnTabSelectedListener(this.currentVpSelectedListener);
            androidx.viewpager.widget.a_renamed adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z_renamed);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new com.google.android.material.tabs.TabLayout.AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z_renamed);
            viewPager.a_renamed(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    @java.lang.Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a_renamed aVar) {
        setPagerAdapter(aVar, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            android.view.ViewParent parent = getParent();
            if (parent instanceof androidx.viewpager.widget.ViewPager) {
                setupWithViewPager((androidx.viewpager.widget.ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    private int getTabScrollRange() {
        return java.lang.Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(androidx.viewpager.widget.a_renamed aVar, boolean z_renamed) {
        android.database.DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a_renamed aVar2 = this.pagerAdapter;
        if (aVar2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            aVar2.b_renamed(dataSetObserver);
        }
        this.pagerAdapter = aVar;
        if (z_renamed && aVar != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new com.google.android.material.tabs.TabLayout.PagerAdapterObserver();
            }
            aVar.a_renamed(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.a_renamed aVar = this.pagerAdapter;
        if (aVar != null) {
            int iA = aVar.a_renamed();
            for (int i_renamed = 0; i_renamed < iA; i_renamed++) {
                addTab(newTab().setText(this.pagerAdapter.a_renamed(i_renamed)), false);
            }
            androidx.viewpager.widget.ViewPager viewPager = this.viewPager;
            if (viewPager == null || iA <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.tabs.get(i_renamed).updateView();
        }
    }

    private com.google.android.material.tabs.TabLayout.TabView createTabView(com.google.android.material.tabs.TabLayout.Tab tab) {
        androidx.core.g_renamed.e_renamed.a_renamed<com.google.android.material.tabs.TabLayout.TabView> aVar = this.tabViewPool;
        com.google.android.material.tabs.TabLayout.TabView tabViewA = aVar != null ? aVar.a_renamed() : null;
        if (tabViewA == null) {
            tabViewA = new com.google.android.material.tabs.TabLayout.TabView(getContext());
        }
        tabViewA.setTab(tab);
        tabViewA.setFocusable(true);
        tabViewA.setMinimumWidth(getTabMinWidth());
        if (android.text.TextUtils.isEmpty(tab.contentDesc)) {
            tabViewA.setContentDescription(tab.text);
        } else {
            tabViewA.setContentDescription(tab.contentDesc);
        }
        return tabViewA;
    }

    private void configureTab(com.google.android.material.tabs.TabLayout.Tab tab, int i_renamed) {
        tab.setPosition(i_renamed);
        this.tabs.add(i_renamed, tab);
        int size = this.tabs.size();
        while (true) {
            i_renamed++;
            if (i_renamed >= size) {
                return;
            } else {
                this.tabs.get(i_renamed).setPosition(i_renamed);
            }
        }
    }

    private void addTabView(com.google.android.material.tabs.TabLayout.Tab tab) {
        com.google.android.material.tabs.TabLayout.TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(android.view.View view) {
        if (view instanceof com.google.android.material.tabs.TabItem) {
            addTabFromItemView((com.google.android.material.tabs.TabItem) view);
            return;
        }
        throw new java.lang.IllegalArgumentException("Only TabItem instances can be_renamed added to TabLayout");
    }

    private android.widget.LinearLayout.LayoutParams createLayoutParamsForTabs() {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f_renamed);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo).a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(1, getTabCount(), false, 1));
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        for (int i_renamed = 0; i_renamed < this.slidingTabIndicator.getChildCount(); i_renamed++) {
            android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
            if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                ((com.google.android.material.tabs.TabLayout.TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.dpToPx(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.requestedTabMaxWidth
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.dpToPx(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.tabMaxWidth = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.mode
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = r5
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = getChildMeasureSpec(r8, r0, r1)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r3)
            r7.measure(r6, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    private void removeTabViewAt(int i_renamed) {
        com.google.android.material.tabs.TabLayout.TabView tabView = (com.google.android.material.tabs.TabLayout.TabView) this.slidingTabIndicator.getChildAt(i_renamed);
        this.slidingTabIndicator.removeViewAt(i_renamed);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.a_renamed(tabView);
        }
        requestLayout();
    }

    private void animateToTab(int i_renamed) {
        if (i_renamed == -1) {
            return;
        }
        if (getWindowToken() == null || !androidx.core.h_renamed.v_renamed.A_renamed(this) || this.slidingTabIndicator.childrenNeedLayout()) {
            setScrollPosition(i_renamed, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iCalculateScrollXForTab = calculateScrollXForTab(i_renamed, 0.0f);
        if (scrollX != iCalculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.animateIndicatorToPosition(i_renamed, this.tabIndicatorAnimationDuration);
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            this.scrollAnimator = new android.animation.ValueAnimator();
            this.scrollAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.google.android.material.tabs.TabLayout.this.scrollTo(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    void setScrollAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    private void setSelectedTabView(int i_renamed) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i_renamed < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z_renamed = true;
                childAt.setSelected(i2 == i_renamed);
                if (i2 != i_renamed) {
                    z_renamed = false;
                }
                childAt.setActivated(z_renamed);
                i2++;
            }
        }
    }

    public void selectTab(com.google.android.material.tabs.TabLayout.Tab tab) {
        selectTab(tab, true);
    }

    public void selectTab(com.google.android.material.tabs.TabLayout.Tab tab, boolean z_renamed) {
        com.google.android.material.tabs.TabLayout.Tab tab2 = this.selectedTab;
        if (tab2 == tab) {
            if (tab2 != null) {
                dispatchTabReselected(tab);
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z_renamed) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.selectedTab = tab;
        if (tab2 != null) {
            dispatchTabUnselected(tab2);
        }
        if (tab != null) {
            dispatchTabSelected(tab);
        }
    }

    private void dispatchTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void dispatchTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private int calculateScrollXForTab(int i_renamed, float f_renamed) {
        int i2 = this.mode;
        if (i2 != 0 && i2 != 2) {
            return 0;
        }
        android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
        int i3 = i_renamed + 1;
        android.view.View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f_renamed);
        return androidx.core.h_renamed.v_renamed.g_renamed(this) == 0 ? left + i4 : left - i4;
    }

    private void applyModeAndGravity() {
        int i_renamed = this.mode;
        androidx.core.h_renamed.v_renamed.b_renamed(this.slidingTabIndicator, (i_renamed == 0 || i_renamed == 2) ? java.lang.Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i2 = this.mode;
        if (i2 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i2 == 1 || i2 == 2) {
            if (this.tabGravity == 2) {
                android.util.Log.w_renamed(LOG_TAG, "GRAVITY_START is_renamed not supported with the current tab mode, GRAVITY_CENTER will be_renamed used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private void applyGravityForModeScrollable(int i_renamed) {
        if (i_renamed == 0) {
            android.util.Log.w_renamed(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is_renamed not supported, GRAVITY_START will be_renamed used instead");
        } else if (i_renamed == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i_renamed != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(8388611);
    }

    void updateTabViews(boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < this.slidingTabIndicator.getChildCount(); i_renamed++) {
            android.view.View childAt = this.slidingTabIndicator.getChildAt(i_renamed);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((android.widget.LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z_renamed) {
                childAt.requestLayout();
            }
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        private java.lang.CharSequence contentDesc;
        private android.view.View customView;
        private android.graphics.drawable.Drawable icon;
        public com.google.android.material.tabs.TabLayout parent;
        private java.lang.Object tag;
        private java.lang.CharSequence text;
        public com.google.android.material.tabs.TabLayout.TabView view;
        private int position = -1;

        @com.google.android.material.tabs.TabLayout.LabelVisibility
        private int labelVisibilityMode = 1;

        public java.lang.Object getTag() {
            return this.tag;
        }

        public com.google.android.material.tabs.TabLayout.Tab setTag(java.lang.Object obj) {
            this.tag = obj;
            return this;
        }

        public android.view.View getCustomView() {
            return this.customView;
        }

        public com.google.android.material.tabs.TabLayout.Tab setCustomView(android.view.View view) {
            this.customView = view;
            updateView();
            return this;
        }

        public com.google.android.material.tabs.TabLayout.Tab setCustomView(int i_renamed) {
            return setCustomView(android.view.LayoutInflater.from(this.view.getContext()).inflate(i_renamed, (android.view.ViewGroup) this.view, false));
        }

        public android.graphics.drawable.Drawable getIcon() {
            return this.icon;
        }

        public int getPosition() {
            return this.position;
        }

        void setPosition(int i_renamed) {
            this.position = i_renamed;
        }

        public java.lang.CharSequence getText() {
            return this.text;
        }

        public com.google.android.material.tabs.TabLayout.Tab setIcon(android.graphics.drawable.Drawable drawable) {
            this.icon = drawable;
            if (this.parent.tabGravity == 1 || this.parent.mode == 2) {
                this.parent.updateTabViews(true);
            }
            updateView();
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        public com.google.android.material.tabs.TabLayout.Tab setIcon(int i_renamed) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new java.lang.IllegalArgumentException("Tab not attached to a_renamed TabLayout");
            }
            return setIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(tabLayout.getContext(), i_renamed));
        }

        public com.google.android.material.tabs.TabLayout.Tab setText(java.lang.CharSequence charSequence) {
            if (android.text.TextUtils.isEmpty(this.contentDesc) && !android.text.TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public com.google.android.material.tabs.TabLayout.Tab setText(int i_renamed) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new java.lang.IllegalArgumentException("Tab not attached to a_renamed TabLayout");
            }
            return setText(tabLayout.getResources().getText(i_renamed));
        }

        public com.google.android.material.badge.BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        public com.google.android.material.badge.BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        public com.google.android.material.tabs.TabLayout.Tab setTabLabelVisibility(@com.google.android.material.tabs.TabLayout.LabelVisibility int i_renamed) {
            this.labelVisibilityMode = i_renamed;
            if (this.parent.tabGravity == 1 || this.parent.mode == 2) {
                this.parent.updateTabViews(true);
            }
            updateView();
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @com.google.android.material.tabs.TabLayout.LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        public void select() {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new java.lang.IllegalArgumentException("Tab not attached to a_renamed TabLayout");
            }
            tabLayout.selectTab(this);
        }

        public boolean isSelected() {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.position;
            }
            throw new java.lang.IllegalArgumentException("Tab not attached to a_renamed TabLayout");
        }

        public com.google.android.material.tabs.TabLayout.Tab setContentDescription(int i_renamed) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new java.lang.IllegalArgumentException("Tab not attached to a_renamed TabLayout");
            }
            return setContentDescription(tabLayout.getResources().getText(i_renamed));
        }

        public com.google.android.material.tabs.TabLayout.Tab setContentDescription(java.lang.CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        public java.lang.CharSequence getContentDescription() {
            com.google.android.material.tabs.TabLayout.TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        void updateView() {
            com.google.android.material.tabs.TabLayout.TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }
    }

    public final class TabView extends android.widget.LinearLayout {
        private android.view.View badgeAnchorView;
        private com.google.android.material.badge.BadgeDrawable badgeDrawable;
        private android.graphics.drawable.Drawable baseBackgroundDrawable;
        private android.widget.ImageView customIconView;
        private android.widget.TextView customTextView;
        private android.view.View customView;
        private int defaultMaxLines;
        private android.widget.ImageView iconView;
        private com.google.android.material.tabs.TabLayout.Tab tab;
        private android.widget.TextView textView;

        public TabView(android.content.Context context) {
            super(context);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            androidx.core.h_renamed.v_renamed.b_renamed(this, com.google.android.material.tabs.TabLayout.this.tabPaddingStart, com.google.android.material.tabs.TabLayout.this.tabPaddingTop, com.google.android.material.tabs.TabLayout.this.tabPaddingEnd, com.google.android.material.tabs.TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!com.google.android.material.tabs.TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            androidx.core.h_renamed.v_renamed.a_renamed(this, androidx.core.h_renamed.s_renamed.a_renamed(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateBackgroundDrawable(android.content.Context context) {
            if (com.google.android.material.tabs.TabLayout.this.tabBackgroundResId != 0) {
                this.baseBackgroundDrawable = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, com.google.android.material.tabs.TabLayout.this.tabBackgroundResId);
                android.graphics.drawable.Drawable drawable = this.baseBackgroundDrawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            android.graphics.drawable.Drawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            ((android.graphics.drawable.GradientDrawable) gradientDrawable).setColor(0);
            if (com.google.android.material.tabs.TabLayout.this.tabRippleColorStateList != null) {
                android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                android.content.res.ColorStateList colorStateListConvertToRippleDrawableColor = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(com.google.android.material.tabs.TabLayout.this.tabRippleColorStateList);
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    if (com.google.android.material.tabs.TabLayout.this.unboundedRipple) {
                        gradientDrawable = null;
                    }
                    if (com.google.android.material.tabs.TabLayout.this.unboundedRipple) {
                        gradientDrawable2 = null;
                    }
                    gradientDrawable = new android.graphics.drawable.RippleDrawable(colorStateListConvertToRippleDrawableColor, gradientDrawable, gradientDrawable2);
                } else {
                    android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(gradientDrawable2);
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, colorStateListConvertToRippleDrawableColor);
                    gradientDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{gradientDrawable, drawableG});
                }
            }
            androidx.core.h_renamed.v_renamed.a_renamed(this, gradientDrawable);
            com.google.android.material.tabs.TabLayout.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(android.graphics.Canvas canvas) {
            android.graphics.drawable.Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            android.graphics.drawable.Drawable drawable = this.baseBackgroundDrawable;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (state) {
                invalidate();
                com.google.android.material.tabs.TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.tab == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z_renamed) {
            boolean z2 = isSelected() != z_renamed;
            super.setSelected(z_renamed);
            if (z2 && z_renamed && android.os.Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            android.widget.TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z_renamed);
            }
            android.widget.ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z_renamed);
            }
            android.view.View view = this.customView;
            if (view != null) {
                view.setSelected(z_renamed);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((java.lang.Object) getContentDescription()) + ", " + ((java.lang.Object) this.badgeDrawable.getContentDescription()));
            }
            androidx.core.h_renamed.a_renamed.d_renamed dVarA = androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo);
            dVarA.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                dVarA.g_renamed(false);
                dVarA.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.e_renamed);
            }
            dVarA.i_renamed("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i_renamed, int i2) {
            android.text.Layout layout;
            int size = android.view.View.MeasureSpec.getSize(i_renamed);
            int mode = android.view.View.MeasureSpec.getMode(i_renamed);
            int tabMaxWidth = com.google.android.material.tabs.TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(com.google.android.material.tabs.TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i_renamed, i2);
            if (this.textView != null) {
                float f_renamed = com.google.android.material.tabs.TabLayout.this.tabTextSize;
                int i3 = this.defaultMaxLines;
                android.widget.ImageView imageView = this.iconView;
                boolean z_renamed = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    android.widget.TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f_renamed = com.google.android.material.tabs.TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int iA = androidx.core.widget.i_renamed.a_renamed(this.textView);
                if (f_renamed != textSize || (iA >= 0 && i3 != iA)) {
                    if (com.google.android.material.tabs.TabLayout.this.mode == 1 && f_renamed > textSize && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f_renamed) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z_renamed = false;
                    }
                    if (z_renamed) {
                        this.textView.setTextSize(0, f_renamed);
                        this.textView.setMaxLines(i3);
                        super.onMeasure(i_renamed, i2);
                    }
                }
            }
        }

        void setTab(com.google.android.material.tabs.TabLayout.Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        final void update() {
            com.google.android.material.tabs.TabLayout.Tab tab = this.tab;
            android.graphics.drawable.Drawable drawableMutate = null;
            android.view.View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                android.view.ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((android.view.ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.customView = customView;
                android.widget.TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                android.widget.ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                this.customTextView = (android.widget.TextView) customView.findViewById(android.R_renamed.id_renamed.text1);
                android.widget.TextView textView2 = this.customTextView;
                if (textView2 != null) {
                    this.defaultMaxLines = androidx.core.widget.i_renamed.a_renamed(textView2);
                }
                this.customIconView = (android.widget.ImageView) customView.findViewById(android.R_renamed.id_renamed.icon);
            } else {
                android.view.View view = this.customView;
                if (view != null) {
                    removeView(view);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (tab != null && tab.getIcon() != null) {
                    drawableMutate = androidx.core.graphics.drawable.a_renamed.g_renamed(tab.getIcon()).mutate();
                }
                if (drawableMutate != null) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, com.google.android.material.tabs.TabLayout.this.tabIconTint);
                    if (com.google.android.material.tabs.TabLayout.this.tabIconTintMode != null) {
                        androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, com.google.android.material.tabs.TabLayout.this.tabIconTintMode);
                    }
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = androidx.core.widget.i_renamed.a_renamed(this.textView);
                }
                androidx.core.widget.i_renamed.a_renamed(this.textView, com.google.android.material.tabs.TabLayout.this.tabTextAppearance);
                if (com.google.android.material.tabs.TabLayout.this.tabTextColors != null) {
                    this.textView.setTextColor(com.google.android.material.tabs.TabLayout.this.tabTextColors);
                }
                updateTextAndIcon(this.textView, this.iconView);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else if (this.customTextView != null || this.customIconView != null) {
                updateTextAndIcon(this.customTextView, this.customIconView);
            }
            if (tab != null && !android.text.TextUtils.isEmpty(tab.contentDesc)) {
                setContentDescription(tab.contentDesc);
            }
            setSelected(tab != null && tab.isSelected());
        }

        private void inflateAndAddDefaultIconView() {
            android.widget.FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot;
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot, 0);
            } else {
                frameLayoutCreatePreApi18BadgeAnchorRoot = this;
            }
            this.iconView = (android.widget.ImageView) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R_renamed.layout.design_layout_tab_icon, (android.view.ViewGroup) frameLayoutCreatePreApi18BadgeAnchorRoot, false);
            frameLayoutCreatePreApi18BadgeAnchorRoot.addView(this.iconView, 0);
        }

        private void inflateAndAddDefaultTextView() {
            android.widget.FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot;
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot);
            } else {
                frameLayoutCreatePreApi18BadgeAnchorRoot = this;
            }
            this.textView = (android.widget.TextView) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R_renamed.layout.design_layout_tab_text, (android.view.ViewGroup) frameLayoutCreatePreApi18BadgeAnchorRoot, false);
            frameLayoutCreatePreApi18BadgeAnchorRoot.addView(this.textView);
        }

        private android.widget.FrameLayout createPreApi18BadgeAnchorRoot() {
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
            frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.material.badge.BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = com.google.android.material.badge.BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new java.lang.IllegalStateException("Unable to create badge");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.material.badge.BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void addOnLayoutChangeListener(final android.view.View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view2, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (view.getVisibility() == 0) {
                        com.google.android.material.tabs.TabLayout.TabView.this.tryUpdateBadgeDrawableBounds(view);
                    }
                }
            });
        }

        private void tryUpdateBadgeAnchor() {
            com.google.android.material.tabs.TabLayout.Tab tab;
            com.google.android.material.tabs.TabLayout.Tab tab2;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                    android.view.View view = this.badgeAnchorView;
                    android.widget.ImageView imageView = this.iconView;
                    if (view != imageView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    } else {
                        tryUpdateBadgeDrawableBounds(imageView);
                        return;
                    }
                }
                if (this.textView != null && (tab = this.tab) != null && tab.getTabLabelVisibility() == 1) {
                    android.view.View view2 = this.badgeAnchorView;
                    android.widget.TextView textView = this.textView;
                    if (view2 != textView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.textView);
                        return;
                    } else {
                        tryUpdateBadgeDrawableBounds(textView);
                        return;
                    }
                }
                tryRemoveBadgeFromAnchor();
            }
        }

        private void tryAttachBadgeToAnchor(android.view.View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                com.google.android.material.badge.BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                android.view.View view = this.badgeAnchorView;
                if (view != null) {
                    com.google.android.material.badge.BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                    this.badgeAnchorView = null;
                }
            }
        }

        private void clipViewToPaddingForBadge(boolean z_renamed) {
            setClipChildren(z_renamed);
            setClipToPadding(z_renamed);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z_renamed);
                viewGroup.setClipToPadding(z_renamed);
            }
        }

        final void updateOrientation() {
            setOrientation(!com.google.android.material.tabs.TabLayout.this.inlineLabel ? 1 : 0);
            if (this.customTextView != null || this.customIconView != null) {
                updateTextAndIcon(this.customTextView, this.customIconView);
            } else {
                updateTextAndIcon(this.textView, this.iconView);
            }
        }

        private void updateTextAndIcon(android.widget.TextView textView, android.widget.ImageView imageView) {
            com.google.android.material.tabs.TabLayout.Tab tab = this.tab;
            android.graphics.drawable.Drawable drawableMutate = (tab == null || tab.getIcon() == null) ? null : androidx.core.graphics.drawable.a_renamed.g_renamed(this.tab.getIcon()).mutate();
            com.google.android.material.tabs.TabLayout.Tab tab2 = this.tab;
            java.lang.CharSequence text = tab2 != null ? tab2.getText() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z_renamed = !android.text.TextUtils.isEmpty(text);
            if (textView != null) {
                if (z_renamed) {
                    textView.setText(text);
                    if (this.tab.labelVisibilityMode == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((java.lang.CharSequence) null);
                }
            }
            if (imageView != null) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iDpToPx = (z_renamed && imageView.getVisibility() == 0) ? (int) com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 8) : 0;
                if (com.google.android.material.tabs.TabLayout.this.inlineLabel) {
                    if (iDpToPx != androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams)) {
                        androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams, iDpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iDpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iDpToPx;
                    androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            com.google.android.material.tabs.TabLayout.Tab tab3 = this.tab;
            java.lang.CharSequence charSequence = tab3 != null ? tab3.contentDesc : null;
            if (z_renamed) {
                charSequence = null;
            }
            androidx.appcompat.widget.at_renamed.a_renamed(this, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(android.view.View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                com.google.android.material.badge.BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        private android.widget.FrameLayout getCustomParentForBadge(android.view.View view) {
            if ((view == this.iconView || view == this.textView) && com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                return (android.widget.FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            int iMax = 0;
            int iMin = 0;
            boolean z_renamed = false;
            for (android.view.View view : new android.view.View[]{this.textView, this.iconView, this.customView}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z_renamed ? java.lang.Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z_renamed ? java.lang.Math.max(iMax, view.getRight()) : view.getRight();
                    z_renamed = true;
                }
            }
            return iMax - iMin;
        }

        public com.google.android.material.tabs.TabLayout.Tab getTab() {
            return this.tab;
        }

        private float approximateLineWidth(android.text.Layout layout, int i_renamed, float f_renamed) {
            return layout.getLineWidth(i_renamed) * (f_renamed / layout.getPaint().getTextSize());
        }
    }

    class SlidingTabIndicator extends android.widget.LinearLayout {
        private int animationStartLeft;
        private int animationStartRight;
        private final android.graphics.drawable.GradientDrawable defaultSelectionIndicator;
        android.animation.ValueAnimator indicatorAnimator;
        int indicatorLeft;
        int indicatorRight;
        private int layoutDirection;
        private int selectedIndicatorHeight;
        private final android.graphics.Paint selectedIndicatorPaint;
        int selectedPosition;
        float selectionOffset;

        SlidingTabIndicator(android.content.Context context) {
            super(context);
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            this.indicatorLeft = -1;
            this.indicatorRight = -1;
            this.animationStartLeft = -1;
            this.animationStartRight = -1;
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new android.graphics.Paint();
            this.defaultSelectionIndicator = new android.graphics.drawable.GradientDrawable();
        }

        void setSelectedIndicatorColor(int i_renamed) {
            if (this.selectedIndicatorPaint.getColor() != i_renamed) {
                this.selectedIndicatorPaint.setColor(i_renamed);
                androidx.core.h_renamed.v_renamed.e_renamed(this);
            }
        }

        void setSelectedIndicatorHeight(int i_renamed) {
            if (this.selectedIndicatorHeight != i_renamed) {
                this.selectedIndicatorHeight = i_renamed;
                androidx.core.h_renamed.v_renamed.e_renamed(this);
            }
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                if (getChildAt(i_renamed).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void setIndicatorPositionFromTabPosition(int i_renamed, float f_renamed) {
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            this.selectedPosition = i_renamed;
            this.selectionOffset = f_renamed;
            updateIndicatorPosition();
        }

        float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i_renamed) {
            super.onRtlPropertiesChanged(i_renamed);
            if (android.os.Build.VERSION.SDK_INT >= 23 || this.layoutDirection == i_renamed) {
                return;
            }
            requestLayout();
            this.layoutDirection = i_renamed;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i_renamed, int i2) {
            boolean z_renamed;
            super.onMeasure(i_renamed, i2);
            if (android.view.View.MeasureSpec.getMode(i_renamed) != 1073741824) {
                return;
            }
            if (com.google.android.material.tabs.TabLayout.this.tabGravity == 1 || com.google.android.material.tabs.TabLayout.this.mode == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    android.view.View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = java.lang.Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    z_renamed = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z_renamed = true;
                        }
                    }
                } else {
                    com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
                    tabLayout.tabGravity = 0;
                    tabLayout.updateTabViews(false);
                    z_renamed = true;
                }
                if (z_renamed) {
                    super.onMeasure(i_renamed, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
            super.onLayout(z_renamed, i_renamed, i2, i3, i4);
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
            } else {
                updateIndicatorPosition();
            }
        }

        private void updateIndicatorPosition() {
            int left;
            int right;
            android.view.View childAt = getChildAt(this.selectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (!com.google.android.material.tabs.TabLayout.this.tabIndicatorFullWidth && (childAt instanceof com.google.android.material.tabs.TabLayout.TabView)) {
                    calculateTabViewContentBounds((com.google.android.material.tabs.TabLayout.TabView) childAt, com.google.android.material.tabs.TabLayout.this.tabViewContentBounds);
                    left = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.left;
                    right = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.right;
                }
                if (this.selectionOffset > 0.0f && this.selectedPosition < getChildCount() - 1) {
                    android.view.View childAt2 = getChildAt(this.selectedPosition + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    if (!com.google.android.material.tabs.TabLayout.this.tabIndicatorFullWidth && (childAt2 instanceof com.google.android.material.tabs.TabLayout.TabView)) {
                        calculateTabViewContentBounds((com.google.android.material.tabs.TabLayout.TabView) childAt2, com.google.android.material.tabs.TabLayout.this.tabViewContentBounds);
                        left2 = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.left;
                        right2 = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.right;
                    }
                    float f_renamed = this.selectionOffset;
                    left = (int) ((left2 * f_renamed) + ((1.0f - f_renamed) * left));
                    right = (int) ((right2 * f_renamed) + ((1.0f - f_renamed) * right));
                }
            }
            setIndicatorPosition(left, right);
        }

        void setIndicatorPosition(int i_renamed, int i2) {
            if (i_renamed == this.indicatorLeft && i2 == this.indicatorRight) {
                return;
            }
            this.indicatorLeft = i_renamed;
            this.indicatorRight = i2;
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }

        void animateIndicatorToPosition(int i_renamed, int i2) {
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i_renamed, i2);
        }

        private void updateOrRecreateIndicatorAnimation(boolean z_renamed, final int i_renamed, int i2) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt == null) {
                updateIndicatorPosition();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (!com.google.android.material.tabs.TabLayout.this.tabIndicatorFullWidth && (childAt instanceof com.google.android.material.tabs.TabLayout.TabView)) {
                calculateTabViewContentBounds((com.google.android.material.tabs.TabLayout.TabView) childAt, com.google.android.material.tabs.TabLayout.this.tabViewContentBounds);
                left = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.left;
                right = (int) com.google.android.material.tabs.TabLayout.this.tabViewContentBounds.right;
            }
            int i3 = this.indicatorLeft;
            int i4 = this.indicatorRight;
            if (i3 == left && i4 == right) {
                return;
            }
            if (z_renamed) {
                this.animationStartLeft = i3;
                this.animationStartRight = i4;
            }
            android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    com.google.android.material.tabs.TabLayout.SlidingTabIndicator slidingTabIndicator = com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this;
                    slidingTabIndicator.setIndicatorPosition(com.google.android.material.animation.AnimationUtils.lerp(slidingTabIndicator.animationStartLeft, left, animatedFraction), com.google.android.material.animation.AnimationUtils.lerp(com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this.animationStartRight, right, animatedFraction));
                }
            };
            if (z_renamed) {
                android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
                this.indicatorAnimator = valueAnimator;
                valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator.setDuration(i2);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(animatorUpdateListener);
                valueAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this.selectedPosition = i_renamed;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        com.google.android.material.tabs.TabLayout.SlidingTabIndicator slidingTabIndicator = com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this;
                        slidingTabIndicator.selectedPosition = i_renamed;
                        slidingTabIndicator.selectionOffset = 0.0f;
                    }
                });
                valueAnimator.start();
                return;
            }
            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
        }

        private void calculateTabViewContentBounds(com.google.android.material.tabs.TabLayout.TabView tabView, android.graphics.RectF rectF) {
            int contentWidth = tabView.getContentWidth();
            int iDpToPx = (int) com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 24);
            if (contentWidth >= iDpToPx) {
                iDpToPx = contentWidth;
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i_renamed = iDpToPx / 2;
            rectF.set(left - i_renamed, 0.0f, left + i_renamed, 0.0f);
        }

        @Override // android.view.View
        public void draw(android.graphics.Canvas canvas) {
            int height = 0;
            int intrinsicHeight = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator != null ? com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getIntrinsicHeight() : 0;
            int i_renamed = this.selectedIndicatorHeight;
            if (i_renamed >= 0) {
                intrinsicHeight = i_renamed;
            }
            int i2 = com.google.android.material.tabs.TabLayout.this.tabIndicatorGravity;
            if (i2 == 0) {
                height = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i2 == 1) {
                height = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i2 != 2) {
                intrinsicHeight = i2 != 3 ? 0 : getHeight();
            }
            int i3 = this.indicatorLeft;
            if (i3 >= 0 && this.indicatorRight > i3) {
                android.graphics.drawable.Drawable drawableMutate = androidx.core.graphics.drawable.a_renamed.g_renamed(com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator != null ? com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator : this.defaultSelectionIndicator).mutate();
                drawableMutate.setBounds(this.indicatorLeft, height, this.indicatorRight, intrinsicHeight);
                if (this.selectedIndicatorPaint != null) {
                    if (android.os.Build.VERSION.SDK_INT == 21) {
                        drawableMutate.setColorFilter(this.selectedIndicatorPaint.getColor(), android.graphics.PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a_renamed.a_renamed(drawableMutate, this.selectedIndicatorPaint.getColor());
                    }
                }
                drawableMutate.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static android.content.res.ColorStateList createColorStateList(int i_renamed, int i2) {
        return new android.content.res.ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i_renamed});
    }

    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z_renamed = false;
        int i_renamed = 0;
        while (true) {
            if (i_renamed < size) {
                com.google.android.material.tabs.TabLayout.Tab tab = this.tabs.get(i_renamed);
                if (tab != null && tab.getIcon() != null && !android.text.TextUtils.isEmpty(tab.getText())) {
                    z_renamed = true;
                    break;
                }
                i_renamed++;
            } else {
                break;
            }
        }
        return (!z_renamed || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i_renamed = this.requestedTabMinWidth;
        if (i_renamed != -1) {
            return i_renamed;
        }
        int i2 = this.mode;
        if (i2 == 0 || i2 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public static class TabLayoutOnPageChangeListener implements androidx.viewpager.widget.ViewPager.f_renamed {
        private int previousScrollState;
        private int scrollState;
        private final java.lang.ref.WeakReference<com.google.android.material.tabs.TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(com.google.android.material.tabs.TabLayout tabLayout) {
            this.tabLayoutRef = new java.lang.ref.WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.f_renamed
        public void onPageScrollStateChanged(int i_renamed) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i_renamed;
        }

        @Override // androidx.viewpager.widget.ViewPager.f_renamed
        public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.setScrollPosition(i_renamed, f_renamed, this.scrollState != 2 || this.previousScrollState == 1, (this.scrollState == 2 && this.previousScrollState == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.f_renamed
        public void onPageSelected(int i_renamed) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i_renamed || i_renamed >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i_renamed), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        private final androidx.viewpager.widget.ViewPager viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        public ViewPagerOnTabSelectedListener(androidx.viewpager.widget.ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) throws android.content.res.Resources.NotFoundException {
            this.viewPager.setCurrentItem(tab.getPosition());
        }
    }

    private class PagerAdapterObserver extends android.database.DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            com.google.android.material.tabs.TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.google.android.material.tabs.TabLayout.this.populateFromPagerAdapter();
        }
    }

    private class AdapterChangeListener implements androidx.viewpager.widget.ViewPager.e_renamed {
        private boolean autoRefresh;

        AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.e_renamed
        public void onAdapterChanged(androidx.viewpager.widget.ViewPager viewPager, androidx.viewpager.widget.a_renamed aVar, androidx.viewpager.widget.a_renamed aVar2) {
            if (com.google.android.material.tabs.TabLayout.this.viewPager == viewPager) {
                com.google.android.material.tabs.TabLayout.this.setPagerAdapter(aVar2, this.autoRefresh);
            }
        }

        void setAutoRefresh(boolean z_renamed) {
            this.autoRefresh = z_renamed;
        }
    }
}
