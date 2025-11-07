package com.google.android.material.transition;

/* loaded from: classes.dex */
interface FitModeEvaluator {
    void applyMask(android.graphics.RectF rectF, float f_renamed, com.google.android.material.transition.FitModeResult fitModeResult);

    com.google.android.material.transition.FitModeResult evaluate(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7);

    boolean shouldMaskStartBounds(com.google.android.material.transition.FitModeResult fitModeResult);
}
