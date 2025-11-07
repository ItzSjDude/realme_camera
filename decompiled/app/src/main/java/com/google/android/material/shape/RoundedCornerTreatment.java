package com.google.android.material.shape;

/* loaded from: classes.dex */
public class RoundedCornerTreatment extends com.google.android.material.shape.CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @java.lang.Deprecated
    public RoundedCornerTreatment(float f_renamed) {
        this.radius = -1.0f;
        this.radius = f_renamed;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(com.google.android.material.shape.ShapePath shapePath, float f_renamed, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f_renamed);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(0.0f, 0.0f, f4, f4, 180.0f, f_renamed);
    }
}
