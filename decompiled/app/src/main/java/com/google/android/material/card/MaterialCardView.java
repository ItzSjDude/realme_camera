package com.google.android.material.card;

/* loaded from: classes.dex */
public class MaterialCardView extends androidx.cardview.a_renamed.a_renamed implements android.widget.Checkable, com.google.android.material.shape.Shapeable {
    private static final java.lang.String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final java.lang.String LOG_TAG = "MaterialCardView";
    private final com.google.android.material.card.MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private com.google.android.material.card.MaterialCardView.OnCheckedChangeListener onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {android.R_renamed.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {android.R_renamed.attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {com.google.android.material.R_renamed.attr.state_dragged};
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_CardView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(com.google.android.material.card.MaterialCardView materialCardView, boolean z_renamed);
    }

    public MaterialCardView(android.content.Context context) {
        this(context, null);
    }

    public MaterialCardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.materialCardViewStyle);
    }

    public MaterialCardView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R_renamed.styleable.MaterialCardView, i_renamed, DEF_STYLE_RES, new int[0]);
        this.cardViewHelper = new com.google.android.material.card.MaterialCardViewHelper(this, attributeSet, i_renamed, DEF_STYLE_RES);
        this.cardViewHelper.setCardBackgroundColor(super.getCardBackgroundColor());
        this.cardViewHelper.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.cardViewHelper.loadFromAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.cardview.a_renamed.a_renamed, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        this.cardViewHelper.onMeasure(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setStrokeColor(int i_renamed) {
        this.cardViewHelper.setStrokeColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        this.cardViewHelper.setStrokeColor(colorStateList);
    }

    @java.lang.Deprecated
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public android.content.res.ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    public void setStrokeWidth(int i_renamed) {
        this.cardViewHelper.setStrokeWidth(i_renamed);
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setRadius(float f_renamed) {
        super.setRadius(f_renamed);
        this.cardViewHelper.setCornerRadius(f_renamed);
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public void setProgress(float f_renamed) {
        this.cardViewHelper.setProgress(f_renamed);
    }

    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setContentPadding(int i_renamed, int i2, int i3, int i4) {
        this.cardViewHelper.setUserContentPadding(i_renamed, i2, i3, i4);
    }

    void setAncestorContentPadding(int i_renamed, int i2, int i3, int i4) {
        super.setContentPadding(i_renamed, i2, i3, i4);
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setCardBackgroundColor(int i_renamed) {
        this.cardViewHelper.setCardBackgroundColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setCardBackgroundColor(android.content.res.ColorStateList colorStateList) {
        this.cardViewHelper.setCardBackgroundColor(colorStateList);
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public android.content.res.ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    public void setCardForegroundColor(android.content.res.ColorStateList colorStateList) {
        this.cardViewHelper.setCardForegroundColor(colorStateList);
    }

    public android.content.res.ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    @Override // android.view.View
    public void setClickable(boolean z_renamed) {
        super.setClickable(z_renamed);
        this.cardViewHelper.updateClickable();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setCardElevation(float f_renamed) {
        super.setCardElevation(f_renamed);
        this.cardViewHelper.updateElevation();
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setMaxCardElevation(float f_renamed) {
        super.setMaxCardElevation(f_renamed);
        this.cardViewHelper.updateInsets();
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setUseCompatPadding(boolean z_renamed) {
        super.setUseCompatPadding(z_renamed);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    @Override // androidx.cardview.a_renamed.a_renamed
    public void setPreventCornerOverlap(boolean z_renamed) {
        super.setPreventCornerOverlap(z_renamed);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.isBackgroundOverwritten()) {
                android.util.Log.i_renamed(LOG_TAG, "Setting a_renamed custom background is_renamed not supported.");
                this.cardViewHelper.setBackgroundOverwritten(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        if (this.checked != z_renamed) {
            toggle();
        }
    }

    public void setDragged(boolean z_renamed) {
        if (this.dragged != z_renamed) {
            this.dragged = z_renamed;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    public boolean isDragged() {
        return this.dragged;
    }

    public boolean isCheckable() {
        com.google.android.material.card.MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        return materialCardViewHelper != null && materialCardViewHelper.isCheckable();
    }

    public void setCheckable(boolean z_renamed) {
        this.cardViewHelper.setCheckable(z_renamed);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            com.google.android.material.card.MaterialCardView.OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 3);
        if (isCheckable()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            mergeDrawableStates(iArrOnCreateDrawableState, DRAGGED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    public void setOnCheckedChangeListener(com.google.android.material.card.MaterialCardView.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public void setRippleColor(android.content.res.ColorStateList colorStateList) {
        this.cardViewHelper.setRippleColor(colorStateList);
    }

    public void setRippleColorResource(int i_renamed) {
        this.cardViewHelper.setRippleColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.content.res.ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    public android.graphics.drawable.Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    public void setCheckedIconResource(int i_renamed) {
        this.cardViewHelper.setCheckedIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public void setCheckedIcon(android.graphics.drawable.Drawable drawable) {
        this.cardViewHelper.setCheckedIcon(drawable);
    }

    public android.content.res.ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    public void setCheckedIconTint(android.content.res.ColorStateList colorStateList) {
        this.cardViewHelper.setCheckedIconTint(colorStateList);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.cardViewHelper.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    private void forceRippleRedrawIfNeeded() {
        if (android.os.Build.VERSION.SDK_INT > 26) {
            this.cardViewHelper.forceRippleRedraw();
        }
    }
}
