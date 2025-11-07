package com.google.android.material.shape;

/* loaded from: classes.dex */
public class MaterialShapeDrawable extends android.graphics.drawable.Drawable implements androidx.core.graphics.drawable.b_renamed, com.google.android.material.shape.Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final java.lang.String TAG = "MaterialShapeDrawable";
    private static final android.graphics.Paint clearPaint = new android.graphics.Paint(1);
    private final java.util.BitSet containsIncompatibleShadowOp;
    private final com.google.android.material.shape.ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState drawableState;
    private final com.google.android.material.shape.ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final android.graphics.Paint fillPaint;
    private final android.graphics.RectF insetRectF;
    private final android.graphics.Matrix matrix;
    private final android.graphics.Path path;
    private final android.graphics.RectF pathBounds;
    private boolean pathDirty;
    private final android.graphics.Path pathInsetByStroke;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider;
    private final com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final android.graphics.RectF rectF;
    private final android.graphics.Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final com.google.android.material.shadow.ShadowRenderer shadowRenderer;
    private final android.graphics.Paint strokePaint;
    private com.google.android.material.shape.ShapeAppearanceModel strokeShapeAppearance;
    private android.graphics.PorterDuffColorFilter strokeTintFilter;
    private android.graphics.PorterDuffColorFilter tintFilter;
    private final android.graphics.Region transparentRegion;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    private static int modulateAlpha(int i_renamed, int i2) {
        return (i_renamed * (i2 + (i2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public static com.google.android.material.shape.MaterialShapeDrawable createWithElevationOverlay(android.content.Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    public static com.google.android.material.shape.MaterialShapeDrawable createWithElevationOverlay(android.content.Context context, float f_renamed) {
        int color = com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R_renamed.attr.colorSurface, com.google.android.material.shape.MaterialShapeDrawable.class.getSimpleName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(color));
        materialShapeDrawable.setElevation(f_renamed);
        return materialShapeDrawable;
    }

    public MaterialShapeDrawable() {
        this(new com.google.android.material.shape.ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        this(com.google.android.material.shape.ShapeAppearanceModel.builder(context, attributeSet, i_renamed, i2).build());
    }

    @java.lang.Deprecated
    public MaterialShapeDrawable(com.google.android.material.shape.ShapePathModel shapePathModel) {
        this((com.google.android.material.shape.ShapeAppearanceModel) shapePathModel);
    }

    public MaterialShapeDrawable(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this(new com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    private MaterialShapeDrawable(com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState) {
        this.cornerShadowOperation = new com.google.android.material.shape.ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new com.google.android.material.shape.ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new java.util.BitSet(8);
        this.matrix = new android.graphics.Matrix();
        this.path = new android.graphics.Path();
        this.pathInsetByStroke = new android.graphics.Path();
        this.rectF = new android.graphics.RectF();
        this.insetRectF = new android.graphics.RectF();
        this.transparentRegion = new android.graphics.Region();
        this.scratchRegion = new android.graphics.Region();
        this.fillPaint = new android.graphics.Paint(1);
        this.strokePaint = new android.graphics.Paint(1);
        this.shadowRenderer = new com.google.android.material.shadow.ShadowRenderer();
        this.pathProvider = new com.google.android.material.shape.ShapeAppearancePathProvider();
        this.pathBounds = new android.graphics.RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        this.strokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.fillPaint.setStyle(android.graphics.Paint.Style.FILL);
        clearPaint.setColor(-1);
        clearPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new com.google.android.material.shape.ShapeAppearancePathProvider.PathListener() { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onCornerPathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i_renamed) {
                com.google.android.material.shape.MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i_renamed, shapePath.containsIncompatibleShadowOp());
                com.google.android.material.shape.MaterialShapeDrawable.this.cornerShadowOperation[i_renamed] = shapePath.createShadowCompatOperation(matrix);
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onEdgePathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i_renamed) {
                com.google.android.material.shape.MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i_renamed + 4, shapePath.containsIncompatibleShadowOp());
                com.google.android.material.shape.MaterialShapeDrawable.this.edgeShadowOperation[i_renamed] = shapePath.createShadowCompatOperation(matrix);
            }
        };
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        this.drawableState = new com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.Shapeable
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @java.lang.Deprecated
    public void setShapedViewModel(com.google.android.material.shape.ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    @java.lang.Deprecated
    public com.google.android.material.shape.ShapePathModel getShapedViewModel() {
        com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof com.google.android.material.shape.ShapePathModel) {
            return (com.google.android.material.shape.ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    public void setFillColor(android.content.res.ColorStateList colorStateList) {
        if (this.drawableState.fillColor != colorStateList) {
            this.drawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public android.content.res.ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (this.drawableState.strokeColor != colorStateList) {
            this.drawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public android.content.res.ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.drawableState.tintMode != mode) {
            this.drawableState.tintMode = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public android.content.res.ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public android.content.res.ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTint(int i_renamed) {
        setTintList(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setStrokeTint(android.content.res.ColorStateList colorStateList) {
        this.drawableState.strokeTintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeTint(int i_renamed) {
        setStrokeTint(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setStroke(float f_renamed, int i_renamed) {
        setStrokeWidth(f_renamed);
        setStrokeColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setStroke(float f_renamed, android.content.res.ColorStateList colorStateList) {
        setStrokeWidth(f_renamed);
        setStrokeColor(colorStateList);
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    public void setStrokeWidth(float f_renamed) {
        this.drawableState.strokeWidth = f_renamed;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        if (this.drawableState.alpha != i_renamed) {
            this.drawableState.alpha = i_renamed;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, android.graphics.Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    protected android.graphics.RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    public void setCornerSize(float f_renamed) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f_renamed));
    }

    public void setCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(cornerSize));
    }

    public boolean isPointInTransparentRegion(int i_renamed, int i2) {
        return getTransparentRegion().contains(i_renamed, i2);
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        if (this.drawableState.padding != null) {
            rect.set(this.drawableState.padding);
            return true;
        }
        return super.getPadding(rect);
    }

    public void setPadding(int i_renamed, int i2, int i3, int i4) {
        if (this.drawableState.padding == null) {
            this.drawableState.padding = new android.graphics.Rect();
        }
        this.drawableState.padding.set(i_renamed, i2, i3, i4);
        invalidateSelf();
    }

    public void setShadowCompatibilityMode(int i_renamed) {
        if (this.drawableState.shadowCompatMode != i_renamed) {
            this.drawableState.shadowCompatMode = i_renamed;
            invalidateSelfIgnoreShape();
        }
    }

    @java.lang.Deprecated
    public boolean isShadowEnabled() {
        return this.drawableState.shadowCompatMode == 0 || this.drawableState.shadowCompatMode == 2;
    }

    @java.lang.Deprecated
    public void setShadowEnabled(boolean z_renamed) {
        setShadowCompatibilityMode(!z_renamed ? 1 : 0);
    }

    public boolean isElevationOverlayEnabled() {
        return this.drawableState.elevationOverlayProvider != null && this.drawableState.elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.elevationOverlayProvider != null;
    }

    public void initializeElevationOverlay(android.content.Context context) {
        this.drawableState.elevationOverlayProvider = new com.google.android.material.elevation.ElevationOverlayProvider(context);
        updateZ();
    }

    private int compositeElevationOverlayIfNeeded(int i_renamed) {
        return this.drawableState.elevationOverlayProvider != null ? this.drawableState.elevationOverlayProvider.compositeOverlayIfNeeded(i_renamed, getZ() + getParentAbsoluteElevation()) : i_renamed;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    public void setInterpolation(float f_renamed) {
        if (this.drawableState.interpolation != f_renamed) {
            this.drawableState.interpolation = f_renamed;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    public void setParentAbsoluteElevation(float f_renamed) {
        if (this.drawableState.parentAbsoluteElevation != f_renamed) {
            this.drawableState.parentAbsoluteElevation = f_renamed;
            updateZ();
        }
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    public void setElevation(float f_renamed) {
        if (this.drawableState.elevation != f_renamed) {
            this.drawableState.elevation = f_renamed;
            updateZ();
        }
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    public void setTranslationZ(float f_renamed) {
        if (this.drawableState.translationZ != f_renamed) {
            this.drawableState.translationZ = f_renamed;
            updateZ();
        }
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void setZ(float f_renamed) {
        setTranslationZ(f_renamed - getElevation());
    }

    private void updateZ() {
        float z_renamed = getZ();
        this.drawableState.shadowCompatRadius = (int) java.lang.Math.ceil(0.75f * z_renamed);
        this.drawableState.shadowCompatOffset = (int) java.lang.Math.ceil(z_renamed * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @java.lang.Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    @java.lang.Deprecated
    public void setShadowElevation(int i_renamed) {
        setElevation(i_renamed);
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    public void setShadowBitmapDrawingEnable(boolean z_renamed) {
        this.shadowBitmapDrawingEnable = z_renamed;
    }

    public void setEdgeIntersectionCheckEnable(boolean z_renamed) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z_renamed);
    }

    public void setShadowVerticalOffset(int i_renamed) {
        if (this.drawableState.shadowCompatOffset != i_renamed) {
            this.drawableState.shadowCompatOffset = i_renamed;
            invalidateSelfIgnoreShape();
        }
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public void setShadowCompatRotation(int i_renamed) {
        if (this.drawableState.shadowCompatRotation != i_renamed) {
            this.drawableState.shadowCompatRotation = i_renamed;
            invalidateSelfIgnoreShape();
        }
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @java.lang.Deprecated
    public void setShadowRadius(int i_renamed) {
        this.drawableState.shadowCompatRadius = i_renamed;
    }

    public boolean requiresCompatShadow() {
        return android.os.Build.VERSION.SDK_INT < 21 || !(isRoundRect() || this.path.isConvex() || android.os.Build.VERSION.SDK_INT >= 29);
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public void setScale(float f_renamed) {
        if (this.drawableState.scale != f_renamed) {
            this.drawableState.scale = f_renamed;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    public void setUseTintColorForShadow(boolean z_renamed) {
        if (this.drawableState.useTintColorForShadow != z_renamed) {
            this.drawableState.useTintColorForShadow = z_renamed;
            invalidateSelf();
        }
    }

    public void setShadowColor(int i_renamed) {
        this.shadowRenderer.setShadowColor(i_renamed);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public android.graphics.Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public void setPaintStyle(android.graphics.Paint.Style style) {
        this.drawableState.paintStyle = style;
        invalidateSelfIgnoreShape();
    }

    private boolean hasCompatShadow() {
        return this.drawableState.shadowCompatMode != 1 && this.drawableState.shadowCompatRadius > 0 && (this.drawableState.shadowCompatMode == 2 || requiresCompatShadow());
    }

    private boolean hasFill() {
        return this.drawableState.paintStyle == android.graphics.Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == android.graphics.Paint.Style.FILL;
    }

    private boolean hasStroke() {
        return (this.drawableState.paintStyle == android.graphics.Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == android.graphics.Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    private void maybeDrawCompatShadow(android.graphics.Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.pathBounds.width() - getBounds().width());
            int iHeight = (int) (this.pathBounds.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new java.lang.IllegalStateException("Invalid shadow bounds. Check that the treatments result in_renamed a_renamed valid path.");
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + iWidth, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + iHeight, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapCreateBitmap);
            float f_renamed = (getBounds().left - this.drawableState.shadowCompatRadius) - iWidth;
            float f2 = (getBounds().top - this.drawableState.shadowCompatRadius) - iHeight;
            canvas2.translate(-f_renamed, -f2);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f_renamed, f2, (android.graphics.Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    protected void drawShape(android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Path path, android.graphics.RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, rectF);
    }

    private void drawShape(android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Path path, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, android.graphics.RectF rectF) {
        if (shapeAppearanceModel.isRoundRect(rectF)) {
            float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    private void drawFillShape(android.graphics.Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    private void drawStrokeShape(android.graphics.Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    private void prepareCanvasForShadow(android.graphics.Canvas canvas) {
        int shadowOffsetX = getShadowOffsetX();
        int shadowOffsetY = getShadowOffsetY();
        if (android.os.Build.VERSION.SDK_INT < 21 && this.shadowBitmapDrawingEnable) {
            android.graphics.Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(-this.drawableState.shadowCompatRadius, -this.drawableState.shadowCompatRadius);
            clipBounds.offset(shadowOffsetX, shadowOffsetY);
            canvas.clipRect(clipBounds, android.graphics.Region.Op.REPLACE);
        }
        canvas.translate(shadowOffsetX, shadowOffsetY);
    }

    private void drawCompatShadow(android.graphics.Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            android.util.Log.w_renamed(TAG, "Compatibility shadow requested but can't_renamed be_renamed drawn for all operations in_renamed this shape.");
        }
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            this.cornerShadowOperation[i_renamed].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i_renamed].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    public int getShadowOffsetX() {
        return (int) (this.drawableState.shadowCompatOffset * java.lang.Math.sin(java.lang.Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        return (int) (this.drawableState.shadowCompatOffset * java.lang.Math.cos(java.lang.Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    @java.lang.Deprecated
    public void getPathForSize(int i_renamed, int i2, android.graphics.Path path) {
        calculatePathForSize(new android.graphics.RectF(0.0f, 0.0f, i_renamed, i2), path);
    }

    protected final void calculatePathForSize(android.graphics.RectF rectF, android.graphics.Path path) {
        this.pathProvider.calculatePath(this.drawableState.shapeAppearanceModel, this.drawableState.interpolation, rectF, this.pathShadowListener, path);
    }

    private void calculateStrokePath() {
        final float f_renamed = -getStrokeInsetLength();
        this.strokeShapeAppearance = getShapeAppearanceModel().withTransformedCornerSizes(new com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public com.google.android.material.shape.CornerSize apply(com.google.android.material.shape.CornerSize cornerSize) {
                return cornerSize instanceof com.google.android.material.shape.RelativeCornerSize ? cornerSize : new com.google.android.material.shape.AdjustedCornerSize(f_renamed, cornerSize);
            }
        });
        this.pathProvider.calculatePath(this.strokeShapeAppearance, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @Override // android.graphics.drawable.Drawable
    @android.annotation.TargetApi(21)
    public void getOutline(android.graphics.Outline outline) {
        if (this.drawableState.shadowCompatMode == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
            return;
        }
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() || android.os.Build.VERSION.SDK_INT >= 29) {
            outline.setConvexPath(this.path);
        }
    }

    private void calculatePath(android.graphics.RectF rectF, android.graphics.Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            this.matrix.setScale(this.drawableState.scale, this.drawableState.scale, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private boolean updateTintFilter() {
        android.graphics.PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        android.graphics.PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        this.tintFilter = calculateTintFilter(this.drawableState.tintList, this.drawableState.tintMode, this.fillPaint, true);
        this.strokeTintFilter = calculateTintFilter(this.drawableState.strokeTintList, this.drawableState.tintMode, this.strokePaint, false);
        if (this.drawableState.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(this.drawableState.tintList.getColorForState(getState(), 0));
        }
        return (androidx.core.g_renamed.c_renamed.a_renamed(porterDuffColorFilter, this.tintFilter) && androidx.core.g_renamed.c_renamed.a_renamed(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
    }

    private android.graphics.PorterDuffColorFilter calculateTintFilter(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, android.graphics.Paint paint, boolean z_renamed) {
        if (colorStateList == null || mode == null) {
            return calculatePaintColorTintFilter(paint, z_renamed);
        }
        return calculateTintColorTintFilter(colorStateList, mode, z_renamed);
    }

    private android.graphics.PorterDuffColorFilter calculatePaintColorTintFilter(android.graphics.Paint paint, boolean z_renamed) {
        int color;
        int iCompositeElevationOverlayIfNeeded;
        if (!z_renamed || (iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(iCompositeElevationOverlayIfNeeded, android.graphics.PorterDuff.Mode.SRC_IN);
    }

    private android.graphics.PorterDuffColorFilter calculateTintColorTintFilter(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, boolean z_renamed) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z_renamed) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        return new android.graphics.PorterDuffColorFilter(colorForState, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return super.isStateful() || (this.drawableState.tintList != null && this.drawableState.tintList.isStateful()) || ((this.drawableState.strokeTintList != null && this.drawableState.strokeTintList.isStateful()) || ((this.drawableState.strokeColor != null && this.drawableState.strokeColor.isStateful()) || (this.drawableState.fillColor != null && this.drawableState.fillColor.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    protected boolean onStateChange(int[] iArr) {
        boolean z_renamed = updateColorsForState(iArr) || updateTintFilter();
        if (z_renamed) {
            invalidateSelf();
        }
        return z_renamed;
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z_renamed;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            z_renamed = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z_renamed = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            return z_renamed;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private android.graphics.RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    static final class MaterialShapeDrawableState extends android.graphics.drawable.Drawable.ConstantState {
        public int alpha;
        public android.graphics.ColorFilter colorFilter;
        public float elevation;
        public com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider;
        public android.content.res.ColorStateList fillColor;
        public float interpolation;
        public android.graphics.Rect padding;
        public android.graphics.Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;
        public com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;
        public android.content.res.ColorStateList strokeColor;
        public android.content.res.ColorStateList strokeTintList;
        public float strokeWidth;
        public android.content.res.ColorStateList tintList;
        public android.graphics.PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public MaterialShapeDrawableState(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = android.graphics.Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.elevationOverlayProvider = elevationOverlayProvider;
        }

        public MaterialShapeDrawableState(com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = android.graphics.Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            android.graphics.Rect rect = materialShapeDrawableState.padding;
            if (rect != null) {
                this.padding = new android.graphics.Rect(rect);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(this);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }
    }
}
