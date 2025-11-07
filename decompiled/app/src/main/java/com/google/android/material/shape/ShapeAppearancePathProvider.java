package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* loaded from: classes.dex */
public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final Path overlappedEdgePath = new Path();
    private final Path boundsPath = new Path();
    private final ShapePath shapePath = new ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private boolean edgeIntersectionCheckEnabled = true;

    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int OplusGLSurfaceView_13);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int OplusGLSurfaceView_13);
    }

    private float angleOfEdge(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 + 1) * 90;
    }

    public ShapeAppearancePathProvider() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            this.cornerPaths[OplusGLSurfaceView_13] = new ShapePath();
            this.cornerTransforms[OplusGLSurfaceView_13] = new Matrix();
            this.edgeTransforms[OplusGLSurfaceView_13] = new Matrix();
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float COUIBaseListPopupWindow_12, RectF rectF, Path path) {
        calculatePath(shapeAppearanceModel, COUIBaseListPopupWindow_12, rectF, null, path);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float COUIBaseListPopupWindow_12, RectF rectF, PathListener pathListener, Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, COUIBaseListPopupWindow_12, rectF, pathListener, path);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, OplusGLSurfaceView_13);
            setEdgePathAndTransform(OplusGLSurfaceView_13);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (Build.VERSION.SDK_INT < 19 || this.overlappedEdgePath.isEmpty()) {
            return;
        }
        path.op(this.overlappedEdgePath, Path.Op.UNION);
    }

    private void setCornerPathAndTransform(ShapeAppearancePathSpec shapeAppearancePathSpec, int OplusGLSurfaceView_13) {
        getCornerTreatmentForIndex(OplusGLSurfaceView_13, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[OplusGLSurfaceView_13], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(OplusGLSurfaceView_13, shapeAppearancePathSpec.shapeAppearanceModel));
        float fAngleOfEdge = angleOfEdge(OplusGLSurfaceView_13);
        this.cornerTransforms[OplusGLSurfaceView_13].reset();
        getCoordinatesOfCorner(OplusGLSurfaceView_13, shapeAppearancePathSpec.bounds, this.pointF);
        this.cornerTransforms[OplusGLSurfaceView_13].setTranslate(this.pointF.x, this.pointF.y);
        this.cornerTransforms[OplusGLSurfaceView_13].preRotate(fAngleOfEdge);
    }

    private void setEdgePathAndTransform(int OplusGLSurfaceView_13) {
        this.scratch[0] = this.cornerPaths[OplusGLSurfaceView_13].getEndX();
        this.scratch[1] = this.cornerPaths[OplusGLSurfaceView_13].getEndY();
        this.cornerTransforms[OplusGLSurfaceView_13].mapPoints(this.scratch);
        float fAngleOfEdge = angleOfEdge(OplusGLSurfaceView_13);
        this.edgeTransforms[OplusGLSurfaceView_13].reset();
        Matrix matrix = this.edgeTransforms[OplusGLSurfaceView_13];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[OplusGLSurfaceView_13].preRotate(fAngleOfEdge);
    }

    private void appendCornerPath(ShapeAppearancePathSpec shapeAppearancePathSpec, int OplusGLSurfaceView_13) {
        this.scratch[0] = this.cornerPaths[OplusGLSurfaceView_13].getStartX();
        this.scratch[1] = this.cornerPaths[OplusGLSurfaceView_13].getStartY();
        this.cornerTransforms[OplusGLSurfaceView_13].mapPoints(this.scratch);
        if (OplusGLSurfaceView_13 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[OplusGLSurfaceView_13].applyToPath(this.cornerTransforms[OplusGLSurfaceView_13], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onCornerPathCreated(this.cornerPaths[OplusGLSurfaceView_13], this.cornerTransforms[OplusGLSurfaceView_13], OplusGLSurfaceView_13);
        }
    }

    private void appendEdgePath(ShapeAppearancePathSpec shapeAppearancePathSpec, int OplusGLSurfaceView_13) {
        int i2 = (OplusGLSurfaceView_13 + 1) % 4;
        this.scratch[0] = this.cornerPaths[OplusGLSurfaceView_13].getEndX();
        this.scratch[1] = this.cornerPaths[OplusGLSurfaceView_13].getEndY();
        this.cornerTransforms[OplusGLSurfaceView_13].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float COUIBaseListPopupWindow_12 = this.scratch[0];
        float[] fArr = this.scratch2;
        float fMax = Math.max(((float) Math.hypot(COUIBaseListPopupWindow_12 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, OplusGLSurfaceView_13);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(OplusGLSurfaceView_13, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(fMax, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        Path path = new Path();
        this.shapePath.applyToPath(this.edgeTransforms[OplusGLSurfaceView_13], path);
        if (this.edgeIntersectionCheckEnabled && Build.VERSION.SDK_INT >= 19 && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(path, OplusGLSurfaceView_13) || pathOverlapsCorner(path, i2))) {
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[OplusGLSurfaceView_13].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr2 = this.scratch;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.shapePath.applyToPath(this.edgeTransforms[OplusGLSurfaceView_13], this.overlappedEdgePath);
        } else {
            this.shapePath.applyToPath(this.edgeTransforms[OplusGLSurfaceView_13], shapeAppearancePathSpec.path);
        }
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[OplusGLSurfaceView_13], OplusGLSurfaceView_13);
        }
    }

    private boolean pathOverlapsCorner(Path path, int OplusGLSurfaceView_13) {
        Path path2 = new Path();
        this.cornerPaths[OplusGLSurfaceView_13].applyToPath(this.cornerTransforms[OplusGLSurfaceView_13], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private float getEdgeCenterForIndex(RectF rectF, int OplusGLSurfaceView_13) {
        this.scratch[0] = this.cornerPaths[OplusGLSurfaceView_13].endX;
        this.scratch[1] = this.cornerPaths[OplusGLSurfaceView_13].endY;
        this.cornerTransforms[OplusGLSurfaceView_13].mapPoints(this.scratch);
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private CornerTreatment getCornerTreatmentForIndex(int OplusGLSurfaceView_13, ShapeAppearanceModel shapeAppearanceModel) {
        if (OplusGLSurfaceView_13 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (OplusGLSurfaceView_13 == 3) {
            return shapeAppearanceModel.getTopLeftCorner();
        }
        return shapeAppearanceModel.getTopRightCorner();
    }

    private CornerSize getCornerSizeForIndex(int OplusGLSurfaceView_13, ShapeAppearanceModel shapeAppearanceModel) {
        if (OplusGLSurfaceView_13 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (OplusGLSurfaceView_13 == 3) {
            return shapeAppearanceModel.getTopLeftCornerSize();
        }
        return shapeAppearanceModel.getTopRightCornerSize();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int OplusGLSurfaceView_13, ShapeAppearanceModel shapeAppearanceModel) {
        if (OplusGLSurfaceView_13 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (OplusGLSurfaceView_13 == 3) {
            return shapeAppearanceModel.getTopEdge();
        }
        return shapeAppearanceModel.getRightEdge();
    }

    private void getCoordinatesOfCorner(int OplusGLSurfaceView_13, RectF rectF, PointF pointF) {
        if (OplusGLSurfaceView_13 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (OplusGLSurfaceView_13 == 3) {
            pointF.set(rectF.left, rectF.top);
        } else {
            pointF.set(rectF.right, rectF.top);
        }
    }

    void setEdgeIntersectionCheckEnable(boolean z) {
        this.edgeIntersectionCheckEnabled = z;
    }

    static final class ShapeAppearancePathSpec {
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel, float COUIBaseListPopupWindow_12, RectF rectF, PathListener pathListener, Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = COUIBaseListPopupWindow_12;
            this.bounds = rectF;
            this.path = path;
        }
    }
}
