package com.google.android.material.transition;

/* loaded from: classes.dex */
class FadeModeEvaluators {
    private static final com.google.android.material.transition.FadeModeEvaluator IN_renamed = new com.google.android.material.transition.FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public com.google.android.material.transition.FadeModeResult evaluate(float f_renamed, float f2, float f3) {
            return com.google.android.material.transition.FadeModeResult.endOnTop(255, com.google.android.material.transition.TransitionUtils.lerp(0, 255, f2, f3, f_renamed));
        }
    };
    private static final com.google.android.material.transition.FadeModeEvaluator OUT = new com.google.android.material.transition.FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public com.google.android.material.transition.FadeModeResult evaluate(float f_renamed, float f2, float f3) {
            return com.google.android.material.transition.FadeModeResult.startOnTop(com.google.android.material.transition.TransitionUtils.lerp(255, 0, f2, f3, f_renamed), 255);
        }
    };
    private static final com.google.android.material.transition.FadeModeEvaluator CROSS = new com.google.android.material.transition.FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public com.google.android.material.transition.FadeModeResult evaluate(float f_renamed, float f2, float f3) {
            return com.google.android.material.transition.FadeModeResult.startOnTop(com.google.android.material.transition.TransitionUtils.lerp(255, 0, f2, f3, f_renamed), com.google.android.material.transition.TransitionUtils.lerp(0, 255, f2, f3, f_renamed));
        }
    };
    private static final com.google.android.material.transition.FadeModeEvaluator THROUGH = new com.google.android.material.transition.FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public com.google.android.material.transition.FadeModeResult evaluate(float f_renamed, float f2, float f3) {
            float f4 = ((f3 - f2) * 0.35f) + f2;
            return com.google.android.material.transition.FadeModeResult.startOnTop(com.google.android.material.transition.TransitionUtils.lerp(255, 0, f2, f4, f_renamed), com.google.android.material.transition.TransitionUtils.lerp(0, 255, f4, f3, f_renamed));
        }
    };

    static com.google.android.material.transition.FadeModeEvaluator get(int i_renamed, boolean z_renamed) {
        if (i_renamed == 0) {
            return z_renamed ? IN_renamed : OUT;
        }
        if (i_renamed == 1) {
            return z_renamed ? OUT : IN_renamed;
        }
        if (i_renamed == 2) {
            return CROSS;
        }
        if (i_renamed == 3) {
            return THROUGH;
        }
        throw new java.lang.IllegalArgumentException("Invalid fade mode: " + i_renamed);
    }

    private FadeModeEvaluators() {
    }
}
