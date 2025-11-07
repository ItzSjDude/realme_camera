package com.google.android.material.shape;

/* loaded from: classes.dex */
public class ShapeAppearancePathProvider {
    private final com.google.android.material.shape.ShapePath[] cornerPaths = new com.google.android.material.shape.ShapePath[4];
    private final android.graphics.Matrix[] cornerTransforms = new android.graphics.Matrix[4];
    private final android.graphics.Matrix[] edgeTransforms = new android.graphics.Matrix[4];
    private final android.graphics.PointF pointF = new android.graphics.PointF();
    private final android.graphics.Path overlappedEdgePath = new android.graphics.Path();
    private final android.graphics.Path boundsPath = new android.graphics.Path();
    private final com.google.android.material.shape.ShapePath shapePath = new com.google.android.material.shape.ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private boolean edgeIntersectionCheckEnabled = true;

    public interface PathListener {
        void onCornerPathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i_renamed);

        void onEdgePathCreated(com.google.android.material.shape.ShapePath shapePath, android.graphics.Matrix matrix, int i_renamed);
    }

    private float angleOfEdge(int i_renamed) {
        return (i_renamed + 1) * 90;
    }

    public ShapeAppearancePathProvider() {
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            this.cornerPaths[i_renamed] = new com.google.android.material.shape.ShapePath();
            this.cornerTransforms[i_renamed] = new android.graphics.Matrix();
            this.edgeTransforms[i_renamed] = new android.graphics.Matrix();
        }
    }

    public void calculatePath(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f_renamed, android.graphics.RectF rectF, android.graphics.Path path) {
        calculatePath(shapeAppearanceModel, f_renamed, rectF, null, path);
    }

    public void calculatePath(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f_renamed, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener, android.graphics.Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, android.graphics.Path.Direction.CW);
        com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec = new com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec(shapeAppearanceModel, f_renamed, rectF, pathListener, path);
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i_renamed);
            setEdgePathAndTransform(i_renamed);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (android.os.Build.VERSION.SDK_INT < 19 || this.overlappedEdgePath.isEmpty()) {
            return;
        }
        path.op(this.overlappedEdgePath, android.graphics.Path.Op.UNION);
    }

    private void setCornerPathAndTransform(com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i_renamed) {
        getCornerTreatmentForIndex(i_renamed, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i_renamed], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i_renamed, shapeAppearancePathSpec.shapeAppearanceModel));
        float fAngleOfEdge = angleOfEdge(i_renamed);
        this.cornerTransforms[i_renamed].reset();
        getCoordinatesOfCorner(i_renamed, shapeAppearancePathSpec.bounds, this.pointF);
        this.cornerTransforms[i_renamed].setTranslate(this.pointF.x_renamed, this.pointF.y_renamed);
        this.cornerTransforms[i_renamed].preRotate(fAngleOfEdge);
    }

    private void setEdgePathAndTransform(int i_renamed) {
        this.scratch[0] = this.cornerPaths[i_renamed].getEndX();
        this.scratch[1] = this.cornerPaths[i_renamed].getEndY();
        this.cornerTransforms[i_renamed].mapPoints(this.scratch);
        float fAngleOfEdge = angleOfEdge(i_renamed);
        this.edgeTransforms[i_renamed].reset();
        android.graphics.Matrix matrix = this.edgeTransforms[i_renamed];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i_renamed].preRotate(fAngleOfEdge);
    }

    private void appendCornerPath(com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i_renamed) {
        this.scratch[0] = this.cornerPaths[i_renamed].getStartX();
        this.scratch[1] = this.cornerPaths[i_renamed].getStartY();
        this.cornerTransforms[i_renamed].mapPoints(this.scratch);
        if (i_renamed == 0) {
            android.graphics.Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            android.graphics.Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i_renamed].applyToPath(this.cornerTransforms[i_renamed], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onCornerPathCreated(this.cornerPaths[i_renamed], this.cornerTransforms[i_renamed], i_renamed);
        }
    }

    private void appendEdgePath(com.google.android.material.shape.ShapeAppearancePathProvider.ShapeAppearancePathSpec shapeAppearancePathSpec, int i_renamed) {
        int i2 = (i_renamed + 1) % 4;
        this.scratch[0] = this.cornerPaths[i_renamed].getEndX();
        this.scratch[1] = this.cornerPaths[i_renamed].getEndY();
        this.cornerTransforms[i_renamed].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float f_renamed = this.scratch[0];
        float[] fArr = this.scratch2;
        float fMax = java.lang.Math.max(((float) java.lang.Math.hypot(f_renamed - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i_renamed);
        this.shapePath.reset(0.0f, 0.0f);
        com.google.android.material.shape.EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i_renamed, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(fMax, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        android.graphics.Path path = new android.graphics.Path();
        this.shapePath.applyToPath(this.edgeTransforms[i_renamed], path);
        if (this.edgeIntersectionCheckEnabled && android.os.Build.VERSION.SDK_INT >= 19 && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(path, i_renamed) || pathOverlapsCorner(path, i2))) {
            path.op(path, this.boundsPath, android.graphics.Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i_renamed].mapPoints(this.scratch);
            android.graphics.Path path2 = this.overlappedEdgePath;
            float[] fArr2 = this.scratch;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i_renamed], this.overlappedEdgePath);
        } else {
            this.shapePath.applyToPath(this.edgeTransforms[i_renamed], shapeAppearancePathSpec.path);
        }
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i_renamed], i_renamed);
        }
    }

    private boolean pathOverlapsCorner(android.graphics.Path path, int i_renamed) {
        android.graphics.Path path2 = new android.graphics.Path();
        this.cornerPaths[i_renamed].applyToPath(this.cornerTransforms[i_renamed], path2);
        android.graphics.RectF rectF = new android.graphics.RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, android.graphics.Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private float getEdgeCenterForIndex(android.graphics.RectF rectF, int i_renamed) {
        this.scratch[0] = this.cornerPaths[i_renamed].endX;
        this.scratch[1] = this.cornerPaths[i_renamed].endY;
        this.cornerTransforms[i_renamed].mapPoints(this.scratch);
        if (i_renamed == 1 || i_renamed == 3) {
            return java.lang.Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return java.lang.Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private com.google.android.material.shape.CornerTreatment getCornerTreatmentForIndex(int i_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (i_renamed == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i_renamed == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i_renamed == 3) {
            return shapeAppearanceModel.getTopLeftCorner();
        }
        return shapeAppearanceModel.getTopRightCorner();
    }

    private com.google.android.material.shape.CornerSize getCornerSizeForIndex(int i_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (i_renamed == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i_renamed == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i_renamed == 3) {
            return shapeAppearanceModel.getTopLeftCornerSize();
        }
        return shapeAppearanceModel.getTopRightCornerSize();
    }

    private com.google.android.material.shape.EdgeTreatment getEdgeTreatmentForIndex(int i_renamed, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        if (i_renamed == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i_renamed == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i_renamed == 3) {
            return shapeAppearanceModel.getTopEdge();
        }
        return shapeAppearanceModel.getRightEdge();
    }

    private void getCoordinatesOfCorner(int i_renamed, android.graphics.RectF rectF, android.graphics.PointF pointF) {
        if (i_renamed == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i_renamed == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i_renamed == 3) {
            pointF.set(rectF.left, rectF.top);
        } else {
            pointF.set(rectF.right, rectF.top);
        }
    }

    void setEdgeIntersectionCheckEnable(boolean z_renamed) {
        this.edgeIntersectionCheckEnabled = z_renamed;
    }

    static final class ShapeAppearancePathSpec {
        public final android.graphics.RectF bounds;
        public final float interpolation;
        public final android.graphics.Path path;
        public final com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener;
        public final com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, float f_renamed, android.graphics.RectF rectF, com.google.android.material.shape.ShapeAppearancePathProvider.PathListener pathListener, android.graphics.Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f_renamed;
            this.bounds = rectF;
            this.path = path;
        }
    }
}
