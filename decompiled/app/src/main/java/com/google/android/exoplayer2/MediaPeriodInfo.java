package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId id_renamed;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    MediaPeriodInfo(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, long j2, long j3, boolean z_renamed, boolean z2) {
        this.id_renamed = mediaPeriodId;
        this.startPositionUs = j_renamed;
        this.contentPositionUs = j2;
        this.durationUs = j3;
        this.isLastInTimelinePeriod = z_renamed;
        this.isFinal = z2;
    }

    public com.google.android.exoplayer2.MediaPeriodInfo copyWithStartPositionUs(long j_renamed) {
        return new com.google.android.exoplayer2.MediaPeriodInfo(this.id_renamed, j_renamed, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}
