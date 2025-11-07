package com.google.android.material.transition;

/* loaded from: classes.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    static com.google.android.material.transition.FadeModeResult startOnTop(int i_renamed, int i2) {
        return new com.google.android.material.transition.FadeModeResult(i_renamed, i2, false);
    }

    static com.google.android.material.transition.FadeModeResult endOnTop(int i_renamed, int i2) {
        return new com.google.android.material.transition.FadeModeResult(i_renamed, i2, true);
    }

    private FadeModeResult(int i_renamed, int i2, boolean z_renamed) {
        this.startAlpha = i_renamed;
        this.endAlpha = i2;
        this.endOnTop = z_renamed;
    }
}
