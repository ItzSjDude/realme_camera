package com.google.android.material.transition;

/* loaded from: classes.dex */
public class MaterialArcMotion extends android.transition.PathMotion {
    @Override // android.transition.PathMotion
    public android.graphics.Path getPath(float f_renamed, float f2, float f3, float f4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(f_renamed, f2);
        android.graphics.PointF controlPoint = getControlPoint(f_renamed, f2, f3, f4);
        path.quadTo(controlPoint.x_renamed, controlPoint.y_renamed, f3, f4);
        return path;
    }

    private static android.graphics.PointF getControlPoint(float f_renamed, float f2, float f3, float f4) {
        if (f2 > f4) {
            return new android.graphics.PointF(f3, f2);
        }
        return new android.graphics.PointF(f_renamed, f4);
    }
}
