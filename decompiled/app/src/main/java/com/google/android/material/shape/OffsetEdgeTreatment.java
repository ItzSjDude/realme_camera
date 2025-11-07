package com.google.android.material.shape;

/* loaded from: classes.dex */
public final class OffsetEdgeTreatment extends com.google.android.material.shape.EdgeTreatment {
    private final float offset;
    private final com.google.android.material.shape.EdgeTreatment other;

    public OffsetEdgeTreatment(com.google.android.material.shape.EdgeTreatment edgeTreatment, float f_renamed) {
        this.other = edgeTreatment;
        this.offset = f_renamed;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f_renamed, float f2, float f3, com.google.android.material.shape.ShapePath shapePath) {
        this.other.getEdgePath(f_renamed, f2 - this.offset, f3, shapePath);
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return this.other.forceIntersection();
    }
}
