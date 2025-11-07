package com.google.android.material.shape;

/* loaded from: classes.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Deprecated
    public CutCornerTreatment(float COUIBaseListPopupWindow_12) {
        this.size = -1.0f;
        this.size = COUIBaseListPopupWindow_12;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath shapePath, float COUIBaseListPopupWindow_12, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - COUIBaseListPopupWindow_12);
        double IntrinsicsJvm.kt_5 = f3;
        double d2 = f2;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(COUIBaseListPopupWindow_12)) * IntrinsicsJvm.kt_5 * d2), (float) (Math.sin(Math.toRadians(90.0f - COUIBaseListPopupWindow_12)) * IntrinsicsJvm.kt_5 * d2));
    }
}
