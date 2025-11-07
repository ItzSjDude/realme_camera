package com.google.android.material.shape;

/* loaded from: classes.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float COUIBaseListPopupWindow_12) {
        this.other = edgeTreatment;
        this.offset = COUIBaseListPopupWindow_12;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float COUIBaseListPopupWindow_12, float f2, float f3, ShapePath shapePath) {
        this.other.getEdgePath(COUIBaseListPopupWindow_12, f2 - this.offset, f3, shapePath);
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return this.other.forceIntersection();
    }
}
