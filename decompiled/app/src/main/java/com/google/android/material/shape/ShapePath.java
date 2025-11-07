package com.google.android.material.shape;

/* loaded from: classes.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @java.lang.Deprecated
    public float currentShadowAngle;

    @java.lang.Deprecated
    public float endShadowAngle;

    @java.lang.Deprecated
    public float endX;

    @java.lang.Deprecated
    public float endY;
    private final java.util.List<com.google.android.material.shape.ShapePath.PathOperation> operations = new java.util.ArrayList();
    private final java.util.List<com.google.android.material.shape.ShapePath.ShadowCompatOperation> shadowCompatOperations = new java.util.ArrayList();

    @java.lang.Deprecated
    public float startX;

    @java.lang.Deprecated
    public float startY;

    public static abstract class PathOperation {
        protected final android.graphics.Matrix matrix = new android.graphics.Matrix();

        public abstract void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path);
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public ShapePath(float f_renamed, float f2) {
        reset(f_renamed, f2);
    }

    public void reset(float f_renamed, float f2) {
        reset(f_renamed, f2, ANGLE_UP, 0.0f);
    }

    public void reset(float f_renamed, float f2, float f3, float f4) {
        setStartX(f_renamed);
        setStartY(f2);
        setEndX(f_renamed);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public void lineTo(float f_renamed, float f2) {
        com.google.android.material.shape.ShapePath.PathLineOperation pathLineOperation = new com.google.android.material.shape.ShapePath.PathLineOperation();
        pathLineOperation.x_renamed = f_renamed;
        pathLineOperation.y_renamed = f2;
        this.operations.add(pathLineOperation);
        com.google.android.material.shape.ShapePath.LineShadowOperation lineShadowOperation = new com.google.android.material.shape.ShapePath.LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f_renamed);
        setEndY(f2);
    }

    public void quadToPoint(float f_renamed, float f2, float f3, float f4) {
        com.google.android.material.shape.ShapePath.PathQuadOperation pathQuadOperation = new com.google.android.material.shape.ShapePath.PathQuadOperation();
        pathQuadOperation.setControlX(f_renamed);
        pathQuadOperation.setControlY(f2);
        pathQuadOperation.setEndX(f3);
        pathQuadOperation.setEndY(f4);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    public void cubicToPoint(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new com.google.android.material.shape.ShapePath.PathCubicOperation(f_renamed, f2, f3, f4, f5, f6));
        this.containsIncompatibleShadowOp = true;
        setEndX(f5);
        setEndY(f6);
    }

    public void addArc(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        com.google.android.material.shape.ShapePath.PathArcOperation pathArcOperation = new com.google.android.material.shape.ShapePath.PathArcOperation(f_renamed, f2, f3, f4);
        pathArcOperation.setStartAngle(f5);
        pathArcOperation.setSweepAngle(f6);
        this.operations.add(pathArcOperation);
        com.google.android.material.shape.ShapePath.ArcShadowOperation arcShadowOperation = new com.google.android.material.shape.ShapePath.ArcShadowOperation(pathArcOperation);
        float f7 = f5 + f6;
        boolean z_renamed = f6 < 0.0f;
        if (z_renamed) {
            f5 = (f5 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f5, z_renamed ? (ANGLE_LEFT + f7) % 360.0f : f7);
        double d_renamed = f7;
        setEndX(((f_renamed + f3) * 0.5f) + (((f3 - f_renamed) / 2.0f) * ((float) java.lang.Math.cos(java.lang.Math.toRadians(d_renamed)))));
        setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) java.lang.Math.sin(java.lang.Math.toRadians(d_renamed)))));
    }

    public void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path) {
        int size = this.operations.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.operations.get(i_renamed).applyToPath(matrix, path);
        }
    }

    com.google.android.material.shape.ShapePath.ShadowCompatOperation createShadowCompatOperation(final android.graphics.Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final java.util.ArrayList arrayList = new java.util.ArrayList(this.shadowCompatOperations);
        return new com.google.android.material.shape.ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void draw(android.graphics.Matrix matrix2, com.google.android.material.shadow.ShadowRenderer shadowRenderer, int i_renamed, android.graphics.Canvas canvas) {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.google.android.material.shape.ShapePath.ShadowCompatOperation) it.next()).draw(matrix, shadowRenderer, i_renamed, canvas);
                }
            }
        };
    }

    private void addShadowCompatOperation(com.google.android.material.shape.ShapePath.ShadowCompatOperation shadowCompatOperation, float f_renamed, float f2) {
        addConnectingShadowIfNecessary(f_renamed);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f2);
    }

    boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    private void addConnectingShadowIfNecessary(float f_renamed) {
        if (getCurrentShadowAngle() == f_renamed) {
            return;
        }
        float currentShadowAngle = ((f_renamed - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > ANGLE_LEFT) {
            return;
        }
        com.google.android.material.shape.ShapePath.PathArcOperation pathArcOperation = new com.google.android.material.shape.ShapePath.PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new com.google.android.material.shape.ShapePath.ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f_renamed);
    }

    float getStartX() {
        return this.startX;
    }

    float getStartY() {
        return this.startY;
    }

    float getEndX() {
        return this.endX;
    }

    float getEndY() {
        return this.endY;
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setStartX(float f_renamed) {
        this.startX = f_renamed;
    }

    private void setStartY(float f_renamed) {
        this.startY = f_renamed;
    }

    private void setEndX(float f_renamed) {
        this.endX = f_renamed;
    }

    private void setEndY(float f_renamed) {
        this.endY = f_renamed;
    }

    private void setCurrentShadowAngle(float f_renamed) {
        this.currentShadowAngle = f_renamed;
    }

    private void setEndShadowAngle(float f_renamed) {
        this.endShadowAngle = f_renamed;
    }

    static abstract class ShadowCompatOperation {
        static final android.graphics.Matrix IDENTITY_MATRIX = new android.graphics.Matrix();

        public abstract void draw(android.graphics.Matrix matrix, com.google.android.material.shadow.ShadowRenderer shadowRenderer, int i_renamed, android.graphics.Canvas canvas);

        ShadowCompatOperation() {
        }

        public final void draw(com.google.android.material.shadow.ShadowRenderer shadowRenderer, int i_renamed, android.graphics.Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i_renamed, canvas);
        }
    }

    static class LineShadowOperation extends com.google.android.material.shape.ShapePath.ShadowCompatOperation {
        private final com.google.android.material.shape.ShapePath.PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(com.google.android.material.shape.ShapePath.PathLineOperation pathLineOperation, float f_renamed, float f2) {
            this.operation = pathLineOperation;
            this.startX = f_renamed;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(android.graphics.Matrix matrix, com.google.android.material.shadow.ShadowRenderer shadowRenderer, int i_renamed, android.graphics.Canvas canvas) {
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, (float) java.lang.Math.hypot(this.operation.y_renamed - this.startY, this.operation.x_renamed - this.startX), 0.0f);
            android.graphics.Matrix matrix2 = new android.graphics.Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i_renamed);
        }

        float getAngle() {
            return (float) java.lang.Math.toDegrees(java.lang.Math.atan((this.operation.y_renamed - this.startY) / (this.operation.x_renamed - this.startX)));
        }
    }

    static class ArcShadowOperation extends com.google.android.material.shape.ShapePath.ShadowCompatOperation {
        private final com.google.android.material.shape.ShapePath.PathArcOperation operation;

        public ArcShadowOperation(com.google.android.material.shape.ShapePath.PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(android.graphics.Matrix matrix, com.google.android.material.shadow.ShadowRenderer shadowRenderer, int i_renamed, android.graphics.Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new android.graphics.RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i_renamed, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }
    }

    public static class PathLineOperation extends com.google.android.material.shape.ShapePath.PathOperation {
        private float x_renamed;
        private float y_renamed;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path) {
            android.graphics.Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x_renamed, this.y_renamed);
            path.transform(matrix);
        }
    }

    public static class PathQuadOperation extends com.google.android.material.shape.ShapePath.PathOperation {

        @java.lang.Deprecated
        public float controlX;

        @java.lang.Deprecated
        public float controlY;

        @java.lang.Deprecated
        public float endX;

        @java.lang.Deprecated
        public float endY;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path) {
            android.graphics.Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }

        private float getEndX() {
            return this.endX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float f_renamed) {
            this.endX = f_renamed;
        }

        private float getControlY() {
            return this.controlY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float f_renamed) {
            this.controlY = f_renamed;
        }

        private float getEndY() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float f_renamed) {
            this.endY = f_renamed;
        }

        private float getControlX() {
            return this.controlX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float f_renamed) {
            this.controlX = f_renamed;
        }
    }

    public static class PathArcOperation extends com.google.android.material.shape.ShapePath.PathOperation {
        private static final android.graphics.RectF rectF = new android.graphics.RectF();

        @java.lang.Deprecated
        public float bottom;

        @java.lang.Deprecated
        public float left;

        @java.lang.Deprecated
        public float right;

        @java.lang.Deprecated
        public float startAngle;

        @java.lang.Deprecated
        public float sweepAngle;

        @java.lang.Deprecated
        public float top;

        public PathArcOperation(float f_renamed, float f2, float f3, float f4) {
            setLeft(f_renamed);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path) {
            android.graphics.Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            rectF.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        private void setLeft(float f_renamed) {
            this.left = f_renamed;
        }

        private void setTop(float f_renamed) {
            this.top = f_renamed;
        }

        private void setRight(float f_renamed) {
            this.right = f_renamed;
        }

        private void setBottom(float f_renamed) {
            this.bottom = f_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartAngle(float f_renamed) {
            this.startAngle = f_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float f_renamed) {
            this.sweepAngle = f_renamed;
        }
    }

    public static class PathCubicOperation extends com.google.android.material.shape.ShapePath.PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
            setControlX1(f_renamed);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(android.graphics.Matrix matrix, android.graphics.Path path) {
            android.graphics.Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private void setControlX1(float f_renamed) {
            this.controlX1 = f_renamed;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private void setControlY1(float f_renamed) {
            this.controlY1 = f_renamed;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private void setControlX2(float f_renamed) {
            this.controlX2 = f_renamed;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private void setControlY2(float f_renamed) {
            this.controlY2 = f_renamed;
        }

        private float getEndX() {
            return this.endX;
        }

        private void setEndX(float f_renamed) {
            this.endX = f_renamed;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setEndY(float f_renamed) {
            this.endY = f_renamed;
        }
    }
}
