package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public interface DropFrameManager {
    long adjustPresentTimeUs(long j_renamed);

    boolean canRender(long j_renamed);

    void doRender();

    void initialize(int i_renamed);

    boolean isAvailable();

    void setRealFps(float f_renamed);
}
