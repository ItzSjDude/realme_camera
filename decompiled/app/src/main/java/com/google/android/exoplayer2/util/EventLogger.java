package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public class EventLogger implements com.google.android.exoplayer2.analytics.AnalyticsListener {
    private static final java.lang.String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final java.text.NumberFormat TIME_FORMAT = java.text.NumberFormat.getInstance(java.util.Locale.US);
    private final com.google.android.exoplayer2.Timeline.Period period;
    private final long startTimeMs;
    private final java.lang.String tag;
    private final com.google.android.exoplayer2.trackselection.MappingTrackSelector trackSelector;
    private final com.google.android.exoplayer2.Timeline.Window window;

    private static java.lang.String getAdaptiveSupportString(int i_renamed, int i2) {
        return i_renamed < 2 ? com.oplus.tblplayer.Constants.STRING_VALUE_UNSET : i2 != 0 ? i2 != 8 ? i2 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static java.lang.String getDiscontinuityReasonString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    private static java.lang.String getFormatSupportString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    private static java.lang.String getRepeatModeString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    private static java.lang.String getStateString(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static java.lang.String getTimelineChangeReasonString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED";
    }

    private static java.lang.String getTrackStatusString(boolean z_renamed) {
        return z_renamed ? "[X_renamed]" : "[ ]";
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed, long j2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    static {
        TIME_FORMAT.setMinimumFractionDigits(2);
        TIME_FORMAT.setMaximumFractionDigits(2);
        TIME_FORMAT.setGroupingUsed(false);
    }

    public EventLogger(com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, DEFAULT_TAG);
    }

    public EventLogger(com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector, java.lang.String str) {
        this.trackSelector = mappingTrackSelector;
        this.tag = str;
        this.window = new com.google.android.exoplayer2.Timeline.Window();
        this.period = new com.google.android.exoplayer2.Timeline.Period();
        this.startTimeMs = android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed) {
        logd(eventTime, "loading", java.lang.Boolean.toString(z_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed, int i_renamed) {
        logd(eventTime, "state", z_renamed + ", " + getStateString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
        logd(eventTime, "repeatMode", getRepeatModeString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed) {
        logd(eventTime, "shuffleModeEnabled", java.lang.Boolean.toString(z_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
        logd(eventTime, "positionDiscontinuity", getDiscontinuityReasonString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekStarted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", com.google.android.exoplayer2.util.Util.formatInvariant("speed=%.2f, pitch=%.2f, skipSilence=%s_renamed", java.lang.Float.valueOf(playbackParameters.speed), java.lang.Float.valueOf(playbackParameters.pitch), java.lang.Boolean.valueOf(playbackParameters.skipSilence)));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timelineChanged [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i_renamed));
        for (int i2 = 0; i2 < java.lang.Math.min(periodCount, 3); i2++) {
            eventTime.timeline.getPeriod(i2, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < java.lang.Math.min(windowCount, 3); i3++) {
            eventTime.timeline.getWindow(i3, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        loge(eventTime, "playerFailed", exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        int i_renamed;
        com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector = this.trackSelector;
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            logd(eventTime, "tracksChanged", "[]");
            return;
        }
        logd("tracksChanged [" + getEventTimeString(eventTime) + ", ");
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i2 = 0;
        while (true) {
            java.lang.String str = "  ]";
            java.lang.String str2 = " [";
            if (i2 >= rendererCount) {
                break;
            }
            com.google.android.exoplayer2.source.TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i2);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArray.get(i2);
            if (trackGroups.length > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                i_renamed = rendererCount;
                sb.append("  Renderer:");
                sb.append(i2);
                sb.append(" [");
                logd(sb.toString());
                int i3 = 0;
                while (i3 < trackGroups.length) {
                    com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroups.get(i3);
                    com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2 = trackGroups;
                    java.lang.String str3 = str;
                    logd("    Group:" + i3 + ", adaptive_supported=" + getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i2, i3, false)) + str2);
                    int i4 = 0;
                    while (i4 < trackGroup.length) {
                        logd("      " + getTrackStatusString(trackSelection, trackGroup, i4) + " Track:" + i4 + ", " + com.google.android.exoplayer2.Format.toLogString(trackGroup.getFormat(i4)) + ", supported=" + getFormatSupportString(currentMappedTrackInfo.getTrackSupport(i2, i3, i4)));
                        i4++;
                        str2 = str2;
                    }
                    logd("    ]");
                    i3++;
                    trackGroups = trackGroupArray2;
                    str = str3;
                }
                java.lang.String str4 = str;
                if (trackSelection != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= trackSelection.length()) {
                            break;
                        }
                        com.google.android.exoplayer2.metadata.Metadata metadata = trackSelection.getFormat(i5).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i5++;
                    }
                }
                logd(str4);
            } else {
                i_renamed = rendererCount;
            }
            i2++;
            rendererCount = i_renamed;
        }
        java.lang.String str5 = " [";
        com.google.android.exoplayer2.source.TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Renderer:None [");
            int i6 = 0;
            while (i6 < unmappedTrackGroups.length) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("    Group:");
                sb2.append(i6);
                java.lang.String str6 = str5;
                sb2.append(str6);
                logd(sb2.toString());
                com.google.android.exoplayer2.source.TrackGroup trackGroup2 = unmappedTrackGroups.get(i6);
                for (int i7 = 0; i7 < trackGroup2.length; i7++) {
                    logd("      " + getTrackStatusString(false) + " Track:" + i7 + ", " + com.google.android.exoplayer2.Format.toLogString(trackGroup2.getFormat(i7)) + ", supported=" + getFormatSupportString(0));
                }
                logd("    ]");
                i6++;
                str5 = str6;
            }
            logd("  ]");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekProcessed(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekProcessed");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.metadata.Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime) + ", ");
        printMetadata(metadata, "  ");
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        logd(eventTime, "decoderEnabled", getTrackTypeString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioSessionId(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed) {
        logd(eventTime, "audioSessionId", java.lang.Integer.toString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, java.lang.String str, long j_renamed) {
        logd(eventTime, "decoderInitialized", getTrackTypeString(i_renamed) + ", " + str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.Format format) {
        logd(eventTime, "decoderInputFormatChanged", getTrackTypeString(i_renamed) + ", " + com.google.android.exoplayer2.Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        logd(eventTime, "decoderDisabled", getTrackTypeString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed, long j2) {
        loge(eventTime, "audioTrackUnderrun", i_renamed + ", " + j_renamed + ", " + j2 + "]", null);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed) {
        logd(eventTime, "droppedFrames", java.lang.Integer.toString(i_renamed));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, int i2, int i3, float f_renamed) {
        logd(eventTime, "videoSizeChanged", i_renamed + ", " + i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
        logd(eventTime, "renderedFirstFrame", java.lang.String.valueOf(surface));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaPeriodCreated(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodCreated");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaPeriodReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReleased");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
        printInternalError(eventTime, "loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onReadingStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReadingStarted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, int i2) {
        logd(eventTime, "surfaceSizeChanged", i_renamed + ", " + i2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", com.google.android.exoplayer2.Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormatChanged", com.google.android.exoplayer2.Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionAcquired");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    protected void logd(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.d_renamed(this.tag, str);
    }

    protected void loge(java.lang.String str, java.lang.Throwable th) {
        com.google.android.exoplayer2.util.Log.e_renamed(this.tag, str, th);
    }

    private void logd(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        logd(getEventString(eventTime, str));
    }

    private void logd(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2) {
        logd(getEventString(eventTime, str, str2));
    }

    private void loge(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.Throwable th) {
        loge(getEventString(eventTime, str), th);
    }

    private void loge(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        loge(getEventString(eventTime, str, str2), th);
    }

    private void printInternalError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(com.google.android.exoplayer2.metadata.Metadata metadata, java.lang.String str) {
        for (int i_renamed = 0; i_renamed < metadata.length(); i_renamed++) {
            logd(str + metadata.get(i_renamed));
        }
    }

    private java.lang.String getEventString(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        return str + " [" + getEventTimeString(eventTime) + "]";
    }

    private java.lang.String getEventString(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2) {
        return str + " [" + getEventTimeString(eventTime) + ", " + str2 + "]";
    }

    private java.lang.String getEventTimeString(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        java.lang.String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad_renamed=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", " + getTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    private static java.lang.String getTimeString(long j_renamed) {
        return j_renamed == -9223372036854775807L ? "?" : TIME_FORMAT.format(j_renamed / 1000.0f);
    }

    private static java.lang.String getTrackStatusString(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.source.TrackGroup trackGroup, int i_renamed) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i_renamed) == -1) ? false : true);
    }

    private static java.lang.String getTrackTypeString(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return "default";
            case 1:
                return com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT;
            case 4:
                return com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_METADATA;
            case 5:
                return "camera motion";
            case 6:
                return "none";
            default:
                if (i_renamed < 10000) {
                    return "?";
                }
                return "custom (" + i_renamed + ")";
        }
    }
}
