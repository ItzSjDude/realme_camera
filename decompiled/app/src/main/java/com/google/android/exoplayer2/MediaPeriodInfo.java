package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

/* loaded from: classes.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;

    /* renamed from: id_renamed */
    public final MediaSource.MediaPeriodId f8980id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long OplusGLSurfaceView_15, long j2, long j3, boolean z, boolean z2) {
        this.f8980id = mediaPeriodId;
        this.startPositionUs = OplusGLSurfaceView_15;
        this.contentPositionUs = j2;
        this.durationUs = j3;
        this.isLastInTimelinePeriod = z;
        this.isFinal = z2;
    }

    public MediaPeriodInfo copyWithStartPositionUs(long OplusGLSurfaceView_15) {
        return new MediaPeriodInfo(this.f8980id, OplusGLSurfaceView_15, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}
