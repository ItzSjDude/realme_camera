package com.google.android.material.chip;

/* loaded from: classes.dex */
public class Chip extends androidx.appcompat.widget.AppCompatCheckBox implements com.google.android.material.chip.ChipDrawable.Delegate, com.google.android.material.shape.Shapeable {
    private static final java.lang.String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final java.lang.String COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.CompoundButton";
    private static final java.lang.String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final java.lang.String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final java.lang.String TAG = "Chip";
    private com.google.android.material.chip.ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final com.google.android.material.resources.TextAppearanceFontCallback fontCallback;
    private android.graphics.drawable.InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    private int minTouchTargetSize;
    private android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    private android.view.View.OnClickListener onCloseIconClickListener;
    private final android.graphics.Rect rect;
    private final android.graphics.RectF rectF;
    private android.graphics.drawable.RippleDrawable ripple;
    private final com.google.android.material.chip.Chip.ChipTouchHelper touchHelper;
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Chip_Action;
    private static final android.graphics.Rect EMPTY_BOUNDS = new android.graphics.Rect();
    private static final int[] SELECTED_STATE = {android.R_renamed.attr.state_selected};
    private static final int[] CHECKABLE_STATE_SET = {android.R_renamed.attr.state_checkable};

    public Chip(android.content.Context context) {
        this(context, null);
    }

    public Chip(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R_renamed.attr.chipStyle);
    }

    public Chip(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.rect = new android.graphics.Rect();
        this.rectF = new android.graphics.RectF();
        this.fontCallback = new com.google.android.material.resources.TextAppearanceFontCallback() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i2) {
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(android.graphics.Typeface typeface, boolean z_renamed) {
                com.google.android.material.chip.Chip chip = com.google.android.material.chip.Chip.this;
                chip.setText(chip.chipDrawable.shouldDrawText() ? com.google.android.material.chip.Chip.this.chipDrawable.getText() : com.google.android.material.chip.Chip.this.getText());
                com.google.android.material.chip.Chip.this.requestLayout();
                com.google.android.material.chip.Chip.this.invalidate();
            }
        };
        android.content.Context context2 = getContext();
        validateAttributes(attributeSet);
        com.google.android.material.chip.ChipDrawable chipDrawableCreateFromAttributes = com.google.android.material.chip.ChipDrawable.createFromAttributes(context2, attributeSet, i_renamed, DEF_STYLE_RES);
        initMinTouchTarget(context2, attributeSet, i_renamed);
        setChipDrawable(chipDrawableCreateFromAttributes);
        chipDrawableCreateFromAttributes.setElevation(androidx.core.h_renamed.v_renamed.o_renamed(this));
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R_renamed.styleable.Chip, i_renamed, DEF_STYLE_RES, new int[0]);
        if (android.os.Build.VERSION.SDK_INT < 23) {
            setTextColor(com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes.recycle();
        this.touchHelper = new com.google.android.material.chip.Chip.ChipTouchHelper(this);
        updateAccessibilityDelegate();
        if (!zHasValue) {
            initOutlineProvider();
        }
        setChecked(this.deferredCheckedValue);
        setText(chipDrawableCreateFromAttributes.getText());
        setEllipsize(chipDrawableCreateFromAttributes.getEllipsize());
        setIncludeFontPadding(false);
        updateTextPaintDrawState();
        if (!this.chipDrawable.shouldDrawText()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        updatePaddingInternal();
        if (shouldEnsureMinTouchTargetSize()) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = androidx.core.h_renamed.v_renamed.g_renamed(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // android.view.View
    public void setElevation(float f_renamed) {
        super.setElevation(f_renamed);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setElevation(f_renamed);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isCheckable() || isClickable()) {
            accessibilityNodeInfo.setClassName(isCheckable() ? COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME : BUTTON_ACCESSIBILITY_CLASS_NAME);
        } else {
            accessibilityNodeInfo.setClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        }
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof com.google.android.material.chip.ChipGroup) {
            com.google.android.material.chip.ChipGroup chipGroup = (com.google.android.material.chip.ChipGroup) getParent();
            androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo).b_renamed(androidx.core.h_renamed.a_renamed.d_renamed.c_renamed.a_renamed(chipGroup.getRowIndex(this), 1, chipGroup.isSingleLine() ? chipGroup.getIndexOfChip(this) : -1, 1, false, isChecked()));
        }
    }

    private void updateAccessibilityDelegate() {
        if (hasCloseIcon() && isCloseIconVisible() && this.onCloseIconClickListener != null) {
            androidx.core.h_renamed.v_renamed.a_renamed(this, this.touchHelper);
        } else {
            androidx.core.h_renamed.v_renamed.a_renamed(this, (androidx.core.h_renamed.a_renamed) null);
        }
    }

    private void initMinTouchTarget(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R_renamed.styleable.Chip, i_renamed, DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = (int) java.lang.Math.ceil(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipMinTouchTargetSize, (float) java.lang.Math.ceil(com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void updatePaddingInternal() {
        com.google.android.material.chip.ChipDrawable chipDrawable;
        if (android.text.TextUtils.isEmpty(getText()) || (chipDrawable = this.chipDrawable) == null) {
            return;
        }
        int chipEndPadding = (int) (chipDrawable.getChipEndPadding() + this.chipDrawable.getTextEndPadding() + this.chipDrawable.calculateCloseIconWidth());
        int chipStartPadding = (int) (this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.calculateChipIconWidth());
        if (this.insetBackgroundDrawable != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.insetBackgroundDrawable.getPadding(rect);
            chipStartPadding += rect.left;
            chipEndPadding += rect.right;
        }
        androidx.core.h_renamed.v_renamed.b_renamed(this, chipStartPadding, getPaddingTop(), chipEndPadding, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    @android.annotation.TargetApi(17)
    public void onRtlPropertiesChanged(int i_renamed) {
        super.onRtlPropertiesChanged(i_renamed);
        if (this.lastLayoutDirection != i_renamed) {
            this.lastLayoutDirection = i_renamed;
            updatePaddingInternal();
        }
    }

    private void validateAttributes(android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "background") != null) {
            android.util.Log.w_renamed(TAG, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableLeft") != null) {
            throw new java.lang.UnsupportedOperationException("Please set left drawable using R_renamed.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableStart") != null) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableEnd") != null) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_ANDROID, "drawableRight") != null) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue(NAMESPACE_ANDROID, "singleLine", true) || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "lines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "maxLines", 1) != 1) {
            throw new java.lang.UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue(NAMESPACE_ANDROID, "gravity", 8388627) != 8388627) {
            android.util.Log.w_renamed(TAG, "Chip text must be_renamed vertically center and start aligned");
        }
    }

    private void initOutlineProvider() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new android.view.ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                @android.annotation.TargetApi(21)
                public void getOutline(android.view.View view, android.graphics.Outline outline) {
                    if (com.google.android.material.chip.Chip.this.chipDrawable != null) {
                        com.google.android.material.chip.Chip.this.chipDrawable.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
    }

    public android.graphics.drawable.Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public void setChipDrawable(com.google.android.material.chip.ChipDrawable chipDrawable) {
        com.google.android.material.chip.ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 != chipDrawable) {
            unapplyChipDrawable(chipDrawable2);
            this.chipDrawable = chipDrawable;
            this.chipDrawable.setShouldDrawText(false);
            applyChipDrawable(this.chipDrawable);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    private void updateBackgroundDrawable() {
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            updateFrameworkRippleBackground();
            return;
        }
        this.chipDrawable.setUseCompatRipple(true);
        androidx.core.h_renamed.v_renamed.a_renamed(this, getBackgroundDrawable());
        updatePaddingInternal();
        ensureChipDrawableHasCallback();
    }

    private void ensureChipDrawableHasCallback() {
        if (getBackgroundDrawable() == this.insetBackgroundDrawable && this.chipDrawable.getCallback() == null) {
            this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        }
    }

    public android.graphics.drawable.Drawable getBackgroundDrawable() {
        android.graphics.drawable.InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        return insetDrawable == null ? this.chipDrawable : insetDrawable;
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.ripple);
        updatePaddingInternal();
    }

    private void unapplyChipDrawable(com.google.android.material.chip.ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.setDelegate(null);
        }
    }

    private void applyChipDrawable(com.google.android.material.chip.ChipDrawable chipDrawable) {
        chipDrawable.setDelegate(this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 2);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, SELECTED_STATE);
        }
        if (isCheckable()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView
    public void setGravity(int i_renamed) {
        if (i_renamed != 8388627) {
            android.util.Log.w_renamed(TAG, "Chip text must be_renamed vertically center and start aligned");
        } else {
            super.setGravity(i_renamed);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        android.util.Log.w_renamed(TAG, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        android.util.Log.w_renamed(TAG, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        android.util.Log.w_renamed(TAG, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i_renamed) {
        android.util.Log.w_renamed(TAG, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
            android.util.Log.w_renamed(TAG, "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.ripple) {
            android.util.Log.w_renamed(TAG, "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        if (drawable != null) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i_renamed, int i2, int i3, int i4) {
        if (i_renamed != 0) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i_renamed, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        if (drawable != null) {
            throw new java.lang.UnsupportedOperationException("Please set left drawable using R_renamed.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new java.lang.UnsupportedOperationException("Please set right drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        if (drawable != null) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i_renamed, int i2, int i3, int i4) {
        if (i_renamed != 0) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i_renamed, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        if (drawable != null) {
            throw new java.lang.UnsupportedOperationException("Please set start drawable using R_renamed.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new java.lang.UnsupportedOperationException("Please set end drawable using R_renamed.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public android.text.TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getEllipsize();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable == null) {
            return;
        }
        if (truncateAt == android.text.TextUtils.TruncateAt.MARQUEE) {
            throw new java.lang.UnsupportedOperationException("Text within a_renamed chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setEllipsize(truncateAt);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z_renamed) {
        if (!z_renamed) {
            throw new java.lang.UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z_renamed);
    }

    @Override // android.widget.TextView
    public void setLines(int i_renamed) {
        if (i_renamed > 1) {
            throw new java.lang.UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i_renamed);
    }

    @Override // android.widget.TextView
    public void setMinLines(int i_renamed) {
        if (i_renamed > 1) {
            throw new java.lang.UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i_renamed);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i_renamed) {
        if (i_renamed > 1) {
            throw new java.lang.UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i_renamed);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i_renamed) {
        super.setMaxWidth(i_renamed);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setMaxWidth(i_renamed);
        }
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            this.deferredCheckedValue = z_renamed;
            return;
        }
        if (chipDrawable.isCheckable()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z_renamed);
            if (zIsChecked == z_renamed || (onCheckedChangeListener = this.onCheckedChangeListenerInternal) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z_renamed);
        }
    }

    void setOnCheckedChangeListenerInternal(android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListenerInternal = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(android.view.View.OnClickListener onClickListener) {
        this.onCloseIconClickListener = onClickListener;
        updateAccessibilityDelegate();
    }

    public boolean performCloseIconClick() {
        boolean z_renamed = false;
        playSoundEffect(0);
        android.view.View.OnClickListener onClickListener = this.onCloseIconClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z_renamed = true;
        }
        this.touchHelper.sendEventForVirtualView(1, 1);
        return z_renamed;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.closeIconPressed
            if (r0 == 0) goto L34
            r5.performCloseIconClick()
            r0 = r3
            goto L35
        L34:
            r0 = r2
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = r3
            goto L41
        L40:
            r0 = r2
        L41:
            if (r0 != 0) goto L49
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L4a
        L49:
            r2 = r3
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @android.annotation.SuppressLint({"PrivateApi"})
    private boolean handleAccessibilityExit(android.view.MotionEvent motionEvent) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (motionEvent.getAction() == 10) {
            try {
                java.lang.reflect.Field declaredField = androidx.customview.a_renamed.a_renamed.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((java.lang.Integer) declaredField.get(this.touchHelper)).intValue() != Integer.MIN_VALUE) {
                    java.lang.reflect.Method declaredMethod = androidx.customview.a_renamed.a_renamed.class.getDeclaredMethod("updateHoveredVirtualView", java.lang.Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.touchHelper, Integer.MIN_VALUE);
                    return true;
                }
            } catch (java.lang.IllegalAccessException e_renamed) {
                android.util.Log.e_renamed(TAG, "Unable to send Accessibility Exit event", e_renamed);
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e_renamed(TAG, "Unable to send Accessibility Exit event", e2);
            } catch (java.lang.NoSuchMethodException e3) {
                android.util.Log.e_renamed(TAG, "Unable to send Accessibility Exit event", e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                android.util.Log.e_renamed(TAG, "Unable to send Accessibility Exit event", e4);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(android.view.MotionEvent motionEvent) {
        return handleAccessibilityExit(motionEvent) || this.touchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        if (!this.touchHelper.dispatchKeyEvent(keyEvent) || this.touchHelper.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z_renamed, int i_renamed, android.graphics.Rect rect) {
        super.onFocusChanged(z_renamed, i_renamed, rect);
        this.touchHelper.onFocusChanged(z_renamed, i_renamed, rect);
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        if (this.touchHelper.getKeyboardFocusedVirtualViewId() == 1 || this.touchHelper.getAccessibilityFocusedVirtualViewId() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    private void setCloseIconPressed(boolean z_renamed) {
        if (this.closeIconPressed != z_renamed) {
            this.closeIconPressed = z_renamed;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z_renamed) {
        if (this.closeIconHovered != z_renamed) {
            this.closeIconHovered = z_renamed;
            refreshDrawableState();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if ((chipDrawable == null || !chipDrawable.isCloseIconStateful()) ? false : this.chipDrawable.setCloseIconState(createCloseIconDrawableState())) {
            invalidate();
        }
    }

    private int[] createCloseIconDrawableState() {
        int i_renamed = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.closeIconFocused) {
            i2++;
        }
        if (this.closeIconHovered) {
            i2++;
        }
        if (this.closeIconPressed) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i_renamed = 1;
        }
        if (this.closeIconFocused) {
            iArr[i_renamed] = 16842908;
            i_renamed++;
        }
        if (this.closeIconHovered) {
            iArr[i_renamed] = 16843623;
            i_renamed++;
        }
        if (this.closeIconPressed) {
            iArr[i_renamed] = 16842919;
            i_renamed++;
        }
        if (isChecked()) {
            iArr[i_renamed] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasCloseIcon() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        return (chipDrawable == null || chipDrawable.getCloseIcon() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if (hasCloseIcon()) {
            this.chipDrawable.getCloseIconTouchBounds(this.rectF);
        }
        return this.rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Rect getCloseIconTouchBoundsInt() {
        android.graphics.RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.rect;
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @android.annotation.TargetApi(24)
    public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent motionEvent, int i_renamed) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return android.view.PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    private class ChipTouchHelper extends androidx.customview.a_renamed.a_renamed {
        ChipTouchHelper(com.google.android.material.chip.Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected int getVirtualViewAt(float f_renamed, float f2) {
            return (com.google.android.material.chip.Chip.this.hasCloseIcon() && com.google.android.material.chip.Chip.this.getCloseIconTouchBounds().contains(f_renamed, f2)) ? 1 : 0;
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void getVisibleVirtualViews(java.util.List<java.lang.Integer> list) {
            list.add(0);
            if (com.google.android.material.chip.Chip.this.hasCloseIcon() && com.google.android.material.chip.Chip.this.isCloseIconVisible() && com.google.android.material.chip.Chip.this.onCloseIconClickListener != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onVirtualViewKeyboardFocusChanged(int i_renamed, boolean z_renamed) {
            if (i_renamed == 1) {
                com.google.android.material.chip.Chip.this.closeIconFocused = z_renamed;
                com.google.android.material.chip.Chip.this.refreshDrawableState();
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onPopulateNodeForVirtualView(int i_renamed, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            if (i_renamed == 1) {
                java.lang.CharSequence closeIconContentDescription = com.google.android.material.chip.Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    dVar.e_renamed(closeIconContentDescription);
                } else {
                    java.lang.CharSequence text = com.google.android.material.chip.Chip.this.getText();
                    android.content.Context context = com.google.android.material.chip.Chip.this.getContext();
                    int i2 = com.google.android.material.R_renamed.string.mtrl_chip_close_icon_content_description;
                    java.lang.Object[] objArr = new java.lang.Object[1];
                    if (android.text.TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    dVar.e_renamed(context.getString(i2, objArr).trim());
                }
                dVar.b_renamed(com.google.android.material.chip.Chip.this.getCloseIconTouchBoundsInt());
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.e_renamed);
                dVar.h_renamed(com.google.android.material.chip.Chip.this.isEnabled());
                return;
            }
            dVar.e_renamed("");
            dVar.b_renamed(com.google.android.material.chip.Chip.EMPTY_BOUNDS);
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected void onPopulateNodeForHost(androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            dVar.a_renamed(com.google.android.material.chip.Chip.this.isCheckable());
            dVar.g_renamed(com.google.android.material.chip.Chip.this.isClickable());
            if (com.google.android.material.chip.Chip.this.isCheckable() || com.google.android.material.chip.Chip.this.isClickable()) {
                dVar.b_renamed((java.lang.CharSequence) (com.google.android.material.chip.Chip.this.isCheckable() ? com.google.android.material.chip.Chip.COMPOUND_BUTTON_ACCESSIBILITY_CLASS_NAME : com.google.android.material.chip.Chip.BUTTON_ACCESSIBILITY_CLASS_NAME));
            } else {
                dVar.b_renamed(com.google.android.material.chip.Chip.GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
            }
            java.lang.CharSequence text = com.google.android.material.chip.Chip.this.getText();
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                dVar.c_renamed(text);
            } else {
                dVar.e_renamed(text);
            }
        }

        @Override // androidx.customview.a_renamed.a_renamed
        protected boolean onPerformActionForVirtualView(int i_renamed, int i2, android.os.Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i_renamed == 0) {
                return com.google.android.material.chip.Chip.this.performClick();
            }
            if (i_renamed == 1) {
                return com.google.android.material.chip.Chip.this.performCloseIconClick();
            }
            return false;
        }
    }

    public android.content.res.ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipBackgroundColor();
        }
        return null;
    }

    public void setChipBackgroundColorResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColorResource(i_renamed);
        }
    }

    public void setChipBackgroundColor(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipBackgroundColor(colorStateList);
        }
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipMinHeight();
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeightResource(i_renamed);
        }
    }

    public void setChipMinHeight(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipMinHeight(f_renamed);
        }
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return java.lang.Math.max(0.0f, chipDrawable.getChipCornerRadius());
        }
        return 0.0f;
    }

    @java.lang.Deprecated
    public void setChipCornerRadiusResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadiusResource(i_renamed);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.chipDrawable.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @java.lang.Deprecated
    public void setChipCornerRadius(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipCornerRadius(f_renamed);
        }
    }

    public android.content.res.ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipStrokeColor();
        }
        return null;
    }

    public void setChipStrokeColorResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColorResource(i_renamed);
        }
    }

    public void setChipStrokeColor(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeColor(colorStateList);
        }
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipStrokeWidth();
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidthResource(i_renamed);
        }
    }

    public void setChipStrokeWidth(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStrokeWidth(f_renamed);
        }
    }

    public android.content.res.ColorStateList getRippleColor() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getRippleColor();
        }
        return null;
    }

    public void setRippleColorResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColorResource(i_renamed);
            if (this.chipDrawable.getUseCompatRipple()) {
                return;
            }
            updateFrameworkRippleBackground();
        }
    }

    public void setRippleColor(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setRippleColor(colorStateList);
        }
        if (this.chipDrawable.getUseCompatRipple()) {
            return;
        }
        updateFrameworkRippleBackground();
    }

    @java.lang.Deprecated
    public java.lang.CharSequence getChipText() {
        return getText();
    }

    @Override // android.view.View
    public void setLayoutDirection(int i_renamed) {
        if (this.chipDrawable != null && android.os.Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i_renamed);
        }
    }

    @Override // android.widget.TextView
    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType bufferType) {
        if (this.chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.chipDrawable.shouldDrawText() ? null : charSequence, bufferType);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setText(charSequence);
        }
    }

    @java.lang.Deprecated
    public void setChipTextResource(int i_renamed) {
        setText(getResources().getString(i_renamed));
    }

    @java.lang.Deprecated
    public void setChipText(java.lang.CharSequence charSequence) {
        setText(charSequence);
    }

    public void setTextAppearanceResource(int i_renamed) {
        setTextAppearance(getContext(), i_renamed);
    }

    public void setTextAppearance(com.google.android.material.resources.TextAppearance textAppearance) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearance(textAppearance);
        }
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) {
        super.setTextAppearance(context, i_renamed);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(i_renamed);
        }
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i_renamed) {
        super.setTextAppearance(i_renamed);
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextAppearanceResource(i_renamed);
        }
        updateTextPaintDrawState();
    }

    private void updateTextPaintDrawState() {
        android.text.TextPaint paint = getPaint();
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        com.google.android.material.resources.TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }

    private com.google.android.material.resources.TextAppearance getTextAppearance() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getTextAppearance();
        }
        return null;
    }

    public boolean isChipIconVisible() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        return chipDrawable != null && chipDrawable.isChipIconVisible();
    }

    @java.lang.Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public void setChipIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(i_renamed);
        }
    }

    public void setChipIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconVisible(z_renamed);
        }
    }

    @java.lang.Deprecated
    public void setChipIconEnabledResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setChipIconVisible(i_renamed);
    }

    @java.lang.Deprecated
    public void setChipIconEnabled(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setChipIconVisible(z_renamed);
    }

    public android.graphics.drawable.Drawable getChipIcon() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipIcon();
        }
        return null;
    }

    public void setChipIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconResource(i_renamed);
        }
    }

    public void setChipIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIcon(drawable);
        }
    }

    public android.content.res.ColorStateList getChipIconTint() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipIconTint();
        }
        return null;
    }

    public void setChipIconTintResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTintResource(i_renamed);
        }
    }

    public void setChipIconTint(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconTint(colorStateList);
        }
    }

    public float getChipIconSize() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipIconSize();
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSizeResource(i_renamed);
        }
    }

    public void setChipIconSize(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipIconSize(f_renamed);
        }
    }

    public boolean isCloseIconVisible() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        return chipDrawable != null && chipDrawable.isCloseIconVisible();
    }

    @java.lang.Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public void setCloseIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCloseIconVisible(getResources().getBoolean(i_renamed));
    }

    public void setCloseIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconVisible(z_renamed);
        }
        updateAccessibilityDelegate();
    }

    @java.lang.Deprecated
    public void setCloseIconEnabledResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCloseIconVisible(i_renamed);
    }

    @java.lang.Deprecated
    public void setCloseIconEnabled(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCloseIconVisible(z_renamed);
    }

    public android.graphics.drawable.Drawable getCloseIcon() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIcon();
        }
        return null;
    }

    public void setCloseIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconResource(i_renamed);
        }
        updateAccessibilityDelegate();
    }

    public void setCloseIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIcon(drawable);
        }
        updateAccessibilityDelegate();
    }

    public android.content.res.ColorStateList getCloseIconTint() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconTint();
        }
        return null;
    }

    public void setCloseIconTintResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTintResource(i_renamed);
        }
    }

    public void setCloseIconTint(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconTint(colorStateList);
        }
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconSize();
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSizeResource(i_renamed);
        }
    }

    public void setCloseIconSize(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconSize(f_renamed);
        }
    }

    public void setCloseIconContentDescription(java.lang.CharSequence charSequence) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconContentDescription(charSequence);
        }
    }

    public java.lang.CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconContentDescription();
        }
        return null;
    }

    public boolean isCheckable() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        return chipDrawable != null && chipDrawable.isCheckable();
    }

    public void setCheckableResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckableResource(i_renamed);
        }
    }

    public void setCheckable(boolean z_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckable(z_renamed);
        }
    }

    public boolean isCheckedIconVisible() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        return chipDrawable != null && chipDrawable.isCheckedIconVisible();
    }

    @java.lang.Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public void setCheckedIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(i_renamed);
        }
    }

    public void setCheckedIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconVisible(z_renamed);
        }
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabledResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIconVisible(i_renamed);
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabled(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIconVisible(z_renamed);
    }

    public android.graphics.drawable.Drawable getCheckedIcon() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCheckedIcon();
        }
        return null;
    }

    public void setCheckedIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconResource(i_renamed);
        }
    }

    public void setCheckedIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIcon(drawable);
        }
    }

    public android.content.res.ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCheckedIconTint();
        }
        return null;
    }

    public void setCheckedIconTintResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTintResource(i_renamed);
        }
    }

    public void setCheckedIconTint(android.content.res.ColorStateList colorStateList) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCheckedIconTint(colorStateList);
        }
    }

    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getShowMotionSpec();
        }
        return null;
    }

    public void setShowMotionSpecResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpecResource(i_renamed);
        }
    }

    public void setShowMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setShowMotionSpec(motionSpec);
        }
    }

    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getHideMotionSpec();
        }
        return null;
    }

    public void setHideMotionSpecResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpecResource(i_renamed);
        }
    }

    public void setHideMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setHideMotionSpec(motionSpec);
        }
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipStartPadding();
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPaddingResource(i_renamed);
        }
    }

    public void setChipStartPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipStartPadding(f_renamed);
        }
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getIconStartPadding();
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPaddingResource(i_renamed);
        }
    }

    public void setIconStartPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconStartPadding(f_renamed);
        }
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getIconEndPadding();
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPaddingResource(i_renamed);
        }
    }

    public void setIconEndPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setIconEndPadding(f_renamed);
        }
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getTextStartPadding();
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPaddingResource(i_renamed);
        }
    }

    public void setTextStartPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextStartPadding(f_renamed);
        }
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getTextEndPadding();
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPaddingResource(i_renamed);
        }
    }

    public void setTextEndPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setTextEndPadding(f_renamed);
        }
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconStartPadding();
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPaddingResource(i_renamed);
        }
    }

    public void setCloseIconStartPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconStartPadding(f_renamed);
        }
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getCloseIconEndPadding();
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPaddingResource(i_renamed);
        }
    }

    public void setCloseIconEndPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setCloseIconEndPadding(f_renamed);
        }
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.getChipEndPadding();
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPaddingResource(i_renamed);
        }
    }

    public void setChipEndPadding(float f_renamed) {
        com.google.android.material.chip.ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setChipEndPadding(f_renamed);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    public void setEnsureMinTouchTargetSize(boolean z_renamed) {
        this.ensureMinTouchTargetSize = z_renamed;
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public boolean ensureAccessibleTouchTarget(int i_renamed) {
        this.minTouchTargetSize = i_renamed;
        if (!shouldEnsureMinTouchTargetSize()) {
            if (this.insetBackgroundDrawable != null) {
                removeBackgroundInset();
            } else {
                updateBackgroundDrawable();
            }
            return false;
        }
        int iMax = java.lang.Math.max(0, i_renamed - this.chipDrawable.getIntrinsicHeight());
        int iMax2 = java.lang.Math.max(0, i_renamed - this.chipDrawable.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.insetBackgroundDrawable != null) {
                removeBackgroundInset();
            } else {
                updateBackgroundDrawable();
            }
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.insetBackgroundDrawable != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.insetBackgroundDrawable.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                updateBackgroundDrawable();
                return true;
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i_renamed) {
                setMinHeight(i_renamed);
            }
            if (getMinWidth() != i_renamed) {
                setMinWidth(i_renamed);
            }
        } else {
            setMinHeight(i_renamed);
            setMinWidth(i_renamed);
        }
        insetChipBackgroundDrawable(i2, i3, i2, i3);
        updateBackgroundDrawable();
        return true;
    }

    private void removeBackgroundInset() {
        if (this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            updateBackgroundDrawable();
        }
    }

    private void insetChipBackgroundDrawable(int i_renamed, int i2, int i3, int i4) {
        this.insetBackgroundDrawable = new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) this.chipDrawable, i_renamed, i2, i3, i4);
    }
}
