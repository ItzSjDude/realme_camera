package com.google.android.material.tooltip;

/* loaded from: classes.dex */
public class TooltipDrawable extends com.google.android.material.shape.MaterialShapeDrawable implements com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = com.google.android.material.R_renamed.style.Widget_MaterialComponents_Tooltip;
    private static final int DEFAULT_THEME_ATTR = com.google.android.material.R_renamed.attr.tooltipStyle;
    private int arrowSize;
    private final android.view.View.OnLayoutChangeListener attachedViewLayoutChangeListener;
    private final android.content.Context context;
    private final android.graphics.Rect displayFrame;
    private final android.graphics.Paint.FontMetrics fontMetrics;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private java.lang.CharSequence text;
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;

    public static com.google.android.material.tooltip.TooltipDrawable createFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        com.google.android.material.tooltip.TooltipDrawable tooltipDrawable = new com.google.android.material.tooltip.TooltipDrawable(context, attributeSet, i_renamed, i2);
        tooltipDrawable.loadFromAttributes(attributeSet, i_renamed, i2);
        return tooltipDrawable;
    }

    public static com.google.android.material.tooltip.TooltipDrawable createFromAttributes(android.content.Context context, android.util.AttributeSet attributeSet) {
        return createFromAttributes(context, attributeSet, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static com.google.android.material.tooltip.TooltipDrawable create(android.content.Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    private TooltipDrawable(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.fontMetrics = new android.graphics.Paint.FontMetrics();
        this.textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.attachedViewLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                com.google.android.material.tooltip.TooltipDrawable.this.updateLocationOnScreen(view);
            }
        };
        this.displayFrame = new android.graphics.Rect();
        this.context = context;
        this.textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.textDrawableHelper.getTextPaint().setTextAlign(android.graphics.Paint.Align.CENTER);
    }

    private void loadFromAttributes(android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, com.google.android.material.R_renamed.styleable.Tooltip, i_renamed, i2, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(com.google.android.material.R_renamed.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        setText(typedArrayObtainStyledAttributes.getText(com.google.android.material.R_renamed.styleable.Tooltip_android_text));
        setTextAppearance(com.google.android.material.resources.MaterialResources.getTextAppearance(this.context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.Tooltip_android_textAppearance));
        setFillColor(android.content.res.ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(com.google.android.material.R_renamed.styleable.Tooltip_backgroundTint, com.google.android.material.color.MaterialColors.layer(androidx.core.graphics.d_renamed.b_renamed(com.google.android.material.color.MaterialColors.getColor(this.context, android.R_renamed.attr.colorBackground, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName()), 229), androidx.core.graphics.d_renamed.b_renamed(com.google.android.material.color.MaterialColors.getColor(this.context, com.google.android.material.R_renamed.attr.colorOnBackground, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName()), 153)))));
        setStrokeColor(android.content.res.ColorStateList.valueOf(com.google.android.material.color.MaterialColors.getColor(this.context, com.google.android.material.R_renamed.attr.colorSurface, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName())));
        this.padding = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Tooltip_android_padding, 0);
        this.minWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Tooltip_android_minWidth, 0);
        this.minHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.Tooltip_android_layout_margin, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public java.lang.CharSequence getText() {
        return this.text;
    }

    public void setTextResource(int i_renamed) {
        setText(this.context.getResources().getString(i_renamed));
    }

    public void setText(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
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

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int i_renamed) {
        this.minWidth = i_renamed;
        invalidateSelf();
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public void setMinHeight(int i_renamed) {
        this.minHeight = i_renamed;
        invalidateSelf();
    }

    public int getTextPadding() {
        return this.padding;
    }

    public void setTextPadding(int i_renamed) {
        this.padding = i_renamed;
        invalidateSelf();
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public void setLayoutMargin(int i_renamed) {
        this.layoutMargin = i_renamed;
        invalidateSelf();
    }

    public void setRelativeToView(android.view.View view) {
        if (view == null) {
            return;
        }
        updateLocationOnScreen(view);
        view.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void detachView(android.view.View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) java.lang.Math.max((this.padding * 2) + getTextWidth(), this.minWidth);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) java.lang.Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        canvas.save();
        canvas.translate(calculatePointerOffset(), (float) (-((this.arrowSize * java.lang.Math.sqrt(2.0d)) - this.arrowSize)));
        super.draw(canvas);
        drawText(canvas);
        canvas.restore();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocationOnScreen(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.locationOnScreenX = iArr[0];
        view.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    private float calculatePointerOffset() {
        int i_renamed;
        if (((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i_renamed = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else {
            if (((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
                return 0.0f;
            }
            i_renamed = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return i_renamed;
    }

    private com.google.android.material.shape.EdgeTreatment createMarkerEdge() {
        float f_renamed = -calculatePointerOffset();
        float fWidth = ((float) (getBounds().width() - (this.arrowSize * java.lang.Math.sqrt(2.0d)))) / 2.0f;
        return new com.google.android.material.shape.OffsetEdgeTreatment(new com.google.android.material.shape.MarkerEdgeTreatment(this.arrowSize), java.lang.Math.min(java.lang.Math.max(f_renamed, -fWidth), fWidth));
    }

    private void drawText(android.graphics.Canvas canvas) {
        if (this.text == null) {
            return;
        }
        int iCalculateTextOriginAndAlignment = (int) calculateTextOriginAndAlignment(getBounds());
        if (this.textDrawableHelper.getTextAppearance() != null) {
            this.textDrawableHelper.getTextPaint().drawableState = getState();
            this.textDrawableHelper.updateTextPaintDrawState(this.context);
        }
        java.lang.CharSequence charSequence = this.text;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iCalculateTextOriginAndAlignment, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        java.lang.CharSequence charSequence = this.text;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textDrawableHelper.getTextWidth(charSequence.toString());
    }

    private float calculateTextOriginAndAlignment(android.graphics.Rect rect) {
        return rect.centerY() - calculateTextCenterFromBaseline();
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }
}
