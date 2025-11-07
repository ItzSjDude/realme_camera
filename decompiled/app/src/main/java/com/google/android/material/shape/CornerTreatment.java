package com.google.android.material.shape;

/* loaded from: classes.dex */
public class CornerTreatment {
    @java.lang.Deprecated
    public void getCornerPath(float f_renamed, float f2, com.google.android.material.shape.ShapePath shapePath) {
    }

    public void getCornerPath(com.google.android.material.shape.ShapePath shapePath, float f_renamed, float f2, float f3) {
        getCornerPath(f_renamed, f2, shapePath);
    }

    public void getCornerPath(com.google.android.material.shape.ShapePath shapePath, float f_renamed, float f2, android.graphics.RectF rectF, com.google.android.material.shape.CornerSize cornerSize) {
        getCornerPath(shapePath, f_renamed, f2, cornerSize.getCornerSize(rectF));
    }
}
