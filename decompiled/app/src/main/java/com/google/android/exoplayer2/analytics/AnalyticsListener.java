package com.google.android.exoplayer2.analytics;

/* loaded from: classes.dex */
public interface AnalyticsListener {
    default void onAudioAttributesChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
    }

    default void onAudioSessionId(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
    }

    default void onAudioUnderrun(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed, long j2) {
    }

    default void onBandwidthEstimate(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed, long j2) {
    }

    default void onDecoderDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onDecoderEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
    }

    default void onDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, java.lang.String str, long j_renamed) {
    }

    default void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.Format format) {
    }

    default void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    default void onDrmKeysLoaded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onDrmKeysRemoved(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onDrmKeysRestored(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onDrmSessionAcquired(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onDrmSessionManagerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
    }

    default void onDrmSessionReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onDroppedVideoFrames(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed) {
    }

    default void onLoadCanceled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    default void onLoadCompleted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    default void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
    }

    default void onLoadStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    default void onLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed) {
    }

    default void onMediaPeriodCreated(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onMediaPeriodReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onMetadata(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.metadata.Metadata metadata) {
    }

    default void onPlaybackParametersChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
    }

    default void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
    }

    default void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed, int i_renamed) {
    }

    default void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
    }

    default void onPrepared(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onReadingStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
    }

    default void onRepeatModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
    }

    default void onSeekCompleted(int i_renamed, int i2) {
    }

    default void onSeekProcessed(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onSeekStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
    }

    default void onShuffleModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed) {
    }

    default void onSurfaceSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, int i2) {
    }

    default void onTimelineChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
    }

    default void onTracksChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
    }

    default void onUpstreamDiscarded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    default void onVideoSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, int i2, int i3, float f_renamed) {
    }

    default void onVolumeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, float f_renamed) {
    }

    public static final class EventTime {
        public final long currentPlaybackPositionMs;
        public final long eventPlaybackPositionMs;
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final com.google.android.exoplayer2.Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long j_renamed, com.google.android.exoplayer2.Timeline timeline, int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4) {
            this.realtimeMs = j_renamed;
            this.timeline = timeline;
            this.windowIndex = i_renamed;
            this.mediaPeriodId = mediaPeriodId;
            this.eventPlaybackPositionMs = j2;
            this.currentPlaybackPositionMs = j3;
            this.totalBufferedDurationMs = j4;
        }
    }
}
