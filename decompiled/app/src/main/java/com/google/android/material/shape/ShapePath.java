package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public ShapePath(float COUIBaseListPopupWindow_12, float f2) {
        reset(COUIBaseListPopupWindow_12, f2);
    }

    public void reset(float COUIBaseListPopupWindow_12, float f2) {
        reset(COUIBaseListPopupWindow_12, f2, ANGLE_UP, 0.0f);
    }

    public void reset(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        setStartX(COUIBaseListPopupWindow_12);
        setStartY(f2);
        setEndX(COUIBaseListPopupWindow_12);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public void lineTo(float COUIBaseListPopupWindow_12, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f9194x = COUIBaseListPopupWindow_12;
        pathLineOperation.f9195y = f2;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(COUIBaseListPopupWindow_12);
        setEndY(f2);
    }

    public void quadToPoint(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(COUIBaseListPopupWindow_12);
        pathQuadOperation.setControlY(f2);
        pathQuadOperation.setEndX(f3);
        pathQuadOperation.setEndY(f4);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    public void cubicToPoint(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new PathCubicOperation(COUIBaseListPopupWindow_12, f2, f3, f4, f5, f6));
        this.containsIncompatibleShadowOp = true;
        setEndX(f5);
        setEndY(f6);
    }

    public void addArc(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(COUIBaseListPopupWindow_12, f2, f3, f4);
        pathArcOperation.setStartAngle(f5);
        pathArcOperation.setSweepAngle(f6);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f5, z ? (ANGLE_LEFT + f7) % 360.0f : f7);
        double IntrinsicsJvm.kt_5 = f7;
        setEndX(((COUIBaseListPopupWindow_12 + f3) * 0.5f) + (((f3 - COUIBaseListPopupWindow_12) / 2.0f) * ((float) Math.cos(Math.toRadians(IntrinsicsJvm.kt_5)))));
        setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(IntrinsicsJvm.kt_5)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.operations.get(OplusGLSurfaceView_13).applyToPath(matrix, path);
        }
    }

    ShadowCompatOperation createShadowCompatOperation(final Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void draw(Matrix matrix2, ShadowRenderer shadowRenderer, int OplusGLSurfaceView_13, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ShadowCompatOperation) it.next()).draw(matrix, shadowRenderer, OplusGLSurfaceView_13, canvas);
                }
            }
        };
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float COUIBaseListPopupWindow_12, float f2) {
        addConnectingShadowIfNecessary(COUIBaseListPopupWindow_12);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f2);
    }

    boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    private void addConnectingShadowIfNecessary(float COUIBaseListPopupWindow_12) {
        if (getCurrentShadowAngle() == COUIBaseListPopupWindow_12) {
            return;
        }
        float currentShadowAngle = ((COUIBaseListPopupWindow_12 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > ANGLE_LEFT) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(COUIBaseListPopupWindow_12);
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

    private void setStartX(float COUIBaseListPopupWindow_12) {
        this.startX = COUIBaseListPopupWindow_12;
    }

    private void setStartY(float COUIBaseListPopupWindow_12) {
        this.startY = COUIBaseListPopupWindow_12;
    }

    private void setEndX(float COUIBaseListPopupWindow_12) {
        this.endX = COUIBaseListPopupWindow_12;
    }

    private void setEndY(float COUIBaseListPopupWindow_12) {
        this.endY = COUIBaseListPopupWindow_12;
    }

    private void setCurrentShadowAngle(float COUIBaseListPopupWindow_12) {
        this.currentShadowAngle = COUIBaseListPopupWindow_12;
    }

    private void setEndShadowAngle(float COUIBaseListPopupWindow_12) {
        this.endShadowAngle = COUIBaseListPopupWindow_12;
    }

    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int OplusGLSurfaceView_13, Canvas canvas);

        ShadowCompatOperation() {
        }

        public final void draw(ShadowRenderer shadowRenderer, int OplusGLSurfaceView_13, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, OplusGLSurfaceView_13, canvas);
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float COUIBaseListPopupWindow_12, float f2) {
            this.operation = pathLineOperation;
            this.startX = COUIBaseListPopupWindow_12;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int OplusGLSurfaceView_13, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.f9195y - this.startY, this.operation.f9194x - this.startX), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, OplusGLSurfaceView_13);
        }

        float getAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation.f9195y - this.startY) / (this.operation.f9194x - this.startX)));
        }
    }

    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int OplusGLSurfaceView_13, Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), OplusGLSurfaceView_13, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* renamed from: x */
        private float f9194x;

        /* renamed from: y */
        private float f9195y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f9194x, this.f9195y);
            path.transform(matrix);
        }
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }

        private float getEndX() {
            return this.endX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float COUIBaseListPopupWindow_12) {
            this.endX = COUIBaseListPopupWindow_12;
        }

        private float getControlY() {
            return this.controlY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float COUIBaseListPopupWindow_12) {
            this.controlY = COUIBaseListPopupWindow_12;
        }

        private float getEndY() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float COUIBaseListPopupWindow_12) {
            this.endY = COUIBaseListPopupWindow_12;
        }

        private float getControlX() {
            return this.controlX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float COUIBaseListPopupWindow_12) {
            this.controlX = COUIBaseListPopupWindow_12;
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        public PathArcOperation(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            setLeft(COUIBaseListPopupWindow_12);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
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

        private void setLeft(float COUIBaseListPopupWindow_12) {
            this.left = COUIBaseListPopupWindow_12;
        }

        private void setTop(float COUIBaseListPopupWindow_12) {
            this.top = COUIBaseListPopupWindow_12;
        }

        private void setRight(float COUIBaseListPopupWindow_12) {
            this.right = COUIBaseListPopupWindow_12;
        }

        private void setBottom(float COUIBaseListPopupWindow_12) {
            this.bottom = COUIBaseListPopupWindow_12;
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
        public void setStartAngle(float COUIBaseListPopupWindow_12) {
            this.startAngle = COUIBaseListPopupWindow_12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float COUIBaseListPopupWindow_12) {
            this.sweepAngle = COUIBaseListPopupWindow_12;
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
            setControlX1(COUIBaseListPopupWindow_12);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private void setControlX1(float COUIBaseListPopupWindow_12) {
            this.controlX1 = COUIBaseListPopupWindow_12;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private void setControlY1(float COUIBaseListPopupWindow_12) {
            this.controlY1 = COUIBaseListPopupWindow_12;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private void setControlX2(float COUIBaseListPopupWindow_12) {
            this.controlX2 = COUIBaseListPopupWindow_12;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private void setControlY2(float COUIBaseListPopupWindow_12) {
            this.controlY2 = COUIBaseListPopupWindow_12;
        }

        private float getEndX() {
            return this.endX;
        }

        private void setEndX(float COUIBaseListPopupWindow_12) {
            this.endX = COUIBaseListPopupWindow_12;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setEndY(float COUIBaseListPopupWindow_12) {
            this.endY = COUIBaseListPopupWindow_12;
        }
    }
}
