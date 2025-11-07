package com.google.android.material.textfield;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends androidx.appcompat.widget.d_renamed {
    private static final int MAX_ITEMS_MEASURED = 15;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private final androidx.appcompat.widget.ae_renamed modalListPopup;
    private final android.graphics.Rect tempRect;

    public MaterialAutoCompleteTextView(android.content.Context context) {
        this(context, null);
    }

    public MaterialAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, 0), attributeSet, i_renamed);
        this.tempRect = new android.graphics.Rect();
        android.content.Context context2 = getContext();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.MaterialAutoCompleteTextView, i_renamed, com.google.android.material.R_renamed.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.MaterialAutoCompleteTextView_android_inputType) && typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) context2.getSystemService("accessibility");
        this.modalListPopup = new androidx.appcompat.widget.ae_renamed(context2);
        this.modalListPopup.a_renamed(true);
        this.modalListPopup.b_renamed(this);
        this.modalListPopup.i_renamed(2);
        this.modalListPopup.a_renamed(getAdapter());
        this.modalListPopup.a_renamed(new android.widget.AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i2, long j_renamed) {
                com.google.android.material.textfield.MaterialAutoCompleteTextView.this.updateText(i2 < 0 ? com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.n_renamed() : com.google.android.material.textfield.MaterialAutoCompleteTextView.this.getAdapter().getItem(i2));
                android.widget.AdapterView.OnItemClickListener onItemClickListener = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i2 < 0) {
                        view = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.q_renamed();
                        i2 = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.o_renamed();
                        j_renamed = com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.p_renamed();
                    }
                    onItemClickListener.onItemClick(com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.b__renamed(), view, i2, j_renamed);
                }
                com.google.android.material.textfield.MaterialAutoCompleteTextView.this.modalListPopup.b_renamed();
            }
        });
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.view.accessibility.AccessibilityManager accessibilityManager;
        if (getInputType() == 0 && (accessibilityManager = this.accessibilityManager) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.modalListPopup.a__renamed();
        } else {
            super.showDropDown();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T_renamed extends android.widget.ListAdapter & android.widget.Filterable> void setAdapter(T_renamed t_renamed) {
        super.setAdapter(t_renamed);
        this.modalListPopup.a_renamed(getAdapter());
    }

    @Override // android.widget.TextView
    public java.lang.CharSequence getHint() {
        com.google.android.material.textfield.TextInputLayout textInputLayoutFindTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (textInputLayoutFindTextInputLayoutAncestor != null && textInputLayoutFindTextInputLayoutAncestor.isProvidingHint()) {
            return textInputLayoutFindTextInputLayoutAncestor.getHint();
        }
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (android.view.View.MeasureSpec.getMode(i_renamed) == Integer.MIN_VALUE) {
            setMeasuredDimension(java.lang.Math.min(java.lang.Math.max(getMeasuredWidth(), measureContentWidth()), android.view.View.MeasureSpec.getSize(i_renamed)), getMeasuredHeight());
        }
    }

    private int measureContentWidth() {
        android.widget.ListAdapter adapter = getAdapter();
        com.google.android.material.textfield.TextInputLayout textInputLayoutFindTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i_renamed = 0;
        if (adapter == null || textInputLayoutFindTextInputLayoutAncestor == null) {
            return 0;
        }
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = java.lang.Math.min(adapter.getCount(), java.lang.Math.max(0, this.modalListPopup.o_renamed()) + 15);
        int iMax = 0;
        android.view.View view = null;
        for (int iMax2 = java.lang.Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i_renamed) {
                view = null;
                i_renamed = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutFindTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = java.lang.Math.max(iMax, view.getMeasuredWidth());
        }
        android.graphics.drawable.Drawable drawableD = this.modalListPopup.d_renamed();
        if (drawableD != null) {
            drawableD.getPadding(this.tempRect);
            iMax += this.tempRect.left + this.tempRect.right;
        }
        return iMax + textInputLayoutFindTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    private com.google.android.material.textfield.TextInputLayout findTextInputLayoutAncestor() {
        for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof com.google.android.material.textfield.TextInputLayout) {
                return (com.google.android.material.textfield.TextInputLayout) parent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T_renamed extends android.widget.ListAdapter & android.widget.Filterable> void updateText(java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        android.widget.ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }
}
