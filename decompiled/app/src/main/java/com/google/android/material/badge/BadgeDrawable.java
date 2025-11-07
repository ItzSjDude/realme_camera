package com.google.android.material.badge;

/* loaded from: classes.dex */
public class BadgeDrawable extends android.graphics.drawable.Drawable implements com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final java.lang.String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    private static final int DEFAULT_STYLE = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = com.google.android.material.R_renamed.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    private java.lang.ref.WeakReference<android.view.View> anchorViewRef;
    private final android.graphics.Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;
    private final java.lang.ref.WeakReference<android.content.Context> contextRef;
    private float cornerRadius;
    private java.lang.ref.WeakReference<android.view.ViewGroup> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final com.google.android.material.badge.BadgeDrawable.SavedState savedState;
    private final com.google.android.material.shape.MaterialShapeDrawable shapeDrawable;
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public static final class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.material.badge.BadgeDrawable.SavedState> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.badge.BadgeDrawable.SavedState>() { // from class: com.google.android.material.badge.BadgeDrawable.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.badge.BadgeDrawable.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.badge.BadgeDrawable.SavedState(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.badge.BadgeDrawable.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.badge.BadgeDrawable.SavedState[i_renamed];
            }
        };
        private int alpha;
        private int backgroundColor;
        private int badgeGravity;
        private int badgeTextColor;
        private java.lang.CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private int horizontalOffset;
        private int maxCharacterCount;
        private int number;
        private int verticalOffset;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState(android.content.Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new com.google.android.material.resources.TextAppearance(context, com.google.android.material.R_renamed.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(com.google.android.material.R_renamed.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = com.google.android.material.R_renamed.plurals.mtrl_badge_content_description;
        }

        protected SavedState(android.os.Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
        }
    }

    public com.google.android.material.badge.BadgeDrawable.SavedState getSavedState() {
        return this.savedState;
    }

    static com.google.android.material.badge.BadgeDrawable createFromSavedState(android.content.Context context, com.google.android.material.badge.BadgeDrawable.SavedState savedState) throws android.content.res.Resources.NotFoundException {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = new com.google.android.material.badge.BadgeDrawable(context);
        badgeDrawable.restoreFromSavedState(savedState);
        return badgeDrawable;
    }

    public static com.google.android.material.badge.BadgeDrawable create(android.content.Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static com.google.android.material.badge.BadgeDrawable createFromResource(android.content.Context context, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        android.util.AttributeSet drawableXml = com.google.android.material.drawable.DrawableUtils.parseDrawableXml(context, i_renamed, "badge");
        int styleAttribute = drawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = DEFAULT_STYLE;
        }
        return createFromAttributes(context, drawableXml, DEFAULT_THEME_ATTR, styleAttribute);
    }

    private static com.google.android.material.badge.BadgeDrawable createFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = new com.google.android.material.badge.BadgeDrawable(context);
        badgeDrawable.loadDefaultStateFromAttributes(context, attributeSet, i_renamed, i2);
        return badgeDrawable;
    }

    public void setVisible(boolean z_renamed) {
        setVisible(z_renamed, false);
    }

    private void restoreFromSavedState(com.google.android.material.badge.BadgeDrawable.SavedState savedState) throws android.content.res.Resources.NotFoundException {
        setMaxCharacterCount(savedState.maxCharacterCount);
        if (savedState.number != -1) {
            setNumber(savedState.number);
        }
        setBackgroundColor(savedState.backgroundColor);
        setBadgeTextColor(savedState.badgeTextColor);
        setBadgeGravity(savedState.badgeGravity);
        setHorizontalOffset(savedState.horizontalOffset);
        setVerticalOffset(savedState.verticalOffset);
    }

    private void loadDefaultStateFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R_renamed.styleable.Badge, i_renamed, i2, new int[0]);
        setMaxCharacterCount(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.Badge_maxCharacterCount, 4));
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Badge_number)) {
            setNumber(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.Badge_number, 0));
        }
        setBackgroundColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Badge_backgroundColor));
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Badge_badgeTextColor)) {
            setBadgeTextColor(readColorFromAttributes(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Badge_badgeTextColor));
        }
        setBadgeGravity(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.Badge_horizontalOffset, 0));
        setVerticalOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R_renamed.styleable.Badge_verticalOffset, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    private static int readColorFromAttributes(android.content.Context context, android.content.res.TypedArray typedArray, int i_renamed) {
        return com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArray, i_renamed).getDefaultColor();
    }

    private BadgeDrawable(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        this.contextRef = new java.lang.ref.WeakReference<>(context);
        com.google.android.material.internal.ThemeEnforcement.checkMaterialTheme(context);
        android.content.res.Resources resources = context.getResources();
        this.badgeBounds = new android.graphics.Rect();
        this.shapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.badgeRadius = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_badge_radius);
        this.badgeWidePadding = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = resources.getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_badge_with_text_radius);
        this.textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.textDrawableHelper.getTextPaint().setTextAlign(android.graphics.Paint.Align.CENTER);
        this.savedState = new com.google.android.material.badge.BadgeDrawable.SavedState(context);
        setTextAppearanceResource(com.google.android.material.R_renamed.style.TextAppearance_MaterialComponents_Badge);
    }

    public void updateBadgeCoordinates(android.view.View view, android.view.ViewGroup viewGroup) {
        this.anchorViewRef = new java.lang.ref.WeakReference<>(view);
        this.customBadgeParentRef = new java.lang.ref.WeakReference<>(viewGroup);
        updateCenterAndBounds();
        invalidateSelf();
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public void setBackgroundColor(int i_renamed) {
        this.savedState.backgroundColor = i_renamed;
        android.content.res.ColorStateList colorStateListValueOf = android.content.res.ColorStateList.valueOf(i_renamed);
        if (this.shapeDrawable.getFillColor() != colorStateListValueOf) {
            this.shapeDrawable.setFillColor(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    public void setBadgeTextColor(int i_renamed) {
        this.savedState.badgeTextColor = i_renamed;
        if (this.textDrawableHelper.getTextPaint().getColor() != i_renamed) {
            this.textDrawableHelper.getTextPaint().setColor(i_renamed);
            invalidateSelf();
        }
    }

    public boolean hasNumber() {
        return this.savedState.number != -1;
    }

    public int getNumber() {
        if (hasNumber()) {
            return this.savedState.number;
        }
        return 0;
    }

    public void setNumber(int i_renamed) throws android.content.res.Resources.NotFoundException {
        int iMax = java.lang.Math.max(0, i_renamed);
        if (this.savedState.number != iMax) {
            this.savedState.number = iMax;
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public void clearNumber() {
        this.savedState.number = -1;
        invalidateSelf();
    }

    public int getMaxCharacterCount() {
        return this.savedState.maxCharacterCount;
    }

    public void setMaxCharacterCount(int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.savedState.maxCharacterCount != i_renamed) {
            this.savedState.maxCharacterCount = i_renamed;
            updateMaxBadgeNumber();
            this.textDrawableHelper.setTextWidthDirty(true);
            updateCenterAndBounds();
            invalidateSelf();
        }
    }

    public int getBadgeGravity() {
        return this.savedState.badgeGravity;
    }

    public void setBadgeGravity(int i_renamed) {
        if (this.savedState.badgeGravity != i_renamed) {
            this.savedState.badgeGravity = i_renamed;
            java.lang.ref.WeakReference<android.view.View> weakReference = this.anchorViewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            android.view.View view = this.anchorViewRef.get();
            java.lang.ref.WeakReference<android.view.ViewGroup> weakReference2 = this.customBadgeParentRef;
            updateBadgeCoordinates(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.savedState.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        this.savedState.alpha = i_renamed;
        this.textDrawableHelper.getTextPaint().setAlpha(i_renamed);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasNumber()) {
            drawText(canvas);
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setContentDescriptionNumberless(java.lang.CharSequence charSequence) {
        this.savedState.contentDescriptionNumberless = charSequence;
    }

    public void setContentDescriptionQuantityStringsResource(int i_renamed) {
        this.savedState.contentDescriptionQuantityStrings = i_renamed;
    }

    public java.lang.CharSequence getContentDescription() {
        android.content.Context context;
        if (!isVisible()) {
            return null;
        }
        if (hasNumber()) {
            if (this.savedState.contentDescriptionQuantityStrings <= 0 || (context = this.contextRef.get()) == null) {
                return null;
            }
            return context.getResources().getQuantityString(this.savedState.contentDescriptionQuantityStrings, getNumber(), java.lang.Integer.valueOf(getNumber()));
        }
        return this.savedState.contentDescriptionNumberless;
    }

    public void setHorizontalOffset(int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.savedState.horizontalOffset = i_renamed;
        updateCenterAndBounds();
    }

    public int getHorizontalOffset() {
        return this.savedState.horizontalOffset;
    }

    public void setVerticalOffset(int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.savedState.verticalOffset = i_renamed;
        updateCenterAndBounds();
    }

    public int getVerticalOffset() {
        return this.savedState.verticalOffset;
    }

    private void setTextAppearanceResource(int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        setTextAppearance(new com.google.android.material.resources.TextAppearance(context, i_renamed));
    }

    private void setTextAppearance(com.google.android.material.resources.TextAppearance textAppearance) throws android.content.res.Resources.NotFoundException {
        android.content.Context context;
        if (this.textDrawableHelper.getTextAppearance() == textAppearance || (context = this.contextRef.get()) == null) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        updateCenterAndBounds();
    }

    private void updateCenterAndBounds() throws android.content.res.Resources.NotFoundException {
        android.content.Context context = this.contextRef.get();
        java.lang.ref.WeakReference<android.view.View> weakReference = this.anchorViewRef;
        android.view.View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        rect.set(this.badgeBounds);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        view.getDrawingRect(rect2);
        java.lang.ref.WeakReference<android.view.ViewGroup> weakReference2 = this.customBadgeParentRef;
        android.view.ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
            if (viewGroup == null) {
                viewGroup = (android.view.ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(context, rect2, view);
        com.google.android.material.badge.BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private void calculateCenterAndBounds(android.content.Context context, android.graphics.Rect rect, android.view.View view) throws android.content.res.Resources.NotFoundException {
        int i_renamed = this.savedState.badgeGravity;
        if (i_renamed == 8388691 || i_renamed == 8388693) {
            this.badgeCenterY = rect.bottom - this.savedState.verticalOffset;
        } else {
            this.badgeCenterY = rect.top + this.savedState.verticalOffset;
        }
        if (getNumber() <= 9) {
            this.cornerRadius = !hasNumber() ? this.badgeRadius : this.badgeWithTextRadius;
            float f_renamed = this.cornerRadius;
            this.halfBadgeHeight = f_renamed;
            this.halfBadgeWidth = f_renamed;
        } else {
            this.cornerRadius = this.badgeWithTextRadius;
            this.halfBadgeHeight = this.cornerRadius;
            this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(hasNumber() ? com.google.android.material.R_renamed.dimen.mtrl_badge_text_horizontal_edge_offset : com.google.android.material.R_renamed.dimen.mtrl_badge_horizontal_edge_offset);
        int i2 = this.savedState.badgeGravity;
        if (i2 == 8388659 || i2 == 8388691) {
            this.badgeCenterX = androidx.core.h_renamed.v_renamed.g_renamed(view) == 0 ? (rect.left - this.halfBadgeWidth) + dimensionPixelSize + this.savedState.horizontalOffset : ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - this.savedState.horizontalOffset;
        } else {
            this.badgeCenterX = androidx.core.h_renamed.v_renamed.g_renamed(view) == 0 ? ((rect.right + this.halfBadgeWidth) - dimensionPixelSize) - this.savedState.horizontalOffset : (rect.left - this.halfBadgeWidth) + dimensionPixelSize + this.savedState.horizontalOffset;
        }
    }

    private void drawText(android.graphics.Canvas canvas) {
        android.graphics.Rect rect = new android.graphics.Rect();
        java.lang.String badgeText = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(badgeText, 0, badgeText.length(), rect);
        canvas.drawText(badgeText, this.badgeCenterX, this.badgeCenterY + (rect.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    private java.lang.String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) {
            return java.lang.Integer.toString(getNumber());
        }
        android.content.Context context = this.contextRef.get();
        return context == null ? "" : context.getString(com.google.android.material.R_renamed.string.mtrl_exceed_max_badge_number_suffix, java.lang.Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) java.lang.Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
    }
}
