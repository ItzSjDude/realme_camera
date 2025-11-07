package com.oplus.tblplayer.monitor;

/* loaded from: classes2.dex */
public final class AnalyticsMonitor implements com.google.android.exoplayer2.analytics.AnalyticsListener, com.google.android.exoplayer2.upstream.TransferListener, com.oplus.tblplayer.monitor.ErrorCode {
    private static final java.lang.String TAG = "AnalyticsMonitor";
    private long alreadyPreCacheBytes;
    private boolean audioRendererHasFailed;
    private java.lang.String errorRendererInfo;
    private boolean hasRenderFirstFrame;
    private com.google.android.exoplayer2.source.TrackGroupArray lastSeenTrackGroupArray;
    private com.google.android.exoplayer2.SimpleExoPlayer mExoPlayer;
    private com.oplus.tblplayer.misc.MediaInfo mMediaInfo;
    private com.oplus.tblplayer.misc.MediaUrl mMediaUrl;
    private com.oplus.tblplayer.monitor.Report.Builder mReportBuilder;
    private boolean rebuffering;
    private long rebufferingStartTimeMs;
    private long startTimeMs;
    private long totalNetworkReadBytes;
    private long totalRebufferCount;
    private long totalRebufferTimeMs;
    private com.google.android.exoplayer2.trackselection.DefaultTrackSelector trackSelector;
    private boolean videoRendererHasFailed;
    private long firstRenderTime = 0;
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;
    private boolean isStarted = false;

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferEnd(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferStart(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed) {
    }

    public AnalyticsMonitor(com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer, com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector) {
        this.mExoPlayer = simpleExoPlayer;
        this.trackSelector = defaultTrackSelector;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onReadingStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onReadingStarted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDownstreamFormatChanged: " + com.google.android.exoplayer2.Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.Format format) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDecoderInputFormatChanged: " + com.google.android.exoplayer2.Format.toLogString(format));
        formatMediaInfo(i_renamed, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, java.lang.String str, long j_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDecoderInitialized: decoderName = " + str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDecoderEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDecoderDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onDecoderDisabled: " + com.oplus.tblplayer.utils.LogUtil.getDecoderCountersString(decoderCounters));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, android.view.Surface surface) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onRenderedFirstFrame: " + surface);
        if (!checkState() || this.hasRenderFirstFrame) {
            return;
        }
        this.firstRenderTime = java.lang.System.currentTimeMillis() - this.startTimeMs;
        this.mReportBuilder = this.mReportBuilder.setRenderedFirstFrameTime(this.firstRenderTime);
        this.hasRenderFirstFrame = true;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onRenderedFirstFrame: firstRenderTime[" + this.firstRenderTime + "]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed, int i_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onPlayerStateChanged: playWhenReady = " + z_renamed + ", state = " + com.oplus.tblplayer.utils.LogUtil.getStateString(i_renamed));
        if (this.hasRenderFirstFrame) {
            if (z_renamed && i_renamed == 2 && !this.rebuffering) {
                this.rebuffering = true;
                this.rebufferingStartTimeMs = java.lang.System.currentTimeMillis();
            } else if (i_renamed == 3 && this.rebuffering) {
                maybeAdvanceRebufferCount(true);
                this.rebuffering = false;
            }
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        if (checkState()) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onPlayerError", exoPlaybackException);
            if (exoPlaybackException.type == 1) {
                updateErrorRendererInfo(exoPlaybackException);
            }
            this.mReportBuilder = this.mReportBuilder.setErrorCode(com.oplus.tblplayer.monitor.ErrorCodeProvider.parseException(this.mExoPlayer, exoPlaybackException)).setException(exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        com.oplus.tblplayer.misc.MediaInfo mediaInfo;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onTracksChanged");
        if (trackGroupArray != this.lastSeenTrackGroupArray) {
            com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
            if (currentMappedTrackInfo != null && (mediaInfo = this.mMediaInfo) != null) {
                mediaInfo.videoRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 2);
                this.mMediaInfo.audioRendererSupport = getTrackTypeRendererSupport(currentMappedTrackInfo, 1);
            }
            this.lastSeenTrackGroupArray = trackGroupArray;
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onLoadCompleted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onLoadCanceled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onLoadError");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onLoadingChanged: isLoading = " + z_renamed);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i_renamed, long j_renamed, long j2) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onBandwidthEstimate: " + i_renamed + ", " + j_renamed + ", " + j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onUpstreamDiscarded");
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z_renamed, int i_renamed) {
        if (z_renamed) {
            this.totalNetworkReadBytes += i_renamed;
        }
    }

    public synchronized void startSession(com.oplus.tblplayer.misc.MediaUrl mediaUrl) {
        reset();
        this.mMediaUrl = mediaUrl;
        this.mMediaInfo = new com.oplus.tblplayer.misc.MediaInfo(this.mMediaUrl.getUri().toString(), this.mMediaUrl.inferContentType());
        this.mReportBuilder = new com.oplus.tblplayer.monitor.Report.Builder();
        this.startTimeMs = java.lang.System.currentTimeMillis();
        this.lastTimeStamp = this.startTimeMs;
        this.lastTotalRxBytes = com.oplus.tblplayer.utils.NetSpeedUtil.getTotalRxBytes(com.oplus.tblplayer.utils.LogUtil.getProcessUid());
        android.util.Pair<java.lang.Long, java.lang.Long> alreadyCacheBytes = com.oplus.tblplayer.managers.TBLSourceManager.getAlreadyCacheBytes(this.mMediaUrl.getUri(), this.mMediaUrl.getCustomCacheKey());
        if (alreadyCacheBytes != null) {
            this.alreadyPreCacheBytes = ((java.lang.Long) alreadyCacheBytes.first).longValue();
        }
        this.isStarted = true;
    }

    public synchronized com.oplus.tblplayer.monitor.Report endSession() {
        if (!checkState() || this.mReportBuilder == null) {
            return null;
        }
        maybeAdvanceRebufferCount(this.rebuffering);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.startTimeMs;
        android.util.Pair<java.lang.Long, java.lang.Long> alreadyCacheBytes = com.oplus.tblplayer.managers.TBLSourceManager.getAlreadyCacheBytes(this.mMediaUrl.getUri(), this.mMediaUrl.getCustomCacheKey());
        if (alreadyCacheBytes != null) {
            this.mReportBuilder.setAlreadyCacheBytes(this.alreadyPreCacheBytes, ((java.lang.Long) alreadyCacheBytes.second).longValue());
        }
        com.oplus.tblplayer.monitor.Report reportBuild = this.mReportBuilder.setAliveDuration(jCurrentTimeMillis).setMediaInfo(this.mMediaInfo).setRebufferCount(this.totalRebufferCount, this.totalRebufferTimeMs).setTotalNetworkReadBytes(this.totalNetworkReadBytes).setVideoFLR(getFrameLossRate(this.mExoPlayer.getVideoDecoderCounters())).setErrorRenderer(this.errorRendererInfo).build();
        reset();
        return reportBuild;
    }

    private void updateErrorRendererInfo(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException.type == 1) {
            com.google.android.exoplayer2.Renderer[] rendererArr = (com.google.android.exoplayer2.Renderer[]) com.oplus.tblplayer.utils.ReflectUtil.getField(this.mExoPlayer, com.google.android.exoplayer2.Renderer[].class, "renderers");
            int i_renamed = exoPlaybackException.rendererIndex;
            com.google.android.exoplayer2.Renderer renderer = (i_renamed <= 0 || i_renamed >= rendererArr.length) ? null : rendererArr[i_renamed];
            if (renderer != null) {
                if (renderer instanceof com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_MC_VIDEO;
                    this.videoRendererHasFailed = true;
                    return;
                }
                if (renderer instanceof com.google.android.exoplayer2.audio.MediaCodecAudioRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_MC_AUDIO;
                    this.audioRendererHasFailed = true;
                    return;
                }
                if (renderer instanceof com.oplus.tblplayer.ffmpeg.FfmpegVideoRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_FF_VIDEO;
                    return;
                }
                if (renderer instanceof com.oplus.tblplayer.ffmpeg.FfmpegAudioRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_FF_AUDIO;
                    return;
                }
                if (renderer instanceof com.google.android.exoplayer2.text.TextRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_TEXT;
                } else if (renderer instanceof com.google.android.exoplayer2.metadata.MetadataRenderer) {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_METADATA;
                } else {
                    this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_UNKNOWN;
                }
            }
        }
    }

    private int getTrackTypeRendererSupport(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i_renamed) {
        int typeSupport = mappedTrackInfo.getTypeSupport(i_renamed);
        if (typeSupport == 0) {
            return 1;
        }
        if (typeSupport == 1) {
            return 2;
        }
        if (typeSupport == 3 || typeSupport == 2) {
            com.google.android.exoplayer2.Renderer[] rendererArr = (com.google.android.exoplayer2.Renderer[]) com.oplus.tblplayer.utils.ReflectUtil.getField(this.mExoPlayer, com.google.android.exoplayer2.Renderer[].class, "renderers");
            if (!this.videoRendererHasFailed) {
                int i2 = 0;
                for (int i3 = 0; i3 < mappedTrackInfo.getRendererCount(); i3++) {
                    if (i_renamed == mappedTrackInfo.getRendererType(i3) && (rendererArr[i3] instanceof com.google.android.exoplayer2.mediacodec.MediaCodecRenderer)) {
                        i2 = mappedTrackInfo.getRendererSupport(i3) == 3 ? 3 : 5;
                    }
                }
                return i2;
            }
            com.oplus.tblplayer.misc.MediaInfo mediaInfo = this.mMediaInfo;
            if (mediaInfo != null) {
                mediaInfo.videoRendererSupport = 4;
            }
        }
        return 0;
    }

    public void maybeAdvanceRebufferCount(boolean z_renamed) {
        if (z_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "maybeAdvanceRebufferCount");
            this.totalRebufferCount++;
            this.totalRebufferTimeMs += java.lang.System.currentTimeMillis() - this.rebufferingStartTimeMs;
        }
    }

    public void reset() {
        this.totalRebufferTimeMs = 0L;
        this.totalRebufferCount = 0L;
        this.rebuffering = false;
        this.totalNetworkReadBytes = 0L;
        this.alreadyPreCacheBytes = 0L;
        this.mReportBuilder = null;
        this.mMediaUrl = null;
        this.mMediaInfo = null;
        this.startTimeMs = 0L;
        this.firstRenderTime = 0L;
        this.hasRenderFirstFrame = false;
        this.isStarted = false;
        this.lastTimeStamp = 0L;
        this.lastTotalRxBytes = 0L;
        this.lastSeenTrackGroupArray = null;
        this.audioRendererHasFailed = false;
        this.videoRendererHasFailed = false;
        this.errorRendererInfo = com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE;
    }

    public boolean checkState() {
        return this.isStarted;
    }

    public com.oplus.tblplayer.misc.MediaInfo getMediaInfo() {
        return this.mMediaInfo;
    }

    public long getNetSpeed(int i_renamed) {
        if (!checkState()) {
            return 0L;
        }
        long totalRxBytes = com.oplus.tblplayer.utils.NetSpeedUtil.getTotalRxBytes(i_renamed);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j_renamed = jCurrentTimeMillis - this.lastTimeStamp;
        if (j_renamed <= 0) {
            return 0L;
        }
        long j2 = ((totalRxBytes - this.lastTotalRxBytes) * 1000) / j_renamed;
        this.lastTimeStamp = jCurrentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        return j2;
    }

    public void formatMediaInfo(int i_renamed, com.google.android.exoplayer2.Format format) {
        com.oplus.tblplayer.misc.MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null) {
            if (i_renamed == 1) {
                mediaInfo.audioSampleRate = format.sampleRate;
                this.mMediaInfo.audioMimeType = format.sampleMimeType;
            } else if (i_renamed == 2) {
                mediaInfo.width = format.width;
                this.mMediaInfo.height = format.height;
                this.mMediaInfo.videoMimeType = format.sampleMimeType;
                this.mMediaInfo.videoFps = format.frameRate;
            }
        }
    }

    public static float getFrameLossRate(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return 0.0f;
        }
        try {
            decoderCounters.ensureUpdated();
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "VideoDecoderCounters: " + com.oplus.tblplayer.utils.LogUtil.getDecoderCountersString(decoderCounters));
            return ((long) decoderCounters.droppedBufferCount) / (decoderCounters.renderedOutputBufferCount + r1);
        } catch (java.lang.Exception unused) {
            return 0.0f;
        }
    }
}
