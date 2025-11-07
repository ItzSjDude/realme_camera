package com.google.android.material.chip;

/* loaded from: classes.dex */
public class ChipDrawable extends com.google.android.material.shape.MaterialShapeDrawable implements android.graphics.drawable.Drawable.Callback, androidx.core.graphics.drawable.b_renamed, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final java.lang.String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;
    private android.graphics.drawable.Drawable checkedIcon;
    private android.content.res.ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    private android.content.res.ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private android.graphics.drawable.Drawable chipIcon;
    private float chipIconSize;
    private android.content.res.ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final android.graphics.Paint chipPaint;
    private float chipStartPadding;
    private android.content.res.ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private android.content.res.ColorStateList chipSurfaceColor;
    private android.graphics.drawable.Drawable closeIcon;
    private java.lang.CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private android.graphics.drawable.Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private android.content.res.ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private android.graphics.ColorFilter colorFilter;
    private android.content.res.ColorStateList compatRippleColor;
    private final android.content.Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentChipSurfaceColor;
    private int currentCompatRippleColor;
    private int currentCompositeSurfaceBackgroundColor;
    private int currentTextColor;
    private int currentTint;
    private final android.graphics.Paint debugPaint;
    private java.lang.ref.WeakReference<com.google.android.material.chip.ChipDrawable.Delegate> delegate;
    private final android.graphics.Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;
    private com.google.android.material.animation.MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final android.graphics.PointF pointF;
    private final android.graphics.RectF rectF;
    private android.content.res.ColorStateList rippleColor;
    private final android.graphics.Path shapePath;
    private boolean shouldDrawText;
    private com.google.android.material.animation.MotionSpec showMotionSpec;
    private java.lang.CharSequence text;
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    private android.content.res.ColorStateList tint;
    private android.graphics.PorterDuffColorFilter tintFilter;
    private android.graphics.PorterDuff.Mode tintMode;
    private android.text.TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;
    private static final int[] DEFAULT_STATE = {android.R_renamed.attr.state_enabled};
    private static final android.graphics.drawable.ShapeDrawable closeIconRippleMask = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public static com.google.android.material.chip.ChipDrawable createFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.google.android.material.chip.ChipDrawable chipDrawable = new com.google.android.material.chip.ChipDrawable(context, attributeSet, i_renamed, i2);
        chipDrawable.loadFromAttributes(attributeSet, i_renamed, i2);
        return chipDrawable;
    }

    public static com.google.android.material.chip.ChipDrawable createFromResource(android.content.Context context, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        android.util.AttributeSet drawableXml = com.google.android.material.drawable.DrawableUtils.parseDrawableXml(context, i_renamed, "chip");
        int styleAttribute = drawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context, drawableXml, com.google.android.material.R_renamed.attr.chipStandaloneStyle, styleAttribute);
    }

    private ChipDrawable(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new android.graphics.Paint(1);
        this.fontMetrics = new android.graphics.Paint.FontMetrics();
        this.rectF = new android.graphics.RectF();
        this.pointF = new android.graphics.PointF();
        this.shapePath = new android.graphics.Path();
        this.alpha = 255;
        this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
        this.delegate = new java.lang.ref.WeakReference<>(null);
        initializeElevationOverlay(context);
        this.context = context;
        this.textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.text = "";
        this.textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        android.graphics.Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void loadFromAttributes(android.util.AttributeSet attributeSet, int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, com.google.android.material.R_renamed.styleable.Chip, i_renamed, i2, new int[0]);
        this.isShapeThemingEnabled = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipMinHeight, 0.0f));
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Chip_chipCornerRadius)) {
            setChipCornerRadius(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipCornerRadius, 0.0f));
        }
        setChipStrokeColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_rippleColor));
        setText(typedArrayObtainStyledAttributes.getText(com.google.android.material.R_renamed.styleable.Chip_android_text));
        setTextAppearance(com.google.android.material.resources.MaterialResources.getTextAppearance(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_android_textAppearance));
        int i3 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            setEllipsize(android.text.TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            setEllipsize(android.text.TextUtils.TruncateAt.END);
        }
        setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") == null) {
            setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_chipIcon));
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Chip_chipIconTint)) {
            setChipIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_chipIconTint));
        }
        setChipIconSize(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipIconSize, 0.0f));
        setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") == null) {
            setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_closeIcon));
        setCloseIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_closeIconTint));
        setCloseIconSize(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") == null) {
            setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_checkedIcon));
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R_renamed.styleable.Chip_checkedIconTint)) {
            setCheckedIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_checkedIconTint));
        }
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromAttribute(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_showMotionSpec));
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromAttribute(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Chip_hideMotionSpec));
        setChipStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setUseCompatRipple(boolean z_renamed) {
        if (this.useCompatRipple != z_renamed) {
            this.useCompatRipple = z_renamed;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void setDelegate(com.google.android.material.chip.ChipDrawable.Delegate delegate) {
        this.delegate = new java.lang.ref.WeakReference<>(delegate);
    }

    protected void onSizeChange() {
        com.google.android.material.chip.ChipDrawable.Delegate delegate = this.delegate.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    public void getChipTouchBounds(android.graphics.RectF rectF) {
        calculateChipTouchBounds(getBounds(), rectF);
    }

    public void getCloseIconTouchBounds(android.graphics.RectF rectF) {
        calculateCloseIconTouchBounds(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return java.lang.Math.min(java.lang.Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return 0.0f;
    }

    float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int iSaveLayerAlpha = this.alpha < 255 ? com.google.android.material.canvas.CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, this.alpha) : 0;
        drawChipSurface(canvas, bounds);
        drawChipBackground(canvas, bounds);
        if (this.isShapeThemingEnabled) {
            super.draw(canvas);
        }
        drawChipStroke(canvas, bounds);
        drawCompatRipple(canvas, bounds);
        drawChipIcon(canvas, bounds);
        drawCheckedIcon(canvas, bounds);
        if (this.shouldDrawText) {
            drawText(canvas, bounds);
        }
        drawCloseIcon(canvas, bounds);
        drawDebug(canvas, bounds);
        if (this.alpha < 255) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
    }

    private void drawChipSurface(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawChipBackground(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawChipStroke(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (this.chipStrokeWidth <= 0.0f || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.STROKE);
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColorFilter(getTintColorFilter());
        }
        this.rectF.set(rect.left + (this.chipStrokeWidth / 2.0f), rect.top + (this.chipStrokeWidth / 2.0f), rect.right - (this.chipStrokeWidth / 2.0f), rect.bottom - (this.chipStrokeWidth / 2.0f));
        float f_renamed = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f_renamed, f_renamed, this.chipPaint);
    }

    private void drawCompatRipple(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        } else {
            calculatePathForSize(new android.graphics.RectF(rect), this.shapePath);
            super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
        }
    }

    private void drawChipIcon(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f_renamed = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f_renamed, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f_renamed, -f2);
        }
    }

    private void drawCheckedIcon(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f_renamed = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f_renamed, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f_renamed, -f2);
        }
    }

    private void drawText(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (this.text != null) {
            android.graphics.Paint.Align alignCalculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(alignCalculateTextOriginAndAlignment);
            int iSave = 0;
            boolean z_renamed = java.lang.Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > java.lang.Math.round(this.rectF.width());
            if (z_renamed) {
                iSave = canvas.save();
                canvas.clipRect(this.rectF);
            }
            java.lang.CharSequence charSequenceEllipsize = this.text;
            if (z_renamed && this.truncateAt != null) {
                charSequenceEllipsize = android.text.TextUtils.ellipsize(charSequenceEllipsize, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            java.lang.CharSequence charSequence = charSequenceEllipsize;
            canvas.drawText(charSequence, 0, charSequence.length(), this.pointF.x_renamed, this.pointF.y_renamed, this.textDrawableHelper.getTextPaint());
            if (z_renamed) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private void drawCloseIcon(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            float f_renamed = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f_renamed, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f_renamed, -f2);
        }
    }

    private void drawDebug(android.graphics.Canvas canvas, android.graphics.Rect rect) {
        android.graphics.Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.d_renamed.b_renamed(-16777216, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(androidx.core.graphics.d_renamed.b_renamed(-65536, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(androidx.core.graphics.d_renamed.b_renamed(-16711936, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void calculateChipIconBounds(android.graphics.Rect rect, android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f_renamed = this.chipStartPadding + this.iconStartPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                rectF.left = rect.left + f_renamed;
                rectF.right = rectF.left + this.chipIconSize;
            } else {
                rectF.right = rect.right - f_renamed;
                rectF.left = rectF.right - this.chipIconSize;
            }
            rectF.top = rect.exactCenterY() - (this.chipIconSize / 2.0f);
            rectF.bottom = rectF.top + this.chipIconSize;
        }
    }

    android.graphics.Paint.Align calculateTextOriginAndAlignment(android.graphics.Rect rect, android.graphics.PointF pointF) {
        pointF.set(0.0f, 0.0f);
        android.graphics.Paint.Align align = android.graphics.Paint.Align.LEFT;
        if (this.text != null) {
            float fCalculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                pointF.x_renamed = rect.left + fCalculateChipIconWidth;
                align = android.graphics.Paint.Align.LEFT;
            } else {
                pointF.x_renamed = rect.right - fCalculateChipIconWidth;
                align = android.graphics.Paint.Align.RIGHT;
            }
            pointF.y_renamed = rect.centerY() - calculateTextCenterFromBaseline();
        }
        return align;
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }

    private void calculateTextBounds(android.graphics.Rect rect, android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (this.text != null) {
            float fCalculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float fCalculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                rectF.left = rect.left + fCalculateChipIconWidth;
                rectF.right = rect.right - fCalculateCloseIconWidth;
            } else {
                rectF.left = rect.left + fCalculateCloseIconWidth;
                rectF.right = rect.right - fCalculateChipIconWidth;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void calculateCloseIconBounds(android.graphics.Rect rect, android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f_renamed = this.chipEndPadding + this.closeIconEndPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                rectF.right = rect.right - f_renamed;
                rectF.left = rectF.right - this.closeIconSize;
            } else {
                rectF.left = rect.left + f_renamed;
                rectF.right = rectF.left + this.closeIconSize;
            }
            rectF.top = rect.exactCenterY() - (this.closeIconSize / 2.0f);
            rectF.bottom = rectF.top + this.closeIconSize;
        }
    }

    private void calculateChipTouchBounds(android.graphics.Rect rect, android.graphics.RectF rectF) {
        rectF.set(rect);
        if (showsCloseIcon()) {
            float f_renamed = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                rectF.right = rect.right - f_renamed;
            } else {
                rectF.left = rect.left + f_renamed;
            }
        }
    }

    private void calculateCloseIconTouchBounds(android.graphics.Rect rect, android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f_renamed = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f_renamed;
            } else {
                rectF.left = rect.left;
                rectF.right = rect.left + f_renamed;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean setCloseIconState(int[] iArr) {
        if (java.util.Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    private boolean onStateChange(int[] iArr, int[] iArr2) {
        boolean z_renamed;
        boolean zOnStateChange = super.onStateChange(iArr);
        android.content.res.ColorStateList colorStateList = this.chipSurfaceColor;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, this.currentChipSurfaceColor) : 0;
        if (this.currentChipSurfaceColor != colorForState) {
            this.currentChipSurfaceColor = colorForState;
            zOnStateChange = true;
        }
        android.content.res.ColorStateList colorStateList2 = this.chipBackgroundColor;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipBackgroundColor) : 0;
        if (this.currentChipBackgroundColor != colorForState2) {
            this.currentChipBackgroundColor = colorForState2;
            zOnStateChange = true;
        }
        int iLayer = com.google.android.material.color.MaterialColors.layer(colorForState, colorForState2);
        if ((this.currentCompositeSurfaceBackgroundColor != iLayer) | (getFillColor() == null)) {
            this.currentCompositeSurfaceBackgroundColor = iLayer;
            setFillColor(android.content.res.ColorStateList.valueOf(this.currentCompositeSurfaceBackgroundColor));
            zOnStateChange = true;
        }
        android.content.res.ColorStateList colorStateList3 = this.chipStrokeColor;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState3) {
            this.currentChipStrokeColor = colorForState3;
            zOnStateChange = true;
        }
        int colorForState4 = (this.compatRippleColor == null || !com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState4) {
            this.currentCompatRippleColor = colorForState4;
            if (this.useCompatRipple) {
                zOnStateChange = true;
            }
        }
        int colorForState5 = (this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().textColor == null) ? 0 : this.textDrawableHelper.getTextAppearance().textColor.getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState5) {
            this.currentTextColor = colorForState5;
            zOnStateChange = true;
        }
        boolean z2 = hasState(getState(), android.R_renamed.attr.state_checked) && this.checkable;
        if (this.currentChecked == z2 || this.checkedIcon == null) {
            z_renamed = false;
        } else {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z2;
            if (fCalculateChipIconWidth != calculateChipIconWidth()) {
                zOnStateChange = true;
                z_renamed = true;
            } else {
                z_renamed = false;
                zOnStateChange = true;
            }
        }
        android.content.res.ColorStateList colorStateList4 = this.tint;
        int colorForState6 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentTint) : 0;
        if (this.currentTint != colorForState6) {
            this.currentTint = colorForState6;
            this.tintFilter = com.google.android.material.drawable.DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
            zOnStateChange = true;
        }
        if (isStateful(this.chipIcon)) {
            zOnStateChange |= this.chipIcon.setState(iArr);
        }
        if (isStateful(this.checkedIcon)) {
            zOnStateChange |= this.checkedIcon.setState(iArr);
        }
        if (isStateful(this.closeIcon)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            java.lang.System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            java.lang.System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            zOnStateChange |= this.closeIcon.setState(iArr3);
        }
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
            zOnStateChange |= this.closeIconRipple.setState(iArr2);
        }
        if (zOnStateChange) {
            invalidateSelf();
        }
        if (z_renamed) {
            onSizeChange();
        }
        return zOnStateChange;
    }

    private static boolean isStateful(android.content.res.ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(android.graphics.drawable.Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(com.google.android.material.resources.TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.textColor == null || !textAppearance.textColor.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i_renamed) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i_renamed);
        if (showsChipIcon()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a_renamed.b_renamed(this.chipIcon, i_renamed);
        }
        if (showsCheckedIcon()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a_renamed.b_renamed(this.checkedIcon, i_renamed);
        }
        if (showsCloseIcon()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a_renamed.b_renamed(this.closeIcon, i_renamed);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i_renamed) {
        boolean zOnLevelChange = super.onLevelChange(i_renamed);
        if (showsChipIcon()) {
            zOnLevelChange |= this.chipIcon.setLevel(i_renamed);
        }
        if (showsCheckedIcon()) {
            zOnLevelChange |= this.checkedIcon.setLevel(i_renamed);
        }
        if (showsCloseIcon()) {
            zOnLevelChange |= this.closeIcon.setLevel(i_renamed);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        boolean visible = super.setVisible(z_renamed, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z_renamed, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z_renamed, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z_renamed, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        if (this.alpha != i_renamed) {
            this.alpha = i_renamed;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = com.google.android.material.drawable.DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @android.annotation.TargetApi(21)
    public void getOutline(android.graphics.Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        android.graphics.Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private void unapplyChildDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void applyChildDrawable(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a_renamed.b_renamed(drawable, androidx.core.graphics.drawable.a_renamed.i_renamed(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.closeIconTint);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        android.graphics.drawable.Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawable2, this.chipIconTint);
        }
    }

    private android.graphics.ColorFilter getTintColorFilter() {
        android.graphics.ColorFilter colorFilter = this.colorFilter;
        return colorFilter != null ? colorFilter : this.tintFilter;
    }

    private void updateCompatRippleColor() {
        this.compatRippleColor = this.useCompatRipple ? com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
    }

    private void setChipSurfaceColor(android.content.res.ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private static boolean hasState(int[] iArr, int i_renamed) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i_renamed) {
                return true;
            }
        }
        return false;
    }

    public android.content.res.ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public void setChipBackgroundColorResource(int i_renamed) {
        setChipBackgroundColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setChipBackgroundColor(android.content.res.ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public void setChipMinHeightResource(int i_renamed) {
        setChipMinHeight(this.context.getResources().getDimension(i_renamed));
    }

    public void setChipMinHeight(float f_renamed) {
        if (this.chipMinHeight != f_renamed) {
            this.chipMinHeight = f_renamed;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    @java.lang.Deprecated
    public void setChipCornerRadiusResource(int i_renamed) {
        setChipCornerRadius(this.context.getResources().getDimension(i_renamed));
    }

    @java.lang.Deprecated
    public void setChipCornerRadius(float f_renamed) {
        if (this.chipCornerRadius != f_renamed) {
            this.chipCornerRadius = f_renamed;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f_renamed));
        }
    }

    public android.content.res.ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public void setChipStrokeColorResource(int i_renamed) {
        setChipStrokeColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setChipStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void setChipStrokeWidthResource(int i_renamed) {
        setChipStrokeWidth(this.context.getResources().getDimension(i_renamed));
    }

    public void setChipStrokeWidth(float f_renamed) {
        if (this.chipStrokeWidth != f_renamed) {
            this.chipStrokeWidth = f_renamed;
            this.chipPaint.setStrokeWidth(f_renamed);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f_renamed);
            }
            invalidateSelf();
        }
    }

    public android.content.res.ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public void setRippleColorResource(int i_renamed) {
        setRippleColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setRippleColor(android.content.res.ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public java.lang.CharSequence getText() {
        return this.text;
    }

    public void setTextResource(int i_renamed) {
        setText(this.context.getResources().getString(i_renamed));
    }

    public void setText(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (android.text.TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
    }

    public com.google.android.material.resources.TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public void setTextAppearanceResource(int i_renamed) {
        setTextAppearance(new com.google.android.material.resources.TextAppearance(this.context, i_renamed));
    }

    public void setTextAppearance(com.google.android.material.resources.TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public android.text.TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        this.truncateAt = truncateAt;
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @java.lang.Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public void setChipIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setChipIconVisible(this.context.getResources().getBoolean(i_renamed));
    }

    public void setChipIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.chipIconVisible != z_renamed) {
            boolean zShowsChipIcon = showsChipIcon();
            this.chipIconVisible = z_renamed;
            boolean zShowsChipIcon2 = showsChipIcon();
            if (zShowsChipIcon != zShowsChipIcon2) {
                if (zShowsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
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
        android.graphics.drawable.Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a_renamed.h_renamed(drawable);
        }
        return null;
    }

    public void setChipIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setChipIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, i_renamed));
    }

    public void setChipIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.drawable.Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate() : null;
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public android.content.res.ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public void setChipIconTintResource(int i_renamed) {
        setChipIconTint(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setChipIconTint(android.content.res.ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public void setChipIconSizeResource(int i_renamed) {
        setChipIconSize(this.context.getResources().getDimension(i_renamed));
    }

    public void setChipIconSize(float f_renamed) {
        if (this.chipIconSize != f_renamed) {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f_renamed;
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    @java.lang.Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public void setCloseIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCloseIconVisible(this.context.getResources().getBoolean(i_renamed));
    }

    public void setCloseIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.closeIconVisible != z_renamed) {
            boolean zShowsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z_renamed;
            boolean zShowsCloseIcon2 = showsCloseIcon();
            if (zShowsCloseIcon != zShowsCloseIcon2) {
                if (zShowsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
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
        android.graphics.drawable.Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a_renamed.h_renamed(drawable);
        }
        return null;
    }

    public void setCloseIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCloseIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, i_renamed));
    }

    public void setCloseIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.graphics.drawable.Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float fCalculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate() : null;
            if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float fCalculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (fCalculateCloseIconWidth != fCalculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    @android.annotation.TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    public android.content.res.ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void setCloseIconTintResource(int i_renamed) {
        setCloseIconTint(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setCloseIconTint(android.content.res.ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public void setCloseIconSizeResource(int i_renamed) {
        setCloseIconSize(this.context.getResources().getDimension(i_renamed));
    }

    public void setCloseIconSize(float f_renamed) {
        if (this.closeIconSize != f_renamed) {
            this.closeIconSize = f_renamed;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(java.lang.CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = androidx.core.f_renamed.a_renamed.a_renamed().a_renamed(charSequence);
            invalidateSelf();
        }
    }

    public java.lang.CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void setCheckableResource(int i_renamed) {
        setCheckable(this.context.getResources().getBoolean(i_renamed));
    }

    public void setCheckable(boolean z_renamed) {
        if (this.checkable != z_renamed) {
            this.checkable = z_renamed;
            float fCalculateChipIconWidth = calculateChipIconWidth();
            if (!z_renamed && this.currentChecked) {
                this.currentChecked = false;
            }
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @java.lang.Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public void setCheckedIconVisible(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIconVisible(this.context.getResources().getBoolean(i_renamed));
    }

    public void setCheckedIconVisible(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.checkedIconVisible != z_renamed) {
            boolean zShowsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z_renamed;
            boolean zShowsCheckedIcon2 = showsCheckedIcon();
            if (zShowsCheckedIcon != zShowsCheckedIcon2) {
                if (zShowsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabledResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIconVisible(this.context.getResources().getBoolean(i_renamed));
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabled(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIconVisible(z_renamed);
    }

    public android.graphics.drawable.Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public void setCheckedIconResource(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        setCheckedIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.context, i_renamed));
    }

    public void setCheckedIcon(android.graphics.drawable.Drawable drawable) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.checkedIcon != drawable) {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public android.content.res.ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public void setCheckedIconTintResource(int i_renamed) {
        setCheckedIconTint(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.context, i_renamed));
    }

    public void setCheckedIconTint(android.content.res.ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void setShowMotionSpecResource(int i_renamed) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(this.context, i_renamed));
    }

    public void setShowMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public void setHideMotionSpecResource(int i_renamed) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(this.context, i_renamed));
    }

    public void setHideMotionSpec(com.google.android.material.animation.MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public void setChipStartPaddingResource(int i_renamed) {
        setChipStartPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setChipStartPadding(float f_renamed) {
        if (this.chipStartPadding != f_renamed) {
            this.chipStartPadding = f_renamed;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public void setIconStartPaddingResource(int i_renamed) {
        setIconStartPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setIconStartPadding(float f_renamed) {
        if (this.iconStartPadding != f_renamed) {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f_renamed;
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public void setIconEndPaddingResource(int i_renamed) {
        setIconEndPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setIconEndPadding(float f_renamed) {
        if (this.iconEndPadding != f_renamed) {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f_renamed;
            float fCalculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public void setTextStartPaddingResource(int i_renamed) {
        setTextStartPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setTextStartPadding(float f_renamed) {
        if (this.textStartPadding != f_renamed) {
            this.textStartPadding = f_renamed;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public void setTextEndPaddingResource(int i_renamed) {
        setTextEndPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setTextEndPadding(float f_renamed) {
        if (this.textEndPadding != f_renamed) {
            this.textEndPadding = f_renamed;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public void setCloseIconStartPaddingResource(int i_renamed) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setCloseIconStartPadding(float f_renamed) {
        if (this.closeIconStartPadding != f_renamed) {
            this.closeIconStartPadding = f_renamed;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public void setCloseIconEndPaddingResource(int i_renamed) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setCloseIconEndPadding(float f_renamed) {
        if (this.closeIconEndPadding != f_renamed) {
            this.closeIconEndPadding = f_renamed;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public void setChipEndPaddingResource(int i_renamed) {
        setChipEndPadding(this.context.getResources().getDimension(i_renamed));
    }

    public void setChipEndPadding(float f_renamed) {
        if (this.chipEndPadding != f_renamed) {
            this.chipEndPadding = f_renamed;
            invalidateSelf();
            onSizeChange();
        }
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxWidth(int i_renamed) {
        this.maxWidth = i_renamed;
    }

    boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    void setShouldDrawText(boolean z_renamed) {
        this.shouldDrawText = z_renamed;
    }
}
