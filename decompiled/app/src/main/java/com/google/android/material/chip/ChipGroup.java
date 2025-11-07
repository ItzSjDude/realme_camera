package com.google.android.material.chip;

/* loaded from: classes.dex */
public class ChipGroup extends com.google.android.material.internal.FlowLayout {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_ChipGroup;
    private int checkedId;
    private final com.google.android.material.chip.ChipGroup.CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener;
    private com.google.android.material.chip.ChipGroup.PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean selectionRequired;
    private boolean singleSelection;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.google.android.material.chip.ChipGroup chipGroup, int i_renamed);
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i_renamed, int i2) {
            super(i_renamed, i2);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ChipGroup(android.content.Context context) {
        this(context, null);
    }

    public ChipGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.chipGroupStyle);
    }

    public ChipGroup(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.checkedStateTracker = new com.google.android.material.chip.ChipGroup.CheckedStateTracker();
        this.passThroughListener = new com.google.android.material.chip.ChipGroup.PassThroughHierarchyChangeListener();
        this.checkedId = -1;
        this.protectFromCheckedChange = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R_renamed.styleable.ChipGroup, i_renamed, DEF_STYLE_RES, new int[0]);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.ChipGroup_selectionRequired, false));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.checkedId = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        super.setOnHierarchyChangeListener(this.passThroughListener);
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo).a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(getRowCount(), isSingleLine() ? getChipCount() : -1, false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new com.google.android.material.chip.ChipGroup.LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof com.google.android.material.chip.ChipGroup.LayoutParams);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i_renamed = this.checkedId;
        if (i_renamed != -1) {
            setCheckedStateForView(i_renamed, true);
            setCheckedId(this.checkedId);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view instanceof com.google.android.material.chip.Chip) {
            com.google.android.material.chip.Chip chip = (com.google.android.material.chip.Chip) view;
            if (chip.isChecked()) {
                int i2 = this.checkedId;
                if (i2 != -1 && this.singleSelection) {
                    setCheckedStateForView(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i_renamed, layoutParams);
    }

    @java.lang.Deprecated
    public void setDividerDrawableHorizontal(android.graphics.drawable.Drawable drawable) {
        throw new java.lang.UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as_renamed spacing.");
    }

    @java.lang.Deprecated
    public void setDividerDrawableVertical(android.graphics.drawable.Drawable drawable) {
        throw new java.lang.UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as_renamed spacing.");
    }

    @java.lang.Deprecated
    public void setShowDividerHorizontal(int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as_renamed spacing.");
    }

    @java.lang.Deprecated
    public void setShowDividerVertical(int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as_renamed spacing.");
    }

    @java.lang.Deprecated
    public void setFlexWrap(int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a_renamed singleLine attribute instead.");
    }

    public void check(int i_renamed) {
        int i2 = this.checkedId;
        if (i_renamed == i2) {
            return;
        }
        if (i2 != -1 && this.singleSelection) {
            setCheckedStateForView(i2, false);
        }
        if (i_renamed != -1) {
            setCheckedStateForView(i_renamed, true);
        }
        setCheckedId(i_renamed);
    }

    public int getCheckedChipId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    public java.util.List<java.lang.Integer> getCheckedChipIds() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if ((childAt instanceof com.google.android.material.chip.Chip) && ((com.google.android.material.chip.Chip) childAt).isChecked()) {
                arrayList.add(java.lang.Integer.valueOf(childAt.getId()));
                if (this.singleSelection) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt instanceof com.google.android.material.chip.Chip) {
                ((com.google.android.material.chip.Chip) childAt).setChecked(false);
            }
        }
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    public void setOnCheckedChangeListener(com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i_renamed) {
        setCheckedId(i_renamed, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i_renamed, boolean z_renamed) {
        this.checkedId = i_renamed;
        com.google.android.material.chip.ChipGroup.OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null && this.singleSelection && z_renamed) {
            onCheckedChangeListener.onCheckedChanged(this, i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedStateForView(int i_renamed, boolean z_renamed) {
        android.view.View viewFindViewById = findViewById(i_renamed);
        if (viewFindViewById instanceof com.google.android.material.chip.Chip) {
            this.protectFromCheckedChange = true;
            ((com.google.android.material.chip.Chip) viewFindViewById).setChecked(z_renamed);
            this.protectFromCheckedChange = false;
        }
    }

    private int getChipCount() {
        int i_renamed = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof com.google.android.material.chip.Chip) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    int getIndexOfChip(android.view.View view) {
        if (!(view instanceof com.google.android.material.chip.Chip)) {
            return -1;
        }
        int i_renamed = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof com.google.android.material.chip.Chip) {
                if (((com.google.android.material.chip.Chip) getChildAt(i2)) == view) {
                    return i_renamed;
                }
                i_renamed++;
            }
        }
        return -1;
    }

    public void setChipSpacing(int i_renamed) {
        setChipSpacingHorizontal(i_renamed);
        setChipSpacingVertical(i_renamed);
    }

    public void setChipSpacingResource(int i_renamed) {
        setChipSpacing(getResources().getDimensionPixelOffset(i_renamed));
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public void setChipSpacingHorizontal(int i_renamed) {
        if (this.chipSpacingHorizontal != i_renamed) {
            this.chipSpacingHorizontal = i_renamed;
            setItemSpacing(i_renamed);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i_renamed) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i_renamed));
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public void setChipSpacingVertical(int i_renamed) {
        if (this.chipSpacingVertical != i_renamed) {
            this.chipSpacingVertical = i_renamed;
            setLineSpacing(i_renamed);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i_renamed) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i_renamed));
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z_renamed) {
        super.setSingleLine(z_renamed);
    }

    public void setSingleLine(int i_renamed) {
        setSingleLine(getResources().getBoolean(i_renamed));
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void setSingleSelection(boolean z_renamed) {
        if (this.singleSelection != z_renamed) {
            this.singleSelection = z_renamed;
            clearCheck();
        }
    }

    public void setSingleSelection(int i_renamed) {
        setSingleSelection(getResources().getBoolean(i_renamed));
    }

    public void setSelectionRequired(boolean z_renamed) {
        this.selectionRequired = z_renamed;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    private class CheckedStateTracker implements android.widget.CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z_renamed) {
            if (com.google.android.material.chip.ChipGroup.this.protectFromCheckedChange) {
                return;
            }
            if (com.google.android.material.chip.ChipGroup.this.getCheckedChipIds().isEmpty() && com.google.android.material.chip.ChipGroup.this.selectionRequired) {
                com.google.android.material.chip.ChipGroup.this.setCheckedStateForView(compoundButton.getId(), true);
                com.google.android.material.chip.ChipGroup.this.setCheckedId(compoundButton.getId(), false);
                return;
            }
            int id_renamed = compoundButton.getId();
            if (z_renamed) {
                if (com.google.android.material.chip.ChipGroup.this.checkedId != -1 && com.google.android.material.chip.ChipGroup.this.checkedId != id_renamed && com.google.android.material.chip.ChipGroup.this.singleSelection) {
                    com.google.android.material.chip.ChipGroup chipGroup = com.google.android.material.chip.ChipGroup.this;
                    chipGroup.setCheckedStateForView(chipGroup.checkedId, false);
                }
                com.google.android.material.chip.ChipGroup.this.setCheckedId(id_renamed);
                return;
            }
            if (com.google.android.material.chip.ChipGroup.this.checkedId == id_renamed) {
                com.google.android.material.chip.ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    private class PassThroughHierarchyChangeListener implements android.view.ViewGroup.OnHierarchyChangeListener {
        private android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(android.view.View view, android.view.View view2) {
            int iHashCode;
            if (view == com.google.android.material.chip.ChipGroup.this && (view2 instanceof com.google.android.material.chip.Chip)) {
                if (view2.getId() == -1) {
                    if (android.os.Build.VERSION.SDK_INT >= 17) {
                        iHashCode = android.view.View.generateViewId();
                    } else {
                        iHashCode = view2.hashCode();
                    }
                    view2.setId(iHashCode);
                }
                ((com.google.android.material.chip.Chip) view2).setOnCheckedChangeListenerInternal(com.google.android.material.chip.ChipGroup.this.checkedStateTracker);
            }
            android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(android.view.View view, android.view.View view2) {
            if (view == com.google.android.material.chip.ChipGroup.this && (view2 instanceof com.google.android.material.chip.Chip)) {
                ((com.google.android.material.chip.Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            android.view.ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
