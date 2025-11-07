package com.google.android.material.transition;

/* loaded from: classes.dex */
class FadeModeEvaluators {

    /* renamed from: IN */
    private static final FadeModeEvaluator f9196IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float COUIBaseListPopupWindow_12, float f2, float f3) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f2, f3, COUIBaseListPopupWindow_12));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float COUIBaseListPopupWindow_12, float f2, float f3) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, COUIBaseListPopupWindow_12), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float COUIBaseListPopupWindow_12, float f2, float f3) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, COUIBaseListPopupWindow_12), TransitionUtils.lerp(0, 255, f2, f3, COUIBaseListPopupWindow_12));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float COUIBaseListPopupWindow_12, float f2, float f3) {
            float f4 = ((f3 - f2) * 0.35f) + f2;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f4, COUIBaseListPopupWindow_12), TransitionUtils.lerp(0, 255, f4, f3, COUIBaseListPopupWindow_12));
        }
    };

    static FadeModeEvaluator get(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == 0) {
            return z ? f9196IN : OUT;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return z ? OUT : f9196IN;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return CROSS;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + OplusGLSurfaceView_13);
    }

    private FadeModeEvaluators() {
    }
}
