package com.google.android.material.shape;

/* loaded from: classes.dex */
public class EdgeTreatment {
    boolean forceIntersection() {
        return false;
    }

    @java.lang.Deprecated
    public void getEdgePath(float f_renamed, float f2, com.google.android.material.shape.ShapePath shapePath) {
        getEdgePath(f_renamed, f_renamed / 2.0f, f2, shapePath);
    }

    public void getEdgePath(float f_renamed, float f2, float f3, com.google.android.material.shape.ShapePath shapePath) {
        shapePath.lineTo(f_renamed, 0.0f);
    }
}
