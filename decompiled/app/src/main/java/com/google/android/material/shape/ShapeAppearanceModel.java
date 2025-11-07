package com.google.android.material.shape;

/* loaded from: classes.dex */
public class ShapeAppearanceModel {
    public static final com.google.android.material.shape.CornerSize PILL = new com.google.android.material.shape.RelativeCornerSize(0.5f);
    com.google.android.material.shape.EdgeTreatment bottomEdge;
    com.google.android.material.shape.CornerTreatment bottomLeftCorner;
    com.google.android.material.shape.CornerSize bottomLeftCornerSize;
    com.google.android.material.shape.CornerTreatment bottomRightCorner;
    com.google.android.material.shape.CornerSize bottomRightCornerSize;
    com.google.android.material.shape.EdgeTreatment leftEdge;
    com.google.android.material.shape.EdgeTreatment rightEdge;
    com.google.android.material.shape.EdgeTreatment topEdge;
    com.google.android.material.shape.CornerTreatment topLeftCorner;
    com.google.android.material.shape.CornerSize topLeftCornerSize;
    com.google.android.material.shape.CornerTreatment topRightCorner;
    com.google.android.material.shape.CornerSize topRightCornerSize;

    public interface CornerSizeUnaryOperator {
        com.google.android.material.shape.CornerSize apply(com.google.android.material.shape.CornerSize cornerSize);
    }

    public static final class Builder {
        private com.google.android.material.shape.EdgeTreatment bottomEdge;
        private com.google.android.material.shape.CornerTreatment bottomLeftCorner;
        private com.google.android.material.shape.CornerSize bottomLeftCornerSize;
        private com.google.android.material.shape.CornerTreatment bottomRightCorner;
        private com.google.android.material.shape.CornerSize bottomRightCornerSize;
        private com.google.android.material.shape.EdgeTreatment leftEdge;
        private com.google.android.material.shape.EdgeTreatment rightEdge;
        private com.google.android.material.shape.EdgeTreatment topEdge;
        private com.google.android.material.shape.CornerTreatment topLeftCorner;
        private com.google.android.material.shape.CornerSize topLeftCornerSize;
        private com.google.android.material.shape.CornerTreatment topRightCorner;
        private com.google.android.material.shape.CornerSize topRightCornerSize;

        public Builder() {
            this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public Builder(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
            this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCorners(int i_renamed, float f_renamed) {
            return setAllCorners(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setAllCornerSizes(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCorners(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCornerSizes(com.google.android.material.shape.CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllCornerSizes(float f_renamed) {
            return setTopLeftCornerSize(f_renamed).setTopRightCornerSize(f_renamed).setBottomRightCornerSize(f_renamed).setBottomLeftCornerSize(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCornerSize(float f_renamed) {
            this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f_renamed);
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
            this.topLeftCornerSize = cornerSize;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCornerSize(float f_renamed) {
            this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f_renamed);
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
            this.topRightCornerSize = cornerSize;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCornerSize(float f_renamed) {
            this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f_renamed);
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
            this.bottomRightCornerSize = cornerSize;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCornerSize(float f_renamed) {
            this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(f_renamed);
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
            this.bottomLeftCornerSize = cornerSize;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(int i_renamed, float f_renamed) {
            return setTopLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setTopLeftCornerSize(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(int i_renamed, com.google.android.material.shape.CornerSize cornerSize) {
            return setTopLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setTopLeftCornerSize(cornerSize);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopLeftCorner(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.topLeftCorner = cornerTreatment;
            float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                setTopLeftCornerSize(fCompatCornerTreatmentSize);
            }
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(int i_renamed, float f_renamed) {
            return setTopRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setTopRightCornerSize(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(int i_renamed, com.google.android.material.shape.CornerSize cornerSize) {
            return setTopRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setTopRightCornerSize(cornerSize);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopRightCorner(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.topRightCorner = cornerTreatment;
            float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                setTopRightCornerSize(fCompatCornerTreatmentSize);
            }
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(int i_renamed, float f_renamed) {
            return setBottomRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setBottomRightCornerSize(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(int i_renamed, com.google.android.material.shape.CornerSize cornerSize) {
            return setBottomRightCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setBottomRightCornerSize(cornerSize);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomRightCorner(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.bottomRightCorner = cornerTreatment;
            float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                setBottomRightCornerSize(fCompatCornerTreatmentSize);
            }
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(int i_renamed, float f_renamed) {
            return setBottomLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setBottomLeftCornerSize(f_renamed);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(int i_renamed, com.google.android.material.shape.CornerSize cornerSize) {
            return setBottomLeftCorner(com.google.android.material.shape.MaterialShapeUtils.createCornerTreatment(i_renamed)).setBottomLeftCornerSize(cornerSize);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomLeftCorner(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            this.bottomLeftCorner = cornerTreatment;
            float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (fCompatCornerTreatmentSize != -1.0f) {
                setBottomLeftCornerSize(fCompatCornerTreatmentSize);
            }
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setAllEdges(com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setLeftEdge(com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.leftEdge = edgeTreatment;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setTopEdge(com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.topEdge = edgeTreatment;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setRightEdge(com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.rightEdge = edgeTreatment;
            return this;
        }

        public com.google.android.material.shape.ShapeAppearanceModel.Builder setBottomEdge(com.google.android.material.shape.EdgeTreatment edgeTreatment) {
            this.bottomEdge = edgeTreatment;
            return this;
        }

        private static float compatCornerTreatmentSize(com.google.android.material.shape.CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof com.google.android.material.shape.RoundedCornerTreatment) {
                return ((com.google.android.material.shape.RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof com.google.android.material.shape.CutCornerTreatment) {
                return ((com.google.android.material.shape.CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        public com.google.android.material.shape.ShapeAppearanceModel build() {
            return new com.google.android.material.shape.ShapeAppearanceModel(this);
        }
    }

    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder() {
        return new com.google.android.material.shape.ShapeAppearanceModel.Builder();
    }

    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        return builder(context, attributeSet, i_renamed, i2, 0);
    }

    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2, int i3) {
        return builder(context, attributeSet, i_renamed, i2, new com.google.android.material.shape.AbsoluteCornerSize(i3));
    }

    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2, com.google.android.material.shape.CornerSize cornerSize) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R_renamed.styleable.MaterialShape, i_renamed, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R_renamed.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    public static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, int i_renamed, int i2) {
        return builder(context, i_renamed, i2, 0);
    }

    private static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, int i_renamed, int i2, int i3) {
        return builder(context, i_renamed, i2, new com.google.android.material.shape.AbsoluteCornerSize(i3));
    }

    private static com.google.android.material.shape.ShapeAppearanceModel.Builder builder(android.content.Context context, int i_renamed, int i2, com.google.android.material.shape.CornerSize cornerSize) throws android.content.res.Resources.NotFoundException {
        if (i2 != 0) {
            android.view.ContextThemeWrapper contextThemeWrapper = new android.view.ContextThemeWrapper(context, i_renamed);
            i_renamed = i2;
            context = contextThemeWrapper;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i_renamed, com.google.android.material.R_renamed.styleable.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            com.google.android.material.shape.CornerSize cornerSize2 = getCornerSize(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerSize, cornerSize);
            com.google.android.material.shape.CornerSize cornerSize3 = getCornerSize(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            com.google.android.material.shape.CornerSize cornerSize4 = getCornerSize(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            com.google.android.material.shape.CornerSize cornerSize5 = getCornerSize(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            return new com.google.android.material.shape.ShapeAppearanceModel.Builder().setTopLeftCorner(i4, cornerSize3).setTopRightCorner(i5, cornerSize4).setBottomRightCorner(i6, cornerSize5).setBottomLeftCorner(i7, getCornerSize(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static com.google.android.material.shape.CornerSize getCornerSize(android.content.res.TypedArray typedArray, int i_renamed, com.google.android.material.shape.CornerSize cornerSize) {
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i_renamed);
        if (typedValuePeekValue == null) {
            return cornerSize;
        }
        if (typedValuePeekValue.type == 5) {
            return new com.google.android.material.shape.AbsoluteCornerSize(android.util.TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return typedValuePeekValue.type == 6 ? new com.google.android.material.shape.RelativeCornerSize(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    private ShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel.Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = com.google.android.material.shape.MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new com.google.android.material.shape.AbsoluteCornerSize(0.0f);
        this.topEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = com.google.android.material.shape.MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    public com.google.android.material.shape.CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public com.google.android.material.shape.CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public com.google.android.material.shape.CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public com.google.android.material.shape.CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public com.google.android.material.shape.CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    public com.google.android.material.shape.CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    public com.google.android.material.shape.CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    public com.google.android.material.shape.CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    public com.google.android.material.shape.EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public com.google.android.material.shape.EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public com.google.android.material.shape.EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public com.google.android.material.shape.EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public com.google.android.material.shape.ShapeAppearanceModel.Builder toBuilder() {
        return new com.google.android.material.shape.ShapeAppearanceModel.Builder(this);
    }

    public com.google.android.material.shape.ShapeAppearanceModel withCornerSize(float f_renamed) {
        return toBuilder().setAllCornerSizes(f_renamed).build();
    }

    public com.google.android.material.shape.ShapeAppearanceModel withCornerSize(com.google.android.material.shape.CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    public com.google.android.material.shape.ShapeAppearanceModel withTransformedCornerSizes(com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }

    public boolean isRoundRect(android.graphics.RectF rectF) {
        boolean z_renamed = this.leftEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.rightEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.topEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class) && this.bottomEdge.getClass().equals(com.google.android.material.shape.EdgeTreatment.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z_renamed && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.topLeftCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.bottomRightCorner instanceof com.google.android.material.shape.RoundedCornerTreatment) && (this.bottomLeftCorner instanceof com.google.android.material.shape.RoundedCornerTreatment));
    }
}
