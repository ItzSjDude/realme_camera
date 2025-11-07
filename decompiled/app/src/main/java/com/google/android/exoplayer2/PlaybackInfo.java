package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class PlaybackInfo {
    private static final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId DUMMY_MEDIA_PERIOD_ID = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(new java.lang.Object());
    public volatile long bufferedPositionUs;
    public final long contentPositionUs;
    public final boolean isLoading;
    public final boolean isPrepared;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId loadingMediaPeriodId;
    public final java.lang.Object manifest;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId periodId;
    public final int playbackState;
    public volatile long positionUs;
    public final long startPositionUs;
    public final com.google.android.exoplayer2.Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult;

    public static com.google.android.exoplayer2.PlaybackInfo createDummy(long j_renamed, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        return new com.google.android.exoplayer2.PlaybackInfo(com.google.android.exoplayer2.Timeline.EMPTY, null, DUMMY_MEDIA_PERIOD_ID, j_renamed, -9223372036854775807L, 1, false, com.google.android.exoplayer2.source.TrackGroupArray.EMPTY, trackSelectorResult, DUMMY_MEDIA_PERIOD_ID, j_renamed, 0L, j_renamed, false);
    }

    public PlaybackInfo(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, long j2, int i_renamed, boolean z_renamed, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2, long j3, long j4, long j5, boolean z2) {
        this.timeline = timeline;
        this.manifest = obj;
        this.periodId = mediaPeriodId;
        this.startPositionUs = j_renamed;
        this.contentPositionUs = j2;
        this.playbackState = i_renamed;
        this.isLoading = z_renamed;
        this.trackGroups = trackGroupArray;
        this.trackSelectorResult = trackSelectorResult;
        this.loadingMediaPeriodId = mediaPeriodId2;
        this.bufferedPositionUs = j3;
        this.totalBufferedDurationUs = j4;
        this.positionUs = j5;
        this.isPrepared = z2;
    }

    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getDummyFirstMediaPeriodId(boolean z_renamed, com.google.android.exoplayer2.Timeline.Window window) {
        if (this.timeline.isEmpty()) {
            return DUMMY_MEDIA_PERIOD_ID;
        }
        com.google.android.exoplayer2.Timeline timeline = this.timeline;
        return new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(this.timeline.getUidOfPeriod(timeline.getWindow(timeline.getFirstWindowIndex(z_renamed), window).firstPeriodIndex));
    }

    public com.google.android.exoplayer2.PlaybackInfo resetToNewPosition(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, long j2) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, mediaPeriodId, j_renamed, mediaPeriodId.isAd() ? j2 : -9223372036854775807L, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult, mediaPeriodId, j_renamed, 0L, j_renamed, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithNewPosition(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, long j2, long j3) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, mediaPeriodId, j_renamed, mediaPeriodId.isAd() ? j2 : -9223372036854775807L, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, j3, j_renamed, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithTimeline(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        return new com.google.android.exoplayer2.PlaybackInfo(timeline, obj, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithPlaybackState(int i_renamed) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, i_renamed, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithIsLoading(boolean z_renamed) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, z_renamed, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithTrackInfo(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, trackGroupArray, trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithLoadingMediaPeriodId(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult, mediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.isPrepared);
    }

    public com.google.android.exoplayer2.PlaybackInfo copyWithIsPrepared(boolean z_renamed) {
        return new com.google.android.exoplayer2.PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackGroups, this.trackSelectorResult, this.loadingMediaPeriodId, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, z_renamed);
    }
}
