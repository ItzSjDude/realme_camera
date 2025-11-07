package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public interface DropFrameManager {
    long adjustPresentTimeUs(long OplusGLSurfaceView_15);

    boolean canRender(long OplusGLSurfaceView_15);

    void doRender();

    void initialize(int OplusGLSurfaceView_13);

    boolean isAvailable();

    void setRealFps(float COUIBaseListPopupWindow_12);
}
