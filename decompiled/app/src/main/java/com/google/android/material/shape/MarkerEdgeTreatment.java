package com.google.android.material.shape;

/* loaded from: classes.dex */
public final class MarkerEdgeTreatment extends com.google.android.material.shape.EdgeTreatment {
    private final float radius;

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return true;
    }

    public MarkerEdgeTreatment(float f_renamed) {
        this.radius = f_renamed - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f_renamed, float f2, float f3, com.google.android.material.shape.ShapePath shapePath) {
        float fSqrt = (float) ((this.radius * java.lang.Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) java.lang.Math.sqrt(java.lang.Math.pow(this.radius, 2.0d) - java.lang.Math.pow(fSqrt, 2.0d));
        shapePath.reset(f2 - fSqrt, ((float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius))) + fSqrt2);
        shapePath.lineTo(f2, (float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius)));
        shapePath.lineTo(f2 + fSqrt, ((float) (-((this.radius * java.lang.Math.sqrt(2.0d)) - this.radius))) + fSqrt2);
    }
}
