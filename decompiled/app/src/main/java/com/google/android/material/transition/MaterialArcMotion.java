package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;

/* loaded from: classes.dex */
public class MaterialArcMotion extends PathMotion {
    @Override // android.transition.PathMotion
    public Path getPath(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(COUIBaseListPopupWindow_12, f2);
        PointF controlPoint = getControlPoint(COUIBaseListPopupWindow_12, f2, f3, f4);
        path.quadTo(controlPoint.x, controlPoint.y, f3, f4);
        return path;
    }

    private static PointF getControlPoint(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        if (f2 > f4) {
            return new PointF(f3, f2);
        }
        return new PointF(COUIBaseListPopupWindow_12, f4);
    }
}
