package com.google.android.material.bottomappbar;

/* loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends com.google.android.material.shape.EdgeTreatment implements java.lang.Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f_renamed, float f2, float f3) {
        this.fabMargin = f_renamed;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
        this.horizontalOffset = 0.0f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f_renamed, float f2, float f3, com.google.android.material.shape.ShapePath shapePath) {
        float f4 = this.fabDiameter;
        if (f4 == 0.0f) {
            shapePath.lineTo(f_renamed, 0.0f);
            return;
        }
        float f5 = ((this.fabMargin * 2.0f) + f4) / 2.0f;
        float f6 = f3 * this.roundedCornerRadius;
        float f7 = f2 + this.horizontalOffset;
        float f8 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f5);
        if (f8 / f5 >= 1.0f) {
            shapePath.lineTo(f_renamed, 0.0f);
            return;
        }
        float f9 = f5 + f6;
        float f10 = f8 + f6;
        float fSqrt = (float) java.lang.Math.sqrt((f9 * f9) - (f10 * f10));
        float f11 = f7 - fSqrt;
        float f12 = f7 + fSqrt;
        float degrees = (float) java.lang.Math.toDegrees(java.lang.Math.atan(fSqrt / f10));
        float f13 = 90.0f - degrees;
        shapePath.lineTo(f11, 0.0f);
        float f14 = f6 * 2.0f;
        shapePath.addArc(f11 - f6, 0.0f, f11 + f6, f14, 270.0f, degrees);
        shapePath.addArc(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        shapePath.addArc(f12 - f6, 0.0f, f12 + f6, f14, 270.0f - degrees, degrees);
        shapePath.lineTo(f_renamed, 0.0f);
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public void setFabDiameter(float f_renamed) {
        this.fabDiameter = f_renamed;
    }

    void setHorizontalOffset(float f_renamed) {
        this.horizontalOffset = f_renamed;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    void setCradleVerticalOffset(float f_renamed) {
        if (f_renamed < 0.0f) {
            throw new java.lang.IllegalArgumentException("cradleVerticalOffset must be_renamed positive.");
        }
        this.cradleVerticalOffset = f_renamed;
    }

    float getFabCradleMargin() {
        return this.fabMargin;
    }

    void setFabCradleMargin(float f_renamed) {
        this.fabMargin = f_renamed;
    }

    float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    void setFabCradleRoundedCornerRadius(float f_renamed) {
        this.roundedCornerRadius = f_renamed;
    }
}
