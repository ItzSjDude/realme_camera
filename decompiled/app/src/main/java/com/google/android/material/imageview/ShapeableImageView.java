package com.google.android.material.imageview;

/* loaded from: classes.dex */
public class ShapeableImageView extends androidx.appcompat.widget.AppCompatImageView implements com.google.android.material.shape.Shapeable {
    private static final int DEF_STYLE_RES = com.google.android.material.R_renamed.style.Widget_MaterialComponents_ShapeableImageView;
    private final android.graphics.Paint borderPaint;
    private final android.graphics.Paint clearPaint;
    private final android.graphics.RectF destination;
    private android.graphics.Path maskPath;
    private final android.graphics.RectF maskRect;
    private final android.graphics.Path path;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
    private android.content.res.ColorStateList strokeColor;
    private int strokeWidth;

    public ShapeableImageView(android.content.Context context) {
        this(context, null, 0);
    }

    public ShapeableImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i_renamed, DEF_STYLE_RES), attributeSet, i_renamed);
        this.pathProvider = new com.google.android.material.shape.ShapeAppearancePathProvider();
        this.path = new android.graphics.Path();
        android.content.Context context2 = getContext();
        this.clearPaint = new android.graphics.Paint();
        this.clearPaint.setAntiAlias(true);
        this.clearPaint.setColor(-1);
        this.clearPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        this.destination = new android.graphics.RectF();
        this.maskRect = new android.graphics.RectF();
        this.maskPath = new android.graphics.Path();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.ShapeableImageView, i_renamed, DEF_STYLE_RES);
        this.strokeColor = com.google.android.material.resources.MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R_renamed.styleable.ShapeableImageView_strokeWidth, 0);
        this.borderPaint = new android.graphics.Paint();
        this.borderPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.borderPaint.setAntiAlias(true);
        this.shapeAppearanceModel = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i_renamed, DEF_STYLE_RES).build();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new com.google.android.material.imageview.ShapeableImageView.OutlineProvider());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        this.destination.set(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.maskPath.addRect(this.maskRect, android.graphics.Path.Direction.CCW);
    }

    private void drawStroke(android.graphics.Canvas canvas) {
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0 || colorForState == 0) {
            return;
        }
        this.borderPaint.setColor(colorForState);
        canvas.drawPath(this.path, this.borderPaint);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        requestLayout();
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public void setStrokeColorResource(int i_renamed) {
        setStrokeColor(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public android.content.res.ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeWidth(int i_renamed) {
        if (this.strokeWidth != i_renamed) {
            this.strokeWidth = i_renamed;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i_renamed) {
        setStrokeWidth(getResources().getDimensionPixelSize(i_renamed));
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    @android.annotation.TargetApi(21)
    class OutlineProvider extends android.view.ViewOutlineProvider {
        private android.graphics.Rect rect = new android.graphics.Rect();

        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            if (com.google.android.material.imageview.ShapeableImageView.this.shapeAppearanceModel == null || !com.google.android.material.imageview.ShapeableImageView.this.shapeAppearanceModel.isRoundRect(com.google.android.material.imageview.ShapeableImageView.this.destination)) {
                return;
            }
            com.google.android.material.imageview.ShapeableImageView.this.destination.round(this.rect);
            outline.setRoundRect(this.rect, com.google.android.material.imageview.ShapeableImageView.this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(com.google.android.material.imageview.ShapeableImageView.this.destination));
        }
    }
}
