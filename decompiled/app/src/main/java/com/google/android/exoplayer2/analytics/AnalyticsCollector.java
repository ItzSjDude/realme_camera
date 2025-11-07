package com.google.android.exoplayer2.analytics;

/* loaded from: classes.dex */
public class AnalyticsCollector implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.audio.AudioListener, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener, com.google.android.exoplayer2.metadata.MetadataOutput, com.google.android.exoplayer2.source.MediaSourceEventListener, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener, com.google.android.exoplayer2.video.VideoListener, com.google.android.exoplayer2.video.VideoRendererEventListener {
    private final com.google.android.exoplayer2.util.Clock clock;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.analytics.AnalyticsListener> listeners;
    private final com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private com.google.android.exoplayer2.Player player;
    private final com.google.android.exoplayer2.Timeline.Window window;

    @Override // com.google.android.exoplayer2.video.VideoListener
    public final void onRenderedFirstFrame() {
    }

    public static class Factory {
        public com.google.android.exoplayer2.analytics.AnalyticsCollector createAnalyticsCollector(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.util.Clock clock) {
            return new com.google.android.exoplayer2.analytics.AnalyticsCollector(player, clock);
        }
    }

    protected AnalyticsCollector(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.util.Clock clock) {
        if (player != null) {
            this.player = player;
        }
        this.clock = (com.google.android.exoplayer2.util.Clock) com.google.android.exoplayer2.util.Assertions.checkNotNull(clock);
        this.listeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.mediaPeriodQueueTracker = new com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodQueueTracker();
        this.window = new com.google.android.exoplayer2.Timeline.Window();
    }

    public void addListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        this.listeners.add(analyticsListener);
    }

    public void removeListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public void setPlayer(com.google.android.exoplayer2.Player player) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.player == null);
        this.player = (com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(player);
    }

    public final void notifySeekStarted() {
        if (this.mediaPeriodQueueTracker.isSeeking()) {
            return;
        }
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        this.mediaPeriodQueueTracker.onSeekStarted();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekStarted(eventTimeGeneratePlayingMediaPeriodEventTime);
        }
    }

    public final void resetForNewMediaSource() {
        for (com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo : new java.util.ArrayList(this.mediaPeriodQueueTracker.mediaPeriodInfoQueue)) {
            onMediaPeriodReleased(mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(eventTimeGeneratePlayingMediaPeriodEventTime, metadata);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(eventTimeGeneratePlayingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTimeGenerateReadingMediaPeriodEventTime, 1, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(eventTimeGenerateReadingMediaPeriodEventTime, 1, format);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkUnderrun(int i_renamed, long j_renamed, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(eventTimeGenerateReadingMediaPeriodEventTime, i_renamed, j_renamed, j2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(eventTimeGenerateLastReportedPlayingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener, com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSessionId(int i_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(eventTimeGenerateReadingMediaPeriodEventTime, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioAttributesChanged(eventTimeGenerateReadingMediaPeriodEventTime, audioAttributes);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioListener
    public void onVolumeChanged(float f_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(eventTimeGenerateReadingMediaPeriodEventTime, f_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(eventTimeGeneratePlayingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTimeGenerateReadingMediaPeriodEventTime, 2, str, j2);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(eventTimeGenerateReadingMediaPeriodEventTime, 2, format);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int i_renamed, long j_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(eventTimeGenerateLastReportedPlayingMediaPeriodEventTime, i_renamed, j_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(eventTimeGenerateLastReportedPlayingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(android.view.Surface surface) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(eventTimeGenerateReadingMediaPeriodEventTime, surface);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener, com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(eventTimeGenerateReadingMediaPeriodEventTime, i_renamed, i2, i3, f_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int i_renamed, int i2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(eventTimeGenerateReadingMediaPeriodEventTime, i_renamed, i2);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodCreated(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onMediaPeriodCreated(i_renamed, mediaPeriodId);
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(eventTimeGenerateMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodReleased(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        if (this.mediaPeriodQueueTracker.onMediaPeriodReleased(mediaPeriodId)) {
            java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onMediaPeriodReleased(eventTimeGenerateMediaPeriodEventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onReadingStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onReadingStarted(mediaPeriodId);
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(eventTimeGenerateMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(eventTimeGenerateMediaPeriodEventTime, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i_renamed, mediaPeriodId);
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(eventTimeGenerateMediaPeriodEventTime, mediaLoadData);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i_renamed) {
        this.mediaPeriodQueueTracker.onTimelineChanged(timeline);
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(eventTimeGeneratePlayingMediaPeriodEventTime, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(eventTimeGeneratePlayingMediaPeriodEventTime, trackGroupArray, trackSelectionArray);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onLoadingChanged(boolean z_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadingChanged(eventTimeGeneratePlayingMediaPeriodEventTime, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerStateChanged(boolean z_renamed, int i_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(eventTimeGeneratePlayingMediaPeriodEventTime, z_renamed, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onRepeatModeChanged(int i_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(eventTimeGeneratePlayingMediaPeriodEventTime, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onShuffleModeEnabledChanged(boolean z_renamed) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(eventTimeGeneratePlayingMediaPeriodEventTime, z_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime;
        if (exoPlaybackException.type == 0) {
            eventTimeGeneratePlayingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        } else {
            eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        }
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(eventTimeGeneratePlayingMediaPeriodEventTime, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i_renamed) {
        this.mediaPeriodQueueTracker.onPositionDiscontinuity(i_renamed);
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(eventTimeGeneratePlayingMediaPeriodEventTime, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(eventTimeGeneratePlayingMediaPeriodEventTime, playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekProcessed() {
        if (this.mediaPeriodQueueTracker.isSeeking()) {
            this.mediaPeriodQueueTracker.onSeekProcessed();
            com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
            java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekProcessed(eventTimeGeneratePlayingMediaPeriodEventTime);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onSeekCompleted(int i_renamed, int i2) {
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekCompleted(i_renamed, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPrepared() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGeneratePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPrepared(eventTimeGeneratePlayingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener
    public final void onBandwidthSample(int i_renamed, long j_renamed, long j2) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(eventTimeGenerateLoadingMediaPeriodEventTime, i_renamed, j_renamed, j2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionAcquired() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionAcquired(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysLoaded() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionManagerError(java.lang.Exception exc) {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(eventTimeGenerateReadingMediaPeriodEventTime, exc);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRestored() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRemoved() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(eventTimeGenerateReadingMediaPeriodEventTime);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionReleased() {
        com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTimeGenerateLastReportedPlayingMediaPeriodEventTime = generateLastReportedPlayingMediaPeriodEventTime();
        java.util.Iterator<com.google.android.exoplayer2.analytics.AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionReleased(eventTimeGenerateLastReportedPlayingMediaPeriodEventTime);
        }
    }

    protected java.util.Set<com.google.android.exoplayer2.analytics.AnalyticsListener> getListeners() {
        return java.util.Collections.unmodifiableSet(this.listeners);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"player"})
    protected com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateEventTime(com.google.android.exoplayer2.Timeline timeline, int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        if (timeline.isEmpty()) {
            mediaPeriodId = null;
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long jElapsedRealtime = this.clock.elapsedRealtime();
        boolean z_renamed = timeline == this.player.getCurrentTimeline() && i_renamed == this.player.getCurrentWindowIndex();
        long defaultPositionMs = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (z_renamed && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup) {
                defaultPositionMs = this.player.getCurrentPosition();
            }
        } else if (z_renamed) {
            defaultPositionMs = this.player.getContentPosition();
        } else if (!timeline.isEmpty()) {
            defaultPositionMs = timeline.getWindow(i_renamed, this.window).getDefaultPositionMs();
        }
        return new com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime(jElapsedRealtime, timeline, i_renamed, mediaPeriodId2, defaultPositionMs, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateEventTime(com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.player);
        if (mediaPeriodInfo == null) {
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfoTryResolveWindowIndex = this.mediaPeriodQueueTracker.tryResolveWindowIndex(currentWindowIndex);
            if (mediaPeriodInfoTryResolveWindowIndex == null) {
                com.google.android.exoplayer2.Timeline currentTimeline = this.player.getCurrentTimeline();
                if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
                    currentTimeline = com.google.android.exoplayer2.Timeline.EMPTY;
                }
                return generateEventTime(currentTimeline, currentWindowIndex, null);
            }
            mediaPeriodInfo = mediaPeriodInfoTryResolveWindowIndex;
        }
        return generateEventTime(mediaPeriodInfo.timeline, mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateLastReportedPlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLastReportedPlayingMediaPeriod());
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime generateMediaPeriodEventTime(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.player);
        if (mediaPeriodId != null) {
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo = this.mediaPeriodQueueTracker.getMediaPeriodInfo(mediaPeriodId);
            if (mediaPeriodInfo != null) {
                return generateEventTime(mediaPeriodInfo);
            }
            return generateEventTime(com.google.android.exoplayer2.Timeline.EMPTY, i_renamed, mediaPeriodId);
        }
        com.google.android.exoplayer2.Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(i_renamed < currentTimeline.getWindowCount())) {
            currentTimeline = com.google.android.exoplayer2.Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i_renamed, null);
    }

    private static final class MediaPeriodQueueTracker {
        private boolean isSeeking;
        private com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo lastReportedPlayingMediaPeriod;
        private com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo readingMediaPeriod;
        private final java.util.ArrayList<com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo> mediaPeriodInfoQueue = new java.util.ArrayList<>();
        private final java.util.HashMap<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo> mediaPeriodIdToInfo = new java.util.HashMap<>();
        private final com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
        private com.google.android.exoplayer2.Timeline timeline = com.google.android.exoplayer2.Timeline.EMPTY;

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo getPlayingMediaPeriod() {
            if (this.mediaPeriodInfoQueue.isEmpty() || this.timeline.isEmpty() || this.isSeeking) {
                return null;
            }
            return this.mediaPeriodInfoQueue.get(0);
        }

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo getLastReportedPlayingMediaPeriod() {
            return this.lastReportedPlayingMediaPeriod;
        }

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo getLoadingMediaPeriod() {
            if (this.mediaPeriodInfoQueue.isEmpty()) {
                return null;
            }
            return this.mediaPeriodInfoQueue.get(r1.size() - 1);
        }

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo getMediaPeriodInfo(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodIdToInfo.get(mediaPeriodId);
        }

        public boolean isSeeking() {
            return this.isSeeking;
        }

        public com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo tryResolveWindowIndex(int i_renamed) {
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo = null;
            for (int i2 = 0; i2 < this.mediaPeriodInfoQueue.size(); i2++) {
                com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo2 = this.mediaPeriodInfoQueue.get(i2);
                int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodInfo2.mediaPeriodId.periodUid);
                if (indexOfPeriod != -1 && this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i_renamed) {
                    if (mediaPeriodInfo != null) {
                        return null;
                    }
                    mediaPeriodInfo = mediaPeriodInfo2;
                }
            }
            return mediaPeriodInfo;
        }

        public void onPositionDiscontinuity(int i_renamed) {
            updateLastReportedPlayingMediaPeriod();
        }

        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline) {
            for (int i_renamed = 0; i_renamed < this.mediaPeriodInfoQueue.size(); i_renamed++) {
                com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline = updateMediaPeriodInfoToNewTimeline(this.mediaPeriodInfoQueue.get(i_renamed), timeline);
                this.mediaPeriodInfoQueue.set(i_renamed, mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline);
                this.mediaPeriodIdToInfo.put(mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline.mediaPeriodId, mediaPeriodInfoUpdateMediaPeriodInfoToNewTimeline);
            }
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo = this.readingMediaPeriod;
            if (mediaPeriodInfo != null) {
                this.readingMediaPeriod = updateMediaPeriodInfoToNewTimeline(mediaPeriodInfo, timeline);
            }
            this.timeline = timeline;
            updateLastReportedPlayingMediaPeriod();
        }

        public void onSeekStarted() {
            this.isSeeking = true;
        }

        public void onSeekProcessed() {
            this.isSeeking = false;
            updateLastReportedPlayingMediaPeriod();
        }

        public void onMediaPeriodCreated(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo = new com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo(mediaPeriodId, this.timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1 ? this.timeline : com.google.android.exoplayer2.Timeline.EMPTY, i_renamed);
            this.mediaPeriodInfoQueue.add(mediaPeriodInfo);
            this.mediaPeriodIdToInfo.put(mediaPeriodId, mediaPeriodInfo);
            if (this.mediaPeriodInfoQueue.size() != 1 || this.timeline.isEmpty()) {
                return;
            }
            updateLastReportedPlayingMediaPeriod();
        }

        public boolean onMediaPeriodReleased(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfoRemove = this.mediaPeriodIdToInfo.remove(mediaPeriodId);
            if (mediaPeriodInfoRemove == null) {
                return false;
            }
            this.mediaPeriodInfoQueue.remove(mediaPeriodInfoRemove);
            com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo = this.readingMediaPeriod;
            if (mediaPeriodInfo == null || !mediaPeriodId.equals(mediaPeriodInfo.mediaPeriodId)) {
                return true;
            }
            this.readingMediaPeriod = this.mediaPeriodInfoQueue.isEmpty() ? null : this.mediaPeriodInfoQueue.get(0);
            return true;
        }

        public void onReadingStarted(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            this.readingMediaPeriod = this.mediaPeriodIdToInfo.get(mediaPeriodId);
        }

        private void updateLastReportedPlayingMediaPeriod() {
            if (this.mediaPeriodInfoQueue.isEmpty()) {
                return;
            }
            this.lastReportedPlayingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
        }

        private com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo updateMediaPeriodInfoToNewTimeline(com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo mediaPeriodInfo, com.google.android.exoplayer2.Timeline timeline) {
            int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodInfo.mediaPeriodId.periodUid);
            if (indexOfPeriod == -1) {
                return mediaPeriodInfo;
            }
            return new com.google.android.exoplayer2.analytics.AnalyticsCollector.MediaPeriodInfo(mediaPeriodInfo.mediaPeriodId, timeline, timeline.getPeriod(indexOfPeriod, this.period).windowIndex);
        }
    }

    private static final class MediaPeriodInfo {
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        public final com.google.android.exoplayer2.Timeline timeline;
        public final int windowIndex;

        public MediaPeriodInfo(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Timeline timeline, int i_renamed) {
            this.mediaPeriodId = mediaPeriodId;
            this.timeline = timeline;
            this.windowIndex = i_renamed;
        }
    }
}
