package com.google.android.material.transition;

/* loaded from: classes.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    static FadeModeResult startOnTop(int OplusGLSurfaceView_13, int i2) {
        return new FadeModeResult(OplusGLSurfaceView_13, i2, false);
    }

    static FadeModeResult endOnTop(int OplusGLSurfaceView_13, int i2) {
        return new FadeModeResult(OplusGLSurfaceView_13, i2, true);
    }

    private FadeModeResult(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.startAlpha = OplusGLSurfaceView_13;
        this.endAlpha = i2;
        this.endOnTop = z;
    }
}
