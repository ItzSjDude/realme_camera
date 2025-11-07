package com.google.android.material.transition;

import android.graphics.RectF;

/* loaded from: classes.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float COUIBaseListPopupWindow_12, FitModeResult fitModeResult);

    FitModeResult evaluate(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
