package com.google.android.material.shape;

/* loaded from: classes.dex */
public class EdgeTreatment {
    boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float COUIBaseListPopupWindow_12, float f2, ShapePath shapePath) {
        getEdgePath(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12 / 2.0f, f2, shapePath);
    }

    public void getEdgePath(float COUIBaseListPopupWindow_12, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(COUIBaseListPopupWindow_12, 0.0f);
    }
}
