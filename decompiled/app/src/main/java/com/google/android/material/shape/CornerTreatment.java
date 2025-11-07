package com.google.android.material.shape;

import android.graphics.RectF;

/* loaded from: classes.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float COUIBaseListPopupWindow_12, float f2, ShapePath shapePath) {
    }

    public void getCornerPath(ShapePath shapePath, float COUIBaseListPopupWindow_12, float f2, float f3) {
        getCornerPath(COUIBaseListPopupWindow_12, f2, shapePath);
    }

    public void getCornerPath(ShapePath shapePath, float COUIBaseListPopupWindow_12, float f2, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, COUIBaseListPopupWindow_12, f2, cornerSize.getCornerSize(rectF));
    }
}
