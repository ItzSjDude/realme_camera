package com.google.android.material.button;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends android.widget.LinearLayout {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private static final java.lang.String LOG_TAG = "MaterialButtonToggleGroup";
    private int checkedId;
    private final com.google.android.material.button.MaterialButtonToggleGroup.CheckedStateTracker checkedStateTracker;
    private java.lang.Integer[] childOrder;
    private final java.util.Comparator<com.google.android.material.button.MaterialButton> childOrderComparator;
    private final java.util.LinkedHashSet<com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener> onButtonCheckedListeners;
    private final java.util.List<com.google.android.material.button.MaterialButtonToggleGroup.CornerData> originalCornerData;
    private final com.google.android.material.button.MaterialButtonToggleGroup.PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    public interface OnButtonCheckedListener {
        void onButtonChecked(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i_renamed, boolean z_renamed);
    }

    public MaterialButtonToggleGroup(android.content.Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.originalCornerData = new java.util.ArrayList();
        this.checkedStateTracker = new com.google.android.material.button.MaterialButtonToggleGroup.CheckedStateTracker();
        this.pressedStateTracker = new com.google.android.material.button.MaterialButtonToggleGroup.PressedStateTracker();
        this.onButtonCheckedListeners = new java.util.LinkedHashSet<>();
        this.childOrderComparator = new java.util.Comparator<com.google.android.material.button.MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            public int compare(com.google.android.material.button.MaterialButton materialButton, com.google.android.material.button.MaterialButton materialButton2) {
                int iCompareTo = java.lang.Boolean.valueOf(materialButton.isChecked()).compareTo(java.lang.Boolean.valueOf(materialButton2.isChecked()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = java.lang.Boolean.valueOf(materialButton.isPressed()).compareTo(java.lang.Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : java.lang.Integer.valueOf(com.google.android.material.button.MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(java.lang.Integer.valueOf(com.google.android.material.button.MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
            }
        };
        this.skipCheckedStateTracker = false;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R_renamed.styleable.MaterialButtonToggleGroup, i_renamed, DEF_STYLE_RES, new int[0]);
        setSingleSelection(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayObtainStyledAttributes.recycle();
        androidx.core.h_renamed.v_renamed.b_renamed((android.view.View) this, 1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i_renamed = this.checkedId;
        if (i_renamed != -1) {
            checkForced(i_renamed);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof com.google.android.material.button.MaterialButton)) {
            android.util.Log.e_renamed(LOG_TAG, "Child views must be_renamed of_renamed type MaterialButton.");
            return;
        }
        super.addView(view, i_renamed, layoutParams);
        com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            updateCheckedStates(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
        androidx.core.h_renamed.v_renamed.a_renamed(materialButton, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view2, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view2, dVar);
                dVar.b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(0, 1, com.google.android.material.button.MaterialButtonToggleGroup.this.getIndexWithinVisibleButtons(view2), 1, false, ((com.google.android.material.button.MaterialButton) view2).isChecked()));
            }
        });
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(android.view.View view) {
        super.onViewRemoved(view);
        if (view instanceof com.google.android.material.button.MaterialButton) {
            com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.originalCornerData.remove(iIndexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i_renamed, i2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public java.lang.CharSequence getAccessibilityClassName() {
        return com.google.android.material.button.MaterialButtonToggleGroup.class.getName();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo).a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.b_renamed.a_renamed(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    public void check(int i_renamed) {
        if (i_renamed == this.checkedId) {
            return;
        }
        checkForced(i_renamed);
    }

    public void uncheck(int i_renamed) {
        setCheckedStateForView(i_renamed, false);
        updateCheckedStates(i_renamed, false);
        this.checkedId = -1;
        dispatchOnButtonChecked(i_renamed, false);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i_renamed);
            childButton.setChecked(false);
            dispatchOnButtonChecked(childButton.getId(), false);
        }
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public int getCheckedButtonId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    public java.util.List<java.lang.Integer> getCheckedButtonIds() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i_renamed);
            if (childButton.isChecked()) {
                arrayList.add(java.lang.Integer.valueOf(childButton.getId()));
            }
        }
        return arrayList;
    }

    public void addOnButtonCheckedListener(com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.add(onButtonCheckedListener);
    }

    public void removeOnButtonCheckedListener(com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener onButtonCheckedListener) {
        this.onButtonCheckedListeners.remove(onButtonCheckedListener);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void setSingleSelection(boolean z_renamed) {
        if (this.singleSelection != z_renamed) {
            this.singleSelection = z_renamed;
            clearChecked();
        }
    }

    public void setSelectionRequired(boolean z_renamed) {
        this.selectionRequired = z_renamed;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public void setSingleSelection(int i_renamed) {
        setSingleSelection(getResources().getBoolean(i_renamed));
    }

    private void setCheckedStateForView(int i_renamed, boolean z_renamed) {
        android.view.View viewFindViewById = findViewById(i_renamed);
        if (viewFindViewById instanceof com.google.android.material.button.MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((com.google.android.material.button.MaterialButton) viewFindViewById).setChecked(z_renamed);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setCheckedId(int i_renamed) {
        this.checkedId = i_renamed;
        dispatchOnButtonChecked(i_renamed, true);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i_renamed = firstVisibleChildIndex + 1; i_renamed < getChildCount(); i_renamed++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i_renamed);
            int iMin = java.lang.Math.min(childButton.getStrokeWidth(), getChildButton(i_renamed - 1).getStrokeWidth());
            android.widget.LinearLayout.LayoutParams layoutParamsBuildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                androidx.core.h_renamed.f_renamed.b_renamed(layoutParamsBuildLayoutParams, 0);
                androidx.core.h_renamed.f_renamed.a_renamed(layoutParamsBuildLayoutParams, -iMin);
            } else {
                layoutParamsBuildLayoutParams.bottomMargin = 0;
                layoutParamsBuildLayoutParams.topMargin = -iMin;
            }
            childButton.setLayoutParams(layoutParamsBuildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    private com.google.android.material.button.MaterialButton getChildButton(int i_renamed) {
        return (com.google.android.material.button.MaterialButton) getChildAt(i_renamed);
    }

    private void resetChildMargins(int i_renamed) {
        if (getChildCount() == 0 || i_renamed == -1) {
            return;
        }
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) getChildButton(i_renamed).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            androidx.core.h_renamed.f_renamed.b_renamed(layoutParams, 0);
            androidx.core.h_renamed.f_renamed.a_renamed(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            com.google.android.material.button.MaterialButton childButton = getChildButton(i_renamed);
            if (childButton.getVisibility() != 8) {
                com.google.android.material.shape.ShapeAppearanceModel.Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                updateBuilderWithCornerData(builder, getNewCornerData(i_renamed, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(builder.build());
            }
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            if (isChildVisible(i_renamed)) {
                return i_renamed;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private boolean isChildVisible(int i_renamed) {
        return getChildAt(i_renamed).getVisibility() != 8;
    }

    private int getVisibleButtonCount() {
        int i_renamed = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof com.google.android.material.button.MaterialButton) && isChildVisible(i2)) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndexWithinVisibleButtons(android.view.View view) {
        if (!(view instanceof com.google.android.material.button.MaterialButton)) {
            return -1;
        }
        int i_renamed = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i_renamed;
            }
            if ((getChildAt(i2) instanceof com.google.android.material.button.MaterialButton) && isChildVisible(i2)) {
                i_renamed++;
            }
        }
        return -1;
    }

    private com.google.android.material.button.MaterialButtonToggleGroup.CornerData getNewCornerData(int i_renamed, int i2, int i3) {
        int childCount = getChildCount();
        com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData = this.originalCornerData.get(i_renamed);
        if (childCount == 1) {
            return cornerData;
        }
        boolean z_renamed = getOrientation() == 0;
        if (i_renamed == i2) {
            return z_renamed ? com.google.android.material.button.MaterialButtonToggleGroup.CornerData.start(cornerData, this) : com.google.android.material.button.MaterialButtonToggleGroup.CornerData.top(cornerData);
        }
        if (i_renamed == i3) {
            return z_renamed ? com.google.android.material.button.MaterialButtonToggleGroup.CornerData.end(cornerData, this) : com.google.android.material.button.MaterialButtonToggleGroup.CornerData.bottom(cornerData);
        }
        return null;
    }

    private static void updateBuilderWithCornerData(com.google.android.material.shape.ShapeAppearanceModel.Builder builder, com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
        if (cornerData == null) {
            builder.setAllCornerSizes(0.0f);
        } else {
            builder.setTopLeftCornerSize(cornerData.topLeft).setBottomLeftCornerSize(cornerData.bottomLeft).setTopRightCornerSize(cornerData.topRight).setBottomRightCornerSize(cornerData.bottomRight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckedStates(int i_renamed, boolean z_renamed) {
        java.util.List<java.lang.Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.selectionRequired && checkedButtonIds.isEmpty()) {
            setCheckedStateForView(i_renamed, true);
            this.checkedId = i_renamed;
        } else if (z_renamed && this.singleSelection) {
            checkedButtonIds.remove(java.lang.Integer.valueOf(i_renamed));
            java.util.Iterator<java.lang.Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                setCheckedStateForView(iIntValue, false);
                dispatchOnButtonChecked(iIntValue, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnButtonChecked(int i_renamed, boolean z_renamed) {
        java.util.Iterator<com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i_renamed, z_renamed);
        }
    }

    private void checkForced(int i_renamed) {
        setCheckedStateForView(i_renamed, true);
        updateCheckedStates(i_renamed, true);
        setCheckedId(i_renamed);
    }

    private void setGeneratedIdIfNeeded(com.google.android.material.button.MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(androidx.core.h_renamed.v_renamed.a_renamed());
        }
    }

    private void setupButtonChild(com.google.android.material.button.MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(android.text.TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.checkedStateTracker);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private android.widget.LinearLayout.LayoutParams buildLayoutParams(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return (android.widget.LinearLayout.LayoutParams) layoutParams;
        }
        return new android.widget.LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i_renamed, int i2) {
        java.lang.Integer[] numArr = this.childOrder;
        if (numArr == null || i2 >= numArr.length) {
            android.util.Log.w_renamed(LOG_TAG, "Child order wasn't_renamed updated");
            return i2;
        }
        return numArr[i2].intValue();
    }

    private void updateChildOrder() {
        java.util.TreeMap treeMap = new java.util.TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            treeMap.put(getChildButton(i_renamed), java.lang.Integer.valueOf(i_renamed));
        }
        this.childOrder = (java.lang.Integer[]) treeMap.values().toArray(new java.lang.Integer[0]);
    }

    private class CheckedStateTracker implements com.google.android.material.button.MaterialButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(com.google.android.material.button.MaterialButton materialButton, boolean z_renamed) {
            if (com.google.android.material.button.MaterialButtonToggleGroup.this.skipCheckedStateTracker) {
                return;
            }
            if (com.google.android.material.button.MaterialButtonToggleGroup.this.singleSelection) {
                com.google.android.material.button.MaterialButtonToggleGroup.this.checkedId = z_renamed ? materialButton.getId() : -1;
            }
            com.google.android.material.button.MaterialButtonToggleGroup.this.dispatchOnButtonChecked(materialButton.getId(), z_renamed);
            com.google.android.material.button.MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), z_renamed);
            com.google.android.material.button.MaterialButtonToggleGroup.this.invalidate();
        }
    }

    private class PressedStateTracker implements com.google.android.material.button.MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(com.google.android.material.button.MaterialButton materialButton, boolean z_renamed) {
            com.google.android.material.button.MaterialButtonToggleGroup.this.updateCheckedStates(materialButton.getId(), materialButton.isChecked());
            com.google.android.material.button.MaterialButtonToggleGroup.this.invalidate();
        }
    }

    private static class CornerData {
        private static final com.google.android.material.shape.CornerSize noCorner = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        com.google.android.material.shape.CornerSize bottomLeft;
        com.google.android.material.shape.CornerSize bottomRight;
        com.google.android.material.shape.CornerSize topLeft;
        com.google.android.material.shape.CornerSize topRight;

        CornerData(com.google.android.material.shape.CornerSize cornerSize, com.google.android.material.shape.CornerSize cornerSize2, com.google.android.material.shape.CornerSize cornerSize3, com.google.android.material.shape.CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData start(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData, android.view.View view) {
            return com.google.android.material.internal.ViewUtils.isLayoutRtl(view) ? right(cornerData) : left(cornerData);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData end(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData, android.view.View view) {
            return com.google.android.material.internal.ViewUtils.isLayoutRtl(view) ? left(cornerData) : right(cornerData);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData left(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = cornerData.topLeft;
            com.google.android.material.shape.CornerSize cornerSize2 = cornerData.bottomLeft;
            com.google.android.material.shape.CornerSize cornerSize3 = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData right(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize, cornerData.topRight, cornerData.bottomRight);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData top(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = cornerData.topLeft;
            com.google.android.material.shape.CornerSize cornerSize2 = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerSize2, cornerData.topRight, cornerSize2);
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.CornerData bottom(com.google.android.material.button.MaterialButtonToggleGroup.CornerData cornerData) {
            com.google.android.material.shape.CornerSize cornerSize = noCorner;
            return new com.google.android.material.button.MaterialButtonToggleGroup.CornerData(cornerSize, cornerData.bottomLeft, cornerSize, cornerData.bottomRight);
        }
    }
}
