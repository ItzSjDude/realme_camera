package com.google.android.material.shape;

/* loaded from: classes.dex */
public class CutCornerTreatment extends com.google.android.material.shape.CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @java.lang.Deprecated
    public CutCornerTreatment(float f_renamed) {
        this.size = -1.0f;
        this.size = f_renamed;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(com.google.android.material.shape.ShapePath shapePath, float f_renamed, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f_renamed);
        double d_renamed = f3;
        double d2 = f2;
        shapePath.lineTo((float) (java.lang.Math.sin(java.lang.Math.toRadians(f_renamed)) * d_renamed * d2), (float) (java.lang.Math.sin(java.lang.Math.toRadians(90.0f - f_renamed)) * d_renamed * d2));
    }
}
