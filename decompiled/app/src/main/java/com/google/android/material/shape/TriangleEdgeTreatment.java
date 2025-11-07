package com.google.android.material.shape;

/* loaded from: classes.dex */
public class TriangleEdgeTreatment extends com.google.android.material.shape.EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f_renamed, boolean z_renamed) {
        this.size = f_renamed;
        this.inside = z_renamed;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f_renamed, float f2, float f3, com.google.android.material.shape.ShapePath shapePath) {
        shapePath.lineTo(f2 - (this.size * f3), 0.0f);
        shapePath.lineTo(f2, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo(f2 + (this.size * f3), 0.0f);
        shapePath.lineTo(f_renamed, 0.0f);
    }
}
