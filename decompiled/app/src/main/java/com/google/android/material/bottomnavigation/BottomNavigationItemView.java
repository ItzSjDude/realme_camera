package com.google.android.material.bottomnavigation;

/* loaded from: classes.dex */
public class BottomNavigationItemView extends android.widget.FrameLayout implements androidx.appcompat.view.menu.o_renamed.a_renamed {
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    public static final int INVALID_ITEM_POSITION = -1;
    private com.google.android.material.badge.BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private android.widget.ImageView icon;
    private android.content.res.ColorStateList iconTint;
    private boolean isShifting;
    private androidx.appcompat.view.menu.j_renamed itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final android.widget.TextView largeLabel;
    private android.graphics.drawable.Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final android.widget.TextView smallLabel;
    private android.graphics.drawable.Drawable wrappedIconDrawable;

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z_renamed, char c2) {
    }

    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.itemPosition = -1;
        android.content.res.Resources resources = getResources();
        android.view.LayoutInflater.from(context).inflate(com.google.android.material.R_renamed.layout.design_bottom_navigation_item, (android.view.ViewGroup) this, true);
        setBackgroundResource(com.google.android.material.R_renamed.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_bottom_navigation_margin);
        this.icon = (android.widget.ImageView) findViewById(com.google.android.material.R_renamed.id_renamed.icon);
        this.smallLabel = (android.widget.TextView) findViewById(com.google.android.material.R_renamed.id_renamed.smallLabel);
        this.largeLabel = (android.widget.TextView) findViewById(com.google.android.material.R_renamed.id_renamed.largeLabel);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.smallLabel, 2);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        android.widget.ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (com.google.android.material.bottomnavigation.BottomNavigationItemView.this.icon.getVisibility() == 0) {
                        com.google.android.material.bottomnavigation.BottomNavigationItemView bottomNavigationItemView = com.google.android.material.bottomnavigation.BottomNavigationItemView.this;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public void initialize(androidx.appcompat.view.menu.j_renamed jVar, int i_renamed) {
        java.lang.CharSequence title;
        this.itemData = jVar;
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setIcon(jVar.getIcon());
        setTitle(jVar.getTitle());
        setId(jVar.getItemId());
        if (!android.text.TextUtils.isEmpty(jVar.getContentDescription())) {
            setContentDescription(jVar.getContentDescription());
        }
        if (!android.text.TextUtils.isEmpty(jVar.getTooltipText())) {
            title = jVar.getTooltipText();
        } else {
            title = jVar.getTitle();
        }
        androidx.appcompat.widget.at_renamed.a_renamed(this, title);
        setVisibility(jVar.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i_renamed) {
        this.itemPosition = i_renamed;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean z_renamed) {
        if (this.isShifting != z_renamed) {
            this.isShifting = z_renamed;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i_renamed) {
        if (this.labelVisibilityMode != i_renamed) {
            this.labelVisibilityMode = i_renamed;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public androidx.appcompat.view.menu.j_renamed getItemData() {
        return this.itemData;
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        androidx.appcompat.view.menu.j_renamed jVar = this.itemData;
        if (jVar == null || android.text.TextUtils.isEmpty(jVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        androidx.appcompat.view.menu.j_renamed jVar2 = this.itemData;
        if (jVar2 != null && !android.text.TextUtils.isEmpty(jVar2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        androidx.appcompat.widget.at_renamed.a_renamed(this, charSequence);
    }

    public void setCheckable(boolean z_renamed) {
        refreshDrawableState();
    }

    public void setChecked(boolean z_renamed) {
        this.largeLabel.setPivotX(r0.getWidth() / 2);
        this.largeLabel.setPivotY(r0.getBaseline());
        this.smallLabel.setPivotX(r0.getWidth() / 2);
        this.smallLabel.setPivotY(r0.getBaseline());
        int i_renamed = this.labelVisibilityMode;
        if (i_renamed != -1) {
            if (i_renamed == 0) {
                if (z_renamed) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i_renamed != 1) {
                if (i_renamed == 2) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    this.largeLabel.setVisibility(8);
                    this.smallLabel.setVisibility(8);
                }
            } else if (z_renamed) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                android.widget.TextView textView = this.smallLabel;
                float f_renamed = this.scaleUpFactor;
                setViewValues(textView, f_renamed, f_renamed, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                android.widget.TextView textView2 = this.largeLabel;
                float f2 = this.scaleDownFactor;
                setViewValues(textView2, f2, f2, 4);
                setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        } else if (this.isShifting) {
            if (z_renamed) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
            }
            this.smallLabel.setVisibility(4);
        } else if (z_renamed) {
            setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
            setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
            android.widget.TextView textView3 = this.smallLabel;
            float f3 = this.scaleUpFactor;
            setViewValues(textView3, f3, f3, 4);
        } else {
            setViewLayoutParams(this.icon, this.defaultMargin, 49);
            android.widget.TextView textView4 = this.largeLabel;
            float f4 = this.scaleDownFactor;
            setViewValues(textView4, f4, f4, 4);
            setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z_renamed);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            java.lang.CharSequence title = this.itemData.getTitle();
            if (!android.text.TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((java.lang.Object) title) + ", " + ((java.lang.Object) this.badgeDrawable.getContentDescription()));
        }
        androidx.core.h_renamed.a_renamed.d_renamed dVarA = androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo);
        dVarA.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            dVarA.g_renamed(false);
            dVarA.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.e_renamed);
        }
        dVarA.i_renamed("Tab");
    }

    private void setViewLayoutParams(android.view.View view, int i_renamed, int i2) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i_renamed;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void setViewValues(android.view.View view, float f_renamed, float f2, int i_renamed) {
        view.setScaleX(f_renamed);
        view.setScaleY(f2);
        view.setVisibility(i_renamed);
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        this.smallLabel.setEnabled(z_renamed);
        this.largeLabel.setEnabled(z_renamed);
        this.icon.setEnabled(z_renamed);
        if (z_renamed) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, androidx.core.h_renamed.s_renamed.a_renamed(getContext(), 1002));
        } else {
            androidx.core.h_renamed.v_renamed.a_renamed(this, (androidx.core.h_renamed.s_renamed) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        androidx.appcompat.view.menu.j_renamed jVar = this.itemData;
        if (jVar != null && jVar.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            android.content.res.ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(this.wrappedIconDrawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconTintList(android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
            return;
        }
        androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.iconTint);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setIconSize(int i_renamed) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i_renamed;
        layoutParams.height = i_renamed;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i_renamed) {
        androidx.core.widget.i_renamed.a_renamed(this.smallLabel, i_renamed);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int i_renamed) {
        androidx.core.widget.i_renamed.a_renamed(this.largeLabel, i_renamed);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    private void calculateTextScaleFactors(float f_renamed, float f2) {
        this.shiftAmount = f_renamed - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f_renamed;
        this.scaleDownFactor = (f_renamed * 1.0f) / f2;
    }

    public void setItemBackground(int i_renamed) {
        setItemBackground(i_renamed == 0 ? null : androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public void setItemBackground(android.graphics.drawable.Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this, drawable);
    }

    void setBadge(com.google.android.material.badge.BadgeDrawable badgeDrawable) {
        this.badgeDrawable = badgeDrawable;
        android.widget.ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    com.google.android.material.badge.BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(android.view.View view) {
        if (hasBadge()) {
            com.google.android.material.badge.BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryAttachBadgeToAnchor(android.view.View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(android.view.View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
            this.badgeDrawable = null;
        }
    }

    private android.widget.FrameLayout getCustomParentForBadge(android.view.View view) {
        if (view == this.icon && com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
            return (android.widget.FrameLayout) this.icon.getParent();
        }
        return null;
    }
}
