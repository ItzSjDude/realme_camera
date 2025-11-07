package com.google.android.material.button;

/* loaded from: classes.dex */
public class MaterialButton extends androidx.appcompat.widget.f_renamed implements android.widget.Checkable, com.google.android.material.shape.Shapeable {
    private static final int[] CHECKABLE_STATE_SET = {android.R_renamed.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final java.lang.String LOG_TAG = "MaterialButton";
    private boolean broadcasting;
    private boolean checked;
    private android.graphics.drawable.Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private android.content.res.ColorStateList iconTint;
    private android.graphics.PorterDuff.Mode iconTintMode;
    private final com.google.android.material.button.MaterialButtonHelper materialButtonHelper;
    private final java.util.LinkedHashSet<com.google.android.material.button.MaterialButton.OnCheckedChangeListener> onCheckedChangeListeners;
    private com.google.android.material.button.MaterialButton.OnPressedChangeListener onPressedChangeListenerInternal;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.google.android.material.button.MaterialButton materialButton, boolean z_renamed);
    }

    interface OnPressedChangeListener {
        void onPressedChanged(com.google.android.material.button.MaterialButton materialButton, boolean z_renamed);
    }

    public MaterialButton(android.content.Context context) {
        this(context, null);
    }

    public MaterialButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.materialButtonStyle);
    }

    public MaterialButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.onCheckedChangeListeners = new java.util.LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        android.content.Context context2 = getContext();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.MaterialButton, i_renamed, DEF_STYLE_RES, new int[0]);
        this.iconPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.MaterialButton_iconTintMode, -1), android.graphics.PorterDuff.Mode.SRC_IN);
        this.iconTint = com.google.android.material.resources.MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialButton_iconTint);
        this.icon = com.google.android.material.resources.MaterialResources.getDrawable(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.MaterialButton_icon);
        this.iconGravity = typedArrayObtainStyledAttributes.getInteger(com.google.android.material.R_renamed.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.MaterialButton_iconSize, 0);
        this.materialButtonHelper = new com.google.android.material.button.MaterialButtonHelper(this, com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i_renamed, DEF_STYLE_RES).build());
        this.materialButtonHelper.loadFromAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
    }

    private java.lang.String getA11yClassName() {
        return (isCheckable() ? android.widget.CompoundButton.class : android.widget.Button.class).getName();
    }

    @Override // androidx.appcompat.widget.f_renamed, android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f_renamed, android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.button.MaterialButton.SavedState savedState = new com.google.android.material.button.MaterialButton.SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.button.MaterialButton.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.button.MaterialButton.SavedState savedState = (com.google.android.material.button.MaterialButton.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // androidx.appcompat.widget.f_renamed, androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f_renamed, androidx.core.h_renamed.u_renamed
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f_renamed, androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.appcompat.widget.f_renamed, androidx.core.h_renamed.u_renamed
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public android.content.res.ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public void setBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public android.graphics.PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(i_renamed);
        } else {
            super.setBackgroundColor(i_renamed);
        }
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f_renamed, android.view.View
    public void setBackgroundResource(int i_renamed) {
        setBackgroundDrawable(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    @Override // androidx.appcompat.widget.f_renamed, android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (isUsingOriginalBackground()) {
            if (drawable != getBackground()) {
                android.util.Log.w_renamed(LOG_TAG, "Do not set the background; MaterialButton manages its own background drawable.");
                this.materialButtonHelper.setBackgroundOverwritten();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f_renamed, android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        com.google.android.material.button.MaterialButtonHelper materialButtonHelper;
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        if (android.os.Build.VERSION.SDK_INT != 21 || (materialButtonHelper = this.materialButtonHelper) == null) {
            return;
        }
        materialButtonHelper.updateMaskBounds(i4 - i2, i3 - i_renamed);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        updateIconPosition();
    }

    @Override // androidx.appcompat.widget.f_renamed, android.widget.TextView
    protected void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
        super.onTextChanged(charSequence, i_renamed, i2, i3);
        updateIconPosition();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f_renamed);
        }
    }

    private void updateIconPosition() {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        int i_renamed = this.iconGravity;
        if (i_renamed == 1 || i_renamed == 3) {
            this.iconLeft = 0;
            updateIcon(false);
            return;
        }
        android.text.TextPaint paint = getPaint();
        java.lang.String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int iMin = java.lang.Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
        int intrinsicWidth = this.iconSize;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.icon.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMin) - androidx.core.h_renamed.v_renamed.k_renamed(this)) - intrinsicWidth) - this.iconPadding) - androidx.core.h_renamed.v_renamed.j_renamed(this)) / 2;
        if (isLayoutRTL() != (this.iconGravity == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.iconLeft != measuredWidth) {
            this.iconLeft = measuredWidth;
            updateIcon(false);
        }
    }

    private boolean isLayoutRTL() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
    }

    void setInternalBackground(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i_renamed) {
        if (this.iconPadding != i_renamed) {
            this.iconPadding = i_renamed;
            setCompoundDrawablePadding(i_renamed);
        }
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public void setIconSize(int i_renamed) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("iconSize cannot be_renamed less than 0");
        }
        if (this.iconSize != i_renamed) {
            this.iconSize = i_renamed;
            updateIcon(true);
        }
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
        }
    }

    public void setIconResource(int i_renamed) {
        setIcon(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed) : null);
    }

    public android.graphics.drawable.Drawable getIcon() {
        return this.icon;
    }

    public void setIconTint(android.content.res.ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i_renamed) {
        setIconTint(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.content.res.ColorStateList getIconTint() {
        return this.iconTint;
    }

    public void setIconTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public android.graphics.PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    private void updateIcon(boolean z_renamed) {
        android.graphics.drawable.Drawable drawable = this.icon;
        boolean z2 = false;
        if (drawable != null) {
            this.icon = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.icon, this.iconTint);
            android.graphics.PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(this.icon, mode);
            }
            int intrinsicWidth = this.iconSize;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.icon.getIntrinsicWidth();
            }
            int intrinsicHeight = this.iconSize;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.icon.getIntrinsicHeight();
            }
            android.graphics.drawable.Drawable drawable2 = this.icon;
            int i_renamed = this.iconLeft;
            drawable2.setBounds(i_renamed, 0, intrinsicWidth + i_renamed, intrinsicHeight);
        }
        int i2 = this.iconGravity;
        boolean z3 = i2 == 1 || i2 == 2;
        if (z_renamed) {
            resetIconDrawable(z3);
            return;
        }
        android.graphics.drawable.Drawable[] drawableArrB = androidx.core.widget.i_renamed.b_renamed(this);
        android.graphics.drawable.Drawable drawable3 = drawableArrB[0];
        android.graphics.drawable.Drawable drawable4 = drawableArrB[2];
        if ((z3 && drawable3 != this.icon) || (!z3 && drawable4 != this.icon)) {
            z2 = true;
        }
        if (z2) {
            resetIconDrawable(z3);
        }
    }

    private void resetIconDrawable(boolean z_renamed) {
        if (z_renamed) {
            androidx.core.widget.i_renamed.a_renamed(this, this.icon, null, null, null);
        } else {
            androidx.core.widget.i_renamed.a_renamed(this, null, null, this.icon, null);
        }
    }

    public void setRippleColor(android.content.res.ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i_renamed) {
        if (isUsingOriginalBackground()) {
            setRippleColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
        }
    }

    public android.content.res.ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }
        return null;
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(int i_renamed) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
        }
    }

    public android.content.res.ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }
        return null;
    }

    public void setStrokeWidth(int i_renamed) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i_renamed);
        }
    }

    public void setStrokeWidthResource(int i_renamed) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i_renamed));
        }
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }
        return 0;
    }

    public void setCornerRadius(int i_renamed) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i_renamed);
        }
    }

    public void setCornerRadiusResource(int i_renamed) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i_renamed));
        }
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public void setIconGravity(int i_renamed) {
        if (this.iconGravity != i_renamed) {
            this.iconGravity = i_renamed;
            updateIconPosition();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 2);
        if (isCheckable()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    public void addOnCheckedChangeListener(com.google.android.material.button.MaterialButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void removeOnCheckedChangeListener(com.google.android.material.button.MaterialButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        if (isCheckable() && isEnabled() && this.checked != z_renamed) {
            this.checked = z_renamed;
            refreshDrawableState();
            if (this.broadcasting) {
                return;
            }
            this.broadcasting = true;
            java.util.Iterator<com.google.android.material.button.MaterialButton.OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, this.checked);
            }
            this.broadcasting = false;
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public boolean isCheckable() {
        com.google.android.material.button.MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return materialButtonHelper != null && materialButtonHelper.isCheckable();
    }

    public void setCheckable(boolean z_renamed) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z_renamed);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new java.lang.IllegalStateException("Attempted to set ShapeAppearanceModel on_renamed a_renamed MaterialButton which has an_renamed overwritten background.");
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }
        throw new java.lang.IllegalStateException("Attempted to get ShapeAppearanceModel from a_renamed MaterialButton which has an_renamed overwritten background.");
    }

    void setOnPressedChangeListenerInternal(com.google.android.material.button.MaterialButton.OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z_renamed) {
        com.google.android.material.button.MaterialButton.OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z_renamed);
        }
        super.setPressed(z_renamed);
    }

    private boolean isUsingOriginalBackground() {
        com.google.android.material.button.MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return (materialButtonHelper == null || materialButtonHelper.isBackgroundOverwritten()) ? false : true;
    }

    void setShouldDrawSurfaceColorStroke(boolean z_renamed) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z_renamed);
        }
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.button.MaterialButton.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.button.MaterialButton.SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.button.MaterialButton.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.button.MaterialButton.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.button.MaterialButton.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.button.MaterialButton.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.button.MaterialButton.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.button.MaterialButton.SavedState[i_renamed];
            }
        };
        boolean checked;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(android.os.Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }
    }
}
