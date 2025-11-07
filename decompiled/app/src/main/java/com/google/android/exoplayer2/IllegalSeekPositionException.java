package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.timeline = timeline;
        this.windowIndex = OplusGLSurfaceView_13;
        this.positionMs = OplusGLSurfaceView_15;
    }
}
