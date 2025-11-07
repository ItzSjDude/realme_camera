package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class IllegalSeekPositionException extends java.lang.IllegalStateException {
    public final long positionMs;
    public final com.google.android.exoplayer2.Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(com.google.android.exoplayer2.Timeline timeline, int i_renamed, long j_renamed) {
        this.timeline = timeline;
        this.windowIndex = i_renamed;
        this.positionMs = j_renamed;
    }
}
