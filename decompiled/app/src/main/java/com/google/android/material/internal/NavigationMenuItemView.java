package com.google.android.material.internal;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends com.google.android.material.internal.ForegroundLinearLayout implements androidx.appcompat.view.menu.o_renamed.a_renamed {
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private final androidx.core.h_renamed.a_renamed accessibilityDelegate;
    private android.widget.FrameLayout actionArea;
    boolean checkable;
    private android.graphics.drawable.Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private android.content.res.ColorStateList iconTintList;
    private androidx.appcompat.view.menu.j_renamed itemData;
    private boolean needsEmptyIcon;
    private final android.widget.CheckedTextView textView;

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z_renamed, char c2) {
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(android.content.Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.accessibilityDelegate = new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a_renamed(com.google.android.material.internal.NavigationMenuItemView.this.checkable);
            }
        };
        setOrientation(0);
        android.view.LayoutInflater.from(context).inflate(com.google.android.material.R_renamed.layout.design_navigation_menu_item, (android.view.ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.design_navigation_icon_size));
        this.textView = (android.widget.CheckedTextView) findViewById(com.google.android.material.R_renamed.id_renamed.design_menu_item_text);
        this.textView.setDuplicateParentStateEnabled(true);
        androidx.core.h_renamed.v_renamed.a_renamed(this.textView, this.accessibilityDelegate);
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public void initialize(androidx.appcompat.view.menu.j_renamed jVar, int i_renamed) {
        this.itemData = jVar;
        if (jVar.getItemId() > 0) {
            setId(jVar.getItemId());
        }
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, createDefaultBackground());
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        androidx.appcompat.widget.at_renamed.a_renamed(this, jVar.getTooltipText());
        adjustAppearance();
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            android.widget.FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                androidx.appcompat.widget.LinearLayoutCompat.a_renamed aVar = (androidx.appcompat.widget.LinearLayoutCompat.a_renamed) frameLayout.getLayoutParams();
                aVar.width = -1;
                this.actionArea.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        android.widget.FrameLayout frameLayout2 = this.actionArea;
        if (frameLayout2 != null) {
            androidx.appcompat.widget.LinearLayoutCompat.a_renamed aVar2 = (androidx.appcompat.widget.LinearLayoutCompat.a_renamed) frameLayout2.getLayoutParams();
            aVar2.width = -2;
            this.actionArea.setLayoutParams(aVar2);
        }
    }

    public void recycle() {
        android.widget.FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(android.view.View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (android.widget.FrameLayout) ((android.view.ViewStub) findViewById(com.google.android.material.R_renamed.id_renamed.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private android.graphics.drawable.StateListDrawable createDefaultBackground() {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(CHECKED_STATE_SET, new android.graphics.drawable.ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new android.graphics.drawable.ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public androidx.appcompat.view.menu.j_renamed getItemData() {
        return this.itemData;
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setCheckable(boolean z_renamed) {
        refreshDrawableState();
        if (this.checkable != z_renamed) {
            this.checkable = z_renamed;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z_renamed) {
        refreshDrawableState();
        this.textView.setChecked(z_renamed);
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.iconTintList);
            }
            int i_renamed = this.iconSize;
            drawable.setBounds(0, 0, i_renamed, i_renamed);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                this.emptyDrawable = androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(getResources(), com.google.android.material.R_renamed.drawable.navigation_empty_icon, getContext().getTheme());
                android.graphics.drawable.Drawable drawable2 = this.emptyDrawable;
                if (drawable2 != null) {
                    int i2 = this.iconSize;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.emptyDrawable;
        }
        androidx.core.widget.i_renamed.a_renamed(this.textView, drawable, null, null, null);
    }

    public void setIconSize(int i_renamed) {
        this.iconSize = i_renamed;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        androidx.appcompat.view.menu.j_renamed jVar = this.itemData;
        if (jVar != null && jVar.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    void setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = this.iconTintList != null;
        androidx.appcompat.view.menu.j_renamed jVar = this.itemData;
        if (jVar != null) {
            setIcon(jVar.getIcon());
        }
    }

    public void setTextAppearance(int i_renamed) {
        androidx.core.widget.i_renamed.a_renamed(this.textView, i_renamed);
    }

    public void setTextColor(android.content.res.ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z_renamed) {
        this.needsEmptyIcon = z_renamed;
    }

    public void setHorizontalPadding(int i_renamed) {
        setPadding(i_renamed, 0, i_renamed, 0);
    }

    public void setIconPadding(int i_renamed) {
        this.textView.setCompoundDrawablePadding(i_renamed);
    }

    public void setMaxLines(int i_renamed) {
        this.textView.setMaxLines(i_renamed);
    }
}
