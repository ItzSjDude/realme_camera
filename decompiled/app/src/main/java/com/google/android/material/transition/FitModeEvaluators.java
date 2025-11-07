package com.google.android.material.transition;

/* loaded from: classes.dex */
class FitModeEvaluators {
    private static final com.google.android.material.transition.FitModeEvaluator WIDTH = new com.google.android.material.transition.FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
        @Override // com.google.android.material.transition.FitModeEvaluator
        public com.google.android.material.transition.FitModeResult evaluate(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fLerp = com.google.android.material.transition.TransitionUtils.lerp(f4, f6, f2, f3, f_renamed);
            float f8 = fLerp / f4;
            float f9 = fLerp / f6;
            return new com.google.android.material.transition.FitModeResult(f8, f9, fLerp, f5 * f8, fLerp, f7 * f9);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(com.google.android.material.transition.FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(android.graphics.RectF rectF, float f_renamed, com.google.android.material.transition.FitModeResult fitModeResult) {
            rectF.bottom -= java.lang.Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f_renamed;
        }
    };
    private static final com.google.android.material.transition.FitModeEvaluator HEIGHT = new com.google.android.material.transition.FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
        @Override // com.google.android.material.transition.FitModeEvaluator
        public com.google.android.material.transition.FitModeResult evaluate(float f_renamed, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fLerp = com.google.android.material.transition.TransitionUtils.lerp(f5, f7, f2, f3, f_renamed);
            float f8 = fLerp / f5;
            float f9 = fLerp / f7;
            return new com.google.android.material.transition.FitModeResult(f8, f9, f4 * f8, fLerp, f6 * f9, fLerp);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(com.google.android.material.transition.FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(android.graphics.RectF rectF, float f_renamed, com.google.android.material.transition.FitModeResult fitModeResult) {
            float fAbs = (java.lang.Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f_renamed;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    };

    static com.google.android.material.transition.FitModeEvaluator get(int i_renamed, boolean z_renamed, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        if (i_renamed == 0) {
            return shouldAutoFitToWidth(z_renamed, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i_renamed == 1) {
            return WIDTH;
        }
        if (i_renamed == 2) {
            return HEIGHT;
        }
        throw new java.lang.IllegalArgumentException("Invalid fit mode: " + i_renamed);
    }

    private static boolean shouldAutoFitToWidth(boolean z_renamed, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f_renamed = (fHeight2 * fWidth) / fWidth2;
        float f2 = (fWidth2 * fHeight) / fWidth;
        if (z_renamed) {
            if (f_renamed >= fHeight) {
                return true;
            }
        } else if (f2 >= fHeight2) {
            return true;
        }
        return false;
    }

    private FitModeEvaluators() {
    }
}
